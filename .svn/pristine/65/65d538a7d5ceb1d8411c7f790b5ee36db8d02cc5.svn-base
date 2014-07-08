package utt.rec.projet.server.metier.grhum;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;
@SuppressWarnings("all")
public class EORepartAssociation extends _EORepartAssociation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5923901144864445882L;
	private static Logger log = Logger.getLogger(EORepartAssociation.class);

	public static EORepartAssociation unAssPourPersId(EOEditingContext ctx,
			Integer persId) {
		if (persId == null)
			return null;
		return fetchEORepartAssociation(ctx, "persId", persId);
	}

	public static NSArray<EORepartAssociation> desAssoValidePourPersId(
			EOEditingContext ctx, Integer persId) {
		if (persId == null)
			return null;
		return fetchEORepartAssociations(
				ctx,
				RAS_D_FERMETURE.isNull()
						.or(RAS_D_FERMETURE
								.greaterThanOrEqualTo(new NSTimestamp())), null);
	}
	
	public static Boolean validiteService(EOEditingContext ctx, Integer persId) {
		NSArray<EORepartAssociation> associations = desAssoValidePourPersId(ctx, persId);
		NSMutableArray services = new NSMutableArray(); 
		for(EORepartAssociation association: associations) {
			EOStructureUlr structure = association.toStructure();
			services.addObject(structure.toRepartTypeGroupes(EORepartTypeGroupe.TGRP_CODE.eq("S")).lastObject()); 
		}
		return services.count() > 0;
	}
	
	public static Boolean validitePole(EOEditingContext ctx, Integer persId) {
		NSArray<EORepartAssociation> associations = desAssoValidePourPersId(ctx, persId);
		NSMutableArray poles = new NSMutableArray(); 
		for(EORepartAssociation association: associations) {
			EOStructureUlr structure = association.toStructure();
			poles.addObject(structure.toRepartTypeGroupes(EORepartTypeGroupe.TGRP_CODE.eq("SR")).lastObject()); 
		}
		return poles.count() > 0;
	}
	
	public static Boolean validiteEquipe(EOEditingContext ctx, Integer persId) {
		NSArray<EORepartAssociation> associations = desAssoValidePourPersId(ctx, persId);
		NSMutableArray equipes = new NSMutableArray(); 
		for(EORepartAssociation association: associations) {
			EOStructureUlr structure = association.toStructure();
			equipes.addObject(structure.toRepartTypeGroupes(EORepartTypeGroupe.TGRP_CODE.eq("ER")).lastObject()); 
		}
		return equipes.count() > 0;
	}
}
