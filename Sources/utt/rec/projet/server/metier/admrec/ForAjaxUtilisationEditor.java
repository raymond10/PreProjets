/**
 * 
 */
package utt.rec.projet.server.metier.admrec;

/**
 * @author naneon
 *Utilisation du mat�riel d�j� existant pour chaque p�le
 */
public class ForAjaxUtilisationEditor {
	
	private Integer index;
	private String tauUtil;
	
	public ForAjaxUtilisationEditor(){
		
	}

	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * @return the tauUtil
	 */
	public String getTauUtil() {
		return tauUtil;
	}

	/**
	 * @param tauUtil the tauUtil to set
	 */
	public void setTauUtil(String tauUtil) {
		this.tauUtil = tauUtil;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ForAjaxUtilisationEditor [index=" + index + ", tauUtil="
				+ tauUtil + "]";
	}
	
}
