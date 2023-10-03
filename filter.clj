(def dados
  [{:titulo "Exercício de academia", :cargaHoraria 10, :categoria "curso"}
   {:titulo "dasdasdsa academia", :cargaHoraria 20, :categoria "curso"}
   {:titulo "fdsfdsfsd academia", :cargaHoraria 30, :categoria "curso"}
   {:titulo "gfdgfd academia", :cargaHoraria 40, :categoria "projeto"}
   {:titulo "arte sdsa da", :cargaHoraria 10, :categoria "curso"}
   {:titulo "dsasa arte dsadas", :cargaHoraria 20, :categoria "projeto"}
   {:titulo "dsadsa arte dsadas", :cargaHoraria 20, :categoria "curso"}
   {:titulo "dsds arte", :cargaHoraria 30, :categoria "projeto"}])

(defn filtro [arr]
  (let [state (atom arr)]
    (fn [tit]
      (swap! state (fn [s]
                     (filter #(or (<= (count tit) 0)
                                  (not (nil? (re-find (re-pattern (str tit)) (:titulo %)))))
                             s)))
      (fn [fcomp]
        (swap! state (fn [s]
                       (filter #(or (nil? fcomp)
                                    (fcomp (:categoria %)))
                               s)))
        (fn [cat]
          (swap! state (fn [s]
                         (filter #(or (<= (count cat) 0)
                                      (= cat (:categoria %)))
                                 s)))
          @state)))))

(filtro dados)