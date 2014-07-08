/**
 * 
 */
package utt.rec.projet.server.components.controler;

import org.cocktail.reporting.CktlAbstractReporter;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator.ComparisonException;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestamp;

import er.ajax.AjaxUpdateContainer;
import er.extensions.appserver.ERXRedirect;
import er.extensions.formatters.ERXTimestampFormatter;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.DeleteProject;
import utt.rec.projet.server.components.EditProject;
import utt.rec.projet.server.components.EnseignantsChercheursView;
import utt.rec.projet.server.components.EnseignantsChercheursView.ReporterAjaxProgress;
import utt.rec.projet.server.components.Projects;
import utt.rec.projet.server.components.UpdateProject;
import utt.rec.projet.server.components.work.PrintWorkingCtrl;
import utt.rec.projet.server.metier.ProjectListTampon;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTypref;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.print.EditionsDetailProjets;
import utt.rec.projet.server.print.EditionsEtatProjets;
import utt.rec.projet.server.print.PrintCSV;
import utt.rec.projet.server.utils.ContratProjetCoissantComparator;
import utt.rec.projet.server.utils.EquipeProjetCoissantComparator;
import utt.rec.projet.server.utils.EtatProjetCoissantComparator;
import utt.rec.projet.server.utils.NomProjetCoissantComparator;
import utt.rec.projet.server.utils.PorteurProjetCoissantComparator;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 23 sept. 2013
 */

@SuppressWarnings("all")
public class EnseignantsChercheursViewCtrl extends Object {

	private EnseignantsChercheursView wocomponent;
	private EOEditingContext edc;
	private Session sess;
	private NSMutableArray tmpListe;
	public static final Integer DEFAULT_DISPLAY = Integer.valueOf(10);
	// Definition des icones d'action de l'acceuil
	public static final String CONSULT_PICTURE = "newImages/application_form_magnify.png";
	public static final String EDIT_PICTURE = "newImages/application_form_edit.png";
	public static final String DELETE_PICTURE = "newImages/application_form_delete.png";
	public static final String VISA_PICTURE = "newImages/3d_glasses.png";
	public static final String VALIDATE_PICTURE = "newImages/auction_hammer_gavel.png";
	public static final String TRAITE_PICTURE = "image/16x16/001_06_16x16.png";
	public static final String NON_TRAITE_PICTURE = "image/warn.png";
	//
	private EOPprec projet = null;
	private NSArray<EOEquipes> otherList = null;
	// le controleur de l'édition
	private PrintWorkingCtrl printWorkingCtrl;

	public EnseignantsChercheursViewCtrl(EnseignantsChercheursView aWOComponent) {
		wocomponent = aWOComponent;
	}

	/**
	 * @return the wocomponent
	 */
	public EnseignantsChercheursView wocomponent() {
		return wocomponent;
	}

	/**
	 * @param wocomponent
	 *            the wocomponent to set
	 */
	public void setWocomponent(EnseignantsChercheursView wocomponent) {
		this.wocomponent = wocomponent;
	}

	/**
	 * @return the otherList
	 */
	public NSArray<EOEquipes> otherList() {
		if (otherList == null)
			otherList = new NSArray<EOEquipes>();
		return otherList;
	}

	/**
	 * @param otherList
	 *            the otherList to set
	 */
	public void setOtherList(NSArray<EOEquipes> otherList) {
		this.otherList = otherList;
	}

	public void lesNomsProjets(NSArray<ProjectListTampon> projets)
			throws ComparisonException {
		EOPprec unProjet = new EOPprec();
		NSMutableArray projetts = new NSMutableArray();
		if (projets != null) {
			for (ProjectListTampon tmp : projets) {
				unProjet = tmp.getProjet();
				if (!projetts.contains(unProjet))
					projetts.addObject(unProjet);
			}
			projetts.sortUsingComparator(new NomProjetCoissantComparator());
			NSArray result = projetts.immutableClone();
			sess().getFiltreProjet().setObjectArray(result);
			// NSArray ordering = EOPprec.byNomLonCourt();
			// sess().getFiltreProjet().setSortOrderings(ordering);
		} else {
			sess().getFiltreProjet().setObjectArray(new NSArray());
		}
	}

	public void lesEtatsProjets(NSArray<ProjectListTampon> projets)
			throws ComparisonException {
		EOTypref unEtat = new EOTypref();
		NSMutableArray etats = new NSMutableArray();
		if (projets != null) {
			for (int i = 0; i < projets.count(); i++) {
				unEtat = projets.objectAtIndex(i).getEtat();
				if (!etats.contains(unEtat)) {
					etats.addObject(unEtat);
				}
			}
			etats.sortUsingComparator(new EtatProjetCoissantComparator());
			NSArray result = etats.immutableClone();
			sess().getFiltreEtat().setObjectArray(result);
			// NSArray ordering = new NSArray(new Object[]
			// {EOTypref.SORT_NOMETAT_ASC});
			// sess().getFiltreEtat().setSortOrderings(ordering);
		} else {
			sess().getFiltreEtat().setObjectArray(new NSArray());
		}
	}

