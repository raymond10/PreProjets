/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPersonnel;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessPersonnel extends Process {
	
	public ProcessPersonnel() {
		// TODO Auto-generated constructor stub
	}
	
	public static void enregistrer(_CktlBasicDataBus databus, EOEditingContext ed, EOPersonnel personnel) {
		boolean personnelEnModification = false;
		
		if (personnel == null)
			throw new FactoryException("il faut passer un personnel en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");
		
		// on regarde si le partenaire a une cle et donc si c'est une creation ou une modification
		if (EOUtilities.primaryKeyForObject(ed, personnel) != null)
			personnelEnModification = true;
		
		if(!personnelEnModification){
			try {
				if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
					System.out.println("Methode ProcessPersonnel.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
					_CktlBasicDataBus.adaptorContext().rollbackTransaction();
				}
				databus.beginTransaction();
				ProcessGestionPersonnel.insererPersonnel(databus, ed, personnel);
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
		
		// modification du personnel projet dŽjˆ existant	
		
		try {
			if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
				System.out.println("Methode ProcessPersonnel.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
				_CktlBasicDataBus.adaptorContext().rollbackTransaction();
			}
			databus.beginTransaction();
			ProcessGestionPersonnel.modifierPersonnel(databus, ed, personnel);
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
