// DO NOT EDIT.  Make changes to EOStructureUlr.java instead.
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
public abstract class _EOStructureUlr extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOStructureUlr";

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
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOAxerec> TO_AXES = new ERXKey<utt.rec.projet.server.metier.admrec.EOAxerec>("toAxes");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne> TO_PERSONNE = new ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne>("toPersonne");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> TO_PERSONNELS = new ERXKey<utt.rec.projet.server.metier.grhum.EOPersonnelUlr>("toPersonnels");
  public static final ERXKey<utt.rec.projet.server.metier.admrec.EOPfmateriel> TO_PFMATERIELS = new ERXKey<utt.rec.projet.server.metier.admrec.EOPfmateriel>("toPfmateriels");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartAssociation> TO_REPART_ASSOCIATIONS = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartAssociation>("toRepartAssociations");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartStructure> TO_REPART_STRUCTURES = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartStructure>("toRepartStructures");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> TO_REPART_TYPE_GROUPES = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe>("toRepartTypeGroupes");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr> TO_RESPONSABLE = new ERXKey<utt.rec.projet.server.metier.grhum.EOIndividuUlr>("toResponsable");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURE_PERE = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructurePere");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_STRUCTURES = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toStructures");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche> TO_VRESPONSABLE_EQUIPE_RECHERCHE = new ERXKey<utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche>("toVresponsableEquipeRecherche");

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
  public static final String TO_AXES_KEY = TO_AXES.key();
  public static final String TO_PERSONNE_KEY = TO_PERSONNE.key();
  public static final String TO_PERSONNELS_KEY = TO_PERSONNELS.key();
  public static final String TO_PFMATERIELS_KEY = TO_PFMATERIELS.key();
  public static final String TO_REPART_ASSOCIATIONS_KEY = TO_REPART_ASSOCIATIONS.key();
  public static final String TO_REPART_STRUCTURES_KEY = TO_REPART_STRUCTURES.key();
  public static final String TO_REPART_TYPE_GROUPES_KEY = TO_REPART_TYPE_GROUPES.key();
  public static final String TO_RESPONSABLE_KEY = TO_RESPONSABLE.key();
  public static final String TO_STRUCTURE_PERE_KEY = TO_STRUCTURE_PERE.key();
  public static final String TO_STRUCTURES_KEY = TO_STRUCTURES.key();
  public static final String TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY = TO_VRESPONSABLE_EQUIPE_RECHERCHE.key();

  private static Logger LOG = Logger.getLogger(_EOStructureUlr.class);

  public EOStructureUlr localInstanceIn(EOEditingContext editingContext) {
    EOStructureUlr localInstance = (EOStructureUlr)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cAcademie() {
    return (String) storedValueForKey(_EOStructureUlr.C_ACADEMIE_KEY);
  }

  public void setCAcademie(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cAcademie from " + cAcademie() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_ACADEMIE_KEY);
  }

  public String cNaf() {
    return (String) storedValueForKey(_EOStructureUlr.C_NAF_KEY);
  }

  public void setCNaf(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cNaf from " + cNaf() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_NAF_KEY);
  }

  public String cNic() {
    return (String) storedValueForKey(_EOStructureUlr.C_NIC_KEY);
  }

  public void setCNic(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cNic from " + cNic() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_NIC_KEY);
  }

  public String cRne() {
    return (String) storedValueForKey(_EOStructureUlr.C_RNE_KEY);
  }

  public void setCRne(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cRne from " + cRne() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_RNE_KEY);
  }

  public String cStatutJuridique() {
    return (String) storedValueForKey(_EOStructureUlr.C_STATUT_JURIDIQUE_KEY);
  }

  public void setCStatutJuridique(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cStatutJuridique from " + cStatutJuridique() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_STATUT_JURIDIQUE_KEY);
  }

  public String cStructure() {
    return (String) storedValueForKey(_EOStructureUlr.C_STRUCTURE_KEY);
  }

  public void setCStructure(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cStructure from " + cStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_STRUCTURE_KEY);
  }

  public String cTypeDecisionStr() {
    return (String) storedValueForKey(_EOStructureUlr.C_TYPE_DECISION_STR_KEY);
  }

  public void setCTypeDecisionStr(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cTypeDecisionStr from " + cTypeDecisionStr() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_TYPE_DECISION_STR_KEY);
  }

  public String cTypeEtablissemen() {
    return (String) storedValueForKey(_EOStructureUlr.C_TYPE_ETABLISSEMEN_KEY);
  }

  public void setCTypeEtablissemen(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cTypeEtablissemen from " + cTypeEtablissemen() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_TYPE_ETABLISSEMEN_KEY);
  }

  public String cTypeStructure() {
    return (String) storedValueForKey(_EOStructureUlr.C_TYPE_STRUCTURE_KEY);
  }

  public void setCTypeStructure(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating cTypeStructure from " + cTypeStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.C_TYPE_STRUCTURE_KEY);
  }

  public NSTimestamp dateDecision() {
    return (NSTimestamp) storedValueForKey(_EOStructureUlr.DATE_DECISION_KEY);
  }

  public void setDateDecision(NSTimestamp value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating dateDecision from " + dateDecision() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.DATE_DECISION_KEY);
  }

  public NSTimestamp dateFermeture() {
    return (NSTimestamp) storedValueForKey(_EOStructureUlr.DATE_FERMETURE_KEY);
  }

  public void setDateFermeture(NSTimestamp value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating dateFermeture from " + dateFermeture() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.DATE_FERMETURE_KEY);
  }

  public NSTimestamp dateOuverture() {
    return (NSTimestamp) storedValueForKey(_EOStructureUlr.DATE_OUVERTURE_KEY);
  }

  public void setDateOuverture(NSTimestamp value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating dateOuverture from " + dateOuverture() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.DATE_OUVERTURE_KEY);
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EOStructureUlr.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.D_CREATION_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EOStructureUlr.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.D_MODIFICATION_KEY);
  }

  public String etabCodurssaf() {
    return (String) storedValueForKey(_EOStructureUlr.ETAB_CODURSSAF_KEY);
  }

  public void setEtabCodurssaf(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating etabCodurssaf from " + etabCodurssaf() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.ETAB_CODURSSAF_KEY);
  }

  public String etabNumurssaf() {
    return (String) storedValueForKey(_EOStructureUlr.ETAB_NUMURSSAF_KEY);
  }

  public void setEtabNumurssaf(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating etabNumurssaf from " + etabNumurssaf() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.ETAB_NUMURSSAF_KEY);
  }

  public Integer export() {
    return (Integer) storedValueForKey(_EOStructureUlr.EXPORT_KEY);
  }

  public void setExport(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating export from " + export() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.EXPORT_KEY);
  }

  public String gencod() {
    return (String) storedValueForKey(_EOStructureUlr.GENCOD_KEY);
  }

  public void setGencod(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating gencod from " + gencod() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GENCOD_KEY);
  }

  public String grpAcces() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_ACCES_KEY);
  }

  public void setGrpAcces(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpAcces from " + grpAcces() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_ACCES_KEY);
  }

  public String grpAlias() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_ALIAS_KEY);
  }

  public void setGrpAlias(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpAlias from " + grpAlias() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_ALIAS_KEY);
  }

  public String grpApeCode() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_APE_CODE_KEY);
  }

  public void setGrpApeCode(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpApeCode from " + grpApeCode() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_APE_CODE_KEY);
  }

  public String grpApeCodeBis() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_APE_CODE_BIS_KEY);
  }

  public void setGrpApeCodeBis(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpApeCodeBis from " + grpApeCodeBis() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_APE_CODE_BIS_KEY);
  }

  public String grpApeCodeComp() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_APE_CODE_COMP_KEY);
  }

  public void setGrpApeCodeComp(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpApeCodeComp from " + grpApeCodeComp() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_APE_CODE_COMP_KEY);
  }

  public Integer grpCa() {
    return (Integer) storedValueForKey(_EOStructureUlr.GRP_CA_KEY);
  }

  public void setGrpCa(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpCa from " + grpCa() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_CA_KEY);
  }

  public Integer grpCapital() {
    return (Integer) storedValueForKey(_EOStructureUlr.GRP_CAPITAL_KEY);
  }

  public void setGrpCapital(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpCapital from " + grpCapital() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_CAPITAL_KEY);
  }

  public String grpCentreDecision() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_CENTRE_DECISION_KEY);
  }

  public void setGrpCentreDecision(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpCentreDecision from " + grpCentreDecision() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_CENTRE_DECISION_KEY);
  }

  public Integer grpEffectifs() {
    return (Integer) storedValueForKey(_EOStructureUlr.GRP_EFFECTIFS_KEY);
  }

  public void setGrpEffectifs(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpEffectifs from " + grpEffectifs() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_EFFECTIFS_KEY);
  }

  public String grpFonction1() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_FONCTION1_KEY);
  }

  public void setGrpFonction1(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpFonction1 from " + grpFonction1() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_FONCTION1_KEY);
  }

  public String grpFonction2() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_FONCTION2_KEY);
  }

  public void setGrpFonction2(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpFonction2 from " + grpFonction2() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_FONCTION2_KEY);
  }

  public String grpFormeJuridique() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_FORME_JURIDIQUE_KEY);
  }

  public void setGrpFormeJuridique(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpFormeJuridique from " + grpFormeJuridique() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_FORME_JURIDIQUE_KEY);
  }

  public String grpMotsClefs() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_MOTS_CLEFS_KEY);
  }

  public void setGrpMotsClefs(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpMotsClefs from " + grpMotsClefs() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_MOTS_CLEFS_KEY);
  }

  public String grpResponsabilite() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_RESPONSABILITE_KEY);
  }

  public void setGrpResponsabilite(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpResponsabilite from " + grpResponsabilite() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_RESPONSABILITE_KEY);
  }

  public Integer grpResponsable() {
    return (Integer) storedValueForKey(_EOStructureUlr.GRP_RESPONSABLE_KEY);
  }

  public void setGrpResponsable(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpResponsable from " + grpResponsable() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_RESPONSABLE_KEY);
  }

  public String grpTrademarque() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_TRADEMARQUE_KEY);
  }

  public void setGrpTrademarque(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpTrademarque from " + grpTrademarque() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_TRADEMARQUE_KEY);
  }

  public String grpWebmestre() {
    return (String) storedValueForKey(_EOStructureUlr.GRP_WEBMESTRE_KEY);
  }

  public void setGrpWebmestre(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating grpWebmestre from " + grpWebmestre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.GRP_WEBMESTRE_KEY);
  }

  public String lcStructure() {
    return (String) storedValueForKey(_EOStructureUlr.LC_STRUCTURE_KEY);
  }

  public void setLcStructure(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating lcStructure from " + lcStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.LC_STRUCTURE_KEY);
  }

  public String llStructure() {
    return (String) storedValueForKey(_EOStructureUlr.LL_STRUCTURE_KEY);
  }

  public void setLlStructure(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating llStructure from " + llStructure() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.LL_STRUCTURE_KEY);
  }

  public Integer moyenneAge() {
    return (Integer) storedValueForKey(_EOStructureUlr.MOYENNE_AGE_KEY);
  }

  public void setMoyenneAge(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating moyenneAge from " + moyenneAge() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.MOYENNE_AGE_KEY);
  }

  public String numAssedic() {
    return (String) storedValueForKey(_EOStructureUlr.NUM_ASSEDIC_KEY);
  }

  public void setNumAssedic(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating numAssedic from " + numAssedic() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.NUM_ASSEDIC_KEY);
  }

  public String numCnracl() {
    return (String) storedValueForKey(_EOStructureUlr.NUM_CNRACL_KEY);
  }

  public void setNumCnracl(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating numCnracl from " + numCnracl() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.NUM_CNRACL_KEY);
  }

  public String numIrcantec() {
    return (String) storedValueForKey(_EOStructureUlr.NUM_IRCANTEC_KEY);
  }

  public void setNumIrcantec(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating numIrcantec from " + numIrcantec() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.NUM_IRCANTEC_KEY);
  }

  public String numRafp() {
    return (String) storedValueForKey(_EOStructureUlr.NUM_RAFP_KEY);
  }

  public void setNumRafp(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating numRafp from " + numRafp() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.NUM_RAFP_KEY);
  }

  public Integer orgOrdre() {
    return (Integer) storedValueForKey(_EOStructureUlr.ORG_ORDRE_KEY);
  }

  public void setOrgOrdre(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating orgOrdre from " + orgOrdre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.ORG_ORDRE_KEY);
  }

  public Integer persId() {
    return (Integer) storedValueForKey(_EOStructureUlr.PERS_ID_KEY);
  }

  public void setPersId(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating persId from " + persId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.PERS_ID_KEY);
  }

  public Integer persIdCreation() {
    return (Integer) storedValueForKey(_EOStructureUlr.PERS_ID_CREATION_KEY);
  }

  public void setPersIdCreation(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating persIdCreation from " + persIdCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.PERS_ID_CREATION_KEY);
  }

  public Integer persIdModification() {
    return (Integer) storedValueForKey(_EOStructureUlr.PERS_ID_MODIFICATION_KEY);
  }

  public void setPersIdModification(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating persIdModification from " + persIdModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.PERS_ID_MODIFICATION_KEY);
  }

  public Integer psecOrdre() {
    return (Integer) storedValueForKey(_EOStructureUlr.PSEC_ORDRE_KEY);
  }

  public void setPsecOrdre(Integer value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating psecOrdre from " + psecOrdre() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.PSEC_ORDRE_KEY);
  }

  public String refDecision() {
    return (String) storedValueForKey(_EOStructureUlr.REF_DECISION_KEY);
  }

  public void setRefDecision(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating refDecision from " + refDecision() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.REF_DECISION_KEY);
  }

  public String refExtComp() {
    return (String) storedValueForKey(_EOStructureUlr.REF_EXT_COMP_KEY);
  }

  public void setRefExtComp(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating refExtComp from " + refExtComp() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.REF_EXT_COMP_KEY);
  }

  public String refExtCr() {
    return (String) storedValueForKey(_EOStructureUlr.REF_EXT_CR_KEY);
  }

  public void setRefExtCr(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating refExtCr from " + refExtCr() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.REF_EXT_CR_KEY);
  }

  public String refExtEtab() {
    return (String) storedValueForKey(_EOStructureUlr.REF_EXT_ETAB_KEY);
  }

  public void setRefExtEtab(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating refExtEtab from " + refExtEtab() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.REF_EXT_ETAB_KEY);
  }

  public String risqueAccTrav() {
    return (String) storedValueForKey(_EOStructureUlr.RISQUE_ACC_TRAV_KEY);
  }

  public void setRisqueAccTrav(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating risqueAccTrav from " + risqueAccTrav() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.RISQUE_ACC_TRAV_KEY);
  }

  public String siren() {
    return (String) storedValueForKey(_EOStructureUlr.SIREN_KEY);
  }

  public void setSiren(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating siren from " + siren() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.SIREN_KEY);
  }

  public String siret() {
    return (String) storedValueForKey(_EOStructureUlr.SIRET_KEY);
  }

  public void setSiret(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating siret from " + siret() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.SIRET_KEY);
  }

  public String strAccueil() {
    return (String) storedValueForKey(_EOStructureUlr.STR_ACCUEIL_KEY);
  }

  public void setStrAccueil(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating strAccueil from " + strAccueil() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.STR_ACCUEIL_KEY);
  }

  public String strActivite() {
    return (String) storedValueForKey(_EOStructureUlr.STR_ACTIVITE_KEY);
  }

  public void setStrActivite(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating strActivite from " + strActivite() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.STR_ACTIVITE_KEY);
  }

  public String strAffichage() {
    return (String) storedValueForKey(_EOStructureUlr.STR_AFFICHAGE_KEY);
  }

  public void setStrAffichage(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating strAffichage from " + strAffichage() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.STR_AFFICHAGE_KEY);
  }

  public String strOrigine() {
    return (String) storedValueForKey(_EOStructureUlr.STR_ORIGINE_KEY);
  }

  public void setStrOrigine(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating strOrigine from " + strOrigine() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.STR_ORIGINE_KEY);
  }

  public String strPhoto() {
    return (String) storedValueForKey(_EOStructureUlr.STR_PHOTO_KEY);
  }

  public void setStrPhoto(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating strPhoto from " + strPhoto() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.STR_PHOTO_KEY);
  }

  public String strRecherche() {
    return (String) storedValueForKey(_EOStructureUlr.STR_RECHERCHE_KEY);
  }

  public void setStrRecherche(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating strRecherche from " + strRecherche() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.STR_RECHERCHE_KEY);
  }

  public String tauxAccTrav() {
    return (String) storedValueForKey(_EOStructureUlr.TAUX_ACC_TRAV_KEY);
  }

  public void setTauxAccTrav(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating tauxAccTrav from " + tauxAccTrav() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TAUX_ACC_TRAV_KEY);
  }

  public String tauxExonerationTva() {
    return (String) storedValueForKey(_EOStructureUlr.TAUX_EXONERATION_TVA_KEY);
  }

  public void setTauxExonerationTva(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating tauxExonerationTva from " + tauxExonerationTva() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TAUX_EXONERATION_TVA_KEY);
  }

  public String tauxIr() {
    return (String) storedValueForKey(_EOStructureUlr.TAUX_IR_KEY);
  }

  public void setTauxIr(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating tauxIr from " + tauxIr() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TAUX_IR_KEY);
  }

  public String tauxTransport() {
    return (String) storedValueForKey(_EOStructureUlr.TAUX_TRANSPORT_KEY);
  }

  public void setTauxTransport(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating tauxTransport from " + tauxTransport() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TAUX_TRANSPORT_KEY);
  }

  public String temCotisAssedic() {
    return (String) storedValueForKey(_EOStructureUlr.TEM_COTIS_ASSEDIC_KEY);
  }

  public void setTemCotisAssedic(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating temCotisAssedic from " + temCotisAssedic() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TEM_COTIS_ASSEDIC_KEY);
  }

  public String temDads() {
    return (String) storedValueForKey(_EOStructureUlr.TEM_DADS_KEY);
  }

  public void setTemDads(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating temDads from " + temDads() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TEM_DADS_KEY);
  }

  public String temEtablissementPaye() {
    return (String) storedValueForKey(_EOStructureUlr.TEM_ETABLISSEMENT_PAYE_KEY);
  }

  public void setTemEtablissementPaye(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating temEtablissementPaye from " + temEtablissementPaye() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TEM_ETABLISSEMENT_PAYE_KEY);
  }

  public String temPlafondReduit() {
    return (String) storedValueForKey(_EOStructureUlr.TEM_PLAFOND_REDUIT_KEY);
  }

  public void setTemPlafondReduit(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating temPlafondReduit from " + temPlafondReduit() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TEM_PLAFOND_REDUIT_KEY);
  }

  public String temSectorise() {
    return (String) storedValueForKey(_EOStructureUlr.TEM_SECTORISE_KEY);
  }

  public void setTemSectorise(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating temSectorise from " + temSectorise() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TEM_SECTORISE_KEY);
  }

  public String temSoumisTva() {
    return (String) storedValueForKey(_EOStructureUlr.TEM_SOUMIS_TVA_KEY);
  }

  public void setTemSoumisTva(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating temSoumisTva from " + temSoumisTva() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TEM_SOUMIS_TVA_KEY);
  }

  public String temValide() {
    return (String) storedValueForKey(_EOStructureUlr.TEM_VALIDE_KEY);
  }

  public void setTemValide(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating temValide from " + temValide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TEM_VALIDE_KEY);
  }

  public String tvaIntracom() {
    return (String) storedValueForKey(_EOStructureUlr.TVA_INTRACOM_KEY);
  }

  public void setTvaIntracom(String value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
    	_EOStructureUlr.LOG.debug( "updating tvaIntracom from " + tvaIntracom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOStructureUlr.TVA_INTRACOM_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EOPersonne toPersonne() {
    return (utt.rec.projet.server.metier.grhum.EOPersonne)storedValueForKey(_EOStructureUlr.TO_PERSONNE_KEY);
  }
  
  public void setToPersonne(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    takeStoredValueForKey(value, _EOStructureUlr.TO_PERSONNE_KEY);
  }

  public void setToPersonneRelationship(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("updating toPersonne from " + toPersonne() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPersonne(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOPersonne oldValue = toPersonne();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOStructureUlr.TO_PERSONNE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOStructureUlr.TO_PERSONNE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOIndividuUlr toResponsable() {
    return (utt.rec.projet.server.metier.grhum.EOIndividuUlr)storedValueForKey(_EOStructureUlr.TO_RESPONSABLE_KEY);
  }
  
  public void setToResponsable(utt.rec.projet.server.metier.grhum.EOIndividuUlr value) {
    takeStoredValueForKey(value, _EOStructureUlr.TO_RESPONSABLE_KEY);
  }

  public void setToResponsableRelationship(utt.rec.projet.server.metier.grhum.EOIndividuUlr value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("updating toResponsable from " + toResponsable() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToResponsable(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOIndividuUlr oldValue = toResponsable();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOStructureUlr.TO_RESPONSABLE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOStructureUlr.TO_RESPONSABLE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOStructureUlr toStructurePere() {
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr)storedValueForKey(_EOStructureUlr.TO_STRUCTURE_PERE_KEY);
  }
  
  public void setToStructurePere(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    takeStoredValueForKey(value, _EOStructureUlr.TO_STRUCTURE_PERE_KEY);
  }

  public void setToStructurePereRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("updating toStructurePere from " + toStructurePere() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToStructurePere(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOStructureUlr oldValue = toStructurePere();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOStructureUlr.TO_STRUCTURE_PERE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOStructureUlr.TO_STRUCTURE_PERE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche toVresponsableEquipeRecherche() {
    return (utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche)storedValueForKey(_EOStructureUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY);
  }
  
  public void setToVresponsableEquipeRecherche(utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche value) {
    takeStoredValueForKey(value, _EOStructureUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY);
  }

  public void setToVresponsableEquipeRechercheRelationship(utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche value) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("updating toVresponsableEquipeRecherche from " + toVresponsableEquipeRecherche() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToVresponsableEquipeRecherche(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche oldValue = toVresponsableEquipeRecherche();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOStructureUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOStructureUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> toAxes() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)storedValueForKey(_EOStructureUlr.TO_AXES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> toAxes(EOQualifier qualifier) {
    return toAxes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> toAxes(EOQualifier qualifier, boolean fetch) {
    return toAxes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> toAxes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOAxerec> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOAxerec.TO_EQUIPE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOAxerec.fetchEOAxerecs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toAxes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOAxerec>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToAxes(utt.rec.projet.server.metier.admrec.EOAxerec object) {
    includeObjectIntoPropertyWithKey(object, _EOStructureUlr.TO_AXES_KEY);
  }

  public void removeFromToAxes(utt.rec.projet.server.metier.admrec.EOAxerec object) {
    excludeObjectFromPropertyWithKey(object, _EOStructureUlr.TO_AXES_KEY);
  }

  public void addToToAxesRelationship(utt.rec.projet.server.metier.admrec.EOAxerec object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("adding " + object + " to toAxes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToAxes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_AXES_KEY);
    }
  }

  public void removeFromToAxesRelationship(utt.rec.projet.server.metier.admrec.EOAxerec object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("removing " + object + " from toAxes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToAxes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_AXES_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOAxerec createToAxesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOAxerec.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructureUlr.TO_AXES_KEY);
    return (utt.rec.projet.server.metier.admrec.EOAxerec) eo;
  }

  public void deleteToAxesRelationship(utt.rec.projet.server.metier.admrec.EOAxerec object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_AXES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToAxesRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOAxerec> objects = toAxes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToAxesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> toPersonnels() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr>)storedValueForKey(_EOStructureUlr.TO_PERSONNELS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> toPersonnels(EOQualifier qualifier) {
    return toPersonnels(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> toPersonnels(EOQualifier qualifier, boolean fetch) {
    return toPersonnels(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> toPersonnels(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOPersonnelUlr.TO_STRUCTURE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EOPersonnelUlr.fetchEOPersonnelUlrs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toPersonnels();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToPersonnels(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    includeObjectIntoPropertyWithKey(object, _EOStructureUlr.TO_PERSONNELS_KEY);
  }

  public void removeFromToPersonnels(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    excludeObjectFromPropertyWithKey(object, _EOStructureUlr.TO_PERSONNELS_KEY);
  }

  public void addToToPersonnelsRelationship(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("adding " + object + " to toPersonnels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToPersonnels(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_PERSONNELS_KEY);
    }
  }

  public void removeFromToPersonnelsRelationship(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("removing " + object + " from toPersonnels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToPersonnels(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_PERSONNELS_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOPersonnelUlr createToPersonnelsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOPersonnelUlr.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructureUlr.TO_PERSONNELS_KEY);
    return (utt.rec.projet.server.metier.grhum.EOPersonnelUlr) eo;
  }

  public void deleteToPersonnelsRelationship(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_PERSONNELS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToPersonnelsRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> objects = toPersonnels().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToPersonnelsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel> toPfmateriels() {
    return (NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel>)storedValueForKey(_EOStructureUlr.TO_PFMATERIELS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel> toPfmateriels(EOQualifier qualifier) {
    return toPfmateriels(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel> toPfmateriels(EOQualifier qualifier, boolean fetch) {
    return toPfmateriels(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel> toPfmateriels(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.admrec.EOPfmateriel.TO_STRUCTURE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.admrec.EOPfmateriel.fetchEOPfmateriels(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toPfmateriels();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.admrec.EOPfmateriel>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToPfmateriels(utt.rec.projet.server.metier.admrec.EOPfmateriel object) {
    includeObjectIntoPropertyWithKey(object, _EOStructureUlr.TO_PFMATERIELS_KEY);
  }

  public void removeFromToPfmateriels(utt.rec.projet.server.metier.admrec.EOPfmateriel object) {
    excludeObjectFromPropertyWithKey(object, _EOStructureUlr.TO_PFMATERIELS_KEY);
  }

  public void addToToPfmaterielsRelationship(utt.rec.projet.server.metier.admrec.EOPfmateriel object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("adding " + object + " to toPfmateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToPfmateriels(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_PFMATERIELS_KEY);
    }
  }

  public void removeFromToPfmaterielsRelationship(utt.rec.projet.server.metier.admrec.EOPfmateriel object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("removing " + object + " from toPfmateriels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToPfmateriels(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_PFMATERIELS_KEY);
    }
  }

  public utt.rec.projet.server.metier.admrec.EOPfmateriel createToPfmaterielsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.admrec.EOPfmateriel.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructureUlr.TO_PFMATERIELS_KEY);
    return (utt.rec.projet.server.metier.admrec.EOPfmateriel) eo;
  }

  public void deleteToPfmaterielsRelationship(utt.rec.projet.server.metier.admrec.EOPfmateriel object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_PFMATERIELS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToPfmaterielsRelationships() {
    Enumeration<utt.rec.projet.server.metier.admrec.EOPfmateriel> objects = toPfmateriels().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToPfmaterielsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)storedValueForKey(_EOStructureUlr.TO_REPART_ASSOCIATIONS_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations(EOQualifier qualifier) {
    return toRepartAssociations(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations(EOQualifier qualifier, boolean fetch) {
    return toRepartAssociations(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> toRepartAssociations(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EORepartAssociation.TO_STRUCTURE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EORepartAssociation.fetchEORepartAssociations(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toRepartAssociations();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartAssociation>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToRepartAssociations(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    includeObjectIntoPropertyWithKey(object, _EOStructureUlr.TO_REPART_ASSOCIATIONS_KEY);
  }

  public void removeFromToRepartAssociations(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    excludeObjectFromPropertyWithKey(object, _EOStructureUlr.TO_REPART_ASSOCIATIONS_KEY);
  }

  public void addToToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("adding " + object + " to toRepartAssociations relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRepartAssociations(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_ASSOCIATIONS_KEY);
    }
  }

  public void removeFromToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("removing " + object + " from toRepartAssociations relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRepartAssociations(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_ASSOCIATIONS_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EORepartAssociation createToRepartAssociationsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EORepartAssociation.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructureUlr.TO_REPART_ASSOCIATIONS_KEY);
    return (utt.rec.projet.server.metier.grhum.EORepartAssociation) eo;
  }

  public void deleteToRepartAssociationsRelationship(utt.rec.projet.server.metier.grhum.EORepartAssociation object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_ASSOCIATIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRepartAssociationsRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EORepartAssociation> objects = toRepartAssociations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRepartAssociationsRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)storedValueForKey(_EOStructureUlr.TO_REPART_STRUCTURES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures(EOQualifier qualifier) {
    return toRepartStructures(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures(EOQualifier qualifier, boolean fetch) {
    return toRepartStructures(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EORepartStructure.TO_STRUCTURE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EORepartStructure.fetchEORepartStructures(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toRepartStructures();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToRepartStructures(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    includeObjectIntoPropertyWithKey(object, _EOStructureUlr.TO_REPART_STRUCTURES_KEY);
  }

  public void removeFromToRepartStructures(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    excludeObjectFromPropertyWithKey(object, _EOStructureUlr.TO_REPART_STRUCTURES_KEY);
  }

  public void addToToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("adding " + object + " to toRepartStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRepartStructures(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_STRUCTURES_KEY);
    }
  }

  public void removeFromToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("removing " + object + " from toRepartStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRepartStructures(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_STRUCTURES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EORepartStructure createToRepartStructuresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EORepartStructure.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructureUlr.TO_REPART_STRUCTURES_KEY);
    return (utt.rec.projet.server.metier.grhum.EORepartStructure) eo;
  }

  public void deleteToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_STRUCTURES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRepartStructuresRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EORepartStructure> objects = toRepartStructures().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRepartStructuresRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> toRepartTypeGroupes() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe>)storedValueForKey(_EOStructureUlr.TO_REPART_TYPE_GROUPES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> toRepartTypeGroupes(EOQualifier qualifier) {
    return toRepartTypeGroupes(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> toRepartTypeGroupes(EOQualifier qualifier, boolean fetch) {
    return toRepartTypeGroupes(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> toRepartTypeGroupes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe.TO_STRUCTURE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EORepartTypeGroupe.fetchEORepartTypeGroupes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toRepartTypeGroupes();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToRepartTypeGroupes(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    includeObjectIntoPropertyWithKey(object, _EOStructureUlr.TO_REPART_TYPE_GROUPES_KEY);
  }

  public void removeFromToRepartTypeGroupes(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    excludeObjectFromPropertyWithKey(object, _EOStructureUlr.TO_REPART_TYPE_GROUPES_KEY);
  }

  public void addToToRepartTypeGroupesRelationship(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("adding " + object + " to toRepartTypeGroupes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRepartTypeGroupes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_TYPE_GROUPES_KEY);
    }
  }

  public void removeFromToRepartTypeGroupesRelationship(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("removing " + object + " from toRepartTypeGroupes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRepartTypeGroupes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_TYPE_GROUPES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EORepartTypeGroupe createToRepartTypeGroupesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EORepartTypeGroupe.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructureUlr.TO_REPART_TYPE_GROUPES_KEY);
    return (utt.rec.projet.server.metier.grhum.EORepartTypeGroupe) eo;
  }

  public void deleteToRepartTypeGroupesRelationship(utt.rec.projet.server.metier.grhum.EORepartTypeGroupe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_REPART_TYPE_GROUPES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRepartTypeGroupesRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EORepartTypeGroupe> objects = toRepartTypeGroupes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRepartTypeGroupesRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)storedValueForKey(_EOStructureUlr.TO_STRUCTURES_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures(EOQualifier qualifier) {
    return toStructures(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures(EOQualifier qualifier, boolean fetch) {
    return toStructures(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toStructures(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOStructureUlr.TO_STRUCTURE_PERE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = utt.rec.projet.server.metier.grhum.EOStructureUlr.fetchEOStructureUlrs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toStructures();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToStructures(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    includeObjectIntoPropertyWithKey(object, _EOStructureUlr.TO_STRUCTURES_KEY);
  }

  public void removeFromToStructures(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    excludeObjectFromPropertyWithKey(object, _EOStructureUlr.TO_STRUCTURES_KEY);
  }

  public void addToToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("adding " + object + " to toStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToStructures(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_STRUCTURES_KEY);
    }
  }

  public void removeFromToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    if (_EOStructureUlr.LOG.isDebugEnabled()) {
      _EOStructureUlr.LOG.debug("removing " + object + " from toStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToStructures(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_STRUCTURES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOStructureUlr createToStructuresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOStructureUlr.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOStructureUlr.TO_STRUCTURES_KEY);
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr) eo;
  }

  public void deleteToStructuresRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOStructureUlr.TO_STRUCTURES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToStructuresRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOStructureUlr> objects = toStructures().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToStructuresRelationship(objects.nextElement());
    }
  }


  public static EOStructureUlr createEOStructureUlr(EOEditingContext editingContext, String cStructure
, String cTypeStructure
, Integer persId
, String temCotisAssedic
, String temDads
, String temSectorise
, String temSoumisTva
, String temValide
, utt.rec.projet.server.metier.grhum.EOPersonne toPersonne, utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche toVresponsableEquipeRecherche) {
    EOStructureUlr eo = (EOStructureUlr) EOUtilities.createAndInsertInstance(editingContext, _EOStructureUlr.ENTITY_NAME);    
		eo.setCStructure(cStructure);
		eo.setCTypeStructure(cTypeStructure);
		eo.setPersId(persId);
		eo.setTemCotisAssedic(temCotisAssedic);
		eo.setTemDads(temDads);
		eo.setTemSectorise(temSectorise);
		eo.setTemSoumisTva(temSoumisTva);
		eo.setTemValide(temValide);
    eo.setToPersonneRelationship(toPersonne);
    eo.setToVresponsableEquipeRechercheRelationship(toVresponsableEquipeRecherche);
    return eo;
  }

  public static ERXFetchSpecification<EOStructureUlr> fetchSpec() {
    return new ERXFetchSpecification<EOStructureUlr>(_EOStructureUlr.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOStructureUlr> fetchAllEOStructureUlrs(EOEditingContext editingContext) {
    return _EOStructureUlr.fetchAllEOStructureUlrs(editingContext, null);
  }

  public static NSArray<EOStructureUlr> fetchAllEOStructureUlrs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOStructureUlr.fetchEOStructureUlrs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOStructureUlr> fetchEOStructureUlrs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOStructureUlr> fetchSpec = new ERXFetchSpecification<EOStructureUlr>(_EOStructureUlr.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOStructureUlr> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOStructureUlr fetchEOStructureUlr(EOEditingContext editingContext, String keyName, Object value) {
    return _EOStructureUlr.fetchEOStructureUlr(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOStructureUlr fetchEOStructureUlr(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOStructureUlr> eoObjects = _EOStructureUlr.fetchEOStructureUlrs(editingContext, qualifier, null);
    EOStructureUlr eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOStructureUlr that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOStructureUlr fetchRequiredEOStructureUlr(EOEditingContext editingContext, String keyName, Object value) {
    return _EOStructureUlr.fetchRequiredEOStructureUlr(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOStructureUlr fetchRequiredEOStructureUlr(EOEditingContext editingContext, EOQualifier qualifier) {
    EOStructureUlr eoObject = _EOStructureUlr.fetchEOStructureUlr(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOStructureUlr that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOStructureUlr localInstanceIn(EOEditingContext editingContext, EOStructureUlr eo) {
    EOStructureUlr localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> fetchEquipes(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("Equipes", _EOStructureUlr.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> fetchEquipes(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("Equipes", _EOStructureUlr.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> fetchPoleCompetence(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("poleCompetence", _EOStructureUlr.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> fetchPoleCompetence(EOEditingContext editingContext,
	Integer persIdBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("poleCompetence", _EOStructureUlr.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(persIdBinding, "persId");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> fetchPoles(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("Poles", _EOStructureUlr.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> fetchPoles(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("Poles", _EOStructureUlr.ENTITY_NAME);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
