/**
 * Created with IntelliJ IDEA.
 * User: Jeroen Verbunt
 * Date: 26/02/13
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function () {

    var map;
    var locations = new Array();
    var directionsService = new google.maps.DirectionsService();
    var geocoder;

    initialize();
    if ($("#checkShowRouteSolution").attr('class') == "showRouteTrue") {
        doCalc();
    }
    else {
        placeMarkers();
        map.setZoom(12);
    }

    function initialize() {
        geocoder = new google.maps.Geocoder();
        directionsDisplay = new google.maps.DirectionsRenderer();

        //init map
        var mapOptions = {
            zoom: 8,
            center: new google.maps.LatLng(50.875311, 4.526367),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        map = new google.maps.Map($('#map_canvas2')[0], mapOptions);
        directionsDisplay.setMap(map);

        //get locations
        $('.addresses').each(function () {
            locations.push(this.innerHTML);
            //alert( this.innerHTML );
        });
    }

    function doCalc() {
        var waypts = [];
        for (var i = 1; i < (locations.length - 1); i++) {
            waypts.push({
                location: locations[i]
            });
        }
        var request = {
            origin: locations[0],
            destination: locations[locations.length - 1],
            waypoints: waypts,
            travelMode: google.maps.TravelMode.DRIVING
        };
        directionsService.route(request, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
            }
        });
    }

    //plaats markers zonder route
    function placeMarkers() {
        $.each(locations, function (l, loc) {
            geocoder.geocode({ 'address': loc}, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    map.setCenter(results[0].geometry.location);
                    marker = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });
                } else {
                    checkExistence2();
                    //alert("Geocode was not successful for the following reason: " + status);
                }
            });


        });
    }
});