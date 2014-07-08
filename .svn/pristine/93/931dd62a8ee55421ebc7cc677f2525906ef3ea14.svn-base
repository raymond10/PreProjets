/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureInsertPartenaireProjet;
import utt.rec.projet.server.components.procedures.ProcedureModifierPartenaireProjet;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionPartProjet extends Process {
	
	public ProcessGestionPartProjet() {
		// TODO Auto-generated constructor stub
	}
	
	protected static void insererPartProjet(_CktlBasicDataBus databus, EOEditingContext ed, EOPartenaireProjet partproj) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureInsertPartenaireProjet.enregistrer(databus, partproj);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}	
	}
	
	protected static void modifierPartProjet(_CktlBasicDataBus databus, EOEditingContext ed, EOPartenaireProjet partproj) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureModifierPartenaireProjet.update(databus, partproj);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}	
	}

}
