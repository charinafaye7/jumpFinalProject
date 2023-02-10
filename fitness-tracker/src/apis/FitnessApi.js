const URI = "http://localhost:8080/api/"
const URIAUTH = "http://localhost:8080/authenticate"
const URILOGIN = ""

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

    }

    // validateLogin : (placer) => {



    // }

    // fetch ( URI, {
    //     method: "POST", // type of request
    //     headers: { "Content-Type": "application/json" }, // header of request
    //     body: JSON.stringify(productToCreate) // body of request, convert object to json string
    // } )



}

export default FitnessApi;