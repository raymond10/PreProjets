// DO NOT EDIT.  Make changes to EOGemateriel.java instead.
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
public abstract class _EOGemateriel extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOGemateriel";

  // Attribute Keys
  public static final ERXKey<java.math.BigDecimal> COUT_ESTIME = new ERXKey<java.math.BigDecimal>("coutEstime");
  public static final ERXKey<Integer> GEMAT_AMORTISSEMENT = new ERXKey<Integer>("gematAmortissement");
  public static final ERXKey<Integer> GEMAT_BRUTE = new ERXKey<Integer>("gematBrute");
  public static final ERXKey<String> GEMAT_LIB = new ERXKey<String>("gematLib");
  public static final ERXKey<NSTimestamp> GEMAT_MISE_SERVICE = new ERXKey<NSTimestamp>("gematMiseService");
  public static final ERXKey<String> GEMAT_TEM = new ERXKey<String>("gematTem");
  public static final ERXKey<Integer> GEMAT_UB = new ERXKey<Integer>("gematUb");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOResmat> TO_MATERIELS = new ERXKey<utt.rec.projet.server.metier.admrec.EOResmat>("toMateriels");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPfmateriel> TO_PFMATERIEL = new ERXKey<utt.rec.projet.server.metier.admrec.EOPfmateriel>("toPfmateriel");

  // Attributes
  public static final String COUT_ESTIME_KEY = COUT_ESTIME.key();
  public static final String GEMAT_AMORTISSEMENT_KEY = GEMAT_AMORTISSEMENT.key();
  public static final String GEMAT_BRUTE_KEY = GEMAT_BRUTE.key();
  public static final String GEMAT_LIB_KEY = GEMAT_LIB.key();
  public static final String GEMAT_MISE_SERVICE_KEY = GEMAT_MISE_SERVICE.key();
  public static final String GEMAT_TEM_KEY = GEMAT_TEM.key();
  public static final String GEMAT_UB_KEY = GEMAT_UB.key();
  // Relationships
  public static final String TO_MATERIELS_KEY = TO_MATERIELS.key();
  public static final String TO_PFMATERIEL_KEY = TO_PFMATERIEL.key();

  private static Logger LOG = Logger.getLogger(_EOGemateriel.class);

  public EOGemateriel localInstanceIn(EOEditingContext editingContext) {
    EOGemateriel localInstance = (EOGemateriel)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public java.math.BigDecimal coutEstime() {
    return (java.math.BigDecimal) storedValueForKey(_EOGemateriel.COUT_ESTIME_KEY);
  }

  public void setCoutEstime(java.math.BigDecimal value) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
    	_EOGemateriel.LOG.debug( "updating coutEstime from " + coutEstime() + " to " + value);
    }
    takeStoredValueForKey(value, _EOGemateriel.COUT_ESTIME_KEY);
  }

  public Integer gematAmortissement() {
    return (Integer) storedValueForKey(_EOGemateriel.GEMAT_AMORTISSEMENT_KEY);
  }

  public void setGematAmortissement(Integer value) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
    	_EOGemateriel.LOG.debug( "updating gematAmortissement from " + gematAmortissement() + " to " + value);
    }
    takeStoredValueForKey(value, _EOGemateriel.GEMAT_AMORTISSEMENT_KEY);
  }

  public Integer gematBrute() {
    return (Integer) storedValueForKey(_EOGemateriel.GEMAT_BRUTE_KEY);
  }

  public void setGematBrute(Integer value) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
    	_EOGemateriel.LOG.debug( "updating gematBrute from " + gematBrute() + " to " + value);
    }
    takeStoredValueForKey(value, _EOGemateriel.GEMAT_BRUTE_KEY);
  }

  public String gematLib() {
    return (String) storedValueForKey(_EOGemateriel.GEMAT_LIB_KEY);
  }

  public void setGematLib(String value) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
    	_EOGemateriel.LOG.debug( "updating gematLib from " + gematLib() + " to " + value);
    }
    takeStoredValueForKey(value, _EOGemateriel.GEMAT_LIB_KEY);
  }

  public NSTimestamp gematMiseService() {
    return (NSTimestamp) storedValueForKey(_EOGemateriel.GEMAT_MISE_SERVICE_KEY);
  }

  public void setGematMiseService(NSTimestamp value) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
    	_EOGemateriel.LOG.debug( "updating gematMiseService from " + gematMiseService() + " to " + value);
    }
    takeStoredValueForKey(value, _EOGemateriel.GEMAT_MISE_SERVICE_KEY);
  }

  public String gematTem() {
    return (String) storedValueForKey(_EOGemateriel.GEMAT_TEM_KEY);
  }

  public void setGematTem(String value) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
    	_EOGemateriel.LOG.debug( "updating gematTem from " + gematTem() + " to " + value);
    }
    takeStoredValueForKey(value, _EOGemateriel.GEMAT_TEM_KEY);
  }

  public Integer gematUb() {
    return (Integer) storedValueForKey(_EOGemateriel.GEMAT_UB_KEY);
  }

  public void setGematUb(Integer value) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
    	_EOGemateriel.LOG.debug( "updating gematUb from " + gematUb() + " to " + value);
    }
    takeStoredValueForKey(value, _EOGemateriel.GEMAT_UB_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOPfmateriel toPfmateriel() {
    return (utt.rec.projet.server.metier.admrec.EOPfmateriel)storedValueForKey(_EOGemateriel.TO_PFMATERIEL_KEY);
  }
  
  public void setToPfmateriel(utt.rec.projet.server.metier.admrec.EOPfmateriel value) {
    takeStoredValueForKey(value, _EOGemateriel.TO_PFMATERIEL_KEY);
  }

  public void setToPfmaterielRelationship(utt.rec.projet.server.metier.admrec.EOPfmateriel value) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
      _EOGemateriel.LOG.debug("updating toPfmateriel from " + toPfmateriel() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPfmateriel(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPfmateriel oldValue = toPfmateriel();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOGemateriel.TO_PFMATERIEL_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOGemateriel.TO_PFMATERIEL_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)storedValueForKey(_EOGemateriel.TO_MATERIELS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOResmat.TO_GRAND_EQUIPEMENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EOGemateriel.TO_MATERIELS_KEY);
  }

  public void removeFromToMateriels(utt.rec.projet.server.metier.admrec.EOResmat object) {
    excludeObjectFromPropertyWithKey(object, _EOGemateriel.TO_MATERIELS_KEY);
  }

  public void addToToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
      _EOGemateriel.LOG.debug("adding " + object + " to toMateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToMateriels(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOGemateriel.TO_MATERIELS_KEY);
    }
  }

  public void removeFromToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    if (_EOGemateriel.LOG.isDebugEnabled()) {
      _EOGemateriel.LOG.debug("removing " + object + " from toMateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToMateriels(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOGemateriel.TO_MATERIELS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOResmat createToMaterielsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOResmat.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOGemateriel.TO_MATERIELS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOResmat) eo;
  }

  public void deleteToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOGemateriel.TO_MATERIELS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToMaterielsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOResmat> objects = toMateriels().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToMaterielsRelationship(objects.nextElement());
    }
  }


  public static EOGemateriel createEOGemateriel(EOEditingContext editingContext, Integer gematAmortissement
, Integer gematBrute
, String gematLib
, NSTimestamp gematMiseService
, String gematTem
, Integer gematUb
, utt.rec.projet.server.metier.admrec.EOPfmateriel toPfmateriel) {
    EOGemateriel eo = (EOGemateriel) EOUtilities.createAndInsertInstance(editingContext, _EOGemateriel.ENTITY_NAME);    
		eo.setGematAmortissement(gematAmortissement);
		eo.setGematBrute(gematBrute);
		eo.setGematLib(gematLib);
		eo.setGematMiseService(gematMiseService);
		eo.setGematTem(gematTem);
		eo.setGematUb(gematUb);
    eo.setToPfmaterielRelationship(toPfmateriel);
    return eo;
  }

  public static ERXFetchSpecification<EOGemateriel> fetchSpec() {
    return new ERXFetchSpecification<EOGemateriel>(_EOGemateriel.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOGemateriel> fetchAllEOGemateriels(EOEditingContext editingContext) {
    return _EOGemateriel.fetchAllEOGemateriels(editingContext, null);
  }

  public static NSArray<EOGemateriel> fetchAllEOGemateriels(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOGemateriel.fetchEOGemateriels(editingContext, null, sortOrderings);
  }

  public static NSArray<EOGemateriel> fetchEOGemateriels(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOGemateriel> fetchSpec = new ERXFetchSpecification<EOGemateriel>(_EOGemateriel.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOGemateriel> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOGemateriel fetchEOGemateriel(EOEditingContext editingContext, String keyName, Object value) {
    return _EOGemateriel.fetchEOGemateriel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOGemateriel fetchEOGemateriel(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOGemateriel> eoObjects = _EOGemateriel.fetchEOGemateriels(editingContext, qualifier, null);
    EOGemateriel eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOGemateriel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOGemateriel fetchRequiredEOGemateriel(EOEditingContext editingContext, String keyName, Object value) {
    return _EOGemateriel.fetchRequiredEOGemateriel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOGemateriel fetchRequiredEOGemateriel(EOEditingContext editingContext, EOQualifier qualifier) {
    EOGemateriel eoObject = _EOGemateriel.fetchEOGemateriel(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOGemateriel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOGemateriel localInstanceIn(EOEditingContext editingContext, EOGemateriel eo) {
    EOGemateriel localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> fetchExistant(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("existant", _EOGemateriel.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> fetchExistant(EOEditingContext editingContext,
	String gematLibBinding,
	utt.rec.projet.server.metier.admrec.EOPfmateriel pfmaterielBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("existant", _EOGemateriel.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(gematLibBinding, "gematLib");
    bindings.takeValueForKey(pfmaterielBinding, "pfmateriel");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> fetchLeGEduPF(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("LeGEduPF", _EOGemateriel.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> fetchLeGEduPF(EOEditingContext editingContext,
	String pfmatIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("LeGEduPF", _EOGemateriel.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(pfmatIdBinding, "pfmatId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> fetchLeNgeDuPT(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("leNgeDuPT", _EOGemateriel.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> fetchLeNgeDuPT(EOEditingContext editingContext,
	String pfmatIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("leNgeDuPT", _EOGemateriel.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(pfmatIdBinding, "pfmatId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> fetchRenvoieLastGE(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("renvoieLastGE", _EOGemateriel.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel> fetchRenvoieLastGE(EOEditingContext editingContext,
	Integer gematIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("renvoieLastGE", _EOGemateriel.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(gematIdBinding, "gematId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOGemateriel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
