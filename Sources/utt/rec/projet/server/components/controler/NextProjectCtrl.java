/**
 * 
 */
package utt.rec.projet.server.components.controler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;

import utt.rec.projet.server.PPrecApplicationUser;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.Commentaire;
import utt.rec.projet.server.components.NextProject;
import utt.rec.projet.server.components.NouveauGrandEquipement;
import utt.rec.projet.server.components.NouveauPlateau;
import utt.rec.projet.server.components.Projects;
import utt.rec.projet.server.components.SoumiProject;
import utt.rec.projet.server.components.procedures.ProcedureCreerAlerte;
import utt.rec.projet.server.components.procedures.ProcedureDelError;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.factory.FactoryTabDataArray;
import utt.rec.projet.server.factory.FactoryTraitemantEquipes;
import utt.rec.projet.server.factory.FactoryTraitementHistorique;
import utt.rec.projet.server.factory.FactoryTraitementMateriels;
import utt.rec.projet.server.factory.FactoryTraitementMotClefs;
import utt.rec.projet.server.factory.FactoryTraitementPartenaires;
import utt.rec.projet.server.factory.FactoryTraitementPersonnel;
import utt.rec.projet.server.factory.FactoryTraitementPosteRh;
import utt.rec.projet.server.factory.FactoryTraitementProjet;
import utt.rec.projet.server.factory.FactoryTraitementRepartPst;
import utt.rec.projet.server.metier.admrec.EOAlerte;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOGemateriel;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOTypref;
import utt.rec.projet.server.metier.admrec.EOVrhcmval;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessAlerte;
import utt.rec.projet.server.process.ProcessProjet;
import utt.rec.projet.server.utils.manufactory.ManufactoryMateriels;
import utt.rec.projet.server.utils.manufactory.ManufactoryPersonnelRhs;
import utt.rec.projet.server.utils.manufactory.ManufactoryRecrue;

import com.ibm.icu.math.MathContext;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOGeneralAdaptorException;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSValidation.ValidationException;

