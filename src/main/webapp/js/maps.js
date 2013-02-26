$(document).ready(function () {

    var map;
    var locations = new Array();

    var directionsService = new google.maps.DirectionsService();
    initialize();
    //alert(locations.length);
    doCalc();
    function initialize() {
        var rendererOptions = {
              draggable: true
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

    function doCalc() {
          //alert(locations[0]);
          //alert(locations[locations.length-1]);

        var selectedMode = $("#mode").val();
        var waypts = [];
        for (var i = 1; i < (locations.length-1); i++) {
           // alert();
             waypts.push({
                  location:locations[i]//,
                 // stopover:true
              });

          }
        //alert(selectedMode);
        var request = {
            origin: locations[0],
            destination: locations[locations.length-1],
            waypoints: waypts,
            optimizeWaypoints: true,
            // Note that Javascript allows us to access the constant
            // using square brackets and a string value as its
            // "property."
            travelMode: google.maps.TravelMode[selectedMode]
        };
        directionsService.route(request, function (response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
            }
        });
    }

});
