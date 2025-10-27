package Actividad.pkg1;

public class LinkedList {
    private Node head;
    private Node tail;
    private String listType; // "SIMPLE", "DOBLE", "CIRCULAR"
    
    public LinkedList(String listType) {
        this.head = null;
        this.tail = null;
        this.listType = listType;
    }
    
    public void insert(Object data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            if (listType.equals("CIRCULAR")) {
                head.setNext(head);
            }
            System.out.println("Se agregó: " + data);
            return;
        }
        
        switch(listType) {
            case "SIMPLE":
                Node temp = head;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(newNode);
                tail = newNode;
                break;
                
            case "DOBLE":
                newNode.setPrev(tail);
                tail.setNext(newNode);
                tail = newNode;
                break;
                
            case "CIRCULAR":
                newNode.setNext(head);
                tail.setNext(newNode);
                if (listType.equals("CIRCULAR_DOBLE")) {
                    newNode.setPrev(tail);
                    head.setPrev(newNode);
                }
                tail = newNode;
                break;
        }
        System.out.println("Se agregó: " + data);
    }
    
    // Método para eliminar por valor - VERSIÓN CORREGIDA
public boolean delete(Object data) {
    if (head == null) {
        System.out.println("La lista está vacía.");
        return false;
    }
    
    // Caso: cabeza
    if (head.getData().equals(data)) {
        System.out.println("Se eliminó: " + data);
        if (listType.equals("CIRCULAR")) {
            if (head.getNext() == head) { // Solo un elemento
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                tail.setNext(head);
                if (listType.equals("CIRCULAR") && head != null) {
                    head.setPrev(tail);
                }
            }
        } else {
            head = head.getNext();
            if (head != null && (listType.equals("DOBLE") || listType.equals("CIRCULAR"))) {
                head.setPrev(null);
            }
        }
        return true;
    }
    
    Node current = head;
    boolean found = false;
    
    do {
        if (current.getNext() != null && current.getNext().getData().equals(data)) {
            found = true;
            break;
        }
        current = current.getNext();
        if (current == null) break;
    } while (current != head && current != null);
    
    if (found) {
        Node toDelete = current.getNext();
        current.setNext(toDelete.getNext());
        
        if (listType.equals("DOBLE") || listType.equals("CIRCULAR")) {
            if (toDelete.getNext() != null) {
                toDelete.getNext().setPrev(current);
            }
        }
        
        if (toDelete == tail) {
            tail = current;
            if (listType.equals("CIRCULAR") && tail != null) {
                tail.setNext(head);
            }
        }
        
        System.out.println("Se eliminó: " + data);
        return true;
    }
    
    System.out.println("No se encontró: " + data);
    return false;
}
    
    // Método para buscar
    public boolean search(Object data) {
        if (head == null) return false;
        
        Node current = head;
        do {
            if (current.getData().equals(data)) {
                System.out.println("Se encontró: " + data);
                return true;
            }
            current = current.getNext();
            if (current == null) break;
        } while (current != head && current != null);
        
        System.out.println("No se encontró: " + data);
        return false;
    }
    
    // Método para mostrar la lista
    public void display() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        System.out.print("Lista " + listType + ": ");
        Node current = head;
        
        do {
            System.out.print(current.getData() + " <-> ");
            current = current.getNext();
            if (current == null) break;
        } while (current != head && current != null);
        
        if (listType.equals("CIRCULAR") && current == head) {
            System.out.print("(circular)");
        }
        System.out.println();
    }
    
    // Métodos auxiliares
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        if (head == null) return 0;
        
        int count = 0;
        Node current = head;
        
        do {
            count++;
            current = current.getNext();
            if (current == null) break;
        } while (current != head && current != null);
        
        return count;
    }
    
    public String getListType() {
        return listType;
    }
}