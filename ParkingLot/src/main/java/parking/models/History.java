package parking.models;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/**
 * Deze tabel bevat alle afgesloten bookings. Eens afgesloten en betaalt komen de gegevens als string in deze entity
 * @author olivi
 *
 */
@Entity
@Table(name = "tblHistory")
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "StringBooking")
	private String historyBooking;

	public History(String historyBooking) {
		this.historyBooking = historyBooking;
	}

	public String getHistoryBooking() {
		return historyBooking;
	}

	public void setHistoryBooking(String historyBooking) {
		this.historyBooking = historyBooking;
	}

	public long getId() {
		return id;
	}

}
