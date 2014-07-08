package utt.rec.projet.server.components;

import utt.rec.projet.server.PprecHelpers;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class SoumiProject extends MonComposant {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7469981996926957503L;
	String onloadJS = null;
	private String state;
	private Number numero;

	public SoumiProject(WOContext context) {
        super(context);
        NSLog.out.appendln("SoumiProject");
    }
	
	public boolean synchronizesVariablesWithBindings(){
		return false;
	}
	
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the numero
	 */
	public Number getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Number numero) {
		this.numero = numero;
	}

	public String stateTitle() {
		if (hasBinding("stateTitle")) {
			return "- " + (String) valueForBinding("stateTitle");
		} else {
			return null;
		}
	}
}