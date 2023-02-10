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
                        <th>User Id</th>
                    </tr>
                </thead>
                <tbody>

                    {
                        sessionList.map( s =>  
                                    <tr key={s.id}>
                                        <td>{s.seshId}</td>
                                        <td>{s.cal}</td>
                                        <td>{s.dur}</td>
                                        <td>{s.date}</td>
                                        <td>{s.exer}</td>
                                        <td>{s.userId}</td>
                                        <td>
                                            <button className="btn btn-danger">
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