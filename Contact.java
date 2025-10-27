package Actividad.pkg1;

public class Contact {
    private String name;
    private String address;
    private String phoneNumber;
    
    public Contact(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    
    @Override
    public String toString() {
        return "Contacto{nombre='" + name + "', direccion='" + address + "', telefono='" + phoneNumber + "'}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber);
    }
}