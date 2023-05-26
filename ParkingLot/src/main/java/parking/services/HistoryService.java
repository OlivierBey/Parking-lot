package parking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import parking.models.History;
import parking.repositories.HistoryRepository;

@Service
@Transactional
public class HistoryService {

	public HistoryService() {
	}

	public HistoryService(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}

	@Autowired
	HistoryRepository historyRepository;

	public void addToHistory(History historyBooking) {
		historyRepository.save(historyBooking);
	}

}
