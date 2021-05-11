package org.commonjava.util.sidecar.jaxrs;

import io.smallrye.mutiny.Uni;
import org.commonjava.util.sidecar.services.ReportService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path( "/folo/admin/record" )
public class ReportResource
{
    @Inject
    ReportService reportService;

    @GET
    public Uni<Response> get(){
        return reportService.getReport();
    }

    @DELETE
    public Uni<Response> delete(){
        return reportService.resetReport();
    }

    @GET
    @Path( "/export" )
    public Uni<Response> export(){
        return reportService.exportReport();
    }
}
