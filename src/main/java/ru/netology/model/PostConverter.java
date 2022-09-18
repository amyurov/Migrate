package ru.netology.model;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PostConverter implements JsonSerializer<Post>, JsonDeserializer<Post> {


    @Override
    public Post deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        long id = jsonObject.get("id") == null ? 0 : jsonObject.get("id").getAsLong();
        return new Post(id, jsonObject.get("content").getAsString());

    }

    @Override
    public JsonElement serialize(Post post, Type type, JsonSerializationContext context) {

        JsonObject obj = new JsonObject();

        obj.addProperty("id", post.getId());
        obj.addProperty("content", post.getContent());

        return obj;
    }
}
