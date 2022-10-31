/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.jakarta.personapp.web.services;

import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Estudios;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.EstudiosPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author santy
 */
@Stateless
@Path("co.edu.javeriana.as.jakarta.personapp.ejb.entities.estudios")
public class EstudiosFacadeREST extends AbstractFacade<Estudios> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private EstudiosPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idProf=idProfValue;ccPer=ccPerValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        co.edu.javeriana.as.jakarta.personapp.ejb.entities.EstudiosPK key = new co.edu.javeriana.as.jakarta.personapp.ejb.entities.EstudiosPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idProf = map.get("idProf");
        if (idProf != null && !idProf.isEmpty()) {
            key.setIdProf(new java.lang.Integer(idProf.get(0)));
        }
        java.util.List<String> ccPer = map.get("ccPer");
        if (ccPer != null && !ccPer.isEmpty()) {
            key.setCcPer(new java.lang.Integer(ccPer.get(0)));
        }
        return key;
    }

    public EstudiosFacadeREST() {
        super(Estudios.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Estudios entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Estudios entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        co.edu.javeriana.as.jakarta.personapp.ejb.entities.EstudiosPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Estudios find(@PathParam("id") PathSegment id) {
        co.edu.javeriana.as.jakarta.personapp.ejb.entities.EstudiosPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudios> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudios> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
