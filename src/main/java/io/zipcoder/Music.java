package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){

        List<String> chooseSong = new ArrayList(Arrays.asList(playList));

        //number of switches forward to reach selection
        int plus =0;
        //num of switches in revere
        int rev =0;
        int current = startIndex;

        //while we arent already at the song we want to select
        while(!playList[current].contains(selection)){

            //we go forward until song is found
            plus++;
            //we are updating the position of the 'start index' as we search
           // current++;

            current+= 1 % chooseSong.size();

        }
        //resetting
        current= startIndex;
        while(!playList[current].contains(selection)) {
            rev++;

            //incanse current is at 0 we would be at index -1
            //so we add the length of choose size
            current = (current-1+chooseSong.size()) %chooseSong.size();


        }

        //using the .min method to see if its less clicks forward or backwards to
        //reach the selection
        return Math.min(rev,plus);
    }
}
