      <!--

      /***********************************************
      * Required field(s) validation v1.10- By NavSurf
      * Visit Nav Surf at http://navsurf.com
      * Visit http://www.dynamicdrive.com/ for full source code
      ***********************************************/

      function formCheck(formobj){
      	// Enter name of mandatory fields
      	var fieldRequired = Array("raison", "StgAdresse1", "StgCodePost");
      	// Enter field description to appear in the dialog box
      	var fieldDescription = Array("Entreprise", "Stage Adresse 1", "Stage code Postal");
      	// dialog message
      	var alertMsg = "Merci de completer les champs suivants :\n";
      	
      	var l_Msg = alertMsg.length;
      	
      	for (var i = 0; i < fieldRequired.length; i++){
      		var obj = formobj.elements[fieldRequired[i]];
      		if (obj){
      			switch(obj.type){
      			case "select-one":
      				if (obj.selectedIndex == -1 || obj.options[obj.selectedIndex].text == ""){
      					alertMsg += " - " + fieldDescription[i] + "\n";
      				}
      				break;
      			case "select-multiple":
      				if (obj.selectedIndex == -1){
      					alertMsg += " - " + fieldDescription[i] + "\n";
      				}
      				break;
      			case "text":
      			case "textarea":
      				if (obj.value == "" || obj.value == null){
      					alertMsg += " - " + fieldDescription[i] + "\n";
      					obj.style.background = 'Yellow';
      				} else {
      					obj.style.background = 'white';
      				}
      				break;
      			default:
      			}
      			if (obj.type == undefined){
      				var blnchecked = false;
      				for (var j = 0; j < obj.length; j++){
      					if (obj[j].checked){
      						blnchecked = true;
      					}
      				}
      				if (!blnchecked){
      					alertMsg += " - " + fieldDescription[i] + "\n";
      				}
      			}
      		}
      	}

      	if (alertMsg.length == l_Msg){
      		return true;
      	}else{
      		alert(alertMsg);
      		return false;
      	}
      }
      
      function lengthRestriction(elem, max){
        	var uInput = elem.value;
        	if(uInput.length <= max){
        		return true;
        		elem.style.background = 'white';
        	}else{
        		alert("Le nombre maximum de ce champs est de : " +max);
        		elem.style.background = 'Yellow';
        		elem.focus();
        		return false;
        	}
        }
      // -->