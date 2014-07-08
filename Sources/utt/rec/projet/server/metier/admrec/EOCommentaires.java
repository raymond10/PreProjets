package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXKey;

@SuppressWarnings("unused")
public class EOCommentaires extends _EOCommentaires {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4271684651071089193L;
	
	private static Logger log = Logger.getLogger(EOCommentaires.class);
	
	//Atributes non visibles
	public static final ERXKey<Integer> COMMENT_ID = new ERXKey<Integer>("commentId");
	public static final String COMMENT_ID_KEY = COMMENT_ID.key();
	
	private Number commId;
	
	public EOCommentaires() {
		// TODO Auto-generated constructor stub
		super();
		commId = null;
	}

	/**
	 * @return the commId
	 */
	public Number getCommId() {
		return commId;
	}

	/**
	 * @param commId the commId to set
	 */
	public void setCommId(Number commId) {
		this.commId = commId;
	}
	
	public static EOCommentaires createEOCommentaires(EOEditingContext editingContext){
		EOCommentaires eo = (EOCommentaires) EOUtilities.createAndInsertInstance(editingContext, _EOCommentaires.ENTITY_NAME);
		return eo;
	}
	
	public static NSArray<EOCommentaires> commentairesPourStructure(EOEditingContext ec, String cStructure) {
		return fetchEOCommentaireses(ec, C_STRUCTURE.eq(cStructure), null);
	}
	
	public static NSArray<EOCommentaires> commentairesPourProjet(EOEditingContext ec, Integer projet) {
		return fetchEOCommentaireses(ec, PROJET.eq(projet), null);
	}
	
	public EOStructureUlr commentaireStructure() {
		EOStructureUlr structure = EOStructureUlr.structurePourcStructure(this.editingContext(), this.cStructure());
		return structure;
	}
}
