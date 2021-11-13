package com.example.caranimation;

import javafx.scene.image.Image;

import java.io.*;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class FileOperation {

    public Vehicle getVehicle() {
        try {
            FileReader input = new FileReader("src/main/resources/settings.txt");
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = null;

            // Polymorphism
            Vehicle toyota = new Car();
//            Vehicle truck = new Truck();

            while ( (myLine = bufRead.readLine()) != null)
            {
                String[] data = myLine.split(" = ");

                if(data[0].equals("carName")){
                    toyota.setName(data[1]);
//                    truck.setName(data[1]);
                }
                else if( data[0].equals("carSpeed")){
                    toyota.setSpeed(Integer.parseInt(data[1]));
//                    truck.setSpeed(Integer.parseInt(data[1]));
                }
                else if( data[0].equals("carImage")){
                    FileInputStream inputStream = new FileInputStream(data[1]);
                    Image image = new Image(inputStream);
                    toyota.setImage(image);
//                    truck.setImage(image);
                }
            }

            return toyota;
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    public void writeCar(Vehicle car) {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/car.txt", StandardCharsets.UTF_8);
            writer.println("Car name: "+car.getName());
            writer.println("Car speed: "+ car.getSpeed() + "km/h");
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}


