# XuBank - Sistema Bancário Inovador 🏦💡

Bem-vindo ao XuBank, a fintech que está redefinindo o conceito de serviços bancários! Nosso sistema foi desenvolvido para oferecer uma experiência confiável, ágil e simples aos nossos clientes. Abaixo estão as características essenciais dos requisitos levantados pela equipe de produto:
Clientes

    Cadastro de Clientes:
        Os clientes são cadastrados com nome, CPF e senha.
        Um cliente pode ter várias contas em seu nome/CPF.

## Tipos de Conta

    Quatro Tipos de Conta:
        Conta Corrente
        Poupança
        Renda Fixa
        Investimento
        Cada tipo possui regras específicas de taxas e possibilidades de rendimento, conforme a tabela presente no anexo.

## Operações Bancárias

    Depósito e Saque:
        As contas têm operações de saque e depósito.
        Contas correntes possuem um limite de crédito, permitindo que o cliente saque além do saldo real.
        Em um depósito de conta corrente, se o saldo estiver negativo, é cobrada uma taxa de 3% sobre o valor negativo, mais R$10 de tarifa fixa.


# Acesso do Cliente

    Acesso Total:
        Um cliente tem acesso total às suas contas.
        Pode verificar a situação e extrato do último mês de cada uma.

# Informações para a Diretoria

    Custódia e Saldo Médio:
        A diretoria precisa saber o valor atual em custódia para cada tipo de conta.
        Deve ter acesso ao saldo médio das contas.

    Clientes Extremos:
        Identificação do cliente com o maior valor de saldo total.
        Identificação do cliente com o menor valor total (que pode ser negativo).
