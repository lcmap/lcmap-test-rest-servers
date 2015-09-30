.PHONY: python lfe clojure

python:
	cd python && make run

lfe: lfe/deps
	cd lfe && make dev

lfe/deps:
	cd lfe && make compile

clean:
	-cd python && make clean
	-cd lfe && make clean
	-cd clojure && make clean
