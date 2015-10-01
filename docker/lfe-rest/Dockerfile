FROM usgs-lcmap/debian-lfe-rest
MAINTAINER USGS LCMAP http://eros.usgs.gov

RUN cd ~ && \
    git clone https://github.com/USGS-EROS/lcmap-test-rest-servers.git && \
    cd lcmap-test-rest-servers/lfe && \
    make compile

CMD cd ~/lcmap-test-rest-servers && make lfe