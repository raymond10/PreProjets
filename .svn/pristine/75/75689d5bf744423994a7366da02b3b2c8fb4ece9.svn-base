package utt.rec.projet.server.metier.admrec;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.EOStructure;
import org.cocktail.fwkcktlwebapp.server.CktlMailBus;
import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;

import utt.rec.projet.server.Application;
import utt.rec.projet.server.DirectAction;
import utt.rec.projet.server.PPrecApplicationUser;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.metier.grhum.EOCompte;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOPersonne;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.utils.ConstsAlerte;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXEC;
import fr.univlr.cri.util.StringCtrl;
import fr.univlr.cri.webapp.CRIDataBus;
import fr.univlr.cri.webapp.CRIMailBus;

/**
 * @author Raymond NANEON
 * 
 */
@SuppressWarnings("all")
public class EOAlerte extends _EOAlerte {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7910580776159661255L;
	private static Logger log = Logger.getLogger(EOAlerte.class);
	private static boolean modeDebug;
	private static boolean useCas;
	private static CktlMailBus mailBus;
	private static CktlDataBus dataBus;
	@Deprecated
	private static String appUrl;
	private static String appAdminMail;
	private static String domaineName;
	private static EOPprec projet;
	private NSMutableArray structureParticipantes;
	private NSMutableArray persIdViseurs;
	private static EOIndividuUlr demandeur = null;
	private static boolean appUseSam;
	private static String appSamMail;
	private static String mailAdministrationRecherche;

	/**
	 * La boite a random
	 */
	private static Random randommer = new Random();

	public EOAlerte() {
		super();
	}

	public static EOAlerte createEOAlerte(EOEditingContext edc) {
		return (EOAlerte) EOUtilities.createAndInsertInstance(edc,
				_EOAlerte.ENTITY_NAME);
	}

	public EOStructure umrStmr() {
		String cStructure = Application.app().cStrctureUmrStmr();
		return EOStructure.structurePourCode(ERXEC.newEditingContext(),
				cStructure);
	}

	public static void initStaticFields(boolean aModeDebug, boolean aUseCas,
			CktlMailBus aMailBus, CktlDataBus aDataBus, String anAppUrl,
			String anAppAdminMail, String anDomaineName,
			String administrationRecherche) {
		modeDebug = aModeDebug;
		useCas = aUseCas;
		mailBus = aMailBus;
		dataBus = aDataBus;
		appUrl = anAppUrl;
		appAdminMail = anAppAdminMail;
		domaineName = anDomaineName;
		appSamMail = null;
		appUseSam = false;
		mailAdministrationRecherche = administrationRecherche;
		demandeur = null;
	}

	/**
	 * Generation aleatoire d'un hashcode
	 */
	private static String generateRandomHashcode() {
		String hashcode = "";
		for (int i = 0; i < 32; i++)
			hashcode = hashcode.concat((new Character(
					ConstsAlerte.HASH_DICTIONARY.charAt(randommer
							.nextInt(ConstsAlerte.HASH_DICTIONARY.length()))))
					.toString());
		return hashcode;
	}

	public static EOAlerte newEOAlerteInContext(EOEditingContext edc,
			EOPprec proj) {
		projet = proj;
		demandeur = EOIndividuUlr.individuPourNumero(projet.editingContext(),projet.porteur());
		EOAlerte newEOAlerte = EOAlerte.createEOAlerte(edc);
		if (projet != null) {
			newEOAlerte.setToProjetRelationship(projet.localInstanceIn(edc));
			String libelleAlerte = "";
			if (projet.projnomcourt() != null && projet.projnomlong() != null) {
				libelleAlerte = "PrŽ-projet de recherche : "
						+ projet.projnomcourt();
			}
			newEOAlerte.setLibelle(libelleAlerte);
			// mise a jour de la relation alertes
			//projet.addObjectToBothSidesOfRelationshipWithKey(newEOAlerte.localInstanceIn(projet.editingContext()),EOPprec.ALERTES_KEY);
			// projet.pole().addObjectToBothSidesOfRelationshipWithKey(newEOAlerte,
			// EOAlerte.STRUCTURE_ULR_KEY);
			EOStructureUlr pole = EOStructureUlr.structurePourcStructure(edc, projet.poleCompetence());
			newEOAlerte.setCStructure(pole.cStructure());
			newEOAlerte.setDCreation(new NSTimestamp());
			newEOAlerte.setDModification(new NSTimestamp());
		}
		// on genere les hashcode
		newEOAlerte.setPrjHashcodeVis(generateRandomHashcode());
		newEOAlerte.setPrjHashcodeVal(generateRandomHashcode());
		return newEOAlerte;
	}

