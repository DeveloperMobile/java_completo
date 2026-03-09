package aplicacao;



import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
	    System.out.println("Pronto!");
	    em.close();
	    emf.close();
	}
}
