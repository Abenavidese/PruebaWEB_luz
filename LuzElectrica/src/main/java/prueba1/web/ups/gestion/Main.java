package prueba1.web.ups.gestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import prueba1.web.ups.dao.ClienteDAO;
import prueba1.web.ups.dao.DetalleFacturaDAO;
import prueba1.web.ups.dao.FacturaDAO;
import prueba1.web.ups.dao.PersonaDAO;
import prueba1.web.ups.dao.ProductoDAO;
import prueba1.web.ups.entity.Cliente;
import prueba1.web.ups.entity.DetalleFactura;
import prueba1.web.ups.entity.Factura;
import prueba1.web.ups.entity.Persona;
import prueba1.web.ups.entity.Producto;

@Startup
@Singleton
public class Main {
    
    @Inject
    private ClienteDAO daoCliente;
    
    @Inject
    private PersonaDAO daoPersona;
    
    @Inject
    private FacturaDAO daoFactura;
    
    @Inject 
    private DetalleFacturaDAO daoDetalle;
    
    @Inject
    private ProductoDAO daoProducto;
    

	

	    	    

    @PostConstruct
    public void init() {
        // Inicializar 
        
    	
    	Cliente cliente = new Cliente();
		cliente.setCedula("0106411937");
		cliente.setNombre("Anthony Villa");
		cliente.setDireccion("Barrial blanco");
		

		
		daoCliente.insert(cliente);
	

        // Crear Persona
        Persona persona = new Persona();
        persona.setCedula("0702555");
        persona.setNombre("Anthony Benavides");
        persona.setDireccion("No definida");
        
        // Crear Producto
        Producto producto = new Producto();
        producto.setCodigo(1);
        producto.setPrecio(100.0);
        producto.setStock(50);
        
        // Crear Factura
        Factura factura = new Factura();
        factura.setNumero(1);
        factura.setFecha(new Date());
        factura.setCliente(persona);
        
        // Crear DetalleFactura
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setCodigo(1);
        detalleFactura.setCantidad(2);
        detalleFactura.setPrecio(200.0); // precio total = cantidad * precio del producto
        detalleFactura.setProducto(producto);
        
        // Agregar DetalleFactura a la Factura
        List<DetalleFactura> detalles = new ArrayList<>();
        detalles.add(detalleFactura);
        factura.setDetalles(detalles);
        
        detalleFactura.setFactura(factura);
        
        // Insertar Persona
        daoPersona.insert(persona);
        List<Persona> listado = daoPersona.getAll();
        
        for (Persona per : listado) {
            System.out.println("Cedula: " + per.getCedula() + " Nombre: " + per.getNombre() + " Direccion: " + per.getDireccion());
        }
        
        // Insertar Productos
        daoProducto.insert(producto);
        List<Producto> listado1 = daoProducto.getAll();
        
        for (Producto pro : listado1) {
            System.out.println("Precio: " + pro.getPrecio() + " Stock: " + pro.getStock() + " Codigo: " + pro.getCodigo());
        }
        
        // Insertar Factura
        daoFactura.insert(factura);
        List<Factura> listado3 = daoFactura.getAll();
        
        for (Factura fac : listado3) {
            System.out.println("Cliente de la factura: " + fac.getCliente().getNombre() + " Numero de factura: " + fac.getNumero() + " Detalles: " + fac.getDetalles());
        }
        
        // Insertar detalle
        daoDetalle.insert(detalleFactura);
        List<DetalleFactura> listado2 = daoDetalle.getAll();
        
        for (DetalleFactura defa : listado2) {
            System.out.println("Codigo: " + defa.getCodigo() + " Precio: " + defa.getPrecio() + " Consumo: " + defa.getProducto().getCodigo() + " Factura: " + defa.getFactura());
        }
        
   
    }
   
    }

        

        
		
		

