// DO NOT EDIT.  Make changes to EOCompte.java instead.
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
public abstract class _EOCompte extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOCompte";

  // Attribute Keys
  public static final ERXKey<String> CPT_AUTO_MODIF = new ERXKey<String>("cptAutoModif");
  public static final ERXKey<String> CPT_CHARTE = new ERXKey<String>("cptCharte");
  public static final ERXKey<String> CPT_COMMENTAIRE = new ERXKey<String>("cptCommentaire");
  public static final ERXKey<String> CPT_CONNEXION = new ERXKey<String>("cptConnexion");
  public static final ERXKey<Double> CPT_CREATEUR = new ERXKey<Double>("cptCreateur");
  public static final ERXKey<String> CPT_CRYPTE = new ERXKey<String>("cptCrypte");
  public static final ERXKey<NSTimestamp> CPT_DATE_CHARTE = new ERXKey<NSTimestamp>("cptDateCharte");
  public static final ERXKey<NSTimestamp> CPT_DEBUT_VALIDE = new ERXKey<NSTimestamp>("cptDebutValide");
  public static final ERXKey<String> CPT_DOMAINE = new ERXKey<String>("cptDomaine");
  public static final ERXKey<String> CPT_EMAIL = new ERXKey<String>("cptEmail");
  public static final ERXKey<NSTimestamp> CPT_FIN_VALIDE = new ERXKey<NSTimestamp>("cptFinValide");
  public static final ERXKey<Double> CPT_GID = new ERXKey<Double>("cptGid");
  public static final ERXKey<String> CPT_HOME = new ERXKey<String>("cptHome");
  public static final ERXKey<String> CPT_LISTE_ROUGE = new ERXKey<String>("cptListeRouge");
  public static final ERXKey<String> CPT_LOGIN = new ERXKey<String>("cptLogin");
  public static final ERXKey<Double> CPT_MODIFICATEUR = new ERXKey<Double>("cptModificateur");
  public static final ERXKey<String> CPT_PASSWD = new ERXKey<String>("cptPasswd");
  public static final ERXKey<String> CPT_PASSWD_CLAIR = new ERXKey<String>("cptPasswdClair");
  public static final ERXKey<String> CPT_PRINCIPAL = new ERXKey<String>("cptPrincipal");
  public static final ERXKey<String> CPT_QUESTION = new ERXKey<String>("cptQuestion");
  public static final ERXKey<String> CPT_REPONSE = new ERXKey<String>("cptReponse");
  public static final ERXKey<String> CPT_SHELL = new ERXKey<String>("cptShell");
  public static final ERXKey<String> CPT_TYPE = new ERXKey<String>("cptType");
  public static final ERXKey<String> CPT_TYPE_CONNEXION = new ERXKey<String>("cptTypeConnexion");
  public static final ERXKey<Double> CPT_UID = new ERXKey<Double>("cptUid");
  public static final ERXKey<Double> CPT_UID_GID = new ERXKey<Double>("cptUidGid");
  public static final ERXKey<String> CPT_VALIDE = new ERXKey<String>("cptValide");
  public static final ERXKey<String> CPT_VLAN = new ERXKey<String>("cptVlan");
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<Integer> PERS_ID = new ERXKey<Integer>("persId");
  public static final ERXKey<Long> TCRY_ORDRE = new ERXKey<Long>("tcryOrdre");
  public static final ERXKey<String> TVPN_CODE = new ERXKey<String>("tvpnCode");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne> TO_PERSONNE = new ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne>("toPersonne");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartCompte> TO_REPART_COMPTE = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartCompte>("toRepartCompte");

  // Attributes
  public static final String CPT_AUTO_MODIF_KEY = CPT_AUTO_MODIF.key();
  public static final String CPT_CHARTE_KEY = CPT_CHARTE.key();
  public static final String CPT_COMMENTAIRE_KEY = CPT_COMMENTAIRE.key();
  public static final String CPT_CONNEXION_KEY = CPT_CONNEXION.key();
  public static final String CPT_CREATEUR_KEY = CPT_CREATEUR.key();
  public static final String CPT_CRYPTE_KEY = CPT_CRYPTE.key();
  public static final String CPT_DATE_CHARTE_KEY = CPT_DATE_CHARTE.key();
  public static final String CPT_DEBUT_VALIDE_KEY = CPT_DEBUT_VALIDE.key();
  public static final String CPT_DOMAINE_KEY = CPT_DOMAINE.key();
  public static final String CPT_EMAIL_KEY = CPT_EMAIL.key();
  public static final String CPT_FIN_VALIDE_KEY = CPT_FIN_VALIDE.key();
  public static final String CPT_GID_KEY = CPT_GID.key();
  public static final String CPT_HOME_KEY = CPT_HOME.key();
  public static final String CPT_LISTE_ROUGE_KEY = CPT_LISTE_ROUGE.key();
  public static final String CPT_LOGIN_KEY = CPT_LOGIN.key();
  public static final String CPT_MODIFICATEUR_KEY = CPT_MODIFICATEUR.key();
  public static final String CPT_PASSWD_KEY = CPT_PASSWD.key();
  public static final String CPT_PASSWD_CLAIR_KEY = CPT_PASSWD_CLAIR.key();
  public static final String CPT_PRINCIPAL_KEY = CPT_PRINCIPAL.key();
  public static final String CPT_QUESTION_KEY = CPT_QUESTION.key();
  public static final String CPT_REPONSE_KEY = CPT_REPONSE.key();
  public static final String CPT_SHELL_KEY = CPT_SHELL.key();
  public static final String CPT_TYPE_KEY = CPT_TYPE.key();
  public static final String CPT_TYPE_CONNEXION_KEY = CPT_TYPE_CONNEXION.key();
  public static final String CPT_UID_KEY = CPT_UID.key();
  public static final String CPT_UID_GID_KEY = CPT_UID_GID.key();
  public static final String CPT_VALIDE_KEY = CPT_VALIDE.key();
  public static final String CPT_VLAN_KEY = CPT_VLAN.key();
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String PERS_ID_KEY = PERS_ID.key();
  public static final String TCRY_ORDRE_KEY = TCRY_ORDRE.key();
  public static final String TVPN_CODE_KEY = TVPN_CODE.key();
  // Relationships
  public static final String TO_PERSONNE_KEY = TO_PERSONNE.key();
  public static final String TO_REPART_COMPTE_KEY = TO_REPART_COMPTE.key();

  private static Logger LOG = Logger.getLogger(_EOCompte.class);

  public EOCompte localInstanceIn(EOEditingContext editingContext) {
    EOCompte localInstance = (EOCompte)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cptAutoModif() {
    return (String) storedValueForKey(_EOCompte.CPT_AUTO_MODIF_KEY);
  }

  public void setCptAutoModif(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptAutoModif from " + cptAutoModif() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_AUTO_MODIF_KEY);
  }

  public String cptCharte() {
    return (String) storedValueForKey(_EOCompte.CPT_CHARTE_KEY);
  }

  public void setCptCharte(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptCharte from " + cptCharte() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_CHARTE_KEY);
  }

  public String cptCommentaire() {
    return (String) storedValueForKey(_EOCompte.CPT_COMMENTAIRE_KEY);
  }

  public void setCptCommentaire(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptCommentaire from " + cptCommentaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_COMMENTAIRE_KEY);
  }

  public String cptConnexion() {
    return (String) storedValueForKey(_EOCompte.CPT_CONNEXION_KEY);
  }

  public void setCptConnexion(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptConnexion from " + cptConnexion() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_CONNEXION_KEY);
  }

  public Double cptCreateur() {
    return (Double) storedValueForKey(_EOCompte.CPT_CREATEUR_KEY);
  }

  public void setCptCreateur(Double value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptCreateur from " + cptCreateur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_CREATEUR_KEY);
  }

  public String cptCrypte() {
    return (String) storedValueForKey(_EOCompte.CPT_CRYPTE_KEY);
  }

  public void setCptCrypte(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptCrypte from " + cptCrypte() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_CRYPTE_KEY);
  }

  public NSTimestamp cptDateCharte() {
    return (NSTimestamp) storedValueForKey(_EOCompte.CPT_DATE_CHARTE_KEY);
  }

  public void setCptDateCharte(NSTimestamp value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptDateCharte from " + cptDateCharte() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_DATE_CHARTE_KEY);
  }

  public NSTimestamp cptDebutValide() {
    return (NSTimestamp) storedValueForKey(_EOCompte.CPT_DEBUT_VALIDE_KEY);
  }

  public void setCptDebutValide(NSTimestamp value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptDebutValide from " + cptDebutValide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_DEBUT_VALIDE_KEY);
  }

  public String cptDomaine() {
    return (String) storedValueForKey(_EOCompte.CPT_DOMAINE_KEY);
  }

  public void setCptDomaine(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptDomaine from " + cptDomaine() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_DOMAINE_KEY);
  }

  public String cptEmail() {
    return (String) storedValueForKey(_EOCompte.CPT_EMAIL_KEY);
  }

  public void setCptEmail(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptEmail from " + cptEmail() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_EMAIL_KEY);
  }

  public NSTimestamp cptFinValide() {
    return (NSTimestamp) storedValueForKey(_EOCompte.CPT_FIN_VALIDE_KEY);
  }

  public void setCptFinValide(NSTimestamp value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptFinValide from " + cptFinValide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_FIN_VALIDE_KEY);
  }

  public Double cptGid() {
    return (Double) storedValueForKey(_EOCompte.CPT_GID_KEY);
  }

  public void setCptGid(Double value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptGid from " + cptGid() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_GID_KEY);
  }

  public String cptHome() {
    return (String) storedValueForKey(_EOCompte.CPT_HOME_KEY);
  }

  public void setCptHome(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptHome from " + cptHome() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_HOME_KEY);
  }

  public String cptListeRouge() {
    return (String) storedValueForKey(_EOCompte.CPT_LISTE_ROUGE_KEY);
  }

  public void setCptListeRouge(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptListeRouge from " + cptListeRouge() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_LISTE_ROUGE_KEY);
  }

  public String cptLogin() {
    return (String) storedValueForKey(_EOCompte.CPT_LOGIN_KEY);
  }

  public void setCptLogin(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptLogin from " + cptLogin() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_LOGIN_KEY);
  }

  public Double cptModificateur() {
    return (Double) storedValueForKey(_EOCompte.CPT_MODIFICATEUR_KEY);
  }

  public void setCptModificateur(Double value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptModificateur from " + cptModificateur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_MODIFICATEUR_KEY);
  }

  public String cptPasswd() {
    return (String) storedValueForKey(_EOCompte.CPT_PASSWD_KEY);
  }

  public void setCptPasswd(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptPasswd from " + cptPasswd() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_PASSWD_KEY);
  }

  public String cptPasswdClair() {
    return (String) storedValueForKey(_EOCompte.CPT_PASSWD_CLAIR_KEY);
  }

  public void setCptPasswdClair(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptPasswdClair from " + cptPasswdClair() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_PASSWD_CLAIR_KEY);
  }

  public String cptPrincipal() {
    return (String) storedValueForKey(_EOCompte.CPT_PRINCIPAL_KEY);
  }

  public void setCptPrincipal(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptPrincipal from " + cptPrincipal() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_PRINCIPAL_KEY);
  }

  public String cptQuestion() {
    return (String) storedValueForKey(_EOCompte.CPT_QUESTION_KEY);
  }

  public void setCptQuestion(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptQuestion from " + cptQuestion() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_QUESTION_KEY);
  }

  public String cptReponse() {
    return (String) storedValueForKey(_EOCompte.CPT_REPONSE_KEY);
  }

  public void setCptReponse(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptReponse from " + cptReponse() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_REPONSE_KEY);
  }

  public String cptShell() {
    return (String) storedValueForKey(_EOCompte.CPT_SHELL_KEY);
  }

  public void setCptShell(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptShell from " + cptShell() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_SHELL_KEY);
  }

  public String cptType() {
    return (String) storedValueForKey(_EOCompte.CPT_TYPE_KEY);
  }

  public void setCptType(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptType from " + cptType() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_TYPE_KEY);
  }

  public String cptTypeConnexion() {
    return (String) storedValueForKey(_EOCompte.CPT_TYPE_CONNEXION_KEY);
  }

  public void setCptTypeConnexion(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptTypeConnexion from " + cptTypeConnexion() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_TYPE_CONNEXION_KEY);
  }

  public Double cptUid() {
    return (Double) storedValueForKey(_EOCompte.CPT_UID_KEY);
  }

  public void setCptUid(Double value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptUid from " + cptUid() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_UID_KEY);
  }

  public Double cptUidGid() {
    return (Double) storedValueForKey(_EOCompte.CPT_UID_GID_KEY);
  }

  public void setCptUidGid(Double value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptUidGid from " + cptUidGid() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_UID_GID_KEY);
  }

  public String cptValide() {
    return (String) storedValueForKey(_EOCompte.CPT_VALIDE_KEY);
  }

  public void setCptValide(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptValide from " + cptValide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_VALIDE_KEY);
  }

  public String cptVlan() {
    return (String) storedValueForKey(_EOCompte.CPT_VLAN_KEY);
  }

  public void setCptVlan(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating cptVlan from " + cptVlan() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.CPT_VLAN_KEY);
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EOCompte.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EOCompte.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.D_MODIFICATION_KEY);
  }

  public Integer persId() {
    return (Integer) storedValueForKey(_EOCompte.PERS_ID_KEY);
  }

  public void setPersId(Integer value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating persId from " + persId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.PERS_ID_KEY);
  }

  public Long tcryOrdre() {
    return (Long) storedValueForKey(_EOCompte.TCRY_ORDRE_KEY);
  }

  public void setTcryOrdre(Long value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating tcryOrdre from " + tcryOrdre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.TCRY_ORDRE_KEY);
  }

  public String tvpnCode() {
    return (String) storedValueForKey(_EOCompte.TVPN_CODE_KEY);
  }

  public void setTvpnCode(String value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
    	_EOCompte.LOG.debug( "updating tvpnCode from " + tvpnCode() + " to " + value);
    }
    takeStoredValueForKey(value, _EOCompte.TVPN_CODE_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EOPersonne toPersonne() {
    return (utt.rec.projet.server.metier.grhum.EOPersonne)storedValueForKey(_EOCompte.TO_PERSONNE_KEY);
  }
  
  public void setToPersonne(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    takeStoredValueForKey(value, _EOCompte.TO_PERSONNE_KEY);
  }

  public void setToPersonneRelationship(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
      _EOCompte.LOG.debug("updating toPersonne from " + toPersonne() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPersonne(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOPersonne oldValue = toPersonne();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOCompte.TO_PERSONNE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOCompte.TO_PERSONNE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EORepartCompte toRepartCompte() {
    return (utt.rec.projet.server.metier.grhum.EORepartCompte)storedValueForKey(_EOCompte.TO_REPART_COMPTE_KEY);
  }
  
  public void setToRepartCompte(utt.rec.projet.server.metier.grhum.EORepartCompte value) {
    takeStoredValueForKey(value, _EOCompte.TO_REPART_COMPTE_KEY);
  }

  public void setToRepartCompteRelationship(utt.rec.projet.server.metier.grhum.EORepartCompte value) {
    if (_EOCompte.LOG.isDebugEnabled()) {
      _EOCompte.LOG.debug("updating toRepartCompte from " + toRepartCompte() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToRepartCompte(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EORepartCompte oldValue = toRepartCompte();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOCompte.TO_REPART_COMPTE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOCompte.TO_REPART_COMPTE_KEY);
    }
  }
  

  public static EOCompte createEOCompte(EOEditingContext editingContext, String cptAutoModif
, String cptCharte
, String cptConnexion
, String cptCrypte
, String cptListeRouge
, String cptLogin
, String cptPasswd
, String cptPrincipal
, String cptValide
, String cptVlan
, NSTimestamp dCreation
, NSTimestamp dModification
, String tvpnCode
, utt.rec.projet.server.metier.grhum.EORepartCompte toRepartCompte) {
    EOCompte eo = (EOCompte) EOUtilities.createAndInsertInstance(editingContext, _EOCompte.ENTITY_NAME);    
		eo.setCptAutoModif(cptAutoModif);
		eo.setCptCharte(cptCharte);
		eo.setCptConnexion(cptConnexion);
		eo.setCptCrypte(cptCrypte);
		eo.setCptListeRouge(cptListeRouge);
		eo.setCptLogin(cptLogin);
		eo.setCptPasswd(cptPasswd);
		eo.setCptPrincipal(cptPrincipal);
		eo.setCptValide(cptValide);
		eo.setCptVlan(cptVlan);
		eo.setDCreation(dCreation);
		eo.setDModification(dModification);
		eo.setTvpnCode(tvpnCode);
    eo.setToRepartCompteRelationship(toRepartCompte);
    return eo;
  }

  public static ERXFetchSpecification<EOCompte> fetchSpec() {
    return new ERXFetchSpecification<EOCompte>(_EOCompte.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOCompte> fetchAllEOComptes(EOEditingContext editingContext) {
    return _EOCompte.fetchAllEOComptes(editingContext, null);
  }

  public static NSArray<EOCompte> fetchAllEOComptes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOCompte.fetchEOComptes(editingContext, null, sortOrderings);
  }

  public static NSArray<EOCompte> fetchEOComptes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOCompte> fetchSpec = new ERXFetchSpecification<EOCompte>(_EOCompte.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOCompte> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOCompte fetchEOCompte(EOEditingContext editingContext, String keyName, Object value) {
    return _EOCompte.fetchEOCompte(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOCompte fetchEOCompte(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOCompte> eoObjects = _EOCompte.fetchEOComptes(editingContext, qualifier, null);
    EOCompte eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOCompte that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOCompte fetchRequiredEOCompte(EOEditingContext editingContext, String keyName, Object value) {
    return _EOCompte.fetchRequiredEOCompte(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOCompte fetchRequiredEOCompte(EOEditingContext editingContext, EOQualifier qualifier) {
    EOCompte eoObject = _EOCompte.fetchEOCompte(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOCompte that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOCompte localInstanceIn(EOEditingContext editingContext, EOCompte eo) {
    EOCompte localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
