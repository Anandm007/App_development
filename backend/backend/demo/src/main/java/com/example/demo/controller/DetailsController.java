package com.example.demo.controller;

import com.example.demo.model.Details;
import com.example.demo.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;

    @GetMapping
    public List<Details> getAllDetails() {
        return detailsService.getAllDetails();
    }

    @GetMapping("/{id}")
    public Optional<Details> getDetailsById(@PathVariable Long id) {
        return detailsService.getDetailsById(id);
    }

    @PostMapping
    public Details createDetails(@RequestBody Details details) {
        return detailsService.saveDetails(details);
    }

    @PutMapping("/{id}")
    public Details updateDetails(@PathVariable Long id, @RequestBody Details details) {
        return detailsService.updateDetails(id, details);
    }

    @DeleteMapping("/{id}")
    public void deleteDetails(@PathVariable Long id) {
        detailsService.deleteDetails(id);
    }
}
