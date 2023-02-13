import FitnessApi from '../apis/FitnessApi';
import React, { useState } from 'react';

const UserCreate = () => {

    //const [user_id, setUser] = useState(0)
    const [f_name, setFName] = useState("")
    const [l_name, setLName] = useState("")
    const [roles, setRoles] = useState("")
    const [username, setUserName] = useState("")
    const [user_pwd, setPwd] = useState("")
    const [enabled, setEnab] = useState("")

    const handleSubmit = (event) => { // event -> represents the event of submitting the form

        const user = {
                "f_name": f_name,
                "l_name": l_name,
                "roles": roles,
                "username": username,
                "user_pwd": user_pwd,
                "enabled": true
        }

        FitnessApi.createUser(user)
        event.preventDefault();


}

return (
    

    <div>
            <h1>Create User</h1>

            <form onSubmit={ handleSubmit }>
                <div className='mb-3'>
                    <label htmlFor='sesh-dur' className='form-label' >
                        First Name
                    </label>
                    <input type="text"
                           className='form-control'
                           id='sesh-dur'
                           required
                           name="sesh-dur"
                           value={f_name}
                           onChange={ (event) => { setFName(event.target.value) } }
                        />
                </div>

                <div className='mb-3'>
                    <label htmlFor='exercise' className='form-label' >
                        Last Name
                    </label>
                    <input type="text"
                           className='form-control'
                           id='exercise'
                           required
                           name="exercise"
                           value={l_name}
                           onChange={ (event) => { setLName(event.target.value) } }
                           />
                </div>


                {/* AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA */}
                
                <div className='mb-3'>
                    <label htmlFor='sesh-user' className='form-label' >
                        Roles
                    </label>
                    <input type="text"
                           className='form-control'
                           id='sesh-user'
                           required
                           name="sesh-user"
                           value={roles}
                           onChange={ (event) => { setRoles(event.target.value) } }
                        />
                </div>

                <div className='mb-3'>
                    <label htmlFor='sesh-date' className='form-label' >
                        Username
                    </label>
                    <input type="text"
                           className='form-control'
                           id='sesh-date'
                           required
                           name="sesh-date"
                           value={username}
                           onChange={ (event) => { setUserName(event.target.value) } }
                        />
                </div>

                <div className='mb-3'>
                    <label htmlFor='sesh-cal' className='form-label' >
                        Password
                    </label>
                    <input type="text"
                           className='form-control'
                           id='sesh-cal'
                           required
                           name="sesh-cal"
                           value={user_pwd}  //Edit here for calorie calc
                           onChange={ (event) => { setPwd(event.target.value) } }
                        />
                </div>

                {/* AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA */}

                <button type="submit" className="btn btn-primary">
                    Create Session
                </button>
            </form>
        </div>


)


}
export default UserCreate