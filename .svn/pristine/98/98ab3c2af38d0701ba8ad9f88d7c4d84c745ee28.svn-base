/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessPersonnel;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryTraitementPersonnel extends Factory {
	
	boolean personnelEnModification = false;

	public FactoryTraitementPersonnel() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public NSMutableArray<EOPersonnel> personnelsEncCours(
			CktlAjaxWOComponent component, NSMutableArray personnels,
			EOPersonnel personnel) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		NSArray tmpDg = sess.personneDg().allObjects();
		NSMutableArray lesRh = new NSMutableArray();
		EOStructureUlr pole0 = null;
		EOIndividuUlr individu0 = null;
		EOPersonnel personne0 = null;
		if (personnels.count() > 0) {
			for (int j = 0; j < personnels.count(); j++) {
				personne0 = new EOPersonnel();
				personne0 = (EOPersonnel) personnels.objectAtIndex(j);
				if (tmpDg.contains(personne0)) {
					lesRh.addObject(personne0);
					tmpDg.remove(personne0);
				} else {
					EOPersonnel rh = new EOPersonnel();
					rh = (EOPersonnel) tmpDg.objectAtIndex(j);
					personne0.setNoIndividu(rh.noIndividu());
					personne0.setNomPersonnel(rh.toVrhcmval().nomUsuel());
					personne0.setCStructure(rh.cStructure());
					personne0.setNomStructure(rh.toVrhcmval().pole());
					personne0.setToProjet(sess.leProjetEnCours());
					personne0.setTempsuitl(rh.tempsuitl());
					personne0.setCoutestime(rh.coutestime());
					personne0.setTemvalide("O");
					lesRh.addObject(personne0);
				}
			}
		} 
			if (tmpDg != null && tmpDg.count() > 0) {
				for (int i = 0; tmpDg.count() > i; i++) {
					EOPersonnel rh = null;
					rh = (EOPersonnel) tmpDg.objectAtIndex(i);
					if (EOUtilities.primaryKeyForObject(component.edc(), rh) != null)
						personnelEnModification = true;
					if(!personnelEnModification){
						rh.setToProjet(sess.leProjetEnCours());
						lesRh.addObject(rh);
					} else {
						rh.setToProjet(sess.leProjetEnCours());
						lesRh.addObject(rh);
					}
				}
			}
			
		return lesRh.mutableClone();
	}

	@Override
	public void traitementPersonnel(NSArray personnels,
			CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		if (personnels != null && personnels.count() > 0) {
			for (int i = 0; personnels.count() > i; i++) {
				EOPersonnel personnel = (EOPersonnel) personnels
						.objectAtIndex(i);
				try {
					ProcessPersonnel
							.enregistrer(sess.dataBus(), component.edc(), personnel);
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
