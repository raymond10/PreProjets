/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOGemateriel;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation.ValidationException;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureNouveauMateriel extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "newGemateriel";
	
	public ProcedureNouveauMateriel() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean enregistrer(_CktlBasicDataBus dataBus, EOGemateriel materiel)
			throws ValidationException {
		return dataBus.executeProcedure(ProcedureNouveauMateriel.PROCEDURE_NAME,
				ProcedureNouveauMateriel.construireDictionnaire(materiel));
	}
	
	private static NSDictionary construireDictionnaire(EOGemateriel materiel) {
		NSMutableDictionary dico = new NSMutableDictionary();
		
		// on met la cle de la table a null, elle sera generee dans la procedure
		dico.takeValueForKey(null, "10_ge_matid");
		dico.takeValueForKey(materiel.toPfmateriel().primaryKey(), "20_ge_pfmatid");
		dico.takeValueForKey(materiel.gematLib(), "30_ge_matlib");
		dico.takeValueForKey(materiel.gematBrute(), "40_ge_matbrute");
		dico.takeValueForKey(materiel.coutEstime(), "50_ge_cout");
		return dico;
	}

}
