
import java.util.Scanner;

//Duncan Rua Valiente
public class BibliotecaAPP {

    public Scanner lector = new Scanner(System.in);
    private static GestorUsuarios gestorusuario = new GestorUsuarios();
    private static GestorLibros gestorlibros = new GestorLibros();

    //-------------------------------------------------------------------------------------------

    // Menu de usuario y libros
    public void menu() {
        System.out.println("Que quieres consultar?");
        System.out.println("1- Usuarios");
        System.out.println("2- Libros");
        System.out.println("3- Salir");
    }

    //Menu usuario
     public void menuUsuario(){
        System.out.println(" ");
        System.out.println("Que deseas hacer?");
        System.out.println("1.Añadir usuario");
        System.out.println("2.Modificar usuario");
        System.out.println("3.Eliminar usuario");
        System.out.println("4.Ver usuarios");
        System.out.println("5.Coger libro");
        System.out.println("6.Devolver libro");
        System.out.println("7.Usuarios bloqueados");
        System.out.println("8.Usuarios no bloqueados");
        System.out.println("9.Usuarios con dos libros");
        System.out.println("10.Bloquear usuario");
        System.out.println("11.Volver al menu principal");
        System.out.println("12.Salir");
    }

    //Menú de Libros
    public void menuLibros(){
        System.out.println(" ");
        System.out.println("Que deseas hacer?");
        System.out.println("1.Añadir libro");
        System.out.println("2.Modificar libro");
        System.out.println("3.Eliminar libros");
        System.out.println("4.Ver lista de libros");
        System.out.println("5.Libros que estan ocupados");
        System.out.println("6.Libros que estan libres");
        System.out.println("7.Libros desaparecidos");
        System.out.println("8.Propuesta de mas libros");
        System.out.println("9.Ver todos los libros propuestos");
        System.out.println("10.Volver al menu principal");
        System.out.println("11.Salir");
    }
    //-------------------------------------------------------------------------------------------------

    //elecion del menu principal
    public void eleccion(int eleccion) {
        switch (eleccion) {
            case 1:
                menudeusuarios();
                break;

            case 2:
                menudelibros();
                break;

            case 3:
                salir();
                break;
            default:
                System.out.println("No existe esa opción");
        }
    }

    //eleccion del menu de usuarios
    public void eleccionUsuario(int eleccion){
        switch (eleccion) {
            case 1:
                agregarUsuario();
            break;

            case 2:
                modificarUsuario();
            break;

            case 3:
                eliminarUsuario();
            break;

            case 4:
                verUsuarios();
            break;

            case 5:
                cogerLibro();
            break;

            case 6:
                devolverLibro();
            break;

            case 7:
                usuariosBloqueados();
            break;

            case 8:
                usuariosActivos();
            break;

            case 9:
                gestorusuario.usuariosConDosLibros();
            break;

            case 10:
                bloquearUsuarios();
            break;

            case 11:
                menuprincipal();
            break;

            case 12:
                salir();
            break;
        
            default:
                System.out.println("Ese número no es valido");
        }
    }

    //eleccion del menu libros
    public void eleccionLibro(int eleccion){
        switch (eleccion) {
            case 1:
                agregarLibro();
            break;

            case 2:
                modificarLibro();
            break;

            case 3:
                eliminarLibro();
            break;

            case 4:
                verLibros();
            break;

            case 5:
                librosOcupados();
            break;

            case 6:
                librosLibres();
            break;

            case 7:
                librosDesaparecidos();
            break;

            case 8:
                propuestaLibro();
            break;

            case 9:
                verPropuestaLibros();
            break;

            case 10:
                menuprincipal();
            break;

            case 11:
                salir();
            break;
        
            default:
                System.out.println("No existe el numero");
        }
    }
    //------------------------------------------------------------------------------------------------

    //Todo lo del usuario

    //1. Pedir datos usuarios que llama a añadir usuario
    public void agregarUsuario(){
        System.out.print("Dime el nombre del usuario: ");
        String nombre = lector.next();
        lector.nextLine();
        System.out.print("Dime los apellidos: ");
        String apellidos = lector.nextLine();
        System.out.print("Dime el dni: ");
        String dni = lector.next();
        System.out.print("Dime la fecha: ");
        String fecha = lector.next();
        gestorusuario.agregarUsuario(nombre, apellidos, dni, fecha);
    }

    //2. Modificar usuario que llamara a modificarUsuario
    public void modificarUsuario(){
        System.out.print("Dime en la posición que esta: ");
        verUsuarios();
        int modificar = lector.nextInt();
        if (modificar < gestorusuario.UsuariosActuales) {
            System.out.print("Dime el nombre: ");
            String nombre = lector.next();
            lector.nextLine();
            System.out.print("Dime los apellidos: ");
            String apellidos = lector.nextLine();
            System.out.print("Dime el dni: ");
            String dni = lector.next();
            lector.nextLine();
            System.out.print("Dime la fecha: ");
            String fecha = lector.next();
            gestorusuario.modificarUsuario(modificar, nombre, apellidos, dni, fecha);
        }
        else{
            System.out.println("No existe esa posición");
        }
    }

    //3. eliminarusuario que llamara a eliminar usuario;
    public void eliminarUsuario(){
        System.out.println("Dime en que posición esta: ");
        verUsuarios();
        int eliminar = lector.nextInt();
        if (eliminar < gestorusuario.UsuariosActuales) {
            gestorusuario.eliminarUsuario(eliminar); 
        }
        else{
            System.out.println("No existe");
        } 
    }

