package lab2ex3;

import java.util.Scanner;


public class learnString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti sirul: "); // adaugarea in interiorul unui string
        String a = scanner.nextLine();
        System.out.print("Introduceti alt sir: ");
        String b = scanner.nextLine();
        System.out.print("Introduceti indexul la care doriti sa aduagati al doilea sir: ");
        int index = scanner.nextInt();
        StringBuffer str1 = new StringBuffer(a);
        str1.insert(index, b);
        System.out.println(str1);

        System.out.println("Introduceti indexul de la care doriti sa inceapa stergerea");
        int index2 = scanner.nextInt();
        System.out.println("Introduceti numarul de caractere pe care doriti sa o stergeti");
        int lengthToDelete = scanner.nextInt();
        StringBuilder str2 = new StringBuilder(a);
        str2.delete(index2, index2+lengthToDelete);
        System.out.println(str2);
        scanner.close();
    }
}
