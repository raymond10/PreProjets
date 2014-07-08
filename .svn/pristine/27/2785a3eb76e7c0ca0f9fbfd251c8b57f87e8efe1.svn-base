/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORefidx;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEC;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 11 juin 2013
 */
@SuppressWarnings("all")
public class ManufactoryMotClefs extends Manufactory {

	/**
	 * @param ec
	 * @param withlog
	 */
	public ManufactoryMotClefs(EOEditingContext ec, boolean withlog) {
		super(ec, withlog);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ec
	 */
	public ManufactoryMotClefs(EOEditingContext ec) {
		super(ec);
		// TODO Auto-generated constructor stub
	}

	public EOMotclefs creerKeywordVierge() {
		EOMotclefs keyword = EOMotclefs.createEOMotclefs(ERXEC.newEditingContext());
		keyword.setTemvalide("O");
		return keyword;
	}

	// KEYWORD
	public void insKeyword(EOPprec projet, NSMutableArray listKey) throws Exception {
		for (EORefidx word : (NSMutableArray<EORefidx>) listKey) {
			enregistrementKeyword(projet, word);
		}
	}

	public void delKeyword(EOPprec projet, NSMutableArray listKey) throws Exception {
		for (EORefidx word : (NSMutableArray<EORefidx>) listKey) {
			SuppressionKeyword(projet, word);
		}
	}

	// Enregistrement d'un mot clef d'un projet
	protected void enregistrementKeyword(EOPprec projet, EORefidx word)
			throws Exception {
		EOMotclefs keyword = creerKeywordVierge();
		EOMotclefs repartKey = EOMotclefs.fetchEOMotclefs(
				ERXEC.newEditingContext(),
				EOMotclefs.TO_PROJET.eq(projet).and(EOMotclefs.TO_REFIDX.eq(word)));
		if(repartKey == null) {
			ec = keyword.editingContext();
			keyword.setToProjetRelationship(projet.localInstanceIn(ec));
			keyword.setToRefidxRelationship(word.localInstanceIn(ec));
			keyword.setProjetId(Integer.valueOf(projet.primaryKey()));
			keyword.setRefidxId(Integer.valueOf(word.primaryKey()));
			trace("enregistrementKeyword()", keyword);
			if(ec.hasChanges())
				ec.saveChanges();
		} else {
			repartKey.editingContext().saveChanges();
		}
	}
	
	// Suppression d'un mot clef d'un projet
	protected void SuppressionKeyword(EOPprec projet, EORefidx word)
			throws Exception {
		EOMotclefs repartKey = EOMotclefs.fetchEOMotclefs(
				ERXEC.newEditingContext(),
				EOMotclefs.TO_PROJET.eq(projet).and(EOMotclefs.TO_REFIDX.eq(word)));
		if(repartKey != null) {
			ec = repartKey.editingContext();
			ec.deleteObject(repartKey);
			if(ec.hasChanges())
				ec.saveChanges();
		}
	}

}
