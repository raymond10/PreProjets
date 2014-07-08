/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.metier.admrec.EOCommentaires;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureModifierCommentaire extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "updCommentOtherEquipe";
	
	public ProcedureModifierCommentaire() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean update (_CktlBasicDataBus dataBus,
			EOCommentaires comment) throws NSValidation.ValidationException {
		return dataBus.executeProcedure(
				ProcedureModifierCommentaire.PROCEDURE_NAME,
				ProcedureModifierCommentaire.construireDictionnaire(comment));
	}

	private static NSDictionary construireDictionnaire(EOCommentaires comment) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico = new NSMutableDictionary();
		NSDictionary 		dicoForPrimaryKeys=null;

		// on cherche la cle du commentairet
		dicoForPrimaryKeys=EOUtilities.primaryKeyForObject(comment.editingContext(), comment);
		dico.takeValueForKey(Integer.valueOf(comment.primaryKey()), "010_commentId");

		// On renseigne la cle du projet
		if (comment.toProjet() != null) {
			dico.takeValueForKey(comment.projet(),	"020_projet");
		} else {
			dico.takeValueForKey(null, "020_projet");
		}
		// On renseigne la cle de l'equipe
		if (comment.cStructure() != null) {
			dico.takeValueForKey(comment.cStructure(),"040_cStructure");
		} else {
			dico.takeValueForKey(null, "040_cStructure");
		}
		dico.takeValueForKey(comment.commentaires(), "050_comments");
		dico.takeValueForKey(comment.createDate(), "060_comCreate");
		dico.takeValueForKey(comment.majDate(), "070_comMajdate");
		dico.takeValueForKey(comment.majAuteur(), "080_comAuteur");
		dico.takeValueForKey(comment.toAvis().typrefdom(), "090_avis_a");
		dico.takeValueForKey(comment.toAvis().typrefnat(), "099_avis_b");
		return dico;
	}

}
