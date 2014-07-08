/**
 * 
 */
package utt.rec.projet.server.components.assistant;


import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSNotificationCenter;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSValidation.ValidationException;

import er.extensions.eof.ERXEC;
import utt.rec.projet.server.components.Accueil;
import utt.rec.projet.server.components.MonComposant;
import utt.rec.projet.server.components.controler.ModuleCtrl;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.admrec.EOVrhcmval;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 3 juin 2013
 */
@SuppressWarnings("all")
public class MAssistant extends MonComposant implements IAssistant {
	

	public static final String EDITING_CONTEXT_BDG = "editingContext";
	public static final String BDG_utilisateurPersId = "utilisateurPersId";
	public static String ASSISTANT_BDG = "assistant";
	public static final String MODULE_BDG = "module";
	private ModuleCtrl ctrl = null;


	private Integer utilisateurPersId;
	private Assistant assistant;
	private EOEditingContext editingContext;
	private IAssistant module;
	
	private String failureMessage;
	public static final String BDG_projet = "projet";
	public static final String BDG_contrat = "contrat";
	public static final String BDG_axe = "axe";
	public static final String BDG_partenaire = "partenaire";
	public static final String BDG_selectedMotClefs = "selectedMotClefs";
	public static final String BDG_removedMotClefs = "removedMotClefs";
	private EOPprec projet;
	private EOTyppartenaire partenaire;
	// Page1
	private String contexte;
	private String problematique;
	private String objectifs;
	private String methodologie;

	// Page2
	private NSMutableArray selectedPersonnelProjet;
	private NSMutableArray removedPersonnelProjet;
	private NSMutableArray selectedPosteProjet;
	private NSMutableArray removedPosteProjet;
	private NSMutableArray selectedMaterielProjet;
	private NSMutableArray removedMaterielProjet;
	private NSMutableArray selectedNouveauMaterielProjet;
	private NSMutableArray removedNouveauMaterielProjet;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5776624097684254654L;

	/**
	 * @param context
	 */
	public MAssistant(WOContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public MAssistant(WOContext context, ModuleCtrl controler) {
		super(context);
		// TODO Auto-generated constructor stub
		ctrl = controler;
	}

	@Override
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
	}

	/**
	 * @return the ctrl
	 */
	public ModuleCtrl ctrl() {
		return ctrl;
	}

	/**
	 * @param ctrl
	 *            the ctrl to set
	 */
	public void setCtrl(ModuleCtrl ctrl) {
		this.ctrl = ctrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.IAssistant#onPrecedent()
	 */
	@Override
	public void onPrecedent() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * utt.rec.projet.server.components.assistant.IAssistant#isPrecedentDisabled
	 * ()
	 */
	@Override
	public boolean isPrecedentDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.IAssistant#onSuivant()
	 */
	@Override
	public void onSuivant() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * utt.rec.projet.server.components.assistant.IAssistant#isSuivantDisabled()
	 */
	@Override
	public boolean isSuivantDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utt.rec.projet.server.components.assistant.IAssistant#valider()
	 */
	@Override
	public boolean valider() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * utt.rec.projet.server.components.assistant.IAssistant#isTerminerDisabled
	 * ()
	 */
	@Override
	public boolean isTerminerDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * utt.rec.projet.server.components.assistant.IAssistant#editingContext()
	 */
	@Override
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
	 * @return the partenaire
	 */
	public EOTyppartenaire partenaire() {
		if(partenaire == null) {
			EOTyppartenaire partenaireParent = (EOTyppartenaire) valueForBinding(BDG_partenaire);
			if(partenaireParent != null && partenaireParent.editingContext() != null)
				partenaire = partenaireParent;
		}
		return partenaire;
	}

	/**
	 * @param partenaire the partenaire to set
	 */
	public void setPartenaire(EOTyppartenaire partenaire) {
		this.partenaire = partenaire;
		setValueForBinding(partenaire, BDG_partenaire);
	}

	/**
	 * @return the contexte
	 */
	public String contexte() {
		EOPprec projet = myProjet();
		if (projet != null)
			contexte = projet.projctx();
		return contexte;
	}

	/**
	 * @param contexte
	 *            the contexte to set
	 */
	public void setContexte(String contexte) {
		EOPprec projet = myProjet();
		this.contexte = contexte;
		if (projet != null)
			projet.setProjctx(contexte);
	}

	/**
	 * @return the problematique
	 */
	public String problematique() {
		EOPprec projet = myProjet();
		if (projet != null)
			problematique = projet.projpblm();
		return problematique;
	}

	/**
	 * @param problematique
	 *            the problematique to set
	 */
	public void setProblematique(String problematique) {
		EOPprec projet = myProjet();
		this.problematique = problematique;
		if (projet != null)
			projet.setProjpblm(problematique);
	}

	/**
	 * @return the objectifs
	 */
	public String objectifs() {
		EOPprec projet = myProjet();
		if (projet != null)
			objectifs = projet.projobf();
		return objectifs;
	}

	/**
	 * @param objectifs
	 *            the objectifs to set
	 */
	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
		EOPprec projet = myProjet();
		if (projet != null)
			projet.setProjobf(objectifs);
	}

