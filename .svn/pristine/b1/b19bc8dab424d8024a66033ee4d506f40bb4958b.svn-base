/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOPosterh;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("rawtypes")
public class ProcedureCreerPoste extends ProjectPRC {

	private static final String PROCEDURE_NAME = "insPosteRh";

	public ProcedureCreerPoste() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer(_CktlBasicDataBus dataBus, EOPosterh poste)
			throws NSValidation.ValidationException {
		return dataBus.executeProcedure(ProcedureCreerPoste.PROCEDURE_NAME,
				ProcedureCreerPoste.construireDictionnaire(poste));
	}

	private static NSDictionary construireDictionnaire(EOPosterh poste) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico = new NSMutableDictionary();
		dico.takeValueForKey(null, "010_pos_id");
		dico.takeValueForKey(poste.cStructure(), "020_pos_pole");
		if (poste.toProjet().primaryKey() != null) {
			dico.takeValueForKey(Integer.valueOf(poste.toProjet().primaryKey()),
					"030_pos_projid");
		} else {
			dico.takeValueForKey(poste.toProjet().getProjIdProc(),
					"030_pos_projid");
		}
		dico.takeValueForKey(poste.creadate(), "040_pos_create");
		dico.takeValueForKey(poste.majdate(), "050_pos_majdate");
		dico.takeValueForKey(poste.majauteur(), "060_pos_majauteur");
		dico.takeValueForKey(poste.postelib(), "070_pos_postelib");
		dico.takeValueForKey(poste.txfinancement(), "080_pos_finance");
		dico.takeValueForKey(Integer.valueOf(poste.toCategorieRh().primaryKey()),
				"090_pos_categ");
		dico.takeValueForKey(poste.coutestime(), "091_pos_coutestime");
		dico.takeValueForKey(poste.dureeRecrue(), "092_pos_duree");
		dico.takeValueForKey(poste.nomStructure(), "093_pos_nom_pole");
		dico.takeValueForKey(poste.temvalide(), "094_post_tem_valide");
		return dico;
	}

}
