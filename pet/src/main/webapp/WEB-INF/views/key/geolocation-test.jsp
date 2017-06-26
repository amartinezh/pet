<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>"src/main/java"
    <title>Device Properties Example</title>

    <script type="text/javascript" charset="utf-8" src="/resources/js/cordova.js"></script>
    <script type="text/javascript" charset="utf-8">

    // Wait for device API libraries to load
    //
    document.addEventListener("deviceready", onDeviceReady, false);

    var watchID = null;

    // device APIs are available
    //
    function onDeviceReady() {
        // Get the most accurate position updates available on the
        // device.
        var options = { enableHighAccuracy: true };
        watchID = navigator.geolocation.watchPosition(onSuccess, onError, options);
    }

    // onSuccess Geolocation
    //
    function onSuccess(position) {
        var element = document.getElementById('geolocation');
        element.innerHTML = 'Latitude: '  + position.coords.latitude      + '<br />' +
                            'Longitude: ' + position.coords.longitude     + '<br />' +
                            '<hr />'      + element.innerHTML;
    }

    // clear the watch that was started earlier
    //
    function clearWatch() {
        if (watchID != null) {
            navigator.geolocation.clearWatch(watchID);
            watchID = null;
        }
    }

        // onError Callback receives a PositionError object
        //
        function onError(error) {
          alert('code: '    + error.code    + '\n' +
                'message: ' + error.message + '\n');
        }

    </script>
  </head>
  <body>
    <p id="geolocation">Watching geolocation...</p>
        <button onclick="clearWatch();">Clear Watch</button>
  </body>
</html>
