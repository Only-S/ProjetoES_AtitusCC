document.querySelectorAll('.avaliacao').forEach(avaliacao => {
    const stars = avaliacao.querySelectorAll('.star-icon');
    
    stars.forEach((star, index) => {
        star.addEventListener('click', function() {
            stars.forEach((s, i) => {
                if (i <= index) {
                    s.classList.add('ativo');
                } else {
                    s.classList.remove('ativo');
                }
            });
        });
    });
});