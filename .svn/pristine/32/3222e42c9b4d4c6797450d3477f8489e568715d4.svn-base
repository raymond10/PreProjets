// DO NOT EDIT.  Make changes to EORepartStructure.java instead.
package utt.rec.projet.server.metier.grhum;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _EORepartStructure extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EORepartStructure";

  // Attribute Keys
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<Integer> PERS_ID = new ERXKey<Integer>("persId");
  public static final ERXKey<Integer> PERS_ID_CREATION = new ERXKey<Integer>("persIdCreation");
  public static final ERXKey<Integer> PERS_ID_MODIFICATION = new ERXKey<Integer>("persIdModification");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr> TO_INDIVIDU = new ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr>("toIndividu");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne> TO_PERSONNE = new ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne>("toPersonne");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartAssociation> TO_REPART_ASSOCIATIONS = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartAssociation>("toRepartAssociations");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURE = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructure");

  // Attributes
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String PERS_ID_KEY = PERS_ID.key();
  public static final String PERS_ID_CREATION_KEY = PERS_ID_CREATION.key();
  public static final String PERS_ID_MODIFICATION_KEY = PERS_ID_MODIFICATION.key();
  // Relationships
  public static final String TO_INDIVIDU_KEY = TO_INDIVIDU.key();
  public static final String TO_PERSONNE_KEY = TO_PERSONNE.key();
  public static final String TO_REPART_ASSOCIATIONS_KEY = TO_REPART_ASSOCIATIONS.key();
  public static final String TO_STRUCTURE_KEY = TO_STRUCTURE.key();

  private static Logger LOG = Logger.getLogger(_EORepartStructure.class);

  public EORepartStructure localInstanceIn(EOEditingContext editingContext) {
    EORepartStructure localInstance = (EORepartStructure)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cStructure() {
    return (String) storedValueForKey(_EORepartStructure.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
    	_EORepartStructure.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartStructure.C_STRUCTURE_KEY);
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EORepartStructure.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
    	_EORepartStructure.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartStructure.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EORepartStructure.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
    	_EORepartStructure.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartStructure.D_MODIFICATION_KEY);
  }

  public Integer persId() {
    return (Integer) storedValueForKey(_EORepartStructure.PERS_ID_KEY);
  }

  public void setPersId(Integer value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
    	_EORepartStructure.LOG.debug( "updating persId from " + persId() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartStructure.PERS_ID_KEY);
  }

  public Integer persIdCreation() {
    return (Integer) storedValueForKey(_EORepartStructure.PERS_ID_CREATION_KEY);
  }

  public void setPersIdCreation(Integer value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
    	_EORepartStructure.LOG.debug( "updating persIdCreation from " + persIdCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartStructure.PERS_ID_CREATION_KEY);
  }

  public Integer persIdModification() {
    return (Integer) storedValueForKey(_EORepartStructure.PERS_ID_MODIFICATION_KEY);
  }

  public void setPersIdModification(Integer value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
    	_EORepartStructure.LOG.debug( "updating persIdModification from " + persIdModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartStructure.PERS_ID_MODIFICATION_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EOIndividuUlr toIndividu() {
    return (utt.rec.projet.server.metier.grhum.EOIndividuUlr)storedValueForKey(_EORepartStructure.TO_INDIVIDU_KEY);
  }
  
  public void setToIndividu(utt.rec.projet.server.metier.grhum.EOIndividuUlr value) {
    takeStoredValueForKey(value, _EORepartStructure.TO_INDIVIDU_KEY);
  }

  public void setToIndividuRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
      _EORepartStructure.LOG.debug("updating toIndividu from " + toIndividu() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToIndividu(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOIndividuUlr oldValue = toIndividu();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartStructure.TO_INDIVIDU_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartStructure.TO_INDIVIDU_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOPersonne toPersonne() {
    return (utt.rec.projet.server.metier.grhum.EOPersonne)storedValueForKey(_EORepartStructure.TO_PERSONNE_KEY);
  }
  
  public void setToPersonne(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    takeStoredValueForKey(value, _EORepartStructure.TO_PERSONNE_KEY);
  }

  public void setToPersonneRelationship(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
      _EORepartStructure.LOG.debug("updating toPersonne from " + toPersonne() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPersonne(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOPersonne oldValue = toPersonne();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartStructure.TO_PERSONNE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartStructure.TO_PERSONNE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure() {
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr)storedValueForKey(_EORepartStructure.TO_STRUCTURE_KEY);
  }
  
  public void setToStructure(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    takeStoredValueForKey(value, _EORepartStructure.TO_STRUCTURE_KEY);
  }

  public void setToStructureRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
      _EORepartStructure.LOG.debug("updating toStructure from " + toStructure() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStructure(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOStructureUlr oldValue = toStructure();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartStructure.TO_STRUCTURE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartStructure.TO_STRUCTURE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)storedValueForKey(_EORepartStructure.TO_REPART_ASSOCIATIONS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations(EOQualifier qualifier) {
    return toRepartAssociations(qualifier, null);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> results;
      results = toRepartAssociations();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToToRepartAssociations(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    includeObjectIntoPropertyWithKey(object, _EORepartStructure.TO_REPART_ASSOCIATIONS_KEY);
  }

  public void removeFromToRepartAssociations(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    excludeObjectFromPropertyWithKey(object, _EORepartStructure.TO_REPART_ASSOCIATIONS_KEY);
  }

  public void addToToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
      _EORepartStructure.LOG.debug("adding " + object + " to toRepartAssociations relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRepartAssociations(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EORepartStructure.TO_REPART_ASSOCIATIONS_KEY);
    }
  }

  public void removeFromToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    if (_EORepartStructure.LOG.isDebugEnabled()) {
      _EORepartStructure.LOG.debug("removing " + object + " from toRepartAssociations relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRepartAssociations(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EORepartStructure.TO_REPART_ASSOCIATIONS_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EORepartAssociation createToRepartAssociationsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EORepartAssociation.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EORepartStructure.TO_REPART_ASSOCIATIONS_KEY);
    return (utt.rec.projet.server.metier.grhum.EORepartAssociation) eo;
  }

  public void deleteToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EORepartStructure.TO_REPART_ASSOCIATIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRepartAssociationsRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EORepartAssociation> objects = toRepartAssociations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRepartAssociationsRelationship(objects.nextElement());
    }
  }


  public static EORepartStructure createEORepartStructure(EOEditingContext editingContext, String cStructure
, Integer persId
, utt.rec.projet.server.metier.grhum.EOIndividuUlr toIndividu, utt.rec.projet.server.metier.grhum.EOPersonne toPersonne, utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure) {
    EORepartStructure eo = (EORepartStructure) EOUtilities.createAndInsertInstance(editingContext, _EORepartStructure.ENTITY_NAME);    
		eo.setCStructure(cStructure);
		eo.setPersId(persId);
    eo.setToIndividuRelationship(toIndividu);
    eo.setToPersonneRelationship(toPersonne);
    eo.setToStructureRelationship(toStructure);
    return eo;
  }

  public static ERXFetchSpecification<EORepartStructure> fetchSpec() {
    return new ERXFetchSpecification<EORepartStructure>(_EORepartStructure.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EORepartStructure> fetchAllEORepartStructures(EOEditingContext editingContext) {
    return _EORepartStructure.fetchAllEORepartStructures(editingContext, null);
  }

  public static NSArray<EORepartStructure> fetchAllEORepartStructures(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EORepartStructure.fetchEORepartStructures(editingContext, null, sortOrderings);
  }

  public static NSArray<EORepartStructure> fetchEORepartStructures(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EORepartStructure> fetchSpec = new ERXFetchSpecification<EORepartStructure>(_EORepartStructure.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EORepartStructure> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EORepartStructure fetchEORepartStructure(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartStructure.fetchEORepartStructure(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartStructure fetchEORepartStructure(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EORepartStructure> eoObjects = _EORepartStructure.fetchEORepartStructures(editingContext, qualifier, null);
    EORepartStructure eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EORepartStructure that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartStructure fetchRequiredEORepartStructure(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartStructure.fetchRequiredEORepartStructure(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartStructure fetchRequiredEORepartStructure(EOEditingContext editingContext, EOQualifier qualifier) {
    EORepartStructure eoObject = _EORepartStructure.fetchEORepartStructure(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EORepartStructure that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartStructure localInstanceIn(EOEditingContext editingContext, EORepartStructure eo) {
    EORepartStructure localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> fetchLesER(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lesER", _EORepartStructure.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> fetchLesER(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lesER", _EORepartStructure.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> fetchUneRepartStructure(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("UneRepartStructure", _EORepartStructure.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> fetchUneRepartStructure(EOEditingContext editingContext,
	Integer persIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("UneRepartStructure", _EORepartStructure.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(persIdBinding, "persId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
