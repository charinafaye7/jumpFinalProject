import React from 'react';
import FitnessApi from '../apis/FitnessApi';
import { Link } from 'react-router-dom';

const Login = () => {

return(

    <div>
        <form  class="form-signin w-100 m-auto">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput" placeholder="Username"/>
                <label for="floatingInput">Email address</label>
            </div>

            <div class="form-floating w-100">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password"/>
                <label for="floatingPassword">Password</label>
            </div>

            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"/> Remember me
                </label>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit" onClick={FitnessApi.validateLogin()}>Sign in</button>
            <p class="mt-5 mb-3 text-muted">©Fitness Tracker 2023</p>
        </form>
    </div>


)


};

export default Login;