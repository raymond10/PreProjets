// DO NOT EDIT.  Make changes to EOPersonnel.java instead.
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
public abstract class _EOPersonnel extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOPersonnel";

  // Attribute Keys
  public static final ERXKey<java.math.BigDecimal> COUTESTIME = new ERXKey<java.math.BigDecimal>("coutestime");
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<Integer> NO_INDIVIDU = new ERXKey<Integer>("noIndividu");
  public static final ERXKey<String> NOM_PERSONNEL = new ERXKey<String>("nomPersonnel");
  public static final ERXKey<String> NOM_STRUCTURE = new ERXKey<String>("nomStructure");
  public static final ERXKey<String> TEMPSUITL = new ERXKey<String>("tempsuitl");
  public static final ERXKey<String> TEMVALIDE = new ERXKey<String>("temvalide");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJET = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjet");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOVrhcmval> TO_VRHCMVAL = new ERXKey<utt.rec.projet.server.metier.admrec.EOVrhcmval>("toVrhcmval");

  // Attributes
  public static final String COUTESTIME_KEY = COUTESTIME.key();
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String NO_INDIVIDU_KEY = NO_INDIVIDU.key();
  public static final String NOM_PERSONNEL_KEY = NOM_PERSONNEL.key();
  public static final String NOM_STRUCTURE_KEY = NOM_STRUCTURE.key();
  public static final String TEMPSUITL_KEY = TEMPSUITL.key();
  public static final String TEMVALIDE_KEY = TEMVALIDE.key();
  // Relationships
  public static final String TO_PROJET_KEY = TO_PROJET.key();
  public static final String TO_VRHCMVAL_KEY = TO_VRHCMVAL.key();

  private static Logger LOG = Logger.getLogger(_EOPersonnel.class);

  public EOPersonnel localInstanceIn(EOEditingContext editingContext) {
    EOPersonnel localInstance = (EOPersonnel)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public java.math.BigDecimal coutestime() {
    return (java.math.BigDecimal) storedValueForKey(_EOPersonnel.COUTESTIME_KEY);
  }

  public void setCoutestime(java.math.BigDecimal value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
    	_EOPersonnel.LOG.debug( "updating coutestime from " + coutestime() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnel.COUTESTIME_KEY);
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOPersonnel.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
    	_EOPersonnel.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnel.C_STRUCTURE_KEY);
  }

  public Integer noIndividu() {
    return (Integer) storedValueForKey(_EOPersonnel.NO_INDIVIDU_KEY);
  }

  public void setNoIndividu(Integer value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
    	_EOPersonnel.LOG.debug( "updating noIndividu from " + noIndividu() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnel.NO_INDIVIDU_KEY);
  }

  public String nomPersonnel() {
    return (String) storedValueForKey(_EOPersonnel.NOM_PERSONNEL_KEY);
  }

  public void setNomPersonnel(String value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
    	_EOPersonnel.LOG.debug( "updating nomPersonnel from " + nomPersonnel() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnel.NOM_PERSONNEL_KEY);
  }

  public String nomStructure() {
    return (String) storedValueForKey(_EOPersonnel.NOM_STRUCTURE_KEY);
  }

  public void setNomStructure(String value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
    	_EOPersonnel.LOG.debug( "updating nomStructure from " + nomStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnel.NOM_STRUCTURE_KEY);
  }

  public String tempsuitl() {
    return (String) storedValueForKey(_EOPersonnel.TEMPSUITL_KEY);
  }

  public void setTempsuitl(String value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
    	_EOPersonnel.LOG.debug( "updating tempsuitl from " + tempsuitl() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnel.TEMPSUITL_KEY);
  }

  public String temvalide() {
    return (String) storedValueForKey(_EOPersonnel.TEMVALIDE_KEY);
  }

  public void setTemvalide(String value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
    	_EOPersonnel.LOG.debug( "updating temvalide from " + temvalide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnel.TEMVALIDE_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOPprec toProjet() {
    return (utt.rec.projet.server.metier.admrec.EOPprec)storedValueForKey(_EOPersonnel.TO_PROJET_KEY);
  }
  
  public void setToProjet(utt.rec.projet.server.metier.admrec.EOPprec value) {
    takeStoredValueForKey(value, _EOPersonnel.TO_PROJET_KEY);
  }

  public void setToProjetRelationship(utt.rec.projet.server.metier.admrec.EOPprec value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
      _EOPersonnel.LOG.debug("updating toProjet from " + toProjet() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToProjet(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOPprec oldValue = toProjet();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPersonnel.TO_PROJET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPersonnel.TO_PROJET_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOVrhcmval toVrhcmval() {
    return (utt.rec.projet.server.metier.admrec.EOVrhcmval)storedValueForKey(_EOPersonnel.TO_VRHCMVAL_KEY);
  }
  
  public void setToVrhcmval(utt.rec.projet.server.metier.admrec.EOVrhcmval value) {
    takeStoredValueForKey(value, _EOPersonnel.TO_VRHCMVAL_KEY);
  }

  public void setToVrhcmvalRelationship(utt.rec.projet.server.metier.admrec.EOVrhcmval value) {
    if (_EOPersonnel.LOG.isDebugEnabled()) {
      _EOPersonnel.LOG.debug("updating toVrhcmval from " + toVrhcmval() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToVrhcmval(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOVrhcmval oldValue = toVrhcmval();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPersonnel.TO_VRHCMVAL_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPersonnel.TO_VRHCMVAL_KEY);
    }
  }
  

  public static EOPersonnel createEOPersonnel(EOEditingContext editingContext, java.math.BigDecimal coutestime
, String cStructure
, Integer noIndividu
, String nomPersonnel
, String nomStructure
, String temvalide
, utt.rec.projet.server.metier.admrec.EOPprec toProjet, utt.rec.projet.server.metier.admrec.EOVrhcmval toVrhcmval) {
    EOPersonnel eo = (EOPersonnel) EOUtilities.createAndInsertInstance(editingContext, _EOPersonnel.ENTITY_NAME);    
		eo.setCoutestime(coutestime);
		eo.setCStructure(cStructure);
		eo.setNoIndividu(noIndividu);
		eo.setNomPersonnel(nomPersonnel);
		eo.setNomStructure(nomStructure);
		eo.setTemvalide(temvalide);
    eo.setToProjetRelationship(toProjet);
    eo.setToVrhcmvalRelationship(toVrhcmval);
    return eo;
  }

  public static ERXFetchSpecification<EOPersonnel> fetchSpec() {
    return new ERXFetchSpecification<EOPersonnel>(_EOPersonnel.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOPersonnel> fetchAllEOPersonnels(EOEditingContext editingContext) {
    return _EOPersonnel.fetchAllEOPersonnels(editingContext, null);
  }

  public static NSArray<EOPersonnel> fetchAllEOPersonnels(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOPersonnel.fetchEOPersonnels(editingContext, null, sortOrderings);
  }

  public static NSArray<EOPersonnel> fetchEOPersonnels(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOPersonnel> fetchSpec = new ERXFetchSpecification<EOPersonnel>(_EOPersonnel.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOPersonnel> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOPersonnel fetchEOPersonnel(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPersonnel.fetchEOPersonnel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPersonnel fetchEOPersonnel(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOPersonnel> eoObjects = _EOPersonnel.fetchEOPersonnels(editingContext, qualifier, null);
    EOPersonnel eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOPersonnel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPersonnel fetchRequiredEOPersonnel(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPersonnel.fetchRequiredEOPersonnel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPersonnel fetchRequiredEOPersonnel(EOEditingContext editingContext, EOQualifier qualifier) {
    EOPersonnel eoObject = _EOPersonnel.fetchEOPersonnel(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOPersonnel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPersonnel localInstanceIn(EOEditingContext editingContext, EOPersonnel eo) {
    EOPersonnel localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> fetchPersonnelProjet(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("personnelProjet", _EOPersonnel.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> fetchPersonnelProjet(EOEditingContext editingContext,
	Integer projetIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("personnelProjet", _EOPersonnel.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(projetIdBinding, "projetId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> fetchUnPersonnel(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("unPersonnel", _EOPersonnel.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> fetchUnPersonnel(EOEditingContext editingContext,
	String cStructureBinding,
	Integer noIndividuBinding,
	Integer projetIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("unPersonnel", _EOPersonnel.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(cStructureBinding, "cStructure");
    bindings.takeValueForKey(noIndividuBinding, "noIndividu");
    bindings.takeValueForKey(projetIdBinding, "projetId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
