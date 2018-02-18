import React from 'react';

class App1 extends React.Component {
	render() {
		const {groups} = {
			"userId": 1,
			"id": 1,
			"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
			"body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
		};
		return <div>{groups}</div>
	}
}

export default App1;
