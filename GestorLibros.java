

//Duncan Rua Valiente
public class GestorLibros {
    public Libro[] libros = new Libro[10];
    public Libro[] librospropuestos = new Libro[10];
    public int librosactuales = 3, libPropActuales = 0;

    //Método
    public void contenidoInicializar(){
        libros[0] = new Libro("El corazón de la piedra", "Nocturna", "José María García López",Libro.EstadoLibro.LIBRE);
        libros[1] = new Libro("Salmos de vísperas", "Obra social de Caja de Avila", "Esteban Hernández Castello",Libro.EstadoLibro.LIBRE);
        libros[2] = new Libro("La polifonía clásica", "la ciudad de Dios", "Samuel Rubio",Libro.EstadoLibro.LIBRE);

    }

    //1.Añadir libros
    public void agregarLibros(String nombre, String editorial, String autor, int opcion){
        Libro libro = new Libro();
        libro.setNombre(nombre);
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        switch (opcion) {
            case 1:
                libro.setEstadoLibro(Libro.EstadoLibro.LIBRE);    
            break;

            case 2:
                libro.setEstadoLibro(Libro.EstadoLibro.OCUPADO);
            break;

            case 3:
                libro.setEstadoLibro(Libro.EstadoLibro.DESAPARECIDO);
            break;
        
            default:
                System.out.println("No existe esa opción");
        }
        libros[librosactuales] = libro;
        librosactuales++;
    }

    //2.Modificar libro
    public void modificarLibro(int modificar, String nombre, String editorial, String autor, int opcion){
        libros[modificar].setNombre(nombre);
        libros[modificar].setEditorial(editorial);
        libros[modificar].setAutor(autor);
        switch (opcion) {
            case 1:
            libros[modificar].setEstadoLibro(Libro.EstadoLibro.LIBRE);
            break;

            case 2:
            libros[modificar].setEstadoLibro(Libro.EstadoLibro.OCUPADO);

            break;

            case 3:
            libros[modificar].setEstadoLibro(Libro.EstadoLibro.DESAPARECIDO);

            break;
        
            default:
               System.out.println("No existe el número");
        }
    }

    //3.Eliminar libros
    public void eliminarLibros(int eliminar){
        libros[eliminar] = null;
        for (int i = eliminar+1; i < librosactuales; i++) {
            libros[eliminar] = libros[i];
            eliminar++;
        }
        librosactuales--;
    }

    //4.Ver libros actuales
    public void verlibros(){
        for (int i = 0; i < librosactuales; i++) {
            System.out.print(i + ". ");
            libros[i].imprimir();
        }
    }

    //5.Libros que estan ocupados
    public void librosOcupados(){
        for (int i = 0; i < librosactuales; i++) {
            if (libros[i].getEstadoLibro() == Libro.EstadoLibro.OCUPADO) {
                System.out.print(i + ".");
                libros[i].imprimir();
            }
        }
    }

    //6.Libros que estan libres
    public void librosLibres(){
        for (int i = 0; i < librosactuales; i++) {
            if (libros[i].getEstadoLibro() == Libro.EstadoLibro.LIBRE) {
                System.out.print(i + ".");
                libros[i].imprimir();
            }
        }
    }

    //7.Libros desaparecidos
    public void librosDesaparecidos(){
        for (int i = 0; i < librosactuales; i++) {
            if (libros[i].getEstadoLibro() == Libro.EstadoLibro.DESAPARECIDO) {
                System.out.print(i + ".");
                libros[i].imprimir();
            }
        }
    }

    //8.Propuesta de mas libros
    public void propuestaLibro(String nombre, String editorial, String autor){
        Libro propLibro = new Libro();
        propLibro.setNombre(nombre);
        propLibro.setEditorial(editorial);
        propLibro.setAutor(autor);
        librospropuestos[libPropActuales] = propLibro;
        libPropActuales++;
    }

    //9.Ver todos los libros propuestos
    public void verLibrosPropuestos(){
        for (int i = 0; i < libPropActuales; i++) {
            System.out.print(i + ". ");
            librospropuestos[i].imprimir();
        }
    }
}
