/**
 * 
 */
package utt.rec.projet.server.print;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * Classe interne pour la gestion des exports qui permet
 * de s'affranchir des {@link EOEditingContext}
 * 
 *
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class PrintCSVNode extends Object {
	
	private String etat;
	private String projet;
	private String porteur;
	private String contrat;
	private String equipe;
	private String dateCreate;
	
	public PrintCSVNode(String aEtat, String aProjet, String aPorteur, String aContrat, String aEquipe, String aDate) {
		super();
		etat = aEtat;
		projet = aProjet;
		porteur = aPorteur;
		contrat = aContrat;
		equipe = aEquipe;
		dateCreate = aDate;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the projet
	 */
	public String getProjet() {
		return projet;
	}

	/**
	 * @param projet the projet to set
	 */
	public void setProjet(String projet) {
		this.projet = projet;
	}

	/**
	 * @return the porteur
	 */
	public String getPorteur() {
		return porteur;
	}

	/**
	 * @param porteur the porteur to set
	 */
	public void setPorteur(String porteur) {
		this.porteur = porteur;
	}

	/**
	 * @return the contrat
	 */
	public String getContrat() {
		return contrat;
	}

	/**
	 * @param contrat the contrat to set
	 */
	public void setContrat(String contrat) {
		this.contrat = contrat;
	}

	/**
	 * @return the equipe
	 */
	public String getEquipe() {
		return equipe;
	}

	/**
	 * @param equipe the equipe to set
	 */
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	/**
	 * @return the dateCreate
	 */
	public String getDateCreate() {
		return dateCreate;
	}

	/**
	 * @param dateCreate the dateCreate to set
	 */
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrintCSVNode [etat=" + etat + ", projet=" + projet
				+ ", porteur=" + porteur + ", contrat=" + contrat + ", equipe="
				+ equipe + ", dateCreate=" + dateCreate + "]";
	}

}
