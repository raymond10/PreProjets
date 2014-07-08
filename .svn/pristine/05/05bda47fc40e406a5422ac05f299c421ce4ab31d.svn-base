/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 17 juin 2013
 */
@SuppressWarnings("all")
public class ManufactoryPersonnelRhs extends Manufactory {

	/**
	 * @param ec
	 */
	public ManufactoryPersonnelRhs(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryPersonnelRhs(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}

	public EOPersonnel creerPersonnelVierge(EOEditingContext ec) {
		EOPersonnel personnel = EOPersonnel.createEOPersonnel(ec);
		personnel.setTempsuitl("5");
		personnel.setTemvalide("O");
		return personnel;
	}

	public void insPersonnel(EOPprec projet, NSMutableArray listPers)
			throws Exception {
		for (EOPersonnel personnel : (NSMutableArray<EOPersonnel>) listPers) {
			enregistrementPersonnelRh(projet, personnel);
		}
	}

	public void delPersonnel(EOPprec projet, NSMutableArray listPers) throws Exception {
		for (EOPersonnel personnel : (NSMutableArray<EOPersonnel>) listPers) {
			SuppressionPersonnelRh(projet, personnel);
		}
	}

	// Enregistrement du personnel pour un projet
	protected void enregistrementPersonnelRh(EOPprec projet,
			EOPersonnel personnel) throws Exception {
		String cStructure = personnel.cStructure();
		Integer noIndividu = personnel.noIndividu();
		Integer projetId = Integer.valueOf(projet.primaryKey());
		trace("enregistrementPersonnelRh()", personnel);
		EOPersonnel pers = EOPersonnel.fetchUnPersonnel(ec,cStructure,noIndividu,projetId).lastObject();
		if (pers == null) {
			ec = personnel.editingContext();
			personnel.setToProjet(projet.localInstanceIn(ec));
			trace("enregistrementPersonnelRh()", personnel);
			if (ec.hasChanges())
				ec.saveChanges();
		} else {
			pers.editingContext().saveChanges();
		}
	}

	// Suppression du personnel pour un projet
	protected void SuppressionPersonnelRh(EOPprec projet, EOPersonnel personnel)
			throws Exception {
		String cStructure = personnel.cStructure();
		Integer noIndividu = personnel.noIndividu();
		Integer projetId = Integer.valueOf(projet.primaryKey());
		trace("SuppressionPersonnelRh()", personnel);
		EOPersonnel pers = EOPersonnel.fetchUnPersonnel(ec,cStructure,noIndividu,projetId).lastObject();
		if (pers != null) {
			ec = pers.editingContext();
			ec.deleteObject(pers);
			if (ec.hasChanges())
				ec.saveChanges();
		}
	}

}
