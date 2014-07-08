// DO NOT EDIT.  Make changes to EOPosterh.java instead.
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
public abstract class _EOPosterh extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOPosterh";

  // Attribute Keys
  public static final ERXKey<java.math.BigDecimal> COUTESTIME = new ERXKey<java.math.BigDecimal>("coutestime");
  public static final ERXKey<NSTimestamp> CREADATE = new ERXKey<NSTimestamp>("creadate");
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<String> DUREE_RECRUE = new ERXKey<String>("dureeRecrue");
  public static final ERXKey<String> MAJAUTEUR = new ERXKey<String>("majauteur");
  public static final ERXKey<NSTimestamp> MAJDATE = new ERXKey<NSTimestamp>("majdate");
  public static final ERXKey<String> NOM_STRUCTURE = new ERXKey<String>("nomStructure");
  public static final ERXKey<String> POSTELIB = new ERXKey<String>("postelib");
  public static final ERXKey<Integer> PROJET_ID = new ERXKey<Integer>("projetId");
  public static final ERXKey<String> TEMVALIDE = new ERXKey<String>("temvalide");
  public static final ERXKey<String> TXFINANCEMENT = new ERXKey<String>("txfinancement");
  public static final ERXKey<Integer> TYPRHCM_ID = new ERXKey<Integer>("typrhcmId");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOVtyprhcm> TO_CATEGORIE_RH = new ERXKey<utt.rec.projet.server.metier.admrec.EOVtyprhcm>("toCategorieRh");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");

  // Attributes
  public static final String COUTESTIME_KEY = COUTESTIME.key();
  public static final String CREADATE_KEY = CREADATE.key();
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String DUREE_RECRUE_KEY = DUREE_RECRUE.key();
  public static final String MAJAUTEUR_KEY = MAJAUTEUR.key();
  public static final String MAJDATE_KEY = MAJDATE.key();
  public static final String NOM_STRUCTURE_KEY = NOM_STRUCTURE.key();
  public static final String POSTELIB_KEY = POSTELIB.key();
  public static final String PROJET_ID_KEY = PROJET_ID.key();
  public static final String TEMVALIDE_KEY = TEMVALIDE.key();
  public static final String TXFINANCEMENT_KEY = TXFINANCEMENT.key();
  public static final String TYPRHCM_ID_KEY = TYPRHCM_ID.key();
  // Relationships
  public static final String TO_CATEGORIE_RH_KEY = TO_CATEGORIE_RH.key();
  public static final String TO_PROJET_KEY = TO_PROJET.key();

  private static Logger LOG = Logger.getLogger(_EOPosterh.class);

  public EOPosterh localInstanceIn(EOEditingContext editingContext) {
    EOPosterh localInstance = (EOPosterh)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public java.math.BigDecimal coutestime() {
    return (java.math.BigDecimal) storedValueForKey(_EOPosterh.COUTESTIME_KEY);
  }

  public void setCoutestime(java.math.BigDecimal value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating coutestime from " + coutestime() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.COUTESTIME_KEY);
  }

  public NSTimestamp creadate() {
    return (NSTimestamp) storedValueForKey(_EOPosterh.CREADATE_KEY);
  }

  public void setCreadate(NSTimestamp value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating creadate from " + creadate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.CREADATE_KEY);
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOPosterh.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.C_STRUCTURE_KEY);
  }

  public String dureeRecrue() {
    return (String) storedValueForKey(_EOPosterh.DUREE_RECRUE_KEY);
  }

  public void setDureeRecrue(String value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating dureeRecrue from " + dureeRecrue() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.DUREE_RECRUE_KEY);
  }

  public String majauteur() {
    return (String) storedValueForKey(_EOPosterh.MAJAUTEUR_KEY);
  }

  public void setMajauteur(String value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating majauteur from " + majauteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.MAJAUTEUR_KEY);
  }

  public NSTimestamp majdate() {
    return (NSTimestamp) storedValueForKey(_EOPosterh.MAJDATE_KEY);
  }

  public void setMajdate(NSTimestamp value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating majdate from " + majdate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.MAJDATE_KEY);
  }

  public String nomStructure() {
    return (String) storedValueForKey(_EOPosterh.NOM_STRUCTURE_KEY);
  }

  public void setNomStructure(String value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating nomStructure from " + nomStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.NOM_STRUCTURE_KEY);
  }

  public String postelib() {
    return (String) storedValueForKey(_EOPosterh.POSTELIB_KEY);
  }

  public void setPostelib(String value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating postelib from " + postelib() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.POSTELIB_KEY);
  }

  public Integer projetId() {
    return (Integer) storedValueForKey(_EOPosterh.PROJET_ID_KEY);
  }

  public void setProjetId(Integer value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating projetId from " + projetId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.PROJET_ID_KEY);
  }

  public String temvalide() {
    return (String) storedValueForKey(_EOPosterh.TEMVALIDE_KEY);
  }

  public void setTemvalide(String value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating temvalide from " + temvalide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.TEMVALIDE_KEY);
  }

  public String txfinancement() {
    return (String) storedValueForKey(_EOPosterh.TXFINANCEMENT_KEY);
  }

  public void setTxfinancement(String value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating txfinancement from " + txfinancement() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.TXFINANCEMENT_KEY);
  }

  public Integer typrhcmId() {
    return (Integer) storedValueForKey(_EOPosterh.TYPRHCM_ID_KEY);
  }

  public void setTyprhcmId(Integer value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
    	_EOPosterh.LOG.debug( "updating typrhcmId from " + typrhcmId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPosterh.TYPRHCM_ID_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOVtyprhcm toCategorieRh() {
    return (utt.rec.projet.server.metier.admrec.EOVtyprhcm)storedValueForKey(_EOPosterh.TO_CATEGORIE_RH_KEY);
  }
  
  public void setToCategorieRh(utt.rec.projet.server.metier.admrec.EOVtyprhcm value) {
    takeStoredValueForKey(value, _EOPosterh.TO_CATEGORIE_RH_KEY);
  }

  public void setToCategorieRhRelationship(utt.rec.projet.server.metier.admrec.EOVtyprhcm value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
      _EOPosterh.LOG.debug("updating toCategorieRh from " + toCategorieRh() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToCategorieRh(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOVtyprhcm oldValue = toCategorieRh();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPosterh.TO_CATEGORIE_RH_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPosterh.TO_CATEGORIE_RH_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOPosterh.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOPosterh.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOPosterh.LOG.isDebugEnabled()) {
      _EOPosterh.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPosterh.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPosterh.TO_PROJET_KEY);
    }
  }
  

  public static EOPosterh createEOPosterh(EOEditingContext editingContext, java.math.BigDecimal coutestime
, String cStructure
, String dureeRecrue
, String nomStructure
, Integer projetId
, String temvalide
, Integer typrhcmId
, utt.rec.projet.server.metier.admrec.EOVtyprhcm toCategorieRh, utt.rec.projet.server.metier.admrec.EOPprec toProjet) {
    EOPosterh eo = (EOPosterh) EOUtilities.createAndInsertInstance(editingContext, _EOPosterh.ENTITY_NAME);    
		eo.setCoutestime(coutestime);
		eo.setCStructure(cStructure);
		eo.setDureeRecrue(dureeRecrue);
		eo.setNomStructure(nomStructure);
		eo.setProjetId(projetId);
		eo.setTemvalide(temvalide);
		eo.setTyprhcmId(typrhcmId);
    eo.setToCategorieRhRelationship(toCategorieRh);
    eo.setToProjetRelationship(toProjet);
    return eo;
  }

  public static ERXFetchSpecification<EOPosterh> fetchSpec() {
    return new ERXFetchSpecification<EOPosterh>(_EOPosterh.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOPosterh> fetchAllEOPosterhs(EOEditingContext editingContext) {
    return _EOPosterh.fetchAllEOPosterhs(editingContext, null);
  }

  public static NSArray<EOPosterh> fetchAllEOPosterhs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOPosterh.fetchEOPosterhs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOPosterh> fetchEOPosterhs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOPosterh> fetchSpec = new ERXFetchSpecification<EOPosterh>(_EOPosterh.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOPosterh> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOPosterh fetchEOPosterh(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPosterh.fetchEOPosterh(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPosterh fetchEOPosterh(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOPosterh> eoObjects = _EOPosterh.fetchEOPosterhs(editingContext, qualifier, null);
    EOPosterh eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOPosterh that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPosterh fetchRequiredEOPosterh(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPosterh.fetchRequiredEOPosterh(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPosterh fetchRequiredEOPosterh(EOEditingContext editingContext, EOQualifier qualifier) {
    EOPosterh eoObject = _EOPosterh.fetchEOPosterh(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOPosterh that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPosterh localInstanceIn(EOEditingContext editingContext, EOPosterh eo) {
    EOPosterh localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> fetchPosteProjet(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("posteProjet", _EOPosterh.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPosterh>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> fetchPosteProjet(EOEditingContext editingContext,
	Integer projetIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("posteProjet", _EOPosterh.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(projetIdBinding, "projetId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPosterh>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
