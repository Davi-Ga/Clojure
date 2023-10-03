(defn tap [value]
  (fn [fn]
    (if (fn? fn)
      (fn value)
      (throw (IllegalArgumentException. "A segunda argumento deve ser uma função")))))

((tap 'função') (fn [x] (+ x x)))
