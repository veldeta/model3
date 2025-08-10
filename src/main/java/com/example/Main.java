package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws MyException {
        MyFile myfile = new MyFile();
        try{

            File file = myfile.open("D://java/model3/src/main/java/com", "Hello.txt");
            // File file = null;
            

            myfile.write(file, (new Scanner(System.in)).nextLine(), true);
            
            myfile.read(file);

        } catch (MyException e) {
            
            System.out.println(e.getCoder());

        } catch (IOException e) {

            System.out.println(e.getMessage());
            
        } finally {

            try {
                myfile.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}