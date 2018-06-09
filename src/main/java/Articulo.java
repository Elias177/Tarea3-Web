import java.sql.Date;
import java.util.ArrayList;

public class Articulo {

    private long id;
    private String titulo;
    private String cuerpo;
    private Usuario autor;
    private Date fecha;
    private ArrayList<Comentario> listaComentarios;
    private ArrayList<Etiqueta> listaEtiqueta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public ArrayList<Etiqueta> getListaEtiqueta() {
        return listaEtiqueta;
    }

    public void setListaEtiqueta(ArrayList<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
    }
}
