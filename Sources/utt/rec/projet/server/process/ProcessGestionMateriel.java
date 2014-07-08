/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureCreerMateriel;
import utt.rec.projet.server.components.procedures.ProcedureModifierMateriel;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOResmat;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionMateriel extends Process {
	
	protected static void insererMateriel(_CktlBasicDataBus databus, EOEditingContext ed, EOResmat materiel) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on enregistre dans la table RESMAT
		pbProcedure = ProcedureCreerMateriel.enregistrer(databus, materiel);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du materiel
		materiel.setMatIdProc((Number) dico.valueForKey("010_m_id"));		
	}
	
	protected static void modifierMateriel(_CktlBasicDataBus databus, EOEditingContext ed, EOResmat materiel) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on fait la MAJ dans la table RESMAT
		pbProcedure = ProcedureModifierMateriel.update(databus, materiel);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}

}
