
function Button1(props){
	/*
	function click(){
		alert(props.text)
	}
	*/

	return(
		<button onClick={props.click} className={props.classNames}>{props.text}</button>
	)
}

const Button2 = ({text, styles, click})=>{
	//const click = ()=> alert(text);
	return(
		<button onClick={click} style={styles}>{text}</button>
	)
}

export {Button1, Button2};