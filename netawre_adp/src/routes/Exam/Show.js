import React from 'react';
import $ from 'jquery';
import { Row, Col, Icon} from 'antd';
import {
  ChartCard,
  yuan,
  MiniArea,
  MiniBar,
  MiniProgress,
  Field,
  Bar,
  Pie,
  TimelineChart,
} from 'components/Charts';


export default class Human extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			dataList : []
		}
	}

	componentDidMount(){
		//发起ajax请求，获取后台数据
		$.getJSON("http://localhost:8080/findAll",function(data){
			let tempList = [];
			let temp = {};
			for (var i =0 ; i < data.length; i++) {
				let{month:x,sales:y}=data[i];
				temp = {x,y};
				tempList.push(temp);
			}
			console.log(tempList);

			this.setState({
				dataList: tempList
			});
		}.bind(this))
	}

	render() {
		const visitData = this.state.dataList;
		return (
			<div>
				<div>销售图表展示</div>
				<Col span={18}>
					<Bar height={200} title="趋势图" data={visitData} />
				</Col>
			</div>
		);
	}
}
