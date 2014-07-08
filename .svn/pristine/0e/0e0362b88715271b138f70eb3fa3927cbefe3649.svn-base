// DO NOT EDIT.  Make changes to EOResmat.java instead.
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
public abstract class _EOResmat extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOResmat";

  // Attribute Keys
  public static final ERXKey<java.math.BigDecimal> COUTESTIME = new ERXKey<java.math.BigDecimal>("coutestime");
  public static final ERXKey<NSTimestamp> CREADATE = new ERXKey<NSTimestamp>("creadate");
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<Integer> GEMAT_ID = new ERXKey<Integer>("gematId");
  public static final ERXKey<String> MAJAUTEUR = new ERXKey<String>("majauteur");
  public static final ERXKey<NSTimestamp> MAJDATE = new ERXKey<NSTimestamp>("majdate");
  public static final ERXKey<String> MATEXIST = new ERXKey<String>("matexist");
  public static final ERXKey<String> MATUTIL = new ERXKey<String>("matutil");
  public static final ERXKey<String> NOM_STRUCTURE = new ERXKey<String>("nomStructure");
  public static final ERXKey<String> PFMAT_ID = new ERXKey<String>("pfmatId");
  public static final ERXKey<Integer> PROJET_ID = new ERXKey<Integer>("projetId");
  public static final ERXKey<String> TEMVALIDE = new ERXKey<String>("temvalide");
  public static final ERXKey<String> TXFINANCEMENT = new ERXKey<String>("txfinancement");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOGemateriel> TO_GRAND_EQUIPEMENT = new ERXKey<utt.rec.projet.server.metier.admrec.EOGemateriel>("toGrandEquipement");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPfmateriel> TO_PLATEAU_TECH = new ERXKey<utt.rec.projet.server.metier.admrec.EOPfmateriel>("toPlateauTech");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");

  // Attributes
  public static final String COUTESTIME_KEY = COUTESTIME.key();
  public static final String CREADATE_KEY = CREADATE.key();
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String GEMAT_ID_KEY = GEMAT_ID.key();
  public static final String MAJAUTEUR_KEY = MAJAUTEUR.key();
  public static final String MAJDATE_KEY = MAJDATE.key();
  public static final String MATEXIST_KEY = MATEXIST.key();
  public static final String MATUTIL_KEY = MATUTIL.key();
  public static final String NOM_STRUCTURE_KEY = NOM_STRUCTURE.key();
  public static final String PFMAT_ID_KEY = PFMAT_ID.key();
  public static final String PROJET_ID_KEY = PROJET_ID.key();
  public static final String TEMVALIDE_KEY = TEMVALIDE.key();
  public static final String TXFINANCEMENT_KEY = TXFINANCEMENT.key();
  // Relationships
  public static final String TO_GRAND_EQUIPEMENT_KEY = TO_GRAND_EQUIPEMENT.key();
  public static final String TO_PLATEAU_TECH_KEY = TO_PLATEAU_TECH.key();
  public static final String TO_PROJET_KEY = TO_PROJET.key();

  private static Logger LOG = Logger.getLogger(_EOResmat.class);

  public EOResmat localInstanceIn(EOEditingContext editingContext) {
    EOResmat localInstance = (EOResmat)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public java.math.BigDecimal coutestime() {
    return (java.math.BigDecimal) storedValueForKey(_EOResmat.COUTESTIME_KEY);
  }

  public void setCoutestime(java.math.BigDecimal value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating coutestime from " + coutestime() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.COUTESTIME_KEY);
  }

  public NSTimestamp creadate() {
    return (NSTimestamp) storedValueForKey(_EOResmat.CREADATE_KEY);
  }

  public void setCreadate(NSTimestamp value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating creadate from " + creadate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.CREADATE_KEY);
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOResmat.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.C_STRUCTURE_KEY);
  }

  public Integer gematId() {
    return (Integer) storedValueForKey(_EOResmat.GEMAT_ID_KEY);
  }

  public void setGematId(Integer value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating gematId from " + gematId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.GEMAT_ID_KEY);
  }

  public String majauteur() {
    return (String) storedValueForKey(_EOResmat.MAJAUTEUR_KEY);
  }

  public void setMajauteur(String value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating majauteur from " + majauteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.MAJAUTEUR_KEY);
  }

  public NSTimestamp majdate() {
    return (NSTimestamp) storedValueForKey(_EOResmat.MAJDATE_KEY);
  }

  public void setMajdate(NSTimestamp value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating majdate from " + majdate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.MAJDATE_KEY);
  }

  public String matexist() {
    return (String) storedValueForKey(_EOResmat.MATEXIST_KEY);
  }

  public void setMatexist(String value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating matexist from " + matexist() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.MATEXIST_KEY);
  }

  public String matutil() {
    return (String) storedValueForKey(_EOResmat.MATUTIL_KEY);
  }

  public void setMatutil(String value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating matutil from " + matutil() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.MATUTIL_KEY);
  }

  public String nomStructure() {
    return (String) storedValueForKey(_EOResmat.NOM_STRUCTURE_KEY);
  }

  public void setNomStructure(String value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating nomStructure from " + nomStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.NOM_STRUCTURE_KEY);
  }

  public String pfmatId() {
    return (String) storedValueForKey(_EOResmat.PFMAT_ID_KEY);
  }

  public void setPfmatId(String value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating pfmatId from " + pfmatId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.PFMAT_ID_KEY);
  }

  public Integer projetId() {
    return (Integer) storedValueForKey(_EOResmat.PROJET_ID_KEY);
  }

  public void setProjetId(Integer value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating projetId from " + projetId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.PROJET_ID_KEY);
  }

  public String temvalide() {
    return (String) storedValueForKey(_EOResmat.TEMVALIDE_KEY);
  }

  public void setTemvalide(String value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating temvalide from " + temvalide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.TEMVALIDE_KEY);
  }

  public String txfinancement() {
    return (String) storedValueForKey(_EOResmat.TXFINANCEMENT_KEY);
  }

  public void setTxfinancement(String value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
    	_EOResmat.LOG.debug( "updating txfinancement from " + txfinancement() + " to " + value);
    }
    takeStoredValueForKey(value, _EOResmat.TXFINANCEMENT_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOGemateriel toGrandEquipement() {
    return (utt.rec.projet.server.metier.admrec.EOGemateriel)storedValueForKey(_EOResmat.TO_GRAND_EQUIPEMENT_KEY);
  }
  
  public void setToGrandEquipement(utt.rec.projet.server.metier.admrec.EOGemateriel value) {
    takeStoredValueForKey(value, _EOResmat.TO_GRAND_EQUIPEMENT_KEY);
  }

  public void setToGrandEquipementRelationship(utt.rec.projet.server.metier.admrec.EOGemateriel value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
      _EOResmat.LOG.debug("updating toGrandEquipement from " + toGrandEquipement() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToGrandEquipement(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOGemateriel oldValue = toGrandEquipement();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOResmat.TO_GRAND_EQUIPEMENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOResmat.TO_GRAND_EQUIPEMENT_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOPfmateriel toPlateauTech() {
    return (utt.rec.projet.server.metier.admrec.EOPfmateriel)storedValueForKey(_EOResmat.TO_PLATEAU_TECH_KEY);
  }
  
  public void setToPlateauTech(utt.rec.projet.server.metier.admrec.EOPfmateriel value) {
    takeStoredValueForKey(value, _EOResmat.TO_PLATEAU_TECH_KEY);
  }

  public void setToPlateauTechRelationship(utt.rec.projet.server.metier.admrec.EOPfmateriel value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
      _EOResmat.LOG.debug("updating toPlateauTech from " + toPlateauTech() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPlateauTech(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPfmateriel oldValue = toPlateauTech();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOResmat.TO_PLATEAU_TECH_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOResmat.TO_PLATEAU_TECH_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOResmat.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOResmat.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOResmat.LOG.isDebugEnabled()) {
      _EOResmat.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOResmat.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOResmat.TO_PROJET_KEY);
    }
  }
  

  public static EOResmat createEOResmat(EOEditingContext editingContext, java.math.BigDecimal coutestime
, String cStructure
, Integer gematId
, String nomStructure
, String pfmatId
, Integer projetId
, String temvalide
, utt.rec.projet.server.metier.admrec.EOGemateriel toGrandEquipement, utt.rec.projet.server.metier.admrec.EOPfmateriel toPlateauTech, utt.rec.projet.server.metier.admrec.EOPprec toProjet) {
    EOResmat eo = (EOResmat) EOUtilities.createAndInsertInstance(editingContext, _EOResmat.ENTITY_NAME);    
		eo.setCoutestime(coutestime);
		eo.setCStructure(cStructure);
		eo.setGematId(gematId);
		eo.setNomStructure(nomStructure);
		eo.setPfmatId(pfmatId);
		eo.setProjetId(projetId);
		eo.setTemvalide(temvalide);
    eo.setToGrandEquipementRelationship(toGrandEquipement);
    eo.setToPlateauTechRelationship(toPlateauTech);
    eo.setToProjetRelationship(toProjet);
    return eo;
  }

  public static ERXFetchSpecification<EOResmat> fetchSpec() {
    return new ERXFetchSpecification<EOResmat>(_EOResmat.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOResmat> fetchAllEOResmats(EOEditingContext editingContext) {
    return _EOResmat.fetchAllEOResmats(editingContext, null);
  }

  public static NSArray<EOResmat> fetchAllEOResmats(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOResmat.fetchEOResmats(editingContext, null, sortOrderings);
  }

  public static NSArray<EOResmat> fetchEOResmats(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOResmat> fetchSpec = new ERXFetchSpecification<EOResmat>(_EOResmat.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOResmat> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOResmat fetchEOResmat(EOEditingContext editingContext, String keyName, Object value) {
    return _EOResmat.fetchEOResmat(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOResmat fetchEOResmat(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOResmat> eoObjects = _EOResmat.fetchEOResmats(editingContext, qualifier, null);
    EOResmat eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOResmat that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOResmat fetchRequiredEOResmat(EOEditingContext editingContext, String keyName, Object value) {
    return _EOResmat.fetchRequiredEOResmat(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOResmat fetchRequiredEOResmat(EOEditingContext editingContext, EOQualifier qualifier) {
    EOResmat eoObject = _EOResmat.fetchEOResmat(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOResmat that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOResmat localInstanceIn(EOEditingContext editingContext, EOResmat eo) {
    EOResmat localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOResmat> fetchMaterielProjet(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("materielProjet", _EOResmat.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOResmat> fetchMaterielProjet(EOEditingContext editingContext,
	Integer projetIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("materielProjet", _EOResmat.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(projetIdBinding, "projetId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOResmat> fetchNouceauMaterielProjet(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("nouceauMaterielProjet", _EOResmat.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOResmat> fetchNouceauMaterielProjet(EOEditingContext editingContext,
	Integer projetIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("nouceauMaterielProjet", _EOResmat.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(projetIdBinding, "projetId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
