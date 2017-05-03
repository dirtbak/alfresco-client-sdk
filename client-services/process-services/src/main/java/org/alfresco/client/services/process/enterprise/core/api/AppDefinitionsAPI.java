/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.alfresco.client.services.process.enterprise.core.api;

import org.alfresco.client.services.process.enterprise.core.model.editor.AppDefinitionPublishRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.AppDefinitionRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.AppDefinitionSaveRepresentation;
import org.alfresco.client.services.process.enterprise.core.model.editor.AppDefinitionUpdateResultRepresentation;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface AppDefinitionsAPI
{
    // ///////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/app-definitions/{modelId}")
    Call<AppDefinitionRepresentation> getAppDefinitionCall(@Path("modelId") String modelId);

    // ///////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/app-definitions/{modelId}")
    Call<AppDefinitionUpdateResultRepresentation> getAppDefinitionCall(@Path("modelId") String modelId,
            @Body AppDefinitionSaveRepresentation appDefinitionSaveRepresentation);

    // ///////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////
    @DELETE("api/enterprise/app-definitions/{appDefinitionId}")
    Call<Void> deleteAppDefinitionCall(@Path("appDefinitionId") String appDefinitionId);

    // ///////////////////////////////////////////////////////////////////
    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @Streaming
    @GET("api/enterprise/app-definitions/{modelId}/export")
    Call<ResponseBody> exportAppDefinitionCall(@Path("modelId") String modelId);

    @Multipart
    @POST("api/enterprise/app-definitions/{modelId}/import")
    Call<AppDefinitionRepresentation> importAppDefinitionCall(@Path("modelId") String modelId,
            @Part("file") RequestBody file);

    @Multipart
    @POST("api/enterprise/app-definitions/import")
    Call<AppDefinitionRepresentation> importAppDefinitionCall(@Part("file") RequestBody file,
            @Query("renewIdmEntries") String renewIdmEntries);

    // ///////////////////////////////////////////////////////////////////
    // PUBLISH
    // ///////////////////////////////////////////////////////////////////
    @Multipart
    @POST("api/enterprise/app-definitions/{modelId}/publish")
    Call<AppDefinitionUpdateResultRepresentation> publishAppDefinitionCall(@Path("modelId") String modelId,
            @Body AppDefinitionPublishRepresentation publishModel);

    @Multipart
    @POST("api/enterprise/app-definitions/{modelId}/publish-app")
    Call<AppDefinitionUpdateResultRepresentation> importAndPublishAppCall(@Path("modelId") String modelId,
            @Part("file") RequestBody file);

    @Multipart
    @POST("api/enterprise/app-definitions/publish-app")
    Call<AppDefinitionUpdateResultRepresentation> importAndPublishAppCall(@Part("file") RequestBody file);

    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////////////

    // ///////////////////////////////////////////////////////////////////
    // GET
    // ///////////////////////////////////////////////////////////////////
    @GET("api/enterprise/app-definitions/{modelId}")
    Observable<AppDefinitionRepresentation> getAppDefinitionObservable(@Path("modelId") String modelId);

    // ///////////////////////////////////////////////////////////////////
    // UPDATE
    // ///////////////////////////////////////////////////////////////////
    @Headers({ "Content-type: application/json" })
    @PUT("api/enterprise/app-definitions/{modelId}")
    Observable<AppDefinitionUpdateResultRepresentation> getAppDefinitionObservable(@Path("modelId") String modelId,
            @Body AppDefinitionSaveRepresentation appDefinitionSaveRepresentation);

    // ///////////////////////////////////////////////////////////////////
    // DELETE
    // ///////////////////////////////////////////////////////////////////
    @DELETE("api/enterprise/app-definitions/{appDefinitionId}")
    Observable<Void> deleteAppDefinitionObservable(@Path("appDefinitionId") String appDefinitionId);

    // ///////////////////////////////////////////////////////////////////
    // ACTIONS
    // ///////////////////////////////////////////////////////////////////
    @Streaming
    @GET("api/enterprise/app-definitions/{modelId}/export")
    Observable<ResponseBody> exportAppDefinitionObservable(@Path("modelId") String modelId);

    @Multipart
    @POST("api/enterprise/app-definitions/{modelId}/import")
    Observable<AppDefinitionRepresentation> importAppDefinitionObservable(@Path("modelId") String modelId,
            @Part("file") RequestBody file);

    @Multipart
    @POST("api/enterprise/app-definitions/import")
    Observable<AppDefinitionRepresentation> importAppDefinitionObservable(@Part("file") RequestBody file,
            @Query("renewIdmEntries") String renewIdmEntries);

    // ///////////////////////////////////////////////////////////////////
    // PUBLISH
    // ///////////////////////////////////////////////////////////////////
    @Multipart
    @POST("api/enterprise/app-definitions/{modelId}/publish")
    Observable<AppDefinitionUpdateResultRepresentation> publishAppDefinitionObservable(@Path("modelId") String modelId,
            @Body AppDefinitionPublishRepresentation publishModel);

    @Multipart
    @POST("api/enterprise/app-definitions/{modelId}/publish-app")
    Observable<AppDefinitionUpdateResultRepresentation> importAndPublishAppObservable(@Path("modelId") String modelId,
            @Part("file") RequestBody file);

    @Multipart
    @POST("api/enterprise/app-definitions/publish-app")
    Observable<AppDefinitionUpdateResultRepresentation> importAndPublishAppObservable(@Part("file") RequestBody file);

}
