/**
 * 
 */
package utt.rec.projet.server.components.controler;

import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.eoaccess.EOGeneralAdaptorException;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestamp;

import er.ajax.AjaxUpdateContainer;
import er.extensions.appserver.ERXDisplayGroup;
import er.extensions.appserver.ERXRedirect;

import utt.rec.projet.server.PPrecApplicationUser;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.Commentaire;
import utt.rec.projet.server.components.NextProject;
import utt.rec.projet.server.components.NouveauGrandEquipement;
import utt.rec.projet.server.components.NouveauPlateau;
import utt.rec.projet.server.components.SoumiProject;
import utt.rec.projet.server.components.UpdateNextProject;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.exception.ProjetException;
import utt.rec.projet.server.factory.FactoryTabDataArray;
import utt.rec.projet.server.factory.FactoryTraitemantEquipes;
import utt.rec.projet.server.factory.FactoryTraitementHistorique;
import utt.rec.projet.server.factory.FactoryTraitementMateriels;
import utt.rec.projet.server.factory.FactoryTraitementMotClefs;
import utt.rec.projet.server.factory.FactoryTraitementPartenaires;
import utt.rec.projet.server.factory.FactoryTraitementPersonnel;
import utt.rec.projet.server.factory.FactoryTraitementPosteRh;
import utt.rec.projet.server.factory.FactoryTraitementProjet;
import utt.rec.projet.server.factory.FactoryTraitementRepartPst;
import utt.rec.projet.server.metier.admrec.EOAlerte;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOGemateriel;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessAlerte;
import utt.rec.projet.server.process.ProcessEquipes;
import utt.rec.projet.server.process.ProcessMateriel;
import utt.rec.projet.server.process.ProcessPartProjet;
import utt.rec.projet.server.process.ProcessPartenaire;
import utt.rec.projet.server.process.ProcessPersonnel;
import utt.rec.projet.server.process.ProcessPoste;
import utt.rec.projet.server.process.ProcessProjet;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class UpdateNextProjectCtrl extends ModuleCtrl<UpdateNextProject> {

	private EOEditingContext edc;
	private Session sess;
	private EOPprec projet;
	private EOPosterh poste;
	private EOPersonnel personnel;
	private EOResmat materiel;
	private EOResmat selectedMatos;
	private FactoryTraitemantEquipes trtEquipes = new FactoryTraitemantEquipes();
	private FactoryTraitementPersonnel trtPersonnel = new FactoryTraitementPersonnel();
	private FactoryTraitementPosteRh trtPoste = new FactoryTraitementPosteRh();
	private FactoryTraitementMateriels trtMateriel = new FactoryTraitementMateriels();
	private FactoryTraitementProjet trtProjet = new FactoryTraitementProjet();
	private FactoryTraitementHistorique trtHtq = new FactoryTraitementHistorique();
	private FactoryTraitementPartenaires trtPartenaire = new FactoryTraitementPartenaires();
	private FactoryTraitementMotClefs trtMotClefs = new FactoryTraitementMotClefs();
	private FactoryTraitementRepartPst trtRepartAxe = new FactoryTraitementRepartPst();
	boolean success = false;
	private FactoryTabDataArray tabDataArray;
	private boolean resetAjoutPlateauDialog;
	private boolean resetAjoutEquipementDialog;
	private boolean resetOpenCommentDialog;
	
	/**
	 * @param component
	 */
	public UpdateNextProjectCtrl(UpdateNextProject component) {
		super(component);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the projet
	 */
	public EOPprec projet() {
		if(projet == null)
			projet = wocomponent().myProjet();
		return projet;
	}

	/**
	 * @param projet
	 *            the projet to set
	 */
	public void setProjet(EOPprec projet) {
		this.projet = projet;
	}

	/**
	 * @return the edc
	 */
	public EOEditingContext edc() {
		if(edc == null)
			edc = wocomponent().edc();
		return edc;
	}

	/**
	 * @param edc the edc to set
	 */
	public void setEdc(EOEditingContext edc) {
		this.edc = edc;
	}

	/**
	 * @return the sess
	 */
	public Session sess() {
		if(sess == null)
			sess = wocomponent().mySession();
		return sess;
	}

	/**
	 * @param sess the sess to set
	 */
	public void setSess(Session sess) {
		this.sess = sess;
	}

	/**
	 * @return the tabDataArray
	 */
	public FactoryTabDataArray tabDataArray() {
		if(tabDataArray == null)
			tabDataArray = new FactoryTabDataArray(wocomponent(), sess(),
					wocomponent().getPersRh(), wocomponent().getPoleRh(),
					wocomponent().getPosteRh(), wocomponent().getMata(),
					wocomponent().getMato());
		return tabDataArray;
	}

	/**
	 * @param tabDataArray the tabDataArray to set
	 */
	public void setTabDataArray(FactoryTabDataArray tabDataArray) {
		this.tabDataArray = tabDataArray;
	}

	/**
	 * @return the poste
	 */
	public EOPosterh getPoste() {
		return poste;
	}

	/**
	 * @param poste
	 *            the poste to set
	 */
	public void setPoste(EOPosterh poste) {
		this.poste = poste;
	}

	/**
	 * @return the personnel
	 */
	public EOPersonnel getPersonnel() {
		return personnel;
	}

	/**
	 * @param personnel
	 *            the personnel to set
	 */
	public void setPersonnel(EOPersonnel personnel) {
		this.personnel = personnel;
	}

	/**
	 * @return the selectedMatos
	 */
	public EOResmat getSelectedMatos() {
		return selectedMatos;
	}

	/**
	 * @param selectedMatos
	 *            the selectedMatos to set
	 */
	public void setSelectedMatos(EOResmat selectedMatos) {
		this.selectedMatos = selectedMatos;
	}

	/**
	 * @return the materiel
	 */
	public EOResmat getMateriel() {
		return materiel;
	}

	/**
	 * @param materiel
	 *            the materiel to set
	 */
	public void setMateriel(EOResmat materiel) {
		this.materiel = materiel;
	}

	// Initialisation des donnees principales de champs
	public void intFields() {
		if (projet.toPersonnelExistants() != null) {
			wocomponent().getPersonnels().setArray(
					projet.toPersonnelExistants(EOPersonnel.TEMVALIDE.eq("O"),
							true));
		} else {
			wocomponent().getPersonnels().setArray(new NSArray());
		}
		if (projet.toPosteRhs() != null) {
			wocomponent().getPosteRh().setArray(
					projet.toPosteRhs(EOPosterh.TEMVALIDE.eq("O"), true));
		} else {
			wocomponent().getPosteRh().setArray(new NSArray());
		}
		if (projet.toMateriels() != null) {
			wocomponent().getResMat().setArray(
					projet.toMateriels(
							EOResmat.MATEXIST.eq("O").and(
									EOResmat.TEMVALIDE.eq("O")), true));
			wocomponent().getNewResMat().setArray(
					projet.toMateriels(
							EOResmat.MATEXIST.eq("N").and(
									EOResmat.TEMVALIDE.eq("O")), true));
		} else {
			wocomponent().getResMat().setArray(new NSArray());
			wocomponent().getNewResMat().setArray(new NSArray());
		}
	}

	// Affichage Page2
	public void personnelProjet() {
		NSArray tmp = new NSArray();
		boolean exist = false;
		NSMutableArray addO = new NSMutableArray();
		if (sess().personneDg() == null) {
			sess().setPersonneDg(new ERXDisplayGroup());
			sess().personneDg().setNumberOfObjectsPerBatch(5);
			NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
			bindings.takeValueForKey(Long.valueOf(projet.primaryKey()),
					"projetId");
			tmp = EOPersonnel.fetchPersonnelProjet(edc(), bindings);
			for (int i = 0; i < tmp.count(); i++) {
				EOPersonnel pers = new EOPersonnel();
				sess().setRh(new EOPersonnel());
				pers = (EOPersonnel) tmp.objectAtIndex(i);
				// on verifie le pk
				if (EOUtilities.primaryKeyForObject(edc(), pers) != null)
					exist = true;
				if (!exist) {
					sess().rh().setNoIndividu(pers.noIndividu());
					sess().rh().setNomPersonnel(pers.nomPersonnel());
					sess().rh().setCStructure(pers.cStructure());
					sess().rh().setNomStructure(pers.nomStructure());
					sess().rh().setTempsuitl(pers.tempsuitl());
					sess().rh().setCoutestime(pers.coutestime());
					sess().rh().setTemvalide("O");
					addO.addObject(sess().rh());
				} else {
					addO.addObject(pers);
				}
			}
			sess().personneDg().setObjectArray(addO.immutableClone());
		}
		wocomponent().getPersRh().setArray(sess().personneDg().allObjects());
	}

	public void posteProjet() {
		NSArray tmp = new NSArray();
		boolean exist = false;
		NSMutableArray addO = new NSMutableArray();
		if (sess().postesDg() == null) {
			sess().setPostesDg(new ERXDisplayGroup());
			sess().postesDg().setNumberOfObjectsPerBatch(5);
			NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
			bindings.takeValueForKey(Long.valueOf(projet.primaryKey()),
					"projetId");
			tmp = EOPosterh.fetchPosteProjet(edc(), bindings);
			for (int i = 0; i < tmp.count(); i++) {
				EOPosterh pos = new EOPosterh();
				sess().setRecrue(new EOPosterh());
				pos = (EOPosterh) tmp.objectAtIndex(i);
				// on verifie le pk
				if (EOUtilities.primaryKeyForObject(edc(), pos) != null)
					exist = true;
				if (!exist) {
					sess().recrue().setPostelib(pos.postelib());
					sess().recrue().setCStructure(pos.cStructure());
					sess().recrue().setNomStructure(pos.nomStructure());
					sess().recrue().setTxfinancement(pos.txfinancement());
					sess().recrue().setDureeRecrue(pos.dureeRecrue());
					sess().recrue().setToCategorieRh(pos.toCategorieRh());
					sess().recrue().setCoutestime(pos.coutestime());
					sess().recrue().setTemvalide("O");
					addO.addObject(sess().recrue());
				} else {
					addO.addObject(pos);
				}
			}
			sess().postesDg().setObjectArray(addO.immutableClone());
		}
		wocomponent().getPosta().setArray(sess().postesDg().allObjects());
	}

	public void materielProjet() {
		// Materiel existant
		NSArray tmp = new NSArray();
		boolean exist = false;
		boolean exo = false;
		NSMutableArray addO = new NSMutableArray();
		NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
		bindings.takeValueForKey(Long.valueOf(projet.primaryKey()), "projetId");
		if (sess().poleMaterielsDg() == null) {
			sess().setPoleMaterielsDg(new ERXDisplayGroup());
			sess().poleMaterielsDg().setNumberOfObjectsPerBatch(5);
			tmp = EOResmat.fetchMaterielProjet(edc(), bindings);
			for (int i = 0; i < tmp.count(); i++) {
				EOResmat mat = new EOResmat();
				sess().setMatos(new EOResmat());
				mat = (EOResmat) tmp.objectAtIndex(i);
				// on verifie le pk
				if (EOUtilities.primaryKeyForObject(edc(), mat) != null)
					exist = true;
				if (!exist) {
					sess().matos().setToGrandEquipement(
							mat.toGrandEquipement());
					sess().matos().setCStructure(mat.cStructure());
					sess().matos().setNomStructure(mat.nomStructure());
					sess().matos().setToPlateauTech(mat.toPlateauTech());
					sess().matos().setMatutil(mat.matutil());
					sess().matos().setCoutestime(mat.coutestime());
					sess().matos().setTemvalide("O");
					addO.addObject(sess().matos());
				} else {
					addO.addObject(mat);
				}
			}
			sess().poleMaterielsDg().setObjectArray(addO.immutableClone());
		}
		wocomponent().getMata().setArray(sess().poleMaterielsDg().allObjects());
		// Nouveau materiel
		addO = new NSMutableArray();
		if (sess().materielsDg() == null) {
			sess().setMaterielsDg(new ERXDisplayGroup());
			sess().materielsDg().setNumberOfObjectsPerBatch(5);
			tmp = EOResmat.fetchNouceauMaterielProjet(edc(), bindings);
			for (int i = 0; i < tmp.count(); i++) {
				EOResmat mat = new EOResmat();
				sess().setNewMatos(new EOResmat());
				mat = (EOResmat) tmp.objectAtIndex(i);
				// on verifie le pk
				if (EOUtilities.primaryKeyForObject(edc(), mat) != null)
					exo = true;
				if (!exo) {
					sess().newMatos().setToGrandEquipement(
							mat.toGrandEquipement());
					sess().newMatos().setCStructure(mat.cStructure());
					sess().newMatos().setNomStructure(mat.nomStructure());
					sess().newMatos().setToPlateauTech(mat.toPlateauTech());
					sess().newMatos().setTxfinancement(mat.txfinancement());
					sess().newMatos().setCoutestime(mat.coutestime());
					sess().newMatos().setTemvalide("O");
					addO.addObject(sess().newMatos());
				} else {
					addO.addObject(mat);
				}
			}
			sess().materielsDg().setObjectArray(addO.immutableClone());
		}
		wocomponent().getMato().setArray(sess().materielsDg().allObjects());
	}

	// Fin Affichage Page 2

	/* Data Base save Methods */

	public WOActionResults annuler() {
		Accueil home = (Accueil) wocomponent().pageWithName(Accueil.class
				.getName());
		ERXRedirect redirect = (ERXRedirect) wocomponent()
				.pageWithName(ERXRedirect.class.getName());
		redirect.setComponent(home);
		return redirect;
	}

	/* Debut traitement de l'insertion dans la BDD */

	public WOActionResults enregistrer() {
		WORequest request = wocomponent().context().request();
		UpdateNextProject same = (UpdateNextProject) wocomponent()
				.pageWithName(UpdateNextProject.class.getName());
		SoumiProject home = (SoumiProject) wocomponent()
				.pageWithName(SoumiProject.class.getName());
		String action = (String) request.formValueForKey("save");
		ERXRedirect redirect = null;
		if (action == null) {
			EtatNouvoProjet();
		}
		save();
		if (!success) {
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			redirect = (ERXRedirect) wocomponent().pageWithName(ERXRedirect.class
					.getName());
			redirect.setComponent(same);
		} else {
			home.setNumero(projet.getProjIdProc());
			same.setOnloadJS("openListeSelectionWin(null,'"
					+ wocomponent().context().directActionURLForActionNamed(
							"pageProjetSoumis", null)
					+ "',\'Fin de sauvegarde Projet\',\'PageSoumiseDetaillee\',\'Contenu\',true);");
			redirect = (ERXRedirect) wocomponent().pageWithName(ERXRedirect.class
					.getName());
			redirect.setComponent(home);
		}
		return redirect;
	}

	/* End Data Base save Methods */

	// Initialisation des factory

	/**
	 * @return the trtEquipes
	 */
	public FactoryTraitemantEquipes getTrtEquipes() {
		return trtEquipes;
	}

	/**
	 * @param trtEquipes
	 *            the trtEquipes to set
	 */
	public void setTrtEquipes(FactoryTraitemantEquipes trtEquipes) {
		this.trtEquipes = trtEquipes;
	}

	/**
	 * @return the trtPersonnel
	 */
	public FactoryTraitementPersonnel getTrtPersonnel() {
		return trtPersonnel;
	}

	/**
	 * @param trtPersonnel
	 *            the trtPersonnel to set
	 */
	public void setTrtPersonnel(FactoryTraitementPersonnel trtPersonnel) {
		this.trtPersonnel = trtPersonnel;
	}

	/**
	 * @return the trtPoste
	 */
	public FactoryTraitementPosteRh getTrtPoste() {
		return trtPoste;
	}

	/**
	 * @param trtPoste
	 *            the trtPoste to set
	 */
	public void setTrtPoste(FactoryTraitementPosteRh trtPoste) {
		this.trtPoste = trtPoste;
	}

	/**
	 * @return the trstMateriel
	 */
	public FactoryTraitementMateriels getTrtMateriel() {
		return trtMateriel;
	}

	/**
	 * @param trstMateriel
	 *            the trstMateriel to set
	 */
	public void setTrtMateriel(FactoryTraitementMateriels trtMateriel) {
		this.trtMateriel = trtMateriel;
	}

	/**
	 * @return the trtProjet
	 */
	public FactoryTraitementProjet getTrtProjet() {
		return trtProjet;
	}

	/**
	 * @param trtProjet
	 *            the trtProjet to set
	 */
	public void setTrtProjet(FactoryTraitementProjet trtProjet) {
		this.trtProjet = trtProjet;
	}

	/**
	 * @return the trtHtq
	 */
	public FactoryTraitementHistorique getTrtHtq() {
		return trtHtq;
	}

	/**
	 * @param trtHtq
	 *            the trtHtq to set
	 */
	public void setTrtHtq(FactoryTraitementHistorique trtHtq) {
		this.trtHtq = trtHtq;
	}

	/**
	 * @return the trtPartenaire
	 */
	public FactoryTraitementPartenaires getTrtPartenaire() {
		return trtPartenaire;
	}

	/**
	 * @param trtPartenaire
	 *            the trtPartenaire to set
	 */
	public void setTrtPartenaire(FactoryTraitementPartenaires trtPartenaire) {
		this.trtPartenaire = trtPartenaire;
	}

	/**
	 * @return the trtMotClefs
	 */
	public FactoryTraitementMotClefs getTrtMotClefs() {
		return trtMotClefs;
	}

	/**
	 * @param trtMotClefs
	 *            the trtMotClefs to set
	 */
	public void setTrtMotClefs(FactoryTraitementMotClefs trtMotClefs) {
		this.trtMotClefs = trtMotClefs;
	}

	/**
	 * @return the trtRepartAxe
	 */
	public FactoryTraitementRepartPst getTrtRepartAxe() {
		return trtRepartAxe;
	}

	/**
	 * @param trtRepartAxe
	 *            the trtRepartAxe to set
	 */
	public void setTrtRepartAxe(FactoryTraitementRepartPst trtRepartAxe) {
		this.trtRepartAxe = trtRepartAxe;
	}

	/**
	 * @return the resetAjoutPlateauDialog
	 */
	public boolean isResetAjoutPlateauDialog() {
		return resetAjoutPlateauDialog;
	}

	/**
	 * @param resetAjoutPlateauDialog
	 *            the resetAjoutPlateauDialog to set
	 */
	public void setResetAjoutPlateauDialog(boolean resetAjoutPlateauDialog) {
		this.resetAjoutPlateauDialog = resetAjoutPlateauDialog;
	}

	/**
	 * @return the resetAjoutEquipementDialog
	 */
	public boolean isResetAjoutEquipementDialog() {
		return resetAjoutEquipementDialog;
	}

	/**
	 * @return the resetOpenCommentDialog
	 */
	public boolean isResetOpenCommentDialog() {
		return resetOpenCommentDialog;
	}

	/**
	 * @param resetOpenCommentDialog the resetOpenCommentDialog to set
	 */
	public void setResetOpenCommentDialog(boolean resetOpenCommentDialog) {
		this.resetOpenCommentDialog = resetOpenCommentDialog;
	}

	/**
	 * @param resetAjoutEquipementDialog the resetAjoutEquipementDialog to set
	 */
	public void setResetAjoutEquipementDialog(boolean resetAjoutEquipementDialog) {
		this.resetAjoutEquipementDialog = resetAjoutEquipementDialog;
	}

	// Fin init factory
	public WOActionResults updateNewMat() {
		ERXRedirect redirect = null;
		tabDataArray.ajouNouvoMatos();
		/*UpdateNextProject same = (UpdateNextProject) wocomponent
				.pageWithName(UpdateNextProject.class.getName());
		redirect = (ERXRedirect) wocomponent().pageWithName(ERXRedirect.class
				.getName());
		redirect.setComponent(same);*/
		return wocomponent().doNothing();
	}

	// Gestion nouveau plateau
	public boolean peutCreer() {
		if(wocomponent().myApp().newGestionDroitsEnabled()) {
			return wocomponent().myAppGDUser().getPprecAutorisationCache().gDPprecCreationProjet();
		}
		return wocomponent().myAppJAUser().hasDroitCreationProjet();
	}

	public WOActionResults openAjouterPlateau() {
		setResetAjoutPlateauDialog(true);
		NouveauPlateau page = (NouveauPlateau) wocomponent()
				.pageWithName(NouveauPlateau.class.getName());
		page.setResetAjoutPlateauDialog(true);
		return page;
	}
	
	public WOActionResults openAjouterEquipement() {
		setResetAjoutEquipementDialog(true);
		NouveauGrandEquipement page = (NouveauGrandEquipement) wocomponent()
				.pageWithName(NouveauGrandEquipement.class.getName());
		page.setResetAjoutEquipementDialog(true);
		return page;
	}
	
	public WOActionResults openCommentaire() {
		resetOpenCommentDialog = true;
		Commentaire page = (Commentaire) wocomponent()
				.pageWithName(Commentaire.class.getName());
		page.setResetOpenCommentDialog(true);
		return page;
	}

	public void refreshPlateau() {
		if (sess().getSelectNewMatPole() != null)
			sess().setListCategMteriels0(EOPfmateriel.fetchLePFduPole(edc(), sess
					.getSelectNewMatPole().primaryKey()));
		if (sess().getLastPlateau() != null)
			sess().setCategMatSelect0(sess().getLastPlateau());
	}
	
	public void refreshEquipement() {
		if (sess().getCategMatSelect0() != null)
			sess().setListLibNewMat(EOGemateriel.fetchLeNgeDuPT(edc(), sess
					.getCategMatSelect0().primaryKey()));
		if (sess().getNouveauEquipement() != null)
			sess().setLibNewMatSelect(sess().getNouveauEquipement());
	}

	// Fin nouveau plateau

	// Supression d'une personne sŽlectionnee dans le tableau dynamique RH
	public WOActionResults removePersonne() {
		sess().personneDg().setSelectedObject(sess().getPersonRhRep());
		if (EOUtilities.primaryKeyForObject(edc(), sess().getPersonRhRep()) != null) {
			sess().getPersonRhRep().setTemvalide("N");
			sess().getPersonRhRep().editingContext().saveChanges();
		}
		sess().personneDg()._deleteObject(sess().personneDg().selectedObject());
		wocomponent().getPersRh().setArray(sess().personneDg().allObjects());
		return wocomponent().doNothing();
	}

	// Supression d'un poste sŽlectionnŽ dans le tableau dynamique Recrutement
	public WOActionResults removePoste() {
		sess().postesDg().setSelectedObject(sess().getPoleRecruRepetition());
		if (EOUtilities.primaryKeyForObject(edc(), sess().getPoleRecruRepetition()) != null) {
			sess().getPoleRecruRepetition().setTemvalide("N");
			sess().getPoleRecruRepetition().editingContext().saveChanges();
		}
		sess().postesDg()._deleteObject(sess().postesDg().selectedObject());
		wocomponent().getPosta().setArray(sess().postesDg().allObjects());
		return wocomponent().doNothing();
	}

	// Supression d'un poste sŽlectionnŽ dans le tableau dynamique Recrutement
	public WOActionResults removeMatExt() {
		sess().poleMaterielsDg().setSelectedObject(sess().getMaterielRep());
		if (EOUtilities.primaryKeyForObject(edc(), sess().getMaterielRep()) != null) {
			sess().getMaterielRep().setTemvalide("N");
			sess().getMaterielRep().editingContext().saveChanges();
		}
		sess().poleMaterielsDg()._deleteObject(sess().poleMaterielsDg().selectedObject());
		wocomponent().getMata().setArray(sess().poleMaterielsDg().allObjects());
		return wocomponent().doNothing();
	}

	// Supression d'un poste sŽlectionnŽ dans le tableau dynamique Recrutement
	public WOActionResults removeNewMat() {
		sess().materielsDg().setSelectedObject(sess().getPoleNewMatRep());
		if (EOUtilities.primaryKeyForObject(edc(), sess().getPoleNewMatRep()) != null) {
			sess().getPoleNewMatRep().setTemvalide("N");
			sess().getPoleNewMatRep().editingContext().saveChanges();
		}
		sess().materielsDg()._deleteObject(sess().materielsDg().selectedObject());
		wocomponent().getMato().setArray(sess().materielsDg().allObjects());
		return wocomponent().doNothing();
	}

	// Initialisation de l'etat du projet
	public void EtatNouvoProjet() {
		for (int i = 0; i < sess().getListEtat1().count(); i++) {
			if (sess().getListEtat1().objectAtIndex(i).typrefnat().equals("SO")) {
				sess().setEtatRepetition1(sess().getListEtat1()
						.objectAtIndex(i));
			}
		}
	}

	// Enregistrement des modifications
	protected void save() {
		// Traitement Ecriture projet
		traitementProjet();
		// lancement de l'insertion de la liste des partenaire et des autres
		// Žquipes projets
		if (success)
			traitementPartenaire();
		if (success)
			traitementEquipe();
		// Traitement Axes STMR
		if (success)
			traitementStmr();
		// Traitement des mots clefs
		if (success)
			traitementMotClef();
		// Lancement de l'insertition des donnŽes du tableau dynamique
		if (success)
			traitementPersonnels();
		if (success)
			traitementPostes();
		if (success)
			traitementMateriels();
		if (success)
			traitementNewMateriel();
		// Fin insertion tableau dynamique

		// Envoie de mail en cas de soumission
		if (success)
			traitementMail();

		if (success) {
			sess().addSimpleInfoMessage(
					sess().localizer().localizedStringForKey("confirmation"),
					"confirmation");
			sess().resetAll();
			// Commit gŽnŽral de toutes les transaction
			sess().dataBus().commitTransaction();
		}
	}

	protected void traitementProjet() {
		EOPprec leNouveauProjet = null;
		// Traitement Ecriture projet
		try {
			// Traitement du projet
			EOPprec leProjet = trtProjet.projetEnCours(projet(), wocomponent());
			sess().setLeProjetEnCours(leProjet);
			leNouveauProjet = sess().leProjetEnCours();
			EOEditingContext edc = leNouveauProjet.editingContext();
			ProcessProjet.enregistrer(sess().dataBus(), edc(), leNouveauProjet);
			sess().setAlertMessage(null);
			sess().setIdProjetRecent(leNouveauProjet.getProjIdProc());
			// On refetch pour rŽcupŽrŽ le dernier enregistrement pour les
			// autres donnŽes dŽpendants de EOPPREC
			sess().setLeProjetEnCours((EOPprec) leNouveauProjet);
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementPartenaire() {
		try {
			NSArray<EOPartenaireProjet> lesPartenaires = trtPartenaire
					.partProj(wocomponent());
			trtPartenaire.traitementPartProjet(wocomponent(), lesPartenaires);
			if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementEquipe() {
		try {
			NSArray<EOEquipes> lesEquipes = trtEquipes
					.autrePRGAssocie(wocomponent());
			trtEquipes.traitementAutrePRGAssocie(lesEquipes, wocomponent());
			if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementStmr() {
		try {
			if (projet.toAxe() == null
					&& (projet.projthetv() == null || projet.projthetv()
							.equals("N"))) {
				NSArray<EORepartaxe> lesRepartAxes = trtRepartAxe
						.pstEncCours(wocomponent());
				trtRepartAxe.traitementPst(lesRepartAxes.immutableClone(),
						wocomponent());
			} else if (projet.projthetv() != null
					&& projet.projthetv().equals("O")
					&& sess().getSelectedStmrAxe() != null) {
				NSArray<EORepartaxe> lesRepartAxes = trtRepartAxe
						.pstEncCours(wocomponent());
				trtRepartAxe.traitementPst(lesRepartAxes.immutableClone(),
						wocomponent());
			}
			if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementMotClef() {
		try {
			NSArray<EOMotclefs> keywords = trtMotClefs.Keywords(wocomponent());
			trtMotClefs.traitementMotClefs(keywords, wocomponent());
			if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementPersonnels() {
		try {
			NSArray<EOPersonnel> lesPersonnel = trtPersonnel
					.personnelsEncCours(wocomponent(),
							wocomponent().getPersonnels(), personnel);
			trtPersonnel.traitementPersonnel(lesPersonnel, wocomponent());
			if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementPostes() {
		try {
			NSArray<EOPosterh> lesPotes = trtPoste.postesEncCours(wocomponent(),
					wocomponent().getPosteRh(), poste);
			trtPoste.traitementPoste(lesPotes, wocomponent());
			if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementMateriels() {
		try {

			NSArray<EOResmat> lesMatos = trtMateriel.materielsEncCours(
					wocomponent(), wocomponent().getResMat(), materiel);
			trtMateriel.traitementMateriel(lesMatos, wocomponent());
			if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementNewMateriel() {
		try {
			NSArray<EOResmat> lesNewMat = trtMateriel.newResMatEncCours(
					wocomponent(), wocomponent().getNewResMat(), materiel);
			trtMateriel.traitementMateriel(lesNewMat, wocomponent());
			if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
				throw new FactoryException(sess().getAlertMessage());
			success = true;
		} catch (FactoryException e) {
			sess().dataBus().rollbackTransaction();
			success = false;
			String alertMessage = e.getMessageFormatte();
			wocomponent().logger().info(alertMessage);
			wocomponent().logger().warn(e);
			// Exception contenant un message d'information pour
			// l'utilisateur
			sess().setAlertMessage(alertMessage);
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e.printStackTrace();
		} catch (EOGeneralAdaptorException e1) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(e1.getMessage(), e1);
			sess().setAlertMessage(e1.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			e1.printStackTrace();
		} catch (Exception re) {
			sess().dataBus().rollbackTransaction();
			success = false;
			wocomponent().logger().warn(re.getMessage(), re);
			sess().setAlertMessage(re.getMessage());
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					wocomponent().updateNextContainerId(), wocomponent().context());
			re.printStackTrace();
		}
	}

	protected void traitementMail() throws FactoryException {
		if (wocomponent().leProjetEnCours() != null
				&& wocomponent().leProjetEnCours().toEtat().typrefnat()
						.equals("SO")) {
			try {
				EOAlerte alerte = EOAlerte.numeroPourProjet(edc(), Integer
						.valueOf(wocomponent().leProjetEnCours().primaryKey()));
				if(alerte == null){
					alerte = EOAlerte.newEOAlerteInContext(edc(),
							wocomponent().leProjetEnCours());
					alerte.insertInEditingContext(edc());
					alerte.sendMailsNouvelleAlerte(sess(), wocomponent().leProjetEnCours());
					ProcessAlerte.enregistrer(sess().dataBus(), edc(), alerte);
					if(sess().getAlertMessage() != null && !sess().getAlertMessage().equals(""))
						throw new FactoryException(sess().getAlertMessage());
				} else {
					alerte.sendMailsNouvelleAlerte(sess(), wocomponent().leProjetEnCours());
				}
				success = true;
			} catch (Exception e) {
				sess().dataBus().rollbackTransaction();
				success = false;
				String alertMessage = e.getMessage();
				if(alertMessage == null)
					alertMessage="java.lang.NullPointerException"+"Aucune alerte mail pour le projet en modification";
				edc().revert();
				sess().setAlertMessage(alertMessage);
				wocomponent().context().response().setStatus(500);
				AjaxUpdateContainer.updateContainerWithID(
						wocomponent().updateNextContainerId(),
						wocomponent().context());
			}
		}
	}
}
