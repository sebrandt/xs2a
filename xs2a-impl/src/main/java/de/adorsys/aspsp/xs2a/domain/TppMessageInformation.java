package de.adorsys.aspsp.xs2a.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.adorsys.aspsp.xs2a.exception.MessageCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@ApiModel(description = "Tpp Message Information", value = "TppMessageInformation")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TppMessageInformation {

	@ApiModelProperty(value = "Category of the error, Only ”ERROR” or \"WARNING\" permitted", required = true, example = "Error")
	private MessageCategory category;

	@ApiModelProperty(value = "Code", required = true)
	private MessageCode code;

    @ApiModelProperty(value = "Path")
    private String path;

	@ApiModelProperty(value = "Additional explanation text", example = "Additional text information of the ASPSP up to 512 characters")
    @Size(max = 512)
	private String text;

    public TppMessageInformation(MessageCategory category, MessageCode code) {
        this.category = category;
        this.code = code;
    }

    public TppMessageInformation path(String path){
        this.path = path;
        return this;
    }

    public TppMessageInformation text(String text){
        this.text = text;
        return this;
    }
}
