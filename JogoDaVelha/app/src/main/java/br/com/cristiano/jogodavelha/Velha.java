package br.com.cristiano.jogodavelha;


import java.util.concurrent.ExecutionException;

public class Velha {

    Boolean eVezDoJogador1 = true;
    Ponto pontos[] = new Ponto[9];
    int contador = 0;

    public Velha(){

        for (int x = 0;x < 3;x++){
            for (int y = 0;y < 3;y++) {
                pontos[contador] = new Ponto(x, y);
                contador += 1;
            }
        }

    }

    public void jogada(int position) throws Exception {

        if (pontos[position].valor != ""){
            throw new Exception("Já marcado");
        }

        if(eVezDoJogador1){
            pontos[position].valor = "X";
        }else{
            pontos[position].valor = "O";
        }

        eVezDoJogador1 = !eVezDoJogador1;


        if(!pontos[0].valor.equals("") && pontos[0].valor.equals(pontos[1].valor) && pontos[0].valor.equals(pontos[2].valor)) throw new NumberFormatException(quemGanhou());
        if(!pontos[3].valor.equals("") && pontos[3].valor.equals(pontos[4].valor) && pontos[3].valor.equals(pontos[5].valor)) throw new NumberFormatException(quemGanhou());
        if(!pontos[6].valor.equals("") && pontos[6].valor.equals(pontos[7].valor) && pontos[6].valor.equals(pontos[8].valor)) throw new NumberFormatException(quemGanhou());
        if(!pontos[0].valor.equals("") && pontos[0].valor.equals(pontos[3].valor) && pontos[0].valor.equals(pontos[5].valor)) throw new NumberFormatException(quemGanhou());
        if(!pontos[1].valor.equals("") && pontos[1].valor.equals(pontos[4].valor) && pontos[1].valor.equals(pontos[7].valor)) throw new NumberFormatException(quemGanhou());
        if(!pontos[2].valor.equals("") && pontos[2].valor.equals(pontos[5].valor) && pontos[2].valor.equals(pontos[8].valor)) throw new NumberFormatException(quemGanhou());
        if(!pontos[0].valor.equals("") && pontos[0].valor.equals(pontos[4].valor) && pontos[0].valor.equals(pontos[8].valor)) throw new NumberFormatException(quemGanhou());
        if(!pontos[2].valor.equals("") && pontos[2].valor.equals(pontos[4].valor) && pontos[2].valor.equals(pontos[6].valor)) throw new NumberFormatException(quemGanhou());

        boolean jogoAcabou = true;
        for (int x = 0;x < 9; x++){
            if (pontos[x].valor == ""){
                jogoAcabou = false;
            }
        }

        if(jogoAcabou){
            throw new Exception("Game over!");
        }




    }

    private String quemGanhou() {
        if(eVezDoJogador1){
            return "Jogador 1 Ganhou!";
        }else{
            return "Jogador 2 Ganhou!";
        }

    }

}






































































