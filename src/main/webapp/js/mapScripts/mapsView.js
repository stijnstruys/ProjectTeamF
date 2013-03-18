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
    var coordinates = new Array();
    var counter = 0;
    var infowindow = new google.maps.InfoWindow();

    if ($("#map_canvas2").length > 0) {
        initialize();
        if ($("#checkShowRouteSolution").attr('class') == "showRouteTrue") {
            doCalc();
        }
        else {
            placeMarkers();
        }
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
        //get locations
        var count = 0;
        $('.addresses2').each(function () {
            var loc = new Object();
            loc.Adres = this.value;
            loc.ID = this.id;
            loc.InfoWindow = $('#infowindow' + count).html();
            loc.coorLat = $('#coorLat' + count).text();
            loc.coorLng = $('#coorLng' + count).text();
            locations.push(loc);
            count++;
        });
    }

    //plaats markers met route
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
                var legs = response.routes[0].legs;
            }
        });
    }

    //plaats markers zonder route
    function placeMarkers() {
        var count = 0;// locations.length - 1;
        var infoWindowArray = new Array();

        $.each(locations, function (l, loc) {
            var marker = new google.maps.Marker({
                map: map,
                position: new google.maps.LatLng(loc.coorLat, loc.coorLng)
            });
            //  alert(loc.InfoWindow);

            google.maps.event.addListener(marker, 'click', function () {
                infowindow.setContent(loc.InfoWindow);
                infowindow.open(map, marker);
            });
            markers.push(marker);
            counter++;
            if (counter == locations.length) {
                zoomMap();
            }
        });

        //neem id voor juiste marker trigger
        $(".addresses2").click(function () {
            var temp = this.id.split("_");
            var clickedID = temp[temp.length - 1];
            //var t = temp.length - clickedID;
            google.maps.event.trigger(markers[clickedID], "click");
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
});