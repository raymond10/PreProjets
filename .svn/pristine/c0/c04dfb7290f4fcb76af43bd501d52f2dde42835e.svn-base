/**
 * 
 */
package utt.rec.projet.server.components.work;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.print.PrintCSV;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOOrQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import fr.univlr.cri.webapp.CRIDataBus;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class PrintWorkingCtrl {
	
	private WOResponse lastCsvResponse;
	private NSMutableDictionary bindings = new NSMutableDictionary();
	private boolean isTravailTermine;
	private Accueil caller;
	
	public PrintWorkingCtrl(NSMutableDictionary aBindings, Accueil aCaller) {
		// TODO Auto-generated constructor stub
		super();
		this.bindings = aBindings;
		this.caller = aCaller;
		isTravailTermine = false;
	}
	
	/** 
	 * Methode de generation du flux CSV
	 */
	public void generateCsvResponse() {
		lastCsvResponse = PrintCSV.printCsvProjet("export", bindings, caller.mySession());		
		isTravailTermine = true;
	}

	/**
	 * @return the lastCsvResponse
	 */
	public WOResponse getLastCsvResponse() {
		return lastCsvResponse;
	}

	/**
	 * @param lastCsvResponse the lastCsvResponse to set
	 */
	public void setLastCsvResponse(WOResponse lastCsvResponse) {
		this.lastCsvResponse = lastCsvResponse;
	}

	/**
	 * @return the bindings
	 */
	public NSMutableDictionary getBindings() {
		return bindings;
	}

	/**
	 * @param bindings the bindings to set
	 */
	public void setBindings(NSMutableDictionary bindings) {
		this.bindings = bindings;
	}

	/**
	 * @return the isTravailTermine
	 */
	public boolean isTravailTermine() {
		return isTravailTermine;
	}

	/**
	 * @param isTravailTermine the isTravailTermine to set
	 */
	public void setTravailTermine(boolean isTravailTermine) {
		this.isTravailTermine = isTravailTermine;
	}

	/**
	 * @return the caller
	 */
	public Accueil getCaller() {
		return caller;
	}

	/**
	 * @param caller the caller to set
	 */
	public void setCaller(Accueil caller) {
		this.caller = caller;
	}

}
