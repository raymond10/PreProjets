/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessPartProjet extends Process {

	public ProcessPartProjet() {
		// TODO Auto-generated constructor stub
	}

	public static void enregistrer(_CktlBasicDataBus databus,
			EOEditingContext ed, EOPartenaireProjet partproj) {
		boolean equipeEnModification = false;
		if (partproj == null)
			throw new FactoryException(
					"il faut passer un PartenaireProjet en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");
		// on regarde si le partenaire a une cle et donc si c'est une creation ou une
		// modification
		if (EOUtilities.primaryKeyForObject(ed, partproj) != null)
			equipeEnModification = true;
		
		if (!equipeEnModification) {
			try {
				if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
					System.out
							.println("Methode ProcessPartProjet.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
					_CktlBasicDataBus.adaptorContext().rollbackTransaction();
				}
				databus.beginTransaction();
				ProcessGestionPartProjet.insererPartProjet(databus, ed,
						partproj);
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

		try {
			if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
				System.out
						.println("Methode ProcessPartProjet.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
				_CktlBasicDataBus.adaptorContext().rollbackTransaction();
			}
			databus.beginTransaction();
			ProcessGestionPartProjet.modifierPartProjet(databus, ed, partproj);
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
