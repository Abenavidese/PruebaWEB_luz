package prueba1.web.ups.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "TBL_FACTURA")
@Entity

public class Factura {
	
	
	@Id
	@Column(name="fac_numero")
	private int numero;
	
	 @Column(name="fac_fecha")
		private Date fecha;
	
	 @ManyToOne
	    @JoinColumn(name = "per_cedula")
	    private Persona cliente;

	    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
	    private List<DetalleFactura> detalles;

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public Persona getCliente() {
			return cliente;
		}

		public void setCliente(Persona cliente) {
			this.cliente = cliente;
		}

		public List<DetalleFactura> getDetalles() {
			return detalles;
		}

		public void setDetalles(List<DetalleFactura> detalles) {
			this.detalles = detalles;
		}
		
	    public void addDetalle(DetalleFactura detalle) {
	        detalles.add(detalle);
	        detalle.setFactura(this);
	    }

	    public void removeDetalle(DetalleFactura detalle) {
	        detalles.remove(detalle);
	        detalle.setFactura(null);
	    }
	    
	    @Override
	    public String toString() {
	        return "Factura [numero=" + numero + ", fecha=" + fecha + ", cliente=" + (cliente != null ? cliente.getNombre() : "null")
	                + ", detalles=" + detalles + "]";
	    }
	    
	    
	    
    
    

}

