package za.ac.cput.factory;

import za.ac.cput.domain.Room;
import za.ac.cput.util.Helper;

public class RoomFactory {

    public static Room createRoom(String roomNumber, String roomType, double roomPrice, String roomFloor, String imageName, String imageType, byte[] image) {
        // Validate inputs
        if (Helper.isNullOrEmpty(roomNumber) || Helper.isNullOrEmpty(roomType) || Helper.isNullOrEmpty(roomFloor)) {
            return null;
        }

        // Validate image details
        if (Helper.isNullOrEmpty(imageName) || Helper.isNullOrEmpty(imageType) || image == null || image.length == 0) {
            return null;
        }

        return new Room.Builder()
                .setRoomNumber(roomNumber)
                .setRoomType(roomType)
                .setRoomFloor(roomFloor)
                .setRoomPrice(roomPrice)
                .setImageName(imageName)
                .setImageType(imageType)
                .setImage(image)
                .build();
    }

}
