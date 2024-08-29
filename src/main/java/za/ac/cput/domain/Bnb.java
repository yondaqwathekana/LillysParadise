package za.ac.cput.domain;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Bnb {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bnbId;
    private String bnbName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Contact contact;
    @Embedded
    private Address address;

    protected Bnb(){}
    private Bnb(Builder build){
        this.bnbId = build.bnbId;
        this.bnbName = build.bnbName;
        this.contact = build.contact;
        this.address = build.address;

    }

    @PrePersist
    public void onCreate(){
        if(bnbId == null)
            bnbId = UUID.randomUUID();
    }

    public UUID getBnbId() {
        return bnbId;
    }

    public String getBnbName() {
        return bnbName;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Bnb bnb = (Bnb) object;
        return Objects.equals(bnbId, bnb.bnbId) && Objects.equals(bnbName, bnb.bnbName) && Objects.equals(contact, bnb.contact) && Objects.equals(address, bnb.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bnbId, bnbName, contact, address);
    }

    @Override
    public String toString() {
        return "Bnb{" +
                "bnbId=" + bnbId +
                ", bnbName='" + bnbName + '\'' +
                ", contact=" + contact +
                ", address=" + address +
                '}';
    }

    public static class Builder{
        private UUID bnbId;
        private String bnbName;
        private Contact contact;
        private Address address;

        public Builder setBnbId(UUID bnbId) {
            this.bnbId = bnbId;
            return this;
        }

        public Builder setBnbName(String bnbName) {
            this.bnbName = bnbName;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }
        public Builder copy(Bnb bnb){
            this.bnbId = bnb.bnbId;
            this.bnbName = bnb.bnbName;
            this.contact = bnb.contact;
            this.address = bnb.address;
            return this;
        }
        public Bnb build(){
            return new Bnb(this);
        }
    }

}
