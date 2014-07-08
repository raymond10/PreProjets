/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EORepartaxe;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureCreerRepartPst extends ProjectPRC {

	private static final String PROCEDURE_NAME = "addRepartPst";

	public ProcedureCreerRepartPst() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer(_CktlBasicDataBus dataBus, EORepartaxe pst)
			throws NSValidation.ValidationException {
		return dataBus.executeProcedure(ProcedureCreerRepartPst.PROCEDURE_NAME,
				ProcedureCreerRepartPst.construireDictionnaire(pst));
	}

	private static NSDictionary construireDictionnaire(EORepartaxe pst) {
		NSMutableDictionary dico = new NSMutableDictionary();
		dico.takeValueForKey(null, "10_a_pstid");
		dico.takeValueForKey(Integer.valueOf(pst.toAxe().primaryKey()),
				"20_a_axeid");
		if (pst.toProjet().primaryKey() != null){
			dico.takeValueForKey(Integer.valueOf(pst.toProjet().primaryKey()),
					"30_a_projetid");
		} else {
			dico.takeValueForKey(pst.toProjet().getProjIdProc(),
					"30_a_projetid");
		}
		dico.takeValueForKey(pst.temvalide(), "40_a_temvalide");
		dico.takeValueForKey(pst.majcreate(), "50_a_majcreate");
		return dico;
	}

}
