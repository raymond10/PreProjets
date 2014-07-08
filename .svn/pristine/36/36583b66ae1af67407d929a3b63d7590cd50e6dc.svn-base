package utt.rec.projet.server.components;

import org.cocktail.fwkcktlwebapp.common.CktlUserInfo;
import org.cocktail.fwkcktlwebapp.server.CktlWebAction;
import org.cocktail.fwkcktlwebapp.server.components.CktlLoginResponder;
import org.cocktail.fwkcktlwebapp.server.components.CktlWebPage;

import utt.rec.projet.server.PprecHelpers;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class DAVisaMain extends CktlWebPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3294873933822007144L;

	String onload = null;
	private String login;
	private String password;
	public boolean blocageQuestionSecrete = false;
	
	/** Le gestionnaire des evenements de composant de login local. */
	private CktlLoginResponder loginResponder;

	public DAVisaMain(WOContext context) {
		super(context);
		NSLog.out.appendln("DAVisaMain");
	}
	
	public boolean synchronizesVariablesWithBindings(){
		return false;
	}
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		PprecHelpers.insertStylesSheet(context, response);
	}
	
	/*public String getOnload() {
		if (onload == null) {
			onload = "if(navigator.appName != 'Microsoft Internet Explorer') {window.location='";
			onload += context().directActionURLForActionNamed("myDefault", null);
			onload += "';} else {Element.show('Avertissement');}";
		}
		return onload;
	}

	public void setOnload(String onload) {
		this.onload = onload;
	}*/
	
	public String goCas() {
		return (CktlWebAction.getDefaultLoginActionURL(context()));
	}
	
	public boolean isConnected() {
		CktlUserInfo conect = cktlSession().connectedUserInfo();
		Boolean connected = conect != null;
		return connected;
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
	
	public boolean useCAS() {
		return CktlWebAction.useCasService();
	}
	
	/**
	 * Retourne la reference vers une instance de gestionnaire des evenements
	 * du composant de login local.
	 */
	public CktlLoginResponder loginResponder() {
		return loginResponder;
	}

	/**
	 * Definit le gestionnaire des evenements du composant de login local.
	 */
	public void registerLoginResponder(CktlLoginResponder responder) {
		loginResponder = responder;
	}
}
