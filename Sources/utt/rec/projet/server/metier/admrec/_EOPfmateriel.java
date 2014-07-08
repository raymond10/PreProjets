// DO NOT EDIT.  Make changes to EOPfmateriel.java instead.
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
public abstract class _EOPfmateriel extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOPfmateriel";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATE_DARE = new ERXKey<NSTimestamp>("createDare");
  public static final ERXKey<String> C_STRCUTURE = new ERXKey<String>("cStrcuture");
  public static final ERXKey<Integer> MAJ_AUTEUR = new ERXKey<Integer>("majAuteur");
  public static final ERXKey<String> PFMAT_ID = new ERXKey<String>("pfmatId");
  public static final ERXKey<String> PFMAT_LIB = new ERXKey<String>("pfmatLib");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOGemateriel> TO_GEMATERIELS = new ERXKey<utt.rec.projet.server.metier.admrec.EOGemateriel>("toGemateriels");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOResmat> TO_MATERIELS = new ERXKey<utt.rec.projet.server.metier.admrec.EOResmat>("toMateriels");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURE = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructure");

  // Attributes
  public static final String CREATE_DARE_KEY = CREATE_DARE.key();
  public static final String C_STRCUTURE_KEY = C_STRCUTURE.key();
  public static final String MAJ_AUTEUR_KEY = MAJ_AUTEUR.key();
  public static final String PFMAT_ID_KEY = PFMAT_ID.key();
  public static final String PFMAT_LIB_KEY = PFMAT_LIB.key();
  // Relationships
  public static final String TO_GEMATERIELS_KEY = TO_GEMATERIELS.key();
  public static final String TO_MATERIELS_KEY = TO_MATERIELS.key();
  public static final String TO_STRUCTURE_KEY = TO_STRUCTURE.key();

  private static Logger LOG = Logger.getLogger(_EOPfmateriel.class);

  public EOPfmateriel localInstanceIn(EOEditingContext editingContext) {
    EOPfmateriel localInstance = (EOPfmateriel)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp createDare() {
    return (NSTimestamp) storedValueForKey(_EOPfmateriel.CREATE_DARE_KEY);
  }

  public void setCreateDare(NSTimestamp value) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
    	_EOPfmateriel.LOG.debug( "updating createDare from " + createDare() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPfmateriel.CREATE_DARE_KEY);
  }

  public String cStrcuture() {
    return (String) storedValueForKey(_EOPfmateriel.C_STRCUTURE_KEY);
  }

  public void setCStrcuture(String value) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
    	_EOPfmateriel.LOG.debug( "updating cStrcuture from " + cStrcuture() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPfmateriel.C_STRCUTURE_KEY);
  }

  public Integer majAuteur() {
    return (Integer) storedValueForKey(_EOPfmateriel.MAJ_AUTEUR_KEY);
  }

  public void setMajAuteur(Integer value) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
    	_EOPfmateriel.LOG.debug( "updating majAuteur from " + majAuteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPfmateriel.MAJ_AUTEUR_KEY);
  }

  public String pfmatId() {
    return (String) storedValueForKey(_EOPfmateriel.PFMAT_ID_KEY);
  }

  public void setPfmatId(String value) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
    	_EOPfmateriel.LOG.debug( "updating pfmatId from " + pfmatId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPfmateriel.PFMAT_ID_KEY);
  }

  public String pfmatLib() {
    return (String) storedValueForKey(_EOPfmateriel.PFMAT_LIB_KEY);
  }

  public void setPfmatLib(String value) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
    	_EOPfmateriel.LOG.debug( "updating pfmatLib from " + pfmatLib() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPfmateriel.PFMAT_LIB_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure() {
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr)storedValueForKey(_EOPfmateriel.TO_STRUCTURE_KEY);
  }
  
  public void setToStructure(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    takeStoredValueForKey(value, _EOPfmateriel.TO_STRUCTURE_KEY);
  }

  public void setToStructureRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
      _EOPfmateriel.LOG.debug("updating toStructure from " + toStructure() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStructure(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOStructureUlr oldValue = toStructure();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPfmateriel.TO_STRUCTURE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPfmateriel.TO_STRUCTURE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> toGemateriels() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)storedValueForKey(_EOPfmateriel.TO_GEMATERIELS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> toGemateriels(EOQualifier qualifier) {
    return toGemateriels(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> toGemateriels(EOQualifier qualifier, boolean fetch) {
    return toGemateriels(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> toGemateriels(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOGemateriel.TO_PFMATERIEL_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOGemateriel.fetchEOGemateriels(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toGemateriels();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToGemateriels(utt.rec.projet.server.metier.admrec.EOGemateriel object) {
    includeObjectIntoPropertyWithKey(object, _EOPfmateriel.TO_GEMATERIELS_KEY);
  }

  public void removeFromToGemateriels(utt.rec.projet.server.metier.admrec.EOGemateriel object) {
    excludeObjectFromPropertyWithKey(object, _EOPfmateriel.TO_GEMATERIELS_KEY);
  }

  public void addToToGematerielsRelationship(utt.rec.projet.server.metier.admrec.EOGemateriel object) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
      _EOPfmateriel.LOG.debug("adding " + object + " to toGemateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToGemateriels(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPfmateriel.TO_GEMATERIELS_KEY);
    }
  }

  public void removeFromToGematerielsRelationship(utt.rec.projet.server.metier.admrec.EOGemateriel object) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
      _EOPfmateriel.LOG.debug("removing " + object + " from toGemateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToGemateriels(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPfmateriel.TO_GEMATERIELS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOGemateriel createToGematerielsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOGemateriel.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPfmateriel.TO_GEMATERIELS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOGemateriel) eo;
  }

  public void deleteToGematerielsRelationship(utt.rec.projet.server.metier.admrec.EOGemateriel object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPfmateriel.TO_GEMATERIELS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToGematerielsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOGemateriel> objects = toGemateriels().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToGematerielsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)storedValueForKey(_EOPfmateriel.TO_MATERIELS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels(EOQualifier qualifier) {
    return toMateriels(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels(EOQualifier qualifier, boolean fetch) {
    return toMateriels(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOResmat> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOResmat.TO_PLATEAU_TECH_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOResmat.fetchEOResmats(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toMateriels();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToMateriels(utt.rec.projet.server.metier.admrec.EOResmat object) {
    includeObjectIntoPropertyWithKey(object, _EOPfmateriel.TO_MATERIELS_KEY);
  }

  public void removeFromToMateriels(utt.rec.projet.server.metier.admrec.EOResmat object) {
    excludeObjectFromPropertyWithKey(object, _EOPfmateriel.TO_MATERIELS_KEY);
  }

  public void addToToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
      _EOPfmateriel.LOG.debug("adding " + object + " to toMateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToMateriels(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPfmateriel.TO_MATERIELS_KEY);
    }
  }

  public void removeFromToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    if (_EOPfmateriel.LOG.isDebugEnabled()) {
      _EOPfmateriel.LOG.debug("removing " + object + " from toMateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToMateriels(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPfmateriel.TO_MATERIELS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOResmat createToMaterielsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOResmat.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPfmateriel.TO_MATERIELS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOResmat) eo;
  }

  public void deleteToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPfmateriel.TO_MATERIELS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToMaterielsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOResmat> objects = toMateriels().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToMaterielsRelationship(objects.nextElement());
    }
  }


  public static EOPfmateriel createEOPfmateriel(EOEditingContext editingContext, NSTimestamp createDare
, String cStrcuture
, Integer majAuteur
, String pfmatId
, String pfmatLib
, utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure) {
    EOPfmateriel eo = (EOPfmateriel) EOUtilities.createAndInsertInstance(editingContext, _EOPfmateriel.ENTITY_NAME);    
		eo.setCreateDare(createDare);
		eo.setCStrcuture(cStrcuture);
		eo.setMajAuteur(majAuteur);
		eo.setPfmatId(pfmatId);
		eo.setPfmatLib(pfmatLib);
    eo.setToStructureRelationship(toStructure);
    return eo;
  }

  public static ERXFetchSpecification<EOPfmateriel> fetchSpec() {
    return new ERXFetchSpecification<EOPfmateriel>(_EOPfmateriel.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOPfmateriel> fetchAllEOPfmateriels(EOEditingContext editingContext) {
    return _EOPfmateriel.fetchAllEOPfmateriels(editingContext, null);
  }

  public static NSArray<EOPfmateriel> fetchAllEOPfmateriels(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOPfmateriel.fetchEOPfmateriels(editingContext, null, sortOrderings);
  }

  public static NSArray<EOPfmateriel> fetchEOPfmateriels(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOPfmateriel> fetchSpec = new ERXFetchSpecification<EOPfmateriel>(_EOPfmateriel.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOPfmateriel> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOPfmateriel fetchEOPfmateriel(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPfmateriel.fetchEOPfmateriel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPfmateriel fetchEOPfmateriel(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOPfmateriel> eoObjects = _EOPfmateriel.fetchEOPfmateriels(editingContext, qualifier, null);
    EOPfmateriel eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOPfmateriel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPfmateriel fetchRequiredEOPfmateriel(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPfmateriel.fetchRequiredEOPfmateriel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPfmateriel fetchRequiredEOPfmateriel(EOEditingContext editingContext, EOQualifier qualifier) {
    EOPfmateriel eoObject = _EOPfmateriel.fetchEOPfmateriel(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOPfmateriel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPfmateriel localInstanceIn(EOEditingContext editingContext, EOPfmateriel eo) {
    EOPfmateriel localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel> fetchLePFduPole(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lePFduPole", _EOPfmateriel.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel> fetchLePFduPole(EOEditingContext editingContext,
	String cStrcutureBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lePFduPole", _EOPfmateriel.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(cStrcutureBinding, "cStrcuture");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
