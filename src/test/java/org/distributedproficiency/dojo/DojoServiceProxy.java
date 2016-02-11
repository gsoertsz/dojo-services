package org.distributedproficiency.dojo;

import java.util.Collection;

import org.distributedproficiency.dojo.domain.Student;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.dto.InitiateRegistrationRequest;
import org.distributedproficiency.dojo.dto.InitiatedRegistrationResponse;
import org.distributedproficiency.dojo.dto.RegistrationRequest;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface DojoServiceProxy {

    public final static String TOKEN_RSC_PATH = "/oauth/token";

    /**************** USERS *********************/

    @GET(value="/user")
    public User getUser();

    @POST(value="/users/admin/{username}")
    public User createAdminUser(@Path("username") String username);

    /**************** REGISTRATION **************/

    public final static String REGISTRATION_RSC_PATH = "/registrations";

    public final static String REGISTRATION_KEY = "registrationKey";

    public final static String REGISTRATION_ID = "id";

    @POST(value=REGISTRATION_RSC_PATH)
    public InitiatedRegistrationResponse initiateRegistration(@Body InitiateRegistrationRequest request);

    @PUT(value=REGISTRATION_RSC_PATH + "/{" + REGISTRATION_KEY + "}")
    public Response completeRegistration(
            @Body RegistrationRequest request,
            @Path(REGISTRATION_KEY) String registrationKey);

    @PUT(value=REGISTRATION_RSC_PATH + "/{" +REGISTRATION_ID+ "}/approve")
    public Response approveRegistration(@Path(REGISTRATION_ID) Long id);

    /**************** PATIENTS ******************/

    public final static String NAME_QUERY_PARAM = "name";

    public final static String PATIENT_RSC_PATH_NAME = "/patients";

    public final static String PATIENT_ID_PARAM_NAME = "id";

    public final static String PATIENT_SEARCH_PATH_ELEM = "search";

    public final static String PATIENT_SEARCH_URI = PATIENT_RSC_PATH_NAME + "/" + PATIENT_SEARCH_PATH_ELEM;

    @GET(value = PATIENT_RSC_PATH_NAME + "/{"+PATIENT_ID_PARAM_NAME+"}")
    public Student getPatientById(@Path(PATIENT_ID_PARAM_NAME) Long id);


}
