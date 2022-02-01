package pl.kosmider.thymeleaf_kosmider.services;

import org.springframework.beans.factory.annotation.Autowired;

public class VarietyService {

    @Autowired
    private VarietyReposistory varietyReposistory;

    public VarietyService() {
        super();
    }

    public List<Variety> findAll() {
        return this.varietyReposistory.findAll();
    }

    public Variety findById(final Integer id) {
        return this.varietyReposistory.findById(id);
    }
}
