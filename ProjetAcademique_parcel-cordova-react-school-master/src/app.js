import { useEffect,useState } from "react";
import ListVehicules from "./features/vehicule/ListVehicules";
function Welcome(props) {
    return <h1>Hello, {props.name}</h1>;
}

function Welcome2({ name, children }) {
    return name == 'Sara' ? <h1>{children}</h1> : <h1 onClick={() => alert(`${name}`)}>Hello, {name}</h1>;
}

function ListNumbers() {
    const numbers = [1, 2, 3, 4, 5];
    const listItems = numbers.map((number) =>
        <li key={number}>{number}</li>
    );

    return listItems;
}

const random = (max, min) => Math.floor(Math.random() * (max - min + 1) + min);

function App() {
    //var [date, setDate] = useState(new Date().toLocaleTimeString());
    /*
    const [nbRoue, setNbRoue] = useState(4);
    const changeNbRoue = () => setNbRoue(nbRoue + 1);
    */

    var [nbVehicule, setNbVehicule] = useState(0);
    const [vehicules, setVehicules] = useState([]);
    

    if(nbVehicule == 0) {
        let response = window.prompt('Combien de vehicule voulez vous ?');
        setNbVehicule(response)
    }
    
    const generateVehicule = () => { return {roue : random(2,8), nbPassager : random(1, 4)}}

    useEffect(() => {
        var vehiculeTemp = [];
        for(var i= 0; i< nbVehicule; i++) vehiculeTemp.push(generateVehicule());
        setVehicules([...vehiculeTemp]);
    }, [nbVehicule]);

    useEffect(() => {
        console.log(vehicules.length);
        if(vehicules.length < 6) {
            return;
        }

        alert('Il y a beaucoup de véhicules affiché')
    }, [vehicules.length]);
    
    const addVehicule = () => {
        setVehicules([...vehicules, generateVehicule()])
    }
    /*
    const vehiculesJsx = [<Vehicule roue={4} nbPassager={2}/>]
    vehiculesJsx.map(vehicule => <>{vehicule}</>);*/
    return (
        <div style={{width : "300px", margin : 'auto', marginTop : '20px'}}>
            <ListVehicules vehicules={vehicules} state={[vehicules, setVehicules]}/>
            <button onClick={addVehicule}>Add Vehicule</button>
        </div>
    )
}

export default App;