	public void insertInEditingContext(EOEditingContext ec) {
		if (ec != null) {
			if (ec.globalIDForObject(this) == null) {
				ec.insertObject(this);
			}
		}
	}

	/**
	 * Pour utiliser StringCtrl.replaceWithDico(), il faut recuperer les noms de
	 * variable sans les caraceteres '%'. Cette methode enleve ce caractere
	 * avant et apres.
	 * 
	 * @param varName
	 * @return
	 */
	private String clean(String varName) {
		return StringCtrl.replace(varName, "%", "");
	}

	/**
	 * retourne la liste de tous les email des individu passes en parametre :
	 * liste de <code>EOIndividu</code> a passer directement en parametre a la
	 * methode d'envoi de message. Si l'individu est celui concerne par
	 * l'alerte, alors son adresse sera ignoree.
	 */
	private String formatedEmailsIgnore(NSArray Structures) {
		StringBuffer strMails = new StringBuffer();
		// recup des responsables
		for (int i = 0; i < Structures.count(); i++) {
			Integer str = (Integer) Structures.objectAtIndex(i);
			EOIndividuUlr unIndividu = EOIndividuUlr.individuPourNumero(
					projet.editingContext(), str);
			// on enleve l'individu ciblŽ des destinataires des mail si c'est
			// lui meme
			if (demandeur == unIndividu) {
				continue;
			}

			EOPersonne pers = unIndividu.toPersonne();
			EOCompte cpt = EOCompte.fetchEOComptes(
					unIndividu.editingContext(),
					EOCompte.CPT_DOMAINE.eq(domaineName)
							.and(EOCompte.CPT_EMAIL.isNotNull())
							.and(EOCompte.PERS_ID.eq(pers.persId())), null)
					.lastObject();
			if (cpt != null) {
				String email = cpt.cptEmail() + "@" + cpt.cptDomaine();
				strMails.append(email).append(",");
			}
		}

		// on enleve la derniere virgule
		if (strMails.length() > 0) {
			strMails.deleteCharAt(strMails.length() - 1);
		}
		return strMails.toString();
	}

