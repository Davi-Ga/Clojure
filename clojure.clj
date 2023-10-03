(def som 
  (let [contador (atom 0)] 
      (fn [] (swap! contador inc) @contador) 
      )
    )
    
(som) 
(som)
(som) 

