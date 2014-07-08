package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class EOMotclefs extends _EOMotclefs {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5079795017194250943L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOMotclefs.class);
	private Number keywordIdProc;
	
	public EOMotclefs() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @return the keywordIdProc
	 */
	public Number getKeywordIdProc() {
		return keywordIdProc;
	}

	/**
	 * @param keywordIdProc the keywordIdProc to set
	 */
	public void setKeywordIdProc(Number keywordIdProc) {
		this.keywordIdProc = keywordIdProc;
	}
	
	public static EOMotclefs createEOMotclefs(EOEditingContext editingContext) {
		EOMotclefs eo = (EOMotclefs) EOUtilities.createAndInsertInstance(editingContext, _EOMotclefs.ENTITY_NAME);
		return eo;
	}
	
	public static EOMotclefs keywordPourPorjet(EOEditingContext editingContext, EOPprec projet) {
		if(projet == null)
			return null;
		return fetchEOMotclefs(editingContext, "projet", projet);
	}
	
	public static NSArray<EOMotclefs> keywordsPourPorjet(EOEditingContext editingContext, EOPprec projet) {
		if(projet == null)
			return new NSArray<EOMotclefs>();
		return fetchEOMotclefses(editingContext, TO_PROJET.eq(projet), EOMotclefs.MOTCLEF_ID.ascs());
	}
}
