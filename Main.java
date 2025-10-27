package Actividad.pkg1;

public class Main {
    private static LinkedList currentList;
    private static DataTypeExamples dataExamples;
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE LISTAS ENLAZADAS ===");
        
        boolean exit = false;
        
        while (!exit) {
            showMainMenu();
            int option = readInt();
            
            switch (option) {
                case 1:
                    selectListType();
                    break;
                case 2:
                    if (checkListSelected()) operateOnList();
                    break;
                case 3:
                    demonstrateDataTypes();
                    break;
                case 4:
                    manageContacts();
                    break;
                case 5:
                    exit = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
    
    private static void showMainMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Seleccionar tipo de lista");
        System.out.println("2. Operar en lista actual" + 
            (currentList != null ? " (" + currentList.getListType() + ")" : ""));
        System.out.println("3. Demostrar tipos de datos");
        System.out.println("4. Gestión de contactos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static void selectListType() {
        System.out.println("\n=== SELECCIONAR TIPO DE LISTA ===");
        System.out.println("1. Lista Simplemente Enlazada");
        System.out.println("2. Lista Doblemente Enlazada");
        System.out.println("3. Lista Circular");
        System.out.print("Seleccione el tipo: ");
        
        int type = readInt();
        switch (type) {
            case 1:
                currentList = new LinkedList("SIMPLE");
                dataExamples = new DataTypeExamples("SIMPLE");
                break;
            case 2:
                currentList = new LinkedList("DOBLE");
                dataExamples = new DataTypeExamples("DOBLE");
                break;
            case 3:
                currentList = new LinkedList("CIRCULAR");
                dataExamples = new DataTypeExamples("CIRCULAR");
                break;
            default:
                System.out.println("Tipo inválido. Usando lista simple por defecto.");
                currentList = new LinkedList("SIMPLE");
                dataExamples = new DataTypeExamples("SIMPLE");
        }
        System.out.println("Lista " + currentList.getListType() + " creada.");
    }
    
    private static void operateOnList() {
        boolean back = false;
        
        while (!back && checkListSelected()) {
            System.out.println("\n=== OPERACIONES EN LISTA " + currentList.getListType() + " ===");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Tamaño de la lista");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int option = readInt();
            
            switch (option) {
                case 1:
                    System.out.print("Ingrese el dato a insertar: ");
                    String data = readString();
                    currentList.insert(data);
                    break;
                case 2:
                    System.out.print("Ingrese el dato a eliminar: ");
                    String toDelete = readString();
                    currentList.delete(toDelete);
                    break;
                case 3:
                    System.out.print("Ingrese el dato a buscar: ");
                    String toSearch = readString();
                    currentList.search(toSearch);
                    break;
                case 4:
                    currentList.display();
                    break;
                case 5:
                    System.out.println("Tamaño de la lista: " + currentList.size());
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    
    private static void demonstrateDataTypes() {
        if (dataExamples == null) {
            dataExamples = new DataTypeExamples("SIMPLE");
        }
        
        boolean back = false;
        
        while (!back) {
            System.out.println("\n=== DEMOSTRACIÓN DE TIPOS DE DATOS ===");
            System.out.println("1. Tipos primitivos (Integer, Double, Boolean, Character)");
            System.out.println("2. Tipos complejos (String)");
            System.out.println("3. Tipos abstractos (Contactos)");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int option = readInt();
            
            switch (option) {
                case 1:
                    dataExamples.demonstratePrimitiveTypes();
                    break;
                case 2:
                    dataExamples.demonstrateComplexTypes();
                    break;
                case 3:
                    dataExamples.demonstrateAbstractTypes();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    
    private static void manageContacts() {
        DataTypeExamples contactDemo = new DataTypeExamples("SIMPLE");
        contactDemo.contactManagementDemo();
    }
    
    private static boolean checkListSelected() {
        if (currentList == null) {
            System.out.println("Primero debe seleccionar un tipo de lista.");
            return false;
        }
        return true;
    }
    
    // Método para leer enteros sin usar librerías
    private static int readInt() {
        try {
            StringBuilder input = new StringBuilder();
            while (true) {
                char c = (char) System.in.read();
                if (c == '\n' || c == '\r') {
                    break;
                }
                input.append(c);
            }
            return Integer.parseInt(input.toString().trim());
        } catch (Exception e) {
            return -1;
        }
    }
    
    // Método para leer cadenas sin usar librerías
    private static String readString() {
        try {
            StringBuilder input = new StringBuilder();
            while (true) {
                char c = (char) System.in.read();
                if (c == '\n' || c == '\r') {
                    break;
                }
                input.append(c);
            }
            return input.toString().trim();
        } catch (Exception e) {
            return "";
        }
    }
}