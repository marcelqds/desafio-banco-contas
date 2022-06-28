package projeto.contas;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory mFactory = Persistence.createEntityManagerFactory("bco-dev");
        EntityManager eManager = mFactory.createEntityManager();
        eManager.getTransaction().begin();

        Banco meuDigital = new Banco("Meu Digital","Rua Santo Afonso, 354, Bairro Nossa, São Paulo, SP");
        System.out.println(meuDigital);

        // Criação de clientes
        Cliente cliente1 = new Cliente("Teste Guerra", "Rua: Um, 1, Bairro Um, São Paulo, SP");
        Cliente cliente2 = new Cliente("Aprendiz Guerra", "Rua: Dois, 2, Bairro Dois, São Paulo, SP");
        Cliente cliente3 = new Cliente("Marciano Guerra", "Rua: Tres, 3, Bairro Tres, São Paulo, SP");
        Cliente cliente4 = new Cliente("Marcos Guerra", "Rua: Quatro, 4, Bairro Quatro, São Paulo, SP");
        Cliente cliente5 = new Cliente("Amanda Guerra", "Rua: Cinco, 5, Bairro Cinco, São Paulo, SP");

        Conta ccCli1 = new ContaCorrente(meuDigital,cliente1);
        Conta cpCli1 = new ContaPoupanca(meuDigital,cliente1);
        Conta ccCli2 = new ContaCorrente(meuDigital,cliente2);
        cpCli1.depositar(100);
        cpCli1.transferir(ccCli1,25);
        Conta ccCli3 = new ContaCorrente(meuDigital,cliente3);
        Conta cpCli3 = new ContaPoupanca(meuDigital,cliente3);
        Conta cpCli4 = new ContaPoupanca(meuDigital,cliente4);
        cpCli4.depositar(1000);
        cpCli4.sacar(250);
        Conta ccCli5 = new ContaCorrente(meuDigital,cliente5);
        Conta cpCli5 = new ContaPoupanca(meuDigital,cliente5);

        // Persistencia do banco
        eManager.persist(meuDigital);

        // Persistencia dos clientes;
        eManager.persist(cliente1);
        eManager.persist(cliente2);
        eManager.persist(cliente3);
        eManager.persist(cliente4);
        eManager.persist(cliente5);

        // Persistencia das contas
        eManager.persist(ccCli1);
        eManager.persist(cpCli1);
        eManager.persist(ccCli2);
        eManager.persist(ccCli3);
        eManager.persist(cpCli3);
        eManager.persist(cpCli4);
        eManager.persist(ccCli5);
        eManager.persist(cpCli5);

        Banco banco1 = eManager.find(Banco.class, 1);
        Conta rsConta1 = eManager.find(Conta.class,1);
        Conta rsConta2 = eManager.find(Conta.class,2);
        Conta rsConta3 = eManager.find(Conta.class,3);
        Conta rsConta4 = eManager.find(Conta.class,4);

        System.out.println(banco1);
        System.out.println(rsConta1);
        System.out.println(rsConta2);
        System.out.println(rsConta3);
        System.out.println(rsConta4);

        eManager.getTransaction().commit();
        eManager.close();
        mFactory.close();
    }
}