import er.ajax.AjaxUpdateContainer;
import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.appserver.ERXRedirect;
import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class NextProjectCtrl extends ModuleCtrl<NextProject> {

	private EOEditingContext edc;
	private Session sess;
	private EOPprec projet = null;
	private EOPosterh poste;
	private EOPersonnel personnel;
	private EOResmat materiel;
	private Number idPArt;
	private FactoryTabDataArray tabDataArray;
	private Boolean isSauvegarderUnProjetDisabled = null;
	private Boolean isTerminerUnProjetDisabled = null;
	private FactoryTraitemantEquipes trtEquipes;
	private FactoryTraitementPersonnel trtPersonnel;
	private FactoryTraitementPosteRh trtPoste;
	private FactoryTraitementMateriels trtMateriel;
	private FactoryTraitementProjet trtProjet;
	private FactoryTraitementHistorique trtHtq;
	private FactoryTraitementPartenaires trtPartenaire;
	private FactoryTraitementMotClefs trtMotClefs;
	private FactoryTraitementRepartPst trtRepartAxe;
	private boolean success;
	private boolean resetAjoutPlateauDialog;
	private boolean resetAjoutEquipementDialog;
	private boolean resetOpenCommentDialog;
	private EOEditingContext editingContextForPlateau;
	EOPprec lProjet;
	// les transations
	CktlDataBus prjTrans = null;
	CktlDataBus prtTrans = null;
	CktlDataBus ekpTrans = null;
	CktlDataBus stmrTrans = null;
	CktlDataBus mcTrans = null;
	CktlDataBus persTrans = null;
	CktlDataBus postTrans = null;
	CktlDataBus matrans = null;
	CktlDataBus newMatTrans = null;
	CktlDataBus mailTrans = null;

	/**
	 * @param component
	 */
	public NextProjectCtrl(NextProject component) {
		super(component);
		// TODO Auto-generated constructor stub
		success = false;
	}

	/**
	 * @return the edc
	 */
	public EOEditingContext edc() {
		if (edc == null)
			edc = wocomponent().edcProjet();
		return edc;
	}

	/**
	 * @param edc
	 *            the edc to set
	 */
	public void setEdc(EOEditingContext edc) {
		this.edc = edc;
	}

	/**
	 * @return the sess
	 */
	public Session sess() {
		if (sess == null)
			sess = wocomponent().mySession();
		return sess;
	}

	/**
	 * @param sess
	 *            the sess to set
	 */
	public void setSess(Session sess) {
		this.sess = sess;
	}

	/**
	 * @return the projet
	 */
	public EOPprec projet() {
		if (projet == null)
			projet = wocomponent().myProjet();
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
	 * @return the tabDataArray
	 */
	public FactoryTabDataArray tabDataArray() {
		if (tabDataArray == null)
			tabDataArray = new FactoryTabDataArray(wocomponent(), sess(),
					wocomponent().persRh(), wocomponent().poleRh(),
					wocomponent().posteRh(), wocomponent().mata(),
					wocomponent().mato());
		return tabDataArray;
	}

	/**
	 * @param tabDataArray
	 *            the tabDataArray to set
	 */
	public void setTabDataArray(FactoryTabDataArray tabDataArray) {
		this.tabDataArray = tabDataArray;
	}

	/**
	 * @return the poste
	 */
	public EOPosterh getPoste() {
		return poste;
	}

	/**
	 * @param poste
	 *            the poste to set
	 */
	public void setPoste(EOPosterh poste) {
		this.poste = poste;
	}

	/**
	 * @return the personnel
	 */
	public EOPersonnel getPersonnel() {
		return personnel;
	}

	/**
	 * @param personnel
	 *            the personnel to set
	 */
	public void setPersonnel(EOPersonnel personnel) {
		this.personnel = personnel;
	}

	/**
	 * @return the materiel
	 */
	public EOResmat getMateriel() {
		return materiel;
	}

	/**
	 * @param materiel
	 *            the materiel to set
	 */
	public void setMateriel(EOResmat materiel) {
		this.materiel = materiel;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the idPArt
	 */
	public Number getIdPArt() {
		return idPArt;
	}

	/**
	 * @param idPArt
	 *            the idPArt to set
	 */
	public void setIdPArt(Number idPArt) {
		this.idPArt = idPArt;
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
	 * @return the resetOpenCommentDialog
	 */
	public boolean isResetOpenCommentDialog() {
		return resetOpenCommentDialog;
	}

	/**
	 * @param resetOpenCommentDialog
	 *            the resetOpenCommentDialog to set
	 */
	public void setResetOpenCommentDialog(boolean resetOpenCommentDialog) {
		this.resetOpenCommentDialog = resetOpenCommentDialog;
	}

	/**
	 * @return the editingContextForPlateau
	 */
	public EOEditingContext getEditingContextForPlateau() {
		return editingContextForPlateau;
	}

	/**
	 * @param editingContextForPlateau
	 *            the editingContextForPlateau to set
	 */
	public void setEditingContextForPlateau(
			EOEditingContext editingContextForPlateau) {
		this.editingContextForPlateau = editingContextForPlateau;
	}

	/* Data Base save Methods */
	public WOActionResults backProject() {
		Projects backPage = (Projects) wocomponent().pageWithName(
				Projects.class.getName());
		/*
		 * backPage.isEnregistrerUnProjetDisabled = false; String vide =
		 * "<p><br data-mce-bogus=\"1\"></p>"; String ctx =
		 * wocomponent().getContexte(); String pb =
		 * wocomponent().getProblematique(); String obj =
		 * wocomponent().getObjectif(); String mth =
		 * wocomponent().getMethodologie(); if (ctx != null && !ctx.equals("")
		 * && !ctx.equals(vide)) sess().setContexte(ctx); if (pb != null &&
		 * !pb.equals("") && !pb.equals(vide)) sess().setProblematik(pb); if
		 * (obj != null && !obj.equals("") && !obj.equals(vide))
		 * sess().setObjectifs(obj); if (mth != null && !mth.equals("") &&
		 * !mth.equals(vide)) sess().setMetho(mth);
		 */
		ERXRedirect redirect = (ERXRedirect) wocomponent().pageWithName(
				ERXRedirect.class.getName());
		redirect.setComponent(backPage);
		return redirect;
	}

	public WOActionResults fermer() {
		EOPprec projet = projet();
		EOEditingContext ec = null;
		if(projet != null)
			ec = projet.editingContext();
		if (ec != null && ec.hasChanges()) {
			/*
			 * Boolean answer = getUserQuestionDelegate() .askUserAsBoolean(
			 * "confirm",
			 * "Des changements n'ont pas �t� enregistr�s, voulez-vous vraiment fermer le projet?"
			 * , "ContainerPrincipal"); if (answer == null) return null; if
			 * (answer) { getUserQuestionDelegate().clearAnswers(); return
			 * annuler(); } else { getUserQuestionDelegate().clearAnswers();
			 * return annuler(); }
			 */
			sess().addSimpleErrorMessage(
					"Fermerture impossible",
					"Des changements n'ont pas �t� enregistr�s, voulez-vous vraiment fermer le projet ?\n Cliquer sur tout annuler");
			return null;
		} else {
			sess().myEnv().setObjectForKey(true, "Refresh");
			return annuler();
		}
	}

	public WOActionResults annuler() {
		ERXRedirect redirect = (ERXRedirect) wocomponent().pageWithName(
				ERXRedirect.class.getName());
		redirect.setComponent(wocomponent().home());
		return redirect;
	}

	/* Debut traitement de l'insertion dans la BDD */

	public WOActionResults enregistrer() {
		WORequest request = wocomponent().context().request();
		ERXRedirect redirect = null;
		String action = (String) request.formValueForKey("save");
		if (action == null && stateProject()) {
			EtatNouvoProjet();
		}
		save();
		if (success) {
			SoumiProject home = (SoumiProject) wocomponent().pageWithName(
					SoumiProject.class.getName());
			home.setNumero(wocomponent().idProj());
			NextProject same = (NextProject) wocomponent().pageWithName(
					NextProject.class.getName());
			same.setOnloadJS("openListeSelectionWin(null,'"
					+ wocomponent().context().directActionURLForActionNamed(
							"pageProjetSoumis", null)
					+ "',\'Fin de sauvegarde Projet\',\'PageSoumiseDetaillee\',\'Contenu\',true);");
			redirect = (ERXRedirect) wocomponent().pageWithName(
					ERXRedirect.class.getName());
			redirect.setComponent(home);
		} else {
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			NextProject same = (NextProject) wocomponent().pageWithName(
					NextProject.class.getName());
			same.ctrl().isSauvegarderUnProjetDisabled();
			same.ctrl().isTerminerUnProjetDisabled();
			redirect = (ERXRedirect) wocomponent().pageWithName(
					ERXRedirect.class.getName());
			redirect.setComponent(same);
		}
		return redirect;
	}

	/* End Data Base save Methods */

	// Initialisation des factory

	/**
	 * @return the trtEquipes
	 */
	public FactoryTraitemantEquipes trtEquipes() {
		if (trtEquipes == null)
			trtEquipes = new FactoryTraitemantEquipes();
		return trtEquipes;
	}

	/**
	 * @param trtEquipes
	 *            the trtEquipes to set
	 */
	public void setTrtEquipes(FactoryTraitemantEquipes trtEquipes) {
		this.trtEquipes = trtEquipes;
	}

	/**
	 * @return the trtPersonnel
	 */
	public FactoryTraitementPersonnel trtPersonnel() {
		if (trtPersonnel == null)
			trtPersonnel = new FactoryTraitementPersonnel();
		return trtPersonnel;
	}

	/**
	 * @param trtPersonnel
	 *            the trtPersonnel to set
	 */
	public void setTrtPersonnel(FactoryTraitementPersonnel trtPersonnel) {
		this.trtPersonnel = trtPersonnel;
	}

	/**
	 * @return the trtPoste
	 */
	public FactoryTraitementPosteRh trtPoste() {
		if (trtPoste == null)
			trtPoste = new FactoryTraitementPosteRh();
		return trtPoste;
	}

	/**
	 * @param trtPoste
	 *            the trtPoste to set
	 */
	public void setTrtPoste(FactoryTraitementPosteRh trtPoste) {
		this.trtPoste = trtPoste;
	}

	/**
	 * @return the trtMateriel
	 */
	public FactoryTraitementMateriels trtMateriel() {
		if (trtMateriel == null)
			trtMateriel = new FactoryTraitementMateriels();
		return trtMateriel;
	}

	/**
	 * @param trstMateriel
	 *            the trstMateriel to set
	 */
	public void setTrtMateriel(FactoryTraitementMateriels trtMateriel) {
		this.trtMateriel = trtMateriel;
	}

	/**
	 * @return the trtProjet
	 */
	public FactoryTraitementProjet trtProjet() {
		if (trtProjet == null)
			trtProjet = new FactoryTraitementProjet();
		return trtProjet;
	}

	/**
	 * @param trtProjet
	 *            the trtProjet to set
	 */
	public void setTrtProjet(FactoryTraitementProjet trtProjet) {
		this.trtProjet = trtProjet;
	}

	/**
	 * @return the trtHtq
	 */
	public FactoryTraitementHistorique trtHtq() {
		if (trtHtq == null)
			trtHtq = new FactoryTraitementHistorique();
		return trtHtq;
	}

	/**
	 * @param trtHtq
	 *            the trtHtq to set
	 */
	public void setTrtHtq(FactoryTraitementHistorique trtHtq) {
		this.trtHtq = trtHtq;
	}

	/**
	 * @return the trtPartenaire
	 */
	public FactoryTraitementPartenaires trtPartenaire() {
		if (trtPartenaire == null)
			trtPartenaire = new FactoryTraitementPartenaires();
		return trtPartenaire;
	}

	/**
	 * @param trtPartenaire
	 *            the trtPartenaire to set
	 */
	public void setTrtPartenaire(FactoryTraitementPartenaires trtPartenaire) {
		this.trtPartenaire = trtPartenaire;
	}

	/**
	 * @return the trtMotClefs
	 */
	public FactoryTraitementMotClefs trtMotClefs() {
		if (trtMotClefs == null)
			trtMotClefs = new FactoryTraitementMotClefs();
		return trtMotClefs;
	}

	/**
	 * @param trtMotClefs
	 *            the trtMotClefs to set
	 */
	public void setTrtMotClefs(FactoryTraitementMotClefs trtMotClefs) {
		this.trtMotClefs = trtMotClefs;
	}

	// Fin init factory

	/**
	 * @return the trtRepartAxe
	 */
	public FactoryTraitementRepartPst trtRepartAxe() {
		if (trtRepartAxe == null)
			trtRepartAxe = new FactoryTraitementRepartPst();
		return trtRepartAxe;
	}

	/**
	 * @param trtRepartAxe
	 *            the trtRepartAxe to set
	 */
	/**
	 * @param trtRepartAxe
	 */
	public void setTrtRepartAxe(FactoryTraitementRepartPst trtRepartAxe) {
		this.trtRepartAxe = trtRepartAxe;
	}

	public void EtatNouvoProjet() {
		for (int i = 0; i < sess().getListEtat1().count(); i++) {
			if (sess().getListEtat1().objectAtIndex(i).typrefnat()
					.equals(EOTypref.VAR_ETAT_SOUMETTRE)) {
				sess().setEtatRepetition1(
						sess().getListEtat1().objectAtIndex(i));
			}
		}
	}

	// Supression d'une personne s�lectionnee dans le tableau dynamique RH
	public WOActionResults removePersonne() {
		try {
			sess().setPersonneDg(null);
			sess().selectedrhs().removeObject(sess().getPersonRhRep());
			if (!sess().removedrhs().contains(sess().getPersonRhRep()))
				sess().removedrhs().addObject(sess().getPersonRhRep());
		} catch (Exception e) {
			// TODO: handle exception
			sess().addSimpleErrorMessage("Supression personnel",
					e.getLocalizedMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
		}
		return null;
	}

	// Supression d'un poste s�lectionn� dans le tableau dynamique Recrutement
	public WOActionResults removePoste() {
		try {
			sess().setPostesDg(null);
			sess().selectedRecrue().removeObject(
					sess().getPoleRecruRepetition());
			if (!sess().removedRecrue().contains(
					sess().getPoleRecruRepetition()))
				sess().removedRecrue().addObject(
						sess().getPoleRecruRepetition());
		} catch (Exception e) {
			// TODO: handle exception
			sess().addSimpleErrorMessage("Supression poste",
					e.getLocalizedMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
		}
		return null;
	}

	// Supression d'un poste s�lectionn� dans le tableau dynamique Recrutement
	public WOActionResults removeMatExt() {
		try {
			sess().setPoleMaterielsDg(null);
			sess().selectedMaterielExistant().removeObject(
					sess().getMaterielRep());
			if (!sess().removedMaterielExistant().contains(
					sess().getMaterielRep()))
				sess().removedMaterielExistant().addObject(
						sess().getMaterielRep());
		} catch (Exception e) {
			// TODO: handle exception
			sess().addSimpleErrorMessage("Supression mat�riel existant",
					e.getLocalizedMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
		}
		return null;
	}

	// Supression d'un poste s�lectionn� dans le tableau dynamique Recrutement
	public WOActionResults removeNewMat() {
		try {
			sess().setMaterielsDg(null);
			sess().selectedMaterielAcquis().removeObject(
					sess().getPoleNewMatRep());
			if (!sess().removedMaterielAcquis().contains(
					sess().getPoleNewMatRep()))
				sess().removedMaterielAcquis().addObject(
						sess().getPoleNewMatRep());
		} catch (Exception e) {
			// TODO: handle exception
			sess().addSimpleErrorMessage("Supression nouveau mat�riel",
					e.getLocalizedMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
		}
		return null;
	}

	public boolean stateProject() {
		boolean state = false;
		state = (sess().selectedrhs().count() != 0 || sess().selectedRecrue()
				.count() != 0)
		/*
		 * && (sess().selectedMaterielExistant().count() != 0 || sess()
		 * .selectedMaterielAcquis().count() != 0)
		 */;
		return state;
	}

	// Rafraichissement de la liste des Personnes attach�es � un p�le
	public WOActionResults refreshPerson() {
		NSMutableArray<EOVrhcmval> tinyIndiv = new NSMutableArray<EOVrhcmval>();
		if (sess().getSelectRhPole() != null) {
			tinyIndiv.setArray(EOVrhcmval.fetchLesChercheurs(edc(), sess()
					.getSelectRhPole().primaryKey()));
			sess().listInPerson().setObjectArray(tinyIndiv.mutableClone());
		}
		return null;
	}

	public WOActionResults updatePers() {
		ajoutPerson();
		isTerminerUnProjetDisabled = null;
		isSauvegarderUnProjetDisabled = null;
		// isSauvegarderUnProjetDisabled();
		// isTerminerUnProjetDisabled();
		wocomponent().context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
				.messageContainerID(), wocomponent().context());
		return null;
	}

	public WOActionResults updatePost() {
		ajoutPoste();
		isTerminerUnProjetDisabled = null;
		isSauvegarderUnProjetDisabled = null;
		// isSauvegarderUnProjetDisabled();
		// isTerminerUnProjetDisabled();
		wocomponent().context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
				.messageContainerID(), wocomponent().context());
		return null;
	}

	public WOActionResults updateMat() {
		ajoutMatos();
		isTerminerUnProjetDisabled = null;
		isSauvegarderUnProjetDisabled = null;
		// isSauvegarderUnProjetDisabled();
		// isTerminerUnProjetDisabled();
		wocomponent().context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
				.messageContainerID(), wocomponent().context());
		return null;
	}

	public WOActionResults updateNewMat() {
		ERXRedirect redirect = null;
		// tabDataArray().saveNouveauMateriel();
		ajouNouvoMatos();
		isTerminerUnProjetDisabled = null;
		isSauvegarderUnProjetDisabled = null;
		// isSauvegarderUnProjetDisabled();
		// isTerminerUnProjetDisabled();
		wocomponent().context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
				.messageContainerID(), wocomponent().context());
		return null;
	}

	public boolean peutCreer() {
		if (wocomponent().myApp().newGestionDroitsEnabled()) {
			return wocomponent().myAppGDUser().getPprecAutorisationCache()
					.gDPprecCreationProjet()
					|| wocomponent().myAppGDUser().getPprecAutorisationCache()
							.gDPprecSuperUserProjet();
		}
		return wocomponent().myAppJAUser().hasDroitCreationProjet()
				|| wocomponent().myAppJAUser().hasDroitSuperUserProjet();
	}

	public String auteur() {
		if (wocomponent().myApp().newGestionDroitsEnabled()) {
			return wocomponent().myAppGDUser().getPersId().toString();
		}
		return wocomponent().myAppJAUser().getPersId().toString();
	}

	public WOActionResults openAjouterPlateau() {
		setResetAjoutPlateauDialog(true);
		NouveauPlateau page = (NouveauPlateau) wocomponent().pageWithName(
				NouveauPlateau.class.getName());
		page.setResetAjoutPlateauDialog(true);
		return page;
	}

	public WOActionResults openAjouterEquipement() {
		setResetAjoutEquipementDialog(true);
		NouveauGrandEquipement page = (NouveauGrandEquipement) wocomponent()
				.pageWithName(NouveauGrandEquipement.class.getName());
		page.setResetAjoutEquipementDialog(true);
		return page;
	}

	public WOActionResults openCommentaire() {
		resetOpenCommentDialog = true;
		Commentaire page = (Commentaire) wocomponent().pageWithName(
				Commentaire.class.getName());
		page.setResetOpenCommentDialog(true);
		return page;
	}

	public void refreshPlateau() {
		if (sess().getSelectNewMatPole() != null)
			sess().setListCategMteriels0(
					EOPfmateriel.fetchLePFduPole(edc(), sess()
							.getSelectNewMatPole().primaryKey()));
		if (sess().getLastPlateau() != null)
			sess().setCategMatSelect0(sess().getLastPlateau());
	}

	public void refreshEquipement() {
		if (sess().getCategMatSelect0() != null)
			sess().setListLibNewMat(
					EOGemateriel.fetchLeNgeDuPT(edc(), sess()
							.getCategMatSelect0().primaryKey()));
		if (sess().getNouveauEquipement() != null)
			sess().setLibNewMatSelect(sess().getNouveauEquipement());
	}

	// Action tableau dynamique
	// Maj du tableau recevant les personnes li�es au projet
	public void ajoutPerson() {
		try {
			sess().setPersonneDg(null);
			if (sess().getSelectRhPole() == null)
				throw new ValidationException("Veuillez s�lectionner un p�le");
			if (sess().getSelectRhPerson() == null)
				throw new ValidationException(
						"Veuillez s�lectionner une personne");
			ManufactoryPersonnelRhs mpr = new ManufactoryPersonnelRhs(
					wocomponent().edc(), true);
			EOEditingContext ec = ERXEC.newEditingContext();
			sess().setRh(mpr.creerPersonnelVierge(ec));
			sess().rh().setToVrhcmvalRelationship(
					sess().getSelectRhPerson().localInstanceIn(ec));
			wocomponent().logger().debug(ec);
			sess().rh().setNoIndividu(sess().getSelectRhPerson().noIndividu());
			sess().rh().setNomPersonnel(sess().getSelectRhPerson().nomUsuel());
			sess().rh().setCStructure(sess().getSelectRhPole().cStructure());
			sess().rh().setNomStructure(sess().getSelectRhPole().lcStructure());
			sess().rh().setCoutestime(
					coutMoyenRh(sess().rh().tempsuitl(), sess()
							.getSelectRhPerson().rhcmvalVal(), projet()
							.projduree()));
			if (!sess().selectedrhs().contains(sess().rh()))
				sess().selectedrhs().addObject(sess().rh());
			sess().removedrhs().removeObject(sess().rh());
			sess().setSelectRhPole(null);
			sess().setSelectRhPerson(null);
		} catch (ValidationException e) {
			sess().addSimpleErrorMessage("Estimation des ressources humaines",
					e);
			e.printStackTrace();
		} catch (Exception e) {
			sess().addSimpleErrorMessage("Estimation des ressources humaines",
					e);
			e.printStackTrace();
		}
	}
	
	//Correction Bug personnel non/existant
	public String nomPrenom() {
		String afficher = "NON RENSEIGNE";
		EOPprec projet = projet();
		try {
			afficher = sess().getPersonRhRep().toVrhcmval().nomPrenom();
		} catch (Exception e) {
			EOIndividuUlr Ec = EOIndividuUlr.individuPourNumero(edc(), sess().getPersonRhRep().noIndividu());
			sess().addSimpleInfoMessage(
					"Estimation des ressources humaines, Personnels impliqu�s",
					Ec.fullname()
							+ " n'est plus affect�(e) dans le p�le "
							+ sess().getPersonRhRep().nomStructure()
							+ ". NON RENSEIGNE est affich� � la place");
			e.printStackTrace();
		}
		return afficher;
	}

	// Maj du tableau recevant les profils li�s au projet
	public WOActionResults ajoutPoste() {
		try {
			sess().setPostesDg(null);
			if (sess().getSelectRecruePole() == null
					&& sess().getCategSelect() == null)
				throw new ValidationException(
						"Veuillez s�l�ctionner un p�le et une cat�gorie");
			if (sess().getNouvoPostes() == null)
				throw new ValidationException("Veuillez renseigner un profil");
			ManufactoryRecrue mfr = new ManufactoryRecrue(wocomponent().edc(),
					true);
			sess().setRecrue(mfr.creerPosteVierge());
			sess().recrue().setPostelib(sess().getNouvoPostes().toUpperCase());
			sess().recrue().setCStructure(
					sess().getSelectRecruePole().cStructure());
			sess().recrue().setNomStructure(
					sess().getSelectRecruePole().lcStructure());
			sess().recrue().setDureeRecrue(projet().projduree());
			sess().recrue().setToCategorieRhRelationship(
					sess().getCategSelect().localInstanceIn(
							sess().recrue().editingContext()));
			sess().recrue().setMajauteur(auteur());
			sess().recrue().setCoutestime(
					coutMoyenRecrue(sess().recrue().txfinancement(), sess()
							.getCategSelect().typrhcmVal(), sess().recrue()
							.dureeRecrue()));
			if (!sess().selectedRecrue().contains(sess().recrue()))
				sess().selectedRecrue().addObject(sess().recrue());
			sess().removedRecrue().removeObject(sess().recrue());
			sess().setSelectRecruePole(null);
			sess().setCategSelect(null);
			sess().setNouvoPostes(null);
		} catch (ValidationException e) {
			sess().addSimpleErrorMessage("Estimation des personnes � recruter",
					e);
			e.printStackTrace();
		} catch (Exception e) {
			sess().addSimpleErrorMessage("Estimation des personnes � recruter",
					e);
			e.printStackTrace();
		}
		return null;
	}

	// Maj du tableau recevant les mat�riaux existants li�s au projet
	public WOActionResults ajoutMatos() {
		try {
			sess().setPoleMaterielsDg(null);
			if (sess().getSelectMatPole() == null
					&& sess().getCategMatSelect() == null)
				throw new ValidationException(
						"Veuillez s�lectionner un p�le et un plateau technique");
			if (sess().getLibMaterielSelect() == null)
				throw new ValidationException(
						"Veuillez s�lectionner un grand �quipement");
			ManufactoryMateriels materiel = new ManufactoryMateriels(
					wocomponent().edc(), true);
			sess().setMatos(materiel.creerMaterielExistantVierge());
			sess().matos().setToGrandEquipementRelationship(
					sess().getLibMaterielSelect().localInstanceIn(
							sess().matos().editingContext()));
			sess().matos()
					.setCStructure(sess().getSelectMatPole().cStructure());
			sess().matos().setNomStructure(
					sess().getSelectMatPole().lcStructure());
			sess().matos().setToPlateauTechRelationship(
					sess().getCategMatSelect().localInstanceIn(
							sess().matos().editingContext()));
			sess().matos().setMajauteur(auteur());
			sess().setSelectMatPole(null);
			sess().setLibMaterielSelect(null);
			sess().setCategMatSelect(null);
			if (!sess().selectedMaterielExistant().contains(sess().matos()))
				sess().selectedMaterielExistant().addObject(sess().matos());
			sess().removedMaterielExistant().removeObject(sess().matos());
		} catch (ValidationException e) {
			sess().addSimpleErrorMessage("Estimation des ressources mat�riels",
					e);
			e.printStackTrace();
		} catch (Exception e) {
			sess().addSimpleErrorMessage("Estimation des ressources mat�riels",
					e);
			e.printStackTrace();
		}
		return null;
	}

	// Maj du tableau recevant les mat�riaux � acquerir li�s au projet
	public WOActionResults ajouNouvoMatos() {
		try {
			sess().setMaterielsDg(null);
			if (sess().getSelectNewMatPole() == null
					&& sess().getCategMatSelect0() == null)
				throw new ValidationException(
						"Veuillez s�lectionner un p�le et un plateau technique");
			if (sess().getLibNewMatSelect() == null)
				throw new ValidationException(
						"Veuillez s�lectionner un grand �quipement");
			ManufactoryMateriels materiel = new ManufactoryMateriels(
					wocomponent().edc(), true);
			sess().setNewMatos(materiel.creerNouveauMaterielVierge());
			sess().newMatos().setToGrandEquipementRelationship(
					sess().getLibNewMatSelect().localInstanceIn(
							sess().newMatos().editingContext()));
			sess().newMatos().setCStructure(
					sess().getSelectNewMatPole().cStructure());
			sess().newMatos().setNomStructure(
					sess().getSelectNewMatPole().lcStructure());
			sess().newMatos().setToPlateauTechRelationship(
					sess().getCategMatSelect0().localInstanceIn(
							sess().newMatos().editingContext()));
			sess().newMatos().setMajauteur(auteur());
			BigDecimal txCout = coutNouvoMatos(sess().newMatos()
					.txfinancement(), sess().newMatos().toGrandEquipement()
					.coutEstime());
			sess().newMatos().setCoutestime(txCout);
			if (!sess().selectedMaterielAcquis().contains(sess().newMatos()))
				sess().selectedMaterielAcquis().addObject(sess().newMatos());
			sess().removedMaterielAcquis().removeObject(sess().newMatos());
			sess().setSelectNewMatPole(null);
			sess().setCategMatSelect0(null);
			sess().setNouvoMatos(null);
			sess().setLibNewMatSelect(null);
		} catch (ValidationException e) {
			sess().addSimpleErrorMessage(
					"Estimation des ressources mat�riels � acqu�rir", e);
			e.printStackTrace();
		} catch (Exception e) {
			sess().addSimpleErrorMessage(
					"Estimation des ressources mat�riels � acqu�rir", e);
			e.printStackTrace();
		}
		return null;
	}

	// MAJ liste des plateaux techniques en fonction du p�le s�lectionn�
	// (materiel existant)
	public WOActionResults refreshPF() {
		// TODO Auto-generated method stub
		if (sess().getSelectMatPole() != null)
			sess().setListCategMteriels(
					EOPfmateriel.materiels(edc(), sess().getSelectMatPole()
							.cStructure()));
		return null;
	}

	// MAJ liste des plateaux techniques en fonction du p�le s�lectionn�
	// (materiel � acqu�rir)
	public WOActionResults refreshPF0() {
		// TODO Auto-generated method stub
		if (sess().getSelectNewMatPole() != null
				&& !sess().getSelectNewMatPole().lcStructure().equals("P2MN")
				&& !sess().getSelectNewMatPole().lcStructure().equals("ROSAS")) {
			sess().setListCategMteriels0(
					EOPfmateriel.nouveauxMateriels(edc(), sess()
							.getSelectNewMatPole().cStructure()));
		} else {
			sess().setListCategMteriels0(
					EOPfmateriel.fetchLePFduPole(edc(), sess()
							.getSelectNewMatPole().cStructure()));
		}
		return null;
	}

	// MAJ liste des grands �quipementss en fonction du plateau technique
	// s�lectionn�
	public WOActionResults refreshGE() {
		// TODO Auto-generated method stub
		if (sess().getCategMatSelect() != null)
			sess().setListLibMateriels(
					EOGemateriel.fetchLeGEduPF(edc(), sess()
							.getCategMatSelect().primaryKey()));
		return null;
	}

	public WOActionResults refreshGE0() {
		// TODO Auto-generated method stub
		if (sess().getCategMatSelect0() != null)
			sess().setListLibNewMat(
					EOGemateriel.fetchLeNgeDuPT(edc(), sess()
							.getCategMatSelect0().primaryKey()));
		return null;
	}

	public Boolean isSauvegarderUnProjetDisabled() {
		if (isSauvegarderUnProjetDisabled == null)
			isSauvegarderUnProjetDisabled = !isTerminerUnProjetDisabled();
		/*
		 * boolean porteur = projet().porteur() != null; boolean equipe =
		 * projet().equipePrincipale() != null; boolean axe = projet().axe() !=
		 * null; boolean pst = sess().pst() != null; // boolean leProject =
		 * projet != null; boolean personel = sess().selectedrhs().count() >= 0;
		 * boolean poste = sess().selectedRecrue().count() >= 0; boolean reMat =
		 * sess().selectedMaterielExistant().count() >= 0; boolean neMat =
		 * sess().selectedMaterielAcquis().count() >= 0; if (porteur && equipe
		 * && (axe || pst) && (personel || poste) && (reMat || neMat)) {
		 * isSauvegarderUnProjetDisabled = true; }
		 */
		return isSauvegarderUnProjetDisabled;
	}

	/**
	 * @param isSauvegarderUnProjetDisabled
	 *            the isSauvegarderUnProjetDisabled to set
	 */
	public void setIsSauvegarderUnProjetDisabled(
			Boolean isSauvegarderUnProjetDisabled) {
		this.isSauvegarderUnProjetDisabled = isSauvegarderUnProjetDisabled;
	}

	public Boolean isTerminerUnProjetDisabled() {
		if (isTerminerUnProjetDisabled == null) {
			String messageFini = "";
			String personnel = "de l'estimation des ressources humaines";
			String resume = "du resum� du projet";
			String message = "Penser � renseigner au moins une des informations ";
			String message2 = " pour activer le bouton 'Demande visa'";
			wocomponent().onSuivant();
			boolean porteur = projet().porteur() != null;
			boolean equipe = projet().equipePrincipale() != null;
			boolean axe = sess().axe() != null;
			boolean pst = sess().pst() != null;
			boolean ctx = projet().projctx() != null;
			boolean obj = projet().projobf() != null;
			boolean mtd = projet().projmtdg() != null;
			boolean plm = projet().projpblm() != null;
			// Seul le porteur peut demander un visa quand toutes les conditions
			// sont r�unies
			boolean porteurProjet = wocomponent().estPorteur(projet());
			if (!ctx && !obj && !mtd && !plm)
				messageFini = message + resume + message2;

			boolean personel = sess().selectedrhs().count() > 0;
			if (!personel) {
				if (messageFini.contains("projet")) {
					messageFini = message + resume + " et " + personnel
							+ message2;
				} else {
					messageFini = message + personnel + message2;
				}
			}
			boolean poste = sess().selectedRecrue().count() > 0;
			if (!poste) {
				if (messageFini.contains("projet")) {
					messageFini = message + resume + " et " + personnel
							+ message2;
				} else {
					messageFini = message + personnel + message2;
				}
			}
			if (porteur && equipe && (axe || pst) && (ctx || obj || mtd || plm)
					&& (personel || poste)
					&& (porteurProjet || wocomponent().droitTout())) {
				isTerminerUnProjetDisabled = false;
			} else {
				isTerminerUnProjetDisabled = true;
				sess().addSimpleInfoMessage(null, messageFini);
				// sess().setAlertMessage("Penser � renseigner toutes les informations n�cessaires (+) pour activer le bouton 'Soumettre'");
				wocomponent().context().response().setStatus(500);
				AjaxUpdateContainer.updateContainerWithID(wocomponent()
						.updateNextContainerId(), wocomponent().context());
			}
		}
		return isTerminerUnProjetDisabled;
	}

	// ---> AjaxInPlaceEditor Methods and actions <--- //

	/**
	 * @param isTerminerUnProjetDisabled
	 *            the isTerminerUnProjetDisabled to set
	 */
	public void setIsTerminerUnProjetDisabled(Boolean isTerminerUnProjetDisabled) {
		this.isTerminerUnProjetDisabled = isTerminerUnProjetDisabled;
	}

	protected static boolean isNumeric(String str) {
		try {
			str = str.replace(",", ".");
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	// people from one pole **/
	public WOActionResults saveOnImplication() {
		if (!isNumeric(sess().getPersonRhRep().tempsuitl())) {
			sess().addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}

		String str = sess().getPersonRhRep().tempsuitl().replace(",", ".");
		double d = Double.parseDouble(str);
		if (Double.valueOf(d) > 100) {
			sess().addSimpleErrorMessage("Valeur trop �lev�e",
					"Le maximum est 100");
			sess().getPersonRhRep().setTempsuitl("5");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}
		BigDecimal tmp = coutMoyenRh(String.valueOf(d), sess().getPersonRhRep()
				.toVrhcmval().rhcmvalVal(), projet().projduree());
		if (sess().getPersonRhRep().toVrhcmval().isEnsChercheur())
			tmp = tmp.divide(BigDecimal.valueOf(2));
		sess().getPersonRhRep().setCoutestime(tmp);
		return null;
	}

	// Person to recruit **/

	public WOActionResults saveOnTxFinance() {
		if (!isNumeric(sess().getPoleRecruRepetition().txfinancement())) {
			sess().addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}

		String str = sess().getPoleRecruRepetition().txfinancement()
				.replace(",", ".");
		double d = Double.parseDouble(str);

		if (Double.valueOf(d) > 100) {
			sess().addSimpleErrorMessage("Valeur trop �lev�e",
					"Le maximum est 100");
			sess().getPoleRecruRepetition().setTxfinancement("5");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}
		BigDecimal tmp = coutMoyenRecrue(String.valueOf(d), sess()
				.getPoleRecruRepetition().toCategorieRh().typrhcmVal(), sess()
				.getPoleRecruRepetition().dureeRecrue());
		sess().getPoleRecruRepetition().setCoutestime(tmp);
		return null;
	}

	// Duree Projet

	public WOActionResults saveOnDuree() {
		if (!isNumeric(sess().getPoleRecruRepetition().dureeRecrue())) {
			sess().addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}

		String str = sess().getPoleRecruRepetition().txfinancement()
				.replace(",", ".");
		double d = Double.parseDouble(str);

		BigDecimal tmp = coutMoyenRecrue(String.valueOf(d), sess()
				.getPoleRecruRepetition().toCategorieRh().typrhcmVal(), sess()
				.getPoleRecruRepetition().dureeRecrue());
		sess().getPoleRecruRepetition().setCoutestime(tmp);
		return null;
	}

	// Equipments from poles

	public WOActionResults saveOnUtilisation() {
		if (!isNumeric(sess().getMaterielRep().matutil())) {
			sess().addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}

		String str = sess().getMaterielRep().matutil().replace(",", ".");
		double d = Double.parseDouble(str);

		if (Double.valueOf(d) > 100) {
			sess().addSimpleErrorMessage("Valeur trop �lev�e",
					"Le maximum est 100");
			sess().getMaterielRep().setMatutil("5");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}
		return null;
	}

	// Material to get

	public WOActionResults saveOnFinance() {
		if (!isNumeric(sess().getPoleNewMatRep().txfinancement())) {
			sess().addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}

		String str = sess().getPoleNewMatRep().txfinancement()
				.replace(",", ".");
		double d = Double.parseDouble(str);

		if (Double.valueOf(d) > 100) {
			sess().addSimpleErrorMessage("Valeur trop �lev�e",
					"Le maximum est 100");
			sess().getPoleNewMatRep().setTxfinancement("5");
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;
		}

		BigDecimal txCout = coutNouvoMatos(String.valueOf(d), sess()
				.getPoleNewMatRep().toGrandEquipement().coutEstime());
		sess().getPoleNewMatRep().setCoutestime(txCout);
		return null;

	}

	// Co�t moyen pour un en-cherch d�j� en poste
	protected BigDecimal coutMoyenRh(String pctge, Integer cm, String mois) {
		BigDecimal couMoyen = new BigDecimal(0);
		BigDecimal couMoy = new BigDecimal(0);
		BigDecimal tx = BigDecimal.valueOf(Double.valueOf(pctge));
		BigDecimal moi = BigDecimal.valueOf(Double.valueOf(mois));
		BigDecimal cmm = BigDecimal.valueOf(cm);
		BigDecimal div = tx.multiply(cmm);
		BigDecimal prod = div.divide(BigDecimal.valueOf(100));
		couMoyen = prod.multiply(moi);
		couMoy = couMoyen.setScale(2, RoundingMode.FLOOR);
		NumberFormat eurCostFormat = NumberFormat
				.getCurrencyInstance(Locale.FRANCE);
		eurCostFormat.setMinimumFractionDigits(1);
		eurCostFormat.setMaximumFractionDigits(2);
		NSLog.out.appendln("persRh - Co�t estim� � " + tx + "%  sur " + moi
				+ " mois : " + eurCostFormat.format(couMoy.doubleValue()));
		return couMoy;
	}

	// Co�t moyen pour un recrutement
	protected BigDecimal coutMoyenRecrue(String pctge, Integer cm, String mois) {
		BigDecimal couMoyen = new BigDecimal(0);
		BigDecimal couMoy = new BigDecimal(0);
		BigDecimal tx = BigDecimal.valueOf(Double.valueOf(pctge));
		BigDecimal moi = BigDecimal.valueOf(Double.valueOf(mois));
		BigDecimal div = tx.multiply(BigDecimal.valueOf(cm));
		BigDecimal prod = div.divide(BigDecimal.valueOf(100));
		// NSLog.out.appendln(tx + "% du coutMoyen :" + prod);
		// BigDecimal tmp = BigDecimal.valueOf(cm).subtract(prod);
		couMoyen = prod.multiply(moi);
		couMoy = couMoyen.setScale(2, RoundingMode.FLOOR);
		NumberFormat eurCostFormat = NumberFormat
				.getCurrencyInstance(Locale.FRANCE);
		eurCostFormat.setMinimumFractionDigits(1);
		eurCostFormat.setMaximumFractionDigits(2);
		NSLog.out.appendln("Poste - Co�t estim� � " + tx + "% sur " + moi
				+ " mois : " + eurCostFormat.format(couMoy.doubleValue()));
		return couMoy;
	}

	// Co�t d'un nouveau mat�riel
	protected BigDecimal coutNouvoMatos(String pctge, BigDecimal cm) {
		//BigDecimal couMoyen = new BigDecimal(0);
		BigDecimal couMoy = new BigDecimal(0);
		BigDecimal tx = BigDecimal.valueOf(Double.valueOf(pctge)).divide(BigDecimal.valueOf(Double.valueOf(pctge)));
		BigDecimal div = tx.multiply(cm).multiply(BigDecimal.valueOf(100));
		BigDecimal prod = div.divide(BigDecimal.valueOf(100));
		// NSLog.out.appendln(tx + "% du coutMoyen :" + prod);
		//couMoyen = cm.subtract(prod);
		couMoy = prod.setScale(2, RoundingMode.FLOOR);
		NumberFormat eurCostFormat = NumberFormat
				.getCurrencyInstance(Locale.FRANCE);
		eurCostFormat.setMinimumFractionDigits(1);
		eurCostFormat.setMaximumFractionDigits(2);
		NSLog.out.appendln("Nouveau mat�riel -" + tx + "% Co�t estim� "
				+ eurCostFormat.format(couMoy.doubleValue()));
		return couMoy;
	}

	// Fin action tableaux

	protected void save() {
		// Traitement Ecriture projet
		traitementProjet();
		// lancement de l'insertion de la liste des partenaire et des autres
		// �quipes projets
		if (success)
			traitementPartenaire();
		if (success)
			traitementEquipe();
		// Traitement Axes STMR
		if (success)
			traitementStmr();
		// Traitement des mots clefs
		if (success)
			traitementMotClef();
		// Lancement de l'insertition des donn�es du tableau dynamique
		if (success)
			traitementPersonnels();
		if (success)
			traitementPostes();
		if (success)
			traitementMateriels();
		if (success)
			traitementNewMateriel();
		// Fin insertion tableau dynamique

		// Envoie de mail en cas de soumission
		if (success)
			traitementMail();

		if (success) {
			sess().addSimpleInfoMessage(
					"Nouveau Projet '"
							+ wocomponent().mySession().getNomCourt()
							+ " 'soumi avec succ�s",
					"Le projet � �t� ajout� dans le r�f�rentiel ADMREC");
			sess().resetAll();
		}
	}

	protected void traitementProjet() throws FactoryException {
		EOPprec leNouveauProjet = null;
		// Traitement Ecriture projet
		try {
			EOPprec leProjet = trtProjet().projetEnCours(projet(),
					wocomponent());
			wocomponent().setLeProjetEnCours(leProjet);
			leNouveauProjet = wocomponent().leProjetEnCours();
			ProcessProjet.enregistrer(sess().dataBus(), edc, leNouveauProjet);
			wocomponent().setIdProj(leNouveauProjet.getProjIdProc());
			// On refetch pour r�cup�r� le dernier enregistrement pour les
			// autres donn�es d�pendants de EOPPREC
			lProjet = EOPprec.projetPourNumero(edc,
					Integer.valueOf(wocomponent().idProj().toString()));
			if (lProjet == null) {
				wocomponent().setLeProjetEnCours(leNouveauProjet);
			} else {
				wocomponent().setLeProjetEnCours(lProjet);
			}
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementPartenaire() throws FactoryException {
		try {
			NSArray<EOPartenaireProjet> lesPartenaires = trtPartenaire
					.partProj(wocomponent());
			trtPartenaire().traitementPartProjet(wocomponent(), lesPartenaires);
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementEquipe() throws FactoryException {
		try {
			NSArray<EOEquipes> lesEquipes = trtEquipes().autrePRGAssocie(
					wocomponent());
			trtEquipes.traitementAutrePRGAssocie(lesEquipes, wocomponent());
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementStmr() throws FactoryException {
		try {
			if (wocomponent().leProjetEnCours().toAxe() == null
					&& (wocomponent().leProjetEnCours().projthetv() == null || wocomponent()
							.leProjetEnCours().projthetv().equals("N"))) {
				NSArray<EORepartaxe> lesRepartAxes = trtRepartAxe()
						.pstEncCours(wocomponent());
				trtRepartAxe().traitementPst(lesRepartAxes.immutableClone(),
						wocomponent());
			} else if (wocomponent().leProjetEnCours().projthetv() != null
					&& wocomponent().leProjetEnCours().projthetv().equals("O")
					&& sess().getSelectedStmrAxe() != null) {
				NSArray<EORepartaxe> lesRepartAxes = trtRepartAxe()
						.pstEncCours(wocomponent());
				trtRepartAxe().traitementPst(lesRepartAxes.immutableClone(),
						wocomponent());
			}
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementMotClef() throws FactoryException {
		try {
			NSArray<EOMotclefs> keywords = trtMotClefs()
					.Keywords(wocomponent());
			trtMotClefs().traitementMotClefs(keywords, wocomponent());
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementPersonnels() throws FactoryException {
		try {
			NSArray<EOPersonnel> lesPersonnel = trtPersonnel()
					.personnelsEncCours(wocomponent(),
							wocomponent().personnels(), personnel);
			trtPersonnel().traitementPersonnel(lesPersonnel, wocomponent());
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementPostes() throws FactoryException {
		try {
			NSArray<EOPosterh> lesPotes = trtPoste().postesEncCours(
					wocomponent(), wocomponent().posteRh(), poste);
			trtPoste().traitementPoste(lesPotes, wocomponent());
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementMateriels() throws FactoryException {
		try {

			NSArray<EOResmat> lesMatos = trtMateriel().materielsEncCours(
					wocomponent(), wocomponent().resMat(), materiel);
			trtMateriel().traitementMateriel(lesMatos, wocomponent());
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementNewMateriel() throws FactoryException {
		try {
			NSArray<EOResmat> lesNewMat = trtMateriel().newResMatEncCours(
					wocomponent(), wocomponent().newResMat(), materiel);
			trtMateriel().traitementMateriel(lesNewMat, wocomponent());
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			success = false;
			sess().dataBus().rollbackTransaction();
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementMail() throws FactoryException {
		try {
			if (projet().toEtat().typrefnat().equals("SO")) {
				EOAlerte uneAlerte = EOAlerte.numeroPourProjet(edc(),
						Integer.valueOf(projet().primaryKey()));
				if (uneAlerte == null) {
					uneAlerte = EOAlerte.newEOAlerteInContext(edc(), projet());
					// uneAlerte.insertInEditingContext(uneAlerte.editingContext());
					uneAlerte.sendMailsNouvelleAlerte(sess(), projet());
					// ProcessAlerte.enregistrer(sess().dataBus(),
					// edc(),uneAlerte);
					uneAlerte.editingContext().saveChanges();
					if (sess().getAlertMessage() != null
							&& !sess().getAlertMessage().equals(""))
						throw new FactoryException(sess().getAlertMessage());
				} else {
					uneAlerte.sendMailsNouvelleAlerte(sess(), projet());
				}
				success = true;
			}
		} catch (Exception e) {
			success = false;
			sess().dataBus().rollbackTransaction();
			edc().revert();
			deleteError();
			String alertMessage = e.getMessage();
			if (alertMessage == null)
				alertMessage = "java.lang.NullPointerException"
						+ "Aucune alerte mail pour le projet en modification";
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.updateNextContainerId(), wocomponent().context());
		}
	}

	// Supression du projet enregistr� en cas d'erreur
	// dans le reste du traitement
	protected void deleteError() throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		try {
			sess().dataBus().beginTransaction();
			pbProcedure = ProcedureDelError.supprimer(sess().dataBus(),
					wocomponent().leProjetEnCours());
			dico = new NSDictionary(sess().dataBus().executedProcResult());
			if (!pbProcedure) {
				throw new FactoryException((String) dico.valueForKey("ERREUR"));
			}
			sess().dataBus().commitTransaction();
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			System.out.println("FactoryException : " + e);
			throw e;
		} catch (Exception e) {
			sess().dataBus().rollbackTransaction();
			System.out.println("Exception : " + e);
			throw new FactoryException(e.getMessage());
		}
	}
}
