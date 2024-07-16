package prueba1.web.ups.services;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import prueba1.web.ups.entity.Cliente;
import prueba1.web.ups.gestion.Gestionclientes;

@Path("/factura")
public class ClientesService {

	@Inject
	private Gestionclientes gClientes;
	
	
	@GET
	@Path("/{cedula}")
	@Produces("application/json")
	public Cliente get(String cedula) {
		Cliente cliente;
		try {
			cliente = gClientes.getCliente(cedula);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	 @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response list() {
	        List<Cliente> clientes = gClientes.getClientes(); // Suponiendo que gClientes es tu servicio para obtener clientes

	        // Configuración de las cabeceras CORS
	        return Response.status(200)
	                .header("Access-Control-Allow-Origin", "*")
	                .header("Access-Control-Allow-Credentials", "true")
	                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	                .entity(clientes)
	                .build();
	    }

	
	
	
}
