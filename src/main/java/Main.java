import DAO.UsuarioDao;
import clases.Usuario;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.h2.tools.RunScript;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {



    public static void main(String[] args) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassForTemplateLoading(Main.class, "/");


        get("/", (req, res) -> {
            StringWriter writer = new StringWriter();
            Map<String, Object> atr = new HashMap<>();
            Template template = configuration.getTemplate("templates/welcome.ftl");
            template.process(atr,writer);
            return writer;
        });
        post("/agregar", (req, res) -> {

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

            Usuario u =  new Usuario(user,nombre,password,Boolean.valueOf(administrator),Boolean.valueOf(autor),true);
            DAO.UsuarioDao uDao = new UsuarioDao();

            uDao.insertarUsuario(u);

            res.redirect("/");

            return null;
        });
    }




}