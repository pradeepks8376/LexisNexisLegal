package com.risknarrative.service;

import com.risknarrative.request.CompanySearchRequest;
import com.risknarrative.response.Company;
import com.risknarrative.response.CompanySearchResponse;
import com.risknarrative.response.Officer;
import com.risknarrative.response.OfficerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.List;

@Service
public class TruProxyService {

    @Value("${truproxy.api.url}")
    private String apiUrl;

/*    @Value("${truProxyApi.apiKey}")
    private String apiKey;*/

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

/*    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }*/

    private final RestTemplate restTemplate;

    public TruProxyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CompanySearchResponse getCompanyDetails(String apiKey, String companyName, String companyNumber, boolean active) {
        String url = apiUrl + "/Search?Query=" + companyNumber;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apiKey);
        CompanySearchRequest companySearchRequest = new CompanySearchRequest();
        companySearchRequest.setCompanyName(companyName);
        companySearchRequest.setCompanyNumber(companyNumber);
        companySearchRequest.setActiveOnly(active);

        HttpEntity<CompanySearchRequest> entity = new HttpEntity<>(companySearchRequest,headers);
//        ResponseEntity<Company> response = restTemplate.postForEntity(url, HttpMethod.GET, entity, Company.class);
        ResponseEntity<CompanySearchResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, CompanySearchResponse.class);
   //     ResponseEntity<Company> response = restTemplate.postForEntity(apiUrl + "/search", entity, Company.class);
//        ResponseEntity<CompanySearchResponse> response = restTemplate.postForEntity(baseUrl + "/search", entity, CompanySearchResponse.class);
        return response.getBody();
    }

    public List<Officer> getCompanyOfficers(String apiKey, String companyNumber) {
        String url = apiUrl + "/Officers?CompanyNumber=" + companyNumber;
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<OfficerResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, OfficerResponse.class);
        return (List<Officer>) response.getBody();
    }
}

