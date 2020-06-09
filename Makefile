build:
	docker build . -t graleph:latest

gen-stats:
	./script/gen-metrics
