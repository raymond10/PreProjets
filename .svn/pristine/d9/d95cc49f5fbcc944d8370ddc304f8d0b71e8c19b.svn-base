package utt.rec.projet.server.components;
import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.components.controler.EditNextProjectCtrl;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

import er.extensions.appserver.ERXRedirect;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class EditNextProject extends MAssistant {
    /**
	 * 
	 */
	private static final long serialVersionUID = -782314964119443222L;
	private EditNextProjectCtrl ctrl;

	public EditNextProject(WOContext context) {
        super(context);
        NSLog.out.appendln("EditNextProject");
        //setProjet(mySession().getProjectSelected());
        //ctrl.autres(EOEquipes.fetchEOEquipeses(edc(), EOEquipes.PROJET.eq(ctrl.getProjet()).and(EOEquipes.PRINCIPALE.eq("N")).and(EOEquipes.TEMVALIDE.eq("O")), null));
        ctrl().personnelProjet();
        ctrl().posteProjet();
        ctrl().materielProjet();
        ctrl().nouveauMaterielProjet();
    }
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public void appendToResponse(WOResponse woresponse, WOContext wocontext) {
		super.appendToResponse(woresponse, wocontext);
		PprecHelpers.insertStylesSheet(wocontext, woresponse);
		String message = mySession().getAlertMessage();
		if (message != null && message.equals("") == false) {
			String str = "<script language=\"javascript\" type=\"text/javascript\">\n";
			str += "alert(\"" + message + "\");\n";
			str += "</script>";
			woresponse.appendContentString(str);
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
	public EditNextProjectCtrl ctrl() {
		if(ctrl == null)
	        ctrl = new EditNextProjectCtrl(this);
		return ctrl;
	}

	/**
	 * @param ctrl the ctrl to set
	 */
	public void setCtrl(EditNextProjectCtrl ctrl) {
		this.ctrl = ctrl;
	}
	
	public WOActionResults annuler() {
		ERXRedirect redirect = (ERXRedirect) pageWithName(ERXRedirect.class
				.getName());
        mySession().myEnv().setObjectForKey(true, "Refresh");
		redirect.setComponent(home());
		return redirect;
	}
}