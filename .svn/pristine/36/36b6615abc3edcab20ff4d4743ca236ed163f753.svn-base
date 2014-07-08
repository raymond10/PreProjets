package utt.rec.projet.server.metier.grhum;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;

@SuppressWarnings("all")
public class EOVresponsableEquipeRecherche extends _EOVresponsableEquipeRecherche {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3862537786108181530L;
	private static Logger log = Logger.getLogger(EOVresponsableEquipeRecherche.class);
	
	public static Boolean isResponsable(EOEditingContext ec, Integer PersId) {
		EOVresponsableEquipeRecherche responsable = EOVresponsableEquipeRecherche.fetchEOVresponsableEquipeRecherche(ec, "responsablePersId", PersId);
		return responsable != null;
	}
}
