/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EORefidx;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessRefIdx extends Process {
	
	public ProcessRefIdx() {
		// TODO Auto-generated constructor stub
	}
	
	public static void enregistrer(_CktlBasicDataBus databus, EOEditingContext ed, EORefidx keyword) throws FactoryException {
		boolean keywordEnModification = false;

		if (keyword == null)
			throw new FactoryException("il faut passer un mot clef en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");

		// on regarde si le mot clef a une cle et donc si c'est une creation ou une modification
		if (EOUtilities.primaryKeyForObject(ed, keyword) != null)
			keywordEnModification = true;

		// creation d'un nouveau nouveau mot clef
		if (!keywordEnModification) {
			try {
				if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
					System.out.println("Methode ProcessRefIdx.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
					_CktlBasicDataBus.adaptorContext().rollbackTransaction();
				}
				databus.beginTransaction();
				ProcessGestionRefIdx.inserer(databus, ed, keyword);
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
	}

}
