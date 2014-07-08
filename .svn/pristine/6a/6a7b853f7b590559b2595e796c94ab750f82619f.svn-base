package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

@SuppressWarnings("all")
public class EOPfmateriel extends _EOPfmateriel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(EOPfmateriel.class);
	public static final String HORS_PLATEAU = "HS_PLA_";

	public static EOPfmateriel createEOPfmateriel(
			EOEditingContext editingContext) {
		EOPfmateriel eo = (EOPfmateriel) EOUtilities.createAndInsertInstance(editingContext, _EOPfmateriel.ENTITY_NAME);  
		return eo;
	}

	public static EOPfmateriel plateauPourNumero(
			EOEditingContext editingContext, String pfmatId) {
		if (pfmatId == null)
			return null;
		return fetchEOPfmateriel(editingContext, "pfmatId", pfmatId);
	}
	
	public static EOPfmateriel plateauPourStructure (EOEditingContext editingContext, String cStructure, String pfmatId) {
		if(cStructure == null || pfmatId == null)
			return null;
		EOQualifier finaly = PFMAT_ID.eq(pfmatId).and(C_STRCUTURE.eq(cStructure));
		return fetchEOPfmateriel(editingContext, finaly);
	}
	
	public static NSArray<EOPfmateriel> materiels(EOEditingContext editingContext, String cStructure) {
		NSMutableArray<EOPfmateriel> lesPlateaux = new NSMutableArray<EOPfmateriel>();
		NSArray<EOPfmateriel> plateaux = EOPfmateriel.fetchLePFduPole(editingContext,cStructure);
		for(EOPfmateriel plateau: plateaux) {
			if(!plateau.pfmatId().contains(HORS_PLATEAU) && !lesPlateaux.contains(plateau))
				lesPlateaux.addObject(plateau);
		}
		return lesPlateaux.immutableClone();
		
	}
	
	public static NSArray<EOPfmateriel> nouveauxMateriels(EOEditingContext editingContext, String cStructure) {
		NSMutableArray<EOPfmateriel> lesPlateaux = new NSMutableArray<EOPfmateriel>();
		NSArray<EOPfmateriel> plateaux = EOPfmateriel.fetchLePFduPole(editingContext,cStructure);
		for(EOPfmateriel plateau: plateaux) {
			if(plateau.pfmatId().contains(HORS_PLATEAU) && !lesPlateaux.contains(plateau))
				lesPlateaux.addObject(plateau);
		}
		return lesPlateaux.immutableClone();
	}
}
