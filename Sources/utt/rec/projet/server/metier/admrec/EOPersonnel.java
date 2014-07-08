package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXKey;

public class EOPersonnel extends _EOPersonnel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7705305620778131715L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOPersonnel.class);
	
	// Atributes non visibles
	public static final ERXKey<Integer> PROJET_ID = new ERXKey<Integer>(
			"projetId");

	public EOPersonnel() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static EOPersonnel createEOPersonnel(EOEditingContext editingContext) {
		EOPersonnel eo = (EOPersonnel) EOUtilities.createAndInsertInstance(
				editingContext, _EOPersonnel.ENTITY_NAME);
		return eo;
	}
	
	public static NSArray<EOPersonnel> PersonnelPourProjet(EOEditingContext editingContext, Integer prodId) {
		return EOPersonnel.fetchPersonnelProjet(editingContext, prodId);
	}
}
