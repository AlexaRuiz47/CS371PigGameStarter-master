package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by alexaruiz on 10/12/17.
 */


public class PigGameState extends GameState{

    private int player0;
    private int player1;
    private int total;
    private int die;
    private int id;

    public PigGameState(){

        player0 = 0;
        player1 = 0;
        total = 0;
        id= (int) (Math.random()+1);
        die = (int) (Math.random()*6+1);

    }

    public PigGameState (PigGameState p) {

        player0 = p.getPlayer0();
        player1 = p.getPlayer1();
        total = p.getTotal();
        die = p.getDie();
        id= p.getId();

    }

    public int getPlayer0 () {


        return player0;
    }

    public int getPlayer1 () {


        return player1;
    }

    public int getTotal () {


        return total;
    }

    public int getDie() {


        return die;

    }

    public int getId () {


        return id;
    }

    public void setPlayer0 (int player0) {

        this.player0 = player0;
    }

    public void setPlayer1 (int player1) {

        this.player1 = player1;
    }

    public void setTotal (int total) {

        this.total =total;

    }

    public void setDie(int die) {

        this.die = die;
    }

    public void setId (int id) {

        this.id = id;

    }








}
