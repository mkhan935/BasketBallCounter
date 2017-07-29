package com.example.mustafa.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int teamMoScore = 0;
    int teamWhackScore =0;
    TextView endView1;
    TextView endView2;

    /** get method, makes it easier to future proof this in case i want to expand
     * and good practice to write out getters */
    private int getTeamMoScore(){
        return teamMoScore;
    }

    private int getTeamWhackScore(){
        return teamWhackScore;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * following method is used to display the score to the view,
     * takes PARAM score
     */

    public void displayForTeamMo(int score){
        TextView scoreView = (TextView) findViewById(R.id.teamMo_Score);
        scoreView.setText("Score: "+ score);
    }

    public void displayForTeamWhack(int score){
        TextView scoreView= (TextView) findViewById(R.id.teamwhack_Score);
        scoreView.setText("Score: "+ score);
    }

    public void displayGameStatusForTeam1(int diff){
        TextView statusView1 = (TextView) findViewById(R.id.game_status_1);
        if(diff>0){
            statusView1.setText("You are winning by: " +diff + " points!\n Keep it up!");
        }
        if(diff < 0){
            int stat = Math.abs(diff);
            statusView1.setText("You are losing by: "+ stat+ " points!\n Try Harder!" );
        }
        if(diff == 0) {
            statusView1.setText("You are tied with the other team" );
        }
    }


    public void displayGameStatusForTeam2(int diff) {
        TextView statusView2 = (TextView) findViewById(R.id.game_status_2);
        if (diff > 0) {
            statusView2.setText("You are winning by: " + diff + " points!\n Keep it up!");
        }
        if (diff < 0) {
            int stat = Math.abs(diff);
            statusView2.setText("You are losing by: " + stat + " points!\n Try Harder!");
        }
        if (diff == 0) {
            statusView2.setText("You are tied with the other team" );
        }
    }

    public void displayOnEnd(boolean end){
        endView1 = (TextView) findViewById(R.id.end_view1);
        endView2 = (TextView) findViewById(R.id.end_view2);


        if(end ){
            endView1.setText("WINNER,WINNER CHICKEN DINNER!");
            endView2.setText("LOSER, LOSER, NOW WHO's DINNER!");
        }

        if (!end){
            endView2.setText("WINNER,WINNER CHICKEN DINNER!");
            endView1.setText("LOSER, LOSER, NOW WHO's DINNER!");
        }
    }


    public void matchEnd(View v){
        if(getTeamMoScore() > getTeamWhackScore()){
            displayOnEnd(true);
        }

        if(getTeamWhackScore() > getTeamMoScore()){
            displayOnEnd(false);
        }

        if(getTeamMoScore() == getTeamWhackScore()){
            endView1 = (TextView) findViewById(R.id.end_view1);
            endView2 = (TextView) findViewById(R.id.end_view2);
            endView1.setText("GAME ENDS IN A DRAW");
            endView2.setText("GAME ENDS IN A DRAW");
        }

        teamMoScore=0;
        teamWhackScore = 0;
        displayForTeamMo(teamMoScore);
        displayForTeamWhack(teamWhackScore);

    }


    public void status1(View v){
        int diff =  getTeamMoScore() - getTeamWhackScore();
        displayGameStatusForTeam1(diff);

    }

    public void status2(View v){
        int diff =  getTeamWhackScore() - getTeamMoScore();
        displayGameStatusForTeam2(diff);

    }

    /** Following method is used for button +3 points  */

    public void plus3ForTeamMo(View v){
        teamMoScore=teamMoScore+3;
        displayForTeamMo(teamMoScore);
    }

    public void plus3ForTeamWhack(View v){
        teamWhackScore=teamWhackScore+3;
        displayForTeamWhack(teamWhackScore);
    }

    /** Following method is used for button +2 points  */

    public void plus2ForTeamMo(View v) {
        teamMoScore=teamMoScore+2;
        displayForTeamMo(teamMoScore);
    }

    public void plus2ForTeamWhack(View v){
        teamWhackScore=teamWhackScore+2;
        displayForTeamWhack(teamWhackScore);
    }

    /** Following method is used for button free throw  */

    public void freeThrow(View v){
        teamMoScore=teamMoScore+1;
        displayForTeamMo(teamMoScore);
    }

    public void freeThrowTeamWhack(View v){
        teamWhackScore=teamWhackScore+1;
        displayForTeamWhack(teamWhackScore);
    }

}
