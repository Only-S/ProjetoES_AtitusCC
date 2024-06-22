document.addEventListener('DOMContentLoaded', (event) => {
    let previousGamepadState = null;

    // Função para lançar o jogo
    function launchGame(index) {
        fetch('/launch_game', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ index: index })
        }).then(response => response.json())
          .then(data => {
              if (data.status === 'success') {
                  alert('Jogo iniciado com sucesso!');
              } else {
                  alert('Erro ao iniciar o jogo: ' + data.message);
              }
          });
    }

    // Função para atualizar e logar o status dos botões do gamepad
    function updateGamepadStatus() {
        const gamepads = navigator.getGamepads();
        for (let i = 0; i < gamepads.length; i++) {
            const gp = gamepads[i];
            if (!gp) continue;

            // Verifica se houve mudança desde o último estado registrado
            if (!previousGamepadState || hasGamepadStateChanged(gp, previousGamepadState)) {
                console.log(`Gamepad ${i} State Changed:`);

                // Logar o estado dos botões
                gp.buttons.forEach((button, index) => {
                    if (button.pressed) {
                        console.log(`  Button ${index}: Pressed`);
                    }
                });

                // Atualiza o estado anterior para o atual
                previousGamepadState = cloneGamepad(gp);
            }
        }
        requestAnimationFrame(updateGamepadStatus);
    }

    // Função para verificar se houve mudança no estado do gamepad
    function hasGamepadStateChanged(gp1, gp2) {
        for (let i = 0; i < gp1.buttons.length; i++) {
            if (gp1.buttons[i].pressed !== gp2.buttons[i].pressed) {
                return true;
            }
        }
        return false;
    }

    // Função para clonar um objeto gamepad para evitar referências compartilhadas
    function cloneGamepad(gamepad) {
        return {
            buttons: gamepad.buttons.map(button => ({ pressed: button.pressed })),
            axes: gamepad.axes.slice(0)
        };
    }

    // Event listener para quando o gamepad é conectado
    window.addEventListener("gamepadconnected", (event) => {
        const gamepad = event.gamepad;
        console.log(`Gamepad conectado: ${gamepad.id}`);
        updateGamepadStatus();
    });

    // Event listener para quando o gamepad é desconectado
    window.addEventListener("gamepaddisconnected", (event) => {
        console.log('Gamepad desconectado');
    });

    // Verifique se o gamepad já está conectado quando a página carrega
    const gamepads = navigator.getGamepads();
    for (let i = 0; i < gamepads.length; i++) {
        if (gamepads[i]) {
            updateGamepadStatus();
        }
    }
});



// function launchGame(index) {
//     fetch('/launch_game', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify({ index: index })
//     }).then(response => response.json())
//       .then(data => {
//           if (data.status === 'success') {
//               alert('Jogo iniciado com sucesso!');
//           } else {
//               alert('Erro ao iniciar o jogo: ' + data.message);
//           }
//       });
// };

// // Função para atualizar e logar o status dos botões do gamepad
// function updateGamepadStatus() {
//     const gamepads = navigator.getGamepads();
//     for (let i = 0; i < gamepads.length; i++) {
//         const gp = gamepads[i];
//         if (!gp) continue;

//         // Logar o estado dos eixos
//         gp.axes.forEach((axis, index) => {
//             console.log(`Gamepad ${i} Axis ${index}: ${axis}`);
//         });

//         // Logar o estado dos botões
//         gp.buttons.forEach((button, index) => {
//             console.log(`Gamepad ${i} Button ${index}: ${button.pressed ? 'Pressed' : 'Released'}`);
//         });
//     }
//     requestAnimationFrame(updateGamepadStatus);
// };

// // Event listener para quando o gamepad é conectado
// window.addEventListener("gamepadconnected", (event) => {
//     const gamepad = event.gamepad;
//     console.log(`Gamepad conectado: ${gamepad.id}`);
//     updateGamepadStatus();
// });

// // Event listener para quando o gamepad é desconectado
// window.addEventListener("gamepaddisconnected", (event) => {
//     console.log('Gamepad desconectado');
// });



// // document.addEventListener('DOMContentLoaded', function() {
// //     const buttons = document.querySelectorAll('.launch-button');

// //     buttons.forEach(button => {
// //         button.addEventListener('click', function() {
// //             const gameElement = this.closest('.game');
// //             const gameIndex = gameElement.getAttribute('data-index');

// //             fetch('/launch_game', {
// //                 method: 'POST',
// //                 headers: {
// //                     'Content-Type': 'application/json'
// //                 },
// //                 body: JSON.stringify({ index: gameIndex })
// //             })
// //             .then(response => response.json())
// //             .then(data => {
// //                 if (data.status === 'success') {
// //                     alert('Jogo iniciado com sucesso!');
// //                 } else {
// //                     alert('Erro ao iniciar o jogo: ' + data.message);
// //                 }
// //             })
// //             .catch(error => {
// //                 console.error('Erro:', error);
// //             });
// //         });
// //     });
// // });
