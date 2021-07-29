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

;;Listar resumo de compras
(defn listar-resumo
  [compra]
  (select-keys compra [:data, :valor, :estabelecimento, :categoria]))

(println "\n-----Resumo das compras-----")
(println (map listar-resumo compras-realizadas))

;;Filtrar por categoria
(defn saude? [compra]
  (= (:categoria compra) "Saúde"))
(defn educacao? [compra]
  (= (:categoria compra) "Educação"))
(defn alimentacao? [compra]
  (= (:categoria compra) "Alimentação"))

(def compras-saude (filter saude? compras-realizadas))
(def compras-educacao (filter educacao? compras-realizadas))
(def compras-alimentacao (filter alimentacao? compras-realizadas))

(println "\n-----Itens comprados por categoria-----")
(println "Saúde:" compras-saude)
(println "Educação:" compras-educacao)
(println "Alimentação:" compras-alimentacao)

;;Valores compras por categoria
(defn traz-valor [compra]
  (:valor compra))

(def valor-saude (->> (filter saude? compras-realizadas)
                      (map traz-valor)
                      (reduce +)))
(def valor-educacao (reduce + (map traz-valor (filter educacao? compras-realizadas))))
(def valor-alimentacao (reduce + (map traz-valor (filter alimentacao? compras-realizadas))))

(println "\n-----Valores totais por categoria-----")
(println "Saúde:" valor-saude)
(println "Educação:" valor-educacao)
(println "Alimentação:" valor-alimentacao)

(println "\n-----Valores totais-----")
(println "Valor da Fatura:" (reduce + (map traz-valor compras-realizadas)))

;;Buscar por valor ou categoria

