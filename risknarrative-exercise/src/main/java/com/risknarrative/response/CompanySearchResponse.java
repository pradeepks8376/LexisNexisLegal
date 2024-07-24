package com.risknarrative.response;

import lombok.Data;

import java.util.List;

//@Data
public class CompanySearchResponse {
    private int total_results;
    private List<Company> items;

    public int getResults() {
        return total_results;
    }

    public void setResults(int results) {
        this.total_results = results;
    }

    public List<Company> getItems() {
        return items;
    }

    public void setItems(List<Company> items) {
        this.items = items;
    }
}
