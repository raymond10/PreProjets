/**
 * 
 */
package utt.rec.projet.server;

import org.cocktail.fwkcktldroitsutils.common.ApplicationUser;
import org.cocktail.fwkcktldroitsutils.common.metier.EOAgentAdresse;
import org.cocktail.fwkcktldroitsutils.common.metier.EOUtilisateur;
import org.cocktail.fwkcktlpersonne.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.metier.EOGrhumParametres;
import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.EOStructure;
import org.cocktail.fwkcktlpersonne.common.metier.EOVlans;
import org.cocktail.fwkcktlpersonne.common.metier.IPersonne;
import org.cocktail.fwkcktlwebapp.common.util.NSArrayCtrl;

import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.utils.FinderUtilisateurFonction;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXQ;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class EnseignantApplicationUser extends ApplicationUser {

	public static final String TYAP_STR_ID_PROJET = "PPREC";
	public static final String FON_ID_SU_PROJET = "PRJSU";
	private Boolean hasDroitSuperUserProjet = null;
	public static final String FON_ID_CREATION_PROJET = "PRJCREA";
	private Boolean hasDroitCreationProjet = null;
	public static final String FON_ID_CONSULTATION_PROJET = "PRJEDIT";
	private Boolean hasDroitConsultationProjet = null;
	public static final String FON_ID_MODIFICATION_PROJET = "PRJMODIF";
	private Boolean hasDroitModificationProjet = null;
	public static final String FON_ID_ABANDONNER_PROJET = "PRJABAN";
	private Boolean hasDroitAbandonnerProjet = null;
	public static final String FON_ID_TRAITEMENT_PROJET = "PRJTT";
	private Boolean hasDroitTraitementProjet = null;
	public static final String FON_ID_VISA_PROJET = "PRJVISA";
	private Boolean hasDroitVisaProjet = null;
	public static final String FON_ID_VALIDATION_PROJET = "PRJVALID";
	private Boolean hasDroitValidationProjet = null;
	public static final String FON_ID_REFUSER_PROJET = "PRJREFUS";
	private Boolean hasDroitRefuserProjet = null;
	public static final String FON_ID_RESPONSABLE_PRGACCUEIL = "PRJRSPGA";
	private Boolean hasDroitResponsablePrgAccueilProjet = null;
	public static final String FON_ID_DIRECTEUR_POLE = "PRJDRPOL";
	private Boolean hasDroitDirecteurPole = null;
	public static final String FON_ID_MEMBRE_ICD = "PRJICD";
	private Boolean hasDroitMembreIcd = null;
	public static final String FON_ID_ACCES_PPREC="PPREC";
	private Boolean hasDroitAccesPprec = null;
	public static final String PERS_ID_CURRENT_USER_STORAGE_KEY = "persIdCurrentUser";

	private IPersonne iPersonne = null;
	private EOAgentAdresse agentAdresse;
	private Boolean hasDroitGrhumCreateur = null;
	private Boolean peutConsulterPPREC = null;
	private Boolean peutAdministrerPprec = null;
	private Boolean estCreateur = null;
	private Boolean estPorteur = null;
	private Boolean estImplique = null;
	private Session sess = new Session();

	public EnseignantApplicationUser(EOEditingContext ec,
			EOUtilisateur utilisateur) {
		super(ec, utilisateur);
		// TODO Auto-generated constructor stub
	}

	public EnseignantApplicationUser(EOEditingContext ec, Integer persId) {
		super(ec, persId);
	}

	public EnseignantApplicationUser(EOEditingContext ec, String tyapStrId,
			EOUtilisateur utilisateur) {
		super(ec, tyapStrId, utilisateur);
	}

	public EnseignantApplicationUser(EOEditingContext ec, String tyapStrId,
			Integer persId) {
		super(ec, tyapStrId, persId);
	}
	
	/**
	 * @return the session
	 */
	public Session getSession() {
		return sess;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.sess = session;
	}

	public IPersonne iPersonne() {
		if ((this.iPersonne == null) && (getPersonne() != null)) {
			if (getPersonne().isStructure()) {
				this.iPersonne = EOStructure.structurePourCode(
						getEditingContext(),
						String.valueOf(getPersonne().persOrdre()));
			} else {
				this.iPersonne = EOIndividu.individuPourNumero(
						getEditingContext(), getPersonne().persOrdre());
			}
		}

		return this.iPersonne;
	}

	public EOAgentAdresse getAgentAdresse() {
		if (this.agentAdresse == null) {
			this.agentAdresse = EOAgentAdresse.fetchByKeyValue(
					getEditingContext(), "noIndividu", getPersonne()
							.persOrdre());
		}
		return this.agentAdresse;
	}

	public boolean hasDroitCompteVisualisation() {
		if ((getPersonne() == null) || ("STR".equals(getPersonne().persType()))) {
			return false;
		}
		boolean droit =  ((hasDroitTous()) || ((getAgentAdresse() != null) && ("O"
				.equals(getAgentAdresse().agtCompte()))));
		return droit;
	}

	public boolean hasDroitCompteModification() {
		if ((getPersonne() == null) || ("STR".equals(getPersonne().persType()))) {
			return false;
		}
		boolean droit =  ((hasDroitTous()) || ((getAgentAdresse() != null) && ("O"
				.equals(getAgentAdresse().agtCompteModifs()))));
		return droit;
	}

	/** @deprecated */
	public boolean hasDroitCompteModifiation() {
		return hasDroitCompteModification();
	}

	public boolean hasDroitTous() {
		if ((getPersonne() == null) || (!(getPersonne().isIndividu()))) {
			return false;
		}
		boolean tmpTout = (hasDroitGrhumCreateur() && (getAgentAdresse() != null) && ("O".equals(getAgentAdresse().agtTout())));
		boolean hasDroitTous =   tmpTout || hasDroitSuperUserProjet();
		return hasDroitTous;
	}

	public boolean hasDroitGrhumCreateur() {
		if (this.hasDroitGrhumCreateur == null) {
			NSArray res = EOGrhumParametres.parametresPourCle(
					getEditingContext(), "GRHUM_CREATEUR");
			NSArray logins = getLogins();
			this.hasDroitGrhumCreateur = Boolean.valueOf(NSArrayCtrl
					.intersectionOfNSArray(res, logins).count() > 0);
		}
		boolean createur =  this.hasDroitGrhumCreateur.booleanValue();
		return createur;
    }
	
	//Acces Pprec
	public boolean hasDroitAccesPprec() {
		if(hasDroitAccesPprec == null)
			hasDroitAccesPprec = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_ACCES_PPREC, null);
		return hasDroitAccesPprec;
	}
	
	public boolean hasDroitSuperUserProjet(){
		//EOQualifier qualifier = ERXQ.is(EORepartStructure.PERS_ID_KEY, getPersId()).and(ERXQ.equals(EORepartStructure.C_STRUCTURE_KEY, Application.app().cStructureAdmin()));
		//boolean adm =  ( EORepartStructure.fetchAll(getEditingContext(), qualifier).count() > 0 );
		if(hasDroitSuperUserProjet == null)
			hasDroitSuperUserProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_SU_PROJET, null);
		return hasDroitSuperUserProjet;
	}
	
	public boolean hasDroitTraitementProjet(){
		//EOQualifier qualifier = ERXQ.is(EORepartStructure.PERS_ID_KEY, getPersId()).and(ERXQ.equals(EORepartStructure.C_STRUCTURE_KEY, Application.app().cStructureCccr()));
		//boolean trt =  ( EORepartStructure.fetchAll(getEditingContext(), qualifier).count() > 0 );
		if(hasDroitTraitementProjet == null)
			hasDroitTraitementProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_TRAITEMENT_PROJET, null);
		return hasDroitTraitementProjet;
	}
	
	public boolean peutConsulterPPREC() {
		if (peutConsulterPPREC == null) {
			NSArray<EOCompte> comptes = iPersonne().toComptes(
					ERXQ.inObjects(EOCompte.TO_VLANS_KEY + "."
							+ EOVlans.C_VLAN_KEY, EOVlans.VLAN_P,EOVlans.VLAN_R));
			peutConsulterPPREC = !comptes.isEmpty();
		}
		return peutConsulterPPREC;
	}

	public boolean peutAdministrerPprec() {
		if (peutAdministrerPprec == null) {
			peutAdministrerPprec = true; // Par defaut tout le monde peut
											// administrer Pprec
			if (Application.app().getCStructuresAccesPprec() != null) {
				peutAdministrerPprec = (Boolean
						.valueOf(hasDroitGrhumCreateur()));
			}
		}
		return peutAdministrerPprec;
	}

	public boolean superUserPprec() {
		return hasDroitTous();
	}
	
	public boolean hasDroitCreationProjet() {
		if(hasDroitCreationProjet == null)
			hasDroitCreationProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_CREATION_PROJET, null);
		return hasDroitCreationProjet;
	}

	public boolean hasDroitModificationProjet() {
		if(hasDroitModificationProjet == null)
			hasDroitModificationProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_MODIFICATION_PROJET, null) && (hasDroitCreationProjet());
		return hasDroitModificationProjet;
	}

	public boolean hasDroitConsultationProjet() {
		if(hasDroitConsultationProjet == null)
			hasDroitConsultationProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_CONSULTATION_PROJET, null);
		return hasDroitConsultationProjet;
	}

	public boolean hasDroitAbandonnerProjet() {
		if(hasDroitAbandonnerProjet == null)
			hasDroitAbandonnerProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_ABANDONNER_PROJET, null);
		return hasDroitAbandonnerProjet;
	}

	public boolean hasDroitValidationProjet() {
		if(hasDroitValidationProjet == null)
			hasDroitValidationProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_VALIDATION_PROJET, null);
		return hasDroitValidationProjet;
	}

	public boolean hasDroitVisaProjet() {
		if(hasDroitVisaProjet == null)
			hasDroitVisaProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_VISA_PROJET, null);
		return hasDroitVisaProjet;
	}

	public boolean hasDroitRefuserProjet() {
		if(hasDroitRefuserProjet == null)
			hasDroitRefuserProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_REFUSER_PROJET, null);
		return hasDroitRefuserProjet;
	}

	public boolean hasDroitResponsablePrgAccueilProjet() {
		if(hasDroitResponsablePrgAccueilProjet == null)
			hasDroitResponsablePrgAccueilProjet = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_RESPONSABLE_PRGACCUEIL, null);
		return hasDroitResponsablePrgAccueilProjet;
	}

	public boolean hasDroitDirecteurPole() {
		if(hasDroitDirecteurPole == null)
			hasDroitDirecteurPole = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_DIRECTEUR_POLE, null);
		return hasDroitDirecteurPole;
	}

	public boolean hasDroitMembreIcd() {
		if(hasDroitMembreIcd == null)
			hasDroitMembreIcd = this.isFonctionAutoriseeByFonID(TYAP_STR_ID_PROJET, FON_ID_MEMBRE_ICD, null);
		return hasDroitMembreIcd;
	}
	

	public boolean estCreateur(EOPprec projet) {
		if(estCreateur == null)
			estCreateur = projet.creAuteur().equals(getPersId());
		return estCreateur;
	}
	
	public boolean estPorteur(EOPprec projet) {
		if(estPorteur == null)
			estPorteur = projet.porteur().equals(getNoIndividu());
		return estPorteur;
	}
	
	public boolean estImplique(EOPprec projet) {
		if(estImplique == null)
			estImplique = EOPersonnel.NO_INDIVIDU.eq(getNoIndividu()).filtered(projet.toPersonnelExistants()).count() != 0;
		return estImplique;
	}

}
