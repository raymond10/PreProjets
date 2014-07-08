package utt.rec.projet.server.components;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORefidx;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;

import er.ajax.AjaxUpdateContainer;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class keyWordx extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1113242053802147215L;
	private EORefidx currentValue1;
	private String value;
	private EORefidx currentValue;
	private EORefidx selectedValue;
	private String value1;
	private EORefidx selectedValue1;
	private static final String isPROJET = "Projet";
	private static final String listMotClef = "moclefs";
	private static final String removeMotClef = "removeMotClef";

	// MotClefs values
	private static final String selectedWord1 = "selectedWord1";
	private static final String selectedWord2 = "selectedWord2";
	private static final String selectedWord3 = "selectedWord3";
	private static final String selectedWord4 = "selectedWord4";
	private static final String selectedWord5 = "selectedWord5";
	private static final String selectedWord6 = "selectedWord6";
	private static final String selectedWord7 = "selectedWord7";
	private static final String selectedWord8 = "selectedWord8";
	private static final String selectedWord9 = "selectedWord9";
	private static final String selectedWord10 = "selectedWord10";
	private static final String selectedWord11 = "selectedWord11";
	private static final String selectedWord12 = "selectedWord12";

	public keyWordx(WOContext context) {
		super(context);
		NSLog.out.appendln("keyWords");
	}

	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		PprecHelpers.insertStylesSheet(context, response);
	}

	/**
	 * @return the currentValue
	 */
	public EORefidx currentValue() {
		return currentValue;
	}

	/**
	 * @param currentValue
	 *            the currentValue to set
	 */
	public void setCurrentValue(EORefidx currentValue) {
		this.currentValue = currentValue;
	}

	/**
	 * @return the selectedValue
	 */
	public EORefidx selectedValue() {
		return selectedValue;
	}

	/**
	 * @param selectedValue
	 *            the selectedValue to set
	 */
	public void setSelectedValue(EORefidx selectedValue) {
		this.selectedValue = selectedValue;
		mySession().setSelectedMotClefs(this.selectedValue);
	}

	// End AutoCompletion 1

	// AutoCompletion 2

	/**
	 * @return the currentValue1
	 */
	public EORefidx getCurrentValue1() {
		return currentValue1;
	}

	/**
	 * @param currentValue1
	 *            the currentValue1 to set
	 */
	public void setCurrentValue1(EORefidx currentValue1) {
		this.currentValue1 = currentValue1;
	}

	/**
	 * @return the selectedValue1
	 */
	public EORefidx getSelectedValue1() {
		return selectedValue1;
	}

	/**
	 * @param selectedValue1
	 *            the selectedValue1 to set
	 */
	public void setSelectedValue1(EORefidx selectedValue1) {
		this.selectedValue1 = selectedValue1;
		mySession().setSelectedMotClefs1(this.selectedValue1);
	}

	// End AutoCompletion 2

	public WOActionResults submitted() {
		System.out.println("AutoCompletion1.submitted: " + value + ", "
				+ selectedValue + ", mySession().getSelectedMotClefs :"
				+ mySession().getSelectedMotClefs());
		return null;
	}

	public WOActionResults submitted1() {
		System.out.println("AutoCompletion2.submitted: " + value1 + ", "
				+ selectedValue1 + ", mySession().getSelectedMotClefs1 :"
				+ mySession().getSelectedMotClefs1());
		return null;
	}

	/**
	 * @return the selectedWord1
	 */
	public EORefidx selectedWord1() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord1);
		return value;
	}

	/**
	 * @param selectedWord1
	 *            the selectedWord1 to set
	 */
	public void setSelectedWord1(EORefidx value) {
		setValueForBinding(value, selectedWord1);
	}

	/**
	 * @return the selectedWord2
	 */
	public EORefidx selectedWord2() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord2);
		return value;
	}

	/**
	 * @param selectedWord2
	 *            the selectedWord2 to set
	 */
	public void setSelectedWord2(EORefidx value) {
		setValueForBinding(value, selectedWord2);
	}

	/**
	 * @return the selectedWord3
	 */
	public EORefidx selectedWord3() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord3);
		return value;
	}

	/**
	 * @param selectedWord3
	 *            the selectedWord3 to set
	 */
	public void setSelectedWord3(EORefidx value) {
		setValueForBinding(value, selectedWord3);
	}

	/**
	 * @return the selectedWord4
	 */
	public EORefidx selectedWord4() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord4);
		return value;
	}

	/**
	 * @param selectedWord4
	 *            the selectedWord4 to set
	 */
	public void setSelectedWord4(EORefidx value) {
		setValueForBinding(value, selectedWord4);
	}

	/**
	 * @return the selectedWord5
	 */
	public EORefidx selectedWord5() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord5);
		return value;
	}

	/**
	 * @param selectedWord5
	 *            the selectedWord5 to set
	 */
	public void setSelectedWord5(EORefidx value) {
		setValueForBinding(value, selectedWord5);
	}

	/**
	 * @return the selectedWord6
	 */
	public EORefidx selectedWord6() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord6);
		return value;
	}

	/**
	 * @param selectedWord6
	 *            the selectedWord6 to set
	 */
	public void setSelectedWord6(EORefidx value) {
		setValueForBinding(value, selectedWord6);
	}

	/**
	 * @return the selectedWord7
	 */
	public EORefidx selectedWord7() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord7);
		return value;
	}

	/**
	 * @param selectedWord7
	 *            the selectedWord7 to set
	 */
	public void setSelectedWord7(EORefidx value) {
		setValueForBinding(value, selectedWord7);
	}

	/**
	 * @return the selectedWord8
	 */
	public EORefidx selectedWord8() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord8);
		return value;
	}

	/**
	 * @param selectedWord8
	 *            the selectedWord8 to set
	 */
	public void setSelectedWord8(EORefidx value) {
		setValueForBinding(value, selectedWord8);
	}

	/**
	 * @return the selectedWord9
	 */
	public EORefidx selectedWord9() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord9);
		return value;
	}

	/**
	 * @param selectedWord9
	 *            the selectedWord9 to set
	 */
	public void setSelectedWord9(EORefidx value) {
		setValueForBinding(value, selectedWord9);
	}

	/**
	 * @return the selectedWord10
	 */
	public EORefidx selectedWord10() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord10);
		return value;
	}

	/**
	 * @param value
	 *            the selectedWord10 to set
	 */
	public void setSelectedWord10(EORefidx value) {
		setValueForBinding(value, selectedWord10);
	}

	/**
	 * @return the selectedWord11
	 */
	public EORefidx selectedWord11() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord11);
		return value;
	}

	/**
	 * @param value
	 *            the selectedWord11 to set
	 */
	public void setSelectedWord11(EORefidx value) {
		setValueForBinding(value, selectedWord11);
	}

	/**
	 * @return the selectedWord12
	 */
	public EORefidx selectedWord12() {
		EORefidx value = (EORefidx) valueForBinding(selectedWord12);
		return value;
	}

	/**
	 * @param value
	 *            the selectedWord12 to set
	 */
	public void setSelectedWord12(EORefidx value) {
		setValueForBinding(value, selectedWord12);
	}

	/**
	 * @return the isprojet
	 */
	public EOPprec projet() {
		EOPprec value = (EOPprec) valueForBinding(isPROJET);
		return value;
	}

	public void setProjet(EOPprec value) {
		setValueForBinding(value, isPROJET);
	}

	public NSMutableArray moclefs() {
		NSMutableArray value = (NSMutableArray) valueForBinding(listMotClef);
		return value;
	}

	public void setMoclefs(NSMutableArray value) {
		setValueForBinding(value, listMotClef);
	}
	
	public NSMutableArray removeMotClef() {
		NSMutableArray value = (NSMutableArray) valueForBinding(removeMotClef);
		return value;
	}

	public void setRemoveMotClef(NSMutableArray value) {
		setValueForBinding(value, removeMotClef);
	}

	// Gestion des mots clefs afficher
	public WOActionResults resetFields() {
		try {
			/*setSelectedMotClefs(moclefs());
			setRemovedMotClefs(removeMotClef());*/
			WORequest request = context().request();
			String mot1 = (String) request.formValueForKey("motclef1");
			String mot2 = (String) request.formValueForKey("motclef2");
			String mot3 = (String) request.formValueForKey("motclef3");
			String mot4 = (String) request.formValueForKey("motclef4");
			String mot5 = (String) request.formValueForKey("motclef5");
			String mot6 = (String) request.formValueForKey("motclef6");
			String mot7 = (String) request.formValueForKey("motclef7");
			String mot8 = (String) request.formValueForKey("motclef8");
			String mot9 = (String) request.formValueForKey("motclef9");
			String mot10 = (String) request.formValueForKey("motclef10");
			String mot11 = (String) request.formValueForKey("motclef11");
			String mot12 = (String) request.formValueForKey("motclef12");
			if ((mot1 == null || mot1.equals("")) && selectedWord1() != null) {
				// Bascule du mot clé en invalide en cas de suppression en
				// modification
				if(!myKeywordDel().contains(selectedWord1()))
					myKeywordDel().addObject(selectedWord1());
				myKeywordList().removeObject(selectedWord1());
				mySession().setMotClef(null);
			}
			if ((mot2 == null || mot2.equals("")) && selectedWord2() != null) {
				if(!myKeywordDel().contains(selectedWord2()))
					myKeywordDel().addObject(selectedWord2());
				myKeywordList().removeObject(selectedWord2());
				mySession().setMotClef1(null);
			}
			if ((mot3 == null || mot3.equals("")) && selectedWord3() != null) {
				if(!myKeywordList().contains(selectedWord3()))
					myKeywordList().removeObject(selectedWord3());
				myKeywordList().addObject(selectedWord3());
				mySession().setMotClef2(null);
			}
			if ((mot4 == null || mot4.equals("")) && selectedWord4() != null) {
				if(!myKeywordList().contains(selectedWord4()))
					myKeywordList().removeObject(selectedWord4());
				myKeywordList().addObject(selectedWord4());
				mySession().setMotClef3(null);
			}
			if ((mot5 == null || mot5.equals("")) && selectedWord5() != null) {
				if(!myKeywordList().contains(selectedWord5()))
					myKeywordList().removeObject(selectedWord5());
				myKeywordList().addObject(selectedWord5());
				mySession().setMotClef4(null);
			}
			if ((mot6 == null || mot6.equals("")) && selectedWord6() != null) {
				if(!myKeywordList().contains(selectedWord6()))
					myKeywordList().removeObject(selectedWord6());
				myKeywordList().addObject(selectedWord6());
				mySession().setMotClef5(null);
			}
			if ((mot7 == null || mot7.equals("")) && selectedWord7() != null) {
				if(!myKeywordList().contains(selectedWord7()))
					myKeywordList().removeObject(selectedWord7());
				myKeywordList().addObject(selectedWord7());
				mySession().setMotClef6(null);
			}
			if ((mot8 == null || mot8.equals("")) && selectedWord8() != null) {
				if(!myKeywordList().contains(selectedWord8()))
					myKeywordList().removeObject(selectedWord8());
				myKeywordList().addObject(selectedWord8());
				mySession().setMotClef7(null);
			}
			if ((mot9 == null || mot9.equals("")) && selectedWord9() != null) {
				if(!myKeywordList().contains(selectedWord9()))
					myKeywordList().removeObject(selectedWord9());
				myKeywordList().addObject(selectedWord9());
				mySession().setMotClef8(null);
			}
			if ((mot10 == null || mot10.equals("")) && selectedWord10() != null) {
				if(!myKeywordList().contains(selectedWord10()))
					myKeywordList().removeObject(selectedWord10());
				myKeywordList().addObject(selectedWord10());
				mySession().setMotClef9(null);
			}
			if ((mot11 == null || mot11.equals("")) && selectedWord11() != null) {
				if(!myKeywordList().contains(selectedWord11()))
					myKeywordList().removeObject(selectedWord11());
				myKeywordList().addObject(selectedWord11());
				mySession().setMotClef10(null);
			}
			if ((mot12 == null || mot12.equals("")) && selectedWord12() != null) {
				if(!myKeywordList().contains(selectedWord12()))
					myKeywordList().removeObject(selectedWord12());
				myKeywordList().addObject(selectedWord12());
				mySession().setMotClef11(null);
			}
		} catch (FactoryException e) {
			String alertMessage = e.getMessageFormatte();
			if (e.isBloquant()) {
				if (e.isInformatif()) {
					// Exception contenant un message d'information pour
					// l'utilisateur
					mySession().setAlertMessage(alertMessage);
				} else {
					e.printStackTrace();
					throw e;
				}
			} else {
				mySession().setAlertMessage(alertMessage);
			}
			context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(myApp().messageContainerID(),
					context());

		} catch (Exception e1) {
			mySession().setAlertMessage(e1.getMessage());
			e1.printStackTrace();
			context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(myApp().messageContainerID(),
					context());
		}
		return null;
	}

	public boolean disabled1() {
		return mySession().getMotClef1() == null;
	}

	public boolean disabled2() {
		return mySession().getMotClef2() == null;
	}

	public boolean disabled3() {
		return mySession().getMotClef3() == null;
	}

	public boolean disabled4() {
		return mySession().getMotClef4() == null;
	}

	public boolean disabled5() {
		return mySession().getMotClef5() == null;
	}

	public boolean disabled6() {
		return mySession().getMotClef6() == null;
	}

	public boolean disabled7() {
		return mySession().getMotClef7() == null;
	}

	public boolean disabled8() {
		return mySession().getMotClef8() == null;
	}

	public boolean disabled9() {
		return mySession().getMotClef9() == null;
	}

	public boolean disabled10() {
		return mySession().getMotClef10() == null;
	}

	public boolean disabled11() {
		return mySession().getMotClef11() == null;
	}
}