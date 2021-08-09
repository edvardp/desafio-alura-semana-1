(ns desafio.core
  (:require [desafio.db :as d.db]
            [desafio.logic :as d.logic]))

;;Associar cliente 'a cartão e compras
(println "\n-----Associação do cliente/cartão/compras-----")

(println (d.logic/associar-cliente-cartao-compras d.db/cliente d.db/cartao d.db/compras-realizadas))

;;Agrupar categoria
(println "\n-----Compras agrupadas por categoria-----")
(println (d.logic/agrupar-categoria d.db/compras-realizadas))

(println "\n-----Resumo das compras-----")
(println d.logic/resumo)

(println "\n-----Itens comprados por categoria-----")
(println "Saúde:" d.logic/compras-saude)
(println "Educação:" d.logic/compras-educacao)
(println "Alimentação:" d.logic/compras-alimentacao)

;;Valores compras por categoria
(println "\n-----Valores totais por categoria-----")
(println "Saúde:" d.logic/valor-saude)
(println "Educação:" d.logic/valor-educacao)
(println "Alimentação:" d.logic/valor-alimentacao)

(println "\n-----Valores totais-----")
(println "Valor da Fatura:" d.logic/valor-total)

(println "\n-----Buscar Valor e Estabelecimento-----")
(println "Valor: R$300" d.logic/busca-compra-300-reais)
(println "Estabelecimento: Restaurante" d.logic/busca-estabelecimento-restaurante)
(println "Categoria: Saúde" d.logic/busca-categoria-saude)



