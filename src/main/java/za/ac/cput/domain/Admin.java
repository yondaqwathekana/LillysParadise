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
    private String password;

    protected Admin(){}

    public Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.name = builder.name;
        this.contact = builder.contact;
        this.password = builder.password;
    }

    public String getAdminId() { return adminId; }
    public Name getName() { return name; }
    public Contact getContact() { return contact; }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        return Objects.equals(getAdminId(), admin.getAdminId()) && Objects.equals(getName(), admin.getName()) && Objects.equals(getContact(), admin.getContact()) && Objects.equals(getPassword(), admin.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdminId(), getName(), getContact(), getPassword());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", name=" + name +
                ", contact=" + contact +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String adminId;
        private Name name;
        private Contact contact;
        private String password;

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

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Admin admin){
            this.adminId = admin.adminId;
            this.name = admin.name;
            this.contact = admin.contact;
            this.password = admin.password;
            return this;
        }
        public Admin build(){ return new Admin(this); }
    }
}
