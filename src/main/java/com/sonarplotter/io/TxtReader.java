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

        //O código a seguir cria uma string com todas as coordenads recuperadas a partir do arquivo
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

        //Separa a string por ";"
        String[] splittedContent = content.split(";");

        //Percorre por um vetor das strings separadas por ";"
        for (String s : splittedContent) {
            //Elimina os espaços(" ") e separa a string por ","
            s = s.trim();
            String[] split = s.split(",");
            try {
                //Transforma as coordenadas recuperadas em PolarCoordinates
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
