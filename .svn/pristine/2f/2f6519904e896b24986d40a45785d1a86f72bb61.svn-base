/**
 * 
 */
package utt.rec.projet.server.components.controler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.NextProject;
import utt.rec.projet.server.components.NouveauPartenaire;
import utt.rec.projet.server.components.Projects;
import utt.rec.projet.server.components.SoumiProject;
import utt.rec.projet.server.components.procedures.ProcedureDelError;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.factory.FactoryDataArray;
import utt.rec.projet.server.factory.FactoryTraitemantEquipes;
import utt.rec.projet.server.factory.FactoryTraitementHistorique;
import utt.rec.projet.server.factory.FactoryTraitementMateriels;
import utt.rec.projet.server.factory.FactoryTraitementMotClefs;
import utt.rec.projet.server.factory.FactoryTraitementPartenaires;
import utt.rec.projet.server.factory.FactoryTraitementPersonnel;
import utt.rec.projet.server.factory.FactoryTraitementPosteRh;
import utt.rec.projet.server.factory.FactoryTraitementProjet;
import utt.rec.projet.server.factory.FactoryTraitementRepartPst;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORefidx;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.admrec.EOVrhcmval;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EORepartAssociation;
import utt.rec.projet.server.metier.grhum.EORepartStructure;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessProjet;
import utt.rec.projet.server.utils.manufactory.ManufactoryPartenaire;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOGeneralAdaptorException;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import er.ajax.AjaxUpdateContainer;
import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.appserver.ERXRedirect;
import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class ProjectCtrl extends ModuleCtrl<Projects> {

	private FactoryDataArray dataArray;
	Boolean temException = null;
	private EOEditingContext edc;
	private Session sess;
	private EOPosterh poste;
	private EOPersonnel personnel;
	private EOResmat materiel;
	private Number idPArt;
	// Liste partenaire selectionne
	private NSArray<EOTyppartenaire> newPartList;
	private EOTyppartenaire partenaireItem;
	private WODisplayGroup partenaireDg;
	// Equipe secondaires
	private EOStructureUlr otherRepetition;
	private WODisplayGroup autreEquipeDg;
	private EOPprec projet;
	private FactoryTraitemantEquipes trtEquipes;
	private FactoryTraitementPersonnel trtPersonnel;
	private FactoryTraitementPosteRh trtPoste;
	private FactoryTraitementMateriels trtMateriel;
	private FactoryTraitementProjet trtProjet;
	private FactoryTraitementHistorique trtHtq;
	private FactoryTraitementPartenaires trtPartenaire;
	private FactoryTraitementMotClefs trtMotClefs;
	private FactoryTraitementRepartPst trtRepartAxe;
	private boolean resetAjoutPartenaireDialog;
	private EOEditingContext editingContextForPartner;

	/**
	 * @param component
	 */
	public ProjectCtrl(Projects component) {
		super(component);
		// TODO Auto-generated constructor stub
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
	 * @return the dataArray
	 */
	public FactoryDataArray dataArray() {
		if (dataArray == null)
			dataArray = new FactoryDataArray(wocomponent(), sess(),
					wocomponent().equipeOther(), wocomponent().newPartListe());
		return dataArray;
	}

	/**
	 * @param dataArray
	 *            the dataArray to set
	 */
	public void setDataArray(FactoryDataArray dataArray) {
		this.dataArray = dataArray;
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

	/* Date base save Method */

	// Enregistrement dans la base de données
	public WOActionResults enregistrer() {
		String vide = "<p><br data-mce-bogus=\"1\"></p>";
		ERXRedirect redirect = null;
		WORequest request = wocomponent().context().request();
		String contexte = (String) request.formValueForKey("Contexte");
		String problematik = (String) request.formValueForKey("Problematique");
		String objectifs = (String) request.formValueForKey("Objectifs");
		String methodo = (String) request.formValueForKey("Methodologie");
		if (contexte != null && !contexte.equals(vide) && !contexte.equals("")) {
			sess().setContexte(contexte);
		}
		if (problematik != null && !problematik.equals(vide)
				&& !problematik.equals("")) {
			sess().setProblematik(problematik);
		}
		if (objectifs != null && !objectifs.equals(vide)
				&& !objectifs.equals("")) {
			sess().setObjectifs(objectifs);
		}
		if (methodo != null && !methodo.equals(vide) && !methodo.equals("")) {
			sess().setMetho(methodo);
		}
		EOPprec leNouveauProjet = null;
		EOEditingContext nestedEdc = edc();
		sess().setNestedEdc(nestedEdc);
		save();
		if (temException) {
			redirect = (ERXRedirect) wocomponent().pageWithName(
					ERXRedirect.class.getName());
			Projects back = (Projects) wocomponent().pageWithName(
					Projects.class.getName());
			back.ctrl().isEnregistrerUnProjetEnabled();
			redirect.setComponent(back);
		} else {
			SoumiProject nextPage = (SoumiProject) wocomponent().pageWithName(
					SoumiProject.class.getName());
			nextPage.setNumero(wocomponent().idProj());
			Projects back = (Projects) wocomponent().pageWithName(
					Projects.class.getName());
			back.setOnloadJS("openListeSelectionWin(null,'"
					+ wocomponent().context().directActionURLForActionNamed(
							"pageProjetSoumis", null)
					+ "',\'Fin de sauvegarde Projet\',\'PageSoumiseDetaillee\',\'Contenu\',true);");
			redirect = (ERXRedirect) wocomponent().pageWithName(
					ERXRedirect.class.getName());
			redirect.setComponent(nextPage);
		}
		return redirect;
	}

	/* End Date Base save Method */

	/**
	 * Date du jour
	 */
	public static Date sysdate() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy/MMM/dd HH:mm:ss");
		String dateNow = formatter.format(currentDate.getTime());
		NSLog.out.appendln(dateNow);
		return currentDate.getTime();
	}

	@SuppressWarnings("deprecation")
	public static NSTimestamp date(Date dt) {
		NSTimestamp tm = new NSTimestamp();
		tm.setDate(dt.getDate());
		tm.setMonth(dt.getMonth());
		tm.setYear(dt.getYear());
		tm.setHours(dt.getHours());
		tm.setMinutes(dt.getMinutes());
		tm.setSeconds(dt.getSeconds());
		return tm;
	}

	protected static boolean estNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	// Remove item form partnerList
	public WOActionResults removeSelectedPartenaire() {
		try {
			setPartenaireDg(null);
			sess().selectedPartenaires().removeObject(partenaireItem());
			if (!sess().removedPartenaires().contains(partenaireItem()))
				sess().removedPartenaires().addObject(partenaireItem());
			if (sess().selectedPartenaires().count() == 0) {
				sess().setPartenaire(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			sess().addSimpleErrorMessage("Supression partenaire",
					e.getLocalizedMessage());
		}
		return null;
	}

	// Remove item from OtherEquipeList
	public WOActionResults removeEquipeSecondaires() {
		try {
			setAutreEquipeDg(null);
			sess().selectedEquipes().removeObject(getOtherRepetition());
			if(!sess().removedEquipes().contains(getOtherRepetition()))
				sess().removedEquipes().addObject(getOtherRepetition());
			if(sess().selectedEquipes().count() == 0)
				sess().setSelectedEquipeSecondaire(null);
		} catch (Exception e) {
			// TODO: handle exception
			sess().addSimpleErrorMessage("Supression équipe secondaire",
					e.getLocalizedMessage());
		}
		return null;
	}

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
	 * @return the trstMateriel
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
	public void setTrtRepartAxe(FactoryTraitementRepartPst trtRepartAxe) {
		this.trtRepartAxe = trtRepartAxe;
	}

	/**
	 * @return the newPartList
	 */
	public NSArray<EOTyppartenaire> newPartList() {
		return newPartList;
	}

	/**
	 * @param newPartList
	 *            the newPartList to set
	 */
	public void setNewPartList(NSArray<EOTyppartenaire> newPartList) {
		this.newPartList = newPartList;
	}

	/**
	 * @return the partenaireItem
	 */
	public EOTyppartenaire partenaireItem() {
		return partenaireItem;
	}

	/**
	 * @param partenaireItem
	 *            the partenaireItem to set
	 */
	public void setPartenaireItem(EOTyppartenaire partenaireItem) {
		this.partenaireItem = partenaireItem;
	}

	/**
	 * @return the partenaireDg
	 */
	public WODisplayGroup partenaireDg() {
		if (partenaireDg == null) {
			partenaireDg = new WODisplayGroup();
			partenaireDg.setObjectArray(sess().selectedPartenaires()
					.immutableClone());
		}
		return partenaireDg;
	}

	/**
	 * @param partenaireDg
	 *            the partenaireDg to set
	 */
	public void setPartenaireDg(WODisplayGroup partenaireDg) {
		this.partenaireDg = partenaireDg;
	}

	/**
	 * @return the autreEquipeDg
	 */
	public WODisplayGroup autreEquipeDg() {
		if (autreEquipeDg == null) {
			autreEquipeDg = new WODisplayGroup();
			autreEquipeDg.setObjectArray(sess().selectedEquipes()
					.immutableClone());
		}
		return autreEquipeDg;
	}

	/**
	 * @param autreEquipeDg
	 *            the autreEquipeDg to set
	 */
	public void setAutreEquipeDg(WODisplayGroup autreEquipeDg) {
		this.autreEquipeDg = autreEquipeDg;
	}

	/**
	 * @return the otherRepetition
	 */
	public EOStructureUlr getOtherRepetition() {
		return otherRepetition;
	}

	/**
	 * @param otherRepetition
	 *            the otherRepetition to set
	 */
	public void setOtherRepetition(EOStructureUlr otherRepetition) {
		this.otherRepetition = otherRepetition;
	}

	// Action

	public WOActionResults isEnregistrerUnProjetEnabled() {
		NSMutableArray stm = new NSMutableArray();
		boolean porteur = projet().porteur() != null;
		boolean axe = projet().toAxe() != null && projet().toAxe().isAxe();
		boolean axeTmk = sess().axeStmr() != null;
		boolean pst = sess().pst() != null;
		boolean temoinTransversale = projet().projthetv().equals("O");
		if (porteur && (axe || pst)) {
			wocomponent().isEnregistrerUnProjetDisabled = false;
		}
		if (pst	&& !temoinTransversale
				&& !sess().lesAxesStmr()
						.contains(sess().pst())) {
			stm.addObject(sess().pst());
			sess().lesAxesStmr().addObject(sess().pst());
		}
		if (pst && axeTmk
				&& !temoinTransversale
				&& !sess().lesAxesStmr()
						.contains(sess().axeStmr())) {
			stm.addObject(sess().axeStmr());
			sess().lesAxesStmr().addObject(sess().axeStmr());
		}
		if (axe && temoinTransversale
				&& !sess().lesAxesStmr()
						.contains(sess().axe())) {
			stm.addObject(sess().axe());
			sess().lesAxesStmr().addObject(sess().axe());
		}
		// Activation de axe lors de la selection de thematique
		if (axe && axeTmk
				&& temoinTransversale
				&& !sess().lesAxesStmr()
						.contains(sess().axeStmr())) {
			stm.addObject(sess().axeStmr());
			sess().lesAxesStmr().addObject(sess().axeStmr());
		}
		return null;
	}

	public boolean peutNouveauPartenaire() {
		Boolean partenaireCreate = null;
		if (wocomponent().myApp().newGestionDroitsEnabled()) {
			partenaireCreate = wocomponent().myAppGDUser()
					.getPprecAutorisationCache().gDPprecCreationProjet()
					|| wocomponent().myAppGDUser().getPprecAutorisationCache()
							.gDPprecSuperUserProjet();
		} else {
			partenaireCreate = wocomponent().myAppJAUser()
					.hasDroitCreationProjet()
					|| wocomponent().myAppJAUser().hasDroitSuperUserProjet();
		}
		return partenaireCreate;
	}
	
	public String auteur() {
		if (wocomponent().myApp().newGestionDroitsEnabled()) {
			return wocomponent().myAppGDUser().getPersId().toString();
		}
		return wocomponent().myAppJAUser().getPersId().toString();
	}

	public WOActionResults openAjouterPartenaire() {
		NouveauPartenaire page = null;
		try {
			ManufactoryPartenaire mfp = new ManufactoryPartenaire(ERXEC.newEditingContext(), true);
			EOTyppartenaire partenaire = mfp.creerPartenaireVierge();
			setResetAjoutPartenaireDialog(true);
			page = (NouveauPartenaire) wocomponent().pageWithName(
					NouveauPartenaire.class.getName());
			page.setEditingContext(getEditingContextForPartner());
			page.setResetAjoutPartenaireDialog(true);
			page.setPartenaire(partenaire);
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return page;
	}

	@SuppressWarnings("unchecked")
	public void refreshPartenaire() {
		sess().setPartenaireList(
				EOTyppartenaire.fetchAllEOTyppartenaires(edc(), new NSArray(
						EOTyppartenaire.DENOM_USUELLE.asc())));
	}

/*	public WOActionResults upDateStContrat() {
		if (sess().contrat() != null) {
			sess().setStContratList(
					EOTypcontrat.fetchEOTypcontrats(
							edc(),
							EOTypcontrat.TYPCONT_NOM_ABR
									.eq(sess().contrat()
											.typcontNomAbr()).and(
											EOTypcontrat.TYPCONT_ID_SUP
													.isNotNull()), new NSArray(
									EOTypcontrat.TYPCONT_NOM_ABR.asc())));
		} else {
			sess().setStContratList(null);
		}
		return null;
	}*/

	protected void save() {
		// Traitement Ecriture projet
		traitementProjet();
		// lancement de l'insertion de la liste des partenaire et des autres
		// équipes projets
		if (!temException)
			traitementPartenaire();
		if (!temException)
			traitementEquipe();
		// Traitement Axes STMR
		if (!temException)
			traitementStmr();
		// Traitement des mots clefs
		if (!temException)
			traitementMotClef();
		if (!temException) {
			sess().addSimpleInfoMessage("Confirmation",
					"Le projet enregistré avec succès");
			sess().resetAll();
		}

	}

	// On fetche tous les individus faisant parti d'une équipe dont la date de
	// fonction est valide à l'instant "t"
	public NSMutableArray<Integer> IntegerEquipe() {
		NSMutableArray<Integer> erList = new NSMutableArray<Integer>();
		NSArray tmpList = EORepartAssociation.fetchLesER(wocomponent().edc(),
				new NSTimestamp());
		for (int i = 0; i < tmpList.count(); i++) {
			Integer persId = ((EORepartAssociation) tmpList.objectAtIndex(i))
					.persId();
			erList.addObject(persId);
		}
		return erList;
	}

	protected void traitementProjet() {
		EOPprec leNouveauProjet = null;
		EOPprec lProjet = null;
		// Traitement Ecriture projet
		try {
			if (wocomponent().idProj() == null) {
				EOPprec leProjet = trtProjet().projetEnCours(
						wocomponent().myProjet(), wocomponent());
				wocomponent().setLeProjetEnCours(leProjet);
				leNouveauProjet = wocomponent().leProjetEnCours();
				ProcessProjet.enregistrer(sess().dataBus(), edc(),
						leNouveauProjet);
				wocomponent().setIdProj(leNouveauProjet.getProjIdProc());
				// On refetch pour récupéré le dernier enregistrement pour les
				// autres données dépendants de EOPPREC
				lProjet = EOPprec.projetPourNumero(edc,
						Integer.valueOf(wocomponent().idProj().toString()));
				wocomponent().setLeProjetEnCours(lProjet);
				temException = false;
			}
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			re.printStackTrace();
		}
	}

	protected void traitementPartenaire() {
		try {
			NSArray<EOPartenaireProjet> lesPartenaires = trtPartenaire()
					.partProj(wocomponent());
			trtPartenaire().traitementPartProjet(wocomponent(), lesPartenaires);
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			temException = false;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			re.printStackTrace();
		}
	}

	protected void traitementEquipe() {
		try {
			NSArray<EOEquipes> lesEquipes = trtEquipes().autrePRGAssocie(
					wocomponent());
			trtEquipes().traitementAutrePRGAssocie(lesEquipes, wocomponent());
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			temException = false;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			re.printStackTrace();
		}
	}
	
	public void refdix() {
		if (wocomponent().myKeywordList().count() > 0) {
			for (int i = 0; i < wocomponent().myKeywordList().count(); i++) {
				EORefidx tmp = (EORefidx) wocomponent().myKeywordList().objectAtIndex(i);
				switch (i) {
				case 0:
					sess().setMotClef(tmp);
					break;
				case 1:
					sess().setMotClef1(tmp);
					break;
				case 2:
					sess().setMotClef2(tmp);
					break;
				case 3:
					sess().setMotClef3(tmp);
					break;
				case 4:
					sess().setMotClef4(tmp);
					break;
				case 5:
					sess().setMotClef5(tmp);
					break;
				case 6:
					sess().setMotClef6(tmp);
					break;
				case 7:
					sess().setMotClef7(tmp);
					break;
				case 8:
					sess().setMotClef8(tmp);
					break;
				case 9:
					sess().setMotClef9(tmp);
					break;
				case 10:
					sess().setMotClef10(tmp);
					break;
				case 11:
					sess().setMotClef11(tmp);
					break;
				default:
					break;
				}
			}
		}

	}

	protected void traitementStmr() {
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
			temException = false;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			re.printStackTrace();
		}
	}

	protected void traitementMotClef() {
		try {
			NSArray<EOMotclefs> keywords = trtMotClefs()
					.Keywords(wocomponent());
			trtMotClefs().traitementMotClefs(keywords, wocomponent());
			if (sess().getAlertMessage() != null
					&& !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			temException = false;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			temException = true;
			deleteError();
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			re.printStackTrace();
		}
	}

	// Supression du projet enregistrer en cas d'erreur
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
