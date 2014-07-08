/**
 * 
 */
package utt.rec.projet.server.utils;

import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.foundation.NSComparator;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 14 oct. 2013
 */
public class EquipeProjetCoissantComparator extends NSComparator {

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
		if (paramObject1 instanceof EOStructureUlr
				&& paramObject2 instanceof EOStructureUlr) {
			EOStructureUlr structure0 = (EOStructureUlr) paramObject1, structure1 = (EOStructureUlr) paramObject2;
			return structure0.lcStructure().compareTo(structure1.lcStructure());
		} else {
			return NSComparator.OrderedSame;
		}
	}

}
