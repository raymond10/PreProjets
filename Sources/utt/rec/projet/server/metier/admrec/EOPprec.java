package utt.rec.projet.server.metier.admrec;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktlwebapp.common.util.StringCtrl;

import utt.rec.projet.server.exception.ProjetException;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.utils.Editions;
import utt.rec.projet.server.utils.IdProjetCoissantComparator;
import utt.rec.projet.server.utils.MajDateProjetDecroissantComparator;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOOrQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator.ComparisonException;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSSet;

import er.extensions.eof.ERXKey;
import er.extensions.eof.ERXQ;

@SuppressWarnings("all")
public class EOPprec extends _EOPprec {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6244483276417891470L;
	private static Logger log = Logger.getLogger(EOPprec.class);

	// Atributes non visibles
	public static final ERXKey<Integer> PROJET_ID = new ERXKey<Integer>(
			"projetId");
	public static final String PROJET_ID_KEY = PROJET_ID.key();
	
	
	private Number projIdProc;

	public EOPprec() {
		// TODO Auto-generated constructor stub
		super();
		projIdProc = null;
	}

	// ORDER BY sur le NOM
	public static final EOSortOrdering SORT_NOMPROJET_ASC = EOSortOrdering
			.sortOrderingWithKey(PROJNOMCOURT_KEY,
					EOSortOrdering.CompareAscending);
	public static final EOSortOrdering SORT_NOMLONGPROJET_ASC = EOSortOrdering
			.sortOrderingWithKey(PROJNOMLONG_KEY,
					EOSortOrdering.CompareAscending);
	
	public static final NSArray<EOSortOrdering> byNomLonCourt() {
		return new NSArray(new Object[] {SORT_NOMPROJET_ASC});
	}
	
	// ORDER BY sur le MAJDATE
	public static final EOSortOrdering SORT_DATEMAJ_DESC = EOSortOrdering
			.sortOrderingWithKey(MAJDATE_KEY, EOSortOrdering.CompareDescending);
	// ORDER BY sur le PROJET_ID
	public static final EOSortOrdering SORT_PROJETIDJ_ASC = EOSortOrdering
			.sortOrderingWithKey(PROJET_ID_KEY, EOSortOrdering.CompareAscending);

	public static EOPprec createEOPprec(EOEditingContext editingContext) {
		EOPprec eo = (EOPprec) EOUtilities.createAndInsertInstance(
				editingContext, _EOPprec.ENTITY_NAME);
		return eo;
	}

	public boolean isProjetValide() {
		return "O".equals(projvalide());
	}

	/**
	 * @return the projIdProc
	 */
	public Number getProjIdProc() {
		return projIdProc;
	}

	/**
	 * @param projIdProc
	 *            the projIdProc to set
	 */
	public void setProjIdProc(Number projIdProc) {
		this.projIdProc = projIdProc;
	}

	/*
	 * public void validateForInsert() throws ValidationException {
	 * if(!etat().typrefnat().equals("RE")) validateObjectMetier();
	 * validateBeforeTransactionSave(); //super.validateForInsert(); }
	 * 
	 * public void validateForUpdate() throws ValidationException {
	 * if(!etat().typrefnat().equals("RE")) validateObjectMetier();
	 * validateBeforeTransactionSave(); //super.validateForUpdate(); }
	 * 
	 * public void validateForDelete() throws ValidationException {
	 * super.validateForDelete(); }
	 * 
	 * public void validateForSave() throws ValidationException {
	 * if(!etat().typrefnat().equals("RE")) validateObjectMetier();
	 * validateBeforeTransactionSave(); //super.validateForSave(); }
	 */

