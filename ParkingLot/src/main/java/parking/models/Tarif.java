package parking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblTarif")
public class Tarif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tarifname;
	private double price;

	public Tarif() {
	}

	public Tarif(String tarifname, double price) {
		this.tarifname = tarifname;
		this.price = price;

	}

	public String getTarifname() {
		return tarifname;
	}

	public void setTarifname(String tarifname) {
		this.tarifname = tarifname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

}
