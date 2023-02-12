import React, { useState } from 'react';
import FitnessApi from '../apis/FitnessApi';

const SessionCreate = () => {

    //const[ name, setName ] = useState("")

    const [user_id, setUser] = useState(0)
    const [session_date, setDate] = useState(0)
    const [duration, setDuration] = useState(0)
    const [calories, setCalories] = useState(0)
    const [exercise_id, setExercise] = useState(0)

    const handleSubmit = (event) => { // event -> represents the event of submitting the form

        const sesh = {
            "user_id" : user_id,
            "session_date": session_date,
            "duration": duration,
            "calories": calories,
            "exercise_id": exercise_id
        }

        // make a POST request here to create the session
        FitnessApi.createSession(sesh)

        // stop the page from refreshing/reloading when submitting the form
        event.preventDefault()
    }
    


    return (
        <div>
            <h1>Create Session</h1>

            <form onSubmit={ handleSubmit }>
                <div className='mb-3'>
                    <label htmlFor='sesh-dur' className='form-label' >
                        Duration
                    </label>
                    <input type="text"
                           className='form-control'
                           id='sesh-dur'
                           required
                           name="sesh-dur"
                           value={duration}
                           onChange={ (event) => { setDuration(event.target.value) } }
                        />
                </div>

                <div className='mb-3'>
                    <label htmlFor='exercise' className='form-label' >
                        Exercise
                    </label>
                    <input type="number"
                           className='form-control'
                           id='exercise'
                           required
                           name="exercise"
                           value={exercise_id}
                           onChange={ (event) => { setExercise(event.target.value) } }
                           />
                </div>


                {/* AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA */}
                
                <div className='mb-3'>
                    <label htmlFor='sesh-user' className='form-label' >
                        User Id
                    </label>
                    <input type="text"
                           className='form-control'
                           id='sesh-user'
                           required
                           name="sesh-user"
                           value={user_id}
                           onChange={ (event) => { setUser(event.target.value) } }
                        />
                </div>

                <div className='mb-3'>
                    <label htmlFor='sesh-date' className='form-label' >
                        Date
                    </label>
                    <input type="text"
                           className='form-control'
                           id='sesh-date'
                           required
                           name="sesh-date"
                           value={session_date}
                           onChange={ (event) => { setDate(event.target.value) } }
                        />
                </div>

                <div className='mb-3'>
                    <label htmlFor='sesh-cal' className='form-label' >
                        Calories
                    </label>
                    <input type="text"
                           className='form-control'
                           id='sesh-cal'
                           required
                           name="sesh-cal"
                           value={calories}
                           onChange={ (event) => { setCalories(event.target.value) } }
                        />
                </div>

                {/* AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA */}

                <button type="submit" className="btn btn-primary">
                    Create Session
                </button>
            </form>
        </div>
    );

};

export default SessionCreate;