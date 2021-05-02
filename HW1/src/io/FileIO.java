package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {

    public static ArrayList reader(String file) {
        ArrayList freshCsvDataArl = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)",-1); // found in web it helps to take participant id

                freshCsvDataArl.add(values);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return freshCsvDataArl;
    }
}