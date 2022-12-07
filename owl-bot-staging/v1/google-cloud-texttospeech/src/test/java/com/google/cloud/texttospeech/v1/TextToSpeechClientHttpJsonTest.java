/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.texttospeech.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.texttospeech.v1.stub.HttpJsonTextToSpeechStub;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TextToSpeechClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TextToSpeechClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTextToSpeechStub.getMethodDescriptors(),
            TextToSpeechSettings.getDefaultEndpoint());
    TextToSpeechSettings settings =
        TextToSpeechSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TextToSpeechSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TextToSpeechClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listVoicesTest() throws Exception {
    ListVoicesResponse expectedResponse =
        ListVoicesResponse.newBuilder().addAllVoices(new ArrayList<Voice>()).build();
    mockService.addResponse(expectedResponse);

    String languageCode = "languageCode-2092349083";

    ListVoicesResponse actualResponse = client.listVoices(languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listVoicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String languageCode = "languageCode-2092349083";
      client.listVoices(languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void synthesizeSpeechTest() throws Exception {
    SynthesizeSpeechResponse expectedResponse =
        SynthesizeSpeechResponse.newBuilder().setAudioContent(ByteString.EMPTY).build();
    mockService.addResponse(expectedResponse);

    SynthesisInput input = SynthesisInput.newBuilder().build();
    VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().build();
    AudioConfig audioConfig = AudioConfig.newBuilder().build();

    SynthesizeSpeechResponse actualResponse = client.synthesizeSpeech(input, voice, audioConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void synthesizeSpeechExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SynthesisInput input = SynthesisInput.newBuilder().build();
      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().build();
      AudioConfig audioConfig = AudioConfig.newBuilder().build();
      client.synthesizeSpeech(input, voice, audioConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
