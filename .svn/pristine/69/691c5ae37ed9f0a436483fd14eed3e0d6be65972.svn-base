/**
 * 
 */
package utt.rec.projet.server;

import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.cocktail.fwkcktlwebapp.common.CktlLog;
import org.cocktail.fwkcktlwebapp.common.CktlUserInfo;
import org.cocktail.fwkcktlwebapp.common.database.CktlUserInfoDB;
import org.cocktail.fwkcktlwebapp.common.util.StringCtrl;
import org.cocktail.fwkcktlwebapp.server.components.CktlAlertPage;
import org.cocktail.fwkcktlwebapp.server.components.CktlLogin;
import org.cocktail.fwkcktlwebapp.server.components.CktlLoginResponder;

import utt.rec.projet.server.components.DAVisaMain;
import utt.rec.projet.server.components.EditProject;
import utt.rec.projet.server.components.Login;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 22 oct. 2013
 */

@SuppressWarnings("all")
public class DAVisaProject extends DirectAction {

	public final static String PROJET_ID_KEY = "projetId";
	private NSDictionary actionParams;

	/**
	 * @param request
	 */
	public DAVisaProject(WORequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	/*
	 * @see DirectAction#casLoginLink()
	 */
	public String casLoginLink() {
		return getLoginActionURL(context(), false,
				"utt.rec.projet.server.DAVisaProject", true, actionParams);
	}

	public WOActionResults defaultAction() {
		try {
			try {
				int projetId = Integer.parseInt(request()
						.stringFormValueForKey(PROJET_ID_KEY));
				setLoginComment("Accès au Pré-Projet numéro : " + projetId);
				actionParams = new NSDictionary(new Integer(projetId),
						PROJET_ID_KEY);
				laSession().setActionParams(actionParams);
				if (useCasService())
					return pageForURL(getLoginActionURL(context(), false,
							DAVisaProject.class.getCanonicalName(), true,
							actionParams));
				else
					return loginNoCasPage(actionParams);
			} catch (NumberFormatException e) {
				throw new Exception(
						"Impossible d'accéder au Pré-Projet numéro : "
								+ request()
										.stringFormValueForKey(PROJET_ID_KEY));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return getErrorPage(e.getMessage());
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

	public WOActionResults loginNoCasPage(NSDictionary actionParams) {
		DAVisaMain page = (DAVisaMain) pageWithName(DAVisaMain.class.getName());
		page.registerLoginResponder(getNewLoginResponder(actionParams));
		return page;
	}

	public WOActionResults loginCasSuccessPage(String netid,
			NSDictionary actionParams) {
		WOActionResults nextPage = super.loginCasSuccessPage(netid,
				actionParams);
		String errorMsg = laSession().setConnectedUser(netid);
		CktlLog.trace(errorMsg);
		if (!(nextPage instanceof CktlAlertPage)) {
			nextPage = getDestPage(laSession(), actionParams);
		}
		return nextPage;
	}

	public WOActionResults visaLoginAction() {
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
			return  getErrorPage(messageErreur);
		}

		return loginResponder.loginAccepted(null);
	}

	public WOComponent getDestPage(Session session, NSDictionary actionParams) {
		try {
			CktlLog.log("login : " + session.connectedUserInfo().login()
					+ ", type : DAVisaProject - OK");
			Boolean direct = false;
			Boolean responsableEqpe = false;
			if(actionParams == null)
				actionParams = laSession().getActionParams();
			String strProjetId = actionParams.valueForKey(PROJET_ID_KEY)
					.toString();
			int projetId = Integer.parseInt(strProjetId);
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
				Boolean Directeur = session.applicationGDUser()
						.getPprecAutorisationCache().gDPprecDirecteurPole()
						&& session.applicationGDUser()
								.getPprecAutorisationCache()
								.gDPprecVisaProjet();
				Boolean ResponsableEquipe = session.applicationGDUser()
						.getPprecAutorisationCache().gDPprecResponsableEquipe()
						&& session.applicationGDUser()
								.getPprecAutorisationCache()
								.gDPprecVisaProjet();
				;
				direct = (Directeur && (pole.grpResponsable() != null && pole
						.grpResponsable().equals(
								session.applicationGDUser().getNoIndividu())))
						|| session.applicationGDUser()
								.getPprecAutorisationCache()
								.gDPprecSuperUserProjet();
				;
				responsableEqpe = (ResponsableEquipe && (principal
						.grpResponsable() != null && principal.grpResponsable()
						.equals(session.applicationGDUser().getNoIndividu())))
						|| session.applicationGDUser()
								.getPprecAutorisationCache()
								.gDPprecSuperUserProjet();
				if (!session.applicationGDUser().getPprecAutorisationCache()
						.gDPprecAcces()) {
					throw new Exception(
							"Vous n'avez pas le droit d'accéder à cette application.");
				}
			} else {
				Boolean Directeur = session.applicationJAUser()
						.hasDroitDirecteurPole()
						&& session.applicationJAUser().hasDroitVisaProjet();
				Boolean ResponsableEquipe = session.applicationJAUser()
						.hasDroitResponsablePrgAccueilProjet()
						&& session.applicationJAUser().hasDroitVisaProjet();
				direct = (Directeur && (pole.grpResponsable() != null && pole
						.grpResponsable().equals(
								session.applicationJAUser().getNoIndividu())))
						|| session.applicationJAUser()
								.hasDroitSuperUserProjet();
				responsableEqpe = (ResponsableEquipe && (principal
						.grpResponsable() != null && principal.grpResponsable()
						.equals(session.applicationJAUser().getNoIndividu())))
						|| session.applicationJAUser()
								.hasDroitSuperUserProjet();
				if (!session.applicationJAUser().hasDroitAccesPprec()) {
					throw new Exception(
							"Vous n'avez pas le droit d'accéder à cette application.");
				}
			}
			if (!direct && !responsableEqpe)
				throw new Exception(
						"Vous n'avez pas le droit de viser ce projet");
			EditProject nextPage = (EditProject) cktlApp.pageWithName(
					EditProject.class.getName(), session.context());
			return nextPage;
		} catch (Exception e) {
			e.printStackTrace();
			return getErrorPage(e.getMessage());
		}

	}

	public CktlLoginResponder getNewDefaultLoginResponder(
			NSDictionary actionParams) {
		return new DefaultLoginResponder(actionParams);
	}

	public static String buildLink(Session session, Integer projetId) {
		return ((Application) session.application()).getApplicationURL(session
				.context()) + "/wa/DAVisaProject?projetId=" + projetId;
	}

}
