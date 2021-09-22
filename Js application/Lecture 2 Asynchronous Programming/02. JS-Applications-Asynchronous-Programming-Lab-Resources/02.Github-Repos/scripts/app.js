function loadRepos() {
	let userName = document.querySelector('#username').value;
	let url = 'https://api.github.com/users'
	let githubUrl = `https://github.com/`
	let ul = document.querySelector('#repos');
	ul.innerHTML = '';

	fetch(`${url}/${userName}/repos`).then((res) => res.json())
		.then((data) => {
			data.forEach(element => {
				ul.appendChild(createli(element));
			});
		})
		.catch((error) => console.error(error));

	document.querySelector('#username').value = '';

	function createli(data) {
		let fullName = data.full_name;
		let li = document.createElement('li');
		let a = document.createElement('a');
		let href = `${githubUrl}${userName}/${fullName}`;
		a.setAttribute('href', href);
		a.textContent = fullName;
		li.appendChild(a);
		return li;
	}
}