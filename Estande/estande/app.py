from flask import Flask, render_template, jsonify, request
import os
from game_launcher import launch_game

app = Flask(__name__)

games_info = [
    {
        "name": "FIFA 2023",
        "categories": ["Esportes", "Multiplayer", "Competitivo"],
        "description": "FIFA 2023 é o mais recente título da popular série de jogos de futebol da EA Sports. Compita em ligas do mundo todo.",
        "executable_path": "C:\\Program Files (x86)\\Steam\\steamapps\\common\\BOT.vinnik Chess Early USSR Championships\\bot4_release\\Bot.vinnik Chess Early USSR Championships.exe",
        "image": "/static/images/fifa.jpg",
        "qr_code":  " ",
        "average": ""
    },
    {
        "name": "Stardew Valley",
        "categories": ["RPG", "Casual", "Indie"],
        "description": "Stardew Valley é um RPG de simulação onde você herda uma antiga fazenda e começa uma nova vida no campo.",
        "executable_path": "C:\\path\\to\\stardew_valley.exe",
        "image": "/static/images/stardew_valley.jpg",
        "qr_code":  " ",
        "average": ""
    },
    {
        "name": "Guilty Gear",
        "categories": ["Luta", "Arcade", "Competitivo"],
        "description": "Guilty Gear é um jogo de luta com gráficos impressionantes e uma jogabilidade rápida e emocionante.",
        "executable_path": "C:\\path\\to\\guilty_gear.exe",
        "image": "/static/images/guilty_gear.jpg",
        "qr_code":  " ",
        "average": ""
    },
    {
        "name": "F1 2024",
        "categories": ["Corrida", "Simulação", "Esportes"],
        "description": "F1 2024 traz a emoção das corridas de Fórmula 1 com gráficos realistas e jogabilidade intensa.",
        "executable_path": "C:\\path\\to\\f1_2024.exe",
        "image": "/static/images/f1_2024.jpg",
        "qr_code":  " ",
        "average": ""
    }
]

@app.route('/')
def index():
    return render_template('index.html', games=games_info)

@app.route('/launch_game', methods=['POST'])
def launch_game_route():
    game_index = int(request.json['index'])
    executable_path = games_info[game_index]['executable_path']
    if launch_game(executable_path):
        return jsonify({"status": "success"})
    else:
        return jsonify({"status": "error", "message": "Executable not found"}), 404

if __name__ == '__main__':
    app.run(debug=True)
