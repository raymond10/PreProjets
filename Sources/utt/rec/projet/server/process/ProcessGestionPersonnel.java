/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureInsertPersonnels;
import utt.rec.projet.server.components.procedures.ProcedureModifierPersonnel;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPersonnel;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionPersonnel extends Process {
	
	public ProcessGestionPersonnel() {
		// TODO Auto-generated constructor stub
	}
	
	protected static void insererPersonnel(_CktlBasicDataBus databus, EOEditingContext ed, EOPersonnel personnel) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on insert dans la table PERSONNEL
		pbProcedure = ProcedureInsertPersonnels.enregistrer(databus, personnel);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}	
	}
	
	protected static void modifierPersonnel(_CktlBasicDataBus databus, EOEditingContext ed, EOPersonnel personnel) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on fait la MAJ dans la table PERSONNEL
		pbProcedure = ProcedureModifierPersonnel.update(databus, personnel);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}	
	}
}
