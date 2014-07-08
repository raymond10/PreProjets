// DO NOT EDIT.  Make changes to EOTypcontrat.java instead.
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
public abstract class _EOTypcontrat extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOTypcontrat";

  // Attribute Keys
  public static final ERXKey<String> C_CLCONTRAT = new ERXKey<String>("cClcontrat");
  public static final ERXKey<Integer> TYPCONT_ID_SUP = new ERXKey<Integer>("typcontIdSup");
  public static final ERXKey<String> TYPCONT_NOM = new ERXKey<String>("typcontNom");
  public static final ERXKey<String> TYPCONT_NOM_ABR = new ERXKey<String>("typcontNomAbr");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTypcontrat> TO_CONTRAT_FILS = new ERXKey<utt.rec.projet.server.metier.admrec.EOTypcontrat>("toContratFils");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJETS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjets");

  // Attributes
  public static final String C_CLCONTRAT_KEY = C_CLCONTRAT.key();
  public static final String TYPCONT_ID_SUP_KEY = TYPCONT_ID_SUP.key();
  public static final String TYPCONT_NOM_KEY = TYPCONT_NOM.key();
  public static final String TYPCONT_NOM_ABR_KEY = TYPCONT_NOM_ABR.key();
  // Relationships
  public static final String TO_CONTRAT_FILS_KEY = TO_CONTRAT_FILS.key();
  public static final String TO_PROJETS_KEY = TO_PROJETS.key();

  private static Logger LOG = Logger.getLogger(_EOTypcontrat.class);

  public EOTypcontrat localInstanceIn(EOEditingContext editingContext) {
    EOTypcontrat localInstance = (EOTypcontrat)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cClcontrat() {
    return (String) storedValueForKey(_EOTypcontrat.C_CLCONTRAT_KEY);
  }

  public void setCClcontrat(String value) {
    if (_EOTypcontrat.LOG.isDebugEnabled()) {
    	_EOTypcontrat.LOG.debug( "updating cClcontrat from " + cClcontrat() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypcontrat.C_CLCONTRAT_KEY);
  }

  public Integer typcontIdSup() {
    return (Integer) storedValueForKey(_EOTypcontrat.TYPCONT_ID_SUP_KEY);
  }

  public void setTypcontIdSup(Integer value) {
    if (_EOTypcontrat.LOG.isDebugEnabled()) {
    	_EOTypcontrat.LOG.debug( "updating typcontIdSup from " + typcontIdSup() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypcontrat.TYPCONT_ID_SUP_KEY);
  }

  public String typcontNom() {
    return (String) storedValueForKey(_EOTypcontrat.TYPCONT_NOM_KEY);
  }

  public void setTypcontNom(String value) {
    if (_EOTypcontrat.LOG.isDebugEnabled()) {
    	_EOTypcontrat.LOG.debug( "updating typcontNom from " + typcontNom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypcontrat.TYPCONT_NOM_KEY);
  }

  public String typcontNomAbr() {
    return (String) storedValueForKey(_EOTypcontrat.TYPCONT_NOM_ABR_KEY);
  }

  public void setTypcontNomAbr(String value) {
    if (_EOTypcontrat.LOG.isDebugEnabled()) {
    	_EOTypcontrat.LOG.debug( "updating typcontNomAbr from " + typcontNomAbr() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypcontrat.TYPCONT_NOM_ABR_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> toContratFils() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)storedValueForKey(_EOTypcontrat.TO_CONTRAT_FILS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> toContratFils(EOQualifier qualifier) {
    return toContratFils(qualifier, null);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> toContratFils(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> results;
      results = toContratFils();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToToContratFils(utt.rec.projet.server.metier.admrec.EOTypcontrat object) {
    includeObjectIntoPropertyWithKey(object, _EOTypcontrat.TO_CONTRAT_FILS_KEY);
  }

  public void removeFromToContratFils(utt.rec.projet.server.metier.admrec.EOTypcontrat object) {
    excludeObjectFromPropertyWithKey(object, _EOTypcontrat.TO_CONTRAT_FILS_KEY);
  }

  public void addToToContratFilsRelationship(utt.rec.projet.server.metier.admrec.EOTypcontrat object) {
    if (_EOTypcontrat.LOG.isDebugEnabled()) {
      _EOTypcontrat.LOG.debug("adding " + object + " to toContratFils relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToContratFils(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOTypcontrat.TO_CONTRAT_FILS_KEY);
    }
  }

  public void removeFromToContratFilsRelationship(utt.rec.projet.server.metier.admrec.EOTypcontrat object) {
    if (_EOTypcontrat.LOG.isDebugEnabled()) {
      _EOTypcontrat.LOG.debug("removing " + object + " from toContratFils relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToContratFils(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypcontrat.TO_CONTRAT_FILS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOTypcontrat createToContratFilsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOTypcontrat.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOTypcontrat.TO_CONTRAT_FILS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOTypcontrat) eo;
  }

  public void deleteToContratFilsRelationship(utt.rec.projet.server.metier.admrec.EOTypcontrat object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypcontrat.TO_CONTRAT_FILS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToContratFilsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOTypcontrat> objects = toContratFils().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToContratFilsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)storedValueForKey(_EOTypcontrat.TO_PROJETS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPprec.TO_CONTRAT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EOTypcontrat.TO_PROJETS_KEY);
  }

  public void removeFromToProjets(utt.rec.projet.server.metier.admrec.EOPprec object) {
    excludeObjectFromPropertyWithKey(object, _EOTypcontrat.TO_PROJETS_KEY);
  }

  public void addToToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOTypcontrat.LOG.isDebugEnabled()) {
      _EOTypcontrat.LOG.debug("adding " + object + " to toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOTypcontrat.TO_PROJETS_KEY);
    }
  }

  public void removeFromToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOTypcontrat.LOG.isDebugEnabled()) {
      _EOTypcontrat.LOG.debug("removing " + object + " from toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypcontrat.TO_PROJETS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPprec createToProjetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPprec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOTypcontrat.TO_PROJETS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPprec) eo;
  }

  public void deleteToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypcontrat.TO_PROJETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjetsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPprec> objects = toProjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjetsRelationship(objects.nextElement());
    }
  }


  public static EOTypcontrat createEOTypcontrat(EOEditingContext editingContext) {
    EOTypcontrat eo = (EOTypcontrat) EOUtilities.createAndInsertInstance(editingContext, _EOTypcontrat.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<EOTypcontrat> fetchSpec() {
    return new ERXFetchSpecification<EOTypcontrat>(_EOTypcontrat.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOTypcontrat> fetchAllEOTypcontrats(EOEditingContext editingContext) {
    return _EOTypcontrat.fetchAllEOTypcontrats(editingContext, null);
  }

  public static NSArray<EOTypcontrat> fetchAllEOTypcontrats(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOTypcontrat.fetchEOTypcontrats(editingContext, null, sortOrderings);
  }

  public static NSArray<EOTypcontrat> fetchEOTypcontrats(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOTypcontrat> fetchSpec = new ERXFetchSpecification<EOTypcontrat>(_EOTypcontrat.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOTypcontrat> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOTypcontrat fetchEOTypcontrat(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTypcontrat.fetchEOTypcontrat(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTypcontrat fetchEOTypcontrat(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOTypcontrat> eoObjects = _EOTypcontrat.fetchEOTypcontrats(editingContext, qualifier, null);
    EOTypcontrat eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOTypcontrat that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTypcontrat fetchRequiredEOTypcontrat(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTypcontrat.fetchRequiredEOTypcontrat(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTypcontrat fetchRequiredEOTypcontrat(EOEditingContext editingContext, EOQualifier qualifier) {
    EOTypcontrat eoObject = _EOTypcontrat.fetchEOTypcontrat(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOTypcontrat that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTypcontrat localInstanceIn(EOEditingContext editingContext, EOTypcontrat eo) {
    EOTypcontrat localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> fetchContratPere(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("ContratPere", _EOTypcontrat.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> fetchContratPere(EOEditingContext editingContext,
	Integer typcontIdSupBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("ContratPere", _EOTypcontrat.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(typcontIdSupBinding, "typcontIdSup");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> fetchContrats(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("Contrats", _EOTypcontrat.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> fetchContrats(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("Contrats", _EOTypcontrat.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> fetchLesContrats(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lesContrats", _EOTypcontrat.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> fetchLesContrats(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lesContrats", _EOTypcontrat.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> fetchLesStContrats(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("LesStContrats", _EOTypcontrat.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat> fetchLesStContrats(EOEditingContext editingContext,
	Integer typcontIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("LesStContrats", _EOTypcontrat.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(typcontIdBinding, "typcontId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypcontrat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
