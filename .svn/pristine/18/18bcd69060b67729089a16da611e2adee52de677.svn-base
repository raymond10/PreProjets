// DO NOT EDIT.  Make changes to EOMotclefs.java instead.
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
public abstract class _EOMotclefs extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOMotclefs";

  // Attribute Keys
  public static final ERXKey<Integer> MOTCLEF_ID = new ERXKey<Integer>("motclefId");
  public static final ERXKey<Integer> PROJET_ID = new ERXKey<Integer>("projetId");
  public static final ERXKey<Integer> REFIDX_ID = new ERXKey<Integer>("refidxId");
  public static final ERXKey<String> TEMVALIDE = new ERXKey<String>("temvalide");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORefidx> TO_REFIDX = new ERXKey<utt.rec.projet.server.metier.admrec.EORefidx>("toRefidx");

  // Attributes
  public static final String MOTCLEF_ID_KEY = MOTCLEF_ID.key();
  public static final String PROJET_ID_KEY = PROJET_ID.key();
  public static final String REFIDX_ID_KEY = REFIDX_ID.key();
  public static final String TEMVALIDE_KEY = TEMVALIDE.key();
  // Relationships
  public static final String TO_PROJET_KEY = TO_PROJET.key();
  public static final String TO_REFIDX_KEY = TO_REFIDX.key();

  private static Logger LOG = Logger.getLogger(_EOMotclefs.class);

  public EOMotclefs localInstanceIn(EOEditingContext editingContext) {
    EOMotclefs localInstance = (EOMotclefs)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer motclefId() {
    return (Integer) storedValueForKey(_EOMotclefs.MOTCLEF_ID_KEY);
  }

  public void setMotclefId(Integer value) {
    if (_EOMotclefs.LOG.isDebugEnabled()) {
    	_EOMotclefs.LOG.debug( "updating motclefId from " + motclefId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOMotclefs.MOTCLEF_ID_KEY);
  }

  public Integer projetId() {
    return (Integer) storedValueForKey(_EOMotclefs.PROJET_ID_KEY);
  }

  public void setProjetId(Integer value) {
    if (_EOMotclefs.LOG.isDebugEnabled()) {
    	_EOMotclefs.LOG.debug( "updating projetId from " + projetId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOMotclefs.PROJET_ID_KEY);
  }

  public Integer refidxId() {
    return (Integer) storedValueForKey(_EOMotclefs.REFIDX_ID_KEY);
  }

  public void setRefidxId(Integer value) {
    if (_EOMotclefs.LOG.isDebugEnabled()) {
    	_EOMotclefs.LOG.debug( "updating refidxId from " + refidxId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOMotclefs.REFIDX_ID_KEY);
  }

  public String temvalide() {
    return (String) storedValueForKey(_EOMotclefs.TEMVALIDE_KEY);
  }

  public void setTemvalide(String value) {
    if (_EOMotclefs.LOG.isDebugEnabled()) {
    	_EOMotclefs.LOG.debug( "updating temvalide from " + temvalide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOMotclefs.TEMVALIDE_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOMotclefs.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOMotclefs.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOMotclefs.LOG.isDebugEnabled()) {
      _EOMotclefs.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOMotclefs.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOMotclefs.TO_PROJET_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EORefidx toRefidx() {
    return (utt.rec.projet.server.metier.admrec.EORefidx)storedValueForKey(_EOMotclefs.TO_REFIDX_KEY);
  }
  
  public void setToRefidx(utt.rec.projet.server.metier.admrec.EORefidx value) {
    takeStoredValueForKey(value, _EOMotclefs.TO_REFIDX_KEY);
  }

  public void setToRefidxRelationship(utt.rec.projet.server.metier.admrec.EORefidx value) {
    if (_EOMotclefs.LOG.isDebugEnabled()) {
      _EOMotclefs.LOG.debug("updating toRefidx from " + toRefidx() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToRefidx(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EORefidx oldValue = toRefidx();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOMotclefs.TO_REFIDX_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOMotclefs.TO_REFIDX_KEY);
    }
  }
  

  public static EOMotclefs createEOMotclefs(EOEditingContext editingContext, Integer motclefId
, Integer projetId
, Integer refidxId
, String temvalide
, utt.rec.projet.server.metier.admrec.EOPprec toProjet, utt.rec.projet.server.metier.admrec.EORefidx toRefidx) {
    EOMotclefs eo = (EOMotclefs) EOUtilities.createAndInsertInstance(editingContext, _EOMotclefs.ENTITY_NAME);    
		eo.setMotclefId(motclefId);
		eo.setProjetId(projetId);
		eo.setRefidxId(refidxId);
		eo.setTemvalide(temvalide);
    eo.setToProjetRelationship(toProjet);
    eo.setToRefidxRelationship(toRefidx);
    return eo;
  }

  public static ERXFetchSpecification<EOMotclefs> fetchSpec() {
    return new ERXFetchSpecification<EOMotclefs>(_EOMotclefs.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOMotclefs> fetchAllEOMotclefses(EOEditingContext editingContext) {
    return _EOMotclefs.fetchAllEOMotclefses(editingContext, null);
  }

  public static NSArray<EOMotclefs> fetchAllEOMotclefses(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOMotclefs.fetchEOMotclefses(editingContext, null, sortOrderings);
  }

  public static NSArray<EOMotclefs> fetchEOMotclefses(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOMotclefs> fetchSpec = new ERXFetchSpecification<EOMotclefs>(_EOMotclefs.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOMotclefs> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOMotclefs fetchEOMotclefs(EOEditingContext editingContext, String keyName, Object value) {
    return _EOMotclefs.fetchEOMotclefs(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOMotclefs fetchEOMotclefs(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOMotclefs> eoObjects = _EOMotclefs.fetchEOMotclefses(editingContext, qualifier, null);
    EOMotclefs eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOMotclefs that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOMotclefs fetchRequiredEOMotclefs(EOEditingContext editingContext, String keyName, Object value) {
    return _EOMotclefs.fetchRequiredEOMotclefs(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOMotclefs fetchRequiredEOMotclefs(EOEditingContext editingContext, EOQualifier qualifier) {
    EOMotclefs eoObject = _EOMotclefs.fetchEOMotclefs(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOMotclefs that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOMotclefs localInstanceIn(EOEditingContext editingContext, EOMotclefs eo) {
    EOMotclefs localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> fetchMotClefsProjet(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("MotClefsProjet", _EOMotclefs.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> fetchMotClefsProjet(EOEditingContext editingContext,
	Integer projetIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("MotClefsProjet", _EOMotclefs.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(projetIdBinding, "projetId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
