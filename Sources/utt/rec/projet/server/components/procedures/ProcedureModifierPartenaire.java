/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureModifierPartenaire extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "updPartenaire";
	
	public ProcedureModifierPartenaire() {
		// TODO Auto-generated constructor stub
	}
	
public static boolean update(_CktlBasicDataBus dataBus, EOTyppartenaire partenaire) throws NSValidation.ValidationException{
		
		return dataBus.executeProcedure(ProcedureModifierPartenaire.PROCEDURE_NAME, 
				ProcedureModifierPartenaire.construireDictionnaire(partenaire));
	}
	
	private static NSDictionary construireDictionnaire(EOTyppartenaire partenaire) {
		NSMutableDictionary dico=new NSMutableDictionary();
		NSDictionary 		dicoForPrimaryKeys=null;
		// on cherche la cle du materiel
		dicoForPrimaryKeys=EOUtilities.primaryKeyForObject(partenaire.editingContext(), partenaire);
		dico.takeValueForKey(dicoForPrimaryKeys.objectForKey(EOTyppartenaire.TYPPART_ID_KEY), "010_typartId");
		dico.takeValueForKey(partenaire.partCleunik(), "020_partCleUnik");
		dico.takeValueForKey(partenaire.nomPartenaire(), "030_nom_partenaire");
		dico.takeValueForKey(partenaire.ctPartenaire(), "040_c_t_partenaire");
		dico.takeValueForKey(partenaire.cStPartenaire(), "050_c_st_partenaire");
		dico.takeValueForKey(partenaire.denomUsuelle(), "060_denomUsuelle");
		return dico;
	}

}
