package utt.rec.projet.server.components;

import org.cocktail.fwkcktlajaxwebext.serveur.component.CktlAjaxWindow;

import utt.rec.projet.server.PprecHelpers;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class Teams extends MonComposant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3587662933383220845L;

	public Teams(WOContext context) {
        super(context);
    }
	
	public boolean synchronizesVariablesWithBindings(){
		return false;
	}	
	
	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
        PprecHelpers.insertStylesSheet(context, response);
	}
	
	public String commentaireContainerId() {
		// TODO
		return getComponentId() + "_" + this.getClass().getName();
	}
	
	public WOActionResults annulerAjout() {
		CktlAjaxWindow.close(context());
		return doNothing();
	}
}