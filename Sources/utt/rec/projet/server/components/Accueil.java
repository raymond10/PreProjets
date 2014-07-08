package utt.rec.projet.server.components;

import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.cocktail.fwkcktlreportingguiajax.serveur.CktlAbstractReporterAjaxProgress;
import org.cocktail.reporting.CktlAbstractReporter;
import utt.rec.projet.server.components.controler.AccueilCtrl;
import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator.ComparisonException;
import com.webobjects.foundation.NSLog;
import er.extensions.foundation.ERXProperties;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */

@SuppressWarnings("all")
public class Accueil extends MonComposant {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3272133237132637111L;
	public static final Integer DEFAULT_DISPLAY = Integer.valueOf(10);

	private Boolean isOpenFenetreException = Boolean.FALSE;
	private static final String PROJET_CONTAINER = "projetListContainer";
	private static final String NAVBAR_CONTAINER = "navBarContainer";
	private AccueilCtrl ctrl = null;
	private WODisplayGroup projetDg = null;
	private EOUtilisateur appUtilisateur;
	private String simple;
	private String detail;
	private Boolean haveSimple = null;
	private Boolean haveDetail = null;
	// Element indispensable pour l'impression des projet
	private ReporterAjaxProgress simpleProgress;
	private ReporterAjaxProgress detailProgress;
	private String simpleFilename;
	private String detailFilename;
	private CktlAbstractReporter reporterSimple;
	private CktlAbstractReporter reporterDetail;

