(ns desafio.core)

;Nome
;CPF
;E-mail
(def cliente {:nome  "Fulano Beltrano"
              :cpf   "12345678912"
              :email "fulanob@email.com"})
;Número
;CVV
;Validade
;Limite
(def cartao {:numero   "1234567890123456"
             :cvv      "123"
             :validade "2030/12"
             :limite   2000})

;Data
;Valor
;Estabelecimento
;Categoria
(def compras-realizadas [{:compra-id       1
                          :data            "2021/07/27"
                          :valor           25.5
                          :estabelecimento "Restaurante"
                          :categoria       "Alimentação"}
                         {:compra-id       2
                          :data            "2021/07/26"
                          :valor           300
                          :estabelecimento "Consulta médica"
                          :categoria       "Saúde"}
                         {:compra-id       3
                          :data            "2021/07/10"
                          :valor           250
                          :estabelecimento "Curso"
                          :categoria       "Educação"}
                         {:compra-id       4
                          :data            "2021/07/05"
                          :valor           90.9
                          :estabelecimento "Academia"
                          :categoria       "Saúde"}
                         {:compra-id       5
                          :data            "2021/07/27"
                          :valor           124.2
                          :estabelecimento "Mercado"
                          :categoria       "Alimentação"}]
                         )


(defn listar-compras
  [[id, data, valor, estabelecimento, categoria]]
  {:compra-id       id
   :data            data
   :valor           valor
   :estabelecimento estabelecimento
   :categoria       categoria}
  (println "Compra: " id )
  (println "Data: " data )
  (println "Valor: " valor )
  (println "Estabelecimento: " estabelecimento )
  (println "Categoria: " categoria )
  (println "\n"))

;(println (map listar-compras compras-realizadas))

(defn agrupar-compras [compra]
  (group-by :categoria compra))

(defn retorna-valores [[lista]]
  (get-in lista [:valor])

  (println retorna-valores compras-realizadas))






