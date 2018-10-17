import React from 'react';
import { List } from 'antd';
import axios from 'axios'

const data = [
  '太阳天空照.',
  '花儿对我笑.',
  '小鸟说.',
  '早早早.',
  '你为什么背上小书包.',
];

export default class About extends React.Component {


	constructor(props) {
		super(props);

	}

  componentDidMount() {
    axios.get("/").then((res)=>{
      console.log(res)
    })
  }

	render() {
		return (
  <div>
    <div>
      <h3 style={{ marginBottom: 16 }}>关于中国联通</h3>
      <List
        header={<div>上学歌</div>}
        footer={<div>。。。</div>}
        bordered
        dataSource={data}
        renderItem={item => (<List.Item>{item}</List.Item>)}
      />
    <div></div>
      {/* <h3 style={{ margin: '16px 0' }}>Small Size</h3> */}
      {/* <List
				      size="small"
				      header={<div>Header</div>}
				      footer={<div>Footer</div>}
				      bordered
				      dataSource={data}
				      renderItem={item => (<List.Item>{item}</List.Item>)}
				    />
				    <h3 style={{ margin: '16px 0' }}>Large Size</h3>
				    <List
				      size="large"
				      header={<div>Header</div>}
				      footer={<div>Footer</div>}
				      bordered
				      dataSource={data}
				      renderItem={item => (<List.Item>{item}</List.Item>)}
				    /> */}
    </div>
  </div>
		);
	}
}
