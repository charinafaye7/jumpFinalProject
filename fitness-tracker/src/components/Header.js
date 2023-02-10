import React from 'react';
import { Link } from 'react-router-dom';
import fitness from '../images/fitness-tracker-logo.png';

const Header = () => {

    return (

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <img src={fitness} class="bi me-2" width="40" height="32"/>
                    <span class="fs-4">Fitness Tracker</span>
                </a>

                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="/" class="nav-link active" aria-current="page">Home</a></li>

                    <li class="nav-item"><a href="/Login" class="nav-link">Login</a></li>
                    <li class="nav-item"><a href="/Signup" class="nav-link">Signup</a></li>
                </ul>
            </header>
        </div>   
        // <div>
        //     <h1 className="display-2">Fitness Tracker</h1>

        //     <nav className="navbar navbar-expand-lg bg-light">
        //         <div className="container-fluid">

        //             <Link className="navbar-brand" to="/" >Home</Link>

        //             <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        //                 <span className="navbar-toggler-icon"></span>
        //             </button>

        //             <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
        //             <div className="navbar-nav">

        //                 <Link className="nav-link" to="/Login">Login</Link>

        //                 <Link className="nav-link" to="/Signup">Signup</Link>
        //             </div>
        //             </div>
        //         </div>
        //     </nav>

        // </div>
    );


};

export default Header;