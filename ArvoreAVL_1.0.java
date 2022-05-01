import java.util.Scanner;

class No {
    int dado, altura;
    No esq, dir;

    No(int d) {
      dado = d;
      altura = 1;
    }
  }
  
  class ArvoreAVL {
    No raiz;
  
    int altura(No N) {
      if (N == null)
        return 0;
      return N.altura;
    }
  
    int max(int a, int b) {
      return (a > b) ? a : b;
    }

    int getFatorBal(No N) {
        if (N == null)
          return 0;
        return altura(N.esq) - altura(N.dir);
      }
  
    No RotaDir(No y) {
      No x = y.esq;
      No z = x.dir;

      x.dir = y;
      y.esq = z;
      y.altura = max(altura(y.esq), altura(y.dir)) + 1;
      x.altura = max(altura(x.esq), altura(x.dir)) + 1;
      return x;
    }

    No RotaEsq(No x) {
      No y = x.dir;
      No z = y.esq;

      y.esq = x;
      x.dir = z;
      x.altura = max(altura(x.esq), altura(x.dir)) + 1;
      y.altura = max(altura(y.esq), altura(y.dir)) + 1;
      return y;
    }

    No inserirNo(No No, int dado) {
      if (No == null)
        return (new No(dado));
      if (dado < No.dado)
        No.esq = inserirNo(No.esq, dado);
      else if (dado > No.dado)
        No.dir = inserirNo(No.dir, dado);
      else
        return No;
      No.altura = 1 + max(altura(No.esq), altura(No.dir));
      int FatorBal = getFatorBal(No);

      if (FatorBal > 1) {
        if (dado < No.esq.dado) {
          return RotaDir(No);
        } else if (dado > No.esq.dado) {
          No.esq = RotaEsq(No.esq);
          return RotaDir(No);
        }
      }
      if (FatorBal < -1) {
        if (dado > No.dir.dado) {
          return RotaEsq(No);
        } else if (dado < No.dir.dado) {
          No.dir = RotaDir(No.dir);
          return RotaEsq(No);
        }
      }
      return No;
    }
  
    void preOrdem(No No) {
      if (No != null) {
        System.out.print(No.dado + " ");
        preOrdem(No.esq);
        preOrdem(No.dir);
      }
    }
  
    private void Imprimir(No dadoAtual, String indent, boolean ultimo) {
      if (dadoAtual != null) {
        System.out.print(indent);
        if (ultimo) {
          System.out.print("R----");
          indent += "   ";
        } else {
          System.out.print("L----");
          indent += "|  ";
        }
        System.out.println(dadoAtual.dado);
        Imprimir(dadoAtual.esq, indent, false);
        Imprimir(dadoAtual.dir, indent, true);
      }
    }

    No menorNo(No No) {
        No noAtual = No;

        while (noAtual.esq != null)
          noAtual = noAtual.esq;
        return noAtual;
      }

    No deletar(No raiz, int dado) {
        if (raiz == null)
          return raiz;
        if (dado < raiz.dado)
          raiz.esq = deletar(raiz.esq, dado);
        else if (dado > raiz.dado)
          raiz.dir = deletar(raiz.dir, dado);
        else {
          if ((raiz.esq == null) || (raiz.dir == null)) {
            No temp = null;

            if (temp == raiz.esq)
              temp = raiz.dir;
            else
              temp = raiz.esq;
            if (temp == null) {
              temp = raiz;
              raiz = null;
            } else
              raiz = temp;
          } else {
            No temp = menorNo(raiz.dir);

            raiz.dado = temp.dado;
            raiz.dir = deletar(raiz.dir, temp.dado);
          }
        }
        if (raiz == null)
          return raiz;
        raiz.altura = max(altura(raiz.esq), altura(raiz.dir)) + 1;
        int FatorBal = getFatorBal(raiz);

        if (FatorBal > 1) {
          if (getFatorBal(raiz.esq) >= 0) {
            return RotaDir(raiz);
          } else {
            raiz.esq = RotaEsq(raiz.esq);
            return RotaDir(raiz);
          }
        }
        if (FatorBal < -1) {
          if (getFatorBal(raiz.dir) <= 0) {
            return RotaEsq(raiz);
          } else {
            raiz.dir = RotaDir(raiz.dir);
            return RotaEsq(raiz);
          }
        }
        return raiz;
      }
    
    public static void main(String[] args) {
      ArvoreAVL arvore = new ArvoreAVL();

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
      System.out.println("|                        version 1.0                       |");
      System.out.println("|  Made by V. Lôbo, F. Vinícius, L. Antônio and V.         |");
      System.out.println("|----------------------------------------------------------|");

      //7, 3, 18, 10, 22, 8, 11, 26, 2, 6 e 13

      arvore.raiz = arvore.inserirNo(arvore.raiz, 7);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 3);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 18);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 10);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 22);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 8);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 11);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 26);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 2);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 6);
      arvore.raiz = arvore.inserirNo(arvore.raiz, 13);

      System.out.println("===========================================");
      System.out.println("Arvore Completa Balanceada: ");
      arvore.Imprimir(arvore.raiz, "", true);
      System.out.println("===========================================");
      System.out.println("");
      System.out.println("===========================================");
      System.out.println("Arovre Completa Balanceada (Apos Remoçao): ");
      arvore.Imprimir(arvore.raiz, "", true);
      System.out.println("===========================================");
    }
  }