(defn add [x y z]
  (+ x y z))

(defn curry [f]
  (fn [x]
    (fn [y]
      (fn [z]
        (f x y z)))))


(def curried-add (curry add))

(println (((curried-add 2) 2) 2)) 

;;função fragmentada, cada função é responsavel por um argunmento


