package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

public class EOPartenaireProjet extends _EOPartenaireProjet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7138216719103564092L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOPartenaireProjet.class);
	
	public static EOPartenaireProjet createEOPartenaireProjet(
			EOEditingContext editingContext,
			utt.rec.projet.server.metier.admrec.EOTyppartenaire partenaire,
			utt.rec.projet.server.metier.admrec.EOPprec projet) {
		EOPartenaireProjet eo = (EOPartenaireProjet) EOUtilities
				.createAndInsertInstance(editingContext,
						_EOPartenaireProjet.ENTITY_NAME);
		eo.setProjetId(Integer.parseInt(projet.primaryKey()));
		eo.setTyppartId(Integer.parseInt(partenaire.primaryKey()));
		return eo;
	}
	
	public static EOPartenaireProjet createEOPartenaireProjet(EOEditingContext editingContext) {
		EOPartenaireProjet eo = (EOPartenaireProjet) EOUtilities.createAndInsertInstance(
				editingContext, _EOPartenaireProjet.ENTITY_NAME);
		return eo;
	}
}
