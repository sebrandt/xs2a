package de.adorsys.multibankingxs2a.domain;


import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aro on 27.11.17.
 */
@Data
@ApiModel(description = "Response Body generated by some methods in the AccountController ")
public class TransactionsResponse  {

   private Links _links;
  
   private AccountReport transactions;

}

