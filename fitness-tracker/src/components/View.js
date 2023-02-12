import React, { useEffect, useState } from 'react';
import FitnessApi from '../apis/FitnessApi';

const SessionView = () => {

    const [sessionList, setSessionList] = useState([])

    useEffect( () => {
        console.log("Hello, this component was mounted!")

        FitnessApi.getSession(setSessionList)
       

    }, [] )

    return (
        <div>
            <h1>Session View Page</h1>


            <table className='table'>
                <thead>
                    <tr>
                        <th>Session Id</th>
                        <th>Calories</th>
                        <th>Duration</th>
                        <th>Session Date</th>
                        <th>Exercise</th>
                    </tr>
                </thead>
                <tbody>

                    {
                        sessionList.map( s =>  
                                    <tr key={s.session_id}>

                                        <td>{s.session_id}</td>
                                        <td>{s.calories}</td>
                                        <td>{s.duration}</td>
                                        <td>{s.session_date}</td>
                                        <td>{s.exercise.exercise_name}</td>
                                        <td>
                                            <button className="btn btn-danger" onClick={()=>FitnessApi.deleteSession(s)}>
                                                Delete
                                            </button>
                                            <button className='btn btn-primary'>
                                                Update
                                            </button>
                                        </td>
                                    </tr>
                            )
                    }

                </tbody>
            </table>



        </div>
    );

}

export default SessionView;