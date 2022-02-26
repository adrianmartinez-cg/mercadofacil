insert into produto (ID, NOME, CODIGO_BARRA, FABRICANTE, IS_DISPONIVEL, CATEGORIA, PRECO)
values(10001,'Leite Integral', '87654321-B', 'Parmalat', FALSE, 'Laticinios', 4.5);

insert into produto (ID, NOME, CODIGO_BARRA, FABRICANTE, IS_DISPONIVEL, CATEGORIA, PRECO)
values(10002,'Arroz Integral', '87654322-B', 'Tio Joao', FALSE, 'Graos', 5.5);

insert into produto (ID, NOME, CODIGO_BARRA, FABRICANTE, IS_DISPONIVEL, CATEGORIA, PRECO)
values(10003,'Sabao em Po', '87654323-C', 'OMO', FALSE, 'Limpeza', 12);

insert into produto (ID, NOME, CODIGO_BARRA, FABRICANTE, IS_DISPONIVEL, CATEGORIA, PRECO)
values(10004,'Agua Sanitaria', '87654324-C', 'Dragao', FALSE, 'Limpeza', 3);

insert into produto (ID, NOME, CODIGO_BARRA, FABRICANTE, IS_DISPONIVEL, CATEGORIA, PRECO)
values(10005,'Creme Dental', '87654325-C', 'Colgate', FALSE, 'Higiene', 2.5);

insert into produto (ID, NOME, CODIGO_BARRA, FABRICANTE, IS_DISPONIVEL, CATEGORIA, PRECO)
values(10006,'Jogo Copo de vidro americano', '87654125-A', 'Nadir', FALSE, 'Fragil', 25);

insert into produto (ID, NOME, CODIGO_BARRA, FABRICANTE, IS_DISPONIVEL, CATEGORIA, PRECO)
values(10007,'Leite Fermentado 6unid.', '87654825-B', 'Yakult', FALSE, 'Frios', 8);

insert into produto (ID, NOME, CODIGO_BARRA, FABRICANTE, IS_DISPONIVEL, CATEGORIA, PRECO)
values(10008,'Carne Bovina Acém 1kg', '87654325-B', 'Friboi', FALSE, 'Frios', 35);

insert into lote (ID, PRODUTO_ID, NUMERO_DE_ITENS)
values(1, 10005, 20);

insert into lote (ID, PRODUTO_ID, NUMERO_DE_ITENS)
values(2, 10006, 12);

insert into lote (ID, PRODUTO_ID, NUMERO_DE_ITENS)
values(3, 10007, 15);

insert into lote (ID, PRODUTO_ID, NUMERO_DE_ITENS)
values(4, 10008, 20);

insert into lote (ID, PRODUTO_ID, NUMERO_DE_ITENS)
values(5, 10001, 40);

insert into lote (ID, PRODUTO_ID, NUMERO_DE_ITENS)
values(6, 10002, 60);

insert into lote (ID, PRODUTO_ID, NUMERO_DE_ITENS)
values(7, 10003, 50);

insert into lote (ID, PRODUTO_ID, NUMERO_DE_ITENS)
values(8, 10004, 35);

update produto set IS_DISPONIVEL = TRUE where ID = 10001;
update produto set IS_DISPONIVEL = TRUE where ID = 10002;
update produto set IS_DISPONIVEL = TRUE where ID = 10003;
update produto set IS_DISPONIVEL = TRUE where ID = 10004;
update produto set IS_DISPONIVEL = TRUE where ID = 10005;
update produto set IS_DISPONIVEL = TRUE where ID = 10006;
update produto set IS_DISPONIVEL = TRUE where ID = 10007;
update produto set IS_DISPONIVEL = TRUE where ID = 10008;

insert into carrinho(ID)
values(1);
insert into carrinho(ID)
values(2);
insert into carrinho(ID)
values(3);
insert into cliente (ID, CPF, NOME, IDADE, ENDERECO, PERFIL , CARRINHO_ID)
values(1001, 10020030006, 'Fulano', 23, 'Rua tal',0,1);
insert into cliente (ID, CPF, NOME, IDADE, ENDERECO, PERFIL , CARRINHO_ID)
values(1002, 10020030007, 'Beltrano', 22, 'Rua tal',1,2);
insert into cliente (ID, CPF, NOME, IDADE, ENDERECO, PERFIL , CARRINHO_ID)
values(1003, 10020030008, 'Ciclano', 24, 'Rua tal',2,3);
