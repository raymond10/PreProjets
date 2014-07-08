/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

import utt.rec.projet.server.metier.admrec.EOAlerte;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureCreerAlerte extends ProjectPRC {

	private static final String PROCEDURE_NAME = "addAlerte";

	public ProcedureCreerAlerte() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer(_CktlBasicDataBus dataBus, EOAlerte alerte)
			throws NSValidation.ValidationException {
		return dataBus.executeProcedure(ProcedureCreerAlerte.PROCEDURE_NAME,
				ProcedureCreerAlerte.construireDictionnaire(alerte));

	}

	private static NSDictionary construireDictionnaire(EOAlerte alerte) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico = new NSMutableDictionary();
		dico.takeValueForKey(null, "10_a_alerte_id");
		if (alerte.toProjet().primaryKey() != null) {
			dico.takeValueForKey(Integer.valueOf(alerte.toProjet().primaryKey()),
					"20_a_projet_id");
		} else {
			dico.takeValueForKey(alerte.toProjet().getProjIdProc(),
					"20_a_projet_id");
		}
		dico.takeValueForKey(alerte.cStructure(), "30_a_pole_id");
		dico.takeValueForKey(null, "40_a_comment_id");
		dico.takeValueForKey(alerte.libelle(), "50_a_lebelle");
		dico.takeValueForKey(alerte.prjHashcodeVis(), "60_a_vis_hash");
		dico.takeValueForKey(alerte.prjHashcodeVal(), "70_a_val_hash");
		return dico;
	}

}
