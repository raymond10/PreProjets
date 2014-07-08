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
public class ProcedureInsertPartenaireProjet extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "insRepartPart";
	
	public ProcedureInsertPartenaireProjet() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean enregistrer(_CktlBasicDataBus dataBus, EOPartenaireProjet partproj) throws NSValidation.ValidationException{
	    return dataBus.executeProcedure(ProcedureInsertPartenaireProjet.PROCEDURE_NAME, 
	    		ProcedureInsertPartenaireProjet.construireDictionnaire(partproj));
	}

	private static NSDictionary construireDictionnaire(EOPartenaireProjet partproj) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico=new NSMutableDictionary();
		dico.takeValueForKey(null, "10_partprojid");
		if(partproj.toProjet().primaryKey() != null){
			dico.takeValueForKey(Integer.valueOf(partproj.toProjet().primaryKey()), "20_projid");
		} else {
			dico.takeValueForKey(partproj.toProjet().getProjIdProc(), "20_projid");
		}
		dico.takeValueForKey(Integer.valueOf(partproj.toPartenaire().primaryKey()), "30_partid");
		dico.takeValueForKey(partproj.temvalide(), "40_temvalide");
		return dico;
	}

}
