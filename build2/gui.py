from pathlib import Path
import tkinter as tk
from tkinter import Canvas, PhotoImage
import pygame
import subprocess


# Initialize Pygame
pygame.init()

# Check for joystick
if pygame.joystick.get_count() > 0:
    joystick = pygame.joystick.Joystick(0)
    joystick.init()
else:
    print("No joystick connected!")
    exit()

# Tkinter setup
OUTPUT_PATH = Path(__file__).parent
ASSETS_PATH = OUTPUT_PATH / Path(r"C:\Users\lucas\Desktop\Tkinter-Designer-master\Tkinter-Designer-master\build2\assets\frame0")


def relative_to_assets(path: str) -> Path:
    return ASSETS_PATH / Path(path)



window = tk.Tk()

window.attributes('-fullscreen', True)
window.configure(bg="#000000")

canvas = Canvas(
    window,
    bg="#000000",
    height=1080,
    width=1920,
    bd=0,
    highlightthickness=0,
    relief="ridge"
)
canvas.place(x=0, y=0)

# Load images
image_image_1 = PhotoImage(file=relative_to_assets("image_1.png"))
image_1 = canvas.create_image(960.0, 543.0, image=image_image_1)

image_image_2 = PhotoImage(file=relative_to_assets("image_2.png"))
image_2 = canvas.create_image(960.0, 112.0, image=image_image_2)

image_image_3 = PhotoImage(file=relative_to_assets("image_3.png"))
image_3 = canvas.create_image(960.0, 570.0, image=image_image_3)

canvas.create_text(
    1332.0,
    716.0,
    anchor="nw",
    text="Nota média ",
    fill="#F9FBC7",
    font=("Inter", 22 * -1)
)

image_image_4 = PhotoImage(file=relative_to_assets("image_4.png"))
image_4 = canvas.create_image(1496.0, 741.0, image=image_image_4)

image_image_5 = PhotoImage(file=relative_to_assets("image_5.png"))
image_5 = canvas.create_image(1530.0, 741.0, image=image_image_5)

image_image_6 = PhotoImage(file=relative_to_assets("image_6.png"))
image_6 = canvas.create_image(1564.0, 741.0, image=image_image_6)

image_image_7 = PhotoImage(file=relative_to_assets("image_7.png"))
image_7 = canvas.create_image(1598.0, 741.0, image=image_image_7)

image_image_8 = PhotoImage(file=relative_to_assets("image_8.png"))
image_8 = canvas.create_image(1632.0, 741.0, image=image_image_8)

canvas.create_text(
    1333.0,
    779.0,
    anchor="nw",
    text="500 horas jogadas",
    fill="#F9FBC7",
    font=("Inter", 22 * -1)
)

canvas.create_text(
    1332.0,
    831.0,
    anchor="nw",
    text="Jogado 45 vezes nos últimos 30 dias",
    fill="#F9FBC7",
    font=("Inter", 22 * -1)
)

image_image_9 = PhotoImage(file=relative_to_assets("image_9.png"))
image_9 = canvas.create_image(1743.0, 669.0, image=image_image_9)

image_image_10 = PhotoImage(file=relative_to_assets("image_10.png"))
image_10 = canvas.create_image(1381.0, 669.0, image=image_image_10)

image_image_11 = PhotoImage(file=relative_to_assets("image_11.png"))
image_11 = canvas.create_image(1562.0, 669.0, image=image_image_11)

image_image_12 = PhotoImage(file=relative_to_assets("image_12.png"))
image_12 = canvas.create_image(1520.0, 531.0, image=image_image_12)

image_image_13 = PhotoImage(file=relative_to_assets("image_13.png"))
image_13 = canvas.create_image(1523.0, 323.0, image=image_image_13)

canvas.create_text(
    82.0,
    266.0,
    anchor="nw",
    text="Sobre",
    fill="#F9FBC7",
    font=("Inter", 44 * -1)
)

image_image_14 = PhotoImage(file=relative_to_assets("image_14.png"))
image_14 = canvas.create_image(358.0, 349.0, image=image_image_14)

canvas.create_text(
    82.0,
    349.0,
    anchor="nw",
    text="\nStardew Valley é um RPG sem fim da vida no\ncampo! Você herdou a antiga fazenda de\nseu avô no Vale do Orvalho. Equipado com\nferramentas de segunda mão e algumas\nmoedas, você irá começar sua nova vida.\nSerá que você consegue aprender a viver da\nterra e transformar esses campos\nabsurdamente vegetados em uma casa\npróspera? Não vai ser fácil. Desde que\nCorporação Joja veio à cidade, os antigos\nmodos de vida quase desapareceram. O\nCentro Comunitário, uma vez o lugar mais\nvisitado da cidade,agora está em ruínas.\nMas o vale parece cheio de oportunidades.\nCom um pouco de dedicação, você pode ser\na pessoa que restaurará a grandeza do Vale\ndo Orvalho!",
    fill="#FFFFFF",
    font=("Inter", 26 * -1)
)

# List of images for navigation
images = [image_12, image_13]

selected_index = 0
highlight_rectangle = None

def highlight_selected_image():
    global highlight_rectangle
    canvas.delete("highlight")  # Delete previous highlight
    x, y = canvas.coords(images[selected_index])
    width, height = image_image_12.width(), image_image_12.height()  # Assuming all images have the same size
    highlight_rectangle = canvas.create_rectangle(
        x - width / 2, y - height / 2,
        x + width / 2, y + height / 2,
        outline="white", width=5, tag="highlight"
    )




def execute_game():
        game_path = "D:\SteamLibrary\steamapps\common\Stardew Valley\Stardew Valley.exe"
        subprocess.run([game_path])


def handle_dpad_motion(hat_value):
    global selected_index
    if hat_value == (-1, 0):  # D-pad left
        selected_index = (selected_index - 1) % len(images)
        print(f"Moved left to index: {selected_index}")
    elif hat_value == (1, 0):  # D-pad right
        selected_index = (selected_index + 1) % len(images)
        print(f"Moved right to index: {selected_index}")
    highlight_selected_image()

def substitute_image_3():
    global image_3
    new_photoimage = PhotoImage(file=r'C:\Users\lucas\Documents\GitHub\ProjetoES_AtitusCC\build2\assets\frame0\qrcode-stardew.png')
    canvas.itemconfig(image_3, image=new_photoimage)
    larger_image = image_3.zoom(25)

# Function to handle gamepad input
def handle_gamepad_input():
    global window
    for event in pygame.event.get():
        if event.type == pygame.JOYHATMOTION:
            hat_value = joystick.get_hat(0)
            print(f"D-pad hat value: {hat_value}")
            handle_dpad_motion(hat_value)
        elif event.type == pygame.JOYBUTTONDOWN:
            if joystick.get_button(0) and selected_index == 1:  # Assuming button 0 is the "a" button
                execute_game()
            elif joystick.get_button(0) and selected_index == 0:
                substitute_image_3()

    window.after(100, handle_gamepad_input)


# Start gamepad input handling
handle_gamepad_input()

# Start Tkinter main loop
window.mainloop()

# Quit Pygame when the window is closed
pygame.quit()
