Desafio cumprido mantendo a maior parte das classes e atributos propostos no exemplo, mas com algumas modificações.

Mudanças no projeto:

    Conexão e persistência no banco de dados, utilizando o JPA através da implementação Hibernate;
    Criação do arquivo persistence.xml, para ser utilizado pelo build.gradle;
    Teste da classe Conta, através do JUnit;
    Regra para não permitir saque com valor maior que o saldo em conta;
    Regra para não permitir deposito de valor inválido (menor ou igual a zero);
    Foi incluído uma função para o sacar o valor total em conta;
