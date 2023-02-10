import React from 'react';
import { Link } from 'react-router-dom';

const Login = () => {

return(

    <div>
        <form  class="form-signin w-100 m-auto">
        {/* <img class="mb-4" src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"/> */}
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

            <div class="form-floating">
                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com"/>
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

            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
            <p class="mt-5 mb-3 text-muted">©Fitness Tracker 2023</p>
        </form>
    </div>


)


};

export default Login;