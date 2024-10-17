package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
public class Room {
    @Id
    private String roomNumber;
    private String roomType;
    private double roomPrice;
    private String roomFloor;
    private String imageName;
    private String imageType;
    @Lob
    @Column(length = 100000)
    private byte[] image;

    protected Room() {}

    public Room(Builder builder) {
        this.roomNumber = builder.roomNumber;
        this.roomType = builder.roomType;
        this.roomFloor = builder.roomFloor;
        this.roomPrice = builder.roomPrice;
        this.imageName = builder.imageName;
        this.imageType = builder.imageType;
        this.image = builder.image;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Room room = (Room) object;
        return Double.compare(roomPrice, room.roomPrice) == 0 && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(roomType, room.roomType) && Objects.equals(roomFloor, room.roomFloor) && Objects.equals(imageName, room.imageName) && Objects.equals(imageType, room.imageType) && Arrays.equals(image, room.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(roomNumber, roomType, roomPrice, roomFloor, imageName, imageType);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomFloor='" + roomFloor + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public static class Builder {
        private String roomNumber;
        private String roomType;
        private double roomPrice;
        private String roomFloor;
        private String imageName;
        private String imageType;
        private byte[] image;

        public Builder setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setRoomType(String roomType) {
            this.roomType = roomType;
            return this;
        }

        public Builder setRoomPrice(double roomPrice) {
            this.roomPrice = roomPrice;
            return this;
        }

        public Builder setRoomFloor(String roomFloor) {
            this.roomFloor = roomFloor;
            return this;
        }

        public Builder setImageName(String imageName) {
            this.imageName = imageName;
            return this;
        }

        public Builder setImageType(String imageType) {
            this.imageType = imageType;
            return this;
        }

        public Builder setImage(byte[] image) {
            this.image = image;
            return this;
        }

        public Builder copy(Room room) {
            this.roomNumber = room.roomNumber;
            this.roomType = room.roomType;
            this.roomFloor = room.roomFloor;
            this.roomPrice = room.roomPrice;
            this.imageName = room.imageName;
            this.imageType = room.imageType;
            this.image = room.image;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }
}
