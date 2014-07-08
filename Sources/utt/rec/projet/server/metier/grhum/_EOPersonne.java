// DO NOT EDIT.  Make changes to EOPersonne.java instead.
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
public abstract class _EOPersonne extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOPersonne";

  // Attribute Keys
  public static final ERXKey<Integer> PERS_ID = new ERXKey<Integer>("persId");
  public static final ERXKey<String> PERS_LC = new ERXKey<String>("persLc");
  public static final ERXKey<String> PERS_LIBELLE = new ERXKey<String>("persLibelle");
  public static final ERXKey<String> PERS_NOMPTR = new ERXKey<String>("persNomptr");
  public static final ERXKey<java.math.BigDecimal> PERS_ORDRE = new ERXKey<java.math.BigDecimal>("persOrdre");
  public static final ERXKey<String> PERS_TYPE = new ERXKey<String>("persType");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOCompte> TO_COMPTES = new ERXKey<utt.rec.projet.server.metier.grhum.EOCompte>("toComptes");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr> TO_INDIVIDUS = new ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr>("toIndividus");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartAssociation> TO_REPART_ASSOCIATIONS = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartAssociation>("toRepartAssociations");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartCompte> TO_REPART_COMPTE = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartCompte>("toRepartCompte");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartStructure> TO_REPART_STRUCTURES = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartStructure>("toRepartStructures");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURES = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructures");

  // Attributes
  public static final String PERS_ID_KEY = PERS_ID.key();
  public static final String PERS_LC_KEY = PERS_LC.key();
  public static final String PERS_LIBELLE_KEY = PERS_LIBELLE.key();
  public static final String PERS_NOMPTR_KEY = PERS_NOMPTR.key();
  public static final String PERS_ORDRE_KEY = PERS_ORDRE.key();
  public static final String PERS_TYPE_KEY = PERS_TYPE.key();
  // Relationships
  public static final String TO_COMPTES_KEY = TO_COMPTES.key();
  public static final String TO_INDIVIDUS_KEY = TO_INDIVIDUS.key();
  public static final String TO_REPART_ASSOCIATIONS_KEY = TO_REPART_ASSOCIATIONS.key();
  public static final String TO_REPART_COMPTE_KEY = TO_REPART_COMPTE.key();
  public static final String TO_REPART_STRUCTURES_KEY = TO_REPART_STRUCTURES.key();
  public static final String TO_STRUCTURES_KEY = TO_STRUCTURES.key();

  private static Logger LOG = Logger.getLogger(_EOPersonne.class);

  public EOPersonne localInstanceIn(EOEditingContext editingContext) {
    EOPersonne localInstance = (EOPersonne)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer persId() {
    return (Integer) storedValueForKey(_EOPersonne.PERS_ID_KEY);
  }

  public void setPersId(Integer value) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
    	_EOPersonne.LOG.debug( "updating persId from " + persId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonne.PERS_ID_KEY);
  }

  public String persLc() {
    return (String) storedValueForKey(_EOPersonne.PERS_LC_KEY);
  }

  public void setPersLc(String value) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
    	_EOPersonne.LOG.debug( "updating persLc from " + persLc() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonne.PERS_LC_KEY);
  }

  public String persLibelle() {
    return (String) storedValueForKey(_EOPersonne.PERS_LIBELLE_KEY);
  }

  public void setPersLibelle(String value) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
    	_EOPersonne.LOG.debug( "updating persLibelle from " + persLibelle() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonne.PERS_LIBELLE_KEY);
  }

  public String persNomptr() {
    return (String) storedValueForKey(_EOPersonne.PERS_NOMPTR_KEY);
  }

  public void setPersNomptr(String value) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
    	_EOPersonne.LOG.debug( "updating persNomptr from " + persNomptr() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonne.PERS_NOMPTR_KEY);
  }

  public java.math.BigDecimal persOrdre() {
    return (java.math.BigDecimal) storedValueForKey(_EOPersonne.PERS_ORDRE_KEY);
  }

  public void setPersOrdre(java.math.BigDecimal value) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
    	_EOPersonne.LOG.debug( "updating persOrdre from " + persOrdre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonne.PERS_ORDRE_KEY);
  }

  public String persType() {
    return (String) storedValueForKey(_EOPersonne.PERS_TYPE_KEY);
  }

  public void setPersType(String value) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
    	_EOPersonne.LOG.debug( "updating persType from " + persType() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonne.PERS_TYPE_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EORepartCompte toRepartCompte() {
    return (utt.rec.projet.server.metier.grhum.EORepartCompte)storedValueForKey(_EOPersonne.TO_REPART_COMPTE_KEY);
  }
  
  public void setToRepartCompte(utt.rec.projet.server.metier.grhum.EORepartCompte value) {
    takeStoredValueForKey(value, _EOPersonne.TO_REPART_COMPTE_KEY);
  }

  public void setToRepartCompteRelationship(utt.rec.projet.server.metier.grhum.EORepartCompte value) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("updating toRepartCompte from " + toRepartCompte() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToRepartCompte(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EORepartCompte oldValue = toRepartCompte();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPersonne.TO_REPART_COMPTE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPersonne.TO_REPART_COMPTE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.grhum.EOCompte> toComptes() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOCompte>)storedValueForKey(_EOPersonne.TO_COMPTES_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOCompte.TO_PERSONNE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EOPersonne.TO_COMPTES_KEY);
  }

  public void removeFromToComptes(utt.rec.projet.server.metier.grhum.EOCompte object) {
    excludeObjectFromPropertyWithKey(object, _EOPersonne.TO_COMPTES_KEY);
  }

  public void addToToComptesRelationship(utt.rec.projet.server.metier.grhum.EOCompte object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("adding " + object + " to toComptes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToComptes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_COMPTES_KEY);
    }
  }

  public void removeFromToComptesRelationship(utt.rec.projet.server.metier.grhum.EOCompte object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("removing " + object + " from toComptes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToComptes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_COMPTES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOCompte createToComptesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOCompte.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPersonne.TO_COMPTES_KEY);
    return (utt.rec.projet.server.metier.grhum.EOCompte) eo;
  }

  public void deleteToComptesRelationship(utt.rec.projet.server.metier.grhum.EOCompte object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_COMPTES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToComptesRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOCompte> objects = toComptes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToComptesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> toIndividus() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)storedValueForKey(_EOPersonne.TO_INDIVIDUS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> toIndividus(EOQualifier qualifier) {
    return toIndividus(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> toIndividus(EOQualifier qualifier, boolean fetch) {
    return toIndividus(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> toIndividus(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOIndividuUlr.TO_PERSONNE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EOIndividuUlr.fetchEOIndividuUlrs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toIndividus();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToIndividus(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    includeObjectIntoPropertyWithKey(object, _EOPersonne.TO_INDIVIDUS_KEY);
  }

  public void removeFromToIndividus(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    excludeObjectFromPropertyWithKey(object, _EOPersonne.TO_INDIVIDUS_KEY);
  }

  public void addToToIndividusRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("adding " + object + " to toIndividus relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToIndividus(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_INDIVIDUS_KEY);
    }
  }

  public void removeFromToIndividusRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("removing " + object + " from toIndividus relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToIndividus(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_INDIVIDUS_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOIndividuUlr createToIndividusRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOIndividuUlr.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPersonne.TO_INDIVIDUS_KEY);
    return (utt.rec.projet.server.metier.grhum.EOIndividuUlr) eo;
  }

  public void deleteToIndividusRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_INDIVIDUS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToIndividusRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOIndividuUlr> objects = toIndividus().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToIndividusRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)storedValueForKey(_EOPersonne.TO_REPART_ASSOCIATIONS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations(EOQualifier qualifier) {
    return toRepartAssociations(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations(EOQualifier qualifier, boolean fetch) {
    return toRepartAssociations(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EORepartAssociation.TO_PERSONNE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EORepartAssociation.fetchEORepartAssociations(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toRepartAssociations();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToRepartAssociations(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    includeObjectIntoPropertyWithKey(object, _EOPersonne.TO_REPART_ASSOCIATIONS_KEY);
  }

  public void removeFromToRepartAssociations(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    excludeObjectFromPropertyWithKey(object, _EOPersonne.TO_REPART_ASSOCIATIONS_KEY);
  }

  public void addToToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("adding " + object + " to toRepartAssociations relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRepartAssociations(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_REPART_ASSOCIATIONS_KEY);
    }
  }

  public void removeFromToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("removing " + object + " from toRepartAssociations relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRepartAssociations(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_REPART_ASSOCIATIONS_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EORepartAssociation createToRepartAssociationsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EORepartAssociation.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPersonne.TO_REPART_ASSOCIATIONS_KEY);
    return (utt.rec.projet.server.metier.grhum.EORepartAssociation) eo;
  }

  public void deleteToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_REPART_ASSOCIATIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRepartAssociationsRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EORepartAssociation> objects = toRepartAssociations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRepartAssociationsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)storedValueForKey(_EOPersonne.TO_REPART_STRUCTURES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures(EOQualifier qualifier) {
    return toRepartStructures(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures(EOQualifier qualifier, boolean fetch) {
    return toRepartStructures(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EORepartStructure.TO_PERSONNE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EORepartStructure.fetchEORepartStructures(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toRepartStructures();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToRepartStructures(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    includeObjectIntoPropertyWithKey(object, _EOPersonne.TO_REPART_STRUCTURES_KEY);
  }

  public void removeFromToRepartStructures(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    excludeObjectFromPropertyWithKey(object, _EOPersonne.TO_REPART_STRUCTURES_KEY);
  }

  public void addToToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("adding " + object + " to toRepartStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRepartStructures(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_REPART_STRUCTURES_KEY);
    }
  }

  public void removeFromToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("removing " + object + " from toRepartStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRepartStructures(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_REPART_STRUCTURES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EORepartStructure createToRepartStructuresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EORepartStructure.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPersonne.TO_REPART_STRUCTURES_KEY);
    return (utt.rec.projet.server.metier.grhum.EORepartStructure) eo;
  }

  public void deleteToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_REPART_STRUCTURES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRepartStructuresRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EORepartStructure> objects = toRepartStructures().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRepartStructuresRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)storedValueForKey(_EOPersonne.TO_STRUCTURES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures(EOQualifier qualifier) {
    return toStructures(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures(EOQualifier qualifier, boolean fetch) {
    return toStructures(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOStructureUlr.TO_PERSONNE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EOStructureUlr.fetchEOStructureUlrs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toStructures();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToStructures(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    includeObjectIntoPropertyWithKey(object, _EOPersonne.TO_STRUCTURES_KEY);
  }

  public void removeFromToStructures(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    excludeObjectFromPropertyWithKey(object, _EOPersonne.TO_STRUCTURES_KEY);
  }

  public void addToToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("adding " + object + " to toStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToStructures(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_STRUCTURES_KEY);
    }
  }

  public void removeFromToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    if (_EOPersonne.LOG.isDebugEnabled()) {
      _EOPersonne.LOG.debug("removing " + object + " from toStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToStructures(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_STRUCTURES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOStructureUlr createToStructuresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOStructureUlr.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPersonne.TO_STRUCTURES_KEY);
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr) eo;
  }

  public void deleteToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPersonne.TO_STRUCTURES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToStructuresRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOStructureUlr> objects = toStructures().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToStructuresRelationship(objects.nextElement());
    }
  }


  public static EOPersonne createEOPersonne(EOEditingContext editingContext, Integer persId
, String persLibelle
, java.math.BigDecimal persOrdre
, String persType
, utt.rec.projet.server.metier.grhum.EORepartCompte toRepartCompte) {
    EOPersonne eo = (EOPersonne) EOUtilities.createAndInsertInstance(editingContext, _EOPersonne.ENTITY_NAME);    
		eo.setPersId(persId);
		eo.setPersLibelle(persLibelle);
		eo.setPersOrdre(persOrdre);
		eo.setPersType(persType);
    eo.setToRepartCompteRelationship(toRepartCompte);
    return eo;
  }

  public static ERXFetchSpecification<EOPersonne> fetchSpec() {
    return new ERXFetchSpecification<EOPersonne>(_EOPersonne.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOPersonne> fetchAllEOPersonnes(EOEditingContext editingContext) {
    return _EOPersonne.fetchAllEOPersonnes(editingContext, null);
  }

  public static NSArray<EOPersonne> fetchAllEOPersonnes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOPersonne.fetchEOPersonnes(editingContext, null, sortOrderings);
  }

  public static NSArray<EOPersonne> fetchEOPersonnes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOPersonne> fetchSpec = new ERXFetchSpecification<EOPersonne>(_EOPersonne.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOPersonne> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOPersonne fetchEOPersonne(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPersonne.fetchEOPersonne(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPersonne fetchEOPersonne(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOPersonne> eoObjects = _EOPersonne.fetchEOPersonnes(editingContext, qualifier, null);
    EOPersonne eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOPersonne that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPersonne fetchRequiredEOPersonne(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPersonne.fetchRequiredEOPersonne(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPersonne fetchRequiredEOPersonne(EOEditingContext editingContext, EOQualifier qualifier) {
    EOPersonne eoObject = _EOPersonne.fetchEOPersonne(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOPersonne that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPersonne localInstanceIn(EOEditingContext editingContext, EOPersonne eo) {
    EOPersonne localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
