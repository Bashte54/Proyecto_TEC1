package mx.aragon.tec.proyecto.modelos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "nombre_libro",nullable = false, length = 200)
    private String nombre;
    @Column (name = "autor_libro",nullable = false, length = 200)
    private String author;
    @Column (name = "editorial_libro",nullable = false, length = 200)
    private String editorial;
    @Column (name = "annio_libro",nullable = true)
    private String annio_publicacion;
    @Column (name = "isbn_libro", nullable = false, length = 13)
    private String isbn;
    @Column (name = "descripcion_libro",nullable = true, length = 500)
    private String descripcion;
    @Column (name = "url_foto",nullable = true, insertable = false,columnDefinition = "VARCHAR(500) DEFAULT 'https://cdn1.iconfinder.com/data/icons/image-manipulations/100/13-512.png'")
    private String imagen;
    @Column (name = "genero_libro",nullable = true, length = 500)
    private String genero;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libros = (Libro) o;
        return Objects.equals(id, libros.id) && Objects.equals(nombre, libros.nombre) && Objects.equals(author, libros.author) && Objects.equals(editorial, libros.editorial) && Objects.equals(annio_publicacion, libros.annio_publicacion) && Objects.equals(isbn, libros.isbn) && Objects.equals(descripcion, libros.descripcion) && Objects.equals(imagen, libros.imagen) && Objects.equals(genero, libros.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, author, editorial, annio_publicacion, isbn, descripcion, imagen, genero);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAnnio_publicacion() {
        return annio_publicacion;
    }

    public void setAnnio_publicacion(String annio_publicacion) {
        this.annio_publicacion = annio_publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Libro(Integer idLibro, String nombre, String author, String editorial, String annio_publicacion, String isbn, String descripcion, String imagen, String genero) {
        this.id = idLibro;
        this.nombre = nombre;
        this.author = author;
        this.editorial = editorial;
        this.annio_publicacion = annio_publicacion;
        this.isbn = isbn;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.genero = genero;
    }

    public Libro() {
    }
}
