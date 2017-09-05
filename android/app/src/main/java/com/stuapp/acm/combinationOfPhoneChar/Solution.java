package com.stuapp.acm.combinationOfPhoneChar;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    HashMap<String,List<String>> dictionary=new HashMap<>();
    List<String> results=new ArrayList<>();

    //递归
    private void recurse(String digits,String prefix)
    {

        String digit=digits.substring(0,1);
        List<String> items=dictionary.get(digit);
        for(int i=0;i<items.size();i++)
        {
            String character=items.get(i);
            if(digits.length()>1)
            {

                recurse(digits.substring(1,digits.length()),prefix+character);
            }else{
                results.add(prefix+character);
            }
        }

    }

    public List<String> letterCombinations(String digits) {


        dictionary.put("2", Arrays.asList("a","b","c"));
        dictionary.put("3", Arrays.asList("d","e","f"));
        dictionary.put("4", Arrays.asList("g","h","i"));
        dictionary.put("5", Arrays.asList("j","k","l"));
        dictionary.put("6", Arrays.asList("m","n","o"));
        dictionary.put("7", Arrays.asList("p","q","r","s"));
        dictionary.put("8", Arrays.asList("t","u","v"));
        dictionary.put("9", Arrays.asList("w","x","y","z"));

        if(digits.length()<1)
        {}
        else
            recurse(digits,"");

        return results;
    }
}
