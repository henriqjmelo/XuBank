import java.util.Scanner;

public class DefinirSenha {
    
    protected String senha;
    public void definirSenha() {
        Scanner scanner = new Scanner(System.in);

        // Password criteria: at least 8 characters
        System.out.println("Digite uma senha (pelo menos 8 caracteres): ");
        senha = scanner.nextLine();

        // Additional password criteria can be added here
        if (senha.length() < 8) {
            System.out.println("A senha deve ter pelo menos 8 caracteres.");
            // You may want to handle the case where the password doesn't meet the criteria
            definirSenha(); // Retry setting the password
        }
    }
    public boolean validarSenha(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }
        public void setSenha(){
    
        }
        public String getSenha(){
            return senha;
        }
    }
