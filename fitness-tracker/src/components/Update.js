import React, { useEffect, useState } from 'react';
import FitnessApi from '../apis/FitnessApi';


const Update = (props) => {

    const session = props.sessionToUpdate

    const [user_id, setUser] = useState(session ? session.user_id:0)
    const [session_date, setDate] = useState(session ? session.session_date:0)
    const [duration, setDuration] = useState(session ? session.duration:0)
    const [calories, setCalories] = useState(session ? session.calories:0)
    const [exercise_id, setExercise] = useState(session ? session.exercise_id:0)

    useEffect (()=>{
        if (session){
            setUser(session.user_id)
            setDate(session.session_date)
            setDuration(session.duration)
            setCalories(session.calories)
            setExercise(session.exercise_id)
        }
    }, [session])



        const handleSubmit = (event) => {
            const sesh = {
                "user": {
                    "user_id": user_id
                },
                "session_date": session_date,
                "duration": duration,
                "calories": calories,
                "exercise": {
                    "exercise_id": exercise_id
                }
            }
        // make a PUT request here to update the product
        FitnessApi.updateSession(sesh)
        // stop the page from refreshing/reloading when submitting the form
        event.preventDefault()
        }
        


    return (
        session ?
        (<div>
            <h1>Update Product Page</h1>

            <form onSubmit={ handleSubmit }>

            <div className='mb-3'>
                    <label htmlFor='duration' className='form-label' >
                        TEST READ ONLY
                    </label>
                    <input type="number"
                        className='form-control'
                        id='duration'
                        name="duration"
                        value={calories}
                        onChange={ (event) => { setCalories(event.target.value) } }
                        //readOnly
                        />
                </div>

                

                <button type="submit" className="btn btn-primary">
                    Update
                </button>
            </form>
        </div>)
         : "Please return to MENU"
    );


};

export default Update;
 