package ws;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Administrador;
import pojos.Estado;
import pojos.Medico;
import pojos.Mensaje;
import pojos.TipoGenero;



@Path("fitnutrition")
public class FitNutritionWS {

    @Context
    private UriInfo context;

    
    public FitNutritionWS() {
    }

    
    @Path("loginAdmin")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje loginAdmin(@FormParam("usuario") String username, @FormParam("contraseña") String password){
        Mensaje respuesta = new Mensaje();
        SqlSession conn = MyBatisUtil.getSession();
        Administrador user =  new Administrador();
        HashMap<String,Object> param = new HashMap<>();
        param.put("user", username);
        param.put("password", password);
        if(conn != null){
            try {
                user = conn.selectOne("FitNutrition.loginAdmin", param);
                conn.commit();
                if(user != null && user.getIdAdministrador() > 0){
                    respuesta.setError(false);
                    respuesta.setMensaje(""+user.getIdAdministrador());
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Las credenciales son incorrectas...");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("No se puede conectar con la base de datos...");
        }
        return respuesta;
    }
    
    @Path("loginMedico")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje loginMedico(@FormParam("numeroPersonal") String username, @FormParam("contraseña") String password){
        Mensaje respuesta = new Mensaje();
        SqlSession conn = MyBatisUtil.getSession();
        Medico user =  new Medico();
        HashMap<String,Object> param = new HashMap<>();
        param.put("user", username);
        param.put("password", password);
        if(conn != null){
            try {
                user = conn.selectOne("FitNutrition.loginMedico", param);
                conn.commit();
                if(user != null && user.getIdMedico() > 0){
                    respuesta.setError(false);
                    respuesta.setMensaje(""+user.getIdMedico());
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Las credenciales son incorrectas...");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("No se puede conectar con la base de datos...");
        }
        return respuesta;
    }
    
    @Path("getAllMedicos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medico> getAllMedicos(){
        List<Medico> medicos = null;
        SqlSession conn = MyBatisUtil.getSession();        
        if(conn != null){
            try {
                medicos = conn.selectList("FitNutrition.listarMedicos");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return medicos;
    }
    

    @Path("getTiposGeneros")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoGenero> getTiposGeneros(){
        List<TipoGenero> tipoGenero = null;
        SqlSession conn = MyBatisUtil.getSession();
        
        if(conn != null){
            try {
                tipoGenero = conn.selectList("FitNutrition.getTiposGeneros");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tipoGenero;
    }
    
    @Path("getTipoEstados")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> getTipoEstados(){
        List<Estado> estados = null;
        SqlSession conn = MyBatisUtil.getSession();
        
        if(conn != null){
            try {
                estados = conn.selectList("FitNutrition.getEstados");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return estados;
    }

    
    @Path("agregarMedico")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje crearMedico(@FormParam("nombre") String nombre, @FormParam("apellidos") String apellidos, @FormParam("fechaNacimiento") String fechaNacimiento, 
            @FormParam("idGenero") Integer idGenero, @FormParam("domicilio") String domicilio, @FormParam("numeroPersonal") String numeroPersonal, @FormParam("numeroCedula") Integer numeroCedula, @FormParam("contraseña") String contraseña, @FormParam("idEstado") Integer idEstado){
        Mensaje respuesta = new Mensaje();
        
        Medico medic =  new Medico(0, nombre, apellidos, fechaNacimiento, idGenero, "", domicilio, numeroPersonal, numeroCedula, contraseña, idEstado, "");
        SqlSession conn = MyBatisUtil.getSession();
        
        if(conn != null){
            try {
                int resultado = conn.insert("FitNutrition.registrarMedico", medic);
                conn.commit();
                if(resultado > 0){
                    respuesta.setError(false);
                    respuesta.setMensaje("Registro agregado con éxito...");
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("No se pudo agregar el registro");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("No se puede conectar con la base de datos...");
        }
        return respuesta;
    } 
    
    
    @Path("editarMedico")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editarMedico(@FormParam("idMedico") Integer idMedico, @FormParam("nombre") String nombre, @FormParam("apellidos") String apellidos, @FormParam("fechaNacimiento") String fechaNacimiento, 
            @FormParam("idGenero") Integer idGenero, @FormParam("domicilio") String domicilio,  @FormParam("numeroCedula") Integer numeroCedula, @FormParam("contraseña") String contraseña, @FormParam("idEstado") Integer idEstado){
        Mensaje respuesta = new Mensaje();
        Medico medic =  new Medico(idMedico, nombre, apellidos, fechaNacimiento, idGenero, "", domicilio, "", numeroCedula, contraseña, idEstado, "");
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null){
           try{
               int resultado = conn.update("FitNutrition.actualizarMedico", medic);
               conn.commit();
               if(resultado > 0){
                   respuesta.setError(false);
                   respuesta.setMensaje("Registro actualizado con éxito...");
               }else{
                   respuesta.setError(true);
                   respuesta.setMensaje("El registro No pudo ser actualizado...");
               }
           }catch(Exception e){
               respuesta.setError(true);
               respuesta.setMensaje(e.getMessage());
           }
        }else{
           respuesta.setError(true);
           respuesta.setMensaje("No hay conexión con la BD...");
        }
        return respuesta;
    }
    
    @Path("eliminarMedico")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarMedico(@FormParam("idMedico") Integer idMedico){
        Mensaje respuesta = new Mensaje();
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null){
            try {
                int resultado = conn.delete("FitNutrition.eliminarMedico", idMedico);
                conn.commit();
                if( resultado > 0 ){
                    respuesta.setError(false);
                    respuesta.setMensaje("Registro eliminado correctamente...");
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("El registro no se pudo eliminar...");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("No hay conexión con la BD...");
        }
        return respuesta;
    }  
    
    
    //@Path("getMedicoById")
    //@GET
    //@Produces(MediaType.APPLICATION_JSON)
    //public Medico getMedicoByID(@PathParam("idMedico") Integer idMedico){
      //  SqlSession conn = MyBatisUtil.getSession();
        //Medico medico = new Medico(idMedico, "", "", "", 0, "", "", "", 0, "");
        //return medico;
    //}
    //
    @Path("subirImagen/{idMedico}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje subirImagen(byte[] imageBytes, @PathParam("idMedico") Integer idMedico){
        SqlSession conn = MyBatisUtil.getSession();
        Medico medico = new Medico();
        medico.setIdMedico(idMedico);
        medico.setFotografia(imageBytes);
        Mensaje msj = new Mensaje();
        try {
            int resultado = conn.update("FitNutrition.enviarImgMedico", medico);
            conn.commit();
            if(resultado > 0){
                msj.setError(false);
                msj.setMensaje("Imagen subida con éxito...");
            }else{
                msj.setError(true);
                msj.setMensaje("No se pudo guardar la imagen...");
            }
        } catch (Exception e) {
            msj.setError(true);
            msj.setMensaje(e.getMessage());
        } finally{
            conn.close();
        }
        
        return msj;
    }
    
    
    @Path("getImgMedico/{idMedico}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje getImgMedico(@PathParam("idMedico") Integer idMedico){
        Mensaje msj = new Mensaje();
        SqlSession conn = MyBatisUtil.getSession();
        String PATH = "/Users/Usuario/Desktop/imgMedicos/"+idMedico+".png";
        if(conn != null){
            try{
                Medico medic = conn.selectOne("FitNutrition.getImgMedico", idMedico);
                System.out.println("Medico: "+medic.getNombre());
                boolean isSave = escribeImagenMedico(PATH, medic.getFotografia());
                if(isSave){
                   msj.setError(false);
                   msj.setMensaje(PATH);
                }else{
                   msj.setError(true);
                   msj.setMensaje("No se pudo obtener la imagen...");
                }
            }catch(Exception e){
                
            }
        }else{
            msj.setError(true);
            msj.setMensaje("Sin conexion a la BD");
        }
        return msj;
    }
    
    private boolean escribeImagenMedico(String path, byte[] bytes){
        InputStream in = new ByteArrayInputStream(bytes);
        try {
            BufferedImage buffImage = ImageIO.read(in);
            ImageIO.write(buffImage, "png", new File(path));
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }
    
}

