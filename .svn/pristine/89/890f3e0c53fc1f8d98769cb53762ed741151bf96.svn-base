/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

import utt.rec.projet.server.metier.admrec.EOPfmateriel;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureCreerPlateau extends ProjectPRC {

	/**
	 * 
	 */
	
	private static final String PROCEDURE_NAME = "addPlateau";
	
	public ProcedureCreerPlateau() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean enregistrer(_CktlBasicDataBus dataBus, EOPfmateriel matos) throws NSValidation.ValidationException{
		return dataBus.executeProcedure(ProcedureCreerPlateau.PROCEDURE_NAME,ProcedureCreerPlateau.construireDictionnaire(matos));
	}

	private static NSDictionary construireDictionnaire(EOPfmateriel matos) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico =new NSMutableDictionary();
		dico.takeValueForKey(matos.pfmatId(), "010_a_pfmat_id");
		dico.takeValueForKey(matos.pfmatLib(), "020_a_pfmat_lib");
		dico.takeValueForKey(matos.toStructure().primaryKey(), "030_a_pole");
		dico.takeValueForKey(matos.majAuteur(), "040_a_auteur");
		return dico;
	}

}