	public void validateObjectMetier() throws ProjetException {
		if (projctx() == null
				|| projctx().equals("<p><br data-mce-bogus=\"1\"></p>")) {
			throw new ProjetException("il faut rédiger le contexte du projet");
		} else if (projpblm() == null) {
			throw new ProjetException(
					"il faut rédiger la problematique du projet");
		} else if (projobf() == null) {
			throw new ProjetException("il faut rédiger l'objectif du projet");
		} else if (projmtdg() == null) {
			throw new ProjetException(
					"il faut rédiger la methodologie du projet");
		}
		if (projthetv() == null)
			throw new ProjetException(
					"il faut sélectionner la thématique transversale du projet");
	}

	private final void validateBeforeTransactionSave()
			throws ValidationException {
		if (porteur() == null)
			throw new ProjetException("il faut associer un porteur");
		if (equipePrincipale() == null)
			throw new ProjetException(
					"il faut associer un programme d'accueil principal");
		if (toContrat() == null)
			throw new ProjetException(
					"il faut associer un type de contrat du projet");
		// if(partenaireProjets() == null || partenaireProjets().count() == 0)
		// throw new
		// ProjetException("il faut indiquer le(s) partenaire(s) du projet");
		if (toAxe() == null)
			throw new ProjetException("il faut associer un axe ou un pst");
	}

	public static EOPprec projetPourNumero(EOEditingContext editingContext,
			Integer projetId) {
		if (projetId == null)
			return null;
		return fetchEOPprec(editingContext, "projetId", projetId);
	}

	public String projnomcourt() {
		return (String) Editions
				.cleanKoma(storedValueForKey(_EOPprec.PROJNOMCOURT_KEY));
	}

	public void setProjnomcourt(String value) {
		takeStoredValueForKey(Editions.cleanKoma(value),
				_EOPprec.PROJNOMCOURT_KEY);
	}

	public String projnomlong() {
		return (String) Editions
				.cleanKoma(storedValueForKey(_EOPprec.PROJNOMLONG_KEY));
	}

	public void setProjnomlong(String value) {
		takeStoredValueForKey(Editions.cleanKoma(value),
				_EOPprec.PROJNOMLONG_KEY);
	}

	public String projctx() {
		String ctx = (String) storedValueForKey(_EOPprec.PROJCTX_KEY);
		return Editions.cleanKoma(ctx);
	}

	public void setProjctx(String value) {
		takeStoredValueForKey(Editions.cleanKoma(value), _EOPprec.PROJCTX_KEY);
	}

	public String projpblm() {
		return (String) Editions
				.cleanKoma(storedValueForKey(_EOPprec.PROJPBLM_KEY));
	}

	public void setProjpblm(String value) {
		takeStoredValueForKey(Editions.cleanKoma(value), _EOPprec.PROJPBLM_KEY);
	}

	public String projobf() {
		return (String) Editions
				.cleanKoma(storedValueForKey(_EOPprec.PROJOBF_KEY));
	}

	public void setProjobf(String value) {
		takeStoredValueForKey(Editions.cleanKoma(value), _EOPprec.PROJOBF_KEY);
	}

	public String projmtdg() {
		return (String) Editions
				.cleanKoma(storedValueForKey(_EOPprec.PROJMTDG_KEY));
	}

	public void setProjmtdg(String value) {
		takeStoredValueForKey(Editions.cleanKoma(value), _EOPprec.PROJMTDG_KEY);
	}

	// SELECT sur la vue parcours des etudiants
	private static NSArray<String> preFetch() {
		NSMutableArray preFetching = new NSMutableArray();
		preFetching.addObject("toAlertes");
		preFetching.addObject("toAxe");
		preFetching.addObject("toCommentaires");
		preFetching.addObject("toContrat");
		preFetching.addObject("toEquipeSecondaires");
		preFetching.addObject("toEtat");
		preFetching.addObject("toHistoriques");
		preFetching.addObject("toMateriels");
		preFetching.addObject("toMotCles");
		preFetching.addObject("toPersonnelExistants");
		preFetching.addObject("toPosteRhs");
		preFetching.addObject("toPrincipal");
		preFetching.addObject("toProjetPartenaires");
		preFetching.addObject("toProjetRepartaxes");
		preFetching.addObject("toSousThemes");
		preFetching.addObject("toThematique");
		preFetching.addObject("toTheme");
		return preFetching.immutableClone();
		/*
		 * 
		 * bindings.takeValueForKey(porteurBinding, "porteur");
		 * bindings.takeValueForKey(projetIdBinding, "projetId");
		 * bindings.takeValueForKey(typcontIdBinding, "typcontId");
		 * bindings.takeValueForKey(typrefdomBinding, "typrefdom");
		 * bindings.takeValueForKey(typrefnatBinding, "typrefnat");
		 */
	}

