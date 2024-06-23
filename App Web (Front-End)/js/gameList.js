const apiUrl = "https://wondrous-evenly-catfish.ngrok-free.app/games";

function createGameDiv(game) {
	// Cria a div principal do jogo
	const gameDiv = document.createElement("div");
	gameDiv.className = "game-div";

	// Cria a imagem do jogo
	const gameImage = document.createElement("img");
	gameImage.className = "img-capa";
	gameImage.src = "./assets/img/" + game.capaPath;
	gameImage.alt = "Capa " + game.nome;
	gameDiv.appendChild(gameImage);

	// Cria a lista de dados do jogo
	const gameData = document.createElement("ul");
	gameData.className = "game-data";

	// Cria o título do jogo
	const gameTitle = document.createElement("li");
	gameTitle.className = "li-title";
	gameTitle.textContent = game.nome;
	gameData.appendChild(gameTitle);

	// Cria o item de média
	const gameRating = document.createElement("li");
	gameRating.className = "li-data";
	gameRating.textContent = "Média: " + game.mediaNotas;
	gameData.appendChild(gameRating);

	// Cria o item de número de reviews
	const gameReviews = document.createElement("li");
	gameReviews.className = "li-data";
	gameReviews.textContent = "N° Reviews: " + game.quantidadeReviews;
	gameData.appendChild(gameReviews);

	// Adiciona a lista de dados ao div do jogo
	gameDiv.appendChild(gameData);

	gameDiv.addEventListener("click", function () {
		window.location.href = "./form.html?id=" + game.id; // Redireciona para a página de review do jogo
	});

	return gameDiv;
}

// Função para adicionar os jogos à página
function addGames(games) {
	const container = document.querySelector(".container-catalogo");
	games.forEach((game) => {
		const gameElement = createGameDiv(game);
		container.appendChild(gameElement);
	});
}

// Função para fazer o fetch dos dados da API
async function fetchData(apiUrl) {
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
		handleData(data);
	} catch (error) {
		console.error("Houve um problema com a requisição fetch:", error);
	}
}

// Função para tratar os dados recebidos da API
function handleData(data) {
	// Exibindo os dados no console (pode ser substituído por outra lógica)
	console.log(data);
	addGames(data);
}

window.onload = function () {
	fetchData(apiUrl);
};
