(ns euler.123
  (:require [euler.nt.primes :refer sieve]))

(def primes (sieve))

(let [x (- 10 (Math/log10 2))]
  (->> primes
       (map #(Math/log10 %))
       (map vector (->> (iterate inc 1) (map #(Math/log10 %))))
       (map #(apply + %))
       (take-while #(<= % x))
       (count)
       (inc)))

;; 21034
;; Answer must be odd => 21035

