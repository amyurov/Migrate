package ru.netology.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import ru.netology.model.Post;
import ru.netology.model.PostConverter;

@Configuration
public class WebConfig {
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        final var bean = new RequestMappingHandlerAdapter();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Post.class, new PostConverter())
                .setPrettyPrinting()
                .create();

        bean.getMessageConverters().add(new GsonHttpMessageConverter(gson));
        return bean;
    }
}
