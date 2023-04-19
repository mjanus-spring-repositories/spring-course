package com.mjanus.converter.controller;

import com.mjanus.converter.domain.Report;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MyCustomSlashConverter implements HttpMessageConverter<Object> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return clazz.getName().equals("com.mjanus.converter.domain.Report") &&
                mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");

    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.getName().equals("com.mjanus.converter.domain.Report") &&
                mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");

    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return List.of(MediaType.ALL);
    }

    @Override
    public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (Reader reader = new BufferedReader(
                new InputStreamReader(
                        inputMessage.getBody(),
                        StandardCharsets.UTF_8))) {
            int c = 0;
            while ((c = reader.read()) != -1)
                builder.append((char) c);
        }

        String[] fields = builder.toString().split(";");

        return new Report(fields[0], fields[1], Integer.parseInt(fields[2]));
    }

    @Override
    public void write(
            Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
    }
}

