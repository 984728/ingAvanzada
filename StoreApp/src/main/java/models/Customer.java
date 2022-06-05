
package models;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "customer.findAll", query ="SELECT c FROM Customer c ORDER BY C.customerName" )
})
public class Customer {
    
    
    //@GeneratedValue(strategy = GenerationType.IDENTITY) Para valores gerados de forma automática
    @Id
    private String customerID;
    private String customerName;
    private String address;
    private String city;
    private String state;
    private long phone;
    private long mobileno;
    private String email;
    @Column (name = "notes") //Cuando el nombre del campo de la tabla es diferente
    private String notes;

    public Customer() {
    }

    public Customer(String customerID, String customerName, String address, String city, String state, int phone, int mobileno, String email, String notes) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.mobileno = mobileno;
        this.email = email;
        this.notes = notes;
    }

    public Customer(String customerName, String address, String city, String state, int phone, int mobileno, String email) {
        this.customerName = customerName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.mobileno = mobileno;
        this.email = email;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
            
    
}
