(defmodule yrests-store-3
  (export all))

(include-lib "lfest/include/macros.lfe")

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