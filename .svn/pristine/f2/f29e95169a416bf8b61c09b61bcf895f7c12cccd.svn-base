/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOResmat;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("rawtypes")
public class ProcedureCreerMateriel extends ProjectPRC {

	private static final String PROCEDURE_NAME = "insMateriel";

	public ProcedureCreerMateriel() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer(_CktlBasicDataBus dataBus,
			EOResmat materiel) throws NSValidation.ValidationException {
		return dataBus.executeProcedure(ProcedureCreerMateriel.PROCEDURE_NAME,
				ProcedureCreerMateriel.construireDictionnaire(materiel));
	}

	private static NSDictionary construireDictionnaire(EOResmat materiel) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico = new NSMutableDictionary();
		dico.takeValueForKey(null, "010_m_id");
		if (materiel.toProjet().primaryKey() != null) {
			dico.takeValueForKey(
					Integer.valueOf(materiel.toProjet().primaryKey()),
					"020_m_projid");
		} else {
			dico.takeValueForKey(materiel.toProjet().getProjIdProc(),
					"020_m_projid");
		}
		dico.takeValueForKey(materiel.cStructure(), "030_m_pole");
		dico.takeValueForKey(materiel.creadate(), "040_m_create");
		dico.takeValueForKey(materiel.majdate(), "050_m_majdate");
		dico.takeValueForKey(materiel.majauteur(), "060_m_majauteur");
		dico.takeValueForKey(
				Integer.valueOf(materiel.toGrandEquipement().primaryKey()),
				"070_m_gematid");
		dico.takeValueForKey(materiel.txfinancement(), "080_m_finance");
		dico.takeValueForKey(materiel.matexist(), "090_m_matexist");
		dico.takeValueForKey(materiel.matutil(), "091_m_matutil");
		dico.takeValueForKey(materiel.toPlateauTech().primaryKey(),
				"092_m_categ");
		dico.takeValueForKey(materiel.coutestime(), "094_m_coustestime");
		dico.takeValueForKey(materiel.nomStructure(), "095_m_nom_pole");
		dico.takeValueForKey(materiel.temvalide(), "096_m_tem_valide");
		return dico;
	}

}
