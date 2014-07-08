package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXKey;

public class EOTyppartenaire extends _EOTyppartenaire {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8650886756949595681L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOTyppartenaire.class);
	private Number typIdProc;
	//Atributes non visibles
	public static final ERXKey<Long> TYPPART_ID = new ERXKey<Long>("typpartId");
	public static final String TYPPART_ID_KEY = TYPPART_ID.key();
	
	public EOTyppartenaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the typIdProc
	 */
	public Number getTypIdProc() {
		return typIdProc;
	}

	/**
	 * @param typIdProc the typIdProc to set
	 */
	public void setTypIdProc(Number typIdProc) {
		this.typIdProc = typIdProc;
	}
	
	public static EOTyppartenaire createEOTyppartenaire(EOEditingContext editingContext) {
		// TODO Auto-generated method stub
		EOTyppartenaire eo = (EOTyppartenaire) EOUtilities.createAndInsertInstance(editingContext, _EOTyppartenaire.ENTITY_NAME);
		eo.setProvenance("C");
		eo.setPartCleunik("0000000000");
		return eo;
	}
	
}
