// DO NOT EDIT.  Make changes to EOTypref.java instead.
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
public abstract class _EOTypref extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOTypref";

  // Attribute Keys
  public static final ERXKey<String> TYPREFDOM = new ERXKey<String>("typrefdom");
  public static final ERXKey<String> TYPREFLIB = new ERXKey<String>("typreflib");
  public static final ERXKey<String> TYPREFNAT = new ERXKey<String>("typrefnat");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOCommentaires> TO_COMMENTAIRES = new ERXKey<utt.rec.projet.server.metier.admrec.EOCommentaires>("toCommentaires");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOHistorique> TO_HISTORIQUE = new ERXKey<utt.rec.projet.server.metier.admrec.EOHistorique>("toHistorique");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJETS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjets");

  // Attributes
  public static final String TYPREFDOM_KEY = TYPREFDOM.key();
  public static final String TYPREFLIB_KEY = TYPREFLIB.key();
  public static final String TYPREFNAT_KEY = TYPREFNAT.key();
  // Relationships
  public static final String TO_COMMENTAIRES_KEY = TO_COMMENTAIRES.key();
  public static final String TO_HISTORIQUE_KEY = TO_HISTORIQUE.key();
  public static final String TO_PROJETS_KEY = TO_PROJETS.key();

  private static Logger LOG = Logger.getLogger(_EOTypref.class);

  public EOTypref localInstanceIn(EOEditingContext editingContext) {
    EOTypref localInstance = (EOTypref)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String typrefdom() {
    return (String) storedValueForKey(_EOTypref.TYPREFDOM_KEY);
  }

  public void setTyprefdom(String value) {
    if (_EOTypref.LOG.isDebugEnabled()) {
    	_EOTypref.LOG.debug( "updating typrefdom from " + typrefdom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypref.TYPREFDOM_KEY);
  }

  public String typreflib() {
    return (String) storedValueForKey(_EOTypref.TYPREFLIB_KEY);
  }

  public void setTypreflib(String value) {
    if (_EOTypref.LOG.isDebugEnabled()) {
    	_EOTypref.LOG.debug( "updating typreflib from " + typreflib() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypref.TYPREFLIB_KEY);
  }

  public String typrefnat() {
    return (String) storedValueForKey(_EOTypref.TYPREFNAT_KEY);
  }

  public void setTyprefnat(String value) {
    if (_EOTypref.LOG.isDebugEnabled()) {
    	_EOTypref.LOG.debug( "updating typrefnat from " + typrefnat() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTypref.TYPREFNAT_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> toCommentaires() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires>)storedValueForKey(_EOTypref.TO_COMMENTAIRES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> toCommentaires(EOQualifier qualifier) {
    return toCommentaires(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> toCommentaires(EOQualifier qualifier, boolean fetch) {
    return toCommentaires(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> toCommentaires(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOCommentaires.TO_AVIS_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOCommentaires.fetchEOCommentaireses(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toCommentaires();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToCommentaires(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    includeObjectIntoPropertyWithKey(object, _EOTypref.TO_COMMENTAIRES_KEY);
  }

  public void removeFromToCommentaires(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    excludeObjectFromPropertyWithKey(object, _EOTypref.TO_COMMENTAIRES_KEY);
  }

  public void addToToCommentairesRelationship(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    if (_EOTypref.LOG.isDebugEnabled()) {
      _EOTypref.LOG.debug("adding " + object + " to toCommentaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToCommentaires(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOTypref.TO_COMMENTAIRES_KEY);
    }
  }

  public void removeFromToCommentairesRelationship(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    if (_EOTypref.LOG.isDebugEnabled()) {
      _EOTypref.LOG.debug("removing " + object + " from toCommentaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToCommentaires(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypref.TO_COMMENTAIRES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOCommentaires createToCommentairesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOCommentaires.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOTypref.TO_COMMENTAIRES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOCommentaires) eo;
  }

  public void deleteToCommentairesRelationship(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypref.TO_COMMENTAIRES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToCommentairesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOCommentaires> objects = toCommentaires().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToCommentairesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> toHistorique() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOHistorique>)storedValueForKey(_EOTypref.TO_HISTORIQUE_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> toHistorique(EOQualifier qualifier) {
    return toHistorique(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> toHistorique(EOQualifier qualifier, boolean fetch) {
    return toHistorique(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> toHistorique(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOHistorique.TO_ETATS_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOHistorique.fetchEOHistoriques(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toHistorique();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOHistorique>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOHistorique>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToHistorique(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    includeObjectIntoPropertyWithKey(object, _EOTypref.TO_HISTORIQUE_KEY);
  }

  public void removeFromToHistorique(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    excludeObjectFromPropertyWithKey(object, _EOTypref.TO_HISTORIQUE_KEY);
  }

  public void addToToHistoriqueRelationship(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    if (_EOTypref.LOG.isDebugEnabled()) {
      _EOTypref.LOG.debug("adding " + object + " to toHistorique relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToHistorique(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOTypref.TO_HISTORIQUE_KEY);
    }
  }

  public void removeFromToHistoriqueRelationship(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    if (_EOTypref.LOG.isDebugEnabled()) {
      _EOTypref.LOG.debug("removing " + object + " from toHistorique relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToHistorique(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypref.TO_HISTORIQUE_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOHistorique createToHistoriqueRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOHistorique.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOTypref.TO_HISTORIQUE_KEY);
    return (utt.rec.projet.server.metier.admrec.EOHistorique) eo;
  }

  public void deleteToHistoriqueRelationship(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypref.TO_HISTORIQUE_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToHistoriqueRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOHistorique> objects = toHistorique().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToHistoriqueRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)storedValueForKey(_EOTypref.TO_PROJETS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPprec.TO_ETAT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EOTypref.TO_PROJETS_KEY);
  }

  public void removeFromToProjets(utt.rec.projet.server.metier.admrec.EOPprec object) {
    excludeObjectFromPropertyWithKey(object, _EOTypref.TO_PROJETS_KEY);
  }

  public void addToToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOTypref.LOG.isDebugEnabled()) {
      _EOTypref.LOG.debug("adding " + object + " to toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOTypref.TO_PROJETS_KEY);
    }
  }

  public void removeFromToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOTypref.LOG.isDebugEnabled()) {
      _EOTypref.LOG.debug("removing " + object + " from toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypref.TO_PROJETS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPprec createToProjetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPprec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOTypref.TO_PROJETS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPprec) eo;
  }

  public void deleteToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTypref.TO_PROJETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjetsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPprec> objects = toProjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjetsRelationship(objects.nextElement());
    }
  }


  public static EOTypref createEOTypref(EOEditingContext editingContext, String typrefdom
, String typrefnat
) {
    EOTypref eo = (EOTypref) EOUtilities.createAndInsertInstance(editingContext, _EOTypref.ENTITY_NAME);    
		eo.setTyprefdom(typrefdom);
		eo.setTyprefnat(typrefnat);
    return eo;
  }

  public static ERXFetchSpecification<EOTypref> fetchSpec() {
    return new ERXFetchSpecification<EOTypref>(_EOTypref.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOTypref> fetchAllEOTyprefs(EOEditingContext editingContext) {
    return _EOTypref.fetchAllEOTyprefs(editingContext, null);
  }

  public static NSArray<EOTypref> fetchAllEOTyprefs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOTypref.fetchEOTyprefs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOTypref> fetchEOTyprefs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOTypref> fetchSpec = new ERXFetchSpecification<EOTypref>(_EOTypref.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOTypref> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOTypref fetchEOTypref(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTypref.fetchEOTypref(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTypref fetchEOTypref(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOTypref> eoObjects = _EOTypref.fetchEOTyprefs(editingContext, qualifier, null);
    EOTypref eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOTypref that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTypref fetchRequiredEOTypref(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTypref.fetchRequiredEOTypref(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTypref fetchRequiredEOTypref(EOEditingContext editingContext, EOQualifier qualifier) {
    EOTypref eoObject = _EOTypref.fetchEOTypref(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOTypref that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTypref localInstanceIn(EOEditingContext editingContext, EOTypref eo) {
    EOTypref localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchCategorieRMSpec(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("CategorieRMSpec", _EOTypref.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchCategorieRMSpec(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("CategorieRMSpec", _EOTypref.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchEtatsFetchSpec(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("EtatsFetchSpec", _EOTypref.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchEtatsFetchSpec(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("EtatsFetchSpec", _EOTypref.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchIcd(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("icd", _EOTypref.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchIcd(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("icd", _EOTypref.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchPleiade(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("pleiade", _EOTypref.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchPleiade(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("pleiade", _EOTypref.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchProjetPleiade(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("projetPleiade", _EOTypref.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchProjetPleiade(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("projetPleiade", _EOTypref.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchTraiter(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("traiter", _EOTypref.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchTraiter(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("traiter", _EOTypref.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchValider(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("valider", _EOTypref.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchValider(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("valider", _EOTypref.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchVisa(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("visa", _EOTypref.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTypref> fetchVisa(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("visa", _EOTypref.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTypref>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
