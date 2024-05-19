function Vehicule({roue, nbPassager, marque, state, index}) {
    if(roue < 2) {
        throw new Error(`Il ne peut pas y avoir moins de 2 roues à un véhicule`)
    }

    if(marque == undefined) {
        marque = 'to define'
    }

    const [vehicules, setVehicules] = state;
    const onDelete = () => {
        setVehicules([...vehicules.filter((vehicule, idx) => idx != index)])
    }

    const reverseName = () => {
        let temp = marque.split("").reverse().join("");
        setVehicules([...vehicules.map((vehicule, idx) => idx == index ? {...vehicule, marque : temp} : vehicule)])
    }

    return (
        <div style={{ display : 'flex', flexDirection : 'column', border : '1px solid black', marginBottom : '20px'}}>
            <label>Nombre de roues :</label>
            <span>{roue}</span>
            <label>Nombre de passagers : </label>
            <span>{nbPassager}</span>
            <label>Marque : </label>
            <span>{marque.toUpperCase()}</span>
            <button onClick={onDelete}>Delete</button>
            <button onClick={reverseName}>Reverse Brand</button>
        </div>
    )
}

export default Vehicule;