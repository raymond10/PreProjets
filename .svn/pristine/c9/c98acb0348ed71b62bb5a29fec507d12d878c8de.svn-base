/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 11 juin 2013
 */
@SuppressWarnings("all")
public class ManufactoryEquipe extends Manufactory {

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryEquipe(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ec
	 */
	public ManufactoryEquipe(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}

	public EOEquipes creerEquipeVierge() {
		EOEquipes repartEquipe = EOEquipes.createEOEquipes(ERXEC.newEditingContext());
		repartEquipe.setTemvalide("O");
		repartEquipe.setPrincipale("N");
		return repartEquipe;
	}
	
	// Equipes
	public void insEquipe(EOPprec projet, NSMutableArray listEquipe) throws Exception {
		for (EOStructureUlr equipe : (NSMutableArray<EOStructureUlr>) listEquipe) {
			enregistrementEquipe(projet, equipe);
		}
	}

	public void delEquipe(EOPprec projet, NSMutableArray listEquipe) throws Exception {
		for (EOStructureUlr equipe : (NSMutableArray<EOStructureUlr>) listEquipe) {
			suppressionEquipe(projet, equipe);
		}
	}

	// Enregistrement d'une Žquipe d'un projet
	protected void enregistrementEquipe(EOPprec projet, EOStructureUlr equipe)
			throws Exception {
		EOEquipes repartEquipe = creerEquipeVierge();
		EOEquipes repartExist = EOEquipes.equipePourProjetEtStructure(ERXEC.newEditingContext(), Integer.valueOf(projet.primaryKey()), equipe.cStructure());
		if (repartExist == null) {
			ec = repartEquipe.editingContext();
			if(projet.equipePrincipale().equals(equipe.cStructure())) {
				repartEquipe.setPrincipale("O");				
			} else {
				repartEquipe.setPrincipale("N");				
			}
			repartEquipe.setToProjetRelationship(projet.localInstanceIn(ec));
			//repartEquipe.setRechUnit(equipe.localInstanceIn(ec));
			repartEquipe.setCStructure(equipe.cStructure());
			repartEquipe.setProjetId(Integer.valueOf(projet.primaryKey()));
			trace("enregistrementEquipe()", repartEquipe);
			if (ec.hasChanges())
				ec.saveChanges();
		} else {
			repartExist.editingContext().saveChanges();
		}
	}

	// Suppression du partenaire d'un projet
	protected void suppressionEquipe(EOPprec projet, EOStructureUlr equipe)
			throws Exception {
		EOEquipes repartExist = EOEquipes.fetchEOEquipes(
				ERXEC.newEditingContext(),
				EOEquipes.TO_PROJET.eq(projet).and(EOEquipes.C_STRUCTURE.eq(equipe.cStructure()))
						.and(EOEquipes.PRINCIPALE.eq("N").or(EOEquipes.PRINCIPALE.eq("O"))));
		trace("suppressionEquipe()", repartExist);
		if (repartExist != null) {
			ec = repartExist.editingContext();
			ec.deleteObject(repartExist);
			if (ec.hasChanges())
				ec.saveChanges();
		}
	}
}
