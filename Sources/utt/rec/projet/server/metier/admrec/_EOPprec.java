// DO NOT EDIT.  Make changes to EOPprec.java instead.
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
public abstract class _EOPprec extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOPprec";

  // Attribute Keys
  public static final ERXKey<String> BLOC_COM = new ERXKey<String>("blocCom");
  public static final ERXKey<NSTimestamp> CREADATE = new ERXKey<NSTimestamp>("creadate");
  public static final ERXKey<Integer> CRE_AUTEUR = new ERXKey<Integer>("creAuteur");
  public static final ERXKey<Integer> DIRECTEUR_POLE = new ERXKey<Integer>("DirecteurPole");
  public static final ERXKey<String> EQUIPE_PRINCIPALE = new ERXKey<String>("equipePrincipale");
  public static final ERXKey<String> ETAB_PORTEUR = new ERXKey<String>("etabPorteur");
  public static final ERXKey<String> MAJAUTEUR = new ERXKey<String>("majauteur");
  public static final ERXKey<NSTimestamp> MAJDATE = new ERXKey<NSTimestamp>("majdate");
  public static final ERXKey<String> POLE_COMPETENCE = new ERXKey<String>("poleCompetence");
  public static final ERXKey<Integer> PORTEUR = new ERXKey<Integer>("porteur");
  public static final ERXKey<String> PROJCTX = new ERXKey<String>("projctx");
  public static final ERXKey<NSTimestamp> PROJDATDEBUT = new ERXKey<NSTimestamp>("projdatdebut");
  public static final ERXKey<String> PROJDUREE = new ERXKey<String>("projduree");
  public static final ERXKey<String> PROJMTDG = new ERXKey<String>("projmtdg");
  public static final ERXKey<String> PROJNOMCOURT = new ERXKey<String>("projnomcourt");
  public static final ERXKey<String> PROJNOMLONG = new ERXKey<String>("projnomlong");
  public static final ERXKey<String> PROJOBF = new ERXKey<String>("projobf");
  public static final ERXKey<String> PROJPBLM = new ERXKey<String>("projpblm");
  public static final ERXKey<String> PROJTHETV = new ERXKey<String>("projthetv");
  public static final ERXKey<String> PROJVALIDE = new ERXKey<String>("projvalide");
  public static final ERXKey<String> SRCEFINANCE = new ERXKey<String>("srcefinance");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOAlerte> TO_ALERTES = new ERXKey<utt.rec.projet.server.metier.admrec.EOAlerte>("toAlertes");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOAxerec> TO_AXE = new ERXKey<utt.rec.projet.server.metier.admrec.EOAxerec>("toAxe");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOCommentaires> TO_COMMENTAIRES = new ERXKey<utt.rec.projet.server.metier.admrec.EOCommentaires>("toCommentaires");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTypcontrat> TO_CONTRAT = new ERXKey<utt.rec.projet.server.metier.admrec.EOTypcontrat>("toContrat");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOEquipes> TO_EQUIPE_SECONDAIRES = new ERXKey<utt.rec.projet.server.metier.admrec.EOEquipes>("toEquipeSecondaires");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTypref> TO_ETAT = new ERXKey<utt.rec.projet.server.metier.admrec.EOTypref>("toEtat");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOHistorique> TO_HISTORIQUES = new ERXKey<utt.rec.projet.server.metier.admrec.EOHistorique>("toHistoriques");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOResmat> TO_MATERIELS = new ERXKey<utt.rec.projet.server.metier.admrec.EOResmat>("toMateriels");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOMotclefs> TO_MOT_CLES = new ERXKey<utt.rec.projet.server.metier.admrec.EOMotclefs>("toMotCles");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPersonnel> TO_PERSONNEL_EXISTANTS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPersonnel>("toPersonnelExistants");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPosterh> TO_POSTE_RHS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPosterh>("toPosteRhs");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOStructure> TO_PRINCIPAL = new ERXKey<utt.rec.projet.server.metier.admrec.EOStructure>("toPrincipal");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> TO_PROJET_PARTENAIRES = new ERXKey<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>("toProjetPartenaires");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORepartaxe> TO_PROJET_REPARTAXES = new ERXKey<utt.rec.projet.server.metier.admrec.EORepartaxe>("toProjetRepartaxes");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORefthe> TO_SOUS_THEMES = new ERXKey<utt.rec.projet.server.metier.admrec.EORefthe>("toSousThemes");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOStructure> TO_STRUCTURE = new ERXKey<utt.rec.projet.server.metier.admrec.EOStructure>("toStructure");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOTypthe> TO_THEMATIQUE = new ERXKey<utt.rec.projet.server.metier.admrec.EOTypthe>("toThematique");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EORefthe> TO_THEME = new ERXKey<utt.rec.projet.server.metier.admrec.EORefthe>("toTheme");

  // Attributes
  public static final String BLOC_COM_KEY = BLOC_COM.key();
  public static final String CREADATE_KEY = CREADATE.key();
  public static final String CRE_AUTEUR_KEY = CRE_AUTEUR.key();
  public static final String DIRECTEUR_POLE_KEY = DIRECTEUR_POLE.key();
  public static final String EQUIPE_PRINCIPALE_KEY = EQUIPE_PRINCIPALE.key();
  public static final String ETAB_PORTEUR_KEY = ETAB_PORTEUR.key();
  public static final String MAJAUTEUR_KEY = MAJAUTEUR.key();
  public static final String MAJDATE_KEY = MAJDATE.key();
  public static final String POLE_COMPETENCE_KEY = POLE_COMPETENCE.key();
  public static final String PORTEUR_KEY = PORTEUR.key();
  public static final String PROJCTX_KEY = PROJCTX.key();
  public static final String PROJDATDEBUT_KEY = PROJDATDEBUT.key();
  public static final String PROJDUREE_KEY = PROJDUREE.key();
  public static final String PROJMTDG_KEY = PROJMTDG.key();
  public static final String PROJNOMCOURT_KEY = PROJNOMCOURT.key();
  public static final String PROJNOMLONG_KEY = PROJNOMLONG.key();
  public static final String PROJOBF_KEY = PROJOBF.key();
  public static final String PROJPBLM_KEY = PROJPBLM.key();
  public static final String PROJTHETV_KEY = PROJTHETV.key();
  public static final String PROJVALIDE_KEY = PROJVALIDE.key();
  public static final String SRCEFINANCE_KEY = SRCEFINANCE.key();
  // Relationships
  public static final String TO_ALERTES_KEY = TO_ALERTES.key();
  public static final String TO_AXE_KEY = TO_AXE.key();
  public static final String TO_COMMENTAIRES_KEY = TO_COMMENTAIRES.key();
  public static final String TO_CONTRAT_KEY = TO_CONTRAT.key();
  public static final String TO_EQUIPE_SECONDAIRES_KEY = TO_EQUIPE_SECONDAIRES.key();
  public static final String TO_ETAT_KEY = TO_ETAT.key();
  public static final String TO_HISTORIQUES_KEY = TO_HISTORIQUES.key();
  public static final String TO_MATERIELS_KEY = TO_MATERIELS.key();
  public static final String TO_MOT_CLES_KEY = TO_MOT_CLES.key();
  public static final String TO_PERSONNEL_EXISTANTS_KEY = TO_PERSONNEL_EXISTANTS.key();
  public static final String TO_POSTE_RHS_KEY = TO_POSTE_RHS.key();
  public static final String TO_PRINCIPAL_KEY = TO_PRINCIPAL.key();
  public static final String TO_PROJET_PARTENAIRES_KEY = TO_PROJET_PARTENAIRES.key();
  public static final String TO_PROJET_REPARTAXES_KEY = TO_PROJET_REPARTAXES.key();
  public static final String TO_SOUS_THEMES_KEY = TO_SOUS_THEMES.key();
  public static final String TO_STRUCTURE_KEY = TO_STRUCTURE.key();
  public static final String TO_THEMATIQUE_KEY = TO_THEMATIQUE.key();
  public static final String TO_THEME_KEY = TO_THEME.key();

  private static Logger LOG = Logger.getLogger(_EOPprec.class);

  public EOPprec localInstanceIn(EOEditingContext editingContext) {
    EOPprec localInstance = (EOPprec)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String blocCom() {
    return (String) storedValueForKey(_EOPprec.BLOC_COM_KEY);
  }

  public void setBlocCom(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating blocCom from " + blocCom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.BLOC_COM_KEY);
  }

  public NSTimestamp creadate() {
    return (NSTimestamp) storedValueForKey(_EOPprec.CREADATE_KEY);
  }

  public void setCreadate(NSTimestamp value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating creadate from " + creadate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.CREADATE_KEY);
  }

  public Integer creAuteur() {
    return (Integer) storedValueForKey(_EOPprec.CRE_AUTEUR_KEY);
  }

  public void setCreAuteur(Integer value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating creAuteur from " + creAuteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.CRE_AUTEUR_KEY);
  }

  public Integer DirecteurPole() {
    return (Integer) storedValueForKey(_EOPprec.DIRECTEUR_POLE_KEY);
  }

  public void setDirecteurPole(Integer value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating DirecteurPole from " + DirecteurPole() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.DIRECTEUR_POLE_KEY);
  }

  public String equipePrincipale() {
    return (String) storedValueForKey(_EOPprec.EQUIPE_PRINCIPALE_KEY);
  }

  public void setEquipePrincipale(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating equipePrincipale from " + equipePrincipale() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.EQUIPE_PRINCIPALE_KEY);
  }

  public String etabPorteur() {
    return (String) storedValueForKey(_EOPprec.ETAB_PORTEUR_KEY);
  }

  public void setEtabPorteur(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating etabPorteur from " + etabPorteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.ETAB_PORTEUR_KEY);
  }

  public String majauteur() {
    return (String) storedValueForKey(_EOPprec.MAJAUTEUR_KEY);
  }

  public void setMajauteur(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating majauteur from " + majauteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.MAJAUTEUR_KEY);
  }

  public NSTimestamp majdate() {
    return (NSTimestamp) storedValueForKey(_EOPprec.MAJDATE_KEY);
  }

  public void setMajdate(NSTimestamp value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating majdate from " + majdate() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.MAJDATE_KEY);
  }

  public String poleCompetence() {
    return (String) storedValueForKey(_EOPprec.POLE_COMPETENCE_KEY);
  }

  public void setPoleCompetence(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating poleCompetence from " + poleCompetence() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.POLE_COMPETENCE_KEY);
  }

  public Integer porteur() {
    return (Integer) storedValueForKey(_EOPprec.PORTEUR_KEY);
  }

  public void setPorteur(Integer value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating porteur from " + porteur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PORTEUR_KEY);
  }

  public String projctx() {
    return (String) storedValueForKey(_EOPprec.PROJCTX_KEY);
  }

  public void setProjctx(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projctx from " + projctx() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJCTX_KEY);
  }

  public NSTimestamp projdatdebut() {
    return (NSTimestamp) storedValueForKey(_EOPprec.PROJDATDEBUT_KEY);
  }

  public void setProjdatdebut(NSTimestamp value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projdatdebut from " + projdatdebut() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJDATDEBUT_KEY);
  }

  public String projduree() {
    return (String) storedValueForKey(_EOPprec.PROJDUREE_KEY);
  }

  public void setProjduree(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projduree from " + projduree() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJDUREE_KEY);
  }

  public String projmtdg() {
    return (String) storedValueForKey(_EOPprec.PROJMTDG_KEY);
  }

  public void setProjmtdg(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projmtdg from " + projmtdg() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJMTDG_KEY);
  }

  public String projnomcourt() {
    return (String) storedValueForKey(_EOPprec.PROJNOMCOURT_KEY);
  }

  public void setProjnomcourt(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projnomcourt from " + projnomcourt() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJNOMCOURT_KEY);
  }

  public String projnomlong() {
    return (String) storedValueForKey(_EOPprec.PROJNOMLONG_KEY);
  }

  public void setProjnomlong(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projnomlong from " + projnomlong() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJNOMLONG_KEY);
  }

  public String projobf() {
    return (String) storedValueForKey(_EOPprec.PROJOBF_KEY);
  }

  public void setProjobf(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projobf from " + projobf() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJOBF_KEY);
  }

  public String projpblm() {
    return (String) storedValueForKey(_EOPprec.PROJPBLM_KEY);
  }

  public void setProjpblm(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projpblm from " + projpblm() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJPBLM_KEY);
  }

  public String projthetv() {
    return (String) storedValueForKey(_EOPprec.PROJTHETV_KEY);
  }

  public void setProjthetv(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projthetv from " + projthetv() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJTHETV_KEY);
  }

  public String projvalide() {
    return (String) storedValueForKey(_EOPprec.PROJVALIDE_KEY);
  }

  public void setProjvalide(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating projvalide from " + projvalide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.PROJVALIDE_KEY);
  }

  public String srcefinance() {
    return (String) storedValueForKey(_EOPprec.SRCEFINANCE_KEY);
  }

  public void setSrcefinance(String value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
    	_EOPprec.LOG.debug( "updating srcefinance from " + srcefinance() + " to " + value);
    }
    takeStoredValueForKey(value, _EOPprec.SRCEFINANCE_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOAxerec toAxe() {
    return (utt.rec.projet.server.metier.admrec.EOAxerec)storedValueForKey(_EOPprec.TO_AXE_KEY);
  }
  
  public void setToAxe(utt.rec.projet.server.metier.admrec.EOAxerec value) {
    takeStoredValueForKey(value, _EOPprec.TO_AXE_KEY);
  }

  public void setToAxeRelationship(utt.rec.projet.server.metier.admrec.EOAxerec value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("updating toAxe from " + toAxe() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToAxe(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOAxerec oldValue = toAxe();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPprec.TO_AXE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPprec.TO_AXE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOTypcontrat toContrat() {
    return (utt.rec.projet.server.metier.admrec.EOTypcontrat)storedValueForKey(_EOPprec.TO_CONTRAT_KEY);
  }
  
  public void setToContrat(utt.rec.projet.server.metier.admrec.EOTypcontrat value) {
    takeStoredValueForKey(value, _EOPprec.TO_CONTRAT_KEY);
  }

  public void setToContratRelationship(utt.rec.projet.server.metier.admrec.EOTypcontrat value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("updating toContrat from " + toContrat() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToContrat(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOTypcontrat oldValue = toContrat();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPprec.TO_CONTRAT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPprec.TO_CONTRAT_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOTypref toEtat() {
    return (utt.rec.projet.server.metier.admrec.EOTypref)storedValueForKey(_EOPprec.TO_ETAT_KEY);
  }
  
  public void setToEtat(utt.rec.projet.server.metier.admrec.EOTypref value) {
    takeStoredValueForKey(value, _EOPprec.TO_ETAT_KEY);
  }

  public void setToEtatRelationship(utt.rec.projet.server.metier.admrec.EOTypref value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("updating toEtat from " + toEtat() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToEtat(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOTypref oldValue = toEtat();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPprec.TO_ETAT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPprec.TO_ETAT_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOStructure toPrincipal() {
    return (utt.rec.projet.server.metier.admrec.EOStructure)storedValueForKey(_EOPprec.TO_PRINCIPAL_KEY);
  }
  
  public void setToPrincipal(utt.rec.projet.server.metier.admrec.EOStructure value) {
    takeStoredValueForKey(value, _EOPprec.TO_PRINCIPAL_KEY);
  }

  public void setToPrincipalRelationship(utt.rec.projet.server.metier.admrec.EOStructure value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("updating toPrincipal from " + toPrincipal() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPrincipal(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOStructure oldValue = toPrincipal();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPprec.TO_PRINCIPAL_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPprec.TO_PRINCIPAL_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EORefthe toSousThemes() {
    return (utt.rec.projet.server.metier.admrec.EORefthe)storedValueForKey(_EOPprec.TO_SOUS_THEMES_KEY);
  }
  
  public void setToSousThemes(utt.rec.projet.server.metier.admrec.EORefthe value) {
    takeStoredValueForKey(value, _EOPprec.TO_SOUS_THEMES_KEY);
  }

  public void setToSousThemesRelationship(utt.rec.projet.server.metier.admrec.EORefthe value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("updating toSousThemes from " + toSousThemes() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToSousThemes(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EORefthe oldValue = toSousThemes();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPprec.TO_SOUS_THEMES_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPprec.TO_SOUS_THEMES_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOStructure toStructure() {
    return (utt.rec.projet.server.metier.admrec.EOStructure)storedValueForKey(_EOPprec.TO_STRUCTURE_KEY);
  }
  
  public void setToStructure(utt.rec.projet.server.metier.admrec.EOStructure value) {
    takeStoredValueForKey(value, _EOPprec.TO_STRUCTURE_KEY);
  }

  public void setToStructureRelationship(utt.rec.projet.server.metier.admrec.EOStructure value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("updating toStructure from " + toStructure() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStructure(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOStructure oldValue = toStructure();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPprec.TO_STRUCTURE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPprec.TO_STRUCTURE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EOTypthe toThematique() {
    return (utt.rec.projet.server.metier.admrec.EOTypthe)storedValueForKey(_EOPprec.TO_THEMATIQUE_KEY);
  }
  
  public void setToThematique(utt.rec.projet.server.metier.admrec.EOTypthe value) {
    takeStoredValueForKey(value, _EOPprec.TO_THEMATIQUE_KEY);
  }

  public void setToThematiqueRelationship(utt.rec.projet.server.metier.admrec.EOTypthe value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("updating toThematique from " + toThematique() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToThematique(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOTypthe oldValue = toThematique();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPprec.TO_THEMATIQUE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPprec.TO_THEMATIQUE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.admrec.EORefthe toTheme() {
    return (utt.rec.projet.server.metier.admrec.EORefthe)storedValueForKey(_EOPprec.TO_THEME_KEY);
  }
  
  public void setToTheme(utt.rec.projet.server.metier.admrec.EORefthe value) {
    takeStoredValueForKey(value, _EOPprec.TO_THEME_KEY);
  }

  public void setToThemeRelationship(utt.rec.projet.server.metier.admrec.EORefthe value) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("updating toTheme from " + toTheme() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToTheme(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EORefthe oldValue = toTheme();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOPprec.TO_THEME_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOPprec.TO_THEME_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> toAlertes() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAlerte>)storedValueForKey(_EOPprec.TO_ALERTES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> toAlertes(EOQualifier qualifier) {
    return toAlertes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> toAlertes(EOQualifier qualifier, boolean fetch) {
    return toAlertes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> toAlertes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOAlerte> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOAlerte.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOAlerte.fetchEOAlertes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toAlertes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOAlerte>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOAlerte>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToAlertes(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_ALERTES_KEY);
  }

  public void removeFromToAlertes(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_ALERTES_KEY);
  }

  public void addToToAlertesRelationship(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toAlertes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToAlertes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_ALERTES_KEY);
    }
  }

  public void removeFromToAlertesRelationship(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toAlertes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToAlertes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_ALERTES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOAlerte createToAlertesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOAlerte.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_ALERTES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOAlerte) eo;
  }

  public void deleteToAlertesRelationship(utt.rec.projet.server.metier.admrec.EOAlerte object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_ALERTES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToAlertesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOAlerte> objects = toAlertes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToAlertesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> toCommentaires() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires>)storedValueForKey(_EOPprec.TO_COMMENTAIRES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> toCommentaires(EOQualifier qualifier) {
    return toCommentaires(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> toCommentaires(EOQualifier qualifier, boolean fetch) {
    return toCommentaires(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> toCommentaires(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOCommentaires.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOCommentaires.fetchEOCommentaireses(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toCommentaires();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOCommentaires>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToCommentaires(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_COMMENTAIRES_KEY);
  }

  public void removeFromToCommentaires(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_COMMENTAIRES_KEY);
  }

  public void addToToCommentairesRelationship(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toCommentaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToCommentaires(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_COMMENTAIRES_KEY);
    }
  }

  public void removeFromToCommentairesRelationship(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toCommentaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToCommentaires(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_COMMENTAIRES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOCommentaires createToCommentairesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOCommentaires.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_COMMENTAIRES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOCommentaires) eo;
  }

  public void deleteToCommentairesRelationship(utt.rec.projet.server.metier.admrec.EOCommentaires object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_COMMENTAIRES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToCommentairesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOCommentaires> objects = toCommentaires().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToCommentairesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> toEquipeSecondaires() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOEquipes>)storedValueForKey(_EOPprec.TO_EQUIPE_SECONDAIRES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> toEquipeSecondaires(EOQualifier qualifier) {
    return toEquipeSecondaires(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> toEquipeSecondaires(EOQualifier qualifier, boolean fetch) {
    return toEquipeSecondaires(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> toEquipeSecondaires(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOEquipes> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOEquipes.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOEquipes.fetchEOEquipeses(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toEquipeSecondaires();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOEquipes>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOEquipes>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToEquipeSecondaires(utt.rec.projet.server.metier.admrec.EOEquipes object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_EQUIPE_SECONDAIRES_KEY);
  }

  public void removeFromToEquipeSecondaires(utt.rec.projet.server.metier.admrec.EOEquipes object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_EQUIPE_SECONDAIRES_KEY);
  }

  public void addToToEquipeSecondairesRelationship(utt.rec.projet.server.metier.admrec.EOEquipes object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toEquipeSecondaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToEquipeSecondaires(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_EQUIPE_SECONDAIRES_KEY);
    }
  }

  public void removeFromToEquipeSecondairesRelationship(utt.rec.projet.server.metier.admrec.EOEquipes object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toEquipeSecondaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToEquipeSecondaires(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_EQUIPE_SECONDAIRES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOEquipes createToEquipeSecondairesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOEquipes.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_EQUIPE_SECONDAIRES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOEquipes) eo;
  }

  public void deleteToEquipeSecondairesRelationship(utt.rec.projet.server.metier.admrec.EOEquipes object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_EQUIPE_SECONDAIRES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToEquipeSecondairesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOEquipes> objects = toEquipeSecondaires().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToEquipeSecondairesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> toHistoriques() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOHistorique>)storedValueForKey(_EOPprec.TO_HISTORIQUES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> toHistoriques(EOQualifier qualifier) {
    return toHistoriques(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> toHistoriques(EOQualifier qualifier, boolean fetch) {
    return toHistoriques(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> toHistoriques(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOHistorique> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOHistorique.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOHistorique.fetchEOHistoriques(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toHistoriques();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOHistorique>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOHistorique>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToHistoriques(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_HISTORIQUES_KEY);
  }

  public void removeFromToHistoriques(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_HISTORIQUES_KEY);
  }

  public void addToToHistoriquesRelationship(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toHistoriques relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToHistoriques(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_HISTORIQUES_KEY);
    }
  }

  public void removeFromToHistoriquesRelationship(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toHistoriques relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToHistoriques(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_HISTORIQUES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOHistorique createToHistoriquesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOHistorique.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_HISTORIQUES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOHistorique) eo;
  }

  public void deleteToHistoriquesRelationship(utt.rec.projet.server.metier.admrec.EOHistorique object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_HISTORIQUES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToHistoriquesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOHistorique> objects = toHistoriques().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToHistoriquesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)storedValueForKey(_EOPprec.TO_MATERIELS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels(EOQualifier qualifier) {
    return toMateriels(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels(EOQualifier qualifier, boolean fetch) {
    return toMateriels(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOResmat> toMateriels(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOResmat> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOResmat.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOResmat.fetchEOResmats(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toMateriels();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOResmat>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToMateriels(utt.rec.projet.server.metier.admrec.EOResmat object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_MATERIELS_KEY);
  }

  public void removeFromToMateriels(utt.rec.projet.server.metier.admrec.EOResmat object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_MATERIELS_KEY);
  }

  public void addToToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toMateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToMateriels(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_MATERIELS_KEY);
    }
  }

  public void removeFromToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toMateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToMateriels(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_MATERIELS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOResmat createToMaterielsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOResmat.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_MATERIELS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOResmat) eo;
  }

  public void deleteToMaterielsRelationship(utt.rec.projet.server.metier.admrec.EOResmat object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_MATERIELS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToMaterielsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOResmat> objects = toMateriels().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToMaterielsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> toMotCles() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs>)storedValueForKey(_EOPprec.TO_MOT_CLES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> toMotCles(EOQualifier qualifier) {
    return toMotCles(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> toMotCles(EOQualifier qualifier, boolean fetch) {
    return toMotCles(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> toMotCles(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOMotclefs.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOMotclefs.fetchEOMotclefses(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toMotCles();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOMotclefs>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToMotCles(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_MOT_CLES_KEY);
  }

  public void removeFromToMotCles(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_MOT_CLES_KEY);
  }

  public void addToToMotClesRelationship(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toMotCles relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToMotCles(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_MOT_CLES_KEY);
    }
  }

  public void removeFromToMotClesRelationship(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toMotCles relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToMotCles(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_MOT_CLES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOMotclefs createToMotClesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOMotclefs.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_MOT_CLES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOMotclefs) eo;
  }

  public void deleteToMotClesRelationship(utt.rec.projet.server.metier.admrec.EOMotclefs object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_MOT_CLES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToMotClesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOMotclefs> objects = toMotCles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToMotClesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> toPersonnelExistants() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)storedValueForKey(_EOPprec.TO_PERSONNEL_EXISTANTS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> toPersonnelExistants(EOQualifier qualifier) {
    return toPersonnelExistants(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> toPersonnelExistants(EOQualifier qualifier, boolean fetch) {
    return toPersonnelExistants(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> toPersonnelExistants(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPersonnel.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPersonnel.fetchEOPersonnels(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toPersonnelExistants();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPersonnel>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToPersonnelExistants(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_PERSONNEL_EXISTANTS_KEY);
  }

  public void removeFromToPersonnelExistants(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_PERSONNEL_EXISTANTS_KEY);
  }

  public void addToToPersonnelExistantsRelationship(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toPersonnelExistants relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToPersonnelExistants(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PERSONNEL_EXISTANTS_KEY);
    }
  }

  public void removeFromToPersonnelExistantsRelationship(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toPersonnelExistants relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToPersonnelExistants(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PERSONNEL_EXISTANTS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPersonnel createToPersonnelExistantsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPersonnel.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_PERSONNEL_EXISTANTS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPersonnel) eo;
  }

  public void deleteToPersonnelExistantsRelationship(utt.rec.projet.server.metier.admrec.EOPersonnel object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PERSONNEL_EXISTANTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToPersonnelExistantsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPersonnel> objects = toPersonnelExistants().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToPersonnelExistantsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> toPosteRhs() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPosterh>)storedValueForKey(_EOPprec.TO_POSTE_RHS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> toPosteRhs(EOQualifier qualifier) {
    return toPosteRhs(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> toPosteRhs(EOQualifier qualifier, boolean fetch) {
    return toPosteRhs(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> toPosteRhs(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPosterh> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPosterh.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPosterh.fetchEOPosterhs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toPosteRhs();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPosterh>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPosterh>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToPosteRhs(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_POSTE_RHS_KEY);
  }

  public void removeFromToPosteRhs(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_POSTE_RHS_KEY);
  }

  public void addToToPosteRhsRelationship(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toPosteRhs relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToPosteRhs(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_POSTE_RHS_KEY);
    }
  }

  public void removeFromToPosteRhsRelationship(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toPosteRhs relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToPosteRhs(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_POSTE_RHS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPosterh createToPosteRhsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPosterh.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_POSTE_RHS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPosterh) eo;
  }

  public void deleteToPosteRhsRelationship(utt.rec.projet.server.metier.admrec.EOPosterh object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_POSTE_RHS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToPosteRhsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPosterh> objects = toPosteRhs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToPosteRhsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> toProjetPartenaires() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>)storedValueForKey(_EOPprec.TO_PROJET_PARTENAIRES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> toProjetPartenaires(EOQualifier qualifier) {
    return toProjetPartenaires(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> toProjetPartenaires(EOQualifier qualifier, boolean fetch) {
    return toProjetPartenaires(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> toProjetPartenaires(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPartenaireProjet.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
      results = toProjetPartenaires();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPartenaireProjet>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToProjetPartenaires(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_PROJET_PARTENAIRES_KEY);
  }

  public void removeFromToProjetPartenaires(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_PROJET_PARTENAIRES_KEY);
  }

  public void addToToProjetPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toProjetPartenaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjetPartenaires(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PROJET_PARTENAIRES_KEY);
    }
  }

  public void removeFromToProjetPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toProjetPartenaires relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjetPartenaires(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PROJET_PARTENAIRES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPartenaireProjet createToProjetPartenairesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPartenaireProjet.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_PROJET_PARTENAIRES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPartenaireProjet) eo;
  }

  public void deleteToProjetPartenairesRelationship(utt.rec.projet.server.metier.admrec.EOPartenaireProjet object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PROJET_PARTENAIRES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjetPartenairesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPartenaireProjet> objects = toProjetPartenaires().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjetPartenairesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> toProjetRepartaxes() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe>)storedValueForKey(_EOPprec.TO_PROJET_REPARTAXES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> toProjetRepartaxes(EOQualifier qualifier) {
    return toProjetRepartaxes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> toProjetRepartaxes(EOQualifier qualifier, boolean fetch) {
    return toProjetRepartaxes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> toProjetRepartaxes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EORepartaxe.TO_PROJET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EORepartaxe.fetchEORepartaxes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toProjetRepartaxes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EORepartaxe>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToProjetRepartaxes(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    includeObjectIntoPropertyWithKey(object, _EOPprec.TO_PROJET_REPARTAXES_KEY);
  }

  public void removeFromToProjetRepartaxes(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    excludeObjectFromPropertyWithKey(object, _EOPprec.TO_PROJET_REPARTAXES_KEY);
  }

  public void addToToProjetRepartaxesRelationship(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("adding " + object + " to toProjetRepartaxes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjetRepartaxes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PROJET_REPARTAXES_KEY);
    }
  }

  public void removeFromToProjetRepartaxesRelationship(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    if (_EOPprec.LOG.isDebugEnabled()) {
      _EOPprec.LOG.debug("removing " + object + " from toProjetRepartaxes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjetRepartaxes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PROJET_REPARTAXES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EORepartaxe createToProjetRepartaxesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EORepartaxe.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOPprec.TO_PROJET_REPARTAXES_KEY);
    return (utt.rec.projet.server.metier.admrec.EORepartaxe) eo;
  }

  public void deleteToProjetRepartaxesRelationship(utt.rec.projet.server.metier.admrec.EORepartaxe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOPprec.TO_PROJET_REPARTAXES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjetRepartaxesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EORepartaxe> objects = toProjetRepartaxes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjetRepartaxesRelationship(objects.nextElement());
    }
  }


  public static EOPprec createEOPprec(EOEditingContext editingContext, Integer creAuteur
) {
    EOPprec eo = (EOPprec) EOUtilities.createAndInsertInstance(editingContext, _EOPprec.ENTITY_NAME);    
		eo.setCreAuteur(creAuteur);
    return eo;
  }

  public static ERXFetchSpecification<EOPprec> fetchSpec() {
    return new ERXFetchSpecification<EOPprec>(_EOPprec.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOPprec> fetchAllEOPprecs(EOEditingContext editingContext) {
    return _EOPprec.fetchAllEOPprecs(editingContext, null);
  }

  public static NSArray<EOPprec> fetchAllEOPprecs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOPprec.fetchEOPprecs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOPprec> fetchEOPprecs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOPprec> fetchSpec = new ERXFetchSpecification<EOPprec>(_EOPprec.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOPprec> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOPprec fetchEOPprec(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPprec.fetchEOPprec(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPprec fetchEOPprec(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOPprec> eoObjects = _EOPprec.fetchEOPprecs(editingContext, qualifier, null);
    EOPprec eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOPprec that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPprec fetchRequiredEOPprec(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPprec.fetchRequiredEOPprec(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPprec fetchRequiredEOPprec(EOEditingContext editingContext, EOQualifier qualifier) {
    EOPprec eoObject = _EOPprec.fetchEOPprec(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOPprec that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPprec localInstanceIn(EOEditingContext editingContext, EOPprec eo) {
    EOPprec localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchEditionProjet(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("EditionProjet", _EOPprec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchEditionProjet(EOEditingContext editingContext,
	String equipePrincipalBinding,
	Integer porteurBinding,
	Integer projetIdBinding,
	Integer typcontIdBinding,
	String typrefdomBinding,
	String typrefnatBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("EditionProjet", _EOPprec.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(equipePrincipalBinding, "equipePrincipal");
    bindings.takeValueForKey(porteurBinding, "porteur");
    bindings.takeValueForKey(projetIdBinding, "projetId");
    bindings.takeValueForKey(typcontIdBinding, "typcontId");
    bindings.takeValueForKey(typrefdomBinding, "typrefdom");
    bindings.takeValueForKey(typrefnatBinding, "typrefnat");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchEditionProjetEC(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("EditionProjetEC", _EOPprec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchEditionProjetEC(EOEditingContext editingContext,
	String equipePrincipaleBinding,
	Integer noIndiv_ImpliqueBinding,
	Integer noIndiv_PorteurBinding,
	Integer perId_CreAuteurBinding,
	Integer porteurBinding,
	Integer projetIdBinding,
	Integer typcontIdBinding,
	String typrefdomBinding,
	String typrefnatBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("EditionProjetEC", _EOPprec.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(equipePrincipaleBinding, "equipePrincipale");
    bindings.takeValueForKey(noIndiv_ImpliqueBinding, "noIndiv_Implique");
    bindings.takeValueForKey(noIndiv_PorteurBinding, "noIndiv_Porteur");
    bindings.takeValueForKey(perId_CreAuteurBinding, "perId_CreAuteur");
    bindings.takeValueForKey(porteurBinding, "porteur");
    bindings.takeValueForKey(projetIdBinding, "projetId");
    bindings.takeValueForKey(typcontIdBinding, "typcontId");
    bindings.takeValueForKey(typrefdomBinding, "typrefdom");
    bindings.takeValueForKey(typrefnatBinding, "typrefnat");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchFiltreProjet(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("FiltreProjet", _EOPprec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchFiltreProjet(EOEditingContext editingContext,
	String equipePrincipaleBinding,
	Integer porteurBinding,
	Integer projetIdBinding,
	Integer typcontIdBinding,
	String typrefdomBinding,
	String typrefnatBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("FiltreProjet", _EOPprec.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(equipePrincipaleBinding, "equipePrincipale");
    bindings.takeValueForKey(porteurBinding, "porteur");
    bindings.takeValueForKey(projetIdBinding, "projetId");
    bindings.takeValueForKey(typcontIdBinding, "typcontId");
    bindings.takeValueForKey(typrefdomBinding, "typrefdom");
    bindings.takeValueForKey(typrefnatBinding, "typrefnat");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchFiltreProjetEC(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("FiltreProjetEC", _EOPprec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchFiltreProjetEC(EOEditingContext editingContext,
	String equipePrincipaleBinding,
	Integer noIndiv_ImpliqueBinding,
	Integer noIndiv_PorteurBinding,
	Integer perId_CreAuteurBinding,
	Integer porteurBinding,
	Integer projetIdBinding,
	Integer typcontIdBinding,
	String typrefdomBinding,
	String typrefnatBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("FiltreProjetEC", _EOPprec.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(equipePrincipaleBinding, "equipePrincipale");
    bindings.takeValueForKey(noIndiv_ImpliqueBinding, "noIndiv_Implique");
    bindings.takeValueForKey(noIndiv_PorteurBinding, "noIndiv_Porteur");
    bindings.takeValueForKey(perId_CreAuteurBinding, "perId_CreAuteur");
    bindings.takeValueForKey(porteurBinding, "porteur");
    bindings.takeValueForKey(projetIdBinding, "projetId");
    bindings.takeValueForKey(typcontIdBinding, "typcontId");
    bindings.takeValueForKey(typrefdomBinding, "typrefdom");
    bindings.takeValueForKey(typrefnatBinding, "typrefnat");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchProjetValide(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("projetValide", _EOPprec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchProjetValide(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("projetValide", _EOPprec.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchRenvoiLeProjet(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("renvoiLeProjet", _EOPprec.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.admrec.EOPprec> fetchRenvoiLeProjet(EOEditingContext editingContext,
	Integer projetIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("renvoiLeProjet", _EOPprec.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(projetIdBinding, "projetId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
