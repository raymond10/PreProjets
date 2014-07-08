/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureCreerCommentaire;
import utt.rec.projet.server.components.procedures.ProcedureCreerProjet;
import utt.rec.projet.server.components.procedures.ProcedureModifierCommentaire;
import utt.rec.projet.server.components.procedures.ProcedureModifierProjet;
import utt.rec.projet.server.components.procedures.ProcedureSupprimerCommentaire;
import utt.rec.projet.server.components.procedures.ProcedureSupprimerProjet;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOCommentaires;
import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionComment extends Process {
	
	protected static void insererComment(_CktlBasicDataBus databus, EOEditingContext ed, EOCommentaires comment) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on enregistre dans la table eqpsecond_comment
		pbProcedure = ProcedureCreerCommentaire.enregistrer(databus, comment);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du commentaire
		comment.setCommId((Integer) dico.valueForKey("010_commentId"));
	}
	
	protected static void modifierComment(_CktlBasicDataBus databus, EOEditingContext ed, EOCommentaires comment) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on fait la MAJ dans la table eqpsecond_comment
		pbProcedure = ProcedureModifierCommentaire.update(databus, comment);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}
	
	protected static void supprimerComment(_CktlBasicDataBus databus, EOEditingContext ed, EOCommentaires comment) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on fait la suppression dans la table eqpsecond_comment
		pbProcedure = ProcedureSupprimerCommentaire.delete(databus, comment);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}

}
