/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessPlateau extends Process {

	/**
	 * 
	 */
	public ProcessPlateau() {
		// TODO Auto-generated constructor stub
	}
	
	public static void enregistrer(_CktlBasicDataBus databus, EOEditingContext ed, EOPfmateriel matos) {
		
		if(matos == null)
			throw new FactoryException("il faut passer un Plateau en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");
		try {
			if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
				System.out.println("Methode ProcessPlateau.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
				_CktlBasicDataBus.adaptorContext().rollbackTransaction();
			}
			databus.beginTransaction();
			ProcessGestionPlateau.insererPlateau(databus, ed, matos);
			databus.commitTransaction();
			
		}catch (FactoryException e) {
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
