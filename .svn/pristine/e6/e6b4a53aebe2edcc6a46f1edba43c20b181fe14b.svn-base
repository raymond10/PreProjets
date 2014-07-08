/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOPosterh;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureModifierPoste extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "updPosteRh";
	
	public ProcedureModifierPoste() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean update(_CktlBasicDataBus dataBus, EOPosterh poste) throws NSValidation.ValidationException{
		
		return dataBus.executeProcedure(ProcedureModifierPoste.PROCEDURE_NAME, 
				ProcedureModifierPoste.construireDictionnaire(poste));
	}
	
	private static NSDictionary construireDictionnaire(EOPosterh poste) {
		NSMutableDictionary dico=new NSMutableDictionary();
		NSDictionary 		dicoForPrimaryKeys=null;
		// on cherche la cle du poste
		dicoForPrimaryKeys=EOUtilities.primaryKeyForObject(poste.editingContext(), poste);
		dico.takeValueForKey(dicoForPrimaryKeys.objectForKey(EOPosterh.ID_POSTE_KEY), "010_pos_id");
		dico.takeValueForKey(poste.cStructure(), "020_pos_pole");
		dico.takeValueForKey(Long.valueOf(poste.toProjet().primaryKey()), "030_pos_projid");
		dico.takeValueForKey(poste.creadate(), "040_pos_create");
		dico.takeValueForKey(poste.majdate(), "050_pos_majdate");
		dico.takeValueForKey(poste.majauteur(), "060_pos_majauteur");
		dico.takeValueForKey(poste.postelib(), "070_pos_postelib");
		dico.takeValueForKey(poste.txfinancement(), "080_pos_finance");
		dico.takeValueForKey(Integer.valueOf(poste.toCategorieRh().primaryKey()), "090_pos_categ");
		dico.takeValueForKey(poste.coutestime(), "091_pos_coutestime");
		dico.takeValueForKey(poste.dureeRecrue(), "092_pos_duree");
		dico.takeValueForKey(poste.nomStructure(), "093_pos_nom_pole");
		dico.takeValueForKey(poste.temvalide(), "094_post_tem_valide");
		return dico;
	}

}
