package projeto.contas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@DiscriminatorValue(value = "Corrente")
public class ContaCorrente extends Conta{
    public ContaCorrente(){}
    public ContaCorrente(Banco banco, Cliente cliente) {
        super(banco,cliente);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("==== Extrato Conta Corrente ====");
        super.infosContaSaldo();

    }
}
