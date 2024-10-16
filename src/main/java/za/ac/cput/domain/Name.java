package za.ac.cput.domain;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;
@Getter
@EqualsAndHashCode
@ToString
@Embeddable
public class Name implements Serializable {
    private String firstName;
    private String middleName;
    private String lastName;

    protected Name() {
    }
    public Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;


        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name n) {
            this.firstName = n.firstName;
            this.middleName = n.middleName;
            this.lastName = n.lastName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }
}
