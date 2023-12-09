public class ProcurarCliente {
    public static Cliente procurarCliente(String cpf, Cliente[] clientes) {
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getCPF().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
}
