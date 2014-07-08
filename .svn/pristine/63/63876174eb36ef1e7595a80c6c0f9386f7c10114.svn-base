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
@SuppressWarnings("all")
public class NomProjetCoissantComparator extends NSComparator {

	/* (non-Javadoc)
	 * @see com.webobjects.foundation.NSComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object arg0, Object arg1)
			throws ComparisonException {
		// TODO Auto-generated method stub
		if (arg0 instanceof EOPprec && arg1 instanceof EOPprec) {
			EOPprec projet0 = (EOPprec) arg0, projet1 = (EOPprec) arg1;
			return projet0.projnomcourt().toUpperCase().compareTo(projet1.projnomcourt().toUpperCase());
		}else {	// Pas de comparaison
			return NSComparator.OrderedSame;
		}
	}

}
