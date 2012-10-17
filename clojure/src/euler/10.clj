(ns euler.10
  (:require [euler.nt.primes :refer (sieve)]))

(def primes (sieve))

(defn sum-primes [n]
  (->> primes
       (take-while #(< % n))
       (apply +)))

;; (sum-primes 2000000)
;; 142913828922

