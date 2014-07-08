package utt.rec.projet.server;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;
import org.cocktail.fwkcktldroitsutils.common.util.MyStringCtrl;
import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.cocktail.fwkcktlpersonne.common.metier.IPersonne;
import org.cocktail.fwkcktlpersonne.common.metier.PersonneDelegate;
import org.cocktail.fwkcktlwebapp.common.CktlLog;
import org.cocktail.fwkcktlwebapp.common.CktlUserInfo;
import org.cocktail.fwkcktlwebapp.common.database.CktlUserInfoDB;
import org.cocktail.fwkcktlwebapp.common.util.StringCtrl;
import org.cocktail.fwkcktlwebapp.server.CktlWebAction;
import org.cocktail.fwkcktlwebapp.server.components.CktlAlertPage;
import org.cocktail.fwkcktlwebapp.server.components.CktlLogin;
import org.cocktail.fwkcktlwebapp.server.components.CktlLoginResponder;
import org.openqa.selenium.internal.seleniumemulation.GetValue;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WORedirect;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.eof.ERXEC;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.DAValidateMain;
import utt.rec.projet.server.components.DAVisaMain;
import utt.rec.projet.server.components.EditProject;
import utt.rec.projet.server.components.EnseignantsChercheursView;
import utt.rec.projet.server.components.Login;
import utt.rec.projet.server.components.LoginCAS;
import utt.rec.projet.server.components.Main;
import utt.rec.projet.server.components.SoumiProject;
import utt.rec.projet.server.components.Timeout;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.grhum.EOCompte;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class DirectAction extends CktlWebAction {

	private String loginComment;
	EOUtilisateur utilisateur = new EOUtilisateur();
	EOEditingContext ec = ERXEC.newEditingContext();
	private NSDictionary actionParams;
	public final static String PROJET_ID_KEY = "projetId";
	public final static String DIRECTVISA = "directVisa";
	public final static String DIRECTVALIDATE = "directValidate";
	Boolean directVisa = null;
	Boolean directValidate = null;

	public DirectAction(WORequest request) {
		super(request);
	}

	protected Session laSession() {
		Session cngSession = (Session) existingSession();
		if (cngSession == null) {
			cngSession = (Session) session();
		}
		return cngSession;
	}

	public Application pprecApp() {
		return (Application) WOApplication.application();
	}

	public WOActionResults defaultAction() {
		NSMutableDictionary params = new NSMutableDictionary();
		if (useCasService()) {
			params.put(DIRECTVISA, new Boolean(false));
			params.put(DIRECTVALIDATE, new Boolean(false));
			setActionParams(params.immutableClone());
			laSession().setActionParams(params.immutableClone());
			return loginCASPage();
		} else {
			params.put(DIRECTVISA, new Boolean(false));
			params.put(DIRECTVALIDATE, new Boolean(false));
			setActionParams(params.immutableClone());
			laSession().setActionParams(params.immutableClone());
			return pageWithName(Main.class.getName());
		}
	}

	/**
	 * @param actionParams
	 *            the actionParams to set
	 */
	public void setActionParams(NSDictionary actionParams) {
		this.actionParams = actionParams;
	}

	public NSDictionary actionParams() {
		if (actionParams == null)
			actionParams = laSession().getActionParams();
		return actionParams;
	}

	/**
	 * Execute l'action par defaut de l'application Pprec(Login sur le CAS)
	 */
	public WOActionResults myDefaultAction() {
		if (useCasService())
			return loginCASPage();
		else
			return loginNoCasPage(null);
	}

	public WOActionResults sessionExpiredAction() {
		Timeout nextPage = (Timeout) pageWithName(Timeout.class.getName());
		return nextPage;
	}

	public WOActionResults applicationExceptionAction() {
		WOComponent nextPage = null;
		if (laSession().myEnv().valueForKey("pageName").equals("Accueil")
				&& (Boolean) laSession().myEnv().valueForKey("PNA")
				&& !((Boolean) laSession().myEnv().valueForKey("PECV"))) {
			nextPage = (Accueil) pageWithName(Accueil.class.getName());
			((Accueil) nextPage).setIsOpenFenetreException(true);
		} else {
			nextPage = (EnseignantsChercheursView) pageWithName(EnseignantsChercheursView.class
					.getName());
			((EnseignantsChercheursView) nextPage)
					.setIsOpenFenetreException(true);
		}
		return nextPage;
	}

	public WOComponent pageProjetSoumisAction() {
		SoumiProject nextPage = (SoumiProject) pageWithName(SoumiProject.class
				.getName());
		return nextPage;
	}

	public WOComponent AccueilAction() {
		Accueil nextPage = (Accueil) pageWithName(Accueil.class.getName());
		return nextPage;
	}

	/**
	 * CAS : traitement authentification OK
	 */
	public WOActionResults loginCasSuccessPage(String netid) {
		NSDictionary actionParams = getParamsFromRequest(request(), null);
		try {
			WOActionResults nextPage = null;
			IPersonne pers = PersonneDelegate.fetchPersonneForLogin(ec, netid);
			if (pers == null) {
				throw new Exception(
						"Impossible de recuperer un objet personne associe au login "
								+ netid);
			}
			String erreur = laSession().setConnectedUser(netid);
			if (actionParams.count() > 0
					&& (actionParams.containsKey(DIRECTVISA) || actionParams
							.containsKey(DIRECTVALIDATE))) {
				this.directVisa = false;
				this.directValidate = false;
				String directVisa = (String) actionParams
						.valueForKey(DIRECTVISA);
				String directValidate = (String) actionParams
						.valueForKey(DIRECTVALIDATE);
				if (!MyStringCtrl.isEmpty(directVisa)) {
					if (directVisa.equals("O") || directVisa.equals("OUI")) {
						this.directVisa = new Boolean(true);
						this.directValidate = new Boolean(false);
					}
				}
				if (!MyStringCtrl.isEmpty(directValidate)) {
					if (directValidate.equals("O")
							|| directValidate.equals("OUI")) {
						this.directValidate = new Boolean(true);
						this.directVisa = new Boolean(false);
					}
				}
			} else {
				this.directVisa = false;
				this.directValidate = false;
				if (actionParams.containsKey("mot_de_passe"))
					actionParams.put("mot_de_passe", "deleted for log");
				NSLog.out.appendln("actionParams :" + actionParams);
				try {
					NSLog.out.appendln("actionParams() :" + actionParams());
					directVisa = (Boolean) actionParams().valueForKey(
							DIRECTVISA);
					directValidate = (Boolean) actionParams().valueForKey(
							DIRECTVALIDATE);
				} catch (Exception e) {

				}
			}
			NSArray utilisateurs = EOUtilities.objectsMatchingKeyAndValue(ec,
					EOUtilisateur.ENTITY_NAME, "persId", pers.persId());
			if (utilisateurs != null && utilisateurs.count() == 1) {
				utilisateur = (EOUtilisateur) utilisateurs.lastObject();
				laSession().setUtilisateur(utilisateur);
			}
			// Vérifier la validité du compte
			if (!EOCompte.isCompteValide(ec, netid))
				erreur = "Vous n'êtes pas autorisé à utiliser cette application, votre login est invalide";
			// Vérifier la validité du personnel
			if (erreur != null)
				throw new Exception(erreur);
			if (pprecApp().newGestionDroitsEnabled()) {
				// Connexion par gestion de droit
				PPrecApplicationUser appGDUser = new PPrecApplicationUser(
						pers.persId());
				laSession().setApplicationGDUser(appGDUser);
				if (appGDUser.getPprecAutorisationCache()
						.gDPprecSuperUserProjet()
						|| appGDUser.getPprecAutorisationCache()
								.gDPprecMembreIcd()
						|| appGDUser.getPprecAutorisationCache()
								.gDPprecTraiterProjet()) {
					// Connexion Admin, ICD, AAAP
					laSession().setPageName("Accueil");
					laSession().myEnv().put("myComponent",
							pageWithName(Accueil.class.getName()));
					laSession().myEnv().put("pageName", laSession().pageName());
					laSession().myEnv().put("PECV", false);
					laSession().myEnv().put("PNA", true);
					laSession().myEnv().put("Refresh", false);
				} else {
					// Connexion EC
					laSession().setPageName("EnseignantsChercheursView");
					laSession().myEnv().put("pageName", laSession().pageName());
					laSession().myEnv().put(
							"myComponent",
							pageWithName(EnseignantsChercheursView.class
									.getName()));
					laSession().myEnv().put("PECV", true);
					laSession().myEnv().put("PNA", false);
					laSession().myEnv().put("Refresh", false);
				}
			} else {
				// Connexion par JefyAdmin
				EnseignantApplicationUser appJAUser = new EnseignantApplicationUser(
						ec, Application.TYPE_APP_STR, pers.persId());
				laSession().setApplicationJAUser(appJAUser);
				if (appJAUser.hasDroitSuperUserProjet()
						|| appJAUser.hasDroitMembreIcd()
						|| appJAUser.hasDroitTraitementProjet()) {
					// Connexion Admin, ICD, AAAP
					laSession().setPageName("Accueil");
					laSession().myEnv().put("myComponent",
							pageWithName(Accueil.class.getName()));
					laSession().myEnv().put("pageName", laSession().pageName());
					laSession().myEnv().put("PECV", false);
					laSession().myEnv().put("PNA", true);
					laSession().myEnv().put("Refresh", false);

				} else {
					// Connexion EC
					laSession().setPageName("EnseignantsChercheursView");
					laSession().myEnv().put("pageName", laSession().pageName());
					laSession().myEnv().put(
							"myComponent",
							pageWithName(EnseignantsChercheursView.class
									.getName()));
					laSession().myEnv().put("PECV", true);
					laSession().myEnv().put("PNA", false);
					laSession().myEnv().put("Refresh", false);

				}
			}
			// ERXEC.unlockAllContextsForCurrentThread();
			if (directVisa) {
				if (!(nextPage instanceof CktlAlertPage)) {
					nextPage = getVisaPage(laSession(), actionParams());
					return nextPage;
				}
			}
			if (directValidate) {
				if (!(nextPage instanceof CktlAlertPage)) {
					nextPage = getValidatePage(laSession(), actionParams());
					return nextPage;
				}
			}
			return laSession().myHome();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return getErrorPage(e.getMessage());
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public WOActionResults loginCasSuccessPage(String netid,
			NSDictionary actionParams) {
		return loginCasSuccessPage(netid);
	}

	@Override
	public WOActionResults loginCasFailurePage(String errorMessage,
			String errorCode) {
		// log.info("loginCasFailurePage : " + errorMessage + " (" +
		// errorMessage + ")");
		StringBuffer msg = new StringBuffer();
		msg.append("Une erreur s'est produite lors de l'authentification de l'uilisateur&nbsp;:<br><br>");
		if (errorMessage != null)
			msg.append("&nbsp;").append(errorMessage);
		return getErrorPage(msg.toString());
	}

	public WOComponent getErrorPage(String errorMessage) {
		CktlAlertPage page = (CktlAlertPage) cktlApp.pageWithName(
				CktlAlertPage.class.getName(), context());
		// NSLog.out.appendln(errorMessage);
		page.showMessage(null, cktlApp.name() + " : ERREUR", errorMessage,
				null, null, null, CktlAlertPage.ERROR, null);
		return page;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public WOActionResults loginNoCasPage(NSDictionary actionParams) {
		Main page = (Main) pageWithName(Main.class.getName());
		page.registerLoginResponder(getNewLoginResponder(actionParams));
		return page;
	}

	// Cas
	public WOActionResults loginCASPage() {
		String url = DirectAction.getLoginActionURL(this.context(), false,
				null, true, null);
		WORedirect page = (WORedirect) pageWithName(WORedirect.class.getName());
		page.setUrl(url);
		return page;
	}

	// Deconnection
	public WOActionResults quitterAction() {
		if (useCasService())
			return casLogOut();
		else
			return laSession().onQuitter();
	}

	public WOActionResults casLogOut() {
		WORedirect nextPage = (WORedirect) cktlApp.pageWithName(
				WORedirect.class.getName(), context());
		String url = casLogoutURL(); // ==> on récupère l'URL de déconnexion
										// définie dans le fichier .config
		nextPage.setUrl(url);
		laSession().terminate();
		return nextPage;
	}

	// link cas
	public WOActionResults linkCas() {
		LoginCAS page = (LoginCAS) pageWithName(LoginCAS.class.getName());
		page.setTitleComment(loginComment());
		page.setCASLoginLink(casLoginLink());
		laSession().terminate();
		laSession().defaultEditingContext().revert();
		return page;
	}

	/*
	 * // Cas public WOActionResults loginCASPage() {
	 * 
	 * String url = DirectAction.getLoginActionURL(this.context(), false, null,
	 * true, null); WORedirect page = (WORedirect)
	 * pageWithName(WORedirect.class.getName()); page.setUrl(url);
	 * 
	 * LoginCAS page = (LoginCAS) pageWithName(LoginCAS.class.getName());
	 * page.setTitleComment(loginComment());
	 * page.setCASLoginLink(casLoginLink()); return page; }
	 */

	public WOActionResults mailUsersAction() {
		String destinataire = cktlApp.config().stringForKey("APP_ADMIN_MAIL");
		WORequest req = request();
		if (req.formValueForKey("dest") != null) {
			destinataire = (String) req.formValueForKey("dest");
		}
		cktlApp.mailBus()
				.sendMail(
						destinataire,
						cktlApp.config().stringForKey("APP_ADMIN_MAIL"),
						null,
						"[" + cktlApp.name()
								+ "]Utilisateur connecté à l'application ",
						"Liste des emails : \n"
								+ ((Application) WOApplication.application())
										.utilisateurs()
										.componentsJoinedByString(","));
		return defaultAction();
	}

	public String loginComment() {
		return loginComment;
	}

	public void setLoginComment(String comment) {
		loginComment = comment;
	}

	private String casLoginLink() {
		return null;
	}

	public WOActionResults validerLoginAction() {
		directVisa = false;
		directValidate = false;
		NSMutableDictionary params = new NSMutableDictionary();
		params.put(DIRECTVISA, directVisa);
		params.put(DIRECTVALIDATE, directValidate);
		setActionParams(params.immutableClone());
		laSession().setActionParams(params.immutableClone());
		WOActionResults page = null;
		WORequest request = context().request();
		String login = StringCtrl.normalize((String) request
				.formValueForKey("identifiant"));
		String password = StringCtrl.normalize((String) request
				.formValueForKey("mot_de_passe"));
		String messageErreur = null;
		CktlLoginResponder loginResponder = getNewLoginResponder(null);
		CktlUserInfo loggedUserInfo = new CktlUserInfoDB(cktlApp.dataBus());
		if (login.length() == 0) {
			messageErreur = "Vous devez renseigner l'identifiant.";
		} else if (!loginResponder.acceptLoginName(login)) {
			messageErreur = "Vous n'êtes pas autorisé à utiliser cette application";
		} else {
			if (password == null)
				password = "";
			loggedUserInfo.setRootPass(loginResponder.getRootPassword());
			loggedUserInfo.setAcceptEmptyPass(loginResponder
					.acceptEmptyPassword());
			loggedUserInfo.compteForLogin(login, password, true);
			if (loggedUserInfo.errorCode() != CktlUserInfo.ERROR_NONE) {
				if (loggedUserInfo.errorMessage() != null)
					messageErreur = loggedUserInfo.errorMessage();
				CktlLog.rawLog(">> Erreur | " + loggedUserInfo.errorMessage());
			}
		}
		if (!EOCompte.isCompteValide(ec, login))
			messageErreur = "Vous n'êtes pas autorisé à utiliser cette application, votre login est invalide";
		NSArray utilisateurs = null;
		if (messageErreur == null) {
			laSession().setConnectedUserInfo(loggedUserInfo);
			String erreur = laSession()
					.setConnectedUser(loggedUserInfo.login());
			if (erreur != null) {
				messageErreur = erreur;
			} else {
				Integer persId = Integer.valueOf(loggedUserInfo.persId()
						.intValue());
				if (pprecApp().newGestionDroitsEnabled()) {
					PPrecApplicationUser appGDUser = new PPrecApplicationUser(
							persId);
					laSession().setApplicationGDUser(appGDUser);
					utilisateurs = EOUtilities.objectsMatchingKeyAndValue(ec,
							EOUtilisateur.ENTITY_NAME, "persId",
							appGDUser.getPersId());
				} else {
					EnseignantApplicationUser appJAUser = new EnseignantApplicationUser(
							ec, Application.TYPE_APP_STR, persId);
					laSession().setApplicationJAUser(appJAUser);
					utilisateurs = EOUtilities.objectsMatchingKeyAndValue(ec,
							EOUtilisateur.ENTITY_NAME, "persId",
							appJAUser.getPersId());
				}
				if (utilisateurs != null && utilisateurs.count() == 1) {
					utilisateur = (EOUtilisateur) utilisateurs.lastObject();
					laSession().setUtilisateur(utilisateur);
				}
			}
		}

		if (messageErreur != null) {
			return getErrorPage(messageErreur);
		}
		return loginResponder.loginAccepted(null);
	}

	private static NSDictionary<String, String> getParamsFromRequest(
			WORequest request, NSArray<String> ignoreParams) {
		NSMutableDictionary params = new NSMutableDictionary();
		NSArray keys = request.formValueKeys();

		for (int i = 0; i < keys.count(); ++i) {
			String key = (String) keys.objectAtIndex(i);
			if ((ignoreParams == null) || (!(ignoreParams.containsObject(key))))
				params.setObjectForKey((String) request.formValueForKey(key),
						key);
		}
		return params;
	}

	public WOActionResults visaProjectAction() {
		directVisa = true;
		WOActionResults nextPage = null;
		String login = "";
		String password = "";
		NSDictionary actionParams = getParamsFromRequest(request(), null);
		String projetId = (String) actionParams.valueForKey(PROJET_ID_KEY);
		String directVisa = (String) actionParams.valueForKey(DIRECTVISA);
		NSMutableDictionary params = new NSMutableDictionary();
		if (!MyStringCtrl.isEmpty(projetId)) {
			params.put(PROJET_ID_KEY, new Integer(projetId));
		}
		if (!MyStringCtrl.isEmpty(directVisa)) {
			if (directVisa.equals("O") || directVisa.equals("OUI")) {
				params.put(DIRECTVISA, new Boolean(true));
				params.put(DIRECTVALIDATE, new Boolean(false));
			}
		}
		setActionParams(params.immutableClone());
		laSession().setActionParams(params.immutableClone());
		if (useCasService()) {
			return loginCASPage();
		} else {
			nextPage = pageWithName(DAVisaMain.class.getName());
			return nextPage;
		}
	}

	public WOActionResults validateProjectAction() {
		directValidate = true;
		WOActionResults nextPage = null;
		String login = "";
		String password = "";
		NSDictionary actionParams = getParamsFromRequest(request(), null);
		String projetId = (String) actionParams.valueForKey(PROJET_ID_KEY);
		String directValidate = (String) actionParams
				.valueForKey(DIRECTVALIDATE);
		NSMutableDictionary params = new NSMutableDictionary();
		if (!MyStringCtrl.isEmpty(projetId)) {
			params.put(PROJET_ID_KEY, new Integer(projetId));
		}
		if (!MyStringCtrl.isEmpty(directValidate)) {
			if (directValidate.equals("O") || directValidate.equals("OUI")) {
				params.put(DIRECTVALIDATE, new Boolean(true));
				params.put(DIRECTVISA, new Boolean(false));
			}
		}
		setActionParams(params.immutableClone());
		laSession().setActionParams(params.immutableClone());
		if (useCasService()) {
			return loginCASPage();
		} else {
			nextPage = pageWithName(DAValidateMain.class.getName());
			// DAValidateMain page = (DAValidateMain) nextPage;
			// page.registerLoginResponder(getNewLoginResponder(actionParams));
			return nextPage;
		}
	}

	public WOActionResults visaAcceptedAction() {
		directVisa = true;
		WOActionResults page = null;
		WORequest request = context().request();
		String login = StringCtrl.normalize((String) request
				.formValueForKey("identifiant"));
		String password = StringCtrl.normalize((String) request
				.formValueForKey("mot_de_passe"));
		String messageErreur = null;
		CktlLoginResponder loginResponder = getNewLoginResponder(null);
		CktlUserInfo loggedUserInfo = new CktlUserInfoDB(cktlApp.dataBus());
		if (login.length() == 0) {
			messageErreur = "Vous devez renseigner l'identifiant.";
		} else if (!loginResponder.acceptLoginName(login)) {
			messageErreur = "Vous n'êtes pas autorisé à utiliser cette application";
		} else {
			if (password == null)
				password = "";
			loggedUserInfo.setRootPass(loginResponder.getRootPassword());
			loggedUserInfo.setAcceptEmptyPass(loginResponder
					.acceptEmptyPassword());
			loggedUserInfo.compteForLogin(login, password, true);
			if (loggedUserInfo.errorCode() != CktlUserInfo.ERROR_NONE) {
				if (loggedUserInfo.errorMessage() != null)
					messageErreur = loggedUserInfo.errorMessage();
				CktlLog.rawLog(">> Erreur | " + loggedUserInfo.errorMessage());
			}
		}
		NSArray utilisateurs = null;
		if (messageErreur == null) {
			laSession().setConnectedUserInfo(loggedUserInfo);
			String erreur = laSession()
					.setConnectedUser(loggedUserInfo.login());
			if (erreur != null) {
				messageErreur = erreur;
			} else {
				Integer persId = Integer.valueOf(loggedUserInfo.persId()
						.intValue());
				if (pprecApp().newGestionDroitsEnabled()) {
					PPrecApplicationUser appGDUser = new PPrecApplicationUser(
							persId);
					laSession().setApplicationGDUser(appGDUser);
					utilisateurs = EOUtilities.objectsMatchingKeyAndValue(
							laSession().editingContext(),
							EOUtilisateur.ENTITY_NAME, "persId",
							appGDUser.getPersId());
				} else {
					EnseignantApplicationUser appJAUser = new EnseignantApplicationUser(
							laSession().editingContext(),
							Application.TYPE_APP_STR, persId);
					laSession().setApplicationJAUser(appJAUser);
					utilisateurs = EOUtilities.objectsMatchingKeyAndValue(
							laSession().editingContext(),
							EOUtilisateur.ENTITY_NAME, "persId",
							appJAUser.getPersId());
				}
				if (utilisateurs != null && utilisateurs.count() == 1) {
					utilisateur = (EOUtilisateur) utilisateurs.lastObject();
					laSession().setUtilisateur(utilisateur);
				}
			}
		}

		if (messageErreur != null) {
			return getErrorPage(messageErreur);
		}

		return loginResponder.loginAccepted(null);
	}

	public WOActionResults validateAcceptedAction() {
		WOActionResults page = null;
		WORequest request = context().request();
		String login = StringCtrl.normalize((String) request
				.formValueForKey("identifiant"));
		String password = StringCtrl.normalize((String) request
				.formValueForKey("mot_de_passe"));
		String messageErreur = null;
		CktlLoginResponder loginResponder = getNewLoginResponder(null);
		CktlUserInfo loggedUserInfo = new CktlUserInfoDB(cktlApp.dataBus());
		if (login.length() == 0) {
			messageErreur = "Vous devez renseigner l'identifiant.";
		} else if (!loginResponder.acceptLoginName(login)) {
			messageErreur = "Vous n'êtes pas autorisé à utiliser cette application";
		} else {
			if (password == null)
				password = "";
			loggedUserInfo.setRootPass(loginResponder.getRootPassword());
			loggedUserInfo.setAcceptEmptyPass(loginResponder
					.acceptEmptyPassword());
			loggedUserInfo.compteForLogin(login, password, true);
			if (loggedUserInfo.errorCode() != CktlUserInfo.ERROR_NONE) {
				if (loggedUserInfo.errorMessage() != null)
					messageErreur = loggedUserInfo.errorMessage();
				CktlLog.rawLog(">> Erreur | " + loggedUserInfo.errorMessage());
			}
		}
		NSArray utilisateurs = null;
		if (messageErreur == null) {
			laSession().setConnectedUserInfo(loggedUserInfo);
			String erreur = laSession()
					.setConnectedUser(loggedUserInfo.login());
			if (erreur != null) {
				messageErreur = erreur;
			} else {
				Integer persId = Integer.valueOf(loggedUserInfo.persId()
						.intValue());
				if (pprecApp().newGestionDroitsEnabled()) {
					PPrecApplicationUser appGDUser = new PPrecApplicationUser(
							persId);
					laSession().setApplicationGDUser(appGDUser);
					utilisateurs = EOUtilities.objectsMatchingKeyAndValue(
							laSession().editingContext(),
							EOUtilisateur.ENTITY_NAME, "persId",
							appGDUser.getPersId());
				} else {
					EnseignantApplicationUser appJAUser = new EnseignantApplicationUser(
							laSession().editingContext(),
							Application.TYPE_APP_STR, persId);
					laSession().setApplicationJAUser(appJAUser);
					utilisateurs = EOUtilities.objectsMatchingKeyAndValue(
							laSession().editingContext(),
							EOUtilisateur.ENTITY_NAME, "persId",
							appJAUser.getPersId());
				}
				if (utilisateurs != null && utilisateurs.count() == 1) {
					utilisateur = (EOUtilisateur) utilisateurs.lastObject();
					laSession().setUtilisateur(utilisateur);
				}
			}
		}

		if (messageErreur != null) {
			return getErrorPage(messageErreur);
		}

		return loginResponder.loginAccepted(null);
	}

	public CktlLoginResponder getNewLoginResponder(NSDictionary actionParams) {
		return new DefaultLoginResponder(actionParams);
	}

	public class DefaultLoginResponder implements CktlLoginResponder {
		private NSDictionary actionParams;

		public DefaultLoginResponder(NSDictionary actionParams) {
			this.actionParams = actionParams;
		}

		public NSDictionary actionParams() {
			if (actionParams == null)
				actionParams = laSession().getActionParams();
			return actionParams;
		}

		public WOComponent loginAccepted(CktlLogin loginComponent) {
			PPrecApplicationUser appGDUser = laSession().applicationGDUser();
			NSDictionary actionParams = getParamsFromRequest(request(), null);
			if (actionParams.count() > 0
					&& (actionParams.containsKey(DIRECTVISA) || actionParams
							.containsKey(DIRECTVALIDATE))) {
				directVisa = false;
				directValidate = false;
				String directVis = (String) actionParams
						.valueForKey(DIRECTVISA);
				String directValidat = (String) actionParams
						.valueForKey(DIRECTVALIDATE);
				if (!MyStringCtrl.isEmpty(directVis)) {
					if (directVis.equals("O") || directVis.equals("OUI")) {
						directVisa = new Boolean(true);
						directValidate = new Boolean(false);
					}
				}
				if (!MyStringCtrl.isEmpty(directValidat)) {
					if (directValidat.equals("O")
							|| directValidat.equals("OUI")) {
						directValidate = new Boolean(true);
						directVisa = new Boolean(false);
					}
				}
			} else {
				directVisa = false;
				directValidate = false;
				if (actionParams.containsKey("mot_de_passe"))
					actionParams.put("mot_de_passe", "deleted for log");
				NSLog.out.appendln("actionParams :" + actionParams);
				try {
					NSLog.out.appendln("actionParams() :" + actionParams());
					directVisa = (Boolean) actionParams().valueForKey(
							DIRECTVISA);
					directValidate = (Boolean) actionParams().valueForKey(
							DIRECTVALIDATE);
				} catch (Exception e) {

				}
			}
			if (appGDUser != null) {
				if (appGDUser.getPprecAutorisationCache()
						.gDPprecSuperUserProjet()
						|| appGDUser.getPprecAutorisationCache()
								.gDPprecMembreIcd()
						|| appGDUser.getPprecAutorisationCache()
								.gDPprecTraiterProjet()) {
					// Connexion Admin, ICD, AAAP
					laSession().setPageName("Accueil");
					laSession().myEnv().put("pageName", laSession().pageName());
					laSession().myEnv().put("myComponent",
							pageWithName(Accueil.class.getName()));
					laSession().myEnv().put("PECV", false);
					laSession().myEnv().put("PNA", true);
					laSession().myEnv().put("Refresh", false);
				} else if (appGDUser.getPprecAutorisationCache().gDPprecAcces()) {
					// Connexion EC
					laSession().setPageName("EnseignantsChercheursView");
					laSession().myEnv().put("pageName", laSession().pageName());
					laSession().myEnv().put(
							"myComponent",
							pageWithName(EnseignantsChercheursView.class
									.getName()));
					laSession().myEnv().put("PECV", true);
					laSession().myEnv().put("PNA", false);
					laSession().myEnv().put("Refresh", false);
				}
			} else {
				EnseignantApplicationUser appJAUser = laSession()
						.applicationJAUser();
				if (appJAUser.hasDroitSuperUserProjet()
						|| appJAUser.hasDroitMembreIcd()
						|| appJAUser.hasDroitTraitementProjet()) {
					// Connexion Admin, ICD, AAAP
					laSession().setPageName("Accueil");
					laSession().myEnv().put("pageName", laSession().pageName());
					laSession().myEnv().put("myComponent",
							pageWithName(Accueil.class.getName()));
					laSession().myEnv().put("PECV", false);
					laSession().myEnv().put("PNA", true);
					laSession().myEnv().put("Refresh", false);
				} else if (appJAUser.hasDroitAccesPprec()) {
					// Connexion EC
					laSession().setPageName("EnseignantsChercheursView");
					laSession().myEnv().put("pageName", laSession().pageName());
					laSession().myEnv().put(
							"myComponent",
							pageWithName(EnseignantsChercheursView.class
									.getName()));
					laSession().myEnv().put("PECV", true);
					laSession().myEnv().put("PNA", false);
					laSession().myEnv().put("Refresh", false);
				}
			}
			if (directVisa)
				return getVisaPage(laSession(), actionParams());

			if (directValidate)
				return getVisaPage(laSession(), actionParams());
			return getDestPage(laSession(), actionParams());
		}

		public boolean acceptLoginName(String loginName) {
			return cktlApp.acceptLoginName(loginName);
		}

		public boolean acceptEmptyPassword() {
			return cktlApp.config().booleanForKey("ACCEPT_EMPTY_PASSWORD");
		}

		public String getRootPassword() {
			return cktlApp.getRootPassword();
		}
	}

	public WOComponent getDestPage(Session session, NSDictionary actionParams) {
		WOComponent nextPage = null;
		nextPage = session.myHome();
		return nextPage;
	}

	public WOComponent getVisaPage(Session session, NSDictionary actionParams) {
		try {
			CktlLog.log("login : " + session.connectedUserInfo().login()
					+ ", type : VisaProject - OK");
			Boolean direct = false;
			Boolean responsableEqpe = false;
			Integer projetId = (Integer) actionParams
					.valueForKey(PROJET_ID_KEY);
			if (projetId == null)
				projetId = (Integer) actionParams().valueForKey(PROJET_ID_KEY);
			EOEditingContext edc = session.defaultEditingContext();
			NSArray projets = EOUtilities.objectsMatchingKeyAndValue(edc,
					EOPprec.ENTITY_NAME, "projetId", projetId);
			if (projets != null && projets.count() == 1) {
				session.setProjet((EOPprec) projets.lastObject());
				session.setLeProjetEnCours((EOPprec) projets.lastObject());
			} else {
				throw new Exception("Il existe des doublons pour ce projet : "
						+ projetId);
			}
			EOStructureUlr pole = EOStructureUlr.structurePourcStructure(
					session.projet().editingContext(), session.projet()
							.poleCompetence());
			EOStructureUlr principal = EOStructureUlr.structurePourcStructure(
					session.projet().editingContext(), session.projet()
							.equipePrincipale());
			if (session.applicationGDUser() != null) {
				PPrecApplicationUser appUser = session.applicationGDUser();
				Boolean Directeur = appUser.getPprecAutorisationCache()
						.gDPprecDirecteurPole()
						&& session.applicationGDUser()
								.getPprecAutorisationCache()
								.gDPprecVisaProjet();
				Boolean ResponsableEquipe = appUser.getPprecAutorisationCache()
						.gDPprecResponsableEquipe();
				;
				direct = (Directeur && (pole.grpResponsable() != null && pole
						.grpResponsable().equals(appUser.getNoIndividu())))
						|| appUser.getPprecAutorisationCache()
								.gDPprecSuperUserProjet();
				;
				responsableEqpe = (ResponsableEquipe && (principal
						.grpResponsable() != null && principal.grpResponsable()
						.equals(appUser.getNoIndividu())))
						|| appUser.getPprecAutorisationCache()
								.gDPprecSuperUserProjet();
				if (!appUser.getPprecAutorisationCache().gDPprecAcces()) {
					throw new Exception(
							"Vous n'avez pas le droit d'accéder à cette application.");
				}
			} else {
				EnseignantApplicationUser appUser = session.applicationJAUser();
				Boolean Directeur = appUser.hasDroitDirecteurPole()
						&& appUser.hasDroitVisaProjet();
				Boolean ResponsableEquipe = appUser
						.hasDroitResponsablePrgAccueilProjet()
						&& appUser.hasDroitVisaProjet();
				direct = (Directeur && (pole.grpResponsable() != null && pole
						.grpResponsable().equals(appUser.getNoIndividu())))
						|| appUser.hasDroitSuperUserProjet();
				responsableEqpe = (ResponsableEquipe && (principal
						.grpResponsable() != null && principal.grpResponsable()
						.equals(appUser.getNoIndividu())))
						|| appUser.hasDroitSuperUserProjet();
				if (!appUser.hasDroitAccesPprec()) {
					throw new Exception(
							"Vous n'avez pas le droit d'accéder à cette application.");
				}
			}
			EditProject nextPage = (EditProject) cktlApp.pageWithName(
					EditProject.class.getName(), context());
			context()._setSession(session);
			session._awakeInContext(context());
			session.awake();
			cktlApp.saveSessionForContext(context());
			if (direct) {
				return nextPage;
			} else if (responsableEqpe) {
				return nextPage;
			} else {
				throw new Exception(
						"Vous n'avez pas le droit de viser ce projet");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return getErrorPage(e.getMessage());
		}

	}

	public WOComponent getValidatePage(Session session,
			NSDictionary actionParams) {
		try {
			CktlLog.log("login : " + session.connectedUserInfo().login()
					+ ", type : validateProject - OK");
			Boolean MembreIcd = false;
			Integer projetId = (Integer) actionParams
					.valueForKey(PROJET_ID_KEY);
			if (projetId == null)
				projetId = (Integer) actionParams().valueForKey(PROJET_ID_KEY);
			EOEditingContext edc = session.defaultEditingContext();
			NSArray projets = EOUtilities.objectsMatchingKeyAndValue(edc,
					EOPprec.ENTITY_NAME, "projetId", projetId);
			if (projets != null && projets.count() == 1) {
				session.setProjet((EOPprec) projets.lastObject());
			} else {
				throw new Exception("Il existe des doublons pour ce projet : "
						+ projetId);
			}
			if (session.applicationGDUser() != null) {
				MembreIcd = (session.applicationGDUser()
						.getPprecAutorisationCache().gDPprecMembreIcd() && session
						.applicationGDUser().getPprecAutorisationCache()
						.gDPprecValiderProjet())
						|| session.applicationGDUser()
								.getPprecAutorisationCache()
								.gDPprecSuperUserProjet();
				if (!session.applicationGDUser().getPprecAutorisationCache()
						.gDPprecAcces()) {
					throw new Exception(
							"Vous n'avez pas le droit d'accéder à cette application.");
				}
			} else {
				MembreIcd = (session.applicationJAUser().hasDroitMembreIcd() && session
						.applicationJAUser().hasDroitValidationProjet())
						|| session.applicationJAUser()
								.hasDroitSuperUserProjet();
				if (!session.applicationJAUser().hasDroitAccesPprec()) {
					throw new Exception(
							"Vous n'avez pas le droit d'accéder à cette application.");
				}
			}
			if (!MembreIcd)
				throw new Exception(
						"Vous n'avez pas le droit de valider ce projet");
			EditProject nextPage = (EditProject) cktlApp.pageWithName(
					EditProject.class.getName(), context());
			context()._setSession(session);
			session._awakeInContext(context());
			session.awake();
			cktlApp.saveSessionForContext(context());
			return nextPage;
		} catch (Exception e) {
			e.printStackTrace();
			return getErrorPage(e.getMessage());
		}

	}

	public static String buildVisaLink(Session session, Integer projetId) {
		return ((Application) session.application()).getApplicationURL(session
				.context())
				+ "/wa/visaProject?projetId="
				+ projetId
				+ "&directVisa=O";
	}

	public static String buildValidateLink(Session session, Integer projetId) {
		return ((Application) session.application()).getApplicationURL(session
				.context())
				+ "/wa/validateProject?projetId="
				+ projetId
				+ "&directValidate=O";
	}
}
