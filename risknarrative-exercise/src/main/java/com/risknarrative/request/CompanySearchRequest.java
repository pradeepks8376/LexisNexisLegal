package com.risknarrative.request;

import lombok.Data;

@Data
public class CompanySearchRequest {
    private String companyName;
    private String companyNumber;
    private boolean activeOnly;
}
