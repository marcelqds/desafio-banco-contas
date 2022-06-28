package projeto.contas;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String endereco;
    @OneToMany(mappedBy="cliente",fetch = FetchType.EAGER,orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Conta> contas = new ArrayList<>();

    public Cliente(){}

    public Cliente(String nome){
        this.nome = nome;
    }

    public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() { return endereco; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public void setId(int id) {
        this.id = id;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Conta> getContas() { return contas; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", contas=" + contas +
                '}';
    }
}
