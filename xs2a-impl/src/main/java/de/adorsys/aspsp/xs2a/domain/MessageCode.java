package de.adorsys.aspsp.xs2a.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "MessageCode", value = "Message error codes and related http response codes.")
public enum MessageCode {
    CERTIFICATE_INVALID(401),  // "The contents of the signature/corporate seal certificate are not matching PSD2 general PSD2 or attribute requirements
    CERTIFICATE_EXPIRED(401),  //Signature/corporate seal certificate is expired
    CERTIFICATE_BLOCKED(401),  //Signature/corporate seal certificate has been blocked by the ASPSP
    CERTIFICATE_REVOKED(401),  //Signature/corporate seal certificate has been revoked by QSTP
    CERTIFICATE_MISSING(401),  //Signature/corporate seal certificate was not available in the request but is mandated for the corresponding
    SIGNATURE_INVALID(401),  //Application layer eIDAS Signature for TPP authentication is not correct
    SIGNATURE_MISSING(401),  //Apllication layer eIDAS Signature for TPP authentication is mandated by the ASPSP but is missing
    FORMAT_ERROR(400),  //Format of certain request fields are not matching the XS2A requirements. An explicit path to the corresponding field might be added in the return message
    PSU_CREDENTIALS_INVALID(401),  // The PSU-ID cannot be matched by the addressed ASPSP or is blocked, or a password resp. OTP was not correct. Additional information might be added
    CORPORATE_ID_INVALID(401),  //The PSU-Corporate-ID cannot be matched by the addressed ASPSP
    CONSENT_INVALID(401),  //The consent was created by this TPP but is not valid for the addressed service/resource
    CONSENT_EXPIRED(401),  //The consent was created by this TPP but has expired and needs to be renewed
    TOKEN_UNKNOWN(401),  //The OAuth2 token cannot be matched by the ASPSP relative to the TPP
    TOKEN_INVALID(401),  //The OAuth2 token is associated to the TPP but is not valid for the addressed service/resource
    TOKEN_EXPIRED(401),  //The OAuth2 token is associated to the TPP but has expired and needs to be renewed

    TIMESTAMP_INVALID(400),  //Timestamp not in accepted time period
    PERIOD_INVALID(400),  //Requested time period out of bound
    SCA_METHOD_UNKNOWN(400),  //Addressed SCA method in the AuthenticationObject Mehtod Select Request is unknown or cannot be matched by the ASPSP with the PSU
    TRANSACTION_ID_INVALID(400),  //The TPP-Transaction-ID is not matching the temporary resource

    //PIS specific error codes
    PRODUCT_INVALID(403),  //The addressed payment product is not available for the PSU
    PRODUCT_UNKNOWN(404),  //The addressed payment product is not supported by the ASPSP
    PAYMENT_FAILED(400),  //The payment initiation POST request failed during the initial process.. Additional information may be provided by the ASPSP
    REQUIRED_KID_MISSING(401),  //The payment initiation has failed due to a missing KID. This is a specific message code for the Norwegian market, where ASPSP can require the payer to transmit the KID

    // AIS specific error code
    //todo task: https://git.adorsys.de/adorsys/xs2a/aspsp-xs2a/issues/38
    //CONSENT_INVALID(401, "The consent definition is not complete or invalid. In case of being not complete, the bank is not supporting a completion of the consent towards the PSU. Additional information will be provided."),
    SESSIONS_NOT_SUPPORTED(400),  //The combined service flag may not be used with this ASPSP
    ACCESS_EXCEEDED(429),  //The access on the account has been exceeding the consented multiplicity per day
    REQUESTED_FORMATS_INVALID(401),  //The requested formats in the Accept header entry are not matching the formats offered by the ASPSP.");

    //SERVICE_INVALID : The addressed service is not valid for the addressed resources or the submitted data
    SERVICE_INVALID_401(401),  //401 - if payload
    SERVICE_INVALID_405(405),  //405 -if http method
    SERVICE_BLOCKED(403),  //This service is not reachable for the addressed PSU due to a channel independent blocking by the ASPSP. Additional information might be given by the ASPSP

    //CONSENT_UNKNOWN: The consent-ID cannot be matched by the ASPSP relative to the TPP
    CONSENT_UNKNOWN_403(403),  //403 - if path
    CONSENT_UNKNOWN_400(400),  //400 - if payload

    //RESOURCE_UNKNOWN_404: The addressed resource is unknown relative to the TPP
    RESOURCE_UNKNOWN_404(404), // 404 - if account-id in path
    RESOURCE_UNKNOWN_403(403), // 403 - if other resource in path
    RESOURCE_UNKNOWN_400(400), // 400 - if payload

    // RESOURCE_EXPIRED : The addressed resource is associated with the TPP but has expired, not addressable anymore
    RESOURCE_EXPIRED_403(403), // 403 if path
    RESOURCE_EXPIRED_400(400), // 400 if payload
    INTERNAL_SERVER_ERROR(500);

    @ApiModelProperty(value = "code", example = "400")
    private int code;

    @JsonCreator
    MessageCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @JsonValue
    public String getName() {
        return this.name();
    }
}
