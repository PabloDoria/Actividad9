import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaramos las variables del programa.
        int cantidad = 2, edad = 0;
        String nombre = "", raza = "", nombre_comida = "";
        double peso = 0, altura_cruz = 0, gramos_comida = 0;
        List<Perro> perros = new ArrayList<>();

        // Invocamos un objeto para leer teclado.
        Scanner lectura = new Scanner(System.in);

        // Imprimimos un encabezado con la introducción.
        System.out.println("""
                -------------------------------------------------------------
                |                     GENERADOR DE PERROS                   |
                -------------------------------------------------------------
                | Este programa contiene una clase "perro" y permite crear  |
                | instancias de la misma, mínimo 2.                         |
                -------------------------------------------------------------""");

        // Creamos un bucle para solicitar la cantidad de perros a generar.
        while (true) {
            try {
                System.out.print("¿Cuantos perros desea generar?: ");
                cantidad = lectura.nextInt();

                if (cantidad < 2) {
                    System.out.println("El número debe ser mayor o igual a 2.");
                } else {
                    break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                lectura.nextLine(); // Limpiar la entrada incorrecta
            }
        }

        // Consumir el salto de línea pendiente
        lectura.nextLine();

        // Creamos un ciclo for para capturar todos los datos de los perros.
        for (int i = 0; i < cantidad; i++) {
            System.out.println(
                    "\n-------------------------------------------------------------" +
                            "\n|                           PERRO " + (i + 1) + "                         |" +
                            "\n-------------------------------------------------------------");

            System.out.print("_Indica el nombre del perro: ");
            nombre = lectura.nextLine();
            System.out.print("_Indica la raza: ");
            raza = lectura.nextLine();
            System.out.print("_Indica la edad (años): ");
            edad = lectura.nextInt();
            System.out.print("_Indica el peso (kg): ");
            peso = lectura.nextDouble();
            System.out.print("_Indica la altura a la cruz (cm): ");
            altura_cruz = lectura.nextDouble();

            Perro perro = new Perro(nombre, raza, edad, peso, altura_cruz);
            perros.add(perro);

            // Consumir el salto de línea pendiente
            lectura.nextLine();
        }

        // Para cada perro llamamos sus métodos.
        for (Perro perro : perros) {
            perro.mostrarDatos();
            System.out.print("_Indica el nombre de la comida para " + perro.getNombre() + ": ");
            nombre_comida = lectura.nextLine();
            System.out.print("_Indica los gramos dados a " + perro.getNombre() + ": ");
            gramos_comida = lectura.nextDouble();
            lectura.nextLine(); // Consumir el salto de línea pendiente
            perro.comer(nombre_comida, gramos_comida);
            perro.ladrar();
        }
    }
}

