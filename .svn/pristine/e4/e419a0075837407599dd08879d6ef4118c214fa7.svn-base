/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("rawtypes")
public class ProcedureInsertMotClefs extends ProjectPRC {

	private static final String PROCEDURE_NAME = "addRepartIdx";

	public ProcedureInsertMotClefs() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer(_CktlBasicDataBus dataBus,
			EOMotclefs keyword) throws NSValidation.ValidationException {
		return dataBus.executeProcedure(ProcedureInsertMotClefs.PROCEDURE_NAME,
				ProcedureInsertMotClefs.construireDictionnaire(keyword));
	}

	private static NSDictionary construireDictionnaire(EOMotclefs keyword) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico = new NSMutableDictionary();
		dico.takeValueForKey(null, "10_motclefid");
		if (keyword.toProjet().primaryKey() != null) {
			dico.takeValueForKey(
					Integer.valueOf(keyword.toProjet().primaryKey()),
					"20_projetId");
		} else {
			dico.takeValueForKey(keyword.toProjet().getProjIdProc(),
					"20_projetId");
		}
		dico.takeValueForKey(Integer.valueOf(keyword.toRefidx().primaryKey()),
				"30_refidxId");
		dico.takeValueForKey(keyword.temvalide(), "40_temvalide");
		return dico;
	}

}
