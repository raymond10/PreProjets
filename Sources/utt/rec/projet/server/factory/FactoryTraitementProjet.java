/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.exception.ProjetException;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class FactoryTraitementProjet extends Factory {

	private FactoryTraitementPartenaires trtPartenaire = new FactoryTraitementPartenaires();
	private String title;

	public FactoryTraitementProjet() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @return the trtPartenaire
	 */
	public FactoryTraitementPartenaires getTrtPartenaire() {
		return trtPartenaire;
	}

	/**
	 * @param trtPartenaire
	 *            the trtPartenaire to set
	 */
	public void setTrtPartenaire(FactoryTraitementPartenaires trtPartenaire) {
		this.trtPartenaire = trtPartenaire;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	// Traitement Page 1
	@Override
	public EOPprec projetEnCours(EOPprec projet, CktlAjaxWOComponent component)
			throws ProjetException {
		// TODO Auto-generated method stub
		Session sess = (Session) component.session();
		EOEditingContext edc = component.edc();
		if (projet == null) {
			projet = EOPprec.createEOPprec(edc);
			projet.setCreadate(new NSTimestamp());
		} else {
			projet.setCreadate(projet.creadate());
		}
		// Traitement Page 1
		if (sess.getSourceFinance() != null) {
			projet.setSrcefinance(sess.getSourceFinance().toUpperCase());
		} else {
			projet.setSrcefinance(null);
		}
		projet.setProjnomcourt(sess.getNomCourt().toUpperCase());
		projet.setProjnomlong(sess.getNomLong().toUpperCase());
		if (sess.porteur() == null) {
			title = "Identité du projet";
			throw new FactoryException(
					"il faut selectionner le porteur du projet");
		}
		//EOIndividuUlr inDiv = EOIndividuUlr.individuPourNumero(edc, sess
		//		.porteur().noIndividu());
		projet.setPorteur(sess.porteur().noIndividu());
		projet.setEtabPorteur(sess.getEtabPorteur());
		projet.setProjduree(sess.getDureeProjet());
		projet.setProjdatdebut(sess.getDateDebut());
		if (sess.getStContratSelected() != null) {
			projet.setToContrat(sess.getStContratSelected());
		} else {
			if (sess.contrat() != null)
				projet.setToContrat(sess.contrat());
		}
		if (sess.equipePrincipale() == null) {
			title = " Positionnement du projet dans l'ICD";
			throw new FactoryException(
					"il faut selectionner le programme d'accueil principal du projet");
		}
		projet.setEquipePrincipale(sess.equipePrincipale().cStructure());
		if (sess.pst() == null) {
			if (sess.axe() == null) {
				title = " Positionnement du projet dans l'ICD";
				throw new FactoryException(
						"il faut selectionner l'axe du projet");
			}
			projet.setToAxe(sess.axe());
		}
		if (sess.getSelectThematique() != null) {
			projet.setProjthetv(sess.getSelectThematique());
		} else {
			projet.setProjthetv(null);
		}
		if (sess.getSelectedThematik() != null) {
			projet.setToThematique(sess.getSelectedThematik());
		} else {
			projet.setToThematique(null);
		}
		if (sess.getSelectedTheme() != null) {
			projet.setToTheme(sess.getSelectedTheme());
		} else {
			projet.setToTheme(null);
		}
		if (sess.getSelectedSouTheme() != null) {
			projet.setToSousThemes(sess.getSelectedSouTheme());
		} else {
			projet.setToSousThemes(null);
		}
		projet.setToEtat(sess.getEtatRepetition1());
		if (sess.getContexte() != null) {
			projet.setProjctx(sess.getContexte());
		} else {
			projet.setProjctx(null);
		}
		if (sess.getProblematik() != null) {
			projet.setProjpblm(sess.getProblematik());
		} else {
			projet.setProjpblm(null);
		}
		if (sess.getObjectifs() != null) {
			projet.setProjobf(sess.getObjectifs());
		} else {
			projet.setProjobf(null);
		}
		if (sess.getMetho() != null) {
			projet.setProjmtdg(sess.getMetho());
		} else {
			projet.setProjmtdg(null);
		}
		projet.setMajauteur(sess.getApplicationUser().getNoIndividu()
				.toString());
		projet.setMajdate(new NSTimestamp());
		// Fetch le pole
		EOStructureUlr str = EOStructureUlr.structurePourcStructure(edc, sess
				.getInfoPorteurRepetition().cStructure());
		projet.setPoleCompetence(str.cStructure());
		if (str.grpResponsable() != null)
			projet.setDirecteurPole(str.grpResponsable());
		projet.setBlocCom(sess.getBlocCom());
		return projet;
	}

}