	private static EOQualifier qualPerId_CreAuteur(Integer persId) {
		return CRE_AUTEUR.eq(persId);
	}

	private static EOQualifier qualNoIndiv_Porteur(Integer noIndividu) {
		return PORTEUR.eq(noIndividu);
	}

	private static EOQualifier qualProjId() {
		return PROJET_ID.isNotNull();
	}

	private static EOQualifier qualTemValide() {
		return PROJVALIDE.eq("O");
		//.and(ETAT.dot(EOTypref.TYPREFNAT).isNot("PE").and(ETAT.dot(EOTypref.TYPREFNAT).isNot("PL")));
	}

	private static EOQualifier qualNoIndiv_Implique(Integer noIndividu) {
		return TO_PERSONNEL_EXISTANTS.dot(EOPersonnel.NO_INDIVIDU).eq(noIndividu);
	}

	private static EOQualifier qualEquipePrincipale(String equipePrincipale) {
		return EQUIPE_PRINCIPALE.eq(equipePrincipale);
	}

	private static EOQualifier qualPorteur(Integer porteur) {
		return PORTEUR.eq(porteur);
	}

	private static EOQualifier qualProjetId(Integer projetId) {
		return PROJET_ID.eq(projetId);
	}

	private static EOQualifier qualTypcontId(Integer typcontId) {
		return TO_CONTRAT.dot(EOTypcontrat.TYPCONT_ID).eq(typcontId);
	}

	private static EOQualifier qualTyprefdom(String typrefdom) {
		return TO_ETAT.dot(EOTypref.TYPREFDOM).eq(typrefdom);
	}

	private static EOQualifier qualTyprefnat(String typrefnat) {
		return TO_ETAT.dot(EOTypref.TYPREFNAT).eq(typrefnat);
	}

	private static EOQualifier qualPersImp() {
		return TO_PERSONNEL_EXISTANTS.dot(EOPersonnel.PROJET_ID).isNot(PROJET_ID);
	}
	
	private static EOQualifier qualDirecteur(Integer noIndividu) {
		return TO_STRUCTURE.dot(EOStructure.C_STRUCTURE).eq(POLE_COMPETENCE).and(TO_STRUCTURE.dot(EOStructure.GRP_RESPONSABLE).eq(noIndividu));
	}
	
	private static EOQualifier qualResponsable(Integer noIndividu) {
		return TO_PRINCIPAL.dot(EOStructure.C_STRUCTURE).eq(EQUIPE_PRINCIPALE).and(TO_PRINCIPAL.dot(EOStructure.GRP_RESPONSABLE).eq(noIndividu));
	}

