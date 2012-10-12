(ns euler.52
  (:require [euler.misc :refer (digits)]))

(defn same-k-digits? [k n]
  (let [fns (->> (range 1 (inc k)) (map #(fn [n] (* n %))))
        sd (comp set digits)]
    (= (sd n)
       (->> n
            ((apply juxt fns))
            (map sd)
            (reduce into #{})))))

(defn first-same-k-digits [k]
  (->> (iterate inc 1)
       (filter (partial same-digits? k))
       (first)))

(first-same-k-digits 6)
;; 142857