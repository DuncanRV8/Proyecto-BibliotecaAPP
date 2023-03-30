

//Duncan Rua Valiente
public class Usuario {

    //Enum
    public enum TipoUsuario{
        ACTIVO,BLOQUEADO
    }
    
    private String Nombre,Apellidos,Dni,Fecha;
    private TipoUsuario Tipo;
    private int maxLibros = 2;
    public int librosenposesion = 0;
    private Libro[] libros = new Libro[maxLibros];

    //Constructores
    public Usuario(){

    }
    public Usuario(String nombre, String apellidos, String dni, String fecha, TipoUsuario tipo){
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Dni = dni;
        this.Fecha = fecha;
        this.Tipo = tipo;
    }

    //Setter
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }
    public void setDni(String dni) {
        this.Dni = dni;
    }
    public void setFecha(String fecha) {
        this.Fecha = fecha;
    }
   
    public void setTipo(TipoUsuario tipo) {
        this.Tipo = tipo;
    }

    //Getter
    public String getNombre() {
        return this.Nombre;
    }
    public String getApellidos() {
        return this.Apellidos;
    }
    public String getDni() {
        return this.Dni;
    }
    public String getFecha() {
        return this.Fecha;
    }
    public TipoUsuario getTipo() {
        return this.Tipo;
    }


    //MÉTODOS
    //Printear
    public void imprimir(){
        System.out.println(" " + Nombre + " " + Apellidos + " " + Dni + " " + Fecha + " " + Tipo);
    }

    public void cogerLibro(Libro libro){
        if (librosenposesion > 2) {
            System.out.println("No puede coger mas");
            return;
        }
        libros[librosenposesion] = libro;
        librosenposesion++;
    }

    public void devolverLibro(int pos){
       libros[pos] = null;
       int eliminar = 0;
       for (int i = eliminar+1; i < librosenposesion; i++) {
            libros[eliminar] = libros[i];
            eliminar++;
        }
       librosenposesion--;
    }

    public void verLibros(){
        for (int i = 0; i < librosenposesion; i++) {
            libros[i].imprimir();
        }
    }
}
