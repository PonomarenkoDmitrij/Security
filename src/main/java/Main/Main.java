package Main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Scanner;

public class Main {

    private static Encrypt encrypt = new Encrypt();
    private static Decrypt decrypt = new Decrypt();


    public static void main(String args[]) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/context.xml");
        encrypt = (Encrypt) context.getBean("encrypt");
        decrypt = (Decrypt) context.getBean("decrypt");
        dialog();
    }

    private static void dialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your JSON: ");
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println("json:   " + s);
            String s2 = encrypt.acceptData(s);
            System.out.println("Encrypt JSON: " + s2);
            System.out.println("Decrypt JSON: " + decrypt.acceptData(s2));
        }
    }

}
