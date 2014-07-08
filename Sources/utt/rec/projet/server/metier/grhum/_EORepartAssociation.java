// DO NOT EDIT.  Make changes to EORepartAssociation.java instead.
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
public abstract class _EORepartAssociation extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EORepartAssociation";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<Integer> PERS_ID = new ERXKey<Integer>("persId");
  public static final ERXKey<Integer> PERS_ID_CREATION = new ERXKey<Integer>("persIdCreation");
  public static final ERXKey<Integer> PERS_ID_MODIFICATION = new ERXKey<Integer>("persIdModification");
  public static final ERXKey<String> RAS_COMMENTAIRE = new ERXKey<String>("rasCommentaire");
  public static final ERXKey<NSTimestamp> RAS_D_FERMETURE = new ERXKey<NSTimestamp>("rasDFermeture");
  public static final ERXKey<NSTimestamp> RAS_D_OUVERTURE = new ERXKey<NSTimestamp>("rasDOuverture");
  public static final ERXKey<java.math.BigDecimal> RAS_QUOTITE = new ERXKey<java.math.BigDecimal>("rasQuotite");
  public static final ERXKey<Integer> RAS_RANG = new ERXKey<Integer>("rasRang");
  // Relationship Keys
  public static final ERXKey<org.cocktail.fwkcktlpersonne.common.metier.EOAssociation> TO_ASSOCIATION = new ERXKey<org.cocktail.fwkcktlpersonne.common.metier.EOAssociation>("toAssociation");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne> TO_PERSONNE = new ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne>("toPersonne");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURE = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructure");

  // Attributes
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String PERS_ID_KEY = PERS_ID.key();
  public static final String PERS_ID_CREATION_KEY = PERS_ID_CREATION.key();
  public static final String PERS_ID_MODIFICATION_KEY = PERS_ID_MODIFICATION.key();
  public static final String RAS_COMMENTAIRE_KEY = RAS_COMMENTAIRE.key();
  public static final String RAS_D_FERMETURE_KEY = RAS_D_FERMETURE.key();
  public static final String RAS_D_OUVERTURE_KEY = RAS_D_OUVERTURE.key();
  public static final String RAS_QUOTITE_KEY = RAS_QUOTITE.key();
  public static final String RAS_RANG_KEY = RAS_RANG.key();
  // Relationships
  public static final String TO_ASSOCIATION_KEY = TO_ASSOCIATION.key();
  public static final String TO_PERSONNE_KEY = TO_PERSONNE.key();
  public static final String TO_STRUCTURE_KEY = TO_STRUCTURE.key();

  private static Logger LOG = Logger.getLogger(_EORepartAssociation.class);

  public EORepartAssociation localInstanceIn(EOEditingContext editingContext) {
    EORepartAssociation localInstance = (EORepartAssociation)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EORepartAssociation.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EORepartAssociation.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.D_MODIFICATION_KEY);
  }

  public Integer persId() {
    return (Integer) storedValueForKey(_EORepartAssociation.PERS_ID_KEY);
  }

  public void setPersId(Integer value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating persId from " + persId() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.PERS_ID_KEY);
  }

  public Integer persIdCreation() {
    return (Integer) storedValueForKey(_EORepartAssociation.PERS_ID_CREATION_KEY);
  }

  public void setPersIdCreation(Integer value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating persIdCreation from " + persIdCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.PERS_ID_CREATION_KEY);
  }

  public Integer persIdModification() {
    return (Integer) storedValueForKey(_EORepartAssociation.PERS_ID_MODIFICATION_KEY);
  }

  public void setPersIdModification(Integer value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating persIdModification from " + persIdModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.PERS_ID_MODIFICATION_KEY);
  }

  public String rasCommentaire() {
    return (String) storedValueForKey(_EORepartAssociation.RAS_COMMENTAIRE_KEY);
  }

  public void setRasCommentaire(String value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating rasCommentaire from " + rasCommentaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.RAS_COMMENTAIRE_KEY);
  }

  public NSTimestamp rasDFermeture() {
    return (NSTimestamp) storedValueForKey(_EORepartAssociation.RAS_D_FERMETURE_KEY);
  }

  public void setRasDFermeture(NSTimestamp value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating rasDFermeture from " + rasDFermeture() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.RAS_D_FERMETURE_KEY);
  }

  public NSTimestamp rasDOuverture() {
    return (NSTimestamp) storedValueForKey(_EORepartAssociation.RAS_D_OUVERTURE_KEY);
  }

  public void setRasDOuverture(NSTimestamp value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating rasDOuverture from " + rasDOuverture() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.RAS_D_OUVERTURE_KEY);
  }

  public java.math.BigDecimal rasQuotite() {
    return (java.math.BigDecimal) storedValueForKey(_EORepartAssociation.RAS_QUOTITE_KEY);
  }

  public void setRasQuotite(java.math.BigDecimal value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating rasQuotite from " + rasQuotite() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.RAS_QUOTITE_KEY);
  }

  public Integer rasRang() {
    return (Integer) storedValueForKey(_EORepartAssociation.RAS_RANG_KEY);
  }

  public void setRasRang(Integer value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
    	_EORepartAssociation.LOG.debug( "updating rasRang from " + rasRang() + " to " + value);
    }
    takeStoredValueForKey(value, _EORepartAssociation.RAS_RANG_KEY);
  }

  public org.cocktail.fwkcktlpersonne.common.metier.EOAssociation toAssociation() {
    return (org.cocktail.fwkcktlpersonne.common.metier.EOAssociation)storedValueForKey(_EORepartAssociation.TO_ASSOCIATION_KEY);
  }
  
  public void setToAssociation(org.cocktail.fwkcktlpersonne.common.metier.EOAssociation value) {
    takeStoredValueForKey(value, _EORepartAssociation.TO_ASSOCIATION_KEY);
  }

  public void setToAssociationRelationship(org.cocktail.fwkcktlpersonne.common.metier.EOAssociation value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
      _EORepartAssociation.LOG.debug("updating toAssociation from " + toAssociation() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToAssociation(value);
    }
    else if (value == null) {
    	org.cocktail.fwkcktlpersonne.common.metier.EOAssociation oldValue = toAssociation();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartAssociation.TO_ASSOCIATION_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartAssociation.TO_ASSOCIATION_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOPersonne toPersonne() {
    return (utt.rec.projet.server.metier.grhum.EOPersonne)storedValueForKey(_EORepartAssociation.TO_PERSONNE_KEY);
  }
  
  public void setToPersonne(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    takeStoredValueForKey(value, _EORepartAssociation.TO_PERSONNE_KEY);
  }

  public void setToPersonneRelationship(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
      _EORepartAssociation.LOG.debug("updating toPersonne from " + toPersonne() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPersonne(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOPersonne oldValue = toPersonne();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartAssociation.TO_PERSONNE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartAssociation.TO_PERSONNE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure() {
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr)storedValueForKey(_EORepartAssociation.TO_STRUCTURE_KEY);
  }
  
  public void setToStructure(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    takeStoredValueForKey(value, _EORepartAssociation.TO_STRUCTURE_KEY);
  }

  public void setToStructureRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    if (_EORepartAssociation.LOG.isDebugEnabled()) {
      _EORepartAssociation.LOG.debug("updating toStructure from " + toStructure() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStructure(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOStructureUlr oldValue = toStructure();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EORepartAssociation.TO_STRUCTURE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EORepartAssociation.TO_STRUCTURE_KEY);
    }
  }
  

  public static EORepartAssociation createEORepartAssociation(EOEditingContext editingContext, Integer persId
, Integer rasRang
, org.cocktail.fwkcktlpersonne.common.metier.EOAssociation toAssociation, utt.rec.projet.server.metier.grhum.EOPersonne toPersonne, utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure) {
    EORepartAssociation eo = (EORepartAssociation) EOUtilities.createAndInsertInstance(editingContext, _EORepartAssociation.ENTITY_NAME);    
		eo.setPersId(persId);
		eo.setRasRang(rasRang);
    eo.setToAssociationRelationship(toAssociation);
    eo.setToPersonneRelationship(toPersonne);
    eo.setToStructureRelationship(toStructure);
    return eo;
  }

  public static ERXFetchSpecification<EORepartAssociation> fetchSpec() {
    return new ERXFetchSpecification<EORepartAssociation>(_EORepartAssociation.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EORepartAssociation> fetchAllEORepartAssociations(EOEditingContext editingContext) {
    return _EORepartAssociation.fetchAllEORepartAssociations(editingContext, null);
  }

  public static NSArray<EORepartAssociation> fetchAllEORepartAssociations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EORepartAssociation.fetchEORepartAssociations(editingContext, null, sortOrderings);
  }

  public static NSArray<EORepartAssociation> fetchEORepartAssociations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EORepartAssociation> fetchSpec = new ERXFetchSpecification<EORepartAssociation>(_EORepartAssociation.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EORepartAssociation> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EORepartAssociation fetchEORepartAssociation(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartAssociation.fetchEORepartAssociation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartAssociation fetchEORepartAssociation(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EORepartAssociation> eoObjects = _EORepartAssociation.fetchEORepartAssociations(editingContext, qualifier, null);
    EORepartAssociation eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EORepartAssociation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartAssociation fetchRequiredEORepartAssociation(EOEditingContext editingContext, String keyName, Object value) {
    return _EORepartAssociation.fetchRequiredEORepartAssociation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORepartAssociation fetchRequiredEORepartAssociation(EOEditingContext editingContext, EOQualifier qualifier) {
    EORepartAssociation eoObject = _EORepartAssociation.fetchEORepartAssociation(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EORepartAssociation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORepartAssociation localInstanceIn(EOEditingContext editingContext, EORepartAssociation eo) {
    EORepartAssociation localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> fetchLesER(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("LesER", _EORepartAssociation.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> fetchLesER(EOEditingContext editingContext,
	NSTimestamp rasDFermetureBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("LesER", _EORepartAssociation.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(rasDFermetureBinding, "rasDFermeture");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
