package com.smockin.admin.persistence.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mgallina.
 */
@Entity
@Table(name = "REST_MOCK_DEF")
public class RestfulMockDefinitionOrder extends Identifier {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REST_MOCK_ID", nullable = false)
    private RestfulMock restfulMock;

    @Column(name = "HTTP_STATUS_CODE", nullable = false)
    private int httpStatusCode;

    @Column(name = "RESPONSE_CONTENT_TYPE", nullable = false, length = 100)
    private String responseContentType;

    @Column(name = "RESPONSE_BODY", nullable = true, length = 5000)
    private String responseBody;

    @Column(name = "ORDER_NO", nullable = false)
    private int orderNo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="REST_MOCK_DEF_RES_HDR")
    private Map<String, String> responseHeaders = new HashMap<String, String>();

    public RestfulMockDefinitionOrder() {
    }

    public RestfulMockDefinitionOrder(RestfulMock restfulMock, int httpStatusCode, String responseContentType, String responseBody, int orderNo) {
        this.restfulMock = restfulMock;
        this.httpStatusCode = httpStatusCode;
        this.responseContentType = responseContentType;
        this.responseBody = responseBody;
        this.orderNo = orderNo;
    }

    public RestfulMock getRestfulMock() {
        return restfulMock;
    }
    public void setRestfulMock(RestfulMock RestfulMock) {
        this.restfulMock = restfulMock;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getResponseContentType() {
        return responseContentType;
    }
    public void setResponseContentType(String responseContentType) {
        this.responseContentType = responseContentType;
    }

    public String getResponseBody() {
        return responseBody;
    }
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public int getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }
    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

}
