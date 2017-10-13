package edu.up.cs301.pig;

import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by alexaruiz on 10/12/17.
 */

public class PigComputerPlayerSmart extends PigComputerPlayer {
    /**
     * ctor does nothing extra
     *
     * @param name
     */
    public PigComputerPlayerSmart(String name) {
        super(name);
    }


    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof PigGameState) {
            PigGameState turn = (PigGameState) info;
            if(turn.getId() != this.playerNum) {
                return;
            } else {
                // is my turn
                GameAction g;
                int threshold;
                if(50 -turn.getPlayer1() <= 5) {
                    threshold = 0;
                }
                if(Math.abs(turn.getPlayer1() - turn.getPlayer0()) <= 5) {
                    threshold= 6;

                } else if (Math.abs(turn.getPlayer1() - turn.getPlayer0()) <20) {
                    // safe
                    threshold = 4;
                } else {
                    //most risky
                    threshold = 13;
                }
                if(turn.getTotal() >= threshold) {
                    g = new PigHoldAction(this);
                } else {
                    g= new PigRollAction(this);
                }

                game.sendAction(g);
            }
        }
    }//receiveInfo
}
