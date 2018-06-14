package DAO;

import clases.Comentario;
import clases.Etiqueta;
import org.sql2o.Sql2o;

public class ComentarioDao {

    private Sql2o conexion = null;

    public void insertarEtiqueta(Comentario comentario) {
        String sql = "insert into comentario (id, comentario, id_autor, id_articulo, activo) values(:id, :comentario, :id_autor, :id_articulo, :activo)";
        Conexion con = new Conexion();
        conexion = con.getConexion();
        conexion.open();
        String lastId = "select top 1 * from comentario order by id desc";
        Long id = new Long(0);
        if(countComentario() != 0){
            id = conexion.createQuery(lastId).executeScalar(Long.class)+1;
        }

        conexion.createQuery(sql)
                .addParameter("id",id)
                .addParameter("comentario",comentario.getComentario())
                .addParameter("id_autor",comentario.getAutor())
                .addParameter("id_articulo",comentario.getArticulo())
                .addParameter("activo",true)
                .executeUpdate();

    }
    public int countComentario(){
        String sql = "select count(id) from comentario";
        Conexion con = new Conexion();
        conexion = con.getConexion();
        conexion.open();
        int count = conexion.createQuery(sql).executeScalar(Integer.class);
        return count;
    }
}
