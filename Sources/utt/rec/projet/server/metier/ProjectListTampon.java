/**
 * 
 */
package utt.rec.projet.server.metier;

import com.webobjects.foundation.NSTimestamp;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTypref;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ProjectListTampon {
	
	private EOPprec projet;
	private EOTypref etat;
	private EOIndividuUlr porteur;
	private EOTypcontrat contrat;
	private EOStructureUlr equipe;
	private String consulter;
	private String modifier;
	private String supprimer;
	private String viser;
	private String valider;
	private String traiter;
	private String nonTraiter;
	private Boolean update;
	private Boolean delete;
	private NSTimestamp majdate;
	public Session sess;
	
	
	public ProjectListTampon() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the projet
	 */
	public EOPprec getProjet() {
		return projet;
	}


	/**
	 * @return the etat
	 */
	public EOTypref getEtat() {
		return etat;
	}


	/**
	 * @param etat the etat to set
	 */
	public void setEtat(EOTypref etat) {
		this.etat = etat;
	}


	/**
	 * @param projet the projet to set
	 */
	public void setProjet(EOPprec projet) {
		this.projet = projet;
	}


	/**
	 * @return the porteur
	 */
	public EOIndividuUlr getPorteur() {
		return porteur;
	}


	/**
	 * @param porteur the porteur to set
	 */
	public void setPorteur(EOIndividuUlr porteur) {
		this.porteur = porteur;
	}


	/**
	 * @return the contrat
	 */
	public EOTypcontrat getContrat() {
		return contrat;
	}


	/**
	 * @param contrat the contrat to set
	 */
	public void setContrat(EOTypcontrat contrat) {
		this.contrat = contrat;
	}


	/**
	 * @return the equipe
	 */
	public EOStructureUlr getEquipe() {
		return equipe;
	}


	/**
	 * @param equipe the equipe to set
	 */
	public void setEquipe(EOStructureUlr equipe) {
		this.equipe = equipe;
	}


	/**
	 * @return the majdate
	 */
	public NSTimestamp getMajdate() {
		return majdate;
	}


	/**
	 * @param majdate the majdate to set
	 */
	public void setMajdate(NSTimestamp majdate) {
		this.majdate = majdate;
	}


	/**
	 * @return the editer
	 */
	public String getConsulter() {
		return consulter;
	}


	/**
	 * @param editer the editer to set
	 */
	public void setConsulter(String editer) {
		this.consulter = editer;
	}


	/**
	 * @return the modifier
	 */
	public String getModifier() {
		return modifier;
	}


	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}


	/**
	 * @return the supprimer
	 */
	public String getSupprimer() {
		return supprimer;
	}


	/**
	 * @param supprimer the supprimer to set
	 */
	public void setSupprimer(String supprimer) {
		this.supprimer = supprimer;
	}


	/**
	 * @return the viser
	 */
	public String getViser() {
		return viser;
	}


	/**
	 * @param viser the viser to set
	 */
	public void setViser(String viser) {
		this.viser = viser;
	}


	/**
	 * @return the valider
	 */
	public String getValider() {
		return valider;
	}


	/**
	 * @param valider the valider to set
	 */
	public void setValider(String valider) {
		this.valider = valider;
	}
	
	/**
	 * @param delete the delete to set
	 */
	public void setDelete(Boolean delete) {
		this.delete = delete;
	}


	/**
	 * @return the traiter
	 */
	public String getTraiter() {
		return traiter;
	}


	/**
	 * @param traiter the traiter to set
	 */
	public void setTraiter(String traiter) {
		this.traiter = traiter;
	}


	/**
	 * @return the nonTraiter
	 */
	public String getNonTraiter() {
		return nonTraiter;
	}


	/**
	 * @param nonTraiter the nonTraiter to set
	 */
	public void setNonTraiter(String nonTraiter) {
		this.nonTraiter = nonTraiter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectListTampon [projet=" + projet + ", etat=" + etat
				+ ", porteur=" + porteur + ", contrat=" + contrat + ", equipe="
				+ equipe + ", consulter=" + consulter + ", modifier="
				+ modifier + ", supprimer=" + supprimer + ", viser=" + viser
				+ ", valider=" + valider + ", traiter=" + traiter
				+ ", nonTraiter=" + nonTraiter + ", update=" + update
				+ ", delete=" + delete + ", majdate=" + majdate + ", sess="
				+ sess + "]";
	}

}
