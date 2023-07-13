package ups.edu.ec.eva62Guaman.negocio;

import java.util.Date;
import java.util.List;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.eva62Guaman.datos.LibroDAO;
import ups.edu.ec.eva62Guaman.modelo.Libro;

public class DatosDemo {

	@Inject
	private LibroDAO daoLibro;
	
	@PostConstruct
	public void init() {
		System.out.println("Hola UPS");
		

		Libro libro1 = new Libro();
		libro1.setNombre("Don Quijote");
		libro1.setPrecio(30.00);
		libro1.setStock(10);
		daoLibro.insert(libro1);
		
		
		List<Libro> libros = daoLibro.getAll();
		for(Libro lib: libros) {
			System.out.println(lib);
		}
		
		
	}
	
}
