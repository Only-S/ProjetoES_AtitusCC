import os
import subprocess
import threading
import logging

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(message)s')


def launch_game(executable_path):
    if os.path.exists(executable_path):
        process = subprocess.Popen([executable_path], shell=True)

        logging.info(f'Jogo iniciado: {executable_path}')

        timer = threading.Timer(10.0, terminate_process_by_name, [os.path.basename(executable_path)])
        timer.start()

        return True
    else:
        return False


def terminate_process_by_name(process_name):
    logging.info(f'Encerrando o jogo {process_name} após 30 segundos')
    try:
        subprocess.run(["taskkill", "/F", "/IM", process_name], check=True)
        logging.info(f'Jogo {process_name} encerrado com sucesso')
    except subprocess.CalledProcessError as e:
        logging.error(f'Erro ao encerrar o jogo {process_name}: {e}')
