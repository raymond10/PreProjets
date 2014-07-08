package utt.rec.projet.server.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class NavBatchBar extends MonComposant {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8286100028915998928L;

	public NavBatchBar(WOContext context) {
        super(context);
    }
	
	public boolean isStateless() {
        return true;
    }

    /*
    * accessors
    */
    public boolean hasObjectName() {
        return hasBinding("objectName");
    }
    
    public int nextBatchIndex() {
	int index = currentBatchIndex();
        return ++index;
    }
    
    public int previousBatchIndex() {
	int index = currentBatchIndex();
        return --index;
    }
    
    public int currentBatchIndex() {
    	WODisplayGroup displayGroup = (WODisplayGroup) valueForBinding("displayGroup");

        return displayGroup.currentBatchIndex();
    }
}