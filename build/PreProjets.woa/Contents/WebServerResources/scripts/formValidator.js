function formValidator(theForm) {
	// Make quick references to our fields
	var projcourt = theForm.elements['projCourt'];
	var projlong = theForm.elements['projLong'];
	var durProj = theForm.elements['durProj'];
	var portProj = theForm.elements['porteurID'];
	var DateInputWithFormatterField = theForm.elements['DateInputWithFormatterField'];
	var papProj = theForm.elements['equipesID'];
	var axeProj = theForm.elements['axeProj'];
	var pstProj = theForm.elements['pstProj'];

	// Check each input in the order that it appears in the form!
	if (isAlphabet(projcourt,
			"Merci de renseigner le nom court du projet valide!")) {
		if (isAlphabet(projlong,
				"Merci de renseigner le nom long du projet valide!")) {
			if (isSelectOption(portProj,
					"Merci de sélectionner le porteur du projet!")) {
				if (isNumeric(durProj,
						"Merci de renseigner la duree du projet. Pas de caractère alphabétique!")) {
					if (isDate(DateInputWithFormatterField,
							"Merci de renseigner la date de debut. Pas de caractère alphabétique!")) {
						if (isSelectOption(papProj,
								"Merci de sélectionner le programme d'accueil principal pour ce projet!")) {
							if (isSelectOption(axeProj,
									"Merci de sélectionner l'axe de l'équipe projet!")
									|| isSelectOption(pstProj,
											"Merci de sélectionner le programme scientifique et technologique!")) {
								tinyMCE.triggerSave();
								theForm.submit();
								return true;
							}
						}
					}
				}
			}
		}
	}
	return false;
}

function validator(theForm) {
	//tinyMCE.triggerSave();
	//tinyMCE.get("contexteId").save();
	//tinyMCE.get("problematiqueId").save();
	//tinyMCE.get("objectifsId").save();
	//tinyMCE.get("methodologieId").save();
	//document.forms[0].elements["contexte"].value=tinyMCE.tinyMCE.get("contexteId").getContent();
	//document.forms[0].elements["problematique"].value=tinyMCE.tinyMCE.get("problematiqueId").getContent();
	//document.forms[0].elements["objectifs"].value=tinyMCE.tinyMCE.get("objectifsId").getContent();
	//document.forms[0].elements["methodologie"].value=tinyMCE.tinyMCE.get("methodologieId").getContent();*/
	//tinyMCE.triggerSave();
	//theForm.elements["contexte"].value=tinyMCE.tinyMCE.get("contexteId").getContent();
	//theForm.elements["problematique"].value=tinyMCE.tinyMCE.get("problematiqueId").getContent();
	//theForm.elements["objectifs"].value=tinyMCE.tinyMCE.get("objectifsId").getContent();
	//theForm.elements["methodologie"].value=tinyMCE.tinyMCE.get("methodologieId").getContent();*/
	//tinyMCE.triggerSave();
	theForm.submit();
	return true;
}

function submitForm() {
	if(document.declarationName.onsubmit()) {
		return ;
	}
	document.declarationName.submit();
}

function isAlphabet(elem, helperMsg) {
	var alphaExp = /^[0-9 a-z A-Z-_.\s'àáâãäåçèéÉêëìíîïðòóôõöùúûüýÿ]+$/;
	if (alphaExp.test(elem.value) == false) {
		alert(helperMsg);
		elem.style.background = '#FFFFCC';
		elem.focus();
		return false;
	}
	elem.style.background = 'White';
	return true;
}

function isNumeric(elem, helperMsg) {
	var numericExpression = /^[0-9]+$/;
	if (numericExpression.test(elem.value) == false) {
		alert(helperMsg);
		elem.style.background = '#FFFFCC';
		elem.focus();
		return false;
	}
	elem.style.background = 'White';
	return true;
}

function isDate(elem, helperMsg) {
	var alphaExp = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
	if (alphaExp.test(elem.value) == false) {
		alert(helperMsg);
		elem.style.background = '#FFFFCC';
		elem.focus();
		return false;
	}
	elem.style.background = 'white';
	return true;
}

function isSelectOption(elem, helperMsg) {
	var alphaExp = /^[0-9 a-z A-Z-_.\s'àáâãäåçèéÉêëìíîïðòóôõöùúûüýÿ]+$/;
	var index = elem.options[elem.selectedIndex];
	if (index.value == "WONoSelectionString") {
		alert(helperMsg);
		return false;
	}
	if (alphaExp.test(index.value) == false) {
		alert(helperMsg);
		elem.focus();
		return false;
	}
	return true;
}