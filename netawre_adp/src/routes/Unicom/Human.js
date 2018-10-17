import React from 'react';
import $ from 'jquery';
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

const visitData=[
	{
		x:"1月",
		y:100
	},
	{
		x:"2月",
		y:60
	},
	{
		x:"3月",
		y:100
	},
	{
		x:"4月",
		y:80
	},
	{
		x:"5月",
		y:100
	},
	{
		x:"6月",
		y:120
	},
	{
		x:"7月",
		y:100
	},
	{
		x:"8月",
		y:140
	},
	{
		x:"9月",
		y:160
	},
	{
		x:"10月",
		y:100
	},
]

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
			for (var i = data.length - 1; i >= 0; i--) {
				let{name:x,price:y}=data[i];
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
				<div>国家主席</div>
				<Bar height={200} title="趋势图" data={visitData} />
				<ChartCard contentHeight={200} title="小趋势图">
					<MiniBar height={200} data={visitData} />
				</ChartCard>
			</div>
		);
	}
}
