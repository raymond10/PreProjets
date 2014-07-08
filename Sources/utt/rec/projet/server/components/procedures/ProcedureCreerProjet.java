/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.metier.admrec.EOPprec;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation.ValidationException;

/**
 * @author Raymond NANEON
 *
 */
@SuppressWarnings("rawtypes")
public class ProcedureCreerProjet extends ProjectPRC {

	private static final String PROCEDURE_NAME = "insProjet";

	public ProcedureCreerProjet() {
		// TODO Auto-generated constructor stub
	}

	public static boolean enregistrer(_CktlBasicDataBus dataBus, EOPprec projet)
			throws ValidationException {
		// projet.validateForInsert();
		return dataBus.executeProcedure(ProcedureCreerProjet.PROCEDURE_NAME,
				ProcedureCreerProjet.construireDictionnaire(projet));
	}

	private static NSDictionary construireDictionnaire(EOPprec projet) {
		NSMutableDictionary dico = new NSMutableDictionary();
		// NSDictionary dicoForPrimaryKeys=null;

		// on met la cle de la table a null, elle sera generee dans la procedure
		dico.takeValueForKey(null, "010_a_proj_Id");

		// on cherche l'id du directeur de pole
		if (projet.DirecteurPole() != null) {
			dico.takeValueForKey(projet.DirecteurPole(), "020_a_no_doss");
		} else {
			dico.takeValueForKey(projet.DirecteurPole(), "020_a_no_doss");
		}
		// on cherche la cle du sous-theme
		if (projet.toSousThemes() != null) {
			dico.takeValueForKey(
					Integer.valueOf(projet.toSousThemes().primaryKey()),
					"030_a_refthe");
		} else {
			dico.takeValueForKey(projet.toSousThemes(), "030_a_refthe");
		}
		// on renseigne la cle du theme
		if (projet.toTheme() != null) {
			dico.takeValueForKey(Integer.valueOf(projet.toTheme().primaryKey()),
					"040_a_ref_refthe");
		} else {
			dico.takeValueForKey(projet.toTheme(), "040_a_ref_refthe");
		}
		// on renseigne la date de creation
		dico.takeValueForKey(projet.creadate(), "050_a_creadate");

		// on renseigne la date de MAJ
		dico.takeValueForKey(projet.majdate(), "060_a_majdate");

		// on renseigne l'auteur de la MAJ ou CREATION
		dico.takeValueForKey(projet.majauteur(), "070_a_majauteur");
		// on renseigne le nom court du projet
		dico.takeValueForKey(projet.projnomcourt(), "071_a_projnomcourt");

		// On renseigne le nom long
		dico.takeValueForKey(projet.projnomlong(), "072_a_projnomlong");

		// On renseigne la duree du projet
		dico.takeValueForKey(projet.projduree(), "073_a_projduree");

		// On renseigne la date de debut
		dico.takeValueForKey(projet.projdatdebut(), "074_a_projdatedebut");

		// On renseigne le résumé du projet (context)
		dico.takeValueForKey(projet.projctx(), "075_a_context ");

		// On renseigne le résumé du projet (problematique)
		dico.takeValueForKey(projet.projpblm(), "076_a_probleme");

		// On renseigne le résumé du projet (objectif)
		dico.takeValueForKey(projet.projobf(), "077_a_objectif");

		// On renseigne le résumé du projet (methodologie)
		dico.takeValueForKey(projet.projmtdg(), "078_a_metho");

		// On renseigne est ce que le projet a une thematique
		dico.takeValueForKey(projet.projthetv(), "079_a_havetemathik");

		// On renseigne la cle du contrat
		if (projet.toContrat() != null)
			dico.takeValueForKey(Integer.valueOf(projet.toContrat().primaryKey()), "080_a_contrat");

		// On renseigne la cle de l'etat0
		dico.takeValueForKey(projet.toEtat().typrefnat(), "081_a_etat0");

		// On renseigne la cle de l'etat1
		dico.takeValueForKey(projet.toEtat().typrefdom(), "082_a_etat1");

		// On renseigne la cle de l'axe
		if (projet.toAxe() != null)
			dico.takeValueForKey(Integer.valueOf(projet.toAxe().primaryKey()), "083_a_axe");

		// On renseigne la cle du programme d'accueil principale
		dico.takeValueForKey(projet.equipePrincipale(),
				"084_a_programpp");

		// On renseigne la cle du porteur
		dico.takeValueForKey(Integer.valueOf(projet.porteur()),
				"085_a_porteur");

		// On renseigne la cle de la tthematique
		if (projet.toThematique() != null) {
			dico.takeValueForKey(
					Integer.valueOf(projet.toThematique().primaryKey()),
					"086_a_temathik");
		} else {
			dico.takeValueForKey(null, "086_a_temathik");
		}
		// On renseigne si le projet est valide
		dico.takeValueForKey(projet.projvalide(), "087_a_pvalide");
		if (projet.srcefinance() != null)
			dico.takeValueForKey(projet.srcefinance(), "088_a_srcefinance");
		// Pole de compétence du porteur de projet
		if (projet.poleCompetence() != null) {
			dico.takeValueForKey(projet.poleCompetence(),
					"089_a_polecompetence");
		} else {
			dico.takeValueForKey(null, "089_a_polecompetence");
		}
		dico.takeValueForKey(projet.etabPorteur(), "090_a_etabPorteur");
		dico.takeValueForKey(projet.blocCom(), "091_a_bloc_com");
		return dico;
	}

}
