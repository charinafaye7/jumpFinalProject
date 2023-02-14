import React from 'react';
import { Link } from 'react-router-dom';

const Menu = () => {

return(

    <div>

        {/* <body onload="myFunction()"> */}

        <button className="btn btn-danger"><a href="/Add" class="nav-link">Add</a></button>
        <br></br>
        <br></br>
        <button className="btn btn-danger"><a href="/View" class="nav-link">View</a></button>


        {/* <script>
        function myFunction() {document.getElementById("nav1").innerHTML = ""}
        function myFunction() {document.getElementById("nav2").innerHTML = ""} 

        </script>
        </body> */}
    </div>

    
)


};

export default Menu;