	public static NSArray filtreProjetEC(EOEditingContext myContext,
			NSDictionary filtres) throws ComparisonException {
		Integer dir_Resp = (Integer) filtres
				.valueForKey("dir_Resp");
		String equipePrincipale = (String) filtres
				.valueForKey("equipePrincipale");
		Integer noIndiv_Implique = (Integer) filtres
				.valueForKey("noIndiv_Implique");
		Integer noIndiv_Porteur = (Integer) filtres
				.valueForKey("noIndiv_Porteur");
		Integer perId_CreAuteur = (Integer) filtres
				.valueForKey("perId_CreAuteur");
		Integer porteur = (Integer) filtres.valueForKey("porteur");
		Integer projetId = (Integer) filtres.valueForKey("projetId");
		Integer typcontId = (Integer) filtres.valueForKey("typcontId");
		String typrefdom = (String) filtres.valueForKey("typrefdom");
		String typrefnat = (String) filtres.valueForKey("typrefnat");
		NSMutableArray qualGlobal = new NSMutableArray();
		NSMutableArray qualAnd = new NSMutableArray();
		NSMutableArray qualOR = new NSMutableArray();
		NSMutableArray qualUnd = new NSMutableArray();
		NSMutableArray qualWith = new NSMutableArray();
		NSMutableArray qualDir = new NSMutableArray();
		NSMutableArray qualResp = new NSMutableArray();
		// Qualifier fix
		if(noIndiv_Implique != null && isNumeric(noIndiv_Implique.toString()))
			qualOR.addObject(qualNoIndiv_Implique(noIndiv_Implique));
		if(noIndiv_Porteur != null && isNumeric(noIndiv_Porteur.toString()))
			qualOR.addObject(qualNoIndiv_Porteur(noIndiv_Porteur));
		if(perId_CreAuteur != null && isNumeric(perId_CreAuteur.toString()))
			qualOR.addObject(qualPerId_CreAuteur(perId_CreAuteur));
		
		//Qualifier Directeur
		qualDir.addObject(qualDirecteur(dir_Resp));
		qualDir.addObject(qualTemValide());
		qualDir.addObject(qualProjId());
		
		//Qualifier Responsable
		qualResp.addObject(qualResponsable(dir_Resp));
		qualResp.addObject(qualTemValide());
		qualResp.addObject(qualProjId());
		
		/*Qualifier createur et personne implique*/
		if(perId_CreAuteur != null && isNumeric(perId_CreAuteur.toString()))
			qualUnd.addObject(qualPerId_CreAuteur(perId_CreAuteur));
		qualUnd.addObject(qualPersImp());
		EOQualifier nUnd = new EOAndQualifier(qualUnd);
		
		/*Qualifier createur*/
		if(perId_CreAuteur != null && isNumeric(perId_CreAuteur.toString()))
			qualWith.addObject(qualPerId_CreAuteur(perId_CreAuteur));
		qualWith.addObject(qualProjId());
		qualWith.addObject(qualTemValide());
		
		// Qualifier variables
		EOQualifier nor = new EOOrQualifier(qualOR);
		qualAnd.addObject(nor);
		qualAnd.addObject(qualTemValide());
		
		if (equipePrincipale != null && !StringCtrl.isEmpty(equipePrincipale)) {
			qualAnd.addObject(qualEquipePrincipale(equipePrincipale));
			qualWith.addObject(qualEquipePrincipale(equipePrincipale));
			qualDir.addObject(qualEquipePrincipale(equipePrincipale));
			qualResp.addObject(qualEquipePrincipale(equipePrincipale));
		}

		if (porteur != null && !isNumeric(porteur.toString())) {
			qualAnd.addObject(qualPorteur(porteur));
			qualWith.addObject(qualPorteur(porteur));
			qualDir.addObject(qualPorteur(porteur));
			qualResp.addObject(qualPorteur(porteur));
		}

		if (projetId != null && !isNumeric(projetId.toString())) {
			qualAnd.addObject(qualProjetId(projetId));
			qualWith.addObject(qualProjetId(projetId));
			qualDir.addObject(qualProjetId(projetId));
			qualResp.addObject(qualProjetId(projetId));
		}

		if (typcontId != null && !isNumeric(typcontId.toString())) {
			qualAnd.addObject(qualTypcontId(typcontId));
			qualWith.addObject(qualTypcontId(typcontId));
			qualDir.addObject(qualTypcontId(typcontId));
			qualResp.addObject(qualTypcontId(typcontId));
		}

		if (typrefdom != null && !StringCtrl.isEmpty(typrefdom)) {
			qualAnd.addObject(qualTyprefdom(typrefdom));
			qualWith.addObject(qualTyprefdom(typrefdom));
			qualDir.addObject(qualTyprefdom(typrefdom));
			qualResp.addObject(qualTyprefdom(typrefdom));
		}

		if (typrefnat != null && !StringCtrl.isEmpty(typrefnat)) {
			qualAnd.addObject(qualTyprefnat(typrefnat));
			qualWith.addObject(qualTyprefnat(typrefnat));
			qualDir.addObject(qualTyprefnat(typrefnat));
			qualResp.addObject(qualTyprefnat(typrefnat));
		}
		EOQualifier qual = new EOAndQualifier(qualAnd);
		qualGlobal.addObject(qual);
		qualGlobal.addObject(nUnd);
		EOQualifier globNor = new EOOrQualifier(qualGlobal);
		//Fetch des projets avec personnels impliqués
		EOFetchSpecification fSpec1 = new EOFetchSpecification(
				EOPprec.ENTITY_NAME, globNor, new NSArray(
						new Object[] {SORT_DATEMAJ_DESC}));
		fSpec1.setPrefetchingRelationshipKeyPaths(preFetch());
		fSpec1.setUsesDistinct(true);
		NSMutableArray projets = new NSMutableArray();
		NSArray tempFs1 = myContext.objectsWithFetchSpecification(fSpec1);
		NSSet set1 = new NSSet(tempFs1);
		//Fetch des projets du createur en redaction
		EOQualifier qualWit = new EOAndQualifier(qualWith);
		EOFetchSpecification fSpec2 = new EOFetchSpecification(
				EOPprec.ENTITY_NAME, qualWit, new NSArray(
						new Object[] {SORT_DATEMAJ_DESC}));
		fSpec2.setPrefetchingRelationshipKeyPaths(preFetch());
		fSpec2.setUsesDistinct(true);
		NSArray tempFs2 = myContext.objectsWithFetchSpecification(fSpec2);
		NSSet set2 = new NSSet(tempFs2);
		//Creation du UNION
		set1 = set1.setByUnioningSet(set2);
		//Fetch directeur de pole
		EOQualifier andDir = new EOAndQualifier(qualDir);
		EOFetchSpecification fSpec3 = new EOFetchSpecification(
				EOPprec.ENTITY_NAME, andDir, new NSArray(
						new Object[] {SORT_DATEMAJ_DESC}));
		fSpec3.setPrefetchingRelationshipKeyPaths(preFetch());
		fSpec3.setUsesDistinct(true);
		NSArray tempFs3 = myContext.objectsWithFetchSpecification(fSpec3);
		NSSet set3 = new NSSet(tempFs3);
		//Creation du UNION
		set1 = set1.setByUnioningSet(set3);
		//Fetch responsable d'equipe principale
		EOQualifier andResp = new EOAndQualifier(qualResp);
		EOFetchSpecification fSpec4 = new EOFetchSpecification(
				EOPprec.ENTITY_NAME, andResp, new NSArray(
						new Object[] {SORT_DATEMAJ_DESC}));
		fSpec4.setPrefetchingRelationshipKeyPaths(preFetch());
		fSpec4.setUsesDistinct(true);
		NSArray tempFs4 = myContext.objectsWithFetchSpecification(fSpec4);
		NSSet set4 = new NSSet(tempFs4);
		//Creation du UNION
		set1 = set1.setByUnioningSet(set4);
		
		//Resultat
		projets = set1.allObjects().mutableClone();
		projets.sortUsingComparator(new MajDateProjetDecroissantComparator());
		NSArray result = projets.immutableClone();
		return result;
	}
	
