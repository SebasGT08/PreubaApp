package ups.edu.ec.eva62Guaman.datos;


import java.io.Serializable;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.eva62Guaman.modelo.Libro;

@Stateless
public class LibroDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Libro libro) {
		em.persist(libro);
	}
	
	public void update(Libro libro) {
		em.merge(libro);
	}
	
	public Libro read(int codigo) {
		Libro p = em.find(Libro.class, codigo);
		return p;
	}
	
	public void delete(int codigo) {
		Libro p = em.find(Libro.class, codigo);
		em.remove(p);
	}
	
	public List<Libro> getAll(){
		String jpql = "SELECT p FROM Libro p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
