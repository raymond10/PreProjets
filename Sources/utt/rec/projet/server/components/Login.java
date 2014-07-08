package utt.rec.projet.server.components;

import org.cocktail.fwkcktlwebapp.common.util.StringCtrl;
import org.cocktail.fwkcktlwebapp.server.components.CktlLoginResponder;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

import er.ajax.AjaxUtils;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */

public class Login extends MonComposant {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2214831531757045484L;
	
	/** Le gestionnaire des evenements de composant de login local. */
	private CktlLoginResponder loginResponder;

	private String login;
	private String password;
	private String messageErreur;

	public Login(WOContext context) {
        super(context);
        NSLog.out.appendln("Login");
    }
	
	public boolean synchronizesVariablesWithBindings(){
		return false;
	}
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		AjaxUtils.addScriptResourceInHead(context, response, "prototype.js");
		AjaxUtils.addScriptResourceInHead(context, response, "effects.js");
		AjaxUtils.addScriptResourceInHead(context, response, "wonder.js");
		AjaxUtils.addStylesheetResourceInHead(context, response, "FwkCktlThemes", "css/CktlCommon.css");
		AjaxUtils.addStylesheetResourceInHead(context, response, "FwkCktlThemes", "css/CktlCommonVert.css");
		AjaxUtils.addStylesheetResourceInHead(context, response, "app", "css/projet.css");
		AjaxUtils.addScriptResourceInHead(context, response, "FwkCktlThemes", "scripts/window.js");
		AjaxUtils.addStylesheetResourceInHead(context, response, "FwkCktlThemes.framework", "themes/default.css");
		AjaxUtils.addStylesheetResourceInHead(context, response, "FwkCktlThemes", "themes/alert.css");
		AjaxUtils.addStylesheetResourceInHead(context, response, "FwkCktlThemes", "themes/lighting.css");
	}
	
	/**
	 * Retourne la reference vers une instance de gestionnaire des evenements
	 * du composant de login local.
	 */
	public CktlLoginResponder loginResponder() {
		return loginResponder;
	}
	
	public String icon() {
		return application().resourceManager().urlForResourceNamed(
				"newImages/projet_icon.png", null, null, context().request());
	}

	/**
	 * Definit le gestionnaire des evenements du composant de login local.
	 */
	public void registerLoginResponder(CktlLoginResponder responder) {
		loginResponder = responder;
	}

	/**
	 * @return the login
	 */
	public String login() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String password() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the messageErreur
	 */
	public String messageErreur() {
		return messageErreur;
	}

	/**
	 * @param messageErreur the messageErreur to set
	 */
	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

	public boolean isAfficherMessageErreur() {
		boolean isAfficherMessageErreur = false;
		
		isAfficherMessageErreur = !StringCtrl.isEmpty(messageErreur());
		
		return isAfficherMessageErreur;
	}
	
	/**
	   * Retourne le URL de l'image "cles" affiches a cote de lien d'acces
	   * au serveur CAS.
	   */
	  public String imageClefsSrc() {
	    return cktlApp.getImageDefaultURL("clefs.gif");
	  }
}