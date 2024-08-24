package com.sonarplotter.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.apache.commons.geometry.euclidean.twod.PolarCoordinates;

public class TxtReader {

    public static ArrayList<PolarCoordinates> readPolarCoordinatesFromFile(String filePath) {
        ArrayList<PolarCoordinates> polarCoordinates = new ArrayList<PolarCoordinates>();
        File file = new File(filePath);
        String content = new String();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            content = sb.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        String[] splittedContent = content.split(";");
        
        for (String s : splittedContent) {
            s = s.trim();
            String[] split = s.split(",");
            try {
                double angle = Math.toRadians(Double.parseDouble(split[0]));
                double radius = Double.parseDouble(split[1]);
                PolarCoordinates pc = PolarCoordinates.of(radius, angle);
                polarCoordinates.add(pc);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        return polarCoordinates;
    }
}
