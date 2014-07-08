/**
 * 
 */
package utt.rec.projet.server.print;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.metier.ProjectListTampon;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.utils.DateCtrlPprec;

import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestamp;
import fr.univlr.cri.webapp.LRDataResponse;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class PrintCSV {

	/**
	 * Constuire le fichier CSV associŽ ˆ liste de projets
	 * 
	 */
	public static WOResponse printCsvProjet(String nomFichier,
			NSMutableDictionary bindings, Session sess) {
		LRDataResponse resp = new LRDataResponse();
		StringBuffer sb = new StringBuffer();
		EOEditingContext ec = new EOEditingContext();
		NSMutableArray nodes = new NSMutableArray();
		NSMutableArray tmpListe = new NSMutableArray();
		sess.setListProjet(EOPprec.fetchFiltreProjet(ec, bindings));
		tmpListe = tamponListProject(sess);
		for (int i = tmpListe.count()-1; i > -1; i--) {
			ProjectListTampon tmpList = (ProjectListTampon) tmpListe
					.objectAtIndex(i);
			String contrat = " ";
			if (tmpList.getContrat() != null)
				contrat = tmpList.getContrat().typcontNomAbr();
			String date = tmpList.getProjet().creadate().dayOfMonth() + "/" + tmpList.getProjet().creadate().monthOfYear() + "/" + tmpList.getProjet().creadate().yearOfCommonEra();
			PrintCSVNode node = new PrintCSVNode(tmpList.getEtat().typreflib(),
					tmpList.getProjet().projnomcourt(), tmpList.getPorteur()
							.fullname(), contrat, tmpList.getEquipe()
							.lcStructure(), date);
			nodes.addObject(node);
		}
		// liberation de memoire
		ec.dispose();
		
		// construction du fichier

		// entete
		sb.append("ETAT").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("PROJET").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("PORTEUR").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("CONTRAT VISE").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("EQUIPE").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("DATE CREATION").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append(ConstsPrint.CSV_NEW_LINE);
		// projets
		for (int indexNode = 0; indexNode < nodes.count(); indexNode++) {
			PrintCSVNode node = (PrintCSVNode) nodes.objectAtIndex(indexNode);

			sb.append(node.getEtat()).append(ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getProjet())
					.append(ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getPorteur()).append(
					ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getContrat()).append(
					ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getEquipe())
					.append(ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getDateCreate())
			.append(ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(ConstsPrint.CSV_NEW_LINE);
		}

		//Encodage fichier
		NSData stream = new NSData(sb.toString(), ConstsPrint.CSV_ENCODING);
		resp.setContent(stream);
		resp.setContentEncoding(ConstsPrint.CSV_ENCODING);
		resp.setHeader(String.valueOf(stream.length()), "Content-Length");
		resp.setFileName(DateCtrlPprec.dateToString(DateCtrlPprec.now(),
				"%Y%m%d") + "_" + nomFichier + ".csv");
		return resp;
	}
	
	public static WOResponse printCsvProjetEC(String nomFichier,
			NSMutableDictionary bindings, Session sess) {
		LRDataResponse resp = new LRDataResponse();
		StringBuffer sb = new StringBuffer();
		EOEditingContext ec = new EOEditingContext();
		NSMutableArray nodes = new NSMutableArray();
		NSMutableArray tmpListe = new NSMutableArray();
		sess.setListProjet(EOPprec.fetchFiltreProjetEC(ec, bindings));
		tmpListe = tamponListProject(sess);
		for (int i = tmpListe.count()-1; i > -1; i--) {
			ProjectListTampon tmpList = (ProjectListTampon) tmpListe
					.objectAtIndex(i);
			String contrat = " ";
			if (tmpList.getContrat() != null)
				contrat = tmpList.getContrat().typcontNomAbr();
			String date = tmpList.getProjet().creadate().dayOfMonth() + "/" + tmpList.getProjet().creadate().monthOfYear() + "/" + tmpList.getProjet().creadate().yearOfCommonEra();
			PrintCSVNode node = new PrintCSVNode(tmpList.getEtat().typreflib(),
					tmpList.getProjet().projnomcourt(), tmpList.getPorteur()
							.fullname(), contrat, tmpList.getEquipe()
							.lcStructure(), date);
			nodes.addObject(node);
		}
		// liberation de memoire
		ec.dispose();
		
		// construction du fichier

		// entete
		sb.append("ETAT").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("PROJET").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("PORTEUR").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("CONTRAT VISE").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("EQUIPE").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append("DATE CREATION").append(ConstsPrint.CSV_COLUMN_SEPARATOR);
		sb.append(ConstsPrint.CSV_NEW_LINE);
		// projets
		for (int indexNode = 0; indexNode < nodes.count(); indexNode++) {
			PrintCSVNode node = (PrintCSVNode) nodes.objectAtIndex(indexNode);

			sb.append(node.getEtat()).append(ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getProjet())
					.append(ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getPorteur()).append(
					ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getContrat()).append(
					ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getEquipe())
					.append(ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(node.getDateCreate())
			.append(ConstsPrint.CSV_COLUMN_SEPARATOR);
			sb.append(ConstsPrint.CSV_NEW_LINE);
		}

		//Encodage fichier
		NSData stream = new NSData(sb.toString(), ConstsPrint.CSV_ENCODING);
		resp.setContent(stream);
		resp.setContentEncoding(ConstsPrint.CSV_ENCODING);
		resp.setHeader(String.valueOf(stream.length()), "Content-Length");
		resp.setFileName(DateCtrlPprec.dateToString(DateCtrlPprec.now(),
				"%Y%m%d") + "_" + nomFichier + ".csv");
		return resp;
	}

	public static NSMutableArray tamponListProject(Session sess) {
		NSMutableArray tmpListe = new NSMutableArray();
		if (sess.getListProjet().count() > 0) {
			for (int i = 0; sess.getListProjet().count() > i; i++) {
				ProjectListTampon tmpList = new ProjectListTampon();
				EOPprec projet = sess.getListProjet().objectAtIndex(i);
				tmpList.setEtat(projet.toEtat());
				tmpList.setProjet(projet);
				tmpList.setPorteur(EOIndividuUlr.individuPourNumero(projet.editingContext(), projet.porteur()));
				tmpList.setContrat(projet.toContrat());
				tmpList.setEquipe(EOStructureUlr.structurePourcStructure(projet.editingContext(), projet.equipePrincipale()));
				tmpListe.addObject(tmpList);
			}
		}
		return tmpListe;
	}
}
