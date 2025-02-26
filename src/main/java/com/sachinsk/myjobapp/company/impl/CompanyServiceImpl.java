package com.sachinsk.myjobapp.company.impl;

import com.sachinsk.myjobapp.company.Company;
import com.sachinsk.myjobapp.company.CompanyRepository;
import com.sachinsk.myjobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
