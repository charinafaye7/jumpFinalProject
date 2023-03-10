import FitnessApi from '../apis/FitnessApi';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const Login = () => {

    
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")

    const handleSubmit = (event) => { // event -> represents the event of submitting the form

        const user = {
            "username" : username,
            "password": password,

        }

        // make a POST request here to create the session
        FitnessApi.validateUser(user)

        // stop the page from refreshing/reloading when submitting the form
        event.preventDefault()
    }

return(

    <div>
        <form  className="form-signin w-100 m-auto" onSubmit={handleSubmit}>  
          
            <h1 className="h3 mb-3 fw-normal">Please sign in</h1>

            <div className="form-floating">
                <input  type="text" 
                        className="form-control" 
                        id="floatingInput" 
                        placeholder="Username"
                        value={username}
                        onChange={ (event) => { setUsername(event.target.value) } }/>
                <label for="floatingInput">Username</label>
            </div>

            <div className="form-floating w-100">
                <input type="password" 
                       className="form-control" 
                       id="floatingPassword" 
                       placeholder="Password"
                       value={password}
                       onChange={ (event) => {setPassword(event.target.value) }}/>
                <label for="floatingPassword">Password</label>
            </div>

            <button className="w-100 btn btn-lg btn-primary" 
                    type="submit">
                Sign in</button>

            <p className="mt-5 mb-3 text-muted">©Fitness Tracker 2023</p>


        </form>
    </div>


)


};

export default Login;