package de.adorsys.aspsp.xs2a.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "Account Report", value = "AccountReport")
@JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@JsonRootName(value = "transactions")
public class AccountReport {

    @ApiModelProperty(value = "Booked TransactionsCreditorResponse", required = true)
    @NotNull
    private final Transactions[] booked;

    @ApiModelProperty(value = "Pending TransactionsCreditorResponse")
    private final Transactions[] pending;

    @ApiModelProperty(value = "Links: the following links might be used within this context:" +
                              "account link (mandatory)" +
                              "first_page_link (optional)" +
                              "second_page_link (optional)" +
                              "current_page_ link (optional)" +
                              "last_page_link (optional)", required = true)
    @NotNull
    private final Links _links;
}
