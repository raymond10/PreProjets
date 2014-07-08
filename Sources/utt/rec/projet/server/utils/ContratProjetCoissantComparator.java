/**
 * 
 */
package utt.rec.projet.server.utils;

import utt.rec.projet.server.metier.admrec.EOTypcontrat;

import com.webobjects.foundation.NSComparator;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *14 oct. 2013
 */
public class ContratProjetCoissantComparator extends NSComparator {

	/* (non-Javadoc)
	 * @see com.webobjects.foundation.NSComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object paramObject1, Object paramObject2)
			throws ComparisonException {
		// TODO Auto-generated method stub
		if(paramObject1 instanceof EOTypcontrat && paramObject2 instanceof EOTypcontrat) {
			EOTypcontrat contrat0 = (EOTypcontrat) paramObject1, contrat1 = (EOTypcontrat) paramObject2;
			return contrat0.typcontNomAbr().compareTo(contrat1.typcontNomAbr());
		} else {
			return NSComparator.OrderedSame;
		}
	}

}
