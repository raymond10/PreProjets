/**
 * 
 */
package utt.rec.projet.server.components.controler;

import java.text.Format;

import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.codehaus.groovy.tools.shell.commands.SetCommand;

import utt.rec.projet.server.PPrecApplicationUser;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.EditNextProject;
import utt.rec.projet.server.components.ViserProject;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.factory.FactoryTraitementAvisCommentaires;
import utt.rec.projet.server.metier.admrec.EOAlerte;
import utt.rec.projet.server.metier.admrec.EOCommentaires;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOTypref;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessComment;
import utt.rec.projet.server.process.ProcessProjet;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.appserver.WORequest;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSTimestampFormatter;

import er.ajax.AjaxUpdateContainer;
import er.extensions.appserver.ERXRedirect;
import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXGenericRecord;
import er.extensions.eof.ERXQ;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class ViserProjectCtrl extends ModuleCtrl<ViserProject> {

	// DatePicker
	public Format formatter = new NSTimestampFormatter("%d/%m/%Y");
	public NSArray<String> frenchMonths = new NSArray<String>(new String[] {
			"janvier", "février", "mars", "avril", "mai", "juin", "juillet",
			"août", "septembre", "octobre", "novembre", "décembre" });

	public NSArray<String> frenchDays = new NSArray<String>(new String[] {
			"dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi",
			"samedi" });
	// End DatePicker
	private EOEditingContext edc;
	private Session sess;
	private EOPprec projet;
	private EOStructureUlr poleCompetence;
	private Boolean principal = false, pseudoSecondaire = false,
			pseudoSecondaire1 = false, secondaire = false, directeur = false,
			afficheDrt = false, affichePP = false, affichePS = false,
			afficheICD = false, overEquipes = false, overPoles = false;
	private NSArray<EOEquipes> equipes = new NSArray<EOEquipes>();
	private NSMutableArray<EOEquipes> ListEquip = new NSMutableArray<EOEquipes>();
	private NSMutableArray<EOStructureUlr> ListPole;
	public String principalValue, secondaireValue, directeurValue;
	private FactoryTraitementAvisCommentaires trtComment = new FactoryTraitementAvisCommentaires();
	public NSMutableArray<EOStructureUlr> rechUnitPrj = new NSMutableArray<EOStructureUlr>();
	public NSMutableArray<EOStructureUlr> rechUnitPrj1 = new NSMutableArray<EOStructureUlr>();
	public NSMutableArray<EOStructureUlr> reponsableEquipeSecondaire = new NSMutableArray<EOStructureUlr>();
	public NSMutableArray<EOStructureUlr> directeurPole = new NSMutableArray<EOStructureUlr>();
	private EOCommentaires comPP;
	// private EOCommentaires comPS;
	private EOCommentaires comDrt;
	private NSArray<EOEquipes> otherList;
	public Boolean buttonSave = true;

	/**
	 * @param component
	 */
	public ViserProjectCtrl(ViserProject component) {
		super(component);
		// TODO Auto-generated constructor stub
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
	 * @return the otherList
	 */
	public NSArray<EOEquipes> getOtherList() {
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
	 * @return the equipes
	 */
	public NSArray<EOEquipes> getEquipes() {
		return equipes;
	}

	/**
	 * @param equipes
	 *            the equipes to set
	 */
	public void setEquipes(NSArray<EOEquipes> equipes) {
		this.equipes = equipes;
	}

	/**
	 * @return the listEquip
	 */
	public NSMutableArray<EOEquipes> getListEquip() {
		return ListEquip;
	}

	/**
	 * @param listEquip
	 *            the listEquip to set
	 */
	public void setListEquip(NSMutableArray<EOEquipes> listEquip) {
		ListEquip = listEquip;
	}

	public String libelleStructure() {
		String lib = "";
		if (sess().getNewEquipe() != null) {
			EOStructureUlr str = EOStructureUlr.structurePourcStructure(edc(),
					sess().getNewEquipe().cStructure());
			lib = str.lcStructure();
		}
		return lib;
	}

	/**
	 * @return the listPole
	 */
	public NSMutableArray<EOStructureUlr> getListPole() {
		if (ListPole == null)
			ListPole = new NSMutableArray<EOStructureUlr>();
		return ListPole;
	}

	/**
	 * @param listPole
	 *            the listPole to set
	 */
	public void setListPole(NSMutableArray<EOStructureUlr> listPole) {
		ListPole = listPole;
	}

	/**
	 * @return the trtComment
	 */
	public FactoryTraitementAvisCommentaires getTrtComment() {
		return trtComment;
	}

	/**
	 * @param trtComment
	 *            the trtComment to set
	 */
	public void setTrtComment(FactoryTraitementAvisCommentaires trtComment) {
		this.trtComment = trtComment;
	}

	/**
	 * @return the comPP
	 */
	public EOCommentaires getComPP() {
		return comPP;
	}

	/**
	 * @param comPP
	 *            the comPP to set
	 */
	public void setComPP(EOCommentaires comPP) {
		this.comPP = comPP;
	}

	/*	*//**
	 * @return the comPS
	 */
	/*
	 * public EOCommentaires getComPS() { return comPS; }
	 *//**
	 * @param comPS
	 *            the comPS to set
	 */
	/*
	 * public void setComPS(EOCommentaires comPS) { this.comPS = comPS; }
	 */

	/**
	 * @return the comDrt
	 */
	public EOCommentaires getComDrt() {
		return comDrt;
	}

	/**
	 * @param comDrt
	 *            the comDrt to set
	 */
	public void setComDrt(EOCommentaires comDrt) {
		this.comDrt = comDrt;
	}

	/**
	 * @return the principal
	 */
	public boolean isPrincipal() {
		return principal;
	}

	/**
	 * @param principal
	 *            the principal to set
	 */
	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	/**
	 * @return the pseudoSecondaire
	 */
	public boolean isPseudoSecondaire() {
		return pseudoSecondaire;
	}

	/**
	 * @param pseudoSecondaire
	 *            the pseudoSecondaire to set
	 */
	public void setPseudoSecondaire(boolean pseudoSecondaire) {
		this.pseudoSecondaire = pseudoSecondaire;
	}

	/**
	 * @return the pseudoSecondaire1
	 */
	public boolean isPseudoSecondaire1() {
		return pseudoSecondaire1;
	}

	/**
	 * @param pseudoSecondaire1
	 *            the pseudoSecondaire1 to set
	 */
	public void setPseudoSecondaire1(boolean pseudoSecondaire1) {
		this.pseudoSecondaire1 = pseudoSecondaire1;
	}

	/**
	 * @return the secondaire
	 */
	public boolean isSecondaire() {
		return secondaire;
	}

	/**
	 * @param secondaire
	 *            the secondaire to set
	 */
	public void setSecondaire(boolean secondaire) {
		this.secondaire = secondaire;
	}

	/**
	 * @return the directeur
	 */
	public boolean isDirecteur() {
		return directeur;
	}

	/**
	 * @param directeur
	 *            the directeur to set
	 */
	public void setDirecteur(boolean directeur) {
		this.directeur = directeur;
	}

	/**
	 * @return the afficheDrt
	 */
	public boolean isAfficheDrt() {
		return afficheDrt;
	}

	/**
	 * @param afficheDrt
	 *            the afficheDrt to set
	 */
	public void setAfficheDrt(boolean afficheDrt) {
		this.afficheDrt = afficheDrt;
	}

	/**
	 * @return the affichePP
	 */
	public boolean isAffichePP() {
		return affichePP;
	}

	/**
	 * @param affichePP
	 *            the affichePP to set
	 */
	public void setAffichePP(boolean affichePP) {
		this.affichePP = affichePP;
	}

	/**
	 * @return the affichePS
	 */
	public boolean isAffichePS() {
		return affichePS;
	}

	/**
	 * @param affichePS
	 *            the affichePS to set
	 */
	public void setAffichePS(boolean affichePS) {
		this.affichePS = affichePS;
	}

	/**
	 * @return the afficheICD
	 */
	public boolean isAfficheICD() {
		return afficheICD;
	}

	/**
	 * @param afficheICD
	 *            the afficheICD to set
	 */
	public void setAfficheICD(boolean afficheICD) {
		this.afficheICD = afficheICD;
	}

	/**
	 * @return the overEquipes
	 */
	public boolean isOverEquipes() {
		return overEquipes;
	}

	/**
	 * @param overEquipes
	 *            the overEquipes to set
	 */
	public void setOverEquipes(boolean overEquipes) {
		this.overEquipes = overEquipes;
	}

	/**
	 * @return the overPoles
	 */
	public boolean isOverPoles() {
		return overPoles;
	}

	/**
	 * @param overPoles
	 *            the overPoles to set
	 */
	public void setOverPoles(boolean overPoles) {
		this.overPoles = overPoles;
	}

	public Boolean isButtonSavedDisabled() {
		return buttonSave;
	}

	public WOActionResults updateSave() {
		wocomponent().onSuivant();
		EOCommentaires commentairePrin = wocomponent().commentairePrincipal();
		EOCommentaires commentaireDrt = wocomponent().commentaireDrt();
		if (commentairePrin != null && commentairePrin.commentaires() != null) {
			boolean pp = commentairePrin.commentaires() != null;
			buttonSave = !pp;
		}
		if (secondaireValue != null) {
			boolean ss = secondaireValue != null;
			buttonSave = !ss;
		}
		if (commentaireDrt != null && commentaireDrt.commentaires() != null) {
			boolean dd = commentaireDrt.commentaires() != null;
			buttonSave = !dd;
		}
		if (isAfficheICD())
			buttonSave = !isAfficheICD();
		wocomponent().context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
				.messageContainerID(), wocomponent().context());
		return null;
	}

	public NSArray<EOEquipes> equiSecondaires() {
		NSArray<EOEquipes> seconds = EOEquipes.fetchEOEquipeses(edc(),
				EOEquipes.PRINCIPALE.eq("N").and(EOEquipes.TO_PROJET.eq(projet()))
						.and(EOEquipes.TEMVALIDE.eq("O")), null);
		if (seconds.count() != 0)
			equipes = EOStructureUlr.C_STRUCTURE.isNot(
					projet().equipePrincipale()).filtered(seconds);
		ListEquip.setArray(equipes);
		return equipes;
	}

	// Droit sur les differents champs commentaires
	public boolean commentaireResponsableEquipePrincipale() {
		EOStructureUlr equipePp = EOStructureUlr.structurePourcStructure(edc(),
				projet().equipePrincipale());
		if (wocomponent().myApp().newGestionDroitsEnabled()) {
			principal = wocomponent().myAppGDUser().getPprecAutorisationCache()
					.gDPprecSuperUserProjet()
					|| (wocomponent().myAppGDUser().getPprecAutorisationCache()
							.gDPprecResponsableEquipe() && equipePp
							.grpResponsable()
							.equals(wocomponent().myAppGDUser().getNoIndividu()));
		} else {
			principal = wocomponent().myAppJAUser().hasDroitSuperUserProjet()
					|| (wocomponent().myAppJAUser()
							.hasDroitResponsablePrgAccueilProjet() && equipePp
							.grpResponsable()
							.equals(wocomponent().myAppJAUser().getNoIndividu()));
		}
		return principal;
	}

	/*
	 * public boolean commentaireSecondaire() {
	 * autres(EOEquipes.fetchEOEquipeses(edc(),
	 * EOEquipes.PROJET_ID.eq(Integer.valueOf(projet.primaryKey())), null));
	 * boolean respSecond = false; if (otherList.count() != 0) { for (int i = 0;
	 * i < otherList.count(); i++) { EOEquipes eqp = otherList.objectAtIndex(i);
	 * if (eqp.rechUnit().grpResponsable() .equals(user.getNoIndividu())) {
	 * respSecond = user.estRespPrgAcueil(utilisateur) &&
	 * eqp.rechUnit().grpResponsable() .equals(user.getNoIndividu());
	 * pseudoSecondaire = true; } } } secondaire = user.hasDroitTous() ||
	 * (respSecond && pseudoSecondaire); return secondaire; }
	 */

	public boolean commentaireDirecteurPole() {
		Boolean dirPole = false;
		for (int j = 0; j < wocomponent().myPoles().count(); j++) {
			EOStructureUlr pole = (EOStructureUlr) wocomponent().myPoles()
					.objectAtIndex(j);
			if (pole.grpResponsable().equals(wocomponent().noIndividu())) {
				dirPole = wocomponent().estDrtPole()
						&& wocomponent().peutViserProjet();
				// projet().pole().grpResponsabilite().equals(noIndividu());
				pseudoSecondaire1 = true;
			}
		}
		directeur = wocomponent().droitTout() || (dirPole && pseudoSecondaire1);
		return directeur;
	}

	/*
	 * public boolean lesAutresCommentairesEquipes() { overEquipes =
	 * !(equipes.count() == sess().getCommentDg().allObjects() .count()); return
	 * overEquipes; }
	 */

	public boolean lesAutresCommentairesPoles() {
		overPoles = !(wocomponent().myPoles().count() == sess().commentPoleDg()
				.allObjects().count());
		return overPoles;
	}

	// Fin commentaires

	public WOActionResults enregistrer() throws Exception {
		wocomponent().setLeProjetEnCours(projet());
		ERXRedirect redirect = (ERXRedirect) wocomponent().pageWithName(
				ERXRedirect.class.getName());
		try {
			if (principal) {
				secondaire = false;
				directeur = false;
				if (principalValue == null)
					throw new FactoryException("Merci de donner votre avis ");
				sess().setAvisRepPP(
						EOTypref.fetchEOTypref(edc(),
								ERXQ.is(EOTypref.TYPREFLIB_KEY, principalValue)));
				EOCommentaires comment = trtComment.avisCommentairesPP(
						wocomponent(), projet());
				ProcessComment.enregistrer(sess().dataBus(), edc(), comment);
				affichePP = true;
			}
			/*
			 * if (secondaire) { principal = false; directeur = false; if
			 * (sess().getSelectedEquipe1() == null || secondaireValue == null)
			 * throw new FactoryException(
			 * "Merci de sélectionner votre équipe projet et donner votre avis "
			 * ); sess().setAvisRespSec( EOTypref.fetchEOTypref(edc(), ERXQ.is(
			 * EOTypref.TYPREFLIB_KEY, secondaireValue))); EOCommentaires
			 * comment = trtComment.avisCommentairesPS( wocomponent(), projet);
			 * ProcessComment.enregistrer(sess().dataBus(), edc(), comment);
			 * affichePS = true; }
			 */
			if (directeur) {
				principal = false;
				secondaire = false;
				if (sess().getSelectedPole1() == null || directeurValue == null)
					throw new FactoryException(
							"Merci de sélectionner votre pôle et donner votre avis ");
				sess().setAvisDrt(
						EOTypref.fetchEOTypref(edc(),
								ERXQ.is(EOTypref.TYPREFLIB_KEY, directeurValue)));
				EOCommentaires comment = trtComment.avisCommentairesDP(
						wocomponent(), projet());
				ProcessComment.enregistrer(sess().dataBus(), edc(), comment);
				afficheDrt = true;
			}
			if (afficheICD) {
				if (sess().getListIcdSelect() == null
						&& sess().getDateIcd() == null)
					throw new FactoryException(
							"La date et l'avis sont obligatoires pour la validation");
				projet().setToEtat(sess().getListIcdSelect());
				projet().setMajdate(sess().getDateIcd());
				ProcessProjet.enregistrer(sess().dataBus(), edc(), projet());
			}
			// Update de l'état du projet
			if (!afficheICD) {
				visaProject();
			}
			sess().addSimpleInfoMessage(null, "Commentaire Enregistré");
			Accueil home = (Accueil) wocomponent().pageWithName(
					Accueil.class.getName());
			redirect.setComponent(home);
		} catch (FactoryException e) {
			String alertMessage = e.getMessageFormatte();
			ViserProject back = (ViserProject) wocomponent().pageWithName(
					ViserProject.class.getName());
			sess().setAlertMessage(alertMessage);
			redirect.setComponent(back);
			if (e.isBloquant()) {
				if (e.isInformatif()) {
					// Exception contenant un message d'information pour
					// l'utilisateur
					sess().setAlertMessage(alertMessage);
				} else {
					sess().setAlertMessage(e.getLocalizedMessage());
					e.printStackTrace();
					throw e;
				}
			} else {
				sess().setAlertMessage(alertMessage);
			}

		} catch (RuntimeException e1) {
			ViserProject back = (ViserProject) wocomponent().pageWithName(
					ViserProject.class.getName());
			redirect.setComponent(back);
			sess().setAlertMessage(e1.getMessage());
			e1.printStackTrace();
			throw e1;
		}
		return redirect;
	}

	// Desactiver le bouton enregistrer
	public Boolean saveDisabled() {
		Boolean saved = null;
		EOPprec projet = projet();
		saved = ((projet.toEtat().typrefnat().equals(EOTypref.VAR_ETAT_SOUMETTRE) && wocomponent()
				.peutViserProjet()) || (projet.toEtat().typrefnat()
				.equals(EOTypref.VAR_ETAT_SOUMETTRE) && wocomponent()
				.droitTout()))
				|| ((projet.toEtat().typrefnat().equals(EOTypref.VAR_ETAT_VISER) && wocomponent()
						.peutValiderProjet()) || (projet.toEtat().typrefnat()
						.equals(EOTypref.VAR_ETAT_VISER) && wocomponent()
						.droitTout()));
		return saved;
	}

	// Second traitement
	public WOActionResults terminer() throws Exception {
		ERXRedirect redirect = null;
		EOPprec projet = projet();
		try {
			wocomponent().onSuivant();
			// Si l'utilisateur est responsable de l'equipe principal projet
			if (isPrincipal()) {
				setSecondaire(false);
				setDirecteur(false);
				setAfficheICD(false);
				if (wocomponent().valider()) {
					EOCommentaires commentaire = wocomponent()
							.commentairePrincipal();
					EOEditingContext ec = commentaire.editingContext();
					sess().setAvisRepPP(
							EOTypref.fetchEOTypref(
									ec,
									ERXQ.is(EOTypref.TYPREFNAT_KEY,
											commentaire.typrefnat()).and(
											ERXQ.is(EOTypref.TYPREFDOM_KEY,
													commentaire.typrefdom()))));
					commentaire.setToAvis(sess().getAvisRepPP());
					commentaire.setToAvisRelationship(sess().getAvisRepPP());
					commentaire.setToProjet(projet.localInstanceIn(ec));
					commentaire.setProjet(Integer.valueOf(projet.primaryKey()));
					commentaire.setCStructure(projet.equipePrincipale());
					if (ec.hasChanges())
						ec.saveChanges();
					setComPP(commentaire);
					setAffichePP(true);
					sess().setFiltres(null);
					sess().setFiltreProjetFacade(null);
				}
			}
			// Si l'utilisateur est directeur de l'equipe projet
			if (isDirecteur()) {
				setSecondaire(false);
				setPrincipal(false);
				setAfficheICD(false);
				if (wocomponent().valider()) {
					EOCommentaires commentaire = wocomponent().commentaireDrt();
					EOEditingContext ec = commentaire.editingContext();
					sess().setAvisDrt(
							EOTypref.fetchEOTypref(
									ec,
									ERXQ.is(EOTypref.TYPREFNAT_KEY,
											commentaire.typrefnat()).and(
											ERXQ.is(EOTypref.TYPREFDOM_KEY,
													commentaire.typrefdom()))));
					commentaire.setToAvis(sess().getAvisDrt());
					commentaire.setToAvisRelationship(sess().getAvisDrt());
					commentaire.setToProjet(projet.localInstanceIn(ec));
					commentaire.setProjet(Integer.valueOf(projet.primaryKey()));
					commentaire.setCStructure(sess().getSelectedPole1()
							.cStructure());
					if (ec.hasChanges())
						ec.saveChanges();
					setComDrt(commentaire);
					setAfficheDrt(true);
					sess().setFiltres(null);
					sess().setFiltreProjetFacade(null);
				}
			}
			// Si l'utilisateur est le responsable de l'icd
			if (isAfficheICD()) {
				if (wocomponent().valider()) {
					EOEditingContext ec = projet.editingContext();
					projet.setToEtatRelationship(sess().getListIcdSelect()
							.localInstanceIn(ec));
					projet.setToEtat(sess().getListIcdSelect()
							.localInstanceIn(ec));
					projet.setMajdate(sess().getDateIcd());
					if (wocomponent().myApp().batchEnable()) {
						EOTypref pleiade = EOTypref.fetchValider(ec)
								.lastObject();
						projet.setToEtat(pleiade);
						projet.setMajdate(new NSTimestamp());
						sess().addSimpleInfoMessage("PPREC",
								"Projet Validé et en attente de déversement..!");
					} else {
						// Envoie du projet vers pleiade
						ProcessProjet.deverser(sess().dataBus(),
								ERXEC.newEditingContext(), projet);
						// Mentionner que le projet a ete envoye vers pleiade
						// correctement
						sess().addSimpleInfoMessage("PPREC",
								"Projet déversé vers pleiade avec succès..!");
						EOTypref pleiade = EOTypref.fetchProjetPleiade(ec)
								.lastObject();
						projet.setToEtat(pleiade);
					}
					if (ec.hasChanges())
						ec.saveChanges();
					redirect = (ERXRedirect) wocomponent().pageWithName(
							ERXRedirect.class.getName());
					sess().myEnv().setObjectForKey(true, "Refresh");
					redirect.setComponent(wocomponent().home());
					sess().setFiltres(null);
					sess().setFiltreProjetFacade(null);
				}
			}
			// Update de l'état du projet
			if (!isAfficheICD()) {
				visaProject();
			}
			if (isAffichePP() || isAfficheDrt()) {
				redirect = (ERXRedirect) wocomponent().pageWithName(
						ERXRedirect.class.getName());
				sess().setFiltreProjetFacade(null);
				sess().myEnv().setObjectForKey(true, "Refresh");
				redirect.setComponent(wocomponent().home());
			}
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
		} catch (FactoryException e) {
			sess().addSimpleErrorMessage(
					"Une erreur est survenue lors de l'enregistrement en base",
					e);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			e.printStackTrace();
		} catch (RuntimeException e1) {
			sess().addSimpleErrorMessage(
					"Une erreur est survenue lors de l'enregistrement en base",
					e1);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent().myApp()
					.messageContainerID(), wocomponent().context());
			e1.printStackTrace();
		}
		return redirect;
	}

	public WOActionResults precedent() {
		EditNextProject nextPage = (EditNextProject) wocomponent()
				.pageWithName(EditNextProject.class.getName());
		ERXRedirect redirect = (ERXRedirect) wocomponent().pageWithName(
				ERXRedirect.class.getName());
		redirect.setComponent(nextPage);
		return redirect;
	}

	// Verification si le user connecté est responsable d'une equipe
	protected boolean inListGrpRespEquipe(Integer userId) {
		NSArray<EOEquipes> seconds = equipes;
		if (seconds != null) {
			for (int i = 0; i < seconds.count(); i++) {
				EOStructureUlr str = EOStructureUlr.structurePourcStructure(
						ERXEC.newEditingContext(), seconds.objectAtIndex(i)
								.cStructure());
				rechUnitPrj.addObject(str);
			}
			EOQualifier qualifier = EOStructureUlr.GRP_RESPONSABLE.eq(userId);
			NSArray<EOStructureUlr> leResponsable = EOStructureUlr
					.fetchEOStructureUlrs(edc(), qualifier, null);
			for (int j = 0; j < leResponsable.count(); j++) {
				NSArray<EOStructureUlr> equipeSecondaire = EOStructureUlr.C_STRUCTURE
						.containsAll(
								leResponsable.objectAtIndex(j).cStructure())
						.filtered(rechUnitPrj);
				if (!equipeSecondaire.isEmpty()) {
					reponsableEquipeSecondaire.addObject(equipeSecondaire);
				}
			}
			pseudoSecondaire = !reponsableEquipeSecondaire.isEmpty();
			return pseudoSecondaire;
		}
		return false;
	}

	// Verification si le user connecté est responsable d'un pôle
	protected boolean inListGrpRespPole(Integer userID) {
		NSArray<EOStructureUlr> poles = wocomponent().myPoles()
				.immutableClone();
		if (poles != null) {
			for (int i = 0; i < poles.count(); i++) {
				if (!rechUnitPrj1.contains(poles.objectAtIndex(i)))
					rechUnitPrj1.addObject(poles.objectAtIndex(i));
			}
			EOQualifier qualifier = EOStructureUlr.GRP_RESPONSABLE.eq(userID);
			NSArray<EOStructureUlr> leResponsable = EOStructureUlr
					.fetchEOStructureUlrs(edc(), qualifier, null);
			for (int j = 0; j < leResponsable.count(); j++) {
				NSArray<EOStructureUlr> tmp = EOStructureUlr.C_STRUCTURE
						.containsAll(
								leResponsable.objectAtIndex(j).cStructure())
						.filtered(rechUnitPrj1);
				if (!tmp.isEmpty()) {
					directeurPole.addObject(tmp);
				}
			}
			pseudoSecondaire1 = !directeurPole.isEmpty();
			return pseudoSecondaire1;
		}
		return false;
	}

	// Affichage du commentaire du responsable du PRGM principal
	public boolean commPP() {
		EOQualifier qual = ERXQ.is(EOCommentaires.C_STRUCTURE_KEY,
				projet().equipePrincipale())
				.and(EOCommentaires.PROJET.eq(Integer.valueOf(projet()
						.primaryKey())));
		comPP = EOCommentaires.fetchEOCommentaires(edc(), qual);
		affichePP = comPP != null;
		// NSLog.out.appendln(comDrt.avis());
		if (affichePP)
			sess().setAvisComPP(comPP.commentaires());
		return affichePP;
	}

	/*
	 * // Affichage des commentaires des responsables des PRGM secondaires
	 * (s'ils // existent) public boolean commPS() {
	 * inListGrpRespEquipe(noIndividu()); NSMutableArray<EOCommentaires> tmpCom
	 * = new NSMutableArray<EOCommentaires>(); EOCommentaires comment = null;
	 * NSMutableArray<EOEquipes> tmp = new NSMutableArray<EOEquipes>(); if
	 * (equipes.count() == 0) { return affichePS; } for (int i = 0; i <
	 * rechUnitPrj.count(); i++) { EOQualifier qual =
	 * ERXQ.is(EOCommentaires.C_STRUCTURE_KEY,
	 * rechUnitPrj.objectAtIndex(i).primaryKey()).and(
	 * EOCommentaires.PROJET.eq(Integer.valueOf(projet .primaryKey()))); comPS =
	 * EOCommentaires.fetchEOCommentaires(edc(), qual); if (comPS != null) {
	 * tmpCom.addObject(comPS); EOStructureUlr tmp1 =
	 * ListEquip.objectAtIndex(i).rechUnit(); EOStructureUlr tmp2 =
	 * comPS.structures(); if (!tmp1.equals(tmp2)) {
	 * tmp.addObject(ListEquip.objectAtIndex(i)); } } else {
	 * tmp.addObject(ListEquip.objectAtIndex(i)); } }
	 * ListEquip.setArray(tmp.immutableClone());
	 * sess().getCommentDg().setObjectArray(tmpCom.immutableClone()); affichePS
	 * = !sess().getCommentDg().allObjects().isEmpty(); if (affichePS) { comment
	 * = (EOCommentaires) sess().getCommentDg().allObjects() .lastObject(); //
	 * sess().setAvisComPS(comment.commentaires()); } return affichePS; }
	 */

	// Affichage des commentaires des directeur de pôle
	public boolean commDrt() {
		inListGrpRespPole(wocomponent().noIndividu());
		sess().setCommentPoleDg(null);
		NSMutableArray<EOCommentaires> tmpCom = new NSMutableArray<EOCommentaires>();
		EOCommentaires comment = null;
		NSMutableArray<EOStructureUlr> tmp = new NSMutableArray<EOStructureUlr>();
		if (wocomponent().myPoles().count() == 0) {
			return afficheDrt;
		}
		for (int k = 0; k < rechUnitPrj1.count(); k++) {
			EOQualifier qual = EOCommentaires.C_STRUCTURE.eq(
					rechUnitPrj1.objectAtIndex(k).cStructure()).and(
					EOCommentaires.TO_PROJET.eq(projet()));
			comDrt = EOCommentaires.fetchEOCommentaires(edc(), qual);
			if (comDrt != null) {
				if (!tmpCom.contains(comDrt))
					tmpCom.addObject(comDrt);
				EOStructureUlr tmp1 = getListPole().objectAtIndex(k);
				EOStructureUlr tmp2 = EOStructureUlr.structurePourcStructure(
						edc(), comDrt.cStructure());
				if (!tmp1.cStructure().equals(tmp2.cStructure())) {
					tmp.addObject(getListPole().objectAtIndex(k));
				}
			} else {
				tmp.addObject(getListPole().objectAtIndex(k));
			}
		}
		getListPole().setArray(tmp.immutableClone());
		sess().commentPoleDg().setObjectArray(tmpCom.immutableClone());
		afficheDrt = !sess().commentPoleDg().allObjects().isEmpty();
		// NSLog.out.appendln(comDrt.avis());
		if (afficheDrt) {
			comment = (EOCommentaires) sess().commentPoleDg().allObjects()
					.lastObject();
			// sess().setAvisComDP(comment.commentaires());
		}
		return afficheDrt;
	}

	// Fin affichage des commentaires

	// Validation ICD
	public boolean validICD() {
		EOPprec projet = projet();
		afficheICD = (wocomponent().estMembreIcd()
				&& wocomponent().peutValiderProjet() && projet.toEtat()
				.typrefnat().equals(EOTypref.VAR_ETAT_VISER))
				|| (wocomponent().droitTout() && projet.toEtat().typrefnat()
						.equals(EOTypref.VAR_ETAT_VISER));
		if (afficheICD) {
			buttonSave = afficheICD;
			sess().setListIcd(EOTypref.fetchIcd(ERXEC.newEditingContext()));
		}
		return afficheICD;
	}

	public boolean saveButton() {
		if (principal) {
			buttonSave = !affichePP;
		}
		/*
		 * if (secondaire) { // NSLog.out.appendln(equipes.count() == //
		 * sess().getCommentDg().allObjects().count()); buttonSave =
		 * !overEquipes; }
		 */
		if (directeur) {
			buttonSave = !overPoles;
		}
		return buttonSave;
	}

	public void visaProject() throws Exception {
		try {
			EOPprec projet = projet();
			EOEditingContext ec = projet.editingContext();
			EOCommentaires comDrtCompetence = EOCommentaires.createEOCommentaires(ec);
			Boolean sendIcd = null;
			EOStructureUlr poleCompetence = EOStructureUlr
					.structurePourcStructure(ec, projet().poleCompetence());
			//Traitement des externes
			if (!poleCompetence.lcStructure().equals("EXTERNES")) {
				comDrtCompetence = EOCommentaires
						.fetchEOCommentaires(
								ec,
								EOCommentaires.C_STRUCTURE.eq(
										projet.poleCompetence()).and(
										EOCommentaires.TO_PROJET.eq(projet)));
			} else {
				//Traitement des externes sans directeur de pole
				comDrtCompetence.setCStructure(poleCompetence.cStructure());
				comDrtCompetence.setTyprefdom(EOTypref.VAR_ETAT_DOM);
				comDrtCompetence.setTyprefnat(EOTypref.VAR_ETAT_FAVORABLE);
			}
			/*
			 * if (equipes.count() != 0) { if (affichePP && affichePS &&
			 * lastVisaEquipe() && lastVisaPole()) { // Update Etat du projet en
			 * viser EOTypref visa = EOTypref.fetchVisa(edc()).lastObject();
			 * projet().setEtat(visa); projet().setMajdate(new NSTimestamp());
			 * try { ProcessProjet .enregistrer(sess().dataBus(), edc(),
			 * projet()); EOAlerte alerte = EOAlerte.numeroPourProjet(edc(),
			 * Integer.valueOf(projet().primaryKey()));
			 * wocomponent().setLeProjetEnCours(projet());
			 * alerte.sendMailsNouvelleAlerte(sess()); } catch (FactoryException
			 * e) { // TODO: handle exception
			 * sess().setAlertMessage(e.getMessageFormatte()); } } } else {
			 */
			/**
			 * Projet valide si les 2 resp. sont d'accord, puis envoie à pleiade
			 **/
			if (getComPP() != null && comDrtCompetence != null
					&& lastVisaPole()) {
				// Update Etat du projet en viser
				if (getComPP().typrefnat().equals(EOTypref.VAR_ETAT_FAVORABLE)
						&& (projet.poleCompetence().equals(
								comDrtCompetence.cStructure()) && comDrtCompetence
								.typrefnat()
								.equals(EOTypref.VAR_ETAT_FAVORABLE))) {
					if (wocomponent().myApp().batchEnable()) {
						EOTypref pleiade = EOTypref.fetchValider(ec)
								.lastObject();
						projet.setToEtat(pleiade);
						sess().addSimpleInfoMessage("PPREC",
								"Projet Validé et en attente de déversement..!");
					} else {
						// Envoie du projet vers pleiade
						ProcessProjet.deverser(sess().dataBus(),
								ERXEC.newEditingContext(), projet);
						// Mentionner que le projet a ete envoye vers pleiade
						// correctement
						sess().addSimpleInfoMessage("PPREC",
								"Projet déversé vers pleiade avec succès..!");
						EOTypref pleiade = EOTypref.fetchTraiter(ec)
								.lastObject();
						projet.setToEtat(pleiade);
					}
					sendIcd = false;
				} else {
					EOTypref visa = EOTypref.fetchVisa(ec).lastObject();
					projet.setToEtat(visa);
					sendIcd = true;
				}
				projet.setMajdate(new NSTimestamp());
				// ProcessProjet.enregistrer(sess().dataBus(), edc(), projet());
				if (ec.hasChanges())
					ec.saveChanges();
				if (sendIcd) {
					// wocomponent().setLeProjetEnCours(projet());
					EOAlerte alerte = EOAlerte.numeroPourProjet(ec,
							Integer.valueOf(projet.primaryKey()));
					alerte.sendMailsNouvelleAlerte(sess(), projet);
				}

			} else {
				projet.setMajdate(new NSTimestamp());
				if (ec.hasChanges())
					ec.saveChanges();
				sess().addSimpleInfoMessage("PPREC",
						"Avis et commentaire Enregistré");
			}
		} catch (FactoryException e) {
			// TODO: handle exception
			sess().setAlertMessage(e.getMessageFormatte());
		} catch (RuntimeException e1) {
			sess().setAlertMessage(e1.getMessage());
		}
	}

	public void autres(NSArray<EOEquipes> equipes) {
		NSMutableArray<EOEquipes> List = new NSMutableArray<EOEquipes>();
		if (equipes != null && equipes.count() != 0) {
			for (int j = 0; equipes.count() > j; j++) {
				List.addObject(equipes.objectAtIndex(j));
			}
			otherList = EOStructureUlr.C_STRUCTURE.isNot(
					projet().equipePrincipale())
					.filtered(List.immutableClone());
		}
	}

	// Verifie si tous les commentaires des directeurs de pôles sont OK
	protected boolean lastVisaPole() {
		EOCommentaires tmpCom = null;
		NSMutableArray lstPol = new NSMutableArray();
		for (int k = 0; k < wocomponent().myPoles().count(); k++) {
			EOQualifier qual = EOCommentaires.C_STRUCTURE.eq(
					((EOStructureUlr) wocomponent().myPoles().objectAtIndex(k))
							.primaryKey()).and(
					EOCommentaires.PROJET.eq(Integer.valueOf(projet()
							.primaryKey())));
			tmpCom = EOCommentaires.fetchEOCommentaires(edc(), qual);
			if (tmpCom != null)
				lstPol.addObject(EOStructureUlr.structurePourcStructure(edc(),
						tmpCom.cStructure()));
		}
		boolean count = wocomponent().myPoles().count() == lstPol.count();
		return count;
	}

	/*
	 * // Verifie si tous les commentaires des responsables d'équipes sont OK
	 * protected boolean lastVisaEquipe() { EOCommentaires tmpCom = null;
	 * NSMutableArray lstEquip = new NSMutableArray(); for (int k = 0; k <
	 * equipes.count(); k++) { EOQualifier qual = EOCommentaires.C_STRUCTURE.eq(
	 * equipes.objectAtIndex(k).rechUnit().primaryKey()).and(
	 * EOCommentaires.PROJET.eq(Integer.valueOf(projet() .primaryKey())));
	 * tmpCom = EOCommentaires.fetchEOCommentaires(edc(), qual); if (tmpCom !=
	 * null) lstEquip.addObject(tmpCom.structures()); } boolean count =
	 * equipes.count() == lstEquip.count(); return count; }
	 */
}
