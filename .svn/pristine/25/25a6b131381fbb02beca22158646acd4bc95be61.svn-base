/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOMotclefs;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureModifierMotClefs extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "updRepartIdx";
	
	public ProcedureModifierMotClefs() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean update(_CktlBasicDataBus dataBus, EOMotclefs keyword) throws NSValidation.ValidationException{
	    return dataBus.executeProcedure(ProcedureModifierMotClefs.PROCEDURE_NAME, 
	    		ProcedureModifierMotClefs.construireDictionnaire(keyword));
	}

	private static NSDictionary construireDictionnaire(EOMotclefs keyword) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico=new NSMutableDictionary();
		NSDictionary 		dicoForPrimaryKeys=null;
		dicoForPrimaryKeys=EOUtilities.primaryKeyForObject(keyword.editingContext(), keyword);
		dico.takeValueForKey(Integer.valueOf(keyword.primaryKey()), "010_motclefid");
		dico.takeValueForKey(Integer.valueOf(keyword.toProjet().primaryKey()), "020_projetId");
		dico.takeValueForKey(Integer.valueOf(keyword.toRefidx().primaryKey()), "030_refidxId");
		dico.takeValueForKey(keyword.temvalide(), "40_temvalide");
		return dico;
	}

}
