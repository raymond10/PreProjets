/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.components.procedures.ProcedureCreerPartenaire;
import utt.rec.projet.server.components.procedures.ProcedureModifierPartenaire;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcessGestionPartenaire extends Process {
	
	public ProcessGestionPartenaire() {
		// TODO Auto-generated constructor stub
	}

	protected static void insererPartenaire(_CktlBasicDataBus databus, EOEditingContext ed, EOTyppartenaire partenaire) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		pbProcedure = ProcedureCreerPartenaire.enregistrer(databus, partenaire);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
		//On récupère la clé du partenaire creer
		partenaire.setTypIdProc((Integer) dico.valueForKey("010_typartId"));
	}
	
	protected static void modifierPartenairel(_CktlBasicDataBus databus, EOEditingContext ed, EOTyppartenaire partenaire) throws FactoryException {
		boolean pbProcedure = false;
		NSDictionary dico = null;
		// on fait la MAJ dans la table TYPPARTENAIRE
		pbProcedure = ProcedureModifierPartenaire.update(databus, partenaire);
		dico = new NSDictionary(databus.executedProcResult());
		if (!pbProcedure) {
			throw new FactoryException((String) dico.valueForKey("ERREUR"));
		}
	}

}
