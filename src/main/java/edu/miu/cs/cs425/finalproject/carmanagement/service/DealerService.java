package edu.miu.cs.cs425.finalproject.carmanagement.service;

import edu.miu.cs.cs425.finalproject.carmanagement.model.Dealer;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.DealerRepository;
import org.springframework.stereotype.Service;

@Service
public class DealerService  extends BaseService<Dealer, Long, DealerRepository> {

    protected DealerService(DealerRepository repository) {
        super(repository);
    }
}
