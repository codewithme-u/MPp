package com.mp.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mp.entity.Institutions;
import com.mp.repository.InstitutionsRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/institutions")
public class InstitutionsController {

    @Autowired
    private InstitutionsRepository institutionsRepository;

    // GET all institutions
    @GetMapping
    public List<Institutions> getInstitutions() {
        return institutionsRepository.findAll();
    }

    // POST new institution with image upload
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Institutions createInstitution(
            @RequestParam("institute_name") String name,
            @RequestParam("institute_location") String location,
            @RequestParam(value = "institute_image", required = false) MultipartFile imageFile) throws IOException {

        Institutions institution = new Institutions();
        institution.setInstitute_name(name);
        institution.setInstitute_location(location);

        if (imageFile != null && !imageFile.isEmpty()) {
            String base64Image = Base64.getEncoder().encodeToString(imageFile.getBytes());
            institution.setInstitute_image("data:image/png;base64," + base64Image);
        }

        return institutionsRepository.save(institution);
    }

    // PUT - update institution by ID
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Institutions updateInstitution(
            @PathVariable int id,
            @RequestParam("institute_name") String name,
            @RequestParam("institute_location") String location,
            @RequestParam(value = "institute_image", required = false) MultipartFile imageFile) throws IOException {

        Optional<Institutions> optionalInstitution = institutionsRepository.findById(id);
        if (!optionalInstitution.isPresent()) {
            throw new RuntimeException("Institution not found with ID: " + id);
        }

        Institutions institution = optionalInstitution.get();
        institution.setInstitute_name(name);
        institution.setInstitute_location(location);

        if (imageFile != null && !imageFile.isEmpty()) {
            String base64Image = Base64.getEncoder().encodeToString(imageFile.getBytes());
            institution.setInstitute_image("data:image/png;base64," + base64Image);
        }

        return institutionsRepository.save(institution);
    }

    // DELETE - delete institution by ID
    @DeleteMapping("/{id}")
    public void deleteInstitution(@PathVariable int id) {
        institutionsRepository.deleteById(id);
    }
}
