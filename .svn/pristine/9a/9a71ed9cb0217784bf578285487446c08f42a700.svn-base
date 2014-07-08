/**
 * 
 */
package utt.rec.projet.server.components.controler;

import utt.rec.projet.server.Session;
import utt.rec.projet.server.components.ValidProject;
import utt.rec.projet.server.metier.admrec.EOPprec;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class ValiderProjectCtrl extends Object {
	
	public EOEditingContext edc;
	private ValidProject wocomponent;
	public Session sess;
	private EOPprec projet = null;
	
	public ValiderProjectCtrl(ValidProject aWOComponent) {
		// TODO Auto-generated constructor stub
		wocomponent = aWOComponent;
		edc = wocomponent.edc();
		sess = wocomponent.mySession();
	}

	/**
	 * @return the projet
	 */
	public EOPprec getProjet() {
		return projet;
	}

	/**
	 * @param projet the projet to set
	 */
	public void setProjet(EOPprec projet) {
		this.projet = projet;
	}

}
