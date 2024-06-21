import pygame
import sys
import os

pygame.init()

screen_width, screen_height = 1920, 1080
screen = pygame.display.set_mode((screen_width, screen_height), pygame.FULLSCREEN)
pygame.display.set_caption("Jogos em Destaque")

BROWN = (139, 69, 19)
WHITE = (255, 255, 255)


def load_and_resize(image_path, width, height):
    image = pygame.image.load(image_path)
    return pygame.transform.scale(image, (width, height))


game_images = [
    load_and_resize('fifa.jpg', 150, 250),
    load_and_resize('fifa.jpg', 150, 250),
    load_and_resize('fifa.jpg', 150, 250),
    load_and_resize('fifa.jpg', 150, 250)
]

games_info = [
    {
        "name": "Stardew valley",
        "categories": ["Fazenda", "Relaxante", "Casual"],
        "description": " eu amo tanto esse jogo eu amo tanto esse jogo",
        "executable_path": "C:\\Program Files (x86)\\Steam\\steamapps\\common\\BOT.vinnik Chess Early USSR Championships\\bot4_release\\Bot.vinnik Chess Early USSR Championships.exe"
    },
    {
        "name": "Stardew Valley",
        "categories": ["RPG", "Casual", "Indie"],
        "description": "Stardew Valley é um RPG de simulação onde você herda uma antiga fazenda e começa uma nova vida no campo.",
        "executable_path": ""
    },
    {
        "name": "Guilty Gear",
        "categories": ["Luta", "Arcade", "Competitivo"],
        "description": "teste",
        "executable_path": ""
    },
    {
        "name": "F1 2024",
        "categories": ["Corrida", "Simulação", "Esportes"],
        "description": "teste",
        "executable_path": "C:\\path\\to\\f1_2024.exe"
    }
]

if pygame.joystick.get_count() > 0:
    joystick = pygame.joystick.Joystick(0)
    joystick.init()
else:
    print("Nenhum joystick conectado!")
    sys.exit()


def draw_interface(selected_game_index):
    screen.fill(BROWN)

    font = pygame.font.Font(None, 36)
    categories = ["uga"]
    y_pos = 50
    for category in categories:
        text = font.render(category, True, WHITE)
        screen.blit(text, (50, y_pos))
        y_pos += 40

    x_pos = 200
    for index, image in enumerate(game_images):
        if index == selected_game_index:
            pygame.draw.rect(screen, WHITE, (x_pos - 10, 140 - 10, image.get_width() + 20, image.get_height() + 20), 3)
        screen.blit(image, (x_pos, 140))
        x_pos += image.get_width() + 50

    selected_game = games_info[selected_game_index]
    y_pos = 400
    for category in selected_game["categories"]:
        text = font.render(category, True, WHITE)
        screen.blit(text, (200, y_pos))
        y_pos += 40

    description = f"Sobre: {selected_game['description']}"
    description_lines = description.split('\n')
    y_pos = screen_height - 400
    for line in description_lines:
        text = font.render(line, True, WHITE)
        screen.blit(text, (100, y_pos))
        y_pos += 20

    pygame.display.flip()


def handle_joystick_motion(axis_value, selected_game_index, last_move_time, current_time, threshold=0.5, delay=0.2):
    if axis_value < -threshold and current_time - last_move_time > delay:
        selected_game_index = (selected_game_index - 1) % len(game_images)
        last_move_time = current_time
    elif axis_value > threshold and current_time - last_move_time > delay:
        selected_game_index = (selected_game_index + 1) % len(game_images)
        last_move_time = current_time
    return selected_game_index, last_move_time


def execute_game(executable_path):
    if os.path.exists(executable_path):
        os.startfile(executable_path)
    else:
        print(f"Executable path not found: {executable_path}")


selected_game_index = 1
clock = pygame.time.Clock()
last_move_time = 0

while True:
    current_time = pygame.time.get_ticks() / 1000
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.JOYAXISMOTION:
            axis_value = joystick.get_axis(0)
            selected_game_index, last_move_time = handle_joystick_motion(axis_value, selected_game_index,
                                                                         last_move_time, current_time)
        elif event.type == pygame.JOYBUTTONDOWN:
            if joystick.get_button(0):
                selected_game = games_info[selected_game_index]
                print(f"Você escolheu abrir o jogo: {selected_game['name']}")
                execute_game(selected_game['executable_path'])

    draw_interface(selected_game_index)
    clock.tick(60)
