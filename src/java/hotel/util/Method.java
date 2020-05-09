package hotel.util;

import java.util.List;

import hotel.model.Room;
import hotel.model.Worker;

public class Method {

	public static void getWorkerList(List<Worker> workerList) {
		for (Worker worker : workerList) {
			System.out.println(
					worker.getId() + "-" + worker.getName() + "-" + worker.getSurname() + "-" + worker.getDob());
		}
	}

	public static void getRoomList(List<Room> roomList) {
		for (Room room : roomList) {
			System.out.println(room.getId() + "--" + room.getRoomNumber() + "--" + room.getRoomSituation() + "--"
					+ room.getPrice() + "--" + room.getRoomType());
		}
	}

}
