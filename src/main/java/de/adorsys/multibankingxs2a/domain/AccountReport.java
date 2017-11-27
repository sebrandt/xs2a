package de.adorsys.multibankingxs2a.domain;

import java.util.List;
import java.util.Map;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by aro on 23.11.17.
 */

@Data
@ApiModel(description = "Account Report", value = "AccountReport")
public class AccountReport {
	 
	@ApiModelProperty(value = "Booked Transactions")
	 private Transactions[] booked;
	
	@ApiModelProperty(value = "Pending Transactions")
	 private Transactions[] pending;
	
	@ApiModelProperty(value = "Liks")
	 private Links _links;
}