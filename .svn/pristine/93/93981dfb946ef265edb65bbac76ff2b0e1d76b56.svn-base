package utt.rec.projet.server.components;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.components.controler.ProjectCtrl;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class projectState extends MAssistant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1098897882741877338L;
	private ProjectCtrl ctrl;

	public projectState(WOContext context) {
        super(context);
        NSLog.out.appendln("projectState");
    }

	/**
	 * @return the ctrl
	 */
	public ProjectCtrl ctrl() {
		return ctrl;
	}

	/**
	 * @param ctrl the ctrl to set
	 */
	public void setCtrl(ProjectCtrl ctrl) {
		this.ctrl = ctrl;
	}
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		PprecHelpers.insertStylesSheet(context, response);
	}

	@Override
	public void takeValuesFromRequest(WORequest aRequest, WOContext aContext) {
		super.takeValuesFromRequest(aRequest, aContext);
	}
}