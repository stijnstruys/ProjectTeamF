/**
 * Created with IntelliJ IDEA.
 * User: Jeroen Verbunt
 * Date: 27/02/13
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */

$(document).ready(function () {

    var map;
    var geocoder;
    var marker;

    initialize();
    placeMarker();

    function initialize() {
        geocoder = new google.maps.Geocoder();
        //init map
        var mapOptions = {
            zoom: 8,
            center: new google.maps.LatLng(50.875311, 4.526367),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        map = new google.maps.Map($('#map_canvas')[0], mapOptions);
    }

    $("#mapCheckIcon").click(function () {
        checkExistence2();
        deleteMarker();
        placeMarker();
    });

    $("#updateStopPlaats").bind("keypress", function (e) {
        if (e.keyCode == 13) {
            checkExistence();
            return false;
        }
    });

    $("#updateStopplaatsBtn").click(function () {
        checkExistence();
    });

    function checkExistence() {
        $("#validation_failed2").hide();
        var geocoder = new google.maps.Geocoder();
        var addressInput = $("#address").val();
        geocoder.geocode({'address': addressInput}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                $("#coorLat").val(results[0].geometry.location.lat());
                $("#coorLng").val(results[0].geometry.location.lng());
                $("#updateStopPlaats").submit();
                //alert('ja');
            }
            else {
                $("#validation_failed2").show();
            }
        });
    }

    function checkExistence2() {
        $("#validation_failed2").hide();
        var geocoder = new google.maps.Geocoder();
        var addressInput = $("#address").val();
        geocoder.geocode({'address': addressInput}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                moveMarker();
            }
            else {
                $("#validation_failed2").show();
            }
        });
    }

    //zet marker
    function placeMarker() {
        var address = $("#address").val();

        geocoder.geocode({ 'address': address}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                map.setCenter(results[0].geometry.location);
                marker = new google.maps.Marker({
                    map: map,
                    draggable: true,
                    position: results[0].geometry.location
                });
                geocodePosition(marker.getPosition());
                google.maps.event.addListener(marker, 'dragend', function () {
                    geocodePosition(marker.getPosition());
                });

            } else {
                checkExistence2();
                //alert("Geocode was not successful for the following reason: " + status);
            }
        });
    }

    function deleteMarker() {
        marker.setMap(null);
    }

    function geocodePosition(pos) {
        geocoder.geocode({
            latLng: pos
        }, function (responses) {
            if (responses && responses.length > 0) {
                updateMarkerAddress(responses[0].formatted_address);
            } else {
                updateMarkerAddress('Cannot determine address at this location.');
            }
        });
    }

    function updateMarkerAddress(str) {
        $("#address").val(str);// = str;
    }

});