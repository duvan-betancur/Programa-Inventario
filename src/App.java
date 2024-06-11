import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSistema de Control de Inventarios");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Actualizar Artículo");
            System.out.println("3. Eliminar Artículo");
            System.out.println("4. Listar Artículos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    manager.addItem(nombre, cantidad, precio);
                    break;
                case 2:
                    System.out.print("ID del Artículo: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Nuevo Nombre: ");
                    String newName = scanner.next();
                    System.out.print("Nueva Cantidad: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Nuevo Precio: ");
                    double newPrice = scanner.nextDouble();
                    manager.updateItem(idActualizar, newName, newQuantity, newPrice);
                    break;
                case 3:
                    System.out.print("ID del Artículo a Eliminar: ");
                    int idToDelete = scanner.nextInt();
                    manager.eliminarItem(idToDelete);
                    break;
                case 4:
                    manager.listaItems();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}


