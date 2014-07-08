/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;
import org.cocktail.fwkcktlpersonne.common.metier.EOStructure;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.appserver.ERXDisplayGroup;

import utt.rec.projet.server.PPrecApplicationUser;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EORefthe;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.grhum.EOPersonne;
import utt.rec.projet.server.metier.grhum.EORepartAssociation;
import utt.rec.projet.server.metier.grhum.EORepartStructure;
import utt.rec.projet.server.metier.grhum.EORepartTypeGroupe;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryDataArray extends Factory {

	private CktlAjaxWOComponent component;
	private Session session;
	private NSMutableArray<EOStructureUlr> equipeOther;
	private NSMutableArray<EOTyppartenaire> newPartListe;
	EOEditingContext ed = null;

	public FactoryDataArray() {
		// TODO Auto-generated constructor stub
		session = new Session();
		ed = facEdc();
	}

	public FactoryDataArray(CktlAjaxWOComponent comp, Session sess,
			NSMutableArray<EOStructureUlr> eqp,
			NSMutableArray<EOTyppartenaire> newP) {
		// TODO Auto-generated constructor stub
		component = comp;
		session = sess;
		equipeOther = eqp;
		newPartListe = newP;
		ed = facEdc();
	}

	/**
	 * @return the component
	 */
	public CktlAjaxWOComponent getComponent() {
		return component;
	}

	/**
	 * @param component
	 *            the component to set
	 */
	public void setComponent(CktlAjaxWOComponent component) {
		this.component = component;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * @return the equipeOther
	 */
	public NSMutableArray<EOStructureUlr> getEquipeOther() {
		return equipeOther;
	}

	/**
	 * @param equipeOther
	 *            the equipeOther to set
	 */
	public void setEquipeOther(NSMutableArray<EOStructureUlr> equipeOther) {
		this.equipeOther = equipeOther;
	}

	/**
	 * @return the newPartListe
	 */
	public NSMutableArray<EOTyppartenaire> getNewPartListe() {
		return newPartListe;
	}

	/**
	 * @param newPartListe
	 *            the newPartListe to set
	 */
	public void setNewPartListe(NSMutableArray<EOTyppartenaire> newPartListe) {
		this.newPartListe = newPartListe;
	}

	// Traitement d'informations liées aux tableaux de données
	// lors de la création et de la modification d'un projet
	public WOActionResults getHasThematique() {
		if (session.getSelectThematique() == null) {
			session.setHaveThmtk(false);
			return null;
		} else if (session.getSelectThematique().equals("O")) {
			//EOStructure str = user.umrStmr();
			session.setHaveThmtk(true);
			session.setHasYesChecked(true);
			//session.setAxeStmrList(EOAxerec.fetchEquipeAxes(ed, str.primaryKey()));
			return null;
		}
		session.setHaveThmtk(false);
		session.setHasYesChecked(false);
		return component.doNothing();
	}

	// Sélection d'une autre équipe de recherche
	public WOActionResults onChange() {
		if (session.autreEquipeDg() == null) {
			session.setAutreEquipeDg(new ERXDisplayGroup<EOStructureUlr>());
		} else {
			equipeOther = session.autreEquipeDg().allObjects()
					.mutableClone();
		}
		if (session.selectedEquipeSecondaire() != null) {
			if (session.getProjectSelected() != null) {
				EOEquipes okp = EOEquipes.fetchEOEquipes(
						ed,
						EOEquipes.C_STRUCTURE
								.eq(session.selectedEquipeSecondaire().cStructure())
								.and(EOEquipes.TO_PROJET.eq(session
										.getProjectSelected()))
								.and(EOEquipes.TEMVALIDE.eq("N")));
				if (okp != null) {
					okp.setTemvalide("O");
					okp.editingContext().saveChanges();
				}
			}
			if (session.selectedEquipeSecondaire().lcStructure() != null
					&& !equipeOther.contains(session.selectedEquipeSecondaire())) {
				equipeOther.add(session.selectedEquipeSecondaire());
			}
			if (equipeOther.count() != 0) {
				session.setHasOtherSelection(true);
			} else {
				session.setHasOtherSelection(false);
			}
			session.setOtherList(equipeOther);
			session.autreEquipeDg().setObjectArray(equipeOther);
		}
		return component.doNothing();
	}

	// Sélection d'un partenaire
	public WOActionResults onPart() {
		if (session.partenaireDg() == null) {
			session.setPartenaireDg(new ERXDisplayGroup<EOTyppartenaire>());
		} else {
			newPartListe = session.partenaireDg().allObjects()
					.mutableClone();
		}
		if (session.partenaire() != null) {
			if (session.getProjectSelected() != null) {
				EOPartenaireProjet prop = EOPartenaireProjet
						.fetchEOPartenaireProjet(
								ed,
								EOPartenaireProjet.TO_PARTENAIRE
										.eq(session.partenaire())
										.and(EOPartenaireProjet.TO_PROJET
												.eq(session
														.getProjectSelected()))
										.and(EOPartenaireProjet.TEMVALIDE
												.eq("N")));
				if (prop != null) {
					prop.setTemvalide("O");
					prop.editingContext().saveChanges();
				}
			}
			if (session.partenaire().nomPartenaire() != null
					&& !newPartListe.contains(session.partenaire())) {
				newPartListe.addObject(session.partenaire());
			}
			session.setNewPartList(newPartListe.mutableClone());
			session.partenaireDg().setObjectArray(newPartListe);
		}
		return component.doNothing();
	}

	// Màj de la liste des autres équipes recherche
	public WOActionResults upDateOtherEqp() {
		if (session.equipePrincipale() != null) {
			NSArray<EOStructureUlr> listEqp = session.getEquipeList();
			NSMutableArray<EOStructureUlr> eqpList = new NSMutableArray<EOStructureUlr>();
			for (int i = 0; i < listEqp.count(); i++) {
				if (session.equipePrincipale().lcStructure() != null
						&& listEqp.objectAtIndex(i).lcStructure() != session
								.equipePrincipale().lcStructure()) {
					eqpList.add(listEqp.objectAtIndex(i));
				}
			}
			session.setEquipeSecondaireList(eqpList);
		}
		return component.doNothing();
	}

	// Rafraichement de la liste des pôles
	public WOActionResults refreshPole() {
		if (session.porteur() != null) {
			if (session.porteur().nomUsuel() != null) {
				NSMutableArray tmp = new NSMutableArray();
				tmp.addObject(session.porteur());
				session.setListInfoPole(tmp.immutableClone());
			}
		}
		return component.doNothing();
	}

	// Rafraichissement de la liste des Axes
	public WOActionResults upDateAxes() {
		if (session.equipePrincipale() != null) {
			if (session.equipePrincipale().lcStructure() != null) {
				session.setAxeList(EOAxerec.fetchEquipeAxes(ed, session
						.equipePrincipale().primaryKey()));
			} else {
				session.setAxeList(EOAxerec.fetchAllEOAxerecs(ed));
			}
		}
		return component.doNothing();
	}

	// Rafraichissement de la liste des PST
	public WOActionResults upDatePst() {
		if (session.equipePrincipale() != null) {
			if (session.equipePrincipale().lcStructure() != null) {
				session.setPstList(EOAxerec.fetchEquipePst(ed, session
						.equipePrincipale().primaryKey()));
			} else {
				session.setPstList(EOAxerec.fetchAllEOAxerecs(ed));
			}
		}
		return component.doNothing();
	}

	// //Rafraichissement de l'information si le projet est tranverse ou pas
	public WOActionResults upDateTrans() {
		if (session.equipePrincipale() != null) {
			if (session.equipePrincipale().lcStructure() != null
					&& (session.equipePrincipale().lcStructure()
							.equals("STMR"))) {
				session.setHaveSTMR(true);
				session.setHaveNotSTMR(false);
			} else {
				session.setHaveSTMR(false);
				session.setHaveNotSTMR(true);
			}
		}
		return component.doNothing();
	}

	// Rafraichissement de la liste des thèmes
	public WOActionResults upDateTheme() {
		session.setSelectedTheme(null);
		if (session.getSelectedThematik() != null) {
			Integer lg = Integer.valueOf(session.getSelectedThematik()
					.primaryKey());
			session.setThemeList(EORefthe.fetchRefreshTheme(ed, lg));
		}
		return component.doNothing();
	}

	// Rafraichissement de la liste des sous-thèmes
	public WOActionResults upDateSouTheme() {
		if (session.getSelectedTheme() != null) {
			Integer lg = Integer.valueOf(session.getSelectedTheme()
					.primaryKey());
			session.setSouThemeList(EORefthe.fetchRefreshSousTheme(ed, lg));
		} else {
			session.setSouThemeList(EORefthe.fetchSousThemeList(ed));
		}
		return component.doNothing();
	}

	// Rafraichissement de la liste des contrats
	public WOActionResults upDateStContrat() {
		if (session.contrat() != null) {
			Integer pk = Integer.valueOf(session.contrat()
					.primaryKey());
			session.setStContratList(EOTypcontrat.fetchLesStContrats(ed, pk));
		} else {
			session.setStContratList(null);
		}
		return component.doNothing();
	}

}
