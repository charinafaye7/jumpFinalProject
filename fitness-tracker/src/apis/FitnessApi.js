
const URI = "http://54.185.0.170:8080/api/"
const URIAUTH = "http://54.185.0.170:8080/"

// const URI = "http://localhost:8080/api/"
// const URIAUTH = "http://localhost:8080/"


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

    createUser: async (userToCreate) => {

        var userId = null

        // fetch( uri for request, request object )
        await fetch( URI + "user", {
            method: "POST", // type of request
            headers: { "Content-Type": "application/json" }, // header of request
            body: JSON.stringify(userToCreate) // body of request, convert object to json string
        } )
                .then((response) => {return response.json()})
                .then((data)=> {console.log(data)
                                userId = data.user_id})
                .catch( (error) => {console.log(error)
                })

            const obj = {
                viewId : userToCreate.user_id
            }
            console.log(obj.viewId)
            return obj
    },

    validateUser: async (user) => {

        var auth = null

        await fetch( URIAUTH + "authenticate", {
            method: "POST" ,
            headers: { "Content-Type": "application/json" }, // header of request
            body: JSON.stringify(user)
        } )
        .then( (response) => {response.json()})
        .catch( (error) => { console.log(error) 
                             alert("Invalid Username and Password, please try again.")} ) 
        // window.location.reload()
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