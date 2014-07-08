/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOResmat;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessMateriel extends Process {

	public ProcessMateriel() {
		// TODO Auto-generated constructor stub
	}

	public static void enregistrer(_CktlBasicDataBus databus,
			EOEditingContext ed, EOResmat materiel) {
		boolean materielEnModification = false;
		if (materiel == null)
			throw new FactoryException(
					"il faut passer un matŽriel en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");
		// on regarde si le poste a une cle et donc si c'est une creation ou une
		// modification
		if (EOUtilities.primaryKeyForObject(ed, materiel) != null)
			materielEnModification = true;

		if (!materielEnModification) {
			try {
				if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
					System.out
							.println("Methode ProcessMateriel.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
					_CktlBasicDataBus.adaptorContext().rollbackTransaction();
				}
				databus.beginTransaction();
				ProcessGestionMateriel.insererMateriel(databus, ed, materiel);
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

		// modification d'un materiel precedemment enregistree
		// on ouvre une transaction

		try {
			if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
				System.out
						.println("Methode ProcessMateriel.update : hasOpenTransaction() --> rollbackTransaction()");
				_CktlBasicDataBus.adaptorContext().rollbackTransaction();
			}

			databus.beginTransaction();
			ProcessGestionMateriel.modifierMateriel(databus, ed, materiel);
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
