/**
 * 
 */
package utt.rec.projet.server.utils;


import org.cocktail.fwkcktljefyadmin.common.metier.EOFonction;
import org.cocktail.fwkcktljefyadmin.common.metier.EOTypeApplication;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FinderFonction extends Finder {
	/**
	 * Recherche d'une fonction suivant son identifiant et le type d'application. <BR>
	 * 
	 * @param ed editingContext dans lequel se fait le fetch
	 * @param libelle identifiant de la fonction
	 * @param typeApplication type de l'application qui utilise cette fonction
	 * @return une EOFonction
	 */
	public static final EOFonction getFonction(EOEditingContext ed, String libelle, EOTypeApplication typeApplication) {
		// EGE: commente le 21/03/2007. Inutile ? Dangereux ?
		// ed.invalidateObjectsWithGlobalIDs(new NSArray(ed.globalIDForObject(typeApplication)));
		return getUneFonction(ed, libelle, typeApplication);
	}

	/**
	 * Recherche d'une fonction suivant son identifiant et le type d'application. <BR>
	 * 
	 * @param ed editingContext dans lequel se fait le fetch
	 * @param libelle identifiant de la fonction
	 * @param typeApplication type de l'application qui utilise cette fonction
	 * @return une EOFonction
	 */
	private static EOFonction getUneFonction(EOEditingContext ed, String libelle, EOTypeApplication typeApplication) {
		NSArray lesFonctions = null;
		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat(EOFonction.FON_ID_INTERNE_KEY + "=%@ and " + EOFonction.TYPE_APPLICATION_KEY + "." + EOTypeApplication.TYAP_LIBELLE_KEY + "=%@",
				new NSArray(new Object[] {
						libelle, typeApplication.tyapLibelle()
				}));

		lesFonctions = Finder.fetchArray(EOFonction.ENTITY_NAME, qual, null, ed, true);
		/*
		 * NSArray arrayFonctions=fetchFonctions(ed, typeApplication);
		 * 
		 * lesFonctions=new NSArray((NSArray)(EOQualifier.filteredArrayWithQualifier(arrayFonctions,
		 * EOQualifier.qualifierWithQualifierFormat(EOFonction.FON_ID_INTERNE_KEY+"=%@ and "+EOFonction.TYPE_APPLICATION_KEY+"=%@", new NSArray(new
		 * Object[]{libelle, typeApplication})))));
		 */
		if (lesFonctions == null || lesFonctions.count() == 0)
			return null;

		return (EOFonction) lesFonctions.objectAtIndex(0);
	}

	/**
	 * Fetch toutes les fonctions pour les garder en memoire et eviter de refetcher ensuite <BR>
	 * 
	 * @param ed editingContext dans lequel se fait le fetch
	 */
	//    private static NSArray fetchFonctions(EOEditingContext ed) {
	//    	// if (arrayFonctions==null)
	//    	return Finder.fetchArray(ed,EOFonction.ENTITY_NAME,null,null,null,false);
	//    }

	//    private static NSArray fetchFonctions(EOEditingContext ed, EOTypeApplication typeApplication) {
	//    	// TODO EGE : Etudier pkoi qd on passe l'objet typeApplication parfois il fetche bien parfois non
	//    	// return Finder.fetchArray(ed,EOFonction.ENTITY_NAME,EOFonction.TYPE_APPLICATION_KEY+"=%@",new NSArray(typeApplication),null,true);
	//    	return Finder.fetchArray(ed,EOFonction.ENTITY_NAME,EOFonction.TYPE_APPLICATION_KEY+"."+EOTypeApplication.TYAP_LIBELLE_KEY+"='"+typeApplication.tyapLibelle()+"'",
	//    			null,null,true);
	//    }
}
