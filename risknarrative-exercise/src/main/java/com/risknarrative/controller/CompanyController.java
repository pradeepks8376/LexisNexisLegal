package com.risknarrative.controller;

import com.risknarrative.request.CompanySearchRequest;
import com.risknarrative.response.Company;
import com.risknarrative.response.CompanySearchResponse;
import com.risknarrative.service.TruProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    private TruProxyService truProxyService;

    @PostMapping("/search")
    public CompanySearchResponse searchCompany(@RequestHeader("x-api-key") String apiKey,
                                 @RequestParam boolean isActive,
                                 @RequestBody CompanySearchRequest request) {
        String companyName = request.getCompanyName();
        String companyNumber = request.getCompanyNumber();
        CompanySearchResponse company = truProxyService.getCompanyDetails(apiKey, companyName, companyNumber, isActive);
        Company cmp = new Company();
        cmp.setOfficers(truProxyService.getCompanyOfficers(apiKey, companyNumber));
        System.out.println("print officers: "+cmp);
        return company;
    }
}

