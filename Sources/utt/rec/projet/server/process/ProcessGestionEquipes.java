/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureCreerEquipes;
import utt.rec.projet.server.components.procedures.ProcedureModifierEquipes;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOEquipes;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionEquipes extends Process {
	
	public ProcessGestionEquipes() {
		// TODO Auto-generated constructor stub
	}
	
	protected static void insererEquipe(_CktlBasicDataBus databus, EOEditingContext ed, EOEquipes equipe) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureCreerEquipes.enregistrer(databus, equipe);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du projet
		equipe.setEquipesIdProc((Integer) dico.valueForKey("010_oe_equipesid"));
	}
	
	protected static void modifierEquipe(_CktlBasicDataBus databus, EOEditingContext ed, EOEquipes equipe) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on fait la MAJ dans la table EQUIPES
		pbProcedure = ProcedureModifierEquipes.update(databus, equipe);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}

}
