package ecommerce.gateway1;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
@Order(0)
@Component
public class CorsFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain)
    {
        exchange.getResponse().getHeaders().set("Access-Control-Allow-Origin", "http://localhost:4200");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,OPTIONS");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", "Authorization,Content-Type,X-Amz-Date,X-Amz-Security-Token,Accept,X-Requested-With");
        if ("OPTIONS".equalsIgnoreCase(exchange.getRequest().getMethod().toString()))
        {
            exchange.getResponse().setStatusCode(HttpStatus.ACCEPTED);
            return Mono.empty();
        }
        return chain.filter(exchange);
    }
}
