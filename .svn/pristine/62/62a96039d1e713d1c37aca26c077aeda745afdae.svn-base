/**
 * 
 */
package utt.rec.projet.server.components.assistant;

import org.apache.log4j.Logger;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSForwardException;

import er.ajax.AjaxUpdateContainer;

import utt.rec.projet.server.components.MonComposant;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *12 juin 2013
 */
@SuppressWarnings("all")
public abstract class Assistant extends MonComposant {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9157435055297955941L;
	private static final Logger LOG = Logger.getLogger(Assistant.class);
	public static final String MODULES_BDG = "modules";
	public static final String ETAPES_BDG = "etapes";
	public static final String ACTIVE_MODULE_IDX_BDG = "indexModuleActif";
	public static final String ON_FAILURE_UPDTCONTAINER_ID_BDG = "onFailureUpdateContainerID";
	public static final String ACTION_TERMINER_BDG = "terminer";
	public static final String LIBELLE_TERMINER_BDG = "libelleTerminer";
	public static final String ACTION_ANNULER_BDG = "annuler";
	public static final String LIBELLE_ANNULER_BDG = "libelleAnnuler";
	public static final String EDITING_CONTEXT_BDG = "editingContext";
	public static final String UTILISATEUR_PERS_ID_BDG = "utilisateurPersId";
	public static final String ASSISTANT_EDIT_MODE_VALUE = "editMode";

	private NSArray<String> modules;
	private EOEditingContext editingContext;
	private Integer utilisateurPersId;
	
	private IAssistant module;
	public NSArray<String> etapes;
	public String uneEtape;
	
	private Integer indexModuleActif;
	private String libelleAnnuler;
	private String libelleTerminer;
	
	private String failureMessage;
	private String onFailureUpdateContainerID;

	private boolean isEditMode;
	private boolean wantRefreshEtapeModule;

