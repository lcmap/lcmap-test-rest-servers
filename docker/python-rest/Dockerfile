FROM usgs-lcmap/debian-py-rest
MAINTAINER USGS LCMAP http://eros.usgs.gov

RUN cd ~ && \
    git clone https://github.com/USGS-EROS/lcmap-test-rest-servers.git && \
    cd lcmap-test-rest-servers/python && \
    make setup

CMD cd ~/lcmap-test-rest-servers && make python