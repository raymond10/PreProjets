/**
 * 
 */
package utt.rec.projet.server.utils.manufactory;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr> 6 juin 2013
 */
@SuppressWarnings("all")
public class Manufactory {

	protected EOEditingContext ec;
	protected boolean withLogs = false;
	
	/**
	 * Constructeur.
	 * @param ec Editing context a utiliser.
	 * @param withlog Activer ou pas les logs.
	 */
	public Manufactory(final EOEditingContext ec, final boolean withlog) {
		this.ec = ec;
		this.withLogs = withlog;
	}

	/**
	 * Constructeur par defaut.
	 * Les logs ne sont pas actives.
	 * @param ec Editing context a utiliser.
	 */
	public Manufactory(final EOEditingContext ec) {
		// TODO Auto-generated constructor stub
		this(ec,false);
	}

	public void setEditingContext(EOEditingContext ec) {
		this.ec = ec;
	}

	public static EOEnterpriseObject instanceForEntity(EOEditingContext ec,
			String entity) throws Exception {
		EOClassDescription description = (EOClassDescription) EOClassDescription
				.classDescriptionForEntityName(entity);

		EOEnterpriseObject object = description
				.createInstanceWithEditingContext(ec, null);

		return object;
	}

	public static NSArray fetchArray(EOEditingContext ec, String entityName,
			String conditionStr, NSArray params, NSArray sortOrderings,
			boolean refreshObjects) {
		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat(
				conditionStr, params);
		EOFetchSpecification spec = new EOFetchSpecification(entityName, qual,
				sortOrderings, true, true, null);
		spec.setRefreshesRefetchedObjects(refreshObjects);
		return ec.objectsWithFetchSpecification(spec);
	}

	public static EOEnterpriseObject fetchObject(EOEditingContext ec,
			String entityName, String conditionStr, NSArray params,
			NSArray sortOrderings, boolean refreshObjects) {
		NSArray res = fetchArray(ec, entityName, conditionStr, params,
				sortOrderings, refreshObjects);
		if ((res == null) || (res.count() == 0)) {
			return null;
		}
		return (EOEnterpriseObject) res.objectAtIndex(0);
	}

	public void trace(final String prefix, final NSArray a) {
		System.out.println("Factory.trace() TRACE");
		for (int i = 0; i < a.count(); i++) {
			trace(prefix + "  " + i + "-->", a.objectAtIndex(i));
		}
	}

	// public void trace(String m) {
	// if (withLogs())
	// System.out.println(m);
	// }
	//
	// pblic void trace(final String prefix, String m) {
	// if (withLogs())
	// System.out.println(m);
	// }
	//
	public void trace(final Object obj) {
		// trace("", obj);
	}

	public void trace(final String prefix, final Object obj) {
		if (withLogs()) {
			if (obj == null) {
				System.out.println(prefix + "null");
			} else {
				if (obj instanceof NSArray) {
					trace(prefix, (NSArray) obj);
				} else if (obj instanceof EOEnterpriseObject) {
					trace(prefix, (EOEnterpriseObject) obj);
				} else {
					System.out.println(prefix + obj.toString());
				}
			}

		}
	}

	public void trace(final String prefix, final EOEnterpriseObject object) {
		System.out.println("Factory.trace() 3");
		if (object != null) {
			final Iterator iter = object.attributeKeys().vector().iterator();
			while (iter.hasNext()) {
				String obj = (String) iter.next();
				trace(prefix + "  " + obj + "-->", object.valueForKey(obj));
			}

			Iterator iter2 = object.toOneRelationshipKeys().vector().iterator();
			while (iter2.hasNext()) {
				String obj = (String) iter2.next();
				trace(prefix + "  " + obj + "-->" + object.valueForKey(obj));
			}
			Iterator iter3 = object.toManyRelationshipKeys().vector()
					.iterator();
			while (iter3.hasNext()) {
				String obj = (String) iter3.next();
				if (prefix != null && prefix.length() > 250) {
					trace(prefix + "  " + obj + "-->" + object.valueForKey(obj));
				} else {
					trace(prefix + "  " + obj + "-->", object.valueForKey(obj));
				}

			}
		}
	}

	/**
	 * @param withLogs
	 *            The withLogs to set.
	 * @uml.property name="withLogs"
	 */
	public void setWithLogs(boolean b) {
		this.withLogs = b;
	}

	public boolean withLogs() {
		return withLogs;
	}

	/*
	 * public float computeSumForKey( NSArray eo, String key) {
	 * 
	 * float total = 0; int i = 0; while (i < eo.count()) { total = total +
	 * ((Number) ((EOEnterpriseObject) eo.objectAtIndex(i))
	 * .valueForKey(key)).floatValue(); i = i + 1; } return (float) total; }
	 */

