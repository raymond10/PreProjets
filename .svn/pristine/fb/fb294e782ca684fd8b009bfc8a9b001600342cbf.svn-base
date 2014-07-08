/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOEquipes;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessEquipes extends Process {
	
	public ProcessEquipes() {
		// TODO Auto-generated constructor stub
	}
	
	public static void enregistrer(_CktlBasicDataBus databus, EOEditingContext ed, EOEquipes equipe) {
		boolean equipeEnModification = false;
		
		if (equipe == null)
			throw new FactoryException("il faut passer une Equipe en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");
		// on regarde si l'Žquipe a une cle et donc si c'est une creation ou une modification
		if (EOUtilities.primaryKeyForObject(ed, equipe) != null)
			equipeEnModification = true;
		
		if(!equipeEnModification){
			try {
				if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
					System.out.println("Methode ProcessEquipe.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
					_CktlBasicDataBus.adaptorContext().rollbackTransaction();
				}
				databus.beginTransaction();
				ProcessGestionEquipes.insererEquipe(databus, ed, equipe);
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

		// modification d'une equipe dŽjˆ existante		
		try {
			if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
				System.out.println("Methode ProcessEquipe.update : hasOpenTransaction() --> rollbackTransaction()");
				_CktlBasicDataBus.adaptorContext().rollbackTransaction();
			}
			databus.beginTransaction();
			ProcessGestionEquipes.modifierEquipe(databus, ed, equipe);
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
