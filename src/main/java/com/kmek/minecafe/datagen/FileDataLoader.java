package com.kmek.minecafe.datagen;

import com.kmek.minecafe.MineCafeMod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class FileDataLoader {
    final String fileName;

    public FileDataLoader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<ArrayList<String>> read() {
        ArrayList<String> lines;

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(
                            getClass().getClassLoader()
                                    .getResourceAsStream("assets/" + MineCafeMod.MODID + "/" + fileName)),
                            "UTF-8"));
            lines = new ArrayList<>(br.lines()
                    .filter(s -> s.length() > 0 && !s.startsWith("//")) // Skip empty lines and comments
                    .toList());
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<ArrayList<String>> data = new ArrayList<>(lines.stream()
                .map(s -> new ArrayList<>(Arrays.stream(s.split(", ")).toList()))
                .toList());

        return data;
    }
}
