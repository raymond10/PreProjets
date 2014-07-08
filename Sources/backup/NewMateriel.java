/**
 * 
 */
package backup;

import utt.rec.projet.server.metier.admrec.EOTypref;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class NewMateriel {
	
	private String matLib;
	private EOStructureUlr matPole;
	private String poleLib;
	private String financeMat;
	private String categorie;
	private EOTypref laCategorie;
	private double coutEstime;
	/**
	 * @return the matLib
	 */
	public String getMatLib() {
		return matLib;
	}
	/**
	 * @param matLib the matLib to set
	 */
	public void setMatLib(String matLib) {
		this.matLib = matLib;
	}
	/**
	 * @return the matPole
	 */
	public EOStructureUlr getMatPole() {
		return matPole;
	}
	/**
	 * @param matPole the matPole to set
	 */
	public void setMatPole(EOStructureUlr matPole) {
		this.matPole = matPole;
	}
	/**
	 * @return the financeMat
	 */
	public String getFinanceMat() {
		return financeMat;
	}
	/**
	 * @param financeMat the financeMat to set
	 */
	public void setFinanceMat(String financeMat) {
		this.financeMat = financeMat;
	}
	/**
	 * @return the poleLib
	 */
	public String getPoleLib() {
		return poleLib;
	}
	/**
	 * @param poleLib the poleLib to set
	 */
	public void setPoleLib(String poleLib) {
		this.poleLib = poleLib;
	}
	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
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
	public EOTypref getLaCategorie() {
		return laCategorie;
	}
	public void setLaCategorie(EOTypref laCategorie) {
		this.laCategorie = laCategorie;
	}
	@Override
	public String toString() {
		return "NewMateriel [matLib=" + matLib + ", matPole=" + matPole
				+ ", poleLib=" + poleLib + ", financeMat=" + financeMat
				+ ", categorie=" + categorie + ", laCategorie=" + laCategorie
				+ ", coutEstime=" + coutEstime + "]";
	}

}
