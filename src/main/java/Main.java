import DAO.UsuarioDao;
import clases.Usuario;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {


    public static void main(String[] args) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassForTemplateLoading(Main.class, "/");
        DAO.UsuarioDao uDao = new UsuarioDao();
        if(uDao.countUsuarios() == 0){
            Usuario admin = new Usuario("admin","admin","admin",true,true);
            uDao.insertarUsuario(admin);
            System.out.println("Admin creado con exito.");
        }



        get("/", (req, res) -> {
            StringWriter writer = new StringWriter();
            Map<String, Object> atr = new HashMap<>();
            Template template = configuration.getTemplate("templates/crearUsuario.ftl");
            template.process(atr,writer);
            return writer;
        });
        post("/agregarUsuario", (req, res) -> {

            String user = req.queryParams("username");
            String nombre = req.queryParams("nombre");
            String password = req.queryParams("password");
            String administrator = req.queryParams("administrator");

            if(administrator == null){
                administrator = "false";
            }else if(administrator.equals("on")){
                administrator="true";
            }

            String autor = req.queryParams("autor");

            if(autor == null){
                autor = "false";
            }else if(autor.equals("on")){
                autor="true";
            }

            Usuario u =  new Usuario(user,nombre,password,Boolean.valueOf(administrator),Boolean.valueOf(autor));

            uDao.insertarUsuario(u);


            res.redirect("/");

            return null;
        });
    }




}