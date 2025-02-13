sudo chmod -R a+rwx /data/vhs_mysql_dbms/

export MYSQL_USER=root
export MYSQL_ROOT_PASSWORD=$(cat ./.mysql_password)

docker-compose up -d

sleep 5

# Optional
while [ "$(docker exec vhs_mysql_dbms mysqladmin --user=$MYSQL_USER --password=$MYSQL_ROOT_PASSWORD ping --silent)" != "" ] ;
do
	echo "MYSQL Server is being initialised ...."
	sleep 1
done

echo "MYSQL Server is ready"

docker-compose logs -f
#docker exec -it vhs_mysql_dbms service mysql restart || true

#docker exec -it vhs_mysql_dbms mysql --user=root --password=$MYSQL_ROOT_PASSWORD
#docker exec -it vhs_mysql_dbms mysql --user=root --password=$MYSQL_ROOT_PASSWORD < path-to-file.sql
