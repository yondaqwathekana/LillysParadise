package za.ac.cput.factory;

import za.ac.cput.domain.RoomService;
import za.ac.cput.util.Helper;

public class RoomServiceFactory {

    public static RoomService createRoomService(String serviceName, String serviceDescription, double servicePrice) {
        if(Helper.isNullOrEmpty(serviceName) || Helper.isNullOrEmpty(serviceDescription) || Helper.isNullOrEmpty(servicePrice))
            return null;
        return new RoomService.Builder()
                .setServiceName(serviceName)
                .setServiceDescription(serviceDescription)
                .setServicePrice(servicePrice)
                .build();
    }
}
