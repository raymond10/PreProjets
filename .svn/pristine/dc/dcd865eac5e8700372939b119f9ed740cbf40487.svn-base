/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessPartenaire extends Process {
	
	public ProcessPartenaire() {
		// TODO Auto-generated constructor stub
	}
	
	public static void enregistrer(_CktlBasicDataBus databus, EOEditingContext ed, EOTyppartenaire partenaire) {
		boolean partenaireEnModification = false;
		
		if (partenaire == null)
			throw new FactoryException("il faut passer un Partenaire en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");
		
		// on regarde si le partenaire a une cle et donc si c'est une creation ou une modification
				if (EOUtilities.primaryKeyForObject(ed, partenaire) != null)
					partenaireEnModification = true;
				
		if(!partenaireEnModification){
			try {
				if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
					System.out.println("Methode ProcessPartenaire.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
					_CktlBasicDataBus.adaptorContext().rollbackTransaction();
				}
				databus.beginTransaction();
				ProcessGestionPartenaire.insererPartenaire(databus, ed, partenaire);
				databus.commitTransaction();
			} catch (FactoryException e) {
				databus.rollbackTransaction();
				System.out.println("FactoryException : " + e);
				throw e;
			} catch (Exception e) {
				databus.rollbackTransaction();
				System.out.println("Exception : " + e);
				throw new FactoryException(e.getMessage());
			}
			return;
		}
		
		// modification d'un partenaire precedemment enregistree
		
		try {
			if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
				System.out.println("Methode ProcessPartenaire.update : hasOpenTransaction() --> rollbackTransaction()");
				_CktlBasicDataBus.adaptorContext().rollbackTransaction();
			}
			databus.beginTransaction();
			ProcessGestionPartenaire.modifierPartenairel(databus, ed, partenaire);
			databus.commitTransaction();
		} catch (FactoryException e) {
			databus.rollbackTransaction();
			System.out.println("FactoryException : " + e);
			throw e;
		} catch (Exception e) {
			databus.rollbackTransaction();
			System.out.println("Exception : " + e);
			throw new FactoryException(e.getMessage());
		}
	}
}
