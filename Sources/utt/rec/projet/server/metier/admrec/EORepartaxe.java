package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

public class EORepartaxe extends _EORepartaxe {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6551377232218817257L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EORepartaxe.class);
	private Integer repartPstId;
	
	public static EORepartaxe createEORepartaxe(EOEditingContext editingContext) {
		EORepartaxe eo = (EORepartaxe) EOUtilities.createAndInsertInstance(
				editingContext, _EORepartaxe.ENTITY_NAME);
		return eo;
	}

	/**
	 * @return the repartPstId
	 */
	public Integer getRepartPstId() {
		return repartPstId;
	}

	/**
	 * @param repartPstId the repartPstId to set
	 */
	public void setRepartPstId(Integer repartPstId) {
		this.repartPstId = repartPstId;
	}
}
