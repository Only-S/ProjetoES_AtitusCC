document.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.launch-button');

    buttons.forEach(button => {
        button.addEventListener('click', function() {
            const gameElement = this.closest('.game');
            const gameIndex = gameElement.getAttribute('data-index');

            fetch('/launch_game', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ index: gameIndex })
            })
            .then(response => response.json())
            .then(data => {
                if (data.status === 'success') {
                    alert('Jogo iniciado com sucesso!');
                } else {
                    alert('Erro ao iniciar o jogo: ' + data.message);
                }
            })
            .catch(error => {
                console.error('Erro:', error);
            });
        });
    });
});
