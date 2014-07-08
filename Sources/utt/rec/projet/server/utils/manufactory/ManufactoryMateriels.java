/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import java.math.BigDecimal;

import utt.rec.projet.server.metier.admrec.EOGemateriel;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 17 juin 2013
 */
@SuppressWarnings("all")
public class ManufactoryMateriels extends Manufactory {

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryMateriels(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ec
	 */
	public ManufactoryMateriels(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}

	public EOResmat creerMaterielExistantVierge() {
		EOResmat materiel = EOResmat.createEOResmat(ERXEC.newEditingContext());
		materiel.setMatutil("5");
		materiel.setTxfinancement("N/A");
		materiel.setMatexist("O");
		materiel.setTemvalide("O");
		materiel.setCoutestime(new BigDecimal(0));
		return materiel;
	}

	public EOResmat creerNouveauMaterielVierge() {
		EOResmat materiel = EOResmat.createEOResmat(ERXEC.newEditingContext());
		materiel.setMatutil("N/A");
		materiel.setTxfinancement("5");
		materiel.setMatexist("N");
		materiel.setTemvalide("O");
		materiel.setCoutestime(new BigDecimal(0));
		return materiel;
	}

	public void insMateriel(EOPprec projet, NSMutableArray listMateriel)
			throws Exception {
		for (EOResmat materiel : (NSMutableArray<EOResmat>) listMateriel) {
			enregistrementMateriel(projet, materiel);
		}
	}
	
	public void delMateriel(EOPprec projet, NSMutableArray listMateriel)
			throws Exception {
		for (EOResmat materiel : (NSMutableArray<EOResmat>) listMateriel) {
			suppressionMateriel(projet, materiel);
		}
	}

	// Enregistrement d'un poste pour un projet
	protected void enregistrementMateriel(EOPprec projet, EOResmat materiel)
			throws Exception {
		String cStructure = materiel.cStructure();
		String pfmatId = materiel.toPlateauTech().pfmatId();
		Integer gematId = Integer.valueOf(materiel.toGrandEquipement().primaryKey());
		EOStructureUlr pole = EOStructureUlr.structurePourcStructure(ec, cStructure);
		EOPfmateriel plateau = EOPfmateriel.plateauPourNumero(ec, pfmatId);
		EOGemateriel gemat = EOGemateriel.gematerielPourNumero(ec, gematId);
		EOResmat mat = EOResmat.fetchEOResmat(
				ERXEC.newEditingContext(),
				EOResmat.TO_PROJET
						.eq(projet)
						.and(EOResmat.C_STRUCTURE.eq(cStructure))
						.and(EOResmat.TO_PLATEAU_TECH.eq(plateau))
						.and(EOResmat.TO_GRAND_EQUIPEMENT.eq(gemat)));
		if (mat == null) {
			ec = materiel.editingContext();
			materiel.setPfmatId(pfmatId);
			materiel.setGematId(gematId);
			materiel.setProjetId(Integer.valueOf(projet.primaryKey()));
			materiel.setToProjetRelationship(projet.localInstanceIn(ec));
			if (ec.hasChanges())
				ec.saveChanges();
		} else {
			mat.setMajdate(getDateJour());
			mat.editingContext().saveChanges();
		}
	}

	// suppression d'un materiel pour un projet
	protected void suppressionMateriel(EOPprec projet, EOResmat materiel)
			throws Exception {
		String cStructure = materiel.cStructure();
		String pfmatId = materiel.toPlateauTech().pfmatId();
		Integer gematId = Integer.valueOf(materiel.toGrandEquipement().primaryKey());
		EOStructureUlr pole = EOStructureUlr.structurePourcStructure(ec, cStructure);
		EOPfmateriel plateau = EOPfmateriel.plateauPourNumero(ec, pfmatId);
		EOGemateriel gemat = EOGemateriel.gematerielPourNumero(ec, gematId);
		EOResmat mat = EOResmat.fetchEOResmat(
				ERXEC.newEditingContext(),
				EOResmat.TO_PROJET
						.eq(projet)
						.and(EOResmat.C_STRUCTURE.eq(cStructure))
						.and(EOResmat.TO_PLATEAU_TECH.eq(plateau))
						.and(EOResmat.TO_GRAND_EQUIPEMENT.eq(gemat)));
		if (mat != null) {
			ec = mat.editingContext();
			ec.deleteObject(mat);
			if (ec.hasChanges())
				ec.saveChanges();
		}
	}

}
