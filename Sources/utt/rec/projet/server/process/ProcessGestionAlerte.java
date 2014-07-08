/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureCreerAlerte;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOAlerte;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ProcessGestionAlerte extends Process {

	/**
	 * 
	 */
	public ProcessGestionAlerte() {
		// TODO Auto-generated constructor stub
	}

	protected static void insererAlerte(_CktlBasicDataBus databus,
			EOEditingContext ed, EOAlerte alerte) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureCreerAlerte.enregistrer(databus, alerte);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}

	}

}
