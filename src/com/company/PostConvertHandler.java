package com.company;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.*;
import java.util.stream.Collectors;

public class PostConvertHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "This is the response";
        httpExchange.sendResponseHeaders(200, response.length());
        InputStream stream = httpExchange.getRequestBody();
        String body = new BufferedReader(new InputStreamReader(stream))
                .lines().collect(Collectors.joining("\n"));
        JSONObject jsonObject = new JSONObject(body);
        System.out.println(jsonObject.get("from"));
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

