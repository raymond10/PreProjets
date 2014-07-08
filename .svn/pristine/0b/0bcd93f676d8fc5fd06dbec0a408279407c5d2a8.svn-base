/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EORepartaxe;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessRepartAxe extends Process {
	
	public ProcessRepartAxe() {
		// TODO Auto-generated constructor stub
	}
	
	public static void enregistrer(_CktlBasicDataBus databus, EOEditingContext ed, EORepartaxe pst) {
		boolean equipeEnModification = false;
		
		if (pst == null)
			throw new FactoryException("il faut passer un RepartAxe en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");
		// on regarde si RepartAxe a une cle et donc si c'est une creation ou une modification
		if (EOUtilities.primaryKeyForObject(ed, pst) != null)
			equipeEnModification = true;
		
		if(!equipeEnModification){
			try {
				if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
					System.out.println("Methode ProcessRepartAxe.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
					_CktlBasicDataBus.adaptorContext().rollbackTransaction();
				}
				databus.beginTransaction();
				ProcessGestionPST.insererRepartAxe(databus, ed, pst);
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

		// modification d'un RepartAxe dŽjˆ existante		
		try {
			if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
				System.out.println("Methode ProcessRepartAxe.update : hasOpenTransaction() --> rollbackTransaction()");
				_CktlBasicDataBus.adaptorContext().rollbackTransaction();
			}
			databus.beginTransaction();
			ProcessGestionPST.modifierRepartAxe(databus, ed, pst);
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
