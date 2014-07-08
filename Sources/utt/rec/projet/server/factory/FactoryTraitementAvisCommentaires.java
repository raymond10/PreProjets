/**
 * 
 */
package utt.rec.projet.server.factory;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import com.webobjects.appserver.WORequest;
import com.webobjects.eocontrol.EOEditingContext;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.metier.admrec.EOCommentaires;
import utt.rec.projet.server.metier.admrec.EOPprec;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class FactoryTraitementAvisCommentaires extends Factory {
	
	public FactoryTraitementAvisCommentaires() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public EOCommentaires avisCommentairesPP(CktlAjaxWOComponent component, EOPprec projet) {
		// TODO Auto-generated method stub
		WORequest req = component.context().request();
		Session sess = (Session) component.session();
		String compp = (String) req.formValueForKey("respPP");
		if (compp != null && !compp.equals(""))
			sess.setAvisComPP(compp);
		EOEditingContext edc = sess.editingContext();
		//EOStructureUlr equipePp = EOStructureUlr.structurePourcStructure(edc, projet.equipePrincipale());
		EOCommentaires comment  = new EOCommentaires();
		comment = EOCommentaires.createEOCommentaires(edc);
		comment.setToProjet(projet);
		comment.setProjet(Integer.valueOf(projet.primaryKey()));
		comment.setCStructure(projet.equipePrincipale());
		comment.setCommentaires(sess.getAvisComPP());
		comment.setCreateDate(getDateJour());
		comment.setMajAuteur(sess.getApplicationUser().getNoIndividu().toString());
		comment.setToAvisRelationship(sess.getAvisRepPP());
		comment.setTyprefdom(sess.getAvisRepPP().typrefdom());
		comment.setTyprefnat(sess.getAvisRepPP().typrefnat());
		return comment;
	}
	
	@Override
	public EOCommentaires avisCommentairesPS(CktlAjaxWOComponent component, EOPprec projet) {
		// TODO Auto-generated method stub
		WORequest req = component.context().request();
		Session sess = (Session) component.session();
		String comps = (String) req.formValueForKey("respEPS");
		if (comps != null && !comps.equals(""))
			sess.setAvisComPS(comps);
		EOEditingContext edc = sess.editingContext();
		EOCommentaires comment  = new EOCommentaires();
		comment = EOCommentaires.createEOCommentaires(edc);
		comment.setToProjet(projet);
		comment.setProjet(Integer.valueOf(projet.primaryKey()));
		comment.setCStructure(sess.getSelectedEquipe1().cStructure());
		comment.setCommentaires(sess.getAvisComPS());
		comment.setCreateDate(getDateJour());
		comment.setMajAuteur(sess.getApplicationUser().getNoIndividu().toString());
		comment.setToAvisRelationship(sess.getAvisRespSec());
		comment.setTyprefdom(sess.getAvisRespSec().typrefdom());
		comment.setTyprefnat(sess.getAvisRespSec().typrefnat());
		return comment;
	}
	
	@Override
	public EOCommentaires avisCommentairesDP(CktlAjaxWOComponent component, EOPprec projet) {
		// TODO Auto-generated method stub
		WORequest req = component.context().request();
		Session sess = (Session) component.session();
		String comdrt = (String) req.formValueForKey("DirP");
		if (comdrt != null && !comdrt.equals(""))
			sess.setAvisComDP(comdrt);
		EOEditingContext edc = sess.editingContext();
		EOCommentaires comment  = new EOCommentaires();
		comment = EOCommentaires.createEOCommentaires(edc);
		comment.setToProjet(projet);
		comment.setProjet(Integer.valueOf(projet.primaryKey()));
		comment.setCStructure(sess.getSelectedPole1().primaryKey());
		comment.setCommentaires(sess.getAvisComDP());
		comment.setCreateDate(getDateJour());
		comment.setMajAuteur(sess.getApplicationUser().getNoIndividu().toString());
		comment.setToAvisRelationship(sess.getAvisDrt());
		comment.setTyprefdom(sess.getAvisDrt().typrefdom());
		comment.setTyprefnat(sess.getAvisDrt().typrefnat());
		return comment;
	}

}
