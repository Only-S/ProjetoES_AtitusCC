// URL da API que iremos usar como exemplo
const apiUrl =
	"https://b546-2804-14d-4ca9-826d-54ee-9aec-c65d-a0f4.ngrok-free.app/games";

// Função para fazer o fetch dos dados da API
async function fetchData() {
	try {
		// Fazendo o fetch dos dados da API
		const response = await fetch(apiUrl, {
			method: "GET",
			headers: {
				"Content-Type": "application/json",
				"ngrok-skip-browser-warning": "any_value", // Custom header to skip Ngrok warning
			},
		});

		// Verificando se a resposta está ok
		if (!response.ok) {
			throw new Error(
				"Network response was not ok " + response.statusText
			);
		}

		console.log(response);
		// Convertendo a resposta em JSON
		const data = await response.json();
		console.log(data);

		// Chamando a função para tratar os dados
		//handleData(data);
	} catch (error) {
		console.error("Houve um problema com a requisição fetch:", error);
	}
}

// Função para tratar os dados recebidos da API
function handleData(data) {
	// Exibindo os dados no console (pode ser substituído por outra lógica)
	console.log(data);

	// Exemplo de como iterar sobre os dados e fazer algo com cada item
	data.forEach((item) => {
		// Aqui você pode acessar as propriedades de cada item
		console.log(`Post ID: ${item.id}, Title: ${item.title}`);
	});
}

// Chamando a função para fazer o fetch dos dados
fetchData();

/*

window.onload = function () {
	const apiAdress =
		"https://b546-2804-14d-4ca9-826d-54ee-9aec-c65d-a0f4.ngrok-free.app/games";

	const jogos = [];

	fetch(apiAdress)
		.then((data) => {
			console.log(typeof data);
			jogos = data.json();
			console.log(jogos);
		})
		.then((data) => {
			if (!data.ok) {
				throw Error(data.status);
			}
			return data.json();
		});
};
*/
