// DO NOT EDIT.  Make changes to EOStpart.java instead.
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
public abstract class _EOStpart extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOStpart";

  // Attribute Keys
  public static final ERXKey<String> LIB_STATUT_PARTENAIRE = new ERXKey<String>("libStatutPartenaire");
  public static final ERXKey<Integer> PUBLIC_PRIVE = new ERXKey<Integer>("publicPrive");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTyppartenaire> TO_TYPE_PARTENAIRES = new ERXKey<utt.rec.projet.server.metier.admrec.EOTyppartenaire>("toTypePartenaires");

  // Attributes
  public static final String LIB_STATUT_PARTENAIRE_KEY = LIB_STATUT_PARTENAIRE.key();
  public static final String PUBLIC_PRIVE_KEY = PUBLIC_PRIVE.key();
  // Relationships
  public static final String TO_TYPE_PARTENAIRES_KEY = TO_TYPE_PARTENAIRES.key();

  private static Logger LOG = Logger.getLogger(_EOStpart.class);

  public EOStpart localInstanceIn(EOEditingContext editingContext) {
    EOStpart localInstance = (EOStpart)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String libStatutPartenaire() {
    return (String) storedValueForKey(_EOStpart.LIB_STATUT_PARTENAIRE_KEY);
  }

  public void setLibStatutPartenaire(String value) {
    if (_EOStpart.LOG.isDebugEnabled()) {
    	_EOStpart.LOG.debug( "updating libStatutPartenaire from " + libStatutPartenaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStpart.LIB_STATUT_PARTENAIRE_KEY);
  }

  public Integer publicPrive() {
    return (Integer) storedValueForKey(_EOStpart.PUBLIC_PRIVE_KEY);
  }

  public void setPublicPrive(Integer value) {
    if (_EOStpart.LOG.isDebugEnabled()) {
    	_EOStpart.LOG.debug( "updating publicPrive from " + publicPrive() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStpart.PUBLIC_PRIVE_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> toTypePartenaires() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire>)storedValueForKey(_EOStpart.TO_TYPE_PARTENAIRES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> toTypePartenaires(EOQualifier qualifier) {
    return toTypePartenaires(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> toTypePartenaires(EOQualifier qualifier, boolean fetch) {
    return toTypePartenaires(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> toTypePartenaires(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOTyppartenaire.TO_STPART_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOTyppartenaire.fetchEOTyppartenaires(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toTypePartenaires();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToTypePartenaires(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    includeObjectIntoPropertyWithKey(object, _EOStpart.TO_TYPE_PARTENAIRES_KEY);
  }

  public void removeFromToTypePartenaires(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    excludeObjectFromPropertyWithKey(object, _EOStpart.TO_TYPE_PARTENAIRES_KEY);
  }

  public void addToToTypePartenairesRelationship(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    if (_EOStpart.LOG.isDebugEnabled()) {
      _EOStpart.LOG.debug("adding " + object + " to toTypePartenaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToTypePartenaires(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStpart.TO_TYPE_PARTENAIRES_KEY);
    }
  }

  public void removeFromToTypePartenairesRelationship(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    if (_EOStpart.LOG.isDebugEnabled()) {
      _EOStpart.LOG.debug("removing " + object + " from toTypePartenaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToTypePartenaires(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStpart.TO_TYPE_PARTENAIRES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOTyppartenaire createToTypePartenairesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOTyppartenaire.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStpart.TO_TYPE_PARTENAIRES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOTyppartenaire) eo;
  }

  public void deleteToTypePartenairesRelationship(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStpart.TO_TYPE_PARTENAIRES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToTypePartenairesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOTyppartenaire> objects = toTypePartenaires().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToTypePartenairesRelationship(objects.nextElement());
    }
  }


  public static EOStpart createEOStpart(EOEditingContext editingContext) {
    EOStpart eo = (EOStpart) EOUtilities.createAndInsertInstance(editingContext, _EOStpart.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<EOStpart> fetchSpec() {
    return new ERXFetchSpecification<EOStpart>(_EOStpart.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOStpart> fetchAllEOStparts(EOEditingContext editingContext) {
    return _EOStpart.fetchAllEOStparts(editingContext, null);
  }

  public static NSArray<EOStpart> fetchAllEOStparts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOStpart.fetchEOStparts(editingContext, null, sortOrderings);
  }

  public static NSArray<EOStpart> fetchEOStparts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOStpart> fetchSpec = new ERXFetchSpecification<EOStpart>(_EOStpart.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOStpart> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOStpart fetchEOStpart(EOEditingContext editingContext, String keyName, Object value) {
    return _EOStpart.fetchEOStpart(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOStpart fetchEOStpart(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOStpart> eoObjects = _EOStpart.fetchEOStparts(editingContext, qualifier, null);
    EOStpart eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOStpart that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOStpart fetchRequiredEOStpart(EOEditingContext editingContext, String keyName, Object value) {
    return _EOStpart.fetchRequiredEOStpart(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOStpart fetchRequiredEOStpart(EOEditingContext editingContext, EOQualifier qualifier) {
    EOStpart eoObject = _EOStpart.fetchEOStpart(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOStpart that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOStpart localInstanceIn(EOEditingContext editingContext, EOStpart eo) {
    EOStpart localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
