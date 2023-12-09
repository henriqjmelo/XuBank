import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Cliente {
    private String cpf;

    public Cliente(String cpf) {
        this.cpf = cpf;
    }
}

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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Assume these data structures to track created accounts
        Set<String> contasCorrenteCriadas = new HashSet<>();
        Set<String> contasRendaFixaCriadas = new HashSet<>();
        // Assume a Map to store user passwords based on CPF
        Map<String, String> cpfToSenhaMap = new HashMap<>();

        do {
            System.out.println("Menu:");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta de Renda Fixa");
            System.out.println("3. Criar Conta de Investimento");
            System.out.println("4. Criar Conta Poupança");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarContaCorrente(scanner, contasCorrenteCriadas, cpfToSenhaMap);
                    break;

                case 2:
                    criarContaRendaFixa(scanner, contasRendaFixaCriadas, cpfToSenhaMap);
                    break;

                case 5:
                    System.out.println("Saindo do programa. Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        // Close the scanner to avoid resource leaks
        scanner.close();
    }

    private static void criarContaCorrente(Scanner scanner, Set<String> contasCorrenteCriadas, Map<String, String> cpfToSenhaMap) {
        System.out.print("Informe o CPF do titular: ");
        String cpfCorrente = scanner.next();

        // Check if a Conta Corrente already exists for the given CPF
        if (contasCorrenteCriadas.contains(cpfCorrente)) {
            System.out.println("Conta Corrente já criada para este CPF.");
            verificarSenha(scanner, cpfCorrente, cpfToSenhaMap);
        } else if (validarCPF(cpfCorrente)) {
            criarConta(scanner, cpfCorrente, contasCorrenteCriadas, cpfToSenhaMap);
        } else {
            System.out.println("CPF inválido. Tente novamente.");
        }
    }

    private static void criarContaRendaFixa(Scanner scanner, Set<String> contasRendaFixaCriadas, Map<String, String> cpfToSenhaMap) {
        System.out.print("Informe o CPF do titular: ");
        String cpfContaRendaFixa = scanner.next();

        // Check if a Conta Renda Fixa already exists for the given CPF
        if (contasRendaFixaCriadas.contains(cpfContaRendaFixa)) {
            System.out.println("Conta Renda Fixa já criada para este CPF.");
            verificarSenha(scanner, cpfContaRendaFixa, cpfToSenhaMap);
        } else if (validarCPF(cpfContaRendaFixa)) {
            criarConta(scanner, cpfContaRendaFixa, contasRendaFixaCriadas, cpfToSenhaMap);
        } else {
            System.out.println("CPF inválido. Tente novamente.");
        }
    }

    private static void criarConta(Scanner scanner, String cpf, Set<String> contasCriadas, Map<String, String> cpfToSenhaMap) {
        System.out.print("Digite a senha do titular: ");
        // Consume the newline character left in the buffer
        scanner.nextLine();
        String senha = scanner.nextLine();

        if (senha.length() != 8) {
            System.out.println("Sua senha precisa ter exatamente 8 dígitos.");
        } else {
            // Assuming Cliente and Conta classes have appropriate constructors and methods
            Cliente titular = new Cliente(cpf);
            ContaCorrente contaCorrente = new ContaCorrente(titular);
            contaCorrente.criarConta();

            // Associa o CPF à conta recém-criada
            contasCriadas.add(cpf);
            cpfToSenhaMap.put(cpf, senha);

            System.out.println("Conta criada com sucesso!");
        }
    }

    private static void verificarSenha(Scanner scanner, String cpf, Map<String, String> cpfToSenhaMap) {
        System.out.print("Digite a senha do titular: ");
        // Consume the newline character left in the buffer
        scanner.nextLine();
        String senha = scanner.nextLine();

        if (cpfToSenhaMap.containsKey(cpf) && cpfToSenhaMap.get(cpf).equals(senha)) {
            System.out.println("Senha correta. Você já possui uma conta.");
        } else {
            System.out.println("Senha incorreta ou CPF não encontrado.");
        }
    }

    private static boolean validarCPF(String cpf) {
                // Remove caracteres não numéricos
                cpf = cpf.replaceAll("[^0-9]", "");

                // Verifica se o CPF tem 11 dígitos
                if (cpf.length() != 11) {
                    return false;
                }
        
                // Calcula o primeiro dígito verificador
                int soma = 0;
                for (int i = 0; i < 9; i++) {
                    soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
                }
                int resto = 11 - (soma % 11);
                int digitoVerificador1 = (resto == 10 || resto == 11) ? 0 : resto;
        
                // Calcula o segundo dígito verificador
                soma = 0;
                for (int i = 0; i < 10; i++) {
                    soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
                }
                resto = 11 - (soma % 11);
                int digitoVerificador2 = (resto == 10 || resto == 11) ? 0 : resto;
        
                // Verifica se os dígitos verificadores calculados são iguais aos informados
                return digitoVerificador1 == Character.getNumericValue(cpf.charAt(9))
                        && digitoVerificador2 == Character.getNumericValue(cpf.charAt(10));
            }
        
    }