package utt.rec.projet.server.components;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.controler.ValiderProjectCtrl;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ValidProject extends MonComposant {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1120901838659293246L;
	private ValiderProjectCtrl ctrl;

	public ValidProject(WOContext context) {
        super(context);
        NSLog.out.appendln("ValidProject");
        ctrl = new ValiderProjectCtrl(this);
    }
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
        PprecHelpers.insertStylesSheet(context, response);
		String message = mySession().getAlertMessage();
		if (message != null && message.equals("") == false) {
			String str = "<script language=\"javascript\" type=\"text/javascript\">\n";
			str += "alert(\"" + message + "\");\n";
			str += "</script>";
			response.appendContentString(str);
			mySession().setAlertMessage(null);
		}
		if (onloadJS() != null)
			setOnloadJS(null);
	}

	@Override
	public void takeValuesFromRequest(WORequest aRequest, WOContext aContext) {
		super.takeValuesFromRequest(aRequest, aContext);
	}

	/**
	 * @return the ctrl
	 */
	public ValiderProjectCtrl getCtrl() {
		return ctrl;
	}

	/**
	 * @param ctrl the ctrl to set
	 */
	public void setCtrl(ValiderProjectCtrl ctrl) {
		this.ctrl = ctrl;
	}
}