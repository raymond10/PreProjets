package utt.rec.projet.server.components;

import org.cocktail.fwkcktlajaxwebext.serveur.component.CktlAjaxWindow;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.process.ProcessPlateau;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;

import er.ajax.AjaxUpdateContainer;
import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
public class NouveauPlateau extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3455016079169126392L;
	private boolean resetAjoutPlateauDialog;
	private String idGlobal;
	private String nomPlateau;
	private String nomAbrPlateau;
	public EOPprec projet;
	EOEditingContext ec = ERXEC.newEditingContext();

	public NouveauPlateau(WOContext context) {
		super(context);
		NSLog.out.appendln("NouveauPlateau");
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

	/**
	 * @return the resetAjoutPlateauDialog
	 */
	public boolean isResetAjoutPlateauDialog() {
		return resetAjoutPlateauDialog;
	}

	/**
	 * @param resetAjoutPlateauDialog
	 *            the resetAjoutPlateauDialog to set
	 */
	public void setResetAjoutPlateauDialog(boolean resetAjoutPlateauDialog) {
		this.resetAjoutPlateauDialog = resetAjoutPlateauDialog;
	}

	/**
	 * @return the idGlobal
	 */
	public String idGlobal() {
		return idGlobal;
	}

	/**
	 * @param idGlobal
	 *            the idGlobal to set
	 */
	public void setIdGlobal(String idGlobal) {
		this.idGlobal = idGlobal;
	}

	public String nouveauPlateaufUpdateContainerId() {
		// TODO
		return getComponentId() + "_" + this.getClass().getName();
	}

	/**
	 * @return the nomPlateau
	 */
	public String nomPlateau() {
		return nomPlateau;
	}

	/**
	 * @param nomPlateau
	 *            the nomPlateau to set
	 */
	public void setNomPlateau(String nomPlateau) {
		this.nomPlateau = nomPlateau;
	}

	/**
	 * @return the nomAbrPlateau
	 */
	public String nomAbrPlateau() {
		return nomAbrPlateau;
	}

	/**
	 * @param nomAbrPlateau
	 *            the nomAbrPlateau to set
	 */
	public void setNomAbrPlateau(String nomAbrPlateau) {
		this.nomAbrPlateau = nomAbrPlateau;
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
		if (mySession().getSelectNewMatPole() == null)
			failureMessages = failureMessages.arrayByAddingObject("Le pôle");
		if (nomAbrPlateau() == null)
			failureMessages = failureMessages
					.arrayByAddingObject("L'abréviation de votre plateau");
		if (nomPlateau() == null)
			failureMessages = failureMessages
					.arrayByAddingObject("Le nom de votre plateau");
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

	public WOActionResults ajouterPlat() {
		try {
			EOPfmateriel newMatos = null;
			if (valider()) {
				newMatos = EOPfmateriel.createEOPfmateriel(ec);
				newMatos.setPfmatId(nomAbrPlateau().toUpperCase());
				newMatos.setPfmatLib(nomPlateau().toUpperCase());
				newMatos.setMajAuteur(projet().creAuteur());
				newMatos.setToStructure(mySession().getSelectNewMatPole());
				ProcessPlateau.enregistrer(mySession().dataBus(), ec,
						newMatos);
				setIdGlobal(nomAbrPlateau());
				mySession().setLastPlateau(
						EOPfmateriel.plateauPourNumero(edc(), idGlobal()));
				mySession().addSimpleInfoMessage(
						mySession().localizer().localizedStringForKey(
								"confirmation"), null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			mySession().addSimpleErrorMessage(
					"Création nouveau plateau technique",
					e.getLocalizedMessage());
			e.printStackTrace();
		}
		if (idGlobal() != null) {
			CktlAjaxWindow.close(context());
		}
		context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(myApp().messageContainerID(),
				context());
		return doNothing();
	}
}