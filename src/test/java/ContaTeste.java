import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.function.Executable;
import projeto.contas.*;

public class ContaTeste {
    Banco bc1 = new Banco("Primeiro Banco","Rua dois, 50");
    Cliente cli1 = new Cliente("Marcos Furtalo","Rua Amizade");
    Cliente cli2 = new Cliente("Amanda Guerra","Rua Dos Felizes");
    Conta cc = new ContaCorrente(bc1,cli1);
    Conta cp = new ContaPoupanca(bc1,cli2);

    @Test
    @DisplayName("Deve manter o mesmo saldo ao tentar efetuar saque acima do valor em conta")
    public void deveRetornarExcessaoSaldoInsulficiente(){
        double saldo = cc.getSaldo();
        cc.sacar(10);
        assertEquals(saldo,cc.getSaldo());
    }

    @Test
    @DisplayName("Válida saldo ao tentar depositar valor inválido")
    public void validaSaldoAoTentarDepositarValorInvalido(){
        double saldo = cp.getSaldo();
        cp.depositar(0);
        double saldoAtual = cp.getSaldo();
        assertEquals(saldo,saldoAtual);
    }

    @Test
    @DisplayName("Válida saldo após depósito válido")
    public void validaSaldoAposDepositoValido(){
        cc.depositar(50);
        assertEquals(50,cc.getSaldo());
    }

    @Test
    @DisplayName("Válida saldo após tranferência")
    public void validaSaldoAposTransferencia(){

        cc.depositar(100);
        cc.transferir(cp,35);
        cc.transferir(cp,15);
        assertEquals(50,cc.getSaldo());
        cp.depositar(20);
        assertEquals(70,cp.getSaldo());
    }

    @Test
    @DisplayName("Válida saque do saldo total em conta")
    public void validaSaqueSaldoTotalConta(){
        cc.depositar(1000);
        cc.sacarTotal();
        assertEquals(0,cc.getSaldo());
    }
}
