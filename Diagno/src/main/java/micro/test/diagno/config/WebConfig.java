package micro.test.diagno.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

@Configuration
public class WebConfig {
    @Bean
//    @LoadBalanced
    public WebClient.Builder webClient (){
        return WebClient.builder();
    }

    @Bean
    public ReactiveResilience4JCircuitBreakerFactory circuitBreakerFactory(CircuitBreakerRegistry circuitBreakerRegistry,
                                                                           TimeLimiterRegistry timeLimiterRegistry,
                                                                           Resilience4JConfigurationProperties resilience4JConfigurationProperties) {
        return new ReactiveResilience4JCircuitBreakerFactory(circuitBreakerRegistry, timeLimiterRegistry, resilience4JConfigurationProperties);
    }

}
