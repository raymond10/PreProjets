package utt.rec.projet.server;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import er.ajax.CktlAjaxUtils;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class PprecHelpers {
	
    /**
     * Rajoute les styles css aux réponses.
     * @param context le contexte
     * @param response la réponse
     */
    public static void insertStylesSheet(WOContext context, WOResponse response) {
        CktlAjaxUtils.addStylesheetResourceInHead(context, response,   "FwkCktlThemes.framework", "themes/default.css");
        CktlAjaxUtils.addStylesheetResourceInHead(context, response,   "FwkCktlThemes.framework", "themes/alert.css");
        CktlAjaxUtils.addStylesheetResourceInHead(context, response,   "FwkCktlThemes.framework", "themes/lighting.css");
        CktlAjaxUtils.addStylesheetResourceInHead(context, response,   "FwkCktlThemes.framework", "css/CktlCommon.css");
        CktlAjaxUtils.addStylesheetResourceInHead(context, response, "FwkCktlThemes.framework", "css/CktlCommonVert.css");
        //main css
        CktlAjaxUtils.addStylesheetResourceInHead(context, response, "app", "css/projet.css");
        CktlAjaxUtils.addStylesheetResourceInHead(context, response, "app", "css/media-queries.css");
        CktlAjaxUtils.addStylesheetResourceInHead(context, response, "Ajax", "default_ajaxupload.css");
    }

    /**
     * @param obj1 
     * @param obj2
     * @return true si obj1 et obj2 sont non nulls et égaux (au sens Object.equals())
     */
    public static boolean nullSafeEquals(Object obj1, Object obj2) {
        return obj1 != null && obj2 != null && obj1.equals(obj2);
    }

}
