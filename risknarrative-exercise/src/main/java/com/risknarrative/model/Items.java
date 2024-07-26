package com.risknarrative.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Items {
    private Address address;
    private String name;
    private String appointed_on;
    private String officer_role;
}
