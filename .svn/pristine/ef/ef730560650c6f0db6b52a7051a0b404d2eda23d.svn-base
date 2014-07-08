package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;

public class EOVrhcmval extends _EOVrhcmval {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5017486244249959689L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOVrhcmval.class);
	private static String CHERCHEUR = "ENS_CHER";
	
	public String nomPrenom(){
		return nomUsuel() +" "+ prenom();
	}
	
	public static EOVrhcmval unPolePourIndividu(EOEditingContext editingContext, Integer noIndividu){
		if(noIndividu == null)
			return null;
		return fetchEOVrhcmval(editingContext, "noIndividu", noIndividu);
	}
	
	public static EOVrhcmval chercheurPourPole(EOEditingContext editingContext, String cStructure){
		if(cStructure == null)
			return null;
		return fetchEOVrhcmval(editingContext, "cStructure", cStructure);
	}
	
	public Boolean isEnsChercheur() {
		return typrhcmCod().equals(CHERCHEUR);
	}
}
