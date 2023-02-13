import React from 'react';
// import myproducts from '../images/myproducts.jpg';
import workout1 from '../images/workout1.jpg';
import workout2 from '../images/workout2.jpg';
import workout3 from '../images/workout3.jpg';

const Home = () => {
    return (
        

        <div id="carouselExampleFade" className="carousel slide carousel-fade">
            <div className="carousel-inner">
                <div className="carousel-item active">
                    <img  src={workout1} className="d-block w-100" alt="..."/>
                </div>
                <div className="carousel-item">
                    <img  src={workout2} className="d-block w-100" alt="..."/>
                </div>
                <div className="carousel-item">
                    <img  src={workout3} className="d-block w-100" alt="..."/>
                </div>
            </div>
            <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                <span className="visually-hidden">Previous</span>
            </button>
            <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                <span className="visually-hidden">Next</span>
            </button>

            <h1>Welcome to Fitness Tracker</h1>
            <p>This is developed by Ayden Abad, Charina Abapo, Matteo Antunez, and Travis Saulat was create to help users keep track of there exercise to gather statistics like calories burned. Please feel free to create an account and experience our application we have created.</p>
        </div>

        
    );
};

export default Home;