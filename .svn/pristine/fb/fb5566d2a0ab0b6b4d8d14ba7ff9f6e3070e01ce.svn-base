// DO NOT EDIT.  Make changes to EOVtyprhcm.java instead.
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
public abstract class _EOVtyprhcm extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOVtyprhcm";

  // Attribute Keys
  public static final ERXKey<String> TYPRHCM_COD = new ERXKey<String>("typrhcmCod");
  public static final ERXKey<Integer> TYPRHCM_ID = new ERXKey<Integer>("typrhcmId");
  public static final ERXKey<String> TYPRHCM_LIB = new ERXKey<String>("typrhcmLib");
  public static final ERXKey<Integer> TYPRHCM_VAL = new ERXKey<Integer>("typrhcmVal");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPosterh> TO_PROFILS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPosterh>("toProfils");

  // Attributes
  public static final String TYPRHCM_COD_KEY = TYPRHCM_COD.key();
  public static final String TYPRHCM_ID_KEY = TYPRHCM_ID.key();
  public static final String TYPRHCM_LIB_KEY = TYPRHCM_LIB.key();
  public static final String TYPRHCM_VAL_KEY = TYPRHCM_VAL.key();
  // Relationships
  public static final String TO_PROFILS_KEY = TO_PROFILS.key();

  private static Logger LOG = Logger.getLogger(_EOVtyprhcm.class);

  public EOVtyprhcm localInstanceIn(EOEditingContext editingContext) {
    EOVtyprhcm localInstance = (EOVtyprhcm)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String typrhcmCod() {
    return (String) storedValueForKey(_EOVtyprhcm.TYPRHCM_COD_KEY);
  }

  public void setTyprhcmCod(String value) {
    if (_EOVtyprhcm.LOG.isDebugEnabled()) {
    	_EOVtyprhcm.LOG.debug( "updating typrhcmCod from " + typrhcmCod() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVtyprhcm.TYPRHCM_COD_KEY);
  }

  public Integer typrhcmId() {
    return (Integer) storedValueForKey(_EOVtyprhcm.TYPRHCM_ID_KEY);
  }

  public void setTyprhcmId(Integer value) {
    if (_EOVtyprhcm.LOG.isDebugEnabled()) {
    	_EOVtyprhcm.LOG.debug( "updating typrhcmId from " + typrhcmId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVtyprhcm.TYPRHCM_ID_KEY);
  }

  public String typrhcmLib() {
    return (String) storedValueForKey(_EOVtyprhcm.TYPRHCM_LIB_KEY);
  }

  public void setTyprhcmLib(String value) {
    if (_EOVtyprhcm.LOG.isDebugEnabled()) {
    	_EOVtyprhcm.LOG.debug( "updating typrhcmLib from " + typrhcmLib() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVtyprhcm.TYPRHCM_LIB_KEY);
  }

  public Integer typrhcmVal() {
    return (Integer) storedValueForKey(_EOVtyprhcm.TYPRHCM_VAL_KEY);
  }

  public void setTyprhcmVal(Integer value) {
    if (_EOVtyprhcm.LOG.isDebugEnabled()) {
    	_EOVtyprhcm.LOG.debug( "updating typrhcmVal from " + typrhcmVal() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVtyprhcm.TYPRHCM_VAL_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> toProfils() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPosterh>)storedValueForKey(_EOVtyprhcm.TO_PROFILS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> toProfils(EOQualifier qualifier) {
    return toProfils(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> toProfils(EOQualifier qualifier, boolean fetch) {
    return toProfils(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> toProfils(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPosterh.TO_CATEGORIE_RH_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPosterh.fetchEOPosterhs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toProfils();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPosterh>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPosterh>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToProfils(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    includeObjectIntoPropertyWithKey(object, _EOVtyprhcm.TO_PROFILS_KEY);
  }

  public void removeFromToProfils(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    excludeObjectFromPropertyWithKey(object, _EOVtyprhcm.TO_PROFILS_KEY);
  }

  public void addToToProfilsRelationship(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    if (_EOVtyprhcm.LOG.isDebugEnabled()) {
      _EOVtyprhcm.LOG.debug("adding " + object + " to toProfils relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProfils(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOVtyprhcm.TO_PROFILS_KEY);
    }
  }

  public void removeFromToProfilsRelationship(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    if (_EOVtyprhcm.LOG.isDebugEnabled()) {
      _EOVtyprhcm.LOG.debug("removing " + object + " from toProfils relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProfils(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOVtyprhcm.TO_PROFILS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPosterh createToProfilsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPosterh.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOVtyprhcm.TO_PROFILS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPosterh) eo;
  }

  public void deleteToProfilsRelationship(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOVtyprhcm.TO_PROFILS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProfilsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPosterh> objects = toProfils().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProfilsRelationship(objects.nextElement());
    }
  }


  public static EOVtyprhcm createEOVtyprhcm(EOEditingContext editingContext, String typrhcmCod
, Integer typrhcmId
, String typrhcmLib
, Integer typrhcmVal
) {
    EOVtyprhcm eo = (EOVtyprhcm) EOUtilities.createAndInsertInstance(editingContext, _EOVtyprhcm.ENTITY_NAME);    
		eo.setTyprhcmCod(typrhcmCod);
		eo.setTyprhcmId(typrhcmId);
		eo.setTyprhcmLib(typrhcmLib);
		eo.setTyprhcmVal(typrhcmVal);
    return eo;
  }

  public static ERXFetchSpecification<EOVtyprhcm> fetchSpec() {
    return new ERXFetchSpecification<EOVtyprhcm>(_EOVtyprhcm.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOVtyprhcm> fetchAllEOVtyprhcms(EOEditingContext editingContext) {
    return _EOVtyprhcm.fetchAllEOVtyprhcms(editingContext, null);
  }

  public static NSArray<EOVtyprhcm> fetchAllEOVtyprhcms(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOVtyprhcm.fetchEOVtyprhcms(editingContext, null, sortOrderings);
  }

  public static NSArray<EOVtyprhcm> fetchEOVtyprhcms(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOVtyprhcm> fetchSpec = new ERXFetchSpecification<EOVtyprhcm>(_EOVtyprhcm.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOVtyprhcm> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOVtyprhcm fetchEOVtyprhcm(EOEditingContext editingContext, String keyName, Object value) {
    return _EOVtyprhcm.fetchEOVtyprhcm(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOVtyprhcm fetchEOVtyprhcm(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOVtyprhcm> eoObjects = _EOVtyprhcm.fetchEOVtyprhcms(editingContext, qualifier, null);
    EOVtyprhcm eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOVtyprhcm that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOVtyprhcm fetchRequiredEOVtyprhcm(EOEditingContext editingContext, String keyName, Object value) {
    return _EOVtyprhcm.fetchRequiredEOVtyprhcm(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOVtyprhcm fetchRequiredEOVtyprhcm(EOEditingContext editingContext, EOQualifier qualifier) {
    EOVtyprhcm eoObject = _EOVtyprhcm.fetchEOVtyprhcm(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOVtyprhcm that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOVtyprhcm localInstanceIn(EOEditingContext editingContext, EOVtyprhcm eo) {
    EOVtyprhcm localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
