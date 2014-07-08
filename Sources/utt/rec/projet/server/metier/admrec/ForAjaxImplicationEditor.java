/**
 * 
 */
package utt.rec.projet.server.metier.admrec;

/**
 * @author naneon
 *Taux d'implication du personnel déjà existant
 */
public class ForAjaxImplicationEditor {
	
	private Integer index;
	private String tempUtil;
	
	public ForAjaxImplicationEditor(){
		
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
	 * @return the tempUtil
	 */
	public String getTempUtil() {
		return tempUtil;
	}

	/**
	 * @param tempUtil the tempUtil to set
	 */
	public void setTempUtil(String tempUtil) {
		this.tempUtil = tempUtil;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ForAjaxImplicationEditor [index=" + index + ", tempUtil="
				+ tempUtil + "]";
	}
	
}
