/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.texttospeech.v1;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TextToSpeechTest {

  @Test
  public void synthesizeSpeechTest() throws IOException {
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      SynthesisInput input = SynthesisInput.newBuilder().setText("Hello, World!").build();

      VoiceSelectionParams voice =
          VoiceSelectionParams.newBuilder()
              .setLanguageCode("en-US")
              .setSsmlGender(SsmlVoiceGender.NEUTRAL)
              .build();

      AudioConfig audioConfig =
          AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();

      SynthesizeSpeechResponse response =
          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

      ByteString audioContents = response.getAudioContent();

      Assert.assertTrue(!audioContents.isEmpty());
    }
  }

  @Test
  public void listVoicesTest() throws IOException {
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      ListVoicesRequest request = ListVoicesRequest.getDefaultInstance();

      ListVoicesResponse response = textToSpeechClient.listVoices(request);
      List<Voice> voices = response.getVoicesList();

      Assert.assertTrue(!voices.isEmpty());
    }
  }
}
