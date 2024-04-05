package com.main;

import kendaraan.Kendaraan;
import kendaraan.khusus.Pesawat;
import kendaraan.khusus.Tank;
import kendaraan.pribadi.Mobil;
import kendaraan.pribadi.Motor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kendaraan[] kendaraan;
        try (Scanner input = new Scanner(System.in)) {

            // menyimpan semua object dalam satu array dengan teknik polymorphism
            kendaraan = new Kendaraan[4];
            kendaraan[0] = new Motor() {
                @Override
                public void Start() {

                }

                @Override
                public void Shoot(String vehicle) {

                }
            };
            kendaraan[1] = new Mobil() {
                @Override
                public void Shoot(String vehicle) {

                }
            };
            kendaraan[2] = new Tank();
            kendaraan[3] = new Pesawat() {
                @Override
                public void Shoot(String vehicle) {

                }
            };

            // input atribut pada setiap object kendaraan
            for (int i = 0; i < kendaraan.length; i++) {
                System.out.printf("Masukkan nama kendaraan ke-%d ", (i + 1));
                kendaraan[i].setName(input.next());
                System.out.printf("Masukkan model kendaraan ke-%d ", (i + 1));
                kendaraan[i].setModel(input.next());
                System.out.printf("Masukkan warna kendaraan ke-%d ", (i + 1));
                kendaraan[i].setWarna(input.next());
                System.out.printf("Masukkan tahun kendaraan ke-%d ", (i + 1));
                kendaraan[i].setTahun(input.nextInt());
                System.out.println();
            }
        }

        // output pada setiap method di kendaraan
        for (Kendaraan objectKendaraan : kendaraan) {
            if (objectKendaraan instanceof Tank tank){
                tank.Start();
                tank.Brake();
                tank.Stop();
                tank.Shoot("Tank");

            } else if(objectKendaraan instanceof Pesawat pesawat){
                pesawat.Start();
                pesawat.fly();
                pesawat.Brake();
                pesawat.Stop();

            } else {
                objectKendaraan.Start();
                objectKendaraan.Brake();
                objectKendaraan.Stop();
            }

            objectKendaraan.getInfo();
            System.out.println();
        }
    }
}