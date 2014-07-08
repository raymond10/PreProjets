/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOCategorie;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessPoste;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryTraitementPosteRh extends Factory {

	public FactoryTraitementPosteRh() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public NSMutableArray<EOPosterh> postesEncCours(
			CktlAjaxWOComponent component, NSMutableArray postes,
			EOPosterh poste) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		NSArray tmpDg = sess.postesDg().allObjects();
		NSMutableArray lesPostes = new NSMutableArray();
		EOPosterh post0 = null;
		if (postes.count() > 0) {
			for (int j = 0; j < postes.count(); j++) {
				post0 = (EOPosterh) postes.objectAtIndex(j);
				if (tmpDg.contains(post0)) {
					post0.setToProjet(sess.leProjetEnCours());
					lesPostes.addObject(post0);
					tmpDg.remove(post0);
				} else {
					EOPosterh recru = new EOPosterh();
					recru = (EOPosterh) tmpDg.objectAtIndex(j);
					recru.setToProjet(sess.leProjetEnCours());
					lesPostes.addObject(recru);
					tmpDg.remove(j);
				}
			}
		}

		if (tmpDg.count() > 0) {
			for (int i = 0; tmpDg.count() > i; i++) {
				EOPosterh recru = new EOPosterh();
				recru = (EOPosterh) tmpDg.objectAtIndex(i);
				recru.setToProjet(sess.leProjetEnCours());
				lesPostes.addObject(recru);
			}
		}
		return lesPostes.mutableClone();
	}

	@Override
	public void traitementPoste(NSArray postes, CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		if (postes != null && postes.count() > 0) {
			for (int j = 0; postes.count() > j; j++) {
				EOPosterh poste = (EOPosterh) postes.objectAtIndex(j);
				try {
					ProcessPoste.enregistrer(sess.dataBus(), component.edc(), poste);
					sess.setAlertMessage(null);
				} catch (FactoryException e) {
					String alertMessage = e.getMessageFormatte();
					if (e.isBloquant()) {
						if (e.isInformatif()) {
							// Exception contenant un message d'information pour
							// l'utilisateur
							sess.setAlertMessage(alertMessage);
						} else {
							e.printStackTrace();
							throw e;
						}
					} else {
						sess.setAlertMessage(alertMessage);
					}

				} catch (Exception e1) {
					sess.setAlertMessage(e1.getMessage());
					e1.printStackTrace();
				}

			}
		}
	}

}
