(ns euler.10
  (:require [euler.primes :refer (sieve)]))

(def primes (sieve))

(defn sum-primes [n]
  (->> primes
       (take-while #(< % n))
       (apply +)))

;; (sum-primes 2000000)
;; 142913828922

