(def som 
  (let [contador (atom 0)] 
      (fn [] (swap! contador inc) @contador) 
      )
    )
    ;; acessar variaveis fora do escopo 
    
(som) 
(som)
(som) 

