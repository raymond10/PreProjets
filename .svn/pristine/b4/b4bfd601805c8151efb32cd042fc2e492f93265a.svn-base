// DO NOT EDIT.  Make changes to EOIndividuUlr.java instead.
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
public abstract class _EOIndividuUlr extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOIndividuUlr";

  // Attribute Keys
  public static final ERXKey<Integer> CATEGORIE_PRINC = new ERXKey<Integer>("categoriePrinc");
  public static final ERXKey<String> C_CIVILITE = new ERXKey<String>("cCivilite");
  public static final ERXKey<String> C_DEPT_NAISSANCE = new ERXKey<String>("cDeptNaissance");
  public static final ERXKey<String> C_PAYS_NAISSANCE = new ERXKey<String>("cPaysNaissance");
  public static final ERXKey<String> C_PAYS_NATIONALITE = new ERXKey<String>("cPaysNationalite");
  public static final ERXKey<NSTimestamp> D_CREATION = new ERXKey<NSTimestamp>("dCreation");
  public static final ERXKey<NSTimestamp> D_DECES = new ERXKey<NSTimestamp>("dDeces");
  public static final ERXKey<NSTimestamp> D_MODIFICATION = new ERXKey<NSTimestamp>("dModification");
  public static final ERXKey<NSTimestamp> D_NAISSANCE = new ERXKey<NSTimestamp>("dNaissance");
  public static final ERXKey<NSTimestamp> D_NATURALISATION = new ERXKey<NSTimestamp>("dNaturalisation");
  public static final ERXKey<String> IND_ACTIVITE = new ERXKey<String>("indActivite");
  public static final ERXKey<String> IND_AGENDA = new ERXKey<String>("indAgenda");
  public static final ERXKey<Integer> IND_CLE_INSEE = new ERXKey<Integer>("indCleInsee");
  public static final ERXKey<Integer> IND_CLE_INSEE_PROV = new ERXKey<Integer>("indCleInseeProv");
  public static final ERXKey<String> IND_C_SIT_MILITAIRE = new ERXKey<String>("indCSitMilitaire");
  public static final ERXKey<String> IND_C_SITUATION_FAMILLE = new ERXKey<String>("indCSituationFamille");
  public static final ERXKey<String> IND_NO_INSEE = new ERXKey<String>("indNoInsee");
  public static final ERXKey<String> IND_NO_INSEE_PROV = new ERXKey<String>("indNoInseeProv");
  public static final ERXKey<String> IND_ORIGINE = new ERXKey<String>("indOrigine");
  public static final ERXKey<String> IND_PHOTO = new ERXKey<String>("indPhoto");
  public static final ERXKey<String> IND_QUALITE = new ERXKey<String>("indQualite");
  public static final ERXKey<String> LANGUE_PREF = new ERXKey<String>("languePref");
  public static final ERXKey<String> LIEU_DECES = new ERXKey<String>("lieuDeces");
  public static final ERXKey<String> LISTE_ROUGE = new ERXKey<String>("listeRouge");
  public static final ERXKey<Integer> NO_INDIVIDU = new ERXKey<Integer>("noIndividu");
  public static final ERXKey<Integer> NO_INDIVIDU_CREATEUR = new ERXKey<Integer>("noIndividuCreateur");
  public static final ERXKey<String> NOM_AFFICHAGE = new ERXKey<String>("nomAffichage");
  public static final ERXKey<String> NOM_PATRONYMIQUE = new ERXKey<String>("nomPatronymique");
  public static final ERXKey<String> NOM_PATRONYMIQUE_AFFICHAGE = new ERXKey<String>("nomPatronymiqueAffichage");
  public static final ERXKey<String> NOM_USUEL = new ERXKey<String>("nomUsuel");
  public static final ERXKey<String> ORGA_CODE = new ERXKey<String>("orgaCode");
  public static final ERXKey<String> ORGA_LIBELLE = new ERXKey<String>("orgaLibelle");
  public static final ERXKey<Integer> PERS_ID = new ERXKey<Integer>("persId");
  public static final ERXKey<Integer> PERS_ID_CREATION = new ERXKey<Integer>("persIdCreation");
  public static final ERXKey<Integer> PERS_ID_MODIFICATION = new ERXKey<Integer>("persIdModification");
  public static final ERXKey<String> PRENOM = new ERXKey<String>("prenom");
  public static final ERXKey<String> PRENOM2 = new ERXKey<String>("prenom2");
  public static final ERXKey<String> PRENOM_AFFICHAGE = new ERXKey<String>("prenomAffichage");
  public static final ERXKey<String> PRISE_CPT_INSEE = new ERXKey<String>("priseCptInsee");
  public static final ERXKey<String> TEM_SS_DIPLOME = new ERXKey<String>("temSsDiplome");
  public static final ERXKey<String> TEM_VALIDE = new ERXKey<String>("temValide");
  public static final ERXKey<String> VILLE_DE_NAISSANCE = new ERXKey<String>("villeDeNaissance");
  // Relationship Keys
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr> TO_GRP_RESPONSABLE = new ERXKey<utt.rec.projet.server.metier.grhum.EOStructureUlr>("toGrpResponsable");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne> TO_PERSONNE = new ERXKey<utt.rec.projet.server.metier.grhum.EOPersonne>("toPersonne");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> TO_PERSONNEL = new ERXKey<utt.rec.projet.server.metier.grhum.EOPersonnelUlr>("toPersonnel");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EORepartStructure> TO_REPART_STRUCTURES = new ERXKey<utt.rec.projet.server.metier.grhum.EORepartStructure>("toRepartStructures");
  public static final ERXKey<utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche> TO_VRESPONSABLE_EQUIPE_RECHERCHE = new ERXKey<utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche>("toVresponsableEquipeRecherche");

  // Attributes
  public static final String CATEGORIE_PRINC_KEY = CATEGORIE_PRINC.key();
  public static final String C_CIVILITE_KEY = C_CIVILITE.key();
  public static final String C_DEPT_NAISSANCE_KEY = C_DEPT_NAISSANCE.key();
  public static final String C_PAYS_NAISSANCE_KEY = C_PAYS_NAISSANCE.key();
  public static final String C_PAYS_NATIONALITE_KEY = C_PAYS_NATIONALITE.key();
  public static final String D_CREATION_KEY = D_CREATION.key();
  public static final String D_DECES_KEY = D_DECES.key();
  public static final String D_MODIFICATION_KEY = D_MODIFICATION.key();
  public static final String D_NAISSANCE_KEY = D_NAISSANCE.key();
  public static final String D_NATURALISATION_KEY = D_NATURALISATION.key();
  public static final String IND_ACTIVITE_KEY = IND_ACTIVITE.key();
  public static final String IND_AGENDA_KEY = IND_AGENDA.key();
  public static final String IND_CLE_INSEE_KEY = IND_CLE_INSEE.key();
  public static final String IND_CLE_INSEE_PROV_KEY = IND_CLE_INSEE_PROV.key();
  public static final String IND_C_SIT_MILITAIRE_KEY = IND_C_SIT_MILITAIRE.key();
  public static final String IND_C_SITUATION_FAMILLE_KEY = IND_C_SITUATION_FAMILLE.key();
  public static final String IND_NO_INSEE_KEY = IND_NO_INSEE.key();
  public static final String IND_NO_INSEE_PROV_KEY = IND_NO_INSEE_PROV.key();
  public static final String IND_ORIGINE_KEY = IND_ORIGINE.key();
  public static final String IND_PHOTO_KEY = IND_PHOTO.key();
  public static final String IND_QUALITE_KEY = IND_QUALITE.key();
  public static final String LANGUE_PREF_KEY = LANGUE_PREF.key();
  public static final String LIEU_DECES_KEY = LIEU_DECES.key();
  public static final String LISTE_ROUGE_KEY = LISTE_ROUGE.key();
  public static final String NO_INDIVIDU_KEY = NO_INDIVIDU.key();
  public static final String NO_INDIVIDU_CREATEUR_KEY = NO_INDIVIDU_CREATEUR.key();
  public static final String NOM_AFFICHAGE_KEY = NOM_AFFICHAGE.key();
  public static final String NOM_PATRONYMIQUE_KEY = NOM_PATRONYMIQUE.key();
  public static final String NOM_PATRONYMIQUE_AFFICHAGE_KEY = NOM_PATRONYMIQUE_AFFICHAGE.key();
  public static final String NOM_USUEL_KEY = NOM_USUEL.key();
  public static final String ORGA_CODE_KEY = ORGA_CODE.key();
  public static final String ORGA_LIBELLE_KEY = ORGA_LIBELLE.key();
  public static final String PERS_ID_KEY = PERS_ID.key();
  public static final String PERS_ID_CREATION_KEY = PERS_ID_CREATION.key();
  public static final String PERS_ID_MODIFICATION_KEY = PERS_ID_MODIFICATION.key();
  public static final String PRENOM_KEY = PRENOM.key();
  public static final String PRENOM2_KEY = PRENOM2.key();
  public static final String PRENOM_AFFICHAGE_KEY = PRENOM_AFFICHAGE.key();
  public static final String PRISE_CPT_INSEE_KEY = PRISE_CPT_INSEE.key();
  public static final String TEM_SS_DIPLOME_KEY = TEM_SS_DIPLOME.key();
  public static final String TEM_VALIDE_KEY = TEM_VALIDE.key();
  public static final String VILLE_DE_NAISSANCE_KEY = VILLE_DE_NAISSANCE.key();
  // Relationships
  public static final String TO_GRP_RESPONSABLE_KEY = TO_GRP_RESPONSABLE.key();
  public static final String TO_PERSONNE_KEY = TO_PERSONNE.key();
  public static final String TO_PERSONNEL_KEY = TO_PERSONNEL.key();
  public static final String TO_REPART_STRUCTURES_KEY = TO_REPART_STRUCTURES.key();
  public static final String TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY = TO_VRESPONSABLE_EQUIPE_RECHERCHE.key();

  private static Logger LOG = Logger.getLogger(_EOIndividuUlr.class);

  public EOIndividuUlr localInstanceIn(EOEditingContext editingContext) {
    EOIndividuUlr localInstance = (EOIndividuUlr)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer categoriePrinc() {
    return (Integer) storedValueForKey(_EOIndividuUlr.CATEGORIE_PRINC_KEY);
  }

  public void setCategoriePrinc(Integer value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating categoriePrinc from " + categoriePrinc() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.CATEGORIE_PRINC_KEY);
  }

  public String cCivilite() {
    return (String) storedValueForKey(_EOIndividuUlr.C_CIVILITE_KEY);
  }

  public void setCCivilite(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating cCivilite from " + cCivilite() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.C_CIVILITE_KEY);
  }

  public String cDeptNaissance() {
    return (String) storedValueForKey(_EOIndividuUlr.C_DEPT_NAISSANCE_KEY);
  }

  public void setCDeptNaissance(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating cDeptNaissance from " + cDeptNaissance() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.C_DEPT_NAISSANCE_KEY);
  }

  public String cPaysNaissance() {
    return (String) storedValueForKey(_EOIndividuUlr.C_PAYS_NAISSANCE_KEY);
  }

  public void setCPaysNaissance(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating cPaysNaissance from " + cPaysNaissance() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.C_PAYS_NAISSANCE_KEY);
  }

  public String cPaysNationalite() {
    return (String) storedValueForKey(_EOIndividuUlr.C_PAYS_NATIONALITE_KEY);
  }

  public void setCPaysNationalite(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating cPaysNationalite from " + cPaysNationalite() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.C_PAYS_NATIONALITE_KEY);
  }

  public NSTimestamp dCreation() {
    return (NSTimestamp) storedValueForKey(_EOIndividuUlr.D_CREATION_KEY);
  }

  public void setDCreation(NSTimestamp value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating dCreation from " + dCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.D_CREATION_KEY);
  }

  public NSTimestamp dDeces() {
    return (NSTimestamp) storedValueForKey(_EOIndividuUlr.D_DECES_KEY);
  }

  public void setDDeces(NSTimestamp value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating dDeces from " + dDeces() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.D_DECES_KEY);
  }

  public NSTimestamp dModification() {
    return (NSTimestamp) storedValueForKey(_EOIndividuUlr.D_MODIFICATION_KEY);
  }

  public void setDModification(NSTimestamp value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating dModification from " + dModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.D_MODIFICATION_KEY);
  }

  public NSTimestamp dNaissance() {
    return (NSTimestamp) storedValueForKey(_EOIndividuUlr.D_NAISSANCE_KEY);
  }

  public void setDNaissance(NSTimestamp value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating dNaissance from " + dNaissance() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.D_NAISSANCE_KEY);
  }

  public NSTimestamp dNaturalisation() {
    return (NSTimestamp) storedValueForKey(_EOIndividuUlr.D_NATURALISATION_KEY);
  }

  public void setDNaturalisation(NSTimestamp value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating dNaturalisation from " + dNaturalisation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.D_NATURALISATION_KEY);
  }

  public String indActivite() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_ACTIVITE_KEY);
  }

  public void setIndActivite(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indActivite from " + indActivite() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_ACTIVITE_KEY);
  }

  public String indAgenda() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_AGENDA_KEY);
  }

  public void setIndAgenda(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indAgenda from " + indAgenda() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_AGENDA_KEY);
  }

  public Integer indCleInsee() {
    return (Integer) storedValueForKey(_EOIndividuUlr.IND_CLE_INSEE_KEY);
  }

  public void setIndCleInsee(Integer value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indCleInsee from " + indCleInsee() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_CLE_INSEE_KEY);
  }

  public Integer indCleInseeProv() {
    return (Integer) storedValueForKey(_EOIndividuUlr.IND_CLE_INSEE_PROV_KEY);
  }

  public void setIndCleInseeProv(Integer value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indCleInseeProv from " + indCleInseeProv() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_CLE_INSEE_PROV_KEY);
  }

  public String indCSitMilitaire() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_C_SIT_MILITAIRE_KEY);
  }

  public void setIndCSitMilitaire(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indCSitMilitaire from " + indCSitMilitaire() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_C_SIT_MILITAIRE_KEY);
  }

  public String indCSituationFamille() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_C_SITUATION_FAMILLE_KEY);
  }

  public void setIndCSituationFamille(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indCSituationFamille from " + indCSituationFamille() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_C_SITUATION_FAMILLE_KEY);
  }

  public String indNoInsee() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_NO_INSEE_KEY);
  }

  public void setIndNoInsee(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indNoInsee from " + indNoInsee() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_NO_INSEE_KEY);
  }

  public String indNoInseeProv() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_NO_INSEE_PROV_KEY);
  }

  public void setIndNoInseeProv(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indNoInseeProv from " + indNoInseeProv() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_NO_INSEE_PROV_KEY);
  }

  public String indOrigine() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_ORIGINE_KEY);
  }

  public void setIndOrigine(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indOrigine from " + indOrigine() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_ORIGINE_KEY);
  }

  public String indPhoto() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_PHOTO_KEY);
  }

  public void setIndPhoto(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indPhoto from " + indPhoto() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_PHOTO_KEY);
  }

  public String indQualite() {
    return (String) storedValueForKey(_EOIndividuUlr.IND_QUALITE_KEY);
  }

  public void setIndQualite(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating indQualite from " + indQualite() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.IND_QUALITE_KEY);
  }

  public String languePref() {
    return (String) storedValueForKey(_EOIndividuUlr.LANGUE_PREF_KEY);
  }

  public void setLanguePref(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating languePref from " + languePref() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.LANGUE_PREF_KEY);
  }

  public String lieuDeces() {
    return (String) storedValueForKey(_EOIndividuUlr.LIEU_DECES_KEY);
  }

  public void setLieuDeces(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating lieuDeces from " + lieuDeces() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.LIEU_DECES_KEY);
  }

  public String listeRouge() {
    return (String) storedValueForKey(_EOIndividuUlr.LISTE_ROUGE_KEY);
  }

  public void setListeRouge(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating listeRouge from " + listeRouge() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.LISTE_ROUGE_KEY);
  }

  public Integer noIndividu() {
    return (Integer) storedValueForKey(_EOIndividuUlr.NO_INDIVIDU_KEY);
  }

  public void setNoIndividu(Integer value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating noIndividu from " + noIndividu() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.NO_INDIVIDU_KEY);
  }

  public Integer noIndividuCreateur() {
    return (Integer) storedValueForKey(_EOIndividuUlr.NO_INDIVIDU_CREATEUR_KEY);
  }

  public void setNoIndividuCreateur(Integer value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating noIndividuCreateur from " + noIndividuCreateur() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.NO_INDIVIDU_CREATEUR_KEY);
  }

  public String nomAffichage() {
    return (String) storedValueForKey(_EOIndividuUlr.NOM_AFFICHAGE_KEY);
  }

  public void setNomAffichage(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating nomAffichage from " + nomAffichage() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.NOM_AFFICHAGE_KEY);
  }

  public String nomPatronymique() {
    return (String) storedValueForKey(_EOIndividuUlr.NOM_PATRONYMIQUE_KEY);
  }

  public void setNomPatronymique(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating nomPatronymique from " + nomPatronymique() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.NOM_PATRONYMIQUE_KEY);
  }

  public String nomPatronymiqueAffichage() {
    return (String) storedValueForKey(_EOIndividuUlr.NOM_PATRONYMIQUE_AFFICHAGE_KEY);
  }

  public void setNomPatronymiqueAffichage(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating nomPatronymiqueAffichage from " + nomPatronymiqueAffichage() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.NOM_PATRONYMIQUE_AFFICHAGE_KEY);
  }

  public String nomUsuel() {
    return (String) storedValueForKey(_EOIndividuUlr.NOM_USUEL_KEY);
  }

  public void setNomUsuel(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating nomUsuel from " + nomUsuel() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.NOM_USUEL_KEY);
  }

  public String orgaCode() {
    return (String) storedValueForKey(_EOIndividuUlr.ORGA_CODE_KEY);
  }

  public void setOrgaCode(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating orgaCode from " + orgaCode() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.ORGA_CODE_KEY);
  }

  public String orgaLibelle() {
    return (String) storedValueForKey(_EOIndividuUlr.ORGA_LIBELLE_KEY);
  }

  public void setOrgaLibelle(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating orgaLibelle from " + orgaLibelle() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.ORGA_LIBELLE_KEY);
  }

  public Integer persId() {
    return (Integer) storedValueForKey(_EOIndividuUlr.PERS_ID_KEY);
  }

  public void setPersId(Integer value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating persId from " + persId() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.PERS_ID_KEY);
  }

  public Integer persIdCreation() {
    return (Integer) storedValueForKey(_EOIndividuUlr.PERS_ID_CREATION_KEY);
  }

  public void setPersIdCreation(Integer value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating persIdCreation from " + persIdCreation() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.PERS_ID_CREATION_KEY);
  }

  public Integer persIdModification() {
    return (Integer) storedValueForKey(_EOIndividuUlr.PERS_ID_MODIFICATION_KEY);
  }

  public void setPersIdModification(Integer value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating persIdModification from " + persIdModification() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.PERS_ID_MODIFICATION_KEY);
  }

  public String prenom() {
    return (String) storedValueForKey(_EOIndividuUlr.PRENOM_KEY);
  }

  public void setPrenom(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating prenom from " + prenom() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.PRENOM_KEY);
  }

  public String prenom2() {
    return (String) storedValueForKey(_EOIndividuUlr.PRENOM2_KEY);
  }

  public void setPrenom2(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating prenom2 from " + prenom2() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.PRENOM2_KEY);
  }

  public String prenomAffichage() {
    return (String) storedValueForKey(_EOIndividuUlr.PRENOM_AFFICHAGE_KEY);
  }

  public void setPrenomAffichage(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating prenomAffichage from " + prenomAffichage() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.PRENOM_AFFICHAGE_KEY);
  }

  public String priseCptInsee() {
    return (String) storedValueForKey(_EOIndividuUlr.PRISE_CPT_INSEE_KEY);
  }

  public void setPriseCptInsee(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating priseCptInsee from " + priseCptInsee() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.PRISE_CPT_INSEE_KEY);
  }

  public String temSsDiplome() {
    return (String) storedValueForKey(_EOIndividuUlr.TEM_SS_DIPLOME_KEY);
  }

  public void setTemSsDiplome(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating temSsDiplome from " + temSsDiplome() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.TEM_SS_DIPLOME_KEY);
  }

  public String temValide() {
    return (String) storedValueForKey(_EOIndividuUlr.TEM_VALIDE_KEY);
  }

  public void setTemValide(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating temValide from " + temValide() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.TEM_VALIDE_KEY);
  }

  public String villeDeNaissance() {
    return (String) storedValueForKey(_EOIndividuUlr.VILLE_DE_NAISSANCE_KEY);
  }

  public void setVilleDeNaissance(String value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
    	_EOIndividuUlr.LOG.debug( "updating villeDeNaissance from " + villeDeNaissance() + " to " + value);
    }
    takeStoredValueForKey(value, _EOIndividuUlr.VILLE_DE_NAISSANCE_KEY);
  }

  public utt.rec.projet.server.metier.grhum.EOPersonne toPersonne() {
    return (utt.rec.projet.server.metier.grhum.EOPersonne)storedValueForKey(_EOIndividuUlr.TO_PERSONNE_KEY);
  }
  
  public void setToPersonne(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    takeStoredValueForKey(value, _EOIndividuUlr.TO_PERSONNE_KEY);
  }

  public void setToPersonneRelationship(utt.rec.projet.server.metier.grhum.EOPersonne value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
      _EOIndividuUlr.LOG.debug("updating toPersonne from " + toPersonne() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToPersonne(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOPersonne oldValue = toPersonne();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOIndividuUlr.TO_PERSONNE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOIndividuUlr.TO_PERSONNE_KEY);
    }
  }
  
  public utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche toVresponsableEquipeRecherche() {
    return (utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche)storedValueForKey(_EOIndividuUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY);
  }
  
  public void setToVresponsableEquipeRecherche(utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche value) {
    takeStoredValueForKey(value, _EOIndividuUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY);
  }

  public void setToVresponsableEquipeRechercheRelationship(utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche value) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
      _EOIndividuUlr.LOG.debug("updating toVresponsableEquipeRecherche from " + toVresponsableEquipeRecherche() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToVresponsableEquipeRecherche(value);
    }
    else if (value == null) {
    	utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche oldValue = toVresponsableEquipeRecherche();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _EOIndividuUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _EOIndividuUlr.TO_VRESPONSABLE_EQUIPE_RECHERCHE_KEY);
    }
  }
  
  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toGrpResponsable() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)storedValueForKey(_EOIndividuUlr.TO_GRP_RESPONSABLE_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toGrpResponsable(EOQualifier qualifier) {
    return toGrpResponsable(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toGrpResponsable(EOQualifier qualifier, boolean fetch) {
    return toGrpResponsable(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> toGrpResponsable(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOStructureUlr.TO_RESPONSABLE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
      results = toGrpResponsable();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOStructureUlr>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToGrpResponsable(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    includeObjectIntoPropertyWithKey(object, _EOIndividuUlr.TO_GRP_RESPONSABLE_KEY);
  }

  public void removeFromToGrpResponsable(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    excludeObjectFromPropertyWithKey(object, _EOIndividuUlr.TO_GRP_RESPONSABLE_KEY);
  }

  public void addToToGrpResponsableRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
      _EOIndividuUlr.LOG.debug("adding " + object + " to toGrpResponsable relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToGrpResponsable(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_GRP_RESPONSABLE_KEY);
    }
  }

  public void removeFromToGrpResponsableRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
      _EOIndividuUlr.LOG.debug("removing " + object + " from toGrpResponsable relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToGrpResponsable(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_GRP_RESPONSABLE_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOStructureUlr createToGrpResponsableRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOStructureUlr.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOIndividuUlr.TO_GRP_RESPONSABLE_KEY);
    return (utt.rec.projet.server.metier.grhum.EOStructureUlr) eo;
  }

  public void deleteToGrpResponsableRelationship(utt.rec.projet.server.metier.grhum.EOStructureUlr object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_GRP_RESPONSABLE_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToGrpResponsableRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOStructureUlr> objects = toGrpResponsable().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToGrpResponsableRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> toPersonnel() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr>)storedValueForKey(_EOIndividuUlr.TO_PERSONNEL_KEY);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> toPersonnel(EOQualifier qualifier) {
    return toPersonnel(qualifier, null, false);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> toPersonnel(EOQualifier qualifier, boolean fetch) {
    return toPersonnel(qualifier, null, fetch);
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> toPersonnel(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EOPersonnelUlr.TO_INDIVIDU_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
      results = toPersonnel();
      if (qualifier != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<utt.rec.projet.server.metier.grhum.EOPersonnelUlr>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToPersonnel(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    includeObjectIntoPropertyWithKey(object, _EOIndividuUlr.TO_PERSONNEL_KEY);
  }

  public void removeFromToPersonnel(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    excludeObjectFromPropertyWithKey(object, _EOIndividuUlr.TO_PERSONNEL_KEY);
  }

  public void addToToPersonnelRelationship(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
      _EOIndividuUlr.LOG.debug("adding " + object + " to toPersonnel relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToPersonnel(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_PERSONNEL_KEY);
    }
  }

  public void removeFromToPersonnelRelationship(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
      _EOIndividuUlr.LOG.debug("removing " + object + " from toPersonnel relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToPersonnel(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_PERSONNEL_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EOPersonnelUlr createToPersonnelRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EOPersonnelUlr.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOIndividuUlr.TO_PERSONNEL_KEY);
    return (utt.rec.projet.server.metier.grhum.EOPersonnelUlr) eo;
  }

  public void deleteToPersonnelRelationship(utt.rec.projet.server.metier.grhum.EOPersonnelUlr object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_PERSONNEL_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToPersonnelRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EOPersonnelUlr> objects = toPersonnel().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToPersonnelRelationship(objects.nextElement());
    }
  }

  public NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure> toRepartStructures() {
    return (NSArray<utt.rec.projet.server.metier.grhum.EORepartStructure>)storedValueForKey(_EOIndividuUlr.TO_REPART_STRUCTURES_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(utt.rec.projet.server.metier.grhum.EORepartStructure.TO_INDIVIDU_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _EOIndividuUlr.TO_REPART_STRUCTURES_KEY);
  }

  public void removeFromToRepartStructures(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    excludeObjectFromPropertyWithKey(object, _EOIndividuUlr.TO_REPART_STRUCTURES_KEY);
  }

  public void addToToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
      _EOIndividuUlr.LOG.debug("adding " + object + " to toRepartStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToRepartStructures(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_REPART_STRUCTURES_KEY);
    }
  }

  public void removeFromToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    if (_EOIndividuUlr.LOG.isDebugEnabled()) {
      _EOIndividuUlr.LOG.debug("removing " + object + " from toRepartStructures relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToRepartStructures(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_REPART_STRUCTURES_KEY);
    }
  }

  public utt.rec.projet.server.metier.grhum.EORepartStructure createToRepartStructuresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( utt.rec.projet.server.metier.grhum.EORepartStructure.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _EOIndividuUlr.TO_REPART_STRUCTURES_KEY);
    return (utt.rec.projet.server.metier.grhum.EORepartStructure) eo;
  }

  public void deleteToRepartStructuresRelationship(utt.rec.projet.server.metier.grhum.EORepartStructure object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _EOIndividuUlr.TO_REPART_STRUCTURES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllToRepartStructuresRelationships() {
    Enumeration<utt.rec.projet.server.metier.grhum.EORepartStructure> objects = toRepartStructures().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToRepartStructuresRelationship(objects.nextElement());
    }
  }


  public static EOIndividuUlr createEOIndividuUlr(EOEditingContext editingContext, String cCivilite
, NSTimestamp dCreation
, NSTimestamp dModification
, String listeRouge
, Integer noIndividu
, String nomUsuel
, Integer persId
, String prenom
, String temSsDiplome
, String temValide
, utt.rec.projet.server.metier.grhum.EOPersonne toPersonne, utt.rec.projet.server.metier.grhum.EOVresponsableEquipeRecherche toVresponsableEquipeRecherche) {
    EOIndividuUlr eo = (EOIndividuUlr) EOUtilities.createAndInsertInstance(editingContext, _EOIndividuUlr.ENTITY_NAME);    
		eo.setCCivilite(cCivilite);
		eo.setDCreation(dCreation);
		eo.setDModification(dModification);
		eo.setListeRouge(listeRouge);
		eo.setNoIndividu(noIndividu);
		eo.setNomUsuel(nomUsuel);
		eo.setPersId(persId);
		eo.setPrenom(prenom);
		eo.setTemSsDiplome(temSsDiplome);
		eo.setTemValide(temValide);
    eo.setToPersonneRelationship(toPersonne);
    eo.setToVresponsableEquipeRechercheRelationship(toVresponsableEquipeRecherche);
    return eo;
  }

  public static ERXFetchSpecification<EOIndividuUlr> fetchSpec() {
    return new ERXFetchSpecification<EOIndividuUlr>(_EOIndividuUlr.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<EOIndividuUlr> fetchAllEOIndividuUlrs(EOEditingContext editingContext) {
    return _EOIndividuUlr.fetchAllEOIndividuUlrs(editingContext, null);
  }

  public static NSArray<EOIndividuUlr> fetchAllEOIndividuUlrs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOIndividuUlr.fetchEOIndividuUlrs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOIndividuUlr> fetchEOIndividuUlrs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<EOIndividuUlr> fetchSpec = new ERXFetchSpecification<EOIndividuUlr>(_EOIndividuUlr.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOIndividuUlr> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static EOIndividuUlr fetchEOIndividuUlr(EOEditingContext editingContext, String keyName, Object value) {
    return _EOIndividuUlr.fetchEOIndividuUlr(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOIndividuUlr fetchEOIndividuUlr(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOIndividuUlr> eoObjects = _EOIndividuUlr.fetchEOIndividuUlrs(editingContext, qualifier, null);
    EOIndividuUlr eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOIndividuUlr that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOIndividuUlr fetchRequiredEOIndividuUlr(EOEditingContext editingContext, String keyName, Object value) {
    return _EOIndividuUlr.fetchRequiredEOIndividuUlr(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOIndividuUlr fetchRequiredEOIndividuUlr(EOEditingContext editingContext, EOQualifier qualifier) {
    EOIndividuUlr eoObject = _EOIndividuUlr.fetchEOIndividuUlr(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOIndividuUlr that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOIndividuUlr localInstanceIn(EOEditingContext editingContext, EOIndividuUlr eo) {
    EOIndividuUlr localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> fetchFetchEquipe(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("fetchEquipe", _EOIndividuUlr.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> fetchFetchEquipe(EOEditingContext editingContext,
	NSTimestamp rasDFermetureBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("fetchEquipe", _EOIndividuUlr.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(rasDFermetureBinding, "rasDFermeture");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> fetchPorteurs(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("Porteurs", _EOIndividuUlr.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> fetchPorteurs(EOEditingContext editingContext,
	NSTimestamp rasDFermetureBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("Porteurs", _EOIndividuUlr.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(rasDFermetureBinding, "rasDFermeture");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> fetchUnIndividu(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("unIndividu", _EOIndividuUlr.ENTITY_NAME);
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr> fetchUnIndividu(EOEditingContext editingContext,
	Integer noIndividuBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("unIndividu", _EOIndividuUlr.ENTITY_NAME);
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(noIndividuBinding, "noIndividu");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return (NSArray<utt.rec.projet.server.metier.grhum.EOIndividuUlr>)editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
}
