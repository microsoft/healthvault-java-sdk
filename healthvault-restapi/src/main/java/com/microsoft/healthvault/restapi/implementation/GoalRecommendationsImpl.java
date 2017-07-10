/**
 * Code generated by Microsoft (R) AutoRest Code Generator 1.1.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.healthvault.restapi.implementation;

import com.google.common.reflect.TypeToken;
import com.microsoft.healthvault.restapi.GoalRecommendations;
import com.microsoft.healthvault.restapi.models.ErrorResponseException;
import com.microsoft.healthvault.restapi.models.GoalRecommendation;
import com.microsoft.healthvault.restapi.models.GoalRecommendationInstance;
import com.microsoft.healthvault.restapi.models.GoalRecommendationsResponse;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.functions.Func1;

/**
 * An instance of this class provides access to all the operations defined
 * in GoalRecommendations.
 */
public class GoalRecommendationsImpl implements GoalRecommendations {
    /** The Retrofit service to perform REST calls. */
    private GoalRecommendationsService service;
    /** The service client containing this operation class. */
    private MicrosoftHealthVaultRestApiImpl client;

    /**
     * Initializes an instance of GoalRecommendations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public GoalRecommendationsImpl(Retrofit retrofit, MicrosoftHealthVaultRestApiImpl client) {
        this.service = retrofit.create(GoalRecommendationsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for GoalRecommendations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface GoalRecommendationsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.healthvault.restapi.GoalRecommendations get" })
        @GET("GoalRecommendations")
        Observable<Response<ResponseBody>> get(@Query("goalTypes") String goalTypes, @Query("goalWindowTypes") String goalWindowTypes);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.healthvault.restapi.GoalRecommendations create" })
        @POST("GoalRecommendations")
        Observable<Response<ResponseBody>> create(@Body GoalRecommendation goalRecommendation);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.healthvault.restapi.GoalRecommendations getById" })
        @GET("GoalRecommendations/{goalRecommendationId}")
        Observable<Response<ResponseBody>> getById(@Path("goalRecommendationId") String goalRecommendationId);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.healthvault.restapi.GoalRecommendations delete" })
        @HTTP(path = "GoalRecommendations/{goalRecommendationId}", method = "DELETE", hasBody = true)
        Observable<Response<ResponseBody>> delete(@Path("goalRecommendationId") String goalRecommendationId);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.healthvault.restapi.GoalRecommendations acknowledge" })
        @PUT("GoalRecommendations/{goalRecommendationId}/Acknowledge")
        Observable<Response<ResponseBody>> acknowledge(@Path("goalRecommendationId") String goalRecommendationId);

    }

    /**
     * Get a collection of all goal recommendations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the GoalRecommendationsResponse object if successful.
     */
    public GoalRecommendationsResponse get() {
        return getWithServiceResponseAsync().toBlocking().single().body();
    }

    /**
     * Get a collection of all goal recommendations.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<GoalRecommendationsResponse> getAsync(final ServiceCallback<GoalRecommendationsResponse> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(), serviceCallback);
    }

    /**
     * Get a collection of all goal recommendations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the GoalRecommendationsResponse object
     */
    public Observable<GoalRecommendationsResponse> getAsync() {
        return getWithServiceResponseAsync().map(new Func1<ServiceResponse<GoalRecommendationsResponse>, GoalRecommendationsResponse>() {
            @Override
            public GoalRecommendationsResponse call(ServiceResponse<GoalRecommendationsResponse> response) {
                return response.body();
            }
        });
    }

