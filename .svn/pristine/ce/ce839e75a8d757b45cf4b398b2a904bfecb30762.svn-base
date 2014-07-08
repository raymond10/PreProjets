/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOTypref;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessMateriel;
import backup.Materiels;
import backup.NewMateriel;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryTraitementMateriels extends Factory {

	public FactoryTraitementMateriels() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public NSMutableArray<EOResmat> materielsEncCours(
			CktlAjaxWOComponent component, NSMutableArray materiels,
			EOResmat materiel) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		NSArray tmpDg = sess.poleMaterielsDg().allObjects();
		NSMutableArray lesResMat = new NSMutableArray();
		EOResmat LilMat0 = null;
		EOPfmateriel categorie0 = null;
		EOStructureUlr pole0 = null;
		if (materiels.count() > 0) {
			for (int j = 0; j < materiels.count(); j++) {
				categorie0 = new EOPfmateriel();
				pole0 = new EOStructureUlr();
				LilMat0 = new EOResmat();
				LilMat0 = (EOResmat) materiels.objectAtIndex(j);
				categorie0 = LilMat0.toPlateauTech();
				pole0 = EOStructureUlr.structurePourcStructure(LilMat0.editingContext(), LilMat0.cStructure());
				if (tmpDg.contains(LilMat0)) {
					lesResMat.addObject(LilMat0);
					tmpDg.remove(LilMat0);
				} else {
					EOResmat mat = new EOResmat();
					mat = (EOResmat) tmpDg.objectAtIndex(j);
					mat.setToProjet(sess.leProjetEnCours());
					lesResMat.addObject(mat);
				}
			}
		}

		if (tmpDg.count() > 0) {
			for (int i = 0; tmpDg.count() > i; i++) {
				EOResmat mat = new EOResmat();
				mat = (EOResmat) tmpDg.objectAtIndex(i);
				mat.setToProjet(sess.leProjetEnCours());
				lesResMat.addObject(mat);
			}
		}
		return lesResMat.mutableClone();
	}

	@Override
	public NSMutableArray<EOResmat> newResMatEncCours(
			CktlAjaxWOComponent component, NSMutableArray materiels,
			EOResmat materiel) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		NSArray tmpDg = sess.materielsDg().allObjects();
		NSMutableArray lesNewResMat = new NSMutableArray();
		EOResmat LilMati0 = null;
		EOPfmateriel categorie0 = null;
		EOStructureUlr pole0 = null;
		if (materiels.count() > 0
				&& sess.materielsDg().allObjects().count() == materiels
						.count()) {
			for (int j = 0; j < materiels.count(); j++) {
				LilMati0 = new EOResmat();
				categorie0 = new EOPfmateriel();
				pole0 = new EOStructureUlr();
				LilMati0 = (EOResmat) materiels.objectAtIndex(j);
				if (tmpDg.contains(LilMati0)) {
					lesNewResMat.addObject(LilMati0);
					tmpDg.remove(LilMati0);
				} else {
					EOResmat mat = new EOResmat();
					mat = (EOResmat) tmpDg.objectAtIndex(j);
					mat.setToProjet(sess.leProjetEnCours());
					lesNewResMat.addObject(LilMati0);

				}
			}
		} 
			if (tmpDg.count() > 0) {
				for (int i = 0; tmpDg.count() > i; i++) {
					EOResmat mat = new EOResmat();
					mat = (EOResmat) tmpDg.objectAtIndex(i);
					mat.setToProjet(sess.leProjetEnCours());
					lesNewResMat.addObject(mat);
				}
			}
		return lesNewResMat.mutableClone();
	}

	@Override
	public void traitementMateriel(NSArray materiels,
			CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		if (materiels != null && materiels.count() > 0) {
			for (int k = 0; materiels.count() > k; k++) {
				EOResmat materiel = (EOResmat) materiels.objectAtIndex(k);
				try {
					ProcessMateriel.enregistrer(sess.dataBus(), component.edc(), materiel);
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

				} catch (RuntimeException e1) {
					sess.setAlertMessage(e1.getMessage());
					e1.printStackTrace();
					throw e1;
				}

			}
		}
	}

}
