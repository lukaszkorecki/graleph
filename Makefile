build:
	time docker build . -t graleph:latest

run:
	docker run --net host --rm -it graleph:latest

gen-stats:
	./script/gen-metrics
