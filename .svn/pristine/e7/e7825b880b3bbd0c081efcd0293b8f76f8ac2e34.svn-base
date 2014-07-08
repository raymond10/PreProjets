package utt.rec.projet.server.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;
import com.webobjects.foundation.NSLog;

import er.ajax.AjaxGrid;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class deleteGridRow extends WOComponent {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9212925166981233990L;
	public String value;
	public AjaxGrid grid;

	public deleteGridRow(WOContext context) {
        super(context);
    }

	public void deleteRow() {
		NSLog.out.appendln("Nombre d'objets du grid: "+grid.displayGroup().allObjects());
		NSLog.out.appendln("Numero ligne : "+grid.displayGroup().allObjects().indexOfObject(grid.row()));
		grid.displayGroup().deleteObjectAtIndex(grid.displayGroup().allObjects().indexOfObject(grid.row()));
	}
}