/**
 * 
 */
package utt.rec.projet.server.utils;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public interface ConstsAlerte {
	
	  public final static String ALERT_MAIL_SUBJECT_PREFIX = "[Pré-Projet de RechErChe - PPREC] ";
	  public final static String TXT_ERREUR_RESPONSABLE = 
	    "Exception\n" + 
	    "L'application n'a pas pu detecté les responsables\n" + 
	    "des structures participantes au projet \n"+
	    "AGrhum n'est pas renseigné; correctement\n" +
	    "Veuillez contacter le CEDRE ...";
	  public final static String TXT_ERREUR_RESPONSABLE_HTML = 
	    "Exception<br>" + 
	    "L'application n'a pas pu detect&eacute; les responsables<br>" + 
	    "des structures participantes au projet<br>" + 
	    "AGrhum n'est pas renseign&eacute; correctement<br>" + 
	    "Veuillez contacter le CEDRE ...";

	  /** le titre du mail venant du demandeur */
	  public final static String PREFIX_MAIL_TITLE_DEMANDE = ALERT_MAIL_SUBJECT_PREFIX + "demande de ";
	  /** le nom du demandeur */
	  public final static String VAR_DEMANDEUR 				= "%DEMANDEUR%";
	  /** le libelle de l'alerte */
	  public final static String VAR_LIBELLE_ALERTE		= "%LIBELLE_ALERTE%";
	  /** l'URL de l'application Conges */
	  public final static String VAR_APP_URL						= "%APPURL%";
	  /** la partie specifique selon la nature de l'alerte */
	  public final static String VAR_SPEC							= "%SPEC%";
	  /** le verbe de l'action a realiser par le valideur */
	  public final static String VAR_VERBE							= "%VERBE%";
	  /** l'adresse email de sam associee au plugin sam-conges */
	  public final static String VAR_SAM_MAIL					= "%APP_SAM_MAIL%";
	  /** la terminaison de l'attribut de la table correspondant a la demande */
	  public final static String VAR_ATTR							=	"%ATTR%";
	  /** la valeur du hashcode associee a l'alerte */
	  public final static String VAR_HASH							=	"%HASH%";
	  /** la variable du texte relatif a la delegation */
	  public final static String VAR_CONTENT_DELEGATION			=	"%CONTENT_DELEGATION%";
	  
	  /** Le contenu du message envoye pour une alerte generique, sans SAM */
	  public final static String PATTERN_NEW_ALERT = 
	  	"Une demande de "+VAR_DEMANDEUR+VAR_CONTENT_DELEGATION+" concernant :\n" + 
	  	VAR_LIBELLE_ALERTE + "\n vient d'etre créée.\n" + 
	  	"\n" +
	  	VAR_SPEC + "Vous pouvez consulter et/ou la valider à cette adresse:\n" + 
	  	VAR_APP_URL;

	  /** Le contenu du message envoye pour une alerte generique, sans SAM */
	  public final static String PATTERN_NEW_ALERT_VIS = 
	  	"Une alerte projet de "+VAR_DEMANDEUR+VAR_CONTENT_DELEGATION+" concernant le " + 
	  	VAR_LIBELLE_ALERTE + " vient d'etre créée.\n" + 
	  	"\n" +
	  	VAR_SPEC + "Vous pouvez consulter et/ou viser le projet à cette adresse:\n " + 
	  	VAR_APP_URL;
	  
	  /** Le contenu du message envoye pour une alerte generique, sans SAM */
	  public final static String PATTERN_NEW_ALERT_VAL = 
	  	"Une alerte projet de "+VAR_DEMANDEUR+VAR_CONTENT_DELEGATION+" concernant le " + 
	  	VAR_LIBELLE_ALERTE + " vient d'etre créée.\n" + 
	  	"\n" +
	  	VAR_SPEC + "Vous pouvez consulter et/ou valider le projet à cette adresse:\n " + 
	  	VAR_APP_URL;
	  
	  /** Le contenu du message envoye pour une alerte generique, avec SAM */
	  public final static String PATTERN_NEW_ALERT_SAM = 
	  	PATTERN_NEW_ALERT + "\n" +
	  	"\n" +
	  	"----------------\n" +
	  	"Actions par mail\n" +
	  	"\n" + 
	  	"Vous pouvez "+VAR_VERBE+" la demande directement en cliquant sur ce lien :\n" +
	  	VAR_SAM_MAIL + "?subject=ACCEPT$PRJ_HASHCODE_" + VAR_ATTR + "$" + VAR_HASH + "\n" +
	  	/*"ou bien en envoyant un mail a l'adresse "+appSamMail+" avec en sujet:\n " + subjectSamCongesAccept +
	        "\n\n" + */
	  	"\n"+
	  	"Vous pouvez refuser la demande directement en cliquant sur ce lien :\n" +
	  	VAR_SAM_MAIL + "?subject=REFUSE$PRJ_HASHCODE_" + VAR_ATTR + "$" + VAR_HASH + "\n";
	  /*"ou bien en envoyant un mail a l'adresse "+appSamMail+" avec en sujet:\n" + subjectSamCongesRefuse;*/
	  
	  /** mode debug : la variable contenant l'adresse email de l'administrateur */
	  public final static String VAR_ADMIN_MAIL 		= "%APP_ADMIN_MAIL%";
	  /** mode debug : la variable contenant l'adresse email du destinataire */
	  public final static String VAR_MAIL_TO 			= "%MAIL_TO%";
	  /** mode debug : la variable contenant l'adresse email des cc */
	  public final static String VAR_MAIL_CC 			= "%MAIL_CC%";

	  /** mode debug : le prefix de tout le message email reexpedie */
	  public final static String PREFIX_CONTENT_DEBUG = 
	  	"---------\n" + 
	  	"Attention, le mail suivant n'a été envoyé qu'a(ux) adresse(s) suivante(s) : \n" + 
	  	VAR_ADMIN_MAIL + "\n" + 
	  	"En production, les destinataires seront : " + VAR_MAIL_TO + ", cc : " + VAR_MAIL_CC + "\n" +
	  	"---------\n" +
	  	"\n";

	  /** l'ensemble des caracteres utilises pour construire les hashcode */
		public final static String HASH_DICTIONARY = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ0123456789";
	 
		
		// delegation

	  /** la variable du nom du delegue */
	  public final static String VAR_DELEGUE								=	"%DELEGUE%";
	  /** le texte concernant la delegation */
		public final static String CONTENT_DELEGATION 				= " (de " + VAR_DELEGUE + " par délégation)";
	  
		// libelles des reponses lies au traitement des alerte
		
		public final static String ALERTE_LIBELLE_ACCEPTEE 		= "ACCEPTEE";
		public final static String ALERTE_LIBELLE_REFUSEE 		= "REFUSEE";
		public final static String ALERTE_LIBELLE_VISEE 			= "VISEE";

}
