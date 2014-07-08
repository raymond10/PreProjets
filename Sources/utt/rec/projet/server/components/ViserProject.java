package utt.rec.projet.server.components;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.components.controler.ViserProjectCtrl;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOCommentaires;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;

import er.ajax.CktlAjaxUtils;
import er.extensions.appserver.ERXRedirect;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class ViserProject extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8417905685003365845L;
	public static String SAVE_CONTAINER = "saveContainer";
	private ViserProjectCtrl ctrl;
	// private NSMutableArray poles;
	private EOCommentaires commentairePrincipal;
	private EOCommentaires commentaireSecondaire;
	private EOCommentaires commentaireDrt;

	public ViserProject(WOContext context) {
		super(context);
		NSLog.out.appendln("ViserProject");
		ctrl().equiSecondaires();
		ctrl().commPP();
		if (myPoles().count() != 0) {
			ctrl().setListPole(myPoles().mutableClone());
			ctrl().commDrt();
			ctrl().lesAutresCommentairesPoles();
		}
		if (!ctrl().isAffichePP()) {
			ctrl().commentaireResponsableEquipePrincipale();
		}
		if (ctrl().isOverPoles()) {
			ctrl().commentaireDirecteurPole();
		}
		ctrl().validICD();
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
	public ViserProjectCtrl ctrl() {
		if (ctrl == null)
			ctrl = new ViserProjectCtrl(this);
		return ctrl;
	}

	/**
	 * @param ctrl
	 *            the ctrl to set
	 */
	public void setCtrl(ViserProjectCtrl ctrl) {
		this.ctrl = ctrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.MAssistant#onSuivant()
	 */
	@Override
	public void onSuivant() {
		// TODO Auto-generated method stub
		WORequest req = context().request();
		String compp = (String) req.formValueForKey("respPP");
		if (compp != null && !compp.equals("") && (commentairePrincipal().commentaires() == null || commentairePrincipal().commentaires().equals("")))
			commentairePrincipal().setCommentaires(compp);
		String comps = (String) req.formValueForKey("respEPS");
		if (comps != null && !comps.equals("") && (commentaireSecondaire().commentaires() == null || commentaireSecondaire().commentaires().equals("")))
			commentaireSecondaire().setCommentaires(comps);
		String comdrt = (String) req.formValueForKey("DirP");
		if (comdrt != null && !comdrt.equals("") && (commentaireDrt().commentaires() == null || commentaireDrt().commentaires().equals("")))
			commentaireDrt().setCommentaires(comdrt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.MAssistant#valider()
	 */
	@Override
	public boolean valider() {
		// TODO Auto-generated method stub
		Boolean validate = false;
		NSArray<String> failureMessages = new NSArray<String>();
		if (ctrl().isPrincipal()) {
			if (commentairePrincipal().commentaires() == null
					|| commentairePrincipal().commentaires().equals(""))
				failureMessages = failureMessages
						.arrayByAddingObject("Merci de faire un commentaire");
			if (commentairePrincipal().typrefnat() == null
					|| commentairePrincipal().typrefnat().equals(""))
				failureMessages = failureMessages
						.arrayByAddingObject("Merci de donner votre avis");
		}
		if(ctrl().isDirecteur()) {
			if (mySession().getSelectedPole1() == null || (commentaireDrt().commentaires() == null
					|| commentaireDrt().commentaires().equals("")))
				failureMessages = failureMessages
						.arrayByAddingObject("Merci de sélectionner votre pôle et de faire un commentaire");
			if (commentaireDrt().typrefnat() == null
					|| commentaireDrt().typrefnat().equals(""))
				failureMessages = failureMessages
						.arrayByAddingObject("Merci de donner votre avis");
		}
		if(ctrl().isAfficheICD()) {
			if (mySession().getListIcdSelect() == null
				|| mySession().getDateIcd() == null)
				failureMessages = failureMessages
				.arrayByAddingObject("La date et l'avis sont obligatoires pour la validation");
		}
		if (failureMessages.count() == 0) {
			validate = true;
			setFailureMessage(null);
		} else {
			setFailureMessage("Veuillez renseigner "
					+ failureMessages.componentsJoinedByString(", ") + ".");
		}
		if (validate)
			mySession().getUiMessages().removeAllObjects();
		return validate;
	}

	/*	*//**
	 * @return the poles
	 */
	/*
	 * public NSMutableArray poles() { if(poles == null) poles = new
	 * NSMutableArray(); return poles; }
	 *//**
	 * @param poles
	 *            the poles to set
	 */
	/*
	 * public void setPoles(NSMutableArray poles) { this.poles = poles; }
	 */

	public String saveContainerId() {
		return SAVE_CONTAINER;
	}

	public void updateBatchSize() {
	}

	/**
	 * @return the commentairePrincipal
	 */
	public EOCommentaires commentairePrincipal() {
		return commentairePrincipal;
	}

	/**
	 * @param commentairePrincipal
	 *            the commentairePrincipal to set
	 */
	public void setCommentairePrincipal(EOCommentaires commentairePrincipal) {
		this.commentairePrincipal = commentairePrincipal;
	}

	/**
	 * @return the commentaireDrt
	 */
	public EOCommentaires commentaireDrt() {
		return commentaireDrt;
	}

	/**
	 * @param commentaireDrt
	 *            the commentaireDrt to set
	 */
	public void setCommentaireDrt(EOCommentaires commentaireDrt) {
		this.commentaireDrt = commentaireDrt;
	}

	/**
	 * @return the commentaireSecondaire
	 */
	public EOCommentaires commentaireSecondaire() {
		return commentaireSecondaire;
	}

	/**
	 * @param commentaireSecondaire
	 *            the commentaireSecondaire to set
	 */
	public void setCommentaireSecondaire(EOCommentaires commentaireSecondaire) {
		this.commentaireSecondaire = commentaireSecondaire;
	}
}