describe('test show event function', function() {

	
	var rootId = "testContainer";
	var markup = "<ul id='eventTable' class='list-inline' ></ul>";
	var mock_json = [{"id":1, "attributes":{"title":"TestTitle1","description":"TestContent1", "location" : "Singapore"}},{"id":2,"attributes":{"title":"TestTitle2","description":"TestContent2", "location" : "Singapore"}}];
	
	beforeEach(function(){
		var container = document.createElement('div');
		container.setAttribute('id', rootId);
		document.body.appendChild(container);
		container.innerHTML = markup;
	});
	
	afterEach(function() {
		var container = document.getElementById(rootId);
		container.parentNode.removeChild(container);
	});
	
	it('should render empty event list when server JSON is empty',function() {

		var mock_json = [];
		
		renderEventList(mock_json, $("#eventTable"));
		expect($("#eventTable .col-md-12").length).toBe(mock_json.length);
	});
	

	it('should render complete event lists when server JSON contains some elements',function() {

		renderEventList(mock_json, $('#eventTable'));
		expect($("#eventTable .title").length).toBe(mock_json.length);
		$.each(mock_json, function(index, obj)
		{
			expect($("#eventTable .title").eq(index).text()).toBe(obj.attributes.title);
			expect($("#eventTable .content").eq(index).text()).toBe(obj.attributes.description);
			expect($("#eventTable .location").eq(index).text()).toBe(obj.attributes.location);
		})	
	});
	
});