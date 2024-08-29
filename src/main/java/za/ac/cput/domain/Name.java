package za.ac.cput.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
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

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(getFirstName(), name.getFirstName()) && Objects.equals(getMiddleName(), name.getMiddleName()) && Objects.equals(getLastName(), name.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getMiddleName(), getLastName());
    }

    @Override
    public String toString() {
        return "Name{" +
                "FirstName='" + firstName + '\'' +
                ", MiddleName='" + middleName + '\'' +
                ", LastName='" + lastName + '\'' +
                '}';
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
