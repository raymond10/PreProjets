// DO NOT EDIT.  Make changes to EOTypthe.java instead.
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
public abstract class _EOTypthe extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOTypthe";

  // Attribute Keys
  public static final ERXKey<String> TYPTHELIB = new ERXKey<String>("typthelib");
  public static final ERXKey<String> TYPTHENAT = new ERXKey<String>("typthenat");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJETS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjets");

  // Attributes
  public static final String TYPTHELIB_KEY = TYPTHELIB.key();
  public static final String TYPTHENAT_KEY = TYPTHENAT.key();
  // Relationships
  public static final String TO_PROJETS_KEY = TO_PROJETS.key();

  private static Logger LOG = Logger.getLogger(_EOTypthe.class);

  public EOTypthe localInstanceIn(EOEditingContext editingContext) {
    EOTypthe localInstance = (EOTypthe)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String typthelib() {
    return (String) storedValueForKey(_EOTypthe.TYPTHELIB_KEY);
  }

  public void setTypthelib(String value) {
    if (_EOTypthe.LOG.isDebugEnabled()) {
    	_EOTypthe.LOG.debug( "updating typthelib from " + typthelib() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypthe.TYPTHELIB_KEY);
  }

  public String typthenat() {
    return (String) storedValueForKey(_EOTypthe.TYPTHENAT_KEY);
  }

  public void setTypthenat(String value) {
    if (_EOTypthe.LOG.isDebugEnabled()) {
    	_EOTypthe.LOG.debug( "updating typthenat from " + typthenat() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypthe.TYPTHENAT_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)storedValueForKey(_EOTypthe.TO_PROJETS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets(EOQualifier qualifier) {
    return toProjets(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets(EOQualifier qualifier, boolean fetch) {
    return toProjets(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPprec> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPprec.TO_THEMATIQUE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPprec.fetchEOPprecs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toProjets();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToProjets(utt.rec.projet.server.metier.admrec.EOPprec object) {
    includeObjectIntoPropertyWithKey(object, _EOTypthe.TO_PROJETS_KEY);
  }

  public void removeFromToProjets(utt.rec.projet.server.metier.admrec.EOPprec object) {
    excludeObjectFromPropertyWithKey(object, _EOTypthe.TO_PROJETS_KEY);
  }

  public void addToToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOTypthe.LOG.isDebugEnabled()) {
      _EOTypthe.LOG.debug("adding " + object + " to toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOTypthe.TO_PROJETS_KEY);
    }
  }

  public void removeFromToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOTypthe.LOG.isDebugEnabled()) {
      _EOTypthe.LOG.debug("removing " + object + " from toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypthe.TO_PROJETS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPprec createToProjetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPprec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOTypthe.TO_PROJETS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPprec) eo;
  }

  public void deleteToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypthe.TO_PROJETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjetsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPprec> objects = toProjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjetsRelationship(objects.nextElement());
    }
  }


  public static EOTypthe createEOTypthe(EOEditingContext editingContext) {
    EOTypthe eo = (EOTypthe) EOUtilities.createAndInsertInstance(editingContext, _EOTypthe.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<EOTypthe> fetchSpec() {
    return new ERXFetchSpecification<EOTypthe>(_EOTypthe.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOTypthe> fetchAllEOTypthes(EOEditingContext editingContext) {
    return _EOTypthe.fetchAllEOTypthes(editingContext, null);
  }

  public static NSArray<EOTypthe> fetchAllEOTypthes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOTypthe.fetchEOTypthes(editingContext, null, sortOrderings);
  }

  public static NSArray<EOTypthe> fetchEOTypthes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOTypthe> fetchSpec = new ERXFetchSpecification<EOTypthe>(_EOTypthe.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOTypthe> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOTypthe fetchEOTypthe(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTypthe.fetchEOTypthe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTypthe fetchEOTypthe(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOTypthe> eoObjects = _EOTypthe.fetchEOTypthes(editingContext, qualifier, null);
    EOTypthe eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOTypthe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTypthe fetchRequiredEOTypthe(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTypthe.fetchRequiredEOTypthe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTypthe fetchRequiredEOTypthe(EOEditingContext editingContext, EOQualifier qualifier) {
    EOTypthe eoObject = _EOTypthe.fetchEOTypthe(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOTypthe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTypthe localInstanceIn(EOEditingContext editingContext, EOTypthe eo) {
    EOTypthe localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypthe> fetchThemqatiqueList(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("themqatiqueList", _EOTypthe.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypthe> fetchThemqatiqueList(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("themqatiqueList", _EOTypthe.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
