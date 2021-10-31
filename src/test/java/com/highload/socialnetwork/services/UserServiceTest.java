package com.highload.socialnetwork.services;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserServiceTest {

    @Test
    public void generationP() throws FileNotFoundException {
        List<String> family = parseFile("src/test/resources/family.txt");
        List<String> name = parseFile("src/test/resources/name.txt");

        writeToCsv(family, name);
    }

    private List<String> parseFile(String path) {
        List<String> mas = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = Arrays.stream(line.split(" ")).findFirst().get();
                mas.add(line);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return mas;
    }

    private String generatorLogin() {

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    private void writeToCsv(List<String> family, List<String> name) {
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter("test.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("name");
            sb.append(',');
            sb.append("surname,");
            sb.append("login,");
            sb.append("password,");
            sb.append("sex,");
            sb.append("city,");
            sb.append("interests,");
            sb.append("age");
            sb.append('\n');

            for (int i = 0; i < 1_000_000; i++) {

                int randomNum = random.nextInt(149);
                String randomFamily = family.get(randomNum);
                String randomName = name.get(randomNum);
                String sex;
                if (randomNum > 100) {
                    sex = "женщина";
                } else {
                    sex = "мужчина";
                }


                sb.append(randomName);
                sb.append(',');
                sb.append(randomFamily);
                sb.append(',');
                sb.append(generatorLogin());
                sb.append(',');
                sb.append("pass,");
                sb.append(sex);
                sb.append(',');
                sb.append("Москва,");
                sb.append("Все интересно,");
                sb.append("23");

                sb.append('\n');
            }
            writer.write(sb.toString());

            System.out.println("done!");

        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}