package com.gamereviewer.teste_es.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamereviewer.teste_es.json.ObjectIdDeserializer;
import com.gamereviewer.teste_es.json.ObjectIdSerializer;
import org.bson.types.ObjectId;

public class ObjectIdUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new com.fasterxml.jackson.databind.module.SimpleModule()
                .addSerializer(ObjectId.class, new ObjectIdSerializer())
                .addDeserializer(ObjectId.class, new ObjectIdDeserializer()));
    }

    public static String objectIdToString(ObjectId objectId) {
        try {
            return objectMapper.writeValueAsString(objectId).replace("\"", "");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing ObjectId to String", e);
        }
    }

    public static ObjectId stringToObjectId(String id) {
        try {
            return objectMapper.readValue("\"" + id + "\"", ObjectId.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing String to ObjectId", e);
        }
    }
}
