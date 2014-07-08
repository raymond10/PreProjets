// DO NOT EDIT.  Make changes to EOVresponsableEquipeRecherche.java instead.
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
public abstract class _EOVresponsableEquipeRecherche extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOVresponsableEquipeRecherche";

  // Attribute Keys
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<String> LC_STRUCTURE = new ERXKey<String>("lcStructure");
  public static final ERXKey<Integer> NO_INDIVIDU = new ERXKey<Integer>("noIndividu");
  public static final ERXKey<String> NOM = new ERXKey<String>("nom");
  public static final ERXKey<String> PRENOM = new ERXKey<String>("prenom");
  public static final ERXKey<Integer> RESPONSABLE_PERS_ID = new ERXKey<Integer>("responsablePersId");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr> TO_INDIVIDUS = new ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr>("toIndividus");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURES = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructures");

  // Attributes
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String LC_STRUCTURE_KEY = LC_STRUCTURE.key();
  public static final String NO_INDIVIDU_KEY = NO_INDIVIDU.key();
  public static final String NOM_KEY = NOM.key();
  public static final String PRENOM_KEY = PRENOM.key();
  public static final String RESPONSABLE_PERS_ID_KEY = RESPONSABLE_PERS_ID.key();
  // Relationships
  public static final String TO_INDIVIDUS_KEY = TO_INDIVIDUS.key();
  public static final String TO_STRUCTURES_KEY = TO_STRUCTURES.key();

  private static Logger LOG = Logger.getLogger(_EOVresponsableEquipeRecherche.class);

  public EOVresponsableEquipeRecherche localInstanceIn(EOEditingContext editingContext) {
    EOVresponsableEquipeRecherche localInstance = (EOVresponsableEquipeRecherche)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOVresponsableEquipeRecherche.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
    	_EOVresponsableEquipeRecherche.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVresponsableEquipeRecherche.C_STRUCTURE_KEY);
  }

  public String lcStructure() {
    return (String) storedValueForKey(_EOVresponsableEquipeRecherche.LC_STRUCTURE_KEY);
  }

  public void setLcStructure(String value) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
    	_EOVresponsableEquipeRecherche.LOG.debug( "updating lcStructure from " + lcStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVresponsableEquipeRecherche.LC_STRUCTURE_KEY);
  }

  public Integer noIndividu() {
    return (Integer) storedValueForKey(_EOVresponsableEquipeRecherche.NO_INDIVIDU_KEY);
  }

  public void setNoIndividu(Integer value) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
    	_EOVresponsableEquipeRecherche.LOG.debug( "updating noIndividu from " + noIndividu() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVresponsableEquipeRecherche.NO_INDIVIDU_KEY);
  }

  public String nom() {
    return (String) storedValueForKey(_EOVresponsableEquipeRecherche.NOM_KEY);
  }

  public void setNom(String value) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
    	_EOVresponsableEquipeRecherche.LOG.debug( "updating nom from " + nom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVresponsableEquipeRecherche.NOM_KEY);
  }

  public String prenom() {
    return (String) storedValueForKey(_EOVresponsableEquipeRecherche.PRENOM_KEY);
  }

  public void setPrenom(String value) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
    	_EOVresponsableEquipeRecherche.LOG.debug( "updating prenom from " + prenom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVresponsableEquipeRecherche.PRENOM_KEY);
  }

  public Integer responsablePersId() {
    return (Integer) storedValueForKey(_EOVresponsableEquipeRecherche.RESPONSABLE_PERS_ID_KEY);
  }

  public void setResponsablePersId(Integer value) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
    	_EOVresponsableEquipeRecherche.LOG.debug( "updating responsablePersId from " + responsablePersId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOVresponsableEquipeRecherche.RESPONSABLE_PERS_ID_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> toIndividus() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)storedValueForKey(_EOVresponsableEquipeRecherche.TO_INDIVIDUS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOIndividuUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EOVresponsableEquipeRecherche.TO_INDIVIDUS_KEY);
  }

  public void removeFromToIndividus(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    excludeObjectFromPropertyWithKey(object, _EOVresponsableEquipeRecherche.TO_INDIVIDUS_KEY);
  }

  public void addToToIndividusRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
      _EOVresponsableEquipeRecherche.LOG.debug("adding " + object + " to toIndividus relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToIndividus(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOVresponsableEquipeRecherche.TO_INDIVIDUS_KEY);
    }
  }

  public void removeFromToIndividusRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
      _EOVresponsableEquipeRecherche.LOG.debug("removing " + object + " from toIndividus relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToIndividus(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOVresponsableEquipeRecherche.TO_INDIVIDUS_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOIndividuUlr createToIndividusRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOIndividuUlr.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOVresponsableEquipeRecherche.TO_INDIVIDUS_KEY);
    return (utt.rec.projet.server.metier.grhum.EOIndividuUlr) eo;
  }

  public void deleteToIndividusRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOVresponsableEquipeRecherche.TO_INDIVIDUS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToIndividusRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOIndividuUlr> objects = toIndividus().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToIndividusRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)storedValueForKey(_EOVresponsableEquipeRecherche.TO_STRUCTURES_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOStructureUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EOVresponsableEquipeRecherche.TO_STRUCTURES_KEY);
  }

  public void removeFromToStructures(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    excludeObjectFromPropertyWithKey(object, _EOVresponsableEquipeRecherche.TO_STRUCTURES_KEY);
  }

  public void addToToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
      _EOVresponsableEquipeRecherche.LOG.debug("adding " + object + " to toStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToStructures(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOVresponsableEquipeRecherche.TO_STRUCTURES_KEY);
    }
  }

  public void removeFromToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    if (_EOVresponsableEquipeRecherche.LOG.isDebugEnabled()) {
      _EOVresponsableEquipeRecherche.LOG.debug("removing " + object + " from toStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToStructures(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOVresponsableEquipeRecherche.TO_STRUCTURES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOStructureUlr createToStructuresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOStructureUlr.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOVresponsableEquipeRecherche.TO_STRUCTURES_KEY);
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr) eo;
  }

  public void deleteToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOVresponsableEquipeRecherche.TO_STRUCTURES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToStructuresRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOStructureUlr> objects = toStructures().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToStructuresRelationship(objects.nextElement());
    }
  }


  public static EOVresponsableEquipeRecherche createEOVresponsableEquipeRecherche(EOEditingContext editingContext, String cStructure
, String lcStructure
, Integer noIndividu
, String nom
, String prenom
, Integer responsablePersId
) {
    EOVresponsableEquipeRecherche eo = (EOVresponsableEquipeRecherche) EOUtilities.createAndInsertInstance(editingContext, _EOVresponsableEquipeRecherche.ENTITY_NAME);    
		eo.setCStructure(cStructure);
		eo.setLcStructure(lcStructure);
		eo.setNoIndividu(noIndividu);
		eo.setNom(nom);
		eo.setPrenom(prenom);
		eo.setResponsablePersId(responsablePersId);
    return eo;
  }

  public static ERXFetchSpecification<EOVresponsableEquipeRecherche> fetchSpec() {
    return new ERXFetchSpecification<EOVresponsableEquipeRecherche>(_EOVresponsableEquipeRecherche.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOVresponsableEquipeRecherche> fetchAllEOVresponsableEquipeRecherches(EOEditingContext editingContext) {
    return _EOVresponsableEquipeRecherche.fetchAllEOVresponsableEquipeRecherches(editingContext, null);
  }

  public static NSArray<EOVresponsableEquipeRecherche> fetchAllEOVresponsableEquipeRecherches(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOVresponsableEquipeRecherche.fetchEOVresponsableEquipeRecherches(editingContext, null, sortOrderings);
  }

  public static NSArray<EOVresponsableEquipeRecherche> fetchEOVresponsableEquipeRecherches(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOVresponsableEquipeRecherche> fetchSpec = new ERXFetchSpecification<EOVresponsableEquipeRecherche>(_EOVresponsableEquipeRecherche.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOVresponsableEquipeRecherche> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOVresponsableEquipeRecherche fetchEOVresponsableEquipeRecherche(EOEditingContext editingContext, String keyName, Object value) {
    return _EOVresponsableEquipeRecherche.fetchEOVresponsableEquipeRecherche(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOVresponsableEquipeRecherche fetchEOVresponsableEquipeRecherche(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOVresponsableEquipeRecherche> eoObjects = _EOVresponsableEquipeRecherche.fetchEOVresponsableEquipeRecherches(editingContext, qualifier, null);
    EOVresponsableEquipeRecherche eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOVresponsableEquipeRecherche that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOVresponsableEquipeRecherche fetchRequiredEOVresponsableEquipeRecherche(EOEditingContext editingContext, String keyName, Object value) {
    return _EOVresponsableEquipeRecherche.fetchRequiredEOVresponsableEquipeRecherche(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOVresponsableEquipeRecherche fetchRequiredEOVresponsableEquipeRecherche(EOEditingContext editingContext, EOQualifier qualifier) {
    EOVresponsableEquipeRecherche eoObject = _EOVresponsableEquipeRecherche.fetchEOVresponsableEquipeRecherche(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOVresponsableEquipeRecherche that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOVresponsableEquipeRecherche localInstanceIn(EOEditingContext editingContext, EOVresponsableEquipeRecherche eo) {
    EOVresponsableEquipeRecherche localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
