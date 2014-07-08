/**
 * 
 */
package utt.rec.projet.server.factory;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import org.cocktail.fwkcktlajaxwebext.serveur.CktlAjaxWOComponent;
import org.cocktail.fwkcktlpersonneguiajax.serveur.controleurs.GroupeAdminFormCtrl.RepartTypeGroupeDGDelegate;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.exception.ProjetException;
import utt.rec.projet.server.metier.admrec.EOAxerec;
import utt.rec.projet.server.metier.admrec.EOCommentaires;
import utt.rec.projet.server.metier.admrec.EOEquipes;
import utt.rec.projet.server.metier.admrec.EOMotclefs;
import utt.rec.projet.server.metier.admrec.EOPartenaireProjet;
import utt.rec.projet.server.metier.admrec.EOPersonnel;
import utt.rec.projet.server.metier.admrec.EOPosterh;
import utt.rec.projet.server.metier.admrec.EOPprec;
import utt.rec.projet.server.metier.admrec.EORepartaxe;
import utt.rec.projet.server.metier.admrec.EOResmat;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public abstract class Factory {
	
	private boolean withLogs;
	private Session session;
	
	public Factory() {
        super();
        session = new Session();
        this.setWithLogs(false);
    }
	
	public EOEditingContext facEdc(){
		return facSession().editingContext();
	}

    /**
	 * @return the session
	 */
	public Session facSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	public Factory(boolean withLog) {
        super();
        this.setWithLogs(withLog);
    }
    
    public void setWithLogs(boolean b) {
        this.withLogs = b;
    }

    public boolean withLogs() {
        return withLogs;
    }
    
    //Traitement d'informations liéex aux tableaux de données
    //lors de la création et de la modification d'un projet
    public WOActionResults getHasThematique() {
    	return null;
    }
    public WOActionResults onChange(){
    	return null;
    }
    
    public WOActionResults onPart() {
    	return null;
    }
    
    public WOActionResults upDateOtherEqp() {
    	return null;
    }
    
    public WOActionResults refreshPole() {
    	return null;
    }
    
    public WOActionResults upDateAxes() {
    	return null;
    }
    
    public WOActionResults upDateTrans() {
    	return null;
    }
    
    public WOActionResults upDateTheme() {
    	return null;
    }
    
    public WOActionResults upDateSouTheme() {
    	return null;
    }
    
    public WOActionResults upDateStContrat() {
    	return null;
    }
    //END
    
    //Gestion des donnees des tableaux dynamique
    private void setTriPers(String name) {
    	
    }
    
    private void setSorOrdPers(String name) {
    	
    }
    
    private void setSorOrdProfil(String name) {
    	
    }
    
    private void sorOrdMatPoles(String name) {
    	
    }
    
    private void sorOrdNewMatPoles(String name) {
    	
    }
    
    public WOActionResults ajoutPerson() {
    	return null;
    }
    
    public WOActionResults refreshPerson() {
    	return null;
    }
    
    public WOActionResults ajoutPoste() {
    	return null;
    }
    
    public WOActionResults refreshPF(){
    	return null;
    }
    
    public WOActionResults refreshPF0(){
    	return null;
    }
    
    public WOActionResults refreshGE(){
    	return null;
    }
    
    public WOActionResults refreshGE0(){
    	return null;
    }
    
    public WOActionResults ajoutMatos() {
    	return null;
    }
    
    public WOActionResults ajouNouvoMatos() {
    	return null;
    }
    //END
    
    //Traitement autre programme d'acceuil secondaire projet
	public NSMutableArray<EOEquipes> autrePRGAssocie(CktlAjaxWOComponent component){
		return null;
	}
	
	public void traitementAutrePRGAssocie(NSArray equipes, CktlAjaxWOComponent component){
		
	}
	
	//Traitement personnel projet
	public NSMutableArray<EOPersonnel> personnelsEncCours(CktlAjaxWOComponent component, NSMutableArray personnels, EOPersonnel personnel){
		return null;
	}
	
	public void traitementPersonnel(NSArray personnels, CktlAjaxWOComponent component){
		
	}
	
	//Traitement poste projet
	public NSMutableArray<EOPosterh> postesEncCours(CktlAjaxWOComponent component, NSMutableArray postes, EOPosterh poste){
		return null;
	}
	
	public void traitementPoste(NSArray postes, CktlAjaxWOComponent component){
		
	}
	
	//Traitement materiel et nouveau materiel projet
	public NSMutableArray<EOResmat> materielsEncCours(CktlAjaxWOComponent component, NSMutableArray materiels, EOResmat materiel){
		return null;
	}
	
	public NSMutableArray<EOResmat> newResMatEncCours(CktlAjaxWOComponent component, NSMutableArray materiels, EOResmat materiel){
		return null;
	}
		
	public void traitementMateriel(NSArray materiels, CktlAjaxWOComponent component){
			
	}
	
	//Traitement projet
	public EOPprec projetEnCours(EOPprec projet, CktlAjaxWOComponent component) throws ProjetException {
		return null;
	}
	
	//Traitement partenaire
	public NSMutableArray<EOPartenaireProjet> partProj(CktlAjaxWOComponent component){
		return null;
	}
	
	public void traitementPartProjet(CktlAjaxWOComponent component, NSArray partenaires){
		
	}
	
	public void newPartnaire(CktlAjaxWOComponent component, EOTyppartenaire partenaire){
		
	}
	
	//Traitement commentaire Directeur et Responsable
	public EOCommentaires avisCommentairesPP(CktlAjaxWOComponent component, EOPprec projet) {
		return null;
	}
	
	public EOCommentaires avisCommentairesPS(CktlAjaxWOComponent component, EOPprec projet) {
		return null;
	}
	
	public EOCommentaires avisCommentairesDP(CktlAjaxWOComponent component, EOPprec projet) {
		return null;
	}
	
	//Traitement mot clefs
	public void traitementMotClefs(NSArray keywords, CktlAjaxWOComponent component){
		
	}
	
	public NSMutableArray<EOMotclefs> Keywords(CktlAjaxWOComponent component){
		return null;
	}
	
	//Traitement repart pst
	public NSMutableArray<EORepartaxe> pstEncCours(CktlAjaxWOComponent component){
		return null;
	}
	
	public void traitementPst(NSArray pst, CktlAjaxWOComponent component){
		
	}
    
	
	//Utilitaires
    public void trace(final String prefix, final NSArray a) {
        for (int i = 0; i < a.count(); i++) {
            trace(prefix +"  "+i+"-->" , a.objectAtIndex(i));
        }
    }

    public void trace(final Object obj) { 
        trace("", obj);
    }
    
    public void trace(final String prefix, final Object obj) {
        if (withLogs()) {
            if (obj==null) {
                System.out.println(prefix+"null");
            }
            else {
                if (obj instanceof NSArray) {
                    trace (prefix, (NSArray)obj);
                }
                else if (obj instanceof EOEnterpriseObject) {
                    trace (prefix, (EOEnterpriseObject)obj);
                }
                else {
                    System.out.println (prefix + obj.toString());
                }
            }
            
        }
    }    
    
    public void trace(final String prefix, final EOEnterpriseObject object) {
        if (object!=null) {
            final Iterator iter = object.attributeKeys().vector().iterator();
            while (iter.hasNext()) {
                String obj = (String) iter.next();
                trace(prefix+"  "+ obj  +"-->", object.valueForKey(obj) );
            }

            Iterator iter2 = object.toOneRelationshipKeys().vector().iterator();
            while (iter2.hasNext()) {
                String obj = (String) iter2.next();
                trace(prefix+"  "+ obj  +"-->" + object.valueForKey(obj) );
            }
            Iterator iter3 = object.toManyRelationshipKeys().vector().iterator();
            while (iter3.hasNext()) {
                String obj = (String) iter3.next();
                if (prefix != null && prefix.length()>250) {
                    trace(prefix+"  "+ obj  +"-->" + object.valueForKey(obj) );
                }
                else {
                    trace(prefix+"  "+ obj  +"-->" , object.valueForKey(obj) );
                }
            }
        }
    }
    
    public BigDecimal computeSumForKeyBigDecimal(NSArray eo, String keyBigDecimal) {
		if (eo==null || eo.count()==0)
			return new BigDecimal(0.0);
    	return (BigDecimal)eo.valueForKeyPath("@sum."+keyBigDecimal);
    }

    public static boolean inferieur(BigDecimal a, BigDecimal b) {
        boolean reponse = false;

        int resultat = a.compareTo(b);

        if (resultat == -1)
            reponse = true;

        if (resultat == 0)
            reponse = false;

        if (resultat == 1)
            reponse = false;

        return reponse;
    }

    public static boolean inferieurOuEgal(BigDecimal a, BigDecimal b) {
        boolean reponse = false;

        int resultat = a.compareTo(b);

        if (resultat == -1)
            reponse = true;

        if (resultat == 0)
            reponse = true;

        if (resultat == 1)
            reponse = false;

        return reponse;
    }

    public static boolean superieur(BigDecimal a, BigDecimal b) {
        boolean reponse = false;

        int resultat = a.compareTo(b);

        if (resultat == -1)
            reponse = false;

        if (resultat == 0)
            reponse = false;

        if (resultat == 1)
            reponse = true;

        return reponse;
    }

    public static boolean superieurOuEgal(BigDecimal a, BigDecimal b) {
        boolean reponse = false;

        int resultat = a.compareTo(b);

        if (resultat == -1)
            reponse = false;

        if (resultat == 0)
            reponse = true;

        if (resultat == 1)
            reponse = true;

        return reponse;
    }

    public static boolean egal(BigDecimal a, BigDecimal b) {
        boolean reponse = false;

        int resultat = a.compareTo(b);

        if (resultat == -1)
            reponse = false;

        if (resultat == 0)
            reponse = true;

        if (resultat == 1)
            reponse = false;

        return reponse;
    }

    public static boolean different(BigDecimal a, BigDecimal b) {
        boolean reponse = false;

        int resultat = a.compareTo(b);

        if (resultat == -1)
            reponse = true;

        if (resultat == 0)
            reponse = false;

        if (resultat == 1)
            reponse = true;

        return reponse;
    }

    /**
     * @return Un gregorianCalendar initialise la date du jour (sans les
     *         heures/minutes/etc). Utilisez getToday().getTime() pour recuperer
     *         la date du jour nettoyee des secondes sous forme de Date.
     */
    private final GregorianCalendar getToday() {
        final GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
        return gc;
    }

    /**
     * @return
     */
    public final NSTimestamp getDateJour() {
        return new NSTimestamp();
    }


    public static final BigDecimal calcSommeOfBigDecimals(final NSArray array, final String keyName) {
        return calcSommeOfBigDecimals(array.vector(), keyName);
    }

    public static final BigDecimal calcSommeOfBigDecimals(final Vector array, final String keyName) {
        BigDecimal res = new BigDecimal(0.0).setScale(2);
        Iterator iter = array.iterator();
        while (iter.hasNext()) {
            EOEnterpriseObject element = (EOEnterpriseObject) iter.next();
            res = res.add((BigDecimal) element.valueForKey(keyName));
        }
        return res;
    }

}
