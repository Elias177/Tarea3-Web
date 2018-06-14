package DAO;

import clases.Usuario;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class UsuarioDao {

    private Sql2o conexion = null;

    public void insertarUsuario(Usuario usuario) {
        String sql = "insert into usuario (id, username, nombre, password,administrator,autor,activo) values(:id,:username,:nombre,:password,:administrator,:autor,:activo)";
        Conexion con = new Conexion();
        conexion = con.getConexion();
        conexion.open();
        String lastId = "select top 1 * from usuario order by id desc";
        Long id = new Long(0);
        if(countUsuarios() != 0){
            id = conexion.createQuery(lastId).executeScalar(Long.class)+1;
        }



        conexion.createQuery(sql)
                .addParameter("id",id)
                .addParameter("username",usuario.getUsername())
                .addParameter("nombre", usuario.getNombre())
                .addParameter("password",usuario.getPassword())
                .addParameter("administrator",usuario.isAdministrador())
                .addParameter("autor",usuario.isAutor())
                .addParameter("activo",true)
                .executeUpdate();



    }
    public int countUsuarios(){
        String sql = "select count(id) from usuario";
        Conexion con = new Conexion();
        conexion = con.getConexion();
        conexion.open();
        int count = conexion.createQuery(sql).executeScalar(Integer.class);
        return count;
    }

    public void borrarUsuario(Long id){
        String sql = "update usuario set activo=false where id="+id;
        Conexion con = new Conexion();
        conexion = con.getConexion();
        conexion.open();
        conexion.createQuery(sql).executeUpdate();
    }

    public Usuario getSesion(String sesion) {
            String sql = "select * from usuario where cookies = '" +sesion+"'";
            Conexion con = new Conexion();
            conexion = con.getConexion();
            conexion.open();
            return conexion.createQuery(sql).executeScalar(Usuario.class);
    }

}
