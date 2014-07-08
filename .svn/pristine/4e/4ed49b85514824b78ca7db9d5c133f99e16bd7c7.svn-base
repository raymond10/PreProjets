package utt.rec.projet.server;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.cocktail.fwkcktldroitsutils.common.metier.EOCompteEmail;
import org.cocktail.fwkcktldroitsutils.common.metier.EOPersonne;
import org.cocktail.fwkcktlgrh.common.GRHApplicationUser;
import org.cocktail.fwkcktlpersonne.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.EORepartAssociation;
import org.cocktail.fwkcktlpersonne.common.metier.EORepartStructure;
import org.cocktail.fwkcktlpersonne.common.metier.EOStructure;
import org.cocktail.fwkcktlpersonne.common.metier.EOVlans;
import org.cocktail.fwkcktlpersonne.common.metier.droits.ApplicationUser;
import org.cocktail.fwkcktlpersonne.common.metier.droits.AutorisationsCache;
import org.cocktail.fwkcktlpersonneguiajax.serveur.controleurs.GroupeAdminFormCtrl.RepartTypeGroupeDGDelegate;

import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXQ;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class PPrecApplicationUser extends ApplicationUser {

	private EOPersonne pers = null;
	public static final String PERS_ID_CURRENT_USER_STORAGE_KEY = "persIdCurrentUser";
	private Boolean peutConsulterPPREC = null;
	private Boolean estCreateur = null;
	private Boolean estPorteur = null;
	private Boolean estImplique = null;

	/**
	 * 
	 */
	public PPrecApplicationUser(Integer persId) {
		// TODO Auto-generated constructor stub
		super(new PprecAutorisationCache(persId));
		pers = EOPersonne.fetchAll(ERXEC.newEditingContext(), "persId", persId,
				null).lastObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cocktail.fwkcktlpersonne.common.metier.droits.ApplicationUser#
	 * getAutorisationsCacheForAppId(java.lang.String)
	 */
	public PprecAutorisationCache getPprecAutorisationCache() {
		// TODO Auto-generated method stub
		return (PprecAutorisationCache) getAutorisationsCacheForAppId("PPREC");
	}

	/**
	 * @return the pers
	 */
	public EOPersonne pers() {
		return pers;
	}

	/**
	 * @param pers
	 *            the pers to set
	 */
	public void setPers(EOPersonne pers) {
		this.pers = pers;
	}

	public static boolean isEtudiant(EOIndividu individu) {
		if (individu == null)
			return false;
		return "ETUDIANT".equals(individu.indQualite());
	}

	public NSArray<String> getEmails() {
		NSMutableArray res = new NSMutableArray();
		for (int i = 0; i < pers().toComptes().count(); ++i) {
			EOCompte compte = (EOCompte) pers().toComptes().objectAtIndex(i);
			NSArray cptEmails = compte.toCompteEmails();
			for (int j = 0; j < cptEmails.count(); ++j) {
				String email = ((EOCompteEmail) cptEmails.objectAtIndex(j))
						.getEmailFormatte();
				if (res.indexOfObject(email) == -1) {
					res.addObject(email);
				}
			}
		}
		return res.immutableClone();
	}

	public String getNomAndPrenom() {
		return pers().persLc() + " " + pers().persLibelle();
	}

	public Integer getNoIndividu() {
		return (((isIndividu()) && (pers().persOrdre() != null)) ? pers()
				.persOrdre() : null);
	}

	public Integer getPersId() {
		return pers().persId();
	}

	public boolean isIndividu() {
		return (!("STR".equals(pers().persType())));
	}
	
	public boolean estCreateur(EOPprec projet) {
		Integer createur = projet.creAuteur();
		Integer persId = getPersId();
		estCreateur = createur.equals(persId);
		return estCreateur;
	}
	
	public boolean estPorteur(EOPprec projet) {
		Integer porteur = projet.porteur();
		Integer noIndividu = getNoIndividu();
		estPorteur = porteur.equals(noIndividu);
		return estPorteur;
	}
	
	public boolean estImplique(EOPprec projet) {
		NSArray<EOPersonnel> persExistants = EOPersonnel.PersonnelPourProjet(projet.editingContext(), Integer.valueOf(projet.primaryKey()));
		estImplique = EOPersonnel.NO_INDIVIDU.eq(getNoIndividu()).filtered(persExistants).count() != 0;
		return estImplique;
	}
	
	//ALL USER
	public boolean peutConsulterPPREC() {
		if (peutConsulterPPREC == null) {
			NSArray<org.cocktail.fwkcktldroitsutils.common.metier.EOCompte> comptes = pers().toComptes(
					ERXQ.inObjects(EOCompte.TO_VLANS_KEY + "."
							+ EOVlans.C_VLAN_KEY, EOVlans.VLAN_P,EOVlans.VLAN_R));
			peutConsulterPPREC = !comptes.isEmpty();
		}
		return peutConsulterPPREC;
	}
/*
	// Le user connecté peut-il utiliser un projet
	public boolean peutUtiliserPprec() {
		boolean use = hasDroitTous()
				|| (peutConsulterPPREC() && peutAdministrerPprec())
				|| hasDroitConsultationProjet() || hasDroitTraiterLesValides();
		return use;
	}

	// Le user connecté peut-il créer un projet
	public boolean peutCreerProject(EOUtilisateur user) {
		sess.setUtilisateur(user);
		boolean create = hasDroitTous() || isInGrhumAccessStructures()
				|| hasDroitCreationProject(user, null);
		return create;
		// && ;
	}

	// Le user connecté peut-il consulter un projet
	public boolean peutConsulterProjet(EOUtilisateur user) {
		sess.setUtilisateur(user);
		boolean read = hasDroitTous() || isInGrhumAccessStructures()
				|| hasDroitConsultationProjet(user, null);
		return read;
	}

	// Le user connecté peut-il modifier un projet
	public boolean peutUpdateProject(EOUtilisateur user) {
		sess.setUtilisateur(user);
		boolean update = hasDroitTous() || isInGrhumAccessStructures()
				|| hasDroitModificationProject(user, null);
		return update;
		//
	}

	// Le user connecté peut-il supprimer un projet
	public boolean peutDeleteProject(EOUtilisateur user) {
		sess.setUtilisateur(user);
		boolean delete = hasDroitTous() || isInGrhumAccessStructures()
				|| hasDroitSuppressionProject(user, null);
		return delete;
		// ;
	}

	// Le user connecté peut-il viser un projet
	public boolean peutViserProject(EOUtilisateur user, EOPprec projet) {
		// if(user != null) {
		sess.setUtilisateur(user);
		boolean visa = false;
		visa = (hasDroitTous() && projet.etat().typrefnat().equals("SO"))
				|| (hasDroitViserProject(user, null)
						&& projet.etat().typrefnat().equals("SO") && (estRespPrgAcueil(user) || estDirecteurPole(user)));
		return visa;
		// } else return false;
	}

	// Le user connecté peut-il valider un projet
	public boolean peutValiderProject(EOUtilisateur user, EOPprec projet) {
		// if( user != null ){
		sess.setUtilisateur(user);
		boolean validate = false;
		validate = (hasDroitTous() && projet.etat().typrefnat().equals("VI"))
				|| (hasDroitValidationProject(user, null)
						&& projet.etat().typrefnat().equals("VI") && estMembreICD(
							user, projet));
		return validate;
		// } else return false;
	}

	// Vérifier si le user est responsable d'un pgrm d'acceuil
	public boolean estRespPrgAcueil(EOUtilisateur user) {
		// if(user != null){
		sess.setUtilisateur(user);
		boolean resp = hasDroitTous()
				|| hasDroitResponsablePrgAcueil(user, null);
		return resp;
		// } else return false;
	}

	// Vérifier si le user connecté est drt de pgrm
	public boolean estDirecteurPole(EOUtilisateur user) {
		// if(user != null){
		sess.setUtilisateur(user);
		boolean director = hasDroitTous() || hasDroitDirecteurPole(user, null);
		return director;
		// } else return false;
	}

	// Vérifier si le user connecté est membre de l'ICD
	public boolean estMembreICD(EOUtilisateur user, EOPprec projet) {
		// if(user != null){
		sess.setUtilisateur(user);
		boolean icd = (hasDroitTous() && !projet.commentaires().isEmpty())
				|| (hasDroitMembreICD(user, null) && !projet.commentaires()
						.isEmpty());
		return icd;
		// } else return false;
	}
	*/
}
