/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.components.procedures.ProcedureCreerRepartPst;
import utt.rec.projet.server.components.procedures.ProcedureModifierRepartPst;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionPST extends Process {
	
	public ProcessGestionPST() {
		// TODO Auto-generated constructor stub
	}
	
	protected static void insererRepartAxe(_CktlBasicDataBus databus, EOEditingContext ed, EORepartaxe pst) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureCreerRepartPst.enregistrer(databus, pst);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du repart axe
		pst.setRepartPstId((Integer) dico.valueForKey("10_a_pstid"));
	}
	
	protected static void modifierRepartAxe(_CktlBasicDataBus databus, EOEditingContext ed, EORepartaxe pst) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on fait la MAJ dans la table REPART AXE
		pbProcedure = ProcedureModifierRepartPst.update(databus, pst);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}

}
