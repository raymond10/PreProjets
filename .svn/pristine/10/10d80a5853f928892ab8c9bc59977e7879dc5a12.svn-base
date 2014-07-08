/**
 * 
 */
package utt.rec.projet.server.utils;


import org.cocktail.fwkcktljefyadmin.common.metier.EOTypeApplication;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FinderTypeApplication extends Finder {
	/**
	 * Recherche des differents types applications. <BR>
	 * 
	 * @param ed editingContext dans lequel se fait le fetch
	 * @return un NSArray de EOTypeApplication
	 */
	public static final NSArray<EOTypeApplication> getTypesApplication(EOEditingContext ed) {
		return Finder.tableauTrie(fetchTypeApplications(ed), sort());
	}

	/**
	 * Recherche d'un type application par son libelle. <BR>
	 * 
	 * @param ed editingContext dans lequel se fait le fetch
	 * @param libelle libelle auquel correspond l'application
	 * @return un EOTypeApplication
	 */
	public static final EOTypeApplication getTypeApplication(EOEditingContext ed, String libelle) {
		return getUnTypeApplication(ed, libelle);
	}

	/**
	 * Recherche d'un type application par son libelle. <BR>
	 * 
	 * @param ed editingContext dans lequel se fait le fetch
	 * @param libelle libelle auquel correspond l'application
	 * @return un EOTypeApplication
	 */
	private static EOTypeApplication getUnTypeApplication(EOEditingContext ed, String libelle) {
		NSArray typeApplications = null;

		NSArray arrayTypeApplication = fetchTypeApplications(ed);

		typeApplications = new NSArray((NSArray) (EOQualifier.filteredArrayWithQualifier(arrayTypeApplication,
				EOQualifier.qualifierWithQualifierFormat(EOTypeApplication.TYAP_STRID_KEY + " = %@", new NSArray(libelle)))));

		if (typeApplications == null || typeApplications.count() == 0)
			return null;

		return (EOTypeApplication) typeApplications.objectAtIndex(0);
	}

	/**
	 * Fetch tous les types d'application pour les garder en memoire et eviter de refetcher ensuite <BR>
	 * 
	 * @param ed editingContext dans lequel se fait le fetch
	 */
	private static NSArray<EOTypeApplication> fetchTypeApplications(EOEditingContext ed) {
		return Finder.fetchArray(ed, EOTypeApplication.ENTITY_NAME, null, null, null, true);
	}

	private static NSArray sort() {
		return new NSArray(EOSortOrdering.sortOrderingWithKey(EOTypeApplication.TYAP_LIBELLE_KEY, EOSortOrdering.CompareCaseInsensitiveAscending));
	}
}
