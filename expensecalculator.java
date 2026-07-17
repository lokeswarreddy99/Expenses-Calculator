import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double totalIncome = 0.0;
        double totalExpenses = 0.0;

        System.out.println("****Welcome to the Expense Tracker****");
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("Hello " + userName + "! Let's track your finances effectively.");

        while (true) {
            System.out.println("\n****Main Menu****");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expenses");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Please choose an option (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter the amount of income: ");
                    double income = scanner.nextDouble();

                    if (income > 0) {
                        totalIncome += income;
                        System.out.println("Income added successfully!");
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 2:
                    System.out.print("Enter the amount of expense: ");
                    double expense = scanner.nextDouble();

                    if (expense > 0) {
                        if (expense <= (totalIncome - totalExpenses)) {

                            System.out.println("Choose a category:");
                            System.out.println("1. Food");
                            System.out.println("2. Transportation");
                            System.out.println("3. Entertainment");
                            System.out.println("4. Other");

                            int category = scanner.nextInt();
                            String categoryName;

                            switch (category) {
                                case 1:
                                    categoryName = "Food";
                                    break;
                                case 2:
                                    categoryName = "Transportation";
                                    break;
                                case 3:
                                    categoryName = "Entertainment";
                                    break;
                                case 4:
                                    categoryName = "Other";
                                    break;
                                default:
                                    System.out.println("Invalid category!");
                                    continue;
                            }

                            totalExpenses += expense;
                            System.out.println("Expense added successfully under " + categoryName);

                        } else {
                            System.out.println("Not enough balance!");
                        }
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 3:
                    double remainingBalance = totalIncome - totalExpenses;

                    System.out.println("\n=== FINANCIAL SUMMARY ===");
                    System.out.println("Total Income: " + totalIncome);
                    System.out.println("Total Expenses: " + totalExpenses);
                    System.out.println("Balance: " + remainingBalance);
                    break;

                case 4:
                    System.out.println("Thank you for using Expense Tracker!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}