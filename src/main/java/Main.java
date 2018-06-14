import DAO.ArticuloDao;
import DAO.EtiquetaDao;
import DAO.UsuarioDao;
import clases.Articulo;
import clases.Etiqueta;
import clases.Usuario;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.jasypt.util.text.StrongTextEncryptor;

import java.io.StringWriter;
import java.sql.Date;
import java.util.*;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

public class Main {

    static String usuarioNombre = "";
    static Usuario usuarioLogeado;

    public static void main(String[] args) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassForTemplateLoading(Main.class, "/");

        DAO.UsuarioDao usuarioDao = new UsuarioDao();
        if(usuarioDao.countUsuarios() == 0){
            Usuario admin = new Usuario("admin","admin","admin",true,true);
            usuarioDao.insertarUsuario(admin);
            System.out.println("Admin creado con exito.");
        }


        DAO.ArticuloDao articuloDao = new ArticuloDao();
        DAO.EtiquetaDao etiquetaDao = new EtiquetaDao();

        before("/", (req, res) -> {
            if (req.cookie("cookieSesion") != null) {
                StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
                textEncryptor.setPassword("mangekyouSharingan42");
                String sesion = textEncryptor.decrypt(req.cookie("cookieSesion"));

                Usuario oldUsuario = usuarioDao.getSesion(sesion);
                usuarioNombre = oldUsuario.getUsername();
                usuarioLogeado = oldUsuario;
                req.session().attribute("sesion", oldUsuario);

                if (oldUsuario != null) {
                    req.session(true);
                    req.session().attribute("sesion", oldUsuario);
                }
            }

        });

        get("/", (req, res) -> {
            StringWriter writer = new StringWriter();
            Map<String, Object> atr = new HashMap<>();
            Template template = configuration.getTemplate("templates/agregarArticulo.ftl");
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

            usuarioDao.insertarUsuario(u);


            res.redirect("/");

            return null;
        });

        post("/agregarArticulo", (req, res) -> {

            String titulo = req.queryParams("titulo");
            String cuerpo = req.queryParams("cuerpo");
            String etiquetas = req.queryParams("etiquetas");
            List<String> listaEtiquetas = Arrays.asList(etiquetas.split(","));

            Long idArticulo =  new Long(0);
            if(articuloDao.countArticulos() != 0){
                idArticulo = articuloDao.lastArticulo();

            }
            System.out.println(idArticulo);
            Long countEtiqueta = new Long(0);
            if(etiquetaDao.countEtiquetas() != 0){
                countEtiqueta =  etiquetaDao.lastEtiqueta();
            }
            ArrayList<Etiqueta> et =  new ArrayList<>();
            for(int i = 0; i < listaEtiquetas.size(); i++){
                Etiqueta e = new Etiqueta(listaEtiquetas.get(i));
                et.add(e);
                etiquetaDao.insertarEtiqueta(e);
            }

            Date d = new Date(System.currentTimeMillis());

            Articulo a =  new Articulo(titulo,cuerpo,Long.valueOf(0),d,null,et);
            articuloDao.insertarArticulo(a);

            for(int i = 0; i < listaEtiquetas.size(); i++){
                articuloDao.insertarArticuloEtiqueta(idArticulo,countEtiqueta);
                countEtiqueta++;
            }

            res.redirect("/");

            return null;
        });
    }




}