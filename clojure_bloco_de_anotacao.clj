(ns carro.core
  (:gen-class))

;;==================================================
;;exemplo de high order function

(defn double-+
  [a b]
  (* 2 (+ a b))
)

(filter even? (range 0 10)) ;; a função interna é executada antes do que a interna (even == número par )


;;filtrar bandas de Rock
(def bands [
  {:name "Brown Beaters"   :genre :rock}
  {:name "Sunday Sunshine" :genre :blues}
  {:name "Foolish Beaters" :genre :rock}
  {:name "Monday Blues"    :genre :blues}
  {:name "Friday Fewer"    :genre :blues}
  {:name "Saturday Stars"  :genre :jazz}
  {:name "Sunday Brunch"   :genre :jazz}
])

(filter #(= :rock (:genre %)) bands)




;;==================================================
;; exemplo de closure function
(def som 
  (let [contador (atom 0)] ;; definimos o contador como um atom (variável que pode ser alterada) e iniciamos com o valor 0
    (fn [] (do (swap! contador inc) @contador) ) ;; Utilização do swap! para incrementar o contador e o @ para retornar o valor do contador
  )
)

(som) ;; 1
(som) ;; 2  
(som) ;; 3


;;==================================================
;;exemplo de functors
(defn maisum
  [x] ;; x é o valor que será passado para a função
  (map inc x) ;; incrementa cada elemento da lista e retorna uma nova lista com os valores incrementados
)

(map inc [1 2 3 4 5]) ;;[2 3 4 5 6] Incrementa cada elemento da lista


;;==================================================
;;exemplo de currying/partials function

(defn sum
  [x y] ;; x e y são os valores que serão passados para a função
  (+ x y) ;; soma os valores de x e y
)

;; ;; exemplo funcional
(map (partial sum 10) [1 3 5 7 9]) ;;[11 13 15 17 19] soma 10 com cada elemento da lista, utilizamos o map para retornar uma nova lista e o partial para passar o valor 10 para a função sum

;; ;; exemplo que não funciona, pois o valor 10 não é passado para a função devido ao partial
;; (reduce + [1 2 5 5 6 1])





;;==================================================
;; funcao main
(defn -main
  "I don't do a whole lot."
  [& args ]
  (println  "Hello, World!")
  (println (sum 5 4)))


