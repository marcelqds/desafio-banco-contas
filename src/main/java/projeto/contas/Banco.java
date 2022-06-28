package projeto.contas;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

@Entity(name = "bancos")
public class Banco implements Comparator<Banco>{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int agencia;
    @Column
    private String nome;

    @Column
    private String endereco;

    @OneToMany(mappedBy="banco", fetch=FetchType.LAZY, cascade = CascadeType.ALL)//orphanRemoval = true, cascade = CascadeType.ALL ,
    private List<Conta> listaContas = new ArrayList<>();

    public Banco(){}
    public Banco(String nome,  String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    @Override
    public int compare(Banco bcA, Banco bcB) {
        int codigoA = bcA.getAgencia(), codigoB = bcB.getAgencia();
        if( codigoA< codigoB) return -1;
        else if(codigoA > codigoB) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "agencia=" + agencia +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", listaContas=" + listaContas +
                '}';
    }
}
