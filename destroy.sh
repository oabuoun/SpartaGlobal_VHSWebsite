docker-compose stop
docker-compose rm
sudo rm -rf /data/vhs_mysql_dbms/*
sudo chown $(echo $USER) -R /data/vhs_mysql_dbms
