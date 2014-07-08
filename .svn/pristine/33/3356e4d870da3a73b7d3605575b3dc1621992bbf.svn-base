// DO NOT EDIT.  Make changes to EOAxerec.java instead.
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
public abstract class _EOAxerec extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOAxerec";

  // Attribute Keys
  public static final ERXKey<String> AXERECLIB = new ERXKey<String>("axereclib");
  public static final ERXKey<Double> AXERECNUM = new ERXKey<Double>("axerecnum");
  public static final ERXKey<String> TEM_AXE = new ERXKey<String>("temAxe");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORepartaxe> TO_AXE_REPARTAXES = new ERXKey<utt.rec.projet.server.metier.admrec.EORepartaxe>("toAxeRepartaxes");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_EQUIPE = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toEquipe");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJETS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjets");

  // Attributes
  public static final String AXERECLIB_KEY = AXERECLIB.key();
  public static final String AXERECNUM_KEY = AXERECNUM.key();
  public static final String TEM_AXE_KEY = TEM_AXE.key();
  // Relationships
  public static final String TO_AXE_REPARTAXES_KEY = TO_AXE_REPARTAXES.key();
  public static final String TO_EQUIPE_KEY = TO_EQUIPE.key();
  public static final String TO_PROJETS_KEY = TO_PROJETS.key();

  private static Logger LOG = Logger.getLogger(_EOAxerec.class);

  public EOAxerec localInstanceIn(EOEditingContext editingContext) {
    EOAxerec localInstance = (EOAxerec)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String axereclib() {
    return (String) storedValueForKey(_EOAxerec.AXERECLIB_KEY);
  }

  public void setAxereclib(String value) {
    if (_EOAxerec.LOG.isDebugEnabled()) {
    	_EOAxerec.LOG.debug( "updating axereclib from " + axereclib() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAxerec.AXERECLIB_KEY);
  }

  public Double axerecnum() {
    return (Double) storedValueForKey(_EOAxerec.AXERECNUM_KEY);
  }

  public void setAxerecnum(Double value) {
    if (_EOAxerec.LOG.isDebugEnabled()) {
    	_EOAxerec.LOG.debug( "updating axerecnum from " + axerecnum() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAxerec.AXERECNUM_KEY);
  }

  public String temAxe() {
    return (String) storedValueForKey(_EOAxerec.TEM_AXE_KEY);
  }

  public void setTemAxe(String value) {
    if (_EOAxerec.LOG.isDebugEnabled()) {
    	_EOAxerec.LOG.debug( "updating temAxe from " + temAxe() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAxerec.TEM_AXE_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EOStructureUlr toEquipe() {
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr)storedValueForKey(_EOAxerec.TO_EQUIPE_KEY);
  }
  
  public void setToEquipe(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    takeStoredValueForKey(value, _EOAxerec.TO_EQUIPE_KEY);
  }

  public void setToEquipeRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    if (_EOAxerec.LOG.isDebugEnabled()) {
      _EOAxerec.LOG.debug("updating toEquipe from " + toEquipe() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToEquipe(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOStructureUlr oldValue = toEquipe();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOAxerec.TO_EQUIPE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOAxerec.TO_EQUIPE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> toAxeRepartaxes() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe>)storedValueForKey(_EOAxerec.TO_AXE_REPARTAXES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> toAxeRepartaxes(EOQualifier qualifier) {
    return toAxeRepartaxes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> toAxeRepartaxes(EOQualifier qualifier, boolean fetch) {
    return toAxeRepartaxes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> toAxeRepartaxes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EORepartaxe.TO_AXE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EORepartaxe.fetchEORepartaxes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toAxeRepartaxes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToAxeRepartaxes(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    includeObjectIntoPropertyWithKey(object, _EOAxerec.TO_AXE_REPARTAXES_KEY);
  }

  public void removeFromToAxeRepartaxes(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    excludeObjectFromPropertyWithKey(object, _EOAxerec.TO_AXE_REPARTAXES_KEY);
  }

  public void addToToAxeRepartaxesRelationship(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    if (_EOAxerec.LOG.isDebugEnabled()) {
      _EOAxerec.LOG.debug("adding " + object + " to toAxeRepartaxes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToAxeRepartaxes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOAxerec.TO_AXE_REPARTAXES_KEY);
    }
  }

  public void removeFromToAxeRepartaxesRelationship(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    if (_EOAxerec.LOG.isDebugEnabled()) {
      _EOAxerec.LOG.debug("removing " + object + " from toAxeRepartaxes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToAxeRepartaxes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOAxerec.TO_AXE_REPARTAXES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EORepartaxe createToAxeRepartaxesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EORepartaxe.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOAxerec.TO_AXE_REPARTAXES_KEY);
    return (utt.rec.projet.server.metier.admrec.EORepartaxe) eo;
  }

  public void deleteToAxeRepartaxesRelationship(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOAxerec.TO_AXE_REPARTAXES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToAxeRepartaxesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EORepartaxe> objects = toAxeRepartaxes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToAxeRepartaxesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)storedValueForKey(_EOAxerec.TO_PROJETS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPprec.TO_AXE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EOAxerec.TO_PROJETS_KEY);
  }

  public void removeFromToProjets(utt.rec.projet.server.metier.admrec.EOPprec object) {
    excludeObjectFromPropertyWithKey(object, _EOAxerec.TO_PROJETS_KEY);
  }

  public void addToToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOAxerec.LOG.isDebugEnabled()) {
      _EOAxerec.LOG.debug("adding " + object + " to toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOAxerec.TO_PROJETS_KEY);
    }
  }

  public void removeFromToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOAxerec.LOG.isDebugEnabled()) {
      _EOAxerec.LOG.debug("removing " + object + " from toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOAxerec.TO_PROJETS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPprec createToProjetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPprec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOAxerec.TO_PROJETS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPprec) eo;
  }

  public void deleteToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOAxerec.TO_PROJETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjetsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPprec> objects = toProjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjetsRelationship(objects.nextElement());
    }
  }


  public static EOAxerec createEOAxerec(EOEditingContext editingContext, Double axerecnum
, String temAxe
, utt.rec.projet.server.metier.grhum.EOStructureUlr toEquipe) {
    EOAxerec eo = (EOAxerec) EOUtilities.createAndInsertInstance(editingContext, _EOAxerec.ENTITY_NAME);    
		eo.setAxerecnum(axerecnum);
		eo.setTemAxe(temAxe);
    eo.setToEquipeRelationship(toEquipe);
    return eo;
  }

  public static ERXFetchSpecification<EOAxerec> fetchSpec() {
    return new ERXFetchSpecification<EOAxerec>(_EOAxerec.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOAxerec> fetchAllEOAxerecs(EOEditingContext editingContext) {
    return _EOAxerec.fetchAllEOAxerecs(editingContext, null);
  }

  public static NSArray<EOAxerec> fetchAllEOAxerecs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOAxerec.fetchEOAxerecs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOAxerec> fetchEOAxerecs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOAxerec> fetchSpec = new ERXFetchSpecification<EOAxerec>(_EOAxerec.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOAxerec> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOAxerec fetchEOAxerec(EOEditingContext editingContext, String keyName, Object value) {
    return _EOAxerec.fetchEOAxerec(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOAxerec fetchEOAxerec(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOAxerec> eoObjects = _EOAxerec.fetchEOAxerecs(editingContext, qualifier, null);
    EOAxerec eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOAxerec that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOAxerec fetchRequiredEOAxerec(EOEditingContext editingContext, String keyName, Object value) {
    return _EOAxerec.fetchRequiredEOAxerec(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOAxerec fetchRequiredEOAxerec(EOEditingContext editingContext, EOQualifier qualifier) {
    EOAxerec eoObject = _EOAxerec.fetchEOAxerec(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOAxerec that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOAxerec localInstanceIn(EOEditingContext editingContext, EOAxerec eo) {
    EOAxerec localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> fetchEquipe(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("equipe", _EOAxerec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> fetchEquipe(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("equipe", _EOAxerec.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> fetchEquipeAxes(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("equipeAxes", _EOAxerec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> fetchEquipeAxes(EOEditingContext editingContext,
	String equipeBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("equipeAxes", _EOAxerec.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(equipeBinding, "equipe");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> fetchEquipePst(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("equipePst", _EOAxerec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> fetchEquipePst(EOEditingContext editingContext,
	String equipeBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("equipePst", _EOAxerec.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(equipeBinding, "equipe");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