	public void lesPorteurProjet(NSArray<ProjectListTampon> projets)
			throws ComparisonException {
		EOIndividuUlr unPorteur = new EOIndividuUlr();
		NSMutableArray porteurs = new NSMutableArray();
		if (projets != null) {
			for (int i = 0; i < projets.count(); i++) {
				unPorteur = projets.objectAtIndex(i).getPorteur();
				if (!porteurs.contains(unPorteur)) {
					porteurs.addObject(unPorteur);
				}
			}
			porteurs.sortUsingComparator(new PorteurProjetCoissantComparator());
			NSArray result = porteurs.immutableClone();
			sess().getFiltrePorteur().setObjectArray(result);
			// NSArray ordering = EOIndividuUlr.ByNomPrenom();
			// sess().getFiltrePorteur().setSortOrderings(ordering);
		} else {
			sess().getFiltrePorteur().setObjectArray(new NSArray());
		}
	}

	public void lesContratProjet(NSArray<ProjectListTampon> projets)
			throws ComparisonException {
		EOTypcontrat unContrat = new EOTypcontrat();
		NSMutableArray contrats = new NSMutableArray();
		if (projets != null) {
			for (int i = 0; i < projets.count(); i++) {
				unContrat = projets.objectAtIndex(i).getContrat();
				if (unContrat != null && !contrats.contains(unContrat)) {
					contrats.addObject(unContrat);
				}
			}
			contrats.sortUsingComparator(new ContratProjetCoissantComparator());
			NSArray result = contrats.immutableClone();
			sess().getFiltreContrat().setObjectArray(result);
			// NSArray ordering = new NSArray(new Object[]
			// {EOTypcontrat.SORT_NOMABR_ASC});
			// sess().getFiltreContrat().setSortOrderings(ordering);
		} else {
			sess().getFiltreContrat().setObjectArray(new NSArray());
		}
	}

	public void lesEquipeProjet(NSArray<ProjectListTampon> projets)
			throws ComparisonException {
		EOStructureUlr uneEquipe = new EOStructureUlr();
		NSMutableArray equipes = new NSMutableArray();
		if (projets != null) {
			for (int i = 0; i < projets.count(); i++) {
				uneEquipe = projets.objectAtIndex(i).getEquipe();
				if (!equipes.contains(uneEquipe)) {
					equipes.addObject(uneEquipe);
				}
			}
			equipes.sortUsingComparator(new EquipeProjetCoissantComparator());
			NSArray result = equipes.immutableClone();
			sess().getFiltreEquipe().setObjectArray(result);
			// NSArray ordering = new NSArray(new Object[]
			// {EOStructureUlr.SORT_LC_ASC});
			// sess().getFiltreEquipe().setSortOrderings(ordering);
		} else {
			sess().getFiltreEquipe().setObjectArray(new NSArray());
		}
	}

	/*
	 * bouton editer projet
	 */
	public WOActionResults editerProjet() {
		resetSessionState();
		sess().resetAll();
		EditProject nextPage = (EditProject) wocomponent().pageWithName(
				EditProject.class.getName());
		sess().setIndexModuleActifGestionProjet(null);
		return nextPage;
	}

	/*
	 * bouton modifier projet
	 */
	public WOActionResults modifierProjet() {
		resetSessionState();
		sess().resetAll();
		UpdateProject nextPage = (UpdateProject) wocomponent().pageWithName(
				UpdateProject.class.getName());
		sess().setIndexModuleActifGestionProjet(null);
		return nextPage;
	}

	/*
	 * bouton supprimer projet
	 */
	public WOActionResults supprimerProjet() {
		resetSessionState();
		sess().resetAll();
		DeleteProject nextPage = (DeleteProject) wocomponent().pageWithName(
				DeleteProject.class.getName());
		sess().setIndexModuleActifGestionProjet(null);
		return nextPage;
	}

	private void resetSessionState() {
		sess().setIndexModuleActifGestionProjet(0);
	}

