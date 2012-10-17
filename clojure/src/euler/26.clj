(ns euler.26
  (:require [euler.nt.primes :refer (sieve primitive-root?)]))

(defn primes-to-n [n]
  (take-while #(< % n) (sieve)))

(defn longest-cycle [n]
  (->> (primes-to-n n)
       (filter #(primitive-root? % 10))
       (last)))

;; Look for the largest prime under 1000 for which 10 is a primitive
;; root.
;; (longest-cycle 1000)
;; 983