package utt.rec.projet.server.metier.grhum;

import org.apache.log4j.Logger;

import utt.rec.projet.server.Application;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

@SuppressWarnings("all")
public class EOStructureUlr extends _EOStructureUlr {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6461505843952397693L;
	private static Logger log = Logger.getLogger(EOStructureUlr.class);
	// ORDER BY sur le NOM
		public static final EOSortOrdering SORT_LC_ASC = EOSortOrdering
				.sortOrderingWithKey(LC_STRUCTURE_KEY,
						EOSortOrdering.CompareAscending);
		public static NSArray<String> argsPoles = Application.app().getLcStructuresListPoles().allObjects();
		public static NSArray<String> argsEquipes = Application.app().getLcStructuresListEquipes().allObjects();

	public static final EOQualifier qualPoles() {
		/*NSMutableArray argsPoles = new NSMutableArray();
		argsPoles.addObject("HETIC");
		argsPoles.addObject("P2MN");
		argsPoles.addObject("ROSAS");*/
		return EOQualifier.qualifierWithQualifierFormat(
				"lcStructure=%@ OR lcStructure=%@ OR lcStructure=%@ OR lcStructure=%@", argsPoles);
	}

	public static final EOQualifier qualRepartPole(EORepartStructure repart) {
		/*NSMutableArray argsPoles = new NSMutableArray();
		argsPoles.addObject("HETIC");
		argsPoles.addObject("P2MN");
		argsPoles.addObject("ROSAS");*/
		NSMutableArray qualfinal = new NSMutableArray();
		EOQualifier qualPole = EOQualifier.qualifierWithQualifierFormat(
				"lcStructure=%@ OR lcStructure=%@ OR lcStructure=%@ OR lcStructure=%@", argsPoles);
		EOQualifier qualRepart = new EOKeyValueQualifier(
				EOStructureUlr.C_STRUCTURE_KEY,
				EOQualifier.QualifierOperatorEqual, repart.cStructure());
		qualfinal.addObject(qualPole);
		qualfinal.addObject(qualRepart);
		return new EOAndQualifier(qualfinal);
	}

	public static final EOQualifier qualEquipes() {
		/*NSMutableArray args = new NSMutableArray();
		args.addObject("CREIDD");
		args.addObject("GAMMA3");
		args.addObject("ERA");
		args.addObject("LASMIS");
		args.addObject("LM2S");
		args.addObject("LNIO");
		args.addObject("LOSI");
		args.addObject("TECH-CICO");*/
		return EOQualifier
				.qualifierWithQualifierFormat(
						"lcStructure=%@ OR lcStructure=%@ OR lcStructure=%@ OR lcStructure=%@ "
								+ "OR lcStructure=%@ OR lcStructure=%@ OR lcStructure=%@ OR lcStructure=%@",
								argsEquipes);
	}

	public static EOStructureUlr structurePourcStructure(
			EOEditingContext editingContext, String cStructure) {
		if (cStructure == null)
			return null;
		return fetchEOStructureUlr(editingContext, "cStructure", cStructure);
	}

	public static EOStructureUlr instanciate(EOEditingContext ec) {
		EOStructureUlr structure = (EOStructureUlr) EOUtilities
				.createAndInsertInstance(ec, _EOStructureUlr.ENTITY_NAME);
		return structure;
	}
}
