(ns euler.15
  (:require [euler.combinatorics :refer (catalan)]))

(defn f [n]
  "Calculate the number of paths on an n x n grid from top-left to
bottom-right corner."
  (* (inc n) (catalan n)))

; (f 20)
; 1048576
