// DO NOT EDIT.  Make changes to EOVrhcmval.java instead.
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
public abstract class _EOVrhcmval extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOVrhcmval";

  // Attribute Keys
  public static final ERXKey<String> CHERCHEUR = new ERXKey<String>("chercheur");
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<Integer> NO_INDIVIDU = new ERXKey<Integer>("noIndividu");
  public static final ERXKey<String> NOM_USUEL = new ERXKey<String>("nomUsuel");
  public static final ERXKey<Integer> PERS_ID = new ERXKey<Integer>("persId");
  public static final ERXKey<String> POLE = new ERXKey<String>("pole");
  public static final ERXKey<String> PRENOM = new ERXKey<String>("prenom");
  public static final ERXKey<Integer> RHCMVAL_VAL = new ERXKey<Integer>("rhcmvalVal");
  public static final ERXKey<String> TYPRHCM_COD = new ERXKey<String>("typrhcmCod");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPersonnel> TO_PERSONNELS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPersonnel>("toPersonnels");

  // Attributes
  public static final String CHERCHEUR_KEY = CHERCHEUR.key();
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String NO_INDIVIDU_KEY = NO_INDIVIDU.key();
  public static final String NOM_USUEL_KEY = NOM_USUEL.key();
  public static final String PERS_ID_KEY = PERS_ID.key();
  public static final String POLE_KEY = POLE.key();
  public static final String PRENOM_KEY = PRENOM.key();
  public static final String RHCMVAL_VAL_KEY = RHCMVAL_VAL.key();
  public static final String TYPRHCM_COD_KEY = TYPRHCM_COD.key();
  // Relationships
  public static final String TO_PERSONNELS_KEY = TO_PERSONNELS.key();

  private static Logger LOG = Logger.getLogger(_EOVrhcmval.class);

  public EOVrhcmval localInstanceIn(EOEditingContext editingContext) {
    EOVrhcmval localInstance = (EOVrhcmval)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String chercheur() {
    return (String) storedValueForKey(_EOVrhcmval.CHERCHEUR_KEY);
  }

  public void setChercheur(String value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating chercheur from " + chercheur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.CHERCHEUR_KEY);
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOVrhcmval.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.C_STRUCTURE_KEY);
  }

  public Integer noIndividu() {
    return (Integer) storedValueForKey(_EOVrhcmval.NO_INDIVIDU_KEY);
  }

  public void setNoIndividu(Integer value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating noIndividu from " + noIndividu() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.NO_INDIVIDU_KEY);
  }

  public String nomUsuel() {
    return (String) storedValueForKey(_EOVrhcmval.NOM_USUEL_KEY);
  }

  public void setNomUsuel(String value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating nomUsuel from " + nomUsuel() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.NOM_USUEL_KEY);
  }

  public Integer persId() {
    return (Integer) storedValueForKey(_EOVrhcmval.PERS_ID_KEY);
  }

  public void setPersId(Integer value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating persId from " + persId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.PERS_ID_KEY);
  }

  public String pole() {
    return (String) storedValueForKey(_EOVrhcmval.POLE_KEY);
  }

  public void setPole(String value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating pole from " + pole() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.POLE_KEY);
  }

  public String prenom() {
    return (String) storedValueForKey(_EOVrhcmval.PRENOM_KEY);
  }

  public void setPrenom(String value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating prenom from " + prenom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.PRENOM_KEY);
  }

  public Integer rhcmvalVal() {
    return (Integer) storedValueForKey(_EOVrhcmval.RHCMVAL_VAL_KEY);
  }

  public void setRhcmvalVal(Integer value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating rhcmvalVal from " + rhcmvalVal() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.RHCMVAL_VAL_KEY);
  }

  public String typrhcmCod() {
    return (String) storedValueForKey(_EOVrhcmval.TYPRHCM_COD_KEY);
  }

  public void setTyprhcmCod(String value) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
    	_EOVrhcmval.LOG.debug( "updating typrhcmCod from " + typrhcmCod() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVrhcmval.TYPRHCM_COD_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> toPersonnels() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)storedValueForKey(_EOVrhcmval.TO_PERSONNELS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> toPersonnels(EOQualifier qualifier) {
    return toPersonnels(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> toPersonnels(EOQualifier qualifier, boolean fetch) {
    return toPersonnels(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> toPersonnels(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPersonnel.TO_VRHCMVAL_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPersonnel.fetchEOPersonnels(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toPersonnels();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToPersonnels(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    includeObjectIntoPropertyWithKey(object, _EOVrhcmval.TO_PERSONNELS_KEY);
  }

  public void removeFromToPersonnels(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    excludeObjectFromPropertyWithKey(object, _EOVrhcmval.TO_PERSONNELS_KEY);
  }

  public void addToToPersonnelsRelationship(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
      _EOVrhcmval.LOG.debug("adding " + object + " to toPersonnels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToPersonnels(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOVrhcmval.TO_PERSONNELS_KEY);
    }
  }

  public void removeFromToPersonnelsRelationship(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    if (_EOVrhcmval.LOG.isDebugEnabled()) {
      _EOVrhcmval.LOG.debug("removing " + object + " from toPersonnels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToPersonnels(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOVrhcmval.TO_PERSONNELS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPersonnel createToPersonnelsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPersonnel.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOVrhcmval.TO_PERSONNELS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPersonnel) eo;
  }

  public void deleteToPersonnelsRelationship(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOVrhcmval.TO_PERSONNELS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToPersonnelsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPersonnel> objects = toPersonnels().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToPersonnelsRelationship(objects.nextElement());
    }
  }


  public static EOVrhcmval createEOVrhcmval(EOEditingContext editingContext, String chercheur
, Integer noIndividu
) {
    EOVrhcmval eo = (EOVrhcmval) EOUtilities.createAndInsertInstance(editingContext, _EOVrhcmval.ENTITY_NAME);    
		eo.setChercheur(chercheur);
		eo.setNoIndividu(noIndividu);
    return eo;
  }

  public static ERXFetchSpecification<EOVrhcmval> fetchSpec() {
    return new ERXFetchSpecification<EOVrhcmval>(_EOVrhcmval.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOVrhcmval> fetchAllEOVrhcmvals(EOEditingContext editingContext) {
    return _EOVrhcmval.fetchAllEOVrhcmvals(editingContext, null);
  }

  public static NSArray<EOVrhcmval> fetchAllEOVrhcmvals(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOVrhcmval.fetchEOVrhcmvals(editingContext, null, sortOrderings);
  }

  public static NSArray<EOVrhcmval> fetchEOVrhcmvals(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOVrhcmval> fetchSpec = new ERXFetchSpecification<EOVrhcmval>(_EOVrhcmval.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOVrhcmval> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOVrhcmval fetchEOVrhcmval(EOEditingContext editingContext, String keyName, Object value) {
    return _EOVrhcmval.fetchEOVrhcmval(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOVrhcmval fetchEOVrhcmval(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOVrhcmval> eoObjects = _EOVrhcmval.fetchEOVrhcmvals(editingContext, qualifier, null);
    EOVrhcmval eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOVrhcmval that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOVrhcmval fetchRequiredEOVrhcmval(EOEditingContext editingContext, String keyName, Object value) {
    return _EOVrhcmval.fetchRequiredEOVrhcmval(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOVrhcmval fetchRequiredEOVrhcmval(EOEditingContext editingContext, EOQualifier qualifier) {
    EOVrhcmval eoObject = _EOVrhcmval.fetchEOVrhcmval(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOVrhcmval that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOVrhcmval localInstanceIn(EOEditingContext editingContext, EOVrhcmval eo) {
    EOVrhcmval localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOVrhcmval> fetchLesChercheurs(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("LesChercheurs", _EOVrhcmval.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOVrhcmval>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOVrhcmval> fetchLesChercheurs(EOEditingContext editingContext,
	String cStructureBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("LesChercheurs", _EOVrhcmval.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(cStructureBinding, "cStructure");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOVrhcmval>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOVrhcmval> fetchRealChercheurs(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("RealChercheurs", _EOVrhcmval.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOVrhcmval>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOVrhcmval> fetchRealChercheurs(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("RealChercheurs", _EOVrhcmval.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOVrhcmval>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
