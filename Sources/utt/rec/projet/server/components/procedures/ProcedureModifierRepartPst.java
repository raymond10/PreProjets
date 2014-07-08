/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EORepartaxe;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureModifierRepartPst extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "updRepartPst";
	
	public ProcedureModifierRepartPst() {
		// TODO Auto-generated constructor stub
	}
	
	//Exécution de la procédure
	public static boolean update(_CktlBasicDataBus dataBus, EORepartaxe pst) throws NSValidation.ValidationException{
	    return dataBus.executeProcedure(ProcedureModifierRepartPst.PROCEDURE_NAME, 
	    		ProcedureModifierRepartPst.construireDictionnaire(pst));
	}
	
	//Construction des valeurs à mettre en paramètre de la procédure.
	private static NSDictionary construireDictionnaire(EORepartaxe pst){
		NSMutableDictionary dico= new NSMutableDictionary();
		NSDictionary dicoForPrimaryKeys = null;
		// on cherche la cle du repart_pst
		dicoForPrimaryKeys = EOUtilities.primaryKeyForObject(pst.editingContext(), pst);
		dico.takeValueForKey(Integer.valueOf(pst.primaryKey()), "10_a_pstid");
		dico.takeValueForKey(Integer.valueOf(pst.toAxe().primaryKey()), "20_a_axeid");
		dico.takeValueForKey(Integer.valueOf(pst.toProjet().primaryKey()), "30_a_projetid");
		dico.takeValueForKey(pst.temvalide(), "40_a_temvalide");
		dico.takeValueForKey(pst.majcreate(), "50_a_majcreate");
		return dico;
	}

}
