/**
 * 
 */
package utt.rec.projet.server.utils;

import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.foundation.NSComparator;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *14 oct. 2013
 */
public class IdProjetCoissantComparator extends NSComparator {

	/* (non-Javadoc)
	 * @see com.webobjects.foundation.NSComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object paramObject1, Object paramObject2)
			throws ComparisonException {
		// TODO Auto-generated method stub
		if(paramObject1 instanceof EOPprec && paramObject2 instanceof EOPprec) {
			EOPprec projet0 = (EOPprec) paramObject1, projet1 = (EOPprec) paramObject2;
			return projet0.primaryKey().compareTo(projet1.primaryKey());
		} else {
			return NSComparator.OrderedSame;
		}
	}

}
