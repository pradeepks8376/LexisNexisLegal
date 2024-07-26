package com.risknarrative.controller;

import com.risknarrative.constant.Constants;
import com.risknarrative.request.CompanySearchRequest;
import com.risknarrative.response.CompanySearchResponse;
import com.risknarrative.service.TruProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    private TruProxyService truProxyService;

    @PostMapping(Constants.SEARCH_URI)
    public CompanySearchResponse searchCompany(@RequestHeader(Constants.API_KEY) String apiKey,
                                 @RequestParam boolean isActive,
                                 @RequestBody CompanySearchRequest request) {
        return truProxyService.getCompanyDetails(apiKey, request.getCompanyName(), request.getCompanyNumber(), isActive);
    }
}

