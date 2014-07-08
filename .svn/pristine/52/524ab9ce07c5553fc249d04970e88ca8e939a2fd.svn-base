/**
 * 
 */
package utt.rec.projet.server.utils;

import utt.rec.projet.server.metier.grhum.EOIndividuUlr;

import com.webobjects.foundation.NSComparator;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *14 oct. 2013
 */
public class PorteurProjetCoissantComparator extends NSComparator {

	/* (non-Javadoc)
	 * @see com.webobjects.foundation.NSComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object paramObject1, Object paramObject2)
			throws ComparisonException {
		// TODO Auto-generated method stub
		if (paramObject1 instanceof EOIndividuUlr
				&& paramObject2 instanceof EOIndividuUlr) {
			EOIndividuUlr individu0 = (EOIndividuUlr) paramObject1, individu1 = (EOIndividuUlr) paramObject2;
			return individu0.fullname().compareTo(individu1.fullname());
		} else {
			return NSComparator.OrderedSame;
		}
	}

}
