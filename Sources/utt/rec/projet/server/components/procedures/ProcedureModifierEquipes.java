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
public class ProcedureModifierEquipes extends ProjectPRC {
	
	private static String PROCEDURE_NAME = "updOtherEquipe";
	
	public ProcedureModifierEquipes() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean update(_CktlBasicDataBus dataBus, EOEquipes equipes) throws NSValidation.ValidationException{
	    return dataBus.executeProcedure(ProcedureModifierEquipes.PROCEDURE_NAME, 
	    		ProcedureModifierEquipes.construireDictionnaire(equipes));
	}

	private static NSDictionary construireDictionnaire(EOEquipes equipes) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico=new NSMutableDictionary();
		dico.takeValueForKey(Integer.valueOf(equipes.primaryKey()),"010_oe_equipesid");
		dico.takeValueForKey(Integer.valueOf(equipes.toProjet().primaryKey()), "020_oe_projetid");
		dico.takeValueForKey(equipes.cStructure(), "030_oe_cstrure");
		dico.takeValueForKey(equipes.principale(), "040_oe_ekipprin");
		dico.takeValueForKey(equipes.temvalide(), "050_oe_tem_valide");
		return dico;
	}

}
