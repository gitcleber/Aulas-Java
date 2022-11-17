package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos Produtos Cadastrar: ");
        int n = sc.nextInt();
        Product[] vetProduto = new Product[n];

        for (int i =0; i< vetProduto.length; i++){
            sc.nextLine();
            System.out.println("Nome Produto: ");
            String name = sc.nextLine();
            System.out.println("Preço Produto: ");
            double price = sc.nextDouble();
            vetProduto[i] = new Product(name,price);
        }
        double soma = 0.0;
        for (int i =0; i< vetProduto.length; i++) {
            soma += vetProduto[i].getPrice();
        }
        double media = soma / n;

        System.out.printf("Media de Preço dos Produtos: %.2f%n",media);



            sc.close();
    }
}
