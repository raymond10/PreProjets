package utt.rec.projet.server.components.work;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.woextensions.WOLongResponsePage;
import fr.univlr.cri.util.StringCtrl;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class PrintWorking extends WOLongResponsePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7257085294620639648L;

	private static final double REFRESH_INTERVAL = 2.0;
	private PrintWorkingCtrl ctrl;
	private int refreshCount = 0;
	private String strTexteEvolution;

	public PrintWorking(WOContext context) {
		super(context);
		setRefreshInterval(REFRESH_INTERVAL);
		setCachingEnabled(false);
		strTexteEvolution = "Cr&eacute;ation du fichier CSV en cours<br><br>";
	}

	/**
	 * Override of appendToResponse - this method increments the count (the
	 * total number of refreshes) and sets the refresh interval to the passed in
	 * value.
	 */
	public void appendToResponse(WOResponse aResponse, WOContext aContext) {
		setRefreshInterval(REFRESH_INTERVAL);

		if (refreshCount % 5 == 0) {
			strTexteEvolution = StringCtrl.replace(strTexteEvolution,
					"<br>||||", "<br><s>||||</s><br>");
		} else {
			strTexteEvolution += "|";
		}

		refreshCount++;

		super.appendToResponse(aResponse, aContext);
	}

	@Override
	public Object performAction() {
		PrintFactory printFactory = new PrintFactory();
		/*
		 * This class does a setStatus: on the refresh page as it is computing
		 * another way of setting the status would be to implement
		 * -returnStatusPage, and in there, to have the main thread pole this
		 * object (first keep this object as an ivar) for the status. but then
		 * pnc needs a thread safe -status method.
		 */
		printFactory.doPrint();
		return null;
	}

	/**
	 * La classe qui fait le boulot
	 */
	private class PrintFactory {
		public void doPrint() {
			isWorking = true;
			ctrl.generateCsvResponse();
			isWorking = false;
		}
	}

	/**
	 * Method to return the result page when the computation is complete.  This
	 * methods sets the result page, passes all of the computation information,
	 * and then returns the page.
	 */
	public WOComponent pageForResult(Object result) {
		return ctrl.getCaller();
	}
	
	private static boolean isWorking = false;

	public boolean isWorking() {
		return isWorking;
	}

	/**
	 * @return the ctrl
	 */
	public PrintWorkingCtrl getCtrl() {
		return ctrl;
	}

	/**
	 * @param ctrl
	 *            the ctrl to set
	 */
	public void setCtrl(PrintWorkingCtrl ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * @return the strTexteEvolution
	 */
	public String getStrTexteEvolution() {
		return strTexteEvolution;
	}

	/**
	 * @param strTexteEvolution
	 *            the strTexteEvolution to set
	 */
	public void setStrTexteEvolution(String strTexteEvolution) {
		this.strTexteEvolution = strTexteEvolution;
	}

	/**
	 * @return the refreshCount
	 */
	public int getRefreshCount() {
		return refreshCount;
	}

	/**
	 * @param refreshCount
	 *            the refreshCount to set
	 */
	public void setRefreshCount(int refreshCount) {
		this.refreshCount = refreshCount;
	}
}