    /**
     * Get a collection of all goal recommendations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the GoalRecommendationsResponse object
     */
    public Observable<ServiceResponse<GoalRecommendationsResponse>> getWithServiceResponseAsync() {
        final String goalTypes = null;
        final String goalWindowTypes = null;
        return service.get(goalTypes, goalWindowTypes)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<GoalRecommendationsResponse>>>() {
                @Override
                public Observable<ServiceResponse<GoalRecommendationsResponse>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<GoalRecommendationsResponse> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Get a collection of all goal recommendations.
     *
     * @param goalTypes The goal types(e.g Steps, CaloriesBurned) filter.
     * @param goalWindowTypes The goal window types(e.g Daily, Weekly) filter.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the GoalRecommendationsResponse object if successful.
     */
    public GoalRecommendationsResponse get(String goalTypes, String goalWindowTypes) {
        return getWithServiceResponseAsync(goalTypes, goalWindowTypes).toBlocking().single().body();
    }

    /**
     * Get a collection of all goal recommendations.
     *
     * @param goalTypes The goal types(e.g Steps, CaloriesBurned) filter.
     * @param goalWindowTypes The goal window types(e.g Daily, Weekly) filter.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<GoalRecommendationsResponse> getAsync(String goalTypes, String goalWindowTypes, final ServiceCallback<GoalRecommendationsResponse> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(goalTypes, goalWindowTypes), serviceCallback);
    }

    /**
     * Get a collection of all goal recommendations.
     *
     * @param goalTypes The goal types(e.g Steps, CaloriesBurned) filter.
     * @param goalWindowTypes The goal window types(e.g Daily, Weekly) filter.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the GoalRecommendationsResponse object
     */
    public Observable<GoalRecommendationsResponse> getAsync(String goalTypes, String goalWindowTypes) {
        return getWithServiceResponseAsync(goalTypes, goalWindowTypes).map(new Func1<ServiceResponse<GoalRecommendationsResponse>, GoalRecommendationsResponse>() {
            @Override
            public GoalRecommendationsResponse call(ServiceResponse<GoalRecommendationsResponse> response) {
                return response.body();
            }
        });
    }

    /**
     * Get a collection of all goal recommendations.
     *
     * @param goalTypes The goal types(e.g Steps, CaloriesBurned) filter.
     * @param goalWindowTypes The goal window types(e.g Daily, Weekly) filter.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the GoalRecommendationsResponse object
     */
    public Observable<ServiceResponse<GoalRecommendationsResponse>> getWithServiceResponseAsync(String goalTypes, String goalWindowTypes) {
        return service.get(goalTypes, goalWindowTypes)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<GoalRecommendationsResponse>>>() {
                @Override
                public Observable<ServiceResponse<GoalRecommendationsResponse>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<GoalRecommendationsResponse> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<GoalRecommendationsResponse> getDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException {
        return this.client.restClient().responseBuilderFactory().<GoalRecommendationsResponse, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<GoalRecommendationsResponse>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Post a goal recommendation instance.
     *
     * @param goalRecommendation The instance of the goal recommendation to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the Object object if successful.
     */
    public Object create(GoalRecommendation goalRecommendation) {
        return createWithServiceResponseAsync(goalRecommendation).toBlocking().single().body();
    }

    /**
     * Post a goal recommendation instance.
     *
     * @param goalRecommendation The instance of the goal recommendation to create.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Object> createAsync(GoalRecommendation goalRecommendation, final ServiceCallback<Object> serviceCallback) {
        return ServiceFuture.fromResponse(createWithServiceResponseAsync(goalRecommendation), serviceCallback);
    }

    /**
     * Post a goal recommendation instance.
     *
     * @param goalRecommendation The instance of the goal recommendation to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the Object object
     */
    public Observable<Object> createAsync(GoalRecommendation goalRecommendation) {
        return createWithServiceResponseAsync(goalRecommendation).map(new Func1<ServiceResponse<Object>, Object>() {
            @Override
            public Object call(ServiceResponse<Object> response) {
                return response.body();
            }
        });
    }

    /**
     * Post a goal recommendation instance.
     *
     * @param goalRecommendation The instance of the goal recommendation to create.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the Object object
     */
    public Observable<ServiceResponse<Object>> createWithServiceResponseAsync(GoalRecommendation goalRecommendation) {
        if (goalRecommendation == null) {
            throw new IllegalArgumentException("Parameter goalRecommendation is required and cannot be null.");
        }
        Validator.validate(goalRecommendation);
        return service.create(goalRecommendation)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Object>>>() {
                @Override
                public Observable<ServiceResponse<Object>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Object> clientResponse = createDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Object> createDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Object, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<Object>() { }.getType())
                .register(201, new TypeToken<GoalRecommendation>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Get an instance of a specific goal recommendation.
     *
     * @param goalRecommendationId The goal recommendation identifier.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the GoalRecommendationInstance object if successful.
     */
    public GoalRecommendationInstance getById(String goalRecommendationId) {
        return getByIdWithServiceResponseAsync(goalRecommendationId).toBlocking().single().body();
    }

    /**
     * Get an instance of a specific goal recommendation.
     *
     * @param goalRecommendationId The goal recommendation identifier.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<GoalRecommendationInstance> getByIdAsync(String goalRecommendationId, final ServiceCallback<GoalRecommendationInstance> serviceCallback) {
        return ServiceFuture.fromResponse(getByIdWithServiceResponseAsync(goalRecommendationId), serviceCallback);
    }

    /**
     * Get an instance of a specific goal recommendation.
     *
     * @param goalRecommendationId The goal recommendation identifier.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the GoalRecommendationInstance object
     */
    public Observable<GoalRecommendationInstance> getByIdAsync(String goalRecommendationId) {
        return getByIdWithServiceResponseAsync(goalRecommendationId).map(new Func1<ServiceResponse<GoalRecommendationInstance>, GoalRecommendationInstance>() {
            @Override
            public GoalRecommendationInstance call(ServiceResponse<GoalRecommendationInstance> response) {
                return response.body();
            }
        });
    }

    /**
     * Get an instance of a specific goal recommendation.
     *
     * @param goalRecommendationId The goal recommendation identifier.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the GoalRecommendationInstance object
     */
    public Observable<ServiceResponse<GoalRecommendationInstance>> getByIdWithServiceResponseAsync(String goalRecommendationId) {
        if (goalRecommendationId == null) {
            throw new IllegalArgumentException("Parameter goalRecommendationId is required and cannot be null.");
        }
        return service.getById(goalRecommendationId)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<GoalRecommendationInstance>>>() {
                @Override
                public Observable<ServiceResponse<GoalRecommendationInstance>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<GoalRecommendationInstance> clientResponse = getByIdDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<GoalRecommendationInstance> getByIdDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<GoalRecommendationInstance, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<GoalRecommendationInstance>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Delete a goal recommendation instance.
     *
     * @param goalRecommendationId The identifier of the goal recommendation to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the Object object if successful.
     */
    public Object delete(String goalRecommendationId) {
        return deleteWithServiceResponseAsync(goalRecommendationId).toBlocking().single().body();
    }

    /**
     * Delete a goal recommendation instance.
     *
     * @param goalRecommendationId The identifier of the goal recommendation to delete.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Object> deleteAsync(String goalRecommendationId, final ServiceCallback<Object> serviceCallback) {
        return ServiceFuture.fromResponse(deleteWithServiceResponseAsync(goalRecommendationId), serviceCallback);
    }

    /**
     * Delete a goal recommendation instance.
     *
     * @param goalRecommendationId The identifier of the goal recommendation to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the Object object
     */
    public Observable<Object> deleteAsync(String goalRecommendationId) {
        return deleteWithServiceResponseAsync(goalRecommendationId).map(new Func1<ServiceResponse<Object>, Object>() {
            @Override
            public Object call(ServiceResponse<Object> response) {
                return response.body();
            }
        });
    }

    /**
     * Delete a goal recommendation instance.
     *
     * @param goalRecommendationId The identifier of the goal recommendation to delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the Object object
     */
    public Observable<ServiceResponse<Object>> deleteWithServiceResponseAsync(String goalRecommendationId) {
        if (goalRecommendationId == null) {
            throw new IllegalArgumentException("Parameter goalRecommendationId is required and cannot be null.");
        }
        return service.delete(goalRecommendationId)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Object>>>() {
                @Override
                public Observable<ServiceResponse<Object>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Object> clientResponse = deleteDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Object> deleteDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Object, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<Object>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Updates the goal recommendation to acknowledged state.
     *
     * @param goalRecommendationId The identifier of the goal recommendation to acknowledge.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the Object object if successful.
     */
    public Object acknowledge(String goalRecommendationId) {
        return acknowledgeWithServiceResponseAsync(goalRecommendationId).toBlocking().single().body();
    }

    /**
     * Updates the goal recommendation to acknowledged state.
     *
     * @param goalRecommendationId The identifier of the goal recommendation to acknowledge.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Object> acknowledgeAsync(String goalRecommendationId, final ServiceCallback<Object> serviceCallback) {
        return ServiceFuture.fromResponse(acknowledgeWithServiceResponseAsync(goalRecommendationId), serviceCallback);
    }

    /**
     * Updates the goal recommendation to acknowledged state.
     *
     * @param goalRecommendationId The identifier of the goal recommendation to acknowledge.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the Object object
     */
    public Observable<Object> acknowledgeAsync(String goalRecommendationId) {
        return acknowledgeWithServiceResponseAsync(goalRecommendationId).map(new Func1<ServiceResponse<Object>, Object>() {
            @Override
            public Object call(ServiceResponse<Object> response) {
                return response.body();
            }
        });
    }

    /**
     * Updates the goal recommendation to acknowledged state.
     *
     * @param goalRecommendationId The identifier of the goal recommendation to acknowledge.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the Object object
     */
    public Observable<ServiceResponse<Object>> acknowledgeWithServiceResponseAsync(String goalRecommendationId) {
        if (goalRecommendationId == null) {
            throw new IllegalArgumentException("Parameter goalRecommendationId is required and cannot be null.");
        }
        return service.acknowledge(goalRecommendationId)
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Object>>>() {
                @Override
                public Observable<ServiceResponse<Object>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Object> clientResponse = acknowledgeDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Object> acknowledgeDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Object, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<Object>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

}