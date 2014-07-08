// DO NOT EDIT.  Make changes to EOtypeGroupe.java instead.
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
public abstract class _EOtypeGroupe extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOtypeGroupe";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<String> TGRP_LIBELLE = new ERXKey<String>("tgrpLibelle");
  public static final ERXKey<String> TGRP_TEM_UTIL = new ERXKey<String>("tgrpTemUtil");
  public static final ERXKey<String> TGRP_TEM_WEB = new ERXKey<String>("tgrpTemWeb");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> TO_REPART_TYPE_GROUPES = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe>("toRepartTypeGroupes");

  // Attributes
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String TGRP_LIBELLE_KEY = TGRP_LIBELLE.key();
  public static final String TGRP_TEM_UTIL_KEY = TGRP_TEM_UTIL.key();
  public static final String TGRP_TEM_WEB_KEY = TGRP_TEM_WEB.key();
  // Relationships
  public static final String TO_REPART_TYPE_GROUPES_KEY = TO_REPART_TYPE_GROUPES.key();

  private static Logger LOG = Logger.getLogger(_EOtypeGroupe.class);

  public EOtypeGroupe localInstanceIn(EOEditingContext editingContext) {
    EOtypeGroupe localInstance = (EOtypeGroupe)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EOtypeGroupe.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EOtypeGroupe.LOG.isDebugEnabled()) {
    	_EOtypeGroupe.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOtypeGroupe.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EOtypeGroupe.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EOtypeGroupe.LOG.isDebugEnabled()) {
    	_EOtypeGroupe.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOtypeGroupe.D_MODIFICATION_KEY);
  }

  public String tgrpLibelle() {
    return (String) storedValueForKey(_EOtypeGroupe.TGRP_LIBELLE_KEY);
  }

  public void setTgrpLibelle(String value) {
    if (_EOtypeGroupe.LOG.isDebugEnabled()) {
    	_EOtypeGroupe.LOG.debug( "updating tgrpLibelle from " + tgrpLibelle() + " to " + value);
    }
    takeStoredValueForKey(value, _EOtypeGroupe.TGRP_LIBELLE_KEY);
  }

  public String tgrpTemUtil() {
    return (String) storedValueForKey(_EOtypeGroupe.TGRP_TEM_UTIL_KEY);
  }

  public void setTgrpTemUtil(String value) {
    if (_EOtypeGroupe.LOG.isDebugEnabled()) {
    	_EOtypeGroupe.LOG.debug( "updating tgrpTemUtil from " + tgrpTemUtil() + " to " + value);
    }
    takeStoredValueForKey(value, _EOtypeGroupe.TGRP_TEM_UTIL_KEY);
  }

  public String tgrpTemWeb() {
    return (String) storedValueForKey(_EOtypeGroupe.TGRP_TEM_WEB_KEY);
  }

  public void setTgrpTemWeb(String value) {
    if (_EOtypeGroupe.LOG.isDebugEnabled()) {
    	_EOtypeGroupe.LOG.debug( "updating tgrpTemWeb from " + tgrpTemWeb() + " to " + value);
    }
    takeStoredValueForKey(value, _EOtypeGroupe.TGRP_TEM_WEB_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> toRepartTypeGroupes() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe>)storedValueForKey(_EOtypeGroupe.TO_REPART_TYPE_GROUPES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> toRepartTypeGroupes(EOQualifier qualifier) {
    return toRepartTypeGroupes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> toRepartTypeGroupes(EOQualifier qualifier, boolean fetch) {
    return toRepartTypeGroupes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> toRepartTypeGroupes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe.TO_TYPE_GROUPE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EORepartTypeGroupe.fetchEORepartTypeGroupes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toRepartTypeGroupes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToRepartTypeGroupes(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    includeObjectIntoPropertyWithKey(object, _EOtypeGroupe.TO_REPART_TYPE_GROUPES_KEY);
  }

  public void removeFromToRepartTypeGroupes(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    excludeObjectFromPropertyWithKey(object, _EOtypeGroupe.TO_REPART_TYPE_GROUPES_KEY);
  }

  public void addToToRepartTypeGroupesRelationship(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    if (_EOtypeGroupe.LOG.isDebugEnabled()) {
      _EOtypeGroupe.LOG.debug("adding " + object + " to toRepartTypeGroupes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRepartTypeGroupes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOtypeGroupe.TO_REPART_TYPE_GROUPES_KEY);
    }
  }

  public void removeFromToRepartTypeGroupesRelationship(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    if (_EOtypeGroupe.LOG.isDebugEnabled()) {
      _EOtypeGroupe.LOG.debug("removing " + object + " from toRepartTypeGroupes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRepartTypeGroupes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOtypeGroupe.TO_REPART_TYPE_GROUPES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EORepartTypeGroupe createToRepartTypeGroupesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EORepartTypeGroupe.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOtypeGroupe.TO_REPART_TYPE_GROUPES_KEY);
    return (utt.rec.projet.server.metier.grhum.EORepartTypeGroupe) eo;
  }

  public void deleteToRepartTypeGroupesRelationship(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOtypeGroupe.TO_REPART_TYPE_GROUPES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRepartTypeGroupesRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> objects = toRepartTypeGroupes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRepartTypeGroupesRelationship(objects.nextElement());
    }
  }


  public static EOtypeGroupe createEOtypeGroupe(EOEditingContext editingContext, NSTimestamp dCreation
, NSTimestamp dModification
, String tgrpLibelle
, String tgrpTemUtil
, String tgrpTemWeb
) {
    EOtypeGroupe eo = (EOtypeGroupe) EOUtilities.createAndInsertInstance(editingContext, _EOtypeGroupe.ENTITY_NAME);    
		eo.setDCreation(dCreation);
		eo.setDModification(dModification);
		eo.setTgrpLibelle(tgrpLibelle);
		eo.setTgrpTemUtil(tgrpTemUtil);
		eo.setTgrpTemWeb(tgrpTemWeb);
    return eo;
  }

  public static ERXFetchSpecification<EOtypeGroupe> fetchSpec() {
    return new ERXFetchSpecification<EOtypeGroupe>(_EOtypeGroupe.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOtypeGroupe> fetchAllEOtypeGroupes(EOEditingContext editingContext) {
    return _EOtypeGroupe.fetchAllEOtypeGroupes(editingContext, null);
  }

  public static NSArray<EOtypeGroupe> fetchAllEOtypeGroupes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOtypeGroupe.fetchEOtypeGroupes(editingContext, null, sortOrderings);
  }

  public static NSArray<EOtypeGroupe> fetchEOtypeGroupes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOtypeGroupe> fetchSpec = new ERXFetchSpecification<EOtypeGroupe>(_EOtypeGroupe.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOtypeGroupe> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOtypeGroupe fetchEOtypeGroupe(EOEditingContext editingContext, String keyName, Object value) {
    return _EOtypeGroupe.fetchEOtypeGroupe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOtypeGroupe fetchEOtypeGroupe(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOtypeGroupe> eoObjects = _EOtypeGroupe.fetchEOtypeGroupes(editingContext, qualifier, null);
    EOtypeGroupe eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOtypeGroupe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOtypeGroupe fetchRequiredEOtypeGroupe(EOEditingContext editingContext, String keyName, Object value) {
    return _EOtypeGroupe.fetchRequiredEOtypeGroupe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOtypeGroupe fetchRequiredEOtypeGroupe(EOEditingContext editingContext, EOQualifier qualifier) {
    EOtypeGroupe eoObject = _EOtypeGroupe.fetchEOtypeGroupe(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOtypeGroupe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOtypeGroupe localInstanceIn(EOEditingContext editingContext, EOtypeGroupe eo) {
    EOtypeGroupe localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
