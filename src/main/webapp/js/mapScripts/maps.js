/**
 * Created with IntelliJ IDEA.
 * User: Jeroen Verbunt
 * Date: 27/02/13
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function () {

    var map;
    var locations = new Array();

    var directionsService = new google.maps.DirectionsService();
    initialize();
    //alert(locations.length);
    doCalc();
    function initialize() {
        var rendererOptions = {
            //suppressMarkers : true
            // draggable: true
        };
        directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);
        //geocoder = new google.maps.Geocoder();

        //init map
        var mapOptions = {
            zoom: 8,
            center: new google.maps.LatLng(50.875311, 4.526367),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        map = new google.maps.Map($('#map_canvas')[0], mapOptions);
        directionsDisplay.setMap(map);

        //get locations
        $('.addresses').each(function () {
            locations.push(this.value);
            //alert( this.value );
        });
    }

    //bij klik op knop of enter eerst kijken of plaats bestaat
    $("#addStopPlaats").bind("keypress", function (e) {
        if (e.keyCode == 13) {
           checkExistence();
            return false;
        }
    });

    $("#searchKnop").click(function(){
          checkExistence();
    });

    function checkExistence (){
        $("#validation_failed2").hide();
        var geocoder = new google.maps.Geocoder();
        var addressInput = $("#address").val();
        geocoder.geocode({'address': addressInput}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                //bestaande plaats
                $("#addStopPlaats").submit();
            }
            else {
                //onbestaande plaats
                $("#validation_failed2").show();
            }
        });
    }

    //bereken route
    function doCalc() {
        var selectedMode = $("#mode").val();
        var waypts = [];
        //alle punten tussen start en einde
        for (var i = 1; i < (locations.length - 1); i++) {
            waypts.push({
                location: locations[i]
            });
        }

        var request = {
            origin: locations[0],
            destination: locations[locations.length - 1],
            waypoints: waypts,
            travelMode: google.maps.TravelMode[selectedMode]
        };

        directionsService.route(request, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
            }
        });
    }

});
