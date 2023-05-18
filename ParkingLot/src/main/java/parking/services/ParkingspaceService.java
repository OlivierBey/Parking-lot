package parking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import parking.models.ParkingSpace;
import parking.repositories.ParkingSpaceRepository;

@Service
@Transactional
public class ParkingspaceService {

	@Autowired
	ParkingSpaceRepository parkingSpaceRepository;
	
	public ParkingspaceService() {}
	
	public ParkingspaceService(ParkingSpaceRepository parkingSpaceRepository) {
		this.parkingSpaceRepository= parkingSpaceRepository;
	}
	public ParkingSpace findParkingspaceById(long id) {
		return parkingSpaceRepository.findById(id).get();
	}
	public List<ParkingSpace> findAllParkingSpaces(){
		return parkingSpaceRepository.findAll();
	}
	public void addParkingspace(ParkingSpace p) {
		parkingSpaceRepository.save(p);
	}
	public void removeParkingSpace(long id) {
		parkingSpaceRepository.deleteById(id);
	}
	public boolean isParkingSpaceAvailable(ParkingSpace p) {
		return p.isAvailable();
	}
	public List<ParkingSpace> availableParkingSpaces(){
		List<ParkingSpace>freeList= new ArrayList<>();
		for (ParkingSpace p : findAllParkingSpaces()) {
			if(p.isAvailable()) {
				freeList.add(p);
			}
		}
		return freeList;
	}

	public ParkingSpace findFirstAvailable() {
		return availableParkingSpaces().get(0);
		
	}
}
