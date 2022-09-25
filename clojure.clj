(def som 
    (let [contador (atom 0)] ;; definimos o contador como um atom (variável que pode ser alterada) e iniciamos com o valor 0
      (fn [] (do (swap! contador inc) @contador) ) ;; Utilização do swap! para incrementar o contador e o @ para retornar o valor do contador
    )
  )
  
  (som) ;; 1
  (som) ;; 2  
  (som) ;; 3