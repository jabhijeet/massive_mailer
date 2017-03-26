function retrieveEventListFromServer()
{
	var eventList = [];
	
	$.ajax({
	    type: 'GET',
	    url: 'events',
	    dataType: 'json',
	    success: function(data) {eventList = data },
	    async: false
	});
	
	return eventList;
}

function renderEventList(json, selector)
{
	$.each(json, function(idx, item) {
		var title = item.title===undefined?'':item.title;
		var content = (item.content===undefined || item.content==='')?'&nbsp;':item.content;
		selector.append('<li class="col-md-6 title" id="title" style="text-align: left">'+title+'</li>');
		selector.append('<li class="col-md-6 content" id="content" style="text-align: left">'+content+'</li>');
	})
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

