(ns desafio.core
  (:require [desafio.db :as d.db]))

;;Listar resumo de compras
(defn listar-resumo
  [compra]
  (select-keys compra [:data, :valor, :estabelecimento, :categoria]))

(println "\n-----Resumo das compras-----")
(println (map listar-resumo d.db/compras-realizadas))

;;Filtrar por categoria
(defn saude? [compra]
  (= (:categoria compra) "Saúde"))
(defn educacao? [compra]
  (= (:categoria compra) "Educação"))
(defn alimentacao? [compra]
  (= (:categoria compra) "Alimentação"))

(def compras-saude (filter saude? d.db/compras-realizadas))
(def compras-educacao (filter educacao? d.db/compras-realizadas))
(def compras-alimentacao (filter alimentacao? d.db/compras-realizadas))

(println "\n-----Itens comprados por categoria-----")
(println "Saúde:" compras-saude)
(println "Educação:" compras-educacao)
(println "Alimentação:" compras-alimentacao)

;;Valores compras por categoria
(defn traz-valor [compra]
  (:valor compra))

(def valor-saude (->> (filter saude? d.db/compras-realizadas)
                      (map traz-valor)
                      (reduce +)))
(def valor-educacao (reduce + (map traz-valor (filter educacao? d.db/compras-realizadas))))
(def valor-alimentacao (reduce + (map traz-valor (filter alimentacao? d.db/compras-realizadas))))

(println "\n-----Valores totais por categoria-----")
(println "Saúde:" valor-saude)
(println "Educação:" valor-educacao)
(println "Alimentação:" valor-alimentacao)

(println "\n-----Valores totais-----")
(println "Valor da Fatura:" (reduce + (map traz-valor d.db/compras-realizadas)))

;;Buscar por valor ou estabelecimento
(defn buscar-por-valor [valor]
  (fn [compra] (= valor (:valor compra))))

(defn buscar-por-estabelecimento [estabelecimento]
  (fn [compra] (= estabelecimento (:estabelecimento compra))))

(defn buscar-por-categoria [categoria]
  (fn [compra] (= categoria (:categoria compra))))

(println "\n-----Buscar Valor e Estabelecimento-----")
(println "Valor: R$300" (filter (buscar-por-valor 300) d.db/compras-realizadas))
(println "Estabelecimento: Restaurante" (filter (buscar-por-estabelecimento "Restaurante") d.db/compras-realizadas))
(println "Categoria: Saúde" (filter (buscar-por-categoria "Saúde") d.db/compras-realizadas))



