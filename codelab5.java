import java.util.ArrayList;
import java.util.Scanner;

public class codelab5 {

    public static void main(String[] args) {
        ArrayList<String> namaMahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int counter = 1;

        while (true) {
            System.out.print("Masukkan nama mahasiswa ke-" + counter + "  :");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Selesai")) {
                break;
            }

            try {
                tambahNama(namaMahasiswa, input);
                counter++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Daftar nama mahasiswa:");
        for (int i = 0; i < namaMahasiswa.size(); i++) {
            System.out.println((i + 1) + ". " + namaMahasiswa.get(i));
        }

        scanner.close();
    }

    public static void tambahNama(ArrayList<String> list, String nama) {
        if (nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        list.add(nama);
    }
}