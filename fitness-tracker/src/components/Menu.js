import React from 'react';
import { Link } from 'react-router-dom';

const Menu = () => {

return(

    <div>

        <button className="btn btn-danger"><a href="/Add" class="nav-link">Add</a></button>

        <button className="btn btn-danger"><a href="/View" class="nav-link">View</a></button>

    </div>


)


};

export default Menu;