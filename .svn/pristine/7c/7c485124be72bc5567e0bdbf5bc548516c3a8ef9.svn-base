// DO NOT EDIT.  Make changes to EOPersonnelUlr.java instead.
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
public abstract class _EOPersonnelUlr extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOPersonnelUlr";

  // Attribute Keys
  public static final ERXKey<String> AFFECTE_DEFENSE = new ERXKey<String>("affecteDefense");
  public static final ERXKey<String> C_LIMITE_AGE = new ERXKey<String>("cLimiteAge");
  public static final ERXKey<String> C_LOGE = new ERXKey<String>("cLoge");
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_FIN_AUTO_PROV = new ERXKey<NSTimestamp>("dFinAutoProv");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<NSTimestamp> D_SITUATION_FAMILLE = new ERXKey<NSTimestamp>("dSituationFamille");
  public static final ERXKey<Integer> NB_ENFANTS = new ERXKey<Integer>("nbEnfants");
  public static final ERXKey<Integer> NB_ENFANTS_A_CHARGE = new ERXKey<Integer>("nbEnfantsACharge");
  public static final ERXKey<String> NO_MATRICULE = new ERXKey<String>("noMatricule");
  public static final ERXKey<String> NPC = new ERXKey<String>("npc");
  public static final ERXKey<String> NUMEN = new ERXKey<String>("numen");
  public static final ERXKey<String> TEM_BUDGET_ETAT = new ERXKey<String>("temBudgetEtat");
  public static final ERXKey<String> TEM_IMPOSABLE = new ERXKey<String>("temImposable");
  public static final ERXKey<String> TEM_PAIE_SECU = new ERXKey<String>("temPaieSecu");
  public static final ERXKey<String> TEM_TITULAIRE = new ERXKey<String>("temTitulaire");
  public static final ERXKey<String> TXT_LIBRE = new ERXKey<String>("txtLibre");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr> TO_INDIVIDU = new ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr>("toIndividu");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURE = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructure");

  // Attributes
  public static final String AFFECTE_DEFENSE_KEY = AFFECTE_DEFENSE.key();
  public static final String C_LIMITE_AGE_KEY = C_LIMITE_AGE.key();
  public static final String C_LOGE_KEY = C_LOGE.key();
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_FIN_AUTO_PROV_KEY = D_FIN_AUTO_PROV.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String D_SITUATION_FAMILLE_KEY = D_SITUATION_FAMILLE.key();
  public static final String NB_ENFANTS_KEY = NB_ENFANTS.key();
  public static final String NB_ENFANTS_A_CHARGE_KEY = NB_ENFANTS_A_CHARGE.key();
  public static final String NO_MATRICULE_KEY = NO_MATRICULE.key();
  public static final String NPC_KEY = NPC.key();
  public static final String NUMEN_KEY = NUMEN.key();
  public static final String TEM_BUDGET_ETAT_KEY = TEM_BUDGET_ETAT.key();
  public static final String TEM_IMPOSABLE_KEY = TEM_IMPOSABLE.key();
  public static final String TEM_PAIE_SECU_KEY = TEM_PAIE_SECU.key();
  public static final String TEM_TITULAIRE_KEY = TEM_TITULAIRE.key();
  public static final String TXT_LIBRE_KEY = TXT_LIBRE.key();
  // Relationships
  public static final String TO_INDIVIDU_KEY = TO_INDIVIDU.key();
  public static final String TO_STRUCTURE_KEY = TO_STRUCTURE.key();

  private static Logger LOG = Logger.getLogger(_EOPersonnelUlr.class);

  public EOPersonnelUlr localInstanceIn(EOEditingContext editingContext) {
    EOPersonnelUlr localInstance = (EOPersonnelUlr)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String affecteDefense() {
    return (String) storedValueForKey(_EOPersonnelUlr.AFFECTE_DEFENSE_KEY);
  }

  public void setAffecteDefense(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating affecteDefense from " + affecteDefense() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.AFFECTE_DEFENSE_KEY);
  }

  public String cLimiteAge() {
    return (String) storedValueForKey(_EOPersonnelUlr.C_LIMITE_AGE_KEY);
  }

  public void setCLimiteAge(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating cLimiteAge from " + cLimiteAge() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.C_LIMITE_AGE_KEY);
  }

  public String cLoge() {
    return (String) storedValueForKey(_EOPersonnelUlr.C_LOGE_KEY);
  }

  public void setCLoge(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating cLoge from " + cLoge() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.C_LOGE_KEY);
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EOPersonnelUlr.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.D_CREATION_KEY);
  }

  public NSTimestamp dFinAutoProv() {
    return (NSTimestamp) storedValueForKey(_EOPersonnelUlr.D_FIN_AUTO_PROV_KEY);
  }

  public void setDFinAutoProv(NSTimestamp value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating dFinAutoProv from " + dFinAutoProv() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.D_FIN_AUTO_PROV_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EOPersonnelUlr.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.D_MODIFICATION_KEY);
  }

  public NSTimestamp dSituationFamille() {
    return (NSTimestamp) storedValueForKey(_EOPersonnelUlr.D_SITUATION_FAMILLE_KEY);
  }

  public void setDSituationFamille(NSTimestamp value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating dSituationFamille from " + dSituationFamille() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.D_SITUATION_FAMILLE_KEY);
  }

  public Integer nbEnfants() {
    return (Integer) storedValueForKey(_EOPersonnelUlr.NB_ENFANTS_KEY);
  }

  public void setNbEnfants(Integer value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating nbEnfants from " + nbEnfants() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.NB_ENFANTS_KEY);
  }

  public Integer nbEnfantsACharge() {
    return (Integer) storedValueForKey(_EOPersonnelUlr.NB_ENFANTS_A_CHARGE_KEY);
  }

  public void setNbEnfantsACharge(Integer value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating nbEnfantsACharge from " + nbEnfantsACharge() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.NB_ENFANTS_A_CHARGE_KEY);
  }

  public String noMatricule() {
    return (String) storedValueForKey(_EOPersonnelUlr.NO_MATRICULE_KEY);
  }

  public void setNoMatricule(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating noMatricule from " + noMatricule() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.NO_MATRICULE_KEY);
  }

  public String npc() {
    return (String) storedValueForKey(_EOPersonnelUlr.NPC_KEY);
  }

  public void setNpc(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating npc from " + npc() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.NPC_KEY);
  }

  public String numen() {
    return (String) storedValueForKey(_EOPersonnelUlr.NUMEN_KEY);
  }

  public void setNumen(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating numen from " + numen() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.NUMEN_KEY);
  }

  public String temBudgetEtat() {
    return (String) storedValueForKey(_EOPersonnelUlr.TEM_BUDGET_ETAT_KEY);
  }

  public void setTemBudgetEtat(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating temBudgetEtat from " + temBudgetEtat() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.TEM_BUDGET_ETAT_KEY);
  }

  public String temImposable() {
    return (String) storedValueForKey(_EOPersonnelUlr.TEM_IMPOSABLE_KEY);
  }

  public void setTemImposable(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating temImposable from " + temImposable() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.TEM_IMPOSABLE_KEY);
  }

  public String temPaieSecu() {
    return (String) storedValueForKey(_EOPersonnelUlr.TEM_PAIE_SECU_KEY);
  }

  public void setTemPaieSecu(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating temPaieSecu from " + temPaieSecu() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.TEM_PAIE_SECU_KEY);
  }

  public String temTitulaire() {
    return (String) storedValueForKey(_EOPersonnelUlr.TEM_TITULAIRE_KEY);
  }

  public void setTemTitulaire(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating temTitulaire from " + temTitulaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.TEM_TITULAIRE_KEY);
  }

  public String txtLibre() {
    return (String) storedValueForKey(_EOPersonnelUlr.TXT_LIBRE_KEY);
  }

  public void setTxtLibre(String value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
    	_EOPersonnelUlr.LOG.debug( "updating txtLibre from " + txtLibre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPersonnelUlr.TXT_LIBRE_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EOIndividuUlr toIndividu() {
    return (utt.rec.projet.server.metier.grhum.EOIndividuUlr)storedValueForKey(_EOPersonnelUlr.TO_INDIVIDU_KEY);
  }
  
  public void setToIndividu(utt.rec.projet.server.metier.grhum.EOIndividuUlr value) {
    takeStoredValueForKey(value, _EOPersonnelUlr.TO_INDIVIDU_KEY);
  }

  public void setToIndividuRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
      _EOPersonnelUlr.LOG.debug("updating toIndividu from " + toIndividu() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToIndividu(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOIndividuUlr oldValue = toIndividu();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPersonnelUlr.TO_INDIVIDU_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPersonnelUlr.TO_INDIVIDU_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOStructureUlr toStructure() {
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr)storedValueForKey(_EOPersonnelUlr.TO_STRUCTURE_KEY);
  }
  
  public void setToStructure(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    takeStoredValueForKey(value, _EOPersonnelUlr.TO_STRUCTURE_KEY);
  }

  public void setToStructureRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    if (_EOPersonnelUlr.LOG.isDebugEnabled()) {
      _EOPersonnelUlr.LOG.debug("updating toStructure from " + toStructure() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStructure(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOStructureUlr oldValue = toStructure();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPersonnelUlr.TO_STRUCTURE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPersonnelUlr.TO_STRUCTURE_KEY);
    }
  }
  

  public static EOPersonnelUlr createEOPersonnelUlr(EOEditingContext editingContext, NSTimestamp dCreation
, NSTimestamp dModification
, String temBudgetEtat
, String temImposable
, String temPaieSecu
, String temTitulaire
, utt.rec.projet.server.metier.grhum.EOIndividuUlr toIndividu) {
    EOPersonnelUlr eo = (EOPersonnelUlr) EOUtilities.createAndInsertInstance(editingContext, _EOPersonnelUlr.ENTITY_NAME);    
		eo.setDCreation(dCreation);
		eo.setDModification(dModification);
		eo.setTemBudgetEtat(temBudgetEtat);
		eo.setTemImposable(temImposable);
		eo.setTemPaieSecu(temPaieSecu);
		eo.setTemTitulaire(temTitulaire);
    eo.setToIndividuRelationship(toIndividu);
    return eo;
  }

  public static ERXFetchSpecification<EOPersonnelUlr> fetchSpec() {
    return new ERXFetchSpecification<EOPersonnelUlr>(_EOPersonnelUlr.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOPersonnelUlr> fetchAllEOPersonnelUlrs(EOEditingContext editingContext) {
    return _EOPersonnelUlr.fetchAllEOPersonnelUlrs(editingContext, null);
  }

  public static NSArray<EOPersonnelUlr> fetchAllEOPersonnelUlrs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOPersonnelUlr.fetchEOPersonnelUlrs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOPersonnelUlr> fetchEOPersonnelUlrs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOPersonnelUlr> fetchSpec = new ERXFetchSpecification<EOPersonnelUlr>(_EOPersonnelUlr.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOPersonnelUlr> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOPersonnelUlr fetchEOPersonnelUlr(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPersonnelUlr.fetchEOPersonnelUlr(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPersonnelUlr fetchEOPersonnelUlr(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOPersonnelUlr> eoObjects = _EOPersonnelUlr.fetchEOPersonnelUlrs(editingContext, qualifier, null);
    EOPersonnelUlr eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOPersonnelUlr that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPersonnelUlr fetchRequiredEOPersonnelUlr(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPersonnelUlr.fetchRequiredEOPersonnelUlr(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPersonnelUlr fetchRequiredEOPersonnelUlr(EOEditingContext editingContext, EOQualifier qualifier) {
    EOPersonnelUlr eoObject = _EOPersonnelUlr.fetchEOPersonnelUlr(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOPersonnelUlr that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPersonnelUlr localInstanceIn(EOEditingContext editingContext, EOPersonnelUlr eo) {
    EOPersonnelUlr localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
