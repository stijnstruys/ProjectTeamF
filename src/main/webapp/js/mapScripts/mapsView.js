/**
 * Created with IntelliJ IDEA.
 * User: Jeroen Verbunt
 * Date: 26/02/13
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function () {

    var map;
    var markers = new Array();
    var locations = new Array();
    var locationInfo = new Array();
    var directionsService = new google.maps.DirectionsService();
    var geocoder;

    if ($("#map_canvas2").length > 0) {
        initialize();
        if ($("#checkShowRouteSolution").attr('class') == "showRouteTrue") {
            doCalc();
        }
        else {
            placeMarkers();
            map.setZoom(12);
        }
        // placeMarkers();
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
        });

        //location info
        $(".address_info").each( function() {
            locationInfo.push(this.innerHTML);
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
        var count = locations.length - 1;
        var infoWindowArray = new Array();

        $.each(locations, function (l, loc) {

            geocoder.geocode({ 'address': loc}, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    map.setCenter(results[0].geometry.location);
                    var marker = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });

                    var infowindow = new google.maps.InfoWindow({
                        content: locationInfo[count]
                    });

                    infoWindowArray.push(infowindow);

                    google.maps.event.addListener(marker, 'click', function() {
                        resetInfoWindow();
                        infowindow.open(map,marker);
                    });
                    markers.push(marker);

                } else {
                    checkExistence2();
                    //alert("Geocode was not successful for the following reason: " + status);
                }
                count--;
            });

            function resetInfoWindow(){
                if(infoWindowArray){
                    for(i in infoWindowArray){
                        infoWindowArray[i].close();
                    }
                }
            }
        });
    }

    /* $(".addresses").click( function() {
     var temp = this.id.split("_");
     var clickedID = temp[temp.length-1];

     markers[1].click();
     });*/


});