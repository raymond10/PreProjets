package utt.rec.projet.server;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktlajaxwebext.serveur.CocktailAjaxApplication;
import org.cocktail.fwkcktldroitsutils.common.util.MyStringCtrl;
import org.cocktail.fwkcktlwebapp.common.CktlLog;
import org.cocktail.fwkcktlwebapp.common.util.DateCtrl;
import org.cocktail.fwkcktlwebapp.server.CktlMailBus;
import org.cocktail.fwkcktlwebapp.server.init.NSLegacyBundleMonkeyPatch;
import org.cocktail.fwkcktlwebapp.server.util.EOModelCtrl;
import org.cocktail.fwkcktlwebapp.server.version.A_CktlVersion;

import utt.rec.projet.server.metier.CedreConfigurationException;
import utt.rec.projet.server.metier.admrec.EOAlerte;

import com.webobjects.appserver.WOAction;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOMessage;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WORequestHandler;
import com.webobjects.appserver.WOResponse;
import com.webobjects.appserver.WOSession;
import com.webobjects.eoaccess.EOGeneralAdaptorException;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSNumberFormatter;
import com.webobjects.foundation.NSPropertyListSerialization;
import com.webobjects.foundation.NSSet;
import com.webobjects.foundation.NSTimeZone;
import com.webobjects.foundation.NSTimestampFormatter;
import com.woinject.WOInject;

