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
public class ProcedureSupprimerCommentaire extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "delCommentOtherEquipe";
	
	public ProcedureSupprimerCommentaire() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean delete (_CktlBasicDataBus dataBus,
			EOCommentaires comment) throws NSValidation.ValidationException {
		if (comment.editingContext().globalIDForObject(comment).isTemporary())
			return true;
		return dataBus.executeProcedure(
				ProcedureSupprimerCommentaire.PROCEDURE_NAME,
				ProcedureSupprimerCommentaire.construireDictionnaire(comment));
	}

	private static NSDictionary construireDictionnaire(EOCommentaires comment) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico=new NSMutableDictionary();
		NSDictionary 		dicoForPrimaryKeys=null;
		// on cherche la cle
		dicoForPrimaryKeys=EOUtilities.primaryKeyForObject(comment.editingContext(), comment);
		dico.takeValueForKey(dicoForPrimaryKeys.objectForKey(comment.COMMENT_ID_KEY), "010_commentId");
		return dico;
	}

}
