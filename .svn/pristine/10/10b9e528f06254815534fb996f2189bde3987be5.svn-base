package utt.rec.projet.server.components;


import utt.rec.projet.server.PprecHelpers;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

import er.extensions.foundation.ERXStringUtilities;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class Timeout extends MonComposant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3788661737806025693L;

	public Timeout(WOContext context) {
		super(context);
		NSLog.out.appendln("TimeOut");
	}
	
	public boolean synchronizesVariablesWithBindings(){
		return false;
	}
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
        PprecHelpers.insertStylesSheet(context, response);
		addScriptResource(response, "jscript/wz_tooltip.js", null,
				"FwkCktlWebApp", RESOURCE_TYPE_JSCRIPT, RESOURCE_DEST_END_BODY,
				RESOURCE_FROM_WEB_SERVER_RESOURCES);
	}
	
	public boolean isStateless() {
		return true;
	}

	/**
	 * Retourne la definition des styles par defaut. Les balises de style CSS 
	 * doivent etre donnees dans la configuration de l'application, le parametre
	 * <code>HTML_CSS_STYLES</code>.
	 */
	public String getDefaultStyles() {
		return ERXStringUtilities.toString(myApp().config().valuesForKey("HTML_CSS_STYLES").objects(), "\n");
	}
	public String applicationURL() {
		return myApp().appUlr();
	}

	public String siteURL() {
		return myApp().mainWebSiteURL();
	}

	public boolean hasSiteURL() {
		return (myApp().mainWebSiteURL() != null);
	}
}