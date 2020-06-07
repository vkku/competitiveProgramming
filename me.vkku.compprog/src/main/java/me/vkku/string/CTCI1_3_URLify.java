package me.vkku.string;

import org.junit.Test;

public class CTCI1_3_URLify {

    public String[] urlifyString(String[] str, int trueLength){
        int spaceCount = 0;
        for(int i = 0 ; i < trueLength ; i++){
            if(str[i] == " "){
                spaceCount++;
            }
        }
        int requiredLength = (spaceCount * 2) + trueLength;
        if(trueLength < str.length){
            str[trueLength] = "\0";
        }
        for(int i = trueLength - 1 ; i >= 0 ; i--){
            if(str[i] == " "){
                str[requiredLength - 1] = "0";
                str[requiredLength - 2] = "2";
                str[requiredLength - 3] = "%";
                requiredLength = requiredLength - 3;
            }else{
                str[requiredLength - 1] = str[i];
                requiredLength--;
            }
        }
        return str;
    }



    @Test
    public void main(){
        CTCI1_3_URLify ctci1_3_urLify = new CTCI1_3_URLify();
        String[] str = {"M", "r", " ", "J", "o", "h", "n", " ", "S", "m", "i", "t", "h", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        String[] ret = ctci1_3_urLify.urlifyString(str, 13);
        //ctci1_3_urLify
    }

}
