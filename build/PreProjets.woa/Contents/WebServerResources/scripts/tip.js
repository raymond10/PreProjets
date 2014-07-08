$(BT_init);

var BT_open_wait = 500; // attente en ms avant de montrer
var BT_close_wait = 0; //attente en ms avant de cacher
var BT_cache_enabled = true;
var BT_events = new Array();
var BT_titles = new Array();

function BT_init(){
	
    $("a.betterTip").parent("div.betterTip")
    .hover(function(){BT_hoverIn($(this).children("a.betterTip")[0]); return false;},
    	   function(){BT_hoverOut($(this).children("a.betterTip")[0])})
    ;
    
    $("a.betterTip").filter(function(index){
    	return $(this).parent("div.betterTip").length == 0;
    })
    .hover(function(){BT_hoverIn(this)}, function(){BT_hoverOut(this)});
    //.click(function(){return false});	
}

function BT_setOptions(hash)
{
	if(hash["openWait"] != null)
		BT_open_wait = hash["openWait"];
	if(hash["closeWait"] != null)
		BT_close_wait = hash["closeWait"];
	if(hash["cacheEnabled"] != null)
		BT_cache_enabled = hash["cacheEnabled"];
}

function BT_hoverIn(a)
{
	var timeout = BT_open_wait;
	
	if($('#BT_cache_'+a.id).length > 0)
		timeout = 0;
	
	var title = a.title;
	
	if(!BT_titles[a.id])
	{
		if(!title || title.toLowerCase() == "$none")
			title = "";
		else if(title.toLowerCase() == "$content")
			title = $(a).text();
		
		BT_titles[a.id] = title;
		a.title = "";
	}
		
	BT_events[a.id] = 1;
	setTimeout(function(){BT_show(a.id)}, BT_open_wait);
}

function BT_hoverOut(a)
{
	BT_events[a.id] = 0;
	setTimeout(function(){BT_remove();}, BT_close_wait);
}

function BT_remove()
{
	$('#BT_main').remove();
}

function BT_show(id) {

	if(BT_events[id] == 0)
		return;
	
	var obj = $("#"+id);
	var url = obj[0].hreflang;
	/*
	var pUV = obj[0].innerHTML.split(" ")[0];
	url = url+'&uv='+pUV;
	*/
	var title = BT_titles[id];
	
	$("#BT").remove();

	var parents = $("#"+id).parent("div.betterTip");
	
	if(parents.length > 0)
		id = $("#"+id).parent("div.betterTip")[0].id;

	obj = $("#"+id);
	
	var showTitle = true;

	if(title.length == 0)
		showTitle = false;
	
	var urlParts = url.split("\?", 2);
	var query = BT_parseQuery(urlParts[1]);
	urlParts[0] = urlParts[0].substr(urlParts[0].lastIndexOf('/')+1);
	
	
	if(!query["width"] || query["width"].length == 0)
		query["width"] = 250;
	
	var tipWidth = parseInt(query["width"]);
	
	var act_left = BT_getLeft(id);
	var act_width = BT_getWidth(id);
				
	var left = act_left + act_width + 12;
	var top = BT_getTop(id);
	
	var arrowDir = "left";
	
	var docWidth = self.innerWidth || (document.documentElement&&document.documentElement.clientWidth) || document.body.clientWidth;
	var right = act_left + act_width + 11 + tipWidth + 20;

	if(docWidth < right)
	{
		left = act_left - 12 - tipWidth;
		
	}

	$("body").append(
	"<div id='BT' class='BT_shadow0' style='top:"+(top-8)+"px; left:"+(left-8)+"px;'>" +
		"<div id='BT_main' style='width:"+query["width"]+"px; '>" +
			"<div style='padding:5px'>" +
				"<div id='BT_content'>" +
					"<div class='BT_loader'></div>" +
				"</div>" +
			"</div>"+
		"</div></div>");
	
	
	
	if(urlParts[0].charAt(0) == '$')
	{
		$('#BT_content').html($("#"+urlParts[0].substr(1)).html());
		$('#BT').show();
	}
	else if(BT_cache_enabled)
	{
		if($('#BT_cache_'+id).length > 0)
			BT_loadCache(id);
		else
			$.get(url, {}, function(data){
					BT_createCacheElement(id, data);
			});
	}
	else
	{
		$.get(url, {}, function(data){
			$('#BT_content').html(data);
			$('#BT_main').show();

		})
	}
}
 
function BT_createCacheElement(id, data)
{
	$("body").append("<div id='BT_cache_"+id+"' style='display:none'>"+
		data+"</div>");
 	BT_loadCache(id);
}

function BT_loadCache(id)
{
	$('#BT_content').html($('#BT_cache_'+id).html());
	hh = $('#BT_content').height();
 t = BT_getTop(id);
 winH=(window.innerHeight)?window.innerHeight+window.pageYOffset  :document.body.offsetHeight;
 top1 = t;
 
 if (t+hh+10>winH) {
  top1=t-hh;
  if (top1<0){ top1=(winH -hh) / 2;} 
 }
 
  
 $('#BT').css("top",top1);
	$('#BT_main').show();

}

function BT_getWidth(id) {
	var x = document.getElementById(id);
	return x.offsetWidth;
}

function BT_getLeft(id) {
	
	var obj = $('#'+id)[0];
	var left = obj.offsetLeft;
	var parent = obj.offsetParent;
	
	while(parent) {
		left += parent.offsetLeft;
		parent = parent.offsetParent;
	}
	
	return left
}

function BT_getTop(id) {
	var obj = $('#'+id)[0];
	var top = obj.offsetTop;
	var parent = obj.offsetParent;
	
	var xoffset = 8    
	var yoffset = 12   
	var px      = "px"
	
	while(parent) {
		top += parent.offsetTop;
		parent = parent.offsetParent;
	}
	
	/*
	winH=(window.innerHeight)?window.innerHeight+window.pageYOffset  :document.body.offsetHeight;

	
	if ((top+obj.offsetHeight*6)>winH) {
	     
      top=(top-obj.offsetHeight*6-yoffset);
    } else {
      top=  top;
    }	
	*/
	return top;
}

function BT_parseQuery ( query ) {
	
	var params = new Object ();
   
	if ( ! query ) 
		return params;
		
	var pairs = query.split(/[;&]/);
	
	for ( var i = 0; i < pairs.length; i++ ) {
		
		var kv = pairs[i].split('=');
		
		if ( ! kv || kv.length != 2 ) 
			continue;
			
		var key = unescape( kv[0] );	
		var val = unescape( kv[1] );
		
		val = val.replace(/\+/g, ' ');
		params[key] = val;
	}
	
	return params;
}
