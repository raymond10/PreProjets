package utt.rec.projet.server.components;

import org.apache.log4j.Logger;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.components.controler.UpdateNextProjectCtrl;
import utt.rec.projet.server.metier.admrec.EOGemateriel;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOCategorie;
import utt.rec.projet.server.metier.admrec.EOTypref;
import utt.rec.projet.server.metier.admrec.EOVtyprhcm;
import utt.rec.projet.server.metier.admrec.ForAjaxFinanceEditor;
import utt.rec.projet.server.metier.admrec.ForAjaxImplicationEditor;
import utt.rec.projet.server.metier.admrec.ForAjaxTxFinanceEditor;
import utt.rec.projet.server.metier.admrec.ForAjaxUtilisationEditor;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOPersonne;
import utt.rec.projet.server.metier.grhum.EORepartStructure;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation.ValidationException;

import er.ajax.CktlAjaxUtils;
import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.appserver.ERXRedirect;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class UpdateNextProject extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5613458835039335706L;
	private static final String UPDATENEXT_CONTAINER_ID = "updateNextContainer";
	String onloadJS = null;
	public static final Logger LOG = Logger.getLogger(UpdateNextProject.class);
	private NSMutableArray persRh = new NSMutableArray();
	private NSMutableArray poleRh = new NSMutableArray();
	private NSMutableArray posta = new NSMutableArray();
	private NSMutableArray mata = new NSMutableArray();
	private NSMutableArray mato = new NSMutableArray();
	private NSMutableArray personnels = new NSMutableArray();
	private NSMutableArray posteRh = new NSMutableArray();
	private NSMutableArray resMat = new NSMutableArray();
	private NSMutableArray newResMat = new NSMutableArray();
	public WOContext ctxt;
	private NSMutableDictionary persTxKey = new NSMutableDictionary();
	private NSMutableDictionary poleKey = new NSMutableDictionary();
	private NSMutableDictionary poleMatKey = new NSMutableDictionary();
	private NSMutableDictionary txFinanRecrue = new NSMutableDictionary();
	private NSMutableDictionary txImplication = new NSMutableDictionary();
	private NSMutableDictionary txUtilisation = new NSMutableDictionary();
	private NSMutableDictionary txFinancement = new NSMutableDictionary();
	private NSMutableDictionary dispPoleRecrue = new NSMutableDictionary();
	private NSMutableDictionary dispPoleMat = new NSMutableDictionary();
	public ForAjaxTxFinanceEditor recrueFinanEditor = new ForAjaxTxFinanceEditor();
	public ForAjaxImplicationEditor ImplicationEditor = new ForAjaxImplicationEditor();
	public ForAjaxUtilisationEditor utilsationEditor = new ForAjaxUtilisationEditor();
	public ForAjaxFinanceEditor financeEditor = new ForAjaxFinanceEditor();
	public int count = -1;
	public int anotherCount = -1;
	public int watch = 0;
	public ERXDisplayGroup persDg;
	public String errorPoste;
	private UpdateNextProjectCtrl ctrl;
	private String contexte, problematique, objectif, methodologie;

	public UpdateNextProject(WOContext context) {
		super(context);
		NSLog.out.appendln("UpdateNextProject");
		ctxt = context;
		mySession().setListEtat1(EOTypref.fetchEtatsFetchSpec(edc()));
		mySession().setPoleList(EOStructureUlr.fetchPoles(edc()));
		mySession().setListCategories(EOVtyprhcm.fetchAllEOVtyprhcms(edc(),
				EOVtyprhcm.TYPRHCM_LIB.ascs()));
		// mySession().setListCategMteriels(EOPfmateriel.fetchAllEOPfmateriels(edc(),
		// EOPfmateriel.PFMAT_LIB.ascs()));
		// mySession().setListLibMateriels(EOGemateriel.fetchEOGemateriels(edc(),
		// EOGemateriel.GEMAT_TEM.eq("AC"), EOGemateriel.GEMAT_LIB.ascs()));
		ctrl().setProjet(mySession().getProjectSelected());
		ctrl().intFields();
		ctrl().personnelProjet();
		ctrl().posteProjet();
		ctrl().materielProjet();
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
        PprecHelpers.insertStylesSheet(context, response);
		String message = mySession().getAlertMessage();
		if (message != null && message.equals("") == false) {
			String str = "<script language=\"javascript\" type=\"text/javascript\">\n";
			str += "alert(\"" + message + "\");\n";
			str += "</script>";
			response.appendContentString(str);
			mySession().setAlertMessage(null);
		}
		if (onloadJS() != null)
			setOnloadJS(null);
	}

	@Override
	public void takeValuesFromRequest(WORequest aRequest, WOContext aContext) {
		super.takeValuesFromRequest(aRequest, aContext);
	}

	public String updateNextContainerId() {
		return UPDATENEXT_CONTAINER_ID;
	}

	/**
	 * @return the ctrl
	 */
	public UpdateNextProjectCtrl ctrl() {
		if(ctrl == null)
			ctrl = new UpdateNextProjectCtrl(this);
		return ctrl;
	}

	/**
	 * @param ctrl
	 *            the ctrl to set
	 */
	public void setCtrl(UpdateNextProjectCtrl ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * @return the persRh
	 */
	public NSMutableArray getPersRh() {
		return persRh;
	}

	/**
	 * @param persRh
	 *            the persRh to set
	 */
	public void setPersRh(NSMutableArray persRh) {
		this.persRh = persRh;
	}

	/**
	 * @return the poleRh
	 */
	public NSMutableArray getPoleRh() {
		return poleRh;
	}

	/**
	 * @param poleRh
	 *            the poleRh to set
	 */
	public void setPoleRh(NSMutableArray poleRh) {
		this.poleRh = poleRh;
	}

	/**
	 * @return the posta
	 */
	public NSMutableArray getPosta() {
		return posta;
	}

	/**
	 * @param posta
	 *            the posta to set
	 */
	public void setPosta(NSMutableArray posta) {
		this.posta = posta;
	}

	/**
	 * @return the mata
	 */
	public NSMutableArray getMata() {
		return mata;
	}

	/**
	 * @param mata
	 *            the mata to set
	 */
	public void setMata(NSMutableArray mata) {
		this.mata = mata;
	}

	/**
	 * @return the mato
	 */
	public NSMutableArray getMato() {
		return mato;
	}

	/**
	 * @param mato
	 *            the mato to set
	 */
	public void setMato(NSMutableArray mato) {
		this.mato = mato;
	}

	// ---> AjaxInPlaceEditor Methods and actions <--- //

	// people from one pole **/
	public void saveOnImplication() {
	}

	// Person to recruit **/

	public void saveOnTxFinance() {
	}

	// Equipments from poles

	public void saveOnUtilisation() {
	}

	// Material to get

	public void saveOnFinance() {

	}

	public void saveOnDuree() {

	}

	// Dictionnaries of AjaxInPlaceEditor Components

	/**
	 * @return the persTxKey
	 */
	public NSMutableDictionary getPersTxKey() {
		return persTxKey;
	}

	/**
	 * @param persTxKey
	 *            the persTxKey to set
	 */
	public void setPersTxKey(NSMutableDictionary persTxKey) {
		this.persTxKey = persTxKey;
	}

	/**
	 * @return the poleKey
	 */
	public NSMutableDictionary getPoleKey() {
		return poleKey;
	}

	/**
	 * @param poleKey
	 *            the poleKey to set
	 */
	public void setPoleKey(NSMutableDictionary poleKey) {
		this.poleKey = poleKey;
	}

	/**
	 * @return the poleMatKey
	 */
	public NSMutableDictionary getPoleMatKey() {
		return poleMatKey;
	}

	/**
	 * @param poleMatKey
	 *            the poleMatKey to set
	 */
	public void setPoleMatKey(NSMutableDictionary poleMatKey) {
		this.poleMatKey = poleMatKey;
	}

	/**
	 * @return the txImplication
	 */
	public NSMutableDictionary getTxImplication() {
		return txImplication;
	}

	/**
	 * @param txImplication
	 *            the txImplication to set
	 */
	public void setTxImplication(NSMutableDictionary txImplication) {
		this.txImplication = txImplication;
	}

	/**
	 * @return the txFinanRecrue
	 */
	public NSMutableDictionary getTxFinanRecrue() {
		return txFinanRecrue;
	}

	/**
	 * @param txFinanRecrue
	 *            the txFinanRecrue to set
	 */
	public void setTxFinanRecrue(NSMutableDictionary txFinanRecrue) {
		this.txFinanRecrue = txFinanRecrue;
	}

	/**
	 * @return the txUtilisation
	 */
	public NSMutableDictionary getTxUtilisation() {
		return txUtilisation;
	}

	/**
	 * @param txUtilisation
	 *            the txUtilisation to set
	 */
	public void setTxUtilisation(NSMutableDictionary txUtilisation) {
		this.txUtilisation = txUtilisation;
	}

	/**
	 * @return the txFinancement
	 */
	public NSMutableDictionary getTxFinancement() {
		return txFinancement;
	}

	/**
	 * @param txFinancement
	 *            the txFinancement to set
	 */
	public void setTxFinancement(NSMutableDictionary txFinancement) {
		this.txFinancement = txFinancement;
	}

	/**
	 * @return the dispPoleRecrue
	 */
	public NSMutableDictionary getDispPoleRecrue() {
		return dispPoleRecrue;
	}

	/**
	 * @param dispPoleRecrue
	 *            the dispPoleRecrue to set
	 */
	public void setDispPoleRecrue(NSMutableDictionary dispPoleRecrue) {
		this.dispPoleRecrue = dispPoleRecrue;
	}

	/**
	 * @return the dispPoleMat
	 */
	public NSMutableDictionary getDispPoleMat() {
		return dispPoleMat;
	}

	/**
	 * @param dispPoleMat
	 *            the dispPoleMat to set
	 */
	public void setDispPoleMat(NSMutableDictionary dispPoleMat) {
		this.dispPoleMat = dispPoleMat;
	}

	// End of dictionnaries

	/**
	 * @return the contexte
	 */
	public String getContexte() {
		return contexte;
	}

	/**
	 * @param contexte
	 *            the contexte to set
	 */
	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	/**
	 * @return the problematique
	 */
	public String getProblematique() {
		return problematique;
	}

	/**
	 * @param problematique
	 *            the problematique to set
	 */
	public void setProblematique(String problematique) {
		this.problematique = problematique;
	}

	/**
	 * @return the objectif
	 */
	public String getObjectif() {
		return objectif;
	}

	/**
	 * @param objectif
	 *            the objectif to set
	 */
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	/**
	 * @return the methodologie
	 */
	public String getMethodologie() {
		return methodologie;
	}

	/**
	 * @param methodologie
	 *            the methodologie to set
	 */
	public void setMethodologie(String methodologie) {
		this.methodologie = methodologie;
	}

	/**
	 * Making Data
	 */

	// Builting data for people grid
	public NSArray personData(EOPersonnel aPerson) {
		if (!persRh.contains(aPerson)) {
			persRh.addObject(aPerson);
		}
		return persRh.mutableClone();
	}

	public NSArray poleData(EOStructureUlr aPole) {
		if (!poleRh.contains(aPole)) {
			poleRh.add(aPole);
		}
		return poleRh.mutableClone();
	}

	// Construction of the data for the positions grid
	@SuppressWarnings("unchecked")
	public NSMutableArray postesData(EOPosterh aPoste) {
		if (!posta.contains(aPoste)) {
			posta.add(aPoste);
		}
		return posta;
	}

	// Construction of the data for equipments from one pole
	public NSMutableArray materielsData(EOResmat aMateriel) {
		if (!mata.contains(aMateriel)) {
			mata.add(aMateriel);
		}
		return mata.mutableClone();
	}

	// Construction of the data for new hardware to buy
	public NSMutableArray nouvoMatosData(EOResmat aNouvoMatos) {
		if (!mato.contains(aNouvoMatos)) {
			mato.add(aNouvoMatos);
		}
		return mato.mutableClone();
	}

	/** End **/
	/*
	 * // ---> Action method <--- //
	 * 
	 * // Refresh the list of people from one pole public WOActionResults
	 * refreshPerson() { mySession().setListInPerson(new
	 * ERXDisplayGroup<EOVrhcmval>()); NSMutableArray<EORepartStructure>
	 * tinyRepart = new NSMutableArray<EORepartStructure>();
	 * NSMutableArray<EOPersonne> dic = new NSMutableArray<EOPersonne>();
	 * EORepartStructure rePart = new EORepartStructure(); Object obj = new
	 * Object(); Object objs = new Object(); NSMutableArray<EOIndividuUlr>
	 * tinyIndiv = new NSMutableArray<EOIndividuUlr>(); if
	 * (mySession().getSelectRhPole() != null) {
	 * tinyRepart.addObject(mySession().getSelectRhPole().repartStructures( null,
	 * new NSArray(EORepartStructure.SORT_PERS_ASC), false)); for (int i = 0; i
	 * < tinyRepart.count(); i++) { obj = tinyRepart.objectAtIndex(i); for (int
	 * j = 0; j < ((NSArray) obj).count(); j++) { rePart = (EORepartStructure)
	 * ((NSArray<EORepartStructure>) obj) .objectAtIndex(j);
	 * dic.addObject(rePart.eoPersonneFK()); } } for (int k = 0; k <
	 * dic.count(); k++) { objs = dic.objectAtIndex(k).eoIndividuUlrsFk(); for
	 * (int l = 0; l < ((NSArray<EOIndividuUlr>) objs).count(); l++) {
	 * tinyIndiv.addObject(((NSArray<EOIndividuUlr>) objs) .objectAtIndex(l)); }
	 * } mySession().getListInPerson().setObjectArray(tinyIndiv.mutableClone());
	 * mySession().getListInPerson().setSortOrderings( new
	 * NSArray<EOSortOrdering>(EOIndividuUlr.SORT_NOM_ASC));
	 * mySession().getListInPerson().qualifyDisplayGroup(); } return doNothing(); }
	 */
	/*
	 * Adding person to project resource
	 * 
	 * public WOActionResults ajoutPerson() { try { if
	 * (mySession().getSelectRhPole() == null) throw new
	 * ValidationException("Veuillez sélectionner un pôle"); if
	 * (mySession().personneDg() == null) { mySession().setPersonneDg(new
	 * ERXDisplayGroup()); } mySession().setRh(new EOPersonnel()); if
	 * (mySession().getSelectRhPerson() == null) throw new ValidationException(
	 * "Veuillez sélectionner une personne"); EOPersonnel perso =
	 * EOPersonnel.fetchEOPersonnel( ed,
	 * EOPersonnel.PROJET.eq(mySession().getProjectSelected()).and(
	 * EOPersonnel.INDIVIDU_ULR .eq(mySession().getSelectRhPerson())
	 * .and(EOPersonnel.POLE.eq(mySession() .getSelectRhPole()))
	 * .and(EOPersonnel.TEMVALIDE.eq("N")))); if (perso != null) {
	 * perso.setTemvalide("O"); perso.setTempsuitl("5");
	 * mySession().personneDg().setObjectArray(personData(perso)); } else {
	 * mySession().getRh().setIndividuUlr(mySession().getSelectRhPerson());
	 * mySession().getRh().setNomPersonnel(
	 * mySession().getSelectRhPerson().nomPatronymique());
	 * mySession().getRh().setPole(mySession().getSelectRhPole());
	 * mySession().getRh().setNomStructure(
	 * mySession().getSelectRhPole().lcStructure());
	 * mySession().getRh().setTempsuitl("5"); mySession().getRh().setTemvalide("O");
	 * mySession().getRh().setCoutestime(new Double("0"));
	 * mySession().personneDg().setObjectArray( personData(mySession().getRh())); //
	 * Add line to set row and the String value
	 * ImplicationEditor.setIndex(mySession().personneDg().allObjects() .count()
	 * - 1); ImplicationEditor.setTempUtil("1"); // Here I use NSDictionnary,
	 * it's perfect txImplication.put(ImplicationEditor.getIndex(),
	 * ImplicationEditor.getTempUtil()); } if
	 * (mySession().personneDg().batchCount() == 0) {
	 * mySession().personneDg().setNumberOfObjectsPerBatch(5); } } catch
	 * (ValidationException e) { LOG.warn(e); mySession()().addSimpleErrorMessage(
	 * "Estimation des ressources humaines", e); } catch (Exception e) {
	 * LOG.error(e); throw new NSForwardException(e); } return null; }
	 */

	/*
	 * Adding a pole containing people to a project resource
	 * 
	 * public WOActionResults ajoutPole() { if (mySession().getPoleDg() == null) {
	 * mySession().setPoleDg(new ERXDisplayGroup()); } if (mySession().getSelectRhPole()
	 * != null) { mySession().getPoleDg().setObjectArray(
	 * poleData(mySession().getSelectRhPole())); // Add line to set row and the
	 * String value ImplicationEditor
	 * .setIndex(mySession().getPoleDg().allObjects().count() - 1);
	 * ImplicationEditor.setTempUtil("1"); // Here I use NSDictionnary, it's
	 * perfect to keep index and the // String // value for InPlaceEditor
	 * txImplication.put(ImplicationEditor.getIndex(),
	 * ImplicationEditor.getTempUtil()); if (mySession().getPoleDg().batchCount() ==
	 * 0) { mySession().getPoleDg().setNumberOfObjectsPerBatch(5); } } return null;
	 * }
	 */

	/*
	 * Recruiting a new person
	 * 
	 * public WOActionResults ajoutPoste() { try { errorPoste = null; if
	 * (mySession().getSelectRecruePole() == null && mySession().getCategSelect() ==
	 * null) throw new ValidationException(
	 * "Veuillez séléctionner un pôle et une catégorie"); if
	 * (mySession().postesDg() == null) { mySession().setPostesDg(new
	 * ERXDisplayGroup()); } mySession().setRecrue(new EOPosterh()); if
	 * (mySession().getNouvoPostes() == null) throw new
	 * ValidationException("Veuillez renseigner un profil"); EOPosterh posy =
	 * EOPosterh .fetchEOPosterh( ed, EOPosterh.PROJET
	 * .eq(mySession().getProjectSelected()) .and(EOPosterh.POLE.eq(mySession()
	 * .getSelectRecruePole())) .and(EOPosterh.POSTELIB.eq(mySession()
	 * .getNouvoPostes())) .and(EOPosterh.TEMVALIDE.eq("N"))); if (posy != null)
	 * { posy.setTemvalide("O"); posy.setTxfinancement("5");
	 * mySession().postesDg().setObjectArray(postesData(posy)); } else {
	 * mySession().getRecrue().setPostelib(mySession().getNouvoPostes());
	 * mySession().getRecrue().setPole(mySession().getSelectRecruePole());
	 * mySession().getRecrue().setNomStructure(
	 * mySession().getSelectRecruePole().lcStructure());
	 * mySession().getRecrue().setTxfinancement("5");
	 * mySession().getRecrue().setDureeRecrue(mySession().getDureeProjet());
	 * mySession().getRecrue().setCategorieRh(mySession().getCategSelect());
	 * mySession().getRecrue().setTemvalide("O");
	 * mySession().postesDg().setObjectArray( postesData(mySession().getRecrue()));
	 * // Add line to set row and the String value
	 * recrueFinanEditor.setIndex(mySession().postesDg().allObjects() .count() -
	 * 1); recrueFinanEditor.setTxFinance("1"); // Here I use NSDictionnary,
	 * it's perfect to keep index and // the // String value for InPlaceEditor
	 * txFinanRecrue.put(recrueFinanEditor.getIndex(),
	 * recrueFinanEditor.getTxFinance()); } if
	 * (mySession().postesDg().batchCount() == 0) {
	 * mySession().postesDg().setNumberOfObjectsPerBatch(5); }
	 * mySession().setNouvoPostes(null); } catch (ValidationException e) {
	 * LOG.warn(e); mySession()().addSimpleErrorMessage(
	 * "Estimation des personnes à recruter", e); } catch (Exception e) {
	 * LOG.error(e); throw new NSForwardException(e); } return null; }
	 * 
	 * 
	 * Selected pole for person to recruit public String lePoleSelectioner() {
	 * count++; if (mySession().postesDg().allObjects().count() != 0 &&
	 * mySession().postesDg().displayedObjects()
	 * .indexOf(mySession().getPoleRecruRepetition()) != -1) {
	 * NSLog.out.appendln("display :" +
	 * (mySession().postesDg().displayedObjects().count() - 1));
	 * NSLog.out.appendln("allObject :" +
	 * (mySession().postesDg().allObjects().count() - 1)); if
	 * (mySession().postesDg().allObjects().count() - 1 == mySession()
	 * .postesDg().displayedObjects().count() - 1) { if
	 * (dispPoleRecrue.containsKey(mySession().postesDg() .displayedObjects()
	 * .indexOf(mySession().getPoleRecruRepetition()))) {
	 * NSLog.out.appendln("indexOf :" + mySession().postesDg().displayedObjects()
	 * .indexOf(mySession().getPoleRecruRepetition())); anotherCount++; return
	 * (String) dispPoleRecrue.get(mySession().postesDg() .displayedObjects()
	 * .indexOf(mySession().getPoleRecruRepetition())); } } } return
	 * "We have problem here"; }
	 */

	/*
	 * Adding new equipement to project resource
	 * 
	 * public WOActionResults ajoutMatos() { if (mySession().getSelectMatPole() !=
	 * null && mySession().getCategMatSelect() != null) { if
	 * (mySession().poleMaterielsDg() == null) { mySession().setPoleMaterielsDg(new
	 * ERXDisplayGroup()); } mySession().setMatos(new EOResmat()); if
	 * (mySession().getMatosExistant() != null) { EOResmat mt =
	 * EOResmat.fetchEOResmat( ed, EOResmat.PROJET
	 * .eq(mySession().getSelectedProjet()) .and(EOResmat.POLE.eq(mySession()
	 * .getSelectMatPole())) .and(EOResmat.MATLIB.eq(mySession()
	 * .getMatosExistant())) .and(EOResmat.TEMVALIDE.eq("N"))); if (mt != null)
	 * { mt.setTemvalide("O"); mt.setCategorie(mySession().getCategMatSelect());
	 * mt.setMatutil("5"); mt.setMatexist("O");
	 * mySession().poleMaterielsDg().setObjectArray( materielsData(mt)); } else {
	 * mySession().getMatos().setMatlib(mySession().getMatosExistant());
	 * mySession().getMatos().setPole(mySession().getSelectMatPole());
	 * mySession().getMatos().setNomStructure(
	 * mySession().getSelectMatPole().lcStructure()); mySession().getMatos()
	 * .setCategorie(mySession().getCategMatSelect());
	 * mySession().getMatos().setMatutil("5"); mySession().getMatos().setMatexist("O");
	 * mySession().getMatos().setTemvalide("O");
	 * mySession().poleMaterielsDg().setObjectArray(
	 * materielsData(mySession().getMatos())); // Add line to set row and the String
	 * value utilsationEditor.setIndex(mySession().poleMaterielsDg()
	 * .allObjects().count() - 1); utilsationEditor.setTauUtil("1"); //
	 * Utilisation de dictionnaire pour le changement
	 * txUtilisation.put(utilsationEditor.getIndex(),
	 * utilsationEditor.getTauUtil()); } if
	 * (mySession().poleMaterielsDg().batchCount() == 0) {
	 * mySession().poleMaterielsDg().setNumberOfObjectsPerBatch(5); } } else {
	 * mySession().addSimpleInfoMessage( "Estimation des ressources matériels",
	 * "Veuillez renseigner un matériel"); } } else {
	 * mySession().addSimpleErrorMessage( "Estimation des ressources matériels",
	 * "Veuillez sélectionner un pôle et une catégorie"); }
	 * mySession().setMatosExistant(null); return null; }
	 */

	/*
	 * Buying new harware
	 * 
	 * public WOActionResults ajouNouvoMatos() { if
	 * (mySession().getSelectNewMatPole() != null && mySession().getCategMatSelect0() !=
	 * null) { if (mySession().materielsDg() == null) {
	 * mySession().setMaterielsDg(new ERXDisplayGroup()); } mySession().setNewMatos(new
	 * EOResmat()); if (mySession().getNouvoMatos() != null) { EOResmat mt =
	 * EOResmat.fetchEOResmat( ed, EOResmat.PROJET
	 * .eq(mySession().getSelectedProjet()) .and(EOResmat.POLE.eq(mySession()
	 * .getSelectMatPole())) .and(EOResmat.MATLIB.eq(mySession()
	 * .getMatosExistant())) .and(EOResmat.TEMVALIDE.eq("N"))); if (mt != null)
	 * { mt.setTemvalide("O"); mt.setCategorie(mySession().getCategMatSelect0());
	 * mt.setTxfinancement("5"); mt.setMatexist("N");
	 * mySession().poleMaterielsDg().setObjectArray( materielsData(mt)); } else {
	 * mySession().getNewMatos().setMatlib(mySession().getNouvoMatos());
	 * mySession().getNewMatos() .setPole(mySession().getSelectNewMatPole());
	 * mySession().getNewMatos().setNomStructure(
	 * mySession().getSelectNewMatPole().lcStructure());
	 * mySession().getNewMatos().setCategorie( mySession().getCategMatSelect0());
	 * mySession().getNewMatos().setTxfinancement("5");
	 * mySession().getNewMatos().setTemvalide("O");
	 * mySession().getNewMatos().setMatexist("N");
	 * mySession().materielsDg().setObjectArray(
	 * nouvoMatosData(mySession().getNewMatos())); // Add line to set row and the
	 * String value financeEditor.setIndex(mySession().materielsDg()
	 * .allObjects().count() - 1); financeEditor.setTauFinance("1"); // Here I
	 * use NSDictionnary, it's perfect to keep index and // the // String value
	 * for InPlaceEditor txFinancement.put(financeEditor.getIndex(),
	 * financeEditor.getTauFinance()); } if
	 * (mySession().materielsDg().batchCount() == 0) {
	 * mySession().materielsDg().setNumberOfObjectsPerBatch(5); } } else {
	 * mySession().addSimpleInfoMessage(
	 * "Estimation des principaux matériels à acquerir",
	 * "Veuillez renseigner le matériel à acquérir"); } } else {
	 * mySession().addSimpleErrorMessage(
	 * "Estimation des principaux matériels à acquerir",
	 * "Veuillez sélectionner le pôle et la catégorie"); }
	 * mySession().setNouvoMatos(null); return null; }
	 * 
	 * public String lePoleASelectioner() { count++; if
	 * (mySession().materielsDg().allObjects().count() != 0 &&
	 * mySession().materielsDg().displayedObjects()
	 * .indexOf(mySession().getPoleNewMatRep()) != -1) { NSLog.out
	 * .appendln("display :" + (mySession().materielsDg().displayedObjects()
	 * .count() - 1)); NSLog.out.appendln("allObject :" +
	 * (mySession().materielsDg().allObjects().count() - 1)); if
	 * (mySession().materielsDg().allObjects().count() - 1 == mySession()
	 * .materielsDg().displayedObjects().count() - 1) { if (dispPoleMat
	 * .containsKey(mySession().materielsDg() .displayedObjects()
	 * .indexOf(mySession().getPoleNewMatRep()))) { NSLog.out.appendln("indexOf :" +
	 * mySession().materielsDg().displayedObjects()
	 * .indexOf(mySession().getPoleNewMatRep())); anotherCount++; return (String)
	 * dispPoleMat.get(mySession().materielsDg() .displayedObjects()
	 * .indexOf(mySession().getPoleNewMatRep())); } } } return
	 * "We have problem here"; }
	 */

	// Comment from one of the secondary team responsible project

	public WOActionResults nouvoCommentaire() {
		return doNothing();
	}

	// End comment

	// Action
	public WOActionResults backProject() {
		mySession().retourMaj = true;
		String vide = "<p><br data-mce-bogus=\"1\"></p>";
		UpdateProject previousPage = (UpdateProject) pageWithName(UpdateProject.class
				.getName());
		if (contexte != null && !contexte.equals("") && !contexte.equals(vide))
			mySession().setContexte(contexte);
		if (problematique != null && !problematique.equals("")
				&& !problematique.equals(vide))
			mySession().setProblematik(problematique);
		if (objectif != null && !objectif.equals("") && !objectif.equals(vide))
			mySession().setObjectifs(objectif);
		if (methodologie != null && !methodologie.equals("")
				&& !methodologie.equals(vide))
			mySession().setMetho(methodologie);
		ERXRedirect redirect = (ERXRedirect) pageWithName(ERXRedirect.class
				.getName());
		redirect.setComponent(previousPage);
		return redirect;
	}

	public WOActionResults nextPage() {
		SoumiProject nextPage = (SoumiProject) pageWithName(SoumiProject.class
				.getName());
		return nextPage;
	}

	public WOActionResults saveRawData() {
		return doNothing();
	}

	// End Action

	// ---> End action Method <--- //

	// ---> Management of dynamic table page <--- //

	/** Sort on dynamic table **/
	private void setTriPers(String name) {
		NSArray<EOSortOrdering> oldArray = persDg.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		persDg.setSortOrderings(new NSArray<EOSortOrdering>(newOrdering));
		persDg.qualifyDisplayGroup();
	}

	private void setSorOrdPers(String name) {
		NSArray<EOSortOrdering> oldArray = mySession().personneDg()
				.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		mySession().personneDg().setSortOrderings(
				new NSArray<EOSortOrdering>(newOrdering));
		mySession().personneDg().qualifyDisplayGroup();
	}

	private void setSorOrdProfil(String name) {
		NSArray<EOSortOrdering> oldArray = mySession().postesDg()
				.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		mySession().postesDg().setSortOrderings(
				new NSArray<EOSortOrdering>(newOrdering));
		mySession().postesDg().qualifyDisplayGroup();
	}

	private void sorOrdMatPoles(String name) {
		NSArray<EOSortOrdering> oldArray = mySession().poleMaterielsDg()
				.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		mySession().poleMaterielsDg().setSortOrderings(
				new NSArray<EOSortOrdering>(newOrdering));
		mySession().poleMaterielsDg().qualifyDisplayGroup();
	}

	private void sorOrdNewMatPoles(String name) {
		NSArray<EOSortOrdering> oldArray = mySession().materielsDg()
				.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		mySession().materielsDg().setSortOrderings(
				new NSArray<EOSortOrdering>(newOrdering));
		mySession().materielsDg().qualifyDisplayGroup();
	}

	public void sortByPole() {
		ctrl().tabDataArray().setSorOrdPers("nomStructure");
	}

	public void sortByNom() {
		ctrl().tabDataArray().setSorOrdPers("nomPersonnel");
	}

	public void sortByRecruePole() {
		ctrl().tabDataArray().setSorOrdProfil("postelib");
	}

	public void sortByProfil() {
		ctrl().tabDataArray().setSorOrdProfil("nomStructure");
	}

	public void sortByMatPole() {
		ctrl().tabDataArray().sorOrdMatPoles("nomStrcuture");
	}

	public void sortByMatLib() {
		ctrl().tabDataArray().sorOrdMatPoles("eoGrandEquipement");
	}

	public void sortByNewMatPole() {
		ctrl().tabDataArray().sorOrdNewMatPoles("nomStrcuture");
	}

	public void sortByNewMatLib() {
		ctrl().tabDataArray().sorOrdNewMatPoles("eoGrandEquipement");
	}

	/** Next and previous on the dynamic table **/

	public void nextBatch() {
		mySession().personneDg().displayNextBatch();
		mySession().personneDg().setSelectedObject(null);
	}

	public void previousBatch() {
		mySession().personneDg().displayPreviousBatch();
		mySession().personneDg().setSelectedObject(null);
	}

	public void nextBatch1() {
		mySession().postesDg().displayNextBatch();
		mySession().postesDg().setSelectedObject(null);
	}

	public void previousBatch1() {
		mySession().postesDg().displayPreviousBatch();
		mySession().postesDg().setSelectedObject(null);
	}

	public void nextBatch2() {
		mySession().poleMaterielsDg().displayNextBatch();
		mySession().poleMaterielsDg().setSelectedObject(null);
	}

	public void previousBatch2() {
		mySession().poleMaterielsDg().displayPreviousBatch();
		mySession().poleMaterielsDg().setSelectedObject(null);
	}

	public void nextBatch3() {
		mySession().materielsDg().displayNextBatch();
		mySession().materielsDg().setSelectedObject(null);
	}

	public void previousBatch3() {
		mySession().materielsDg().displayPreviousBatch();
		mySession().materielsDg().setSelectedObject(null);
	}

	/**
	 * @return the personnels
	 */
	public NSMutableArray getPersonnels() {
		return personnels;
	}

	/**
	 * @param personnels
	 *            the personnels to set
	 */
	public void setPersonnels(NSMutableArray personnels) {
		this.personnels = personnels;
	}

	/**
	 * @return the posteRh
	 */
	public NSMutableArray getPosteRh() {
		return posteRh;
	}

	/**
	 * @param posteRh
	 *            the posteRh to set
	 */
	public void setPosteRh(NSMutableArray posteRh) {
		this.posteRh = posteRh;
	}

	/**
	 * @return the resMat
	 */
	public NSMutableArray getResMat() {
		return resMat;
	}

	/**
	 * @param resMat
	 *            the resMat to set
	 */
	public void setResMat(NSMutableArray resMat) {
		this.resMat = resMat;
	}

	/**
	 * @return the newResMat
	 */
	public NSMutableArray getNewResMat() {
		return newResMat;
	}

	/**
	 * @param newResMat
	 *            the newResMat to set
	 */
	public void setNewResMat(NSMutableArray newResMat) {
		this.newResMat = newResMat;
	}
}