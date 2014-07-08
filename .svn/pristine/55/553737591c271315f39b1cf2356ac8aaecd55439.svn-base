/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessEquipes;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryTraitemantEquipes extends Factory {

	public FactoryTraitemantEquipes() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public NSMutableArray<EOEquipes> autrePRGAssocie(
			CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		NSMutableArray otherList = new NSMutableArray();
		NSArray tmpDg = new NSArray();
		if (sess.autreEquipeDg() != null)
			tmpDg = sess.autreEquipeDg().allObjects();
		if (sess.leProjetEnCours().equipePrincipale() != null) {
			EOEquipes equipes = EOEquipes.fetchEOEquipes(
					component.edc(),
					EOEquipes.C_STRUCTURE
							.eq(sess.leProjetEnCours().equipePrincipale())
							.and(EOEquipes.TO_PROJET.eq(sess.leProjetEnCours()))
							.and(EOEquipes.TEMVALIDE.eq("O")));
			if (equipes == null) {
				equipes = EOEquipes.createEOEquipes(component.edc());
			}
			equipes.setCStructure(EOStructureUlr.structurePourcStructure(component.edc(), sess.leProjetEnCours().equipePrincipale()).cStructure());
			equipes.setToProjet(sess.leProjetEnCours());
			equipes.setPrincipale("O");
			equipes.setTemvalide("O");
			otherList.addObject(equipes);
		}
		EOEquipes equipe0 = null;
		EOStructureUlr structure0 = null;
		NSArray listSecond = sess.leProjetEnCours().toEquipeSecondaires(
				EOEquipes.PRINCIPALE.eq("N").and(EOEquipes.TEMVALIDE.eq("O")));
		if (listSecond.count() != 0) {
			for (int j = 0; j < listSecond.count(); j++) {
				equipe0 = new EOEquipes();
				equipe0 = (EOEquipes) listSecond.objectAtIndex(j);
				//structure0 = new EOStructureUlr();
				//structure0 = equipe0.rechUnit();
				if (tmpDg.contains(structure0)) {
					//equipe0.setRechUnit(structure0);
					equipe0.setToProjet(sess.leProjetEnCours());
					equipe0.setPrincipale("N");
					equipe0.setTemvalide("O");
					otherList.addObject(equipe0);
					tmpDg.remove(structure0);
				} else {
					listSecond.remove(equipe0);
				}
			}
		}
		if (tmpDg != null && tmpDg.count() != 0) {
			for (int i = 0; tmpDg.count() > i; i++) {
				EOEquipes equipes = new EOEquipes();
				equipes = EOEquipes.createEOEquipes(component.edc());
				EOStructureUlr structure = new EOStructureUlr();
				structure = (EOStructureUlr) tmpDg.objectAtIndex(i);
				EOEquipes okp = EOEquipes.fetchEOEquipes(
						component.edc(),
						EOEquipes.C_STRUCTURE.eq(structure.cStructure()).and(
								EOEquipes.TEMVALIDE.eq("N")));
				if (okp != null) {
					okp.setToProjet(sess.leProjetEnCours());
					okp.setTemvalide("O");
					okp.setPrincipale("N");
					otherList.addObject(okp);
				} else {
					equipes.setCStructure(structure.cStructure());
					equipes.setToProjet(sess.leProjetEnCours());
					equipes.setPrincipale("N");
					equipes.setTemvalide("O");
					otherList.addObject(equipes);
				}
			}
		}
		return otherList.mutableClone();
	}

	// traitement liste des autres equipes projets
	@Override
	public void traitementAutrePRGAssocie(NSArray equipes,
			CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		if (equipes != null && equipes.count() > 0) {
			for (int i = 0; equipes.count() > i; i++) {
				EOEquipes equipe = (EOEquipes) equipes.objectAtIndex(i);
				try {
					ProcessEquipes.enregistrer(sess.dataBus(), component.edc(),
							equipe);
					sess.setAlertMessage(null);
				} catch (FactoryException e) {
					String alertMessage = e.getMessageFormatte();
					if (e.isBloquant()) {
						if (e.isInformatif()) {
							// Exception contenant un message d'information pour
							// l'utilisateur
							sess.setAlertMessage(alertMessage);
							return;
						} else {
							e.printStackTrace();
							throw e;
						}
					} else {
						sess.setAlertMessage(alertMessage);
						return;
					}

				} catch (Exception e1) {
					sess.setAlertMessage(e1.getMessage());
					e1.printStackTrace();
				}
			}
		}
	}
}