import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.ERXMessageEncoding;
import er.extensions.appserver.ERXSession;
import er.extensions.appserver.ERXStaticResourceRequestHandler;
import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXProperties;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class Application extends CocktailAjaxApplication {

	public static final String TYPE_APP_STR = VersionMe.APPLICATION_STRID; // ID
																			// de
																			// l'application
	// dans JefyAdmin
	private static final String CONFIG_FILE_NAME = VersionMe.APPLICATIONINTERNALNAME
			+ ".config";
	private static final String CONFIG_TABLE_NAME = "FwkCktlWebApp_GrhumParametres";
	private static final String MAIN_MODEL_NAME = "FwkCktlPersonne";
	private final Logger logger = ERXApplication.log;

	public static final String DEFAULT_TIMESTAMP_FORMATTER = "%d/%m/%Y à %Hh%M";

	/**
	 * Mettre a true pour que votre application renvoie les informations de
	 * collecte au serveur de collecte de Cocktail.
	 */
	public static boolean APP_SHOULD_SEND_COLLECTE = false;
	/**
	 * Liste des parametres obligatoires (dans fichier de config ou table
	 * grhum_parametres) pour que l'application se lance. Si un des parametre
	 * n'est pas initialise, il y a une erreur bloquante.
	 */
	public static final String[] MANDATORY_PARAMS = new String[] { "HOST_MAIL",
			"ADMIN_MAIL" };

	/**
	 * Liste des parametres optionnels (dans fichier de config ou table
	 * grhum_parametres). Si un des parametre n'est pas initialise, il y a un
	 * warning.
	 */
	public static final String[] OPTIONAL_PARAMS = new String[] {};
	public static final String CONFIG_C_STRUCTURE_LIST_PPREC_USERS_KEY = "C_STRUCTURE_LIST_PPREC_USERS";
	public static final String CONFIG_LC_STRUCTURE_LIST_POLES_KEY = "LC_STRUCTURE_LIST_POLES";
	public static final String CONFIG_LC_STRUCTURE_LIST_EQUIPES_KEY = "LC_STRUCTURE_LIST_EQUIPES";
	public static final String CONFIG_C_STRUCTURE_ADMIN_PPREC_KEY = "C_STRUCTURE_ADMIN_PPREC";
	public static final String CONFIG_RESP_ADM_RECH = "RESP_ADM_RECH";
	public static final String CONFIG_RESP_DR_RECH = "RESP_DR_RECH";
	public static final String CONFIG_CCCR = "CCCR";
	public static final String CONFIG_MAIL_RECH = "ADRM_RECH_MAIL";
	public static final String CONFIG_GD_ENABLE = "ENABLE_NEW_GD";
	public static final String CONFIG_BATCH_ENABLE = "BATCH_ENABLE";
	// Configuration des equipes
	public static final String CONFIG_UMR_STMR = "UMR_STMR";
	public static final String CONFIG_CREIDD = "CREIDD";
	public static final String CONFIG_ERA = "ERA";
	public static final String CONFIG_GAMMA3 = "GAMMA3";
	public static final String CONFIG_LASMIS = "LASMIS";
	public static final String CONFIG_LM2S = "LM2S";
	public static final String CONFIG_LNIO = "LNIO";
	public static final String CONFIG_LOSI = "LOSI";
	public static final String CONFIG_TECH_CICO = "TECH-CICO";

	/**
	 * boolean qui indique si on se trouve en mode developpement ou non. Permet
	 * de desactiver l'envoi de mail lors d'une exception par exemple
	 */
	public static boolean isModeDebug = false;
	public static boolean useCas = false;

	public static Application app() {
		return (Application) application();
	}

	private Version _appVersion;

	public static NSTimeZone ntz = null;
	/**
	 * Formatteur a deux decimales e utiliser pour les donnees numeriques non
	 * monetaires.
	 */
	public NSNumberFormatter app2DecimalesFormatter;
	/**
	 * Formatteur a 5 decimales a utiliser pour les pourcentages dans la
	 * repartition.
	 */
	public NSNumberFormatter app5DecimalesFormatter;

	/**
	 * Formatteur de dates.
	 */
	public NSTimestampFormatter appDateFormatter;

	/**
	 * Liste des emails des utilisateurs connectes.
	 */
	private static NSMutableArray utilisateurs; // Liste des emails des
	// utilisateurs connectes

	/**
	 * ID du container permettant d'afficher les messages via pnotify
	 */
	private static final String MESSAGE_CONTAINER_ID = "Pprec_MessageContainer";

	/**
	 * Fonction JS permettant l'update du container de messages
	 */
	private static final String ON_FAILURE_MESSAGE = "function () {"
			+ MESSAGE_CONTAINER_ID + "Update();}";
	private static final String ON_MESSAGE_UPDATE = "function () {"
			+ MESSAGE_CONTAINER_ID + "Update();}";

	/**
	 * Liste des c_structure des groupes dont les membres ont le droit d'accéer
	 * à PPREC. cf {@link Application#CONFIG_C_STRUCTURE_LIST_AGRHUM_USERS_KEY}
	 */
	private NSSet<String> cStructuresAccesPprec;
	private NSSet<String> lcStructuresListPoles;
	private NSSet<String> lcStructuresListEquipes;
	private String _cStructureAdmin;
	private String _cStructureDrResp;
	private String _cStructureAdmResp;
	private String _cStructureUmrStmr;
	private String _cStructureCreidd;
	private String _cStructureEra;
	private String _cStructureGamma3;
	private String _cStructureLm2s;
	private String _cStructureLnio;
	private String _cStructureLosi;
	private String _cStructureTechCico;
	private String _cStructureCccr;
	private Boolean _newGd;
	private Boolean _batchEnable;
	private String _mailRecherche;

	public static void main(String[] argv) {
		//Fix pb lenteur au démarrage
		NSLegacyBundleMonkeyPatch.apply();
		WOInject.init("utt.rec.projet.server.Application", argv);
		ERXApplication.main(argv, Application.class);
	}

	@SuppressWarnings("rawtypes")
	public Application() {
		super();
		/* ** put your initialization code in here ** */
		setAllowsConcurrentRequestHandling(false);
		setDefaultRequestHandler(requestHandlerForKey(directActionRequestHandlerKey()));
		setPageRefreshOnBacktrackEnabled(true);
		WOMessage.setDefaultEncoding("UTF-8");
		WOMessage.setDefaultURLEncoding("UTF-8");
		ERXMessageEncoding.setDefaultEncoding("UTF8");
		ERXMessageEncoding.setDefaultEncodingForAllLanguages("UTF8");
		WOResponse.setDefaultEncoding("UTF-8");
		utilisateurs = new NSMutableArray();
		ERXEC.setDefaultFetchTimestampLag(0);
		ERXEC.unlockAllContextsForCurrentThread();
		logger.info("Bienvenue sur " + TYPE_APP_STR);
		/*
		 * setSessionTimeOut(86400); setPageCacheSize(100); if
		 * (isDirectConnectEnabled()) { registerRequestHandler(new
		 * ERXStaticResourceRequestHandler(), "_wr_"); }
		 */
	}

	@Override
	public A_CktlVersion appCktlVersion() {
		return new Version();
	}

	@Override
	public A_CktlVersion appCktlVersionDb() {
		return new VersionDatabase();
	}

	public void initApplication() {
		System.out.println("Lancement de l'application serveur " + TYPE_APP_STR
				+ "...");
		super.initApplication();
		CktlLog.rawLog("WOFrameworksBaseURL: " + frameworksBaseURL());
		// Afficher les infos de connexion des modeles de donnees
		rawLogModelInfos();
		// Verifier la coherence des dictionnaires de connexion des modeles de
		// donnees
		@SuppressWarnings("unused")
		boolean isInitialisationErreur = !checkModel();
		isModeDebug = config().booleanForKey("MODE_DEBUG");
		useCas = config().booleanForKey("APP_USE_CAS");
		// Instanciation de la classe d'envoie de mail
		EOAlerte.initStaticFields(isModeDebug, useCas, mailBus(), dataBus(),
				config().stringForKey("APP_URL"),
				config().stringForKey("ADMIN_MAIL"),
				config().stringForKey("DOMAIN_NAME"), mailRecherche());
		Application.APP_SHOULD_SEND_COLLECTE = !Application
				.isDevelopmentModeSafe();
		setPageCacheSize(10);
	}

	/**
	 * Execute les operations au demarrage de l'application, juste apres
	 * l'initialisation standard de l'application.
	 */
	public void startRunning() {
		initFormatters();
		initTimeZones();
		this.appDateFormatter = new NSTimestampFormatter();
		this.appDateFormatter.setPattern("%d/%m/%Y");

		// EOStructureForGroupeSpec.getGroupeDefaut(ERXEC.newEditingContext());

		/**
		 * Prefetch dans le sharedEditingContext des nomenclatures communes a
		 * toute l'appli Il est necessaire de declarer dans l'eomodel, l'entite
		 * a prefetecher via l'inspecteur: 'Share all objects' --> creation d'un
		 * fetchspecificationnamed 'FetchAll' Il est indispensable d'utiliser
		 * l'api 'bindObjectsWithFetchSpecification'
		 */
	}

	public Logger logger() {
		return logger;
	}

	public String configFileName() {
		return CONFIG_FILE_NAME;
	}

	public String configTableName() {
		return CONFIG_TABLE_NAME;
	}

	public String[] configMandatoryKeys() {
		return MANDATORY_PARAMS;
	}

	public String[] configOptionalKeys() {
		return OPTIONAL_PARAMS;
	}

	public String messageContainerID() {
		return MESSAGE_CONTAINER_ID;
	}

	public String onFailureMessage() {
		return ON_FAILURE_MESSAGE;
	}

	public String onMessageUpdate() {
		return ON_MESSAGE_UPDATE;
	}

	public String casLogOutURL() {
		return config().stringForKey("CAS_LOGOUT_URL");
	}

	public String appUlr() {
		return config().stringForKey("APP_URL");
	}

	public String copyright() {
		return appVersion().copyright();
	}

	public A_CktlVersion appA_CktlVersion() {
		return appVersion();
	}

	public Version appVersion() {
		if (_appVersion == null) {
			_appVersion = new Version();
		}
		return _appVersion;
	}

	public String mainModelName() {
		return MAIN_MODEL_NAME;
	}

	public void initFormatters() {
		this.app2DecimalesFormatter = new NSNumberFormatter();
		this.app2DecimalesFormatter.setDecimalSeparator(",");
		this.app2DecimalesFormatter.setThousandSeparator(" ");

		this.app2DecimalesFormatter.setHasThousandSeparators(true);
		this.app2DecimalesFormatter.setPattern("#,##0.00;0,00;-#,##0.00");

		this.app5DecimalesFormatter = new NSNumberFormatter();
		this.app5DecimalesFormatter.setDecimalSeparator(",");
		this.app5DecimalesFormatter.setThousandSeparator(" ");

		this.app5DecimalesFormatter.setHasThousandSeparators(true);
		this.app5DecimalesFormatter.setPattern("##0.00000;0,00000;-##0.00000");
	}

	public NSNumberFormatter app2DecimalesFormatter() {
		return this.app2DecimalesFormatter;
	}

	public NSNumberFormatter getApp5DecimalesFormatter() {
		return this.app5DecimalesFormatter;
	}

	/**
	 * Initialise le TimeZone a utiliser pour l'application.
	 */
	protected void initTimeZones() {
		logger().info("Initialisation du NSTimeZone");
		String tz = config().stringForKey("DEFAULT_NS_TIMEZONE");
		if (tz == null || tz.equals("")) {
			CktlLog.log("Le parametre DEFAULT_NS_TIMEZONE n'est pas defini dans le fichier .config.");
			TimeZone.setDefault(TimeZone.getTimeZone("ECT"));
			NSTimeZone.setDefaultTimeZone(NSTimeZone.timeZoneWithName("ECT",
					false));
		} else {
			ntz = NSTimeZone.timeZoneWithName(tz, false);
			if (ntz == null) {
				CktlLog.log("Le parametre DEFAULT_NS_TIMEZONE defini dans le fichier .config n'est pas valide ("
						+ tz + ")");
				TimeZone.setDefault(TimeZone.getTimeZone("ECT"));
				NSTimeZone.setDefaultTimeZone(NSTimeZone.timeZoneWithName(
						"ECT", false));
			} else {
				TimeZone.setDefault(ntz);
				NSTimeZone.setDefaultTimeZone(ntz);
			}
		}
		ntz = NSTimeZone.defaultTimeZone();
		logger().info(
				"NSTimeZone par defaut utilise dans l'application:"
						+ NSTimeZone.defaultTimeZone());
		NSTimestampFormatter ntf = new NSTimestampFormatter();
		logger().info(
				"Les NSTimestampFormatter afficheront les dates avec le NSTimeZone: "
						+ ntf.defaultFormatTimeZone());
	}

	/**
	 * Retourne le mot de passe du super-administrateur. Il permet de se
	 * connecter a l'application avec le nom d'un autre utilisateur
	 * (l'authentification local et non celle CAS doit etre activee dans ce
	 * cas).
	 */
	public String getRootPassword() {
		// passpar2
		return "HO4LI8hKZb81k";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public WOResponse handleException(Exception anException, WOContext context) {
		logger().error("Message d'erreur :" + anException.getMessage(),
				anException);
		WOResponse response = null;
		if (context != null && context.hasSession()) {
			Session session = (Session) context.session();
			session.setGeneralErrorMessage(anException.getMessage());
			sendMessageErreur(anException, context, session);
			String error = createMessageErreur(anException, context, session);
			response = createResponseInContext(context);
			session.setGeneralErrorMessage(error);
			NSMutableDictionary formValues = new NSMutableDictionary();
			formValues.setObjectForKey(session.sessionID(), "wosid");
			String applicationExceptionUrl = context
					.directActionURLForActionNamed("applicationException",
							formValues);
			response.appendContentString("<script>document.location.href='"
					+ applicationExceptionUrl + "';</script>");
			cleanInvalidEOFState(anException, context);
			return response;
		} else {
			return super.handleException(anException, context);
		}
	}

	/**public WOResponse handleActionRequestError(WORequest aRequest,
			Exception exception, String reason, WORequestHandler aHandler,
			String actionClassName, String actionName, Class actionClass,
			WOAction actionInstance) {
		logger().error("Message d'erreur :" + exception.getMessage(), exception);
		return super.handleActionRequestError(aRequest, exception, reason,
				aHandler, actionClassName, actionName, actionClass,
				actionInstance);
	}**/

	@SuppressWarnings("rawtypes")
	private String createMessageErreur(Exception anException,
			WOContext context, Session session) {
		String contenu;
		// Si c'est une erreur de config, on affiche pas tout le tsoin tsoin,
		// juste une info claire
		if (anException instanceof CedreConfigurationException) {
			contenu = anException.getMessage();
			session.setGeneralErrorMessage(contenu);
		} else if (anException instanceof NSForwardException
				&& ((NSForwardException) anException).originalException() instanceof CedreConfigurationException) {
			Throwable cause = ((NSForwardException) anException)
					.originalException();
			contenu = cause != null ? cause.getLocalizedMessage() : null;
		} else {
			NSDictionary extraInfo = extraInformationForExceptionInContext(
					anException, context);
			contenu = "Date : "
					+ DateCtrl.dateToString(DateCtrl.now(), "%d/%m/%Y %H:%M")
					+ "\n";
			contenu += "OS: " + System.getProperty("os.name") + "\n";
			contenu += "Java vm version: "
					+ System.getProperty("java.vm.version") + "\n";
			contenu += "WO version: " + ERXProperties.webObjectsVersion()
					+ "\n\n";
			contenu += "User agent: "
					+ context.request().headerForKey("user-agent") + "\n\n";
			if (newGestionDroitsEnabled()) {
				if (session.applicationGDUser() != null) {
					contenu += "Utilisateur(Numero individu): "
							+ session.applicationGDUser().getNomAndPrenom()
							+ " ("
							+ session.applicationGDUser().getNoIndividu() + ")"
							+ "\n";
				} else {
					contenu += "Utilisateur(Numero individu): \n";
				}
			} else {
				if (session.applicationJAUser() != null) {
					contenu += "Utilisateur(Numero individu): "
							+ session.applicationJAUser().getNomAndPrenom()
							+ " ("
							+ session.applicationJAUser().getNoIndividu() + ")"
							+ "\n";
				} else {
					contenu += "Utilisateur(Numero individu): \n";
				}
			}

			contenu += "\n\nException : " + "\n";
			if (anException instanceof InvocationTargetException) {
				contenu += getMessage(anException, extraInfo) + "\n";
				anException = (Exception) anException.getCause();
			}
			contenu += getMessage(anException, extraInfo) + "\n";
			contenu += "\n\n";
		}
		return contenu;
	}

	private void sendMessageErreur(Exception anException, WOContext context,
			Session session) {
		try {
			CktlMailBus cmb = session.mailBus();
			String smtpServeur = config().stringForKey("HOST_MAIL");
			String destinataires = config().stringForKey("ADMIN_MAIL");

			if (cmb != null && smtpServeur != null
					&& smtpServeur.equals("") == false && destinataires != null
					&& destinataires.equals("") == false) {
				String objet = "[PPREC]:Exception:[";
				objet += VersionMe.txtAppliVersion() + "]";
				String contenu = createMessageErreur(anException, context,
						session);
				session.setGeneralErrorMessage(contenu);
				boolean retour = false;
				if (isModeDebug) {
					logger().info(
							"!!!!!!!!!!!!!!!!!!!!!!!! MODE DEVELOPPEMENT : pas de mail !!!!!!!!!!!!!!!!");
					retour = false;
				} else {
					retour = cmb.sendMail(destinataires, destinataires, null,
							objet, contenu);
				}
				if (!retour) {
					logger().warn(
							"!!!!!!!!!!!!!!!!!!!!!!!! IMPOSSIBLE d'ENVOYER le mail d'exception !!!!!!!!!!!!!!!!");
					logger().warn("\nMail:\n\n" + contenu);

				}
			} else {
				logger().warn(
						"!!!!!!!!!!!!!!!!!!!!!!!! IMPOSSIBLE d'ENVOYER le mail d'exception !!!!!!!!!!!!!!!!");
				logger().warn(
						"Veuillez verifier que les parametres HOST_MAIL et ADMIN_MAIL sont bien renseignes");
				logger().warn("HOST_MAIL = " + smtpServeur);
				logger().warn("ADMIN_MAIL = " + destinataires);
				logger().warn("cmb = " + cmb);
				logger().warn("\n\n\n");
			}
		} catch (Exception e) {
			logger().error("\n\n\n");
			logger().error(
					"!!!!!!!!!!!!!!!!!!!!!!!! Exception durant le traitement d'une autre exception !!!!!!!!!!!!!!!!");
			logger().error(e.getMessage(), e);
			super.handleException(e, context);
			logger().error("\n");
			logger().error(
					"Message Exception originale: " + anException.getMessage());
			logger().error(
					"Stack Exception dans exception: "
							+ anException.getStackTrace());
		}

	}

	public String _rewriteURL(String url) {
		String processedURL = url;
		if (url != null && _replaceApplicationPathPattern != null
				&& _replaceApplicationPathReplace != null) {
			processedURL = processedURL.replaceFirst(
					_replaceApplicationPathPattern,
					_replaceApplicationPathReplace);
		}
		return processedURL;
	}

	private void cleanInvalidEOFState(Exception e, WOContext ctx) {
		if (e instanceof IllegalStateException
				|| e instanceof EOGeneralAdaptorException) {
			Session sess = (Session) ctx.session();
			sess.editingContext().invalidateAllObjects();
		}
	}

	@SuppressWarnings("rawtypes")
	protected String getMessage(Throwable e, NSDictionary extraInfo) {
		String message = "";
		if (e != null) {
			message = stackTraceToString(e, false) + "\n\n";
			message += "Info extra :\n";
			if (extraInfo != null) {
				message += NSPropertyListSerialization
						.stringFromPropertyList(extraInfo) + "\n\n";
			}
		}
		return message;
	}

	/**
	 * permet de recuperer la trace d'une exception au format string message +
	 * trace
	 * 
	 * @param e
	 * @return
	 */
	public static String stackTraceToString(Throwable e, boolean useHtml) {
		String tagCR = "\n";
		if (useHtml) {
			tagCR = "<br>";
		}
		String stackStr = e + tagCR + tagCR;
		StackTraceElement[] stack = e.getStackTrace();
		for (int i = 0; i < stack.length; i++) {
			stackStr += (stack[i]).toString() + tagCR;
		}
		return stackStr;
	}

	public boolean _isSupportedDevelopmentPlatform() {
		return (super._isSupportedDevelopmentPlatform() || System.getProperty(
				"os.name").startsWith("Win"));
	}

	@Override
	public WOResponse handleSessionRestorationErrorInContext(WOContext context) {
		WOResponse response;
		response = createResponseInContext(context);
		String sessionExpiredUrl = context.directActionURLForActionNamed(
				"sessionExpired", null);
		response.appendContentString("<script>document.location.href='"
				+ sessionExpiredUrl + "';</script>");

		return response;
	}

	@SuppressWarnings("rawtypes")
	public NSMutableArray utilisateurs() {
		return utilisateurs;
	}

	@SuppressWarnings("rawtypes")
	public static String serverBDId() {
		NSMutableArray<String> serverDBIds = new NSMutableArray<String>();
		final NSMutableDictionary mdlsDico = EOModelCtrl.getModelsDico();
		final Enumeration mdls = mdlsDico.keyEnumerator();
		while (mdls.hasMoreElements()) {
			final String mdlName = (String) mdls.nextElement();
			String serverDBId = EOModelCtrl
					.bdConnexionServerId((EOModel) mdlsDico
							.objectForKey(mdlName));
			if (!serverDBIds.containsObject(serverDBId)) {
				serverDBIds.addObject(serverDBId);
			}
		}
		return serverDBIds.componentsJoinedByString(",");
	}

	public String getDefaultTimestampFormatter() {
		return DEFAULT_TIMESTAMP_FORMATTER;
	}

	/**
	 * @return the cStructuresAccesGrhum : liste des cStructures dont les
	 *         membres ont accès à PPREC
	 */
	public NSSet<String> getCStructuresAccesPprec() {
		if (cStructuresAccesPprec == null) {
			String cStructuresListeParam = config().stringForKey(
					CONFIG_C_STRUCTURE_LIST_PPREC_USERS_KEY);
			if (!MyStringCtrl.isEmpty(cStructuresListeParam)) {
				cStructuresAccesPprec = new NSSet<String>(
						cStructuresListeParam.split(","));
			}
		}
		return cStructuresAccesPprec;
	}

	/**
	 * @return the lcStructuresListPoles
	 */
	public NSSet<String> getLcStructuresListPoles() {
		if (lcStructuresListPoles == null) {
			String lcStructuresListeParam = config().stringForKey(
					CONFIG_LC_STRUCTURE_LIST_POLES_KEY);
			if (!MyStringCtrl.isEmpty(lcStructuresListeParam)) {
				lcStructuresListPoles = new NSSet<String>(
						lcStructuresListeParam.split(","));
			}
		}
		return lcStructuresListPoles;
	}

	/**
	 * @return the lcStructuresListEquipes
	 */
	public NSSet<String> getLcStructuresListEquipes() {
		if (lcStructuresListEquipes == null) {
			String lcStructuresListeParam = config().stringForKey(
					CONFIG_LC_STRUCTURE_LIST_EQUIPES_KEY);
			if (!MyStringCtrl.isEmpty(lcStructuresListeParam)) {
				lcStructuresListEquipes = new NSSet<String>(
						lcStructuresListeParam.split(","));
			}
		}
		return lcStructuresListEquipes;
	}

	/**
	 * cStruture des membres Admin
	 * 
	 * @return
	 */
	public String cStructureAdmin() {
		if (_cStructureAdmin == null)
			_cStructureAdmin = config().stringForKey(
					CONFIG_C_STRUCTURE_ADMIN_PPREC_KEY);
		return _cStructureAdmin;
	}

	/**
	 * cStructure de la direction de la recherche
	 * 
	 * @return
	 */
	public String cStrctureDrResp() {
		if (_cStructureDrResp == null)
			_cStructureDrResp = config().stringForKey(CONFIG_RESP_DR_RECH);
		return _cStructureDrResp;
	}

	/**
	 * cStructure de l'administration à la recherche
	 * 
	 * @return
	 */
	public String cStrctureAdmResp() {
		if (_cStructureAdmResp == null)
			_cStructureAdmResp = config().stringForKey(CONFIG_RESP_ADM_RECH);
		return _cStructureAdmResp;
	}

	// Definitions des equipes
	/**
	 * cStructure de l'équipe transverse
	 * 
	 * @return
	 */
	public String cStrctureUmrStmr() {
		if (_cStructureUmrStmr == null)
			_cStructureUmrStmr = config().stringForKey(CONFIG_UMR_STMR);
		return _cStructureUmrStmr;
	}

	/**
	 * @return the _cStructureCreidd
	 */
	public String cStructureCreidd() {
		if (_cStructureCreidd == null)
			_cStructureCreidd = config().stringForKey(CONFIG_CREIDD);
		return _cStructureCreidd;
	}

	/**
	 * @return the _cStructureEra
	 */
	public String cStructureEra() {
		if (_cStructureEra == null)
			_cStructureEra = config().stringForKey(CONFIG_ERA);
		return _cStructureEra;
	}

	/**
	 * @return the _cStructureGamma3
	 */
	public String cStructureGamma3() {
		if (_cStructureGamma3 == null)
			_cStructureGamma3 = config().stringForKey(CONFIG_GAMMA3);
		return _cStructureGamma3;
	}

	/**
	 * @return the _cStructureLm2s
	 */
	public String cStructureLm2s() {
		if (_cStructureLm2s == null)
			_cStructureLm2s = config().stringForKey(CONFIG_LM2S);
		return _cStructureLm2s;
	}

	/**
	 * @return the _cStructureLnio
	 */
	public String cStructureLnio() {
		if (_cStructureLnio == null)
			_cStructureLnio = config().stringForKey(CONFIG_LNIO);
		return _cStructureLnio;
	}

	/**
	 * @return the _cStructureLosi
	 */
	public String cStructureLosi() {
		if (_cStructureLosi == null)
			_cStructureLosi = config().stringForKey(CONFIG_LOSI);
		return _cStructureLosi;
	}

	/**
	 * @return the _cStructureTechCico
	 */
	public String cStructureTechCico() {
		if (_cStructureTechCico == null)
			_cStructureTechCico = config().stringForKey(CONFIG_TECH_CICO);
		return _cStructureTechCico;
	}

	/**
	 * cStructure de la cellule de coor.
	 * 
	 * @return
	 */
	public String cStructureCccr() {
		if (_cStructureCccr == null)
			_cStructureCccr = config().stringForKey(CONFIG_CCCR);
		return _cStructureCccr;
	}

	/**
	 * _newGd
	 * 
	 * @return
	 */
	public boolean newGestionDroitsEnabled() {
		if (_newGd == null)
			_newGd = config().booleanForKey(CONFIG_GD_ENABLE);
		return _newGd;
	}

	/**
	 * @return the _mailRecherche
	 */
	public String mailRecherche() {
		if (_mailRecherche == null)
			_mailRecherche = config().stringForKey(CONFIG_MAIL_RECH);
		return _mailRecherche;
	}

	/**
	 * @return the _batchEnable
	 */
	public Boolean batchEnable() {
		if (_batchEnable == null)
			_batchEnable = config().booleanForKey(CONFIG_BATCH_ENABLE);
		return _batchEnable;
	}

}
