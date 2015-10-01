VENV=.venv-server

create:
	python3.4 -m venv --without-pip $(VENV)

pip:
	. $(VENV)/bin/activate && \
	wget https://raw.githubusercontent.com/pypa/pip/develop/contrib/get-pip.py && \
	python3.4 get-pip.py

setup: create pip
	. $(VENV)/bin/activate && \
	pip install bottle pulsar
	. $(VENV)/bin/activate && \
	pip freeze > requirements.txt

run: setup
	source $(VENV)/bin/activate && \
	PYTHONPATH=. python example/bottle/server.py

clean:
	-find example -type d -name "__pycache__" -exec rm -rf {} \;
