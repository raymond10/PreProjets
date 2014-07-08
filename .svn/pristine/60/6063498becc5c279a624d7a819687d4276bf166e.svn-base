/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOTypref;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 6 juin 2013
 */
@SuppressWarnings("all")
public class ManufactoryProjet extends Manufactory {

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryProjet(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ec
	 */
	public ManufactoryProjet(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}

	public EOPprec creerProjetVierge(Integer persId) {
		EOPprec projet = EOPprec.createEOPprec(ec);
		EOTypref etat = EOTypref.fetchEOTypref(
				ec,
				EOTypref.TYPREFDOM.eq(EOTypref.VAR_ETAT_DOM).and(
						EOTypref.TYPREFNAT.eq(EOTypref.VAR_ETAT_REDACTION)));
		projet.setCreadate(getDateJour());
		projet.setCreAuteur(persId);
		projet.setEtabPorteur("N");
		projet.setProjthetv("N");
		projet.setSrcefinance("Aucun");
		projet.setBlocCom("");
		projet.setToEtatRelationship(etat);
		projet.setProjvalide("O");
		projet.setMajdate(getDateJour());
		projet.setMajauteur(persId.toString());
		return projet;
	}

}
