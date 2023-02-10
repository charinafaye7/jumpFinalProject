import React from 'react';
// import myproducts from '../images/myproducts.jpg';
import workout1 from '../images/workout1.jpg';
import workout2 from '../images/workout2.jpg';
import workout3 from '../images/workout3.jpg';

const Home = () => {
    return (
        

        <div id="carouselExampleFade" class="carousel slide carousel-fade">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img  src={workout1} class="d-block w-100" alt="..."/>
                </div>
                <div class="carousel-item">
                    <img  src={workout2} class="d-block w-100" alt="..."/>
                </div>
                <div class="carousel-item">
                    <img  src={workout3} class="d-block w-100" alt="..."/>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>

            <h1>Welcome to Fitness Tracker</h1>
            <p>This is developed by Ayden Abad, Charina Abapo, Matteo Antunez, and Travis Saulat was create to help users keep track of there exercise to gather statistics like calories burned. Please feel free to create an account and experience our application we have created.</p>
        </div>

        
    );
};

export default Home;