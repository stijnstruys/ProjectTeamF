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
    var geocoder;
    var counter = 0;

    var directionsService = new google.maps.DirectionsService();
    initialize();

    //zet specifieke locaties
    setSpecificLocations();

    if ($("#showRoute").is(':checked')) {
        doCalc();
    }
    else {
        placeMarkers();
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
        map = new google.maps.Map($('#map_canvas')[0], mapOptions);
        directionsDisplay.setMap(map);

        //get locations
        var count = 1;
        $('.addresses').each(function () {
            var loc = new Object();
            loc.Adres = this.value;
            loc.ID = this.id;
            loc.coorLat = $('#coorLat' + count).text();
            loc.coorLng = $('#coorLng' + count).text();
            locations.push(loc);
            count++;
        });

        var input = $("#address");

        //bij klik op knop of enter eerst kijken of plaats bestaat
        $("#addStopPlaats").bind("keypress", function (e) {
            if (e.keyCode == 13) {
                checkExistence();
                return false;
            }
        });

        $("#searchKnop").click(function () {
            checkExistence();
        });

    }

    function checkExistence() {
        $("#validation_failed2").hide();
        var geocoder = new google.maps.Geocoder();
        var addressInput = $("#address").val();
        geocoder.geocode({'address': addressInput}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                //alert('ja');
                //bestaande plaats
                $("#coorLat").val(results[0].geometry.location.lat());
                $("#coorLng").val(results[0].geometry.location.lng());
                $("#addStopPlaats").submit();
            }
            else {
                //onbestaande plaats
                $("#validation_failed2").show();
            }
        });
    }

    //zet markers met route
    function doCalc() {
        var selectedMode = $("#mode").val();
        var waypts = [];
        //alle punten tussen start en einde
        for (var i = 1; i < (locations.length - 1); i++) {
            waypts.push({
                location: locations[i].Adres
            });
        }
        var request = {
            origin: locations[0].Adres,
            destination: locations[locations.length - 1].Adres,
            waypoints: waypts,
            travelMode: google.maps.TravelMode[selectedMode]
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
            //alert(loc.coorLat);
            marker = new google.maps.Marker({
                map: map,
                position: new google.maps.LatLng(loc.coorLat, loc.coorLng)
            });
            counter++;
            if (counter == locations.length) {
                zoomMap();
            }
        });
    }

    //zoom map to middle of markers
    function zoomMap() {
        //  Make an array of the LatLng's of the markers you want to show
        var LatLngList = new Array();
        $.each(locations, function (l, loc) {
            LatLngList.push(new google.maps.LatLng(loc.coorLat, loc.coorLng));
        });
        //  Create a new viewpoint bound
        var bounds = new google.maps.LatLngBounds();
        //  Go through each...
        for (var i = 0, LtLgLen = LatLngList.length; i < LtLgLen; i++) {
            //  And increase the bounds to take this point
            bounds.extend(LatLngList[i]);
        }
        //  Fit these bounds to the map
        map.fitBounds(bounds);
    }

    //exacte locaties plaatsen
    function setSpecificLocations() {
        $.each(locations, function (l, loc) {
            geocoder.geocode({ 'address': loc.Adres}, function (results, status) {
                $("#" + loc.ID).val(results[0].formatted_address);
            });
        });
    }

});
