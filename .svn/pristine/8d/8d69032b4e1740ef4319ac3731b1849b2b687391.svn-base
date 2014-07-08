// DO NOT EDIT.  Make changes to EOTpartenaire.java instead.
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
public abstract class _EOTpartenaire extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOTpartenaire";

  // Attribute Keys
  public static final ERXKey<String> LIB_TYPE_PARTENAIRE = new ERXKey<String>("libTypePartenaire");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTyppartenaire> TO_TYP_PARTENAIRES = new ERXKey<utt.rec.projet.server.metier.admrec.EOTyppartenaire>("toTypPartenaires");

  // Attributes
  public static final String LIB_TYPE_PARTENAIRE_KEY = LIB_TYPE_PARTENAIRE.key();
  // Relationships
  public static final String TO_TYP_PARTENAIRES_KEY = TO_TYP_PARTENAIRES.key();

  private static Logger LOG = Logger.getLogger(_EOTpartenaire.class);

  public EOTpartenaire localInstanceIn(EOEditingContext editingContext) {
    EOTpartenaire localInstance = (EOTpartenaire)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String libTypePartenaire() {
    return (String) storedValueForKey(_EOTpartenaire.LIB_TYPE_PARTENAIRE_KEY);
  }

  public void setLibTypePartenaire(String value) {
    if (_EOTpartenaire.LOG.isDebugEnabled()) {
    	_EOTpartenaire.LOG.debug( "updating libTypePartenaire from " + libTypePartenaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTpartenaire.LIB_TYPE_PARTENAIRE_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> toTypPartenaires() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire>)storedValueForKey(_EOTpartenaire.TO_TYP_PARTENAIRES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> toTypPartenaires(EOQualifier qualifier) {
    return toTypPartenaires(qualifier, null);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> toTypPartenaires(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> results;
      results = toTypPartenaires();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToToTypPartenaires(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    includeObjectIntoPropertyWithKey(object, _EOTpartenaire.TO_TYP_PARTENAIRES_KEY);
  }

  public void removeFromToTypPartenaires(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    excludeObjectFromPropertyWithKey(object, _EOTpartenaire.TO_TYP_PARTENAIRES_KEY);
  }

  public void addToToTypPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    if (_EOTpartenaire.LOG.isDebugEnabled()) {
      _EOTpartenaire.LOG.debug("adding " + object + " to toTypPartenaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToTypPartenaires(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOTpartenaire.TO_TYP_PARTENAIRES_KEY);
    }
  }

  public void removeFromToTypPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    if (_EOTpartenaire.LOG.isDebugEnabled()) {
      _EOTpartenaire.LOG.debug("removing " + object + " from toTypPartenaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToTypPartenaires(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTpartenaire.TO_TYP_PARTENAIRES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOTyppartenaire createToTypPartenairesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOTyppartenaire.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOTpartenaire.TO_TYP_PARTENAIRES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOTyppartenaire) eo;
  }

  public void deleteToTypPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOTyppartenaire object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTpartenaire.TO_TYP_PARTENAIRES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToTypPartenairesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOTyppartenaire> objects = toTypPartenaires().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToTypPartenairesRelationship(objects.nextElement());
    }
  }


  public static EOTpartenaire createEOTpartenaire(EOEditingContext editingContext, String libTypePartenaire
) {
    EOTpartenaire eo = (EOTpartenaire) EOUtilities.createAndInsertInstance(editingContext, _EOTpartenaire.ENTITY_NAME);    
		eo.setLibTypePartenaire(libTypePartenaire);
    return eo;
  }

  public static ERXFetchSpecification<EOTpartenaire> fetchSpec() {
    return new ERXFetchSpecification<EOTpartenaire>(_EOTpartenaire.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOTpartenaire> fetchAllEOTpartenaires(EOEditingContext editingContext) {
    return _EOTpartenaire.fetchAllEOTpartenaires(editingContext, null);
  }

  public static NSArray<EOTpartenaire> fetchAllEOTpartenaires(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOTpartenaire.fetchEOTpartenaires(editingContext, null, sortOrderings);
  }

  public static NSArray<EOTpartenaire> fetchEOTpartenaires(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOTpartenaire> fetchSpec = new ERXFetchSpecification<EOTpartenaire>(_EOTpartenaire.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOTpartenaire> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOTpartenaire fetchEOTpartenaire(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTpartenaire.fetchEOTpartenaire(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTpartenaire fetchEOTpartenaire(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOTpartenaire> eoObjects = _EOTpartenaire.fetchEOTpartenaires(editingContext, qualifier, null);
    EOTpartenaire eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOTpartenaire that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTpartenaire fetchRequiredEOTpartenaire(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTpartenaire.fetchRequiredEOTpartenaire(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTpartenaire fetchRequiredEOTpartenaire(EOEditingContext editingContext, EOQualifier qualifier) {
    EOTpartenaire eoObject = _EOTpartenaire.fetchEOTpartenaire(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOTpartenaire that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTpartenaire localInstanceIn(EOEditingContext editingContext, EOTpartenaire eo) {
    EOTpartenaire localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
