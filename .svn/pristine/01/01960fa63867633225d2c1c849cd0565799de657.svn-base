/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.components.procedures.ProcedureInsertMotClefs;
import utt.rec.projet.server.components.procedures.ProcedureModifierMotClefs;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOMotclefs;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionMotClefs extends Process {
	
	public ProcessGestionMotClefs() {
		// TODO Auto-generated constructor stub
	}
	
	protected static void insererMotClef(_CktlBasicDataBus databus, EOEditingContext ed, EOMotclefs keyword) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureInsertMotClefs.enregistrer(databus, keyword);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du mot clef
		keyword.setKeywordIdProc((Integer) dico.valueForKey("10_motclefid"));
	}
	
	protected static void modifierMotClef(_CktlBasicDataBus databus, EOEditingContext ed, EOMotclefs keyword) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureModifierMotClefs.update(databus, keyword);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du mot clef
		//keyword.setKeywordIdProc((Integer) dico.valueForKey("10_motclefid"));
	}

}
