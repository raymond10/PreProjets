package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXKey;

public class EOEquipes extends _EOEquipes {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3337097651890089986L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOEquipes.class);
	private Number equipesIdProc;
	
	//Atributes non visibles
	  public static final ERXKey<Long> EQUIPES_ID = new ERXKey<Long>("equipesId");
	  public static final String EQUIPES_ID_KEY = EQUIPES_ID.key();
	
	public EOEquipes() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public static EOEquipes createEOEquipes(EOEditingContext editingContext) {
		EOEquipes eo = (EOEquipes) EOUtilities.createAndInsertInstance(
				editingContext, _EOEquipes.ENTITY_NAME);
		return eo;
	}

	/**
	 * @return the equipesIdProc
	 */
	public Number getEquipesIdProc() {
		return equipesIdProc;
	}

	/**
	 * @param equipesIdProc the equipesIdProc to set
	 */
	public void setEquipesIdProc(Number equipesIdProc) {
		this.equipesIdProc = equipesIdProc;
	}
	
	public static EOEquipes equipePourNumero(EOEditingContext editingContext, Integer equipesId){
		if(equipesId == null)
			return null;
		return fetchEOEquipes(editingContext, "equipesId", equipesId);
	}
	
	public static EOEquipes EquipePourProjet(EOEditingContext editingContext, Integer projetId ) {
		if(projetId == null)
			return null;
		return fetchEOEquipes(editingContext, "projetId", projetId);
	}
	
	public static EOEquipes equipePourStructure(EOEditingContext editingContext, String cStructure ) {
		if(cStructure == null)
			return null;
		return fetchEOEquipes(editingContext, "cStructure", cStructure);
	}
	
	public static EOEquipes equipePourProjetEtStructure(EOEditingContext editingContext, Integer projetId, String cStructure) {
		if(projetId == null || cStructure == null)
			return null;
		return fetchEOEquipes(editingContext, PROJET_ID.eq(projetId).and(C_STRUCTURE.eq(cStructure)));
	}
}
