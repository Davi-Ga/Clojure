(def itens [{:valor 6 :peso 6}
            {:valor 9 :peso 6}
            {:valor 10 :peso 5}
            {:valor 5 :peso 6}
            {:valor 5 :peso 10}])
 

 (defn mochila [itens w]
   (reduce (fn [acc  cur]
             (if (<= (- (:peso cur) w) 0)
               (- w (:peso cur) (+ acc (:valor cur)))

               acc)
             ) (sort-by (fn [x] (/ (:peso x) (:valor x))) itens)))

(mochila itens 15) 