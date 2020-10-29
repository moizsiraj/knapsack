import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int currentStation = stops[0];
        int nextStation = stops[1];
        int currentStationIndex = 0;
        int nextStationIndex = 1;
        int distanceBetween = 0;
        int distanceCovered = 0;
        int stations = 0;
        if (dist <= tank) {
            return stations;
        } else {
            while (distanceCovered != dist && nextStationIndex < stops.length - 1) {
                distanceBetween = nextStation - currentStation;
                while (distanceBetween <= tank && nextStationIndex < stops.length - 1) {
                    nextStationIndex++;
                    nextStation = stops[nextStationIndex];
                    distanceBetween = nextStation - currentStation;
                }
                currentStationIndex = nextStationIndex - 1;
                currentStation = stops[currentStationIndex];
                distanceCovered = stops[currentStationIndex];
                if (nextStation - currentStation > tank) {
                    stations = -1;
                    return stations;
                } else {
                    stations++;
                }
            }
        }
        return stations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[0] = 0;
        stops[n + 1] = dist;
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
