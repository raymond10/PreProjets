/**
 * 
 */
package utt.rec.projet.server.process;

import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;

import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPosterh;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProcessPoste extends Process {

	public ProcessPoste() {
		// TODO Auto-generated constructor stub
	}

	public static void enregistrer(_CktlBasicDataBus databus,
			EOEditingContext ed, EOPosterh poste) {
		boolean posteEnModification = false;

		if (poste == null)
			throw new FactoryException("il faut passer un poste en parametre");
		if (databus == null || !CktlDataBus.isDatabaseConnected())
			throw new FactoryException("probleme avec le dataBus");
		// on regarde si le poste a une cle et donc si c'est une creation ou une
		// modification
		if (EOUtilities.primaryKeyForObject(ed, poste) != null)
			posteEnModification = true;

		if (!posteEnModification) {
			try {
				if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
					System.out
							.println("Methode ProcessPoste.enregistrer : hasOpenTransaction() --> rollbackTransaction()");
					_CktlBasicDataBus.adaptorContext().rollbackTransaction();
				}
				databus.beginTransaction();
				ProcessGestionPostesRh.insererPoste(databus, ed, poste);
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

		// modification d'un poste precedemment enregistree
		// on ouvre une transaction

		try {
			if (_CktlBasicDataBus.adaptorContext().hasOpenTransaction()) {
				System.out
						.println("Methode ProcessPoste.update : hasOpenTransaction() --> rollbackTransaction()");
				_CktlBasicDataBus.adaptorContext().rollbackTransaction();
			}
			databus.beginTransaction();
			ProcessGestionPostesRh.modifierPoste(databus, ed, poste);
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
