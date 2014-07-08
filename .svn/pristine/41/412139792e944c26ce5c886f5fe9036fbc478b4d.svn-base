/**
 * 
 */
package utt.rec.projet.server.factory;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;
import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.eoaccess.EOGeneralAdaptorException;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSValidation.ValidationException;

import er.ajax.AjaxUpdateContainer;
import er.extensions.appserver.ERXDisplayGroup;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.FactoryException;
import utt.rec.projet.server.metier.admrec.EOGemateriel;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPfmateriel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOVrhcmval;
import utt.rec.projet.server.metier.grhum.EOIndividuUlr;
import utt.rec.projet.server.metier.grhum.EOPersonne;
import utt.rec.projet.server.metier.grhum.EORepartStructure;
import utt.rec.projet.server.metier.grhum.EOStructureUlr;
import utt.rec.projet.server.process.ProcessGestionNouveauMateriel;
import utt.rec.projet.server.process.ProcessNouveauMateriel;
import utt.rec.projet.server.components.MonComposant;
import utt.rec.projet.server.components.NextProject;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class FactoryTabDataArray extends Factory {

	private CktlAjaxWOComponent component;
	private Session session;
	EOEditingContext ed = null;
	private static final Logger LOG = Logger
			.getLogger(FactoryTabDataArray.class);
	private NSMutableArray persRh = new NSMutableArray();
	private NSMutableArray poleRh = new NSMutableArray();
	private NSMutableArray posta = new NSMutableArray();
	private NSMutableArray mata = new NSMutableArray();
	private NSMutableArray mato = new NSMutableArray();
	public ERXDisplayGroup persDg;
	// public EOGemateriel nouveauEquipement;
	public EOPprec projet;
	boolean success = false;

	public FactoryTabDataArray() {
		// TODO Auto-generated constructor stub
	}

	// Constructeur surchargé afin de pouvoir instacier les données à traiter
	// dans la page 2 de la création ou modification du projet
	public FactoryTabDataArray(CktlAjaxWOComponent comp, Session sess,
			NSMutableArray rh, NSMutableArray poles, NSMutableArray post,
			NSMutableArray mat, NSMutableArray mats) {
		component = comp;
		session = sess;
		ed = component.edc();
		persRh = rh;
		poleRh = poles;
		posta = post;
		mata = mat;
		mato = mats;
		projet = session.getProjectSelected();
	}

	/** Sort on dynamic table **/
	public void setTriPers(String name) {
		NSArray<EOSortOrdering> oldArray = persDg.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		persDg.setSortOrderings(new NSArray<EOSortOrdering>(newOrdering));
		persDg.qualifyDisplayGroup();
	}

	public void setSorOrdPers(String name) {
		NSArray<EOSortOrdering> oldArray = session.personneDg()
				.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		session.personneDg().setSortOrderings(
				new NSArray<EOSortOrdering>(newOrdering));
		session.personneDg().qualifyDisplayGroup();
	}

	public void setSorOrdProfil(String name) {
		NSArray<EOSortOrdering> oldArray = session.postesDg()
				.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		session.postesDg().setSortOrderings(
				new NSArray<EOSortOrdering>(newOrdering));
		session.postesDg().qualifyDisplayGroup();
	}

	public void sorOrdMatPoles(String name) {
		NSArray<EOSortOrdering> oldArray = session.poleMaterielsDg()
				.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		session.poleMaterielsDg().setSortOrderings(
				new NSArray<EOSortOrdering>(newOrdering));
		session.poleMaterielsDg().qualifyDisplayGroup();
	}

	public void sorOrdNewMatPoles(String name) {
		NSArray<EOSortOrdering> oldArray = session.materielsDg()
				.sortOrderings();
		EOSortOrdering oldOrdering = null;
		EOSortOrdering newOrdering = null;
		if (oldArray != null) {
			oldOrdering = oldArray.lastObject();
		}
		if (oldOrdering != null && oldOrdering.key().equals(name)) {
			newOrdering = EOSortOrdering
					.sortOrderingWithKey(
							name,
							oldOrdering.selector() == EOSortOrdering.CompareDescending ? EOSortOrdering.CompareAscending
									: EOSortOrdering.CompareDescending);
		} else {
			newOrdering = EOSortOrdering.sortOrderingWithKey(name,
					EOSortOrdering.CompareAscending);
		}
		session.materielsDg().setSortOrderings(
				new NSArray<EOSortOrdering>(newOrdering));
		session.materielsDg().qualifyDisplayGroup();
	}

	/** End sort dynamic **/

	// Rafraichissement de la liste des Personnes attachées à un pôle
	public WOActionResults refreshPerson() {
		session.setListInPerson(new ERXDisplayGroup<EOVrhcmval>());
		NSMutableArray<EOVrhcmval> tinyIndiv = new NSMutableArray<EOVrhcmval>();
		if (session.getSelectRhPole() != null) {
			tinyIndiv.setArray(EOVrhcmval.fetchLesChercheurs(ed, session
					.getSelectRhPole().primaryKey()));
			session.listInPerson().setObjectArray(tinyIndiv.mutableClone());
		}
		return component.doNothing();
	}

	// Maj du tableau recevant les personnes liées au projet
	public WOActionResults ajoutPerson() {
		try {
			EOPersonnel perso = null;
			if (session.getSelectRhPole() == null)
				throw new ValidationException("Veuillez sélectionner un pôle");
			if (session.personneDg() == null) {
				session.setPersonneDg(new ERXDisplayGroup());
			} else {
				persRh = session.personneDg().allObjects().mutableClone();
			}
			session.setRh(new EOPersonnel());
			if (session.getSelectRhPerson() == null)
				throw new ValidationException(
						"Veuillez sélectionner une personne");
			// Mode update project
			if (projet != null) {
				perso = EOPersonnel.fetchEOPersonnel(
						ed,
						EOPersonnel.TO_PROJET.eq(projet).and(
								EOPersonnel.NO_INDIVIDU
										.eq(session.getSelectRhPerson().noIndividu())
										.and(EOPersonnel.C_STRUCTURE.eq(session
												.getSelectRhPole().cStructure()))
										.and(EOPersonnel.TEMVALIDE.eq("N"))));
			}
			if (perso != null) {
				perso.setTemvalide("O");
				perso.setTempsuitl("5");
				perso.setCoutestime(coutMoyenRh(perso.tempsuitl(), session
						.getSelectRhPerson().rhcmvalVal(), session
						.getDureeProjet()));
				session.personneDg().setObjectArray(personData(perso));
			}
			// Mode new project
			else {
				session.rh().setToVrhcmval(session.getSelectRhPerson());
				EOIndividuUlr inDiv = EOIndividuUlr.individuPourNumero(ed,
						session.getSelectRhPerson().noIndividu());
				session.rh().setNoIndividu(session.getSelectRhPerson().noIndividu());
				session.rh().setNomPersonnel(
						session.getSelectRhPerson().nomUsuel());
				session.rh().setCStructure(session.getSelectRhPole().cStructure());
				session.rh().setNomStructure(
						session.getSelectRhPole().lcStructure());
				session.rh().setTempsuitl("5");
				session.rh().setTemvalide("O");
				session.rh().setCoutestime(
						coutMoyenRh(session.rh().tempsuitl(), session
								.getSelectRhPerson().rhcmvalVal(), session
								.getDureeProjet()));
				session.personneDg().setObjectArray(
						personData(session.rh()));
			}
			if (session.personneDg().batchCount() == 0) {
				session.personneDg().setNumberOfObjectsPerBatch(5);
			}
			session.setSelectRhPole(null);
			session.setSelectRhPerson(null);
		} catch (ValidationException e) {
			LOG.warn(e);
			session.addSimpleErrorMessage("Estimation des ressources humaines",
					e);
		} catch (Exception e) {
			LOG.error(e);
			throw new NSForwardException(e);
		}
		return component.doNothing();
	}

	// Maj du tableau recevant les profils liés au projet
	public WOActionResults ajoutPoste() {
		try {
			EOPosterh posy = null;
			if (session.getSelectRecruePole() == null
					&& session.getCategSelect() == null)
				throw new ValidationException(
						"Veuillez séléctionner un pôle et une catégorie");
			if (session.postesDg() == null) {
				session.setPostesDg(new ERXDisplayGroup());
			} else {
				posta = session.postesDg().allObjects().mutableClone();
			}
			session.setRecrue(new EOPosterh());
			if (session.getNouvoPostes() == null)
				throw new ValidationException("Veuillez renseigner un profil");
			// Mode update project
			if (session.getProjectSelected() != null)
				posy = EOPosterh.fetchEOPosterh(
						ed,
						EOPosterh.TO_PROJET
								.eq(session.getProjectSelected())
								.and(EOPosterh.C_STRUCTURE.eq(session
										.getSelectRecruePole().cStructure()))
								.and(EOPosterh.POSTELIB.eq(session
										.getNouvoPostes()))
								.and(EOPosterh.TEMVALIDE.eq("N")));
			if (posy != null) {
				posy.setTemvalide("O");
				posy.setTxfinancement("5");
				posy.setCoutestime(coutMoyenRecrue(posy.txfinancement(),
						session.getCategSelect().typrhcmVal(),
						posy.dureeRecrue()));
				session.postesDg().setObjectArray(postesData(posy));
			}
			// Mode new project
			else {
				session.recrue().setPostelib(
						session.getNouvoPostes().toUpperCase());
				session.recrue().setCStructure(session.getSelectRecruePole().cStructure());
				session.recrue().setNomStructure(
						session.getSelectRecruePole().lcStructure());
				session.recrue().setTxfinancement("5");
				session.recrue().setDureeRecrue(session.getDureeProjet());
				session.recrue().setToCategorieRh(session.getCategSelect());
				session.recrue().setTemvalide("O");
				session.recrue().setMajauteur(
						session.utilisateur().individu().primaryKey());
				session.recrue().setCoutestime(
						coutMoyenRecrue(session.recrue().txfinancement(),
								session.getCategSelect().typrhcmVal(), session
										.recrue().dureeRecrue()));
				session.postesDg().setObjectArray(
						postesData(session.recrue()));
			}
			if (session.postesDg().batchCount() == 0) {
				session.postesDg().setNumberOfObjectsPerBatch(5);
			}
			session.setSelectRecruePole(null);
			session.setCategSelect(null);
			session.setNouvoPostes(null);
		} catch (ValidationException e) {
			LOG.warn(e);
			session.addSimpleErrorMessage(
					"Estimation des personnes à recruter", e);
		} catch (Exception e) {
			LOG.error(e);
			throw new NSForwardException(e);
		}
		return component.doNothing();
	}

	// MAJ liste des plateaux techniques en fonction du pôle sélectionné
	// (materiel existant)
	@Override
	public WOActionResults refreshPF() {
		// TODO Auto-generated method stub
		if (session.getSelectMatPole() != null)
			session.setListCategMteriels(EOPfmateriel.fetchLePFduPole(ed,
					session.getSelectMatPole().primaryKey()));
		/*
		 * } else {
		 * session.setListCategMteriels(EOPfmateriel.fetchAllEOPfmateriels(ed,
		 * EOPfmateriel.PFMAT_LIB.ascs())); }
		 */
		return component.doNothing();
	}

	// MAJ liste des plateaux techniques en fonction du pôle sélectionné
	// (materiel à acquérir)
	@Override
	public WOActionResults refreshPF0() {
		// TODO Auto-generated method stub
		if (session.getSelectNewMatPole() != null)
			session.setListCategMteriels0(EOPfmateriel.fetchLePFduPole(ed,
					session.getSelectNewMatPole().primaryKey()));
		/*
		 * } else {
		 * session.setListCategMteriels0(EOPfmateriel.fetchAllEOPfmateriels(ed,
		 * EOPfmateriel.PFMAT_LIB.ascs())); }
		 */
		return component.doNothing();
	}

	// MAJ liste des grands équipementss en fonction du plateau technique
	// sélectionné
	@Override
	public WOActionResults refreshGE() {
		// TODO Auto-generated method stub
		if (session.getCategMatSelect() != null)
			session.setListLibMateriels(EOGemateriel.fetchLeGEduPF(ed, session
					.getCategMatSelect().primaryKey()));
		/*
		 * } else {
		 * session.setListLibMateriels(EOGemateriel.fetchEOGemateriels(ed,
		 * EOGemateriel.GEMAT_TEM.eq("AC"), EOGemateriel.GEMAT_LIB.ascs())); }
		 */
		return component.doNothing();
	}

	@Override
	public WOActionResults refreshGE0() {
		// TODO Auto-generated method stub
		if (session.getCategMatSelect0() != null)
			session.setListLibNewMat(EOGemateriel.fetchLeNgeDuPT(ed, session
					.getCategMatSelect0().primaryKey()));
		return component.doNothing();
	}

	// Maj du tableau recevant les matériaux existants liés au projet
	public WOActionResults ajoutMatos() {
		try {
			EOResmat mt = null;
			if (session.getSelectMatPole() == null
					&& session.getCategMatSelect() == null)
				throw new ValidationException(
						"Veuillez sélectionner un pôle et un plateau technique");
			if (session.poleMaterielsDg() == null) {
				session.setPoleMaterielsDg(new ERXDisplayGroup());
			} else {
				mata = session.poleMaterielsDg().allObjects().mutableClone();
			}
			session.setMatos(new EOResmat());
			if (session.getLibMaterielSelect() == null)
				throw new ValidationException(
						"Veuillez sélectionner un grand équipement");
			// Mode update project
			if (projet != null)
				mt = EOResmat.fetchEOResmat(
						ed,
						EOResmat.TO_PROJET
								.eq(projet)
								.and(EOResmat.C_STRUCTURE.eq(session
										.getSelectMatPole().cStructure()))
								.and(EOResmat.TO_GRAND_EQUIPEMENT.eq(session
										.getLibMaterielSelect()))
								.and(EOResmat.TEMVALIDE.eq("N")));
			if (mt != null) {
				mt.setTemvalide("O");
				mt.setToPlateauTech(session.getCategMatSelect());
				mt.setMatutil("5");
				mt.setMatexist("O");
				session.poleMaterielsDg().setObjectArray(materielsData(mt));
			}
			// Mode new project
			else {
				session.matos().setToGrandEquipement(
						session.getLibMaterielSelect());
				session.matos().setCStructure(session.getSelectMatPole().cStructure());
				session.matos().setNomStructure(
						session.getSelectMatPole().lcStructure());
				session.matos()
						.setToPlateauTech(session.getCategMatSelect());
				session.matos().setMajauteur(
						session.utilisateur().individu().primaryKey());
				session.matos().setMatutil("5");
				session.matos().setTxfinancement("N/A");
				session.matos().setCoutestime(new BigDecimal(0));
				session.matos().setMatexist("O");
				session.matos().setTemvalide("O");
				session.poleMaterielsDg().setObjectArray(
						materielsData(session.matos()));
			}
			session.setSelectMatPole(null);
			session.setLibMaterielSelect(null);
			session.setCategMatSelect(null);
			if (session.poleMaterielsDg().batchCount() == 0) {
				session.poleMaterielsDg().setNumberOfObjectsPerBatch(5);
			}
		} catch (ValidationException e) {
			LOG.warn(e);
			session.addSimpleErrorMessage(
					"Estimation des ressources matériels", e);
		} catch (Exception e) {
			LOG.error(e);
			throw new NSForwardException(e);
		}
		return component.doNothing();
	}

	// Enregistrement du nouveau matériel à acquérir avant dospatch dans le
	// tableau dynamique
	public WOActionResults saveNouveauMateriel() {
		try {
			if (session.getSelectNewMatPole() == null
					&& session.getCategMatSelect0() == null)
				throw new ValidationException(
						"Veuillez sélectionner un pôle et un plateau technique");
			if (session.getNouvoMatos() == null)
				throw new ValidationException(
						"Veuillez renseigner l'équipement à acquérir");
			// Mode update
			if (projet != null)
				session.setNouveauEquipement(EOGemateriel.fetchEOGemateriels(
						ed,
						EOGemateriel.GEMAT_LIB
								.eq(session.getNouvoMatos().toUpperCase())
								.and(EOGemateriel.TO_PFMATERIEL.eq(session
										.getCategMatSelect0()))
								.and(EOGemateriel.TO_PFMATERIEL.dot(
										EOPfmateriel.TO_STRUCTURE).eq(
										session.getSelectNewMatPole())), null)
						.lastObject());
			// Mode new materiel
			if (session.getNouveauEquipement() == null) {
				EOGemateriel demo = new EOGemateriel();
				demo.createEOGemateriel(ed);
				demo.setGematLib(session.getNouvoMatos().toUpperCase());
				demo.setToPfmateriel(session.getCategMatSelect0());
				demo.setGematBrute(0);
				ProcessNouveauMateriel.enregistrer(session.dataBus(), ed, demo);
				session.setNouveauEquipement(EOGemateriel.fetchRenvoieLastGE(
						ed, (Integer) demo.getGematIdProc()).lastObject());
			}
			ajouNouvoMatos();
		} catch (ValidationException e) {
			LOG.warn(e);
			session.addSimpleErrorMessage(
					"Estimation des ressources matériels à acquérir", e);
		} catch (FactoryException e) {
			String alertMessage = e.getMessageFormatte();
			((MonComposant) component).logger().info(alertMessage);
			if (e.isBloquant()) {
				if (e.isInformatif()) {
					// Exception contenant un message d'information pour
					// l'utilisateur
					session.setAlertMessage(alertMessage);
					session.addSimpleErrorMessage(null, alertMessage);
					component.context().response().setStatus(500);
					AjaxUpdateContainer.updateContainerWithID(
							((NextProject) component).updateNextContainerId(),
							component.context());
				} else {
					session.setAlertMessage(e.getLocalizedMessage());
					session.addSimpleErrorMessage(null, e.getLocalizedMessage());
					component.context().response().setStatus(500);
					AjaxUpdateContainer.updateContainerWithID(
							((NextProject) component).updateNextContainerId(),
							component.context());
					e.printStackTrace();
					throw e;
				}
			} else {
				session.setAlertMessage(alertMessage);
				session.addSimpleErrorMessage(null, alertMessage);
				component.context().response().setStatus(500);
				AjaxUpdateContainer.updateContainerWithID(
						((NextProject) component).updateNextContainerId(),
						component.context());
			}
			component.context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					((NextProject) component).updateNextContainerId(),
					component.context());
		} catch (EOGeneralAdaptorException e1) {
			((MonComposant) component).logger().warn(e1.getMessage(), e1);
			session.setAlertMessage(e1.getMessage());
			session.addSimpleErrorMessage(null, e1.getMessage());
			component.context().response().setStatus(500);
			AjaxUpdateContainer.updateContainerWithID(
					((NextProject) component).updateNextContainerId(),
					component.context());
		}
		return component.doNothing();
	}

	// Maj du tableau recevant les matériaux à acquerir liés au projet
	public WOActionResults ajouNouvoMatos() {
		try {
			if (session.getSelectNewMatPole() == null
					&& session.getCategMatSelect0() == null)
				throw new ValidationException(
						"Veuillez sélectionner un pôle et un plateau technique");
			if (session.getLibNewMatSelect() == null)
				throw new ValidationException(
						"Veuillez sélectionner un grand équipement");
			EOResmat mt = null;
			EOResmat mt1 = null;
			if (session.materielsDg() == null) {
				session.setMaterielsDg(new ERXDisplayGroup());
			} else {
				mato = session.materielsDg().allObjects().mutableClone();
			}
			session.setNewMatos(new EOResmat());
			// Mode update
			if (projet != null && session.getLibNewMatSelect() != null) {
				mt = EOResmat.fetchEOResmat(
						ed,
						EOResmat.TO_PROJET
								.eq(projet)
								.and(EOResmat.C_STRUCTURE.eq(session
										.getSelectNewMatPole().cStructure()))
								.and(EOResmat.TO_GRAND_EQUIPEMENT.eq(session
										.getLibNewMatSelect()))
								.and(EOResmat.TEMVALIDE.eq("N")));
				mt1 = EOResmat.fetchEOResmat(
						ed,
						EOResmat.TO_PROJET
								.eq(projet)
								.and(EOResmat.C_STRUCTURE.eq(session
										.getSelectNewMatPole().cStructure()))
								.and(EOResmat.TO_GRAND_EQUIPEMENT.eq(session
										.getLibNewMatSelect()))
								.and(EOResmat.TEMVALIDE.eq("O")));
			}
			if (mt1 == null)
				mt1 = new EOResmat();
			if (mt != null) {
				mt.setTemvalide("O");
				mt.setToPlateauTech(session.getCategMatSelect0());
				mt.setTxfinancement("5");
				mt.setMatexist("N");
				session.poleMaterielsDg().setObjectArray(materielsData(mt));
			}
			// Mode new project
			else if (!session.materielsDg().allObjects().contains(mt1)) {
				session.newMatos().setToGrandEquipement(
						session.getLibNewMatSelect());
				session.newMatos().setCStructure(session.getSelectNewMatPole().cStructure());
				session.newMatos().setNomStructure(
						session.getSelectNewMatPole().lcStructure());
				session.newMatos().setToPlateauTech(
						session.getCategMatSelect0());
				session.newMatos().setTxfinancement("5");
				session.newMatos().setMatutil("N/A");
				session.newMatos().setTemvalide("O");
				session.newMatos().setMatexist("N");
				session.newMatos().setMajauteur(
						session.utilisateur().individu().primaryKey());
				BigDecimal txCout = coutNouvoMatos(session.newMatos()
						.txfinancement(), session.newMatos()
						.toGrandEquipement().coutEstime());
				session.newMatos().setCoutestime(txCout);
				session.materielsDg().setObjectArray(
						nouvoMatosData(session.newMatos()));

			}
			/*
			 * // Mode new project if(mt == null && mt1 == null) {
			 * session.newMatos().setGrandEquipement(nouveauEquipement);
			 * session.newMatos().setPole(session.getSelectNewMatPole());
			 * session.newMatos().setNomStructure(
			 * session.getSelectNewMatPole().lcStructure());
			 * session.newMatos().setPlateauTech(
			 * session.getCategMatSelect0());
			 * session.newMatos().setTxfinancement("5");
			 * session.newMatos().setMatutil("N/A");
			 * session.newMatos().setTemvalide("O");
			 * session.newMatos().setMatexist("N");
			 * session.newMatos().setMajauteur(
			 * session.utilisateur().individu().primaryKey());
			 * session.newMatos().setCoutestime(new Double("0"));
			 * session.materielsDg().setObjectArray(
			 * nouvoMatosData(session.newMatos())); }
			 */
			if (session.materielsDg().batchCount() == 0) {
				session.materielsDg().setNumberOfObjectsPerBatch(5);
			}
			session.setSelectNewMatPole(null);
			session.setCategMatSelect0(null);
			session.setNouvoMatos(null);
			session.setLibNewMatSelect(null);
		} catch (ValidationException e) {
			LOG.warn(e);
			session.addSimpleErrorMessage(
					"Estimation des ressources matériels à acquérir", e);
		} catch (Exception e) {
			LOG.error(e);
			session.addSimpleErrorMessage(
					"Estimation des ressources matériels à acquérir", e);
			throw new NSForwardException(e);
		}
		return component.doNothing();
	}

	// ---> AjaxInPlaceEditor Methods and actions <--- //

	// people from one pole **/
	public WOActionResults saveOnImplication() {
		if (!isNumeric(session.getPersonRhRep().tempsuitl())) {
			session.addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			return component.doNothing();
		}
		if (Integer.valueOf(session.getPersonRhRep().tempsuitl()) > 100) {
			session.addSimpleErrorMessage("Valeur trop élevée",
					"Le maximum est 100");
			session.getPersonRhRep().setTempsuitl("5");
			return component.doNothing();
		}
		BigDecimal tmp = coutMoyenRh(session.getPersonRhRep().tempsuitl(),
				session.getPersonRhRep().toVrhcmval().rhcmvalVal(),
				session.getDureeProjet());
		session.getPersonRhRep().setCoutestime(tmp);
		return component.doNothing();
	}

	// Person to recruit **/

	public WOActionResults saveOnTxFinance() {
		if (!isNumeric(session.getPoleRecruRepetition().txfinancement())) {
			session.addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			return component.doNothing();
		}
		if (Integer.valueOf(session.getPoleRecruRepetition().txfinancement()) > 100) {
			session.addSimpleErrorMessage("Valeur trop élevée",
					"Le maximum est 100");
			session.getPoleRecruRepetition().setTxfinancement("5");
			return component.doNothing();
		}
		BigDecimal tmp = coutMoyenRecrue(session.getPoleRecruRepetition()
				.txfinancement(), session.getPoleRecruRepetition()
				.toCategorieRh().typrhcmVal(), session.getPoleRecruRepetition()
				.dureeRecrue());
		session.getPoleRecruRepetition().setCoutestime(tmp);
		return component.doNothing();
	}

	// Duree Projet

	public WOActionResults saveOnDuree() {
		if (!isNumeric(session.getPoleRecruRepetition().dureeRecrue())) {
			session.addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			return component.doNothing();
		}
		BigDecimal tmp = coutMoyenRecrue(session.getPoleRecruRepetition()
				.txfinancement(), session.getPoleRecruRepetition()
				.toCategorieRh().typrhcmVal(), session.getPoleRecruRepetition()
				.dureeRecrue());
		session.getPoleRecruRepetition().setCoutestime(tmp);
		return component.doNothing();
	}

	// Equipments from poles

	public WOActionResults saveOnUtilisation() {
		if (!isNumeric(session.getMaterielRep().matutil())) {
			session.addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			return component.doNothing();
		}
		if (Integer.valueOf(session.getMaterielRep().matutil()) > 100) {
			session.addSimpleErrorMessage("Valeur trop élevée",
					"Le maximum est 100");
			session.getMaterielRep().setMatutil("5");
			return component.doNothing();
		}
		return component.doNothing();
	}

	// Material to get

	public WOActionResults saveOnFinance() {
		if (!isNumeric(session.getPoleNewMatRep().txfinancement())) {
			session.addSimpleErrorMessage("Format incorrect",
					"merci de renseigner un nombre");
			return component.doNothing();
		}
		if (Integer.valueOf(session.getPoleNewMatRep().txfinancement()) > 100) {
			session.addSimpleErrorMessage("Valeur trop élevée",
					"Le maximum est 100");
			session.getPoleNewMatRep().setTxfinancement("5");
			return component.doNothing();
		}

		BigDecimal txCout = coutNouvoMatos(session.getPoleNewMatRep()
				.txfinancement(), session.getPoleNewMatRep()
				.toGrandEquipement().coutEstime());
		session.getPoleNewMatRep().setCoutestime(txCout);
		return component.doNothing();

	}

	/**
	 * @return the component
	 */
	public CktlAjaxWOComponent component() {
		return component;
	}

	/**
	 * @param component
	 *            the component to set
	 */
	public void setComponent(CktlAjaxWOComponent component) {
		this.component = component;
	}

	/**
	 * @return the session
	 */
	public Session session() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * @return the persRh
	 */
	public NSMutableArray getPersRh() {
		return persRh;
	}

	/**
	 * @param persRh
	 *            the persRh to set
	 */
	public void setPersRh(NSMutableArray persRh) {
		this.persRh = persRh;
	}

	/**
	 * @return the poleRh
	 */
	public NSMutableArray getPoleRh() {
		return poleRh;
	}

	/**
	 * @param poleRh
	 *            the poleRh to set
	 */
	public void setPoleRh(NSMutableArray poleRh) {
		this.poleRh = poleRh;
	}

	/**
	 * @return the posta
	 */
	public NSMutableArray getPosta() {
		return posta;
	}

	/**
	 * @param posta
	 *            the posta to set
	 */
	public void setPosta(NSMutableArray posta) {
		this.posta = posta;
	}

	/**
	 * @return the mata
	 */
	public NSMutableArray getMata() {
		return mata;
	}

	/**
	 * @param mata
	 *            the mata to set
	 */
	public void setMata(NSMutableArray mata) {
		this.mata = mata;
	}

	/**
	 * @return the mato
	 */
	public NSMutableArray getMato() {
		return mato;
	}

	/**
	 * @param mato
	 *            the mato to set
	 */
	public void setMato(NSMutableArray mato) {
		this.mato = mato;
	}

	// Builting data for people grid
	@SuppressWarnings("unchecked")
	private NSArray personData(EOPersonnel aPerson) {
		if (!persRh.contains(aPerson)) {
			persRh.addObject(aPerson);
		}
		return persRh.mutableClone();
	}

	private NSArray poleData(EOStructureUlr aPole) {
		if (!poleRh.contains(aPole)) {
			poleRh.add(aPole);
		}
		return poleRh.mutableClone();
	}

	// Construction of the data for the positions grid
	@SuppressWarnings("unchecked")
	private NSMutableArray postesData(EOPosterh aPoste) {
		if (!posta.contains(aPoste)) {
			posta.add(aPoste);
		}
		return posta.mutableClone();
	}

	// Construction of the data for equipments from one pole
	private NSMutableArray materielsData(EOResmat aMateriel) {
		if (!mata.contains(aMateriel)) {
			mata.add(aMateriel);
		}
		return mata.mutableClone();
	}

	// Construction of the data for new hardware to buy
	private NSMutableArray nouvoMatosData(EOResmat aNouvoMatos) {
		if (!mato.contains(aNouvoMatos)) {
			mato.add(aNouvoMatos);
		}
		return mato.mutableClone();
	}

	// Construction of the commentary for the second team
	private NSMutableArray commData() {
		return null;
	}

	public NSMutableArray<Integer> IntegerEquipe() {
		NSMutableArray<Integer> erList = new NSMutableArray<Integer>();
		NSArray tmpList = EORepartStructure.fetchLesER(component.edc());
		for (int i = 0; i < tmpList.count(); i++) {
			Integer persId = ((EORepartStructure) tmpList.objectAtIndex(i))
					.persId();
			erList.addObject(persId);
		}
		return erList;
	}

	protected static boolean isNumeric(String str) {
		try {
			str = str.replace(",", ".");
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	//Coût moyen pour un en-cherch déjà en poste
	protected BigDecimal coutMoyenRh(String pctge, Integer cm, String mois) {
		BigDecimal couMoyen = new BigDecimal(0);
		BigDecimal tx = BigDecimal.valueOf(Double.valueOf(pctge));
		BigDecimal moi = BigDecimal.valueOf(Double.valueOf(mois));
		BigDecimal cmm = BigDecimal.valueOf(cm);
		BigDecimal div = tx.multiply(cmm);
		BigDecimal prod = div.divide(BigDecimal.valueOf(100));
		couMoyen = prod.multiply(moi);
		couMoyen.setScale(2, 2);
		return couMoyen;
	}

	//Coût moyen pour un recrutement
	protected BigDecimal coutMoyenRecrue(String pctge, Integer cm, String mois) {
		BigDecimal couMoyen = new BigDecimal(0);
		BigDecimal tx = BigDecimal.valueOf(Double.valueOf(pctge));
		BigDecimal moi = BigDecimal.valueOf(Double.valueOf(mois));
		BigDecimal div = tx.multiply(BigDecimal.valueOf(cm));
		BigDecimal prod = div.divide(BigDecimal.valueOf(100));
		NSLog.out.appendln(tx + "% du coutMoyen :" + prod);
		BigDecimal tmp = BigDecimal.valueOf(cm).subtract(prod);
		NSLog.out.appendln("Coût estimé sur 1 mois : " + tmp);
		couMoyen = tmp.multiply(moi);
		couMoyen.setScale(2, 2);
		return couMoyen;
	}

	//Coût d'un nouveau matériel
	protected BigDecimal coutNouvoMatos(String pctge, BigDecimal cm) {
		BigDecimal couMoyen = new BigDecimal(0);
		BigDecimal tx = BigDecimal.valueOf(Double.valueOf(pctge));
		BigDecimal div = tx.multiply(cm);
		BigDecimal prod = div.divide(BigDecimal.valueOf(100));
		NSLog.out.appendln(tx + "% du coutMoyen :" + prod);
		couMoyen = cm.subtract(prod);
		couMoyen.setScale(2, 2);
		return couMoyen;
	}

}
