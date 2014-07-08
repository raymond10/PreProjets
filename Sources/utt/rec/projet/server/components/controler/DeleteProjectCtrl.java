/**
 * 
 */
package utt.rec.projet.server.components.controler;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.DeleteProject;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORefidx;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessProjet;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import er.ajax.AjaxUpdateContainer;
import er.extensions.appserver.ERXRedirect;
import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class DeleteProjectCtrl extends ModuleCtrl<DeleteProject> {

	public EOEditingContext edc;
	private Session sess;
	private EOPprec projet = null;
	private EOStructureUlr poleCompetence;
	private EOPartenaireProjet partenaireProjet;
	private NSArray<EOTyppartenaire> partenaires;
	private EOTyppartenaire lePartenaire;
	private EOEquipes otherEkip;
	private NSArray<EOEquipes> otherList;
	private NSArray<EORefidx> motClesList;
	private NSArray<EOAxerec> repartAxeList;
	private EOAxerec axe;
	private EOAxerec ppst;
	private EOAxerec ppstStmr;
	private EOTypcontrat contrat;

	/**
	 * @param component
	 */
	public DeleteProjectCtrl(DeleteProject component) {
		super(component);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the sess
	 */
	public Session sess() {
		if (sess == null)
			sess = wocomponent().mySession();
		return sess;
	}

	/**
	 * @param sess
	 *            the sess to set
	 */
	public void setSess(Session sess) {
		this.sess = sess;
	}

	/**
	 * @return the edc
	 */
	public EOEditingContext edc() {
		if (edc == null)
			edc = wocomponent().edc();
		return edc;
	}

	/**
	 * @param edc
	 *            the edc to set
	 */
	public void setEdc(EOEditingContext edc) {
		this.edc = edc;
	}

	/**
	 * @return the projet
	 */
	public EOPprec projet() {
		if (projet == null)
			projet = wocomponent().myProjet();
		return projet;
	}

	/**
	 * @param projet
	 *            the projet to set
	 */
	public void setProjet(EOPprec projet) {
		this.projet = projet;
	}

	/**
	 * @return the poleCompetence
	 */
	public EOStructureUlr getPoleCompetence() {
		return poleCompetence;
	}

	/**
	 * @param poleCompetence
	 *            the poleCompetence to set
	 */
	public void setPoleCompetence(EOStructureUlr poleCompetence) {
		this.poleCompetence = poleCompetence;
	}

	/**
	 * @return the partenaire
	 */
	public EOPartenaireProjet getPartenaire() {
		return partenaireProjet;
	}

	/**
	 * @param partenaire
	 *            the partenaire to set
	 */
	public void setPartenaire(EOPartenaireProjet partenaire) {
		this.partenaireProjet = partenaire;
	}

	/**
	 * @return the lePartenaire
	 */
	public EOTyppartenaire getLePartenaire() {
		return lePartenaire;
	}

	/**
	 * @param lePartenaire
	 *            the lePartenaire to set
	 */
	public void setLePartenaire(EOTyppartenaire lePartenaire) {
		this.lePartenaire = lePartenaire;
	}

	/**
	 * @return the partenaires
	 */
	public NSArray<EOTyppartenaire> partenaires() {
		if (partenaires == null)
			partenaires = sess().selectedPartenaires().immutableClone();
		return partenaires;
	}

	/**
	 * @param partenaires
	 *            the partenaires to set
	 */
	public void setPartenaires(NSArray<EOTyppartenaire> partenaires) {
		this.partenaires = partenaires;
	}

	/**
	 * @return the otherEkip
	 */
	public EOEquipes getOtherEkip() {
		return otherEkip;
	}

	/**
	 * @param otherEkip
	 *            the otherEkip to set
	 */
	public void setOtherEkip(EOEquipes otherEkip) {
		this.otherEkip = otherEkip;
	}

	public String libelleStructure() {
		EOStructureUlr str = EOStructureUlr.structurePourcStructure(edc(),
				getOtherEkip().cStructure());
		return str.lcStructure();
	}

	/**
	 * @return the otherList
	 */
	public NSArray<EOEquipes> otherList() {
		if (otherList == null)
			otherList = EOStructureUlr.C_STRUCTURE.isNot(
					projet().equipePrincipale())
					.filtered(sess().repartEquipe());
		return otherList;
	}

	/**
	 * @param otherList
	 *            the otherList to set
	 */
	public void setOtherList(NSArray<EOEquipes> otherList) {
		this.otherList = otherList;
	}

	/**
	 * @return the repartAxeList
	 */
	public NSArray<EOAxerec> getRepartAxeList() {
		return repartAxeList;
	}

	/**
	 * @param repartAxeList
	 *            the repartAxeList to set
	 */
	public void setRepartAxeList(NSArray<EOAxerec> repartAxeList) {
		this.repartAxeList = repartAxeList;
	}

	/**
	 * @return the motCleList
	 */
	public NSArray<EORefidx> motCleList() {
		if (motClesList == null)
			motClesList = wocomponent().myKeywordList().immutableClone();
		return motClesList;
	}

	/**
	 * @param motCleList
	 *            the motCleList to set
	 */
	public void setMotCleList(NSArray<EORefidx> motClesList) {
		this.motClesList = motClesList;
	}

	/**
	 * @return the axe
	 */
	public EOAxerec getAxe() {
		return axe;
	}

	/**
	 * @param axe
	 *            the axe to set
	 */
	public void setAxe(EOAxerec axe) {
		this.axe = axe;
	}

	/**
	 * @return the ppst
	 */
	public EOAxerec getPpst() {
		return ppst;
	}

	/**
	 * @param ppst
	 *            the ppst to set
	 */
	public void setPpst(EOAxerec ppst) {
		this.ppst = ppst;
	}

	/**
	 * @return the contrat
	 */
	public EOTypcontrat contrat() {
		return contrat;
	}

	/**
	 * @param contrat
	 *            the contrat to set
	 */
	public void setContrat(EOTypcontrat contrat) {
		this.contrat = contrat;
	}

	/**
	 * @return the ppstStmr
	 */
	public EOAxerec ppstStmr() {
		return ppstStmr;
	}

	/**
	 * @param ppstStmr
	 *            the ppstStmr to set
	 */
	public void setPpstStmr(EOAxerec ppstStmr) {
		this.ppstStmr = ppstStmr;
	}

	public void sTMR(NSArray<EOAxerec> pst) {
		if (projet().projthetv().equals("O")) {
			NSArray lst = EORepartaxe.fetchAxeThematique(edc(), wocomponent()
					.umrStmr().cStructure(), Integer.valueOf(projet()
					.primaryKey()));
			if (lst.count() != 0)
				ppstStmr = ((EORepartaxe) lst.lastObject()).toAxe();
		} else {
			if (pst != null && pst.count() != 0) {
				repartAxeList = pst;
				for (int i = 0; i < pst.count(); i++) {
					EOAxerec axe0 = null;
					axe0 = pst.objectAtIndex(i);
					if (axe0.isPst()) {
						ppst = axe0;
					}
					if (axe0.isAxe()) {
						axe = axe0;
					}
				}
			}
		}
	}

	// Affichage des mots cles du projet
	public void lesMotCles() {
		NSArray<EOMotclefs> motCleList = new NSArray<EOMotclefs>();
		NSMutableArray tmp = new NSMutableArray();
		motCleList = EOMotclefs.fetchMotClefsProjet(edc(),
				Integer.valueOf(projet().primaryKey()));
		if (motCleList.count() > 0) {
			for (int i = 0; i < motCleList.count(); i++) {
				tmp.addObject(motCleList.objectAtIndex(i).toRefidx());
			}
			motClesList = tmp.immutableClone();
		}
	}

	public WOActionResults supprimer() {
		EOPprec projet = projet();
		wocomponent().nestedEdc();
		try {
			ProcessProjet.supprimer(sess().dataBus(),
					ERXEC.newEditingContext(), projet);
		} catch (FactoryException e) {
			String alertMessage = e.getMessageFormatte();
			if (e.isBloquant()) {
				if (e.isInformatif()) {
					// Exception contenant un message d'information pour
					// l'utilisateur
					sess().addSimpleErrorMessage(
							"message d'information pour l'utilisateur",
							alertMessage);
				} else {
					e.printStackTrace();
					throw e;
				}
			} else {
				sess().addSimpleErrorMessage("FactoryException ", alertMessage);
			}
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			return null;

		} catch (RuntimeException e1) {
			sess().addSimpleErrorMessage("RuntimeException ", e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			e1.printStackTrace();
			return null;
		}
		sess().addSimpleInfoMessage("Suppression Projet",
				"le projet " + projet.projnomcourt() + " a ŽtŽ supprimŽ");
		wocomponent().context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
				.messageContainerID(), wocomponent().context());
		ERXRedirect redirect = (ERXRedirect) wocomponent().pageWithName(
				ERXRedirect.class.getName());
		sess().myEnv().setObjectForKey(true, "Refresh");
		redirect.setComponent(wocomponent().home());
		return redirect;
	}

}
