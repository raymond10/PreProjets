/**
 * 
 */
package utt.rec.projet.server;

import org.cocktail.fwkcktlpersonne.common.metier.droits.AutorisationsCache;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;


import utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *3 juin 2013
 */
public class PprecAutorisationCache extends AutorisationsCache {
	
	private Integer persId;
	private EOEditingContext ec = null;
	private Boolean hasDroitSuperUserProjet = null;
	private Boolean hasDroitCreationProjet = null;
	private Boolean hasDroitConsultationProjet = null;
	private Boolean hasDroitModificationProjet = null;
	private Boolean hasDroitAbandonnerProjet = null;
	private Boolean hasDroitTraitementProjet = null;
	private Boolean hasDroitVisaProjet = null;
	private Boolean hasDroitValidationProjet = null;
	private Boolean hasDroitAccesPprec = null;
	private Boolean hasDroitResponsablePrgAccueilProjet = null;
	private Boolean hasDroitDirecteurPole = null;
	private Boolean hasDroitMembreIcd = null;

	/**
	 * @param appStrId
	 * @param persId
	 */
	public PprecAutorisationCache(String appStrId, Integer persId) {
		super(appStrId, persId);
		// TODO Auto-generated constructor stub
		this.persId = persId;
	}
	
	/**
	 * @param persId
	 */
	public PprecAutorisationCache(Integer persId) {
		super("PPREC", persId);
		// TODO Auto-generated constructor stub
		this.persId = persId;
	}
	
	/**
	 * @return the persId
	 */
	public Integer persId() {
		return persId;
	}

	/**
	 * @param persId the persId to set
	 */
	public void setPersId(Integer persId) {
		this.persId = persId;
	}

	/**
	 * @return the ec
	 */
	public EOEditingContext ec() {
		if(ec == null)
			ec = ERXEC.newEditingContext();
		return ec;
	}

	/**
	 * @param ec the ec to set
	 */
	public void setEc(EOEditingContext ec) {
		this.ec = ec;
	}
	
	//ACCES PPREC
	public boolean gDPprecAcces() {
		if(hasDroitAccesPprec == null)
			hasDroitAccesPprec = hasDroitUtilisationOnFonction("PPREC");
		return hasDroitAccesPprec;
	}

	//SUPER USER
	public boolean gDPprecSuperUserProjet() {
		if(hasDroitSuperUserProjet == null)
			hasDroitSuperUserProjet = hasDroitUtilisationOnFonction("PRJSU");
		return hasDroitSuperUserProjet;
    }
	
	//USER BASIC
	public boolean gDPprecCreationProjet() {
		if(hasDroitCreationProjet == null)
			hasDroitCreationProjet = hasDroitUtilisationOnFonction("PRJCREA");
		return hasDroitCreationProjet;
    }
	
	public boolean gDPprecConsultationProjet() {
		if(hasDroitConsultationProjet == null)
			hasDroitConsultationProjet = hasDroitUtilisationOnFonction("PRJEDIT");
		return hasDroitConsultationProjet;
    }
	
	public boolean gDPprecModificationProjet() {
		if(hasDroitModificationProjet == null)
			hasDroitModificationProjet = hasDroitUtilisationOnFonction("PRJMODIF");
		return hasDroitModificationProjet;
    }
	
	public boolean gDPprecSupressionProjet() {
		if(hasDroitAbandonnerProjet == null)
			hasDroitAbandonnerProjet = hasDroitUtilisationOnFonction("PRJABAN");
		return hasDroitAbandonnerProjet;
    }
	
	public boolean gDPprecTraiterProjet() {
		if(hasDroitTraitementProjet == null)
			hasDroitTraitementProjet = hasDroitUtilisationOnFonction("PRJTT");
		return hasDroitTraitementProjet;
    }
	
	//DIRECTEUR POLE et RESPONSABLE EQUIPE
	public boolean gDPprecDirecteurPole() {
		if(hasDroitDirecteurPole == null)
			hasDroitDirecteurPole = hasDroitUtilisationOnFonction("PRJDRPOL");
		return hasDroitDirecteurPole;
    }
	
	public boolean gDPprecResponsableEquipe() {
		if(hasDroitResponsablePrgAccueilProjet == null)
			hasDroitResponsablePrgAccueilProjet = EOVresponsableEquipeRecherche.isResponsable(ec(), persId());
        return hasDroitResponsablePrgAccueilProjet;
    }
	
	public boolean gDPprecVisaProjet() {
		if(hasDroitVisaProjet == null)
			hasDroitVisaProjet = hasDroitUtilisationOnFonction("PRJVISA");
		return hasDroitVisaProjet;
    }
	
	//MEMBRE ICD
	public boolean gDPprecMembreIcd() {
		if(hasDroitMembreIcd == null)
			hasDroitMembreIcd = hasDroitUtilisationOnFonction("PRJICD");
		return hasDroitMembreIcd;
	}
	
	public boolean gDPprecValiderProjet() {
		if(hasDroitValidationProjet == null)
			hasDroitValidationProjet = hasDroitUtilisationOnFonction("PRJVALID");
		return hasDroitValidationProjet;
	}
}
