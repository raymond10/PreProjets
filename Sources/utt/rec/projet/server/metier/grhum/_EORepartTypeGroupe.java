// DO NOT EDIT.  Make changes to EORepartTypeGroupe.java instead.
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
public abstract class _EORepartTypeGroupe extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EORepartTypeGroupe";

  // Attribute Keys
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<Integer> PERS_ID_CREATION = new ERXKey<Integer>("persIdCreation");
  public static final ERXKey<Integer> PERS_ID_MODIFICATION = new ERXKey<Integer>("persIdModification");
  public static final ERXKey<String> TGRP_CODE = new ERXKey<String>("tgrpCode");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURE = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructure");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOtypeGroupe> TO_TYPE_GROUPE = new ERXKey<utt.rec.projet.server.metier.grhum.EOtypeGroupe>("toTypeGroupe");

  // Attributes
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String PERS_ID_CREATION_KEY = PERS_ID_CREATION.key();
  public static final String PERS_ID_MODIFICATION_KEY = PERS_ID_MODIFICATION.key();
  public static final String TGRP_CODE_KEY = TGRP_CODE.key();
  // Relationships
  public static final String TO_STRUCTURE_KEY = TO_STRUCTURE.key();
  public static final String TO_TYPE_GROUPE_KEY = TO_TYPE_GROUPE.key();

  private static Logger LOG = Logger.getLogger(_EORepartTypeGroupe.class);

  public EORepartTypeGroupe localInstanceIn(EOEditingContext editingContext) {
    EORepartTypeGroupe localInstance = (EORepartTypeGroupe)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cStructure() {
    return (String) storedValueForKey(_EORepartTypeGroupe.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EORepartTypeGroupe.LOG.isDebugEnabled()) {
    	_EORepartTypeGroupe.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartTypeGroupe.C_STRUCTURE_KEY);
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EORepartTypeGroupe.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EORepartTypeGroupe.LOG.isDebugEnabled()) {
    	_EORepartTypeGroupe.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartTypeGroupe.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EORepartTypeGroupe.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EORepartTypeGroupe.LOG.isDebugEnabled()) {
    	_EORepartTypeGroupe.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartTypeGroupe.D_MODIFICATION_KEY);
  }

  public Integer persIdCreation() {
    return (Integer) storedValueForKey(_EORepartTypeGroupe.PERS_ID_CREATION_KEY);
  }

  public void setPersIdCreation(Integer value) {
    if (_EORepartTypeGroupe.LOG.isDebugEnabled()) {
    	_EORepartTypeGroupe.LOG.debug( "updating persIdCreation from " + persIdCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartTypeGroupe.PERS_ID_CREATION_KEY);
  }

  public Integer persIdModification() {
    return (Integer) storedValueForKey(_EORepartTypeGroupe.PERS_ID_MODIFICATION_KEY);
  }

  public void setPersIdModification(Integer value) {
    if (_EORepartTypeGroupe.LOG.isDebugEnabled()) {
    	_EORepartTypeGroupe.LOG.debug( "updating persIdModification from " + persIdModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartTypeGroupe.PERS_ID_MODIFICATION_KEY);
  }

  public String tgrpCode() {
    return (String) storedValueForKey(_EORepartTypeGroupe.TGRP_CODE_KEY);
  }

  public void setTgrpCode(String value) {
    if (_EORepartTypeGroupe.LOG.isDebugEnabled()) {
    	_EORepartTypeGroupe.LOG.debug( "updating tgrpCode from " + tgrpCode() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartTypeGroupe.TGRP_CODE_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure() {
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr)storedValueForKey(_EORepartTypeGroupe.TO_STRUCTURE_KEY);
  }
  
  public void setToStructure(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    takeStoredValueForKey(value, _EORepartTypeGroupe.TO_STRUCTURE_KEY);
  }

  public void setToStructureRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    if (_EORepartTypeGroupe.LOG.isDebugEnabled()) {
      _EORepartTypeGroupe.LOG.debug("updating toStructure from " + toStructure() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStructure(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOStructureUlr oldValue = toStructure();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartTypeGroupe.TO_STRUCTURE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartTypeGroupe.TO_STRUCTURE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOtypeGroupe toTypeGroupe() {
    return (utt.rec.projet.server.metier.grhum.EOtypeGroupe)storedValueForKey(_EORepartTypeGroupe.TO_TYPE_GROUPE_KEY);
  }
  
  public void setToTypeGroupe(utt.rec.projet.server.metier.grhum.EOtypeGroupe value) {
    takeStoredValueForKey(value, _EORepartTypeGroupe.TO_TYPE_GROUPE_KEY);
  }

  public void setToTypeGroupeRelationship(utt.rec.projet.server.metier.grhum.EOtypeGroupe value) {
    if (_EORepartTypeGroupe.LOG.isDebugEnabled()) {
      _EORepartTypeGroupe.LOG.debug("updating toTypeGroupe from " + toTypeGroupe() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToTypeGroupe(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOtypeGroupe oldValue = toTypeGroupe();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartTypeGroupe.TO_TYPE_GROUPE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartTypeGroupe.TO_TYPE_GROUPE_KEY);
    }
  }
  

  public static EORepartTypeGroupe createEORepartTypeGroupe(EOEditingContext editingContext, String cStructure
, NSTimestamp dCreation
, NSTimestamp dModification
, String tgrpCode
, utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure, utt.rec.projet.server.metier.grhum.EOtypeGroupe toTypeGroupe) {
    EORepartTypeGroupe eo = (EORepartTypeGroupe) EOUtilities.createAndInsertInstance(editingContext, _EORepartTypeGroupe.ENTITY_NAME);    
		eo.setCStructure(cStructure);
		eo.setDCreation(dCreation);
		eo.setDModification(dModification);
		eo.setTgrpCode(tgrpCode);
    eo.setToStructureRelationship(toStructure);
    eo.setToTypeGroupeRelationship(toTypeGroupe);
    return eo;
  }

  public static ERXFetchSpecification<EORepartTypeGroupe> fetchSpec() {
    return new ERXFetchSpecification<EORepartTypeGroupe>(_EORepartTypeGroupe.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EORepartTypeGroupe> fetchAllEORepartTypeGroupes(EOEditingContext editingContext) {
    return _EORepartTypeGroupe.fetchAllEORepartTypeGroupes(editingContext, null);
  }

  public static NSArray<EORepartTypeGroupe> fetchAllEORepartTypeGroupes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EORepartTypeGroupe.fetchEORepartTypeGroupes(editingContext, null, sortOrderings);
  }

  public static NSArray<EORepartTypeGroupe> fetchEORepartTypeGroupes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EORepartTypeGroupe> fetchSpec = new ERXFetchSpecification<EORepartTypeGroupe>(_EORepartTypeGroupe.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EORepartTypeGroupe> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EORepartTypeGroupe fetchEORepartTypeGroupe(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartTypeGroupe.fetchEORepartTypeGroupe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartTypeGroupe fetchEORepartTypeGroupe(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EORepartTypeGroupe> eoObjects = _EORepartTypeGroupe.fetchEORepartTypeGroupes(editingContext, qualifier, null);
    EORepartTypeGroupe eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EORepartTypeGroupe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartTypeGroupe fetchRequiredEORepartTypeGroupe(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartTypeGroupe.fetchRequiredEORepartTypeGroupe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartTypeGroupe fetchRequiredEORepartTypeGroupe(EOEditingContext editingContext, EOQualifier qualifier) {
    EORepartTypeGroupe eoObject = _EORepartTypeGroupe.fetchEORepartTypeGroupe(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EORepartTypeGroupe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartTypeGroupe localInstanceIn(EOEditingContext editingContext, EORepartTypeGroupe eo) {
    EORepartTypeGroupe localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
