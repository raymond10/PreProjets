/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOPersonnel;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureModifierPersonnel extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "updPersonnel";
	
	public ProcedureModifierPersonnel() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean update(_CktlBasicDataBus dataBus, EOPersonnel personnel) throws NSValidation.ValidationException{
	    return dataBus.executeProcedure(ProcedureModifierPersonnel.PROCEDURE_NAME, 
	    		ProcedureModifierPersonnel.construireDictionnaire(personnel));
	}

	private static NSDictionary construireDictionnaire(EOPersonnel personnel) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico=new NSMutableDictionary();
		NSDictionary dicoForPrimaryKeys = null;
		
		// on cherche la cle du projet
		dicoForPrimaryKeys=EOUtilities.primaryKeyForObject(personnel.editingContext(), personnel);
		dico.takeValueForKey(Integer.valueOf(personnel.primaryKey()), "010_ personnelid");
		dico.takeValueForKey(Integer.valueOf(personnel.toProjet().primaryKey()), "020_per_projid");
		dico.takeValueForKey(Integer.valueOf(personnel.noIndividu()), "030_per_noindividu");
		dico.takeValueForKey(personnel.cStructure(), "040_per_pole");
		dico.takeValueForKey(personnel.tempsuitl(), "050_per_tempsutil");
		dico.takeValueForKey(personnel.coutestime(), "060_per_cout");
		dico.takeValueForKey(personnel.nomStructure(), "070_per_nom_pole");
		dico.takeValueForKey(personnel.nomPersonnel(), "080_per_nom");
		dico.takeValueForKey(personnel.temvalide(), "090_per_tem_valide");
		return dico;
	}

}
