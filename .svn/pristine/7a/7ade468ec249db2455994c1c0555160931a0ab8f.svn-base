/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureCreerPoste;
import utt.rec.projet.server.components.procedures.ProcedureModifierPoste;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPosterh;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionPostesRh extends Process {
	
	protected static void insererPoste(_CktlBasicDataBus databus, EOEditingContext ed, EOPosterh poste) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on enregistre dans la table POSTERH
		pbProcedure = ProcedureCreerPoste.enregistrer(databus, poste);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du poste
		poste.setPosteIdProc((Number) dico.valueForKey("010_pos_id"));		
	}
	
	protected static void modifierPoste(_CktlBasicDataBus databus, EOEditingContext ed, EOPosterh poste) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on fait la MAJ dans la table POSTERH
		pbProcedure = ProcedureModifierPoste.update(databus, poste);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}

}
