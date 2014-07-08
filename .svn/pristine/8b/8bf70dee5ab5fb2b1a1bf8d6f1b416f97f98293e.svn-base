/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOEquipes;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("rawtypes")
public class ProcedureCreerEquipes extends ProjectPRC {

	private static String PROCEDURE_NAME = "insOtherEquipe";

	public ProcedureCreerEquipes() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer(_CktlBasicDataBus dataBus,
			EOEquipes equipes) throws NSValidation.ValidationException {
		return dataBus.executeProcedure(ProcedureCreerEquipes.PROCEDURE_NAME,
				ProcedureCreerEquipes.construireDictionnaire(equipes));
	}

	private static NSDictionary construireDictionnaire(EOEquipes equipes) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico = new NSMutableDictionary();
		// on met la cle de la table a null, elle sera generee dans la procedure
		dico.takeValueForKey(null, "010_oe_equipesid");
		if (equipes.toProjet().primaryKey() != null) {
			dico.takeValueForKey(
					Integer.valueOf(equipes.toProjet().primaryKey()),
					"020_oe_projetid");
		} else {
			dico.takeValueForKey(equipes.toProjet().getProjIdProc(),
					"020_oe_projetid");
		}
		dico.takeValueForKey(equipes.cStructure(), "030_oe_cstrure");
		dico.takeValueForKey(equipes.principale().trim(), "040_oe_ekipprin");
		dico.takeValueForKey(equipes.temvalide(), "050_oe_tem_valide");
		return dico;
	}

}
