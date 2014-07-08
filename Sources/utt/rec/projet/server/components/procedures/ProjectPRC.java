/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public abstract class ProjectPRC {
	
	public ProjectPRC() {
		// TODO Auto-generated constructor stub
	}
	
	public final NSDictionary executeStoredProcedureNamed(EOEditingContext ec, String name, NSDictionary args) {
	    return EOUtilities.executeStoredProcedureNamed(ec, name, args);
	}

}
