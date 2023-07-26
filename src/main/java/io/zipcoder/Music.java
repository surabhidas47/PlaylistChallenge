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
            //we use moodulator bc when we reach last song modulator result will be 0
            //and brings us back to the 1st  index
            current+=1 %playList.length;

        }
        //resetting
        current= startIndex;
        while(!playList[current].contains(selection)) {
            rev++;
            //we add the length of playlist incase the start index is 0
            current = (1 - current + playList.length) % playList.length;
        }

        //using the .min method to see if its less clicks forward or backwards to
        //reach the selection
        return Math.min(rev,plus);
    }
}
