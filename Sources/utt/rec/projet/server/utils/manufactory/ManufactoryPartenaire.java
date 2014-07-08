/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 7 juin 2013
 */
@SuppressWarnings("all")
public class ManufactoryPartenaire extends Manufactory {

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryPartenaire(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ec
	 */
	public ManufactoryPartenaire(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}

	public EOTyppartenaire creerPartenaireVierge() {
		EOTyppartenaire partenaire = EOTyppartenaire.createEOTyppartenaire(ec);
		//partenaire.setPartCleunik(autoPartCleunik());
		return partenaire;
	}

	// Calcul autoMatique Clé unik partenaire
	protected String autoPartCleunik() {
		NSArray<EOTyppartenaire> tmp = EOTyppartenaire
				.fetchAllEOTyppartenaires(ec, new NSArray(
						EOTyppartenaire.PART_CLEUNIK.desc()));
		EOTyppartenaire tmpz = tmp.objectAtIndex(0);
		Long calc = Long.parseLong(tmpz.partCleunik()) + 1;
		String cal = calc.toString();
		String cleunik = tmpz.partCleunik().substring(0,
				tmpz.partCleunik().length() - cal.length());
		return cleunik + cal;
	}
	
	// Partenaires
	public void insPartenaire(EOPprec projet, NSMutableArray listPartenaire) throws Exception {
		for (EOTyppartenaire repart : (NSMutableArray<EOTyppartenaire>) listPartenaire) {
			enregistrementPartenaire(projet, repart);
		}
	}

	public void delPartenaire(EOPprec projet, NSMutableArray listPartenaire) throws Exception {
		for (EOTyppartenaire repart : (NSMutableArray<EOTyppartenaire>) listPartenaire) {
			suppressionPartenaire(projet, repart);
		}
	}

	// Enregistrement du partenaire d'un projet
	protected void enregistrementPartenaire(EOPprec projet,
			EOTyppartenaire partenaire) throws Exception {
		EOPartenaireProjet repartPartenaire = EOPartenaireProjet
				.createEOPartenaireProjet(ERXEC.newEditingContext());
		EOPartenaireProjet repartExist = EOPartenaireProjet
				.fetchEOPartenaireProjet(
						ERXEC.newEditingContext(),
						EOPartenaireProjet.TO_PROJET.eq(projet).and(
								EOPartenaireProjet.TO_PARTENAIRE.eq(partenaire)));
		trace("enregistrementPartenaire()", repartPartenaire);
		if (repartExist == null) {
			ec = repartPartenaire.editingContext();
			repartPartenaire.setToProjetRelationship(projet.localInstanceIn(ec));
			repartPartenaire.setToPartenaireRelationship(partenaire
					.localInstanceIn(ec));
			repartPartenaire.setProjetId(Integer.valueOf(projet.primaryKey()));
			repartPartenaire.setTyppartId(Integer.valueOf(partenaire.primaryKey()));
			repartPartenaire.setTemvalide("O");
			trace("enregistrementPartenaire()", repartPartenaire);
			if (ec.hasChanges())
				ec.saveChanges();
		} else {
			repartExist.editingContext().saveChanges();
		}
	}

	// Suppression du partenaire d'un projet
	protected void suppressionPartenaire(EOPprec projet, EOTyppartenaire partenaire)
			throws Exception {
		EOPartenaireProjet repartExist = EOPartenaireProjet
				.fetchEOPartenaireProjet(
						ERXEC.newEditingContext(),
						EOPartenaireProjet.TO_PROJET.eq(projet).and(
								EOPartenaireProjet.TO_PARTENAIRE.eq(partenaire)));
		trace("suppressionPartenaire()", repartExist);
		if (repartExist != null) {
			ec = repartExist.editingContext();
			ec.deleteObject(repartExist);
			if (ec.hasChanges())
				ec.saveChanges();
		}
	}

}
