/**
 * 
 */
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
		alert("Le caractere maximum du champs "+elem.name+" est de: " +max);
		elem.focus();
		return false;
	}
}
