(ns euler.primes)

(defn sieve []
  "Sieve of Eratosthenes"
  (letfn [(enqueue [sieve n step]
            (let [m (+ n step)]
              (if (sieve m)
                (recur sieve m step)
                (assoc sieve m step))))
          (next-sieve [sieve candidate]
            (if-let [step (sieve candidate)]
              (-> sieve
                  (dissoc candidate)
                  (enqueue candidate step))
              (enqueue sieve candidate (+ candidate candidate))))
          (next-primes [sieve candidate]
            (if (sieve candidate)
              (recur (next-sieve sieve candidate) (+ candidate 2))
              (cons candidate 
                    (lazy-seq (next-primes (next-sieve sieve candidate) 
                                           (+ candidate 2))))))]
    (cons 2 (lazy-seq (next-primes {} 3)))))

(defn val-p-fact [n p]
  "p-adic valuation of n!"
  (->> (iterate #(* p %) p)
       (map #(Math/floor (/ n %)))
       (take-while #(not (zero? %)))
       (apply +)))