	/**
	 * @return the methodologie
	 */
	public String methodologie() {
		EOPprec projet = myProjet();
		if (projet != null)
			methodologie = projet.projmtdg();
		return methodologie;
	}

	/**
	 * @param methodologie
	 *            the methodologie to set
	 */
	public void setMethodologie(String methodologie) {
		EOPprec projet = myProjet();
		this.methodologie = methodologie;
		if (projet != null)
			projet.setProjmtdg(methodologie);
	}

	/**
	 * @return the selectedPersonnelProjet
	 */
	public NSMutableArray selectedPersonnelProjet() {
		if (selectedPersonnelProjet == null) {
			EOPprec projet = myProjet();
			if (projet != null) {
				NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
				bindings.takeValueForKey(Long.valueOf(projet.primaryKey()),
						"projetId");
				selectedPersonnelProjet = EOPersonnel.fetchPersonnelProjet(
						editingContext(), bindings).mutableClone();
			} else {
				selectedPersonnelProjet = new NSMutableArray();
			}
		}
		return selectedPersonnelProjet;
	}

	/**
	 * @param selectedPersonnelProjet
	 *            the selectedPersonnelProjet to set
	 */
	public void setSelectedPersonnelProjet(
			NSMutableArray selectedPersonnelProjet) {
		this.selectedPersonnelProjet = selectedPersonnelProjet;
	}

	/**
	 * @return the removedPersonnelProjet
	 */
	public NSMutableArray removedPersonnelProjet() {
		if (removedPersonnelProjet == null)
			removedPersonnelProjet = new NSMutableArray();
		return removedPersonnelProjet;
	}

	/**
	 * @param removedPersonnelProjet
	 *            the removedPersonnelProjet to set
	 */
	public void setRemovedPersonnelProjet(NSMutableArray removedPersonnelProjet) {
		this.removedPersonnelProjet = removedPersonnelProjet;
	}

	/**
	 * @return the selectedPosteProjet
	 */
	public NSMutableArray selectedPosteProjet() {
		if (selectedPosteProjet == null) {
			EOPprec projet = myProjet();
			if (projet != null) {
				NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
				bindings.takeValueForKey(Long.valueOf(projet.primaryKey()),
						"projetId");
				selectedPosteProjet = EOPosterh.fetchPosteProjet(
						editingContext(), bindings).mutableClone();
			} else {
				selectedPosteProjet = new NSMutableArray();
			}
		}
		return selectedPosteProjet;
	}

	/**
	 * @param selectedPosteProjet
	 *            the selectedPosteProjet to set
	 */
	public void setSelectedPosteProjet(NSMutableArray selectedPosteProjet) {
		this.selectedPosteProjet = selectedPosteProjet;
	}

	/**
	 * @return the removedPosteProjet
	 */
	public NSMutableArray removedPosteProjet() {
		if (removedPosteProjet == null)
			removedPosteProjet = new NSMutableArray();
		return removedPosteProjet;
	}

	/**
	 * @param removedPosteProjet
	 *            the removedPosteProjet to set
	 */
	public void setRemovedPosteProjet(NSMutableArray removedPosteProjet) {
		this.removedPosteProjet = removedPosteProjet;
	}

	/**
	 * @return the selectedMaterielProjet
	 */
	public NSMutableArray selectedMaterielProjet() {
		if (selectedMaterielProjet == null) {
			EOPprec projet = myProjet();
			if (projet != null) {
				NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
				bindings.takeValueForKey(Long.valueOf(projet.primaryKey()),
						"projetId");
				selectedMaterielProjet = EOResmat.fetchMaterielProjet(
						editingContext(), bindings).mutableClone();

			} else {
				selectedMaterielProjet = null;
			}
		}
		return selectedMaterielProjet;
	}

	/**
	 * @param selectedMaterielProjet
	 *            the selectedMaterielProjet to set
	 */
	public void setSelectedMaterielProjet(NSMutableArray selectedMaterielProjet) {
		this.selectedMaterielProjet = selectedMaterielProjet;
	}

	/**
	 * @return the removedMaterielProjet
	 */
	public NSMutableArray removedMaterielProjet() {
		if (removedMaterielProjet == null)
			removedMaterielProjet = new NSMutableArray();
		return removedMaterielProjet;
	}

