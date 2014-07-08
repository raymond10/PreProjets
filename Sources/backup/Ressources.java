/**
 * 
 */
package backup;

import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class Ressources {
	
	private EOStructureUlr poleRh;
	private String poleRhLib;
	private EOIndividuUlr personRh;
	private String personRhLib;
	private String implication;
	private double coutEstime;
	/**
	 * @return the poleRh
	 */
	public EOStructureUlr getPoleRh() {
		return poleRh;
	}
	/**
	 * @param poleRh the poleRh to set
	 */
	public void setPoleRh(EOStructureUlr poleRh) {
		this.poleRh = poleRh;
	}
	/**
	 * @return the personRh
	 */
	public EOIndividuUlr getPersonRh() {
		return personRh;
	}
	/**
	 * @param personRh the personRh to set
	 */
	public void setPersonRh(EOIndividuUlr personRh) {
		this.personRh = personRh;
	}
	/**
	 * @return the implication
	 */
	public String getImplication() {
		return implication;
	}
	/**
	 * @param implication the implication to set
	 */
	public void setImplication(String implication) {
		this.implication = implication;
	}
	/**
	 * @return the poleRhLib
	 */
	public String getPoleRhLib() {
		return poleRhLib;
	}
	/**
	 * @param poleRhLib the poleRhLib to set
	 */
	public void setPoleRhLib(String poleRhLib) {
		this.poleRhLib = poleRhLib;
	}
	/**
	 * @return the personRhLib
	 */
	public String getPersonRhLib() {
		return personRhLib;
	}
	/**
	 * @param personRhLib the personRhLib to set
	 */
	public void setPersonRhLib(String personRhLib) {
		this.personRhLib = personRhLib;
	}
	/**
	 * @return the coutEstime
	 */
	public double getCoutEstime() {
		return coutEstime;
	}
	/**
	 * @param coutEstime the coutEstime to set
	 */
	public void setCoutEstime(double coutEstime) {
		this.coutEstime = coutEstime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ressources [poleRh=" + poleRh + ", poleRhLib=" + poleRhLib
				+ ", personRh=" + personRh + ", personRhLib=" + personRhLib
				+ ", implication=" + implication + ", coutEstime=" + coutEstime
				+ "]";
	}
	
	public String nomComplet() {
		return personRh.nomPatronymique() +" "+personRh.prenom();
	}

}
