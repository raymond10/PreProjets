/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureAlimenterMotClefs;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EORefidx;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionRefIdx extends Process {
	
	public ProcessGestionRefIdx() {
		// TODO Auto-generated constructor stub
	}
	
	protected static void inserer(_CktlBasicDataBus databus, EOEditingContext ed, EORefidx keyword) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on enregistre dans la table refidx
		pbProcedure = ProcedureAlimenterMotClefs.enregistrer(databus, keyword);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du nouveau mot clef
		keyword.setProcId((Integer) dico.valueForKey("010_a_refidxid"));
	}

}
