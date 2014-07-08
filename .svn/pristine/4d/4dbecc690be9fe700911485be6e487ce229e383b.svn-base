package utt.rec.projet.server.components;

import utt.rec.projet.server.components.assistant.Assistant;
import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

public class AssistantProjet extends Assistant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7756352081219556914L;
	public static final String projet_BDG = "projet";
	private EOPprec projet;

	public AssistantProjet(WOContext context) {
        super(context);
		setEditMode(true);
    }
	
	@Override
	public void reset() {
		projet = null;
		setEditMode(false);
		super.reset();
	}
	
	/**
	 * @return the projet
	 */
	public EOPprec projet() {
		if (hasBinding(projet_BDG)) {
			projet = (EOPprec) valueForBinding(projet_BDG);
		}
		return projet;
	}

	/**
	 * @param projet
	 *            the projet to set
	 */
	public void setProjet(EOPprec projet) {
		this.projet = projet;
		if (hasBinding(projet_BDG)) {
			setValueForBinding(projet, projet_BDG);
		}
	}

	public boolean isPrecedentEnabled() {
		boolean precedentEnabled = !isPrecedentDisabled();
		return precedentEnabled;
	}

	public boolean isSuivantEnabled() {
		boolean suivantEnabled = !isSuivantDisabled();
		return suivantEnabled;
	}

	public boolean isTerminerEnabled() {
		boolean terminerEnabled = !isTerminerDisabled();
		return terminerEnabled;
	}
	
	public WOActionResults annuler() {
		Accueil nextPage = (Accueil) pageWithName(Accueil.class.getName());
		if (editingContext() != null) {
			editingContext().revert();
		} else if (projet() != null
				&& projet().editingContext() != null) {
			projet().editingContext().revert();
		}
		setIndexModuleActif(null);
		mySession().setIndexModuleActifGestionProjet(null);
		mySession().getUiMessages().removeAllObjects();
		mySession().reset();
		return nextPage;
	}

	public String getUneEtapeName() {
		String etapeName = "";
		if (uneEtape != null) {
			etapeName = uneEtape;
		}
		return etapeName;
	}

	public boolean isModuleEtapeActive() {
		return (uneEtape != null) ? isEtapeActive() : false;
	}
}