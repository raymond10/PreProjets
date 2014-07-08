/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.components.procedures.ProcedureNouveauMateriel;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOGemateriel;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionNouveauMateriel extends Process {
	
	protected static void insererMateriel(_CktlBasicDataBus databus, EOEditingContext ed, EOGemateriel materiel) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on enregistre dans la table Gemateriel
		pbProcedure = ProcedureNouveauMateriel.enregistrer(databus, materiel);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du materiel
		materiel.setGematIdProc((Integer) dico.valueForKey("10_ge_matid"));
	}

}
