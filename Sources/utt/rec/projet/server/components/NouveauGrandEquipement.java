package utt.rec.projet.server.components;

import java.math.BigDecimal;

import org.cocktail.fwkcktlajaxwebext.serveur.component.CktlAjaxWindow;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.metier.admrec.EOGemateriel;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.process.ProcessNouveauMateriel;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;

import er.ajax.AjaxUpdateContainer;
import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class NouveauGrandEquipement extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5101441317759694945L;
	private boolean resetAjoutEquipementDialog;
	String onloadJS = null;
	private String cout;
	public EOPprec projet;
	Number id = 0;
	private String nomGrandEquipement;
	EOGemateriel existant = null;
	EOEditingContext ec = ERXEC.newEditingContext();

	public NouveauGrandEquipement(WOContext context) {
		super(context);
		NSLog.out.appendln("NouveauGrandEquipement");
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		PprecHelpers.insertStylesSheet(context, response);
	}

	/**
	 * @return the projet
	 */
	public EOPprec projet() {
		if (projet == null)
			projet = myProjet();
		return projet;
	}

	/**
	 * @param projet
	 *            the projet to set
	 */
	public void setProjet(EOPprec projet) {
		this.projet = projet;
	}

	public String nouveauEquipementUpdateContainerId() {
		// TODO
		return getComponentId() + "_" + this.getClass().getName();
	}

	/**
	 * @return the resetAjoutEquipementDialog
	 */
	public boolean isResetAjoutEquipementDialog() {
		return resetAjoutEquipementDialog;
	}

	/**
	 * @param resetAjoutEquipementDialog
	 *            the resetAjoutEquipementDialog to set
	 */
	public void setResetAjoutEquipementDialog(boolean resetAjoutEquipementDialog) {
		this.resetAjoutEquipementDialog = resetAjoutEquipementDialog;
	}

	/**
	 * @return the cout
	 */
	public String cout() {
		return cout;
	}

	/**
	 * @param cout
	 *            the cout to set
	 */
	public void setCout(String cout) {
		this.cout = cout;
	}

	/**
	 * @return the nomGrandEquipement
	 */
	public String nomGrandEquipement() {
		return nomGrandEquipement;
	}

	/**
	 * @param nomGrandEquipement
	 *            the nomGrandEquipement to set
	 */
	public void setNomGrandEquipement(String nomGrandEquipement) {
		this.nomGrandEquipement = nomGrandEquipement;
	}

	public WOActionResults annulerAjout() {
		CktlAjaxWindow.close(context());
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.MAssistant#valider()
	 */
	@Override
	public boolean valider() {
		// TODO Auto-generated method stub
		boolean validate = false;
		NSArray<String> failureMessages = new NSArray<String>();
		if (mySession().getSelectNewMatPole() == null
				&& mySession().getCategMatSelect0() == null)
			failureMessages = failureMessages
					.arrayByAddingObject("Le pôle et un plateau technique");
		if (nomGrandEquipement() == null)
			failureMessages = failureMessages
					.arrayByAddingObject("L'équipement à acquérir");
		if (!isNumeric(cout()))
			failureMessages = failureMessages
					.arrayByAddingObject("Le format numérique pour le coût");
		if (failureMessages.count() == 0) {
			validate = true;
			setFailureMessage(null);
		} else {
			setFailureMessage("Veuillez renseigner "
					+ failureMessages.componentsJoinedByString(", ") + ".");
		}
		if (validate)
			mySession().getUiMessages().removeAllObjects();
		return validate;
	}

	public WOActionResults ajouterEquipement() {
		try {
			EOGemateriel demo = null;
			if (valider()) {
				setCout(cout().replace(",", "."));
				// Mode update
				if (projet() != null) {
					test();
					mySession().setNouveauEquipement(existant);
				}
				// Mode new materiel
				if (mySession().getNouveauEquipement() == null) {
					demo = EOGemateriel.createEOGemateriel(ec);
					demo.setGematLib(nomGrandEquipement().toUpperCase());
					demo.setToPfmateriel(mySession().getCategMatSelect0());
					demo.setGematBrute(0);
					demo.setCoutEstime(BigDecimal.valueOf(Double
							.valueOf(cout())));
					ProcessNouveauMateriel.enregistrer(mySession().dataBus(),
							ec, demo);
					id = demo.getGematIdProc();
					mySession().setNouveauEquipement(
							EOGemateriel.fetchRenvoieLastGE(ec,
									(Integer) demo.getGematIdProc())
									.lastObject());
				}
			}
		} catch (Exception e) {
			mySession().addSimpleErrorMessage(
					"Estimation des ressources matériels à acquérir",
					e.getLocalizedMessage());
			e.printStackTrace();
		}
		if (!id.equals(0)) {
			CktlAjaxWindow.close(context());
		}
		context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(myApp().messageContainerID(),
				context());
		return null;
	}

	// MAJ liste des plateaux techniques en fonction du pôle sélectionné
	// (materiel à acquérir)
	public WOActionResults refreshPF0() {
		// TODO Auto-generated method stub
		if (mySession().getSelectNewMatPole() != null) {
			NSArray<EOPfmateriel> plateaux = EOPfmateriel.nouveauxMateriels(ec, mySession()
					.getSelectNewMatPole().cStructure());
			mySession().setListCategMteriels0(plateaux);
		}
		return doNothing();
	}

	public WOActionResults refreshGE0() {
		// TODO Auto-generated method stub
		if (mySession().getCategMatSelect0() != null)
			mySession().setListLibNewMat(
					EOGemateriel.fetchLeNgeDuPT(ec, mySession()
							.getCategMatSelect0().primaryKey()));
		return doNothing();
	}

	protected static boolean isNumeric(String str) {
		try {
			if (str == null)
				return false;
			str = str.replace(",", ".");
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	protected void test() {
		existant = EOGemateriel.fetchExistant(ec,
				nomGrandEquipement().toUpperCase(),
				mySession().getCategMatSelect0()).lastObject();
	}
}