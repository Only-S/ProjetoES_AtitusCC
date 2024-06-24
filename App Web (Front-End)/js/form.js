document.querySelectorAll(".avaliacao").forEach((avaliacao) => {
	const stars = avaliacao.querySelectorAll(".star-icon");

	stars.forEach((star, index) => {
		star.addEventListener("click", function () {
			stars.forEach((s, i) => {
				if (i <= index) {
					s.classList.add("ativo");
				} else {
					s.classList.remove("ativo");
				}
			});
			avaliacao.setAttribute("data-rating", index + 1);
		});
	});
});

function getRatings() {
	const ratings = {};
	document.querySelectorAll(".container-avaliacao").forEach((container) => {
		const id = container.getAttribute("id");
		const avaliacao = container.querySelector(".avaliacao");
		if (avaliacao) {
			const rating = avaliacao.getAttribute("data-rating");
			ratings[id] = rating ? parseInt(rating) : 1;
		}
	});
	return ratings;
}

window.onload = function () {
	// Pega a URL atual
	const urlParams = new URLSearchParams(window.location.search);

	// Pega o valor do parâmetro 'id'
	// ESPERANDO TESTAR COM QRCODE
	const idGame = urlParams.get("id");

	if (idGame == null) {
		window.location.href = "./index.html";
	}

	// const idGame = "6668e0232f4ab7ad08113cb9";
	const apiAdress =
		"https://wondrous-evenly-catfish.ngrok-free.app/reviews?idGame=" +
		idGame;

	const btnSubmit = document.getElementById("btnSubmit");

	btnSubmit.addEventListener("click", function () {
		const ratings = getRatings();
		const comentario = document.getElementById("textreview").value;
		const usuario = "Anônimo";
		const body = {
			nota_grafico: ratings["grafico"],
			nota_trilha_sonora: ratings["trilha-sonora"],
			nota_historia: ratings["historia"],
			nota_gameplay: ratings["gameplay"],
			comentario: comentario,
			usuario: usuario,
		};

		const options = {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
				"ngrok-skip-browser-warning": "any_value",
			},
			body: JSON.stringify(body),
		};

		fetch(apiAdress, options)
			.then((data) => {
				if (!data.ok) {
					throw Error(data.status);
				}
				return data.json();
			})
			.then((body) => {
				console.log(body);
				setTimeout(console.log("TESTE DOS 10 SEGUNDOS"), 10000);
			})
			.catch((e) => {
				console.log(e);
			});
	});
};