	public static NSArray filtreEditionProjetEC(EOEditingContext myContext,
			NSDictionary filtres) throws ComparisonException {
		String equipePrincipale = (String) filtres
				.valueForKey("equipePrincipale");
		Integer noIndiv_Implique = (Integer) filtres
				.valueForKey("noIndiv_Implique");
		Integer noIndiv_Porteur = (Integer) filtres
				.valueForKey("noIndiv_Porteur");
		Integer perId_CreAuteur = (Integer) filtres
				.valueForKey("perId_CreAuteur");
		Integer porteur = (Integer) filtres.valueForKey("porteur");
		Integer projetId = (Integer) filtres.valueForKey("projetId");
		Integer typcontId = (Integer) filtres.valueForKey("typcontId");
		String typrefdom = (String) filtres.valueForKey("typrefdom");
		String typrefnat = (String) filtres.valueForKey("typrefnat");
		NSMutableArray qualGlobal = new NSMutableArray();
		NSMutableArray qualAnd = new NSMutableArray();
		NSMutableArray qualOR = new NSMutableArray();
		NSMutableArray qualUnd = new NSMutableArray();
		NSMutableArray qualWith = new NSMutableArray();
		NSMutableArray qualDir = new NSMutableArray();
		NSMutableArray qualResp = new NSMutableArray();
		// Qualifier fix
		if(noIndiv_Implique != null && isNumeric(noIndiv_Implique.toString()))
			qualOR.addObject(qualNoIndiv_Implique(noIndiv_Implique));
		if(noIndiv_Porteur != null && isNumeric(noIndiv_Porteur.toString()))
			qualOR.addObject(qualNoIndiv_Porteur(noIndiv_Porteur));
		if(perId_CreAuteur != null && isNumeric(perId_CreAuteur.toString()))
			qualOR.addObject(qualPerId_CreAuteur(perId_CreAuteur));
		
		//Qualifier Directeur
		if(noIndiv_Porteur != null && isNumeric(noIndiv_Porteur.toString()))
			qualDir.addObject(qualDirecteur(noIndiv_Porteur));
		qualDir.addObject(qualTemValide());
		qualDir.addObject(qualProjId());
		
		//Qualifier Responsable
		if(noIndiv_Porteur != null && isNumeric(noIndiv_Porteur.toString()))
			qualResp.addObject(qualResponsable(noIndiv_Porteur));
		qualResp.addObject(qualTemValide());
		qualResp.addObject(qualProjId());
		
		/*Qualifier createur et personne implique*/
		if(perId_CreAuteur != null && isNumeric(perId_CreAuteur.toString()))
			qualUnd.addObject(qualPerId_CreAuteur(perId_CreAuteur));
		qualUnd.addObject(qualPersImp());
		EOQualifier nUnd = new EOAndQualifier(qualUnd);
		
		/*Qualifier createur*/
		if(perId_CreAuteur != null && isNumeric(perId_CreAuteur.toString()))
			qualWith.addObject(qualPerId_CreAuteur(perId_CreAuteur));
		qualWith.addObject(qualProjId());
		qualWith.addObject(qualTemValide());
		
		// Qualifier variables
		EOQualifier nor = new EOOrQualifier(qualOR);
		qualAnd.addObject(nor);
		qualAnd.addObject(qualTemValide());
		
		if (equipePrincipale != null && !StringCtrl.isEmpty(equipePrincipale)) {
			qualAnd.addObject(qualEquipePrincipale(equipePrincipale));
			qualWith.addObject(qualEquipePrincipale(equipePrincipale));
			qualDir.addObject(qualEquipePrincipale(equipePrincipale));
			qualResp.addObject(qualEquipePrincipale(equipePrincipale));
		}

		if (porteur != null && !isNumeric(porteur.toString())) {
			qualAnd.addObject(qualPorteur(porteur));
			qualWith.addObject(qualPorteur(porteur));
			qualDir.addObject(qualPorteur(porteur));
			qualResp.addObject(qualPorteur(porteur));
		}

		if (projetId != null && !isNumeric(projetId.toString())) {
			qualAnd.addObject(qualProjetId(projetId));
			qualWith.addObject(qualProjetId(projetId));
			qualDir.addObject(qualProjetId(projetId));
			qualResp.addObject(qualProjetId(projetId));
		}

		if (typcontId != null && !isNumeric(typcontId.toString())) {
			qualAnd.addObject(qualTypcontId(typcontId));
			qualWith.addObject(qualTypcontId(typcontId));
			qualDir.addObject(qualTypcontId(typcontId));
			qualResp.addObject(qualTypcontId(typcontId));
		}

		if (typrefdom != null && !StringCtrl.isEmpty(typrefdom)) {
			qualAnd.addObject(qualTyprefdom(typrefdom));
			qualWith.addObject(qualTyprefdom(typrefdom));
			qualDir.addObject(qualTyprefdom(typrefdom));
			qualResp.addObject(qualTyprefdom(typrefdom));
		}

		if (typrefnat != null && !StringCtrl.isEmpty(typrefnat)) {
			qualAnd.addObject(qualTyprefnat(typrefnat));
			qualWith.addObject(qualTyprefnat(typrefnat));
			qualDir.addObject(qualTyprefnat(typrefnat));
			qualResp.addObject(qualTyprefnat(typrefnat));
		}
		EOQualifier qual = new EOAndQualifier(qualAnd);
		qualGlobal.addObject(qual);
		qualGlobal.addObject(nUnd);
		EOQualifier globNor = new EOOrQualifier(qualGlobal);
		//Fetch des projets avec personnels impliqués
		EOFetchSpecification fSpec1 = new EOFetchSpecification(
				EOPprec.ENTITY_NAME, globNor, new NSArray(
						new Object[] {SORT_PROJETIDJ_ASC}));
		fSpec1.setPrefetchingRelationshipKeyPaths(preFetch());
		fSpec1.setUsesDistinct(true);
		NSMutableArray projets = new NSMutableArray();
		NSArray tempFs1 = myContext.objectsWithFetchSpecification(fSpec1);
		NSSet set1 = new NSSet(tempFs1);
		//Fetch des projets du createur en redaction
		EOQualifier qualWit = new EOAndQualifier(qualWith);
		EOFetchSpecification fSpec2 = new EOFetchSpecification(
				EOPprec.ENTITY_NAME, qualWit, new NSArray(
						new Object[] {SORT_PROJETIDJ_ASC}));
		fSpec2.setPrefetchingRelationshipKeyPaths(preFetch());
		fSpec2.setUsesDistinct(true);
		NSArray tempFs2 = myContext.objectsWithFetchSpecification(fSpec2);
		NSSet set2 = new NSSet(tempFs2);
		//Creation du UNION
		set1 = set1.setByUnioningSet(set2);
		//Fetch directeur de pole
		EOQualifier andDir = new EOAndQualifier(qualDir);
		EOFetchSpecification fSpec3 = new EOFetchSpecification(
				EOPprec.ENTITY_NAME, andDir, new NSArray(
						new Object[] {SORT_PROJETIDJ_ASC}));
		fSpec3.setPrefetchingRelationshipKeyPaths(preFetch());
		fSpec3.setUsesDistinct(true);
		NSArray tempFs3 = myContext.objectsWithFetchSpecification(fSpec3);
		NSSet set3 = new NSSet(tempFs3);
		//Creation du UNION
		set1 = set1.setByUnioningSet(set3);
		//Fetch responsable d'equipe principale
		EOQualifier andResp = new EOAndQualifier(qualResp);
		EOFetchSpecification fSpec4 = new EOFetchSpecification(
				EOPprec.ENTITY_NAME, andResp, new NSArray(
						new Object[] {SORT_PROJETIDJ_ASC}));
		fSpec4.setPrefetchingRelationshipKeyPaths(preFetch());
		fSpec4.setUsesDistinct(true);
		NSArray tempFs4 = myContext.objectsWithFetchSpecification(fSpec4);
		NSSet set4 = new NSSet(tempFs4);
		//Creation du UNION
		set1 = set1.setByUnioningSet(set4);
		
		//Resultat
		projets = set1.allObjects().mutableClone();
		projets.sortUsingComparator(new IdProjetCoissantComparator());
		NSArray result = projets.immutableClone();
		return result;
	}

	protected static boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
