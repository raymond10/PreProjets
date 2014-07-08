package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

public class EOGemateriel extends _EOGemateriel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 358044687239982415L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOGemateriel.class);
	
	private Number gematIdProc;
	
	public EOGemateriel() {
		// TODO Auto-generated constructor stub
		super();
		gematIdProc = null;
	}
	
	public static EOGemateriel createEOGemateriel(EOEditingContext editingContext){
		EOGemateriel eo = (EOGemateriel) EOUtilities.createAndInsertInstance(editingContext, _EOGemateriel.ENTITY_NAME);
		return eo;
	}

	/**
	 * @return the gematIdProc
	 */
	public Number getGematIdProc() {
		return gematIdProc;
	}

	/**
	 * @param gematIdProc the gematIdProc to set
	 */
	public void setGematIdProc(Number gematIdProc) {
		this.gematIdProc = gematIdProc;
	}
	
	public static EOGemateriel gematerielPourNumero (EOEditingContext ec, Integer gematId) {
		return fetchEOGemateriel(ec, "gematId", gematId);
	}
	
}
