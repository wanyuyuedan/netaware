import React from 'react';
import {Table,Icon,Popconfirm,Divider,Button,Input,Select,Form,Modal,message} from 'antd';
import $ from 'jquery';

const FormItem = Form.Item;

//定义模态框
const CreateForm = Form.create()(props=>{
	//获取参数
	const {modalVisiable,onCancel,onAdd,onShowModal,formValues,form} = props;
	const { getFieldDecorator } = props.form;

	//触发onOk事件的时候，首先检验，然后提交数据
	const okHandle = () => {
		form.validateFields((err,fieldsValues)=>{
			if (err) {return;}

			console.log(fieldsValues);
			form.resetFields();//重置输入域
			onAdd(fieldsValues);//调用父类新增方法并传参
		})
	}

	return(
			<Modal
				visible={modalVisiable}
				title="我是一个粉刷匠"
				okText="确定"
				cancelText="取消"
				onOk={okHandle}
				onCancel={()=>onShowModal(false)}
			>
				<FormItem labelCol={{span:5}} wrapperCol={{span:15}} >
		            {getFieldDecorator('id', {
		                initialValue:formValues.id
		            })(<Input placeholder="编号" type="hidden"/>)}
		        </FormItem>
		        <FormItem labelCol={{span:5}} wrapperCol={{span:15}} >
		            {getFieldDecorator('key', {
		                initialValue:formValues.key
		            })(<Input placeholder="key" type="hidden"/>)}
		        </FormItem>
		        <FormItem labelCol={{span:5}} wrapperCol={{span:15}} label="月份">
		            {getFieldDecorator('month', {
		                initialValue:formValues.month
		            })(<Input placeholder="月份" />)}
		        </FormItem>
		        <FormItem labelCol={{span:5}} wrapperCol={{span:15}} label="销售额">
		            {getFieldDecorator('sales', {
		                initialValue:formValues.sales
		            })(<Input placeholder="销售额" />)}
		        </FormItem>
		        <FormItem labelCol={{span:5}} wrapperCol={{span:15}} >
		            {getFieldDecorator('createtime', {
		                initialValue:formValues.createtime
		            })(<Input placeholder="日期" type="hidden"/>)}
		        </FormItem>
			</Modal>
		)
})

export default class Brand extends React.Component {
	
	constructor(props) {
		super(props);
		this.state={
			itemList :[],
			modalVisiable : false,
			edtFlag : -1
		}
	}

	/*
	 * 在组件首次挂载的时候执行从后台获取数据，只执行一次
	 */
	componentDidMount(){
		//发起ajax请求，获取后台数据
		$.getJSON("http://localhost:8080/findAll",function(data){
			this.setState({
				itemList: data
			});
		}.bind(this))
	}

	//删除方法
	onDelete = (index) => {
		console.log(index);
		//获取当前行对应的数据的ID
		var item_id = this.state.itemList[index].id;
		//发起请求，删除数据
		//data {code:是否成功，msg:成功或失败的消息}
		$.getJSON("http://localhost:8080/delete/"+item_id,function(data){
			console.log(data);
			if(data.code == 1){
				//执行成功后需要刷新页面，把刚才的数据删除掉
				const dataSource = [...this.state.itemList];
				dataSource.splice(index,1);//splice：从index行删除数据，1：表示删除几行
				this.setState({
					itemList : dataSource
				})
			}
		}.bind(this))
	}

	//控制模态框显示
	onShowModal = (flag,index=-1) => {
		console.log(flag,index);
		this.setState({
			modalVisiable : flag,
			edtFlag : index
		})
	}

	//添加方法
	onAdd = (fields) => {
		//判断是新增还是修改
		//如果是新增，调用 save 接口  修改，调用 upodate 接口
		let url = "http://localhost:8080/";
		if(this.state.edtFlag == -1)
			url += "add";
		else
			url += "update";

		let temp = {};
		let{id,month,sales} = fields;
		temp = {id,month,sales};
		console.log("hahaha"+temp);
		//调用接口，并获取返回数据
		$.getJSON(url,temp,function(data){
			//1、重新获取数据  推荐
			//2、修改原来的数据
			if(data.code == 1){//操作成功
				//页面数据 需要 增加新增的数据，如果是修改，我们需要把页面修改的数据改成最新的
				
				let {itemList,edtFlag} = this.state;
				let dataSource = [];

				if(edtFlag == -1){//新增
					//把新增的数据包装在data中
					dataSource = [data.sales,...itemList]
				}else{//修改
					console.log(fields);
					itemList[edtFlag] = fields;
					dataSource = [...itemList];
				}

				message.success("操作成功");
				this.setState({
					itemList : dataSource,
					modalVisiable : false
				})
			}else{
				message.error("操作失败")
			}
		}.bind(this))
	}

	render() {
		
		const dataSource = this.state.itemList;

		const columns = [{
		  title: 'ID',
		  dataIndex: 'id',
		  key: 'id',
		},{
		  title: '月份',
		  dataIndex: 'month',
		  key: 'month',
		}, {
		  title: '销售额',
		  dataIndex: 'sales',
		  key: 'sales',
		}, {
		  title: '创建日期',
		  dataIndex: 'createtime',
		  key: 'createtime',
		}, {
		  title: '操作',
		  dataIndex: '',
		  key: 'operation',
		  width: '20%',
		  render: (text, record,index) => (
		    <span>
		      <span onClick={()=>this.onShowModal(true,index)}>
			    	<a title="编辑" ><Icon type="edit" />编辑</a>
			    </span>
		      <Divider type="vertical" />
		      <Popconfirm title="是否确认删除?" onConfirm={()=>this.onDelete(index)}>
		      <a><Icon type="delete" />删除</a>
		      </Popconfirm>
		    </span>
		  ),
		}];

		const{modalVisiable,edtFlag} = this.state;


		return (
			<div>
				<div>品牌专区</div>
				<Button icon="plus" onClick={()=>this.onShowModal(true)} type="primary" style={{ marginBottom: 16 }}>
		          新增
		        </Button>
		        <CreateForm 
		        	modalVisiable={modalVisiable}
		        	onShowModal={this.onShowModal}
		        	onAdd={this.onAdd}
		        	formValues={edtFlag !=-1 ? this.state.itemList[edtFlag] : {}}
		        />
				<Table dataSource={dataSource} columns={columns} pagination={{ pageSize: 20 }}/>
			</div>
		);
	}
}
