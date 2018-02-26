import React from 'react';
import axios from 'axios';

class App1 extends React.Component {

	state = {
		user: {
			id: 1,
			name: "name",
			email: "",
			role: 1,
			company: {name: "company"}
		}
	};


// var id = this.props.comment;
	input() {
		var id = document.getElementById('id').value;
		this.state.user.id = id;
		axios.get("https://jsonplaceholder.typicode.com/users/" + this.state.user.id)
			.then((resp) => {
				var data = resp.data;
				console.log(data);
				this.setState({user: data});
			});
	}

	render() {
		const user = this.state.user;
		return <div>
			Post id:
			<input id="id" />
			<button onClick={() => this.input()}>get</button>
			<table>
				<tr>
					<th>User name</th>
					<th>user ID</th>
					<th>email</th>
					<th>role id</th>
				</tr>
				<tr>
					<td>{user.name}</td>
					<td>{user.id}</td>
					<td>{user.email}</td>
					<td>{user.company.name}</td>
				</tr>
			</table>
		</div>;
	}

}

export default App1;
