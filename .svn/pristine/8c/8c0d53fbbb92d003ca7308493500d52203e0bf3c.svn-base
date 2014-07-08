/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EORefidx;
import utt.rec.projet.server.metier.admrec._EOMotclefs;
import utt.rec.projet.server.process.ProcessMotClefs;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryTraitementMotClefs extends Factory {

	public FactoryTraitementMotClefs() {
		// TODO Auto-generated constructor stub
		super();
	}

	//Construction de la liste des mots clefs ˆ traiter
	@Override
	public NSMutableArray<EOMotclefs> Keywords(CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		NSArray tmp1 = sess.getMotClefList();
		NSArray tmp2 = sess.leProjetEnCours().toMotCles(EOMotclefs.TEMVALIDE.eq("O"));
		NSMutableArray keywordList = new NSMutableArray();
		if (tmp2 != null && tmp2.count() != 0) {
			for (int i = 0; i < tmp2.count(); i++) {
				EORefidx idx = new EORefidx();
				EOMotclefs mcl = (EOMotclefs) tmp2.objectAtIndex(i);
				idx = mcl.toRefidx();
				if (tmp1.contains(idx)) {
					keywordList.add(mcl);
					tmp1.remove(idx);
				} else {
					tmp2.remove(mcl);
				}
			}
		}
		if (tmp1 != null && tmp1.count() != 0) {
			for (int j = 0; j < tmp1.count(); j++) {
				EOMotclefs keyword = new EOMotclefs();
				EORefidx idx = new EORefidx();
				idx = (EORefidx) tmp1.objectAtIndex(j);
				EOMotclefs moc = EOMotclefs.fetchEOMotclefs(
						component.edc(),
						EOMotclefs.REFIDX_ID.eq(
								Integer.valueOf(idx.primaryKey())).and(
								EOMotclefs.TEMVALIDE.eq("N")));
				if (moc != null) {
					moc.setToProjet(sess.leProjetEnCours());
					moc.setTemvalide("O");
					keywordList.add(moc);
				} else {
					EOMotclefs moc1 = EOMotclefs.fetchEOMotclefs(
							component.edc(),
							EOMotclefs.REFIDX_ID
									.eq(Integer.valueOf(idx.primaryKey()))
									.and(EOMotclefs.TEMVALIDE.eq("O"))
									.and(EOMotclefs.PROJET_ID.eq((Integer)sess.leProjetEnCours()
													.getProjIdProc())));
					if (moc1 != null) {
						keywordList.add(moc1);
					} else {
						keyword = EOMotclefs.createEOMotclefs(component.edc());
						keyword.setToProjet(sess.leProjetEnCours());
						keyword.setToRefidx(idx);
						keyword.setTemvalide("O");
						keywordList.add(keyword);
					}
				}
			}

		}
		return keywordList.mutableClone();
	}

	//Traitement enregistrement des mot clefs en base
	@Override
	public void traitementMotClefs(NSArray keywords,
			CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		if (keywords != null && keywords.count() != 0) {
			for (int i = 0; i < keywords.count(); i++) {
				EOMotclefs keyword = (EOMotclefs) keywords.objectAtIndex(i);
				try {
					ProcessMotClefs.enregistrer(sess.dataBus(),
							component.edc(), keyword);
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
					;
				}
			}
		}
	}

}
