// DO NOT EDIT.  Make changes to EOTyppartenaire.java instead.
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
public abstract class _EOTyppartenaire extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOTyppartenaire";

  // Attribute Keys
  public static final ERXKey<String> C_ST_PARTENAIRE = new ERXKey<String>("cStPartenaire");
  public static final ERXKey<String> CT_PARTENAIRE = new ERXKey<String>("ctPartenaire");
  public static final ERXKey<String> DENOM_USUELLE = new ERXKey<String>("denomUsuelle");
  public static final ERXKey<String> NOM_PARTENAIRE = new ERXKey<String>("nomPartenaire");
  public static final ERXKey<String> PART_CLEUNIK = new ERXKey<String>("partCleunik");
  public static final ERXKey<String> PROVENANCE = new ERXKey<String>("provenance");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> TO_PARTENAIRES = new ERXKey<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>("toPartenaires");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOStpart> TO_STPART = new ERXKey<utt.rec.projet.server.metier.admrec.EOStpart>("toStpart");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTpartenaire> TO_TPARTENAIRE = new ERXKey<utt.rec.projet.server.metier.admrec.EOTpartenaire>("toTpartenaire");

  // Attributes
  public static final String C_ST_PARTENAIRE_KEY = C_ST_PARTENAIRE.key();
  public static final String CT_PARTENAIRE_KEY = CT_PARTENAIRE.key();
  public static final String DENOM_USUELLE_KEY = DENOM_USUELLE.key();
  public static final String NOM_PARTENAIRE_KEY = NOM_PARTENAIRE.key();
  public static final String PART_CLEUNIK_KEY = PART_CLEUNIK.key();
  public static final String PROVENANCE_KEY = PROVENANCE.key();
  // Relationships
  public static final String TO_PARTENAIRES_KEY = TO_PARTENAIRES.key();
  public static final String TO_STPART_KEY = TO_STPART.key();
  public static final String TO_TPARTENAIRE_KEY = TO_TPARTENAIRE.key();

  private static Logger LOG = Logger.getLogger(_EOTyppartenaire.class);

  public EOTyppartenaire localInstanceIn(EOEditingContext editingContext) {
    EOTyppartenaire localInstance = (EOTyppartenaire)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cStPartenaire() {
    return (String) storedValueForKey(_EOTyppartenaire.C_ST_PARTENAIRE_KEY);
  }

  public void setCStPartenaire(String value) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
    	_EOTyppartenaire.LOG.debug( "updating cStPartenaire from " + cStPartenaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTyppartenaire.C_ST_PARTENAIRE_KEY);
  }

  public String ctPartenaire() {
    return (String) storedValueForKey(_EOTyppartenaire.CT_PARTENAIRE_KEY);
  }

  public void setCtPartenaire(String value) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
    	_EOTyppartenaire.LOG.debug( "updating ctPartenaire from " + ctPartenaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTyppartenaire.CT_PARTENAIRE_KEY);
  }

  public String denomUsuelle() {
    return (String) storedValueForKey(_EOTyppartenaire.DENOM_USUELLE_KEY);
  }

  public void setDenomUsuelle(String value) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
    	_EOTyppartenaire.LOG.debug( "updating denomUsuelle from " + denomUsuelle() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTyppartenaire.DENOM_USUELLE_KEY);
  }

  public String nomPartenaire() {
    return (String) storedValueForKey(_EOTyppartenaire.NOM_PARTENAIRE_KEY);
  }

  public void setNomPartenaire(String value) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
    	_EOTyppartenaire.LOG.debug( "updating nomPartenaire from " + nomPartenaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTyppartenaire.NOM_PARTENAIRE_KEY);
  }

  public String partCleunik() {
    return (String) storedValueForKey(_EOTyppartenaire.PART_CLEUNIK_KEY);
  }

  public void setPartCleunik(String value) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
    	_EOTyppartenaire.LOG.debug( "updating partCleunik from " + partCleunik() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTyppartenaire.PART_CLEUNIK_KEY);
  }

  public String provenance() {
    return (String) storedValueForKey(_EOTyppartenaire.PROVENANCE_KEY);
  }

  public void setProvenance(String value) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
    	_EOTyppartenaire.LOG.debug( "updating provenance from " + provenance() + " to " + value);
    }
    takeStoredValueForKey(value, _EOTyppartenaire.PROVENANCE_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOStpart toStpart() {
    return (utt.rec.projet.server.metier.admrec.EOStpart)storedValueForKey(_EOTyppartenaire.TO_STPART_KEY);
  }
  
  public void setToStpart(utt.rec.projet.server.metier.admrec.EOStpart value) {
    takeStoredValueForKey(value, _EOTyppartenaire.TO_STPART_KEY);
  }

  public void setToStpartRelationship(utt.rec.projet.server.metier.admrec.EOStpart value) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
      _EOTyppartenaire.LOG.debug("updating toStpart from " + toStpart() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStpart(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOStpart oldValue = toStpart();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOTyppartenaire.TO_STPART_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOTyppartenaire.TO_STPART_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOTpartenaire toTpartenaire() {
    return (utt.rec.projet.server.metier.admrec.EOTpartenaire)storedValueForKey(_EOTyppartenaire.TO_TPARTENAIRE_KEY);
  }
  
  public void setToTpartenaire(utt.rec.projet.server.metier.admrec.EOTpartenaire value) {
    takeStoredValueForKey(value, _EOTyppartenaire.TO_TPARTENAIRE_KEY);
  }

  public void setToTpartenaireRelationship(utt.rec.projet.server.metier.admrec.EOTpartenaire value) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
      _EOTyppartenaire.LOG.debug("updating toTpartenaire from " + toTpartenaire() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToTpartenaire(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOTpartenaire oldValue = toTpartenaire();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOTyppartenaire.TO_TPARTENAIRE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOTyppartenaire.TO_TPARTENAIRE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> toPartenaires() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>)storedValueForKey(_EOTyppartenaire.TO_PARTENAIRES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> toPartenaires(EOQualifier qualifier) {
    return toPartenaires(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> toPartenaires(EOQualifier qualifier, boolean fetch) {
    return toPartenaires(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> toPartenaires(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPartenaireProjet.TO_PARTENAIRE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPartenaireProjet.fetchEOPartenaireProjets(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toPartenaires();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToPartenaires(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    includeObjectIntoPropertyWithKey(object, _EOTyppartenaire.TO_PARTENAIRES_KEY);
  }

  public void removeFromToPartenaires(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    excludeObjectFromPropertyWithKey(object, _EOTyppartenaire.TO_PARTENAIRES_KEY);
  }

  public void addToToPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
      _EOTyppartenaire.LOG.debug("adding " + object + " to toPartenaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToPartenaires(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOTyppartenaire.TO_PARTENAIRES_KEY);
    }
  }

  public void removeFromToPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    if (_EOTyppartenaire.LOG.isDebugEnabled()) {
      _EOTyppartenaire.LOG.debug("removing " + object + " from toPartenaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToPartenaires(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTyppartenaire.TO_PARTENAIRES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPartenaireProjet createToPartenairesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPartenaireProjet.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOTyppartenaire.TO_PARTENAIRES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPartenaireProjet) eo;
  }

  public void deleteToPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOTyppartenaire.TO_PARTENAIRES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToPartenairesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> objects = toPartenaires().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToPartenairesRelationship(objects.nextElement());
    }
  }


  public static EOTyppartenaire createEOTyppartenaire(EOEditingContext editingContext, String denomUsuelle
, String provenance
) {
    EOTyppartenaire eo = (EOTyppartenaire) EOUtilities.createAndInsertInstance(editingContext, _EOTyppartenaire.ENTITY_NAME);    
		eo.setDenomUsuelle(denomUsuelle);
		eo.setProvenance(provenance);
    return eo;
  }

  public static ERXFetchSpecification<EOTyppartenaire> fetchSpec() {
    return new ERXFetchSpecification<EOTyppartenaire>(_EOTyppartenaire.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOTyppartenaire> fetchAllEOTyppartenaires(EOEditingContext editingContext) {
    return _EOTyppartenaire.fetchAllEOTyppartenaires(editingContext, null);
  }

  public static NSArray<EOTyppartenaire> fetchAllEOTyppartenaires(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOTyppartenaire.fetchEOTyppartenaires(editingContext, null, sortOrderings);
  }

  public static NSArray<EOTyppartenaire> fetchEOTyppartenaires(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOTyppartenaire> fetchSpec = new ERXFetchSpecification<EOTyppartenaire>(_EOTyppartenaire.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOTyppartenaire> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOTyppartenaire fetchEOTyppartenaire(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTyppartenaire.fetchEOTyppartenaire(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTyppartenaire fetchEOTyppartenaire(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOTyppartenaire> eoObjects = _EOTyppartenaire.fetchEOTyppartenaires(editingContext, qualifier, null);
    EOTyppartenaire eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOTyppartenaire that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTyppartenaire fetchRequiredEOTyppartenaire(EOEditingContext editingContext, String keyName, Object value) {
    return _EOTyppartenaire.fetchRequiredEOTyppartenaire(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOTyppartenaire fetchRequiredEOTyppartenaire(EOEditingContext editingContext, EOQualifier qualifier) {
    EOTyppartenaire eoObject = _EOTyppartenaire.fetchEOTyppartenaire(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOTyppartenaire that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOTyppartenaire localInstanceIn(EOEditingContext editingContext, EOTyppartenaire eo) {
    EOTyppartenaire localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> fetchTypPart(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("typPart", _EOTyppartenaire.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire> fetchTypPart(EOEditingContext editingContext,
	Integer typpartIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("typPart", _EOTyppartenaire.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(typpartIdBinding, "typpartId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOTyppartenaire>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
