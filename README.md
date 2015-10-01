# Test REST Servers

*REST Servers for Load-testing and Prototyping*

This project defines a set of REST service routes similar to what might be found
in a REST API server. However, as these are for testing purposes, the REST
resources do not connect with any implemented backend. Instead, they are
intended to be accessed via web browsers, HTTP clients, or REST client
libraries.

To date, this project includes the following REST HTTP servers:

* Python: Bottle running on Python Pulsar
* LFE: lfest routes defined for YAWS
* Clojure: Compojure running on http-kit

## URL Schemas

All of the REST HTTP server test APIs define the following resources, each
with identical behaviour:

* ``GET`` for ``/orders``
* ``POST`` for ``/order``
* ``GET`` for ``/order/n``
* ``PUT`` for ``/order/n``
* ``DELETE`` for ``/order/n``
* ``OPTIONS`` for ``/order/n``
* ``GET`` for ``/payment/order/n``
* ``PUT`` for ``/payment/order/n``
* ``OPTIONS`` for ``/payment/order/n``

In the above, ``n`` is simply whatever ID you wish to provide.

## Usage

Once a given service is running, you can load http://localhost:8080/ in your
browser and access the URLs for the given service with a browser, HTTP client,
or client libraries.

The following ``curl`` examples show how to do this from the command line:

* ``curl -X GET http://localhost:8080/orders``
* ``curl -X POST http://localhost:8080/order``
* ``curl -X GET http://localhost:8080/order/123``
* ``curl -X PUT http://localhost:8080/order/123``
* ``curl -X DELETE http://localhost:8080/order/123``
* ``curl -X OPTIONS http://localhost:8080/order/123``
* ``curl -X GET http://localhost:8080/payment/order/123``
* ``curl -X PUT http://localhost:8080/payment/order/123``
* ``curl -X OPTIONS http://localhost:8080/payment/order/123``

### ``make`` Targets

```bash
$ make python
```

```bash
$ make lfe
```

```bash
$ make clojure
```

### ``Dockerfile``s

#### Setup

To use the ``Dockerfile``s included in this repo to run the example REST
servers, you will need to build the appropriate images in the
[LCMAP Dockerfiles](https://github.com/USGS-EROS/lcmap-dockerfiles)
repository:

```bash
$ git clone https://github.com/USGS-EROS/lcmap-dockerfiles.git
$ cd lcmap-dockerfiles
$ make debian-rest
```

When that completes, you will have the images you will need. You can view them
with the following:

```bash
$ docker images|egrep 'usgs-lcmap/debian*'
```

At this point, you are ready to build the testing REST Docker images:

```bash
$ make docker
```

#### Running Containers

If you are on Mac OS X using ``boot2docker``, you will need to set up
port-forwarding to access the running REST server:

```bash
$ boot2docker ssh -L 8080:127.0.0.1:8080
```

The Docker commands for running the individual containers are wrapped by
``make`` targets for each:

```bash
$ make docker-python
```

```bash
$ make docker-lfe
```

```bash
$ make docker-clojure
```

Once you have a containerized service running, you should be able to test the
REST service resources just like you did when they ran natively on your machine:

```bash
$ curl -X GET http://localhost:8080/orders
```

etc.
