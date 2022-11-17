package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Calcular a altura média de quantas pessoas? ");
        int n = sc.nextInt();

        double[] vect = new double[n];
        for (int i=0; i<n; i++) {
            System.out.println("Digite a altura da "+(i+1) +"º pessoa: ");
            vect[i] = sc.nextDouble();
        }
        double sum = 0.0;
        for (int i=0; i<n; i++) {
            sum += vect[i];
        }
        double avg = sum / n;
        System.out.printf("Altura Média: %.2f%n", avg);

        sc.close();
    }
}
