import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t\tMESSENGER PROGRAM\n\n\n");

        DataBase database = new DataBase();
        Platform platform = new Platform();

        Scanner console = new Scanner (System.in);
        System.out.println("1. LOGIN");
        System.out.println("2. SIGN UP");

        int choice = console.nextInt();

        Member thisUser = null;
        do {
            String username, password;
            switch (choice) {
                case 1 :
                    System.out.println("Username    : ");
                    username = console.nextLine();
                    System.out.println("Password    : ");
                    password = console.nextLine();
                    thisUser = database.getMember(username, password);
                    break;

                case 2 :
                    System.out.println("WELCOME TO MESSENGER\n\n");
                    System.out.println("New Username    : ");
                    username = console.nextLine();
                    System.out.println("New Password    : ");
                    password = console.nextLine();
                    System.out.println("Custom Name     : ");
                    String name = console.nextLine();

                    thisUser = new Member (name);
                    database.newClient(username, password, thisUser);
                    break;
                default :
                    System.out.println("WRONG COMMAND. Retry!!!");
            }
        } while (thisUser == null);

        platform.showCommands();


        Group currentGroup = null;
        while (currentGroup == null) {
            System.out.print("COMMAND   : ");
            int choice1 = console.nextInt();
            if (choice1 == 0) {
                String groupName, groupPassword;
                System.out.print("Enter New Group Name      : ");
                groupName = console.nextLine();
                System.out.print("Enter New Group Password  : ");
                groupPassword = console.nextLine();
                platform.addGroup(groupName, thisUser, groupPassword);
                System.out.println("GROUP CREATED");

                platform.showCommands();
            }
            else if (choice1 >= 1 && choice1 <= platform.GroupList.size()) {
                currentGroup = platform.GroupList.get(choice1-1);
            }
            else {
                System.out.println("ERROR : Wrong Command");
            }
        }

        // space for reading and writing thread
        //sending "EXIT" string exits the group



    }
}