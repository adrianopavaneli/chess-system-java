package application;

import xadrez.ExcesaoXadrez;
import xadrez.JogoXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoXadrez jogoXadrez = new JogoXadrez();
        while (true) {
            try {


                UI.limpaTela();
                UI.imprimeTabuleiro(jogoXadrez.getPecas());
                System.out.println();
                System.out.println("Origem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

                boolean[][] movimentosPossiveis = jogoXadrez.movimentosPossiveis(origem);
                UI.limpaTela();
                UI.imprimeTabuleiro(jogoXadrez.getPecas(), movimentosPossiveis);

                System.out.println();
                System.out.println("Destino: ");
                PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

                PecaXadrez capturaPeca = jogoXadrez.executandoMovimentoXadrez(origem, destino);
            }catch(ExcesaoXadrez e){
                System.out.println(e.getMessage());
                sc.nextLine();

            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();

            }
        }



    }
}
