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

package com.google.cloud.texttospeech.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.texttospeech.v1beta1.stub.TextToSpeechLongAudioSynthesizeStub;
import com.google.cloud.texttospeech.v1beta1.stub.TextToSpeechLongAudioSynthesizeStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service that implements Google Cloud Text-to-Speech API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TextToSpeechLongAudioSynthesizeClient textToSpeechLongAudioSynthesizeClient =
 *     TextToSpeechLongAudioSynthesizeClient.create()) {
 *   SynthesizeLongAudioRequest request =
 *       SynthesizeLongAudioRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setInput(SynthesisInput.newBuilder().build())
 *           .setAudioConfig(AudioConfig.newBuilder().build())
 *           .setOutputGcsUri("outputGcsUri-489598154")
 *           .setVoice(VoiceSelectionParams.newBuilder().build())
 *           .build();
 *   SynthesizeLongAudioResponse response =
 *       textToSpeechLongAudioSynthesizeClient.synthesizeLongAudioAsync(request).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TextToSpeechLongAudioSynthesizeClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * TextToSpeechLongAudioSynthesizeSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TextToSpeechLongAudioSynthesizeSettings textToSpeechLongAudioSynthesizeSettings =
 *     TextToSpeechLongAudioSynthesizeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TextToSpeechLongAudioSynthesizeClient textToSpeechLongAudioSynthesizeClient =
 *     TextToSpeechLongAudioSynthesizeClient.create(textToSpeechLongAudioSynthesizeSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TextToSpeechLongAudioSynthesizeSettings textToSpeechLongAudioSynthesizeSettings =
 *     TextToSpeechLongAudioSynthesizeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TextToSpeechLongAudioSynthesizeClient textToSpeechLongAudioSynthesizeClient =
 *     TextToSpeechLongAudioSynthesizeClient.create(textToSpeechLongAudioSynthesizeSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TextToSpeechLongAudioSynthesizeSettings textToSpeechLongAudioSynthesizeSettings =
 *     TextToSpeechLongAudioSynthesizeSettings.newHttpJsonBuilder().build();
 * TextToSpeechLongAudioSynthesizeClient textToSpeechLongAudioSynthesizeClient =
 *     TextToSpeechLongAudioSynthesizeClient.create(textToSpeechLongAudioSynthesizeSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TextToSpeechLongAudioSynthesizeClient implements BackgroundResource {
  private final TextToSpeechLongAudioSynthesizeSettings settings;
  private final TextToSpeechLongAudioSynthesizeStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TextToSpeechLongAudioSynthesizeClient with default settings. */
  public static final TextToSpeechLongAudioSynthesizeClient create() throws IOException {
    return create(TextToSpeechLongAudioSynthesizeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TextToSpeechLongAudioSynthesizeClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final TextToSpeechLongAudioSynthesizeClient create(
      TextToSpeechLongAudioSynthesizeSettings settings) throws IOException {
    return new TextToSpeechLongAudioSynthesizeClient(settings);
  }

  /**
   * Constructs an instance of TextToSpeechLongAudioSynthesizeClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(TextToSpeechLongAudioSynthesizeSettings).
   */
  public static final TextToSpeechLongAudioSynthesizeClient create(
      TextToSpeechLongAudioSynthesizeStub stub) {
    return new TextToSpeechLongAudioSynthesizeClient(stub);
  }

  /**
   * Constructs an instance of TextToSpeechLongAudioSynthesizeClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected TextToSpeechLongAudioSynthesizeClient(TextToSpeechLongAudioSynthesizeSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((TextToSpeechLongAudioSynthesizeStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TextToSpeechLongAudioSynthesizeClient(TextToSpeechLongAudioSynthesizeStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TextToSpeechLongAudioSynthesizeSettings getSettings() {
    return settings;
  }

  public TextToSpeechLongAudioSynthesizeStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synthesizes long form text asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechLongAudioSynthesizeClient textToSpeechLongAudioSynthesizeClient =
   *     TextToSpeechLongAudioSynthesizeClient.create()) {
   *   SynthesizeLongAudioRequest request =
   *       SynthesizeLongAudioRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInput(SynthesisInput.newBuilder().build())
   *           .setAudioConfig(AudioConfig.newBuilder().build())
   *           .setOutputGcsUri("outputGcsUri-489598154")
   *           .setVoice(VoiceSelectionParams.newBuilder().build())
   *           .build();
   *   SynthesizeLongAudioResponse response =
   *       textToSpeechLongAudioSynthesizeClient.synthesizeLongAudioAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SynthesizeLongAudioResponse, SynthesizeLongAudioMetadata>
      synthesizeLongAudioAsync(SynthesizeLongAudioRequest request) {
    return synthesizeLongAudioOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synthesizes long form text asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechLongAudioSynthesizeClient textToSpeechLongAudioSynthesizeClient =
   *     TextToSpeechLongAudioSynthesizeClient.create()) {
   *   SynthesizeLongAudioRequest request =
   *       SynthesizeLongAudioRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInput(SynthesisInput.newBuilder().build())
   *           .setAudioConfig(AudioConfig.newBuilder().build())
   *           .setOutputGcsUri("outputGcsUri-489598154")
   *           .setVoice(VoiceSelectionParams.newBuilder().build())
   *           .build();
   *   OperationFuture<SynthesizeLongAudioResponse, SynthesizeLongAudioMetadata> future =
   *       textToSpeechLongAudioSynthesizeClient
   *           .synthesizeLongAudioOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SynthesizeLongAudioResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SynthesizeLongAudioRequest, SynthesizeLongAudioResponse, SynthesizeLongAudioMetadata>
      synthesizeLongAudioOperationCallable() {
    return stub.synthesizeLongAudioOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Synthesizes long form text asynchronously.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TextToSpeechLongAudioSynthesizeClient textToSpeechLongAudioSynthesizeClient =
   *     TextToSpeechLongAudioSynthesizeClient.create()) {
   *   SynthesizeLongAudioRequest request =
   *       SynthesizeLongAudioRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInput(SynthesisInput.newBuilder().build())
   *           .setAudioConfig(AudioConfig.newBuilder().build())
   *           .setOutputGcsUri("outputGcsUri-489598154")
   *           .setVoice(VoiceSelectionParams.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       textToSpeechLongAudioSynthesizeClient.synthesizeLongAudioCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SynthesizeLongAudioRequest, Operation> synthesizeLongAudioCallable() {
    return stub.synthesizeLongAudioCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
