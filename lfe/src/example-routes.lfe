(defmodule example-routes
  (export all))

(include-lib "lfest/include/lfest-routes.lfe")

(defroutes
  ('GET "/orders" "<h1>All Current Orders:</h1>")
  ('POST "/order" "<h1>Order placed.</h1>")
  ('GET "/order/:id" (lambda (id) (++ "<h2>Order " id " is not ready.</h2>")))
  ('PUT "/order/:id" (lambda (id) (++ "<h2>Received update for Order " id "</h2>")))
  ('DELETE "/order/:id" (lambda (id) (++ "<h2>All done with Order " id "</h2>")))
  ('OPTIONS "/order/:id" (lambda (id) (++ "<h2>That order is allowed to...</h2>")))
  ('GET "/payment/order/:id" (lambda (id) (++ "<h2>Payment Status</h2>")))
  ('PUT "/payment/order/:id" (lambda (id) (++ "<h2>Paid for Order " id "</h2>")))
  ('OPTIONS "/payment/order/:id" "<h2>That payment can be...</h2>"))

(defun out (arg-data)
  "This is called by YAWS when the requested URL matches the URL specified in
  the YAWS config (see ./etc/yaws.conf) with the 'appmods' directive for the
  virtual host in question.

  In particular, this function is intended to handle all v1 traffic for this
  REST API."
  (let ((method-name (lfest:get-http-method arg-data))
        (path-info (lfest:get-path-info arg-data)))
    (routes method-name path-info arg-data)))