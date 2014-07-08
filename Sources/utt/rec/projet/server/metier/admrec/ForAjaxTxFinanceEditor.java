/**
 * 
 */
package utt.rec.projet.server.metier.admrec;

/**
 * @author naneon
 *Financement du personnel ˆ recruter pour le projet
 */
public class ForAjaxTxFinanceEditor {
	
	private Integer index;
	private String txFinance;
	
	public ForAjaxTxFinanceEditor(){
		
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
	 * @return the txFinance
	 */
	public String getTxFinance() {
		return txFinance;
	}

	/**
	 * @param txFinance the txFinance to set
	 */
	public void setTxFinance(String txFinance) {
		this.txFinance = txFinance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ForAjaxTxFinanceEditor [index=" + index + ", txFinance="
				+ txFinance + "]";
	}
		
}
