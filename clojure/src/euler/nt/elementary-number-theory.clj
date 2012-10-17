(ns euler.elementary-number-theory)

(defn gcd [a b]
  "Return the greatest common divisor of two integers"
  (if (zero? b) (Math/abs a) (recur b (mod a b))))