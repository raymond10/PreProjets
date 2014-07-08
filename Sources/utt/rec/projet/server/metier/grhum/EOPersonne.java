package utt.rec.projet.server.metier.grhum;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

public class EOPersonne extends _EOPersonne {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1407946260893192691L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOPersonne.class);
	
	//ORDER BY sur le NOM
	public static final EOSortOrdering SORT_NOM_ASC = EOSortOrdering
			.sortOrderingWithKey(PERS_NOMPTR_KEY, EOSortOrdering.CompareAscending);
	//ORDER BY sur le PRENOM
	public static final EOSortOrdering SORT_PRENOM_ASC = EOSortOrdering
			.sortOrderingWithKey(PERS_LC_KEY, EOSortOrdering.CompareAscending);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final NSArray<EOSortOrdering> ByNomPrenom(){
		return new NSArray(new Object[]{SORT_NOM_ASC,SORT_PRENOM_ASC});
	}
}
