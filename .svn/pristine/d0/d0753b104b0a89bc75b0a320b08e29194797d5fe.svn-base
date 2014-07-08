// DO NOT EDIT.  Make changes to EOAlerte.java instead.
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
public abstract class _EOAlerte extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOAlerte";

  // Attribute Keys
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<String> LIBELLE = new ERXKey<String>("libelle");
  public static final ERXKey<String> PRJ_HASHCODE_VAL = new ERXKey<String>("prjHashcodeVal");
  public static final ERXKey<String> PRJ_HASHCODE_VIS = new ERXKey<String>("prjHashcodeVis");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOCommentaires> TO_COMMENTAIRE = new ERXKey<utt.rec.projet.server.metier.admrec.EOCommentaires>("toCommentaire");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");

  // Attributes
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String LIBELLE_KEY = LIBELLE.key();
  public static final String PRJ_HASHCODE_VAL_KEY = PRJ_HASHCODE_VAL.key();
  public static final String PRJ_HASHCODE_VIS_KEY = PRJ_HASHCODE_VIS.key();
  // Relationships
  public static final String TO_COMMENTAIRE_KEY = TO_COMMENTAIRE.key();
  public static final String TO_PROJET_KEY = TO_PROJET.key();

  private static Logger LOG = Logger.getLogger(_EOAlerte.class);

  public EOAlerte localInstanceIn(EOEditingContext editingContext) {
    EOAlerte localInstance = (EOAlerte)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOAlerte.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOAlerte.LOG.isDebugEnabled()) {
    	_EOAlerte.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAlerte.C_STRUCTURE_KEY);
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EOAlerte.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EOAlerte.LOG.isDebugEnabled()) {
    	_EOAlerte.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAlerte.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EOAlerte.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EOAlerte.LOG.isDebugEnabled()) {
    	_EOAlerte.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAlerte.D_MODIFICATION_KEY);
  }

  public String libelle() {
    return (String) storedValueForKey(_EOAlerte.LIBELLE_KEY);
  }

  public void setLibelle(String value) {
    if (_EOAlerte.LOG.isDebugEnabled()) {
    	_EOAlerte.LOG.debug( "updating libelle from " + libelle() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAlerte.LIBELLE_KEY);
  }

  public String prjHashcodeVal() {
    return (String) storedValueForKey(_EOAlerte.PRJ_HASHCODE_VAL_KEY);
  }

  public void setPrjHashcodeVal(String value) {
    if (_EOAlerte.LOG.isDebugEnabled()) {
    	_EOAlerte.LOG.debug( "updating prjHashcodeVal from " + prjHashcodeVal() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAlerte.PRJ_HASHCODE_VAL_KEY);
  }

  public String prjHashcodeVis() {
    return (String) storedValueForKey(_EOAlerte.PRJ_HASHCODE_VIS_KEY);
  }

  public void setPrjHashcodeVis(String value) {
    if (_EOAlerte.LOG.isDebugEnabled()) {
    	_EOAlerte.LOG.debug( "updating prjHashcodeVis from " + prjHashcodeVis() + " to " + value);
    }
    takeStoredValueForKey(value, _EOAlerte.PRJ_HASHCODE_VIS_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOCommentaires toCommentaire() {
    return (utt.rec.projet.server.metier.admrec.EOCommentaires)storedValueForKey(_EOAlerte.TO_COMMENTAIRE_KEY);
  }
  
  public void setToCommentaire(utt.rec.projet.server.metier.admrec.EOCommentaires value) {
    takeStoredValueForKey(value, _EOAlerte.TO_COMMENTAIRE_KEY);
  }

  public void setToCommentaireRelationship(utt.rec.projet.server.metier.admrec.EOCommentaires value) {
    if (_EOAlerte.LOG.isDebugEnabled()) {
      _EOAlerte.LOG.debug("updating toCommentaire from " + toCommentaire() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToCommentaire(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOCommentaires oldValue = toCommentaire();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOAlerte.TO_COMMENTAIRE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOAlerte.TO_COMMENTAIRE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOAlerte.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOAlerte.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOAlerte.LOG.isDebugEnabled()) {
      _EOAlerte.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOAlerte.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOAlerte.TO_PROJET_KEY);
    }
  }
  

  public static EOAlerte createEOAlerte(EOEditingContext editingContext, String cStructure
, NSTimestamp dCreation
, NSTimestamp dModification
, String libelle
, String prjHashcodeVal
, String prjHashcodeVis
, utt.rec.projet.server.metier.admrec.EOPprec toProjet) {
    EOAlerte eo = (EOAlerte) EOUtilities.createAndInsertInstance(editingContext, _EOAlerte.ENTITY_NAME);    
		eo.setCStructure(cStructure);
		eo.setDCreation(dCreation);
		eo.setDModification(dModification);
		eo.setLibelle(libelle);
		eo.setPrjHashcodeVal(prjHashcodeVal);
		eo.setPrjHashcodeVis(prjHashcodeVis);
    eo.setToProjetRelationship(toProjet);
    return eo;
  }

  public static ERXFetchSpecification<EOAlerte> fetchSpec() {
    return new ERXFetchSpecification<EOAlerte>(_EOAlerte.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOAlerte> fetchAllEOAlertes(EOEditingContext editingContext) {
    return _EOAlerte.fetchAllEOAlertes(editingContext, null);
  }

  public static NSArray<EOAlerte> fetchAllEOAlertes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOAlerte.fetchEOAlertes(editingContext, null, sortOrderings);
  }

  public static NSArray<EOAlerte> fetchEOAlertes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOAlerte> fetchSpec = new ERXFetchSpecification<EOAlerte>(_EOAlerte.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOAlerte> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOAlerte fetchEOAlerte(EOEditingContext editingContext, String keyName, Object value) {
    return _EOAlerte.fetchEOAlerte(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOAlerte fetchEOAlerte(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOAlerte> eoObjects = _EOAlerte.fetchEOAlertes(editingContext, qualifier, null);
    EOAlerte eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOAlerte that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOAlerte fetchRequiredEOAlerte(EOEditingContext editingContext, String keyName, Object value) {
    return _EOAlerte.fetchRequiredEOAlerte(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOAlerte fetchRequiredEOAlerte(EOEditingContext editingContext, EOQualifier qualifier) {
    EOAlerte eoObject = _EOAlerte.fetchEOAlerte(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOAlerte that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOAlerte localInstanceIn(EOEditingContext editingContext, EOAlerte eo) {
    EOAlerte localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
