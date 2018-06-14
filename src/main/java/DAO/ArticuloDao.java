package DAO;

import clases.Articulo;
import org.sql2o.Sql2o;

public class ArticuloDao {
    private Sql2o conexion = null;

    public void insertarArticulo(Articulo articulo) {
        String sql = "insert into articulo (id, titulo, cuerpo, id_autor, fecha,activo) values(:id,:titulo,:cuerpo,:id_autor,:fecha,:activo)";
        Conexion con = new Conexion();
        conexion = con.getConexion();
        conexion.open();

        String lastId = "select top 1 * from articulo order by id desc";
        Long id = new Long(0);
        if(countArticulos() != 0){
            id = conexion.createQuery(lastId).executeScalar(Long.class)+1;
        }

        conexion.createQuery(sql)
                .addParameter("id",id)
                .addParameter("titulo",articulo.getTitulo())
                .addParameter("cuerpo", articulo.getCuerpo())
                .addParameter("id_autor",articulo.getAutor())
                .addParameter("fecha",articulo.getFecha())
                .addParameter("activo",true)
                .executeUpdate();



    }

    public int countArticulos(){
        String sql = "select count(id) from articulo";
        Conexion con = new Conexion();
        conexion = con.getConexion();
        conexion.open();
        int count = conexion.createQuery(sql).executeScalar(Integer.class);
        return count;
    }

}
