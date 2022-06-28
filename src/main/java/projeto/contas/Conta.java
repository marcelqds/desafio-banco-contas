package projeto.contas;

import javax.management.InvalidAttributeValueException;
import javax.persistence.*;
import java.util.Objects;

@Entity(name = "contas")
@DiscriminatorColumn(name="tipoConta",length = 20, discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Conta implements IConta{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int numeroConta;

    @Column(insertable = false,updatable = false)
    private String tipoConta;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="banco_agencia", nullable = false)
    private Banco banco;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cliente_id", nullable = false)
    private Cliente cliente;

    @Column
    protected double saldo;

    public Conta(){}
    public Conta(Banco banco, Cliente cliente){
        this.banco = banco;
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        try {
            double saldoAtual = this.saldo - valor;
            if(saldoAtual < 0) throw new Exception("Saldo Insulficiente");
            this.saldo = saldoAtual;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void sacarTotal(){
        this.saldo = 0;
    }

    @Override
    public void depositar(double valor) {
        try {
            if (valor <= 0) throw new IllegalArgumentException("O deposito deve ser maior que 0");
            this.saldo += valor;
        }catch(IllegalArgumentException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void infosContaSaldo(){
        System.out.println(String.format("Agencia: %d",banco.getAgencia()));
        System.out.println(String.format("Numero: %d",this.numeroConta));
        System.out.println(String.format("Tipo Conta: %s",this.tipoConta));
        System.out.printf("Saldo: %.2f\n",this.saldo);
    }

    public Banco getBanco() {
        return banco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numeroConta == conta.numeroConta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroConta, tipoConta, banco, cliente, saldo);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", tipoConta=" + tipoConta +
                ", banco=" + banco +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }
}
