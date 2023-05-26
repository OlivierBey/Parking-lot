<<<<<<< Updated upstream
package parking.models;

import org.hibernate.annotations.ColumnDefault;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_parking_space")
public class ParkingSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String location;
	
	@Column(insertable=false, columnDefinition="tinyint(1) default 1")
	private Boolean available= true;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public long getId() {
		return id;
	}
	
	
}
=======
package parking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_parking_space")
public class ParkingSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String location;
	@Column()
	private boolean available;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public long getId() {
		return id;
	}
	
}
>>>>>>> Stashed changes
