# Mercado Fácil
 
Um supermercado da cidade de Campina Grande precisa de um sistema que gerencie o estoque e venda de produtos na sua loja. Neste sistema, o administrador deve obter uma visão geral e o controle sobre o funcionamento do supermercado, por exemplo, ele deve poder adicionar novos produtos, acompanhar quantas unidades do produto estão disponíveis, alterar preços, ser notificado sobre eventos críticos, gerenciar as vendas e oferecer alguns serviços personalizados para o cliente.

## User Stories implementadas

- Eu, como administrador, gostaria de adicionar um novo produto no sistema,
informando seu nome, código de barra, fabricante, situação, e categoria;
- Eu, como administrador, gostaria de consultar a disponibilidade e o preço de cada
produto do supermercado;
- Eu, como administrador, gostaria de atribuir um preço (R$) a um determinado
produto no sistema;
- Eu, como administrador, gostaria de criar lotes associados aos produtos,
informando a quantidade de itens disponíveis e a data de validade;
- Eu, como administrador, gostaria de fazer um CRUD de cliente no sistema.
- Como cliente do sistema, desejo acessar o endpoint do Mercado Fácil para adicionar um produto do catálogo no carrinho de compras, para que seja possível realizar uma compra
- Como cliente do sistema, desejo acessar o endpoint do Mercado Fácil para remover um produto do carrinho de compras, para que seja possível desconsiderar o produto da compra
- Como cliente do sistema, desejo acessar o endpoint do Mercado Fácil para finalizar uma compra (fechar carrinho de compra e realizar pagamento), para que seja possível efetuar a compra dos produtos do carrinho
- Como cliente do sistema, desejo acessar o endpoint do Mercado Fácil para listar minhas compras que foram finalizadas, para que seja possível ver o meu histórico de compras. 
- Como cliente do sistema, desejo acessar o endpoint do Mercado Fácil para ver o descritivo de uma compra, para que seja possível ver detalhes de uma compra realizada (produtos, quantidades, data, usuário, etc.).
- Como cliente do sistema Mercado Fácil, desejo acessar o endpoint do Mercado Fácil para listar as formas de pagamento disponíveis no sistema, para que seja possível realizar o pagamento de uma compra.
- Como cliente do sistema Mercado Fácil, quero definir a forma de pagamento (boleto, paypal e cartão de crédito) ao finalizar compras, para que seja possível pagar as compras da forma mais conveniente. 
- Como administrador do sistema Mercado Fácil, quero poder estabelecer acréscimos percentuais no valor da compra para cada forma de pagamento, para que o valor do pagamento esteja compatível com os custos operacionais de cada tipo de operação.
- Como administrador do sistema Mercado Fácil, quero poder estabelecer perfis de cliente (normal, especial e premium), para possibilitar que descontos diferenciados sejam aplicados nas compras dos clientes.
- Como cliente do sistema Mercado Fácil, quero ter a opção de escolher e calcular o valor do tipo de entrega mais conveniente para mim. As opções de entrega são: Retirada, Padrão e Express. Para cada tipo de entrega um valor diferente será cobrado com base no endereço do cliente e com base nos tipos de produtos. A estratégia de cálculo é diferente de acordo com os itens da lista de produtos: 
- caso tenha produtos de refrigeração: entrega Refrigeração
- caso tenha produtos frágeis e não tenha produtos de refrigeração: entrega Frágil
- caso contrário: entrega Comum

## Estrutura básica

- Um projeto: MercadoFacil;
- Um Controller RestApiController que implementa os endpoints da API Rest.
- O modelo é composto principalmente pelas classes Produto, ProdutoConjunto, Lote , Cliente , Carrinho, Compra , Entrega, EstrategiaCalculo.
- O pacote exceptions guarda as classes de exceções que podem ser levantadas
dentro do sistema;
- Não há implementação de frontend, mas o projeto fornece uma interface de acesso à API via swagger.

## Tecnologias
Código base gerado via [start.sprint.io](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.example&artifactId=EstoqueFacil&name=EstoqueFacil&description=Projeto%20Estoque%20Facil&packageName=com.example.EstoqueFacil&dependencies=web,actuator,devtools,data-jpa,h2) com as seguintes dependências:  

- Spring Web
- Spring Actuator
- Spring Boot DevTools
- Spring Data JPA
- H2 Database

## Endereços úteis

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- [http://localhost:8080/h2](http://localhost:8080/h2)

