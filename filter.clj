(def dados
  [{:titulo "Livro 1", :categoria "Ficção"}
   {:titulo "Livro 2", :categoria "Não Ficção"}
   {:titulo "Livro 3", :categoria "Ficção"}
   {:titulo "Livro 4", :categoria "Não Ficção"}])

(defn filtro [arr]
  ;; Defino a variável state que tem como argumento o arr de forma atomica
  (let [state (atom arr)]
    ;; Crio uma função anônima que tem como argumento o título
    (fn [tit]
      ;; Altero o valor atomico de state com  o valor resultante da função anônima
      (swap! state (fn [s]
                     ;;Faço um filtro que recebe uma função anônima e verifica o título e retorna no s
                     (filter #(or (<= (count tit) 0)
                                  (not (nil? (re-find (re-pattern (str tit)) (:titulo %)))))
                             s)))
      (fn [cat]
        (swap! state (fn [s]
                       (filter #(or (<= (count cat) 0)
                                    (= cat (:categoria %)))
                               s)))
        @state))))



(def filtrar-dados
  (filtro dados))

(def dados-filtrados-1
  ((filtrar-dados "Livro 1")"Ficção"))


(println dados-filtrados-1)
 
