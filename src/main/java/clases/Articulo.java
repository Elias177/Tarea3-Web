package clases;

import java.sql.Date;
import java.util.List;

public class Articulo {

    private String titulo;
    private String cuerpo;
    private Long autor;
    private Date fecha;
    private List<Comentario> listaComentarios;


    public Articulo(String titulo, String cuerpo, Long autor, Date fecha, List<Comentario> listaComentarios, List<Etiqueta> listaEtiqueta) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
        this.listaComentarios = listaComentarios;
        this.listaEtiqueta = listaEtiqueta;
    }

    public List<Comentario> getListaComentarios() {

        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public List<Etiqueta> getListaEtiqueta() {
        return listaEtiqueta;
    }

    public void setListaEtiqueta(List<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
    }

    private List<Etiqueta> listaEtiqueta;

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

    public Long getAutor() {
        return autor;
    }

    public void setAutor(Long autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
