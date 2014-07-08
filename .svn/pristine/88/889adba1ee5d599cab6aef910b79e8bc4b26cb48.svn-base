package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXKey;

@SuppressWarnings("unused")
public class EOPosterh extends _EOPosterh {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6426411525078895639L;
	private static Logger log = Logger.getLogger(EOPosterh.class);
	private Number posteIdProc;
	
	//Atributes non visibles
	  public static final ERXKey<Long> ID_POSTE = new ERXKey<Long>("idPoste");
	  public static final String ID_POSTE_KEY = ID_POSTE.key();
	
	public EOPosterh() {
		// TODO Auto-generated constructor stub
		super();
		posteIdProc=null;
	}
	
	public static EOPosterh createEOPosterh(EOEditingContext editingContext) {
		EOPosterh eo = (EOPosterh) EOUtilities.createAndInsertInstance(
				editingContext, _EOPosterh.ENTITY_NAME);
		return eo;
	}

	public Number getPosteIdProc() {
		return posteIdProc;
	}

	public void setPosteIdProc(Number posteIdProc) {
		this.posteIdProc = posteIdProc;
	}
	
	
}
