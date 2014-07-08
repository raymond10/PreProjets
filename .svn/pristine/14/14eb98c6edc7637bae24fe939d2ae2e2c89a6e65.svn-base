package utt.rec.projet.server.components;

import org.apache.log4j.Logger;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.components.controler.NextProjectCtrl;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOAlerte;
import utt.rec.projet.server.metier.admrec.EOGemateriel;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
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
import utt.rec.projet.server.utils.manufactory.ManufactoryEquipe;
import utt.rec.projet.server.utils.manufactory.ManufactoryMateriels;
import utt.rec.projet.server.utils.manufactory.ManufactoryMotClefs;
import utt.rec.projet.server.utils.manufactory.ManufactoryPartenaire;
import utt.rec.projet.server.utils.manufactory.ManufactoryPersonnelRhs;
import utt.rec.projet.server.utils.manufactory.ManufactoryRecrue;
import utt.rec.projet.server.utils.manufactory.ManufactoryStmr;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSValidation.ValidationException;

import er.ajax.AjaxUpdateContainer;
import er.ajax.CktlAjaxUtils;
import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.appserver.ERXRedirect;
import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */

@SuppressWarnings("all")
public class NextProject extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3801267013841792589L;
	private static final String UPDATENEXT_CONTAINER_ID = "updateNextContainer";
	private static final String ID_SUBMIT = "AJAX_SUBMIT_BUTTON_NAME";
	private static final String SAVE = "Enregistrer";
	private static final Logger LOG = Logger.getLogger(NextProject.class);
	private NSMutableArray persRh;
	private NSMutableArray poleRh;
	private NSMutableArray posta;
	private NSMutableArray mata;
	private NSMutableArray mato;
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
	private ForAjaxTxFinanceEditor recrueFinanEditor;
	private ForAjaxImplicationEditor ImplicationEditor;
	private ForAjaxUtilisationEditor utilsationEditor;
	private ForAjaxFinanceEditor financeEditor;
	public int count = -1;
	public int anotherCount = -1;
	public int watch = 0;
	public ERXDisplayGroup persDg;
	private NextProjectCtrl ctrl;
	public String errorPoste;
	private NSMutableArray personnels;
	private NSMutableArray posteRh;
	private NSMutableArray resMat;
	private NSMutableArray newResMat;
	private String contexte, problematique, objectif, methodologie;

	public NextProject(WOContext context) {
		super(context);
		NSLog.out.appendln("NextProject");
		ctxt = context;
		mySession().setPoleList(EOStructureUlr.fetchPoles(edcProjet()));
		mySession().setListCategories(
				EOVtyprhcm.fetchAllEOVtyprhcms(edcProjet(),
						EOVtyprhcm.TYPRHCM_LIB.ascs()));
		// mySession().setListCategMteriels(EOPfmateriel.fetchAllEOPfmateriels(edcProjet(),
		// EOPfmateriel.PFMAT_LIB.ascs()));
		// mySession().setListLibMateriels(EOGemateriel.fetchEOGemateriels(edcProjet(),
		// EOGemateriel.GEMAT_TEM.eq("AC"), EOGemateriel.GEMAT_LIB.ascs()));
		// initDisplayGroup();
		// mySession().setPersonneDg(new ERXDisplayGroup<EOIndividuUlr>());
		ctrl().isTerminerUnProjetDisabled();
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
	public NextProjectCtrl ctrl() {
		if (ctrl == null)
			ctrl = new NextProjectCtrl(this);
		return ctrl;
	}

	/**
	 * @param ctrl
	 *            the ctrl to set
	 */
	public void setCtrl(NextProjectCtrl ctrl) {
		this.ctrl = ctrl;
	}

	// ---> Action method <--- //

	// Selected pole for person to recruit **/
	public String lePoleSelectioner() {
		count++;
		if (mySession().postesDg().allObjects().count() != 0
				&& mySession().postesDg().displayedObjects()
						.indexOf(mySession().getPoleRecruRepetition()) != -1) {
			NSLog.out.appendln("display :"
					+ (mySession().postesDg().displayedObjects().count() - 1));
			NSLog.out.appendln("allObject :"
					+ (mySession().postesDg().allObjects().count() - 1));
			if (mySession().postesDg().allObjects().count() - 1 == mySession()
					.postesDg().displayedObjects().count() - 1) {
				if (dispPoleRecrue.containsKey(mySession().postesDg()
						.displayedObjects()
						.indexOf(mySession().getPoleRecruRepetition()))) {
					NSLog.out.appendln("indexOf :"
							+ mySession()
									.postesDg()
									.displayedObjects()
									.indexOf(
											mySession()
													.getPoleRecruRepetition()));
					anotherCount++;
					return (String) dispPoleRecrue.get(mySession().postesDg()
							.displayedObjects()
							.indexOf(mySession().getPoleRecruRepetition()));
				}
			}
		}
		return "We have problem here";
	}

	public String lePoleASelectioner() {
		count++;
		if (mySession().materielsDg().allObjects().count() != 0
				&& mySession().materielsDg().displayedObjects()
						.indexOf(mySession().getPoleNewMatRep()) != -1) {
			NSLog.out
					.appendln("display :"
							+ (mySession().materielsDg().displayedObjects()
									.count() - 1));
			NSLog.out.appendln("allObject :"
					+ (mySession().materielsDg().allObjects().count() - 1));
			if (mySession().materielsDg().allObjects().count() - 1 == mySession()
					.materielsDg().displayedObjects().count() - 1) {
				if (dispPoleMat.containsKey(mySession().materielsDg()
						.displayedObjects()
						.indexOf(mySession().getPoleNewMatRep()))) {
					NSLog.out.appendln("indexOf :"
							+ mySession().materielsDg().displayedObjects()
									.indexOf(mySession().getPoleNewMatRep()));
					anotherCount++;
					return (String) dispPoleMat.get(mySession().materielsDg()
							.displayedObjects()
							.indexOf(mySession().getPoleNewMatRep()));
				}
			}
		}
		return "We have problem here";
	}

	// Comment from one of the secondary team responsible project

	public WOActionResults nouvoCommentaire() {
		return null;
	}

	// End comment

	// Action

	public WOActionResults nextPage() {
		SoumiProject nextPage = (SoumiProject) pageWithName(SoumiProject.class
				.getName());
		return nextPage;
	}

	public WOActionResults saveRawData() {
		return null;
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
	
	public boolean batchView() {
		return mySession().personneDg().allObjects().count() > 5;
	}

	public void nextBatch1() {
		mySession().postesDg().displayNextBatch();
		mySession().postesDg().setSelectedObject(null);
	}

	public void previousBatch1() {
		mySession().postesDg().displayPreviousBatch();
		mySession().postesDg().setSelectedObject(null);
	}
	
	public boolean batchView1() {
		return mySession().postesDg().allObjects().count() > 5;
	}

	public void nextBatch2() {
		mySession().poleMaterielsDg().displayNextBatch();
		mySession().poleMaterielsDg().setSelectedObject(null);
	}

	public void previousBatch2() {
		mySession().poleMaterielsDg().displayPreviousBatch();
		mySession().poleMaterielsDg().setSelectedObject(null);
	}
	
	public boolean batchView2() {
		return mySession().poleMaterielsDg().allObjects().count() > 5;
	}

	public void nextBatch3() {
		mySession().materielsDg().displayNextBatch();
		mySession().materielsDg().setSelectedObject(null);
	}

	public void previousBatch3() {
		mySession().materielsDg().displayPreviousBatch();
		mySession().materielsDg().setSelectedObject(null);
	}
	
	public boolean batchView3() {
		return mySession().materielsDg().allObjects().count() > 5;
	}

	// End management of dynamic tables

	/**
	 * Making Data
	 */

	// Builting data for people grid
	@SuppressWarnings("unchecked")
	private NSArray personData(EOPersonnel aPerson) {
		if (!persRh().contains(aPerson)) {
			persRh().addObject(aPerson);
		}
		return persRh().mutableClone();
	}

	private NSArray poleData(EOStructureUlr aPole) {
		if (!poleRh().contains(aPole)) {
			poleRh().add(aPole);
		}
		return poleRh().mutableClone();
	}

	// Construction of the data for the positions grid
	@SuppressWarnings("unchecked")
	private NSMutableArray postesData(EOPosterh aPoste) {
		if (!posta().contains(aPoste)) {
			posta().add(aPoste);
		}
		return posta().mutableClone();
	}

	// Construction of the data for equipments from one pole
	private NSMutableArray materielsData(EOResmat aMateriel) {
		if (!mata().contains(aMateriel)) {
			mata().add(aMateriel);
		}
		return mata().mutableClone();
	}

	// Construction of the data for new hardware to buy
	private NSMutableArray nouvoMatosData(EOResmat aNouvoMatos) {
		if (!mato().contains(aNouvoMatos)) {
			mato().add(aNouvoMatos);
		}
		return mato().mutableClone();
	}

	// Construction of the commentary for the second team
	private NSMutableArray commData() {
		return null;
	}

	/*
	 * // Display the pole in the RH table public String poleValues() {
	 * NSMutableArray<EOStructureUlr> tinyPole = new
	 * NSMutableArray<EOStructureUlr>(); NSArray<EORepartStructure> structList =
	 * new NSArray<EORepartStructure>(); String viewPole = null; EOStructureUlr
	 * test = new EOStructureUlr(); if
	 * (mySession().getPersonRhRepetition().nomPatronymique() != null) {
	 * structList = mySession().getPersonRhRepetition().eoPersonneFk()
	 * .eoRepartStructuresFK(); for (int j = 0; j < structList.count(); j++) {
	 * test = EOStructureUlr.fetchEOStructureUlr(edcProjet(), EOStructureUlr
	 * .qualRepartPole(structList.objectAtIndex(j))); if (test != null) {
	 * tinyPole.addObject(test); } //
	 * structList.objectAtIndex(j).structureUlr()); } } for (int k = 0; k <
	 * tinyPole.count(); k++) { viewPole =
	 * tinyPole.objectAtIndex(k).lcStructure(); } return viewPole; }
	 * 
	 * // Adding the selected person depending the pole public String
	 * personValue() { EOStructureUlr testStruct =
	 * mySession().getPoleRhRepetition(); String viewPerson = null;
	 * NSMutableArray<EORepartStructure> tinyRepart = new
	 * NSMutableArray<EORepartStructure>(); NSMutableArray<EOPersonne> dic = new
	 * NSMutableArray<EOPersonne>(); EORepartStructure rePart = new
	 * EORepartStructure(); Object obj = new Object(); Object objs = new
	 * Object(); NSMutableArray<EOIndividuUlr> tinyIndiv = new
	 * NSMutableArray<EOIndividuUlr>();
	 * tinyRepart.addObject(testStruct.repartStructures(null, new NSArray(
	 * EORepartStructure.ByPersStructure()), false)); for (int i = 0; i <
	 * tinyRepart.count(); i++) { obj = tinyRepart.objectAtIndex(i); for (int j
	 * = 0; j < ((NSArray) obj).count(); j++) { rePart = (EORepartStructure)
	 * ((NSArray<EORepartStructure>) obj) .objectAtIndex(j);
	 * dic.addObject(rePart.eoPersonneFK()); } } for (int k = 0; k <
	 * dic.count(); k++) { objs = dic.objectAtIndex(k).eoIndividuUlrsFk(); for
	 * (int l = 0; l < ((NSArray<EOIndividuUlr>) objs).count(); l++) {
	 * tinyIndiv.addObject(((NSArray<EOIndividuUlr>) objs) .objectAtIndex(l)); }
	 * } for (int m = 0; m < tinyIndiv.count(); m++) { if
	 * (tinyIndiv.objectAtIndex(m).primaryKey()
	 * .equals(mySession().getSelectRhPerson().primaryKey())) { viewPerson =
	 * mySession().getSelectRhPerson().nomPatronymique() + " " +
	 * mySession().getSelectRhPerson().prenom(); } } return viewPerson; }
	 */

	/**
	 * @return the persRh
	 */
	public NSMutableArray persRh() {
		if (persRh == null)
			persRh = new NSMutableArray();
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
	public NSMutableArray poleRh() {
		if (poleRh == null)
			poleRh = new NSMutableArray();
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
	public NSMutableArray posta() {
		if (posta == null)
			posta = new NSMutableArray();
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
	public NSMutableArray mata() {
		if (mata == null)
			mata = new NSMutableArray();
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
	public NSMutableArray mato() {
		if (mato == null)
			mato = new NSMutableArray();
		return mato;
	}

	/**
	 * @param mato
	 *            the mato to set
	 */
	public void setMato(NSMutableArray mato) {
		this.mato = mato;
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

	public NSMutableArray personnels() {
		if (personnels == null)
			personnels = new NSMutableArray();
		return personnels;
	}

	public void setPersonnels(NSMutableArray personnels) {
		this.personnels = personnels;
	}

	public NSMutableArray posteRh() {
		if (posteRh == null)
			posteRh = new NSMutableArray();
		return posteRh;
	}

	public void setPosteRh(NSMutableArray posteRh) {
		this.posteRh = posteRh;
	}

	public NSMutableArray resMat() {
		if (resMat == null)
			resMat = new NSMutableArray();
		return resMat;
	}

	public void setResMat(NSMutableArray resMat) {
		this.resMat = resMat;
	}

	public NSMutableArray newResMat() {
		if (newResMat == null)
			newResMat = new NSMutableArray();
		return newResMat;
	}

	public void setNewResMat(NSMutableArray newResMat) {
		this.newResMat = newResMat;
	}

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

	protected static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.MAssistant#onSuivant()
	 */
	@Override
	public void onSuivant() {
		// TODO Auto-generated method stub
		EOPprec projet = myProjet();
		String vide = "<p><br data-mce-bogus=\"1\"></p>";
		WORequest request = context().request();
		String contexte = (String) request.formValueForKey("contexte");
		String problematik = (String) request.formValueForKey("problematique");
		String objectifs = (String) request.formValueForKey("objectifs");
		String methodo = (String) request.formValueForKey("methodologie");
		if (contexte != null && !contexte.equals(vide) && !contexte.equals("")) {
			projet.setProjctx(contexte);
		}
		if (problematik != null && !problematik.equals(vide)
				&& !problematik.equals("")) {
			projet.setProjpblm(problematik);
		}
		if (objectifs != null && !objectifs.equals(vide)
				&& !objectifs.equals("")) {
			projet.setProjobf(objectifs);
		}
		if (methodo != null && !methodo.equals(vide) && !methodo.equals("")) {
			projet.setProjmtdg(methodo);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.IAssistant#valider()
	 */
	@Override
	public boolean valider() {
		// TODO Auto-generated method stub
		boolean validate = false;
		EOPprec projet = myProjet();
		NSArray<String> failureMessages = new NSArray<String>();
		if (projet != null) {
			if (mySession().personneDg().allObjects().count() == 0)
				failureMessages
						.arrayByAddingObject("Estimation des ressources humaines du projet");
			//if (mySession().poleMaterielsDg().allObjects().count() == 0)
			//	failureMessages
			//			.arrayByAddingObject("Estimation des ressources matériels du projet");
			if (failureMessages.count() == 0) {
				validate = true;
				setFailureMessage(null);
			} else {
				setFailureMessage("Veuillez renseigner "
						+ failureMessages.componentsJoinedByString(", ") + ".");
			}
		} else {
			setFailureMessage("Veuillez renseigner les champs obligatoires (en rouge).");
		}
		if (validate)
			mySession().getUiMessages().removeAllObjects();
		return validate;
	}

	/* Debut traitement de l'insertion dans la BDD */
	public WOActionResults terminer() {
		ERXRedirect redirect = null;
		WORequest request = context().request();
		NSMutableDictionary formValues = request.formValues().mutableClone();
		NSArray actions = (NSArray) formValues.valueForKey(ID_SUBMIT);
		String action = (String) actions.lastObject();
		EOPprec projet = myProjet();
		if (projet != null) {
			try {
				onSuivant();
				EOEditingContext ec = edcProjet();
				if (!action.equals(SAVE) && ctrl().stateProject()) {
					EOTypref etat = EOTypref.fetchEOTypref(
							ec,
							EOTypref.TYPREFDOM.eq(EOTypref.VAR_ETAT_DOM).and(
									EOTypref.TYPREFNAT
											.eq(EOTypref.VAR_ETAT_SOUMETTRE)));
					projet.setToEtatRelationship(etat);
					projet.setToEtat(etat);
				} else {
					EOTypref etat = EOTypref.fetchEOTypref(
							ec,
							EOTypref.TYPREFDOM.eq(EOTypref.VAR_ETAT_DOM).and(
									EOTypref.TYPREFNAT
											.eq(EOTypref.VAR_ETAT_REDACTION)));
					projet.setToEtatRelationship(etat);
					projet.setToEtat(etat);
					
				}
				if (mySession().update()) {
					projet.setMajdate(new NSTimestamp());
					projet.setMajauteur(ctrl().auteur());
				}
				if (valider()) {
					if (ec.hasChanges()) {
						ec.updatedObjects();
						ec.saveChanges();
						// Traitement partenaire
						ManufactoryPartenaire mfp = new ManufactoryPartenaire(
								edc(), true);
						mfp.insPartenaire(projet, mySession()
								.selectedPartenaires());
						// suppression partenaire si existe
						if (mySession().removedPartenaires().count() > 0)
							mfp.delPartenaire(projet, mySession()
									.removedPartenaires());
						// Traitement equipe
						ManufactoryEquipe mfe = new ManufactoryEquipe(edc(),
								true);
						mfe.insEquipe(projet, mySession().selectedEquipes());
						if (mySession().removedEquipes().count() > 0)
							mfe.delEquipe(projet, mySession().removedEquipes());
						// Traitement smtr axe
						EOStructureUlr principal = EOStructureUlr
								.structurePourcStructure(edcProjet(),
										projet.equipePrincipale());
						if (principal.cStructure().equals(
								umrStmr().cStructure())
								|| projet.projthetv().equals("O")) {
							ManufactoryStmr mfs = new ManufactoryStmr(edc(),
									true);
							mfs.insAxeStmr(projet, mySession().lesAxesStmr());
						}
						// Traitement motClef
						ManufactoryMotClefs mfc = new ManufactoryMotClefs(
								edc(), true);
						mfc.insKeyword(projet, myKeywordList());
						if (myKeywordDel().count() > 0)
							mfc.delKeyword(projet, myKeywordDel());
						// Traitement personnel RH
						ManufactoryPersonnelRhs mpr = new ManufactoryPersonnelRhs(
								edc(), true);
						mpr.insPersonnel(projet, mySession().selectedrhs());
						if (mySession().removedrhs().count() > 0)
							mpr.delPersonnel(projet, mySession().removedrhs());
						// Traitement profil recruter
						ManufactoryRecrue mfr = new ManufactoryRecrue(edc(),
								true);
						mfr.insPoste(projet, mySession().selectedRecrue());
						if (mySession().removedRecrue().count() > 0)
							mfr.delPoste(projet, mySession().removedRecrue());
						/** Materiels **/
						// Traitement matériel existant
						ManufactoryMateriels materiel = new ManufactoryMateriels(
								edc(), true);
						materiel.insMateriel(projet, mySession()
								.selectedMaterielExistant());
						if (mySession().removedMaterielExistant().count() > 0)
							materiel.delMateriel(projet, mySession()
									.removedMaterielExistant());
						// Traitement nouveau matériel
						materiel.insMateriel(projet, mySession()
								.selectedMaterielAcquis());
						if (mySession().removedMaterielAcquis().count() > 0)
							materiel.delMateriel(projet, mySession()
									.removedMaterielAcquis());
						/** fin Materiels **/

						// Traitement envoie de mail si terminer
						if(!action.equals(SAVE))
							traitementMail(projet);
						// Message de fin de traitement
						if (mySession().update()) {
							// mySession().getUiMessages().removeAllObjects();
							mySession().addSimpleInfoMessage("PPREC",
									"Le projet a bien été modifié");
						} else {
							mySession().addSimpleInfoMessage("PPREC",
									"Le projet a bien été créé");
						}
						context().response().setStatus(500);
						AjaxUpdateContainer.updateContainerWithID(myApp()
								.messageContainerID(), context());
						redirect = redirect = (ERXRedirect) pageWithName(ERXRedirect.class
								.getName());
					}
				}
				mySession().setFiltreProjetFacade(null);
			} catch (ValidationException e2) {
				mySession()
						.addSimpleErrorMessage(
								"Une erreur est survenue lors de l'enregistrement en base",
								e2);
				e2.printStackTrace();
			} catch (Exception e) {
				mySession()
						.addSimpleErrorMessage(
								"Une erreur est survenue lors de l'enregistrement en base",
								e);
				e.printStackTrace();
			}
		}
		context().response().setStatus(500);
		AjaxUpdateContainer.updateContainerWithID(myApp().messageContainerID(),
				context());
		if(action.equals(SAVE)) {
			return null;
		} else {
			mySession().myEnv().setObjectForKey(true, "Refresh");
			redirect.setComponent(home());
		}
		return redirect;
	}

	protected void traitementMail(EOPprec projet) throws Exception {
		if (projet.toEtat().typrefnat().equals(EOTypref.VAR_ETAT_SOUMETTRE)) {
			EOAlerte uneAlerte = EOAlerte.numeroPourProjet(
					ERXEC.newEditingContext(),
					Integer.valueOf(projet.primaryKey()));
			// Nouveau projet
			if (uneAlerte == null) {
				uneAlerte = EOAlerte.newEOAlerteInContext(
						ERXEC.newEditingContext(), projet);
				uneAlerte.editingContext().saveChanges();
				uneAlerte.sendMailsNouvelleAlerte(mySession(), projet);
				if (mySession().getAlertMessage() != null
						&& !mySession().getAlertMessage().equals(""))
					throw new FactoryException(mySession().getAlertMessage());
			} else {
				// Projet modifié
				uneAlerte.sendMailsNouvelleAlerte(mySession(), projet);
			}
		}
	}

}