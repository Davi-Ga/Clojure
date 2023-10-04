(def dados
  [{:titulo "Livro 1", :categoria "Ficção"}
   {:titulo "Livro 2", :categoria "Não Ficção"}
   {:titulo "Livro 3", :categoria "Ficção"}
   {:titulo "Livro 4", :categoria "Não Ficção"}])

(defn filtro [arr]
  (let [state (atom arr)]
    (fn titulo [tit]
      (swap! state (fn titulo [s]
                     [](filter #(or (<= (count tit) 0)
                                  (not (nil? (re-find (re-pattern (str tit)) (:titulo %)))))
                             s)))
      (fn [fcomp]
        (swap! state (fn compara [s]
                       (filter #(or (nil? fcomp)
                                    (fcomp (:categoria %)))
                               s)))
        (fn [cat]
          (swap! state (fn categoria[s]
                         (filter #(or (<= (count cat) 0)
                                      (= cat (:categoria %)))
                                 s)))
          @state)))))



(def filtrar-dados
  (filtro dados))

(def dados-filtrados-1
  (filtrar-dados "Livro 1"))

(println dados-filtrados-1)
 
