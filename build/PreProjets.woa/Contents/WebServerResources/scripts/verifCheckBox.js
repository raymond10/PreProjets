        function limitText(limitField, limitNum) {
            	if (limitField.value.length > limitNum) {
            		limitField.value = limitField.value.substring(0, limitNum);
            	}
        }
            
        function fieldLength(theForm){
	      	var prd = theForm.periodeStage;
	      	var nometu = theForm.nomEtudiant;
	      	var indemnite = theForm.indemnite;
	      	var montant = theForm.prime;
      	
	      	if(lengthRestriction(prd, 50)){
	      		if(lengthRestriction(nometu, 60)) {
	      			if(lengthRestriction(indemnite, 20)){
	      				if(lengthRestriction(montant, 20)){
	      				return true;
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
	      		alert("Le caractere maximum du champs "+elem.name+" est de: " +max);
	      		elem.focus();
	      		return false;
	      	}
	      }

	       function IngChecked(field){
	        var i = 0;
	        for(i=0; i< field.length;i++){
	        		if(field[i].checked == true) {
	        			alert("IngcheckBox "+field[i].value);
	        		}
	        }
	       }
       
							       function MstChecked(field){
							        var i = 0;
							        for(i=0; i< field.length;i++){
							        		if(field[i].checked == true) {
							        			alert("MstcheckBox "+field[i].value);
							        		}
							        }
							       }