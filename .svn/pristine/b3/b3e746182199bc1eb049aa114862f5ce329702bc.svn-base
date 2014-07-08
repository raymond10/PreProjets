package utt.rec.projet.server;

import org.cocktail.fwkcktlajaxwebext.serveur.CocktailAjaxSession;
import org.cocktail.fwkcktlajaxwebext.serveur.component.CktlAjaxWindow;
import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;

import sun.net.www.http.PosterOutputStream;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.EnseignantsChercheursView;
import utt.rec.projet.server.components.MonComposant;
import utt.rec.projet.server.components.controler.ProjectCtrl;
import utt.rec.projet.server.metier.ProjectListTampon;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOCategorie;
import utt.rec.projet.server.metier.admrec.EOCommentaires;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOGemateriel;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORefidx;
import utt.rec.projet.server.metier.admrec.EORefthe;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.admrec.EOTypref;
import utt.rec.projet.server.metier.admrec.EOTypthe;
import utt.rec.projet.server.metier.admrec.EOVrhcmval;
import utt.rec.projet.server.metier.admrec.EOVtyprhcm;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.appserver.WORequest;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSNumberFormatter;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.appserver.ERXWOContext;
import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXStringUtilities;
import er.extensions.foundation.ERXThreadStorage;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class Session extends CocktailAjaxSession {
	private static final long serialVersionUID = 1L;
	private static final String ACCUEIL = "Accueil";
	public NSNumberFormatter monnaieFormatter;
	public Integer indexModuleActifGestionProjet = null;
	private PPrecApplicationUser applicationGDUser = null;
	private EnseignantApplicationUser applicationJAUser = null;
	private String generalErrorMessage;
	EOEditingContext nestedEdc = null;
	private EOEditingContext editingContext;
	private EOUtilisateur utilisateur = null;
	private EOPprec leProjetEnCours = null;
	private EOPprec projectSelected;
	private EOGemateriel nouveauEquipement;
	String alertMessage = null;
	String messageErreur = null;
	public boolean retourMaj = false;
	public Integer noIndividu;
	// Page 1
	private String nomCourt;
	private String nomLong;
	private NSTimestamp dateDebut;
	private String dureeProjet;
	private String sourceFinance;
	// Contrats Acceuil
	private EOTypcontrat contratRepetition1;
	private EOTypcontrat selectedContrat1;
	// Contrat
	private NSArray<EOTypcontrat> contratList;
	private EOTypcontrat contratRepetition;
	private EOTypcontrat contrat;
	// Sous-Type Contrat
	private NSArray<EOTypcontrat> stContratList;
	private EOTypcontrat stContratItem;
	private EOTypcontrat stContratSelected;
	// Partenaires
	private NSArray<EOTyppartenaire> partenaireList;
	private EOTyppartenaire partenaireRepetition;
	private EOTyppartenaire partenaire;
	private String partAdd;
	// Tableay de selection de partenaires
	private NSMutableArray selectedPartenaires;
	private NSMutableArray removedPartenaires;
	// Equipe principale
	private NSArray<EOStructureUlr> equipeList;
	private EOStructureUlr equipeRepetition;
	private EOStructureUlr equipePrincipale;
	private EOEquipes newEquipe;
	// Liste partenaire selectionne
	private NSArray<EOTyppartenaire> newPartList;
	private EOTyppartenaire partenaireItem;
	private WODisplayGroup partenaireDg;
	// Axe du projet
	private NSArray<EOAxerec> axeList;
	private EOAxerec axeRepetition;
	private EOAxerec axe;
	// Axe STMR du projet
	private NSArray<EOAxerec> axeStmrList;
	private EOAxerec axeStmrRepetition;
	private EOAxerec selectedStmrAxe;

	// Pst du projet
	private NSArray<EOAxerec> pstList;
	private EOAxerec pstRepetition;
	private EOAxerec pst;
	// Liste des pst et Axe STMR
	private WODisplayGroup lesSTMR;
	private NSMutableArray lesAxesStmr;
	private EOAxerec axeStmr;
	// Autre programme du projet selectionne
	private NSArray<EOStructureUlr> equipeSecondaireList;
	private EOStructureUlr equipeSecondaireRepeat;
	private EOStructureUlr selectedEquipeSecondaire;
	private NSArray<EOStructureUlr> otherList;
	private EOStructureUlr otherRepetition;
	private WODisplayGroup autreEquipeDg;
	private NSMutableArray selectedEquipes;
	private NSMutableArray removedEquipes;
	// Gestion thematique
	private NSArray<EOTypthe> thematikList;
	private EOTypthe thematikRepetition;
	private EOTypthe selectedThematik;
	private NSArray<EORefthe> themeList;
	private EORefthe themeRepetition;
	private EORefthe selectedTheme;
	private NSArray<EORefthe> souThemeList;
	private EORefthe souThemeRepetition;
	private EORefthe selectedSouTheme;
	// Mots clés du projet
	private NSMutableArray selectedKeyword;
	private NSMutableArray removedKeyword;
	private EORefidx motClefs;
	private EORefidx motClefs1;
	private EORefidx motClefs2;
	private EORefidx motClef;
	private EORefidx motClef1;
	private EORefidx motClef2;
	private EORefidx motClef3;
	private EORefidx motClef4;
	private EORefidx motClef5;
	private EORefidx motClef6;
	private EORefidx motClef7;
	private EORefidx motClef8;
	private EORefidx motClef9;
	private EORefidx motClef10;
	private EORefidx motClef11;
	private NSMutableArray<EORefidx> motClefList;
	/** AutoComplete 1 **/
	private NSArray<EORefidx> listMotclefs;
	private EORefidx motClefsItem;
	private EORefidx selectedMotClefs;
	private NSArray<EORefidx> matchMotcClefs;
	/** AutoComplete 2 **/
	private NSArray<EORefidx> listMotclefs1;
	private EORefidx motClefsItem1;
	private EORefidx selectedMotClefs1;
	private NSArray<EORefidx> matchMotcClefs1;
	/** AutoComplete 3 **/
	private NSArray<EORefidx> listMotclefs2;
	private EORefidx motClefsItem2;
	private EORefidx selectedMotClefs2;
	private NSArray<EORefidx> matchMotcClefs2;
	/** Created mot clef **/
	private EORefidx lastCreateMotClef;
	/** Created Plateau technique **/
	private EOPfmateriel lastPlateau;
	/** Created Partenaire**/
	private EOTyppartenaire lastCreatedPartenaire;

	// Resumer
	private String contexte;
	private String problematik;
	private String objectifs;
	private String metho;
	// Thématique
	private String selectThematique;
	// Boolean things
	private boolean haveThmtk = false;
	private boolean hasOtherSelection = false;
	private boolean haveSTMR = false;
	private boolean haveNotSTMR = true;
	private boolean hasYesChecked = false;
	private String txImplication = "taux%";

	// Big ListTmpProject
	private NSArray bigListTmp;
	private ProjectListTampon bigTmpProject;

	// Les controleurs;
	public ProjectCtrl ctrlPrj;

	private Number idProjetRecent;

	// WODg mot clefs
	private WODisplayGroup matchDg1;
	private WODisplayGroup matchDg2;
	// Etablissement porteur?
	private String etabPorteur;
	// Porteurs
	private NSArray<EOVrhcmval> porteurList;
	private EOVrhcmval porteurRepetition;
	private EOVrhcmval porteur;
	// info Porteur
	private NSArray<EOVrhcmval> listInfoPole;
	private EOVrhcmval infoPorteurRepetition;
	private EOVrhcmval selectedInfoPorteur;

	// Page 2
	// Ressources humaines
	private WODisplayGroup personneDg;
	private EOPersonnel personRhRep;
	private EOPersonnel rh;
	private NSMutableArray selectedrhs;
	private NSMutableArray removedrhs;
	// Personnes a recruter
	private WODisplayGroup postesDg;
	private EOPosterh recrue;
	private String nouvoPostes;
	private NSMutableArray selectedRecrue;
	private NSMutableArray removedRecrue;
	// Recrutement
	private EOPosterh poleRecruRepetition;
	// Categorie recrutement
	private NSArray<EOVtyprhcm> listCategories;
	private EOVtyprhcm categItem;
	private EOVtyprhcm categSelect;
	// Matériels existant
	private WODisplayGroup poleMaterielsDg;
	private EOResmat matos;
	private EOResmat materielRep;
	private String matosExistant;
	private NSMutableArray selectedMaterielExistant;
	private NSMutableArray removedMaterielExistant;
	// Catégorie matériel (Plateau technique)
	private NSArray<EOPfmateriel> listCategMteriels;
	private EOPfmateriel categMatItem;
	private EOPfmateriel categMatSelect;
	private NSArray<EOPfmateriel> listCategMteriels0;
	private EOPfmateriel categMatItem0;
	private EOPfmateriel categMatSelect0;
	// Libelle Materiel (Grand équipement)
	private NSArray<EOGemateriel> listLibMateriels;
	private EOGemateriel libMaterielItem;
	private EOGemateriel libMaterielSelect;
	// Matériels a acquerir
	private WODisplayGroup materielsDg;
	private EOResmat poleNewMatRep;
	private EOResmat newMatos;
	private String nouvoMatos;
	private NSArray<EOGemateriel> listLibNewMat;
	private EOGemateriel libNewMatItem;
	private EOGemateriel libNewMatSelect;
	private NSMutableArray selectedMaterielAcquis;
	private NSMutableArray removedMaterielAcquis;
	// Commentaire des équipes secondaires
	private WODisplayGroup commentDg;
	private EOCommentaires commentRepetition;
	// Commentaire des poles
	private WODisplayGroup commentPoleDg;
	private EOCommentaires comentRepetition;
	private NSMutableArray poles;
	// Poles
	private WODisplayGroup poleDg;
	private NSArray<EOStructureUlr> poleList;
	private EOStructureUlr poleRepetition;
	private EOStructureUlr poleRhRepetition;
	private EOStructureUlr selectRhPole;
	private EOStructureUlr poleRecrueRepetition;
	private EOStructureUlr selectRecruePole;
	// Matériels
	private EOStructureUlr poleMatRepetition;
	private EOStructureUlr selectMatPole;
	private EOStructureUlr poleNewMatRepetition;
	private EOStructureUlr selectNewMatPole;
	// Projets
	private NSArray<EOPprec> listProjet;
	private EOPprec projetRepetition;
	private EOPprec selectedProjet;
	private EOTypref etatRepetition;
	private NSArray<EOTypref> listEtat1;
	private EOTypref etatRepetition1;
	private EOTypref selectedState;
	private EOIndividuUlr porteurRepetition1;
	private EOIndividuUlr selectedPorteur1;
	private EOStructureUlr equipeRepetition1;
	private EOStructureUlr selectedRechUnit1;
	private EOEquipes selectedEquipe1;
	// Personnes appartenant à un pole
	private WODisplayGroup listInPerson;
	private EOVrhcmval personRhRepetition;
	private EOVrhcmval selectRhPerson;
	private EOIndividuUlr personRecrueRepetition;
	private EOIndividuUlr selectRecruePerson;

	private String avisComPP;
	private String avisComPS;
	private String avisComDP;
	private NSTimestamp date;

	// Avis Projet
	private EOTypref avisRepPP;
	private EOTypref avisRespSec;
	private EOTypref avisDrt;
	private EOTypref avisICD;
	// Validation ICD
	private NSTimestamp dateIcd;
	private NSArray<EOTypref> listIcd;
	private EOTypref listIcdItem;
	private EOTypref listIcdSelect;
	// Bloc comm
	private String blocCom;
	// Commentaires Proles
	private EOStructureUlr itemPole;
	private EOStructureUlr selectedPole1;
	private Application app = null;
	private Boolean isUpdate = null;
	private NSMutableArray myPoles;
	private EOStructureUlr poleDeCompetence;
	private EOStructureUlr commentairePoles;

	// Projet
	public static final String BDG_projet = "projet";
	private EOPprec projet;

	// Filtres
	private WODisplayGroup filtreProjetFacade;
	private WODisplayGroup filtreEtat;
	private WODisplayGroup filtreProjet;
	private WODisplayGroup filtrePorteur;
	private WODisplayGroup filtreContrat;
	private WODisplayGroup filtreEquipe;
	private NSMutableDictionary<String, Object> filtres;
	private NSMutableDictionary<String, Object> eCfiltres;

	// Acceuil par defaut
	private WOComponent myHome;
	private String pageName;
	private NSMutableDictionary myEnv;

	// DAaction param
	private NSDictionary actionParams;

	public Session() {
		super();
		// sauvegarde des IDs de session dans un cookie
		setStoresIDsInURLs(false);
		setStoresIDsInCookies(true);
		// Initialisation du theme applique a toutes les fenetres gerees via
		// CktlAjaxModalDialog
		setWindowsClassName(CktlAjaxWindow.WINDOWS_CLASS_NAME_GREYLIGHTING);
		// personneDg = new WODisplayGroup<EOIndividuUlr>();
	}

	/**
	 * @return the noIndividu
	 */
	public Integer noIndividu() {
		return noIndividu;
	}

	/**
	 * @param noIndividu
	 *            the noIndividu to set
	 */
	public void setNoIndividu(Integer noIndividu) {
		this.noIndividu = noIndividu;
	}

	/**
	 * @return the actionParams
	 */
	public NSDictionary getActionParams() {
		return actionParams;
	}

	/**
	 * @param actionParams
	 *            the actionParams to set
	 */
	public void setActionParams(NSDictionary actionParams) {
		this.actionParams = actionParams;
	}

	/**
	 * @return the isUpdate
	 */
	public Boolean update() {
		return isUpdate;
	}

	/**
	 * @return the myPoles
	 */
	public NSMutableArray myPoles() {
		if (myPoles == null)
			myPoles = new NSMutableArray();
		return myPoles;
	}

	/**
	 * @param myPoles
	 *            the myPoles to set
	 */
	public void setMyPoles(NSMutableArray myPoles) {
		this.myPoles = myPoles;
	}

	/**
	 * @param isUpdate
	 *            the isUpdate to set
	 */
	public void setUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public void resetModule() {
		if (defaultEditingContext() != null) {
			defaultEditingContext().revert();
			setIndexModuleActifGestionProjet(null);
		}
	}

	/**
	 * @return the applicationGDUser
	 */
	public PPrecApplicationUser applicationGDUser() {
		if (applicationGDUser == null) {
			Integer perId = MonComposant.PERS_ID;
			if (perId != 0)
				applicationGDUser = new PPrecApplicationUser(
						MonComposant.PERS_ID);
		}
		return applicationGDUser;
	}

	/**
	 * @param applicationGDUser
	 *            the applicationGDUser to set
	 */
	public void setApplicationGDUser(PPrecApplicationUser applicationGDUser) {
		this.applicationGDUser = applicationGDUser;
	}

	/**
	 * @return the applicationJAUser
	 */
	public EnseignantApplicationUser applicationJAUser() {
		if (applicationJAUser == null) {
			Integer perId = MonComposant.PERS_ID;
			if (perId != 0)
				applicationJAUser = new EnseignantApplicationUser(
						ERXEC.newEditingContext(), Application.TYPE_APP_STR,
						MonComposant.PERS_ID);
		}
		return applicationJAUser;
	}

	/**
	 * @param applicationJAUser
	 *            the applicationJAUser to set
	 */
	public void setApplicationJAUser(EnseignantApplicationUser applicationJAUser) {
		this.applicationJAUser = applicationJAUser;
	}

	/**
	 * @return the utilisateur
	 */
	public EOUtilisateur utilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur
	 *            the utilisateur to set
	 */
	public void setUtilisateur(EOUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
		// NSLog.out.appendln("Instance Utilisateur - "+utilisateur);
	}

	@Override
	public void awake() {
		super.awake();
		if (app().newGestionDroitsEnabled()) {
			if (applicationGDUser != null)
				ERXThreadStorage.takeValueForKey(applicationGDUser.getPersId(),
						PPrecApplicationUser.PERS_ID_CURRENT_USER_STORAGE_KEY);
		} else {
			if (applicationJAUser != null)
				ERXThreadStorage
						.takeValueForKey(
								applicationJAUser.getPersId(),
								EnseignantApplicationUser.PERS_ID_CURRENT_USER_STORAGE_KEY);
		}
	}

	public String setConnectedUser(String arg0) {
		String str = super.setConnectedUser(arg0);
		if (connectedUserInfo() != null) {
			if (connectedUserInfo().email() != null) {
				if (((Application) WOApplication.application()).utilisateurs()
						.indexOfIdenticalObject(connectedUserInfo().email()) == NSArray.NotFound)
					((Application) WOApplication.application()).utilisateurs()
							.addObject(connectedUserInfo().email());
				System.out.println("----Connexion de "
						+ connectedUserInfo().nomEtPrenom() + " (noIndividu ="
						+ connectedUserInfo().noIndividu() + ") le "
						+ (new NSTimestamp()) + " depuis IP : "
						+ cktlApp.getRequestIPAddress(context().request()));
			} else {
				str = "Veuillez renseigner votre adresse email avant de vous connecter.";
			}
		}

		return str;
	}

	public Application app() {
		if (app == null)
			app = Application.app();
		return app;
	}

	/**
	 * @return the projet
	 */
	public EOPprec projet() {
		return projet;
	}

	/**
	 * @param projet
	 *            the projet to set
	 */
	public void setProjet(EOPprec projet) {
		this.projet = projet;
	}

	public EOEditingContext editingContext() {
		if (editingContext == null)
			editingContext = ERXEC.newEditingContext();
		return editingContext;
	}

	/**
	 * @return the alertMessage
	 */
	public String getAlertMessage() {
		return alertMessage;
	}

	/**
	 * @param alertMessage
	 *            the alertMessage to set
	 */
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	/**
	 * @return the messageErreur
	 */
	public String getMessageErreur() {
		return messageErreur;
	}

	/**
	 * @param messageErreur
	 *            the messageErreur to set
	 */
	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

	public WOActionResults onQuitter() {
		terminate();
		return goToMainSite();
	}

	public EOEditingContext nestedEdc() {
		return nestedEdc;
	}

	/**
	 * @return the selectedKeyword
	 */
	public NSMutableArray selectedKeyword() {
		if (selectedKeyword == null) {
			EOPprec projet = projet();
			if (projet != null) {
				selectedKeyword = new NSMutableArray();
				NSArray<EOMotclefs> motCleList = EOMotclefs.keywordsPourPorjet(
						ERXEC.newEditingContext(), projet);
				for (EOMotclefs motclef : motCleList) {
					selectedKeyword.addObject(motclef.toRefidx());
				}
			} else {
				selectedKeyword = new NSMutableArray();
			}
		}
		return selectedKeyword;
	}

	/**
	 * @param selectedKeyword
	 *            the selectedKeyword to set
	 */
	public void setSelectedKeyword(NSMutableArray selectedKeyword) {
		this.selectedKeyword = selectedKeyword;
	}

	/**
	 * @return the removedKeyword
	 */
	public NSMutableArray removedKeyword() {
		if (removedKeyword == null)
			removedKeyword = new NSMutableArray();
		return removedKeyword;
	}

	/**
	 * @param removedKeyword
	 *            the removedKeyword to set
	 */
	public void setRemovedKeyword(NSMutableArray removedKeyword) {
		this.removedKeyword = removedKeyword;
	}

	/**
	 * @return the selectedEquipes
	 */
	public NSMutableArray selectedEquipes() {
		if (selectedEquipes == null) {
			EOPprec projet = projet();
			if (projet != null) {
				selectedEquipes = new NSMutableArray();
				for (EOEquipes equipe : repartEquipe()) {
					EOStructureUlr str = EOStructureUlr
							.structurePourcStructure(ERXEC.newEditingContext(),
									equipe.cStructure());
					if (!selectedEquipes.contains(str))
						selectedEquipes.addObject(str);
				}
			} else {
				selectedEquipes = new NSMutableArray();
			}
		}
		return selectedEquipes;
	}

	public NSArray<EOEquipes> repartEquipe() {
		NSArray<EOEquipes> equipes = new NSArray<EOEquipes>();
		EOPprec projet = projet();
		if (projet != null)
			equipes = EOEquipes.fetchEOEquipeses(
					projet().editingContext(),
					EOEquipes.TO_PROJET.eq(projet)
							.and(EOEquipes.PRINCIPALE.eq("N"))
							.and(EOEquipes.TEMVALIDE.eq("O")), null);
		return equipes;
	}

	/**
	 * @param selectedEquipes
	 *            the selectedEquipes to set
	 */
	public void setSelectedEquipes(NSMutableArray selectedEquipes) {
		this.selectedEquipes = selectedEquipes;
	}

	/**
	 * @return the removedEquipes
	 */
	public NSMutableArray removedEquipes() {
		if (removedEquipes == null)
			removedEquipes = new NSMutableArray();
		return removedEquipes;
	}

	/**
	 * @param removedEquipes
	 *            the removedEquipes to set
	 */
	public void setRemovedEquipes(NSMutableArray removedEquipes) {
		this.removedEquipes = removedEquipes;
	}

	public void setNestedEdc(EOEditingContext nestedEdc) {
		if (this.nestedEdc != null && this.nestedEdc != nestedEdc) {
			this.nestedEdc.dispose();
		}
		this.nestedEdc = nestedEdc;
	}

	/**
	 * @return the leProjetEnCours
	 */
	public EOPprec leProjetEnCours() {
		return leProjetEnCours;
	}

	/**
	 * @param leProjetEnCours
	 *            the leProjetEnCours to set
	 */
	public void setLeProjetEnCours(EOPprec leProjetEnCours) {
		this.leProjetEnCours = leProjetEnCours;
	}

	/**
	 * @return the haveThmtk
	 */
	public boolean isHaveThmtk() {
		return haveThmtk;
	}

	/**
	 * @param haveThmtk
	 *            the haveThmtk to set
	 */
	public void setHaveThmtk(boolean haveThmtk) {
		this.haveThmtk = haveThmtk;
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

	/**
	 * @return the hasThematik
	 */
	public boolean isHasThematik() {
		if (getSelectThematique() == null) {
			return false;
		} else if (getSelectThematique().equals("O")) {
			return getSelectThematique().equals("O");
		}
		return getSelectThematique().equals("O");
	}

	/**
	 * @return the selectedContrat1
	 */
	public EOTypcontrat getSelectedContrat1() {
		return selectedContrat1;
	}

	/**
	 * @param selectedContrat1
	 *            the selectedContrat1 to set
	 */
	public void setSelectedContrat1(EOTypcontrat selectedContrat1) {
		this.selectedContrat1 = selectedContrat1;
	}

	/**
	 * @return the stContratList
	 */
	public NSArray<EOTypcontrat> getStContratList() {
		return stContratList;
	}

	/**
	 * @param stContratList
	 *            the stContratList to set
	 */
	public void setStContratList(NSArray<EOTypcontrat> stContratList) {
		this.stContratList = stContratList;
	}

	/**
	 * @return the stContratItem
	 */
	public EOTypcontrat getStContratItem() {
		return stContratItem;
	}

	/**
	 * @param stContratItem
	 *            the stContratItem to set
	 */
	public void setStContratItem(EOTypcontrat stContratItem) {
		this.stContratItem = stContratItem;
	}

	/**
	 * @return the stContratSelected
	 */
	public EOTypcontrat getStContratSelected() {
		return stContratSelected;
	}

	/**
	 * @param stContratSelected
	 *            the stContratSelected to set
	 */
	public void setStContratSelected(EOTypcontrat stContratSelected) {
		this.stContratSelected = stContratSelected;
		EOPprec projet = projet();
		if (stContratSelected != null) {
			if (projet != null) {
				projet.setToContratRelationship(stContratSelected
						.localInstanceIn(projet.editingContext()));
			}
		}
	}

	/**
	 * @return the applicationUser
	 */
	public PPrecApplicationUser getApplicationUser() {
		return applicationGDUser;
	}

	// Les filtres

	/**
	 * @return the filtreProjetFacade
	 */
	public WODisplayGroup getFiltreProjetFacade() {
		if (filtreProjetFacade == null)
			filtreProjetFacade = new WODisplayGroup();
		return filtreProjetFacade;
	}

	/**
	 * @param filtreProjetFacade
	 *            the filtreProjetFacade to set
	 */
	public void setFiltreProjetFacade(WODisplayGroup filtreProjetFacade) {
		this.filtreProjetFacade = filtreProjetFacade;
	}

	/**
	 * @return the filtreEtat
	 */
	public WODisplayGroup getFiltreEtat() {
		if (filtreEtat == null)
			filtreEtat = new WODisplayGroup();
		return filtreEtat;
	}

	/**
	 * @param filtreEtat
	 *            the filtreEtat to set
	 */
	public void setFiltreEtat(WODisplayGroup filtreEtat) {
		this.filtreEtat = filtreEtat;
	}

	/**
	 * @return the filtreProjet
	 */
	public WODisplayGroup getFiltreProjet() {
		if (filtreProjet == null)
			filtreProjet = new WODisplayGroup();
		return filtreProjet;
	}

	/**
	 * @param filtreProjet
	 *            the filtreProjet to set
	 */
	public void setFiltreProjet(WODisplayGroup filtreProjet) {
		this.filtreProjet = filtreProjet;
	}

	/**
	 * @return the filtrePorteur
	 */
	public WODisplayGroup getFiltrePorteur() {
		if (filtrePorteur == null)
			filtrePorteur = new WODisplayGroup();
		return filtrePorteur;
	}

	/**
	 * @param filtrePorteur
	 *            the filtrePorteur to set
	 */
	public void setFiltrePorteur(WODisplayGroup filtrePorteur) {
		this.filtrePorteur = filtrePorteur;
	}

	/**
	 * @return the filtreContrat
	 */
	public WODisplayGroup getFiltreContrat() {
		if (filtreContrat == null)
			filtreContrat = new WODisplayGroup();
		return filtreContrat;
	}

	/**
	 * @param filtreContrat
	 *            the filtreContrat to set
	 */
	public void setFiltreContrat(WODisplayGroup filtreContrat) {
		this.filtreContrat = filtreContrat;
	}

	/**
	 * @return the filtreEquipe
	 */
	public WODisplayGroup getFiltreEquipe() {
		if (filtreEquipe == null)
			filtreEquipe = new WODisplayGroup();
		return filtreEquipe;
	}

	/**
	 * @param filtreEquipe
	 *            the filtreEquipe to set
	 */
	public void setFiltreEquipe(WODisplayGroup filtreEquipe) {
		this.filtreEquipe = filtreEquipe;
	}

	/**
	 * @return the poleDg
	 */
	public WODisplayGroup poleDg() {
		if (poleDg == null)
			poleDg = new WODisplayGroup();
		return poleDg;
	}

	/**
	 * @param poleDg
	 *            the poleDg to set
	 */
	public void setPoleDg(WODisplayGroup poleDg) {
		this.poleDg = poleDg;
	}

	/**
	 * @return the poleList
	 */
	public NSArray<EOStructureUlr> getPoleList() {
		return poleList;
	}

	/**
	 * @param poleList
	 *            the poleList to set
	 */
	public void setPoleList(NSArray<EOStructureUlr> poleList) {
		this.poleList = poleList;
	}

	/**
	 * @return the poleRepetition
	 */
	public EOStructureUlr getPoleRepetition() {
		return poleRepetition;
	}

	/**
	 * @param poleRepetition
	 *            the poleRepetition to set
	 */
	public void setPoleRepetition(EOStructureUlr poleRepetition) {
		this.poleRepetition = poleRepetition;
	}

	/**
	 * @return the poleRhRepetition
	 */
	public EOStructureUlr getPoleRhRepetition() {
		return poleRhRepetition;
	}

	/**
	 * @param poleRhRepetition
	 *            the poleRhRepetition to set
	 */
	public void setPoleRhRepetition(EOStructureUlr poleRhRepetition) {
		this.poleRhRepetition = poleRhRepetition;
	}

	/**
	 * @return the selectRhPole
	 */
	public EOStructureUlr getSelectRhPole() {
		return selectRhPole;
	}

	/**
	 * @param selectRhPole
	 *            the selectRhPole to set
	 */
	public void setSelectRhPole(EOStructureUlr selectRhPole) {
		this.selectRhPole = selectRhPole;
	}

	/**
	 * @return the poleRhRepetition
	 */
	public EOStructureUlr getPoleRecrueRepetition() {
		return poleRecrueRepetition;
	}

	/**
	 * @param poleRhRepetition
	 *            the poleRhRepetition to set
	 */
	public void setPoleRecrueRepetition(EOStructureUlr poleRecrueRepetition) {
		this.poleRecrueRepetition = poleRecrueRepetition;
	}

	/**
	 * @return the selectRecruePole
	 */
	public EOStructureUlr getSelectRecruePole() {
		return selectRecruePole;
	}

	/**
	 * @param selectRecruePole
	 *            the selectRecruePole to set
	 */
	public void setSelectRecruePole(EOStructureUlr selectRecruePole) {
		this.selectRecruePole = selectRecruePole;
	}

	/**
	 * @return the poleRecruRepetition
	 */
	public EOPosterh getPoleRecruRepetition() {
		return poleRecruRepetition;
	}

	/**
	 * @param poleRecruRepetition
	 *            the poleRecruRepetition to set
	 */
	public void setPoleRecruRepetition(EOPosterh poleRecruRepetition) {
		this.poleRecruRepetition = poleRecruRepetition;
	}

	/**
	 * @return the poleNewMatRep
	 */
	public EOResmat getPoleNewMatRep() {
		return poleNewMatRep;
	}

	/**
	 * @param poleNewMatRep
	 *            the poleNewMatRep to set
	 */
	public void setPoleNewMatRep(EOResmat poleNewMatRep) {
		this.poleNewMatRep = poleNewMatRep;
	}

	/**
	 * @return the poleMatRepetition
	 */
	public EOStructureUlr getPoleMatRepetition() {
		return poleMatRepetition;
	}

	/**
	 * @param poleMatRepetition
	 *            the poleMatRepetition to set
	 */
	public void setPoleMatRepetition(EOStructureUlr poleMatRepetition) {
		this.poleMatRepetition = poleMatRepetition;
	}

	/**
	 * @return the selectMatPole
	 */
	public EOStructureUlr getSelectMatPole() {
		return selectMatPole;
	}

	/**
	 * @param selectMatPole
	 *            the selectMatPole to set
	 */
	public void setSelectMatPole(EOStructureUlr selectMatPole) {
		this.selectMatPole = selectMatPole;
	}

	/**
	 * @return the selectNewMatPole
	 */
	public EOStructureUlr getSelectNewMatPole() {
		return selectNewMatPole;
	}

	/**
	 * @param selectNewMatPole
	 *            the selectNewMatPole to set
	 */
	public void setSelectNewMatPole(EOStructureUlr selectNewMatPole) {
		this.selectNewMatPole = selectNewMatPole;
	}

	/**
	 * @return the poleNewMatRepetition
	 */
	public EOStructureUlr getPoleNewMatRepetition() {
		return poleNewMatRepetition;
	}

	/**
	 * @param poleNewMatRepetition
	 *            the poleNewMatRepetition to set
	 */
	public void setPoleNewMatRepetition(EOStructureUlr poleNewMatRepetition) {
		this.poleNewMatRepetition = poleNewMatRepetition;
	}

	/**
	 * @return the personneDg
	 */
	public WODisplayGroup personneDg() {
		if (personneDg == null) {
			personneDg = new WODisplayGroup();
			personneDg.setObjectArray(selectedrhs().immutableClone());
			if (personneDg.batchCount() == 0)
				personneDg.setNumberOfObjectsPerBatch(5);
		}
		return personneDg;
	}

	/**
	 * @param personneDg
	 *            the personneDg to set
	 */
	public void setPersonneDg(WODisplayGroup personneDg) {
		this.personneDg = personneDg;
	}

	/**
	 * @return the postesDg
	 */
	public WODisplayGroup postesDg() {
		if (postesDg == null) {
			postesDg = new WODisplayGroup();
			postesDg.setObjectArray(selectedRecrue().immutableClone());
			if (postesDg.batchCount() == 0)
				postesDg.setNumberOfObjectsPerBatch(5);
		}
		return postesDg;
	}

	/**
	 * @param postesDg
	 *            the postesDg to set
	 */
	public void setPostesDg(WODisplayGroup postesDg) {
		this.postesDg = postesDg;
	}

	/**
	 * @return the commentDg
	 */
	public WODisplayGroup commentDg() {
		if (commentDg == null)
			commentDg = new WODisplayGroup();
		return commentDg;
	}

	/**
	 * @param commentDg
	 *            the commentDg to set
	 */
	public void setCommentDg(WODisplayGroup commentDg) {
		this.commentDg = commentDg;
	}

	/**
	 * @return the poleRepetition
	 */

	/**
	 * @return the commentRepetition
	 */
	public EOCommentaires getCommentRepetition() {
		return commentRepetition;
	}

	/**
	 * @param commentRepetition
	 *            the commentRepetition to set
	 */
	public void setCommentRepetition(EOCommentaires commentRepetition) {
		this.commentRepetition = commentRepetition;
	}

	/**
	 * @return the commentPoleDg
	 */
	public WODisplayGroup commentPoleDg() {
		if (commentPoleDg == null)
			commentPoleDg = new WODisplayGroup();
		return commentPoleDg;
	}

	/**
	 * @param commentPoleDg
	 *            the commentPoleDg to set
	 */
	public void setCommentPoleDg(WODisplayGroup commentPoleDg) {
		this.commentPoleDg = commentPoleDg;
	}

	/**
	 * @return the comentRepetition
	 */
	public EOCommentaires getComentRepetition() {
		return comentRepetition;
	}

	/**
	 * @param comentRepetition
	 *            the comentRepetition to set
	 */
	public void setComentRepetition(EOCommentaires comentRepetition) {
		this.comentRepetition = comentRepetition;
	}

	/**
	 * @return the listInPerson
	 */
	public WODisplayGroup listInPerson() {
		if (listInPerson == null)
			listInPerson = new WODisplayGroup();
		return listInPerson;
	}

	/**
	 * @param listInPerson
	 *            the listInPerson to set
	 */
	public void setListInPerson(WODisplayGroup listInPerson) {
		this.listInPerson = listInPerson;
	}

	/**
	 * @return the personRepetition
	 */
	public EOVrhcmval getPersonRhRepetition() {
		return personRhRepetition;
	}

	/**
	 * @param personRepetition
	 *            the personRepetition to set
	 */
	public void setPersonRhRepetition(EOVrhcmval personRepetition) {
		this.personRhRepetition = personRepetition;
	}

	/**
	 * @return the personRhRep
	 */
	public EOPersonnel getPersonRhRep() {
		return personRhRep;
	}

	/**
	 * @param personRhRep
	 *            the personRhRep to set
	 */
	public void setPersonRhRep(EOPersonnel personRhRep) {
		this.personRhRep = personRhRep;
	}

	/**
	 * @return the selectRhPerson
	 */
	public EOVrhcmval getSelectRhPerson() {
		return selectRhPerson;
	}

	/**
	 * @param selectRhPerson
	 *            the selectRhPerson to set
	 */
	public void setSelectRhPerson(EOVrhcmval selectRhPerson) {
		this.selectRhPerson = selectRhPerson;
	}

	/**
	 * @return the personRecrueRepetition
	 */
	public EOIndividuUlr getPersonRecrueRepetition() {
		return personRecrueRepetition;
	}

	/**
	 * @param personRecrueRepetition
	 *            the personRecrueRepetition to set
	 */
	public void setPersonRecrueRepetition(EOIndividuUlr personRecrueRepetition) {
		this.personRecrueRepetition = personRecrueRepetition;
	}

	/**
	 * @return the selectRecruePerson
	 */
	public EOIndividuUlr getSelectRecruePerson() {
		return selectRecruePerson;
	}

	/**
	 * @param selectRecruePerson
	 *            the selectRecruePerson to set
	 */
	public void setSelectRecruePerson(EOIndividuUlr selectRecruePerson) {
		this.selectRecruePerson = selectRecruePerson;
	}

	/**
	 * @return the nouvoMatos
	 */
	public String getNouvoMatos() {
		return nouvoMatos;
	}

	/**
	 * @param nouvoMatos
	 *            the nouvoMatos to set
	 */
	public void setNouvoMatos(String nouvoMatos) {
		this.nouvoMatos = nouvoMatos;
	}

	/**
	 * @param nouvoPostes
	 *            the nouvoPostes to set
	 */
	public void setNouvoPostes(String nouvoPostes) {
		this.nouvoPostes = nouvoPostes;
	}

	/**
	 * @return the nouvoPostes
	 */
	public String getNouvoPostes() {
		return nouvoPostes;
	}

	/**
	 * @return the materielsDg
	 */
	public WODisplayGroup materielsDg() {
		if (materielsDg == null) {
			materielsDg = new WODisplayGroup();
			materielsDg.setObjectArray(selectedMaterielAcquis()
					.immutableClone());
			if (materielsDg.batchCount() == 0)
				materielsDg.setNumberOfObjectsPerBatch(5);
		}
		return materielsDg;
	}

	/**
	 * @param materielsDg
	 *            the materielsDg to set
	 */
	public void setMaterielsDg(WODisplayGroup materielsDg) {
		this.materielsDg = materielsDg;
	}

	/**
	 * @return the avisComPP
	 */
	public String getAvisComPP() {
		return avisComPP;
	}

	/**
	 * @param avisComPP
	 *            the avisComPP to set
	 */
	public void setAvisComPP(String avisComPP) {
		this.avisComPP = avisComPP;
	}

	/**
	 * @return the avisComPS
	 */
	public String getAvisComPS() {
		return avisComPS;
	}

	/**
	 * @param avisComPS
	 *            the avisComPS to set
	 */
	public void setAvisComPS(String avisComPS) {
		this.avisComPS = avisComPS;
	}

	/**
	 * @return the avisComDP
	 */
	public String getAvisComDP() {
		return avisComDP;
	}

	/**
	 * @param avisComDP
	 *            the avisComDP to set
	 */
	public void setAvisComDP(String avisComDP) {
		this.avisComDP = avisComDP;
	}

	/**
	 * @return the date
	 */
	public NSTimestamp getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(NSTimestamp date) {
		this.date = date;
	}

	/**
	 * @return the nomCourt
	 */
	public String getNomCourt() {
		return nomCourt;
	}

	/**
	 * @param nomCourt
	 *            the nomCourt to set
	 */
	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt.trim().replace(" ", "-");
	}

	/**
	 * @return the nomLong
	 */
	public String getNomLong() {
		return nomLong;
	}

	/**
	 * @param nomLong
	 *            the nomLong to set
	 */
	public void setNomLong(String nomLong) {
		this.nomLong = nomLong.trim().replace(" ", "-");
	}

	/**
	 * @return the selectThematique
	 */
	public String getSelectThematique() {
		return selectThematique;
	}

	/**
	 * @param selectThematique
	 *            the selectThematique to set
	 */
	public void setSelectThematique(String selectThematique) {
		this.selectThematique = selectThematique;
	}

	/**
	 * @return the dateDebut
	 */
	public NSTimestamp getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut
	 *            the dateDebut to set
	 */
	public void setDateDebut(NSTimestamp dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateIcd
	 */
	public NSTimestamp getDateIcd() {
		return dateIcd;
	}

	/**
	 * @param dateIcd
	 *            the dateIcd to set
	 */
	public void setDateIcd(NSTimestamp dateIcd) {
		this.dateIcd = dateIcd;
	}

	/**
	 * @return the listIcd
	 */
	public NSArray<EOTypref> getListIcd() {
		return listIcd;
	}

	/**
	 * @param listIcd
	 *            the listIcd to set
	 */
	public void setListIcd(NSArray<EOTypref> listIcd) {
		this.listIcd = listIcd;
	}

	/**
	 * @return the listIcdItem
	 */
	public EOTypref getListIcdItem() {
		return listIcdItem;
	}

	/**
	 * @param listIcdItem
	 *            the listIcdItem to set
	 */
	public void setListIcdItem(EOTypref listIcdItem) {
		this.listIcdItem = listIcdItem;
	}

	/**
	 * @return the listIcdSelect
	 */
	public EOTypref getListIcdSelect() {
		return listIcdSelect;
	}

	/**
	 * @param listIcdSelect
	 *            the listIcdSelect to set
	 */
	public void setListIcdSelect(EOTypref listIcdSelect) {
		this.listIcdSelect = listIcdSelect;
	}

	/**
	 * @return the dureeProjet
	 */
	public String getDureeProjet() {
		return dureeProjet;
	}

	/**
	 * @param dureeProjet
	 *            the dureeProjet to set
	 */
	public void setDureeProjet(String dureeProjet) {
		this.dureeProjet = dureeProjet;
	}

	/**
	 * @return the motClefs
	 */
	public EORefidx getMotClefs() {
		return motClefs;
	}

	/**
	 * @param motClefs
	 *            the motClefs to set
	 */
	public void setMotClefs(EORefidx motClefs) {
		this.motClefs = motClefs;
	}

	/**
	 * @return the motClefs1
	 */
	public EORefidx getMotClefs1() {
		return motClefs1;
	}

	/**
	 * @param motClefs1
	 *            the motClefs1 to set
	 */
	public void setMotClefs1(EORefidx motClefs1) {
		this.motClefs1 = motClefs1;
	}

	/**
	 * @return the motClefs2
	 */
	public EORefidx getMotClefs2() {
		return motClefs2;
	}

	/**
	 * @param motClefs2
	 *            the motClefs2 to set
	 */
	public void setMotClefs2(EORefidx motClefs2) {
		this.motClefs2 = motClefs2;
		matchMotcClefs2 = null;
	}

	/**
	 * @return the motClef
	 */
	public EORefidx getMotClef() {
		return motClef;
	}

	/**
	 * @param motClef
	 *            the motClef to set
	 */
	public void setMotClef(EORefidx motClef) {
		this.motClef = motClef;
	}

	/**
	 * @return the motClef1
	 */
	public EORefidx getMotClef1() {
		return motClef1;
	}

	/**
	 * @param motClef1
	 *            the motClef1 to set
	 */
	public void setMotClef1(EORefidx motClef1) {
		this.motClef1 = motClef1;
	}

	/**
	 * @return the motClef2
	 */
	public EORefidx getMotClef2() {
		return motClef2;
	}

	/**
	 * @param motClef2
	 *            the motClef2 to set
	 */
	public void setMotClef2(EORefidx motClef2) {
		this.motClef2 = motClef2;
	}

	/**
	 * @return the motClef3
	 */
	public EORefidx getMotClef3() {
		return motClef3;
	}

	/**
	 * @param motClef3
	 *            the motClef3 to set
	 */
	public void setMotClef3(EORefidx motClef3) {
		this.motClef3 = motClef3;
	}

	/**
	 * @return the motClef4
	 */
	public EORefidx getMotClef4() {
		return motClef4;
	}

	/**
	 * @param motClef4
	 *            the motClef4 to set
	 */
	public void setMotClef4(EORefidx motClef4) {
		this.motClef4 = motClef4;
	}

	/**
	 * @return the motClef5
	 */
	public EORefidx getMotClef5() {
		return motClef5;
	}

	/**
	 * @param motClef5
	 *            the motClef5 to set
	 */
	public void setMotClef5(EORefidx motClef5) {
		this.motClef5 = motClef5;
	}

	/**
	 * @return the motClef6
	 */
	public EORefidx getMotClef6() {
		return motClef6;
	}

	/**
	 * @param motClef6
	 *            the motClef6 to set
	 */
	public void setMotClef6(EORefidx motClef6) {
		this.motClef6 = motClef6;
	}

	/**
	 * @return the motClef7
	 */
	public EORefidx getMotClef7() {
		return motClef7;
	}

	/**
	 * @param motClef7
	 *            the motClef7 to set
	 */
	public void setMotClef7(EORefidx motClef7) {
		this.motClef7 = motClef7;
	}

	/**
	 * @return the motClef8
	 */
	public EORefidx getMotClef8() {
		return motClef8;
	}

	/**
	 * @param motClef8
	 *            the motClef8 to set
	 */
	public void setMotClef8(EORefidx motClef8) {
		this.motClef8 = motClef8;
	}

	/**
	 * @return the motClef9
	 */
	public EORefidx getMotClef9() {
		return motClef9;
	}

	/**
	 * @param motClef9
	 *            the motClef9 to set
	 */
	public void setMotClef9(EORefidx motClef9) {
		this.motClef9 = motClef9;
	}

	/**
	 * @return the motClef10
	 */
	public EORefidx getMotClef10() {
		return motClef10;
	}

	/**
	 * @param motClef10
	 *            the motClef10 to set
	 */
	public void setMotClef10(EORefidx motClef10) {
		this.motClef10 = motClef10;
	}

	/**
	 * @return the motClef11
	 */
	public EORefidx getMotClef11() {
		return motClef11;
	}

	/**
	 * @param motClef11
	 *            the motClef11 to set
	 */
	public void setMotClef11(EORefidx motClef11) {
		this.motClef11 = motClef11;
	}

	/**
	 * @return the motClefList
	 */
	public NSMutableArray<EORefidx> getMotClefList() {
		return motClefList;
	}

	/**
	 * @param motClefList
	 *            the motClefList to set
	 */
	public void setMotClefList(NSMutableArray<EORefidx> motClefList) {
		this.motClefList = motClefList;
	}

	/**
	 * @return the selectedMotClefs
	 */
	public EORefidx getSelectedMotClefs() {
		return selectedMotClefs;
	}

	/**
	 * @param selectedMotClefs
	 *            the selectedMotClefs to set
	 */
	public void setSelectedMotClefs(EORefidx selectedMotClefs) {
		this.selectedMotClefs = selectedMotClefs;
	}

	/**
	 * Générateur de la liste du module de recherche
	 * */
	private NSArray<EORefidx> lesMotsClefs() {
		listMotclefs = null;
		if (listMotclefs == null) {
			listMotclefs = EORefidx.fetchGetMotsClefsParents(editingContext());
		}
		listMotclefs1 = null;
		return listMotclefs.immutableClone();
	}

	public NSArray<EORefidx> lesMotsClefs1() {
		if (listMotclefs1 == null) {
			listMotclefs1 = EORefidx.fetchGetMotClefs(editingContext(),
					Integer.valueOf(selectedMotClefs.primaryKey()));
		}
		listMotclefs2 = null;
		return listMotclefs1.immutableClone();
	}

	public NSArray<EORefidx> lesMotsClefs2() {
		if (listMotclefs2 == null) {
			listMotclefs2 = EORefidx.fetchGetMotClefs(editingContext(),
					Integer.valueOf(motClefsItem1.primaryKey()));
		}
		return listMotclefs2.immutableClone();
	}

	/**
	 * Fin du générateur de la liste du module de recherche
	 * */

	/**
	 * @return the listMotclefs
	 */
	public NSArray<EORefidx> getListMotclefs() {
		return listMotclefs;
	}

	/**
	 * @param listMotclefs
	 *            the listMotclefs to set
	 */
	public void setListMotclefs(NSArray<EORefidx> listMotclefs) {
		this.listMotclefs = listMotclefs;
	}

	/**
	 * @return the motClefsRepetition
	 */
	public EORefidx getMotClefsItem() {
		return motClefsItem;
	}

	/**
	 * @param motClefsRepetition
	 *            the motClefsRepetition to set
	 */
	public void setMotClefsItem(EORefidx motClefsRepetition) {
		this.motClefsItem = motClefsRepetition;
	}

	/**
	 * @return the listMotclefs1
	 */
	public NSArray<EORefidx> getListMotclefs1() {
		return listMotclefs1;
	}

	/**
	 * @param listMotclefs1
	 *            the listMotclefs1 to set
	 */
	public void setListMotclefs1(NSArray<EORefidx> listMotclefs1) {
		this.listMotclefs1 = listMotclefs1;
	}

	/**
	 * @return the motClefsRepetition1
	 */
	public EORefidx getMotClefsItem1() {
		return motClefsItem1;
	}

	/**
	 * @param motClefsRepetition1
	 *            the motClefsRepetition1 to set
	 */
	public void setMotClefsItem1(EORefidx motClefsRepetition1) {
		this.motClefsItem1 = motClefsRepetition1;
	}

	/**
	 * @return the selectedMotClefs1
	 */
	public EORefidx getSelectedMotClefs1() {
		return selectedMotClefs1;
	}

	/**
	 * @param selectedMotClefs1
	 *            the selectedMotClefs1 to set
	 */
	public void setSelectedMotClefs1(EORefidx selectedMotClefs1) {
		this.selectedMotClefs1 = selectedMotClefs1;
	}

	/**
	 * @return the listMotclefs2
	 */
	public NSArray<EORefidx> getListMotclefs2() {
		return listMotclefs2;
	}

	/**
	 * @param listMotclefs2
	 *            the listMotclefs2 to set
	 */
	public void setListMotclefs2(NSArray<EORefidx> listMotclefs2) {
		this.listMotclefs2 = listMotclefs2;
	}

	/**
	 * @return the motClefsRepetition2
	 */
	public EORefidx getMotClefsItem2() {
		return motClefsItem2;
	}

	/**
	 * @param motClefsRepetition2
	 *            the motClefsRepetition2 to set
	 */
	public void setMotClefsItem2(EORefidx motClefsRepetition2) {
		this.motClefsItem2 = motClefsRepetition2;
	}

	/**
	 * @return the selectedMotClefs2
	 */
	public EORefidx getSelectedMotClefs2() {
		return selectedMotClefs2;
	}

	/**
	 * @param selectedMotClefs2
	 *            the selectedMotClefs2 to set
	 */
	public void setSelectedMotClefs2(EORefidx selectedMotClefs2) {
		this.selectedMotClefs2 = selectedMotClefs2;
	}

	/**
	 * @return the lastCreateMotClef
	 */
	public EORefidx getLastCreateMotClef() {
		return lastCreateMotClef;
	}

	/**
	 * @param lastCreateMotClef
	 *            the lastCreateMotClef to set
	 */
	public void setLastCreateMotClef(EORefidx lastCreateMotClef) {
		this.lastCreateMotClef = lastCreateMotClef;
	}

	/**
	 * @return the lastPlateau
	 */
	public EOPfmateriel getLastPlateau() {
		return lastPlateau;
	}

	/**
	 * @param lastPlateau
	 *            the lastPlateau to set
	 */
	public void setLastPlateau(EOPfmateriel lastPlateau) {
		this.lastPlateau = lastPlateau;
	}

	/**
	 * @return the lastCreatedPartenaire
	 */
	public EOTyppartenaire lastCreatedPartenaire() {
		return lastCreatedPartenaire;
	}

	/**
	 * @param lastCreatedPartenaire the lastCreatedPartenaire to set
	 */
	public void setLastCreatedPartenaire(EOTyppartenaire lastCreatedPartenaire) {
		this.lastCreatedPartenaire = lastCreatedPartenaire;
	}

	/**
	 * @return the contexte
	 */
	public String getContexte() {
		return contexte;
	}

	/**
	 * @param contexte
	 *            the contexte to set
	 */
	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	/**
	 * @return the problematik
	 */
	public String getProblematik() {
		return problematik;
	}

	/**
	 * @param problematik
	 *            the problematik to set
	 */
	public void setProblematik(String problematik) {
		this.problematik = problematik;
	}

	/**
	 * @return the objectifs
	 */
	public String getObjectifs() {
		return objectifs;
	}

	/**
	 * @param objectifs
	 *            the objectifs to set
	 */
	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	/**
	 * @return the metho
	 */
	public String getMetho() {
		return metho;
	}

	/**
	 * @param metho
	 *            the metho to set
	 */
	public void setMetho(String metho) {
		this.metho = metho;
	}

	/**
	 * @return the sourceFinance
	 */
	public String getSourceFinance() {
		return sourceFinance;
	}

	/**
	 * @param sourceFinance
	 *            the sourceFinance to set
	 */
	public void setSourceFinance(String sourceFinance) {
		this.sourceFinance = sourceFinance;
	}

	/**
	 * @return the porteurList
	 */
	public NSArray<EOVrhcmval> getPorteurList() {
		return porteurList;
	}

	/**
	 * @param porteurList
	 *            the porteurList to set
	 */
	public void setPorteurList(NSArray<EOVrhcmval> porteurList) {
		this.porteurList = porteurList;
	}

	/**
	 * @return the selectedrhs
	 */
	public NSMutableArray selectedrhs() {
		EOPprec projet = projet();
		EOEditingContext ec = projet.editingContext();
		if (selectedrhs == null) {
			selectedrhs = new NSMutableArray();
			if (projet.primaryKey() != null)
				selectedrhs = EOPersonnel.fetchPersonnelProjet(ec,
						Integer.valueOf(projet.primaryKey())).mutableClone();
		}
		return selectedrhs;
	}

	/**
	 * @param selectedrhs
	 *            the selectedrhs to set
	 */
	public void setSelectedrhs(NSMutableArray selectedrhs) {
		this.selectedrhs = selectedrhs;
	}

	/**
	 * @return the removedrhs
	 */
	public NSMutableArray removedrhs() {
		if (removedrhs == null)
			removedrhs = new NSMutableArray();
		return removedrhs;
	}

	/**
	 * @param removedrhs
	 *            the removedrhs to set
	 */
	public void setRemovedrhs(NSMutableArray removedrhs) {
		this.removedrhs = removedrhs;
	}

	/**
	 * @return the selectedRecrue
	 */
	public NSMutableArray selectedRecrue() {
		EOPprec projet = projet();
		EOEditingContext ec = projet.editingContext();
		if (selectedRecrue == null) {
			selectedRecrue = new NSMutableArray();
			if (projet.primaryKey() != null)
				selectedRecrue = EOPosterh.fetchPosteProjet(ec,
						Integer.valueOf(projet.primaryKey())).mutableClone();
		}
		return selectedRecrue;
	}

	/**
	 * @param selectedRecrue
	 *            the selectedRecrue to set
	 */
	public void setSelectedRecrue(NSMutableArray selectedRecrue) {
		this.selectedRecrue = selectedRecrue;
	}

	/**
	 * @return the removedRecrue
	 */
	public NSMutableArray removedRecrue() {
		if (removedRecrue == null)
			removedRecrue = new NSMutableArray();
		return removedRecrue;
	}

	/**
	 * @param removedRecrue
	 *            the removedRecrue to set
	 */
	public void setRemovedRecrue(NSMutableArray removedRecrue) {
		this.removedRecrue = removedRecrue;
	}

	/**
	 * @return the selectedMaterielExistant
	 */
	public NSMutableArray selectedMaterielExistant() {
		EOPprec projet = projet();
		EOEditingContext ec = projet.editingContext();
		if (selectedMaterielExistant == null) {
			selectedMaterielExistant = new NSMutableArray();
			if (projet.primaryKey() != null)
				selectedMaterielExistant = EOResmat.fetchMaterielProjet(ec,
						Integer.valueOf(projet.primaryKey())).mutableClone();
		}
		return selectedMaterielExistant;
	}

	/**
	 * @param selectedMaterielExistant
	 *            the selectedMaterielExistant to set
	 */
	public void setSelectedMaterielExistant(
			NSMutableArray selectedMaterielExistant) {
		this.selectedMaterielExistant = selectedMaterielExistant;
	}

	/**
	 * @return the removedMaterielExistant
	 */
	public NSMutableArray removedMaterielExistant() {
		if (removedMaterielExistant == null)
			removedMaterielExistant = new NSMutableArray();
		return removedMaterielExistant;
	}

	/**
	 * @param removedMaterielExistant
	 *            the removedMaterielExistant to set
	 */
	public void setRemovedMaterielExistant(
			NSMutableArray removedMaterielExistant) {
		this.removedMaterielExistant = removedMaterielExistant;
	}

	/**
	 * @return the selectedMaterielAcquis
	 */
	public NSMutableArray selectedMaterielAcquis() {
		EOPprec projet = projet();
		EOEditingContext ec = projet.editingContext();
		if (selectedMaterielAcquis == null) {
			selectedMaterielAcquis = new NSMutableArray();
			if (projet.primaryKey() != null)
				selectedMaterielAcquis = EOResmat.fetchNouceauMaterielProjet(
						ec, Integer.valueOf(projet.primaryKey()))
						.mutableClone();
		}
		return selectedMaterielAcquis;
	}

	/**
	 * @param selectedMaterielAcquis
	 *            the selectedMaterielAcquis to set
	 */
	public void setSelectedMaterielAcquis(NSMutableArray selectedMaterielAcquis) {
		this.selectedMaterielAcquis = selectedMaterielAcquis;
	}

	/**
	 * @return the removedMaterielAcquis
	 */
	public NSMutableArray removedMaterielAcquis() {
		if (removedMaterielAcquis == null)
			removedMaterielAcquis = new NSMutableArray();
		return removedMaterielAcquis;
	}

	/**
	 * @param removedMaterielAcquis
	 *            the removedMaterielAcquis to set
	 */
	public void setRemovedMaterielAcquis(NSMutableArray removedMaterielAcquis) {
		this.removedMaterielAcquis = removedMaterielAcquis;
	}

	/**
	 * @return the porteur
	 */
	public EOVrhcmval porteur() {
		if (porteur == null) {
			EOPprec projet = projet();
			EOEditingContext ec = null;
			// Correction java.lang.NullPointerException
			try {
				if (projet != null)
					ec = projet.editingContext();
			} catch (Exception e) {
				if (projet != null) {
					projet.__setEditingContext(ERXEC.newEditingContext());
					ec = projet.editingContext();
				} else {
					ec = ERXEC.newEditingContext();
				}
			} finally {
				if (projet != null && projet.porteur() != null) {
					porteur = EOVrhcmval.unPolePourIndividu(ec,
							projet.porteur());
				} else {
					porteur = EOVrhcmval.unPolePourIndividu(ec, noIndividu());
					setPorteur(porteur);
				}
			}
		}
		return porteur;
	}

	/**
	 * @param porteur
	 *            the porteur to set
	 */
	public void setPorteur(EOVrhcmval porteur) {
		EOPprec projet = projet();
		if (projet != null && porteur != null) {
			EOEditingContext ec = projet.editingContext();
			EOStructureUlr lePole = EOStructureUlr.structurePourcStructure(ec,
					porteur.cStructure());
			projet.setPorteur(porteur.noIndividu());
			projet.setDirecteurPole(lePole.grpResponsable());
			projet.setPoleCompetence(lePole.cStructure());
		}
		this.porteur = porteur;
	}

	/**
	 * @return the listInfoPole
	 */
	public NSArray<EOVrhcmval> getListInfoPole() {
		return listInfoPole;
	}

	/**
	 * @param listInfoPole
	 *            the listInfoPole to set
	 */
	public void setListInfoPole(NSArray<EOVrhcmval> listInfoPole) {
		this.listInfoPole = listInfoPole;
	}

	/**
	 * @return the infoPorteurRepetition
	 */
	public EOVrhcmval getInfoPorteurRepetition() {
		return infoPorteurRepetition;
	}

	/**
	 * @param infoPorteurRepetition
	 *            the infoPorteurRepetition to set
	 */
	public void setInfoPorteurRepetition(EOVrhcmval infoPorteurRepetition) {
		this.infoPorteurRepetition = infoPorteurRepetition;
	}

	/**
	 * @return the selectedInfoPorteur
	 */
	public EOVrhcmval getSelectedInfoPorteur() {
		return selectedInfoPorteur;
	}

	/**
	 * @param selectedInfoPorteur
	 *            the selectedInfoPorteur to set
	 */
	public void setSelectedInfoPorteur(EOVrhcmval selectedInfoPorteur) {
		selectedInfoPorteur = selectedInfoPorteur;
	}

	/**
	 * @return the porteurRepetition
	 */
	public EOVrhcmval getPorteurRepetition() {
		return porteurRepetition;
	}

	/**
	 * @param porteurRepetition
	 *            the porteurRepetition to set
	 */
	public void setPorteurRepetition(EOVrhcmval porteurRepetition) {
		this.porteurRepetition = porteurRepetition;
	}

	/**
	 * @return the contratList
	 */
	public NSArray<EOTypcontrat> getContratList() {
		return contratList;
	}

	/**
	 * @param contratList
	 *            the contratList to set
	 */
	public void setContratList(NSArray<EOTypcontrat> contratList) {
		this.contratList = contratList;
	}

	/**
	 * @return the contratRepetition
	 */
	public EOTypcontrat getContratRepetition() {
		return contratRepetition;
	}

	/**
	 * @param contratRepetition
	 *            the contratRepetition to set
	 */
	public void setContratRepetition(EOTypcontrat contratRepetition) {
		this.contratRepetition = contratRepetition;
	}

	/**
	 * @param contratRepetition1
	 *            the contratRepetition1 to set
	 */
	public void setContratRepetition1(EOTypcontrat contratRepetition1) {
		this.contratRepetition1 = contratRepetition1;
	}

	/**
	 * @return the contratRepetition1
	 */
	public EOTypcontrat getContratRepetition1() {
		return contratRepetition1;
	}

	/**
	 * @return the contrat
	 */
	public EOTypcontrat contrat() {
		if (contrat == null) {
			EOPprec projet = projet();
			if (projet != null) {
				if (projet.toContrat() != null) {
					if (projet.toContrat().typcontIdSup() != null) {
						setStContratSelected(projet.toContrat());
						contrat = EOTypcontrat.fetchContratPere(
								projet.editingContext(),
								getStContratSelected().typcontIdSup())
								.lastObject();
					} else {
						contrat = projet.toContrat();
					}
				}
			}
		}
		return contrat;
	}

	/**
	 * @param contrat
	 *            the contrat to set
	 */
	public void setContrat(EOTypcontrat contrat) {
		this.contrat = contrat;
		EOPprec projet = projet();
		if (contrat != null) {
			if (projet != null) {
				projet.setToContratRelationship(contrat.localInstanceIn(projet
						.editingContext()));
			}
		}
	}

	/**
	 * @return the partenaireList
	 */
	public NSArray<EOTyppartenaire> getPartenaireList() {
		return partenaireList;
	}

	/**
	 * @param partenaireList
	 *            the partenaireList to set
	 */
	public void setPartenaireList(NSArray<EOTyppartenaire> partenaireList) {
		this.partenaireList = partenaireList;
	}

	/**
	 * @return the partenaireRepetition
	 */
	public EOTyppartenaire getPartenaireRepetition() {
		return partenaireRepetition;
	}

	/**
	 * @param partenaireRepetition
	 *            the partenaireRepetition to set
	 */
	public void setPartenaireRepetition(EOTyppartenaire partenaireRepetition) {
		this.partenaireRepetition = partenaireRepetition;
	}

	/**
	 * @return the partenaire
	 */
	public EOTyppartenaire partenaire() {
		return partenaire;
	}

	/**
	 * @param partenaire
	 *            the partenaire to set
	 */
	public void setPartenaire(EOTyppartenaire partenaire) {
		this.partenaire = partenaire;
	}

	/**
	 * @return the selectedPartenaires
	 */
	public NSMutableArray selectedPartenaires() {
		if (selectedPartenaires == null) {
			EOPprec projet = projet();
			if (projet != null) {
				NSArray<EOPartenaireProjet> partProj = projet
						.toProjetPartenaires(
								EOPartenaireProjet.TEMVALIDE.eq("O"), true);
				selectedPartenaires = new NSMutableArray();
				for (EOPartenaireProjet partenaire : partProj) {
					selectedPartenaires.addObject(partenaire.toPartenaire());
				}

			} else {
				selectedPartenaires = new NSMutableArray();
			}
		}
		return selectedPartenaires;
	}

	/**
	 * @param selectedPartenaires
	 *            the selectedPartenaires to set
	 */
	public void setSelectedPartenaires(NSMutableArray selectedPartenaires) {
		this.selectedPartenaires = selectedPartenaires;
	}

	/**
	 * @return the removedPartenaires
	 */
	public NSMutableArray removedPartenaires() {
		if (removedPartenaires == null)
			removedPartenaires = new NSMutableArray();
		return removedPartenaires;
	}

	/**
	 * @param removedPartenaires
	 *            the removedPartenaires to set
	 */
	public void setRemovedPartenaires(NSMutableArray removedPartenaires) {
		this.removedPartenaires = removedPartenaires;
	}

	/**
	 * @return the equipeList
	 */
	public NSArray<EOStructureUlr> getEquipeList() {
		return equipeList;
	}

	/**
	 * @param equipeList
	 *            the equipeList to set
	 */
	public void setEquipeList(NSArray<EOStructureUlr> equipeList) {
		this.equipeList = equipeList;
	}

	/**
	 * @return the equipeRepetition
	 */
	public EOStructureUlr getEquipeRepetition() {
		return equipeRepetition;
	}

	/**
	 * @param equipeRepetition
	 *            the equipeRepetition to set
	 */
	public void setEquipeRepetition(EOStructureUlr equipeRepetition) {
		this.equipeRepetition = equipeRepetition;
	}

	/**
	 * @return the poleDeCompetence
	 */
	public EOStructureUlr poleDeCompetence() {
		if (poleDeCompetence == null) {
			EOPprec projet = projet();
			if (projet != null) {
				poleDeCompetence = EOStructureUlr.structurePourcStructure(
						projet.editingContext(), projet.poleCompetence());
			}
		}
		return poleDeCompetence;
	}

	/**
	 * @param poleDeCompetence
	 *            the poleDeCompetence to set
	 */
	public void setPoleDeCompetence(EOStructureUlr poleDeCompetence) {
		this.poleDeCompetence = poleDeCompetence;
		EOPprec projet = projet();
		if (poleDeCompetence != null) {
			if (projet != null) {
				projet.setPoleCompetence(poleDeCompetence.cStructure());
			}
		} else {
			projet.setPoleCompetence(null);
		}
	}

	/**
	 * @return the equipePrincipale
	 */
	public EOStructureUlr equipePrincipale() {
		if (equipePrincipale == null) {
			EOPprec projet = projet();
			if (projet != null) {
				equipePrincipale = EOStructureUlr.structurePourcStructure(
						projet.editingContext(), projet.equipePrincipale());
			}
		}
		return equipePrincipale;
	}

	/**
	 * @param equipePrincipale
	 *            the equipePrincipale to set
	 */
	public void setEquipePrincipale(EOStructureUlr equipePrincipale) {
		this.equipePrincipale = equipePrincipale;
		EOPprec projet = projet();
		if (equipePrincipale != null) {
			if (projet != null) {
				projet.setEquipePrincipale(equipePrincipale.cStructure());
			}
		} else {
			projet.setEquipePrincipale(null);
		}
	}

	/**
	 * @return the hasOtherSelection
	 */
	public Boolean getHasOtherSelection() {
		return hasOtherSelection;
	}

	/**
	 * @param hasOtherSelection
	 *            the hasOtherSelection to set
	 */
	public void setHasOtherSelection(Boolean hasOtherSelection) {
		this.hasOtherSelection = hasOtherSelection;
	}

	/**
	 * @return the axeList
	 */
	public NSArray<EOAxerec> getAxeList() {
		return axeList;
	}

	/**
	 * @return the axeStmrList
	 */
	public NSArray<EOAxerec> getAxeStmrList() {
		return axeStmrList;
	}

	/**
	 * @param axeStmrList
	 *            the axeStmrList to set
	 */
	public void setAxeStmrList(NSArray<EOAxerec> axeStmrList) {
		this.axeStmrList = axeStmrList;
	}

	/**
	 * @return the axeStmrRepetition
	 */
	public EOAxerec getAxeStmrRepetition() {
		return axeStmrRepetition;
	}

	/**
	 * @param axeStmrRepetition
	 *            the axeStmrRepetition to set
	 */
	public void setAxeStmrRepetition(EOAxerec axeStmrRepetition) {
		this.axeStmrRepetition = axeStmrRepetition;
	}

	/**
	 * @return the selectedStmrAxe
	 */
	public EOAxerec getSelectedStmrAxe() {
		return selectedStmrAxe;
	}

	/**
	 * @param selectedStmrAxe
	 *            the selectedStmrAxe to set
	 */
	public void setSelectedStmrAxe(EOAxerec selectedStmrAxe) {
		this.selectedStmrAxe = selectedStmrAxe;
	}

	/**
	 * @return the equipeSecondaireList
	 */
	public NSArray<EOStructureUlr> equipeSecondaireList() {
		if (equipeSecondaireList == null)
			equipeSecondaireList = new NSArray<EOStructureUlr>();
		return equipeSecondaireList;
	}

	/**
	 * @param newEquipeList
	 *            the newEquipeList to set
	 */
	public void setEquipeSecondaireList(
			NSArray<EOStructureUlr> equipeSecondaireList) {
		this.equipeSecondaireList = equipeSecondaireList;
	}

	/**
	 * @return the newEquipeRepetition
	 */
	public EOStructureUlr equipeSecondaireRepeat() {
		return equipeSecondaireRepeat;
	}

	/**
	 * @param newEquipeRepetition
	 *            the newEquipeRepetition to set
	 */
	public void setEquipeSecondaireRepeat(EOStructureUlr equipeSecondaireRepeat) {
		this.equipeSecondaireRepeat = equipeSecondaireRepeat;
	}

	/**
	 * @return the selectedNewEquipe
	 */
	public EOStructureUlr selectedEquipeSecondaire() {
		return selectedEquipeSecondaire;
	}

	/**
	 * @param selectedNewEquipe
	 *            the selectedNewEquipe to set
	 */
	public void setSelectedEquipeSecondaire(
			EOStructureUlr selectedEquipeSecondaire) {
		this.selectedEquipeSecondaire = selectedEquipeSecondaire;
	}

	/**
	 * @return the newEquipe
	 */
	public EOEquipes getNewEquipe() {
		return newEquipe;
	}

	/**
	 * @param newEquipe
	 *            the newEquipe to set
	 */
	public void setNewEquipe(EOEquipes newEquipe) {
		this.newEquipe = newEquipe;
	}

	/**
	 * @param axeList
	 *            the axeList to set
	 */
	public void setAxeList(NSArray<EOAxerec> axeList) {
		this.axeList = axeList;
	}

	/**
	 * @return the axeRepetition
	 */
	public EOAxerec getAxeRepetition() {
		return axeRepetition;
	}

	/**
	 * @param axeRepetition
	 *            the axeRepetition to set
	 */
	public void setAxeRepetition(EOAxerec axeRepetition) {
		this.axeRepetition = axeRepetition;
	}

	/**
	 * @return the axe
	 */
	public EOAxerec axe() {
		if (axe == null) {
			EOPprec projet = projet();
			if (projet != null
					&& (projet.toAxe() != null && projet.toAxe().isAxe())) {
				axe = projet.toAxe();
			}
		}
		return axe;
	}

	/**
	 * @param axe
	 *            the axe to set
	 */
	public void setAxe(EOAxerec axe) {
		this.axe = axe;
		if (axe != null) {
			EOPprec projet = projet();
			if (projet != null) {
				projet.setToAxe(axe);
				projet.setToAxeRelationship(axe);
			}
		}
	}

	/**
	 * @return the pstList
	 */
	public NSArray<EOAxerec> getPstList() {
		return pstList;
	}

	/**
	 * @param pstList
	 *            the pstList to set
	 */
	public void setPstList(NSArray<EOAxerec> pstList) {
		this.pstList = pstList;
	}

	/**
	 * @return the pstRepetition
	 */
	public EOAxerec getPstRepetition() {
		return pstRepetition;
	}

	/**
	 * @param pstRepetition
	 *            the pstRepetition to set
	 */
	public void setPstRepetition(EOAxerec pstRepetition) {
		this.pstRepetition = pstRepetition;
	}

	/**
	 * @return the pst
	 */
	public EOAxerec pst() {
		if (pst == null) {
			if (lesAxesStmr().count() > 0) {
				for (EOAxerec pt : (NSMutableArray<EOAxerec>) lesAxesStmr()) {
					if (pt.isPst()) {
						pst = pt;
						break;
					}
				}
			}
		}
		return pst;
	}

	/**
	 * @param pst
	 *            the pst to set
	 */
	public void setPst(EOAxerec pst) {
		this.pst = pst;
		if (pst != null) {
			EOPprec projet = projet();
			if (projet != null) {
				projet.setToAxe(pst);
				projet.setToAxeRelationship(pst);
			}
		}
	}

	/**
	 * @return the thematikList
	 */
	public NSArray<EOTypthe> getThematikList() {
		return thematikList;
	}

	/**
	 * @param thematikList
	 *            the thematikList to set
	 */
	public void setThematikList(NSArray<EOTypthe> thematikList) {
		this.thematikList = thematikList;
	}

	/**
	 * @return the thematikRepetition
	 */
	public EOTypthe getThematikRepetition() {
		return thematikRepetition;
	}

	/**
	 * @param thematikRepetition
	 *            the thematikRepetition to set
	 */
	public void setThematikRepetition(EOTypthe thematikRepetition) {
		this.thematikRepetition = thematikRepetition;
	}

	/**
	 * @return the selectedThematik
	 */
	public EOTypthe getSelectedThematik() {
		return selectedThematik;
	}

	/**
	 * @param selectedThematik
	 *            the selectedThematik to set
	 */
	public void setSelectedThematik(EOTypthe selectedThematik) {
		this.selectedThematik = selectedThematik;
	}

	/**
	 * @return the themeList
	 */
	public NSArray<EORefthe> getThemeList() {
		return themeList;
	}

	/**
	 * @param themeList
	 *            the themeList to set
	 */
	public void setThemeList(NSArray<EORefthe> themeList) {
		this.themeList = themeList;
	}

	/**
	 * @return the souThemeList
	 */
	public NSArray<EORefthe> getSouThemeList() {
		return souThemeList;
	}

	/**
	 * @param souThemeList
	 *            the souThemeList to set
	 */
	public void setSouThemeList(NSArray<EORefthe> souThemeList) {
		this.souThemeList = souThemeList;
	}

	/**
	 * @return the themeRepetition
	 */
	public EORefthe getThemeRepetition() {
		return themeRepetition;
	}

	/**
	 * @param themeRepetition
	 *            the themeRepetition to set
	 */
	public void setThemeRepetition(EORefthe themeRepetition) {
		this.themeRepetition = themeRepetition;
	}

	/**
	 * @return the selectedTheme
	 */
	public EORefthe getSelectedTheme() {
		return selectedTheme;
	}

	/**
	 * @param selectedTheme
	 *            the selectedTheme to set
	 */
	public void setSelectedTheme(EORefthe selectedTheme) {
		this.selectedTheme = selectedTheme;
	}

	/**
	 * @return the souThemeRepetition
	 */
	public EORefthe getSouThemeRepetition() {
		return souThemeRepetition;
	}

	/**
	 * @param souThemeRepetition
	 *            the souThemeRepetition to set
	 */
	public void setSouThemeRepetition(EORefthe souThemeRepetition) {
		this.souThemeRepetition = souThemeRepetition;
	}

	/**
	 * @return the selectedSouTheme
	 */
	public EORefthe getSelectedSouTheme() {
		return selectedSouTheme;
	}

	/**
	 * @param selectedSouTheme
	 *            the selectedSouTheme to set
	 */
	public void setSelectedSouTheme(EORefthe selectedSouTheme) {
		this.selectedSouTheme = selectedSouTheme;
	}

	/**
	 * @param etatRepetition
	 *            the etatRepetition to set
	 */
	public void setEtatRepetition(EOTypref etatRepetition) {
		this.etatRepetition = etatRepetition;
	}

	/**
	 * @return the etatRepetition
	 */
	public EOTypref getEtatRepetition() {
		return etatRepetition;
	}

	/**
	 * @param selectedState
	 *            the selectedState to set
	 */
	public void setSelectedState(EOTypref selectedState) {
		this.selectedState = selectedState;
	}

	/**
	 * @return the selectedState
	 */
	public EOTypref getSelectedState() {
		return selectedState;
	}

	/**
	 * @return the listEtat1
	 */
	public NSArray<EOTypref> getListEtat1() {
		return listEtat1;
	}

	/**
	 * @param listEtat1
	 *            the listEtat1 to set
	 */
	public void setListEtat1(NSArray<EOTypref> listEtat1) {
		this.listEtat1 = listEtat1;
	}

	/**
	 * @return the etatRepetition1
	 */
	public EOTypref getEtatRepetition1() {
		return etatRepetition1;
	}

	/**
	 * @param etatRepetition1
	 *            the etatRepetition1 to set
	 */
	public void setEtatRepetition1(EOTypref etatRepetition1) {
		this.etatRepetition1 = etatRepetition1;
	}

	/**
	 * @return the poleMaterielsDg
	 */
	public WODisplayGroup poleMaterielsDg() {
		if (poleMaterielsDg == null) {
			poleMaterielsDg = new WODisplayGroup();
			poleMaterielsDg.setObjectArray(selectedMaterielExistant()
					.immutableClone());
			if (poleMaterielsDg.batchCount() == 0)
				poleMaterielsDg.setNumberOfObjectsPerBatch(5);
		}
		return poleMaterielsDg;
	}

	/**
	 * @param poleMaterielsDg
	 *            the poleMaterielsDg to set
	 */
	public void setPoleMaterielsDg(WODisplayGroup poleMaterielsDg) {
		this.poleMaterielsDg = poleMaterielsDg;
	}

	/**
	 * @param generalErrorMessage
	 *            the generalErrorMessage to set
	 */
	public void setGeneralErrorMessage(String generalErrorMessage) {
		this.generalErrorMessage = generalErrorMessage;
	}

	/**
	 * @return the generalErrorMessage
	 */
	public String getGeneralErrorMessage() {
		return generalErrorMessage;
	}

	public void reset() {
		if (editingContext() != null) {
			editingContext().revert();
		}
	}

	public NSDictionary exceptionInfos() {
		return null;
	}

	/**
	 * @return the newPartList
	 */
	public NSArray<EOTyppartenaire> getNewPartList() {
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
	public EOTyppartenaire getPartenaireItem() {
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
		if (partenaireDg == null)
			partenaireDg = new WODisplayGroup();
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
	 * @return the otherList
	 */
	public NSArray<EOStructureUlr> getOtherList() {
		return otherList;
	}

	/**
	 * @param otherList
	 *            the otherList to set
	 */
	public void setOtherList(NSArray<EOStructureUlr> otherList) {
		this.otherList = otherList;
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

	/**
	 * @return the autreEquipeDg
	 */
	public WODisplayGroup autreEquipeDg() {
		if (autreEquipeDg == null)
			autreEquipeDg = new WODisplayGroup();
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
	 * @return the haveSTMR
	 */
	public boolean isHaveSTMR() {
		return haveSTMR;
	}

	/**
	 * @param haveSTMR
	 *            the haveSTMR to set
	 */
	public void setHaveSTMR(boolean haveSTMR) {
		this.haveSTMR = haveSTMR;
	}

	/**
	 * @return the haveNotSTMR
	 */
	public boolean isHaveNotSTMR() {
		return haveNotSTMR;
	}

	/**
	 * @param haveNotSTMR
	 *            the haveNotSTMR to set
	 */
	public void setHaveNotSTMR(boolean haveNotSTMR) {
		this.haveNotSTMR = haveNotSTMR;
	}

	/**
	 * @return the txImplication
	 */
	public String getTxImplication() {
		return txImplication;
	}

	/**
	 * @param txImplication
	 *            the txImplication to set
	 */
	public void setTxImplication(String txImplication) {
		this.txImplication = txImplication;
	}

	/**
	 * @return the recrue
	 */
	public EOPosterh recrue() {
		return recrue;
	}

	/**
	 * @param recrue
	 *            the recrue to set
	 */
	public void setRecrue(EOPosterh recrue) {
		this.recrue = recrue;
	}

	/**
	 * @return the newMatos
	 */
	public EOResmat newMatos() {
		return newMatos;
	}

	/**
	 * @param newMatos
	 *            the newMatos to set
	 */
	public void setNewMatos(EOResmat newMatos) {
		this.newMatos = newMatos;
	}

	/**
	 * @return the rh
	 */
	public EOPersonnel rh() {
		return rh;
	}

	/**
	 * @param rh
	 *            the rh to set
	 */
	public void setRh(EOPersonnel rh) {
		this.rh = rh;
	}

	/**
	 * @return the matos
	 */
	public EOResmat matos() {
		return matos;
	}

	/**
	 * @param matos
	 *            the matos to set
	 */
	public void setMatos(EOResmat matos) {
		this.matos = matos;
	}

	/**
	 * @return the materielRep
	 */
	public EOResmat getMaterielRep() {
		return materielRep;
	}

	/**
	 * @param materielRep
	 *            the materielRep to set
	 */
	public void setMaterielRep(EOResmat materielRep) {
		this.materielRep = materielRep;
	}

	/**
	 * @return the listProjet
	 */
	public NSArray<EOPprec> getListProjet() {
		return listProjet;
	}

	/**
	 * @param listProjet
	 *            the listProjet to set
	 */
	public void setListProjet(NSArray<EOPprec> listProjet) {
		this.listProjet = listProjet;
	}

	/**
	 * @return the projetRepetition
	 */
	public EOPprec getProjetRepetition() {
		return projetRepetition;
	}

	/**
	 * @param projetRepetition
	 *            the projetRepetition to set
	 */
	public void setProjetRepetition(EOPprec projetRepetition) {
		this.projetRepetition = projetRepetition;
	}

	/**
	 * @return the selectedProjet
	 */
	public EOPprec getSelectedProjet() {
		return selectedProjet;
	}

	/**
	 * @param selectedProjet
	 *            the selectedProjet to set
	 */
	public void setSelectedProjet(EOPprec selectedProjet) {
		this.selectedProjet = selectedProjet;
	}

	/**
	 * @return the porteurRepetition1
	 */
	public EOIndividuUlr getPorteurRepetition1() {
		return porteurRepetition1;
	}

	/**
	 * @param porteurRepetition1
	 *            the porteurRepetition1 to set
	 */
	public void setPorteurRepetition1(EOIndividuUlr porteurRepetition1) {
		this.porteurRepetition1 = porteurRepetition1;
	}

	/**
	 * @return the selectedPorteur1
	 */
	public EOIndividuUlr getSelectedPorteur1() {
		return selectedPorteur1;
	}

	/**
	 * @param selectedPorteur1
	 *            the selectedPorteur1 to set
	 */
	public void setSelectedPorteur1(EOIndividuUlr selectedPorteur1) {
		this.selectedPorteur1 = selectedPorteur1;
	}

	/**
	 * @return the equipeRepetition1
	 */
	public EOStructureUlr getEquipeRepetition1() {
		return equipeRepetition1;
	}

	/**
	 * @param equipeRepetition1
	 *            the equipeRepetition1 to set
	 */
	public void setEquipeRepetition1(EOStructureUlr equipeRepetition1) {
		this.equipeRepetition1 = equipeRepetition1;
	}

	/**
	 * @return the selectedEquipe1
	 */
	public EOEquipes getSelectedEquipe1() {
		return selectedEquipe1;
	}

	/**
	 * @param selectedEquipe1
	 *            the selectedEquipe1 to set
	 */
	public void setSelectedEquipe1(EOEquipes selectedEquipe1) {
		this.selectedEquipe1 = selectedEquipe1;
	}

	/**
	 * @return the selectedRechUnit1
	 */
	public EOStructureUlr getSelectedRechUnit1() {
		return selectedRechUnit1;
	}

	/**
	 * @param selectedRechUnit1
	 *            the selectedRechUnit1 to set
	 */
	public void setSelectedRechUnit1(EOStructureUlr selectedRechUnit1) {
		this.selectedRechUnit1 = selectedRechUnit1;
	}

	/**
	 * @return the listCategories
	 */
	public NSArray<EOVtyprhcm> getListCategories() {
		return listCategories;
	}

	/**
	 * @param listCategories
	 *            the listCategories to set
	 */
	public void setListCategories(NSArray<EOVtyprhcm> listCategories) {
		this.listCategories = listCategories;
	}

	/**
	 * @return the categItem
	 */
	public EOVtyprhcm getCategItem() {
		return categItem;
	}

	/**
	 * @param categItem
	 *            the categItem to set
	 */
	public void setCategItem(EOVtyprhcm categItem) {
		this.categItem = categItem;
	}

	/**
	 * @return the categSelect
	 */
	public EOVtyprhcm getCategSelect() {
		return categSelect;
	}

	/**
	 * @param categSelect
	 *            the categSelect to set
	 */
	public void setCategSelect(EOVtyprhcm categSelect) {
		this.categSelect = categSelect;
	}

	/**
	 * @return the matosExistant
	 */
	public String getMatosExistant() {
		return matosExistant;
	}

	/**
	 * @param matosExistant
	 *            the matosExistant to set
	 */
	public void setMatosExistant(String matosExistant) {
		this.matosExistant = matosExistant;
	}

	/**
	 * @return the listCategMteriels
	 */
	public NSArray<EOPfmateriel> getListCategMteriels() {
		return listCategMteriels;
	}

	/**
	 * @param listCategMteriels
	 *            the listCategMteriels to set
	 */
	public void setListCategMteriels(NSArray<EOPfmateriel> listCategMteriels) {
		this.listCategMteriels = listCategMteriels;
	}

	/**
	 * @return the categMatItem
	 */
	public EOPfmateriel getCategMatItem() {
		return categMatItem;
	}

	/**
	 * @param categMatItem
	 *            the categMatItem to set
	 */
	public void setCategMatItem(EOPfmateriel categMatItem) {
		this.categMatItem = categMatItem;
	}

	/**
	 * @return the categMatSelect
	 */
	public EOPfmateriel getCategMatSelect() {
		return categMatSelect;
	}

	/**
	 * @param categMatSelect
	 *            the categMatSelect to set
	 */
	public void setCategMatSelect(EOPfmateriel categMatSelect) {
		this.categMatSelect = categMatSelect;
	}

	/**
	 * @return the listCategMteriels0
	 */
	public NSArray<EOPfmateriel> getListCategMteriels0() {
		return listCategMteriels0;
	}

	/**
	 * @param listCategMteriels0
	 *            the listCategMteriels0 to set
	 */
	public void setListCategMteriels0(NSArray<EOPfmateriel> listCategMteriels0) {
		this.listCategMteriels0 = listCategMteriels0;
	}

	/**
	 * @return the categMatItem0
	 */
	public EOPfmateriel getCategMatItem0() {
		return categMatItem0;
	}

	/**
	 * @param categMatItem0
	 *            the categMatItem0 to set
	 */
	public void setCategMatItem0(EOPfmateriel categMatItem0) {
		this.categMatItem0 = categMatItem0;
	}

	/**
	 * @return the categMatSelect0
	 */
	public EOPfmateriel getCategMatSelect0() {
		return categMatSelect0;
	}

	/**
	 * @param categMatSelect0
	 *            the categMatSelect0 to set
	 */
	public void setCategMatSelect0(EOPfmateriel categMatSelect0) {
		this.categMatSelect0 = categMatSelect0;
	}

	/**
	 * @return the listLibMateriels
	 */
	public NSArray<EOGemateriel> getListLibMateriels() {
		return listLibMateriels;
	}

	/**
	 * @param listLibMateriels
	 *            the listLibMateriels to set
	 */
	public void setListLibMateriels(NSArray<EOGemateriel> listLibMateriels) {
		this.listLibMateriels = listLibMateriels;
	}

	/**
	 * @return the libMaterielItem
	 */
	public EOGemateriel getLibMaterielItem() {
		return libMaterielItem;
	}

	/**
	 * @param libMaterielItem
	 *            the libMaterielItem to set
	 */
	public void setLibMaterielItem(EOGemateriel libMaterielItem) {
		this.libMaterielItem = libMaterielItem;
	}

	/**
	 * @return the libMaterielSelect
	 */
	public EOGemateriel getLibMaterielSelect() {
		return libMaterielSelect;
	}

	/**
	 * @param libMaterielSelect
	 *            the libMaterielSelect to set
	 */
	public void setLibMaterielSelect(EOGemateriel libMaterielSelect) {
		this.libMaterielSelect = libMaterielSelect;
	}

	/**
	 * @return the indexModuleActifGestionPersonne
	 */
	public Integer indexModuleActifGestionProjet() {
		if (indexModuleActifGestionProjet == null) {
			indexModuleActifGestionProjet = new Integer(0);
		}
		return indexModuleActifGestionProjet;
	}

	/**
	 * @param indexModuleActifGestionPersonne
	 *            the indexModuleActifGestionPersonne to set
	 */
	public void setIndexModuleActifGestionProjet(
			Integer indexModuleActifGestionProjet) {
		this.indexModuleActifGestionProjet = indexModuleActifGestionProjet;
	}

	/**
	 * @return the bigListTmp
	 */
	public NSArray getBigListTmp() {
		return bigListTmp;
	}

	/**
	 * @param bigListTmp
	 *            the bigListTmp to set
	 */
	public void setBigListTmp(NSArray bigListTmp) {
		this.bigListTmp = bigListTmp;
	}

	/**
	 * @return the bigTmpProject
	 */
	public ProjectListTampon getBigTmpProject() {
		return bigTmpProject;
	}

	/**
	 * @param bigTmpProject
	 *            the bigTmpProject to set
	 */
	public void setBigTmpProject(ProjectListTampon bigTmpProject) {
		this.bigTmpProject = bigTmpProject;
	}

	/**
	 * @return the idProjetRecent
	 */
	public Number getIdProjetRecent() {
		return idProjetRecent;
	}

	/**
	 * @param idProjetRecent
	 *            the idProjetRecent to set
	 */
	public void setIdProjetRecent(Number idProjetRecent) {
		this.idProjetRecent = idProjetRecent;
	}

	public EOPprec getProjectSelected() {
		return projectSelected;
	}

	public void setProjectSelected(EOPprec projectSelected) {
		this.projectSelected = projectSelected;
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
	 * @return the matchDg1
	 */
	public WODisplayGroup matchDg1() {
		if (matchDg1 == null)
			matchDg1 = new WODisplayGroup();
		return matchDg1;
	}

	/**
	 * @param matchDg1
	 *            the matchDg1 to set
	 */
	public void setMatchDg1(WODisplayGroup matchDg1) {
		this.matchDg1 = matchDg1;
	}

	/**
	 * @return the matchDg2
	 */
	public WODisplayGroup matchDg2() {
		if (matchDg2 == null)
			matchDg2 = new WODisplayGroup();
		return matchDg2;
	}

	/**
	 * @param matchDg2
	 *            the matchDg2 to set
	 */
	public void setMatchDg2(WODisplayGroup matchDg2) {
		this.matchDg2 = matchDg2;
	}

	/**
	 * @return the avisRepPP
	 */
	public EOTypref getAvisRepPP() {
		return avisRepPP;
	}

	/**
	 * @param avisRepPP
	 *            the avisRepPP to set
	 */
	public void setAvisRepPP(EOTypref avisRepPP) {
		this.avisRepPP = avisRepPP;
	}

	/**
	 * @return the avisRespSec
	 */
	public EOTypref getAvisRespSec() {
		return avisRespSec;
	}

	/**
	 * @param avisRespSec
	 *            the avisRespSec to set
	 */
	public void setAvisRespSec(EOTypref avisRespSec) {
		this.avisRespSec = avisRespSec;
	}

	/**
	 * @return the avisDrt
	 */
	public EOTypref getAvisDrt() {
		return avisDrt;
	}

	/**
	 * @param avisDrt
	 *            the avisDrt to set
	 */
	public void setAvisDrt(EOTypref avisDrt) {
		this.avisDrt = avisDrt;
	}

	/**
	 * @return the avisICD
	 */
	public EOTypref getAvisICD() {
		return avisICD;
	}

	/**
	 * @param avisICD
	 *            the avisICD to set
	 */
	public void setAvisICD(EOTypref avisICD) {
		this.avisICD = avisICD;
	}

	/**
	 * @return the lesSTMR
	 */
	public WODisplayGroup lesSTMR() {
		if (lesSTMR == null)
			lesSTMR = new WODisplayGroup();
		return lesSTMR;
	}

	/**
	 * @param lesSTMR
	 *            the lesSTMR to set
	 */
	public void setLesSTMR(WODisplayGroup lesSTMR) {
		this.lesSTMR = lesSTMR;
	}

	/**
	 * @return the lesAxesStmr
	 */
	public NSMutableArray lesAxesStmr() {
		if (lesAxesStmr == null) {
			EOPprec projet = projet();
			if (projet != null) {
				lesAxesStmr = new NSMutableArray();
				NSArray<EORepartaxe> reparts = EORepartaxe.fetchEORepartaxes(
						projet.editingContext(),
						EORepartaxe.TO_PROJET.eq(projet).and(
								EORepartaxe.TEMVALIDE.eq("O")), null);
				for (EORepartaxe repart : reparts) {
					lesAxesStmr.addObject(repart.toAxe());
				}
			} else {
				lesAxesStmr = new NSMutableArray();
			}
		}
		return lesAxesStmr;
	}

	/**
	 * @param lesAxes
	 *            the lesAxes to set
	 */
	public void setLesAxesStmr(NSMutableArray lesAxesStmr) {
		this.lesAxesStmr = lesAxesStmr;
	}

	/**
	 * @return the axeStmr
	 */
	public EOAxerec axeStmr() {
		if (axeStmr == null) {
			if (lesAxesStmr().count() > 0) {
				for (EOAxerec axe : (NSMutableArray<EOAxerec>) lesAxesStmr()) {
					if (axe.isAxe()) {
						axeStmr = axe;
						break;
					}
				}
			}
		}
		return axeStmr;
	}

	/**
	 * @param axeStmr
	 *            the axeStmr to set
	 */
	public void setAxeStmr(EOAxerec axeStmr) {
		this.axeStmr = axeStmr;
	}

	/**
	 * @return the itemPole
	 */
	public EOStructureUlr getItemPole() {
		return itemPole;
	}

	/**
	 * @param itemPole
	 *            the itemPole to set
	 */
	public void setItemPole(EOStructureUlr itemPole) {
		this.itemPole = itemPole;
	}

	/**
	 * @return the selectedPole1
	 */
	public EOStructureUlr getSelectedPole1() {
		return selectedPole1;
	}

	/**
	 * @param selectedPole1
	 *            the selectedPole1 to set
	 */
	public void setSelectedPole1(EOStructureUlr selectedPole1) {
		this.selectedPole1 = selectedPole1;
	}

	/**
	 * @return the poles
	 */
	public NSMutableArray poles() {
		if (poles == null)
			poles = new NSMutableArray();
		return poles;
	}

	/**
	 * @param poles
	 *            the poles to set
	 */
	public void setPoles(NSMutableArray poles) {
		this.poles = poles;
	}

	/* initialisation des donnees */
	public void resetAll() {
		nomCourt = null;
		nomLong = null;
		porteur = null;
		dureeProjet = null;
		dateDebut = null;
		sourceFinance = null;
		listInfoPole = null;
		selectedInfoPorteur = null;
		infoPorteurRepetition = null;
		contrat = null;
		stContratSelected = null;
		partenaire = null;
		newPartList = null;
		partenaireItem = null;
		equipePrincipale = null;
		selectedEquipes = null;
		selectedEquipeSecondaire = null;
		otherList = null;
		otherRepetition = null;
		axe = null;
		haveSTMR = false;
		hasOtherSelection = false;
		haveNotSTMR = true;
		haveThmtk = false;
		selectThematique = null;
		selectedThematik = null;
		selectedTheme = null;
		selectedSouTheme = null;
		contexte = null;
		problematik = null;
		objectifs = null;
		metho = null;
		selectRhPole = null;
		selectRhPerson = null;
		personneDg = null;
		personRhRep = null;
		selectRecruePole = null;
		categSelect = null;
		nouvoPostes = null;
		postesDg = null;
		poleRecruRepetition = null;
		selectMatPole = null;
		categMatSelect = null;
		matosExistant = null;
		poleMaterielsDg = null;
		materielRep = null;
		selectNewMatPole = null;
		categMatSelect0 = null;
		nouvoMatos = null;
		materielsDg = null;
		poleNewMatRep = null;
		autreEquipeDg = null;
		equipeList = null;
		equipeRepetition = null;
		equipeSecondaireList = null;
		partAdd = null;
		motClef = null;
		motClef1 = null;
		motClef10 = null;
		motClef11 = null;
		motClef2 = null;
		motClefs = null;
		motClefs1 = null;
		motClefs2 = null;
		motClefsItem = null;
		motClefsItem1 = null;
		motClefsItem2 = null;
		avisComDP = null;
		avisComPP = null;
		avisComPS = null;
		selectedRechUnit1 = null;
		selectedEquipe1 = null;
		commentDg = null;
		motClefList = null;
		leProjetEnCours = null;
		// utilisateur = null;
		pst = null;
		partenaireDg = null;
		lesSTMR = null;
		dateIcd = null;
		listIcdSelect = null;
		itemPole = null;
		selectedPole1 = null;
		poles = null;
		lastCreateMotClef = null;
		lastPlateau = null;
		nouveauEquipement = null;
		listLibNewMat = null;
		libNewMatItem = null;
		libNewMatSelect = null;
		etabPorteur = null;
		selectedPartenaires = null;
		removedPartenaires = null;
		lesAxesStmr = null;
		selectedrhs = null;
		removedrhs = null;
		selectedRecrue = null;
		removedRecrue = null;
		selectedMaterielExistant = null;
		removedMaterielExistant = null;
		selectedMaterielAcquis = null;
		removedMaterielAcquis = null;
		selectedKeyword = null;
		removedKeyword = null;
		projet = null;
		pst = null;
		axeStmr = null;
		axe = null;
		// Filtres
		filtreContrat = null;
		filtreProjet = null;
		filtreEtat = null;
		filtrePorteur = null;
		filtreEquipe = null;
		lastCreatedPartenaire = null;
	}

	/**
	 * @return the monnaieFormatter
	 */
	public NSNumberFormatter getMonnaieFormatter() {
		return monnaieFormatter;
	}

	/**
	 * @param monnaieFormatter
	 *            the monnaieFormatter to set
	 */
	public void setMonnaieFormatter(NSNumberFormatter monnaieFormatter) {
		this.monnaieFormatter = monnaieFormatter;
	}

	/**
	 * @return the nouveauEquipement
	 */
	public EOGemateriel getNouveauEquipement() {
		return nouveauEquipement;
	}

	/**
	 * @param nouveauEquipement
	 *            the nouveauEquipement to set
	 */
	public void setNouveauEquipement(EOGemateriel nouveauEquipement) {
		this.nouveauEquipement = nouveauEquipement;
	}

	/**
	 * @return the listLibNewMat
	 */
	public NSArray<EOGemateriel> getListLibNewMat() {
		return listLibNewMat;
	}

	/**
	 * @param listLibNewMat
	 *            the listLibNewMat to set
	 */
	public void setListLibNewMat(NSArray<EOGemateriel> listLibNewMat) {
		this.listLibNewMat = listLibNewMat;
	}

	/**
	 * @return the libNewMatItem
	 */
	public EOGemateriel getLibNewMatItem() {
		return libNewMatItem;
	}

	/**
	 * @param libNewMatItem
	 *            the libNewMatItem to set
	 */
	public void setLibNewMatItem(EOGemateriel libNewMatItem) {
		this.libNewMatItem = libNewMatItem;
	}

	/**
	 * @return the libNewMatSelect
	 */
	public EOGemateriel getLibNewMatSelect() {
		return libNewMatSelect;
	}

	/**
	 * @param libNewMatSelect
	 *            the libNewMatSelect to set
	 */
	public void setLibNewMatSelect(EOGemateriel libNewMatSelect) {
		this.libNewMatSelect = libNewMatSelect;
	}

	/**
	 * @return the etabPorteur
	 */
	public String getEtabPorteur() {
		return etabPorteur;
	}

	/**
	 * @param etabPorteur
	 *            the etabPorteur to set
	 */
	public void setEtabPorteur(String etabPorteur) {
		this.etabPorteur = etabPorteur;
	}

	/**
	 * @return the blocCom
	 */
	public String getBlocCom() {
		return blocCom;
	}

	/**
	 * @param blocCom
	 *            the blocCom to set
	 */
	public void setBlocCom(String blocCom) {
		this.blocCom = blocCom;
	}

	/**
	 * @return the commentairePoles
	 */
	public EOStructureUlr commentairePoles() {
		return commentairePoles;
	}

	/**
	 * @param commentairePoles
	 *            the commentairePoles to set
	 */
	public void setCommentairePoles(EOStructureUlr commentairePoles) {
		this.commentairePoles = commentairePoles;
	}

	/**
	 * @return the filtres
	 */
	public NSMutableDictionary<String, Object> filtres() {
		if (filtres == null)
			filtres = new NSMutableDictionary<String, Object>();
		return filtres;
	}

	/**
	 * @param filtres
	 *            the filtres to set
	 */
	public void setFiltres(NSMutableDictionary<String, Object> filtres) {
		this.filtres = filtres;
	}

	/**
	 * @return the eCfiltres
	 */
	public NSMutableDictionary<String, Object> eCfiltres() {
		if (eCfiltres == null)
			eCfiltres = new NSMutableDictionary<String, Object>();
		return eCfiltres;
	}

	/**
	 * @param eCfiltres
	 *            the eCfiltres to set
	 */
	public void seteCfiltres(NSMutableDictionary<String, Object> eCfiltres) {
		this.eCfiltres = eCfiltres;
	}

	/**
	 * @return the pageName
	 */
	public String pageName() {
		return pageName;
	}

	/**
	 * @param pageName
	 *            the pageName to set
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	/**
	 * @return the myHome
	 */
	public WOComponent myHome() {/*
		if (pageName().equals(ACCUEIL)) {
			Accueil accueil = (Accueil) myHome.pageWithName(Accueil.class
					.getName());
			if (accueil.getAppUtilisateur() == null)
				accueil.setAppUtilisateur(utilisateur());
			myHome = accueil;
		} else {
			EnseignantsChercheursView ECView = (EnseignantsChercheursView) myHome
					.pageWithName(EnseignantsChercheursView.class.getName());
			if (ECView.getAppUtilisateur() == null)
				ECView.setAppUtilisateur(utilisateur());
			myHome = ECView;
		}*/
		if(myEnv().valueForKey("pageName").equals(ACCUEIL) && (Boolean) myEnv().valueForKey("PNA") && !((Boolean) myEnv().valueForKey("PECV"))) {
			myHome = (Accueil) ( myEnv().valueForKey("myComponent"));
			if((Boolean) myEnv().valueForKey("Refresh")) {
				myHome = myHome.pageWithName(Accueil.class.getName());
				myEnv().setObjectForKey(false, "Refresh");
			}
		} else {
			myHome = (EnseignantsChercheursView) (myEnv().valueForKey("myComponent"));
			if((Boolean) myEnv().valueForKey("Refresh")) {
				myHome = myHome.pageWithName(EnseignantsChercheursView.class.getName());
				myEnv().setObjectForKey(false, "Refresh");
			}
		}
		return myHome;
	}

	/**
	 * @param myHome
	 *            the myHome to set
	 */
	public void setMyHome(WOComponent myHome) {
		this.myHome = myHome;
	}

	/**
	 * @return the myEnv
	 */
	public NSMutableDictionary myEnv() {
		if(myEnv == null)
			myEnv = new NSMutableDictionary();
		return myEnv;
	}

	/**
	 * @param myEnv the myEnv to set
	 */
	public void setMyEnv(NSMutableDictionary myEnv) {
		this.myEnv = myEnv;
	}

}
