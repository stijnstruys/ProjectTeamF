
$(document).ready(function(){
 var geocoder
 var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
 var map;
 var counter = 1;
 var markerLocations = new Array();

initialize();

$(".addressButton").click(function(){

	codeAddress();
  var newStoppingPoint = '<tr id="mapsRow'+counter+'"><td><input id="location'+counter+'" type="textbox" value="'+$("#address").val()+'"></td>';
  newStoppingPoint += '<td><input id="changeButton'+counter+'" type="button" value="Change"></td>'
  newStoppingPoint += '<td><input id="removeButton'+counter+'" type="button" value="Remove"></td></tr>'
  var rightLocation = '#mapsRow'+counter;
  var rightLocationNr = counter;
  var newLocation = "#location"+counter;
  if($("#mapsRow"+(counter-1)).length == 0)
  {
    $("#mapsRow0").after(newStoppingPoint);
  }
  else
  {
    $("#mapsRow"+(counter-1)).after(newStoppingPoint);
  }

  $('body').on('click', '#removeButton'+counter, function () {
     removeLocation(rightLocation, rightLocationNr);
  });

  $('body').on('click', '#changeButton'+counter, function () {
     changeLocation(newLocation, rightLocationNr);
  });

  counter++;
});


function initialize() {
  directionsDisplay = new google.maps.DirectionsRenderer();
  geocoder = new google.maps.Geocoder();
  var mapOptions = {
    zoom: 8,
    center: new google.maps.LatLng(50.875311, 4.526367),
    mapTypeId: google.maps.MapTypeId.ROADMAP
  }
  map = new google.maps.Map($('#map_canvas')[0], mapOptions);
  directionsDisplay.setMap(map);
}

function removeLocation(removeThisLocation, removeThisLocationNr) {
  //remove marker
  markerLocations[removeThisLocationNr-1].mrkr.setMap(null);
  markerLocations[removeThisLocationNr-1].Location ="";
  //remove location
  //alert(markerLocations.length);
  $(removeThisLocation).remove();
  calcRoute();

}

function changeLocation(changeThisLocation, changeThisLocationNr) {

geocoder.geocode({'address': $(changeThisLocation).val()}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
            draggable:true,
            position: results[0].geometry.location
        });
        markerLocations[changeThisLocationNr-1].Location = $(changeThisLocation).val();
        markerLocations[changeThisLocationNr-1].mrkr = marker;
      } else {
        alert("Geocode was not successful for the following reason: " + status);
      }

    });

  markerLocations[changeThisLocationNr-1].setMap(null);
  calcRoute();

}

function codeAddress() {
    var address = $("#address").val();
    geocoder.geocode({'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
			      draggable:true,
            position: results[0].geometry.location
        });
        markerLocation=new Object();
              markerLocation.Location = address;
              markerLocation.mrkr = marker;
        markerLocations.push(markerLocation);
        calcRoute();
      } else {
        alert("Geocode was not successful for the following reason: " + status);
      }

    });
  }

  function calcRoute()
  {
    //alert(counter);

  if(counter > 2)
  {
    var routeCounter = 1;
    $.each(markerLocations, function(m, mark){
      //alert('grote: ' + markerLocations.length);
     if(markerLocations.length != (routeCounter))
      {
       // alert('hallo');
       // alert('wat?? ' + mark.Location);
        //alert('jahee ' + markerLocations[routeCounter].Location + '??,');

        alert(mark.Location + " en " + markerLocations[routeCounter].Location);
        doCalc(mark.Location, markerLocations[routeCounter].Location);
       //alert('nogaltijd');
        routeCounter++;
      }

    });
}
  }

  function doCalc(loc1, loc2) {
  //  alert(loc2);
   // alert(loc1);

  var selectedMode = $("#mode").val();
  alert(selectedMode);
  var request = {
      origin: loc1,
      destination: loc2,
      // Note that Javascript allows us to access the constant
      // using square brackets and a string value as its
      // "property."
      travelMode: google.maps.TravelMode[selectedMode]
  };
  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    }
  });
}

  });
