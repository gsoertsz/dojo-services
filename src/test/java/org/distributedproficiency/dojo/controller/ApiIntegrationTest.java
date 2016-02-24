package org.distributedproficiency.dojo.controller;

import org.distributedproficiency.dojo.DojoServiceProxy;
import org.distributedproficiency.dojo.UnsafeHttpsClient;
import org.distributedproficiency.dojo.client.SecuredRestBuilder;
import org.distributedproficiency.dojo.dto.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.client.Response;

@RunWith(JUnit4.class)
public class ApiIntegrationTest {

    private final String USERNAME = "gsoertsz";
    private final String PASSWORD = "pass";
    private final String ADMIN_USERNAME = "superuser";
    private final String ADMIN_PASSWORD = "imimpatient";
    private final String CLIENT_ID = "web";

    private final String TEST_URL = "http://localhost:8081";


    private DojoServiceProxy dojoServiceProxy = new SecuredRestBuilder()
            .setLoginEndpoint(TEST_URL + DojoServiceProxy.TOKEN_RSC_PATH)
            .setUsername(USERNAME)
            .setPassword(PASSWORD)
            .setClientId(CLIENT_ID)
            .setClient(new OkClient(UnsafeHttpsClient.getUnsafeOkHttpClient()))
            .setEndpoint(TEST_URL).setLogLevel(RestAdapter.LogLevel.FULL).build()
            .create(DojoServiceProxy.class);

    private DojoServiceProxy nonSslDojoServiceProxy = new SecuredRestBuilder()
            .setLoginEndpoint(TEST_URL + DojoServiceProxy.TOKEN_RSC_PATH)
            .setUsername(USERNAME)
            .setPassword(PASSWORD)
            .setClientId(CLIENT_ID)
            .setClient(new OkClient(UnsafeHttpsClient.unsafeNonSslHttpClient()))
            .setEndpoint(TEST_URL).setLogLevel(RestAdapter.LogLevel.FULL).build()
            .create(DojoServiceProxy.class);

    private DojoServiceProxy adminServiceProxy = new SecuredRestBuilder()
            .setLoginEndpoint(TEST_URL + DojoServiceProxy.TOKEN_RSC_PATH)
            .setUsername(ADMIN_USERNAME)
            .setPassword(ADMIN_PASSWORD)
            .setClientId(CLIENT_ID)
            .setClient(new OkClient(UnsafeHttpsClient.getUnsafeOkHttpClient()))
            .setEndpoint(TEST_URL).setLogLevel(RestAdapter.LogLevel.FULL).build()
            .create(DojoServiceProxy.class);
    
    private DojoServiceProxy unsecuredProxy = new RestAdapter.Builder()
    		.setClient(new OkClient(UnsafeHttpsClient.getUnsafeOkHttpClient()))
    		.setLogLevel(RestAdapter.LogLevel.FULL)
    		.setEndpoint(TEST_URL)
    		.build()
    		.create(DojoServiceProxy.class);
        
    @Ignore
    @Test
    public void testCompleteRegistration() {

        InitiatedRegistrationResponse response
             = unsecuredProxy.initiateRegistration(new InitiateRegistrationRequest());

        RegistrationRequest request
                = new RegistrationRequest();
        request.setEmail("gsoertsz@odecee.com.au");
        request.setFirstName("Greg");
        request.setLastName("Soertsz");
        request.setPrimaryPhone("0407130312");
        request.setUsername("gsoertsz");

        Response regoResponse = adminServiceProxy.completeRegistration(request, response.getRegistrationKey());
        Assert.assertTrue(regoResponse.getStatus() == 200);
        Response approvalResponse = adminServiceProxy.approveRegistration(new Long(1).longValue());
        Assert.assertTrue(approvalResponse.getStatus() == 200);

        response = adminServiceProxy.initiateRegistration(new InitiateRegistrationRequest());

        request = new RegistrationRequest();
        request.setEmail("alana@gmail.com");
        request.setFirstName("Alana");
        request.setLastName("Soertsz");
        request.setPrimaryPhone("123456789");
        request.setUsername("alana");

        regoResponse = adminServiceProxy.completeRegistration(request, response.getRegistrationKey());
        Assert.assertTrue(regoResponse.getStatus() == 200);
        approvalResponse = adminServiceProxy.approveRegistration(new Long(2).longValue());
        Assert.assertTrue(approvalResponse.getStatus() == 200);

        // create an admin user

        adminServiceProxy.createAdminUser("gsoertszadmin");

    }

    @Ignore
    @Test
    public void testCreateKataAsAuthor() {
        KataCreateRequest request = new KataCreateRequest();
        request.setAuthorId("gsoertsz");

        KataCreatedResponse response
                    = nonSslDojoServiceProxy.initiateCreateKata(request);
    }

    @Test
    public void testCreateAuthor() {

        UserCreateRequest ucr = new UserCreateRequest();
        ucr.setUsername("gsoertsz");

        UserCreatedResponse response
                 = nonSslDojoServiceProxy.createUser(ucr);
    }
}