	public BigDecimal computeSumForKeyBigDecimal(NSArray eo,
			String keyBigDecimal) {

		BigDecimal total = new BigDecimal((double) 0);
		int i = 0;
		while (i < eo.count()) {
			total = total.add((BigDecimal) ((EOEnterpriseObject) eo
					.objectAtIndex(i)).valueForKey(keyBigDecimal));
			i = i + 1;
		}
		return total;

	}

	public static boolean inferieur(BigDecimal a, BigDecimal b) {
		boolean reponse = false;

		int resultat = a.compareTo(b);

		if (resultat == -1)
			reponse = true;

		if (resultat == 0)
			reponse = false;

		if (resultat == 1)
			reponse = false;

		return reponse;
	}

	public static boolean inferieurOuEgal(BigDecimal a, BigDecimal b) {
		boolean reponse = false;

		int resultat = a.compareTo(b);

		if (resultat == -1)
			reponse = true;

		if (resultat == 0)
			reponse = true;

		if (resultat == 1)
			reponse = false;

		return reponse;
	}

	public static boolean superieur(BigDecimal a, BigDecimal b) {
		boolean reponse = false;

		int resultat = a.compareTo(b);

		if (resultat == -1)
			reponse = false;

		if (resultat == 0)
			reponse = false;

		if (resultat == 1)
			reponse = true;

		return reponse;
	}

	public static boolean superieurOuEgal(BigDecimal a, BigDecimal b) {
		boolean reponse = false;

		int resultat = a.compareTo(b);

		if (resultat == -1)
			reponse = false;

		if (resultat == 0)
			reponse = true;

		if (resultat == 1)
			reponse = true;

		return reponse;
	}

	public static boolean egal(BigDecimal a, BigDecimal b) {
		boolean reponse = false;

		int resultat = a.compareTo(b);

		if (resultat == -1)
			reponse = false;

		if (resultat == 0)
			reponse = true;

		if (resultat == 1)
			reponse = false;

		return reponse;
	}

	public static boolean different(BigDecimal a, BigDecimal b) {
		boolean reponse = false;

		int resultat = a.compareTo(b);

		if (resultat == -1)
			reponse = true;

		if (resultat == 0)
			reponse = false;

		if (resultat == 1)
			reponse = true;

		return reponse;
	}

	/**
	 * @return Un gregorianCalendar initialis� � la date du jour (sans les
	 *         heures/minutes/etc). Utilisez getToday().getTime() pour recup�rer
	 *         la date du jour nettoy�e des secondes sous forme de Date.
	 */
	private final GregorianCalendar getToday() {
		final GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		return gc;
	}

	/**
	 * @return
	 */
	public final NSTimestamp getDateJour() {
		return new NSTimestamp(getToday().getTime());
	}

	/**
	 * Calcule la somme de toutes les valeurs contenues dans un champ des
	 * EOEnterpriseObjects contenues dans le tableau.
	 * 
	 * @param array
	 *            Tableau d'EOEnterpriseObjects
	 * @param keyName
	 *            Nom de l'attribut qui contient les valeurs � sommer (le champ
	 *            doit �tre un BigDecimal)
	 * @return
	 */
	public static final BigDecimal calcSommeOfBigDecimals(final NSArray array,
			final String keyName) {
		return calcSommeOfBigDecimals(array.vector(), keyName);
	}

	public static final BigDecimal calcSommeOfBigDecimals(final Vector array,
			final String keyName) {
		BigDecimal res = new BigDecimal((double) 0).setScale(2);
		Iterator iter = array.iterator();
		while (iter.hasNext()) {
			EOEnterpriseObject element = (EOEnterpriseObject) iter.next();
			res = res.add((BigDecimal) element.valueForKey(keyName));
		}
		return res;
	}

	/**
	 * M�thode qui <b>tente</b> de contourner le bug EOF qui se produit lors
	 * d'un saveChanges avec l'erreur "reentered responseToMessage()".<br>
	 * <b>Il faut appeler cette m�thode avant de cr�er un descendant
	 * d'EOCustomObject, donc bien avant le saveChanges()</b><br>
	 * 
	 * Le principe est d'appeler la m�thode
	 * EOClassDescription.classDescriptionForEntityName("A") pour chaque
	 * relation de l'objet qu'on va cr�er. Il faut appeler cette m�thode avant
	 * de cr�er un objet. Par exemple dans le cas d'un objet Facture qui a des
	 * objets Ligne, appeler
	 * EOClassDescription.classDescriptionForEntityName("Facture") avant de
	 * cr�er un objet Ligne. R�p�ter l'op�ration pour toutes les relations de
	 * l'objet.
	 * 
	 * @param list
	 *            Liste de String identifiant une entit� du mod�le.
	 * @see http
	 *      ://www.omnigroup.com/mailman/archive/webobjects-dev/2002-May/023698.
	 *      html
	 */
	public static final void fixWoBug_responseToMessage(final String[] list) {
		for (int i = 0; i < list.length; i++) {
			EOClassDescription.classDescriptionForEntityName(list[i]);
		}
	}

}
