import { Navigate, useNavigate } from "react-router-dom";

const URI = "http://localhost:8080/api/"
const URIAUTH = "http://localhost:8080/"

const navigate = useNavigate();


const FitnessApi = {

    getSession: (setSessionList) => {

        fetch( URI + "workout")
            .then( (result) => {
                console.log("Result")
                console.log(result)
                return result.json()
            })
            .then( (data) =>{
                console.log("Data:") //Small change
                console.log(data)
                setSessionList(data)
            })
            .catch( (error) => { console.log(error)});

    },

    createSession: (sessionToCreate) => {

        // fetch( uri for request, request object )
        fetch( URI + "workout", {
            method: "POST", // type of request
            headers: { "Content-Type": "application/json" }, // header of request
            body: JSON.stringify(sessionToCreate) // body of request, convert object to json string
        } )
            .then( result => result.json() )
            .then( data => {
                console.log("Session Made")
                console.log(data)


            } )
            .catch( (error) => { console.log(error) } ) 

    },

    createUser: (userToCreate) => {

        // fetch( uri for request, request object )
        fetch( URI + "user", {
            method: "POST", // type of request
            headers: { "Content-Type": "application/json" }, // header of request
            body: JSON.stringify(userToCreate) // body of request, convert object to json string
        } )
            .then( result => result.json() )
            .then( data => {
                console.log("User Made")
                console.log(data)


            } )
            .catch( (error) => { console.log(error) } ) 

            const obj = {
                userId : userToCreate.user_id
            }
            console.log(obj.userId)
            return obj
    },

    deleteSession: (sessionToDelete) => {

        fetch( URI + "workout/" + sessionToDelete.session_id, {
            method: "DELETE" 
        } )
        .then(response => response.json())
        .then(data => console.log(data))
        .catch( (error) => { console.log(error) } ) 
        window.location.reload()

    },

    validateUser: async (user) => {

        var auth = null

        await fetch( URIAUTH + "authenticate", {
            method: "POST" ,
            headers: { "Content-Type": "application/json" }, // header of request
            body: JSON.stringify(user)
        } )
<<<<<<< HEAD
        .then( (response) => {response.json()})
        .catch( (error) => { console.log(error) 
                             alert("Invalid Username and Password, please try again.")} ) 
        .finally(() => {
            navigate('/menu')
        })
        // window.location.reload()
=======
        .then((response) => {return response.json()})
        .then((data)=> {console.log(data)
                        auth = data.jwt})
        .catch( (error) => {console.log(error)
                            alert("Invalid Username and Password, please try again.")
                            }) 
        const obj = {
            username: user.username,
            jwt: auth
        }             
        return obj
>>>>>>> 0619ec0d8eb6f4343fa882b98cf87e9586887b4d
    },

    updateSession: (sessionToUpdate) => {
        
        fetch( URI + "/workout/update", {
            method: "PUT", // type of request
            headers: { "Content-Type": "application/json" }, // header of request
            body: JSON.stringify(sessionToUpdate) // body of request, convert object to json string
        } )
            .then( async function (result) {
                const data = await result.json()
                  
            })
            .catch( (error) => { console.log(error) } ) 
    }






}

export default FitnessApi;