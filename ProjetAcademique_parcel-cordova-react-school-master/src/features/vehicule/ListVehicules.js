import Vehicule from "./Vehicule"
function ListVehicules({ vehicules, state }) {

    return (
        vehicules.map((vehicule,index) => <Vehicule {...vehicule} key={index} state={state} index={index}/>)
    )
}

export default ListVehicules