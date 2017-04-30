package ca.roumani.piglatin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 3/11/17.
 */
public class PigLatinModel
{
    //Attributes String English, String PigLatin
    private String english,pig;

    //default constructor
    public PigLatinModel()
    {
        this.english = "";
        this.pig = "";
    }

    //parameterized constructor
    public PigLatinModel(java.lang.String text)
    {
        this.english = text;
        this.pig = "";
    }

    //setEnglish mutator
    public void setEnglish(String text)
    {
        this.english = text;
    }

    //getEnglish accessor
    public String getEnglish()
    {
        return english;
    }

    public String getPig()
    {
        return pig;
    }

    public void setPig(String text)
    {
        this.pig = text;
    }



    //translate helper method
    //change it to pig
    //No effiency is acknowledged
    private void pigTranslate(String text)
    {
        String  vowel= "aeiou";
        int cindex = 0;
        int tindex = text.indexOf(vowel.charAt(cindex));

        //handling the first case of the rule
        if(tindex == 0)
        {
            this.pig += text + "way ";
        }
        else
        {
            //enter the while loop if and only if cindex is less than vowel length
            //and tindex = -1
            while(cindex < vowel.length() && tindex == -1)
            {
                cindex++;
                if(cindex == vowel.length())
                {
                    tindex = 0;
                }
                else
                {
                    tindex = text.indexOf(vowel.charAt(cindex));
                }

            }

            //concaternate part of the text to pig
            this.pig += text.substring(tindex) + text.substring(0, tindex)+"ay ";

        }


    }

    /**
     * Description; Translate the English string to pig latin.
     * Methods:
     *   1) a loop and ghen concengrfae
     *   2)....
     */
    public void translate()
    {
        this.pig = "";
        int index = -1;
        String regex = "[aeiou]";
        String [] words = this.english.split("[ .,;]+");

        for (String j : words)
        {
            Matcher m = Pattern.compile("[aeiou]").matcher(j);
            while (m.find())
            {
                index = m.start();
            }

            if(index == 0)
            {
                this.pig += j + "way ";
            }
            else
            {
                if(index ==-1)
                {
                    index = 0;
                    this.pig += " ";
                }
                else
                {
                    //concaternate part of the text to pig
                    this.pig += j.substring(index) + j.substring(0, index) + "ay ";
                }

            }
        }

    }

    public static void main(String[] args)
    {
        /**
         *
        PigLatinModel test = new PigLatinModel();
        test.setEnglish("hello");
        System.out.println("English is now changed to lee");
        test.pigtranslate(test.english);

        System.out.println("The pig latin of \"lee\" is "+ test.getPig() );
         */
        PigLatinModel test = new PigLatinModel();
        test.setEnglish("Hello, this is a long sentence. Find the longest word Truck jwt");
        test.translate();
        System.out.println("Hello, this is a long sentence. Find the longest word Truck jwt");
        System.out.println(test.getPig());




    }
}