package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Objects;
@Getter
@Entity
public class RoomService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String serviceName;
    private String serviceDescription;
    private double servicePrice;

    protected RoomService() {
    }

    public RoomService(RoomService.Builder builder) {
        this.serviceName = builder.serviceName;
        this.serviceDescription = builder.serviceDescription;
        this.servicePrice = builder.servicePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomService that = (RoomService) o;
        return Double.compare(that.servicePrice, servicePrice) == 0 && Objects.equals(serviceName, that.serviceName) && Objects.equals(serviceDescription, that.serviceDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, serviceDescription, servicePrice);
    }

    @Override
    public String toString() {
        return "RoomService{" +
                "serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }

    public static class Builder {
        private String serviceName;
        private String serviceDescription;
        private double servicePrice;

        public Builder setServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public Builder setServiceDescription(String serviceDescription) {
            this.serviceDescription = serviceDescription;
            return this;
        }

        public Builder setServicePrice(double servicePrice) {
            this.servicePrice = servicePrice;
            return this;
        }

        public Builder copy(RoomService roomService) {
            this.serviceName = roomService.serviceName;
            this.serviceDescription = roomService.serviceDescription;
            this.servicePrice = roomService.servicePrice;
            return this;
        }

        public RoomService build() {
            return new RoomService(this);
        }
    }
}
