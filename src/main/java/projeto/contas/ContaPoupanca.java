package projeto.contas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Poupanca")
public class ContaPoupanca extends Conta{
    public ContaPoupanca(){}
    public ContaPoupanca(Banco banco, Cliente cliente){
        super(banco,cliente);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("==== Saldo Conta Poupança ====");
        super.infosContaSaldo();
    }
}