	public void tamponListProject() {
		if (sess().getListProjet().count() > 0) {
			for (int i = 0; sess().getListProjet().count() > i; i++) {
				ProjectListTampon tmpList = new ProjectListTampon();
				EOPprec projet = sess().getListProjet().objectAtIndex(i);
				tmpList.setEtat(projet.toEtat());
				tmpList.setProjet(projet);
				tmpList.setPorteur(EOIndividuUlr.individuPourNumero(edc(),
						projet.porteur()));
				tmpList.setContrat(projet.toContrat());
				tmpList.setEquipe(EOStructureUlr.structurePourcStructure(edc(),
						projet.equipePrincipale()));
				tmpList.setMajdate(projet.majdate());
				tmpList.setConsulter(CONSULT_PICTURE);
				tmpList.setModifier(EDIT_PICTURE);
				tmpList.setSupprimer(DELETE_PICTURE);
				tmpList.setViser(VISA_PICTURE);
				tmpList.setValider(VALIDATE_PICTURE);
				tmpList.setTraiter(TRAITE_PICTURE);
				tmpList.setNonTraiter(NON_TRAITE_PICTURE);
				tmpListe().addObject(tmpList);
			}
			if (tmpListe().count() > 0) {
				sess().setBigListTmp(tmpListe().immutableClone());
			}
		}
		tmpListe = null;
	}

	/**
	 * @return the tmpListe
	 */
	public NSMutableArray tmpListe() {
		if (tmpListe == null)
			tmpListe = new NSMutableArray();
		return tmpListe;
	}

	/**
	 * @param tmpListe
	 *            the tmpListe to set
	 */
	public void setTmpListe(NSMutableArray tmpListe) {
		this.tmpListe = tmpListe;
	}

	// Gestion des droits sur les differentes actions
	/**
	 * Seul les Admins, les dépositaires de projet et ceux qui ont droit à la
	 * consultation peuvent consulter les provent
	 * **/
	public boolean printProjetDisabled() {
		return wocomponent().droitTout()
				|| wocomponent().peutConsultertProjet() || wocomponent().cCCR();
	}

	public boolean printProjetXmlDisabled() {
		Boolean printProjetXml = wocomponent().cCCR();
		return printProjetXml;
	}

