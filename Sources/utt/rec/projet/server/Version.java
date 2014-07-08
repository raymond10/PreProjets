/**
 * 
 */
package utt.rec.projet.server;

import org.cocktail.fwkcktlwebapp.common.util.DateCtrl;
import org.cocktail.fwkcktlwebapp.server.version.A_CktlVersion;
import org.cocktail.fwkcktlwebapp.server.version.CktlVersionJava;
import org.cocktail.fwkcktlwebapp.server.version.CktlVersionOracleServer;
import org.cocktail.fwkcktlwebapp.server.version.CktlVersionWebObjects;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class Version extends A_CktlVersion {

	// Nom de l'appli
    public static final String APPLICATIONFINALNAME = VersionMe.APPLICATIONFINALNAME;
    public static final String APPLICATIONINTERNALNAME=VersionMe.APPLICATIONINTERNALNAME;
    public static final String APPLICATION_STRID = VersionMe.APPLICATION_STRID;

    // Version appli
    public static final long SERIALVERSIONUID = VersionMe.SERIALVERSIONUID;

    public static final int VERSIONNUMMAJ =     VersionMe.VERSIONNUMMAJ;
    public static final int VERSIONNUMMIN =     VersionMe.VERSIONNUMMIN;
    public static final int VERSIONNUMPATCH =   VersionMe.VERSIONNUMPATCH;
    public static final int VERSIONNUMBUILD =   VersionMe.VERSIONNUMBUILD;

    public static final String VERSIONDATE = VersionMe.VERSIONDATE;
    public static final String COMMENT = VersionMe.COMMENT;

    /** Version de WebObjects */
    private static final String WO_VERSION_MIN = "5.3.3.0";
    private static final String WO_VERSION_MAX = null;

    /** Version du JRE */
    private static final String JRE_VERSION_MIN = "1.6.0.0";
    private static final String JRE_VERSION_MAX = null;

    /** Version d'ORACLE */
    private static final String ORACLE_VERSION_MIN = "9.0";
    private static final String ORACLE_VERSION_MAX = null;

    /** Version de WONDER */
    // TODO si build maven, trouver le moyen d'injecter la version
    // dans l'Info.plist
    @SuppressWarnings("unused")
	private static final String WONDER_VERSION_MIN = "5.0";
    @SuppressWarnings("unused")
	private static final String WONDER_VERSION_MAX = null;

    /** Version du frmk FwkCktlWebApp */
    private static final String FWKCKTLWEBAPP_VERSION_MIN = "4.0.0";
    private static final String FWKCKTLWEBAPP_VERSION_MAX = null;
    
    /** Version du frmk FwkCktlDroitsUtils */
    private static final String FWKCKTLDROITSUTILS_VERSION_MIN = "1.0.0";
    private static final String FWKCKTLDROITSUTILS_VERSION_MAX = null;
    
    /** Version du frmk FwkCktlAjax */
    private static final String FWKCKTLAJAX_VERSION_MIN = "1.0.0";
    private static final String FWKCKTLAJAX_VERSION_MAX = null;

    /** Version du frmk FwkCktlGRH */
    private static final String FWKCKTLGRH_VERSION_MIN = "1.0.0";
    private static final String FWKCKTLGRH_VERSION_MAX = null;
    
    /** Version du frmk FwkCktlGRHGuiAjax */
    private static final String FWKCKTLGRHGUIAJAX_VERSION_MIN = "1.0.0";
    private static final String FWKCKTLGRHGUIAJAX_VERSION_MAX = null;
    
    /** Version du frmk cocowork2 
    private static final String COCOWORK2_VERSION_MIN = "1.0.0";
    private static final String COCOWORK2_VERSION_MAX = null;*/
    
    /** Version du frmk FwkCktlGSpot 
    private static final String FWKCKTLGSPOT_VERSION_MIN = "1.1.2.3";
    private static final String FWKCKTLGSPOT_VERSION_MAX = null;*/
    
    /** Version du frmk FwkCktlGSpotGuiAjax 
    private static final String FWKCKTLGSPOTGUIAJAX_VERSION_MIN = "1.1.2.3";
    private static final String FWKCKTLGSPOTGUIAJAX_VERSION_MAX = null;*/
    
    /** Version du frmk FwkCktlPersonne */
    private static final String FWKCKTLPERSONNE_VERSION_MIN = "1.1.0.0";
    private static final String FWKCKTLPERSONNE_VERSION_MAX = null;
    
    /** Version du frmk FwkCktlPersonneGuiAjax */
    private static final String FWKCKTLPERSONNEGUIAJAX_VERSION_MIN = "1.1.0.0";
    private static final String FWKCKTLPERSONNEGUIAJAX_VERSION_MAX = null;
    
    /** Version de BDD */
    private static final String BD_VERSION_MIN = "1.7.1.2";
    private static final String BD_VERSION_MAX = null;
    
    public String name() {
        return APPLICATIONFINALNAME;
    }

    public String internalName() {
        return APPLICATIONINTERNALNAME;
    }

    public int versionNumBuild() {
        return VERSIONNUMBUILD;
    }

    public int versionNumMaj() {
        return VERSIONNUMMAJ;
    }

    public int versionNumMin() {
        return VERSIONNUMMIN;
    }

    public int versionNumPatch() {
        return VERSIONNUMPATCH;
    }

    public String date() {
        return VERSIONDATE;
    }

    public String comment() {
        return COMMENT;
    }
	
    public String copyright(){
    	String strDateNow = DateCtrl.dateToString(DateCtrl.now());
    	 return "&copy; " + strDateNow.substring(strDateNow.length() - 4) + " - CEDRE - Université de Technologie de Troyes";
    }


    /**
     * Liste des dÃ©ependances 
     * @see org.cocktail.fwkcktlwebapp.server.version.A_CktlVersion#dependencies()
     */
    public CktlVersionRequirements[] dependencies() {
        return new CktlVersionRequirements[]{
                // TODO : faire marcher la verif des versions avec les fmk jar !
                new CktlVersionRequirements(new CktlVersionWebObjects(), WO_VERSION_MIN, WO_VERSION_MAX, true),
                new CktlVersionRequirements(new CktlVersionJava() , JRE_VERSION_MIN, JRE_VERSION_MAX, true)
                ,new CktlVersionRequirements(new CktlVersionOracleServer(), ORACLE_VERSION_MIN, ORACLE_VERSION_MAX, false)
                ,new CktlVersionRequirements(new VersionDatabase(), BD_VERSION_MIN, BD_VERSION_MAX, true)
                , new CktlVersionRequirements(new org.cocktail.fwkcktlgrh.server.Version(), 
                        FWKCKTLGRH_VERSION_MIN, FWKCKTLGRH_VERSION_MAX, true)
                , new CktlVersionRequirements(new org.cocktail.fwkcktlgrhguiajax.server.Version(), 
                        FWKCKTLGRHGUIAJAX_VERSION_MIN, FWKCKTLGRHGUIAJAX_VERSION_MAX, true)
                , new CktlVersionRequirements(new org.cocktail.fwkcktlpersonne.server.Version(), 
                        FWKCKTLPERSONNE_VERSION_MIN, FWKCKTLPERSONNE_VERSION_MAX, true)
                , new CktlVersionRequirements(new org.cocktail.fwkcktlpersonneguiajax.serveur.Version(), 
                        FWKCKTLPERSONNEGUIAJAX_VERSION_MIN, FWKCKTLPERSONNEGUIAJAX_VERSION_MAX, true)
                , new CktlVersionRequirements(new org.cocktail.fwkcktlajaxwebext.serveur.Version(), 
                        FWKCKTLAJAX_VERSION_MIN, FWKCKTLAJAX_VERSION_MAX, true)
                , new CktlVersionRequirements(new org.cocktail.fwkcktlwebapp.server.version.Version(), 
                        FWKCKTLWEBAPP_VERSION_MIN, FWKCKTLWEBAPP_VERSION_MAX, true)
                , new CktlVersionRequirements(new org.cocktail.fwkcktldroitsutils.server.Version(), 
                        FWKCKTLDROITSUTILS_VERSION_MIN, FWKCKTLDROITSUTILS_VERSION_MAX, true)
                //, new CktlVersionRequirements(new org.cocktail.fwkgspot.serveur.Version(), 
                //        FWKCKTLGSPOT_VERSION_MIN, FWKCKTLGSPOT_VERSION_MAX, true)
                //, new CktlVersionRequirements(new org.cocktail.fwkgspotguiajax.serveur.Version(), 
                //        FWKCKTLGSPOTGUIAJAX_VERSION_MIN, FWKCKTLGSPOTGUIAJAX_VERSION_MAX, true)
        };
    }
}
