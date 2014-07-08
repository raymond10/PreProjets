/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.process.ProcessEquipes;
import utt.rec.projet.server.process.ProcessRepartAxe;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryTraitementRepartPst extends Factory {

	public FactoryTraitementRepartPst() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public NSMutableArray<EORepartaxe> pstEncCours(CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		EOEditingContext edc = component.edc();
		NSMutableArray tmp = new NSMutableArray();
		NSArray stmrDg = sess.lesSTMR().allObjects();
		NSArray pretarList = sess.leProjetEnCours().toProjetRepartaxes(EORepartaxe.TEMVALIDE.eq("O"));
		if (pretarList.count() != 0) {
			for (int k = 0; k < pretarList.count(); k++) {
				EORepartaxe axe0 = (EORepartaxe) pretarList.objectAtIndex(k);
				if (stmrDg.contains(axe0.toAxe())) {
					axe0.setMajcreate(new NSTimestamp());
					axe0.setTemvalide("O");
					axe0.setToProjetRelationship(sess.leProjetEnCours());
					tmp.addObject(axe0);
					stmrDg.remove(axe0.toAxe());
				}
			}
		}
		if (stmrDg.count() != 0) {
			for (int i = 0; i < stmrDg.count(); i++) {
				EOAxerec axe = new EOAxerec();
				axe = (EOAxerec) stmrDg.objectAtIndex(i);
				EORepartaxe repartPst = new EORepartaxe();
				repartPst = EORepartaxe.createEORepartaxe(edc);
				repartPst.setMajcreate(new NSTimestamp());
				repartPst.setTemvalide("O");
				repartPst.setToAxeRelationship(axe);
				repartPst.setToProjetRelationship(sess.leProjetEnCours());
				tmp.addObject(repartPst);
			}
		}
		return tmp.mutableClone();
	}

	@Override
	public void traitementPst(NSArray pst, CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		if(pst != null && pst.count() != 0){
			for(int l=0; l < pst.count(); l++){
				EORepartaxe pst0 = (EORepartaxe) pst.objectAtIndex(l);
				try {
					ProcessRepartAxe.enregistrer(sess.dataBus(), component.edc(), pst0);
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
