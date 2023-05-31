package parking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import parking.models.Tarif;
import parking.repositories.TarifRepository;

@Service
@Transactional
public class TarifService {

	@Autowired
	TarifRepository tarifRepository;

	public TarifService() {
	}

	public TarifService(TarifRepository tarifRepository) {
		this.tarifRepository = tarifRepository;
	}

	public Tarif findTarifsbyId(long id) {
		return tarifRepository.findById(id).get();
	}

	public void addTarif(Tarif tarif) {
		tarifRepository.save(tarif);
	}

	public void removeTarif(long id) {
		tarifRepository.deleteById(id);
	}

	public List<Tarif> findAllTarifList() {
		return tarifRepository.findAll();
	}

	public Tarif findTarifByTarifname(String string) {
		return tarifRepository.findTarifByTarifname(string);
	}

}
