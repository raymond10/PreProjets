/**
 * 
 */
package utt.rec.projet.server.print;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;
import org.cocktail.fwkcktlpersonne.common.metier.EOStructure;
import org.cocktail.fwkcktlwebapp.common.util.CktlXMLWriter;
import org.cocktail.fwkcktlwebapp.server.CktlDataResponse;
import org.cocktail.reporting.CktlAbstractReporter;
import org.cocktail.reporting.jrxml.IJrxmlReportListener;
import org.cocktail.reporting.jrxml.JrxmlReporterWithXmlDataSource;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.metier.ProjectListTampon;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOCommentaires;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORefidx;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOTypcontrat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.utils.Editions;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestampFormatter;

import er.ajax.AjaxResponse;
import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.ERXResourceManager;
import er.extensions.appserver.ERXResponse;
import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXQ;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class EditionsDetailProjets {

	static final public Logger LOG = Logger
			.getLogger(EditionsEtatProjets.class);
	public static EOAxerec axe = null;
	public static EOAxerec ppst = null;
	public static EOAxerec ppstStmr = null;
	public static NSArray<EORepartaxe> repartAxeList = new NSArray<EORepartaxe>();
	private static NSMutableArray poles = new NSMutableArray();

	/**
	 * Point d'acces pour la creation de l'edition des projets
	 * 
	 */
	static public CktlAbstractReporter detailProjets(
			NSMutableDictionary bindings, Session sess,
			IJrxmlReportListener listener) {
		String masterJasperFileName = "MainReport.jasper";
		String subReportJasperFileName = "DetailProjetsEditionsSubReport.jasper";
		String subSubReportJasperFileName = "DetailProjetsEditionsSubSubReport.jasper";
		String subReportPartenaireJasperFileName = "DetailReportPartenaire.jasper";
		String subReportPgmAssosJasperFileName = "DetailPrgmAssocie.jasper";
		String subReportKeywordJasperFileName = "DetailKeyword.jasper";
		String subReportContexteJasperFileName = "DetailContexte.jasper";
		String subReportProblematiqueJasperFileName = "DetailProblematique.jasper";
		String subReportObjectifJasperFileName = "DetailObjectifs.jasper";
		String subReportMethodologieJasperFileName = "DetailMethodologie.jasper";
		// point d'entree dans l'arborescence decrite dans le fichier de donnees
		// XML
		String recordPath = "/Detail/Projet";
		JrxmlReporterWithXmlDataSource jr = null;
		try {
			// generation et ecriture du fichier XML produit :
			StringWriter xmlString = createXmlEditionEtatsProjets(bindings,
					sess);
			// Affichage du xml en mode debug uniquement
			//LOG.debug(xmlString);
			// flux fichier associe au fichier XML :
			InputStream xmlFileStream = new ByteArrayInputStream(xmlString
					.toString().getBytes());
			// parametres $P{...} passes au report principal : par ex titres,
			// chemins vers les sous reports, etc.
			Map<String, Object> parameters = new HashMap<String, Object>();
			String subReport = pathForReportDetail(subReportJasperFileName);
			String subSubReport = pathForReportDetail(subSubReportJasperFileName);
			String subPartenaire = pathForReportDetail(subReportPartenaireJasperFileName);
			String subPgmAssos = pathForReportDetail(subReportPgmAssosJasperFileName);
			String subKeyword = pathForReportDetail(subReportKeywordJasperFileName);
			String subContexte = pathForReportDetail(subReportContexteJasperFileName);
			String subProblematique = pathForReportDetail(subReportProblematiqueJasperFileName);
			String subObjectif = pathForReportDetail(subReportObjectifJasperFileName);
			String subMethodologie = pathForReportDetail(subReportMethodologieJasperFileName);
			parameters.put("SubReportFilePath", subReport);
			// NSLog.out.appendln("SubReportFilePath :"+subReport);
			parameters.put("SubSubReportFilePath", subSubReport);
			parameters.put("SubReportPartenairePath", subPartenaire);
			parameters.put("SubReportPgmAssosPath", subPgmAssos);
			parameters.put("SubReportKeywordPath", subKeyword);
			parameters.put("SubReportContextePath", subContexte);
			parameters.put("SubReportProblemPath", subProblematique);
			parameters.put("SubReportObjectifPath", subObjectif);
			parameters.put("SubReportMethodoPath", subMethodologie);
			// NSLog.out.appendln("SubSubReportFilePath :"+subSubReport);
			jr = new JrxmlReporterWithXmlDataSource();
			jr.printWithThread("Edition détaillée des projets", xmlFileStream,
					recordPath, pathForReportDetail(masterJasperFileName),
					parameters, CktlAbstractReporter.EXPORT_FORMAT_PDF, true,
					listener);
		} catch (Throwable e) {
			sess.addSimpleErrorMessage(
					"Une erreur s'est produite durant l'edition des projets",
					e.toString());
			LOG.error("Une erreur s'est produite durant l'edition des projets",
					e);
		}
		// retourne le resultat au client :
		return jr;
	}

	static public CktlAbstractReporter detailProjetsEC(
			NSMutableDictionary bindings, Session sess,
			IJrxmlReportListener listener) {
		String masterJasperFileName = "MainReport.jasper";
		String subReportJasperFileName = "DetailProjetsEditionsSubReport.jasper";
		String subSubReportJasperFileName = "DetailProjetsEditionsSubSubReport.jasper";
		String subReportPartenaireJasperFileName = "DetailReportPartenaire.jasper";
		String subReportPgmAssosJasperFileName = "DetailPrgmAssocie.jasper";
		String subReportKeywordJasperFileName = "DetailKeyword.jasper";
		String subReportContexteJasperFileName = "DetailContexte.jasper";
		String subReportProblematiqueJasperFileName = "DetailProblematique.jasper";
		String subReportObjectifJasperFileName = "DetailObjectifs.jasper";
		String subReportMethodologieJasperFileName = "DetailMethodologie.jasper";
		// point d'entree dans l'arborescence decrite dans le fichier de donnees
		// XML
		String recordPath = "/Detail/Projet";
		JrxmlReporterWithXmlDataSource jr = null;
		try {
			// generation et ecriture du fichier XML produit :
			StringWriter xmlString = createXmlEditionEtatsProjetsEC(bindings,
					sess);
			// Affichage du xml en mode debug uniquement
			//LOG.info(xmlString);
			// flux fichier associe au fichier XML :
			InputStream xmlFileStream = new ByteArrayInputStream(xmlString
					.toString().getBytes());
			// parametres $P{...} passes au report principal : par ex titres,
			// chemins vers les sous reports, etc.
			Map<String, Object> parameters = new HashMap<String, Object>();
			String subReport = pathForReportDetail(subReportJasperFileName);
			String subSubReport = pathForReportDetail(subSubReportJasperFileName);
			String subPartenaire = pathForReportDetail(subReportPartenaireJasperFileName);
			String subPgmAssos = pathForReportDetail(subReportPgmAssosJasperFileName);
			String subKeyword = pathForReportDetail(subReportKeywordJasperFileName);
			String subContexte = pathForReportDetail(subReportContexteJasperFileName);
			String subProblematique = pathForReportDetail(subReportProblematiqueJasperFileName);
			String subObjectif = pathForReportDetail(subReportObjectifJasperFileName);
			String subMethodologie = pathForReportDetail(subReportMethodologieJasperFileName);
			parameters.put("SubReportFilePath", subReport);
			// NSLog.out.appendln("SubReportFilePath :"+subReport);
			parameters.put("SubSubReportFilePath", subSubReport);
			parameters.put("SubReportPartenairePath", subPartenaire);
			parameters.put("SubReportPgmAssosPath", subPgmAssos);
			parameters.put("SubReportKeywordPath", subKeyword);
			parameters.put("SubReportContextePath", subContexte);
			parameters.put("SubReportProblemPath", subProblematique);
			parameters.put("SubReportObjectifPath", subObjectif);
			parameters.put("SubReportMethodoPath", subMethodologie);
			// NSLog.out.appendln("SubSubReportFilePath :"+subSubReport);
			jr = new JrxmlReporterWithXmlDataSource();
			jr.printWithThread("Edition détaillée des projets", xmlFileStream,
					recordPath, pathForReportDetail(masterJasperFileName),
					parameters, CktlAbstractReporter.EXPORT_FORMAT_PDF, true,
					listener);
		} catch (Throwable e) {
			sess.addSimpleErrorMessage(
					"Une erreur s'est produite durant l'edition des projets",
					e.toString());
			LOG.error("Une erreur s'est produite durant l'edition des projets",
					e);
		}
		// retourne le resultat au client :
		return jr;
	}

	// Ecriture du fichier XML
	static public NSData detailXmlProjets(NSMutableDictionary bindings,
			Session sess) {
		NSData jr = null;
		try {
			// generation et ecriture du fichier XML produit :
			StringWriter xmlString = createXmlEditionEtatsProjet(bindings, sess);
			// Affichage du xml en mode debug uniquement
			//LOG.debug(xmlString);
			// flux fichier associe au fichier XML :
			InputStream xmlFileStream = new ByteArrayInputStream(xmlString
					.toString().getBytes());
			jr = new NSData(xmlFileStream, xmlFileStream.available());
		} catch (Throwable e) {
			sess.addSimpleErrorMessage(
					"Une erreur s'est produite durant l'edition des projets",
					e.toString());
			LOG.error("Une erreur s'est produite durant l'edition des projets",
					e);
		}
		// retourne le resultat au client :
		return jr;
	}

	static public CktlAbstractReporter detailXmlProjet(
			NSMutableDictionary bindings, Session sess, String fileName,
			IJrxmlReportListener listener) {
		JrxmlReporterWithXmlDataSource jr = null;
		try {
			// generation et ecriture du fichier XML produit :
			StringWriter xmlString = createXmlEditionEtatsProjet(bindings, sess);
			// Affichage du xml en mode debug uniquement
			//LOG.debug(xmlString);
			// flux fichier associe au fichier XML :
			InputStream xmlFileStream = new ByteArrayInputStream(xmlString
					.toString().getBytes());
			NSData data = new NSData(xmlFileStream, xmlFileStream.available());
			jr = new JrxmlReporterWithXmlDataSource();
			jr.addListener(listener);
			jr.downloadFile(data, fileName, CktlDataResponse.MIME_XML);
		} catch (Throwable e) {
			LOG.error("Une erreur s'est produite durant l'edition des projets",
					e);
		}
		// retourne le resultat au client :
		return jr;
	}

	// Telechargement du fichier XML
	public static WOActionResults afficherXml(NSData xmlData, String fileName,
			CktlAjaxWOComponent comp) {
		AjaxResponse erxResp = new AjaxResponse(comp.context().request(),
				comp.context());
		// CktlDataResponse resp = new CktlDataResponse();
		erxResp.disableClientCaching();
		if (xmlData != null) {
			erxResp.setHeader("maxage=1", "Cache-Control");
			erxResp.setHeader("public", "Pragma");
			erxResp.setHeader(fileName, "Content-Title");
			erxResp.setHeader(CktlDataResponse.MIME_XML, "Content-Type");
			erxResp.setHeader("attachement; filename=\"" + fileName + "\"",
					"Content-Disposition");
			erxResp.setContent(xmlData);
			erxResp.setHeader(String.valueOf(xmlData.length()),
					"Content-Length");
		} else {
			erxResp.setContent("");
			erxResp.setHeader("0", "Content-Length");
		}
		return erxResp.generateResponse();
	}

	// Repertoire contenant les jasper
	protected static String pathForReportDetail(String reportName) {
		ERXResourceManager rsm = (ERXResourceManager) ERXApplication
				.application().resourceManager();
		URL url = rsm.pathURLForResourceNamed("Reports/DetailProjet/"
				+ reportName, "app", null);
		return url.getFile();
	}

	/**
	 * @return the poles
	 */
	public static NSMutableArray getPoles() {
		return poles;
	}

	/**
	 * @param poles
	 *            the poles to set
	 */
	public static void setPoles(NSMutableArray poles) {
		EditionsDetailProjets.poles = poles;
	}

	/**
	 * Interroge la base pour generer le fichier de donnees XML qui sera utilise
	 * pour "nourrir" l'edition. (Utilisation de la bibliotheque du CRI de La
	 * Rochelle)
	 */
	static protected StringWriter createXmlEditionEtatsProjets(
			NSMutableDictionary bindings, Session sess) throws Exception {
		NSTimestampFormatter formatter = new NSTimestampFormatter("%d/%m/%Y");
		// liste projet
		NSMutableArray<ProjectListTampon> tmpListe = new NSMutableArray<ProjectListTampon>();
		// Liste partenaire
		NSArray<EOTyppartenaire> partenaires = new NSArray<EOTyppartenaire>();
		// Liste equipe secondaire
		NSArray<EOEquipes> otherList = new NSArray<EOEquipes>();
		// Liste mot clef
		NSArray<EORefidx> motClesList = new NSArray<EORefidx>();
		// Contrat
		EOTypcontrat contrat = null;
		// Liste personnel
		NSArray<EOPersonnel> personnels = new NSArray<EOPersonnel>();
		// Liste poste
		NSArray<EOPosterh> postes = new NSArray<EOPosterh>();
		// Liste materiels
		NSArray<EOResmat> materiels = new NSArray<EOResmat>();
		// Liste nouveaux materiels
		NSArray<EOResmat> nouveauxMatos = new NSArray<EOResmat>();
		// Commentaire equipe principal
		EOCommentaires comPP = null;
		// Commentaire equipe secondaire
		NSArray<EOCommentaires> comPS = new NSArray<EOCommentaires>();
		// Commentaire equipe secondaire
		NSArray<EOCommentaires> comDrt = new NSArray<EOCommentaires>();
		EOEditingContext edc = sess.editingContext();
		// Fetch des donnees selon le filtre
		sess.setListProjet(EOPprec.fetchFiltreProjet(edc, bindings));
		tmpListe = tamponListProject(sess);
		String vide = "";
		String bogus = "<p><br data-mce-bogus=\"1\"></p>";
		String noRs = "(Non renseign\u00E9e)";
		StringWriter sw = new StringWriter();
		CktlXMLWriter w = new CktlXMLWriter(sw);
		w.setDTD(Editions.DTD_SAX);
		// commencement du document XML :
		w.startDocument();
		w.startElement("Detail");// debut detail
		for (ProjectListTampon tmpList : tmpListe) {
			EOPprec projet = tmpList.getProjet();
			NSLog.out.appendln("Projet "+projet.projnomcourt());
			// Page1
			StringBuffer parts = new StringBuffer();
			StringBuffer prgm = new StringBuffer();
			StringBuffer key = new StringBuffer();
			// Page2
			/** rh **/
			StringBuffer polRh = new StringBuffer();
			StringBuffer persRh = new StringBuffer();
			StringBuffer txRh = new StringBuffer();
			StringBuffer coutRh = new StringBuffer();
			/** poste **/
			StringBuffer polP = new StringBuffer();
			StringBuffer profP = new StringBuffer();
			StringBuffer txP = new StringBuffer();
			StringBuffer durP = new StringBuffer();
			StringBuffer coutP = new StringBuffer();
			/** materiels **/
			StringBuffer poleMat = new StringBuffer();
			StringBuffer ptMat = new StringBuffer();
			StringBuffer geMat = new StringBuffer();
			StringBuffer txUtil = new StringBuffer();
			/** matos **/
			StringBuffer poleNmat = new StringBuffer();
			StringBuffer ptNmat = new StringBuffer();
			StringBuffer geNmat = new StringBuffer();
			StringBuffer txNfin = new StringBuffer();
			StringBuffer cmNmat = new StringBuffer();
			// Page3
			/** Comm SD **/
			StringBuffer equipeSd = new StringBuffer();
			StringBuffer avisSd = new StringBuffer();
			StringBuffer comSd = new StringBuffer();
			/** Comm Drt **/
			StringBuffer poleDrt = new StringBuffer();
			StringBuffer comDr = new StringBuffer();
			StringBuffer avisDrt = new StringBuffer();
			String nomLong = "";
			String contexte = "";
			String objectif = "";
			String problematique = "";
			String methodologie = "";
			/***/
			w.startElement("Projet");// debut projet
			/** PAGE 1 **/
			// Récupération des poles
			EOStructureUlr poleProjet = EOStructureUlr.structurePourcStructure(
					edc, projet.poleCompetence());
			if (poleProjet.grpResponsable() != null) {
				pols(poleProjet);
			}
			// Recuperation cle primaire
			w.writeElement("Id", Editions.cleanedString(projet.primaryKey()));
			// nom long
			if (projet.projnomlong().contains("&")) {
				nomLong = Editions.cleanAmp(projet.projnomlong());
				w.writeElement("Titre", Editions.cleanedString(nomLong));
			} else {
				w.writeElement("Titre",
						Editions.cleanedString(projet.projnomlong()));
			}
			// porteur
			w.writeElement("Porteur",
					Editions.cleanedString(tmpList.getPorteur().fullname()));
			// pole du porteur
			if (poleProjet != null) {
				//NSLog.out.appendln("Pôle :" + poleProjet.lcStructure());
				w.writeElement("Pole", Editions
						.cleanedString((String) poleProjet.lcStructure()));
			} else {
				w.writeElement("Pole", noRs);
			}
			// Etablissment Porteur?
			w.writeElement("etabPorteur",
					Editions.cleanedString(projet.etabPorteur()));
			// duree projet
			w.writeElement("Duree",
					Editions.cleanedString((String) projet.projduree()));
			// date projet
			w.writeElement("DateProjet", Editions.cleanedString(formatter
					.format(projet.projdatdebut())));
			// Contrat
			contrat = Lecontrat(projet, sess);
			if (contrat != null) {
				w.writeElement("Contrat",
						Editions.cleanedString(contrat.typcontNom()));
			} else {
				w.writeElement("Contrat", noRs);
			}
			// Sous-type de contrat
			if (projet.toContrat() != null
					&& projet.toContrat().typcontIdSup() != null) {
				w.writeElement(
						"SousContrat",
						Editions.cleanedString(projet.toContrat()
								.typcontNomAbr().toUpperCase()));
			} else {
				w.writeElement("SousContrat", noRs);
			}
			// les partenaires
			partenaires = lesPartenaires(projet);
			if (partenaires.count() != 0) {
				for (EOTyppartenaire partList : partenaires) {
					if (partList != null) {
						parts.append(Editions.cleanedString(Editions.cleanAmp(partList.denomUsuelle())) + "\n");
					}
				}

				w.writeElement("Partenaires",
						Editions.cleanedString(parts.toString()));
			} else {
				w.writeElement("Partenaires", noRs);
			}
			// Equipe principal
			w.writeElement("prgmPrincipal",
					Editions.cleanedString(tmpList.getEquipe().lcStructure()));
			// Equipes secondaires
			otherList = autres(projet, sess);
			if (otherList.count() != 0) {
				for (EOEquipes eqpList : otherList) {
					if (eqpList != null) {
						EOStructureUlr str = EOStructureUlr
								.structurePourcStructure(edc,
										eqpList.cStructure());
						prgm.append(str.lcStructure() + "\n");
					}

				}
				w.writeElement("prgmAssocie",
						Editions.cleanedString(prgm.toString()));
			} else {
				w.writeElement("prgmAssocie", noRs);
			}
			sTMR(projet, sess);
			// pst et axes
			if (repartAxeList.count() != 0) {
				w.writeElement("Pst", Editions.cleanedString(ppst.axereclib()));
				if (axe != null) {
					w.writeElement("Axe",
							Editions.cleanedString(axe.axereclib()));
				} else {
					w.writeElement("Axe", noRs);
				}
			} else if (projet.toAxe() != null) {
				w.writeElement("Axe",
						Editions.cleanedString(projet.toAxe().axereclib()));
			} else {
				w.writeElement("Pst", noRs);
				w.writeElement("Axe", noRs);
			}
			// axe thématique
			if (ppstStmr != null) {
				w.writeElement("AxeStmr",
						Editions.cleanedString(ppstStmr.axereclib()));
			} else {
				w.writeElement("AxeStmr", noRs);
			}
			// thématique transversale
			if (tmpList.getEquipe().lcStructure().equals("STMR")) {
				w.writeElement("Thmk", Editions.cleanedString(tmpList
						.getEquipe().lcStructure()));
			} else if (projet.projthetv() != null) {
				w.writeElement("Thmk", Editions.cleanedString("O".equals(projet
						.projthetv()) ? "Oui" : "Non"));
			} else {
				w.writeElement("Thmk", noRs);
			}
			// Mot clefs
			motClesList = lesMotCles(projet, sess);
			if (motClesList.count() != 0) {
				for (EORefidx keyList : motClesList) {
					if (keyList != null) {
						key.append(keyList.refidxval() + "\n");
					}
				}
				w.writeElement("Keyword",
						Editions.cleanedString(key.toString()));
			} else {
				w.writeElement("Keyword", noRs);
			}

			// Résumé Projet
			// Contexte
			if (projet.projctx() != null && !projet.projctx().equals(bogus)) {
				if (projet.projctx().contains("&")) {
					contexte = Editions.cleanAmp(projet.projctx());
					w.writeElement("ContexteProjet",
							Editions.cleanedString(cleanTinyMce(contexte)));
				} else {
					w.writeElement("ContexteProjet", Editions
							.cleanedString(cleanTinyMce(projet.projctx())));
				}
			} else {
				w.writeElement("ContexteProjet", (String) noRs);
			}
			// Problématique
			if (projet.projpblm() != null && !projet.projpblm().equals(bogus)) {
				if (projet.projpblm().contains("&")) {
					problematique = Editions.cleanAmp(projet.projpblm());
					w.writeElement("ProblmProjet",
							Editions.cleanedString(cleanTinyMce(problematique)));
				} else {
					w.writeElement("ProblmProjet", Editions
							.cleanedString(cleanTinyMce(projet.projpblm())));
				}
			} else {
				w.writeElement("ProblmProjet", (String) noRs);
			}
			// Objectif
			if (projet.projobf() != null && !projet.projobf().equals(bogus)) {
				if (projet.projobf().contains("&")) {
					objectif = Editions.cleanAmp(projet.projobf());
					w.writeElement("objectifProjet",
							Editions.cleanedString(cleanTinyMce(objectif)));
				} else {
					w.writeElement("objectifProjet", Editions
							.cleanedString(cleanTinyMce(projet.projobf())));
				}
			} else {
				w.writeElement("objectifProjet", (String) noRs);
			}
			// Méthodologie
			if (projet.projmtdg() != null && !projet.projmtdg().equals(bogus)) {
				if (projet.projmtdg().contains("&")) {
					methodologie = Editions.cleanAmp(projet.projmtdg());
					w.writeElement("methodoProjet",
							Editions.cleanedString(cleanTinyMce(methodologie)));
				} else {
					w.writeElement("methodoProjet", Editions
							.cleanedString(cleanTinyMce(projet.projmtdg())));
				}
			} else {
				w.writeElement("methodoProjet", (String) noRs);
			}
			//Fin résumé projet
			/** PAGE 2 **/
			personnels = personnelProjet(projet, sess);
			postes = posteProjet(projet, sess);
			materiels = materielProjet(projet, sess);
			nouveauxMatos = nouveauMaterielProjet(projet, sess);
			if (personnels.count() == 0 && postes.count() == 0
					&& materiels.count() == 0 && nouveauxMatos.count() == 0) {
			} else {
				w.startElement("Resources");// debut resources
				// Personnel
				if (personnels.count() != 0) {
					for (EOPersonnel pers : personnels) {
						if (pers != null) {
							polRh.append(pers.nomStructure() + "\n");
							try {
								persRh.append(pers.toVrhcmval().nomPrenom()
										+ "\n");
							} catch (Exception e) {
								persRh.append("NON RENSEIGNE \n");
								/**
								EOIndividuUlr Ec = EOIndividuUlr.individuPourNumero(edc, pers.noIndividu());
								sess.addSimpleInfoMessage(
										"Estimation des ressources humaines, Personnels impliqués",
										Ec.fullname()
												+ " n'est plus affecté(e) dans le pôle "
												+ pers.nomStructure()
												+ ".");**/
								LOG.error(e.getLocalizedMessage());
							}
							txRh.append(pers.tempsuitl() + ""
									+ Editions.PERCENT + "\n");
							coutRh.append((BigDecimal) pers.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
						}
					}
					w.writeElement("poleTabrh",
							Editions.cleanedString(polRh.toString()));
					w.writeElement("nomPrenom",
							Editions.cleanedString(persRh.toString()));
					w.writeElement("txImpl",
							Editions.cleanedString(txRh.toString()));
					w.writeElement("coutEstime",
							Editions.cleanedString(coutRh.toString()));
				}
				// Poste
				if (postes.count() != 0) {
					for (EOPosterh post : postes) {
						if (post != null) {
							polP.append(post.nomStructure() + "\n");
							profP.append(post.toCategorieRh().typrhcmLib() + "\n");
							txP.append(post.txfinancement() + ""
									+ Editions.PERCENT + "\n");
							durP.append(post.dureeRecrue() + "\n");
							coutP.append((BigDecimal) post.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
						}
					}
					w.writeElement("poleRecru",
							Editions.cleanedString(polP.toString()));
					w.writeElement("profilRecru",
							Editions.cleanedString(profP.toString()));
					w.writeElement("txRecru",
							Editions.cleanedString(txP.toString()));
					w.writeElement("dureeRecru",
							Editions.cleanedString(durP.toString()));
					w.writeElement("cmRecru",
							Editions.cleanedString(coutP.toString()));
				}
				// Materiels
				if (materiels.count() != 0) {
					for (EOResmat mat : materiels) {
						if (mat != null) {
							poleMat.append(mat.nomStructure() + "\n");
							ptMat.append(mat.toPlateauTech().pfmatLib() + "\n");
							geMat.append(mat.toGrandEquipement().gematLib()
									+ "\n");
							txUtil.append(mat.matutil() + "" + Editions.PERCENT
									+ "\n");
						}
					}
					w.writeElement("poleMat",
							Editions.cleanedString(poleMat.toString()));
					w.writeElement("ptMat",
							Editions.cleanedString(ptMat.toString()));
					w.writeElement("geMat",
							Editions.cleanedString(geMat.toString()));
					w.writeElement("txUtil",
							Editions.cleanedString(txUtil.toString()));
				}
				// Nouveau materiels
				if (nouveauxMatos.count() != 0) {
					for (EOResmat newMat : nouveauxMatos) {
						if (newMat != null) {
							poleNmat.append(newMat.nomStructure() + "\n");
							ptNmat.append(newMat.toPlateauTech().pfmatLib()
									+ "\n");
							geNmat.append(newMat.toGrandEquipement().gematLib()
									+ "\n");
							txNfin.append(newMat.txfinancement() + ""
									+ Editions.PERCENT + "\n");
							cmNmat.append((BigDecimal) newMat.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
						}
					}
					w.writeElement("poleNmat",
							Editions.cleanedString(poleNmat.toString()));
					w.writeElement("ptNmat",
							Editions.cleanedString(ptNmat.toString()));
					w.writeElement("geNmat",
							Editions.cleanedString(geNmat.toString()));
					w.writeElement("txNfin",
							Editions.cleanedString(txNfin.toString()));
					w.writeElement("cmNmat",
							Editions.cleanedString(cmNmat.toString()));
				}
				w.endElement();// fin resources
			}

			/** Visa **/
			comPP = commPP(projet, sess);
			comPS = commPS(projet, sess, otherList);
			comDrt = commDrt(projet, sess, poles);
			if (comPP == null && comPS.count() == 0 && comDrt.count() == 0) {
			} else {
				w.startElement("Visa");// debut visa
				// Visa principal
				if (comPP != null) {
					w.writeElement("avisEpp",
							Editions.cleanedString(comPP.toAvis().typreflib()));
					if (comPP.commentaires() != null) {
						w.writeElement("comEpp", Editions
								.cleanedString(cleanTinyMce(comPP
										.commentaires())));
					} else {
						w.writeElement("comEpp", (String) noRs);
					}
				}
				// Visa secondaire
				if (comPS.count() != 0) {
					for (EOCommentaires com : comPS) {
						if (com != null) {
							equipeSd.append(EOStructureUlr
									.structurePourcStructure(
											com.editingContext(),
											com.cStructure()).lcStructure()
									+ "\n");
							if (com.commentaires() != null) {
								comSd.append(cleanTinyMce(com.commentaires())
										+ "\n");
							} else {
								comSd.append(noRs + "\n");
							}
							avisSd.append(com.toAvis().typreflib() + "\n");
						}
					}
					w.writeElement("equipeSd",
							Editions.cleanedString(equipeSd.toString()));
					w.writeElement("comSd",
							Editions.cleanedString(comSd.toString()));
					w.writeElement("avisSd",
							Editions.cleanedString(avisSd.toString()));
				}
				// Visa pole
				if (comDrt.count() != 0) {
					for (EOCommentaires comD : comDrt) {
						if (comD != null) {
							poleDrt.append(EOStructureUlr
									.structurePourcStructure(
											comD.editingContext(),
											comD.cStructure()).lcStructure()
									+ "\n");
							if (comD.commentaires() != null) {
								comDr.append(cleanTinyMce(comD.commentaires())
										+ "\n");
							} else {
								comDr.append(noRs + "\n");
							}
							avisDrt.append(comD.toAvis().typreflib() + "\n");
						}
					}
					w.writeElement("poleDrt",
							Editions.cleanedString(poleDrt.toString()));
					w.writeElement("comDrt",
							Editions.cleanedString(comDr.toString()));
					w.writeElement("avisDrt",
							Editions.cleanedString(avisDrt.toString()));
				}
				w.endElement();// fin visa
			}
			// etat du projet
			w.writeElement("etatProjet",
					Editions.cleanedString(tmpList.getEtat().typreflib()));
			w.endElement();// fin projet
		}
		w.endElement();// fin detail
		w.endDocument();
		w.close();
		return sw;
	}

	static protected StringWriter createXmlEditionEtatsProjetsEC(
			NSMutableDictionary bindings, Session sess) throws Exception {
		NSTimestampFormatter formatter = new NSTimestampFormatter("%d/%m/%Y");
		// liste projet
		NSMutableArray<ProjectListTampon> tmpListe = new NSMutableArray<ProjectListTampon>();
		// Liste partenaire
		NSArray<EOTyppartenaire> partenaires = new NSArray<EOTyppartenaire>();
		// Liste equipe secondaire
		NSArray<EOEquipes> otherList = new NSArray<EOEquipes>();
		// Liste mot clef
		NSArray<EORefidx> motClesList = new NSArray<EORefidx>();
		// Contrat
		EOTypcontrat contrat = null;
		// Liste personnel
		NSArray<EOPersonnel> personnels = new NSArray<EOPersonnel>();
		// Liste poste
		NSArray<EOPosterh> postes = new NSArray<EOPosterh>();
		// Liste materiels
		NSArray<EOResmat> materiels = new NSArray<EOResmat>();
		// Liste nouveaux materiels
		NSArray<EOResmat> nouveauxMatos = new NSArray<EOResmat>();
		// Commentaire equipe principal
		EOCommentaires comPP = null;
		// Commentaire equipe secondaire
		NSArray<EOCommentaires> comPS = new NSArray<EOCommentaires>();
		// Commentaire equipe secondaire
		NSArray<EOCommentaires> comDrt = new NSArray<EOCommentaires>();
		EOEditingContext edc = sess.editingContext();
		// Fetch des donnees selon le filtre
		// sess.setListProjet(EOPprec.filtreEditionProjetEC(edc, bindings));
		tmpListe = (NSMutableArray<ProjectListTampon>) sess
				.getFiltreProjetFacade().displayedObjects();
		String vide = "";
		String bogus = "<p><br data-mce-bogus=\"1\"></p>";
		String noRs = "(Non renseign\u00E9e)";
		StringWriter sw = new StringWriter();
		CktlXMLWriter w = new CktlXMLWriter(sw);
		w.setDTD(Editions.DTD_SAX);

		// commencement du document XML :
		w.startDocument();
		w.startElement("Detail");// debut detail
		for (ProjectListTampon tmpList : tmpListe) {
			EOPprec projet = tmpList.getProjet();
			// Page1
			StringBuffer parts = new StringBuffer();
			StringBuffer prgm = new StringBuffer();
			StringBuffer key = new StringBuffer();
			// Page2
			/** rh **/
			StringBuffer polRh = new StringBuffer();
			StringBuffer persRh = new StringBuffer();
			StringBuffer txRh = new StringBuffer();
			StringBuffer coutRh = new StringBuffer();
			/** poste **/
			StringBuffer polP = new StringBuffer();
			StringBuffer profP = new StringBuffer();
			StringBuffer txP = new StringBuffer();
			StringBuffer durP = new StringBuffer();
			StringBuffer coutP = new StringBuffer();
			/** materiels **/
			StringBuffer poleMat = new StringBuffer();
			StringBuffer ptMat = new StringBuffer();
			StringBuffer geMat = new StringBuffer();
			StringBuffer txUtil = new StringBuffer();
			/** matos **/
			StringBuffer poleNmat = new StringBuffer();
			StringBuffer ptNmat = new StringBuffer();
			StringBuffer geNmat = new StringBuffer();
			StringBuffer txNfin = new StringBuffer();
			StringBuffer cmNmat = new StringBuffer();
			// Page3
			/** Comm SD **/
			StringBuffer equipeSd = new StringBuffer();
			StringBuffer avisSd = new StringBuffer();
			StringBuffer comSd = new StringBuffer();
			/** Comm Drt **/
			StringBuffer poleDrt = new StringBuffer();
			StringBuffer comDr = new StringBuffer();
			StringBuffer avisDrt = new StringBuffer();
			String nomLong = "";
			String contexte = "";
			String objectif = "";
			String problematique = "";
			String methodologie = "";
			/***/
			w.startElement("Projet");// debut projet
			/** PAGE 1 **/
			// Récupération des poles
			EOStructureUlr poleProjet = EOStructureUlr.structurePourcStructure(
					edc, projet.poleCompetence());
			if (poleProjet.grpResponsable() != null) {
				pols(poleProjet);
			}
			// Recuperation cle primaire
			w.writeElement("Id", Editions.cleanedString(projet.primaryKey()));
			// nom long
			if (projet.projnomlong().contains("&")) {
				nomLong = Editions.cleanAmp(projet.projnomlong());
				w.writeElement("Titre", Editions.cleanedString(nomLong));
			} else {
				w.writeElement("Titre",
						Editions.cleanedString(projet.projnomlong()));
			}
			// porteur
			w.writeElement("Porteur",
					Editions.cleanedString(tmpList.getPorteur().fullname()));
			// pole du porteur
			if (poleProjet != null) {
				// NSLog.out.appendln("Pôle :" + poleProjet.lcStructure());
				w.writeElement("Pole", Editions
						.cleanedString((String) poleProjet.lcStructure()));
			} else {
				w.writeElement("Pole", noRs);
			}
			// Etablissment Porteur?
			w.writeElement("etabPorteur",
					Editions.cleanedString(projet.etabPorteur()));
			// duree projet
			w.writeElement("Duree",
					Editions.cleanedString((String) projet.projduree()));
			// date projet
			w.writeElement("DateProjet", Editions.cleanedString(formatter
					.format(projet.projdatdebut())));
			// Contrat
			contrat = Lecontrat(projet, sess);
			if (contrat != null) {
				w.writeElement("Contrat",
						Editions.cleanedString(contrat.typcontNom()));
			} else {
				w.writeElement("Contrat", noRs);
			}
			// Sous-type de contrat
			if (projet.toContrat() != null
					&& projet.toContrat().typcontIdSup() != null) {
				w.writeElement(
						"SousContrat",
						Editions.cleanedString(projet.toContrat()
								.typcontNomAbr().toUpperCase()));
			} else {
				w.writeElement("SousContrat", noRs);
			}
			// les partenaires
			partenaires = lesPartenaires(projet);
			if (partenaires.count() != 0) {
				for (EOTyppartenaire partList : partenaires) {
					if (partList != null) {
						parts.append(Editions.cleanedString(Editions.cleanAmp(partList.denomUsuelle())) + "\n");
					}
				}

				w.writeElement("Partenaires",
						Editions.cleanedString(parts.toString()));
			} else {
				w.writeElement("Partenaires", noRs);
			}
			// Equipe principal
			w.writeElement("prgmPrincipal",
					Editions.cleanedString(tmpList.getEquipe().lcStructure()));
			// Equipes secondaires
			otherList = autres(projet, sess);
			if (otherList.count() != 0) {
				for (EOEquipes eqpList : otherList) {
					if (eqpList != null) {
						EOStructureUlr str = EOStructureUlr
								.structurePourcStructure(edc,
										eqpList.cStructure());
						prgm.append(str.lcStructure() + "\n");
					}

				}
				w.writeElement("prgmAssocie",
						Editions.cleanedString(prgm.toString()));
			} else {
				w.writeElement("prgmAssocie", noRs);
			}
			sTMR(projet, sess);
			// pst et axes
			if (repartAxeList.count() != 0) {
				w.writeElement("Pst", Editions.cleanedString(ppst.axereclib()));
				if (axe != null) {
					w.writeElement("Axe",
							Editions.cleanedString(axe.axereclib()));
				} else {
					w.writeElement("Axe", noRs);
				}
			} else if (projet.toAxe() != null) {
				w.writeElement("Axe",
						Editions.cleanedString(projet.toAxe().axereclib()));
			} else {
				w.writeElement("Pst", noRs);
				w.writeElement("Axe", noRs);
			}
			// axe thématique
			if (ppstStmr != null) {
				w.writeElement("AxeStmr",
						Editions.cleanedString(ppstStmr.axereclib()));
			} else {
				w.writeElement("AxeStmr", noRs);
			}
			// thématique transversale
			if (tmpList.getEquipe().lcStructure().equals("STMR")) {
				w.writeElement("Thmk", Editions.cleanedString(tmpList
						.getEquipe().lcStructure()));
			} else if (projet.projthetv() != null) {
				w.writeElement("Thmk", Editions.cleanedString("O".equals(projet
						.projthetv()) ? "Oui" : "Non"));
			} else {
				w.writeElement("Thmk", noRs);
			}
			// Mot clefs
			motClesList = lesMotCles(projet, sess);
			if (motClesList.count() != 0) {
				for (EORefidx keyList : motClesList) {
					if (keyList != null) {
						key.append(keyList.refidxval() + "\n");
					}
				}
				w.writeElement("Keyword",
						Editions.cleanedString(key.toString()));
			} else {
				w.writeElement("Keyword", noRs);
			}
			// Résumé Projet
			// Contexte
			if (projet.projctx() != null && !projet.projctx().equals(bogus)) {
				if (projet.projctx().contains("&")) {
					contexte = Editions.cleanAmp(projet.projctx());
					w.writeElement("ContexteProjet",
							Editions.cleanedString(cleanTinyMce(contexte)));
				} else {
					w.writeElement("ContexteProjet", Editions
							.cleanedString(cleanTinyMce(projet.projctx())));
				}
			} else {
				w.writeElement("ContexteProjet", (String) noRs);
			}
			// Problématique
			if (projet.projpblm() != null && !projet.projpblm().equals(bogus)) {
				if (projet.projpblm().contains("&")) {
					problematique = Editions.cleanAmp(projet.projpblm());
					w.writeElement("ProblmProjet",
							Editions.cleanedString(cleanTinyMce(problematique)));
				} else {
					w.writeElement("ProblmProjet", Editions
							.cleanedString(cleanTinyMce(projet.projpblm())));
				}
			} else {
				w.writeElement("ProblmProjet", (String) noRs);
			}
			// Objectif
			if (projet.projobf() != null && !projet.projobf().equals(bogus)) {
				if (projet.projobf().contains("&")) {
					objectif = Editions.cleanAmp(projet.projobf());
					w.writeElement("objectifProjet",
							Editions.cleanedString(cleanTinyMce(objectif)));
				} else {
					w.writeElement("objectifProjet", Editions
							.cleanedString(cleanTinyMce(projet.projobf())));
				}
			} else {
				w.writeElement("objectifProjet", (String) noRs);
			}
			// Méthodologie
			if (projet.projmtdg() != null && !projet.projmtdg().equals(bogus)) {
				if (projet.projmtdg().contains("&")) {
					methodologie = Editions.cleanAmp(projet.projmtdg());
					w.writeElement("methodoProjet",
							Editions.cleanedString(cleanTinyMce(methodologie)));
				} else {
					w.writeElement("methodoProjet", Editions
							.cleanedString(cleanTinyMce(projet.projmtdg())));
				}
			} else {
				w.writeElement("methodoProjet", (String) noRs);
			}
			//Fin résumé projet
			/** PAGE 2 **/
			personnels = personnelProjet(projet, sess);
			postes = posteProjet(projet, sess);
			materiels = materielProjet(projet, sess);
			nouveauxMatos = nouveauMaterielProjet(projet, sess);
			if (personnels.count() == 0 && postes.count() == 0
					&& materiels.count() == 0 && nouveauxMatos.count() == 0) {
			} else {
				w.startElement("Resources");// debut resources
				// Personnel
				if (personnels.count() != 0) {
					for (EOPersonnel pers : personnels) {
						if (pers != null) {
							polRh.append(pers.nomStructure() + "\n");
							try {
								persRh.append(pers.toVrhcmval().nomPrenom()
										+ "\n");
							} catch (Exception e) {
								persRh.append("NON RENSEIGNE\n");
								/**
								EOIndividuUlr Ec = EOIndividuUlr.individuPourNumero(edc, pers.noIndividu());
								sess.addSimpleErrorMessage(
										"Estimation des ressources humaines, Personnels impliqués",
										Ec.fullname()
												+ " n'est plus affecté(e) dans le pôle "
												+ pers.nomStructure()
												+ ".");**/
								LOG.error(e.getLocalizedMessage());
							}
							txRh.append(pers.tempsuitl() + ""
									+ Editions.PERCENT + "\n");
							coutRh.append((BigDecimal) pers.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
						}
					}
					w.writeElement("poleTabrh",
							Editions.cleanedString(polRh.toString()));
					w.writeElement("nomPrenom",
							Editions.cleanedString(persRh.toString()));
					w.writeElement("txImpl",
							Editions.cleanedString(txRh.toString()));
					w.writeElement("coutEstime",
							Editions.cleanedString(coutRh.toString()));
				}
				// Poste
				if (postes.count() != 0) {
					for (EOPosterh post : postes) {
						if (post != null) {
							polP.append(post.nomStructure() + "\n");
							profP.append(post.toCategorieRh().typrhcmLib() + "\n");
							txP.append(post.txfinancement() + ""
									+ Editions.PERCENT + "\n");
							durP.append(post.dureeRecrue() + "\n");
							coutP.append((BigDecimal) post.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
						}
					}
					w.writeElement("poleRecru",
							Editions.cleanedString(polP.toString()));
					w.writeElement("profilRecru",
							Editions.cleanedString(profP.toString()));
					w.writeElement("txRecru",
							Editions.cleanedString(txP.toString()));
					w.writeElement("dureeRecru",
							Editions.cleanedString(durP.toString()));
					w.writeElement("cmRecru",
							Editions.cleanedString(coutP.toString()));
				}
				// Materiels
				if (materiels.count() != 0) {
					for (EOResmat mat : materiels) {
						if (mat != null) {
							poleMat.append(mat.nomStructure() + "\n");
							ptMat.append(mat.toPlateauTech().pfmatLib() + "\n");
							geMat.append(mat.toGrandEquipement().gematLib()
									+ "\n");
							txUtil.append(mat.matutil() + "" + Editions.PERCENT
									+ "\n");
						}
					}
					w.writeElement("poleMat",
							Editions.cleanedString(poleMat.toString()));
					w.writeElement("ptMat",
							Editions.cleanedString(ptMat.toString()));
					w.writeElement("geMat",
							Editions.cleanedString(geMat.toString()));
					w.writeElement("txUtil",
							Editions.cleanedString(txUtil.toString()));
				}
				// Nouveau materiels
				if (nouveauxMatos.count() != 0) {
					for (EOResmat newMat : nouveauxMatos) {
						if (newMat != null) {
							poleNmat.append(newMat.nomStructure() + "\n");
							ptNmat.append(newMat.toPlateauTech().pfmatLib()
									+ "\n");
							geNmat.append(newMat.toGrandEquipement().gematLib()
									+ "\n");
							txNfin.append(newMat.txfinancement() + ""
									+ Editions.PERCENT + "\n");
							cmNmat.append((BigDecimal) newMat.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
						}
					}
					w.writeElement("poleNmat",
							Editions.cleanedString(poleNmat.toString()));
					w.writeElement("ptNmat",
							Editions.cleanedString(ptNmat.toString()));
					w.writeElement("geNmat",
							Editions.cleanedString(geNmat.toString()));
					w.writeElement("txNfin",
							Editions.cleanedString(txNfin.toString()));
					w.writeElement("cmNmat",
							Editions.cleanedString(cmNmat.toString()));
				}
				w.endElement();// fin resources
			}

			/** Visa **/
			comPP = commPP(projet, sess);
			comPS = commPS(projet, sess, otherList);
			comDrt = commDrt(projet, sess, poles);
			if (comPP == null && comPS.count() == 0 && comDrt.count() == 0) {
			} else {
				w.startElement("Visa");// debut visa
				// Visa principal
				if (comPP != null) {
					w.writeElement("avisEpp",
							Editions.cleanedString(comPP.toAvis().typreflib()));
					if (comPP.commentaires() != null) {
						w.writeElement("comEpp", Editions
								.cleanedString(cleanTinyMce(comPP
										.commentaires())));
					} else {
						w.writeElement("comEpp", (String) noRs);
					}
				}
				// Visa secondaire
				if (comPS.count() != 0) {
					for (EOCommentaires com : comPS) {
						if (com != null) {
							equipeSd.append(EOStructureUlr
									.structurePourcStructure(
											com.editingContext(),
											com.cStructure()).lcStructure()
									+ "\n");
							if (com.commentaires() != null) {
								comSd.append(cleanTinyMce(com.commentaires())
										+ "\n");
							} else {
								comSd.append(noRs + "\n");
							}
							avisSd.append(com.toAvis().typreflib() + "\n");
						}
					}
					w.writeElement("equipeSd",
							Editions.cleanedString(equipeSd.toString()));
					w.writeElement("comSd",
							Editions.cleanedString(comSd.toString()));
					w.writeElement("avisSd",
							Editions.cleanedString(avisSd.toString()));
				}
				// Visa pole
				if (comDrt.count() != 0) {
					for (EOCommentaires comD : comDrt) {
						if (comD != null) {
							poleDrt.append(EOStructureUlr
									.structurePourcStructure(
											comD.editingContext(),
											comD.cStructure()).lcStructure()
									+ "\n");
							if (comD.commentaires() != null) {
								comDr.append(cleanTinyMce(comD.commentaires())
										+ "\n");
							} else {
								comDr.append(noRs + "\n");
							}
							avisDrt.append(comD.toAvis().typreflib() + "\n");
						}
					}
					w.writeElement("poleDrt",
							Editions.cleanedString(poleDrt.toString()));
					w.writeElement("comDrt",
							Editions.cleanedString(comDr.toString()));
					w.writeElement("avisDrt",
							Editions.cleanedString(avisDrt.toString()));
				}
				w.endElement();// fin visa
			}
			// etat du projet
			w.writeElement("etatProjet",
					Editions.cleanedString(tmpList.getEtat().typreflib()));
			w.endElement();// fin projet
		}
		w.endElement();// fin detail
		w.endDocument();
		w.close();
		return sw;
	}

	// Impression XML Seulement
	static protected StringWriter createXmlEditionEtatsProjet(
			NSMutableDictionary bindings, Session sess) throws Exception {
		NSTimestampFormatter formatter = new NSTimestampFormatter("%d/%m/%Y");
		// liste projet
		NSMutableArray<ProjectListTampon> tmpListe = new NSMutableArray<ProjectListTampon>();
		// Liste partenaire
		NSArray<EOTyppartenaire> partenaires = new NSArray<EOTyppartenaire>();
		// Liste equipe secondaire
		NSArray<EOEquipes> otherList = new NSArray<EOEquipes>();
		// Liste mot clef
		NSArray<EORefidx> motClesList = new NSArray<EORefidx>();
		// Contrat
		EOTypcontrat contrat = null;
		// Liste personnel
		NSArray<EOPersonnel> personnels = new NSArray<EOPersonnel>();
		// Liste poste
		NSArray<EOPosterh> postes = new NSArray<EOPosterh>();
		// Liste materiels
		NSArray<EOResmat> materiels = new NSArray<EOResmat>();
		// Liste nouveaux materiels
		NSArray<EOResmat> nouveauxMatos = new NSArray<EOResmat>();
		// Commentaire equipe principal
		EOCommentaires comPP = null;
		// Commentaire equipe secondaire
		NSArray<EOCommentaires> comPS = new NSArray<EOCommentaires>();
		// Commentaire equipe secondaire
		NSArray<EOCommentaires> comDrt = new NSArray<EOCommentaires>();
		EOEditingContext edc = sess.editingContext();
		// Fetch des donnees selon le filtre
		sess.setListProjet(EOPprec.fetchFiltreProjet(edc, bindings));
		tmpListe = tamponListProject(sess);
		String vide = "";
		String bogus = "<p><br data-mce-bogus=\"1\"></p>";
		String noRs = "(Non renseign\u00E9e)";
		StringWriter sw = new StringWriter();
		CktlXMLWriter w = new CktlXMLWriter(sw);
		// commencement du document XML :
		w.startDocument();
		w.startElement("Detail");// debut detail
		for (ProjectListTampon tmpList : tmpListe) {
			EOPprec projet = tmpList.getProjet();
			// Page1
			StringBuffer parts = new StringBuffer();
			StringBuffer prgm = new StringBuffer();
			StringBuffer key = new StringBuffer();
			// Page2
			/** rh **/
			StringBuffer polRh = new StringBuffer();
			StringBuffer persRh = new StringBuffer();
			StringBuffer txRh = new StringBuffer();
			StringBuffer coutRh = new StringBuffer();
			/** poste **/
			StringBuffer polP = new StringBuffer();
			StringBuffer profP = new StringBuffer();
			StringBuffer txP = new StringBuffer();
			StringBuffer durP = new StringBuffer();
			StringBuffer coutP = new StringBuffer();
			/** materiels **/
			StringBuffer poleMat = new StringBuffer();
			StringBuffer ptMat = new StringBuffer();
			StringBuffer geMat = new StringBuffer();
			StringBuffer txUtil = new StringBuffer();
			/** matos **/
			StringBuffer poleNmat = new StringBuffer();
			StringBuffer ptNmat = new StringBuffer();
			StringBuffer geNmat = new StringBuffer();
			StringBuffer txNfin = new StringBuffer();
			StringBuffer cmNmat = new StringBuffer();
			// Page3
			/** Comm SD **/
			StringBuffer equipeSd = new StringBuffer();
			StringBuffer avisSd = new StringBuffer();
			StringBuffer comSd = new StringBuffer();
			/** Comm Drt **/
			StringBuffer poleDrt = new StringBuffer();
			StringBuffer comDr = new StringBuffer();
			StringBuffer avisDrt = new StringBuffer();
			String nomLong = "";
			String contexte = "";
			String objectif = "";
			String problematique = "";
			String methodologie = "";
			/** PAGE 1 **/
			EOStructureUlr poleProjet = EOStructureUlr.structurePourcStructure(
					edc, projet.poleCompetence());
			// Récupération des poles
			if (poleProjet.grpResponsable() != null) {
				pols(poleProjet);
			}

			/***/
			w.startElement("Projet");// debut projet
			// Recuperation cle primaire
			w.writeElement("Id", Editions.cleanedString(projet.primaryKey()));
			// nom long
			if (projet.projnomlong().contains("&")) {
				nomLong = Editions.cleanAmp(projet.projnomlong());
				w.writeElement("Titre", Editions.cleanedString(nomLong));
			} else {
				w.writeElement("Titre",
						Editions.cleanedString(projet.projnomlong()));
			}
			// porteur
			w.writeElement("Porteur",
					Editions.cleanedString(tmpList.getPorteur().fullname()));
			// pole du porteur
			if (poleProjet != null) {
				w.writeElement("Pole", Editions
						.cleanedString((String) poleProjet.lcStructure()));
			} else {
				w.writeElement("Pole", noRs);
			}
			// Etablissment Porteur?
			w.writeElement("EtablissementPorteur",
					Editions.cleanedString(projet.etabPorteur()));
			// duree projet
			w.writeElement("Duree",
					Editions.cleanedString((String) projet.projduree()));
			// date projet
			w.writeElement("DateProjet", Editions.cleanedString(formatter
					.format(projet.projdatdebut())));
			// Contrat
			contrat = Lecontrat(projet, sess);
			if (contrat != null) {
				w.writeElement("Contrat",
						Editions.cleanedString(contrat.typcontNom()));
			} else {
				w.writeElement("Contrat", noRs);
			}
			// Sous-type de contrat
			if (projet.toContrat() != null
					&& projet.toContrat().typcontIdSup() != null) {
				w.writeElement(
						"SousContrat",
						Editions.cleanedString(projet.toContrat()
								.typcontNomAbr().toUpperCase()));
			} else {
				w.writeElement("SousContrat", noRs);
			}
			// les partenaires
			partenaires = lesPartenaires(projet);
			if (partenaires.count() != 0) {
				w.startElement("Partenaires");// Debut Partenaires
				for (EOTyppartenaire partList : partenaires) {
					if (partList != null) {
						// parts.append(partList.denomUsuelle() + "\n");
						w.writeElement("Partenaire",
								Editions.cleanedString(Editions.cleanedString(Editions.cleanAmp(partList.denomUsuelle()))));
					}
				}
				w.endElement();// Fin partenaire
			} else {
				w.startElement("Partenaires");// Debut Partenaires
				w.writeElement("Partenaire", noRs);
				w.endElement();// Fin partenaire
			}
			// Equipe principal
			w.writeElement("ProgrammePrincipal",
					Editions.cleanedString(tmpList.getEquipe().lcStructure()));
			// Equipes secondaires
			otherList = autres(projet, sess);
			if (otherList.count() != 0) {
				w.startElement("ProgrammesAssocies");// Debut prgm Associes
				for (EOEquipes eqpList : otherList) {
					if (eqpList != null) {
						EOStructureUlr str = EOStructureUlr
								.structurePourcStructure(edc,
										eqpList.cStructure());
						// prgm.append(str.lcStructure() + "\n");
						w.writeElement("ProgrammeAssocie",
								Editions.cleanedString(str.lcStructure()));
					}

				}
				w.endElement();
			} else {
				w.startElement("ProgrammesAssocies");// Debut prgm Associes
				w.writeElement("ProgrammeAssocie", noRs);
				w.endElement();// Fin prgm Associes
			}
			sTMR(projet, sess);
			// pst et axes
			if (repartAxeList.count() != 0) {
				w.writeElement("Pst", Editions.cleanedString(ppst.axereclib()));
				if (axe != null) {
					w.writeElement("Axe",
							Editions.cleanedString(axe.axereclib()));
				} else {
					w.writeElement("Axe", noRs);
				}
			} else if (projet.toAxe() != null) {
				w.writeElement("Axe",
						Editions.cleanedString(projet.toAxe().axereclib()));
			} else {
				w.writeElement("Pst", noRs);
				w.writeElement("Axe", noRs);
			}
			// axe thématique
			if (ppstStmr != null) {
				w.writeElement("AxeStmr",
						Editions.cleanedString(ppstStmr.axereclib()));
			} else {
				w.writeElement("AxeStmr", noRs);
			}
			// thématique transversale
			if (tmpList.getEquipe().lcStructure().equals("STMR")) {
				w.writeElement("ThematiqueTransvere", Editions
						.cleanedString(tmpList.getEquipe().lcStructure()));
			} else if (projet.projthetv() != null) {
				w.writeElement("ThematiqueTransvere", Editions
						.cleanedString("O".equals(projet.projthetv()) ? "Oui"
								: "Non"));
			} else {
				w.writeElement("ThematiqueTransvere", noRs);
			}
			// Mot clefs
			motClesList = lesMotCles(projet, sess);
			if (motClesList.count() != 0) {
				w.startElement("MotsClefs");// Debut Mot clefs
				for (EORefidx keyList : motClesList) {
					if (keyList != null) {
						// key.append(keyList.refidxval() + "\n");
						w.writeElement("MotClef",
								Editions.cleanedString(keyList.refidxval()));
					}
				}
				w.endElement();// Fin Mot clefs
			} else {
				w.startElement("MotsClefs");// Debut Mot clefs
				w.writeElement("MotClef", noRs);
				w.endElement();// Fin Mot clefs
			}
			/*
			 * // Résumé Projet // Contexte if (projet.projctx() != null &&
			 * !projet.projctx().equals(bogus)) {
			 * w.writeElement("ContexteProjet",
			 * Editions.cleanedString(cleanTinyMce(projet.projctx()))); } else {
			 * w.writeElement("ContexteProjet", (String) noRs); } //
			 * Problématique if (projet.projpblm() != null &&
			 * !projet.projpblm().equals(bogus)) {
			 * w.writeElement("ProblmProjet",
			 * Editions.cleanedString(cleanTinyMce(projet.projpblm()))); } else
			 * { w.writeElement("ProblmProjet", (String) noRs); } // Objectif if
			 * (projet.projobf() != null && !projet.projobf().equals(bogus)) {
			 * w.writeElement("objectifProjet",
			 * Editions.cleanedString(cleanTinyMce(projet.projobf()))); } else {
			 * w.writeElement("objectifProjet",(String) noRs); } // Méthodologie
			 * if (projet.projmtdg() != null &&
			 * !projet.projmtdg().equals(bogus)) {
			 * w.writeElement("methodoProjet",
			 * Editions.cleanedString(cleanTinyMce(projet.projmtdg()))); } else
			 * { w.writeElement("methodoProjet", (String) noRs); }
			 */
			/** PAGE 2 **/
			personnels = personnelProjet(projet, sess);
			postes = posteProjet(projet, sess);
			materiels = materielProjet(projet, sess);
			nouveauxMatos = nouveauMaterielProjet(projet, sess);
			if (personnels.count() == 0 && postes.count() == 0
					&& materiels.count() == 0 && nouveauxMatos.count() == 0) {
			} else {
				// Personnel
				if (personnels.count() != 0) {
					for (EOPersonnel pers : personnels) {
						w.startElement("PersonnelImplique");
						if (pers != null) {
							polRh.append(pers.nomStructure() + "\n");
							// groupePole.addObject(pers.nomStructure());
							w.writeElement("PolePersonnel",
									Editions.cleanedString(pers.nomStructure()));
							try {
								persRh.append(pers.toVrhcmval().nomPrenom()
										+ "\n");
								w.writeElement("Chercheur", Editions
										.cleanedString(pers.toVrhcmval()
												.nomPrenom()));
								// groupeChercheur.addObject(pers.toVrhcmval().nomPrenom());
							} catch (Exception e) {
								persRh.append("NON RENSEIGNE \n");
								// groupeChercheur.addObject("NON RENSEIGNE");
								w.writeElement("Chercheur",
										Editions.cleanedString("NON RENSEIGNE"));
								/**
								EOIndividuUlr Ec = EOIndividuUlr.individuPourNumero(edc, pers.noIndividu());
								sess.addSimpleErrorMessage(
										"Estimation des ressources humaines, Personnels impliqués",
										Ec.fullname()
												+ " n'est plus affecté(e) dans le pôle "
												+ pers.nomStructure()
												+ ".");**/
								LOG.error(e.getLocalizedMessage());
							}
							txRh.append(pers.tempsuitl() + ""
									+ Editions.PERCENT + "\n");
							// groupeTx.addObject(pers.tempsuitl() + ""+
							// Editions.PERCENT);
							w.writeElement(
									"TauPersonnel",
									Editions.cleanedString(pers.tempsuitl()
											+ "" + Editions.PERCENT));
							coutRh.append((BigDecimal) pers.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
							// groupeCout.addObject((BigDecimal)
							// pers.coutestime()+ "" + Editions.MONNAIE_EURO);
							w.writeElement("coutPersonnel", Editions
									.cleanedString((BigDecimal) pers
											.coutestime()
											+ ""
											+ Editions.MONNAIE_EURO));
						}
						w.endElement();// Personnel
					}
				}
				// Poste
				if (postes.count() != 0) {
					for (EOPosterh post : postes) {
						w.startElement("Profil_a_Recruter");
						if (post != null) {
							polP.append(post.nomStructure() + "\n");
							// groupePole.addObject(post.nomStructure());
							w.writeElement("poleProfil",
									Editions.cleanedString(post.nomStructure()));
							profP.append(post.toCategorieRh().typrhcmLib() + "\n");
							// groupePoste.addObject(post.toCategorieRh().typrhcmLib());
							w.writeElement("Profil", Editions
									.cleanedString(post.toCategorieRh()
											.typrhcmLib()));
							txP.append(post.txfinancement() + ""
									+ Editions.PERCENT + "\n");
							// groupeTx.addObject(post.txfinancement() + ""+
							// Editions.PERCENT);
							w.writeElement(
									"tauFinancementProfil",
									Editions.cleanedString(post.txfinancement()
											+ "" + Editions.PERCENT));
							durP.append(post.dureeRecrue() + "\n");
							w.writeElement("dureeProfil",
									Editions.cleanedString(post.dureeRecrue()));
							// groupeDuree.addObject(post.dureeRecrue());
							coutP.append((BigDecimal) post.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
							// groupeCout.addObject((BigDecimal)
							// post.coutestime()+ "" + Editions.MONNAIE_EURO);
							w.writeElement("coutProfil", Editions
									.cleanedString((BigDecimal) post
											.coutestime()
											+ ""
											+ Editions.MONNAIE_EURO));
						}

						w.endElement();// Fin profil
					}
				}
				// Materiels
				if (materiels.count() != 0) {
					for (EOResmat mat : materiels) {
						w.startElement("MaterielExistant");
						if (mat != null) {
							poleMat.append(mat.nomStructure() + "\n");
							w.writeElement("poleExistant",
									Editions.cleanedString(mat.nomStructure()));
							ptMat.append(mat.toPlateauTech().pfmatLib() + "\n");
							w.writeElement("plateauExistant",
									Editions.cleanedString(mat.toPlateauTech()
											.pfmatLib()));
							geMat.append(mat.toGrandEquipement().gematLib()
									+ "\n");
							w.writeElement("equipementExistant", Editions
									.cleanedString(mat.toGrandEquipement()
											.gematLib()));
							txUtil.append(mat.matutil() + "" + Editions.PERCENT
									+ "\n");
							w.writeElement(
									"tauExistant ",
									Editions.cleanedString(mat.matutil() + ""
											+ Editions.PERCENT));
						}

						w.endElement();// Fin mat existant
					}
				}
				// Nouveau materiels
				if (nouveauxMatos.count() != 0) {
					for (EOResmat newMat : nouveauxMatos) {
						w.startElement("NouveauMateriel");
						if (newMat != null) {
							poleNmat.append(newMat.nomStructure() + "\n");
							w.writeElement("poleNouveauMateriel", Editions
									.cleanedString(newMat.nomStructure()));
							ptNmat.append(newMat.toPlateauTech().pfmatLib()
									+ "\n");
							w.writeElement("plateauNouveauMateriel", Editions
									.cleanedString(newMat.toPlateauTech()
											.pfmatLib()));
							geNmat.append(newMat.toGrandEquipement().gematLib()
									+ "\n");
							w.writeElement("equipementNouveauMateriel",
									Editions.cleanedString(newMat
											.toGrandEquipement().gematLib()));
							txNfin.append(newMat.txfinancement() + ""
									+ Editions.PERCENT + "\n");
							w.writeElement("tauNouveauMateriel ", Editions
									.cleanedString(newMat.txfinancement()));
							cmNmat.append((BigDecimal) newMat.coutestime() + ""
									+ Editions.MONNAIE_EURO + "\n");
							w.writeElement("coutNouveauMateriel ", Editions
									.cleanedString((BigDecimal) newMat
											.coutestime()
											+ ""
											+ Editions.MONNAIE_EURO));
						}

						w.endElement();
					}
				}
			}

			/** Visa **/
			comPP = commPP(projet, sess);
			comPS = commPS(projet, sess, otherList);
			comDrt = commDrt(projet, sess, poles);
			if (comPP == null && comPS.count() == 0 && comDrt.count() == 0) {
			} else {
				// Visa principal
				if (comPP != null) {
					w.startElement("ResponsableEquipePrincipal");
					w.writeElement("avisResponsableEquipe",
							Editions.cleanedString(comPP.toAvis().typreflib()));
					if (comPP.commentaires() != null) {
						w.writeElement("commentaireResponsableEquipe",
								Editions.cleanedString(comPP.commentaires()));
					} else {
						w.writeElement("commentaireResponsableEquipe",
								(String) noRs);
					}
					w.endElement();
				}
				// Visa secondaire
				if (comPS.count() != 0) {
					for (EOCommentaires com : comPS) {
						if (com != null) {
							equipeSd.append(EOStructureUlr
									.structurePourcStructure(
											com.editingContext(),
											com.cStructure()).lcStructure()
									+ "\n");
							if (com.commentaires() != null) {
								comSd.append(cleanTinyMce(com.commentaires())
										+ "\n");
							} else {
								comSd.append(noRs + "\n");
							}
							avisSd.append(com.toAvis().typreflib() + "\n");
						}
					}
					w.writeElement("equipeSd",
							Editions.cleanedString(equipeSd.toString()));
					w.writeElement("comSd",
							Editions.cleanedString(comSd.toString()));
					w.writeElement("avisSd",
							Editions.cleanedString(avisSd.toString()));
				}
				// Visa pole
				if (comDrt.count() != 0) {
					NSMutableArray<String> groupePole = new NSMutableArray<String>();
					NSMutableArray<String> groupeCom = new NSMutableArray<String>();
					NSMutableArray<String> groupeAvis = new NSMutableArray<String>();
					for (EOCommentaires comD : comDrt) {
						w.startElement("AvisCommentaireDirecteurDePole");
						if (comD != null) {
							poleDrt.append(EOStructureUlr
									.structurePourcStructure(
											comD.editingContext(),
											comD.cStructure()).lcStructure()
									+ "\n");
							w.writeElement("poleDirecteurDePole", Editions
									.cleanedString(EOStructureUlr
											.structurePourcStructure(
													comD.editingContext(),
													comD.cStructure())
											.lcStructure()));
							if (comD.commentaires() != null) {
								comDr.append(comD.commentaires() + "\n");
								w.writeElement("commentaireDirecteurDePole",
										Editions.cleanedString(comD
												.commentaires()));
							} else {
								comDr.append(noRs + "\n");
								w.writeElement("commentaireDirecteurDePole",
										Editions.cleanedString(noRs));
							}
							avisDrt.append(comD.toAvis().typreflib() + "\n");
							w.writeElement("avisDirecteurDePole", Editions
									.cleanedString(comD.toAvis().typreflib()));
						}
						w.endElement();
					}
				}
			}
			// etat du projet
			w.writeElement("etatProjet",
					Editions.cleanedString(tmpList.getEtat().typreflib()));
			w.endElement();// fin projet
			LOG.info(sw);
		}
		w.endElement();// fin detail
		w.endDocument();
		w.close();
		return sw;
	}

	// Traitement de la liste des projet selectionnee selon le filtre
	protected static NSMutableArray tamponListProject(Session sess) {
		NSMutableArray<ProjectListTampon> tmpListe = new NSMutableArray<ProjectListTampon>();
		if (sess.getListProjet().count() > 0) {
			for (int i = 0; sess.getListProjet().count() > i; i++) {
				ProjectListTampon tmpList = new ProjectListTampon();
				EOPprec projet = sess.getListProjet().objectAtIndex(i);
				tmpList.setEtat(projet.toEtat());
				tmpList.setProjet(projet);
				tmpList.setPorteur(EOIndividuUlr.individuPourNumero(
						projet.editingContext(), projet.porteur()));
				tmpList.setContrat(projet.toContrat());
				tmpList.setEquipe(EOStructureUlr.structurePourcStructure(
						projet.editingContext(), projet.equipePrincipale()));
				tmpListe.addObject(tmpList);
			}
		}
		return tmpListe;
	}

	// Affiche la liste des partenaire valide pour le projet
	protected static NSArray<EOTyppartenaire> lesPartenaires(EOPprec projet) {
		NSArray<EOPartenaireProjet> partProj = projet.toProjetPartenaires(
				EOPartenaireProjet.TEMVALIDE.eq("O"), true);
		NSMutableArray<EOTyppartenaire> tmp = new NSMutableArray<EOTyppartenaire>();
		for (int i = 0; i < partProj.count(); i++) {
			tmp.addObject(partProj.objectAtIndex(i).toPartenaire());
		}
		return tmp.immutableClone();
	}

	// Affichage Contrat
	protected static EOTypcontrat Lecontrat(EOPprec projet, Session sess) {
		EOTypcontrat tmp = null;
		if (projet.toContrat() != null) {
			if (projet.toContrat().typcontIdSup() != null) {
				tmp = EOTypcontrat.fetchContratPere(sess.editingContext(),
						projet.toContrat().typcontIdSup()).lastObject();

			} else {
				tmp = projet.toContrat();
			}
		}
		return tmp;
	}

	// traitement Equipes secondaires
	protected static NSArray<EOEquipes> autres(EOPprec projet, Session sess) {
		NSArray<EOEquipes> equipes = EOEquipes.fetchEOEquipeses(
				sess.editingContext(),
				EOEquipes.TO_PROJET.eq(projet).and(EOEquipes.PRINCIPALE.eq("N"))
						.and(EOEquipes.TEMVALIDE.eq("O")), null);
		NSArray<EOEquipes> therList = new NSArray<EOEquipes>();
		if (equipes != null && equipes.count() != 0) {
			therList = EOStructureUlr.C_STRUCTURE.isNot(
					projet.equipePrincipale()).filtered(equipes);
		}
		return therList;
	}

	// Traitement pst et axe stmr
	protected static void sTMR(EOPprec projet, Session sess) {
		NSArray<EORepartaxe> pst = projet
				.toProjetRepartaxes(EORepartaxe.TEMVALIDE.eq("O"));
		if (projet.projthetv().equals("O")) {
			NSArray lst = EORepartaxe.fetchAxeThematique(sess.editingContext(),
					umrStmr(sess).cStructure(),
					Integer.valueOf(projet.primaryKey()));
			if (lst.count() != 0)
				// axe thematique
				ppstStmr = ((EORepartaxe) lst.lastObject()).toAxe();
		} else {
			if (pst != null && pst.count() != 0) {
				repartAxeList = pst;
				for (int i = 0; i < pst.count(); i++) {
					EOAxerec axe0 = new EOAxerec();
					axe0 = pst.objectAtIndex(i).toAxe();
					if (axe0.isPst()) {
						// pst stmr
						ppst = axe0;
					} else {
						// axe stmr
						axe = axe0;
					}
				}
			}
		}
	}

	// Affichage des mots cles du projet
	protected static NSArray<EORefidx> lesMotCles(EOPprec projet, Session sess) {
		NSArray<EOMotclefs> motCleList = new NSArray<EOMotclefs>();
		NSMutableArray tmp = new NSMutableArray();
		motCleList = EOMotclefs.fetchMotClefsProjet(sess.editingContext(),
				Integer.valueOf(projet.primaryKey()));
		if (motCleList.count() > 0) {
			for (int i = 0; i < motCleList.count(); i++) {
				tmp.addObject(motCleList.objectAtIndex(i).toRefidx());
			}
		}
		return tmp.immutableClone();
	}

	// Page 2
	protected static NSArray<EOPersonnel> personnelProjet(EOPprec projet,
			Session sess) {
		NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
		bindings.takeValueForKey(Long.valueOf(projet.primaryKey()), "projetId");
		NSArray tmp = EOPersonnel.fetchPersonnelProjet(sess.editingContext(),
				bindings);
		for (int i = 0; i < tmp.count(); i++) {
			EOPersonnel pers = (EOPersonnel) tmp.objectAtIndex(i);
			EOStructureUlr pole = EOStructureUlr.structurePourcStructure(
					pers.editingContext(), pers.cStructure());
			if (pole.grpResponsable() != null) {
				pols(pole);
			}
		}
		return tmp;
	}

	protected static NSArray<EOPosterh> posteProjet(EOPprec projet, Session sess) {
		NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
		bindings.takeValueForKey(Long.valueOf(projet.primaryKey()), "projetId");
		NSArray tmp = EOPosterh.fetchPosteProjet(sess.editingContext(),
				bindings);
		for (int i = 0; i < tmp.count(); i++) {
			EOPosterh post = (EOPosterh) tmp.objectAtIndex(i);
			EOStructureUlr pole = EOStructureUlr.structurePourcStructure(
					post.editingContext(), post.cStructure());
			if (pole.grpResponsable() != null) {
				pols(pole);
			}
		}
		return tmp;
	}

	protected static NSArray<EOResmat> materielProjet(EOPprec projet,
			Session sess) {
		NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
		bindings.takeValueForKey(Long.valueOf(projet.primaryKey()), "projetId");
		NSArray tmp = EOResmat.fetchMaterielProjet(sess.editingContext(),
				bindings);
		for (int i = 0; i < tmp.count(); i++) {
			EOResmat matos = (EOResmat) tmp.objectAtIndex(i);
			EOStructureUlr pole = EOStructureUlr.structurePourcStructure(
					matos.editingContext(), matos.cStructure());
			if (pole.grpResponsable() != null) {
				pols(pole);
			}
		}
		return tmp;
	}

	protected static NSArray<EOResmat> nouveauMaterielProjet(EOPprec projet,
			Session sess) {
		NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
		bindings.takeValueForKey(Long.valueOf(projet.primaryKey()), "projetId");
		NSArray tmp = EOResmat.fetchNouceauMaterielProjet(
				sess.editingContext(), bindings);
		for (int i = 0; i < tmp.count(); i++) {
			EOResmat newMatos = (EOResmat) tmp.objectAtIndex(i);
			EOStructureUlr pole = EOStructureUlr.structurePourcStructure(
					newMatos.editingContext(), newMatos.cStructure());
			if (pole.grpResponsable() != null) {
				pols(pole);
			}
		}
		return tmp;
	}

	// Fin page 2

	// Page Visa
	// Affichage du commentaire du responsable du PRGM principal
	protected static EOCommentaires commPP(EOPprec projet, Session sess) {
		EOQualifier qual = ERXQ.is(EOCommentaires.C_STRUCTURE_KEY,
				projet.equipePrincipale()).and(
				EOCommentaires.PROJET.eq(Integer.valueOf(projet.primaryKey())));
		return EOCommentaires.fetchEOCommentaires(sess.editingContext(), qual);
	}

	// Affichage des commentaires des responsables des PRGM secondaires (s'ils
	// existent)
	protected static NSArray<EOCommentaires> commPS(EOPprec projet,
			Session sess, NSArray<EOEquipes> otherList) {
		NSMutableArray<EOStructureUlr> rechUnitPrj = new NSMutableArray<EOStructureUlr>();
		NSMutableArray<EOCommentaires> tmpCom = new NSMutableArray<EOCommentaires>();
		EOCommentaires comment = null;
		NSMutableArray<EOEquipes> tmp = new NSMutableArray<EOEquipes>();
		if (otherList != null && otherList.count() > 0)
			for (int i = 0; i < otherList.count(); i++) {
				EOStructureUlr str = EOStructureUlr.structurePourcStructure(
						ERXEC.newEditingContext(), otherList.objectAtIndex(i)
								.cStructure());
				rechUnitPrj.addObject(str);
			}
		for (int i = 0; i < rechUnitPrj.count(); i++) {
			EOQualifier qual = ERXQ.is(EOCommentaires.C_STRUCTURE_KEY,
					rechUnitPrj.objectAtIndex(i).primaryKey()).and(
					EOCommentaires.PROJET.eq(Integer.valueOf(projet
							.primaryKey())));
			comment = EOCommentaires.fetchEOCommentaires(sess.editingContext(),
					qual);
			if (comment != null) {
				tmpCom.addObject(comment);
			}
		}
		return tmpCom.immutableClone();
	}

	// Affichage des commentaires des directeur de pôle
	protected static NSArray<EOCommentaires> commDrt(EOPprec projet,
			Session sess, NSMutableArray poles) {
		NSMutableArray<EOCommentaires> tmpCom = new NSMutableArray<EOCommentaires>();
		NSMutableArray rechUnitPrj1 = new NSMutableArray();
		EOCommentaires comment = null;
		NSMutableArray<EOStructureUlr> tmp = new NSMutableArray<EOStructureUlr>();
		if (poles != null)
			for (int i = 0; i < poles.count(); i++) {
				rechUnitPrj1.addObject(poles.objectAtIndex(i));
			}
		for (int k = 0; k < rechUnitPrj1.count(); k++) {
			EOQualifier qual = EOCommentaires.C_STRUCTURE.eq(
					rechUnitPrj1.objectAtIndex(k).toString()).and(
					EOCommentaires.PROJET.eq(Integer.valueOf(projet
							.primaryKey())));
			comment = EOCommentaires.fetchEOCommentaires(sess.editingContext(),
					qual);
			if (comment != null) {
				tmpCom.addObject(comment);
			}
		}
		setPoles(new NSMutableArray());
		return tmpCom.immutableClone();
	}

	// Recupération des poles
	protected static void pols(EOStructureUlr str) {
		if (!getPoles().containsObject(str.primaryKey()))
			getPoles().addObject(str.primaryKey());
		// NSLog.out.appendln(poles.arrayList());
	}

	// Fin visa

	// Nettoyer les codes tinymce
	protected static String cleanTinyMce(String source) {
		source = source.replace("<br data-mce-bogus=\"1\">", "");
		// Correspondance des fonts JVM
		source = source.replace("comic sans ms", "Comic Sans MS");
		source = source.replace("sans-serif", "Sans Serif");
		source = source.replace("andale mono", "Andale Mono");
		source = source.replace("arial black", "Arial Black");
		source = source.replace("arial", "Arial");
		source = source.replace("helvetica", "Helvetica");
		source = source.replace("book antiqua", "Book Antiqua");
		source = source.replace("palatino", "Palatino");
		source = source.replace("courier new", "Courier New");
		source = source.replace("courier", "Courier");
		source = source.replace("georgia", "Georgia");
		source = source.replace("impact", "Impact");
		source = source.replace("avant garde", "Avant Garde T.");
		source = source.replace("chicago", "Chicago");
		source = source.replace("symbol", "Symbol");
		source = source.replace("times new roman", "Times New Roman");
		source = source.replace("times", "Times");
		source = source.replace("verdana", "Verdana");
		source = source.replace("geneva", "Geneva");
		source = source.replace("wingdings", "Wingdings");
		source = source.replace("webdings", "Webdings");
		source = source.replace("zapf dingbats", "Zapf Dingbats");
		source = source.replace("tahoma", "Tahoma");
		source = source.replace("terminal", "Terminal");
		// Fin fonts
		// source = source.replace("<b>", "");
		// source = source.replace("</b>", "");
		return source;
	}

	protected static EOStructure umrStmr(Session sess) {
		String cStructure = sess.app().cStrctureUmrStmr();
		return EOStructure.structurePourCode(sess.editingContext(), cStructure);
	}

}
