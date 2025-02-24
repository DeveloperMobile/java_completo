package exercicie.application;

import exercicie.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.*;

public class Program13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Map<String, Integer> maps = new HashMap<>();
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votos = Integer.parseInt(fields[1]);

                if (maps.containsKey(name)) {
                    votos += maps.get(name);
                }

                maps.put(name, votos);

                line = br.readLine();
            }

          for (String key : maps.keySet()) {
              System.out.println(key + ": " + maps.get(key));
          }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
