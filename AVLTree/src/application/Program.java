package application;

import java.util.Scanner;

import entities.AVLTree;

public class Program {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int op;
        int value;
        AVLTree avl = new AVLTree();

        System.out.println("|----------------------------------------------------------|");
        System.out.println("|     e Y8b                                                |");
        System.out.println("|    d8b Y8b    888,8, Y8b Y888P  e88 88e  888,8,  ,e e,   |");
        System.out.println("|   d888b Y8b   888 /   Y8b Y8P  d888 888b 888 /  d88 88b  |");
        System.out.println("|  d888888888b  888      Y8b /   Y888 888P 888    888   ,  |");
        System.out.println("| d8888888b Y8b 888       Y8P     /88 88/  888    `YeeP/   |");
        System.out.println("|                                                          |");
        System.out.println("|                                                          |");
        System.out.println("|                 e Y8b     Y8b Y88888P 888                |");
        System.out.println("|                d8b Y8b     Y8b Y888P  888                |");
        System.out.println("|               d888b Y8b     Y8b Y8P   888                |");
        System.out.println("|              d888888888b     Y8b Y    888  ,d            |");
        System.out.println("|             d8888888b Y8b     Y8P     888,d88            |");
        System.out.println("|                                                          |");
        System.out.println("|                        version 2.0                       |");
        System.out.println("|  Made by V. Lôbo, F. Vinícius, L. Antônio and V.         |");
        System.out.println("|----------------------------------------------------------|");

        do{
            menu();
            op = in.nextInt();
          switch(op){
              case 1:
                     System.out.print("Informe o dado que quer inserir: ");
                     value = in.nextInt();
                     avl.inserir(value);
                     System.out.println();
              break;

              case 2:
                    System.out.print("Informe o dado que quer deletar: ");
                    value = in.nextInt();
                    avl.deletar(value);
                    System.out.println();
              break;

              case 3:
                   avl.imprimir();
                   System.out.println();
              break;

              case 0:
                    System.out.println("FIM DO PROGRAMA!!!");
              break;
             
              default:
                   System.out.println("OPÇÃO INVÁLIDA!!");
                   System.out.println();
          }
        }while(op != 0);
    }


    public static void menu(){
        System.out.println("1 - Inserir dado");
        System.out.println("2 - Deletar dado");
        System.out.println("3 - Imprimir árvore");
        System.out.println("0 - Encerrar programa");
        System.out.print("Escolha uma opção: ");
    }
}
