// DO NOT EDIT.  Make changes to EORefidx.java instead.
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
public abstract class _EORefidx extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EORefidx";

  // Attribute Keys
  public static final ERXKey<Integer> REFIDX_SUP = new ERXKey<Integer>("refidxSup");
  public static final ERXKey<String> REFIDXVAL = new ERXKey<String>("refidxval");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOMotclefs> TO_MOTCLEFS = new ERXKey<utt.rec.projet.server.metier.admrec.EOMotclefs>("toMotclefs");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORefidx> TO_REFIDX_PERE = new ERXKey<utt.rec.projet.server.metier.admrec.EORefidx>("toRefidxPere");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORefidx> TO_REFIDXS = new ERXKey<utt.rec.projet.server.metier.admrec.EORefidx>("toRefidxs");

  // Attributes
  public static final String REFIDX_SUP_KEY = REFIDX_SUP.key();
  public static final String REFIDXVAL_KEY = REFIDXVAL.key();
  // Relationships
  public static final String TO_MOTCLEFS_KEY = TO_MOTCLEFS.key();
  public static final String TO_REFIDX_PERE_KEY = TO_REFIDX_PERE.key();
  public static final String TO_REFIDXS_KEY = TO_REFIDXS.key();

  private static Logger LOG = Logger.getLogger(_EORefidx.class);

  public EORefidx localInstanceIn(EOEditingContext editingContext) {
    EORefidx localInstance = (EORefidx)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer refidxSup() {
    return (Integer) storedValueForKey(_EORefidx.REFIDX_SUP_KEY);
  }

  public void setRefidxSup(Integer value) {
    if (_EORefidx.LOG.isDebugEnabled()) {
    	_EORefidx.LOG.debug( "updating refidxSup from " + refidxSup() + " to " + value);
    }
    takeStoredValueForKey(value, _EORefidx.REFIDX_SUP_KEY);
  }

  public String refidxval() {
    return (String) storedValueForKey(_EORefidx.REFIDXVAL_KEY);
  }

  public void setRefidxval(String value) {
    if (_EORefidx.LOG.isDebugEnabled()) {
    	_EORefidx.LOG.debug( "updating refidxval from " + refidxval() + " to " + value);
    }
    takeStoredValueForKey(value, _EORefidx.REFIDXVAL_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EORefidx toRefidxPere() {
    return (utt.rec.projet.server.metier.admrec.EORefidx)storedValueForKey(_EORefidx.TO_REFIDX_PERE_KEY);
  }
  
  public void setToRefidxPere(utt.rec.projet.server.metier.admrec.EORefidx value) {
    takeStoredValueForKey(value, _EORefidx.TO_REFIDX_PERE_KEY);
  }

  public void setToRefidxPereRelationship(utt.rec.projet.server.metier.admrec.EORefidx value) {
    if (_EORefidx.LOG.isDebugEnabled()) {
      _EORefidx.LOG.debug("updating toRefidxPere from " + toRefidxPere() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToRefidxPere(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EORefidx oldValue = toRefidxPere();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORefidx.TO_REFIDX_PERE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORefidx.TO_REFIDX_PERE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> toMotclefs() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs>)storedValueForKey(_EORefidx.TO_MOTCLEFS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> toMotclefs(EOQualifier qualifier) {
    return toMotclefs(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> toMotclefs(EOQualifier qualifier, boolean fetch) {
    return toMotclefs(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> toMotclefs(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOMotclefs.TO_REFIDX_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOMotclefs.fetchEOMotclefses(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toMotclefs();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToMotclefs(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    includeObjectIntoPropertyWithKey(object, _EORefidx.TO_MOTCLEFS_KEY);
  }

  public void removeFromToMotclefs(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    excludeObjectFromPropertyWithKey(object, _EORefidx.TO_MOTCLEFS_KEY);
  }

  public void addToToMotclefsRelationship(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    if (_EORefidx.LOG.isDebugEnabled()) {
      _EORefidx.LOG.debug("adding " + object + " to toMotclefs relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToMotclefs(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EORefidx.TO_MOTCLEFS_KEY);
    }
  }

  public void removeFromToMotclefsRelationship(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    if (_EORefidx.LOG.isDebugEnabled()) {
      _EORefidx.LOG.debug("removing " + object + " from toMotclefs relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToMotclefs(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefidx.TO_MOTCLEFS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOMotclefs createToMotclefsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOMotclefs.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EORefidx.TO_MOTCLEFS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOMotclefs) eo;
  }

  public void deleteToMotclefsRelationship(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefidx.TO_MOTCLEFS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToMotclefsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOMotclefs> objects = toMotclefs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToMotclefsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORefidx> toRefidxs() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)storedValueForKey(_EORefidx.TO_REFIDXS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORefidx> toRefidxs(EOQualifier qualifier) {
    return toRefidxs(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORefidx> toRefidxs(EOQualifier qualifier, boolean fetch) {
    return toRefidxs(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORefidx> toRefidxs(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EORefidx> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EORefidx.TO_REFIDX_PERE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EORefidx.fetchEORefidxes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toRefidxs();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToRefidxs(utt.rec.projet.server.metier.admrec.EORefidx object) {
    includeObjectIntoPropertyWithKey(object, _EORefidx.TO_REFIDXS_KEY);
  }

  public void removeFromToRefidxs(utt.rec.projet.server.metier.admrec.EORefidx object) {
    excludeObjectFromPropertyWithKey(object, _EORefidx.TO_REFIDXS_KEY);
  }

  public void addToToRefidxsRelationship(utt.rec.projet.server.metier.admrec.EORefidx object) {
    if (_EORefidx.LOG.isDebugEnabled()) {
      _EORefidx.LOG.debug("adding " + object + " to toRefidxs relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRefidxs(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EORefidx.TO_REFIDXS_KEY);
    }
  }

  public void removeFromToRefidxsRelationship(utt.rec.projet.server.metier.admrec.EORefidx object) {
    if (_EORefidx.LOG.isDebugEnabled()) {
      _EORefidx.LOG.debug("removing " + object + " from toRefidxs relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRefidxs(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefidx.TO_REFIDXS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EORefidx createToRefidxsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EORefidx.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EORefidx.TO_REFIDXS_KEY);
    return (utt.rec.projet.server.metier.admrec.EORefidx) eo;
  }

  public void deleteToRefidxsRelationship(utt.rec.projet.server.metier.admrec.EORefidx object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EORefidx.TO_REFIDXS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRefidxsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EORefidx> objects = toRefidxs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRefidxsRelationship(objects.nextElement());
    }
  }


  public static EORefidx createEORefidx(EOEditingContext editingContext) {
    EORefidx eo = (EORefidx) EOUtilities.createAndInsertInstance(editingContext, _EORefidx.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<EORefidx> fetchSpec() {
    return new ERXFetchSpecification<EORefidx>(_EORefidx.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EORefidx> fetchAllEORefidxes(EOEditingContext editingContext) {
    return _EORefidx.fetchAllEORefidxes(editingContext, null);
  }

  public static NSArray<EORefidx> fetchAllEORefidxes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EORefidx.fetchEORefidxes(editingContext, null, sortOrderings);
  }

  public static NSArray<EORefidx> fetchEORefidxes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EORefidx> fetchSpec = new ERXFetchSpecification<EORefidx>(_EORefidx.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EORefidx> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EORefidx fetchEORefidx(EOEditingContext editingContext, String keyName, Object value) {
    return _EORefidx.fetchEORefidx(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORefidx fetchEORefidx(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EORefidx> eoObjects = _EORefidx.fetchEORefidxes(editingContext, qualifier, null);
    EORefidx eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EORefidx that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORefidx fetchRequiredEORefidx(EOEditingContext editingContext, String keyName, Object value) {
    return _EORefidx.fetchRequiredEORefidx(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORefidx fetchRequiredEORefidx(EOEditingContext editingContext, EOQualifier qualifier) {
    EORefidx eoObject = _EORefidx.fetchEORefidx(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EORefidx that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORefidx localInstanceIn(EOEditingContext editingContext, EORefidx eo) {
    EORefidx localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefidx> fetchGetMotClefs(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("getMotClefs", _EORefidx.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefidx> fetchGetMotClefs(EOEditingContext editingContext,
	Integer idBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("getMotClefs", _EORefidx.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(idBinding, "id");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefidx> fetchGetMotsClefsParents(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("getMotsClefsParents", _EORefidx.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefidx> fetchGetMotsClefsParents(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("getMotsClefsParents", _EORefidx.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefidx> fetchLastMotClef(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lastMotClef", _EORefidx.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORefidx> fetchLastMotClef(EOEditingContext editingContext,
	Integer idBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lastMotClef", _EORefidx.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(idBinding, "id");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORefidx>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
