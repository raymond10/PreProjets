/**
 * 
 */
package utt.rec.projet.server.metier.admrec;

/**
 * @author naneon
 *Financement du matériel à utiliser pour le projet
 */
public class ForAjaxFinanceEditor {
	
	private Integer index;
	private String tauFinance;
	
	public ForAjaxFinanceEditor(){
		
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
	 * @return the tauFinance
	 */
	public String getTauFinance() {
		return tauFinance;
	}


	/**
	 * @param tauFinance the tauFinance to set
	 */
	public void setTauFinance(String tauFinance) {
		this.tauFinance = tauFinance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ForAjaxFinanceEditor [index=" + index + ", tauFinance="
				+ tauFinance + "]";
	}
}
