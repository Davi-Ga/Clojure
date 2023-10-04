(defn tap [value]
  (fn [fn]
    (if (fn? fn)
      (fn value)
      (throw (IllegalArgumentException. "A segunda argumento deve ser uma função")))))

((tap 5) (fn [x] (+ x x)))

;;acessar a função sendo definida fora de def, pq ela é criada na hr