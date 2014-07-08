/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOVtyprhcm;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 17 juin 2013
 */
@SuppressWarnings("all")
public class ManufactoryRecrue extends Manufactory {

	/**
	 * @param ec
	 */
	public ManufactoryRecrue(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}

	public void insPoste(EOPprec projet, NSMutableArray listPoste)
			throws Exception {
		for (EOPosterh poste : (NSMutableArray<EOPosterh>) listPoste) {
			enregistrementPoste(projet, poste);
		}
	}

	public void delPoste(EOPprec projet, NSMutableArray listPoste)
			throws Exception {
		for (EOPosterh poste : (NSMutableArray<EOPosterh>) listPoste) {
			suppressionPoste(projet, poste);
		}
	}

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryRecrue(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}

	public EOPosterh creerPosteVierge() {
		EOPosterh poste = EOPosterh.createEOPosterh(ERXEC.newEditingContext());
		poste.setTxfinancement("5");
		poste.setTemvalide("O");
		poste.setCreadate(getDateJour());
		return poste;
	}

	// Enregistrement d'un poste pour un projet
	protected void enregistrementPoste(EOPprec projet, EOPosterh poste)
			throws Exception {
		String cStructure = poste.cStructure();
		Integer typrhcmId = poste.toCategorieRh().typrhcmId();
		EOStructureUlr pole = EOStructureUlr.structurePourcStructure(ec, cStructure);
		EOVtyprhcm categorieRh = EOVtyprhcm.categorieRhPourId(ec, typrhcmId);
		EOPosterh recrue = EOPosterh.fetchEOPosterh(
				ERXEC.newEditingContext(),
				EOPosterh.TO_PROJET.eq(projet)
						.and(EOPosterh.C_STRUCTURE.eq(cStructure))
						.and(EOPosterh.TO_CATEGORIE_RH.eq(categorieRh)));
		if (recrue == null) {
			ec = poste.editingContext();
			poste.setProjetId(Integer.valueOf(projet.primaryKey()));
			poste.setTyprhcmId(typrhcmId);
			poste.setToProjetRelationship(projet.localInstanceIn(ec));
			if (ec.hasChanges())
				ec.saveChanges();
		} else {
			recrue.editingContext().saveChanges();
		}
	}

	// suppression d'un poste pour un projet
	protected void suppressionPoste(EOPprec projet, EOPosterh poste)
			throws Exception {
		String cStructure = poste.cStructure();
		Integer typrhcmId = poste.toCategorieRh().typrhcmId();
		EOStructureUlr pole = EOStructureUlr.structurePourcStructure(ec, cStructure);
		EOVtyprhcm categorieRh = EOVtyprhcm.categorieRhPourId(ec, typrhcmId);
		EOPosterh recrue = EOPosterh.fetchEOPosterh(
				ERXEC.newEditingContext(),
				EOPosterh.TO_PROJET.eq(projet)
						.and(EOPosterh.C_STRUCTURE.eq(cStructure))
						.and(EOPosterh.TO_CATEGORIE_RH.eq(categorieRh)));
		if (recrue != null) {
			ec = recrue.editingContext();
			ec.deleteObject(recrue);
			if (ec.hasChanges())
				ec.saveChanges();
		}
	}

}
