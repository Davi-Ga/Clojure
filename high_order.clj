(def data
  [{:i 15, :f 16}
   {:i 8, :f 9}
   {:i 10, :f 12}
   {:i 9, :f 10}])

(defn ordenar-e-verificar [dados]
  (reduce (fn [acc cur]
            (if (and (>= (:i cur) (:i acc)) (<= (:i cur) (:f acc)))
            ;; if ((:i cur) >= (:i acc) and (:i cur) <= (:f acc))
              (if (>= (:f cur) (:f acc))
              ;; if (:f cur) >= (:f acc)
                cur
                ;; return cur
                ;; else
                acc)
                ;; return acc
                
              (if (>= (:i cur) (:f acc))
              ;; if (:i cur) >= (:f acc)
                cur
                ;; return cur
                ;; elses
                acc)
                ;; return acc
                )) (sort-by :i dados)))
                ;; ordena 

(ordenar-e-verificar data)

