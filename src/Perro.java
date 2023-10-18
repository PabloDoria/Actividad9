public class Perro {
    // Declaramos e inicializamos los atributos de la clase.
    private String nombre = "Sin nombre";
    private String raza = "Sin raza";
    private int edad = 0;
    private double peso = 0;
    private double altura_cruz = 0;

    // Constructor para instanciar la clase.
    public Perro(String nombre, String raza, int edad, double peso, double altura_cruz) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.altura_cruz = altura_cruz;
    }

    // Getters para obtener los atributos privados de la clase.
    public String getNombre() {
        return nombre;
    }
    public String getRaza() {
        return raza;
    }
    public int getEdad() {
        return edad;
    }
    public double getPeso() {
        return peso;
    }
    public double getAltura_cruz() {
        return altura_cruz;
    }

    // Setters para configurar los atributos de la clase.
    public void setNombre(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar en blanco.");
            }
            this.nombre = nombre;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setRaza(String raza) {
        try {
            if (raza == null || raza.trim().isEmpty()) {
                throw new IllegalArgumentException("La raza no puede estar en blanco.");
            }
            this.raza = raza;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void setEdad(int edad) {
        try {
            if (edad <= 0) {
                throw new IllegalArgumentException("La edad no puede ser menor o igual que cero.");
            }
            this.edad = edad;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Error: El valor de edad no puede ser null.");
        } catch (ClassCastException e) {
            System.err.println("Error: La edad no es un número entero válido.");
        }
    }

    public void setPeso(Double peso) {
        try {
            if (peso == null) {
                throw new IllegalArgumentException("El peso no puede ser nulo.");
            }

            double valor = peso;
            if (Double.isNaN(valor) || Double.isInfinite(valor)) {
                throw new IllegalArgumentException("El peso no es un número válido.");
            }

            this.peso = valor;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setAltura_cruz(Double altura_cruz) {
        try {
            if (altura_cruz == null) {
                throw new IllegalArgumentException("El peso no puede ser nulo.");
            }

            double valor = altura_cruz;
            if (Double.isNaN(valor) || Double.isInfinite(valor)) {
                throw new IllegalArgumentException("El peso no es un número válido.");
            }

            this.altura_cruz = valor;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Métodos propios de la clase.
    public void mostrarDatos(){
        System.out.println(
                "\n------------------------------------------------" +
                "\nNombre: " + this.nombre +
                "\n------------------------------------------------" +
                "\nRaza: " + this.raza +
                "\nEdad (años): " + this.edad +
                "\nPeso (kg): " + this.peso +
                "\nAltura a la cruz (cm): " + this.altura_cruz);
    }
    public void comer(String tipo_comida, double gramos){
        System.out.println(this.nombre + " se ha alimentado con " + gramos + " gramos de " + tipo_comida +
                ".\n_Ahora su peso es de " + (peso + gramos/1000) + " kg." );
    }
    public void ladrar(){
        System.out.println("Guau guau.");
    }
}
