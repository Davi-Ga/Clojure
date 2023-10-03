(def data
  [{:i 15, :f 16}
   {:i 8, :f 9}
   {:i 10, :f 12}
   {:i 9, :f 10}])

(defn ordenar-e-verificar [dados]
  (reduce (fn [acc cur]
            (if (and (>= (:i cur) (:i acc)) (<= (:i cur) (:f acc)))
              (if (>= (:f cur) (:f acc))
                cur
                acc)
              (if (>= (:i cur) (:f acc))
                cur
                acc))) (sort-by :i dados)))

(ordenar-e-verificar data)