	public boolean consulterProjectDisabled() {
		EOPprec projet = projet();
		EOStructureUlr pole = EOStructureUlr.structurePourcStructure(edc(),
				projet.poleCompetence());
		EOStructureUlr principal = EOStructureUlr.structurePourcStructure(
				edc(), projet.equipePrincipale());
		Boolean responsableEquipe = null;
		boolean cellule = wocomponent().cCCR();
		boolean estValide = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_VALIDER);
		// User createur du projet
		boolean monProj = wocomponent().estCreateur(projet);
		// User porteur du projet
		boolean porteur = wocomponent().estPorteur(projet);
		// User implique dans le projet
		boolean implique = wocomponent().estImplique(projet);
		boolean dir = wocomponent().estDrtPole()
				&& (pole.grpResponsable() != null && pole.grpResponsable()
						.equals(wocomponent().noIndividu()));
		// Programme d'accueil principal
		responsableEquipe = wocomponent().estRepPrgAc()
				&& (principal.grpResponsable() != null && principal
						.grpResponsable().equals(wocomponent().noIndividu()));
		if (estValide)
			cellule = wocomponent().cCCR() && !estValide;
		Boolean consulter = ((monProj || dir || porteur || responsableEquipe
				|| implique) && wocomponent().peutConsultertProjet()) || wocomponent().droitTout()
				|| wocomponent().cCCR();
		return consulter;
	}

	public boolean updateProjectDisabled() {
		EOPprec projet = projet();
		boolean monProj = wocomponent().estCreateur(projet);
		// User porteur du projet
		boolean porteur = wocomponent().estPorteur(projet);
		Boolean update = ((monProj || porteur) && wocomponent()
				.peutUpdateProject()) || wocomponent().droitTout();
		boolean estVise = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_VISER);
		boolean estValide = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_VALIDER);
		boolean estRefuse = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_REFUSER);
		boolean estFavorable = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_FAVORABLE);
		boolean estTraite = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_TRAITER);
		if (estVise)
			update = !estVise;
		if (estValide)
			update = !estValide;
		if (estRefuse)
			update = !estRefuse;
		if (estFavorable)
			update = !estFavorable;
		if (estTraite)
			update = !estTraite;
		return update;
	}

	public boolean deleteProjectDisabled() {
		EOPprec projet = projet();
		boolean monProj = wocomponent().estCreateur(projet);
		// User porteur du projet
		boolean porteur = wocomponent().estPorteur(projet);
		Boolean delete = ((monProj || porteur) && wocomponent()
				.peutDeleteProjet()) || wocomponent().droitTout();
		boolean estVise = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_VISER);
		boolean estValide = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_VALIDER);
		boolean estRefuse = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_REFUSER);
		boolean estFavorable = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_FAVORABLE);
		boolean estTraite = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_TRAITER);
		if (estVise)
			delete = !estVise;
		if (estValide)
			delete = !estValide;
		if (estRefuse)
			delete = !estRefuse;
		if (estFavorable)
			delete = estFavorable;
		if (estTraite)
			delete = !estTraite;
		return delete;
	}

	public boolean viserProjectDisabled() {
		EOPprec projet = projet();
		EOStructureUlr pole = EOStructureUlr.structurePourcStructure(edc(),
				projet.poleCompetence());
		EOStructureUlr principal = EOStructureUlr.structurePourcStructure(
				edc(), projet.equipePrincipale());
		/*
		 * autres(projet().equipeSecondaires()); Boolean responsable2ndEquipe =
		 * false;
		 */
		Boolean responsableEquipe = null;
		Boolean directeurPole = null;
		// Programme d'accueil principal
		responsableEquipe = wocomponent().estRepPrgAc()
				&& (principal.grpResponsable() != null && principal
						.grpResponsable().equals(wocomponent().noIndividu()));

		// Directeur de pole du porteur
		directeurPole = wocomponent().estDrtPole()
				&& (pole.grpResponsable() != null && pole.grpResponsable()
						.equals(wocomponent().noIndividu()));

		/**
		 * // Programme d'accueil secondaire if (otherList().count() != 0) { for
		 * (int i = 0; i < otherList().count(); i++) { EOEquipes eqp =
		 * otherList().objectAtIndex(i); EOStructureUlr str =
		 * EOStructureUlr.structurePourcStructure(ERXEC.newEditingContext(),
		 * eqp.cStructure()); if (str.grpResponsable() != null &&
		 * str.grpResponsable().equals(wocomponent().noIndividu())) {
		 * responsable2ndEquipe = wocomponent().estRepPrgAc() &&
		 * str.grpResponsable() .equals(wocomponent().noIndividu()); } } }
		 **/
		Boolean visa = wocomponent().peutViserProjet()
				&& projet.toEtat().typrefnat()
						.equals(EOTypref.VAR_ETAT_SOUMETTRE);
		Boolean viser = (visa && (responsableEquipe || directeurPole))
				|| (wocomponent().droitTout() && projet.toEtat().typrefnat()
						.equals(EOTypref.VAR_ETAT_SOUMETTRE));
		return viser;
	}

	public boolean validerProjectDisabled() {
		EOPprec projet = projet();
		Boolean estVise = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_VISER);
		Boolean valider = (estVise && wocomponent().estMembreIcd() && wocomponent()
				.peutValiderProjet()) || (estVise && wocomponent().droitTout());
		return valider;
	}

	public boolean validerTraiterDisabled() {
		EOPprec projet = projet();
		boolean estTraite = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_TRAITER);
		boolean traiter = wocomponent().cCCR() && estTraite;
		return traiter;
	}

	public boolean validerNonTraiterDisabled() {
		EOPprec projet = projet();
		boolean estValide = projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_VALIDER);
		Boolean traiter = wocomponent().cCCR() && estValide;
		return traiter;
	}

	// // Fin Gestion des droits

	// Zone Action

	public WOActionResults selectConsult() {
		sess().resetAll();
		EditProject editer = null;
		ProjectListTampon edit = new ProjectListTampon();
		wocomponent().projetDg().setSelectedObject(sess().getBigTmpProject());
		wocomponent().setMyProjet(sess().getBigTmpProject().getProjet());
		edit = (ProjectListTampon) wocomponent().projetDg().selectedObject();
		sess().setProjectSelected(edit.getProjet());
		wocomponent().setLeProjetEnCours(edit.getProjet());
		try {
			editer = (EditProject) wocomponent().pageWithName(
					EditProject.class.getName());
			// sess().setProjet(sess().getBigTmpProject().getProjet());
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return editer;
	}

	public WOActionResults selectUpdate() {
		sess().resetAll();
		Projects update = null;
		ProjectListTampon edit = new ProjectListTampon();
		wocomponent().projetDg().setSelectedObject(sess().getBigTmpProject());
		wocomponent().setMyProjet(sess().getBigTmpProject().getProjet());
		edit = (ProjectListTampon) wocomponent().projetDg().selectedObject();
		sess().setProjectSelected(edit.getProjet());
		wocomponent().setLeProjetEnCours(edit.getProjet());
		try {
			wocomponent().setIsUpdate(true);
			update = (Projects) wocomponent().pageWithName(
					Projects.class.getName());
			// sess().setProjet(sess().getBigTmpProject().getProjet());
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return update;
	}

	public WOActionResults selectDelete() {
		sess().resetAll();
		DeleteProject delete = null;
		ProjectListTampon edit = new ProjectListTampon();
		wocomponent().projetDg().setSelectedObject(sess().getBigTmpProject());
		wocomponent().setMyProjet(sess().getBigTmpProject().getProjet());
		edit = (ProjectListTampon) wocomponent().projetDg().selectedObject();
		sess().setProjectSelected(edit.getProjet());
		wocomponent().setLeProjetEnCours(edit.getProjet());
		try {
			delete = (DeleteProject) wocomponent().pageWithName(
					DeleteProject.class.getName());
			// sess().setProjet(sess().getBigTmpProject().getProjet());
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return delete;
	}

	public WOActionResults selectCheck() {
		sess().resetAll();
		EditProject viser = null;
		ProjectListTampon edit = new ProjectListTampon();
		wocomponent().projetDg().setSelectedObject(sess().getBigTmpProject());
		wocomponent().setMyProjet(sess().getBigTmpProject().getProjet());
		edit = (ProjectListTampon) wocomponent().projetDg().selectedObject();
		sess().setProjectSelected(edit.getProjet());
		wocomponent().setLeProjetEnCours(edit.getProjet());
		try {
			viser = (EditProject) wocomponent().pageWithName(
					EditProject.class.getName());
			// sess().setProjet(sess().getBigTmpProject().getProjet());
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return viser;
	}

	public WOActionResults selectValidate() {
		sess().resetAll();
		EditProject valider = null;
		ProjectListTampon edit = new ProjectListTampon();
		wocomponent().projetDg().setSelectedObject(sess().getBigTmpProject());
		wocomponent().setMyProjet(sess().getBigTmpProject().getProjet());
		edit = (ProjectListTampon) wocomponent().projetDg().selectedObject();
		sess().setProjectSelected(edit.getProjet());
		wocomponent().setLeProjetEnCours(edit.getProjet());
		try {
			valider = (EditProject) wocomponent().pageWithName(
					EditProject.class.getName());
			// sess().setProjet(sess().getBigTmpProject().getProjet());
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return valider;
	}

	public WOActionResults selectNotHandle() {
		sess().resetAll();
		EditProject valider = null;
		ProjectListTampon edit = new ProjectListTampon();
		wocomponent().projetDg().setSelectedObject(sess().getBigTmpProject());
		wocomponent().setMyProjet(sess().getBigTmpProject().getProjet());
		edit = (ProjectListTampon) wocomponent().projetDg().selectedObject();
		sess().setProjectSelected(edit.getProjet());
		wocomponent().setLeProjetEnCours(edit.getProjet());
		try {
			valider = (EditProject) wocomponent().pageWithName(
					EditProject.class.getName());
			// sess().setProjet(sess().getBigTmpProject().getProjet());
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return valider;
	}

	// Fin zone Action

	public WOActionResults resetFilters() throws ComparisonException {
		sess().setFiltres(null);
		sess().setFiltreProjetFacade(null);
		wocomponent().allProjects();
		return null;
	}

	public WOActionResults filtrer() throws ComparisonException {
		wocomponent().projetDg().setCurrentBatchIndex(1);
		NSMutableArray result = new NSMutableArray();
		NSMutableArray qualifiers = new NSMutableArray();
		// Filtre Etat
		if (sess().getSelectedState() != null) {
			sess().filtres().takeValueForKey(
					sess().getSelectedState().typrefdom(), "typrefdom");
			sess().filtres().takeValueForKey(
					sess().getSelectedState().typrefnat(), "typrefnat");
			qualifiers.addObject(new EOKeyValueQualifier("etat",
					EOQualifier.QualifierOperatorEqual, sess()
							.getSelectedState()));
			sess().setSelectedState(null);
		}
		// Filtre Projet
		if (sess().getSelectedProjet() != null) {
			Integer pk = Integer.valueOf(sess().getSelectedProjet()
					.primaryKey());
			sess().filtres().takeValueForKey(pk, "projetId");
			qualifiers.addObject(new EOKeyValueQualifier("projet",
					EOQualifier.QualifierOperatorEqual, sess()
							.getSelectedProjet()));
			sess().setSelectedProjet(null);
		}
		// Filtre Porteur
		if (sess().getSelectedPorteur1() != null) {
			sess().filtres().takeValueForKey(
					sess().getSelectedPorteur1().noIndividu(), "porteur");
			qualifiers.addObject(new EOKeyValueQualifier("porteur",
					EOQualifier.QualifierOperatorEqual, sess()
							.getSelectedPorteur1()));
			sess().setSelectedPorteur1(null);
		}
		// Filtre Contrat
		if (sess().getSelectedContrat1() != null) {
			Integer pk = Integer.valueOf(sess().getSelectedContrat1()
					.primaryKey());
			sess().filtres().takeValueForKey(pk, "typcontId");
			qualifiers.addObject(EOTypcontrat.TYPCONT_ID.eq(pk));
			qualifiers.addObject(new EOKeyValueQualifier("contrat",
					EOQualifier.QualifierOperatorEqual, sess()
							.getSelectedPorteur1()));
			sess().setSelectedContrat1(null);
		}
		// Filtre Equipe
		if (sess().getSelectedRechUnit1() != null) {
			sess().filtres().takeValueForKey(
					sess().getSelectedRechUnit1().cStructure(),
					"equipePrincipale");
			qualifiers.addObject(new EOKeyValueQualifier("equipe",
					EOQualifier.QualifierOperatorEqual, sess()
							.getSelectedRechUnit1()));
			sess().setSelectedRechUnit1(null);
		}
		EOAndQualifier andQual = new EOAndQualifier(qualifiers);
		wocomponent().projetDg().setQualifier(andQual);
		wocomponent().projetDg().updateDisplayedObjects();
		sess().getFiltreProjetFacade().setObjectArray(
				wocomponent().projetDg().displayedObjects());
		/*
		 * sess().setListProjet(EOPprec.filtreProjetEC(edc(),
		 * sess().filtres())); tamponListProject(); if (sess().getBigListTmp()
		 * != null) {
		 * wocomponent().projetDg().setObjectArray(sess().getBigListTmp());
		 * wocomponent().projetDg()
		 * .setNumberOfObjectsPerBatch(DEFAULT_DISPLAY); NSArray ordering = new
		 * NSArray( new Object[] { EOPprec.SORT_DATEMAJ_DESC });
		 * wocomponent().projetDg().setSortOrderings(ordering);
		 * wocomponent().projetDg().qualifyDisplayGroup(); }
		 */
		wocomponent().comboxFilter();
		return wocomponent().doNothing();
	}

	public boolean isExportCSVDisabled() {
		return wocomponent().projetDg().allObjects().count() == 0;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isAfficherLnkTelechargerFichierCsv() {
		boolean isAfficher = false;
		if (getPrintWorkingCtrl() != null
				&& getPrintWorkingCtrl().isTravailTermine()) {
			isAfficher = true;
		}

		return isAfficher;
	}

	// export CVS
	public WOActionResults printCsv() {
		// NSMutableDictionary<String, Object> sess().filtres() = new
		// NSMutableDictionary<String, Object>();
		/*
		 * if (sess().getSelectedRechUnit1() != null) {
		 * sess().filtres().takeValueForKey(
		 * sess().getSelectedRechUnit1().primaryKey(), "equipePrincipale");
		 * sess().setSelectedRechUnit1(null); } if (sess().getSelectedPorteur1()
		 * != null) { sess().filtres().takeValueForKey(
		 * Long.valueOf(sess().getSelectedPorteur1().primaryKey()), "porteur");
		 * sess().setSelectedPorteur1(null); } if (sess().getSelectedProjet() !=
		 * null) { sess().filtres().takeValueForKey(
		 * Long.valueOf(sess().getSelectedProjet().primaryKey()), "projetId");
		 * sess().setSelectedProjet(null); } if (sess().getSelectedContrat1() !=
		 * null) {
		 * sess().filtres().takeValueForKey(sess().getSelectedContrat1().
		 * primaryKey(), "cStcont"); sess().setSelectedContrat1(null); } if
		 * (sess().getSelectedState() != null) {
		 * sess().filtres().takeValueForKey
		 * (sess().getSelectedState().typrefdom(), "typrefdom");
		 * sess().filtres()
		 * .takeValueForKey(sess().getSelectedState().typrefnat(), "typrefnat");
		 * sess().setSelectedState(null); }
		 */
		/*
		 * PrintWorking nextPage = (PrintWorking)
		 * wocomponent.pageWithName(PrintWorking.class.getName()); if
		 * (!nextPage.isWorking()) { setPrintWorkingCtrl(new
		 * PrintWorkingCtrl(filtres,wocomponent));
		 * nextPage.setCtrl(getPrintWorkingCtrl()); ERXRedirect redirect =
		 * (ERXRedirect) wocomponent .pageWithName(ERXRedirect.class.getName());
		 * redirect.setComponent(nextPage); return redirect; }
		 */
		WOResponse csvExport = new WOResponse();
		csvExport = PrintCSV.printCsvProjetEC("export", sess().filtres(),
				sess());
		return csvExport.generateResponse();
	}

	// Edition XLS
	public WOActionResults simpleProjet() {
		ERXRedirect redirect = (ERXRedirect) wocomponent().pageWithName(
				ERXRedirect.class.getName());
		redirect.setComponent(wocomponent().home());
		if (wocomponent().projetDg().allObjects().count() == 0) {
			// sess.addSimpleErrorMessage("Erreur", "Liste de projet vide");
			sess().setAlertMessage(
					"Impression impossible, liste de projet vide");
			wocomponent().context().response().setStatus(500);
			return redirect;
		}
		/*
		 * //NSMutableDictionary<String, Object> sess().filtres() = new
		 * NSMutableDictionary<String, Object>(); if
		 * (sess().getSelectedRechUnit1() != null) {
		 * sess().filtres().takeValueForKey(
		 * sess().getSelectedRechUnit1().primaryKey(), "equipePrincipale");
		 * sess().setSelectedRechUnit1(null); } if (sess().getSelectedPorteur1()
		 * != null) { sess().filtres().takeValueForKey(
		 * Long.valueOf(sess().getSelectedPorteur1().primaryKey()), "porteur");
		 * sess().setSelectedPorteur1(null); } if (sess().getSelectedProjet() !=
		 * null) { sess().filtres().takeValueForKey(
		 * Long.valueOf(sess().getSelectedProjet().primaryKey()), "projetId");
		 * sess().setSelectedProjet(null); } if (sess().getSelectedContrat1() !=
		 * null) { Integer pk = Integer.valueOf(sess().getSelectedContrat1()
		 * .primaryKey()); sess().filtres().takeValueForKey(pk, "typcontId");
		 * sess().setSelectedContrat1(null); } if (sess().getSelectedState() !=
		 * null) {
		 * sess().filtres().takeValueForKey(sess().getSelectedState().typrefdom
		 * (), "typrefdom");
		 * sess().filtres().takeValueForKey(sess().getSelectedState
		 * ().typrefnat(), "typrefnat"); sess().setSelectedState(null); }
		 */
		try {
			wocomponent().setSimpleProgress(new ReporterAjaxProgress(100));
			String timeStamp = ERXTimestampFormatter.dateFormatterForPattern(
					"%Y_%m_%d_%H_%M").format(new NSTimestamp());
			wocomponent().setSimpleFilename(
					"Pprec_EtatProjets_" + timeStamp + ".xls");
			CktlAbstractReporter report = EditionsEtatProjets
					.etatProjetsEC(sess().filtres(), sess(), wocomponent()
							.getSimpleProgress());
			wocomponent().setReporterSimple(report);
		} catch (Exception e) {
			sess().addSimpleErrorMessage("Exception",
					"Une erreur s'est produite durant l'edition des projets");
		}
		return null;
	}

	// Edition PDF
	public WOActionResults detailProjet() {
		if (wocomponent().projetDg().allObjects().count() == 0) {
			// sess.addSimpleErrorMessage("Erreur", "Liste de projet vide");
			sess().setAlertMessage(
					"Impression impossible, liste de projet vide");
			wocomponent().context().response().setStatus(500);
			ERXRedirect redirect = (ERXRedirect) wocomponent().pageWithName(
					ERXRedirect.class.getName());
			redirect.setComponent(wocomponent().home());
			return redirect;
		}
		// NSMutableDictionary<String, Object> filtres = new
		// NSMutableDictionary<String, Object>();
		// NSLog.out.appendln("Nombre de projet : "+
		/*
		 * wocomponent.projetDg().allObjects().count()); if
		 * (sess().getSelectedRechUnit1() != null) { filtres.takeValueForKey(
		 * sess().getSelectedRechUnit1().cStructure(), "equipePrincipale");
		 * sess().setSelectedRechUnit1(null); } if (sess().getSelectedPorteur1()
		 * != null) { filtres.takeValueForKey(
		 * Long.valueOf(sess().getSelectedPorteur1().noIndividu()), "porteur");
		 * sess().setSelectedPorteur1(null); } if (sess.getSelectedProjet() !=
		 * null) { filtres.takeValueForKey(
		 * Long.valueOf(sess().getSelectedProjet().primaryKey()), "projetId");
		 * sess().setSelectedProjet(null); } if (sess().getSelectedContrat1() !=
		 * null) { Integer pk = Integer.valueOf(sess().getSelectedContrat1()
		 * .primaryKey()); filtres.takeValueForKey(pk, "typcontId");
		 * sess().setSelectedContrat1(null); } if (sess().getSelectedState() !=
		 * null) {
		 * filtres.takeValueForKey(sess().getSelectedState().typrefdom(),
		 * "typrefdom");
		 * filtres.takeValueForKey(sess().getSelectedState().typrefnat(),
		 * "typrefnat"); sess().setSelectedState(null); }
		 */
		try {
			wocomponent().setDetailProgress(new ReporterAjaxProgress(100));
			String timeStamp = ERXTimestampFormatter.dateFormatterForPattern(
					"%Y_%m_%d_%H_%M").format(new NSTimestamp());
			wocomponent.setDetailFilename("Pprec_DetailProjets_" + timeStamp
					+ ".pdf");
			CktlAbstractReporter report = EditionsDetailProjets
					.detailProjetsEC(sess().filtres(), sess(), wocomponent()
							.getDetailProgress());
			wocomponent().setReporterDetail(report);
		} catch (Exception e) {
			sess().addSimpleErrorMessage("Exception",
					"Une erreur s'est produite durant l'edition des projets");
		}
		return null;
	}

	// Edition XML
	public WOActionResults detailProjetXML() {
		ERXRedirect redirect = (ERXRedirect) wocomponent().pageWithName(
				ERXRedirect.class.getName());
		try {
			if (wocomponent().projetDg().allObjects().count() == 0) {
				// sess.addSimpleErrorMessage("Erreur", "Liste de projet vide");
				sess().setAlertMessage(
						"Impression impossible, liste de projet vide");
				wocomponent().context().response().setStatus(500);
				redirect.setComponent(wocomponent().home());
				return redirect;
			}
			/*
			 * NSMutableDictionary<String, Object> filtres = new
			 * NSMutableDictionary<String, Object>(); //
			 * NSLog.out.appendln("Nombre de projet : "+ //
			 * wocomponent.projetDg().allObjects().count()); if
			 * (sess().getSelectedRechUnit1() != null) {
			 * filtres.takeValueForKey(sess().getSelectedRechUnit1()
			 * .cStructure(), "equipePrincipale");
			 * sess().setSelectedRechUnit1(null); } if
			 * (sess().getSelectedPorteur1() != null) { filtres.takeValueForKey(
			 * Long.valueOf(sess().getSelectedPorteur1().noIndividu()),
			 * "porteur"); sess().setSelectedPorteur1(null); } if
			 * (sess().getSelectedProjet() != null) { filtres.takeValueForKey(
			 * Long.valueOf(sess().getSelectedProjet().primaryKey()),
			 * "projetId"); sess().setSelectedProjet(null); } if
			 * (sess().getSelectedContrat1() != null) { Integer pk =
			 * Integer.valueOf(sess().getSelectedContrat1() .primaryKey());
			 * filtres.takeValueForKey(pk, "typcontId");
			 * sess().setSelectedContrat1(null); } if (sess().getSelectedState()
			 * != null) {
			 * filtres.takeValueForKey(sess().getSelectedState().typrefdom(),
			 * "typrefdom");
			 * filtres.takeValueForKey(sess().getSelectedState().typrefnat(),
			 * "typrefnat"); sess().setSelectedState(null); }
			 */
			String timeStamp = ERXTimestampFormatter.dateFormatterForPattern(
					"%Y_%m_%d_%H_%M").format(new NSTimestamp());
			wocomponent().setDetailFilename(
					"Pprec_DetailProjets_Xml_" + timeStamp + ".xml");
			NSData xml = EditionsDetailProjets.detailXmlProjets(sess()
					.filtres(), sess());
			return EditionsDetailProjets.afficherXml(xml, wocomponent()
					.getDetailFilename(), wocomponent());
		} catch (Throwable e) {
			e.printStackTrace();
			sess().setAlertMessage(e.getMessage());
			sess().setMessageErreur(e.getMessage());
			return null;
		}
	}

	public WOActionResults exportCSV() {
		WOResponse csv = getPrintWorkingCtrl().getLastCsvResponse();
		getPrintWorkingCtrl().setLastCsvResponse(null);
		getPrintWorkingCtrl().setTravailTermine(false);
		isAfficherLnkTelechargerFichierCsv();
		AjaxUpdateContainer.updateContainerWithID(wocomponent()
				.ListidContainerId(), wocomponent().context());
		return csv;
	}

	protected void autres(NSArray<EOEquipes> equipes) {
		NSMutableArray<EOEquipes> List = new NSMutableArray<EOEquipes>();
		if (equipes != null && equipes.count() != 0) {
			for (int j = 0; equipes.count() > j; j++) {
				List.addObject(equipes.objectAtIndex(j));
			}
			setOtherList(EOStructureUlr.C_STRUCTURE.isNot(
					projet().equipePrincipale())
					.filtered(List.immutableClone()));
		}
	}

	/**
	 * @return the printWorkingCtrl
	 */
	public PrintWorkingCtrl getPrintWorkingCtrl() {
		return printWorkingCtrl;
	}

	/**
	 * @param printWorkingCtrl
	 *            the printWorkingCtrl to set
	 */
	public void setPrintWorkingCtrl(PrintWorkingCtrl printWorkingCtrl) {
		this.printWorkingCtrl = printWorkingCtrl;
	}

	// Gestion des Droits

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
	 * @return the projet
	 */
	public EOPprec projet() {
		if (sess().getBigTmpProject() != null)
			projet = sess().getBigTmpProject().getProjet();
		return projet;
	}

	/**
	 * @param projet
	 *            the projet to set
	 */
	public void setProjet(EOPprec projet) {
		this.projet = projet;
	}

}
