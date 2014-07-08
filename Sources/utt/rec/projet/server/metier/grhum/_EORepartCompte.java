// DO NOT EDIT.  Make changes to EORepartCompte.java instead.
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
public abstract class _EORepartCompte extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EORepartCompte";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOCompte> TO_COMPTES = new ERXKey<utt.rec.projet.server.metier.grhum.EOCompte>("toComptes");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne> TO_PERSONNES = new ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne>("toPersonnes");

  // Attributes
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  // Relationships
  public static final String TO_COMPTES_KEY = TO_COMPTES.key();
  public static final String TO_PERSONNES_KEY = TO_PERSONNES.key();

  private static Logger LOG = Logger.getLogger(_EORepartCompte.class);

  public EORepartCompte localInstanceIn(EOEditingContext editingContext) {
    EORepartCompte localInstance = (EORepartCompte)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EORepartCompte.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EORepartCompte.LOG.isDebugEnabled()) {
    	_EORepartCompte.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartCompte.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EORepartCompte.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EORepartCompte.LOG.isDebugEnabled()) {
    	_EORepartCompte.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartCompte.D_MODIFICATION_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOCompte> toComptes() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOCompte>)storedValueForKey(_EORepartCompte.TO_COMPTES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOCompte> toComptes(EOQualifier qualifier) {
    return toComptes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOCompte> toComptes(EOQualifier qualifier, boolean fetch) {
    return toComptes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOCompte> toComptes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EOCompte> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOCompte.TO_REPART_COMPTE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EOCompte.fetchEOComptes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toComptes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOCompte>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOCompte>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToComptes(utt.rec.projet.server.metier.grhum.EOCompte object) {
    includeObjectIntoPropertyWithKey(object, _EORepartCompte.TO_COMPTES_KEY);
  }

  public void removeFromToComptes(utt.rec.projet.server.metier.grhum.EOCompte object) {
    excludeObjectFromPropertyWithKey(object, _EORepartCompte.TO_COMPTES_KEY);
  }

  public void addToToComptesRelationship(utt.rec.projet.server.metier.grhum.EOCompte object) {
    if (_EORepartCompte.LOG.isDebugEnabled()) {
      _EORepartCompte.LOG.debug("adding " + object + " to toComptes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToComptes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EORepartCompte.TO_COMPTES_KEY);
    }
  }

  public void removeFromToComptesRelationship(utt.rec.projet.server.metier.grhum.EOCompte object) {
    if (_EORepartCompte.LOG.isDebugEnabled()) {
      _EORepartCompte.LOG.debug("removing " + object + " from toComptes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToComptes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EORepartCompte.TO_COMPTES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOCompte createToComptesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOCompte.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EORepartCompte.TO_COMPTES_KEY);
    return (utt.rec.projet.server.metier.grhum.EOCompte) eo;
  }

  public void deleteToComptesRelationship(utt.rec.projet.server.metier.grhum.EOCompte object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EORepartCompte.TO_COMPTES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToComptesRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOCompte> objects = toComptes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToComptesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonne> toPersonnes() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOPersonne>)storedValueForKey(_EORepartCompte.TO_PERSONNES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonne> toPersonnes(EOQualifier qualifier) {
    return toPersonnes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonne> toPersonnes(EOQualifier qualifier, boolean fetch) {
    return toPersonnes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonne> toPersonnes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EOPersonne> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOPersonne.TO_REPART_COMPTE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EOPersonne.fetchEOPersonnes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toPersonnes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOPersonne>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOPersonne>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToPersonnes(utt.rec.projet.server.metier.grhum.EOPersonne object) {
    includeObjectIntoPropertyWithKey(object, _EORepartCompte.TO_PERSONNES_KEY);
  }

  public void removeFromToPersonnes(utt.rec.projet.server.metier.grhum.EOPersonne object) {
    excludeObjectFromPropertyWithKey(object, _EORepartCompte.TO_PERSONNES_KEY);
  }

  public void addToToPersonnesRelationship(utt.rec.projet.server.metier.grhum.EOPersonne object) {
    if (_EORepartCompte.LOG.isDebugEnabled()) {
      _EORepartCompte.LOG.debug("adding " + object + " to toPersonnes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToPersonnes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EORepartCompte.TO_PERSONNES_KEY);
    }
  }

  public void removeFromToPersonnesRelationship(utt.rec.projet.server.metier.grhum.EOPersonne object) {
    if (_EORepartCompte.LOG.isDebugEnabled()) {
      _EORepartCompte.LOG.debug("removing " + object + " from toPersonnes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToPersonnes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EORepartCompte.TO_PERSONNES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOPersonne createToPersonnesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOPersonne.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EORepartCompte.TO_PERSONNES_KEY);
    return (utt.rec.projet.server.metier.grhum.EOPersonne) eo;
  }

  public void deleteToPersonnesRelationship(utt.rec.projet.server.metier.grhum.EOPersonne object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EORepartCompte.TO_PERSONNES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToPersonnesRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOPersonne> objects = toPersonnes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToPersonnesRelationship(objects.nextElement());
    }
  }


  public static EORepartCompte createEORepartCompte(EOEditingContext editingContext, NSTimestamp dCreation
, NSTimestamp dModification
) {
    EORepartCompte eo = (EORepartCompte) EOUtilities.createAndInsertInstance(editingContext, _EORepartCompte.ENTITY_NAME);    
		eo.setDCreation(dCreation);
		eo.setDModification(dModification);
    return eo;
  }

  public static ERXFetchSpecification<EORepartCompte> fetchSpec() {
    return new ERXFetchSpecification<EORepartCompte>(_EORepartCompte.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EORepartCompte> fetchAllEORepartComptes(EOEditingContext editingContext) {
    return _EORepartCompte.fetchAllEORepartComptes(editingContext, null);
  }

  public static NSArray<EORepartCompte> fetchAllEORepartComptes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EORepartCompte.fetchEORepartComptes(editingContext, null, sortOrderings);
  }

  public static NSArray<EORepartCompte> fetchEORepartComptes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EORepartCompte> fetchSpec = new ERXFetchSpecification<EORepartCompte>(_EORepartCompte.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EORepartCompte> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EORepartCompte fetchEORepartCompte(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartCompte.fetchEORepartCompte(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartCompte fetchEORepartCompte(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EORepartCompte> eoObjects = _EORepartCompte.fetchEORepartComptes(editingContext, qualifier, null);
    EORepartCompte eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EORepartCompte that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartCompte fetchRequiredEORepartCompte(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartCompte.fetchRequiredEORepartCompte(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartCompte fetchRequiredEORepartCompte(EOEditingContext editingContext, EOQualifier qualifier) {
    EORepartCompte eoObject = _EORepartCompte.fetchEORepartCompte(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EORepartCompte that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartCompte localInstanceIn(EOEditingContext editingContext, EORepartCompte eo) {
    EORepartCompte localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
