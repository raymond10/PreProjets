package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

public class EORefidx extends _EORefidx {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7179211696230280070L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EORefidx.class);
	private Integer procId;
	
	public EORefidx() {
		// TODO Auto-generated constructor stub
		procId = null;
	}

	/**
	 * @return the procId
	 */
	public Integer getProcId() {
		return procId;
	}

	/**
	 * @param procId the procId to set
	 */
	public void setProcId(Integer procId) {
		this.procId = procId;
	}
}
