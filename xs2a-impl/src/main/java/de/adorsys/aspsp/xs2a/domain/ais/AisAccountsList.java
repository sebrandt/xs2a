package de.adorsys.aspsp.xs2a.domain.ais;

import de.adorsys.aspsp.xs2a.domain.SingleAccountAccess;
import de.adorsys.aspsp.xs2a.domain.TransactionStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "Response for created by some methods in the consent Service")
public class AisAccountsList {
	private SingleAccountAccess[] accounts;
	private String valid_until;
	private Integer frequency_per_day;
	private boolean recurring_indicator;
	private TransactionStatus transaction_status;
	private String consent_status;
}


