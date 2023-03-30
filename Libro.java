

//Duncan Rua Valiente
public class Libro {

    //Enum
    public enum EstadoLibro{
        LIBRE,OCUPADO,DESAPARECIDO
    }

    //Atributos
    private String Nombre,Editorial,Autor;
    private EstadoLibro EstadoLibro;
    

    //Constructor
    public Libro(){

    }
    public Libro(String nombre, String editorial, String Autor, EstadoLibro estadolibro){
        this.Nombre = nombre;
        this.Editorial = editorial;
        this.Autor = Autor;
        this.EstadoLibro = estadolibro;
    }

    //Setter
    public void setNombre(String nombre){
    this.Nombre = nombre;
    }
    public void setEditorial(String editorial) {
        this.Editorial = editorial;
    }
    public void setAutor(String autor) {
        this.Autor = autor;
    }
    public void setEstadoLibro(EstadoLibro estadoLibro) {
        this.EstadoLibro = estadoLibro;
    }
    
    //Getter
    public String getNombre() {
        return this.Nombre;
    }
    public String getEditorial() {
        return this.Editorial;
    }
    public String getAutor() {
        return this.Autor;
    }
    public EstadoLibro getEstadoLibro() {
        return this.EstadoLibro;
    }

    //MÉTODOS
    //Imprimir
    public void imprimir(){
        System.out.println(Nombre + "  Editorial:" + Editorial + "  Autor:" + Autor + "  Estado:" + EstadoLibro);
    }
}
