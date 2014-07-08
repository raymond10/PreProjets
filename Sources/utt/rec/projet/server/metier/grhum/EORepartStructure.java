package utt.rec.projet.server.metier.grhum;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

public class EORepartStructure extends _EORepartStructure {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4698414935899020103L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EORepartStructure.class);

	// ORDER BY sur le PERS ID
	public static final EOSortOrdering SORT_PERS_ASC = EOSortOrdering
			.sortOrderingWithKey(PERS_ID_KEY, EOSortOrdering.CompareAscending);
	// ORDER BY sur le C STRUCTURE
	public static final EOSortOrdering SORT_STRUCTURE_ASC = EOSortOrdering
			.sortOrderingWithKey(C_STRUCTURE_KEY,
					EOSortOrdering.CompareAscending);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final NSArray<EOSortOrdering> ByPersStructure() {
		return new NSArray(new Object[] { SORT_PERS_ASC, C_STRUCTURE_KEY });
	}

	public static EORepartStructure repartStructPourPersId(
			EOEditingContext edc, Integer persId) {
		if (persId == null)
			return null;
		return fetchEORepartStructure(edc, "persId", persId);

	}
}
