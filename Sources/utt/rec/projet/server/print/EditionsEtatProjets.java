/**
 * 
 */
package utt.rec.projet.server.print;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktlwebapp.common.util.CktlXMLWriter;
import org.cocktail.reporting.CktlAbstractReporter;
import org.cocktail.reporting.jrxml.IJrxmlReportListener;
import org.cocktail.reporting.jrxml.JrxmlReporterWithXmlDataSource;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.metier.ProjectListTampon;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.utils.Editions;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestampFormatter;

import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.ERXResourceManager;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */
@SuppressWarnings("all")
public class EditionsEtatProjets {
	static final public Logger LOG = Logger
			.getLogger(EditionsEtatProjets.class);

	/**
	 * Point d'acces pour la creation de l'edition des projets
	 * 
	 */
	static public CktlAbstractReporter etatProjets(
			NSMutableDictionary bindings, Session sess,
			IJrxmlReportListener listener) {
		String masterJasperFileName = "EtatsProjetsEditions.jasper";
		// point d'entree dans l'arborescence decrite dans le fichier de donnees
		// XML
		String recordPath = "/Etat/Projet";
		JrxmlReporterWithXmlDataSource jr = null;
		try {
			// generation et ecriture du fichier XML produit :
			StringWriter xmlString = createXmlEditionEtatsProjets(bindings,
					sess);
			// Affichage du xml en mode debug uniquement
			//LOG.info(xmlString);
			// flux fichier associe au fichier XML :
			InputStream xmlFileStream = new ByteArrayInputStream(xmlString
					.toString().getBytes());
			// parametres $P{...} passes au report principal : par ex titres,
			// chemins vers les sous reports, etc.
			Map<String, Object> parameters = new HashMap<String, Object>();
			jr = new JrxmlReporterWithXmlDataSource();
			jr.printWithThread("Editions des projets", xmlFileStream,
					recordPath, pathForReportGeneralites(masterJasperFileName),
					parameters, CktlAbstractReporter.EXPORT_FORMAT_XLS, true,
					listener);
		} catch (Throwable e) {
			sess.addSimpleErrorMessage("Exception",
					"Une erreur s'est produite durant l'edition des projets");
			LOG.error("Une erreur s'est produite durant l'edition des projets",
					e);
		}
		// retourne le resultat au client :
		return jr;
	}

