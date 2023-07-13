package ups.edu.ec.eva62Guaman.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.eva62Guaman.modelo.Libro;
import ups.edu.ec.eva62Guaman.negocio.GestionLibros;

@Path("clientes")
public class GLibrosService {

	@Inject
	private GestionLibros gLibros;
	
	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola mundo";
	}
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Libro misDatos() {
		Libro l = new Libro();
		l.setCodigo(2);
		l.setNombre("Libro 2");
		l.setPrecio(25.20);
		
		return l;
	}
	
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarLibro(Libro libro) {
		try {
			gLibros.guardarLibros(libro);
			return Response.status(Response.Status.OK).entity(libro).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("listar")
	@Produces("application/json")
	public List<Libro> listaLibros() {
	    return gLibros.listaLibros();
	}
	
}
