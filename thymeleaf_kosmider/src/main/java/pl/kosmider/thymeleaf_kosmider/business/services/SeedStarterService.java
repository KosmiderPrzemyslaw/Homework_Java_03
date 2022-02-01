package pl.kosmider.thymeleaf_kosmider.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedStarterService {

    @Autowired
    private SeedStarterRepository seedStarterRepository;

    public SeedStarterService() {
        super();
    }

    public List<SeedStarter> findAll() {
        return this.seedStarterRepository.findAll;
    }

    public void add(final SeedStarter seedStarter) {
        this.seedStarterRepository.add(seedStarter);
    }
}
