import React from 'react';
// import myproducts from '../images/myproducts.jpg';

const Home = () => {
    return (
        <div>

            <h2 style={{ textAlign: "center" }} 
                className="display-4" >
                    Home Page
            </h2>

            <img src='https://static.vecteezy.com/system/resources/previews/000/139/999/original/vector-illustration-of-skin-care-products.jpg' 
                alt='Products Image'
                style={{ width: "100%"}}
                />
{/* 
            <img src={myproducts} 
                alt='Other Products' 
                style={{ width: "100%" }}
                /> */}

        </div>
    );
};

export default Home;