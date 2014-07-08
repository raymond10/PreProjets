// DO NOT EDIT.  Make changes to EOCategorie.java instead.
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
public abstract class _EOCategorie extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOCategorie";

  // Attribute Keys
  public static final ERXKey<Float> CATEG_COUT = new ERXKey<Float>("categCout");
  public static final ERXKey<String> CATEG_LIB = new ERXKey<String>("categLib");
  // Relationship Keys

  // Attributes
  public static final String CATEG_COUT_KEY = CATEG_COUT.key();
  public static final String CATEG_LIB_KEY = CATEG_LIB.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_EOCategorie.class);

  public EOCategorie localInstanceIn(EOEditingContext editingContext) {
    EOCategorie localInstance = (EOCategorie)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Float categCout() {
    return (Float) storedValueForKey(_EOCategorie.CATEG_COUT_KEY);
  }

  public void setCategCout(Float value) {
    if (_EOCategorie.LOG.isDebugEnabled()) {
    	_EOCategorie.LOG.debug( "updating categCout from " + categCout() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCategorie.CATEG_COUT_KEY);
  }

  public String categLib() {
    return (String) storedValueForKey(_EOCategorie.CATEG_LIB_KEY);
  }

  public void setCategLib(String value) {
    if (_EOCategorie.LOG.isDebugEnabled()) {
    	_EOCategorie.LOG.debug( "updating categLib from " + categLib() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCategorie.CATEG_LIB_KEY);
  }


  public static EOCategorie createEOCategorie(EOEditingContext editingContext) {
    EOCategorie eo = (EOCategorie) EOUtilities.createAndInsertInstance(editingContext, _EOCategorie.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<EOCategorie> fetchSpec() {
    return new ERXFetchSpecification<EOCategorie>(_EOCategorie.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOCategorie> fetchAllEOCategories(EOEditingContext editingContext) {
    return _EOCategorie.fetchAllEOCategories(editingContext, null);
  }

  public static NSArray<EOCategorie> fetchAllEOCategories(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOCategorie.fetchEOCategories(editingContext, null, sortOrderings);
  }

  public static NSArray<EOCategorie> fetchEOCategories(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOCategorie> fetchSpec = new ERXFetchSpecification<EOCategorie>(_EOCategorie.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOCategorie> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOCategorie fetchEOCategorie(EOEditingContext editingContext, String keyName, Object value) {
    return _EOCategorie.fetchEOCategorie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOCategorie fetchEOCategorie(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOCategorie> eoObjects = _EOCategorie.fetchEOCategories(editingContext, qualifier, null);
    EOCategorie eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOCategorie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOCategorie fetchRequiredEOCategorie(EOEditingContext editingContext, String keyName, Object value) {
    return _EOCategorie.fetchRequiredEOCategorie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOCategorie fetchRequiredEOCategorie(EOEditingContext editingContext, EOQualifier qualifier) {
    EOCategorie eoObject = _EOCategorie.fetchEOCategorie(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOCategorie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOCategorie localInstanceIn(EOEditingContext editingContext, EOCategorie eo) {
    EOCategorie localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOCategorie> fetchLesCategories(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lesCategories", _EOCategorie.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOCategorie>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOCategorie> fetchLesCategories(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lesCategories", _EOCategorie.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOCategorie>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
