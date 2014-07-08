/**
 * 
 */
package utt.rec.projet.server.components.controler;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSForwardException;

import er.ajax.AjaxUpdateContainer;
import er.extensions.eof.ERXEC;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.NouveauPartenaire;
import utt.rec.projet.server.components.PartenaireCompletion;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.utils.manufactory.ManufactoryPartenaire;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 19 mars 2014
 * 
 */
@SuppressWarnings("all")
public class PartenaireCompletionCtrl extends ModuleCtrl<PartenaireCompletion> {

	private EOEditingContext edc;
	private Session sess;

	private NSArray<EOTyppartenaire> toutPartenaires;
	// Liste partenaire selectionne
	private NSArray<EOTyppartenaire> newPartList;
	private EOTyppartenaire partenaireItem;
	private WODisplayGroup partenaireDg;
	// Nouveau Partenaire
	private boolean resetAjoutPartenaireDialog;
	private EOEditingContext editingContextForPartner;

	/**
	 * @param component
	 */
	public PartenaireCompletionCtrl(PartenaireCompletion component) {
		super(component);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the edc
	 */
	public EOEditingContext edc() {
		if (edc == null)
			edc = wocomponent().edcProjet();
		return edc;
	}

	/**
	 * @param edc
	 *            the edc to set
	 */
	public void setEdc(EOEditingContext edc) {
		this.edc = edc;
	}

	/**
	 * @return the sess
	 */
	public Session sess() {
		if (sess == null)
			sess = wocomponent().mySession();
		return sess;
	}

	/**
	 * @param sess
	 *            the sess to set
	 */
	public void setSess(Session sess) {
		this.sess = sess;
	}

	/**
	 * @return the newPartList
	 */
	public NSArray<EOTyppartenaire> newPartList() {
		return newPartList;
	}

	/**
	 * @param newPartList
	 *            the newPartList to set
	 */
	public void setNewPartList(NSArray<EOTyppartenaire> newPartList) {
		this.newPartList = newPartList;
	}

	/**
	 * @return the partenaireItem
	 */
	public EOTyppartenaire partenaireItem() {
		return partenaireItem;
	}

	/**
	 * @param partenaireItem
	 *            the partenaireItem to set
	 */
	public void setPartenaireItem(EOTyppartenaire partenaireItem) {
		this.partenaireItem = partenaireItem;
	}

	/**
	 * @return the partenaireDg
	 */
	public WODisplayGroup partenaireDg() {
		if (partenaireDg == null) {
			partenaireDg = new WODisplayGroup();
			partenaireDg.setObjectArray(sess().selectedPartenaires()
					.immutableClone());
		}
		return partenaireDg;
	}

	/**
	 * @param partenaireDg
	 *            the partenaireDg to set
	 */
	public void setPartenaireDg(WODisplayGroup partenaireDg) {
		this.partenaireDg = partenaireDg;
	}

	/**
	 * @return the toutPartenaires
	 */
	public NSArray<EOTyppartenaire> toutPartenaires() {
		if (toutPartenaires == null)
			toutPartenaires = new NSArray<EOTyppartenaire>();
		return toutPartenaires;
	}

	/**
	 * @param toutPartenaires
	 *            the toutPartenaires to set
	 */
	public void setToutPartenaires(NSArray<EOTyppartenaire> toutPartenaires) {
		this.toutPartenaires = toutPartenaires;
	}

	public void refreshPartenaireList() {
		toutPartenaires = EOTyppartenaire.fetchAllEOTyppartenaires(edc(),
				new NSArray(EOTyppartenaire.DENOM_USUELLE.asc()));
		if (sess().lastCreatedPartenaire() != null) {
			wocomponent().setPartenaireSelected(sess().lastCreatedPartenaire());
			onPart();
		}
	}

	public NSArray<EOTyppartenaire> currentsPartenaires(String value) {
		NSArray<EOTyppartenaire> searchResult = EOTyppartenaire.DENOM_USUELLE
				.containsAll(value).filtered(toutPartenaires());
		return searchResult;
	}

	// SŽlection d'un partenaire
	public WOActionResults onPart() {
		if (wocomponent().partenaireSelected() != null) {
			if (!(sess().selectedPartenaires().contains(wocomponent()
					.partenaireSelected()))) {
				sess().selectedPartenaires().addObject(
						wocomponent().partenaireSelected());
				setPartenaireDg(null);
			}
			sess().removedPartenaires().removeObject(
					wocomponent().partenaireSelected());
			wocomponent().setPartenaireSelected(null);
			wocomponent().setMotPartenaire(null);
		}
		// Contournement du bug Ajax Repsonse
		if (sess().lastCreatedPartenaire() == null) {
			wocomponent().context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(wocomponent()
					.partenaireFetchId(), wocomponent().context());
		}
		sess().setLastCreatedPartenaire(null);
		return wocomponent().doNothing();
	}

	// Remove item form partnerList
	public WOActionResults removeSelectedPartenaire() {
		try {
			setPartenaireDg(null);
			sess().selectedPartenaires().removeObject(partenaireItem());
			if (!sess().removedPartenaires().contains(partenaireItem()))
				sess().removedPartenaires().addObject(partenaireItem());
			if (sess().selectedPartenaires().count() == 0) {
				sess().setPartenaire(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			sess().addSimpleErrorMessage("Supression partenaire",
					e.getLocalizedMessage());
		}
		return null;
	}

	/**
	 * @return the resetAjoutPartenaireDialog
	 */
	public boolean isResetAjoutPartenaireDialog() {
		return resetAjoutPartenaireDialog;
	}

	/**
	 * @param resetAjoutPartenaireDialog
	 *            the resetAjoutPartenaireDialog to set
	 */
	public void setResetAjoutPartenaireDialog(boolean resetAjoutPartenaireDialog) {
		this.resetAjoutPartenaireDialog = resetAjoutPartenaireDialog;
	}

	/**
	 * @return the editingContextForPartner
	 */
	public EOEditingContext getEditingContextForPartner() {
		if (editingContextForPartner == null) {
			editingContextForPartner = edc();
		}
		return editingContextForPartner;
	}

	/**
	 * @param editingContextForPartner
	 *            the editingContextForPartner to set
	 */
	public void setEditingContextForPartner(
			EOEditingContext editingContextForPartner) {
		this.editingContextForPartner = editingContextForPartner;
	}

	public boolean peutNouveauPartenaire() {
		Boolean partenaireCreate = null;
		if (wocomponent().myApp().newGestionDroitsEnabled()) {
			partenaireCreate = wocomponent().myAppGDUser()
					.getPprecAutorisationCache().gDPprecCreationProjet()
					|| wocomponent().myAppGDUser().getPprecAutorisationCache()
							.gDPprecSuperUserProjet();
		} else {
			partenaireCreate = wocomponent().myAppJAUser()
					.hasDroitCreationProjet()
					|| wocomponent().myAppJAUser().hasDroitSuperUserProjet();
		}
		return partenaireCreate;
	}

	public WOActionResults openAjouterPartenaire() {
		NouveauPartenaire page = null;
		try {
			ManufactoryPartenaire mfp = new ManufactoryPartenaire(
					ERXEC.newEditingContext(), true);
			EOTyppartenaire partenaire = mfp.creerPartenaireVierge();
			setResetAjoutPartenaireDialog(true);
			page = (NouveauPartenaire) wocomponent().pageWithName(
					NouveauPartenaire.class.getName());
			page.setEditingContext(getEditingContextForPartner());
			page.setResetAjoutPartenaireDialog(true);
			page.setPartenaire(partenaire);
		} catch (Exception e) {
			throw NSForwardException._runtimeExceptionForThrowable(e);
		}
		return page;
	}

}
