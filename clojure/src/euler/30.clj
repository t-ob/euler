(ns euler.30
  (:require [euler.misc :refer (digits)]))

(defn sum-digits-kth-power [k n]
  (->> n
       (digits)
       (map #(Math/pow % k))
       (apply +)
       (int)))

;; a0 + a1*10 + a2*10^2 + ... + an*10^n
;;
;; n <= a0^5 + a1^5 + ... + an^5 <= n(9^5) = 59049n = 59049*10^(log n)
;; 59049n < 1/9 (10^(n+1) - 1)
;; 531441n < 10^(n+1) - 1 < 10^(n+1)
;; log(531441) + log(n) < n + 1
;; n - log(n) > log(531441) - 1 = 4.725
;; n >= 6 upper bound

(->> (range 2 1000000)
     (filter #(= % (sum-digits-kth-power 5 %)))
     (apply +))

;; 443839