package com.example.demo.service;

import com.example.demo.model.Details;
import com.example.demo.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailsService {

    @Autowired
    private DetailsRepository detailsRepository;

    public List<Details> getAllDetails() {
        return detailsRepository.findAll();
    }

    public Optional<Details> getDetailsById(Long id) {
        return detailsRepository.findById(id);
    }

    public Details saveDetails(Details details) {
        return detailsRepository.save(details);
    }

    public Details updateDetails(Long id, Details details) {
        if (detailsRepository.existsById(id)) {
            details.setId(id);
            return detailsRepository.save(details);
        } else {
            return null; 
        }
    }

    public void deleteDetails(Long id) {
        detailsRepository.deleteById(id);
    }
}
