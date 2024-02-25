export default function Login({name, setName})
{
    return (
        <input value={name} onChange={( e ) => {setName(e.target.value)}} type="text" placeholder="Entre ton nom."/>
    )
}