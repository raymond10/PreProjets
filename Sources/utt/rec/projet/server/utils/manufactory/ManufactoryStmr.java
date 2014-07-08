/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORepartaxe;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 11 juin 2013
 */
@SuppressWarnings("all")
public class ManufactoryStmr extends Manufactory {

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryStmr(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ec
	 */
	public ManufactoryStmr(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}
	
	public EORepartaxe creerAxeStmrVierge() {
		EORepartaxe repartStmr = EORepartaxe.createEORepartaxe(ERXEC.newEditingContext());
		repartStmr.setTemvalide("O");
		repartStmr.setMajcreate(getDateJour());
		return repartStmr;
	}
	
	// STMR
	public void insAxeStmr(EOPprec projet, NSMutableArray listAxeStmr) throws Exception {
		for (EOAxerec axe : (NSMutableArray<EOAxerec>) listAxeStmr) {
			enregistrementStmr(projet, axe);
		}
	}

	public void delAxeStmr(EOPprec projet, NSMutableArray listAxeStmr) throws Exception {
		for (EOAxerec axe : (NSMutableArray<EOAxerec>) listAxeStmr) {
			suppressionStmr(projet, axe);
		}
	}

	// Enregistrement des Pst et axe d'un projet en Stmr
	protected void enregistrementStmr(EOPprec projet, EOAxerec axe)
			throws Exception {
		EORepartaxe repartStmr = creerAxeStmrVierge();
		EORepartaxe repartStmrExist = EORepartaxe.fetchEORepartaxe(
				ERXEC.newEditingContext(),
				EORepartaxe.TO_PROJET.eq(projet).and(EORepartaxe.TO_AXE.eq(axe)));
		if(repartStmrExist == null) {
			ec = repartStmr.editingContext();
			repartStmr.setToProjetRelationship(projet.localInstanceIn(ec));
			repartStmr.setToAxeRelationship(axe.localInstanceIn(ec));
			repartStmr.setProjetId(Integer.valueOf(projet.primaryKey()));
			repartStmr.setAxeId(Integer.valueOf(axe.primaryKey()));
			trace("enregistrementStmr()", repartStmr);
			if(ec.hasChanges())
				ec.saveChanges();
		} else {
			repartStmrExist.editingContext().saveChanges();
		}
	}

	// Suppression des Pst et axe d'un projet en Stmr
	protected void suppressionStmr(EOPprec projet, EOAxerec axe) throws Exception {
		EORepartaxe repartStmrExist = EORepartaxe.fetchEORepartaxe(
				ERXEC.newEditingContext(),
				EORepartaxe.TO_PROJET.eq(projet).and(EORepartaxe.TO_AXE.eq(axe)));
		trace("suppressionStmr()", repartStmrExist);
		if(repartStmrExist != null) {
			ec = repartStmrExist.editingContext();
			ec.deleteObject(repartStmrExist);
			if(ec.hasChanges())
				ec.saveChanges();
		}
	}
}
