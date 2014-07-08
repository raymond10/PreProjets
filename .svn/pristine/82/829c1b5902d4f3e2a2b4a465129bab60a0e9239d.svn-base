package utt.rec.projet.server.components.controler;


import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.DeleteProject;
import utt.rec.projet.server.components.EditProject;
import utt.rec.projet.server.components.UpdateProject;
import utt.rec.projet.server.components.Wrappers;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class WrapperCtrl extends Object {
	
	private Wrappers wocomponent;
	public EOEditingContext edc;
	public Session sess;

	public WrapperCtrl(Wrappers aWOComponent) {
        wocomponent = aWOComponent;
    }

	/**
	 * @return the edc
	 */
	public EOEditingContext edc() {
		if(edc == null)
			edc = wocomponent.edc();
		return edc;
	}

	/**
	 * @param edc the edc to set
	 */
	public void setEdc(EOEditingContext edc) {
		this.edc = edc;
	}

	/**
	 * @return the sess
	 */
	public Session sess() {
		if(sess == null)
			sess = wocomponent().mySession();
		return sess;
	}

	/**
	 * @param sess the sess to set
	 */
	public void setSess(Session sess) {
		this.sess = sess;
	}

	/**
	 * @return the wocomponent
	 */
	public Wrappers wocomponent() {
		return wocomponent;
	}

	/**
	 * @param wocomponent the wocomponent to set
	 */
	public void setWocomponent(Wrappers wocomponent) {
		this.wocomponent = wocomponent;
	}
	
	public void fermerMessage() {
		sess().setAlertMessage(null);
		wocomponent().setOnloadJS("");
		return;
	}

	public boolean isAfficherAlerte() {
		boolean isAfficherAlerte = false;
		String alertMsg = sess().getAlertMessage();
		if (alertMsg != null && alertMsg.equals("") == false) {
			isAfficherAlerte = true;
		}
		return isAfficherAlerte;
	}

	public WOActionResults accueil() {
		if (sess().editingContext().hasChanges()) {
			Boolean answer = wocomponent().getUserQuestionDelegate().askUserAsBoolean(
                    "confirm", 
                    "Des changements n'ont pas été enregistrés, voulez-vous vraiment revenir sur la page d\u0027accueil ?", 
                    "ContainerPrincipal");
			if (answer == null) return null;
	        if (answer) {
	        	wocomponent().getUserQuestionDelegate().clearAnswers();
	        	sess().setIndexModuleActifGestionProjet(0);
	    		resetSessionState();
	    		sess().resetAll();
	    		return wocomponent().redirectToAccueil();
	        } else {
	        	wocomponent().getUserQuestionDelegate().clearAnswers();
	    		resetSessionState();
	    		sess().resetAll();
	            return null;
	        }
		}
		else {
		sess().setIndexModuleActifGestionProjet(0);
		return wocomponent().redirectToAccueil();
		}
	}
	public WOActionResults quitter() {
		if (wocomponent().nestedEdc() != null) {
			sess().setNestedEdc(null);
		}
		try {
			//ed.unlock();
			sess().reset();
		} catch (Exception e) {
		}
    	return sess().onQuitter();
	}
	
	public WOActionResults casLogOut(){
		return sess().logout();
	}
	
	/*
	 * bouton liste projets
	 */
	public WOActionResults listProjets(){
		sess().setIndexModuleActifGestionProjet(null);
		resetSessionState();
		sess().resetAll();
		Accueil nextPage =  (Accueil) wocomponent.pageWithName(Accueil.class.getName());
		return nextPage;
	}
	
	/*
	 * bouton editer projet
	 */
	public WOActionResults editerProjet(){
		resetSessionState();
		EditProject nextPage = (EditProject) wocomponent().pageWithName(EditProject.class.getName());
		sess().setIndexModuleActifGestionProjet(null);
		return nextPage;
	}
	
	/*
	 * bouton modifier projet
	 */
	public WOActionResults modifierProjet(){
		resetSessionState();
		UpdateProject nextPage = (UpdateProject) wocomponent().pageWithName(UpdateProject.class.getName());
		sess().setIndexModuleActifGestionProjet(null);
		return nextPage;
	}
	
	/*
	 * bouton supprimer projet
	 */
	public WOActionResults supprimerProjet(){
		resetSessionState();
		DeleteProject nextPage = (DeleteProject) wocomponent().pageWithName(DeleteProject.class.getName());
		sess().setIndexModuleActifGestionProjet(null);
		return nextPage;
	}
	
	public void resetSessionState() {
	    sess().setIndexModuleActifGestionProjet(0);
	}
	
	//Gestion des droits sur les differentes fonctions
	/*
	public boolean creerProjetDisabled(){
		Boolean create = null;
		if(wocomponent().myApp().newGestionDroitsEnabled()) {
			create = wocomponent().myAppGDUser().getPprecAutorisationCache().gDPprecCreationProjet() || wocomponent().myAppGDUser().getPprecAutorisationCache().gDPprecSuperUserProjet();
		} else {
			create = wocomponent().myAppJAUser().hasDroitCreationProjet() || wocomponent().myAppJAUser().superUserPprec();
		}
		//sess.setUtilisateur(utilisateur);
		return create;
	}
	*/
	/*public boolean viserProjectDisabled(){
		PPrecApplicationUser user = sess().applicationUser();
		boolean viser = user.peutConsulterPPREC() && user.peutViserProject(utilisateur);
		return viser;
	}
	
	public boolean validProjectDisabled(){
		PPrecApplicationUser user = sess().applicationUser();
		boolean valider = user.peutConsulterPPREC() && user.peutValiderProject(utilisateur);
		return valider;
	}
	*/
}
