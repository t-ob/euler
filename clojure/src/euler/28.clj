(ns euler.28)

(defn spiral-steps [k]
  (->> (iterate #(+ 2 %) 2)
       (map #(repeat 4 %))
       (take k)
       (apply concat)))

(defn spiral-sum [k]
  "Calculate sum of diagonals on a (2k+1)x(2k+1) spiral."
  (->> (spiral-steps k)
       (reductions + 1)
       (apply +)))

; 1001 = 2 * 500 + 1
; (spiral-sum 500)
; 669171001