package utt.rec.projet.server.metier.grhum;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktlpersonne.common.metier.IIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.IPersonne;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("all")
public class EOIndividuUlr extends _EOIndividuUlr {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5323738615797225923L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOIndividuUlr.class);

	public String fullname() {
		return nomUsuel() + " " + prenom();
	}

	public String numeroInsee() {
		return indNoInsee() + "-" + indCleInsee();
	}

	// ORDER BY sur le NOM
	public static final EOSortOrdering SORT_NOM_ASC = EOSortOrdering
			.sortOrderingWithKey(NOM_USUEL_KEY,
					EOSortOrdering.CompareAscending);
	// ORDER BY sur le PRENOM
	public static final EOSortOrdering SORT_PRENOM_ASC = EOSortOrdering
			.sortOrderingWithKey(PRENOM_KEY, EOSortOrdering.CompareAscending);

	public static final NSArray<EOSortOrdering> ByNomPrenom() {
		return new NSArray(new Object[] { SORT_NOM_ASC, SORT_PRENOM_ASC });
	}

	private static EOQualifier jointures(NSArray<Integer> persId) {
		EOQualifier qual = PERS_ID.in(persId).and(
				TO_PERSONNE
						.dot(EOPersonne.TO_REPART_ASSOCIATIONS)
						.dot(EORepartAssociation.RAS_D_FERMETURE)
						.greaterThanOrEqualTo(new NSTimestamp())
						.or(TO_PERSONNE
								.dot(EOPersonne.TO_REPART_ASSOCIATIONS)
								.dot(EORepartAssociation.RAS_D_FERMETURE)
								.isNull())
						.and(TO_PERSONNE
								.dot(EOPersonne.TO_REPART_ASSOCIATIONS)
								.dot(EORepartAssociation.TO_STRUCTURE_KEY)
								.dot(EOStructureUlr.TO_REPART_TYPE_GROUPES)
								.dot(EORepartTypeGroupe.TGRP_CODE).eq("SR")));
		return qual;
	}

	private static EOQualifier jointure(NSArray<Integer> persId,
			EOStructureUlr str) {
		EOQualifier qual = PERS_ID
				.in(persId)
				.and(TO_PERSONNE
						.dot(EOPersonne.TO_REPART_ASSOCIATIONS)
						.dot(EORepartAssociation.TO_STRUCTURE_KEY)
						.eq(str)
						.and(TO_PERSONNE
								.dot(EOPersonne.TO_REPART_ASSOCIATIONS)
								.dot(EORepartAssociation.RAS_D_FERMETURE)
								.greaterThanOrEqualTo(new NSTimestamp())
								.or(TO_PERSONNE
										.dot(EOPersonne.TO_REPART_ASSOCIATIONS)
										.dot(EORepartAssociation.RAS_D_FERMETURE)
										.isNull())
								.and(TO_PERSONNE
										.dot(EOPersonne.TO_REPART_ASSOCIATIONS)
										.dot(EORepartAssociation.TO_STRUCTURE_KEY)
										.dot(EOStructureUlr.TO_REPART_TYPE_GROUPES)
										.dot(EORepartTypeGroupe.TGRP_CODE)
										.eq("SR"))));
		return qual;
	}

	private static NSArray<String> preFetch() {
		NSMutableArray preFetching = new NSMutableArray();
		preFetching.addObject("toPersonne.toRepartStructures.toStructure");
		return preFetching.immutableClone();
	}

	public static NSArray LesEC(EOEditingContext myContext,
			NSArray<Integer> persId) {
		EOFetchSpecification spec = new EOFetchSpecification("EOIndividuUlr",
				jointures(persId), new NSArray(new Object[] { SORT_NOM_ASC,
						SORT_PRENOM_ASC }));
		// spec.setPrefetchingRelationshipKeyPaths(preFetch());
		spec.setUsesDistinct(true);
		NSArray disp = myContext.objectsWithFetchSpecification(spec);
		return disp;

	}

	public static NSArray LesECparPole(EOEditingContext myContext,
			NSArray<Integer> persId, EOStructureUlr str) {
		EOFetchSpecification spec = new EOFetchSpecification("EOIndividuUlr",
				jointure(persId, str), new NSArray(new Object[] { SORT_NOM_ASC,
						SORT_PRENOM_ASC }));
		// spec.setPrefetchingRelationshipKeyPaths(preFetch());
		spec.setUsesDistinct(true);
		NSArray disp = myContext.objectsWithFetchSpecification(spec);
		return disp;

	}

	public static EOIndividuUlr individuPourNumero(
			EOEditingContext editingContext, Integer noIndividu) {
		if (noIndividu == null) {
			return null;
		}
		return fetchEOIndividuUlr(editingContext, "noIndividu", noIndividu);
	}
	
	public static EOIndividuUlr individuPourPersId(
			EOEditingContext editingContext, Integer persId) {
		if (persId == null) {
			return null;
		}
		return fetchEOIndividuUlr(editingContext, "persId", persId);
	}
}
