/**
 * 
 */
package utt.rec.projet.server;

import org.cocktail.fwkcktlwebapp.common.util.DateCtrl;
import org.cocktail.fwkcktlwebapp.common.version.app.VersionApp;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public final class VersionMe extends Object {
	// Nom de l'appli
	static final String APPLICATIONFINALNAME="Pprec";
	public static final String APPLICATIONINTERNALNAME="Pprec";
	public static final String APPLICATION_STRID = "PPREC";
    
    public static final int VERSIONNUMMAJ;
    public static final int VERSIONNUMMIN;
    public static final int VERSIONNUMPATCH;
    public static final int VERSIONNUMBUILD;
    
    public static final String VERSIONDATE;
    public static final String COMMENT = null;

	static {
		VersionApp versionApp = Application.application().injector().getInstance(VersionApp.class);
		VERSIONNUMMAJ = versionApp.majVersion();
		VERSIONNUMMIN = versionApp.minVersion();
		VERSIONNUMPATCH = versionApp.patchVersion();
		VERSIONNUMBUILD = versionApp.buildVersion();
		VERSIONDATE = versionApp.dateVersion();
	}
    
	// Version appli
    public static final long SERIALVERSIONUID = VERSIONNUMMAJ+VERSIONNUMMIN+VERSIONNUMPATCH+VERSIONNUMBUILD;
    
    
    /***
     * Ne pas modifier cette methode, elle est utilisee pour recuperer le nº de version formate a partir d'une tache ant.
     */
	public static void main(String[] args) {
		System.out.println( ""+VERSIONNUMMAJ+"." + VERSIONNUMMIN+"."+VERSIONNUMPATCH+"."+VERSIONNUMBUILD);
	}
    
	public static String appliVersion() {
		String appliVersion = VERSIONNUMMAJ + "." + VERSIONNUMMIN + "." + VERSIONNUMPATCH + "." + VERSIONNUMBUILD;
		return appliVersion;
	}
	public static String htmlAppliVersion() {
		String htmlAppliVersion = "Version " + appliVersion();
		htmlAppliVersion += " du " + VERSIONDATE;
		return htmlAppliVersion; 
	}

	public static String txtAppliVersion() {
		return "Version " + appliVersion() + " du " + VERSIONDATE;
	}

}
