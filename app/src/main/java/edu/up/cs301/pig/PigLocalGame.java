package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */

    PigGameState state;


    public PigLocalGame() {
        state = new PigGameState();

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {

        if (state.getId() == playerIdx )
        {
            return true;

        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {

        if (action instanceof PigHoldAction) {

            if (state.getId() == 0 ){
                state.setPlayer0(state.getTotal()+state.getPlayer0());
                state.setId(1);

            }
            else if( state.getId() == 1){
                state.setPlayer1(state.getTotal()+state.getPlayer1());
                state.setId(0);
            }
            state.setTotal(0);

            return true;


        }
        else if (action instanceof PigRollAction){

            state.setDie((int) (Math.random()*6+1));
            if(state.getDie() != 1 ){

                state.setTotal(state.getDie() + state.getTotal());

            }
            else {
                state.setTotal(0);
            }

            if(state.getId() == 0){
                state.setId(1);
            }
            else {
                state.setId(0);
            }
            return true;

        }


        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState current;
        current = new PigGameState(state);
        p.sendInfo(current);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (state.getPlayer0() >= 50){

            String win = "Player 0 won! " + state.getPlayer0();
            return win;

        }
        else if (state.getPlayer1() >= 50){
            String win2 = "Player 1 won! " + state.getPlayer1();
            return win2;
        }
        return null;
    }

}// class PigLocalGame
