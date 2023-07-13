package ups.edu.ec.eva62Guaman.negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.eva62Guaman.datos.LibroDAO;
import ups.edu.ec.eva62Guaman.modelo.Libro;

@Stateless
public class GestionLibros {

	@Inject
	private LibroDAO daoLibro;
	
	public void guardarLibros(Libro libro) throws Exception {

		
		if(daoLibro.read(libro.getCodigo()) == null) {
			try {
				daoLibro.insert(libro);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoLibro.update(libro);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	public List<Libro> listaLibros() {
	    return daoLibro.getAll();
	}
}
