<!DOCTYPE html>
<html>
<head>
    <script>
        function fetch(){
            var request = new XMLHttpRequest();
            request.onreadystatechange = function(){
                if(this.readyState == 4 && this.status == 200){
                    var response = this.responseText;
                    document.getElementById("mobiles").innerHTML=response;
                }
            };
            request.open("GET", "details.jsp", true);
            request.send();
        }
    </script>
</head>
<body>
<button onclick="fetch()">Show Details</button>
<div id="mobiles"></div>
</body>
</html>