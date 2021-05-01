package org.hit.android.haim.texasholdem.web.services;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Lists all restful web services related to Chat controllers at Texas Holdem backend
 * @author Haim Adrian
 * @since 15-Apr-21
 * @see org.hit.android.haim.texasholdem.web.TexasHoldemWebService
 */
public interface ChatService {
    /* ***************************** Channel Controller ***************************** */
    /** @return Channel or Error */
    @GET("/channel/{channelName}")
    Call<JsonNode> getChannel(@Path("channelName") String channelName);


    /* ***************************** Message Controller ***************************** */
    /** @return Message or Error */
    @POST("/message/{channelName}/{userId}")
    Call<JsonNode> sendMessage(@Path("channelName") String channelName, @Path("userId") String userId, @Body String message);

    /** @return {@code List<Message>} or Error */
    @GET("/message/{channelName}")
    Call<JsonNode> getAllMessagesInChannel(@Path("channelName") String channelName);

    /** @return {@code List<Message>} or Error */
    @GET("/message/{channelName}/since/{lastMessageDateTime}")
    Call<JsonNode> getLatestMessagesInChannel(@Path("channelName") String channelName, @Path("lastMessageDateTime") LocalDateTime lastMessageDateTime);

    /** @return Message or Error */
    @GET("/message/info/{messageId}")
    Call<JsonNode> getMessageInfo(@Path("userId") String messageId);

    /** @return {@code List<Message>} or Error */
    @GET("/message/info")
    Call<JsonNode> getMessagesInfo(@Body List<String> messagesId);
}