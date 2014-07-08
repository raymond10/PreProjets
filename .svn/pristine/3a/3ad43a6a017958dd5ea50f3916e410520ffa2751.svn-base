package utt.rec.projet.server.components;

import java.math.BigDecimal;
import java.text.Format;
import java.text.ParseException;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOAssociation;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOElement;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.appserver._private.WOConstantValueAssociation;
import com.webobjects.appserver._private.WODynamicElementCreationException;
import com.webobjects.appserver._private.WOFormatterRepository;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation.ValidationException;
import er.ajax.AjaxDynamicElement;
import er.ajax.AjaxInPlaceEditor;
import er.ajax.AjaxOption;
import er.ajax.AjaxOptions;
import er.ajax.AjaxUtils;
import er.extensions.appserver.ERXWOContext;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class AjaxFieldEditor extends AjaxInPlaceEditor {

	public AjaxFieldEditor(String name, NSDictionary associations,
			WOElement children) {
		super(name, associations, children);
		// TODO Auto-generated constructor stub
	}

	public NSDictionary createAjaxOptions(WOComponent component) {
		NSMutableArray ajaxOptionsArray = new NSMutableArray();
		ajaxOptionsArray.addObject(new AjaxOption("annulerLink",
				AjaxOption.BOOLEAN));
		ajaxOptionsArray.addObject(new AjaxOption("annulerText",
				AjaxOption.STRING));
		ajaxOptionsArray.addObject(new AjaxOption("annulerControl",
				AjaxOption.STRING));
		NSMutableDictionary options = AjaxOption.createAjaxOptionsDictionary(
				ajaxOptionsArray, component, associations());
		return options;
	}

	public void appendToResponse(WOResponse response, WOContext context) {
		WOComponent component = context.component();
		NSDictionary options = createAjaxOptions(component);
		AjaxOptions.appendToResponse(options, response, context);
	}

}