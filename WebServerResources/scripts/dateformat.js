function formatterDate(textfield) {
	var mdate = textfield.value;
	if (mdate.length >0 ) {
	var datej = new Date();
    var annee = datej.getFullYear()+'';
    // On met le mois sur 2 caracteres dans tous les cas
    var mois = datej.getMonth()+1;
    if (mois <= 9)
        mois = "0" + mois;
    var jour = datej.getDate();
    if (jour.length <= 1)
        jour = "0" + jour;
	
	var messretour = "Saisie \u00E9rron\u00E9e.\nLa date doit-\u00EAtre saisie dans l'ordre suivant JJ/MM/AAAA ."
	
	// ON SUPPRIME LES SEPARATEURS DANS LA ZONE SAISIE
	// LA CHAINE RESTANTE DOIT ETRE NUMERIQUE ET DE LONGUEUR comprise entre 1 et 8
	// --------------------------------------------------------------------
	mdate=mdate.replace("/","");
	mdate=mdate.replace("/","");
	if (mdate.length <1 && mdate.length > 8) {
		alert(messretour);
		textfield.value="";
		return (false);
	}
	if (IsNumeric(mdate) == false) {
		alert(messretour);
		textfield.value="";
		return (false);
	}
	// ON RECONSTITUE UNE DATE AU FORMAT JJ/MM/AAAA
	// -------------------------------------------
	
	switch (mdate.length) {
        case 1:
            jour = "0" + mdate;
            break;
        case 2:
            jour = mdate;
            break;
        case 3:
            jour = mdate.substring(0, 2);
            mois = "0" + mdate.substring(2);
            break;
        case 4:
            jour = mdate.substring(0, 2);
            mois = mdate.substring(2);
            break;
        case 5:
            jour = mdate.substring(0, 2);
            mois = mdate.substring(2).substring(0, 2);
            annee = annee.substring(0, 3) + mdate.substring(4);
            break;

        case 6:
            jour = mdate.substring(0, 2);
            mois = mdate.substring(2).substring(0, 2);
            annee = annee.substring(0, 2) + mdate.substring(4);
            break;

        case 7:
            jour = mdate.substring(0, 2);
            mois = mdate.substring(2).substring(0, 2);
            annee = annee.substring(0, 1) + mdate.substring(4);
            break;

        default:
            jour = mdate.substring(0, 2);
            mois = mdate.substring(2).substring(0, 2);
            annee = mdate.substring(4).substring(0, 4);
	}
	
	var mdatenew = jour+'/'+mois+'/'+annee;
	// ON CONTROLE LA COHERENCE DE LA DATE
	// -----------------------------------
	if (isDateValid(mdatenew) == false) {
		alert(messretour);
		textfield.value="";
		return (false);
	}
	textfield.value = mdatenew;
	}
	return (true);
}

function IsNumeric(x) {
	var checkOK = "0123456789";
	var checkStr = x;
	var allValid = true;
	var decPoints = 0;
	var allNum = "";
	for (i = 0; i < checkStr.length; i++) {
		ch = checkStr.charAt(i);
		for (j = 0; j < checkOK.length; j++)
			if (ch == checkOK.charAt(j)) break;
			if (j == checkOK.length) {
				allValid = false;
				break;
			}
		allNum += ch;
	}
	if (!allValid) {
		return (false);
	}
	return (true);
}

function isDateValid(chaineDate) {
	// CONTROLE LA VALIDITE D UN CHAMP DATE
	// alert(chaineDate);
	if (chaineDate == "") return false;
	var ladate = (chaineDate).split("/");
	if ((ladate.length != 3) || isNaN(parseInt(ladate[0])) || isNaN(parseInt(ladate[1])) || isNaN(parseInt(ladate[2]))) return false;
	var unedate = new Date(eval(ladate[2]),eval(ladate[1])-1,eval(ladate[0]));
	var annee = unedate.getYear();
	if ((Math.abs(annee)+"").length < 4) annee = annee + 1900;
	//return(true);
	return ((unedate.getDate() == eval(ladate[0])) && (unedate.getMonth() == eval(ladate[1])-1) && (annee == eval(ladate[2])));
}
