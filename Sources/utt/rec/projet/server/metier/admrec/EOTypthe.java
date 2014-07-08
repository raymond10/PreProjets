package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

public class EOTypthe extends _EOTypthe {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5628834607437220164L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOTypthe.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final NSArray<EOSortOrdering> typTheNatTri(){
		return new NSArray(new EOSortOrdering (EOTypthe.TYPTHENAT_KEY, EOSortOrdering.CompareAscending));
	}
}
