package utt.rec.projet.server.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;

import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.components.controler.PartenaireCompletionCtrl;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;

public class PartenaireCompletion extends MAssistant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 886986766489825750L;
	
	String onloadJS = null;
	private PartenaireCompletionCtrl ctrl;
	private String motPartenaire;
	private EOTyppartenaire partenaireItem;
	private EOTyppartenaire partenaireSelected;
	// Binding project
	private static final String isPROJET = "Projet";

	public PartenaireCompletion(WOContext context) {
        super(context);
		NSLog.out.appendln("PartenaireCompletion");
		ctrl().refreshPartenaireList();
    }

	public String partenaireDialogId() {
		return "partenaire_" + uniqueDomId();
	}
	
	public String selectedPartenaireId() {
		return "upDatePartenaire_" + uniqueDomId();
	}
	
	public String partenaireFetchId() {
		return "refreshField_" + uniqueDomId();
	}

	/**
	 * @return the motPartenaire
	 */
	public String motPartenaire() {
		if(motPartenaire == null)
			motPartenaire = "";
		return motPartenaire;
	}

	/**
	 * @param motPartenaire the motPartenaire to set
	 */
	public void setMotPartenaire(String motPartenaire) {
		this.motPartenaire = motPartenaire;
	}

	/**
	 * @return the partenaireItem
	 */
	public EOTyppartenaire partenaireItem() {
		return partenaireItem;
	}

	/**
	 * @param partenaireItem the partenaireItem to set
	 */
	public void setPartenaireItem(EOTyppartenaire partenaireItem) {
		this.partenaireItem = partenaireItem;
	}

	/**
	 * @return the partenaireSelected
	 */
	public EOTyppartenaire partenaireSelected() {
		return partenaireSelected;
	}

	/**
	 * @param partenaireSelected the partenaireSelected to set
	 */
	public void setPartenaireSelected(EOTyppartenaire partenaireSelected) {
		this.partenaireSelected = partenaireSelected;
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
	
	public PartenaireCompletionCtrl ctrl() {
		if(ctrl == null)
			ctrl = new PartenaireCompletionCtrl(this);
		return ctrl;
	}
	
	public void setCtrl(PartenaireCompletionCtrl ctrl) {
		this.ctrl = ctrl;		
	}
	
	public NSArray<EOTyppartenaire> currentsPartenaires() {
		return ctrl().currentsPartenaires(motPartenaire());
	}
}