build-and-deploy:
	mvn clean install -DskipTests;
	docker build -t rgs0712/box-organizer:latest .

docker-stop:
	docker-compose stop

docker-run: docker-stop build-and-deploy
	docker-compose up -d





# HOW GENERATE RS PRIVATE AND PUBLIC KEY https://cryptotools.net/rsagen
