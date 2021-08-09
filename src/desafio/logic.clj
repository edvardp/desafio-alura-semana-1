(ns desafio.logic
  (:require [desafio.db :as d.db]))

(defn associar-cliente-cartao-compras
  [cliente cartao compras]
  (->> compras
       (assoc {} cartao)
       (assoc {} cliente))
  ;(assoc {} cliente (assoc {} cartao compras))
  )

(defn agrupar-categoria
  [compra]
  (group-by :categoria compra))

(defn listar-resumo
  [compra]
  (select-keys compra [:data, :valor, :estabelecimento, :categoria]))

(def resumo (map listar-resumo d.db/compras-realizadas))

(defn saude? [compra]
  (= (:categoria compra) "Saúde"))
(defn educacao? [compra]
  (= (:categoria compra) "Educação"))
(defn alimentacao? [compra]
  (= (:categoria compra) "Alimentação"))

(def compras-saude (filter saude? d.db/compras-realizadas))
(def compras-educacao (filter educacao? d.db/compras-realizadas))
(def compras-alimentacao (filter alimentacao? d.db/compras-realizadas))

(defn traz-valor [compra]
  (:valor compra))

(def valor-total (reduce + (map traz-valor d.db/compras-realizadas)))

(def valor-saude (->> (filter saude? d.db/compras-realizadas)
                      (map traz-valor)
                      (reduce +)))
(def valor-educacao (reduce + (map traz-valor (filter educacao? d.db/compras-realizadas))))
(def valor-alimentacao (reduce + (map traz-valor (filter alimentacao? d.db/compras-realizadas))))

(defn filtro-buscar-por-valor [valor]
  (fn [compra] (= valor (:valor compra))))

(defn filtro-buscar-por-estabelecimento [estabelecimento]
  (fn [compra] (= estabelecimento (:estabelecimento compra))))

(defn filtro-buscar-por-categoria [categoria]
  (fn [compra] (= categoria (:categoria compra))))

(defn buscar-por-valor [compras valor]
  (filter (filtro-buscar-por-valor valor) compras))

(defn buscar-por-estabelecimento [compras estabelecimento]
  (filter (filtro-buscar-por-estabelecimento estabelecimento) compras))

(defn buscar-por-categoria [compras categoria]
  (filter (filtro-buscar-por-categoria categoria) compras))

(def busca-compra-300-reais (buscar-por-valor d.db/compras-realizadas 300))
(def busca-estabelecimento-restaurante (buscar-por-estabelecimento d.db/compras-realizadas "Restaurante"))
(def busca-categoria-saude (buscar-por-categoria d.db/compras-realizadas "Saúde"))