// DO NOT EDIT.  Make changes to EOEquipes.java instead.
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
public abstract class _EOEquipes extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOEquipes";

  // Attribute Keys
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<String> PRINCIPALE = new ERXKey<String>("principale");
  public static final ERXKey<Integer> PROJET_ID = new ERXKey<Integer>("projetId");
  public static final ERXKey<String> TEMVALIDE = new ERXKey<String>("temvalide");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");

  // Attributes
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String PRINCIPALE_KEY = PRINCIPALE.key();
  public static final String PROJET_ID_KEY = PROJET_ID.key();
  public static final String TEMVALIDE_KEY = TEMVALIDE.key();
  // Relationships
  public static final String TO_PROJET_KEY = TO_PROJET.key();

  private static Logger LOG = Logger.getLogger(_EOEquipes.class);

  public EOEquipes localInstanceIn(EOEditingContext editingContext) {
    EOEquipes localInstance = (EOEquipes)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOEquipes.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOEquipes.LOG.isDebugEnabled()) {
    	_EOEquipes.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOEquipes.C_STRUCTURE_KEY);
  }

  public String principale() {
    return (String) storedValueForKey(_EOEquipes.PRINCIPALE_KEY);
  }

  public void setPrincipale(String value) {
    if (_EOEquipes.LOG.isDebugEnabled()) {
    	_EOEquipes.LOG.debug( "updating principale from " + principale() + " to " + value);
    }
    takeStoredValueForKey(value, _EOEquipes.PRINCIPALE_KEY);
  }

  public Integer projetId() {
    return (Integer) storedValueForKey(_EOEquipes.PROJET_ID_KEY);
  }

  public void setProjetId(Integer value) {
    if (_EOEquipes.LOG.isDebugEnabled()) {
    	_EOEquipes.LOG.debug( "updating projetId from " + projetId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOEquipes.PROJET_ID_KEY);
  }

  public String temvalide() {
    return (String) storedValueForKey(_EOEquipes.TEMVALIDE_KEY);
  }

  public void setTemvalide(String value) {
    if (_EOEquipes.LOG.isDebugEnabled()) {
    	_EOEquipes.LOG.debug( "updating temvalide from " + temvalide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOEquipes.TEMVALIDE_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOEquipes.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOEquipes.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOEquipes.LOG.isDebugEnabled()) {
      _EOEquipes.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOEquipes.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOEquipes.TO_PROJET_KEY);
    }
  }
  

  public static EOEquipes createEOEquipes(EOEditingContext editingContext, String cStructure
, Integer projetId
, String temvalide
, utt.rec.projet.server.metier.admrec.EOPprec toProjet) {
    EOEquipes eo = (EOEquipes) EOUtilities.createAndInsertInstance(editingContext, _EOEquipes.ENTITY_NAME);    
		eo.setCStructure(cStructure);
		eo.setProjetId(projetId);
		eo.setTemvalide(temvalide);
    eo.setToProjetRelationship(toProjet);
    return eo;
  }

  public static ERXFetchSpecification<EOEquipes> fetchSpec() {
    return new ERXFetchSpecification<EOEquipes>(_EOEquipes.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOEquipes> fetchAllEOEquipeses(EOEditingContext editingContext) {
    return _EOEquipes.fetchAllEOEquipeses(editingContext, null);
  }

  public static NSArray<EOEquipes> fetchAllEOEquipeses(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOEquipes.fetchEOEquipeses(editingContext, null, sortOrderings);
  }

  public static NSArray<EOEquipes> fetchEOEquipeses(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOEquipes> fetchSpec = new ERXFetchSpecification<EOEquipes>(_EOEquipes.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOEquipes> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOEquipes fetchEOEquipes(EOEditingContext editingContext, String keyName, Object value) {
    return _EOEquipes.fetchEOEquipes(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOEquipes fetchEOEquipes(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOEquipes> eoObjects = _EOEquipes.fetchEOEquipeses(editingContext, qualifier, null);
    EOEquipes eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOEquipes that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOEquipes fetchRequiredEOEquipes(EOEditingContext editingContext, String keyName, Object value) {
    return _EOEquipes.fetchRequiredEOEquipes(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOEquipes fetchRequiredEOEquipes(EOEditingContext editingContext, EOQualifier qualifier) {
    EOEquipes eoObject = _EOEquipes.fetchEOEquipes(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOEquipes that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOEquipes localInstanceIn(EOEditingContext editingContext, EOEquipes eo) {
    EOEquipes localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> fetchUneEquipePP(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("uneEquipePP", _EOEquipes.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOEquipes>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> fetchUneEquipePP(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("uneEquipePP", _EOEquipes.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOEquipes>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> fetchUneEquipeSS(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("uneEquipeSS", _EOEquipes.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOEquipes>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> fetchUneEquipeSS(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("uneEquipeSS", _EOEquipes.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOEquipes>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