	/**
	 * Permet d'envoyer a tous les responsables et valideurs un mail pour les
	 * avertir d'un NOUVEL evenement
	 */
	public void sendMailsNouvelleAlerte(Session session, EOPprec proj)
			throws Exception {
		try {
			// ReparamŽtrage des variables lors de la MAJ ou du VISA
			demandeur = null;
			if (projet == null)
				projet = proj;
			if (demandeur == null)
				demandeur = EOIndividuUlr.individuPourNumero(
						projet.editingContext(),projet.porteur());
			uStructure(projet);
			// viseurs();
			String emailsToResponsables = null;
			String emailsToValideurs = null;
			String titre = "";
			String contentVisa = "";
			String contentVal = "";
			Hashtable dico = new Hashtable();
			Hashtable dicoBidon = new Hashtable();
			dico.put(clean(ConstsAlerte.VAR_SPEC), "");
			dico.put(clean(ConstsAlerte.VAR_CONTENT_DELEGATION), "");

			// construire le dico de visa
			if (isAlerteVisa()) {
				emailsToResponsables = formatedEmailsIgnore(structureParticipantes()
						.immutableClone());
				String linkVisa = DirectAction.buildVisaLink(session, Integer.valueOf(projet.primaryKey()));
				dico.put(clean(ConstsAlerte.VAR_DEMANDEUR),
						demandeur.fullname());
				dico.put(clean(ConstsAlerte.VAR_LIBELLE_ALERTE), libelle());
				dico.put(clean(ConstsAlerte.VAR_APP_URL),
						linkVisa);
				dico.put(clean(ConstsAlerte.VAR_VERBE), "viser");
				dico.put(clean(ConstsAlerte.VAR_HASH), prjHashcodeVis());
				// envoi aux responsables
				if (emailsToResponsables.length() > 0) {

					titre = ConstsAlerte.PREFIX_MAIL_TITLE_DEMANDE + "visa : "
							+ libelle();
					titre = StringCtrl.replace(titre, "\n", " "); // on met
																	// titre a
																	// plat
					contentVisa = StringCtrl
							.replaceWithDico(
									StringCtrl.replaceWithDico(
											StringCtrl
													.replaceWithDico(
															appUseSam ? ConstsAlerte.PATTERN_NEW_ALERT_SAM
																	: ConstsAlerte.PATTERN_NEW_ALERT_VIS,
															dico), dicoBidon),
									dicoBidon);
					// en mode test, on prefixe le message et le destinataire
					// devient l'administrateur
					if (modeDebug) {
						String emailCc = null;
						titre = "MODE TEST: " + titre;
						contentVisa = StringCtrl.replace(
								StringCtrl.replace(StringCtrl.replace(
										ConstsAlerte.PREFIX_CONTENT_DEBUG,
										ConstsAlerte.VAR_ADMIN_MAIL,
										appAdminMail),
										ConstsAlerte.VAR_MAIL_TO,
										emailsToResponsables),
								ConstsAlerte.VAR_MAIL_CC, emailCc)
								+ contentVisa;
						emailsToResponsables = appAdminMail;
					}

					EOPersonne pers = demandeur.toPersonne();
					EOCompte cpt = EOCompte.fetchEOComptes(
							session.editingContext(),
							EOCompte.CPT_DOMAINE.eq(domaineName)
									.and(EOCompte.CPT_EMAIL.isNotNull())
									.and(EOCompte.PERS_ID.eq(pers.persId())),
							null).lastObject();
					String emailFrom = null;
					if (cpt != null)
						emailFrom = cpt.cptEmail() + "@" + cpt.cptDomaine();
					mailBus.sendMail(emailFrom, emailsToResponsables, null,
							titre, contentVisa);
				}
			}
			if (isAlerteValidate()) {
				String linkValidate = DirectAction.buildValidateLink(session, Integer.valueOf(projet.primaryKey()));
				emailsToValideurs = mailAdministrationRecherche;
				dico.put(clean(ConstsAlerte.VAR_DEMANDEUR),
						demandeur.fullname());
				dico.put(clean(ConstsAlerte.VAR_LIBELLE_ALERTE), libelle());
				// dico.put(clean(ConstsAlerte.VAR_APP_URL), appUrl);
				dico.put(clean(ConstsAlerte.VAR_APP_URL),
						linkValidate);
				dico.put(clean(ConstsAlerte.VAR_VERBE), "valider");
				dico.put(clean(ConstsAlerte.VAR_HASH), prjHashcodeVal());
				// envoi aux viseurs
				if (emailsToValideurs.length() > 0) {
					titre = ConstsAlerte.PREFIX_MAIL_TITLE_DEMANDE
							+ "validation : " + libelle();
					titre = StringCtrl.replace(titre, "\n", " "); // on met
																	// titre a
																	// plat
					contentVal = StringCtrl
							.replaceWithDico(
									StringCtrl.replaceWithDico(
											StringCtrl
													.replaceWithDico(
															appUseSam ? ConstsAlerte.PATTERN_NEW_ALERT_SAM
																	: ConstsAlerte.PATTERN_NEW_ALERT_VAL,
															dico), dicoBidon),
									dicoBidon);
					// en mode test, on prefixe le message et le destinataire
					// devient l'administrateur
					if (modeDebug) {
						String emailCc = null;
						titre = "MODE TEST: " + titre;
						contentVal = StringCtrl.replace(StringCtrl.replace(
								StringCtrl.replace(
										ConstsAlerte.PREFIX_CONTENT_DEBUG,
										ConstsAlerte.VAR_ADMIN_MAIL,
										appAdminMail),
								ConstsAlerte.VAR_MAIL_TO, emailsToValideurs),
								ConstsAlerte.VAR_MAIL_CC, emailCc)
								+ contentVal;
						emailsToValideurs = appAdminMail;
					}

					EOPersonne pers = demandeur.toPersonne();
					EOCompte cpt = EOCompte.fetchEOComptes(
							session.editingContext(),
							EOCompte.CPT_DOMAINE.eq(domaineName)
									.and(EOCompte.CPT_EMAIL.isNotNull())
									.and(EOCompte.PERS_ID.eq(pers.persId())),
							null).lastObject();
					String emailFrom = null;
					if (cpt != null)
						emailFrom = cpt.cptEmail() + "@" + cpt.cptDomaine();
					mailBus.sendMail(emailFrom, emailsToValideurs, null, titre,
							contentVal);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			sendMailResponsableIntrouvable();
			throw e;
		}

	}

	/**
	 * Determiner si l'alerte est pour un visa
	 * 
	 * @return
	 */
	private boolean isAlerteVisa() {
		return projet.toEtat().typrefnat().equals(EOTypref.VAR_ETAT_SOUMETTRE);
	}

	/**
	 * Determiner si l'alerte est pour une validation
	 * 
	 * @return
	 */
	private boolean isAlerteValidate() {
		return projet.toEtat().typrefnat().equals(EOTypref.VAR_ETAT_VISER);
	}

	/**
	 * Retourne le lien de connexion ˆ l'application, tenant de
	 */
	private String appURLConnexionDirecte(Session session) {
		String url = session.app().getApplicationURL(session.context())
				+ "/wa/default";
		/*if(useCas)
			url = session.app().getApplicationURL(session.context())
				+ "/wa/default";*/
		return url;
	}

	/**
	 * Envoi de mail d'erreur au demandeur car aucun responsable n'a ete trouve
	 * Copie a l'administrateur
	 */
	private void sendMailResponsableIntrouvable() {
		String emailFrom = appAdminMail;
		EOPersonne pers = demandeur.toPersonne();
		EOCompte cpt = EOCompte.fetchEOComptes(
				pers.editingContext(),
				EOCompte.CPT_DOMAINE.eq(domaineName)
						.and(EOCompte.CPT_EMAIL.isNotNull())
						.and(EOCompte.PERS_ID.eq(pers.persId())), null)
				.lastObject();
		String emailTo = null;
		if (cpt != null)
			emailTo = cpt.cptEmail() + "@" + cpt.cptDomaine();
		String emailCc = appAdminMail;
		String title = ConstsAlerte.ALERT_MAIL_SUBJECT_PREFIX
				+ "Erreur de l'application";
		String content = ConstsAlerte.TXT_ERREUR_RESPONSABLE;
		if (modeDebug) {
			title = "MODE TEST: " + title;
			content = StringCtrl.replace(StringCtrl.replace(
					ConstsAlerte.PREFIX_CONTENT_DEBUG,
					ConstsAlerte.VAR_ADMIN_MAIL, appAdminMail),
					ConstsAlerte.VAR_MAIL_TO, emailTo)
					+ content;
			emailTo = appAdminMail;
			emailCc = null;
		}
		mailBus.sendMail(emailFrom, emailTo, emailCc, title, content);
		// envoi a l'admin avec la trace de l'exception
	}

	// Poles pour visa
	protected void uStructure(EOPprec proj) {
		EOEditingContext ec = proj.editingContext();
		EOStructureUlr pole = EOStructureUlr.structurePourcStructure(ec, proj.poleCompetence());
		EOStructureUlr principal = EOStructureUlr.structurePourcStructure(ec, proj.equipePrincipale());
		// Directeur de pole porteur
		if (pole.grpResponsable() != null
				&& !structureParticipantes().contains(
						pole.grpResponsable())) {
			structureParticipantes().addObject(pole.grpResponsable());
		}
		// Responsable Equipe principale
		if (principal.grpResponsable() != null
				&& !structureParticipantes().contains(principal.grpResponsable()))
			structureParticipantes().addObject(principal.grpResponsable());

/*		// Condition si Equipe principale est STMR
		if (proj.equipePrincipale().equals(umrStmr())) {
			NSArray personnel = proj.personnelExistants(EOPersonnel.TEMVALIDE
					.eq("O"));
			NSArray posteRh = proj.posteRhs(EOPosterh.TEMVALIDE.eq("O"));
			NSArray materiels = proj.materiels(EOResmat.TEMVALIDE.eq("O"));
			if (personnel != null && personnel.count() != 0) {
				for (int i = 0; i < personnel.count(); i++) {
					EOPersonnel pers = (EOPersonnel) personnel.objectAtIndex(i);
					EOStructureUlr polePers = EOStructureUlr.structurePourcStructure(pers.editingContext(), pers.cStructure());
					if (polePers.grpResponsable() != null
							&& !structureParticipantes().contains(
									polePers.grpResponsable())) {
						structureParticipantes().addObject(
								polePers.grpResponsable());
					}
				}
			}

			if (posteRh != null && posteRh.count() != 0) {
				for (int i = 0; i < posteRh.count(); i++) {
					EOPosterh post = (EOPosterh) posteRh.objectAtIndex(i);
					EOStructureUlr polePost = EOStructureUlr.structurePourcStructure(post.editingContext(), post.cStructure());
					if (polePost.grpResponsable() != null
							&& !structureParticipantes().contains(
									polePost.grpResponsable())) {
						structureParticipantes().addObject(
								polePost.grpResponsable());
					}
				}
			}

			if (materiels != null && materiels.count() != 0) {
				for (int i = 0; i < materiels.count(); i++) {
					EOResmat matos = (EOResmat) materiels.objectAtIndex(i);
					EOStructureUlr poleMat = EOStructureUlr.structurePourcStructure(matos.editingContext(), matos.cStructure());
					if (poleMat.grpResponsable() != null
							&& !structureParticipantes().contains(
									poleMat.grpResponsable())) {
						structureParticipantes().addObject(
								poleMat.grpResponsable());
					}
				}
			}

			
			 * NSArray tmpResp = EOEquipes.fetchEOEquipeses( editingContext(),
			 * EOEquipes.PROJET_ID.eq(pk).and( EOEquipes.TEMVALIDE.eq("O")),
			 * null); if (tmpResp != null && tmpResp.count() != 0) { for (int i
			 * = 0; i < tmpResp.count(); i++) { EOEquipes ekp = (EOEquipes)
			 * tmpResp.objectAtIndex(i); if (ekp.rechUnit().grpResponsable() !=
			 * null && !structureParticipantes().contains(ekp.rechUnit()
			 * .grpResponsable())) {
			 * structureParticipantes().addObject(ekp.rechUnit()
			 * .grpResponsable()); } } }
			 
		}*/
	}

	/*
	 * protected void viseurs() { if (user.drResp().grpResponsable() != null)
	 * persIdViseurs().addObject(user.drResp().grpResponsable()); if
	 * (user.admResp().grpResponsable() != null)
	 * persIdViseurs().addObject(user.admResp().grpResponsable());
	 * 
	 * }
	 */

	/**
	 * @return the structureParticipantes
	 */
	public NSMutableArray structureParticipantes() {
		if (structureParticipantes == null)
			structureParticipantes = new NSMutableArray();
		return structureParticipantes;
	}

	/**
	 * @param structureParticipantes
	 *            the structureParticipantes to set
	 */
	public void setStructureParticipantes(NSMutableArray structureParticipantes) {
		this.structureParticipantes = structureParticipantes;
	}

	/**
	 * @return the persIdViseurs
	 */
	public NSMutableArray persIdViseurs() {
		if (persIdViseurs == null)
			persIdViseurs = new NSMutableArray();
		return persIdViseurs;
	}

	/**
	 * @param persIdViseurs
	 *            the persIdViseurs to set
	 */
	public void setPersIdViseurs(NSMutableArray persIdViseurs) {
		this.persIdViseurs = persIdViseurs;
	}

	public static EOAlerte numeroPourAlerte(EOEditingContext edc,
			Integer idAlerte) {
		if (idAlerte == null)
			return null;
		return fetchEOAlerte(edc, "idAlerte", idAlerte);
	}

	public static EOAlerte numeroPourProjet(EOEditingContext edc,
			Integer idProjet) {
		if (idProjet == null)
			return null;
		return fetchEOAlerte(edc, "idProjet", idProjet);
	}
}
