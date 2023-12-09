import java.util.Scanner;


public class XuBankMenu {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente banco = new Cliente();
        int escolha;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
            case 1:
                Cliente cliente = new Cliente();
                cliente.cadastrarCliente();
                DefinirSenha definirSenha =new DefinirSenha();
                definirSenha.definirSenha();
        
                // Accessing the name, CPF, and senha using getter methods
                System.out.println("Nome do cliente: " + cliente.getNome());
                System.out.println("CPF do cliente: " + cliente.getCPF());
                    break;
                case 2:
                    
                    break;
                case 3:

                    break;
                case 4:
                    
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Saindo do programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 6);
    }

    private static void exibirMenu() {
        System.out.println("\n==== XuBank Menu ====");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Conta");
        System.out.println("3. Realizar Operação (Depósito/Saque)");
        System.out.println("4. Exibir Extrato");
        System.out.println("5. Exibir Informações do Banco");
        System.out.println("6. Sair");
    }
    

}
