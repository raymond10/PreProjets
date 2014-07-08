package utt.rec.projet.server.components;

import org.cocktail.fwkcktlajaxwebext.serveur.component.CktlAjaxWindow;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.metier.admrec.EORefidx;
import utt.rec.projet.server.process.ProcessRefIdx;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;

import er.ajax.AjaxUpdateContainer;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
public class NouveauMotClefs extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1766526608080470793L;
	private boolean resetAjoutMotClefDialog;
	private EOEditingContext editingContext;
	private Integer idGlobal;
	String onloadJS = null;

	// master completion
	private String newKeyword1;
	public NSArray<EORefidx> allKeywords;
	public EORefidx currentKeyword;
	public EORefidx selectKeyword;
	// satellite completion1
	public NSArray<EORefidx> allKeywords1;
	public EORefidx currentKeyword1;
	public EORefidx selectKeyword1;
	private String newKeyword2;
	// TextField
	public NSArray<EORefidx> allKeywords2;
	private String newKeyword3;
	protected String errorMessages;

	// Dedecate value
	public EORefidx dedecateValue;

	// Temoin mot existant ou creation
	boolean temMaster = false;
	boolean temSecond = false;

	public NouveauMotClefs(WOContext context) {
		super(context);
		NSLog.out.appendln("NouveauMotClefs");
		refreshKeywords();
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
	 * @return the resetAjoutMotClefDialog
	 */
	public boolean isResetAjoutMotClefDialog() {
		return resetAjoutMotClefDialog;
	}

	/**
	 * @param resetAjoutMotClefDialog
	 *            the resetAjoutMotClefDialog to set
	 */
	public void setResetAjoutMotClefDialog(boolean resetAjoutMotClefDialog) {
		this.resetAjoutMotClefDialog = resetAjoutMotClefDialog;
	}

	/**
	 * @return the editingContext
	 */
	public EOEditingContext getEditingContext() {
		return editingContext;
	}

	/**
	 * @param editingContext
	 *            the editingContext to set
	 */
	public void setEditingContext(EOEditingContext editingContext) {
		this.editingContext = editingContext;
	}

	public String nouveauMotClefUpdateContainerId() {
		return getComponentId() + "_" + this.getClass().getName();
	}

	/**
	 * @return the newKeyword1
	 */
	public String getNewKeyword1() {
		return newKeyword1;
	}

	/**
	 * @param newKeyword1
	 *            the newKeyword1 to set
	 */
	public void setNewKeyword1(String newKeyword1) {
		this.newKeyword1 = newKeyword1;
	}

	/**
	 * @return the newKeyword2
	 */
	public String getNewKeyword2() {
		return newKeyword2;
	}

	/**
	 * @param newKeyword2
	 *            the newKeyword2 to set
	 */
	public void setNewKeyword2(String newKeyword2) {
		this.newKeyword2 = newKeyword2;
	}

	/**
	 * @return the newKeyword3
	 */
	public String getNewKeyword3() {
		return newKeyword3;
	}

	/**
	 * @param newKeyword3
	 *            the newKeyword3 to set
	 */
	public void setNewKeyword3(String newKeyword3) {
		this.newKeyword3 = newKeyword3;
	}

	/**
	 * @return the idGlobal
	 */
	public Integer getIdGlobal() {
		return idGlobal;
	}

	/**
	 * @param idGlobal
	 *            the idGlobal to set
	 */
	public void setIdGlobal(Integer idGlobal) {
		this.idGlobal = idGlobal;
	}

	/**
	 * @return the onloadJS
	 */
	public String getOnloadJS() {
		return onloadJS;
	}

	/**
	 * @param onloadJS
	 *            the onloadJS to set
	 */
	public void setOnloadJS(String onloadJS) {
		this.onloadJS = onloadJS;
	}

	/**
	 * @return the temMaster
	 */
	public boolean isTemMaster() {
		return temMaster;
	}

	/**
	 * @param temMaster
	 *            the temMaster to set
	 */
	public void setTemMaster(boolean temMaster) {
		this.temMaster = temMaster;
	}

	/**
	 * @return the temSecond
	 */
	public boolean isTemSecond() {
		return temSecond;
	}

	/**
	 * @param temSecond
	 *            the temSecond to set
	 */
	public void setTemSecond(boolean temSecond) {
		this.temSecond = temSecond;
	}

	public WOActionResults annulerAjout() {
		CktlAjaxWindow.close(context());
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.MAssistant#valider()
	 */
	@Override
	public boolean valider() {
		// TODO Auto-generated method stub
		boolean validate = false;
		WORequest req = context().request();
		String keyw = (String) req.formValueForKey("newMotClef3");
		if (getNewKeyword3() == null)
			setNewKeyword3(keyw);
		NSArray<String> failureMessages = new NSArray<String>();
		if (getNewKeyword1() == null)
			failureMessages = failureMessages
					.arrayByAddingObject("Mot clef principal");
		if (getNewKeyword2() == null)
			failureMessages = failureMessages
					.arrayByAddingObject("Mot clef sécondaire");
		if (getNewKeyword3() == null)
			failureMessages = failureMessages
					.arrayByAddingObject("Sous mot Clef");
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

	// Nouveau mot clé
	public WOActionResults ajouterMotClef() {
		EORefidx mota = null;
		EORefidx mota1 = null;
		EORefidx mota2 = null;
		try {
			if (valider()) {
				// Mot clé Principal existe? pas forcément la seconde
				if (temMaster && !temSecond) {
					if (newKeyword2 != null) {
						mota1 = EORefidx.createEORefidx(getEditingContext());
						EOEditingContext edc = mota1.editingContext();
						mota1.setRefidxSup(Integer.valueOf(selectKeyword
								.primaryKey()));
						mota1.setRefidxval(newKeyword2);
						ProcessRefIdx.enregistrer(mySession().dataBus(), edc,
								mota1);
						setIdGlobal(mota1.getProcId());
						mySession().setLastCreateMotClef(
								EORefidx.fetchLastMotClef(edc, getIdGlobal())
										.lastObject());
					}
					lastMotCle();
					if (newKeyword3 != null) {
						mota2 = EORefidx.createEORefidx(getEditingContext());
						EOEditingContext edc = mota2.editingContext();
						if (selectKeyword1 != null) {
							mota2.setRefidxSup(Integer.valueOf(selectKeyword1
									.primaryKey()));
						} else {
							mota2.setRefidxSup(getIdGlobal());
						}
						mota2.setRefidxval(newKeyword3);
						ProcessRefIdx.enregistrer(mySession().dataBus(), edc,
								mota2);
						setIdGlobal(mota2.getProcId());
						mySession().setLastCreateMotClef(
								EORefidx.fetchLastMotClef(edc, getIdGlobal())
										.lastObject());
					}
				}
				// Mot clé secondaire existe? parce que le mot clé principal
				// aussi
				if (temSecond) {
					lastMotCle();
					if (newKeyword3 != null) {
						mota2 = EORefidx.createEORefidx(getEditingContext());
						EOEditingContext edc = mota2.editingContext();
						mota2.setRefidxSup(Integer.valueOf(selectKeyword1
								.primaryKey()));
						mota2.setRefidxval(newKeyword3);
						ProcessRefIdx.enregistrer(mySession().dataBus(), edc,
								mota2);
						setIdGlobal(mota2.getProcId());
						mySession().setLastCreateMotClef(
								EORefidx.fetchLastMotClef(edc, getIdGlobal())
										.lastObject());
					}

				} else {
					// création de nouveau mot clé principal
					if (newKeyword1 != null && !temMaster) {
						mota = EORefidx.createEORefidx(getEditingContext());
						mota.setRefidxval(newKeyword1);
						EOEditingContext edc = mota.editingContext();
						ProcessRefIdx.enregistrer(mySession().dataBus(), edc,
								mota);
						setIdGlobal(mota.getProcId());
						mySession().setLastCreateMotClef(
								EORefidx.fetchLastMotClef(edc, getIdGlobal())
										.lastObject());

						// création de nouveau mot clé secondaire
						if (newKeyword2 != null && !temMaster && !temSecond) {
							mota1 = EORefidx
									.createEORefidx(getEditingContext());
							edc = mota1.editingContext();
							mota1.setRefidxSup(getIdGlobal());
							mota1.setRefidxval(newKeyword2);
							ProcessRefIdx.enregistrer(mySession().dataBus(),
									edc, mota1);
							setIdGlobal(mota1.getProcId());
							mySession().setLastCreateMotClef(
									EORefidx.fetchLastMotClef(edc,
											getIdGlobal()).lastObject());

							// création de nouveau mot clé
							lastMotCle();
							if (newKeyword3 != null && !temMaster && !temSecond) {
								mota2 = EORefidx
										.createEORefidx(getEditingContext());
								edc = mota2.editingContext();
								mota2.setRefidxSup(getIdGlobal());
								mota2.setRefidxval(newKeyword3);
								ProcessRefIdx.enregistrer(
										mySession().dataBus(), edc, mota2);
								setIdGlobal(mota2.getProcId());
								mySession().setLastCreateMotClef(
										EORefidx.fetchLastMotClef(edc,
												getIdGlobal()).lastObject());
							}
						}
					}
				}
				mySession().addSimpleInfoMessage(
						mySession().localizer().localizedStringForKey(
								"confirmation"), null);
			}
		} catch (Exception e) {
			mySession().addSimpleErrorMessage("Nouveau mot clef",
					e.getLocalizedMessage());
			e.printStackTrace();
		}
		if (idGlobal != null) {
			CktlAjaxWindow.close(context());
		}
		context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(myApp().messageContainerID(),
				context());
		return null;
	}

	// master completion
	public NSArray<EORefidx> currentsKeywords(String value) {
		NSArray<EORefidx> result = new NSArray<EORefidx>();
		result = EORefidx.REFIDXVAL.containsAll(value).filtered(allKeywords);
		return result;
	}

	public NSArray<EORefidx> currentsKeywords() {
		return currentsKeywords(newKeyword1);
	}

	protected void refreshKeywords() {
		allKeywords = EORefidx.fetchGetMotsClefsParents(edc());
	}

	public WOActionResults submitted() {
		System.out.println("AutoComplete.submitted: " + newKeyword1 + ", "
				+ selectKeyword);
		if (selectKeyword != null) {
			allKeywords1 = EORefidx.fetchGetMotClefs(edc(),
					Integer.valueOf(selectKeyword.primaryKey()));
			dedecateValue = selectKeyword;
			temMaster = true;
			temSecond = false;
		}
		return null;
	}

	// End master completion

	// satellite completion1
	public NSArray<EORefidx> currentsKeywords1(String value) {
		NSArray<EORefidx> result = new NSArray<EORefidx>();
		result = EORefidx.REFIDXVAL.containsAll(value).filtered(allKeywords1);
		return result;
	}

	public NSArray<EORefidx> currentsKeywords1() {
		return currentsKeywords1(newKeyword2);
	}

	public WOActionResults submitted1() {
		if (newKeyword2 == null) {
			WORequest req = context().request();
			String newKey = (String) req.formValueForKey("newMotClef2_field");
			newKeyword2 = newKey;
		}
		System.out.println("AutoComplete1.submitted: " + newKeyword2 + ", "
				+ selectKeyword1);
		if (selectKeyword1 != null) {
			allKeywords2 = EORefidx.fetchGetMotClefs(edc(),
					Integer.valueOf(selectKeyword1.primaryKey()));
			dedecateValue = selectKeyword1;
			temMaster = true;
			temSecond = true;
		}
		return null;
	}

	// End satellite completion 1

	public boolean disabled() {
		return selectKeyword != null;
	}

	// Si le submit du boutons échoue, on récupère la valeur dans le context du
	// formulaire
	protected void lastMotCle() {
		if (newKeyword3 == null) {
			WORequest req = context().request();
			String newKey = (String) req.formValueForKey("newMotClef3");
			newKeyword3 = newKey;
		}
	}
}