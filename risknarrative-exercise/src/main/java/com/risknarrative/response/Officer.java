package com.risknarrative.response;

import com.risknarrative.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Officer {
    private Address address;
    private String name;
    private String appointed_on;
    private String officer_role;
}
