(ns euler.nt.mod)

(defn exp-mod [base n m]
  "Raise a base to the power n, take the result modulo m."
  (loop [a 1 b (mod base m) i n]
    (cond
     (zero? i) (mod a m)
     (even? i) (recur a (mod (* b b) m) (/ i 2))
     :else (recur (mod (* a b) m) b (dec i)))))