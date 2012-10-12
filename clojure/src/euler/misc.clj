(ns euler.misc)

(defn digits
  ([n]
     "Return a list of the digits of n in base 10."
     (digits n 10))
  ([n b]
     "Return a list of the digits of n in base b."
     (loop [a () x n]
       (if (zero? x)
         a
         (recur (conj a (mod x b)) (quot x b))))))