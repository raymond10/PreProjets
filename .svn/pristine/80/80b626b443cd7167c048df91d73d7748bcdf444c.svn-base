package utt.rec.projet.server.metier.grhum;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class EOCompte extends _EOCompte {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2521525234026705745L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOCompte.class);
	private static NSTimestamp SYSDATE = new NSTimestamp();
	
	public static Boolean isCompteValide(EOEditingContext ec, String login) {
		Boolean valide = EOCompte.fetchEOCompte(ec, CPT_LOGIN.eq(login).and(CPT_FIN_VALIDE.isNull().or(CPT_FIN_VALIDE.greaterThanOrEqualTo(SYSDATE)))) != null;
		return valide;
	}
}