	static public CktlAbstractReporter etatProjetsEC(
			NSMutableDictionary bindings, Session sess,
			IJrxmlReportListener listener) {
		String masterJasperFileName = "EtatsProjetsEditions.jasper";
		// point d'entree dans l'arborescence decrite dans le fichier de donnees
		// XML
		String recordPath = "/Etat/Projet";
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
			jr = new JrxmlReporterWithXmlDataSource();
			jr.printWithThread("Editions des projets", xmlFileStream,
					recordPath, pathForReportGeneralites(masterJasperFileName),
					parameters, CktlAbstractReporter.EXPORT_FORMAT_XLS, true,
					listener);
		} catch (Throwable e) {
			sess.addSimpleErrorMessage("Exception",
					"Une erreur s'est produite durant l'edition des projets");
			LOG.error("Une erreur s'est produite durant l'edition des projets",
					e);
		}
		// retourne le resultat au client :
		return jr;
	}

	/**
	 * Interroge la base pour generer le fichier de donnees XML qui sera utilise
	 * pour "nourrir" l'edition. (Utilisation de la bibliotheque du CRI de La
	 * Rochelle)
	 */
	static protected StringWriter createXmlEditionEtatsProjets(
			NSMutableDictionary bindings, Session sess) throws Exception {
		NSTimestampFormatter formatter = new NSTimestampFormatter("%d/%m/%Y");
		NSMutableArray<ProjectListTampon> tmpListe = new NSMutableArray<ProjectListTampon>();
		EOEditingContext edc = sess.editingContext();
		sess.setListProjet(EOPprec.fetchFiltreProjet(edc, bindings));
		tmpListe = tamponListProject(sess);
		String nomCourt = "";

		StringWriter sw = new StringWriter();
		CktlXMLWriter w = new CktlXMLWriter(sw);
		w.startDocument();
		w.startElement("Etat");

		for (ProjectListTampon tmpList : tmpListe) {
			EOPprec projet = tmpList.getProjet();
			NSLog.out.appendln("Projet "+projet.projnomcourt());
			String contrat = " ";
			if (tmpList.getContrat() != null)
				contrat = tmpList.getContrat().typcontNomAbr();
			String date = formatter.format(projet.creadate());

			w.startElement("Projet");

			w.writeElement("Etat",
					Editions.cleanedString(tmpList.getEtat().typreflib()));
			if (tmpList.getProjet().projnomcourt().contains("&")) {
				nomCourt = Editions.cleanAmp(tmpList.getProjet().projnomcourt());
				w.writeElement("Projet", Editions.cleanedString(nomCourt));
			} else {
				w.writeElement("Projet", Editions.cleanedString(tmpList
						.getProjet().projnomcourt()));
			}
			w.writeElement("Porteur",
					Editions.cleanedString(tmpList.getPorteur().fullname()));
			w.writeElement("Contrat", Editions.cleanedString(contrat));
			w.writeElement("Equipe",
					Editions.cleanedString(tmpList.getEquipe().lcStructure()));
			w.writeElement("DateCreate", Editions.cleanedString(date));

			w.endElement();

		}

		w.endElement();
		w.endDocument();
		w.close();
		return sw;
	}

	static protected StringWriter createXmlEditionEtatsProjetsEC(
			NSMutableDictionary bindings, Session sess) throws Exception {
		NSTimestampFormatter formatter = new NSTimestampFormatter("%d/%m/%Y");
		NSMutableArray<ProjectListTampon> tmpListe = new NSMutableArray<ProjectListTampon>();
		EOEditingContext edc = sess.editingContext();
		// sess.setListProjet(EOPprec.filtreEditionProjetEC(edc, bindings));
		tmpListe = (NSMutableArray<ProjectListTampon>) sess
				.getFiltreProjetFacade().displayedObjects();
		String nomCourt = "";

		StringWriter sw = new StringWriter();
		CktlXMLWriter w = new CktlXMLWriter(sw);
		w.startDocument();
		w.startElement("Etat");

		for (ProjectListTampon tmpList : tmpListe) {
			EOPprec projet = tmpList.getProjet();
			NSLog.out.appendln("Projet "+projet.projnomcourt());
			String contrat = " ";
			if (tmpList.getContrat() != null)
				contrat = tmpList.getContrat().typcontNomAbr();
			String date = formatter.format(projet.creadate());

			w.startElement("Projet");

			w.writeElement("Etat",
					Editions.cleanedString(tmpList.getEtat().typreflib()));
			if (tmpList.getProjet().projnomcourt().contains("&")) {
				nomCourt = Editions.cleanAmp(tmpList.getProjet().projnomcourt());
				w.writeElement("Projet", Editions.cleanedString(nomCourt));
			} else {
				w.writeElement("Projet", Editions.cleanedString(tmpList
						.getProjet().projnomcourt()));
			}
			w.writeElement("Porteur",
					Editions.cleanedString(tmpList.getPorteur().fullname()));
			w.writeElement("Contrat", Editions.cleanedString(contrat));
			w.writeElement("Equipe",
					Editions.cleanedString(tmpList.getEquipe().lcStructure()));
			w.writeElement("DateCreate", Editions.cleanedString(date));

			w.endElement();

		}

		w.endElement();
		w.endDocument();
		w.close();
		return sw;
	}

	private static String pathForReportGeneralites(String reportName) {
		ERXResourceManager rsm = (ERXResourceManager) ERXApplication
				.application().resourceManager();
		URL url = rsm.pathURLForResourceNamed("Reports/EtatsProjets/"
				+ reportName, "app", null);
		return url.getFile();
	}

	private static NSMutableArray tamponListProject(Session sess) {
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

}
