from pathlib import Path
from tkinter import Tk, Canvas, PhotoImage
import pygame
import sys

# Initialize Pygame
pygame.init()

# Check for joystick
if pygame.joystick.get_count() > 0:
    joystick = pygame.joystick.Joystick(0)
    joystick.init()
else:
    print("No joystick connected!")
    sys.exit()

# Tkinter setup
OUTPUT_PATH = Path(__file__).parent
ASSETS_PATH = OUTPUT_PATH / Path(r"C:\Users\lucas\Documents\GitHub\ProjetoES_AtitusCC\build\assets\frame0")

def relative_to_assets(path: str) -> Path:
    return ASSETS_PATH / Path(path)

window = Tk()
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

image_image_1 = PhotoImage(file=relative_to_assets("image_1.png"))
image_1 = canvas.create_image(960.0, 540.0, image=image_image_1)

image_image_2 = PhotoImage(file=relative_to_assets("image_2.png"))
image_2 = canvas.create_image(961.0, 115.0, image=image_image_2)

image_image_3 = PhotoImage(file=relative_to_assets("image_3.png"))
image_3 = canvas.create_image(197.0, 504.0, image=image_image_3)

image_image_4 = PhotoImage(file=relative_to_assets("image_4.png"))
image_4 = canvas.create_image(569.0, 504.0, image=image_image_4)

image_image_5 = PhotoImage(file=relative_to_assets("image_5.png"))
image_5 = canvas.create_image(1347.0, 504.0, image=image_image_5)

image_image_6 = PhotoImage(file=relative_to_assets("image_6.png"))
image_6 = canvas.create_image(960.0, 504.0, image=image_image_6)

image_image_7 = PhotoImage(file=relative_to_assets("image_7.png"))
image_7 = canvas.create_image(1718.0, 514.0, image=image_image_7)

canvas.create_text(
    775.0,
    746.0,
    anchor="nw",
    text="Stardew Valley",
    fill="#FFFFFF",
    font=("Inter Bold", 50 * -1)
)

canvas.create_text(
    806.0,
    816.0,
    anchor="nw",
    text="Sobre:\nStardew Valley é um RPG sem fim da\nvida no campo! Você herdou a antiga\nfazenda de seu avô Ver mais ",
    fill="#F9FBC7",
    font=("Inter", 26 * -1)
)

image_image_8 = PhotoImage(file=relative_to_assets("image_8.png"))
image_8 = canvas.create_image(833.0, 1002.0, image=image_image_8)

image_image_9 = PhotoImage(file=relative_to_assets("image_9.png"))
image_9 = canvas.create_image(960.0, 1002.0, image=image_image_9)

image_image_10 = PhotoImage(file=relative_to_assets("image_10.png"))
image_10 = canvas.create_image(1087.0, 1002.0, image=image_image_10)

canvas.create_text(
    804.0,
    1037.0,
    anchor="nw",
    text="Nota média ",
    fill="#F9FBC7",
    font=("Inter", 22 * -1)
)

image_image_11 = PhotoImage(file=relative_to_assets("image_11.png"))
image_11 = canvas.create_image(953.0, 1052.0, image=image_image_11)

image_image_12 = PhotoImage(file=relative_to_assets("image_12.png"))
image_12 = canvas.create_image(986.858154296875, 1052.0, image=image_image_12)

image_image_13 = PhotoImage(file=relative_to_assets("image_13.png"))
image_13 = canvas.create_image(1020.716552734375, 1052.0, image=image_image_13)

image_image_14 = PhotoImage(file=relative_to_assets("image_14.png"))
image_14 = canvas.create_image(1054.574951171875, 1052.0, image=image_image_14)

image_image_15 = PhotoImage(file=relative_to_assets("image_15.png"))
image_15 = canvas.create_image(1088.433349609375, 1052.0, image=image_image_15)

# List of images for navigation
image_elements = [image_image_3, image_image_4, image_image_6, image_image_5, image_image_7]

# Coordinates of images for navigation
image_coords = [(197, 504), (569, 504), (960, 504), (1347, 504), (1718, 514)]

selected_index = 0
highlighted_item = None

def highlight_selected():
    global highlighted_item
    if highlighted_item is not None:
        canvas.delete(highlighted_item)
    x_pos, y_pos = image_coords[selected_index]
    width, height = 312.71, 450
    highlighted_item = canvas.create_rectangle(
        x_pos - width / 2, y_pos - height / 2,
        x_pos + width / 2, y_pos + height / 2,
        outline="white", width=5
    )

def handle_dpad_motion(hat_value):
    global selected_index
    if hat_value == (-1, 0):  # Left
        selected_index = (selected_index - 1) % len(image_elements)
        print(f"Moved left to index: {selected_index}")
    elif hat_value == (1, 0):  # Right
        selected_index = (selected_index + 1) % len(image_elements)
        print(f"Moved right to index: {selected_index}")
    highlight_selected()

def handle_gamepad_input():
    for event in pygame.event.get():
        if event.type == pygame.JOYHATMOTION:
            hat_value = joystick.get_hat(0)
            print(f"D-pad hat value: {hat_value}")
            handle_dpad_motion(hat_value)
        elif event.type == pygame.JOYBUTTONDOWN:
            if joystick.get_button(0):  # Example: A button on Xbox controller
                selected_image = image_elements[selected_index]
                print(f"Selected image: {selected_image}")

    window.after(100, handle_gamepad_input)

# Schedule the gamepad input handler
window.after(100, handle_gamepad_input)

highlight_selected()
window.resizable(False, False)
window.mainloop()

# Quit Pygame when the window is closed
pygame.quit()
