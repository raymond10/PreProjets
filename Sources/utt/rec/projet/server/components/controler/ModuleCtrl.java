/**
 * 
 */
package utt.rec.projet.server.components.controler;

import com.webobjects.eocontrol.EOEditingContext;

import utt.rec.projet.server.components.assistant.IAssistant;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *3 juin 2013
 */
public class ModuleCtrl <T extends IAssistant> {
	private T wocomponent;
	
	public ModuleCtrl(T component) {
	    this.wocomponent = component;
	}
	
	public EOEditingContext editingContext() {
	    return wocomponent().editingContext();
	}
	
	public T wocomponent() {
	    return wocomponent;
	}
}
