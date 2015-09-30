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

### ``make`` Targets

```bash
$ make python
```

Then load http://localhost:8080/ in your browser and access the URLs for the
given service with a browser, HTTP client, or client libraries.

The following ``curl`` examples show how to do this from the command line:

* ``curl -x GET http://localhost:8080/orders``
* ``curl -X POST http://localhost:8080/order``
* ``curl -x GET http://localhost:8080/order/123``
* ``curl -X PUT http://localhost:8080/order/123``
* ``curl -X DELETE http://localhost:8080/order/123``
* ``curl -X OPTIONS http://localhost:8080/order/123``
* ``curl -x GET http://localhost:8080/payment/order/123``
* ``curl -X PUT http://localhost:8080/payment/order/123``
* ``curl -X OPTIONS http://localhost:8080/payment/order/123``
