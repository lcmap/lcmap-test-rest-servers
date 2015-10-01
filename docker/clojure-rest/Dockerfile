FROM usgs-lcmap/debian-clj-rest
MAINTAINER USGS LCMAP http://eros.usgs.gov

RUN cd ~ && \
    git clone https://github.com/USGS-EROS/lcmap-test-rest-servers.git && \
    cd lcmap-test-rest-servers/clojure && \
    lein deps && \
    lein compile

CMD cd ~/lcmap-test-rest-servers && make clojure
