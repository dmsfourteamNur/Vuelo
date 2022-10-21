#!/bin/bash

sudo ufw enable
sudo ufw allow 80
sudo ufw allow 81
sudo ufw allow 22
sudo ufw allow 27017
sudo ufw allow 5672
sudo ufw allow 15672
sudo ufw allow 5080
sudo ufw allow 7080
sudo ufw status
#sudo ufw disable
#enable permissions
#chmod u+r+x ./vuelo/compile.sh
#chmod u+r+x deploy.sh
