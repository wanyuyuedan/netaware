import React from 'react';
import MySwitch from './MySwitch';
import { List,Form, Icon, Input, Button } from 'antd';

const FormItem = Form.Item;

export default class NewsMenu extends React.Component {
	
	constructor(props) {
		super(props);
		this.state ={
			data:[
					'公司新闻',
				  	'国资动态',
				  	'专题专栏',
				  	'通知公告',
				],
			inputValue:'',
		}
		this.inputChange=this.inputChange.bind(this)
	}

	inputChange(e){
      this.setState({
        inputValue: e.target.value
      });
    }

	saveClick (e){
	    this.setState({
			data: [...this.state.data,this.state.inputValue],
			/*清空输入框数据*/
			inputValue: '',
	 	});
	}
	render() {
		const {data} = {...this.state};
		return (
			<div>
				<div>
				    <h3 style={{ margin: '16px 0' }}>新闻中心子菜单</h3>
				    <Form layout="inline">
				        <FormItem>
				      		<Input value={this.state.inputValue} onChange={this.inputChange} prefix={<Icon type="bars" style={{ color:'rgba(0,0,0,.25)' }} />} placeholder="请输入" />
				        </FormItem>
				        <FormItem>
				          <Button
				            type="primary"
				            htmlType="submit"
				            onClick={this.saveClick.bind(this)}
				          >
				            添加
				          </Button>
				        </FormItem>
			    	</Form>
			    	<div style={{height:'10px'}}></div>
				    <List
				      size="small"
				      header={<div>菜单列表</div>}
				      bordered
				      dataSource={data}
				      renderItem={item => (<List.Item>{item}<MySwitch></MySwitch></List.Item>)}
				    />
				</div>
			</div>
		);
	}
}