    //4. Ver los usuarios que tenemos registrados
    public void verUsuarios(){
        gestorusuario.verUsuarios();
    }

    //5.Coger libro
    public void cogerLibro(){
        System.out.print("Dime en que posicion estas: ");
        gestorusuario.verUsuarios();
        int posicion1 = lector.nextInt();
        Usuario usuario = gestorusuario.usuarios[posicion1];

        System.out.print("Elige el libro que quieres: ");
        gestorlibros.librosLibres();
        int posicion2 = lector.nextInt();
        Libro libro = gestorlibros.libros[posicion2];
        libro.setEstadoLibro(Libro.EstadoLibro.OCUPADO);
        usuario.cogerLibro(libro);
    }

    //6.Devolver libro
    public void devolverLibro(){
        System.out.println("Dime la posición que tienes");
        gestorusuario.verUsuarios();
        int posicion = lector.nextInt();
        System.out.print("Que libro quieres devolver: ");
        gestorusuario.usuarios[posicion].verLibros();
        int eleccion = lector.nextInt();
        Usuario usuario = gestorusuario.usuarios[posicion];
        usuario.devolverLibro(eleccion);
    }

    //7. Usuario bloqueado que llamara a usuariosBloqueados
    public void usuariosBloqueados(){
        gestorusuario.usuariosBloqueados();
    }

    //8. Usuarios no bloqueados que llamara a noBloqueados
    public void usuariosActivos(){
        gestorusuario.noBloqueados();
    }

   
    //10.Bloquear usuario
    public void bloquearUsuarios(){
        System.out.println("Dime en que posición estas: ");
        usuariosActivos();
        int posicion = lector.nextInt();
        Usuario usuario = gestorusuario.usuarios[posicion];
        System.out.print(posicion );
        usuario.setTipo(Usuario.TipoUsuario.BLOQUEADO);
    }

    //------------------------------------------------------------------------------------------------------
   
    //Todo lo de los libros

    //1. Añadir libros
    public void agregarLibro(){
        System.out.print("Dime el nombre del libro: ");
        String nombre = lector.next();
        lector.nextLine();
        System.out.print("Dime la editorial:");
        String editorial = lector.next();
        lector.nextLine();
        System.out.print("Dime el autor: ");
        String autor = lector.nextLine();
        System.out.print("Como esta el libro: ");
        System.out.print("1.Libre:");
        System.out.print(" 2.Ocupado:");
        System.out.print(" 3.Desaparecido:");
        int opcion = lector.nextInt();
        gestorlibros.agregarLibros(nombre,editorial,autor, opcion);
    }

    //2.Modificar libro
    public void modificarLibro(){
        System.out.println("Dime la posicon en la que se encuentra: ");
        verLibros();
        int modificar = lector.nextInt();
        if (modificar < gestorlibros.librosactuales) {
            System.out.print("Dime el nombre: ");
            String nombre = lector.nextLine();
            System.out.print("Dime la editorial: ");
            String editorial = lector.nextLine();
            System.out.print("Dime el autor: ");
            String autor = lector.next();
            System.out.print("Dime en que estado se encuentra: ");
            System.out.print("1.Libre:");
            System.out.print(" 2.Ocupado:");
            System.out.print(" 3.Desaparecido:");
            int opcion = lector.nextInt();
            gestorlibros.modificarLibro(modificar, nombre, editorial, autor, opcion);
        }
        else{
            System.out.println("No existe");
        }
    }

    //3. Eliminar libro
    public void eliminarLibro(){
        System.out.print("Dime en que posicion esta: ");
        verLibros();
        int eliminar = lector.nextInt();
        if (eliminar < gestorlibros.librosactuales) {
            gestorlibros.eliminarLibros(eliminar);
        }
        else{
            System.out.println("No existe");
        }
    }

    //4. Libros que tenemos que llama a verlibros
    public void verLibros(){
        gestorlibros.verlibros();
    }

    //5. Libros que estan ocupados
    public void librosOcupados(){
        gestorlibros.librosOcupados();
    }

    //6. Libros que estan libres
    public void librosLibres(){
        gestorlibros.librosLibres();
    }

    //7. Libros desaparecidos
    public void librosDesaparecidos(){
        gestorlibros.librosDesaparecidos();
    }

    //8. Propuesta de mas libros que llamara a propuestaLibro
    public void propuestaLibro(){
        System.out.print("Dime el nombre que quieres proponer: ");
        String nombre = lector.next();
        lector.nextLine();
        System.out.print("Dime la editorial del libro: ");
        String editorial = lector.nextLine();
        System.out.print("Dime el autor del nombre: ");
        String autor = lector.nextLine();
        gestorlibros.propuestaLibro(nombre,editorial,autor);
    }

    //9. Ver todos los libros propuestos
    public void verPropuestaLibros(){
        gestorlibros.verLibrosPropuestos();
    }

    //---------------------------------------------------------------------------------------------

    // Inicializar
    public void inicializar() {
        gestorusuario.contenidoInicial();
        gestorlibros.contenidoInicializar();
        menuprincipal();
    }

    // Salir para la pagina principal, usuario y libros
    public void salir() {
        System.exit(0);
    }
    //----------------------------------------------------------------------------------------------

    public void menuprincipal() {
        while (true) {
            menu();
            eleccion(lector.nextInt());
        }
    }

    //Bucle de usuario
    public void menudeusuarios(){
        while (true) {
            menuUsuario();
            eleccionUsuario(lector.nextInt());
        }
    }

    //Bucle de libros
    public void menudelibros(){
        while (true) {
            menuLibros();
            eleccionLibro(lector.nextInt());
        }
    }
}
