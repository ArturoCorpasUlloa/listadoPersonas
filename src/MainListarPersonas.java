import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainListarPersonas {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        //Creamos la lista para guardar personas
        List<Persona> personas = new ArrayList<>();

        //Menú
        boolean salir = false;
        while(!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+ e.getMessage());
            }
            System.out.println(" ");
        }
    }

    private static void mostrarMenu(){
        System.out.print("""
                ***** Listado Personas App ****
                1. Agregar
                2. Listar
                3. Salir                        
                """);
        System.out.print("Selecciona una opción: ");
        System.out.println(" ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        int opcion = consola.nextInt();
        boolean salir = false;
        switch (opcion){
            case 1 -> { //Agregar
                System.out.println("Ingresa el nombre: ");
                String nombre = consola.next();
                System.out.println("Ingresa el teléfono: ");
                String telefono = consola.next();
                System.out.println("Ingresa el correo: ");
                String email = consola.next();
                //Crear el objeto persona
                var persona = new Persona(nombre, telefono, email);
                //Agregamos a la lista
                personas.add(persona);
            }
            case 2 ->{
                System.out.println("Listado de Personas:");
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);

            }
            case 3 ->{
                System.out.println("Saliendo del App......");
                salir = true;
            }
            default -> System.out.println("Opción erronea: " + opcion);
        }//fin switch
        return salir;
    }


}
