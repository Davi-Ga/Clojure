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