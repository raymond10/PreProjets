package utt.rec.projet.server.components;

import java.util.GregorianCalendar;

import org.cocktail.fwkcktlajaxwebext.serveur.component.CktlAjaxUserQuestionDelegate;
import org.cocktail.fwkcktlwebapp.common.util.DateCtrl;

import utt.rec.projet.server.Application;
import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.VersionMe;
import utt.rec.projet.server.components.controler.WrapperCtrl;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.utils.manufactory.ManufactoryProjet;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSForwardException;

import er.ajax.AjaxUtils;
import er.ajax.CktlAjaxUtils;
import er.extensions.appserver.ERXRedirect;
import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class Wrappers extends MonComposant {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7825863252622283544L;
	private WrapperCtrl ctrl;
	private String onloadJS;
	public String bodyId = "";
	private String id;
	private CktlAjaxUserQuestionDelegate userQuestionDelegate;

	public Wrappers(WOContext context) {
        super(context);
        userQuestionDelegate = new CktlAjaxUserQuestionDelegate(this);
    }
	
	public boolean synchronizesVariablesWithBindings(){
		return false;
	}
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		CktlAjaxUtils.addScriptResourceInHead(context, response, "prototype.js");
    	CktlAjaxUtils.addScriptResourceInHead(context, response, "FwkCktlThemes.framework", "scripts/window.js");
    	CktlAjaxUtils.addScriptResourceInHead(context, response, "app", "scripts/formValidator.js");
    	CktlAjaxUtils.addScriptResourceInHead(context, response, "app", "scripts/pprec.js");
		//Introduction HTML5
		AjaxUtils.addScriptResourceInHead(context, response, "app", "scripts/modernizr.js");
		AjaxUtils.addScriptResourceInHead(context, response, "app", "scripts/jquery.placehold-0.2.min.js");
		AjaxUtils.addScriptResourceInHead(context, response, "app", "scripts/webforms/webforms2-p.js");
		PprecHelpers.insertStylesSheet(context, response);
		addScriptResource(response, "jscript/wz_tooltip.js", null, "FwkCktlWebApp.framework", 
                RESOURCE_TYPE_JSCRIPT, RESOURCE_DEST_END_BODY, RESOURCE_FROM_WEB_SERVER_RESOURCES);
    	if(myApp().newGestionDroitsEnabled()) {
    		if (myAppGDUser() != null && !myAppGDUser().peutConsulterPPREC()) {
    		    mySession().addSimpleErrorMessage("Accès non autorisé", "Vous n'êtes pas autorisé à utiliser cette application");
    		}	
    	} else {
    		if (myAppJAUser() != null && !myAppJAUser().peutConsulterPPREC()) {
    		    mySession().addSimpleErrorMessage("Accès non autorisé", "Vous n'êtes pas autorisé à utiliser cette application");
    		}
    		
    	}
	}
	
	/**
	 * @return the ctrl
	 */
	public WrapperCtrl ctrl() {
		if(ctrl == null)
	        ctrl = new WrapperCtrl(this);
		return ctrl;
	}

	/**
	 * @param ctrl the ctrl to set
	 */
	public void setCtrl(WrapperCtrl ctrl) {
		this.ctrl = ctrl;
	}


	/**
	 * @return the cprgt
	 */
	public String cprgt() {
		return myApp().copyright();
	}

	/**
	 * @return the version
	 */
	public String version() {
		return VersionMe.txtAppliVersion();
	}

	/**
	 * @return the servId
	 */
	public String servId() {
		return Application.serverBDId();
	}

	public String cssProjet() {
		return application().resourceManager().urlForResourceNamed(
				"css/projet.css", null, null, context().request());
	}
	
	public String icon() {
		return application().resourceManager().urlForResourceNamed(
				"newImages/projet_icon.png", null, null, context().request());
	}

	/**
	 * @return the onloadJS
	 */
	public String onloadJS() {
		onloadJS = (String) valueForBinding("onloadJS");
		return onloadJS;
	}

	/**
	 * @param onloadJS the onloadJS to set
	 */
	public void setOnloadJS(String onloadJS) {
		this.onloadJS = onloadJS;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userQuestionDelegate
	 */
	public CktlAjaxUserQuestionDelegate getUserQuestionDelegate() {
		return userQuestionDelegate;
	}

	/**
	 * @param userQuestionDelegate the userQuestionDelegate to set
	 */
	public void setUserQuestionDelegate(
			CktlAjaxUserQuestionDelegate userQuestionDelegate) {
		this.userQuestionDelegate = userQuestionDelegate;
	}

	public WOActionResults projet(){
		if (mySession().editingContext().hasChanges()) {
			Boolean answer = userQuestionDelegate.askUserAsBoolean(
                    "confirm", 
                    "Des changements n'ont pas été enregistrés, voulez-vous vraiment aller sur la page nouveau projet ?", 
                    getComponentId());
			if (answer == null) return null;
	        if (answer) {
	            userQuestionDelegate.clearAnswers();
	            return redirectToProjects();
	        } else {
	            userQuestionDelegate.clearAnswers();
	            return null;
	        }
		} else {
		return redirectToProjects();
		}
	}
	
	public WOActionResults redirectToAccueil() {
		mySession().resetAll();
	    ERXRedirect redirect = (ERXRedirect)pageWithName(ERXRedirect.class.getName());
        mySession().myEnv().setObjectForKey(true, "Refresh");
        redirect.setComponent(home());
		mySession().setIndexModuleActifGestionProjet(0);
        mySession().reset();
        return redirect;
	}
	
	public WOActionResults redirectToProjects() {
        mySession().reset();
	    ERXRedirect redirect = (ERXRedirect)pageWithName(ERXRedirect.class.getName());
        WOComponent projet = pageWithName(Projects.class.getName());
        redirect.setComponent(projet);
        return redirect;
	}

	public void fermerMessage() {
		mySession().setAlertMessage(null);
		setOnloadJS("");
		return;
	}
	
	/*
	 * bouton creer projet
	 */
	public WOActionResults creerProjet(){
		Projects nextPage = null;
		try {
		mySession().setIndexModuleActifGestionProjet(null);
		ctrl().resetSessionState();
		mySession().resetAll();
		setIsUpdate(false);
			ManufactoryProjet mfp = new ManufactoryProjet(ERXEC.newEditingContext(), true);
			EOPprec projet = mfp.creerProjetVierge(persId());
			mySession().setProjet(projet);
			//nextPage.setProjet(projet);
			nextPage = (Projects) pageWithName(Projects.class.getName());
			nextPage.setEditingContext(projet.editingContext());
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return nextPage;
	}
}