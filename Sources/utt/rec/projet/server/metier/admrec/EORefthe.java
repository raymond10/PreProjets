package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

public class EORefthe extends _EORefthe {
	/**
	 * 
	 */
	private static final long serialVersionUID = 171510258410042811L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EORefthe.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final NSArray<EOSortOrdering> triByLib() {
		return new NSArray (new EOSortOrdering(EORefthe.REFTHELIB_KEY, EOSortOrdering.CompareAscending)
		);
	}
}
