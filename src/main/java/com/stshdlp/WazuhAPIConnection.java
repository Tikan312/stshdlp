package com.stshdlp;

import okhttp3.*;
import java.io.IOException;

public class WazuhAPIConnection {
    private static final String BASE_URL = "https://127.0.0.1:55000/api";
    private static String token;

    public static void main(String[] args) throws IOException {
        String token = WazuhAPIConnection.authenticate("user", "");

    }

    // Метод для получения токена
    public static String authenticate(String username, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Тело запроса
        String json = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        RequestBody body = RequestBody.create(
                json, MediaType.get("application/json")
        );

        // Создаем запрос
        Request request = new Request.Builder()
                .url(BASE_URL + "/security/user/authenticate")
                .post(body)
                .build();

        // Выполняем запрос
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                token = new com.fasterxml.jackson.databind.ObjectMapper()
                        .readTree(responseBody)
                        .get("data")
                        .get("token")
                        .asText();
                System.out.println("Token: " + token);
                return token;
            } else {
                throw new IOException("Authentication failed: " + response.code());
            }
        }
    }

    // Метод для создания авторизованных запросов
    public static Request.Builder authorizedRequest(String endpoint) {
        return new Request.Builder()
                .url(BASE_URL + endpoint)
                .header("Authorization", "Bearer " + token);
    }
}
