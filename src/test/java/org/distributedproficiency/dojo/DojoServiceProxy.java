package org.distributedproficiency.dojo;

import java.util.Collection;

import org.distributedproficiency.dojo.domain.Kata;
import org.distributedproficiency.dojo.domain.Student;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.dto.*;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface DojoServiceProxy {

    public final static String TOKEN_RSC_PATH = "/dojo/oauth/token";

    public final static String BASE_CTX_PATH_ELEM = "/dojo";

    /**************** USERS *********************/

    public static final String USER_RSC_PATH = BASE_CTX_PATH_ELEM + "/users";

    @POST(value = USER_RSC_PATH)
    public UserCreatedResponse createUser(@Body UserCreateRequest request);

    @GET(value=USER_RSC_PATH)
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


    /***************** KATA ***********************/

    public final static String KATA_RSC_PATH = BASE_CTX_PATH_ELEM + "/katas";

    @POST(value = BASE_CTX_PATH_ELEM)
    public KataCreatedResponse initiateCreateKata(@Body KataCreateRequest request);
}
