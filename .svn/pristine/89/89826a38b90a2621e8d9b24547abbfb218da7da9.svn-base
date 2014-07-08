/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import utt.rec.projet.server.metier.admrec.EOCommentaires;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOTypref;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *19 juin 2013
 */
public class ManufactoryCommentaire extends Manufactory {
	
	/**
	 * @param ec
	 */
	public ManufactoryCommentaire(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryCommentaire(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}
	
	public EOCommentaires creerCommentaireVierge(EOEditingContext ec, Integer persId) {
		EOCommentaires commentaire = EOCommentaires.createEOCommentaires(ec);
		commentaire.setMajAuteur(persId.toString());
		commentaire.setCreateDate(getDateJour());
		commentaire.setMajDate(getDateJour());
		//commentaire.setTyprefnat(EOTypref.VAR_ETAT_DEFAVORABLE);
		commentaire.setTyprefdom(EOTypref.VAR_ETAT_DOM);
		return commentaire;
	}
	
	public void enregistrerCommentaire(EOPprec projet, EOCommentaires commentaire) {
		
	}

}
