package utt.rec.projet.server.components;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class resumeProjet extends MAssistant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3479477468881001362L;
	private boolean problematiqueTabSelected;
	private boolean objectifsTabSelected;
	private boolean methodologieTabSelected;
	private boolean contexteTabSelected;

	public resumeProjet(WOContext context) {
        super(context);
        NSLog.out.appendln("resumeProjet");
        contexteTabSelected = true;
    }
	
	public boolean synchronizesVariablesWithBindings(){
		return false;
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

	public String tabsId() {
		return "Tabs" + uniqueDomId();
	}

	public String tabContexteId() {
		return "ContTab" + uniqueDomId();
	}

	public String tabProblematiqueId() {
		return "Prob" + uniqueDomId();
	}

	public String tabObjectifId() {
		return "Objec" + uniqueDomId();
	}

	public String tabMethodologieId() {
		return "Method" + uniqueDomId();
	}

	/**
	 * @return the problematiqueTabSelected
	 */
	public boolean isProblematiqueTabSelected() {
		return problematiqueTabSelected;
	}

	/**
	 * @param problematiqueTabSelected the problematiqueTabSelected to set
	 */
	public void setProblematiqueTabSelected(boolean problematiqueTabSelected) {
		this.problematiqueTabSelected = problematiqueTabSelected;
	}

	/**
	 * @return the objectifsTabSelected
	 */
	public boolean isObjectifsTabSelected() {
		return objectifsTabSelected;
	}

	/**
	 * @param objectifsTabSelected the objectifsTabSelected to set
	 */
	public void setObjectifsTabSelected(boolean objectifsTabSelected) {
		this.objectifsTabSelected = objectifsTabSelected;
	}

	/**
	 * @return the methodologieTabSelected
	 */
	public boolean isMethodologieTabSelected() {
		return methodologieTabSelected;
	}

	/**
	 * @param methodologieTabSelected the methodologieTabSelected to set
	 */
	public void setMethodologieTabSelected(boolean methodologieTabSelected) {
		this.methodologieTabSelected = methodologieTabSelected;
	}

	/**
	 * @return the contexteTabSelected
	 */
	public boolean isContexteTabSelected() {
		return contexteTabSelected;
	}

	/**
	 * @param contexteTabSelected the contexteTabSelected to set
	 */
	public void setContexteTabSelected(boolean contexteTabSelected) {
		this.contexteTabSelected = contexteTabSelected;
	}

	public WOActionResults nextPage() {
		WORequest request = context().request();
		String contexte = (String) request.formValueForKey("Contexte");
		String problematik = (String) request.formValueForKey("Problematique");
		String objectifs = (String) request.formValueForKey("Objectifs");
		String methodo = (String) request.formValueForKey("Methodologie");
		mySession().setContexte(contexte);
		mySession().setProblematik(problematik);
		mySession().setObjectifs(objectifs);
		mySession().setMetho(methodo);
		//NSLog.out.appendln(mySession().getContexte() +","+ mySession().getMetho() +","+ mySession().getObjectifs() +","+ mySession().getProblematik());
		return doNothing();
	}
}