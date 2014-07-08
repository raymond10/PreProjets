// DO NOT EDIT.  Make changes to EORepartaxe.java instead.
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
public abstract class _EORepartaxe extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EORepartaxe";

  // Attribute Keys
  public static final ERXKey<Integer> AXE_ID = new ERXKey<Integer>("axeId");
  public static final ERXKey<NSTimestamp> MAJCREATE = new ERXKey<NSTimestamp>("majcreate");
  public static final ERXKey<Integer> PROJET_ID = new ERXKey<Integer>("projetId");
  public static final ERXKey<String> TEMVALIDE = new ERXKey<String>("temvalide");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOAxerec> TO_AXE = new ERXKey<utt.rec.projet.server.metier.admrec.EOAxerec>("toAxe");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");

  // Attributes
  public static final String AXE_ID_KEY = AXE_ID.key();
  public static final String MAJCREATE_KEY = MAJCREATE.key();
  public static final String PROJET_ID_KEY = PROJET_ID.key();
  public static final String TEMVALIDE_KEY = TEMVALIDE.key();
  // Relationships
  public static final String TO_AXE_KEY = TO_AXE.key();
  public static final String TO_PROJET_KEY = TO_PROJET.key();

  private static Logger LOG = Logger.getLogger(_EORepartaxe.class);

  public EORepartaxe localInstanceIn(EOEditingContext editingContext) {
    EORepartaxe localInstance = (EORepartaxe)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer axeId() {
    return (Integer) storedValueForKey(_EORepartaxe.AXE_ID_KEY);
  }

  public void setAxeId(Integer value) {
    if (_EORepartaxe.LOG.isDebugEnabled()) {
    	_EORepartaxe.LOG.debug( "updating axeId from " + axeId() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartaxe.AXE_ID_KEY);
  }

  public NSTimestamp majcreate() {
    return (NSTimestamp) storedValueForKey(_EORepartaxe.MAJCREATE_KEY);
  }

  public void setMajcreate(NSTimestamp value) {
    if (_EORepartaxe.LOG.isDebugEnabled()) {
    	_EORepartaxe.LOG.debug( "updating majcreate from " + majcreate() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartaxe.MAJCREATE_KEY);
  }

  public Integer projetId() {
    return (Integer) storedValueForKey(_EORepartaxe.PROJET_ID_KEY);
  }

  public void setProjetId(Integer value) {
    if (_EORepartaxe.LOG.isDebugEnabled()) {
    	_EORepartaxe.LOG.debug( "updating projetId from " + projetId() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartaxe.PROJET_ID_KEY);
  }

  public String temvalide() {
    return (String) storedValueForKey(_EORepartaxe.TEMVALIDE_KEY);
  }

  public void setTemvalide(String value) {
    if (_EORepartaxe.LOG.isDebugEnabled()) {
    	_EORepartaxe.LOG.debug( "updating temvalide from " + temvalide() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartaxe.TEMVALIDE_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOAxerec toAxe() {
    return (utt.rec.projet.server.metier.admrec.EOAxerec)storedValueForKey(_EORepartaxe.TO_AXE_KEY);
  }
  
  public void setToAxe(utt.rec.projet.server.metier.admrec.EOAxerec value) {
    takeStoredValueForKey(value, _EORepartaxe.TO_AXE_KEY);
  }

  public void setToAxeRelationship(utt.rec.projet.server.metier.admrec.EOAxerec value) {
    if (_EORepartaxe.LOG.isDebugEnabled()) {
      _EORepartaxe.LOG.debug("updating toAxe from " + toAxe() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToAxe(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOAxerec oldValue = toAxe();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartaxe.TO_AXE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartaxe.TO_AXE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EORepartaxe.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EORepartaxe.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EORepartaxe.LOG.isDebugEnabled()) {
      _EORepartaxe.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartaxe.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartaxe.TO_PROJET_KEY);
    }
  }
  

  public static EORepartaxe createEORepartaxe(EOEditingContext editingContext, Integer axeId
, NSTimestamp majcreate
, Integer projetId
, String temvalide
, utt.rec.projet.server.metier.admrec.EOAxerec toAxe, utt.rec.projet.server.metier.admrec.EOPprec toProjet) {
    EORepartaxe eo = (EORepartaxe) EOUtilities.createAndInsertInstance(editingContext, _EORepartaxe.ENTITY_NAME);    
		eo.setAxeId(axeId);
		eo.setMajcreate(majcreate);
		eo.setProjetId(projetId);
		eo.setTemvalide(temvalide);
    eo.setToAxeRelationship(toAxe);
    eo.setToProjetRelationship(toProjet);
    return eo;
  }

  public static ERXFetchSpecification<EORepartaxe> fetchSpec() {
    return new ERXFetchSpecification<EORepartaxe>(_EORepartaxe.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EORepartaxe> fetchAllEORepartaxes(EOEditingContext editingContext) {
    return _EORepartaxe.fetchAllEORepartaxes(editingContext, null);
  }

  public static NSArray<EORepartaxe> fetchAllEORepartaxes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EORepartaxe.fetchEORepartaxes(editingContext, null, sortOrderings);
  }

  public static NSArray<EORepartaxe> fetchEORepartaxes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EORepartaxe> fetchSpec = new ERXFetchSpecification<EORepartaxe>(_EORepartaxe.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EORepartaxe> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EORepartaxe fetchEORepartaxe(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartaxe.fetchEORepartaxe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartaxe fetchEORepartaxe(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EORepartaxe> eoObjects = _EORepartaxe.fetchEORepartaxes(editingContext, qualifier, null);
    EORepartaxe eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EORepartaxe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartaxe fetchRequiredEORepartaxe(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartaxe.fetchRequiredEORepartaxe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartaxe fetchRequiredEORepartaxe(EOEditingContext editingContext, EOQualifier qualifier) {
    EORepartaxe eoObject = _EORepartaxe.fetchEORepartaxe(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EORepartaxe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartaxe localInstanceIn(EOEditingContext editingContext, EORepartaxe eo) {
    EORepartaxe localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> fetchAxeThematique(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("axeThematique", _EORepartaxe.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> fetchAxeThematique(EOEditingContext editingContext,
	String cStructureBinding,
	Integer projetIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("axeThematique", _EORepartaxe.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(cStructureBinding, "cStructure");
    bindings.takeValueForKey(projetIdBinding, "projetId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
