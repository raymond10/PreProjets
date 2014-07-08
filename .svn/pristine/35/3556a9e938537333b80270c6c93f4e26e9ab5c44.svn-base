package utt.rec.projet.server.components;

import java.text.Format;

import org.cocktail.fwkcktlpersonne.common.exception.FactoryException;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.components.controler.UpdateProjectCtrl;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EORefthe;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.admrec.EOTypthe;
import utt.rec.projet.server.metier.admrec.EOVrhcmval;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EORepartStructure;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOGeneralAdaptorException;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestampFormatter;

import er.ajax.CktlAjaxUtils;
import er.extensions.appserver.ERXDisplayGroup;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class UpdateProject extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5719005139758437586L;
	private static String OTHER_CONTAINER = "selectedOtherID";
	private static String PARTENAIRE_CONTAINER = "partenaireId";
	// Calendrier Ajax
	public Format formatter = new NSTimestampFormatter("%d/%m/%Y");
	public NSArray<String> frenchMonths = new NSArray<String>(new String[] {
			"janvier", "février", "mars", "avril", "mai", "juin", "juillet",
			"août", "septembre", "octobre", "novembre", "décembre" });

	public NSArray<String> frenchDays = new NSArray<String>(new String[] {
			"dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi",
			"samedi" });
	// Fin Calendrier Ajax
	private NSMutableArray<EOStructureUlr> equipeOther;
	private NSMutableArray<EOTyppartenaire> newPartListe;
	private EOTyppartenaire nouvoPart;
	private String partAdd;
	private boolean hasYesChecked;
	private UpdateProjectCtrl ctrl;
	private resumeProjet resumer;
	private boolean resetAjoutPartenaireDialog;
	private EOEditingContext editingContextForPartner;

	public UpdateProject(WOContext context) {
		super(context);
		NSLog.out.appendln("UpdateProject");
		setResumer(new resumeProjet(context));
		resumer().setContexteTabSelected(true);
		// Initialisation du projet
		ctrl().setProjet(mySession().getProjectSelected());
		// intinialisation du porteur du projet
		mySession().setPorteurList(EOVrhcmval.fetchAllEOVrhcmvals(edc()));
		// intinialisation de l'equipe principale du projet
		mySession().setEquipeList(EOStructureUlr.fetchEquipes(edc()));
		// Initialisation des contrats du projet
		mySession().setContratList(EOTypcontrat.fetchContrats(edc()));
		// Initialisation du partenaire du projet;
		mySession().setPartenaireList(EOTyppartenaire.fetchAllEOTyppartenaires(edc(), new NSArray(EOTyppartenaire.DENOM_USUELLE.asc())));
		// Initialisation des axes du projet;
		mySession().setAxeList(EOAxerec.fetchAllEOAxerecs(edc()));
		// Initialisation des thematiques du projet;
		mySession().setThematikList(EOTypthe.fetchThemqatiqueList(edc()));
		// Initialisation des Themes du projet;
		mySession().setThemeList(EORefthe.fetchThemeList(edc()));
		// Initialisation des sous-themes du projet;
		mySession().setSouThemeList(EORefthe.fetchSousThemeList(edc()));
		// Iinitialisation des mots clefs
		ctrl().refdix();
		if (mySession().retourMaj == false) {
			ctrl().PageOne();
		}
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
        PprecHelpers.insertStylesSheet(context, response);
		String message = mySession().getAlertMessage();
		if (message != null && message.equals("") == false) {
			String str = "<script language=\"javascript\" type=\"text/javascript\">\n";
			str += "alert(\"" + message + "\");\n";
			str += "</script>";
			response.appendContentString(str);
			mySession().setAlertMessage(null);
		}
		if (onloadJS() != null)
			setOnloadJS(null);
	}

	@Override
	public void takeValuesFromRequest(WORequest aRequest, WOContext aContext) {
		super.takeValuesFromRequest(aRequest, aContext);
	}

	public String partenaireDialogId() {
		return "partenaire_" + uniqueDomId();
	}

	/**
	 * @return the ctrl
	 */
	public UpdateProjectCtrl ctrl() {
		if(ctrl == null)
			ctrl = new UpdateProjectCtrl(this);
		return ctrl;
	}

	/**
	 * @param ctrl
	 *            the ctrl to set
	 */
	public void setCtrl(UpdateProjectCtrl ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * @return the nouvoPart
	 */
	public EOTyppartenaire getNouvoPart() {
		return nouvoPart;
	}

	/**
	 * @param nouvoPart
	 *            the nouvoPart to set
	 */
	public void setNouvoPart(EOTyppartenaire nouvoPart) {
		this.nouvoPart = nouvoPart;
	}

	/**
	 * @return the partAdd
	 */
	public String getPartAdd() {
		return partAdd;
	}

	/**
	 * @param partAdd
	 *            the partAdd to set
	 */
	public void setPartAdd(String partAdd) {
		this.partAdd = partAdd;
	}

	/**
	 * @return the hasYesChecked
	 */
	public boolean isHasYesChecked() {
		return hasYesChecked;
	}

	/**
	 * @param hasYesChecked
	 *            the hasYesChecked to set
	 */
	public void setHasYesChecked(boolean hasYesChecked) {
		this.hasYesChecked = hasYesChecked;
	}

	// BEGIN METHODS

	/**
	 * @return the equipeOther
	 */
	public NSMutableArray<EOStructureUlr> equipeOther() {
		if(equipeOther == null)
			equipeOther = new NSMutableArray<EOStructureUlr>();
		return equipeOther;
	}

	/**
	 * @param equipeOther the equipeOther to set
	 */
	public void setEquipeOther(NSMutableArray<EOStructureUlr> equipeOther) {
		this.equipeOther = equipeOther;
	}

	/**
	 * @return the newPartListe
	 */
	public NSMutableArray<EOTyppartenaire> newPartListe() {
		if(newPartListe == null)
			newPartListe = new NSMutableArray<EOTyppartenaire>();
		return newPartListe;
	}

	/**
	 * @param newPartListe the newPartListe to set
	 */
	public void setNewPartListe(NSMutableArray<EOTyppartenaire> newPartListe) {
		this.newPartListe = newPartListe;
	}

	/**
	 * @return the resumer
	 */
	public resumeProjet resumer() {
		return resumer;
	}

	/**
	 * @param resumer
	 *            the resumer to set
	 */
	public void setResumer(resumeProjet resumer) {
		this.resumer = resumer;
	}

	// UpdateContainer
	public String selectedOtherId() {
		return OTHER_CONTAINER;
	}

	public String partenaireId() {
		return PARTENAIRE_CONTAINER;
	}

	/**
	 * @return the resetAjoutPartenaireDialog
	 */
	public boolean isResetAjoutPartenaireDialog() {
		return resetAjoutPartenaireDialog;
	}

	/**
	 * @param resetAjoutPartenaireDialog
	 *            the resetAjoutPartenaireDialog to set
	 */
	public void setResetAjoutPartenaireDialog(boolean resetAjoutPartenaireDialog) {
		this.resetAjoutPartenaireDialog = resetAjoutPartenaireDialog;
	}

	/**
	 * @return the editingContextForPartner
	 */
	public EOEditingContext getEditingContextForPartner() {
		if (editingContextForPartner == null) {
			editingContextForPartner = edc();
		}
		return editingContextForPartner;
	}

	/**
	 * @param editingContextForPartner
	 *            the editingContextForPartner to set
	 */
	public void setEditingContextForPartner(
			EOEditingContext editingContextForPartner) {
		this.editingContextForPartner = editingContextForPartner;
	}

	public void newPartnaire() {
		EOTyppartenaire partenaire = new EOTyppartenaire();
		partenaire = EOTyppartenaire.createEOTyppartenaire(edc());
		if (partAdd == null) {
			throw new FactoryException(
					"Le libelle du partenaire est obligatoire");
		}
		partenaire.setNomPartenaire(partAdd);
		partenaire.setPartCleunik("N/A");
		partenaire.validateForSave();
		try {
			edc().saveChanges();
			mySession().setPartenaireList(EOTyppartenaire
					.fetchAllEOTyppartenaires(edc()));
		} catch (EOGeneralAdaptorException e) {
			// TODO: handle exception
			e.printStackTrace();
			edc().invalidateAllObjects();
		}
		partAdd = null;
	}

	public WOActionResults openAjouterPartenaire() {
		setResetAjoutPartenaireDialog(true);
		NouveauPartenaire page = (NouveauPartenaire) pageWithName(NouveauPartenaire.class
				.getName());
		page.setEditingContext(getEditingContextForPartner());
		page.setResetAjoutPartenaireDialog(true);
		return page;
	}

	public void refreshPartenaire() {
		mySession().setPartenaireList(EOTyppartenaire.fetchAllEOTyppartenaires(edc(),
				new NSArray(EOTyppartenaire.DENOM_USUELLE.asc())));
	}
	// END METHODS
}