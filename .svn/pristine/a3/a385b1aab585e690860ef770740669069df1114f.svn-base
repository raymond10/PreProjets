/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.components.procedures.ProcedureCreerProjet;
import utt.rec.projet.server.components.procedures.ProcedureDeverser;
import utt.rec.projet.server.components.procedures.ProcedureModifierProjet;
import utt.rec.projet.server.components.procedures.ProcedureSupprimerProjet;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionProjet extends Process {
	
	protected static void insererProjet(_CktlBasicDataBus databus, EOEditingContext ed, EOPprec projet) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on enregistre dans la table pprec
		pbProcedure = ProcedureCreerProjet.enregistrer(databus, projet);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du projet
		projet.setProjIdProc((Integer) dico.valueForKey("010_a_proj_Id"));
	}
	
	protected static void modifierProjet(_CktlBasicDataBus databus, EOEditingContext ed, EOPprec projet) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on fait la MAJ dans la table pprec
		pbProcedure = ProcedureModifierProjet.update(databus, projet);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du projet
		projet.setProjIdProc((Integer) dico.valueForKey("010_a_proj_Id"));
	}
	
	protected static void supprimerProjet(_CktlBasicDataBus databus, EOEditingContext ed, EOPprec projet) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on fait la suppression logique dans la table pprec
		pbProcedure = ProcedureSupprimerProjet.supprimer(databus, projet);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}
	
	protected static void deverserVersPleiade(_CktlBasicDataBus databus, EOEditingContext ed, EOPprec projet) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		//on fait le deversement vers pleiade
		pbProcedure = ProcedureDeverser.deverser(databus, projet);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}

}
