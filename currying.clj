(defn sum
    [x y] ;; x e y são os valores que serão passados para a função
    (+ x y) ;; soma os valores de x e y
  )
  
  ;; ;; exemplo funcional
  (map (partial sum 10) [1 3 5 7 9]) ;;[11 13 15 17 19] soma 10 com cada elemento da lista, utilizamos o map para retornar uma nova lista e o partial para passar o valor 10 para a função sum
  
  ;; ;; exemplo que não funciona, pois o valor 10 não é passado para a função devido ao partial