	public Accueil(WOContext context) throws ComparisonException {
		super(context);
		NSLog.out.appendln("Accueil");
		mySession().reset();
		mySession().resetAll();
		mySession().setNoIndividu(noIndividu());
		simple = "simple";
		haveSimple = true;
		haveDetail = false;
		refreshBatch();
		// Purge m�moire
		// System.gc();
		allProjects();
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public void appendToResponse(WOResponse woresponse, WOContext wocontext) {
		super.appendToResponse(woresponse, wocontext);
		addScriptResource(woresponse, "jscript/wz_tooltip.js", null,
				"FwkCktlWebApp", RESOURCE_TYPE_JSCRIPT, RESOURCE_DEST_END_BODY,
				RESOURCE_FROM_WEB_SERVER_RESOURCES);
		String message = mySession().getAlertMessage();
		if (message != null && message.equals("") == false) {
			String str = "<script language=\"javascript\" type=\"text/javascript\">\n";
			str += "alert(\"" + message + "\");\n";
			str += "</script>";
			woresponse.appendContentString(str);
			mySession().setAlertMessage(null);
		}
		if (onloadJS() != null)
			setOnloadJS(null);
	}

	/**
	 * @return the isOpenFenetreException
	 */
	public Boolean isOpenFenetreException() {
		return isOpenFenetreException;
	}

	/**
	 * @param isOpenFenetreException
	 *            the isOpenFenetreException to set
	 */
	public void setIsOpenFenetreException(Boolean isOpenFenetreException) {
		this.isOpenFenetreException = isOpenFenetreException;
	}

	/**
	 * @return the appUtilisateur
	 */
	public EOUtilisateur getAppUtilisateur() {
		return appUtilisateur;
	}

	/**
	 * @param appUtilisateur
	 *            the appUtilisateur to set
	 */
	public void setAppUtilisateur(EOUtilisateur appUtilisateur) {
		this.appUtilisateur = appUtilisateur;
		if (appUtilisateur != null) {
			mySession().setUtilisateur(appUtilisateur);
		}
	}

	/**
	 * @return the ctrl
	 */
	public AccueilCtrl ctrl() {
		if (ctrl == null)
			ctrl = new AccueilCtrl(this);
		return ctrl;
	}

	/**
	 * @param ctrl
	 *            the ctrl to set
	 */
	public void setCtrl(AccueilCtrl ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * @return the projetDg
	 */
	public WODisplayGroup projetDg() {
		if (projetDg == null) {
			projetDg = new WODisplayGroup();
			projetDg.setNumberOfObjectsPerBatch(DEFAULT_DISPLAY);
		}
		return projetDg;
	}

	/**
	 * @param projetDg
	 *            the projetDg to set
	 */
	public void setProjetDg(WODisplayGroup projetDg) {
		this.projetDg = projetDg;
	}

	protected void refreshBatch() {
		if (projetDg().currentBatchIndex() != 1 || projetDg().batchCount() != 0) {
			projetDg().setCurrentBatchIndex(1);
			projetDg().setNumberOfObjectsPerBatch(0);
		}
	}

	public String projetListContainerId() {
		return PROJET_CONTAINER;
	}

	public String navBarContainerId() {
		return NAVBAR_CONTAINER;
	}

	/**
	 * @return the simple
	 */
	public String getSimple() {
		return simple;
	}

	/**
	 * @param simple
	 *            the simple to set
	 */
	public void setSimple(String simple) {
		this.simple = simple;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail
	 *            the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return the haveSimple
	 */
	public boolean isHaveSimple() {
		return haveSimple;
	}

	/**
	 * @param haveSimple
	 *            the haveSimple to set
	 */
	public void setHaveSimple(boolean haveSimple) {
		this.haveSimple = haveSimple;
	}

	/**
	 * @return the haveDetail
	 */
	public boolean isHaveDetail() {
		return haveDetail;
	}

	/**
	 * @param haveDetail
	 *            the haveDetail to set
	 */
	public void setHaveDetail(boolean haveDetail) {
		this.haveDetail = haveDetail;
	}

	/**
	 * @return the simpleProgress
	 */
	public ReporterAjaxProgress getSimpleProgress() {
		return simpleProgress;
	}

	/**
	 * @param simpleProgress
	 *            the simpleProgress to set
	 */
	public void setSimpleProgress(ReporterAjaxProgress simpleProgress) {
		this.simpleProgress = simpleProgress;
	}

	/**
	 * @return the detailProgress
	 */
	public ReporterAjaxProgress getDetailProgress() {
		return detailProgress;
	}

	/**
	 * @param detailProgress
	 *            the detailProgress to set
	 */
	public void setDetailProgress(ReporterAjaxProgress detailProgress) {
		this.detailProgress = detailProgress;
	}

	/**
	 * @return the reporterSimple
	 */
	public CktlAbstractReporter getReporterSimple() {
		return reporterSimple;
	}

	/**
	 * @param reporterSimple
	 *            the reporterSimple to set
	 */
	public void setReporterSimple(CktlAbstractReporter reporterSimple) {
		this.reporterSimple = reporterSimple;
	}

	/**
	 * @return the reporterDetail
	 */
	public CktlAbstractReporter getReporterDetail() {
		return reporterDetail;
	}

	/**
	 * @param reporterDetail
	 *            the reporterDetail to set
	 */
	public void setReporterDetail(CktlAbstractReporter reporterDetail) {
		this.reporterDetail = reporterDetail;
	}

	/**
	 * @return the simpleFilename
	 */
	public String getSimpleFilename() {
		return simpleFilename;
	}

	/**
	 * @param simpleFilename
	 *            the simpleFilename to set
	 */
	public void setSimpleFilename(String simpleFilename) {
		this.simpleFilename = simpleFilename;
	}

	/**
	 * @return the detailFilename
	 */
	public String getDetailFilename() {
		return detailFilename;
	}

	/**
	 * @param detailFilename
	 *            the detailFilename to set
	 */
	public void setDetailFilename(String detailFilename) {
		this.detailFilename = detailFilename;
	}

	public WOActionResults getHasDetail() {
		WORequest req = context().request();
		String checkThe = (String) req.formValueForKey("checkThe");
		if (checkThe != null && !checkThe.equals("")
				&& checkThe.equals("detail")) {
			haveDetail = true;
			haveSimple = false;
			simple = null;
		} else {
			detail = null;
			haveSimple = true;
			haveDetail = false;
		}
		return doNothing();
	}

	public static class ReporterAjaxProgress extends
			CktlAbstractReporterAjaxProgress implements
			org.cocktail.reporting.jrxml.IJrxmlReportListener {

		public ReporterAjaxProgress(int maximum) {
			super(maximum);
		}

	}

	/**
	 * Decides whether to use editing context unlocking.
	 * 
	 * @return true if ECs should be unlocked after each RR-loop
	 */
	protected boolean useEditingContextUnlocker() {
		return ERXProperties.booleanForKeyWithDefault(
				"er.extensions.ERXApplication.use EditingContextUnlocker",
				false);
	}

	public void allProjects() throws ComparisonException {
		mySession().setListProjet(
				EOPprec.fetchFiltreProjet(edc(), mySession().filtres()));
		ctrl().tamponListProject();
		if (mySession().getBigListTmp() != null) {
			projetDg().setObjectArray(mySession().getBigListTmp());
			projetDg().setNumberOfObjectsPerBatch(DEFAULT_DISPLAY);
			NSArray ordering = new NSArray(new Object[] {EOPprec.SORT_DATEMAJ_DESC});
			projetDg().setSortOrderings(ordering);
			projetDg().updateDisplayedObjects();
		}
		comboxFilter();
	}

	public void comboxFilter() throws ComparisonException {
		// Combox pour filtres
		ctrl().lesNomsProjets(projetDg().allObjects());
		ctrl().lesEtatsProjets(projetDg().allObjects());
		ctrl().lesPorteurProjet(projetDg().allObjects());
		ctrl().lesContratProjet(projetDg().allObjects());
		ctrl().lesEquipeProjet(projetDg().allObjects());
		//sort();
		//projetDg().setCurrentBatchIndex(0);
	}
}