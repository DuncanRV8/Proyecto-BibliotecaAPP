

//Dunca Rua Valiente
public class GestorUsuarios {
    public Usuario[] usuarios = new Usuario[10];
    public int UsuariosActuales = 3;
    
    //Método
    public void contenidoInicial(){
        usuarios[0] = new Usuario("Duncan", "Rua", "21341233D", "23-10-2020", Usuario.TipoUsuario.ACTIVO);
        usuarios[1] = new Usuario("Lolo", "Martinez", "12345612L", "12-6-2004", Usuario.TipoUsuario.ACTIVO);
        usuarios[2] = new Usuario("Nacho", "perez", "42332334F", "25-11-2022", Usuario.TipoUsuario.ACTIVO);
    }


    //1.Añadir usuario
    public void agregarUsuario(String nombre, String apellidos, String dni, String fecha){
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setDni(dni);
        usuario.setFecha(fecha);
        usuario.setTipo(Usuario.TipoUsuario.ACTIVO);
        usuarios[UsuariosActuales] = usuario;
        UsuariosActuales++;
    }

    //2.Modificar usuario
    public void modificarUsuario(int modificar, String nombre, String apellidos, String dni, String fecha){
            usuarios[modificar].setNombre(nombre);
            usuarios[modificar].setApellidos(apellidos);
            usuarios[modificar].setDni(dni);
            usuarios[modificar].setFecha(fecha);
    }

    //3.Eliminar usuario
    public void eliminarUsuario(int eliminar){
        usuarios[eliminar] = null;
        for (int i = eliminar+1; i < UsuariosActuales; i++) {
            usuarios[eliminar] = usuarios[i];
            eliminar++;
        }
        UsuariosActuales--;
    }

    //4.Ver usuarios
    public void verUsuarios(){
        for (int i = 0; i < UsuariosActuales; i++) {
            System.out.print(i + " ");
            usuarios[i].imprimir();
        }
    }

    //7.Usuarios bloqueados
    public void usuariosBloqueados(){
        for (int i = 0; i < UsuariosActuales; i++) {
            if (usuarios[i].getTipo() == Usuario.TipoUsuario.BLOQUEADO) {
                System.out.println(i + ". ");
                usuarios[i].imprimir();
            }
        }
    }

    //8.Usuarios no bloqueados
    public void noBloqueados(){
        for (int i = 0; i < UsuariosActuales; i++) {
            if (usuarios[i].getTipo() == Usuario.TipoUsuario.ACTIVO ) {
                System.out.println(i + ". ");
                usuarios[i].imprimir();
            }
        }
    }
     //9. Usuarios con dos libros que llamara a usuariosDosLibros
     public void usuariosConDosLibros(){
        for (int i = 0; i < UsuariosActuales; i++) {
            if (usuarios[i].librosenposesion == 2  ) {
                usuarios[i].imprimir();
                usuarios[i].verLibros();
            }
        }
    }
}
