.PHONY: python lfe clojure docker

python:
	cd python && make run

lfe: lfe/deps
	cd lfe && make dev

lfe/deps:
	cd lfe && make compile

clojure:
	cd clojure && make run

clean:
	-cd python && make clean
	-cd lfe && make clean
	-cd clojure && make clean
	@-docker rm $(shell docker ps -a -q)
	@-docker rmi $(shell docker images -q --filter 'dangling=true')

docker:
	docker build -t usgs-lcmap/test-py-rest docker/python-rest
	docker build -t usgs-lcmap/test-lfe-rest docker/lfe-rest
	docker build -t usgs-lcmap/test-clj-rest docker/clojure-rest

docker-python:
	docker run -p 8080:8080 -t usgs-lcmap/test-py-rest

docker-lfe:
	docker run -p 8080:8080 -t usgs-lcmap/test-lfe-rest

docker-clojure:
	docker run -p 8080:8080 -t usgs-lcmap/test-clj-rest
