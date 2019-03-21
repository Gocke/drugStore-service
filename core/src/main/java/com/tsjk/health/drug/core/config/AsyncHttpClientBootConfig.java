package com.tsjk.health.drug.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;

/**
 * @author Caine
 * @Date 2019/3/14
 * @DESC
 */
@Configuration
public class AsyncHttpClientBootConfig {
    @Bean
    public AsyncHttpClient asyncHttpClient() {
        AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder()
                .setRequestTimeout(5000)
                .setConnectTimeout(2000)
                .setReadTimeout(3000);
        return new AsyncHttpClient(builder.build());
    }
}