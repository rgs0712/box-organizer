build-and-deploy:
	mvn clean install;
	docker build -t rgs0712/box-organizer .