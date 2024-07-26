package com.risknarrative.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.risknarrative.model.Items;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficerResponse {
    private List<Officer> items;
}
