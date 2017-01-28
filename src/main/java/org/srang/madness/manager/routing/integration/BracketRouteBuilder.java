package org.srang.madness.manager.routing.integration;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;
import org.srang.madness.manager.model.forms.BracketForm;

/**
 * Created by srang on 1/28/17.
 */
@Component
public class BracketRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").port("8080").bindingMode(RestBindingMode.json)
//                .apiContextPath("/v2/api-doc")
//                .apiProperty("api.title", "DevOps Toolchain API")
//                .apiProperty("api.version", "0.1.0")
//                .apiProperty("cors", "true")
        ;

        rest("/bracket")
                .post()
                .type(BracketForm.class)
                .route()
                .process((exchange -> {
                    Message in = exchange.getIn();
                }));
    }
}
