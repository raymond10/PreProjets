/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureCreerPlateau;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionPlateau extends Process {
	
	public ProcessGestionPlateau() {
		// TODO Auto-generated constructor stub
	}
	
	protected static void insererPlateau(_CktlBasicDataBus databus, EOEditingContext ed, EOPfmateriel matos) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureCreerPlateau.enregistrer(databus, matos);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}

}
