VENV=.venv-server

setup:
	python3.4 -m venv $(VENV)
	source $(VENV)/bin/activate && \
	pip install bottle pulsar

reqs: setup
	source $(VENV)/bin/activate && \
	pip freeze > requirements.txt

run: setup
	source $(VENV)/bin/activate && \
	PYTHONPATH=. python example/bottle/server.py

clean:
	-find example -type d -name "__pycache__" -exec rm -rf {} \;
