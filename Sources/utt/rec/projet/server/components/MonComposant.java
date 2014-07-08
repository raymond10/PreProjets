/**
 * 
 */
package utt.rec.projet.server.components;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;
import org.cocktail.fwkcktlajaxwebext.serveur.CktlResourceProvider;
import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.cocktail.fwkcktlpersonne.common.metier.EORepartAssociation;
import org.cocktail.fwkcktlpersonne.common.metier.EOStructure;

import utt.rec.projet.server.Application;
import utt.rec.projet.server.EnseignantApplicationUser;
import utt.rec.projet.server.PPrecApplicationUser;
import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.appserver.ERXWOContext;
import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXQ;
import er.extensions.localization.ERXLocalizer;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class MonComposant extends CktlAjaxWOComponent implements
		CktlResourceProvider {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3709099289374802044L;

	private String onloadJS = null;
	public static final String BINDING_utilisateurPersId = "utilisateurPersId";
	private String _id;
	private EOUtilisateur appUtilisateur;
	private Boolean isUpdate = null;
	public static final String UPDATE_BDG = "update";
	public static Integer PERS_ID = 0;
	// Gestion des droits
	private PPrecApplicationUser userGd = null;
	private EnseignantApplicationUser userJa = null;
	private Boolean accesPprec = null;
	private Integer persId = null;
	private Integer noIndividu = null;
	private String nomPrenoms = null;
	private Boolean droitTout = null;
	private Boolean cCCR = null;
	private Boolean peutCreerProjet = null;
	private Boolean peutConsultertProjet = null;
	private Boolean peutUpdateProject = null;
	private Boolean peutDeleteProjet = null;
	private Boolean peutViserProjet = null;
	private Boolean peutValiderProjet = null;
	private Boolean estRepPrgAc = null;
	private Boolean estDrtPole = null;
	private Boolean estMembreIcd = null;
	private Boolean estCreateur = null;
	private Boolean estPorteur = null;
	private Boolean estImplique = null;
	//Initialize
	private Session sess;
	private EOPprec projet;
	private Application app;
	private ERXLocalizer local;
	private EnseignantApplicationUser appJAUser;
	private PPrecApplicationUser appGDUser;
	private EOUtilisateur user;
	private EOPprec mySelectedProject;
	private EOEditingContext projectEdc;

	public MonComposant(WOContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		Boolean update = (Boolean) valueForBinding(UPDATE_BDG);
		//mySession().setUpdate(update);
	}

	/**
	 * @return the isUpdate
	 */
	public Boolean isUpdate() {
		isUpdate = booleanValueForBinding(UPDATE_BDG, false);
		return isUpdate;
	}

	/**
	 * @param isUpdate
	 *            the isUpdate to set
	 */
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
		setValueForBinding(isUpdate, UPDATE_BDG);
		mySession().setUpdate(isUpdate);
	}

	public Session mySession() {
		if (sess == null) {
			try {
				sess = (Session) session();
			} catch (Exception e) {
				sess = (Session) Session.anySession();
				sess.awake();
				//e.printStackTrace();
			}
		}
		return sess;
	}
	
	public void setMySession(Session session) {
		sess = session;
	}

	public Application myApp() {
		if(app == null)
			app = (Application) application();
		return app;
	}

	public EOPprec myProjet() {
		if(projet == null)
			projet = mySession().projet();
		return projet;
	}

	public void setMyProjet(EOPprec Projet) {
		mySession().setProjet(Projet);
		projet = Projet;
	}

	public ERXLocalizer myLocalizer() {
		if(local == null)
			local = mySession().localizer();
		return local;
	}

	public EnseignantApplicationUser myAppJAUser() {
		if(appJAUser == null)
			appJAUser = mySession().applicationJAUser();
		return appJAUser;
	}

	public PPrecApplicationUser myAppGDUser() {
		if(appGDUser == null)
			appGDUser = mySession().applicationGDUser();
		return appGDUser;
	}

	public EOUtilisateur myUser() {
		if(user == null)
			user = mySession().utilisateur();
		return user;
	}

	public EOPprec mySelectedProject() {
		if(mySelectedProject == null)
			mySelectedProject = mySession().getProjectSelected();
		return mySelectedProject;
	}

	public EOUtilisateur utilisateurInContext(EOEditingContext ed) {
		EOUtilisateur user = mySession().utilisateur();
		if (user.editingContext().equals(ed) == false) {
			user = (EOUtilisateur) ed.faultForGlobalID(
					edc().globalIDForObject(user), ed);
		}
		return user;
	}

	public Integer utilisateurPersId() {
		Integer persId = 0;
			persId = persId();
			PERS_ID = persId;
		return persId;
	}

	public EOEditingContext edc() {
		return ERXEC.newEditingContext();
	}

	public EOEditingContext edcProjet() {
		if(projectEdc == null)
			projectEdc = myProjet().editingContext();
		return projectEdc;
	}

	public EOEditingContext nestedEdc() {
		return mySession().nestedEdc();
	}

	/**
	 * @return the onloadJS
	 */
	public String onloadJS() {
		return onloadJS;
	}

	/**
	 * @param onloadJS
	 *            the onloadJS to set
	 */
	public void setOnloadJS(String onloadJS) {
		this.onloadJS = onloadJS;
	}

	public Logger logger() {
		return myApp().logger();
	}

	protected String uniqueDomId() {
		if (_id == null)
			_id = ERXWOContext.safeIdentifierName(context(), true);
		return _id;
	}

	public String plateauDialogId() {
		return "plateau_" + uniqueDomId();
	}

	public String equipementDialogId() {
		return "equipement_" + uniqueDomId();
	}

	public String commentDialodId() {
		return "comment_" + uniqueDomId();
	}

	public EOPprec leProjetEnCours() {
		return mySession().leProjetEnCours();
	}

	public void setLeProjetEnCours(EOPprec leProjetEnCours) {
		mySession().setLeProjetEnCours(leProjetEnCours);
	}

	public Number idProj() {
		return mySession().getIdProjetRecent();
	}

	public void setIdProj(Number id) {
		mySession().setIdProjetRecent(id);
	}

	public NSMutableArray myKeywordList() {
		return mySession().selectedKeyword();
	}

	public void setMyKeywordList(NSMutableArray list) {
		mySession().setSelectedKeyword(list);
	}

	public NSMutableArray myKeywordDel() {
		return mySession().removedKeyword();
	}

	public void setMyKeywordDel(NSMutableArray list) {
		mySession().setRemovedKeyword(list);
	}

	/**
	 * @return the appUtilisateur
	 */
	public EOUtilisateur getAppUtilisateur() {
		return appUtilisateur;
	}

	/**
	 * @param appUtilisateur
	 *            the appUtilisateur to set
	 */
	public void setAppUtilisateur(EOUtilisateur appUtilisateur) {
		this.appUtilisateur = appUtilisateur;
		if (appUtilisateur != null) {
			mySession().setUtilisateur(appUtilisateur);
		}
	}

	public void handleErrorMessage(WOResponse response) {
		String message = mySession().getAlertMessage();
		if (message != null && message.equals("") == false) {
			String str = "<script language=\"javascript\" type=\"text/javascript\">\n";
			str += "alert(\"" + message + "\");\n";
			if (onloadJS != null) {
				str += onloadJS;
			}
			str += "</script>";
			response.appendContentString(str);
			mySession().setAlertMessage(null);
		}
	}

	@Override
	public void validationFailedWithException(Throwable e, Object obj,
			String keyPath) {
		super.validationFailedWithException(e, obj, keyPath);
	}

	@Override
	public void injectResources(WOResponse response, WOContext context) {
		// TODO Auto-generated method stub
		PprecHelpers.insertStylesSheet(context, response);

	}

	public WOActionResults doNothing() {
		return null;
	}

	public WOActionResults submit() {
		return null;
	}

	public NSMutableArray myPoles() {
		return mySession().myPoles();
	}

	public boolean isInGrhumAccessStructures() {
		NSArray<String> cStructurePprecUsers = myApp()
				.getCStructuresAccesPprec().allObjects();
		EOQualifier qualifier = ERXQ
				.is(EORepartAssociation.PERS_ID_KEY, utilisateurPersId())
				.and(ERXQ.in(EORepartAssociation.C_STRUCTURE_KEY,
						cStructurePprecUsers))
				.and(ERXQ.is(EORepartAssociation.RAS_D_FERMETURE_KEY, null).or(
						ERXQ.greaterThanOrEqualTo(
								EORepartAssociation.RAS_D_FERMETURE_KEY,
								new NSTimestamp())));
		boolean access = (EORepartAssociation.fetchAll(edc(), qualifier)
				.count() > 0);
		return access;
	}

	public EOStructure admResp() {
		String cStructure = myApp().cStrctureAdmResp();
		return EOStructure.structurePourCode(edc(), cStructure);
	}

	public EOStructure drResp() {
		String cStructure = myApp().cStrctureDrResp();
		return EOStructure.structurePourCode(edc(), cStructure);
	}

	public EOStructure umrStmr() {
		String cStructure = myApp().cStrctureUmrStmr();
		return EOStructure.structurePourCode(edc(), cStructure);
	}

	public EOStructure cCAAP() {
		String cStructure = myApp().cStructureCccr();
		return EOStructure.structurePourCode(edc(), cStructure);
	}

	// Gestion des droits
	/**
	 * @return the userGd
	 */
	public PPrecApplicationUser userGd() {
		if (userGd == null)
			userGd = myAppGDUser();
		return userGd;
	}

	/**
	 * @param userGd
	 *            the userGd to set
	 */
	public void setUserGd(PPrecApplicationUser userGd) {
		this.userGd = userGd;
	}

	/**
	 * @return the userJa
	 */
	public EnseignantApplicationUser userJa() {
		if (userJa == null)
			userJa = myAppJAUser();
		return userJa;
	}

	/**
	 * @param userJa
	 *            the userJa to set
	 */
	public void setUserJa(EnseignantApplicationUser userJa) {
		this.userJa = userJa;
	}

	/**
	 * @return the accesPprec
	 */
	public Boolean accesPprec() {
		if (accesPprec == null) {
			if (myApp().newGestionDroitsEnabled()) {
				accesPprec = userGd().getPprecAutorisationCache()
						.gDPprecAcces();
			} else {
				accesPprec = userJa().hasDroitAccesPprec();
			}
		}
		return accesPprec;
	}

	/**
	 * @param accesPprec
	 *            the accesPprec to set
	 */
	public void setAccesPprec(Boolean accesPprec) {
		this.accesPprec = accesPprec;
	}

	/**
	 * @return the droitTout
	 */
	public Boolean droitTout() {
		if (droitTout == null) {
			if (myApp().newGestionDroitsEnabled()) {
				droitTout = userGd().getPprecAutorisationCache()
						.gDPprecSuperUserProjet();
			} else {
				droitTout = userJa().hasDroitTous();
			}
		}
		return droitTout;
	}

	/**
	 * @param droitTout
	 *            the droitTout to set
	 */
	public void setDroitTout(Boolean droitTout) {
		this.droitTout = droitTout;
	}

	/**
	 * @return the cCCR
	 */
	public Boolean cCCR() {
		if (cCCR == null) {
			if (myApp().newGestionDroitsEnabled()) {
				cCCR = userGd().getPprecAutorisationCache()
						.gDPprecTraiterProjet();
			} else {
				cCCR = userJa().hasDroitTraitementProjet();
			}
		}
		return cCCR;
	}

	/**
	 * @param cCCR
	 *            the cCCR to set
	 */
	public void setcCCR(Boolean cCCR) {
		this.cCCR = cCCR;
	}

	/**
	 * @return the peutCreerProjet
	 */
	public Boolean peutCreerProjet() {
		if (peutCreerProjet == null) {
			if (myApp().newGestionDroitsEnabled()) {
				peutCreerProjet = userGd().getPprecAutorisationCache()
						.gDPprecCreationProjet() || droitTout();
			} else {
				peutCreerProjet = userJa().hasDroitCreationProjet()
						|| droitTout();
			}
		}
		return peutCreerProjet;
	}

	/**
	 * @param peutCreerProjet
	 *            the peutCreerProjet to set
	 */
	public void setPeutCreerProjet(Boolean peutCreerProjet) {
		this.peutCreerProjet = peutCreerProjet;
	}

	/**
	 * @return the peutConsultertProjet
	 */
	public Boolean peutConsultertProjet() {
		if (peutConsultertProjet == null) {
			if (myApp().newGestionDroitsEnabled()) {
				peutConsultertProjet = userGd().getPprecAutorisationCache()
						.gDPprecConsultationProjet();
			} else {
				peutConsultertProjet = userJa().hasDroitConsultationProjet();
			}
		}
		return peutConsultertProjet;
	}

	/**
	 * @param peutConsultertProjet
	 *            the peutConsultertProjet to set
	 */
	public void setPeutConsultertProjet(Boolean peutConsultertProjet) {
		this.peutConsultertProjet = peutConsultertProjet;
	}

	/**
	 * @return the peutUpdateProject
	 */
	public Boolean peutUpdateProject() {
		if (peutUpdateProject == null) {
			if (myApp().newGestionDroitsEnabled()) {
				peutUpdateProject = userGd().getPprecAutorisationCache()
						.gDPprecModificationProjet();
			} else {
				peutUpdateProject = userJa().hasDroitModificationProjet();
			}
		}
		return peutUpdateProject;
	}

	/**
	 * @param peutUpdateProject
	 *            the peutUpdateProject to set
	 */
	public void setPeutUpdateProject(Boolean peutUpdateProject) {
		this.peutUpdateProject = peutUpdateProject;
	}

	/**
	 * @return the peutDeleteProjet
	 */
	public Boolean peutDeleteProjet() {
		if (peutDeleteProjet == null) {
			if (myApp().newGestionDroitsEnabled()) {
				peutDeleteProjet = userGd().getPprecAutorisationCache()
						.gDPprecSupressionProjet();
			} else {
				peutDeleteProjet = userJa().hasDroitAbandonnerProjet();
			}
		}
		return peutDeleteProjet;
	}

	/**
	 * @param peutDeleteProjet
	 *            the peutDeleteProjet to set
	 */
	public void setPeutDeleteProjet(Boolean peutDeleteProjet) {
		this.peutDeleteProjet = peutDeleteProjet;
	}

	/**
	 * @return the peutViserProjet
	 */
	public Boolean peutViserProjet() {
		if (peutViserProjet == null) {
			if (myApp().newGestionDroitsEnabled()) {
				peutViserProjet = userGd().getPprecAutorisationCache()
						.gDPprecVisaProjet() || estRepPrgAc();
			} else {
				peutViserProjet = userJa().hasDroitVisaProjet();
			}
		}
		return peutViserProjet;
	}

	/**
	 * @param peutViserProjet
	 *            the peutViserProjet to set
	 */
	public void setPeutViserProjet(Boolean peutViserProjet) {
		this.peutViserProjet = peutViserProjet;
	}

	/**
	 * @return the peutValiderProjet
	 */
	public Boolean peutValiderProjet() {
		if (peutValiderProjet == null) {
			if (myApp().newGestionDroitsEnabled()) {
				peutValiderProjet = userGd().getPprecAutorisationCache()
						.gDPprecVisaProjet();
			} else {
				peutValiderProjet = userJa().hasDroitValidationProjet();
			}
		}
		return peutValiderProjet;
	}

	/**
	 * @param peutValiderProjet
	 *            the peutValiderProjet to set
	 */
	public void setPeutValiderProjet(Boolean peutValiderProjet) {
		this.peutValiderProjet = peutValiderProjet;
	}

	/**
	 * @return the estRepPrgAc
	 */
	public Boolean estRepPrgAc() {
		if (estRepPrgAc == null) {
			if (myApp().newGestionDroitsEnabled()) {
				estRepPrgAc = userGd().getPprecAutorisationCache()
						.gDPprecResponsableEquipe();
			} else {
				estRepPrgAc = userJa().hasDroitResponsablePrgAccueilProjet();
			}
		}
		return estRepPrgAc;
	}

	/**
	 * @param estRepPrgAc
	 *            the estRepPrgAc to set
	 */
	public void setEstRepPrgAc(Boolean estRepPrgAc) {
		this.estRepPrgAc = estRepPrgAc;
	}

	/**
	 * @return the estDrtPole
	 */
	public Boolean estDrtPole() {
		if (estDrtPole == null) {
			if (myApp().newGestionDroitsEnabled()) {
				estDrtPole = userGd().getPprecAutorisationCache()
						.gDPprecDirecteurPole();
			} else {
				estDrtPole = userJa().hasDroitDirecteurPole();
			}
		}
		return estDrtPole;
	}

	/**
	 * @param estDrtPole
	 *            the estDrtPole to set
	 */
	public void setEstDrtPole(Boolean estDrtPole) {
		this.estDrtPole = estDrtPole;
	}

	/**
	 * @return the estMembreIcd
	 */
	public Boolean estMembreIcd() {
		if (estMembreIcd == null) {
			if (myApp().newGestionDroitsEnabled()) {
				estMembreIcd = userGd().getPprecAutorisationCache()
						.gDPprecMembreIcd();
			} else {
				estMembreIcd = userJa().hasDroitMembreIcd();
			}
		}
		return estMembreIcd;
	}

	/**
	 * @param estMembreIcd
	 *            the estMembreIcd to set
	 */
	public void setEstMembreIcd(Boolean estMembreIcd) {
		this.estMembreIcd = estMembreIcd;
	}

	/**
	 * @return the persId
	 */
	public Integer persId() {
		if (persId == null) {
			if (myApp().newGestionDroitsEnabled()) {
				persId = userGd().getPersId();
				PERS_ID = persId;
			} else {
				persId = userJa().getPersId();
				PERS_ID = persId;
			}
		}
		return persId;
	}

	/**
	 * @param persId
	 *            the persId to set
	 */
	public void setPersId(Integer persId) {
		this.persId = persId;
	}

	/**
	 * @return the noIndividu
	 */
	public Integer noIndividu() {
		if (noIndividu == null) {
			if (myApp().newGestionDroitsEnabled()) {
				noIndividu = userGd().getNoIndividu();
			} else {
				noIndividu = userJa().getNoIndividu();
			}
		}
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
	 * @return the nomPrenoms
	 */
	public String nomPrenoms() {
		if (nomPrenoms == null) {
			if (myApp().newGestionDroitsEnabled()) {
				if(userGd() != null)
					nomPrenoms = userGd().getNomAndPrenom();
			} else {
				if(userJa() != null)
					nomPrenoms = userJa().getNomAndPrenom();
			}
		}
		return nomPrenoms;
	}

	/**
	 * @param nomPrenoms
	 *            the nomPrenoms to set
	 */
	public void setNomPrenoms(String nomPrenoms) {
		this.nomPrenoms = nomPrenoms;
	}

	/**
	 * @return the estCreateur
	 */
	public Boolean estCreateur(EOPprec projet) {
		if (myApp().newGestionDroitsEnabled()) {
			estCreateur = userGd().estCreateur(projet);
		} else {
			estCreateur = userJa().estCreateur(projet);
		}
		return estCreateur;
	}

	/**
	 * @param estCreateur
	 *            the estCreateur to set
	 */
	public void setEstCreateur(Boolean estCreateur) {
		this.estCreateur = estCreateur;
	}

	/**
	 * @return the estPorteur
	 */
	public Boolean estPorteur(EOPprec projet) {
		if (myApp().newGestionDroitsEnabled()) {
			estPorteur = userGd().estPorteur(projet);
		} else {
			estPorteur = userJa().estPorteur(projet);
		}
		return estPorteur;
	}

	/**
	 * @param estPorteur
	 *            the estPorteur to set
	 */
	public void setEstPorteur(Boolean estPorteur) {
		this.estPorteur = estPorteur;
	}

	/**
	 * @return the estImplique
	 */
	public Boolean estImplique(EOPprec projet) {
		if (myApp().newGestionDroitsEnabled()) {
			estImplique = userGd().estImplique(projet);
		} else {
			estImplique = userJa().estImplique(projet);
		}
		return estImplique;
	}

	/**
	 * @param estImplique
	 *            the estImplique to set
	 */
	public void setEstImplique(Boolean estImplique) {
		this.estImplique = estImplique;
	}
	
	public WOComponent home() {
		return mySession().myHome();
	}

}
