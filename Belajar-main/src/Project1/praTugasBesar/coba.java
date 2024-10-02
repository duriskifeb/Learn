package Project1.praTugasBesar;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class User implements Serializable {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

class UserManager implements Serializable {
    private ArrayList<User> users;
    private static final String FILE_NAME = "users.ser";

    public UserManager() {
        this.users = new ArrayList<>();
        loadUsers();
    }

    public void registerUser(String username, String password) {
        if (isUserExist(username)) {
            System.out.println("Username already exists. Please choose another username.");
            return;
        }

        users.add(new User(username, password));
        System.out.println("Registration successful!");
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return false;
    }

    public void showUsers() {
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
    }

    private boolean isUserExist(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
            System.out.println("Users saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            users = (ArrayList<User>) ois.readObject();
            System.out.println("Users loaded from file.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveAndExit() {
        saveUsers();
        System.out.println("Goodbye!");
        System.exit(0);
    }
}

public class coba {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        showMenu(userManager);
    }

    private static void showMenu(UserManager userManager) {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Show Users");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    register(userManager);
                    break;
                case 2:
                    login(userManager);
                    break;
                case 3:
                    userManager.showUsers();
                    break;
                case 4:
                    userManager.saveAndExit();
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void register(UserManager userManager) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        userManager.registerUser(username, password);
    }

    private static void login(UserManager userManager) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        userManager.loginUser(username, password);
    }
}
