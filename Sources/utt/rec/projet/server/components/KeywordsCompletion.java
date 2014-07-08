package utt.rec.projet.server.components;

import utt.rec.projet.server.PprecHelpers;
import utt.rec.projet.server.components.assistant.MAssistant;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORefidx;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class KeywordsCompletion extends MAssistant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3143157090797796720L;
	String onloadJS = null;
	private boolean isResetAjoutMotClefDialog;
	private EOEditingContext editingContextForMotClef;

	// master completion
	public NSArray<EORefidx> allKeywords;
	public EORefidx currentKeyword;
	public EORefidx selectKeyword;
	public String wordValue;
	// satellite completion1
	public NSArray<EORefidx> allKeywords1;
	public EORefidx currentKeyword1;
	public EORefidx selectKeyword1;
	public String wordValue1;
	// satellite completion2
	public NSArray<EORefidx> allKeywords2;
	public EORefidx currentKeyword2;
	public EORefidx selectKeyword2;
	public String wordValue2;
	// Dedicate value
	public EORefidx dedicateValue;
	// Binding project
	private static final String isPROJET = "Projet";

	public KeywordsCompletion(WOContext context) {
		super(context);
		NSLog.out.appendln("KeywordsCompletion");
		refreshKeywords();
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		PprecHelpers.insertStylesSheet(context, response);
	}

	@Override
	public void takeValuesFromRequest(WORequest aRequest, WOContext aContext) {
		super.takeValuesFromRequest(aRequest, aContext);
	}

	/**
	 * @return the onloadJS
	 */
	public String getOnloadJS() {
		return onloadJS;
	}

	/**
	 * @param onloadJS
	 *            the onloadJS to set
	 */
	public void setOnloadJS(String onloadJS) {
		this.onloadJS = onloadJS;
	}

	// master completion
	public NSArray<EORefidx> currentsKeywords(String value) {
		NSArray<EORefidx> result = new NSArray<EORefidx>();
		result = EORefidx.REFIDXVAL.containsAll(value).filtered(allKeywords);
		return result;
	}

	public NSArray<EORefidx> currentsKeywords() {
		return currentsKeywords(wordValue);
	}

	public WOActionResults submitted() {
		try {
			// System.out.println("AutoComplete.submitted: " + wordValue + ", "+
			// selectKeyword);
			if (selectKeyword != null) {
				allKeywords1 = EORefidx.fetchGetMotClefs(edc(),
						Integer.valueOf(selectKeyword.primaryKey()));
				dedicateValue = selectKeyword;
			}
		} catch (Exception e) {
			// TODO: handle exception
			mySession().addSimpleErrorMessage("recherche motclef",
					e.getLocalizedMessage());
		}
		return null;
	}

	// End master completion

	// satellite completion1
	public NSArray<EORefidx> currentsKeywords1(String value) {
		NSArray<EORefidx> result = new NSArray<EORefidx>();
		result = EORefidx.REFIDXVAL.containsAll(value).filtered(allKeywords1);
		return result;
	}

	public NSArray<EORefidx> currentsKeywords1() {
		return currentsKeywords1(wordValue1);
	}

	public WOActionResults submitted1() {
		try {
			// System.out.println("AutoComplete1.submitted: " + wordValue1 +
			// ", "
			// +selectKeyword1);
			if (selectKeyword1 != null) {
				allKeywords2 = EORefidx.fetchGetMotClefs(edc(),
						Integer.valueOf(selectKeyword1.primaryKey()));
				dedicateValue = selectKeyword1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			mySession().addSimpleErrorMessage("recherche motclef",
					e.getLocalizedMessage());
		}
		return null;
	}

	// End satellite completion 1

	// satellite completion2
	public NSArray<EORefidx> currentsKeywords2(String value) {
		NSArray<EORefidx> result = new NSArray<EORefidx>();
		result = EORefidx.REFIDXVAL.containsAll(value).filtered(allKeywords2);
		return result;
	}

	public NSArray<EORefidx> currentsKeywords2() {
		return currentsKeywords2(wordValue2);
	}

	public WOActionResults submitted2() {
		try {
			// System.out.println("AutoComplete2.submitted: " + wordValue2 +
			// ", "+
			// selectKeyword2);
			if (selectKeyword2 != null) {
				dedicateValue = selectKeyword2;
			}
		} catch (Exception e) {
			// TODO: handle exception
			mySession().addSimpleErrorMessage("recherche motclef",
					e.getLocalizedMessage());
		}
		return null;
	}

	// End satellite completion 2

	// Add module value to keyword field
	// Arbre d'ajout des différents mot clé, savoir si cet arbre ne peut pas
	// être simplifié de manière générique (à etudier)
	public WOActionResults keywordUpdate() {
		try {
			if (dedicateValue != null) {
				if (mySession().getMotClef() != null) {
					if (mySession().getMotClef1() != null) {
						if (mySession().getMotClef2() != null) {
							if (mySession().getMotClef3() != null) {
								if (mySession().getMotClef4() != null) {
									if (mySession().getMotClef5() != null) {
										if (mySession().getMotClef6() != null) {
											if (mySession().getMotClef7() != null) {
												if (mySession().getMotClef8() != null) {
													if (mySession()
															.getMotClef9() != null) {
														if (mySession()
																.getMotClef10() != null) {
															if (mySession()
																	.getMotClef11() == null) {
																mySession()
																		.setMotClef11(
																				dedicateValue);
																Listing(mySession()
																		.getMotClef11());
															}
														} else {
															mySession()
																	.setMotClef10(
																			dedicateValue);
															Listing(mySession()
																	.getMotClef10());
														}
													} else {
														mySession()
																.setMotClef9(
																		dedicateValue);
														Listing(mySession()
																.getMotClef9());
													}
												} else {
													mySession().setMotClef8(
															dedicateValue);
													Listing(mySession()
															.getMotClef8());
												}
											} else {
												mySession().setMotClef7(
														dedicateValue);
												Listing(mySession()
														.getMotClef7());
											}
										} else {
											mySession().setMotClef6(
													dedicateValue);
											Listing(mySession().getMotClef6());
										}
									} else {
										mySession().setMotClef5(dedicateValue);
										Listing(mySession().getMotClef5());
									}
								} else {
									mySession().setMotClef4(dedicateValue);
									Listing(mySession().getMotClef4());
								}
							} else {
								mySession().setMotClef3(dedicateValue);
								Listing(mySession().getMotClef3());
							}
						} else {
							mySession().setMotClef2(dedicateValue);
							Listing(mySession().getMotClef2());
						}
					} else {
						mySession().setMotClef1(dedicateValue);
						Listing(mySession().getMotClef1());
					}
				} else {
					mySession().setMotClef(dedicateValue);
					Listing(mySession().getMotClef());
				}
			} else {
				mySession().addSimpleInfoMessage("Module de recherche mots clefs ",
						"Aucun mot clef n'a été selectionné");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		dedicateValue = null;
		wordValue2 = null;
		selectKeyword2 = null;
		wordValue1 = null;
		selectKeyword1 = null;
		wordValue = null;
		selectKeyword = null;
		return null;
	}

	public String motclefDialogId() {
		return "Motclef_" + uniqueDomId();
	}

	/**
	 * @return the isResetAjoutMotClefDialog
	 */
	public boolean isResetAjoutMotClefDialog() {
		return isResetAjoutMotClefDialog;
	}

	/**
	 * @param isResetAjoutMotClefDialog
	 *            the isResetAjoutMotClefDialog to set
	 */
	public void setResetAjoutMotClefDialog(boolean isResetAjoutMotClefDialog) {
		this.isResetAjoutMotClefDialog = isResetAjoutMotClefDialog;
	}

	/**
	 * @return the editingContextForMotClef
	 */
	public EOEditingContext getEditingContextForMotClef() {
		if (editingContextForMotClef == null) {
			editingContextForMotClef = edc();
		}
		return editingContextForMotClef;
	}

	/**
	 * @param editingContextForMotClef
	 *            the editingContextForMotClef to set
	 */
	public void setEditingContextForMotClef(
			EOEditingContext editingContextForMotClef) {
		this.editingContextForMotClef = editingContextForMotClef;
	}

	public boolean peutNouveauMotClef() {
		if (myApp().newGestionDroitsEnabled()) {
			return myAppGDUser().getPprecAutorisationCache()
					.gDPprecCreationProjet()
					|| myAppGDUser().getPprecAutorisationCache()
							.gDPprecSuperUserProjet();
		}
		return myAppJAUser().hasDroitCreationProjet()
				|| myAppJAUser().superUserPprec();
	}

	public WOActionResults openAjouterMotClef() {
		setResetAjoutMotClefDialog(true);
		NouveauMotClefs page = (NouveauMotClefs) pageWithName(NouveauMotClefs.class
				.getName());
		page.setEditingContext(getEditingContextForMotClef());
		page.setResetAjoutMotClefDialog(true);
		return page;
	}

	public void refreshKeywords() {
		allKeywords = EORefidx.fetchGetMotsClefsParents(edc());
		if (mySession().getLastCreateMotClef() != null) {
			dedicateValue = mySession().getLastCreateMotClef();
			keywordUpdate();
		}
	}

	public void Listing(EORefidx key) {
		if(!myKeywordList().contains(key))
			myKeywordList().addObject(key);
		myKeywordDel().removeObject(key);
	}

	/**
	 * @return the isprojet
	 */
	public EOPprec projet() {
		EOPprec value = (EOPprec) valueForBinding(isPROJET);
		return value;
	}

	public void setProjet(EOPprec value) {
		setValueForBinding(value, isPROJET);
	}
}