package Actividad.pkg1;

public class DataTypeExamples {
    private LinkedList exampleList;
    
    public DataTypeExamples(String listType) {
        this.exampleList = new LinkedList(listType);
    }
    
    // Demostración de tipos de datos primitivos (usando wrappers)
    public void demonstratePrimitiveTypes() {
        System.out.println("\n=== DEMOSTRACIÓN TIPOS PRIMITIVOS ===");
        
        // Integer
        exampleList.insert(Integer.valueOf(100));
        // Double
        exampleList.insert(Double.valueOf(3.1416));
        // Boolean
        exampleList.insert(Boolean.valueOf(true));
        // Character
        exampleList.insert(Character.valueOf('A'));
        
        exampleList.display();
        exampleList.search(100);
        exampleList.delete(3.1416);
        exampleList.display();
        
        // Limpiar para siguiente demostración
        while (!exampleList.isEmpty()) {
            exampleList.delete(exampleList);
        }
    }
    
    // Demostración de tipos complejos (String)
    public void demonstrateComplexTypes() {
        System.out.println("\n=== DEMOSTRACIÓN TIPOS COMPLEJOS ===");
        
        exampleList.insert("Hola Mundo");
        exampleList.insert("Java Programming");
        exampleList.insert("Listas Enlazadas");
        
        exampleList.display();
        exampleList.search("Java Programming");
        exampleList.display();
    }
    
    // Demostración de tipos abstractos (Contactos)
    public void demonstrateAbstractTypes() {
        System.out.println("\n=== DEMOSTRACIÓN TIPOS ABSTRACTOS (CONTACTOS) ===");
        
        Contact contact1 = new Contact("Juan Pérez", "Calle 123", "555-1234");
        Contact contact2 = new Contact("María García", "Avenida 456", "555-5678");
        Contact contact3 = new Contact("Carlos López", "Plaza 789", "555-9012");
        
        exampleList.insert(contact1);
        exampleList.insert(contact2);
        exampleList.insert(contact3);
        
        exampleList.display();
        exampleList.search(contact2);
        exampleList.delete(contact1);
        exampleList.display();
    }
    
    // Gestión de contactos
    public void contactManagementDemo() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE CONTACTOS ===");
        
        LinkedList contactList = new LinkedList("SIMPLE");
        
        // Agregar contactos
        contactList.insert(new Contact("Ana Torres", "Calle Principal 123", "555-1111"));
        contactList.insert(new Contact("Luis Mendoza", "Av. Central 456", "555-2222"));
        contactList.insert(new Contact("Sofia Castro", "Plaza Mayor 789", "555-3333"));
        
        contactList.display();
        
        // Buscar contacto
        Contact searchContact = new Contact("Luis Mendoza", "Av. Central 456", "555-2222");
        contactList.search(searchContact);
        
        // Eliminar contacto
        Contact deleteContact = new Contact("Ana Torres", "Calle Principal 123", "555-1111");
        contactList.delete(deleteContact);
        contactList.display();
    }
    
    public void clearList() {
        while (!exampleList.isEmpty()) {
            exampleList.delete(exampleList);
        }
    }
}