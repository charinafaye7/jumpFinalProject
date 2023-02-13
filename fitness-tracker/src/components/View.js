import React, { useEffect, useState } from 'react';
import FitnessApi from '../apis/FitnessApi';
import { Link } from 'react-router-dom';

const SessionView = (props) => {

    const [sessionList, setSessionList] = useState([])
    const [refresh, setRefresh] = useState(false)

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
                        sessionList.filter(s => s.user.user_id === 4) //link filter with login
                        .map( s =>  
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
                                            <Link to="/update" onClick={()=> props.setSessionToUpdate(s)}>
                                                <button className='btn btn-primary'>
                                                    Update
                                                </button>
                                            </Link>
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