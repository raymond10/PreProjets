/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOCommentaires;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("rawtypes")
public class ProcedureCreerCommentaire extends ProjectPRC {

	private static final String PROCEDURE_NAME = "insCommentOtherEquipe";

	public ProcedureCreerCommentaire() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer (_CktlBasicDataBus dataBus,
			EOCommentaires comment) throws NSValidation.ValidationException {
		return dataBus.executeProcedure(
				ProcedureCreerCommentaire.PROCEDURE_NAME,
				ProcedureCreerCommentaire.construireDictionnaire(comment));
	}

	private static NSDictionary construireDictionnaire(EOCommentaires comment) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico = new NSMutableDictionary();

		// on met la cle de la table a null, elle sera generee dans la procedure
		dico.takeValueForKey(null, "010_commentId");

		// On renseigne la cle du projet
		if (comment.toProjet() != null) {
			dico.takeValueForKey(comment.projet(),"020_projet");
		} else {
			dico.takeValueForKey(null, "020_projetId");
		}
		// On renseigne la cle de la structure
		if (comment.cStructure() != null) {
			dico.takeValueForKey(comment.cStructure(),"040_cStructure");
		} else {
			dico.takeValueForKey(null, "040_cStructure");
		}
		dico.takeValueForKey(comment.commentaires(), "050_comments");
		dico.takeValueForKey(comment.createDate(), "060_comCreate");
		dico.takeValueForKey(new NSTimestamp(), "070_comMajdate");
		dico.takeValueForKey(comment.majAuteur(), "080_comAuteur");
		if(comment.toAvis() != null) {
		dico.takeValueForKey(comment.typrefdom(), "090_avis_a");
		dico.takeValueForKey(comment.typrefnat(), "099_avis_b");
		} else {
			dico.takeValueForKey(null, "090_avis_a");
			dico.takeValueForKey(null, "099_avis_b");
		}
		return dico;
	}

}
