/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureModifierPartenaireProjet extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "updRepartPart";
	
	public ProcedureModifierPartenaireProjet() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean update(_CktlBasicDataBus dataBus, EOPartenaireProjet partproj) throws NSValidation.ValidationException{
	    return dataBus.executeProcedure(ProcedureModifierPartenaireProjet.PROCEDURE_NAME, 
	    		ProcedureModifierPartenaireProjet.construireDictionnaire(partproj));
	}

	private static NSDictionary construireDictionnaire(EOPartenaireProjet partproj) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico=new NSMutableDictionary();
		dico.takeValueForKey(Integer.valueOf(partproj.primaryKey()), "10_partprojid");
		dico.takeValueForKey(Integer.valueOf(partproj.projetId()), "20_projid");
		dico.takeValueForKey(Integer.valueOf(partproj.typpartId()), "30_partid");
		dico.takeValueForKey(partproj.temvalide(), "40_temvalide");
		return dico;
	}

}
