// DO NOT EDIT.  Make changes to EOPartenaireProjet.java instead.
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
public abstract class _EOPartenaireProjet extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOPartenaireProjet";

  // Attribute Keys
  public static final ERXKey<Integer> PROJET_ID = new ERXKey<Integer>("projetId");
  public static final ERXKey<String> TEMVALIDE = new ERXKey<String>("temvalide");
  public static final ERXKey<Integer> TYPPART_ID = new ERXKey<Integer>("typpartId");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTyppartenaire> TO_PARTENAIRE = new ERXKey<utt.rec.projet.server.metier.admrec.EOTyppartenaire>("toPartenaire");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");

  // Attributes
  public static final String PROJET_ID_KEY = PROJET_ID.key();
  public static final String TEMVALIDE_KEY = TEMVALIDE.key();
  public static final String TYPPART_ID_KEY = TYPPART_ID.key();
  // Relationships
  public static final String TO_PARTENAIRE_KEY = TO_PARTENAIRE.key();
  public static final String TO_PROJET_KEY = TO_PROJET.key();

  private static Logger LOG = Logger.getLogger(_EOPartenaireProjet.class);

  public EOPartenaireProjet localInstanceIn(EOEditingContext editingContext) {
    EOPartenaireProjet localInstance = (EOPartenaireProjet)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer projetId() {
    return (Integer) storedValueForKey(_EOPartenaireProjet.PROJET_ID_KEY);
  }

  public void setProjetId(Integer value) {
    if (_EOPartenaireProjet.LOG.isDebugEnabled()) {
    	_EOPartenaireProjet.LOG.debug( "updating projetId from " + projetId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPartenaireProjet.PROJET_ID_KEY);
  }

  public String temvalide() {
    return (String) storedValueForKey(_EOPartenaireProjet.TEMVALIDE_KEY);
  }

  public void setTemvalide(String value) {
    if (_EOPartenaireProjet.LOG.isDebugEnabled()) {
    	_EOPartenaireProjet.LOG.debug( "updating temvalide from " + temvalide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPartenaireProjet.TEMVALIDE_KEY);
  }

  public Integer typpartId() {
    return (Integer) storedValueForKey(_EOPartenaireProjet.TYPPART_ID_KEY);
  }

  public void setTyppartId(Integer value) {
    if (_EOPartenaireProjet.LOG.isDebugEnabled()) {
    	_EOPartenaireProjet.LOG.debug( "updating typpartId from " + typpartId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPartenaireProjet.TYPPART_ID_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOTyppartenaire toPartenaire() {
    return (utt.rec.projet.server.metier.admrec.EOTyppartenaire)storedValueForKey(_EOPartenaireProjet.TO_PARTENAIRE_KEY);
  }
  
  public void setToPartenaire(utt.rec.projet.server.metier.admrec.EOTyppartenaire value) {
    takeStoredValueForKey(value, _EOPartenaireProjet.TO_PARTENAIRE_KEY);
  }

  public void setToPartenaireRelationship(utt.rec.projet.server.metier.admrec.EOTyppartenaire value) {
    if (_EOPartenaireProjet.LOG.isDebugEnabled()) {
      _EOPartenaireProjet.LOG.debug("updating toPartenaire from " + toPartenaire() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPartenaire(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOTyppartenaire oldValue = toPartenaire();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPartenaireProjet.TO_PARTENAIRE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPartenaireProjet.TO_PARTENAIRE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOPartenaireProjet.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOPartenaireProjet.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOPartenaireProjet.LOG.isDebugEnabled()) {
      _EOPartenaireProjet.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPartenaireProjet.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPartenaireProjet.TO_PROJET_KEY);
    }
  }
  

  public static EOPartenaireProjet createEOPartenaireProjet(EOEditingContext editingContext, Integer projetId
, String temvalide
, Integer typpartId
, utt.rec.projet.server.metier.admrec.EOTyppartenaire toPartenaire, utt.rec.projet.server.metier.admrec.EOPprec toProjet) {
    EOPartenaireProjet eo = (EOPartenaireProjet) EOUtilities.createAndInsertInstance(editingContext, _EOPartenaireProjet.ENTITY_NAME);    
		eo.setProjetId(projetId);
		eo.setTemvalide(temvalide);
		eo.setTyppartId(typpartId);
    eo.setToPartenaireRelationship(toPartenaire);
    eo.setToProjetRelationship(toProjet);
    return eo;
  }

  public static ERXFetchSpecification<EOPartenaireProjet> fetchSpec() {
    return new ERXFetchSpecification<EOPartenaireProjet>(_EOPartenaireProjet.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOPartenaireProjet> fetchAllEOPartenaireProjets(EOEditingContext editingContext) {
    return _EOPartenaireProjet.fetchAllEOPartenaireProjets(editingContext, null);
  }

  public static NSArray<EOPartenaireProjet> fetchAllEOPartenaireProjets(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOPartenaireProjet.fetchEOPartenaireProjets(editingContext, null, sortOrderings);
  }

  public static NSArray<EOPartenaireProjet> fetchEOPartenaireProjets(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOPartenaireProjet> fetchSpec = new ERXFetchSpecification<EOPartenaireProjet>(_EOPartenaireProjet.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOPartenaireProjet> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOPartenaireProjet fetchEOPartenaireProjet(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPartenaireProjet.fetchEOPartenaireProjet(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPartenaireProjet fetchEOPartenaireProjet(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOPartenaireProjet> eoObjects = _EOPartenaireProjet.fetchEOPartenaireProjets(editingContext, qualifier, null);
    EOPartenaireProjet eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOPartenaireProjet that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPartenaireProjet fetchRequiredEOPartenaireProjet(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPartenaireProjet.fetchRequiredEOPartenaireProjet(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPartenaireProjet fetchRequiredEOPartenaireProjet(EOEditingContext editingContext, EOQualifier qualifier) {
    EOPartenaireProjet eoObject = _EOPartenaireProjet.fetchEOPartenaireProjet(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOPartenaireProjet that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPartenaireProjet localInstanceIn(EOEditingContext editingContext, EOPartenaireProjet eo) {
    EOPartenaireProjet localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> fetchLesPartenaires(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lesPartenaires", _EOPartenaireProjet.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> fetchLesPartenaires(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("lesPartenaires", _EOPartenaireProjet.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
