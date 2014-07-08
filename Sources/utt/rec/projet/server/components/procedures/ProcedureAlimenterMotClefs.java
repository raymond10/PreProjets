/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EORefidx;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("rawtypes")
public class ProcedureAlimenterMotClefs extends ProjectPRC {

	private static final String PROCEDURE_NAME = "insRefidx";

	public ProcedureAlimenterMotClefs() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer(_CktlBasicDataBus dataBus,
			EORefidx keyword) throws NSValidation.ValidationException {
		return dataBus.executeProcedure(
				ProcedureAlimenterMotClefs.PROCEDURE_NAME,
				ProcedureAlimenterMotClefs.construireDictionnaire(keyword));
	}

	private static NSDictionary construireDictionnaire(EORefidx keyword) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico = new NSMutableDictionary();

		// on met la cle de la table a null, elle sera generee dans la procedure
		dico.takeValueForKey(null, "010_a_refidxid");

		// On renseigne la cle du projet
		if (keyword.refidxSup() != null) {
			dico.takeValueForKey(keyword.refidxSup(), "020_a_refidxsup");
		} else {
			dico.takeValueForKey(null, "020_a_refidxsup");
		}

		// On renseigne la cle du projet
		if (keyword.refidxval() != null) {
			dico.takeValueForKey(keyword.refidxval(), "030_a_refidxval");
		} else {
			dico.takeValueForKey(null, "030_a_refidxval");
		}
		return dico;
	}

}
