package team47pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import team47pack.models.Clinic;
import team47pack.models.Doctor;
import team47pack.models.dto.ClinicSearchRequest;
import team47pack.models.dto.ClinicSearchResult;
import team47pack.security.TokenUtils;
import team47pack.service.ClinicService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClinicController {
    @Autowired
    private ClinicService clinicService;
    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(value = "/clinic/search", produces = "application/json", consumes = "application/json")
    @PreAuthorize("hasRole('PATIENT')")
    public ArrayList<ClinicSearchResult> searchForClinics(@RequestBody ClinicSearchRequest csr) {
        ArrayList<ClinicSearchResult> rez = clinicService.search(csr);
        return rez;
    }

    @GetMapping(value = "clinic/{id}/getAvailableDoctors")
    @PreAuthorize("hasRole('PATIENT')")
    public List<Doctor> getDoctors(@PathVariable(value = "id") Long id) {
        Clinic clinic = clinicService.getClinic(id);
        if (clinic != null) {
            return clinic.getDoctors();
        }
        return null;
    }
}