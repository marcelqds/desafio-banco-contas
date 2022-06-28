package projeto.contas;

public interface IConta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(Conta contaDestino, double valor);
    void sacarTotal();
    void imprimirExtrato();
}
