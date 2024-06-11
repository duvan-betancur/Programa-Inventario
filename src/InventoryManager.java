import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryManager {
    private List<Item> items;
    private int nextId;

    public InventoryManager() {
        this.items = new ArrayList<>();
        this.nextId = 1;
    }

    public void addItem(String nombre, int cantidad, double precio) {
        Item item = new Item(nextId++, nombre, cantidad, precio);
        items.add(item);
        System.out.println("Artículo agregado: " + item);
    }

    public void updateItem(int id, String nombre, int cantidad, double precio) {
        Optional<Item> optionalItem = items.stream().filter(item -> item.getId() == id).findFirst();
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setNombre(nombre);
            item.setCantidad(cantidad);
            item.setPrecio(precio);
            System.out.println("Artículo actualizado: " + item);
        } else {
            System.out.println("Artículo no encontrado con ID: " + id);
        }
    }

    public void eliminarItem(int id) {
        items.removeIf(item -> item.getId() == id);
        System.out.println("Artículo eliminado con ID: " + id);
    }

    public void listaItems() {
        if (items.isEmpty()) {
            System.out.println("No hay artículos en el inventario.");
        } else {
            items.forEach(System.out::println);
        }
    }
}
