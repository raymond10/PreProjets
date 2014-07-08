package utt.rec.projet.server.components;
import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.components.controler.DeleteProjectCtrl;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class DeleteProject extends MAssistant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7908167014290593411L;
	private DeleteProjectCtrl ctrl;

	public DeleteProject(WOContext context) {
        super(context);
        NSLog.out.appendln("DeleteProject");
        if (ctrl().projet().toContrat() != null) {
			if (ctrl().projet().toContrat().typcontIdSup() != null) {
				ctrl().setContrat(EOTypcontrat.fetchContratPere(edc(),
						ctrl().projet().toContrat().typcontIdSup())
						.lastObject());
				
			} else {
				ctrl().setContrat(ctrl().projet().toContrat());
			}
		}
		ctrl().sTMR(mySession().lesAxesStmr());
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

	/**
	 * @return the ctrl
	 */
	public DeleteProjectCtrl ctrl() {
		
		if(ctrl == null)
			ctrl = new DeleteProjectCtrl(this);
		return ctrl;
	}

	/**
	 * @param ctrl the ctrl to set
	 */
	public void setCtrl(DeleteProjectCtrl ctrl) {
		this.ctrl = ctrl;
	}
}