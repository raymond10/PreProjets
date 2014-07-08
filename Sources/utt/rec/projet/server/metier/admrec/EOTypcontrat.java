package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXFetchSpecification;
import er.extensions.eof.ERXKey;

public class EOTypcontrat extends _EOTypcontrat {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6511801006367250224L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOTypcontrat.class);

	// Atributes non visibles
	public static final ERXKey<Integer> TYPCONT_ID = new ERXKey<Integer>(
			"typcontId");
	// ORDER BY sur le NOM
	public static final EOSortOrdering SORT_NOMABR_ASC = EOSortOrdering
			.sortOrderingWithKey(TYPCONT_NOM_ABR_KEY,
					EOSortOrdering.CompareAscending);

	public static NSArray<EOTypcontrat> fetchEOContrats(
			EOEditingContext editingContext, EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		ERXFetchSpecification<EOTypcontrat> fetchSpec = new ERXFetchSpecification<EOTypcontrat>(
				_EOTypcontrat.ENTITY_NAME, qualifier, sortOrderings);
		fetchSpec.setIsDeep(true);
		fetchSpec.setUsesDistinct(true);
		NSArray<EOTypcontrat> eoObjects = fetchSpec
				.fetchObjects(editingContext);
		return eoObjects;
	}
}
