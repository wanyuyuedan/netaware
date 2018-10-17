import React from 'react';
import NewsMenu from './NewsMenu';
import NewsList from './NewsList';



export default class News extends React.Component {
	
	constructor(props) {
		super(props);
	}

	

	render() {
		return (
			<div>
			    <NewsMenu />
			    <div style={{height:'20px'}}></div>
			    <h3>新闻列表展示</h3>
			    <NewsList />
			</div>
		)
	}
}

