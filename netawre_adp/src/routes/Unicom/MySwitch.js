import React from 'react';
import { Switch } from 'antd';

function onChange(checked) {
	console.log(`switch to ${checked}`);
}

export default class MySwitch extends React.Component {
	
	constructor(props) {
		super(props);
	}

	render() {
		return (
			<div style={{marginLeft:'80%'}}>
				<Switch defaultChecked onChange={onChange} />
			</div>
		);
	}
}
