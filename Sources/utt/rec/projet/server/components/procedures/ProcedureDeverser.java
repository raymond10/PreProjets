/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *16 sept. 2013
 */

@SuppressWarnings("all")
public class ProcedureDeverser extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "deverserPredossier";
	
	/**
	 * 
	 */
	public ProcedureDeverser() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean deverser (_CktlBasicDataBus dataBus, EOPprec projet) throws NSValidation.ValidationException{
		if (projet.editingContext().globalIDForObject(projet).isTemporary())
			return true;
		return dataBus.executeProcedure(ProcedureDeverser.PROCEDURE_NAME, 
				ProcedureDeverser.construireDictionnaire(projet));
	}
	
	private static NSDictionary construireDictionnaire(EOPprec projet) {
		NSMutableDictionary dico=new NSMutableDictionary();
		NSDictionary 		dicoForPrimaryKeys=null;
		// on cherche la cle
		dicoForPrimaryKeys=EOUtilities.primaryKeyForObject(projet.editingContext(), projet);
		dico.takeValueForKey(dicoForPrimaryKeys.objectForKey(projet.PROJET_ID_KEY), "010_a_proj_Id");
		return dico;
	}
}
