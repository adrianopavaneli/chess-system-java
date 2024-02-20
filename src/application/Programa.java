package application;

import xadrez.JogoXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoXadrez jogoXadrez = new JogoXadrez();
        while (true) {
            UI.imprimeTabuleiro(jogoXadrez.getPecas());
            System.out.println();
            System.out.println("Origem: ");
            PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

            System.out.println();
            System.out.println("Destino: ");
            PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

            PecaXadrez capturaPeca = jogoXadrez.executandoMovimentoXadrez(origem, destino);

        }

    }
}
