package Project1.praTugasBesar;
import Sekedar.coba2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registrastion {
    private List<User> users;

    public Registrastion() {
        this.users = new ArrayList<>();
    }

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        System.out.print("Masukkan peran (Admin/User): ");
        String role = scanner.nextLine();

        User user = new User(username, password);
        user.addRole(role);
        users.add(user);

        System.out.println("Pengguna berhasil terdaftar!");
    }

    public List<User> getUsers() {
        return users;
    }
}
