package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOSortOrdering;

import er.extensions.eof.ERXKey;

public class EOResmat extends _EOResmat {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2224592022610831358L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOResmat.class);

	// Atributes non visibles
	public static final ERXKey<Long> MAT_ID = new ERXKey<Long>("matId");
	public static final String MAT_ID_KEY = MAT_ID.key();

	private Number matIdProc;

	// ORDER BY sur le LIBELLE
	public static final EOSortOrdering SORT_ID_ASC = EOResmat.MAT_ID.asc();

	public EOResmat() {
		// TODO Auto-generated constructor stub
		super();
		matIdProc = null;
	}

	public static EOResmat createEOResmat(EOEditingContext editingContext) {
		EOResmat eo = (EOResmat) EOUtilities.createAndInsertInstance(
				editingContext, _EOResmat.ENTITY_NAME);
		return eo;
	}

	public Number getMatIdProc() {
		return matIdProc;
	}

	public void setMatIdProc(Number matIdProc) {
		this.matIdProc = matIdProc;
	}

	public static EOResmat numeroPourMateriel(EOEditingContext editingContext,
			Integer matId) {
		if (matId == null)
			return null;
		return fetchEOResmat(editingContext, "matId", matId);
	}
}
