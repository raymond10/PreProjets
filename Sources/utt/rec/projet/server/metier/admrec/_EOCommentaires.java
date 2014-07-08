// DO NOT EDIT.  Make changes to EOCommentaires.java instead.
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
public abstract class _EOCommentaires extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOCommentaires";

  // Attribute Keys
  public static final ERXKey<String> COMMENTAIRES = new ERXKey<String>("commentaires");
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<String> MAJ_AUTEUR = new ERXKey<String>("majAuteur");
  public static final ERXKey<NSTimestamp> MAJ_DATE = new ERXKey<NSTimestamp>("majDate");
  public static final ERXKey<Integer> PROJET = new ERXKey<Integer>("projet");
  public static final ERXKey<String> TYPREFDOM = new ERXKey<String>("typrefdom");
  public static final ERXKey<String> TYPREFNAT = new ERXKey<String>("typrefnat");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOAlerte> TO_ALERTES = new ERXKey<utt.rec.projet.server.metier.admrec.EOAlerte>("toAlertes");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTypref> TO_AVIS = new ERXKey<utt.rec.projet.server.metier.admrec.EOTypref>("toAvis");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");

  // Attributes
  public static final String COMMENTAIRES_KEY = COMMENTAIRES.key();
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String MAJ_AUTEUR_KEY = MAJ_AUTEUR.key();
  public static final String MAJ_DATE_KEY = MAJ_DATE.key();
  public static final String PROJET_KEY = PROJET.key();
  public static final String TYPREFDOM_KEY = TYPREFDOM.key();
  public static final String TYPREFNAT_KEY = TYPREFNAT.key();
  // Relationships
  public static final String TO_ALERTES_KEY = TO_ALERTES.key();
  public static final String TO_AVIS_KEY = TO_AVIS.key();
  public static final String TO_PROJET_KEY = TO_PROJET.key();

  private static Logger LOG = Logger.getLogger(_EOCommentaires.class);

  public EOCommentaires localInstanceIn(EOEditingContext editingContext) {
    EOCommentaires localInstance = (EOCommentaires)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String commentaires() {
    return (String) storedValueForKey(_EOCommentaires.COMMENTAIRES_KEY);
  }

  public void setCommentaires(String value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
    	_EOCommentaires.LOG.debug( "updating commentaires from " + commentaires() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCommentaires.COMMENTAIRES_KEY);
  }

  public NSTimestamp createDate() {
    return (NSTimestamp) storedValueForKey(_EOCommentaires.CREATE_DATE_KEY);
  }

  public void setCreateDate(NSTimestamp value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
    	_EOCommentaires.LOG.debug( "updating createDate from " + createDate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCommentaires.CREATE_DATE_KEY);
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOCommentaires.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
    	_EOCommentaires.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCommentaires.C_STRUCTURE_KEY);
  }

  public String majAuteur() {
    return (String) storedValueForKey(_EOCommentaires.MAJ_AUTEUR_KEY);
  }

  public void setMajAuteur(String value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
    	_EOCommentaires.LOG.debug( "updating majAuteur from " + majAuteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCommentaires.MAJ_AUTEUR_KEY);
  }

  public NSTimestamp majDate() {
    return (NSTimestamp) storedValueForKey(_EOCommentaires.MAJ_DATE_KEY);
  }

  public void setMajDate(NSTimestamp value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
    	_EOCommentaires.LOG.debug( "updating majDate from " + majDate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCommentaires.MAJ_DATE_KEY);
  }

  public Integer projet() {
    return (Integer) storedValueForKey(_EOCommentaires.PROJET_KEY);
  }

  public void setProjet(Integer value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
    	_EOCommentaires.LOG.debug( "updating projet from " + projet() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCommentaires.PROJET_KEY);
  }

  public String typrefdom() {
    return (String) storedValueForKey(_EOCommentaires.TYPREFDOM_KEY);
  }

  public void setTyprefdom(String value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
    	_EOCommentaires.LOG.debug( "updating typrefdom from " + typrefdom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCommentaires.TYPREFDOM_KEY);
  }

  public String typrefnat() {
    return (String) storedValueForKey(_EOCommentaires.TYPREFNAT_KEY);
  }

  public void setTyprefnat(String value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
    	_EOCommentaires.LOG.debug( "updating typrefnat from " + typrefnat() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCommentaires.TYPREFNAT_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOTypref toAvis() {
    return (utt.rec.projet.server.metier.admrec.EOTypref)storedValueForKey(_EOCommentaires.TO_AVIS_KEY);
  }
  
  public void setToAvis(utt.rec.projet.server.metier.admrec.EOTypref value) {
    takeStoredValueForKey(value, _EOCommentaires.TO_AVIS_KEY);
  }

  public void setToAvisRelationship(utt.rec.projet.server.metier.admrec.EOTypref value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
      _EOCommentaires.LOG.debug("updating toAvis from " + toAvis() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToAvis(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOTypref oldValue = toAvis();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOCommentaires.TO_AVIS_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOCommentaires.TO_AVIS_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOCommentaires.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOCommentaires.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
      _EOCommentaires.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOCommentaires.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOCommentaires.TO_PROJET_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> toAlertes() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAlerte>)storedValueForKey(_EOCommentaires.TO_ALERTES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> toAlertes(EOQualifier qualifier) {
    return toAlertes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> toAlertes(EOQualifier qualifier, boolean fetch) {
    return toAlertes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> toAlertes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOAlerte.TO_COMMENTAIRE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOAlerte.fetchEOAlertes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toAlertes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOAlerte>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOAlerte>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToAlertes(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    includeObjectIntoPropertyWithKey(object, _EOCommentaires.TO_ALERTES_KEY);
  }

  public void removeFromToAlertes(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    excludeObjectFromPropertyWithKey(object, _EOCommentaires.TO_ALERTES_KEY);
  }

  public void addToToAlertesRelationship(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
      _EOCommentaires.LOG.debug("adding " + object + " to toAlertes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToAlertes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOCommentaires.TO_ALERTES_KEY);
    }
  }

  public void removeFromToAlertesRelationship(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    if (_EOCommentaires.LOG.isDebugEnabled()) {
      _EOCommentaires.LOG.debug("removing " + object + " from toAlertes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToAlertes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOCommentaires.TO_ALERTES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOAlerte createToAlertesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOAlerte.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOCommentaires.TO_ALERTES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOAlerte) eo;
  }

  public void deleteToAlertesRelationship(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOCommentaires.TO_ALERTES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToAlertesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOAlerte> objects = toAlertes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToAlertesRelationship(objects.nextElement());
    }
  }


  public static EOCommentaires createEOCommentaires(EOEditingContext editingContext) {
    EOCommentaires eo = (EOCommentaires) EOUtilities.createAndInsertInstance(editingContext, _EOCommentaires.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<EOCommentaires> fetchSpec() {
    return new ERXFetchSpecification<EOCommentaires>(_EOCommentaires.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOCommentaires> fetchAllEOCommentaireses(EOEditingContext editingContext) {
    return _EOCommentaires.fetchAllEOCommentaireses(editingContext, null);
  }

  public static NSArray<EOCommentaires> fetchAllEOCommentaireses(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOCommentaires.fetchEOCommentaireses(editingContext, null, sortOrderings);
  }

  public static NSArray<EOCommentaires> fetchEOCommentaireses(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOCommentaires> fetchSpec = new ERXFetchSpecification<EOCommentaires>(_EOCommentaires.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOCommentaires> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOCommentaires fetchEOCommentaires(EOEditingContext editingContext, String keyName, Object value) {
    return _EOCommentaires.fetchEOCommentaires(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOCommentaires fetchEOCommentaires(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOCommentaires> eoObjects = _EOCommentaires.fetchEOCommentaireses(editingContext, qualifier, null);
    EOCommentaires eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOCommentaires that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOCommentaires fetchRequiredEOCommentaires(EOEditingContext editingContext, String keyName, Object value) {
    return _EOCommentaires.fetchRequiredEOCommentaires(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOCommentaires fetchRequiredEOCommentaires(EOEditingContext editingContext, EOQualifier qualifier) {
    EOCommentaires eoObject = _EOCommentaires.fetchEOCommentaires(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOCommentaires that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOCommentaires localInstanceIn(EOEditingContext editingContext, EOCommentaires eo) {
    EOCommentaires localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
