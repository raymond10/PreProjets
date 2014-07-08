// DO NOT EDIT.  Make changes to EORefthe.java instead.
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
public abstract class _EORefthe extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EORefthe";

  // Attribute Keys
  public static final ERXKey<String> REFTHELIB = new ERXKey<String>("refthelib");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJETS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjets");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJETS1 = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjets1");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORefthe> TO_REFTHE_PERE = new ERXKey<utt.rec.projet.server.metier.admrec.EORefthe>("toRefthePere");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORefthe> TO_REFTHES = new ERXKey<utt.rec.projet.server.metier.admrec.EORefthe>("toRefthes");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTypthe> TO_TYPTHE = new ERXKey<utt.rec.projet.server.metier.admrec.EOTypthe>("toTypthe");

  // Attributes
  public static final String REFTHELIB_KEY = REFTHELIB.key();
  // Relationships
  public static final String TO_PROJETS_KEY = TO_PROJETS.key();
  public static final String TO_PROJETS1_KEY = TO_PROJETS1.key();
  public static final String TO_REFTHE_PERE_KEY = TO_REFTHE_PERE.key();
  public static final String TO_REFTHES_KEY = TO_REFTHES.key();
  public static final String TO_TYPTHE_KEY = TO_TYPTHE.key();

  private static Logger LOG = Logger.getLogger(_EORefthe.class);

  public EORefthe localInstanceIn(EOEditingContext editingContext) {
    EORefthe localInstance = (EORefthe)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String refthelib() {
    return (String) storedValueForKey(_EORefthe.REFTHELIB_KEY);
  }

  public void setRefthelib(String value) {
    if (_EORefthe.LOG.isDebugEnabled()) {
    	_EORefthe.LOG.debug( "updating refthelib from " + refthelib() + " to " + value);
    }
    takeStoredValueForKey(value, _EORefthe.REFTHELIB_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EORefthe toRefthePere() {
    return (utt.rec.projet.server.metier.admrec.EORefthe)storedValueForKey(_EORefthe.TO_REFTHE_PERE_KEY);
  }
  
  public void setToRefthePere(utt.rec.projet.server.metier.admrec.EORefthe value) {
    takeStoredValueForKey(value, _EORefthe.TO_REFTHE_PERE_KEY);
  }

  public void setToRefthePereRelationship(utt.rec.projet.server.metier.admrec.EORefthe value) {
    if (_EORefthe.LOG.isDebugEnabled()) {
      _EORefthe.LOG.debug("updating toRefthePere from " + toRefthePere() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToRefthePere(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EORefthe oldValue = toRefthePere();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORefthe.TO_REFTHE_PERE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORefthe.TO_REFTHE_PERE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOTypthe toTypthe() {
    return (utt.rec.projet.server.metier.admrec.EOTypthe)storedValueForKey(_EORefthe.TO_TYPTHE_KEY);
  }
  
  public void setToTypthe(utt.rec.projet.server.metier.admrec.EOTypthe value) {
    takeStoredValueForKey(value, _EORefthe.TO_TYPTHE_KEY);
  }

  public void setToTyptheRelationship(utt.rec.projet.server.metier.admrec.EOTypthe value) {
    if (_EORefthe.LOG.isDebugEnabled()) {
      _EORefthe.LOG.debug("updating toTypthe from " + toTypthe() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToTypthe(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOTypthe oldValue = toTypthe();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORefthe.TO_TYPTHE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORefthe.TO_TYPTHE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)storedValueForKey(_EORefthe.TO_PROJETS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPprec.TO_SOUS_THEMES_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EORefthe.TO_PROJETS_KEY);
  }

  public void removeFromToProjets(utt.rec.projet.server.metier.admrec.EOPprec object) {
    excludeObjectFromPropertyWithKey(object, _EORefthe.TO_PROJETS_KEY);
  }

  public void addToToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EORefthe.LOG.isDebugEnabled()) {
      _EORefthe.LOG.debug("adding " + object + " to toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EORefthe.TO_PROJETS_KEY);
    }
  }

  public void removeFromToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EORefthe.LOG.isDebugEnabled()) {
      _EORefthe.LOG.debug("removing " + object + " from toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefthe.TO_PROJETS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPprec createToProjetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPprec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EORefthe.TO_PROJETS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPprec) eo;
  }

  public void deleteToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefthe.TO_PROJETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjetsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPprec> objects = toProjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjetsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets1() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)storedValueForKey(_EORefthe.TO_PROJETS1_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets1(EOQualifier qualifier) {
    return toProjets1(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets1(EOQualifier qualifier, boolean fetch) {
    return toProjets1(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets1(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPprec> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPprec.TO_SOUS_THEMES_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
      results = toProjets1();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToProjets1(utt.rec.projet.server.metier.admrec.EOPprec object) {
    includeObjectIntoPropertyWithKey(object, _EORefthe.TO_PROJETS1_KEY);
  }

  public void removeFromToProjets1(utt.rec.projet.server.metier.admrec.EOPprec object) {
    excludeObjectFromPropertyWithKey(object, _EORefthe.TO_PROJETS1_KEY);
  }

  public void addToToProjets1Relationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EORefthe.LOG.isDebugEnabled()) {
      _EORefthe.LOG.debug("adding " + object + " to toProjets1 relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjets1(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EORefthe.TO_PROJETS1_KEY);
    }
  }

  public void removeFromToProjets1Relationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EORefthe.LOG.isDebugEnabled()) {
      _EORefthe.LOG.debug("removing " + object + " from toProjets1 relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjets1(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefthe.TO_PROJETS1_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPprec createToProjets1Relationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPprec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EORefthe.TO_PROJETS1_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPprec) eo;
  }

  public void deleteToProjets1Relationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefthe.TO_PROJETS1_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjets1Relationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPprec> objects = toProjets1().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjets1Relationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORefthe> toRefthes() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)storedValueForKey(_EORefthe.TO_REFTHES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORefthe> toRefthes(EOQualifier qualifier) {
    return toRefthes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORefthe> toRefthes(EOQualifier qualifier, boolean fetch) {
    return toRefthes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORefthe> toRefthes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EORefthe> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EORefthe.TO_REFTHE_PERE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EORefthe.fetchEORefthes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toRefthes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToRefthes(utt.rec.projet.server.metier.admrec.EORefthe object) {
    includeObjectIntoPropertyWithKey(object, _EORefthe.TO_REFTHES_KEY);
  }

  public void removeFromToRefthes(utt.rec.projet.server.metier.admrec.EORefthe object) {
    excludeObjectFromPropertyWithKey(object, _EORefthe.TO_REFTHES_KEY);
  }

  public void addToToRefthesRelationship(utt.rec.projet.server.metier.admrec.EORefthe object) {
    if (_EORefthe.LOG.isDebugEnabled()) {
      _EORefthe.LOG.debug("adding " + object + " to toRefthes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRefthes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EORefthe.TO_REFTHES_KEY);
    }
  }

  public void removeFromToRefthesRelationship(utt.rec.projet.server.metier.admrec.EORefthe object) {
    if (_EORefthe.LOG.isDebugEnabled()) {
      _EORefthe.LOG.debug("removing " + object + " from toRefthes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRefthes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefthe.TO_REFTHES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EORefthe createToRefthesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EORefthe.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EORefthe.TO_REFTHES_KEY);
    return (utt.rec.projet.server.metier.admrec.EORefthe) eo;
  }

  public void deleteToRefthesRelationship(utt.rec.projet.server.metier.admrec.EORefthe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefthe.TO_REFTHES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRefthesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EORefthe> objects = toRefthes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRefthesRelationship(objects.nextElement());
    }
  }


  public static EORefthe createEORefthe(EOEditingContext editingContext) {
    EORefthe eo = (EORefthe) EOUtilities.createAndInsertInstance(editingContext, _EORefthe.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<EORefthe> fetchSpec() {
    return new ERXFetchSpecification<EORefthe>(_EORefthe.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EORefthe> fetchAllEORefthes(EOEditingContext editingContext) {
    return _EORefthe.fetchAllEORefthes(editingContext, null);
  }

  public static NSArray<EORefthe> fetchAllEORefthes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EORefthe.fetchEORefthes(editingContext, null, sortOrderings);
  }

  public static NSArray<EORefthe> fetchEORefthes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EORefthe> fetchSpec = new ERXFetchSpecification<EORefthe>(_EORefthe.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EORefthe> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EORefthe fetchEORefthe(EOEditingContext editingContext, String keyName, Object value) {
    return _EORefthe.fetchEORefthe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORefthe fetchEORefthe(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EORefthe> eoObjects = _EORefthe.fetchEORefthes(editingContext, qualifier, null);
    EORefthe eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EORefthe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORefthe fetchRequiredEORefthe(EOEditingContext editingContext, String keyName, Object value) {
    return _EORefthe.fetchRequiredEORefthe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORefthe fetchRequiredEORefthe(EOEditingContext editingContext, EOQualifier qualifier) {
    EORefthe eoObject = _EORefthe.fetchEORefthe(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EORefthe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORefthe localInstanceIn(EOEditingContext editingContext, EORefthe eo) {
    EORefthe localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefthe> fetchRefreshSousTheme(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("refreshSousTheme", _EORefthe.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefthe> fetchRefreshSousTheme(EOEditingContext editingContext,
	Integer reftheIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("refreshSousTheme", _EORefthe.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(reftheIdBinding, "reftheId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefthe> fetchRefreshTheme(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("refreshTheme", _EORefthe.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefthe> fetchRefreshTheme(EOEditingContext editingContext,
	Integer typtheIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("refreshTheme", _EORefthe.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(typtheIdBinding, "typtheId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefthe> fetchSousThemeList(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("sousThemeList", _EORefthe.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefthe> fetchSousThemeList(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("sousThemeList", _EORefthe.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefthe> fetchThemeList(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("themeList", _EORefthe.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefthe> fetchThemeList(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("themeList", _EORefthe.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefthe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
