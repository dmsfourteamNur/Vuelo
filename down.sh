#!/bin/bash


# █▀▀ █▀█ █▄░█ ▀█▀ █▀▀ █▄░█ █▀▀ █▀█ █▀▄ █▀█ █▀█
# █▄▄ █▄█ █░▀█ ░█░ ██▄ █░▀█ ██▄ █▀▄ █▄▀ █▄█ █▀▄
# Parar todos los contenedores:
docker stop $(docker ps -a -q)
# Eliminar todos los contenedores
docker rm $(docker ps -a -q)
# Enumerar contenedores
docker ps -a

# █ █▀▄▀█ ▄▀█ █▀▀ █▀▀ █▀
# █ █░▀░█ █▀█ █▄█ ██▄ ▄█
# Eliminar todas las imágenes de docker
docker rmi $(docker images -q)
docker images


# █▀▀ █░░ █▀▀ ▄▀█ █▄░█   █▀▄ █▀█ █▄▀ █▀▀ █▀█
# █▄▄ █▄▄ ██▄ █▀█ █░▀█   █▄▀ █▄█ █░█ ██▄ █▀▄
# docker system prune -a


# 📛 Stop and remove containers, networks
# sudo docker-compose down
# 🔇 Remove all unused local volumes
# sudo docker volume prune -a
# 🌐 Remove all unused networks
#sudo docker network prune
# ❌📸 Remove unused images
# sudo docker image prune -a
#sudo docker system prune -a