	/**
	 * @param removedMaterielProjet
	 *            the removedMaterielProjet to set
	 */
	public void setRemovedMaterielProjet(NSMutableArray removedMaterielProjet) {
		this.removedMaterielProjet = removedMaterielProjet;
	}

	/**
	 * @return the selectedNouveauMaterielProjet
	 */
	public NSMutableArray selectedNouveauMaterielProjet() {
		if (selectedNouveauMaterielProjet == null) {
			EOPprec projet = myProjet();
			if (projet != null) {
				NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
				bindings.takeValueForKey(Long.valueOf(projet.primaryKey()),
						"projetId");
				selectedNouveauMaterielProjet = EOResmat
						.fetchNouceauMaterielProjet(editingContext(), bindings)
						.mutableClone();
			} else {
				selectedNouveauMaterielProjet = new NSMutableArray();
			}
		}
		return selectedNouveauMaterielProjet;
	}

	/**
	 * @param selectedNouveauMaterielProjet
	 *            the selectedNouveauMaterielProjet to set
	 */
	public void setSelectedNouveauMaterielProjet(
			NSMutableArray selectedNouveauMaterielProjet) {
		this.selectedNouveauMaterielProjet = selectedNouveauMaterielProjet;
	}

	/**
	 * @return the removedNouveauMaterielProjet
	 */
	public NSMutableArray removedNouveauMaterielProjet() {
		if (removedNouveauMaterielProjet == null)
			removedNouveauMaterielProjet = new NSMutableArray();
		return removedNouveauMaterielProjet;
	}

	/**
	 * @param removedNouveauMaterielProjet
	 *            the removedNouveauMaterielProjet to set
	 */
	public void setRemovedNouveauMaterielProjet(
			NSMutableArray removedNouveauMaterielProjet) {
		this.removedNouveauMaterielProjet = removedNouveauMaterielProjet;
	}

	/**
	 * @return the assistant
	 */
	public Assistant assistant() {
		if (hasBinding(ASSISTANT_BDG)) {
			assistant = (Assistant) valueForBinding(ASSISTANT_BDG);
		}
		return assistant;
	}

	/**
	 * @param assistant
	 *            the assistant to set
	 */
	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
		if (hasBinding(ASSISTANT_BDG)) {
			setValueForBinding(assistant, ASSISTANT_BDG);
		}
	}

	/**
	 * @return the utilisateurPersId
	 */
	public Integer utilisateurPersId() {
		if (hasBinding(BDG_utilisateurPersId)) {
			utilisateurPersId = (Integer) valueForBinding(BDG_utilisateurPersId);
		}
		return utilisateurPersId;
	}

	/**
	 * @param utilisateurPersId
	 *            the utilisateurPersId to set
	 */
	public void setUtilisateurPersId(Integer utilisateurPersId) {
		this.utilisateurPersId = utilisateurPersId;
		if (hasBinding(BDG_utilisateurPersId)) {
			setValueForBinding(utilisateurPersId, BDG_utilisateurPersId);
		}
	}
	
	/**
	 * @return the module
	 */
	public IAssistant module() {
		return module;
	}

	/**
	 * @param module
	 *            the module to set
	 */
	public void setModule(IAssistant module) {
		this.module = module;
		setValueForBinding(module, MODULE_BDG);
	}
	
	// Traitement
		public WOActionResults enregistrer() {
			try {
				myProjet().setCreadate(new NSTimestamp());
				myProjet().setMajauteur(utilisateurPersId().toString());
				editingContext().saveChanges();
				NSMutableDictionary userInfos = new NSMutableDictionary();
				userInfos.setObjectForKey(editingContext(), "edc");
				NSNotificationCenter.defaultCenter().postNotification(
						"refreshTranchesNotification", this, userInfos);
				mySession().addSimpleInfoMessage(
						"RFCCT",
						"Competence '" + myProjet().primaryKey()
								+ "' modifiée avec succès");
			} catch (ValidationException e) {
				context().response().setStatus(500);
				mySession().addSimpleErrorMessage("RFCCT", e.getMessage());
			} catch (Throwable e) {
				context().response().setStatus(500);
				throw NSForwardException._runtimeExceptionForThrowable(e);
			}
			return null;
		}

		public WOActionResults accueil() {
			return (Accueil) pageWithName(Accueil.class.getName());
		}

		/*public WOActionResults consulter() {
			Competence nextPage = (Competence) pageWithName(Competence.class
					.getName());
			nextPage.setCompetence(myProjet());
			mySession().setPageCompetence(nextPage);
			return nextPage;
		}*/

		public void sleep() {
			super.sleep();
			this.projet = null;
			this.failureMessage = null;
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
			} else {
				mySession().addSimpleErrorMessage("", "");
			}
		}

}