	/**
	 * @param context
	 */
	public Assistant(WOContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public void reset() {
		modules = null;
		editingContext = null;
		utilisateurPersId = null;
		indexModuleActif = null;
		module = null;
		failureMessage = null;
		isEditMode = false;
		setWantRefreshEtapeModule(true);
	}
	
	public String moduleName() {
		String moduleName = null;
		if (modules() != null && modules().count() > 0) {
			moduleName = (String) modules().objectAtIndex(indexModuleActif().intValue());
		}
		return moduleName;
	}

	/**
	 * @return the modules
	 */
	public NSArray<String> modules() {
		modules = (NSArray<String>) valueForBinding(MODULES_BDG);
		return modules;
	}

	/**
	 * @param modules
	 *            the modules to set
	 */
	public void setModules(NSArray<String> modules) {
		this.modules = modules;
	}

	public Integer indexModuleActif() {
		indexModuleActif = (Integer) valueForBinding(ACTIVE_MODULE_IDX_BDG);
		if (indexModuleActif == null && !etapes().isEmpty()) {
		    setIndexModuleActif(0);
		}
		return indexModuleActif;
	}

	/**
	 * @param indexModuleActif
	 *            the indexModuleActif to set
	 */
	public void setIndexModuleActif(Integer indexModuleActif) {
		this.indexModuleActif = indexModuleActif;
		setValueForBinding(indexModuleActif, ACTIVE_MODULE_IDX_BDG);
		if (indexModuleActif() != null && indexModuleActif() == 0) {
			reset();
		}
	}
	
	/**
	 * @return the etapes
	 */
	public NSArray<String> etapes() {
		etapes = (NSArray<String>) valueForBinding(ETAPES_BDG);
		return etapes;
	}

	/**
	 * @param etapes
	 *            the etapes to set
	 */
	public void setEtapes(NSArray<String> etapes) {
		this.etapes = etapes;
	}

	public String styleForEtape() {
		String styleForEtape = null;
		if (etapes().indexOf(uneEtape) == indexModuleActif().intValue()) {
			styleForEtape = "etape selected";
		} else if (etapes().indexOf(uneEtape) < indexModuleActif().intValue()) {
			styleForEtape = "etape passed";
		} else {
			styleForEtape = "etape";
		}
		return styleForEtape;
	}

	public boolean isEtapeActive() {
		return etapes().indexOf(uneEtape) == indexModuleActif().intValue();
	}
	
	public WOActionResults annuler() {
		setFailureMessage(null);
		setIndexModuleActif(null);
		return performParentAction(ACTION_ANNULER_BDG);
	}

	public WOActionResults terminer() {
		WOActionResults result = null;
		try {
			if (module.valider()) {
				result = performParentAction(ACTION_TERMINER_BDG);
				setFailureMessage(null);
				mySession().resetModule();
			} else {
				context().response().setStatus(500);
			}
		} catch (NSForwardException e) {
			LOG.error(e.getMessage(), e);
			context().response().setStatus(500);
			if (e.originalException() != null)
				mySession().addSimpleErrorMessage(
						e.originalException().getMessage(),
						e.originalException());
		} catch (Exception e1) {
			LOG.error(e1.getMessage(), e1);
			context().response().setStatus(500);
			mySession().addSimpleErrorMessage(e1.getMessage(), e1);
		}
		return result;
	}

	public boolean isPrecedentDisabled() {
		boolean boolIndex = indexModuleActif().intValue()<=0;
		//boolean boolModule = module().isPrecedentDisabled();
		boolean precedent = boolIndex;
		//|| boolModule;
		return precedent;
	}
	
	public boolean isPrecedentEnabled() {
		return !isPrecedentDisabled();
	}

	public boolean isSuivantDisabled() {
		int modul = modules().count()-1;
		boolean boolIndex = indexModuleActif().intValue()>=modul;
		//boolean boolModule = module().isSuivantDisabled();
		boolean suivant = boolIndex	;
		//|| boolModule;
		return suivant;
	}
	
	public boolean isSuivantEnabled() {
		return !isSuivantDisabled();
	}

	public boolean isTerminerDisabled() {
		boolean isTerminerDisabled = module().isTerminerDisabled();
		return isTerminerDisabled;
	}
	
	public boolean isTerminerEnabled() {
		return !isTerminerDisabled();
	}
	
	//Bouton precedent
	public WOActionResults precedent() {
		try {
			module().onPrecedent();
			int newIndex = indexModuleActif().intValue()-1;
			if (newIndex>=0) {
				setIndexModuleActif(Integer.valueOf(newIndex));
			}
			context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					myApp().messageContainerID(), context());
		} catch (Exception e) {
			context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					myApp().messageContainerID(), context());
		}
		return null;
	}

	//Bouton suivant
	public WOActionResults suivant() {
		try {
			module().onSuivant();
			if (module().valider()) {
				int newIndex = indexModuleActif().intValue() + 1;
				if (newIndex <= modules().count()-1) {
					setIndexModuleActif(Integer.valueOf(newIndex));
				}
				context().response().setStatus(500);
				AjaxUpdateContainer.updateContainerWithID(
						myApp().messageContainerID(), context());
			} else {
				context().response().setStatus(500);
				AjaxUpdateContainer.updateContainerWithID(
						myApp().messageContainerID(), context());
			}
		} catch (Exception e) {
			mySession().addSimpleErrorMessage("RFCCT", e.toString());
			context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					myApp().messageContainerID(), context());
		}
		return null;
	}
	
	public WOComponent assistant() {
		return this;
	}

	/**
	 * @return the module
	 */
	public IAssistant module() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(IAssistant module) {
		this.module = module;
	}
	
	public String onFailure() {
		String onFailure = null;
		if (failureMessage() != null && (onFailureUpdateContainerID() != null)) {
			onFailure = "function ()" + onFailureUpdateContainerID() + "Update();}";
		}
		return onFailure;
	}

	/**
	 * @return the failureMessage
	 */
	public String failureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
		if (failureMessage != null) {
			mySession().addSimpleErrorMessage("Erreur", failureMessage);
		} //else {
		//	mySession().addSimpleErrorMessage("","");
		//}
	}

	/**
	 * @return the libelleAnnuler
	 */
	public String libelleAnnuler() {
		if (hasBinding(LIBELLE_ANNULER_BDG)) {
			libelleAnnuler = (String) valueForBinding(LIBELLE_ANNULER_BDG);
		} else {
			libelleAnnuler = "Annuler";
		}
		return libelleAnnuler;
	}

	/**
	 * @param libelleAnnuler
	 *            the libelleAnnuler to set
	 */
	public void setLibelleAnnuler(String libelleAnnuler) {
		this.libelleAnnuler = libelleAnnuler;
	}

	/**
	 * @return the libelleTerminer
	 */
	public String libelleTerminer() {
		if (hasBinding(LIBELLE_TERMINER_BDG)) {
			libelleTerminer = (String) valueForBinding(LIBELLE_TERMINER_BDG);
		} else {
			libelleTerminer = "Terminer";
		}
		return libelleTerminer;
	}

	/**
	 * @param libelleTerminer
	 *            the libelleTerminer to set
	 */
	public void setLibelleTerminer(String libelleTerminer) {
		this.libelleTerminer = libelleTerminer;
	}

	/**
	 * @return the editingContext
	 */
	public EOEditingContext editingContext() {
		return (EOEditingContext) valueForBinding(EDITING_CONTEXT_BDG);
	}

	/**
	 * @param editingContext
	 *            the editingContext to set
	 */
	public void setEditingContext(EOEditingContext editingContext) {
		this.editingContext = editingContext;
	}

	/**
	 * @return the utilisateurPersId
	 */
	public Integer utilisateurPersId() {
		if (hasBinding(UTILISATEUR_PERS_ID_BDG)) {
			utilisateurPersId = (Integer) valueForBinding(UTILISATEUR_PERS_ID_BDG);
		}
		return utilisateurPersId;
	}

	/**
	 * @param utilisateurPersId
	 *            the utilisateurPersId to set
	 */
	public void setUtilisateurPersId(Integer utilisateurPersId) {
		this.utilisateurPersId = utilisateurPersId;
		if (hasBinding(UTILISATEUR_PERS_ID_BDG)) {
			setValueForBinding(utilisateurPersId, UTILISATEUR_PERS_ID_BDG);
		}
	}
	
	/**
	 * @return the onFailureUpdateContainerID
	 */
	public String onFailureUpdateContainerID() {
		if (hasBinding(ON_FAILURE_UPDTCONTAINER_ID_BDG)) {
			onFailureUpdateContainerID = stringValueForBinding(ON_FAILURE_UPDTCONTAINER_ID_BDG, null);
		}
		return onFailureUpdateContainerID;
	}

	/**
	 * @param onFailureUpdateContainerID the onFailureUpdateContainerID to set
	 */
	public void setOnFailureUpdateContainerID(String onFailureUpdateContainerID) {
		this.onFailureUpdateContainerID = onFailureUpdateContainerID;
		if (canSetValueForBinding(ON_FAILURE_UPDTCONTAINER_ID_BDG)) {
			setValueForBinding(onFailureUpdateContainerID, ON_FAILURE_UPDTCONTAINER_ID_BDG);
		}
	}

	/**
	 * @return the isEditMode
	 */
	public boolean isEditMode() {
		return isEditMode;
	}

	/**
	 * @param isEditMode
	 *            the isEditMode to set
	 */
	public void setEditMode(boolean isEditMode) {
		this.isEditMode = isEditMode;
	}

	public WOActionResults selectEtape() {
		WOActionResults result = null;
		try {
			if (module.valider()) {
				int newIndex = etapes().indexOf(uneEtape); // TODO : stabiliser
															// en vŽrifiant que
															// uneEtape n'est
															// pas nulle....
				if (newIndex <= modules().count() - 1) {
					setIndexModuleActif(Integer.valueOf(newIndex));
					context().response().setStatus(500);
				}
			} else {
				context().response().setStatus(500);
			}
		} catch (NSForwardException e) {
			LOG.error(e.getMessage(), e);
			context().response().setStatus(500);
			if (e.originalException() != null)
				mySession().addSimpleErrorMessage(
						e.originalException().getMessage(),
						e.originalException());
			AjaxUpdateContainer.updateContainerWithID(
					myApp().messageContainerID(), context());
		} catch (Exception e1) {
			LOG.error(e1.getMessage(), e1);
			context().response().setStatus(500);
			mySession().addSimpleErrorMessage(e1.getMessage(), e1);
			AjaxUpdateContainer.updateContainerWithID(
					myApp().messageContainerID(), context());
		}
		return result;
	}

	/**
	 * @return the wantRefreshEtapeModule
	 */
	public boolean wantRefreshEtapeModule() {
		return wantRefreshEtapeModule;
	}

	/**
	 * @param wantRefreshEtapeModule the wantRefreshEtapeModule to set
	 */
	public void setWantRefreshEtapeModule(boolean wantRefreshEtapeModule) {
		this.wantRefreshEtapeModule = wantRefreshEtapeModule;
	}

}
