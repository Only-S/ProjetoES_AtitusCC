import os
import subprocess

def launch_game(executable_path):
    if os.path.exists(executable_path):
        subprocess.Popen([executable_path], shell=True)
        return True
    else:
        return False
