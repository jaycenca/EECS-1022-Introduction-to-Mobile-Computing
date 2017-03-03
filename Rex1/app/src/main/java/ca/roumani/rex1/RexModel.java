package ca.roumani.rex1;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 3/1/17.
 */
public class RexModel
{
    //attributes
    private String regex;
    private boolean digits, letters, anchors;


    //FINAL VALUE attributes
    public static final int SET_SIZE = 3;



    private boolean digit;
    private boolean letter;
    private boolean anchor;

    private Random rng;
    private String DigitPiece, LetterPiece,QPiece;

     //default constructor

    public RexModel()
    {
        regex = "";
        digit = true;
        letter = true;
        anchor = true;

        rng= new Random();
    }

    public void setDigit(boolean digit)
    {
        this.digit=digit;
    }

    public void setLetter(boolean letter)
    {
        this.letter=letter;
    }

    public void setAnchor(boolean anchor)
    {
        this.anchor=anchor;
    }

    public java.lang.String getRex()
    {
        return this.regex;
    }

    public boolean doesMatch(java.lang.String s)
    {
        Pattern p = Pattern.compile(this.regex);
        Matcher m = p.matcher(s);
        return (m.matches());
    }



    public void generate(int repeat)
    {
        regex="";
        int index = 0;
        while(index < repeat)
        {
            if(digit)
            {
                genDigit();
                regex += DigitPiece;
            }
            if(letter)
            {
                genLetter();
                regex += LetterPiece;
            }
            index++;
        }

        if(anchor)
        {
            regex = "^" + this.regex + "$";
        }
    }

    private void genDigit()       // generates the digit piece
    {
        genQuantifier();
        //DigitPiece = rng.nextInt(10)+"";

        if(rng.nextDouble()<0.5)
        {DigitPiece = "[0-9]"+ QPiece;}

    }

    private void genLetter()      // generates the letter piece
    {
        genQuantifier();
        //LetterPiece = (char)(rng.nextInt(26)+97)+"";

        if(rng.nextDouble()<0.5)
        {LetterPiece="[a-z]"+QPiece;}

    }
    private void genQuantifier()  // generates a quantifier
    {
        Double prob = (double)1 / (double) 6;
        if(rng.nextDouble()<prob)
        {
            QPiece = "*";
        }
        else if (rng.nextDouble()< 2*prob)
        {
            QPiece = "?";
        }
        else if (rng.nextDouble()< 3*prob)
        {
            QPiece="+";
        }
        else
        {
            QPiece="{"+(rng.nextInt(SET_SIZE)+1)+"}";
        }


        //char result = (char)(rng.nextInt(26)+'!');

        //return String.valueOf(result);

    }

    public static void main(String[] args)
    {
        RexModel model = new RexModel();

        String x = " am1";
        boolean y = model.doesMatch(x);
        System.out.println(y+"\n");

        model.genDigit();
        System.out.println("digit is "+model.DigitPiece);

        model.genLetter();
        System.out.println("Letter is " + model.LetterPiece);



    }

}
