/**
 * 
 */
package utt.rec.projet.server.utils;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktljefyadmin.common.metier.EOFonction;
import org.cocktail.fwkcktljefyadmin.common.metier.EOTypeApplication;
import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateur;
import org.cocktail.fwkcktljefyadmin.common.metier.EOUtilisateurFonction;

import utt.rec.projet.server.EnseignantApplicationUser;
import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 * 
 */

@SuppressWarnings("all")
public class FinderUtilisateurFonction extends Finder {
	/**
	 * Recherche d'un utilisateurFonction pour un utilisateur et un libelle de
	 * fonction <BR>
	 * 
	 * @param ed
	 *            editingContext dans lequel se fait le fetch
	 * @param utilisateur
	 *            utilisateur pour lequel trouver la fonction associee
	 * @param libelleFonction
	 *            String contenant le libelle de la fonction a rechercher
	 * @return un EOUtilisateurFonction
	 */
	private static final Session sess = new Session();
	private final static Logger LOG = Logger.getLogger(FinderUtilisateurFonction.class);

	public static final EOUtilisateurFonction getUtilisateurFonction(
			EOEditingContext ed, EOUtilisateur utilisateur,
			String libelleFonction) {
		NSMutableDictionary mesBindings = new NSMutableDictionary();
		if (utilisateur == null) {
			utilisateur = sess.utilisateur();
		} else {
			sess.setUtilisateur(utilisateur);
		}
		EOTypeApplication typeApplication = FinderTypeApplication
				.getTypeApplication(ed,
						EnseignantApplicationUser.TYAP_STR_ID_PROJET);
		if (typeApplication == null) {
			throw new FactoryException("Type application "
					+ EnseignantApplicationUser.TYAP_STR_ID_PROJET
					+ " non trouvé ! (utilisateur:" + utilisateur + ", ed:"
					+ ed + "fonction:" + libelleFonction + ", edc=" + ed + ")");
		}

		EOFonction fonction = FinderFonction.getFonction(ed, libelleFonction,
				typeApplication);
		if (fonction == null)
			return null;
		// Correction bug concernant les users non présents dans jefyAdmin (user
		// n'ayant pas de rôle définit pour une application) - 21/01/2013
		if (utilisateur == null) {
			return null;
		}
		mesBindings.setObjectForKey(utilisateur, "utilisateur");
		mesBindings.setObjectForKey(fonction, "fonction");
		EOUtilisateurFonction result = FinderUtilisateurFonction
				.getUtilisateurFontion(ed, mesBindings);
		return result;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return sess;
	}

	/**
	 * Recherche d'un utilisateurFonction par la fetchSpecification Recherche.<BR>
	 * Bindings pris en compte : utilisateur, fonction <BR>
	 * 
	 * @param ed
	 *            editingContext dans lequel se fait le fetch
	 * @param bindings
	 *            dictionnaire contenant les bindings
	 * @return un EOUtilisateurFonction
	 */
	public static final EOUtilisateurFonction getUtilisateurFontion(
			EOEditingContext ed, NSDictionary<String, Object> bindings) {
		NSArray larray = FinderUtilisateurFonction.getUtilisateurFonctions(ed,
				bindings);

		if (larray.count() == 1)
			return (EOUtilisateurFonction) larray.objectAtIndex(0);
		return null;
	}

	/**
	 * Recherche des utilisateurFonction d'un utilisateur par la
	 * fetchSpecification Recherche.<BR>
	 * Bindings pris en compte : utilisateur, fonction <BR>
	 * 
	 * @param ed
	 *            editingContext dans lequel se fait le fetch
	 * @param bindings
	 *            dictionnaire contenant les bindings
	 * @return un NSArray de EOUtilisateurFonction
	 */
	public static final NSArray getUtilisateurFonctions(EOEditingContext ed,
			NSDictionary<String, Object> bindings) {
		NSArray result = null;
		try {
			result = EOUtilities.objectsWithFetchSpecificationAndBindings(ed,
					EOUtilisateurFonction.ENTITY_NAME, "Recherche", bindings);
		} catch (Exception e) {
			LOG.warn(
					"Impossible d'initialiser le user, la raison probable est que l'utilisateur "
							+ "n'est pas enregistré dans JEFY_ADMIN", e);
/*			sess.addSimpleErrorMessage(
			 "Attention les droits d'utilisation n'ont pu être initialisés, les fonctions des menus PPREC seront limitées.",
			e);*/
		}
		return result;
	}
}
