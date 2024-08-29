package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Admin {
    @Id
    private String adminId;
    @Embedded
    private Name name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Contact contact;

    protected Admin(){}

    public Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.name = builder.name;
        this.contact = builder.contact;
    }

    public String getAdminId() { return adminId; }
    public Name getName() { return name; }
    public Contact getContact() { return contact; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Admin admin = (Admin) object;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(name, admin.name) && Objects.equals(contact, admin.contact);
    }
    @Override
    public int hashCode() { return Objects.hash(adminId, name, contact); }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", name=" + name +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{
        private String adminId;
        private Name name;
        private Contact contact;

        public Builder setAdminId(String adminId) {
            this.adminId = adminId;
            return this;
        }
        public Builder setName(Name name) {
            this.name = name;
            return this;
        }
        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }
        public Builder copy(Admin admin){
            this.adminId = admin.adminId;
            this.name = admin.name;
            this.contact = admin.contact;
            return this;
        }
        public Admin build(){ return new Admin(this); }
    }
}
