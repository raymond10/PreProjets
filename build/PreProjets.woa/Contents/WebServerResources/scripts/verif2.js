function limitText(limitField, limitNum) {
      	if (limitField.value.length > limitNum) {
      		limitField.value = limitField.value.substring(0, limitNum);
      	} 
      }

          function fieldLength(theForm){
          	var entr = theForm.Entreprise;
          	var stgad1 = theForm.stageAdr1;
          	var stgad2 = theForm.stageAdr2;
          	var stgbp = theForm.stageBp;
          	var stgcp = theForm.stageCp;
          	var stgcity = theForm.stageVille;
          	var scad1 = theForm.siegeAdr1;
          	var scad2 = theForm.siegeAdr2;
          	var scbp = theForm.siegeBp;
          	var sccp = theForm.siegeCp;
          	var sccity = theForm.siegeVille;
          	var sceff = theForm.siegeEff;
          	var scurl = theForm.siegeUrl;
          	var rdnom = theForm.respDrtNom;
          	var rdfonc = theForm.respDrtFonc;
          	var rdserv = theForm.respDrtServ;
          	var ranom = theForm.respAdmNom;
          	var rafonc = theForm.respAdmFonc;
          	var raserv = theForm.respAdmServ;

          	if(lengthRestriction(entr, 100)){
          		if(lengthRestriction(stgad1, 40)) {
          			if(lengthRestriction(stgad2, 40)){
          				if(lengthRestriction(stgbp, 20)){
          					if(lengthRestriction(stgcp, 10)){
          						if(lengthRestriction(stgcity, 40)){
          							if(lengthRestriction(scad1, 40)) {
          								if(lengthRestriction(scad2, 40)){
          									if(lengthRestriction(scbp, 20)){
          										if(lengthRestriction(sccp, 10)){
          											if(lengthRestriction(sccity, 40)){
          												if(lengthRestriction(sceff, 10)){
          													if(lengthRestriction(scurl, 100)){
          														if(lengthRestriction(rdnom, 60)){
          															if(lengthRestriction(rdfonc, 50)){
          																if(lengthRestriction(rdserv, 100)){
          																	if(lengthRestriction(ranom, 60)){
          																		if(lengthRestriction(rafonc, 50)){
          																			if(lengthRestriction(raserv, 100)){
          																				return true;
          																			}
          																		}
          																	}
          																}
          															}
          														}
          													}
          												}
          											}
          										}
          									}
          								}
          							}
          						}
          					}
          				}
          			}
          		}
          	}
          	return false;
          }

          function lengthRestriction(elem, max){
          	var uInput = elem.value;
          	if(uInput.length <= max){
          		return true;
          	}else{
          		alert("Le nombre caract√†re maximum du champs "+elem.name+" est de: " +max);
          		elem.focus();
          		return false;
          	}
          }
			
			function isAlphaTexteArea(elem, helperMsg) {
				var alphaExp = /^[0-9 a-zA-Z-_.\sàáâãäåçèéêëìíîïðòóôõöùúûüýÿ]+$/;
				if (alphaExp.test(elem.value) == false) {
					alert(helperMsg);
					elem.style.background = 'Yellow';
					elem.value="";
					elem.focus();
					return false;
				}
				elem.style.background = 'White';
				return true;
			}
				
				function isAlphanumeric(elem, helperMsg) {
					var alphaExp = /^[0-9 a-zA-Z]+$/;
					if (alphaExp.test(elem.value) == false) {
						alert(helperMsg);
						elem.style.background = 'Yellow';
						elem.focus();
						return false;
					}
					elem.style.background = 'White';
					return true;
				}

				function emailValidator(elem, helperMsg) {
				  	// var helperMsg = "l'adresse email est incorrecte";
					var emailExp = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
					if(emailExp.test(elem.value) == false) {
					      alert(helperMsg);
					      elem.style.background = 'Yellow';
							  elem.focus();
					      return false;
					   }
					elem.style.background = 'white';
					return true;
				}

				function isDate(elem, helperMsg) {
					var alphaExp = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
					if (alphaExp.test(elem.value) == false) {
						alert(helperMsg);
						elem.style.background = 'Yellow';
						elem.focus();
						return false;
					} 
					elem.style.background = 'white';
					return true;
				}

				function isSelectOption(elem, helperMsg) {
					var alphaExp = /^[0-9 a-zA-Z\s]+$/;
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
				
				function isNumeric(elem, helperMsg) {
					var numericExpression = /^[0-9]+$/;
					if (numericExpression.test(elem.value) == false) {
						alert(helperMsg);
						elem.style.background = 'Yellow';
						elem.focus();
						return false;
					}
					elem.style.background = 'White';
					return true;
				}
				
//				if (isAlphabet(projLong,"Merci de renseigner le nom long du projet. Pas de caractère alpha-numérique svp!")) {
//					if (isNumeric(durProj,	"Merci de renseigner la duree du projet. Pas de caractère alphabétique svp!")) {
//						if (isDate(DateInputWithFormatterField,	"Merci de renseigner la date de debut. Pas de caractère alphabétique svp!")) {
//								if (isAlphabet(finProj,	"Merci de renseigner la source de cofinancement envisagé. Pas de caractère alpha-numérique svp!")) {
//									tinyMCE.triggerSave();
//									theForm.submit();
//									return true;
//								}
//						}
//					}
//
//				}
				
//				var projLong = theForm.elemnts['projLong'];
//				var durProj = theForm.elements['durProj'];
//				var DateInputWithFormatterField = theForm.elements['DateInputWithFormatterField'];
//				var contPrj = theForm.elements['contratSpan'];
//				var finProj = theForm.elements['finProj'];
//				var partProj = theForm.elements['partdDI'];
//				var papProj = theForm.elements['equipesID'];