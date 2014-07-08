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
public class Commentaire extends MonComposant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean resetOpenCommentDialog;

	public Commentaire(WOContext context) {
        super(context);
    }
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
        PprecHelpers.insertStylesSheet(context, response);
	}

	/**
	 * @return the resetOpenCommentDialog
	 */
	public boolean isResetOpenCommentDialog() {
		return resetOpenCommentDialog;
	}

	/**
	 * @param resetOpenCommentDialog the resetOpenCommentDialog to set
	 */
	public void setResetOpenCommentDialog(boolean resetOpenCommentDialog) {
		this.resetOpenCommentDialog = resetOpenCommentDialog;
	}

	public String commentaireContainerId() {
		// TODO
		return getComponentId() + "_" + this.getClass().getName();
	}
	
	public WOActionResults annulerAjout() {
		CktlAjaxWindow.close(context());
		return doNothing();
	}

	public WOActionResults ajouterCom() {
		CktlAjaxWindow.close(context());
		return doNothing();
	}
}