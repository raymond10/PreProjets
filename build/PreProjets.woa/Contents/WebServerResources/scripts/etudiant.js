$(Liste_init);


function Liste_init(){
	$(".periode").change(function(){periode_change(this,true);});
	$(".periode1").change(function(){periode_change(this,false);});	
	$(".diplome").change(function(){diplome_change(this);});
	$(".diplome1").change(function(){diplome_change1(this);});
	$(".niveau").change(function(){niveau_change(this);});
	
	initListePV();

}


function initListePV() {
a = $(".ledit").length;
var int=null;
if (a>0) {
	/*int = setInterval(function() {listePV();},180000);*/
	int = setInterval(function() {listePV();},30000);
}
 
}

function listePV() {
	$.getJSON("listePV",{ajax: 'true'}, function(j) {
 	var options = '';
 	for (var i = 0; i < j.length; i++) {
			options += '<li><a target="_blank" href="http://gestion.utt.fr/dev/dev3/suivi/export/' + j[i] + '">' + j[i] + '</a></li>';
 	}
  $(".ledit").html(options);

	});
}

function periode_change(a,b) {
	$.getJSON("select_dipl",{id: $(a).val(), ajax: 'true'}, function(j) {
 	var options = '';
 	if (b) options='<option value="">Tous</option>';
 	for (var i = 0; i < j.length; i++) {
			options += '<option value="' + j[i].optionValue + '">' + j[i].optionDisplay + '</option>';
 	}
  $(".diplome").html(options);
  $(".diplome")[0].selectedIndex=0;
  diplome_change($(".diplome")[0]);
	});
}

function diplome_change(a) {
 p = $(".periode").val();

 if (!p) {p=$(".periode1").val();}
	$.getJSON("select_niv",{id: $(a).val(),per:p, ajax: 'true'}, function(j) {
 	var options = '<option value="">Tous</option>';
 	for (var i = 0; i < j.length; i++) {
 		options += '<option value="' + j[i].optionValue + '">' + j[i].optionDisplay.replace('     ','&nbsp;') + '</option>';
 	}
  $(".niveau").html(options);
  $(".niveau")[0].selectedIndex=0;
	});
}

function diplome_change1(a) {
 p = $(".periode").val();

 if (!p) {p=$(".periode1").val();}
 $.getJSON("select_nivE",{id: $(a).val(),per:p, ajax: 'true'}, function(j) {
  var options = '<option value="">Tous</option>';
  for (var i = 0; i < j.length; i++) {
   options += '<option value="' + j[i].optionValue + '">' + j[i].optionDisplay + '</option>';
  }
  $(".niveau").html(options);
  $(".niveau")[0].selectedIndex=0;
 });
}

function niveau_change(a) {
 idx = a.selectedIndex;
	libniv = a[idx].innerHTML;
	idx = libniv.indexOf("-");
	if (idx>0) libniv = libniv.substring(idx+1,libniv.length);
	libniv = trim(libniv).replace(/ /, '-');
	$("#libniv").val(libniv);

}

/* util */

function trim(v) {
   return v.replace(/^ +/, '');
}

function trim0(v) {
   return v.replace(/^0+/, '');
}

function trimAll(v) {
      v = v.replace(/^\-+/, '');
			v = v.replace(/^0+/, '');
      return v;
}

function calendrier(inf,but,sdt) {
/* '02/06/2008' */

annee = parseInt(sdt.substring(6,10));
mois = parseInt(sdt.substring(3,5));
jour = parseInt(sdt.substring(0,2));

dt = new Date(annee,mois,jour);  

Calendar.setup({inputField:inf,button:but,ifFormat:'%d/%m/%Y',date:dt,align:'Br',singleClick:true,cache:true});

}
