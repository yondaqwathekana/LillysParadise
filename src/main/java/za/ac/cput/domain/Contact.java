package za.ac.cput.domain;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
@ToString
@Embeddable
public class Contact implements Serializable {
    private String telephone;
    private String mobile;

    protected Contact() {}

    public Contact(Builder build) {
        this.telephone = build.telephone;
        this.mobile = build.mobile;
    }

    public static class Builder {
        private String telephone;
        private String mobile;

        public Builder setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder copy(Contact contact) {
            this.telephone = contact.telephone;
            this.mobile = contact.mobile;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }

    }
}