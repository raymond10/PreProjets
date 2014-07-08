// DO NOT EDIT.  Make changes to EOStructure.java instead.
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
public abstract class _EOStructure extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOStructure";

  // Attribute Keys
  public static final ERXKey<String> C_ACADEMIE = new ERXKey<String>("cAcademie");
  public static final ERXKey<String> C_NAF = new ERXKey<String>("cNaf");
  public static final ERXKey<String> C_NIC = new ERXKey<String>("cNic");
  public static final ERXKey<String> C_RNE = new ERXKey<String>("cRne");
  public static final ERXKey<String> C_STATUT_JURIDIQUE = new ERXKey<String>("cStatutJuridique");
  public static final ERXKey<String> C_STRUCTURE = new ERXKey<String>("cStructure");
  public static final ERXKey<String> C_TYPE_DECISION_STR = new ERXKey<String>("cTypeDecisionStr");
  public static final ERXKey<String> C_TYPE_ETABLISSEMEN = new ERXKey<String>("cTypeEtablissemen");
  public static final ERXKey<String> C_TYPE_STRUCTURE = new ERXKey<String>("cTypeStructure");
  public static final ERXKey<NSTimestamp> DATE_DECISION = new ERXKey<NSTimestamp>("dateDecision");
  public static final ERXKey<NSTimestamp> DATE_FERMETURE = new ERXKey<NSTimestamp>("dateFermeture");
  public static final ERXKey<NSTimestamp> DATE_OUVERTURE = new ERXKey<NSTimestamp>("dateOuverture");
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<String> ETAB_CODURSSAF = new ERXKey<String>("etabCodurssaf");
  public static final ERXKey<String> ETAB_NUMURSSAF = new ERXKey<String>("etabNumurssaf");
  public static final ERXKey<Integer> EXPORT = new ERXKey<Integer>("export");
  public static final ERXKey<String> GENCOD = new ERXKey<String>("gencod");
  public static final ERXKey<String> GRP_ACCES = new ERXKey<String>("grpAcces");
  public static final ERXKey<String> GRP_ALIAS = new ERXKey<String>("grpAlias");
  public static final ERXKey<String> GRP_APE_CODE = new ERXKey<String>("grpApeCode");
  public static final ERXKey<String> GRP_APE_CODE_BIS = new ERXKey<String>("grpApeCodeBis");
  public static final ERXKey<String> GRP_APE_CODE_COMP = new ERXKey<String>("grpApeCodeComp");
  public static final ERXKey<Integer> GRP_CA = new ERXKey<Integer>("grpCa");
  public static final ERXKey<Integer> GRP_CAPITAL = new ERXKey<Integer>("grpCapital");
  public static final ERXKey<String> GRP_CENTRE_DECISION = new ERXKey<String>("grpCentreDecision");
  public static final ERXKey<Integer> GRP_EFFECTIFS = new ERXKey<Integer>("grpEffectifs");
  public static final ERXKey<String> GRP_FONCTION1 = new ERXKey<String>("grpFonction1");
  public static final ERXKey<String> GRP_FONCTION2 = new ERXKey<String>("grpFonction2");
  public static final ERXKey<String> GRP_FORME_JURIDIQUE = new ERXKey<String>("grpFormeJuridique");
  public static final ERXKey<String> GRP_MOTS_CLEFS = new ERXKey<String>("grpMotsClefs");
  public static final ERXKey<String> GRP_RESPONSABILITE = new ERXKey<String>("grpResponsabilite");
  public static final ERXKey<Integer> GRP_RESPONSABLE = new ERXKey<Integer>("grpResponsable");
  public static final ERXKey<String> GRP_TRADEMARQUE = new ERXKey<String>("grpTrademarque");
  public static final ERXKey<String> GRP_WEBMESTRE = new ERXKey<String>("grpWebmestre");
  public static final ERXKey<String> LC_STRUCTURE = new ERXKey<String>("lcStructure");
  public static final ERXKey<String> LL_STRUCTURE = new ERXKey<String>("llStructure");
  public static final ERXKey<Integer> MOYENNE_AGE = new ERXKey<Integer>("moyenneAge");
  public static final ERXKey<String> NUM_ASSEDIC = new ERXKey<String>("numAssedic");
  public static final ERXKey<String> NUM_CNRACL = new ERXKey<String>("numCnracl");
  public static final ERXKey<String> NUM_IRCANTEC = new ERXKey<String>("numIrcantec");
  public static final ERXKey<String> NUM_RAFP = new ERXKey<String>("numRafp");
  public static final ERXKey<Integer> ORG_ORDRE = new ERXKey<Integer>("orgOrdre");
  public static final ERXKey<Integer> PERS_ID = new ERXKey<Integer>("persId");
  public static final ERXKey<Integer> PERS_ID_CREATION = new ERXKey<Integer>("persIdCreation");
  public static final ERXKey<Integer> PERS_ID_MODIFICATION = new ERXKey<Integer>("persIdModification");
  public static final ERXKey<Integer> PSEC_ORDRE = new ERXKey<Integer>("psecOrdre");
  public static final ERXKey<String> REF_DECISION = new ERXKey<String>("refDecision");
  public static final ERXKey<String> REF_EXT_COMP = new ERXKey<String>("refExtComp");
  public static final ERXKey<String> REF_EXT_CR = new ERXKey<String>("refExtCr");
  public static final ERXKey<String> REF_EXT_ETAB = new ERXKey<String>("refExtEtab");
  public static final ERXKey<String> RISQUE_ACC_TRAV = new ERXKey<String>("risqueAccTrav");
  public static final ERXKey<String> SIREN = new ERXKey<String>("siren");
  public static final ERXKey<String> SIRET = new ERXKey<String>("siret");
  public static final ERXKey<String> STR_ACCUEIL = new ERXKey<String>("strAccueil");
  public static final ERXKey<String> STR_ACTIVITE = new ERXKey<String>("strActivite");
  public static final ERXKey<String> STR_AFFICHAGE = new ERXKey<String>("strAffichage");
  public static final ERXKey<String> STR_ORIGINE = new ERXKey<String>("strOrigine");
  public static final ERXKey<String> STR_PHOTO = new ERXKey<String>("strPhoto");
  public static final ERXKey<String> STR_RECHERCHE = new ERXKey<String>("strRecherche");
  public static final ERXKey<String> TAUX_ACC_TRAV = new ERXKey<String>("tauxAccTrav");
  public static final ERXKey<String> TAUX_EXONERATION_TVA = new ERXKey<String>("tauxExonerationTva");
  public static final ERXKey<String> TAUX_IR = new ERXKey<String>("tauxIr");
  public static final ERXKey<String> TAUX_TRANSPORT = new ERXKey<String>("tauxTransport");
  public static final ERXKey<String> TEM_COTIS_ASSEDIC = new ERXKey<String>("temCotisAssedic");
  public static final ERXKey<String> TEM_DADS = new ERXKey<String>("temDads");
  public static final ERXKey<String> TEM_ETABLISSEMENT_PAYE = new ERXKey<String>("temEtablissementPaye");
  public static final ERXKey<String> TEM_PLAFOND_REDUIT = new ERXKey<String>("temPlafondReduit");
  public static final ERXKey<String> TEM_SECTORISE = new ERXKey<String>("temSectorise");
  public static final ERXKey<String> TEM_SOUMIS_TVA = new ERXKey<String>("temSoumisTva");
  public static final ERXKey<String> TEM_VALIDE = new ERXKey<String>("temValide");
  public static final ERXKey<String> TVA_INTRACOM = new ERXKey<String>("tvaIntracom");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_EQUIPES = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toEquipes");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPprec> TO_PROJETS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPprec>("toProjets");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOStructure> TO_STRUCTURE_PERE = new ERXKey<utt.rec.projet.server.metier.admrec.EOStructure>("toStructurePere");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOStructure> TO_STRUCTURES = new ERXKey<utt.rec.projet.server.metier.admrec.EOStructure>("toStructures");

  // Attributes
  public static final String C_ACADEMIE_KEY = C_ACADEMIE.key();
  public static final String C_NAF_KEY = C_NAF.key();
  public static final String C_NIC_KEY = C_NIC.key();
  public static final String C_RNE_KEY = C_RNE.key();
  public static final String C_STATUT_JURIDIQUE_KEY = C_STATUT_JURIDIQUE.key();
  public static final String C_STRUCTURE_KEY = C_STRUCTURE.key();
  public static final String C_TYPE_DECISION_STR_KEY = C_TYPE_DECISION_STR.key();
  public static final String C_TYPE_ETABLISSEMEN_KEY = C_TYPE_ETABLISSEMEN.key();
  public static final String C_TYPE_STRUCTURE_KEY = C_TYPE_STRUCTURE.key();
  public static final String DATE_DECISION_KEY = DATE_DECISION.key();
  public static final String DATE_FERMETURE_KEY = DATE_FERMETURE.key();
  public static final String DATE_OUVERTURE_KEY = DATE_OUVERTURE.key();
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String ETAB_CODURSSAF_KEY = ETAB_CODURSSAF.key();
  public static final String ETAB_NUMURSSAF_KEY = ETAB_NUMURSSAF.key();
  public static final String EXPORT_KEY = EXPORT.key();
  public static final String GENCOD_KEY = GENCOD.key();
  public static final String GRP_ACCES_KEY = GRP_ACCES.key();
  public static final String GRP_ALIAS_KEY = GRP_ALIAS.key();
  public static final String GRP_APE_CODE_KEY = GRP_APE_CODE.key();
  public static final String GRP_APE_CODE_BIS_KEY = GRP_APE_CODE_BIS.key();
  public static final String GRP_APE_CODE_COMP_KEY = GRP_APE_CODE_COMP.key();
  public static final String GRP_CA_KEY = GRP_CA.key();
  public static final String GRP_CAPITAL_KEY = GRP_CAPITAL.key();
  public static final String GRP_CENTRE_DECISION_KEY = GRP_CENTRE_DECISION.key();
  public static final String GRP_EFFECTIFS_KEY = GRP_EFFECTIFS.key();
  public static final String GRP_FONCTION1_KEY = GRP_FONCTION1.key();
  public static final String GRP_FONCTION2_KEY = GRP_FONCTION2.key();
  public static final String GRP_FORME_JURIDIQUE_KEY = GRP_FORME_JURIDIQUE.key();
  public static final String GRP_MOTS_CLEFS_KEY = GRP_MOTS_CLEFS.key();
  public static final String GRP_RESPONSABILITE_KEY = GRP_RESPONSABILITE.key();
  public static final String GRP_RESPONSABLE_KEY = GRP_RESPONSABLE.key();
  public static final String GRP_TRADEMARQUE_KEY = GRP_TRADEMARQUE.key();
  public static final String GRP_WEBMESTRE_KEY = GRP_WEBMESTRE.key();
  public static final String LC_STRUCTURE_KEY = LC_STRUCTURE.key();
  public static final String LL_STRUCTURE_KEY = LL_STRUCTURE.key();
  public static final String MOYENNE_AGE_KEY = MOYENNE_AGE.key();
  public static final String NUM_ASSEDIC_KEY = NUM_ASSEDIC.key();
  public static final String NUM_CNRACL_KEY = NUM_CNRACL.key();
  public static final String NUM_IRCANTEC_KEY = NUM_IRCANTEC.key();
  public static final String NUM_RAFP_KEY = NUM_RAFP.key();
  public static final String ORG_ORDRE_KEY = ORG_ORDRE.key();
  public static final String PERS_ID_KEY = PERS_ID.key();
  public static final String PERS_ID_CREATION_KEY = PERS_ID_CREATION.key();
  public static final String PERS_ID_MODIFICATION_KEY = PERS_ID_MODIFICATION.key();
  public static final String PSEC_ORDRE_KEY = PSEC_ORDRE.key();
  public static final String REF_DECISION_KEY = REF_DECISION.key();
  public static final String REF_EXT_COMP_KEY = REF_EXT_COMP.key();
  public static final String REF_EXT_CR_KEY = REF_EXT_CR.key();
  public static final String REF_EXT_ETAB_KEY = REF_EXT_ETAB.key();
  public static final String RISQUE_ACC_TRAV_KEY = RISQUE_ACC_TRAV.key();
  public static final String SIREN_KEY = SIREN.key();
  public static final String SIRET_KEY = SIRET.key();
  public static final String STR_ACCUEIL_KEY = STR_ACCUEIL.key();
  public static final String STR_ACTIVITE_KEY = STR_ACTIVITE.key();
  public static final String STR_AFFICHAGE_KEY = STR_AFFICHAGE.key();
  public static final String STR_ORIGINE_KEY = STR_ORIGINE.key();
  public static final String STR_PHOTO_KEY = STR_PHOTO.key();
  public static final String STR_RECHERCHE_KEY = STR_RECHERCHE.key();
  public static final String TAUX_ACC_TRAV_KEY = TAUX_ACC_TRAV.key();
  public static final String TAUX_EXONERATION_TVA_KEY = TAUX_EXONERATION_TVA.key();
  public static final String TAUX_IR_KEY = TAUX_IR.key();
  public static final String TAUX_TRANSPORT_KEY = TAUX_TRANSPORT.key();
  public static final String TEM_COTIS_ASSEDIC_KEY = TEM_COTIS_ASSEDIC.key();
  public static final String TEM_DADS_KEY = TEM_DADS.key();
  public static final String TEM_ETABLISSEMENT_PAYE_KEY = TEM_ETABLISSEMENT_PAYE.key();
  public static final String TEM_PLAFOND_REDUIT_KEY = TEM_PLAFOND_REDUIT.key();
  public static final String TEM_SECTORISE_KEY = TEM_SECTORISE.key();
  public static final String TEM_SOUMIS_TVA_KEY = TEM_SOUMIS_TVA.key();
  public static final String TEM_VALIDE_KEY = TEM_VALIDE.key();
  public static final String TVA_INTRACOM_KEY = TVA_INTRACOM.key();
  // Relationships
  public static final String TO_EQUIPES_KEY = TO_EQUIPES.key();
  public static final String TO_PROJETS_KEY = TO_PROJETS.key();
  public static final String TO_STRUCTURE_PERE_KEY = TO_STRUCTURE_PERE.key();
  public static final String TO_STRUCTURES_KEY = TO_STRUCTURES.key();

  private static Logger LOG = Logger.getLogger(_EOStructure.class);

  public EOStructure localInstanceIn(EOEditingContext editingContext) {
    EOStructure localInstance = (EOStructure)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cAcademie() {
    return (String) storedValueForKey(_EOStructure.C_ACADEMIE_KEY);
  }

  public void setCAcademie(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cAcademie from " + cAcademie() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_ACADEMIE_KEY);
  }

  public String cNaf() {
    return (String) storedValueForKey(_EOStructure.C_NAF_KEY);
  }

  public void setCNaf(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cNaf from " + cNaf() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_NAF_KEY);
  }

  public String cNic() {
    return (String) storedValueForKey(_EOStructure.C_NIC_KEY);
  }

  public void setCNic(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cNic from " + cNic() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_NIC_KEY);
  }

  public String cRne() {
    return (String) storedValueForKey(_EOStructure.C_RNE_KEY);
  }

  public void setCRne(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cRne from " + cRne() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_RNE_KEY);
  }

  public String cStatutJuridique() {
    return (String) storedValueForKey(_EOStructure.C_STATUT_JURIDIQUE_KEY);
  }

  public void setCStatutJuridique(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cStatutJuridique from " + cStatutJuridique() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_STATUT_JURIDIQUE_KEY);
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOStructure.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_STRUCTURE_KEY);
  }

  public String cTypeDecisionStr() {
    return (String) storedValueForKey(_EOStructure.C_TYPE_DECISION_STR_KEY);
  }

  public void setCTypeDecisionStr(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cTypeDecisionStr from " + cTypeDecisionStr() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_TYPE_DECISION_STR_KEY);
  }

  public String cTypeEtablissemen() {
    return (String) storedValueForKey(_EOStructure.C_TYPE_ETABLISSEMEN_KEY);
  }

  public void setCTypeEtablissemen(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cTypeEtablissemen from " + cTypeEtablissemen() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_TYPE_ETABLISSEMEN_KEY);
  }

  public String cTypeStructure() {
    return (String) storedValueForKey(_EOStructure.C_TYPE_STRUCTURE_KEY);
  }

  public void setCTypeStructure(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating cTypeStructure from " + cTypeStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.C_TYPE_STRUCTURE_KEY);
  }

  public NSTimestamp dateDecision() {
    return (NSTimestamp) storedValueForKey(_EOStructure.DATE_DECISION_KEY);
  }

  public void setDateDecision(NSTimestamp value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating dateDecision from " + dateDecision() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.DATE_DECISION_KEY);
  }

  public NSTimestamp dateFermeture() {
    return (NSTimestamp) storedValueForKey(_EOStructure.DATE_FERMETURE_KEY);
  }

  public void setDateFermeture(NSTimestamp value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating dateFermeture from " + dateFermeture() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.DATE_FERMETURE_KEY);
  }

  public NSTimestamp dateOuverture() {
    return (NSTimestamp) storedValueForKey(_EOStructure.DATE_OUVERTURE_KEY);
  }

  public void setDateOuverture(NSTimestamp value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating dateOuverture from " + dateOuverture() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.DATE_OUVERTURE_KEY);
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EOStructure.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EOStructure.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.D_MODIFICATION_KEY);
  }

  public String etabCodurssaf() {
    return (String) storedValueForKey(_EOStructure.ETAB_CODURSSAF_KEY);
  }

  public void setEtabCodurssaf(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating etabCodurssaf from " + etabCodurssaf() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.ETAB_CODURSSAF_KEY);
  }

  public String etabNumurssaf() {
    return (String) storedValueForKey(_EOStructure.ETAB_NUMURSSAF_KEY);
  }

  public void setEtabNumurssaf(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating etabNumurssaf from " + etabNumurssaf() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.ETAB_NUMURSSAF_KEY);
  }

  public Integer export() {
    return (Integer) storedValueForKey(_EOStructure.EXPORT_KEY);
  }

  public void setExport(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating export from " + export() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.EXPORT_KEY);
  }

  public String gencod() {
    return (String) storedValueForKey(_EOStructure.GENCOD_KEY);
  }

  public void setGencod(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating gencod from " + gencod() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GENCOD_KEY);
  }

  public String grpAcces() {
    return (String) storedValueForKey(_EOStructure.GRP_ACCES_KEY);
  }

  public void setGrpAcces(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpAcces from " + grpAcces() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_ACCES_KEY);
  }

  public String grpAlias() {
    return (String) storedValueForKey(_EOStructure.GRP_ALIAS_KEY);
  }

  public void setGrpAlias(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpAlias from " + grpAlias() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_ALIAS_KEY);
  }

  public String grpApeCode() {
    return (String) storedValueForKey(_EOStructure.GRP_APE_CODE_KEY);
  }

  public void setGrpApeCode(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpApeCode from " + grpApeCode() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_APE_CODE_KEY);
  }

  public String grpApeCodeBis() {
    return (String) storedValueForKey(_EOStructure.GRP_APE_CODE_BIS_KEY);
  }

  public void setGrpApeCodeBis(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpApeCodeBis from " + grpApeCodeBis() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_APE_CODE_BIS_KEY);
  }

  public String grpApeCodeComp() {
    return (String) storedValueForKey(_EOStructure.GRP_APE_CODE_COMP_KEY);
  }

  public void setGrpApeCodeComp(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpApeCodeComp from " + grpApeCodeComp() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_APE_CODE_COMP_KEY);
  }

  public Integer grpCa() {
    return (Integer) storedValueForKey(_EOStructure.GRP_CA_KEY);
  }

  public void setGrpCa(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpCa from " + grpCa() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_CA_KEY);
  }

  public Integer grpCapital() {
    return (Integer) storedValueForKey(_EOStructure.GRP_CAPITAL_KEY);
  }

  public void setGrpCapital(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpCapital from " + grpCapital() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_CAPITAL_KEY);
  }

  public String grpCentreDecision() {
    return (String) storedValueForKey(_EOStructure.GRP_CENTRE_DECISION_KEY);
  }

  public void setGrpCentreDecision(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpCentreDecision from " + grpCentreDecision() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_CENTRE_DECISION_KEY);
  }

  public Integer grpEffectifs() {
    return (Integer) storedValueForKey(_EOStructure.GRP_EFFECTIFS_KEY);
  }

  public void setGrpEffectifs(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpEffectifs from " + grpEffectifs() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_EFFECTIFS_KEY);
  }

  public String grpFonction1() {
    return (String) storedValueForKey(_EOStructure.GRP_FONCTION1_KEY);
  }

  public void setGrpFonction1(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpFonction1 from " + grpFonction1() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_FONCTION1_KEY);
  }

  public String grpFonction2() {
    return (String) storedValueForKey(_EOStructure.GRP_FONCTION2_KEY);
  }

  public void setGrpFonction2(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpFonction2 from " + grpFonction2() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_FONCTION2_KEY);
  }

  public String grpFormeJuridique() {
    return (String) storedValueForKey(_EOStructure.GRP_FORME_JURIDIQUE_KEY);
  }

  public void setGrpFormeJuridique(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpFormeJuridique from " + grpFormeJuridique() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_FORME_JURIDIQUE_KEY);
  }

  public String grpMotsClefs() {
    return (String) storedValueForKey(_EOStructure.GRP_MOTS_CLEFS_KEY);
  }

  public void setGrpMotsClefs(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpMotsClefs from " + grpMotsClefs() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_MOTS_CLEFS_KEY);
  }

  public String grpResponsabilite() {
    return (String) storedValueForKey(_EOStructure.GRP_RESPONSABILITE_KEY);
  }

  public void setGrpResponsabilite(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpResponsabilite from " + grpResponsabilite() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_RESPONSABILITE_KEY);
  }

  public Integer grpResponsable() {
    return (Integer) storedValueForKey(_EOStructure.GRP_RESPONSABLE_KEY);
  }

  public void setGrpResponsable(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpResponsable from " + grpResponsable() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_RESPONSABLE_KEY);
  }

  public String grpTrademarque() {
    return (String) storedValueForKey(_EOStructure.GRP_TRADEMARQUE_KEY);
  }

  public void setGrpTrademarque(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpTrademarque from " + grpTrademarque() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_TRADEMARQUE_KEY);
  }

  public String grpWebmestre() {
    return (String) storedValueForKey(_EOStructure.GRP_WEBMESTRE_KEY);
  }

  public void setGrpWebmestre(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating grpWebmestre from " + grpWebmestre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.GRP_WEBMESTRE_KEY);
  }

  public String lcStructure() {
    return (String) storedValueForKey(_EOStructure.LC_STRUCTURE_KEY);
  }

  public void setLcStructure(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating lcStructure from " + lcStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.LC_STRUCTURE_KEY);
  }

  public String llStructure() {
    return (String) storedValueForKey(_EOStructure.LL_STRUCTURE_KEY);
  }

  public void setLlStructure(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating llStructure from " + llStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.LL_STRUCTURE_KEY);
  }

  public Integer moyenneAge() {
    return (Integer) storedValueForKey(_EOStructure.MOYENNE_AGE_KEY);
  }

  public void setMoyenneAge(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating moyenneAge from " + moyenneAge() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.MOYENNE_AGE_KEY);
  }

  public String numAssedic() {
    return (String) storedValueForKey(_EOStructure.NUM_ASSEDIC_KEY);
  }

  public void setNumAssedic(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating numAssedic from " + numAssedic() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.NUM_ASSEDIC_KEY);
  }

  public String numCnracl() {
    return (String) storedValueForKey(_EOStructure.NUM_CNRACL_KEY);
  }

  public void setNumCnracl(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating numCnracl from " + numCnracl() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.NUM_CNRACL_KEY);
  }

  public String numIrcantec() {
    return (String) storedValueForKey(_EOStructure.NUM_IRCANTEC_KEY);
  }

  public void setNumIrcantec(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating numIrcantec from " + numIrcantec() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.NUM_IRCANTEC_KEY);
  }

  public String numRafp() {
    return (String) storedValueForKey(_EOStructure.NUM_RAFP_KEY);
  }

  public void setNumRafp(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating numRafp from " + numRafp() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.NUM_RAFP_KEY);
  }

  public Integer orgOrdre() {
    return (Integer) storedValueForKey(_EOStructure.ORG_ORDRE_KEY);
  }

  public void setOrgOrdre(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating orgOrdre from " + orgOrdre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.ORG_ORDRE_KEY);
  }

  public Integer persId() {
    return (Integer) storedValueForKey(_EOStructure.PERS_ID_KEY);
  }

  public void setPersId(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating persId from " + persId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.PERS_ID_KEY);
  }

  public Integer persIdCreation() {
    return (Integer) storedValueForKey(_EOStructure.PERS_ID_CREATION_KEY);
  }

  public void setPersIdCreation(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating persIdCreation from " + persIdCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.PERS_ID_CREATION_KEY);
  }

  public Integer persIdModification() {
    return (Integer) storedValueForKey(_EOStructure.PERS_ID_MODIFICATION_KEY);
  }

  public void setPersIdModification(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating persIdModification from " + persIdModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.PERS_ID_MODIFICATION_KEY);
  }

  public Integer psecOrdre() {
    return (Integer) storedValueForKey(_EOStructure.PSEC_ORDRE_KEY);
  }

  public void setPsecOrdre(Integer value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating psecOrdre from " + psecOrdre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.PSEC_ORDRE_KEY);
  }

  public String refDecision() {
    return (String) storedValueForKey(_EOStructure.REF_DECISION_KEY);
  }

  public void setRefDecision(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating refDecision from " + refDecision() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.REF_DECISION_KEY);
  }

  public String refExtComp() {
    return (String) storedValueForKey(_EOStructure.REF_EXT_COMP_KEY);
  }

  public void setRefExtComp(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating refExtComp from " + refExtComp() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.REF_EXT_COMP_KEY);
  }

  public String refExtCr() {
    return (String) storedValueForKey(_EOStructure.REF_EXT_CR_KEY);
  }

  public void setRefExtCr(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating refExtCr from " + refExtCr() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.REF_EXT_CR_KEY);
  }

  public String refExtEtab() {
    return (String) storedValueForKey(_EOStructure.REF_EXT_ETAB_KEY);
  }

  public void setRefExtEtab(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating refExtEtab from " + refExtEtab() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.REF_EXT_ETAB_KEY);
  }

  public String risqueAccTrav() {
    return (String) storedValueForKey(_EOStructure.RISQUE_ACC_TRAV_KEY);
  }

  public void setRisqueAccTrav(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating risqueAccTrav from " + risqueAccTrav() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.RISQUE_ACC_TRAV_KEY);
  }

  public String siren() {
    return (String) storedValueForKey(_EOStructure.SIREN_KEY);
  }

  public void setSiren(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating siren from " + siren() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.SIREN_KEY);
  }

  public String siret() {
    return (String) storedValueForKey(_EOStructure.SIRET_KEY);
  }

  public void setSiret(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating siret from " + siret() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.SIRET_KEY);
  }

  public String strAccueil() {
    return (String) storedValueForKey(_EOStructure.STR_ACCUEIL_KEY);
  }

  public void setStrAccueil(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating strAccueil from " + strAccueil() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.STR_ACCUEIL_KEY);
  }

  public String strActivite() {
    return (String) storedValueForKey(_EOStructure.STR_ACTIVITE_KEY);
  }

  public void setStrActivite(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating strActivite from " + strActivite() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.STR_ACTIVITE_KEY);
  }

  public String strAffichage() {
    return (String) storedValueForKey(_EOStructure.STR_AFFICHAGE_KEY);
  }

  public void setStrAffichage(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating strAffichage from " + strAffichage() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.STR_AFFICHAGE_KEY);
  }

  public String strOrigine() {
    return (String) storedValueForKey(_EOStructure.STR_ORIGINE_KEY);
  }

  public void setStrOrigine(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating strOrigine from " + strOrigine() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.STR_ORIGINE_KEY);
  }

  public String strPhoto() {
    return (String) storedValueForKey(_EOStructure.STR_PHOTO_KEY);
  }

  public void setStrPhoto(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating strPhoto from " + strPhoto() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.STR_PHOTO_KEY);
  }

  public String strRecherche() {
    return (String) storedValueForKey(_EOStructure.STR_RECHERCHE_KEY);
  }

  public void setStrRecherche(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating strRecherche from " + strRecherche() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.STR_RECHERCHE_KEY);
  }

  public String tauxAccTrav() {
    return (String) storedValueForKey(_EOStructure.TAUX_ACC_TRAV_KEY);
  }

  public void setTauxAccTrav(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating tauxAccTrav from " + tauxAccTrav() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TAUX_ACC_TRAV_KEY);
  }

  public String tauxExonerationTva() {
    return (String) storedValueForKey(_EOStructure.TAUX_EXONERATION_TVA_KEY);
  }

  public void setTauxExonerationTva(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating tauxExonerationTva from " + tauxExonerationTva() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TAUX_EXONERATION_TVA_KEY);
  }

  public String tauxIr() {
    return (String) storedValueForKey(_EOStructure.TAUX_IR_KEY);
  }

  public void setTauxIr(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating tauxIr from " + tauxIr() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TAUX_IR_KEY);
  }

  public String tauxTransport() {
    return (String) storedValueForKey(_EOStructure.TAUX_TRANSPORT_KEY);
  }

  public void setTauxTransport(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating tauxTransport from " + tauxTransport() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TAUX_TRANSPORT_KEY);
  }

  public String temCotisAssedic() {
    return (String) storedValueForKey(_EOStructure.TEM_COTIS_ASSEDIC_KEY);
  }

  public void setTemCotisAssedic(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating temCotisAssedic from " + temCotisAssedic() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TEM_COTIS_ASSEDIC_KEY);
  }

  public String temDads() {
    return (String) storedValueForKey(_EOStructure.TEM_DADS_KEY);
  }

  public void setTemDads(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating temDads from " + temDads() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TEM_DADS_KEY);
  }

  public String temEtablissementPaye() {
    return (String) storedValueForKey(_EOStructure.TEM_ETABLISSEMENT_PAYE_KEY);
  }

  public void setTemEtablissementPaye(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating temEtablissementPaye from " + temEtablissementPaye() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TEM_ETABLISSEMENT_PAYE_KEY);
  }

  public String temPlafondReduit() {
    return (String) storedValueForKey(_EOStructure.TEM_PLAFOND_REDUIT_KEY);
  }

  public void setTemPlafondReduit(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating temPlafondReduit from " + temPlafondReduit() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TEM_PLAFOND_REDUIT_KEY);
  }

  public String temSectorise() {
    return (String) storedValueForKey(_EOStructure.TEM_SECTORISE_KEY);
  }

  public void setTemSectorise(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating temSectorise from " + temSectorise() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TEM_SECTORISE_KEY);
  }

  public String temSoumisTva() {
    return (String) storedValueForKey(_EOStructure.TEM_SOUMIS_TVA_KEY);
  }

  public void setTemSoumisTva(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating temSoumisTva from " + temSoumisTva() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TEM_SOUMIS_TVA_KEY);
  }

  public String temValide() {
    return (String) storedValueForKey(_EOStructure.TEM_VALIDE_KEY);
  }

  public void setTemValide(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating temValide from " + temValide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TEM_VALIDE_KEY);
  }

  public String tvaIntracom() {
    return (String) storedValueForKey(_EOStructure.TVA_INTRACOM_KEY);
  }

  public void setTvaIntracom(String value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
    	_EOStructure.LOG.debug( "updating tvaIntracom from " + tvaIntracom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructure.TVA_INTRACOM_KEY);
  }

  public utt.rec.projet.server.metier.admrec.EOStructure toStructurePere() {
    return (utt.rec.projet.server.metier.admrec.EOStructure)storedValueForKey(_EOStructure.TO_STRUCTURE_PERE_KEY);
  }
  
  public void setToStructurePere(utt.rec.projet.server.metier.admrec.EOStructure value) {
    takeStoredValueForKey(value, _EOStructure.TO_STRUCTURE_PERE_KEY);
  }

  public void setToStructurePereRelationship(utt.rec.projet.server.metier.admrec.EOStructure value) {
    if (_EOStructure.LOG.isDebugEnabled()) {
      _EOStructure.LOG.debug("updating toStructurePere from " + toStructurePere() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStructurePere(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.admrec.EOStructure oldValue = toStructurePere();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOStructure.TO_STRUCTURE_PERE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOStructure.TO_STRUCTURE_PERE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toEquipes() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)storedValueForKey(_EOStructure.TO_EQUIPES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toEquipes(EOQualifier qualifier) {
    return toEquipes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toEquipes(EOQualifier qualifier, boolean fetch) {
    return toEquipes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toEquipes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPprec> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPprec.TO_PRINCIPAL_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPprec.fetchEOPprecs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toEquipes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToEquipes(utt.rec.projet.server.metier.admrec.EOPprec object) {
    includeObjectIntoPropertyWithKey(object, _EOStructure.TO_EQUIPES_KEY);
  }

  public void removeFromToEquipes(utt.rec.projet.server.metier.admrec.EOPprec object) {
    excludeObjectFromPropertyWithKey(object, _EOStructure.TO_EQUIPES_KEY);
  }

  public void addToToEquipesRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOStructure.LOG.isDebugEnabled()) {
      _EOStructure.LOG.debug("adding " + object + " to toEquipes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToEquipes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructure.TO_EQUIPES_KEY);
    }
  }

  public void removeFromToEquipesRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOStructure.LOG.isDebugEnabled()) {
      _EOStructure.LOG.debug("removing " + object + " from toEquipes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToEquipes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructure.TO_EQUIPES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPprec createToEquipesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPprec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructure.TO_EQUIPES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPprec) eo;
  }

  public void deleteToEquipesRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructure.TO_EQUIPES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToEquipesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPprec> objects = toEquipes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToEquipesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)storedValueForKey(_EOStructure.TO_PROJETS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets(EOQualifier qualifier) {
    return toProjets(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets(EOQualifier qualifier, boolean fetch) {
    return toProjets(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPprec> toProjets(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPprec> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPprec.TO_STRUCTURE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPprec.fetchEOPprecs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toProjets();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPprec>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToProjets(utt.rec.projet.server.metier.admrec.EOPprec object) {
    includeObjectIntoPropertyWithKey(object, _EOStructure.TO_PROJETS_KEY);
  }

  public void removeFromToProjets(utt.rec.projet.server.metier.admrec.EOPprec object) {
    excludeObjectFromPropertyWithKey(object, _EOStructure.TO_PROJETS_KEY);
  }

  public void addToToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOStructure.LOG.isDebugEnabled()) {
      _EOStructure.LOG.debug("adding " + object + " to toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToProjets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructure.TO_PROJETS_KEY);
    }
  }

  public void removeFromToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    if (_EOStructure.LOG.isDebugEnabled()) {
      _EOStructure.LOG.debug("removing " + object + " from toProjets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToProjets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructure.TO_PROJETS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPprec createToProjetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPprec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructure.TO_PROJETS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPprec) eo;
  }

  public void deleteToProjetsRelationship(utt.rec.projet.server.metier.admrec.EOPprec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructure.TO_PROJETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToProjetsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPprec> objects = toProjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToProjetsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOStructure> toStructures() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOStructure>)storedValueForKey(_EOStructure.TO_STRUCTURES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOStructure> toStructures(EOQualifier qualifier) {
    return toStructures(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOStructure> toStructures(EOQualifier qualifier, boolean fetch) {
    return toStructures(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOStructure> toStructures(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOStructure> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOStructure.TO_STRUCTURE_PERE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOStructure.fetchEOStructures(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toStructures();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOStructure>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOStructure>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToStructures(utt.rec.projet.server.metier.admrec.EOStructure object) {
    includeObjectIntoPropertyWithKey(object, _EOStructure.TO_STRUCTURES_KEY);
  }

  public void removeFromToStructures(utt.rec.projet.server.metier.admrec.EOStructure object) {
    excludeObjectFromPropertyWithKey(object, _EOStructure.TO_STRUCTURES_KEY);
  }

  public void addToToStructuresRelationship(utt.rec.projet.server.metier.admrec.EOStructure object) {
    if (_EOStructure.LOG.isDebugEnabled()) {
      _EOStructure.LOG.debug("adding " + object + " to toStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToStructures(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructure.TO_STRUCTURES_KEY);
    }
  }

  public void removeFromToStructuresRelationship(utt.rec.projet.server.metier.admrec.EOStructure object) {
    if (_EOStructure.LOG.isDebugEnabled()) {
      _EOStructure.LOG.debug("removing " + object + " from toStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToStructures(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructure.TO_STRUCTURES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOStructure createToStructuresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOStructure.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructure.TO_STRUCTURES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOStructure) eo;
  }

  public void deleteToStructuresRelationship(utt.rec.projet.server.metier.admrec.EOStructure object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructure.TO_STRUCTURES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToStructuresRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOStructure> objects = toStructures().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToStructuresRelationship(objects.nextElement());
    }
  }


  public static EOStructure createEOStructure(EOEditingContext editingContext, String cStructure
, String cTypeStructure
, Integer persId
, String temCotisAssedic
, String temDads
, String temSectorise
, String temSoumisTva
, String temValide
) {
    EOStructure eo = (EOStructure) EOUtilities.createAndInsertInstance(editingContext, _EOStructure.ENTITY_NAME);    
		eo.setCStructure(cStructure);
		eo.setCTypeStructure(cTypeStructure);
		eo.setPersId(persId);
		eo.setTemCotisAssedic(temCotisAssedic);
		eo.setTemDads(temDads);
		eo.setTemSectorise(temSectorise);
		eo.setTemSoumisTva(temSoumisTva);
		eo.setTemValide(temValide);
    return eo;
  }

  public static ERXFetchSpecification<EOStructure> fetchSpec() {
    return new ERXFetchSpecification<EOStructure>(_EOStructure.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOStructure> fetchAllEOStructures(EOEditingContext editingContext) {
    return _EOStructure.fetchAllEOStructures(editingContext, null);
  }

  public static NSArray<EOStructure> fetchAllEOStructures(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOStructure.fetchEOStructures(editingContext, null, sortOrderings);
  }

  public static NSArray<EOStructure> fetchEOStructures(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOStructure> fetchSpec = new ERXFetchSpecification<EOStructure>(_EOStructure.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOStructure> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOStructure fetchEOStructure(EOEditingContext editingContext, String keyName, Object value) {
    return _EOStructure.fetchEOStructure(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOStructure fetchEOStructure(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOStructure> eoObjects = _EOStructure.fetchEOStructures(editingContext, qualifier, null);
    EOStructure eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOStructure that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOStructure fetchRequiredEOStructure(EOEditingContext editingContext, String keyName, Object value) {
    return _EOStructure.fetchRequiredEOStructure(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOStructure fetchRequiredEOStructure(EOEditingContext editingContext, EOQualifier qualifier) {
    EOStructure eoObject = _EOStructure.fetchEOStructure(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOStructure that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOStructure localInstanceIn(EOEditingContext editingContext, EOStructure eo) {
    EOStructure localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
