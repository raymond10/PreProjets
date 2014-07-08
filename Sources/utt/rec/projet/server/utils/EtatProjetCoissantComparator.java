/**
 * 
 */
package utt.rec.projet.server.utils;

import utt.rec.projet.server.metier.admrec.EOTypref;

import com.webobjects.foundation.NSComparator;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 14 oct. 2013
 */
@SuppressWarnings("all")
public class EtatProjetCoissantComparator extends NSComparator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webobjects.foundation.NSComparator#compare(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public int compare(Object paramObject1, Object paramObject2)
			throws ComparisonException {
		// TODO Auto-generated method stub
		if (paramObject1 instanceof EOTypref
				&& paramObject2 instanceof EOTypref) {
			EOTypref etat0  = (EOTypref) paramObject1, etat1 = (EOTypref) paramObject2;
			return etat0.typreflib().compareTo(etat1.typreflib());
		} else {
			return NSComparator.OrderedSame;
		}
	}

}
