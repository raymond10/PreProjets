package utt.rec.projet.server.components;

import utt.rec.projet.server.PprecHelpers;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class Erreur extends MonComposant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3950982959228496884L;
	private NSDictionary exceptionInfos;

	public Erreur(WOContext context) {
        super(context);
        NSLog.out.appendln("Erreur");
    }
	
	public boolean synchronizesVariablesWithBindings(){
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
    
	public WOComponent retourAccueil() {
		mySession().reset();
		mySession().resetAll();
		//mySession()().terminate();
		//accueil.setOnloadJS(null);
		setOnloadJS(null);
		return home();
	}

	/**
	 * @return the exceptionInfos
	 */
	@SuppressWarnings("rawtypes")
	public NSDictionary exceptionInfos() {
		this.exceptionInfos = (NSDictionary)mySession().exceptionInfos();
		return this.exceptionInfos;
	}

	/**
	 * @param exceptionInfos the exceptionInfos to set
	 */
	@SuppressWarnings("rawtypes")
	public void setExceptionInfos(NSDictionary exceptionInfos) {
		this.exceptionInfos = exceptionInfos;
	}
}