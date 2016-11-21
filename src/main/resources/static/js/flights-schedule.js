function loadFlightSchedules(response) {
	response = response.flights;
	var resources = [], events = [];
	for (var i = 0; i < response.length; i++) {
		var resource = {
			id : response[i].fare,
			title :  '$ ' + response[i].fare + "    " + response[i].source + " --> "
					+ response[i].destination,
			eventColor : getAirLineColor(response[i].type)
		}
		resources.push(resource);
		var event = {
			id : response[i].id,
			resourceId : response[i].fare,
			start : response[i].arrivalTime,
			end : response[i].departureTime,
			title:response[i].type
		}
		events.push(event);
	}

	$('#calendar').fullCalendar({
		now : new Date().toJSON().slice(0, 10),
		editable : false, // enable draggable events
		aspectRatio : 1.8,
		//scrollTime: '00:00', // undo default 6am scrollTime
		defaultView : 'timelineDay',
		resourceLabelText : 'Fare',
		resources : resources,
		events : events
	});
}

function getAirLineColor(airlineType) {
	if (airlineType == 'United') {
		return 'blue';
	}
	if (airlineType == 'JetBlue') {
		return 'light blue';
	}
	if (airlineType == 'Delta') {
		return 'orange';
	}
	if (airlineType == 'Continental') {
		return 'gray';
	}
	if (airlineType == 'IAD') {
		return 'yellow';
	}
}