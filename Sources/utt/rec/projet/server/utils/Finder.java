/**
 * 
 */
package utt.rec.projet.server.utils;

import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public abstract class Finder {
	
	public static NSArray tableauTrie(NSArray donnees, NSArray sort) {
		return EOSortOrdering.sortedArrayUsingKeyOrderArray(donnees, sort);
	}
	
    public static NSArray fetchArray(EOEditingContext ec,String entityName,String conditionStr,NSArray params,NSArray sortOrderings,boolean refreshObjects) {
    	NSArray myResult = null;
        EOQualifier qual = EOQualifier.qualifierWithQualifierFormat(conditionStr,params);
        EOFetchSpecification spec = new EOFetchSpecification(entityName,qual,sortOrderings,true,true,null);
        spec.setRefreshesRefetchedObjects(refreshObjects);
        try {
        	ec.lock();
        	myResult= ec.objectsWithFetchSpecification(spec);
        } finally {
        	ec.unlock();
        }
        return myResult;
    }

    public static EOEnterpriseObject fetchObject(EOEditingContext ec,String entityName,String conditionStr,NSArray params,NSArray sortOrderings,boolean refreshObjects) {
        NSArray res = fetchArray(ec,entityName,conditionStr,params,sortOrderings,refreshObjects);
        if ((res == null) || (res.count() == 0))
            return null;
        return (EOEnterpriseObject) res.objectAtIndex(0);
    }

    public static NSArray fetchArrayWithPrefetching(EOEditingContext ec,String entityName,String conditionStr,NSArray params,NSArray sortOrderings,boolean refreshObjects,NSArray relationsToPrefetch) {
    	NSArray myResult = null;
    	EOQualifier qual = EOQualifier.qualifierWithQualifierFormat(conditionStr,params);
        EOFetchSpecification spec = new EOFetchSpecification(entityName,qual,sortOrderings,true,true,null);
        spec.setPrefetchingRelationshipKeyPaths(relationsToPrefetch);
        spec.setRefreshesRefetchedObjects(refreshObjects);
        try {
        	ec.lock();
        	myResult= ec.objectsWithFetchSpecification(spec);
        } finally {
        	ec.unlock();
        }
        return myResult;
    }
    
    public static void fetchTable(WODisplayGroup laTable, String leNomTable, EOQualifier leQualifier, NSArray leSort, EOEditingContext ec, boolean selectionnerPremier, boolean refresh) {
        EOFetchSpecification myFetch;
        NSArray myResult = null;

        laTable.setObjectArray(new NSArray());

        laTable.setSelectsFirstObjectAfterFetch(selectionnerPremier);
        laTable.setSortOrderings(leSort);

        myFetch = new EOFetchSpecification(leNomTable,leQualifier,null);
        myFetch.setRefreshesRefetchedObjects(refresh);
        myFetch.setUsesDistinct(true);
        try {
        	ec.lock();
        	myResult=new NSArray(ec.objectsWithFetchSpecification(myFetch));
        } finally{
        	ec.unlock();
        }

        if (leSort!=null)
            myResult=new NSArray(EOSortOrdering.sortedArrayUsingKeyOrderArray(myResult, leSort));

        laTable.setObjectArray(myResult);
    }

    public static NSArray fetchArray(String leNomTable, EOQualifier leQualifier, NSArray leSort, EOEditingContext ec, boolean refresh) {
        EOFetchSpecification myFetch;
        NSArray myResult = null;

        myFetch = new EOFetchSpecification(leNomTable, leQualifier, null);
        myFetch.setRefreshesRefetchedObjects(refresh);
        myFetch.setUsesDistinct(true);
        try {
        	ec.lock();
        	myResult=new NSArray(ec.objectsWithFetchSpecification(myFetch));
        } finally {
        	ec.unlock();
        }
        if (leSort!=null)
            myResult=new NSArray(EOSortOrdering.sortedArrayUsingKeyOrderArray(myResult, leSort));

        return myResult;
    }

    public static NSArray fetchSharedArrayWithNomTableWithSpec(String leNomTable, EOQualifier leQualifier, NSArray leSort, EOEditingContext ec, boolean fetchAll, String fetchSpec) {
        NSArray	myResult = null;
        EOFetchSpecification	myFetch=null;

        if ((NSArray)((NSDictionary)ec.sharedEditingContext().objectsByEntityName()).valueForKey(leNomTable)==null) {
            if (fetchSpec!=null) {
                myFetch=EOFetchSpecification.fetchSpecificationNamed(fetchSpec, leNomTable);

                if ( (myFetch!=null) && (!fetchAll) && (leQualifier!=null))
                    myFetch.setQualifier(leQualifier);
            }

            if (myFetch==null) {
                if (fetchAll)
                    myFetch=new EOFetchSpecification(leNomTable,null,leSort);
                else
                    myFetch=new EOFetchSpecification(leNomTable,leQualifier,leSort);
            }

            myFetch.setRefreshesRefetchedObjects(true);
            myFetch.setUsesDistinct(true);
            try{
            	ec.lock();
            	myResult=new NSArray(ec.sharedEditingContext().objectsWithFetchSpecification(myFetch));
            } finally {
            	ec.unlock();
            }
        }
        else
            myResult=new NSArray((NSArray)((NSDictionary)ec.sharedEditingContext().objectsByEntityName()).valueForKey(leNomTable));

        if (leQualifier!=null)
            myResult=new NSArray((NSArray)(EOQualifier.filteredArrayWithQualifier(myResult, leQualifier)));

        if (leSort!=null)
            myResult=new NSArray(EOSortOrdering.sortedArrayUsingKeyOrderArray(myResult, leSort));

        return myResult;
    }

}
