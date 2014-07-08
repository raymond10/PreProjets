/**
 * 
 */
package utt.rec.projet.server.components.controler;

import javax.mail.FetchProfile;

import org.apache.commons.lang.text.StrMatcher;
import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOCookie;
import com.webobjects.appserver.WORequest;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import er.ajax.AjaxUpdateContainer;
import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.appserver.ERXRedirect;
import er.extensions.eof.ERXEC;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.SoumiProject;
import utt.rec.projet.server.components.UpdateNextProject;
import utt.rec.projet.server.components.UpdateProject;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.exception.ProjetException;
import utt.rec.projet.server.factory.FactoryDataArray;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORefidx;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.admrec.EOVrhcmval;
import utt.rec.projet.server.metier.admrec.EOVtyprhcm;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EORepartAssociation;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessEquipes;
import utt.rec.projet.server.process.ProcessPartProjet;
import utt.rec.projet.server.process.ProcessPartenaire;
import utt.rec.projet.server.process.ProcessProjet;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class UpdateProjectCtrl extends ModuleCtrl<UpdateProject> {

	private EOEditingContext edc;
	private Session sess;
	private EOPprec projet;
	private Number idPArt;
	private FactoryDataArray dataArray;
	private EOAxerec previousAxe = null;
	private EOAxerec previousPst = null;
	private EOAxerec previousAxetmk = null;
	private EORepartaxe repartPst = null;
	private EORepartaxe repartAx = null;
	private EORepartaxe repartAxTmk = null;
	
	/**
	 * @param component
	 */
	public UpdateProjectCtrl(UpdateProject component) {
		super(component);
		// TODO Auto-generated constructor stub
	}

	public boolean peutNouveauPartenaire() {
		Boolean partenaireCreate = null;
		if (wocomponent().myApp().newGestionDroitsEnabled()) {
			partenaireCreate = wocomponent().myAppGDUser()
					.getPprecAutorisationCache().gDPprecCreationProjet()
					|| wocomponent().myAppGDUser().getPprecAutorisationCache()
							.gDPprecSuperUserProjet();
		} else {
			partenaireCreate = wocomponent().myAppJAUser()
					.hasDroitCreationProjet()
					|| wocomponent().myAppJAUser().hasDroitSuperUserProjet();
		}
		return partenaireCreate;
	}

	/**
	 * @return the projet
	 */
	public EOPprec projet() {
		if(projet == null)
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
	 * @return the edc
	 */
	public EOEditingContext edc() {
		if(edc == null)
			edc = wocomponent().edc();
		return edc;
	}

	/**
	 * @param edc the edc to set
	 */
	public void setEdc(EOEditingContext edc) {
		this.edc = edc;
	}

	/**
	 * @return the sess
	 */
	public Session sess() {
		if(sess == null)
			sess = wocomponent().mySession();
		return sess;
	}

	/**
	 * @param sess the sess to set
	 */
	public void setSess(Session sess) {
		this.sess = sess;
	}

	/**
	 * @return the dataArray
	 */
	public FactoryDataArray dataArray() {
		if (dataArray == null)
			dataArray = new FactoryDataArray(wocomponent(), sess(),
					wocomponent().equipeOther(), wocomponent().newPartListe());
		return dataArray;
	}

	/**
	 * @param dataArray
	 *            the dataArray to set
	 */
	public void setDataArray(FactoryDataArray dataArray) {
		this.dataArray = dataArray;
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

	// Affichage Page 1
	public void PageOne() {
		sess().setNomCourt(projet().projnomcourt());
		sess().setNomLong(projet().projnomlong());
		EOVrhcmval vEc = EOVrhcmval.unPolePourIndividu(edc(),projet().porteur());
		sess().setPorteur(vEc);
		sess().setEtabPorteur(projet().etabPorteur());
		sess().setDureeProjet(projet().projduree());
		sess().setDateDebut(projet().projdatdebut());
		EOTypcontrat contrat = null;
		if (projet().toContrat() != null) {
			if (projet().toContrat().typcontIdSup() != null) {
				sess().setStContratSelected(projet().toContrat());
				contrat = EOTypcontrat.fetchContratPere(edc(),
						projet().toContrat().typcontIdSup()).lastObject();
			} else {
				contrat = projet().toContrat();
			}
			sess().setContrat(contrat);
		}
		if (projet().srcefinance() != null)
			sess().setSourceFinance(projet().srcefinance());
		// sess().setPartAdd(projet.partenaire().nomPartenaire());
		sess().setEquipePrincipale(EOStructureUlr.structurePourcStructure(edc(),projet().equipePrincipale()));
		partProjetList(projet().toProjetPartenaires(
				EOPartenaireProjet.TEMVALIDE.eq("O"), true));
		autres(projet().toEquipeSecondaires(
				EOEquipes.PRINCIPALE.eq("N").and(EOEquipes.TEMVALIDE.eq("O")),
				true));
		sess().setAxe(projet().toAxe());
		smtr(projet().toProjetRepartaxes(EORepartaxe.TEMVALIDE.eq("O")));
		sess().setSelectThematique(projet().projthetv());
		sess().setSelectedThematik(projet().toThematique());
		sess().setSelectedTheme(projet().toTheme());
		sess().setSelectedSouTheme(projet().toSousThemes());
		sess().setContexte(projet().projctx());
		sess().setProblematik(projet().projpblm());
		sess().setObjectifs(projet().projobf());
		sess().setMetho(projet().projmtdg());
		// Factory
		dataArray().refreshPole();
		dataArray().onPart();
		dataArray().upDateTrans();
		dataArray().upDateOtherEqp();
		dataArray().upDatePst();
		dataArray().upDateAxes();
		dataArray().getHasThematique();
		dataArray().upDateStContrat();
	}

	// Fin //Affichage Page 1

	public WOActionResults nextPage() {
		sess().retourMaj = false;
		String vide = "<p><br data-mce-bogus=\"1\"></p>";
		UpdateNextProject nextPage = (UpdateNextProject) wocomponent()
				.pageWithName(UpdateNextProject.class.getName());
		WORequest request = wocomponent().context().request();
		String contexte = (String) request.formValueForKey("Contexte");
		String problematik = (String) request.formValueForKey("Problematique");
		String objectifs = (String) request.formValueForKey("Objectifs");
		String methodo = (String) request.formValueForKey("Methodologie");
		if (contexte != null && !contexte.equals(vide) && !contexte.equals("")) {
			sess().setContexte(contexte);
			nextPage.setContexte(contexte);
		}
		if (problematik != null && !problematik.equals(vide)
				&& !problematik.equals("")) {
			sess().setProblematik(problematik);
			nextPage.setProblematique(problematik);
		}
		if (objectifs != null && !objectifs.equals(vide)
				&& !objectifs.equals("")) {
			sess().setObjectifs(objectifs);
			nextPage.setObjectif(objectifs);
		}
		if (methodo != null && !methodo.equals(vide) && !methodo.equals("")) {
			sess().setMetho(methodo);
			nextPage.setMethodologie(methodo);
		}
		ERXRedirect redirect = (ERXRedirect) wocomponent()
				.pageWithName(ERXRedirect.class.getName());
		redirect.setComponent(nextPage);
		return redirect;
	}

	public WOActionResults annuler() {
		Accueil home = (Accueil) wocomponent().pageWithName(Accueil.class
				.getName());
		ERXRedirect redirect = (ERXRedirect) wocomponent()
				.pageWithName(ERXRedirect.class.getName());
		redirect.setComponent(home);
		return redirect;
	}

	// Remove item form partnerList
	public WOActionResults removePartner() {
		sess().partenaireDg().setSelectedObject(sess().getPartenaireItem());
		EOPartenaireProjet prop = EOPartenaireProjet.fetchEOPartenaireProjet(
				edc(), EOPartenaireProjet.TO_PARTENAIRE.eq(sess().getPartenaireItem())
						.and(EOPartenaireProjet.TO_PROJET.eq(projet())));
		if (prop != null) {
			prop.setTemvalide("N");
			prop.editingContext().saveChanges();
		}
		sess().partenaireDg().allObjects()
				.remove(sess().partenaireDg().selectedObject());
		wocomponent().newPartListe().setArray(sess().partenaireDg().allObjects());
		if (sess().partenaireDg().allObjects().count() == 0) {
			sess().setPartenaire(null);
		}
		AjaxUpdateContainer.updateContainerWithID(wocomponent().partenaireId(),
				wocomponent().context());
		return null;
	}

	/* Date base save Method */

	// Traitement d'un projet

	public EOPprec projetEnCours() throws ProjetException {
		// Traitement Page 1
		if (sess().getSourceFinance() != null) {
			projet().setSrcefinance(sess().getSourceFinance());
		} else {
			projet().setSrcefinance(projet.srcefinance());
		}
		projet().setProjnomcourt(sess().getNomCourt());
		projet().setProjnomlong(sess().getNomLong());
		if (sess().porteur() == null) {
			throw new FactoryException(
					"il faut selectionner le porteur du projet");
		}
		if (sess().porteur() != null) {
			//EOIndividuUlr tmp = EOIndividuUlr.individuPourNumero(edc, sess
			//		.porteur().noIndividu());
			projet().setPorteur(sess().porteur().noIndividu());
		}
		projet().setProjduree(sess().getDureeProjet());
		projet().setProjdatdebut(sess().getDateDebut());
		if (sess().contrat() == null) {
			throw new FactoryException(
					"il faut selectionner le type de contrat du projet");
		}
		projet().setToContrat(sess().getStContratSelected());
		if (sess().equipePrincipale() == null) {
			throw new FactoryException(
					"il faut selectionner le programme d'accueil principal du projet");
		}
		projet().setEquipePrincipale(sess().equipePrincipale().cStructure());
		if (sess().axe() == null) {
			throw new FactoryException("il faut selectionner l'axe du projet");
		}
		projet.setToAxe(sess().axe());
		if (sess().getSelectThematique() != null) {
			projet.setProjthetv(sess().getSelectThematique());
		} else {
			projet.setProjthetv(projet.projthetv());
		}
		if (sess().getSelectedThematik() != null) {
			projet.setToThematique(sess().getSelectedThematik());
		} else {
			projet.setToThematique(projet.toThematique());
		}
		if (sess().getSelectedTheme() != null) {
			projet.setToTheme(sess().getSelectedTheme());
		} else {
			projet.setToTheme(projet.toTheme());
		}
		if (sess().getSelectedSouTheme() != null) {
			projet.setToSousThemes(sess().getSelectedSouTheme());
		} else {
			projet.setToSousThemes(projet.toSousThemes());
		}
		projet.setToEtat(sess().getEtatRepetition1());
		if (sess().getContexte() != null) {
			projet.setProjctx(sess().getContexte());
		} else {
			projet.setProjctx(projet.projctx());
		}
		if (sess().getProblematik() != null) {
			projet.setProjpblm(sess().getProblematik());
		} else {
			projet.setProjpblm(projet.projpblm());
		}
		if (sess().getObjectifs() != null) {
			projet.setProjobf(sess().getObjectifs());
		} else {
			projet.setProjobf(projet.projobf());
		}
		if (sess().getMetho() != null) {
			projet.setProjmtdg(sess().getMetho());
		} else {
			projet.setProjmtdg(projet.projmtdg());
		}
		projet.setMajauteur(sess().getApplicationUser().getNoIndividu()
				.toString());
		projet.setCreadate(projet.creadate());
		projet.setMajdate(new NSTimestamp());
		return projet;
	}

	// Traitement de la liste des partenaires du projet

	@SuppressWarnings("unchecked")
	protected NSMutableArray<EOPartenaireProjet> partProj() {
		NSMutableArray partporj = new NSMutableArray();
		EOPartenaireProjet part = new EOPartenaireProjet();
		if (sess().getNewPartList().count() != 0) {
			for (int j = 0; sess().getNewPartList().count() > j; j++) {
				EOTyppartenaire pat = new EOTyppartenaire();
				pat = sess().getNewPartList().objectAtIndex(j);
				part = EOPartenaireProjet.createEOPartenaireProjet(edc, pat,
						sess().leProjetEnCours());
				partporj.addObject(part);
			}
		}
		return partporj.mutableClone();
	}

	protected void traitementPartProjet(NSArray partProj) {
		if (partProj != null && partProj.count() != 0) {
			for (int i = 0; partProj.count() > i; i++) {
				EOPartenaireProjet partenaire = (EOPartenaireProjet) partProj
						.objectAtIndex(i);
				EOEditingContext edc = partenaire.editingContext();
				try {
					ProcessPartProjet.enregistrer(sess().dataBus(), edc,
							partenaire);
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
						sess().addSimpleErrorMessage("FactoryException ",
								alertMessage);
					}

				} catch (RuntimeException e1) {
					sess().addSimpleErrorMessage("RuntimeException ",
							e1.getMessage());
					e1.printStackTrace();
					throw e1;
				}
			}
		}
	}

	// Fin traitement liste des partenaires

	// traitement liste des autres equipes projets
	@SuppressWarnings("unchecked")
	protected NSMutableArray<EOEquipes> otherEkip() {
		NSMutableArray otherList = new NSMutableArray();
		if (sess().leProjetEnCours().equipePrincipale() != null) {
			EOEquipes equipes = new EOEquipes();
			equipes = EOEquipes.createEOEquipes(edc);
			equipes.setCStructure(EOStructureUlr.structurePourcStructure(edc(), sess().leProjetEnCours().equipePrincipale()).cStructure());
			equipes.setToProjet(sess().leProjetEnCours());
			equipes.setPrincipale("O");
			otherList.addObject(equipes);
		}
		if (sess().autreEquipeDg().allObjects().count() != 0) {
			for (int i = 0; sess().autreEquipeDg().allObjects().count() > i; i++) {
				EOEquipes equipes = new EOEquipes();
				equipes = EOEquipes.createEOEquipes(edc);
				EOStructureUlr structure = new EOStructureUlr();
				structure = (EOStructureUlr) sess().autreEquipeDg().allObjects()
						.objectAtIndex(i);
				equipes.setCStructure(structure.cStructure());
				equipes.setToProjet(sess().leProjetEnCours());
				equipes.setPrincipale("N");
				otherList.addObject(equipes);
			}
		}
		return otherList.mutableClone();
	}

	protected void newPartnaire() {
		EOTyppartenaire partenaire = new EOTyppartenaire();
		partenaire = EOTyppartenaire.createEOTyppartenaire(edc);
		if (sess().getPartAdd() == null) {
			throw new FactoryException(
					"Le libelle du partenaire est obligatoire");
		}
		partenaire.setNomPartenaire(sess().getPartAdd());
		partenaire.setPartCleunik("N/A");
		partenaire.validateForSave();
		try {
			ProcessPartenaire.enregistrer(sess().dataBus(), edc, partenaire);
			idPArt = partenaire.getTypIdProc();
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

		} catch (RuntimeException e1) {
			sess().addSimpleErrorMessage("RuntimeException ", e1.getMessage());
			e1.printStackTrace();
			throw e1;
		}
		sess().setPartAdd(null);
	}

	protected void traitementOtherEkip(NSArray equipes) {
		if (equipes != null && equipes.count() != 0) {
			for (int i = 0; equipes.count() > i; i++) {
				EOEquipes equipe = (EOEquipes) equipes.objectAtIndex(i);
				EOEditingContext edc = equipe.editingContext();
				try {
					ProcessEquipes.enregistrer(sess().dataBus(), edc, equipe);
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
						sess().addSimpleErrorMessage("FactoryException ",
								alertMessage);
					}

				} catch (RuntimeException e1) {
					sess().addSimpleErrorMessage("RuntimeException ",
							e1.getMessage());
					e1.printStackTrace();
					throw e1;
				}
			}
		}
	}

	// Fin traitement liste des autres equipes projets

	// Enregistrement dans la base de données
	public WOActionResults enregistrer() {
		WORequest request = wocomponent().context().request();
		String contexte = (String) request.formValueForKey("Contexte");
		String problematik = (String) request.formValueForKey("Problematique");
		String objectifs = (String) request.formValueForKey("Objectifs");
		String methodo = (String) request.formValueForKey("Methodologie");
		sess().setContexte(contexte);
		sess().setProblematik(problematik);
		sess().setObjectifs(objectifs);
		sess().setMetho(methodo);
		SoumiProject nextPage = null;
		EOPprec leNouveauProjet = null;
		EOEditingContext nestedEdc = edc;
		sess().setNestedEdc(nestedEdc);
		try {
			sess().setLeProjetEnCours(projetEnCours());
			leNouveauProjet = sess().leProjetEnCours();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			EOEditingContext edc = leNouveauProjet.editingContext();
			nextPage = (SoumiProject) wocomponent()
					.pageWithName(SoumiProject.class.getName());
			nextPage.setState("Rédaction");
			ProcessProjet.enregistrer(sess().dataBus(), edc, leNouveauProjet);
			sess().setIdProjetRecent(leNouveauProjet.getProjIdProc());
			sess().addSimpleInfoMessage("Nouveau Projet '" + sess().getNomCourt()
					+ "'enregistré avec succès",
					"Le projet à été ajouté dans le référentiel ADMREC");
			// On refetch pour récupéré le dernier enregistrement pour les
			// autres données dépendants de EOPPREC
			NSArray lesProjets = EOPprec.fetchRenvoiLeProjet(edc,
					Integer.valueOf(sess().getIdProjetRecent().toString()));
			sess().setLeProjetEnCours((EOPprec) lesProjets.lastObject());
			// lancement de l'insertion de la liste des partenaire et des autres
			// équipes projets
			// traitementPartProjet(partProj());
			// newPartnaire();
			traitementOtherEkip(otherEkip());
			sess().resetAll();
		} catch (FactoryException e) {
			String alertMessage = e.getMessageFormatte();
			nextPage = null;
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

		} catch (RuntimeException e1) {
			sess().addSimpleErrorMessage("RuntimeException ", e1.getMessage());
			e1.printStackTrace();
			throw e1;
		}
		return nextPage;
	}

	/* End Date Base save Method */

	// Mots clefs

	public WOActionResults motclef2() {
		if (sess().getMotClef() != null) {
			return null;
		}
		return null;
	}

	// Module de recherches
	public WOActionResults refreshPop2() {
		NSLog.out.appendln(sess().getSelectedMotClefs());
		if (sess().getSelectedMotClefs() != null) {

		}
		return null;
	}

	public WOActionResults refreshPop3() {
		return null;
	}

	// Field Complete

	public WOActionResults completeField() {
		return null;
	}

	// List STMR et Update bouton save
	public WOActionResults isEnregistrerUnProjetEnabled() {
		NSMutableArray stm = sess().lesSTMR().allObjects().mutableClone();
		boolean axe = sess().axe() != null;
		boolean pst = sess().pst() != null;
		boolean axeTmk = sess().getSelectedStmrAxe() != null;
		boolean tmk = sess().getSelectThematique() == null;
		// boolean pjtv = projet.projthetv()!= null &&
		// projet.projthetv().equals("O");
		if (previousPst != null && pst && tmk && stm.contains(previousPst)) {
			stm.remove(previousPst);
			if (repartPst.toAxe().equals(previousPst)) {
				repartPst.setTemvalide("N");
				repartPst.editingContext().saveChanges();
			}
			stm.addObject(sess().pst());
			previousPst = sess().pst();
			if (previousAxe != null && axe && tmk && stm.contains(previousAxe)) {
				stm.remove(previousAxe);
				if (repartAx.toAxe().equals(previousAxe)) {
					repartAx.setTemvalide("N");
					repartAx.editingContext().saveChanges();
				}
				stm.addObject(sess().axe());
				previousAxe = sess().axe();
			}
		}
		if (!tmk) {
			if (previousAxetmk != null && axeTmk
					&& stm.contains(previousAxetmk)) {
				stm.remove(previousAxetmk);
				if (repartAxTmk.toAxe().equals(previousAxetmk)) {
					repartAxTmk.setTemvalide("N");
					repartAxTmk.editingContext().saveChanges();
				}
			}
			stm.addObject(sess().getSelectedStmrAxe());
			previousAxetmk = sess().getSelectedStmrAxe();
		}
		sess().lesSTMR().setObjectArray(stm.immutableClone());
		return wocomponent().doNothing();
	}

	// Remove item from OtherEquipeList
	public WOActionResults removeAtrePRGAssocie() {
		sess().autreEquipeDg().setSelectedObject(sess().getOtherRepetition());
		EOEquipes okp = EOEquipes.fetchEOEquipes(
				edc,
				EOEquipes.C_STRUCTURE.eq(sess().getOtherRepetition().cStructure()).and(
						EOEquipes.TO_PROJET.eq(projet())));
		if (okp != null) {
			okp.setTemvalide("N");
			okp.editingContext().saveChanges();
		}
		/*
		 * sess().autreEquipeDg().allObjects()
		 * .remove(sess().autreEquipeDg().selectedObject());
		 */
		sess().autreEquipeDg()._deleteObject(
				sess().autreEquipeDg().selectedObject());
		wocomponent().equipeOther().setArray(sess().autreEquipeDg().allObjects());
		AjaxUpdateContainer.updateContainerWithID(
				wocomponent().selectedOtherId(), wocomponent().context());
		return null;
	}

	// Construction de la liste des partenaires
	public void partProjetList(NSArray<EOPartenaireProjet> partenaires) {
		NSMutableArray<EOTyppartenaire> tmp = new NSMutableArray<EOTyppartenaire>();
		if (partenaires != null && partenaires.count() != 0) {
			for (int i = 0; i < partenaires.count(); i++) {
				tmp.addObject(partenaires.objectAtIndex(i).toPartenaire());
			}
			if (partenaires.count() > 0
					&& partenaires.lastObject().toPartenaire() != null) {
				sess().setPartenaire(partenaires.lastObject()
						.toPartenaire());
			}
			wocomponent().newPartListe().setArray(tmp.immutableClone());
			sess().setPartenaireDg(new ERXDisplayGroup<EOTyppartenaire>());
			sess().partenaireDg().setObjectArray(wocomponent().newPartListe());
		}
	}

	// Construction de la liste des programmes secondaires
	public void autres(NSArray<EOEquipes> equipes) {
		NSArray<EOEquipes> equip = new NSArray<EOEquipes>();
		sess().setAutreEquipeDg(new ERXDisplayGroup<EOStructureUlr>());
		if (equipes != null && equipes.count() != 0) {
			equip = EOStructureUlr.C_STRUCTURE.isNot(
					projet().equipePrincipale()).filtered(equipes);
			if (equip.count() > 0 && equip.lastObject().cStructure() != null) {
				EOStructureUlr str = EOStructureUlr.structurePourcStructure(ERXEC.newEditingContext(), equip.lastObject().cStructure());
				sess().setSelectedEquipeSecondaire(str);
			}
			NSMutableArray tmp = new NSMutableArray();
			for (int i = 0; i < equip.count(); i++) {
				EOStructureUlr str = EOStructureUlr.structurePourcStructure(ERXEC.newEditingContext(), equip.objectAtIndex(i).cStructure());
				if(!tmp.contains(str))
					tmp.addObject(str);
			}
			wocomponent().equipeOther().setArray(tmp.immutableClone());
			sess().autreEquipeDg().setObjectArray(
					wocomponent().equipeOther().immutableClone());
		}
	}

	// Construction Pst et Axe STMR
	public void smtr(NSArray<EORepartaxe> repartAxes) {
		sess().setLesSTMR(new ERXDisplayGroup<EORepartaxe>());
		if (repartAxes != null && repartAxes.count() != 0) {
			NSMutableArray tmp = new NSMutableArray();
			for (int i = 0; i < repartAxes.count(); i++) {
				EORepartaxe repartAxe = repartAxes.objectAtIndex(i);
				if (projet.projthetv() == null) {
					if (repartAxe.toAxe().temAxe().equals("P")) {
						sess().setPst(repartAxe.toAxe());
						repartPst = repartAxe;
						previousPst = repartAxe.toAxe();
					} else {
						sess().setAxe(repartAxe.toAxe());
						repartAx = repartAxe;
						previousAxe = repartAxe.toAxe();
					}
				}
				// Ici on recupère l'axe STMR lorsque la thématique est à "O"
				if (projet.projthetv() != null
						&& projet.projthetv().equals("O")
						&& repartAxe.toAxe().toEquipe()
								.equals(wocomponent().umrStmr())) {
					sess().setSelectedStmrAxe(repartAxe.toAxe());
					repartAxTmk = repartAxe;
					previousAxetmk = repartAxe.toAxe();
				} else {
					sess().setAxe(repartAxe.toAxe());
					repartAx = repartAxe;
					previousAxe = repartAxe.toAxe();
				}
				tmp.addObject(repartAxe.toAxe());
			}
			sess().lesSTMR().setObjectArray(tmp.immutableClone());
		}
	}

/*	protected void lesMotCles() {
		NSArray<EOMotclefs> motCleList = new NSArray<EOMotclefs>();
		NSMutableArray tmp = new NSMutableArray();
		sess().setMotClefList(new NSMutableArray<EORefidx>());
		motCleList = EOMotclefs.fetchMotClefsProjet(edc,
				Integer.valueOf(projet.primaryKey()));
		if (motCleList.count() > 0) {
			for (int i = 0; i < motCleList.count(); i++) {
				tmp.addObject(motCleList.objectAtIndex(i).refidx());
			}
			sess().getMotClefList().setArray(tmp.immutableClone());
		}
	}*/

	public void refdix() {
		if (wocomponent().myKeywordList() != null && wocomponent().myKeywordList().count() > 0) {
			for (int i = 0; i < wocomponent().myKeywordList().count(); i++) {
				EORefidx tmp = (EORefidx) wocomponent().myKeywordList().objectAtIndex(i);
				switch (i) {
				case 0:
					sess().setMotClef(tmp);
					break;
				case 1:
					sess().setMotClef1(tmp);
					break;
				case 2:
					sess().setMotClef2(tmp);
					break;
				case 3:
					sess().setMotClef3(tmp);
					break;
				case 4:
					sess().setMotClef4(tmp);
					break;
				case 5:
					sess().setMotClef5(tmp);
					break;
				case 6:
					sess().setMotClef6(tmp);
					break;
				case 7:
					sess().setMotClef7(tmp);
					break;
				case 8:
					sess().setMotClef8(tmp);
					break;
				case 9:
					sess().setMotClef9(tmp);
					break;
				case 10:
					sess().setMotClef10(tmp);
					break;
				case 11:
					sess().setMotClef11(tmp);
					break;
				default:
					break;
				}
			}
		}

	}

	public NSMutableArray<Integer> IntegerEquipe() {
		NSMutableArray<Integer> erList = new NSMutableArray<Integer>();
		NSArray tmpList = EORepartAssociation.fetchLesER(wocomponent().edc(),
				new NSTimestamp());
		for (int i = 0; i < tmpList.count(); i++) {
			Integer persId = ((EORepartAssociation) tmpList.objectAtIndex(i))
					.persId();
			erList.addObject(persId);
		}
		return erList;
	}
}
