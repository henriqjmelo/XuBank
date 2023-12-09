import java.util.Scanner;

public class Cliente {
    private String nome;
    private String CPF;
    private String senha;

    // Constructor (optional, depending on your needs)
    public Cliente(String CPF) {
        this.CPF = CPF;
        this.senha = senha;
    }

    // Instance method to register a client
    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        nome = scanner.nextLine();

        // Assuming senha is a string for simplicity, you may want to handle security considerations
        System.out.println("Digite a senha do cliente: ");
        senha = scanner.nextLine();

        // Calling the method to register CPF
        while (!cadastrarCPF()) {
            System.out.println("CPF inválido! Digite novamente.");
        }

        System.out.println("CPF válido!");
    }

    // Method to register CPF and return validation result
    private boolean cadastrarCPF() {
        Scanner scanner = new Scanner(System.in);

        // Assuming CPF is a string for simplicity, you may want to handle formatting
        System.out.println("Digite o CPF do cliente: ");
        CPF = scanner.nextLine();

        // Validating the CPF
        return validarCPF(CPF);
    }

    // Other methods...

    private static boolean validarCPF(String CPF) {
        // Remove non-numeric characters from the CPF
        CPF = CPF.replaceAll("[^0-9]", "");

        // Verifying if CPF has 11 digits
        if (CPF.length() != 11) {
            return false;
        }

        // Checking if all digits are the same
        if (CPF.matches("(\\d)\\1*")) {
            return false;
        }

        // Calculating and verifying the first digit
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(CPF.charAt(i)) * (10 - i);
        }
        int remainder = sum % 11;
        int firstDigit = (remainder < 2) ? 0 : (11 - remainder);

        if (firstDigit != Character.getNumericValue(CPF.charAt(9))) {
            return false;
        }

        // Calculating and verifying the second digit
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(CPF.charAt(i)) * (11 - i);
        }
        remainder = sum % 11;
        int secondDigit = (remainder < 2) ? 0 : (11 - remainder);

        return secondDigit == Character.getNumericValue(CPF.charAt(10));
    }

    // Getter and setter methods for other attributes (senha)
    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
