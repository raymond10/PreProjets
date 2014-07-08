/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.process.ProcessPartProjet;
import utt.rec.projet.server.process.ProcessPartenaire;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryTraitementPartenaires extends Factory {

	private Number idPArt;

	public FactoryTraitementPartenaires() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @return the idPArt
	 */
	public Number getIdPArt() {
		return idPArt;
	}

	/**
	 * @param idPArt
	 *            the idPArt to set
	 */
	public void setIdPArt(Number idPArt) {
		this.idPArt = idPArt;
	}

	@Override
	public NSMutableArray<EOPartenaireProjet> partProj(
			CktlAjaxWOComponent component) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		EOPartenaireProjet pat0 = null;
		EOTyppartenaire pateu0 = null;
		EOEditingContext edc = sess.editingContext();
		NSMutableArray partporj = new NSMutableArray();
		NSArray listPartProjet = sess.leProjetEnCours().toProjetPartenaires(
				EOPartenaireProjet.TEMVALIDE.eq("O"), true);
		NSArray tmpDg = new NSArray();
		if (sess.partenaireDg() != null)
			tmpDg = sess.partenaireDg().allObjects();
		if (listPartProjet.count() > 0) {
			for (int i = 0; i < listPartProjet.count(); i++) {
				pat0 = new EOPartenaireProjet();
				pat0 = (EOPartenaireProjet) listPartProjet.objectAtIndex(i);
				pateu0 = new EOTyppartenaire();
				pateu0 = pat0.toPartenaire();
				if (tmpDg.contains(pateu0)) {
					pat0.setToProjet(sess.leProjetEnCours());
					pat0.setToPartenaire(pateu0);
					partporj.addObject(pat0);
					tmpDg.remove(pateu0);
				} else {
					EOTyppartenaire pateu1 = new EOTyppartenaire();
					pateu1 = (EOTyppartenaire) tmpDg.objectAtIndex(i);
					EOPartenaireProjet prop = EOPartenaireProjet
							.fetchEOPartenaireProjet(
									edc,
									EOPartenaireProjet.TO_PARTENAIRE.eq(pateu1)
											.and(EOPartenaireProjet.TEMVALIDE
													.eq("N")));
					if (prop != null) {
						prop.setToProjet(sess.leProjetEnCours());
						prop.setTemvalide("O");
						partporj.addObject(prop);
					} else {
						pat0.setToProjet(sess.leProjetEnCours());
						pat0.setToPartenaire(pateu1);
						pat0.setTemvalide("O");
						partporj.addObject(pat0);
					}
				}
			}
		}

		if (tmpDg != null && tmpDg.count() > 0) {
			for (int j = 0; tmpDg.count() > j; j++) {
				EOPartenaireProjet pj = new EOPartenaireProjet();
				pj = EOPartenaireProjet.createEOPartenaireProjet(edc);
				EOTyppartenaire typi = new EOTyppartenaire();
				typi = (EOTyppartenaire) tmpDg.objectAtIndex(j);
				EOPartenaireProjet prop = EOPartenaireProjet
						.fetchEOPartenaireProjet(
								edc,
								EOPartenaireProjet.TO_PARTENAIRE.eq(typi).and(
										EOPartenaireProjet.TEMVALIDE.eq("N")));
				if (prop != null) {
					prop.setToProjet(sess.leProjetEnCours());
					prop.setTemvalide("O");
					partporj.addObject(prop);
				} else {
					pj.setToProjet(sess.leProjetEnCours());
					pj.setToPartenaire(typi);
					pj.setTemvalide("O");
					partporj.addObject(pj);
				}
			}
		}
		return partporj.mutableClone();
	}

	@Override
	public void traitementPartProjet(CktlAjaxWOComponent component,
			NSArray partenaires) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		if (partenaires != null && partenaires.count() != 0) {
			for (int i = 0; partenaires.count() > i; i++) {
				EOPartenaireProjet partenaire = (EOPartenaireProjet) partenaires
						.objectAtIndex(i);
				try {
					ProcessPartProjet.enregistrer(sess.dataBus(),
							component.edc(), partenaire);
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

	@Override
	public void newPartnaire(CktlAjaxWOComponent component,
			EOTyppartenaire partenaire) {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		EOTyppartenaire partenaire0 = new EOTyppartenaire();
		if (partenaire == null) {
			partenaire0 = EOTyppartenaire
					.createEOTyppartenaire(component.edc());
			if (sess.getPartAdd() == null) {
				throw new FactoryException(
						"Le libelle du partenaire est obligatoire");
			}
			partenaire0.setNomPartenaire(sess.getPartAdd());
			partenaire0.setPartCleunik("N/A");
		} else {
			partenaire0 = partenaire;
			partenaire0.setNomPartenaire(sess.getPartAdd());
			partenaire0.setPartCleunik(partenaire0.partCleunik());
		}
		partenaire0.validateForSave();
		try {
			ProcessPartenaire.enregistrer(sess.dataBus(), component.edc(),
					partenaire0);
			sess.setAlertMessage(null);
			idPArt = partenaire0.getTypIdProc();
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
		// sess.setPartAdd(null);
	}

}
