(ns euler.nt.ent)

(defn gcd [a b]
  "Return the greatest common divisor of two integers"
  (if (zero? b) (Math/abs a) (recur b (mod a b))))

(defn coprime? [a b]
  (= 1 (gcd a b)))

(defn divisors [n]
  "Naive implementation of divisors of n"
  (filter #(zero? (mod n %)) (range 1 (inc n))))