class Cliente {
    private String cpf;

    public Cliente(String cpf) {
        this.cpf = cpf;
    }
}

// Exemplo da classe abstrata Conta com subclasses ContaCorrente e ContaRendaFixa
abstract class Conta {
    protected Cliente titular;

    public Conta(Cliente titular) {
        this.titular = titular;
    }

    abstract void criarConta();  // Método abstrato, substitua com a implementação real
}

class ContaCorrente extends Conta {
    public ContaCorrente(Cliente titular) {
        super(titular);
    }

    @Override
    void criarConta() {
        // Implementação para criar uma Conta Corrente
        System.out.println("Conta Corrente criada!");
    }
}

class ContaRendaFixa extends Conta {
    public ContaRendaFixa(Cliente titular) {
        super(titular);
    }

    @Override
    void criarConta() {
        // Implementação para criar uma Conta Renda Fixa
        System.out.println("Conta Renda Fixa criada!");
    }
}
