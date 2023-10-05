(def itens [{:valor 6 :peso 6}
            {:valor 9 :peso 6}
            {:valor 10 :peso 5}
            {:valor 5 :peso 6}
            {:valor 5 :peso 10}
            ])

(defn mochila [itens peso-maximo]
  ;; Crio um array de variáveis e atribuo o valor do reduce a elas
    (let [[itens-na-mochila, valor-total]
          (reduce
           ;; função anonima que possui argumentos o array itens na mochila e valor total e item
           (fn [[itens-na-mochila valor-total] item]
             ;;A função map é usada para criar uma sequência com os pesos de cada item na mochila atual. 
             ;;Em seguida, a função reduce é usada para somar os pesos da sequência.
             ;;O resultado da soma é adicionado ao peso do item atual, que é armazenado na variável novo-peso.
             (let [novo-peso (+ (reduce + (map :peso itens-na-mochila)) (:peso item))]
               (if (<= novo-peso peso-maximo)
                 ;; Se o novo peso for menor ou igual ao peso máximo, o item é adicionado à mochila e o valor total é atualizado.
                 [(conj itens-na-mochila item) (+ valor-total (:valor item))]
                 [itens-na-mochila valor-total])))
           [[] 0] ;; Valor inicial
           (sort-by (fn [item] (/ (:peso item) (:valor item))) itens))]
      
          valor-total))

(mochila itens 20) 