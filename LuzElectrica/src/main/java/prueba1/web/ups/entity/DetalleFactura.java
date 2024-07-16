package prueba1.web.ups.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "TBL_DETALLE")
@Entity

public class DetalleFactura {
	
	
	@Id
	@Column(name="defa_codigo")
	private int codigo;
	
	 @Column(name="defa_cantidad")
		private int cantidad;
	
	@Column(name="defa_precio")
	private  double precio;
	
	   @ManyToOne
	    @JoinColumn(name = "pro_codigo")
	    private Producto producto;

	    @ManyToOne
	    @JoinColumn(name = "fac_numero")
	    private Factura factura;

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}

		public Factura getFactura() {
			return factura;
		}

		public void setFactura(Factura factura) {
			this.factura = factura;
		}
		
		   @Override
		    public String toString() {
		        return "DetalleFactura [codigo=" + codigo + ", cantidad=" + cantidad + ", precio=" + precio
		                + ", producto=" + (producto != null ? producto.getCodigo() : "null") + "]";
		    }
	    
	    
	    

}

