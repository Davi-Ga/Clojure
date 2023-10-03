(defn zip [a b fn]
  (mapv fn a b))

(zip [1 4 9 16] [2 3 5 6] (fn [x y] (+ x y)))