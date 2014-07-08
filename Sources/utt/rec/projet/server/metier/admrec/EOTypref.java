package utt.rec.projet.server.metier.admrec;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOSortOrdering;

public class EOTypref extends _EOTypref {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7807548958810643271L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(EOTypref.class);
	
	public static String VAR_ETAT_REDACTION = "RE";
	public static String VAR_ETAT_SOUMETTRE = "SO";
	public static String VAR_ETAT_VISER = "VI";
	public static String VAR_ETAT_VALIDER = "VA";
	public static String VAR_ETAT_TRAITER = "TT";
	public static String VAR_ETAT_NON_TRAITER = "NT";
	public static String VAR_ETAT_FAVORABLE = "FA";
	public static String VAR_ETAT_DEFAVORABLE = "DF";
	public static String VAR_ETAT_REFUSER = "RF";
	public static String VAR_ETAT_ATTENTE = "PE";
	public static String VAR_ETAT_PLEIADE = "PL";
	public static String VAR_ETAT_DOM = "PPRECETAT";
	

	public static final EOSortOrdering SORT_NOMETAT_ASC = EOSortOrdering
			.sortOrderingWithKey(TYPREFLIB_KEY,
					EOSortOrdering.CompareAscending);
}
