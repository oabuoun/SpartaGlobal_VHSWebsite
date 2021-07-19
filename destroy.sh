docker-compose stop
docker-compose rm
sudo rm -rf /data/mysql/*
sudo chown $(echo $USER) -R /data/mysql
