package com.example.javaframeworkassessement1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaframeworkassessement1.entity.Company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/company")
public class CompanyController {
    public static ArrayList<Company> companies = new ArrayList<>();

    // ------------------------Add Company--------------------------------
    @PostMapping("/add-company")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companies.add(company);
        System.out.print("Add Company is work");
        return ResponseEntity.ok("Add company success!");
    }

    // ------------------------Update Company--------------------------------
    @PutMapping("update-company/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        for (Company c : companies) {
            if (Objects.equals(c.getId(), company.getId())) {
                c.setCompanyCode(c.getCompanyCode());
                c.setCompanyName(c.getCompanyName());
                c.setDomain(c.getDomain());
                c.setCountry(c.getCountry());
                c.setPhone(c.getPhone());
            }
        }

        return ResponseEntity.ok("Updated company success!");
    }

    // ------------------------Remove Company--------------------------------
    @DeleteMapping("/delete-company/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        for (Company c : companies) {
            if (Objects.equals(c.getId(), id)) {
                companies.remove(c);
            }
        }
        return ResponseEntity.ok("Deleted company success!");
    }

    // ------------------------Search Company by
    // path--------------------------------
    @GetMapping("/fine-one/company/{id}")
    public ResponseEntity<Company> findOneCompanyByPath(@PathVariable Long id) {
        Company company = new Company();
        for (Company c : companies) {
            if (Objects.equals(c.getId(), id)) {
                company = c;
            }
        }
        return ResponseEntity.ok(company);
    }

    // ------------------------Search Company by
    // param--------------------------------
    @GetMapping("/fine-one/companyName")
    public ResponseEntity<Company> findCompanyByParam(@RequestParam Long id) {
        Company company = new Company();
        for (Company c : companies) {
            if (Objects.equals(c.getId(), id)) {
                company = c;
            }
        }
        return ResponseEntity.ok(company);
    }

    // ------------------------Search All Companies--------------------------------
    @GetMapping("/find-all-companies")
    public ResponseEntity<List<Company>> findAllCompanies() {
        return ResponseEntity.ok(companies);
    }

}
