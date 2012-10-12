(ns euler.combinatorics)

(defn factorial [n]
  (apply * (range 1 (inc n))))

(defn choose-n-k [n k]
  "Compute the binomial coeffiecient 'n choose k' with the factorial
formula."
  (if (< k (/ n 2))
    (/ (apply * (map inc (range (- n k) n))) (factorial k))
    (/ (apply * (map inc (range k n))) (factorial (- n k)))))

(defn choose-n-k-recursive [n k]
  "Compute the binomial coeffiecient 'n choose k' with the recursive
formula."
  (cond
   (zero? k) 1
   (zero? n) 0
   :else (+ (choose-n-k-recursive (dec n) (dec k))
            (choose-n-k-recursive (dec n) k))))

(defn catalan [n]
  "Compute the nth Catalan number."
  (->> (range (inc n))
       (map (comp #(* % %) (partial choose-n-k-recursive n)))
       (apply +)
       (* (/ 1 (inc n)))))