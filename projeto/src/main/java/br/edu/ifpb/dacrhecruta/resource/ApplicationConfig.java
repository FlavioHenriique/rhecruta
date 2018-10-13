package br.edu.ifpb.dacrhecruta.resource;

import br.edu.ifpb.dacrhecruta.security.CorsFilter;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig(){

        register(CorsFilter.class);

    }
}
