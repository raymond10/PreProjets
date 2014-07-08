// DO NOT EDIT.  Make changes to EOHistorique.java instead.
package utt.rec.projet.server.metier.admrec;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _EOHistorique extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOHistorique";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> HTQDATE = new ERXKey<NSTimestamp>("htqdate");
  public static final ERXKey<String> MAJAUTEUR = new ERXKey<String>("majauteur");
  public static final ERXKey<String> TYPREFDOM = new ERXKey<String>("typrefdom");
  public static final ERXKey<String> TYPREFNAT = new ERXKey<String>("typrefnat");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTypref> TO_ETATS = new ERXKey<utt.rec.projet.server.metier.admrec.EOTypref>("toEtats");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");

  // Attributes
  public static final String HTQDATE_KEY = HTQDATE.key();
  public static final String MAJAUTEUR_KEY = MAJAUTEUR.key();
  public static final String TYPREFDOM_KEY = TYPREFDOM.key();
  public static final String TYPREFNAT_KEY = TYPREFNAT.key();
  // Relationships
  public static final String TO_ETATS_KEY = TO_ETATS.key();
  public static final String TO_PROJET_KEY = TO_PROJET.key();

  private static Logger LOG = Logger.getLogger(_EOHistorique.class);

  public EOHistorique localInstanceIn(EOEditingContext editingContext) {
    EOHistorique localInstance = (EOHistorique)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp htqdate() {
    return (NSTimestamp) storedValueForKey(_EOHistorique.HTQDATE_KEY);
  }

  public void setHtqdate(NSTimestamp value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating htqdate from " + htqdate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOHistorique.HTQDATE_KEY);
  }

  public String majauteur() {
    return (String) storedValueForKey(_EOHistorique.MAJAUTEUR_KEY);
  }

  public void setMajauteur(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating majauteur from " + majauteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOHistorique.MAJAUTEUR_KEY);
  }

  public String typrefdom() {
    return (String) storedValueForKey(_EOHistorique.TYPREFDOM_KEY);
  }

  public void setTyprefdom(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating typrefdom from " + typrefdom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOHistorique.TYPREFDOM_KEY);
  }

  public String typrefnat() {
    return (String) storedValueForKey(_EOHistorique.TYPREFNAT_KEY);
  }

  public void setTyprefnat(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating typrefnat from " + typrefnat() + " to " + value);
    }
    takeStoredValueForKey(value, _EOHistorique.TYPREFNAT_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOTypref toEtats() {
    return (utt.rec.projet.server.metier.admrec.EOTypref)storedValueForKey(_EOHistorique.TO_ETATS_KEY);
  }
  
  public void setToEtats(utt.rec.projet.server.metier.admrec.EOTypref value) {
    takeStoredValueForKey(value, _EOHistorique.TO_ETATS_KEY);
  }

  public void setToEtatsRelationship(utt.rec.projet.server.metier.admrec.EOTypref value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
      _EOHistorique.LOG.debug("updating toEtats from " + toEtats() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToEtats(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOTypref oldValue = toEtats();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOHistorique.TO_ETATS_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOHistorique.TO_ETATS_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOHistorique.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOHistorique.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
      _EOHistorique.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOHistorique.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOHistorique.TO_PROJET_KEY);
    }
  }
  

  public static EOHistorique createEOHistorique(EOEditingContext editingContext, String typrefdom
, String typrefnat
, utt.rec.projet.server.metier.admrec.EOTypref toEtats) {
    EOHistorique eo = (EOHistorique) EOUtilities.createAndInsertInstance(editingContext, _EOHistorique.ENTITY_NAME);    
		eo.setTyprefdom(typrefdom);
		eo.setTyprefnat(typrefnat);
    eo.setToEtatsRelationship(toEtats);
    return eo;
  }

  public static ERXFetchSpecification<EOHistorique> fetchSpec() {
    return new ERXFetchSpecification<EOHistorique>(_EOHistorique.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOHistorique> fetchAllEOHistoriques(EOEditingContext editingContext) {
    return _EOHistorique.fetchAllEOHistoriques(editingContext, null);
  }

  public static NSArray<EOHistorique> fetchAllEOHistoriques(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOHistorique.fetchEOHistoriques(editingContext, null, sortOrderings);
  }

  public static NSArray<EOHistorique> fetchEOHistoriques(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOHistorique> fetchSpec = new ERXFetchSpecification<EOHistorique>(_EOHistorique.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOHistorique> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOHistorique fetchEOHistorique(EOEditingContext editingContext, String keyName, Object value) {
    return _EOHistorique.fetchEOHistorique(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOHistorique fetchEOHistorique(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOHistorique> eoObjects = _EOHistorique.fetchEOHistoriques(editingContext, qualifier, null);
    EOHistorique eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOHistorique that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOHistorique fetchRequiredEOHistorique(EOEditingContext editingContext, String keyName, Object value) {
    return _EOHistorique.fetchRequiredEOHistorique(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOHistorique fetchRequiredEOHistorique(EOEditingContext editingContext, EOQualifier qualifier) {
    EOHistorique eoObject = _EOHistorique.fetchEOHistorique(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOHistorique that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOHistorique localInstanceIn(EOEditingContext editingContext, EOHistorique eo) {
    EOHistorique localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
