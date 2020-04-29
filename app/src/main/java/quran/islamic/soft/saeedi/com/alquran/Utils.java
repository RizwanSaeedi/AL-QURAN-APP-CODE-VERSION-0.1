package quran.islamic.soft.saeedi.com.alquran;

import android.content.*;
import android.graphics.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;

/**
 * Created by soft on 3/15/2017.
 */

public class Utils
{
    public static void setToFullScreen(ViewGroup mContentView) {

        //      Set full screen mode
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    public static void ui_scroll_to_word_for_scrollview (ScrollView scv, EditText tv, String needle)
    {
        final TextView textView = tv;
        final ScrollView scrollView = scv;
        final String key = needle;
        try
        {
            scrollView.post ( new Runnable()
            {
                @Override
                public void run ()
                {
                    int offset = textView.getText ().toString ().indexOf ( key );
                    Log.i ( "_read", "offset " + offset );
                    int line = textView.getLayout ().getLineForOffset ( offset );
                    int y = textView.getLayout ().getLineTop ( line ); // e.g. I want to scroll to line 40
                    scrollView.scrollTo ( 0, y );
                }
            } );
        } catch (Exception e)
        {
            Log.i ( "_read", e.toString () );
        }
    }
    public static String get_clean_arabic(String v) {
        v = v.replaceAll("۟", "");
        v = v.replaceAll("ِ", "");
        v = v.replaceAll("ْ", "");
        v = v.replaceAll("ّ", "");
        v = v.replaceAll("َ", "");
        v = v.replaceAll("ـ", "");
        v = v.replaceAll("ُ", "");
        v = v.replaceAll("ُ", "");
        v = v.replaceAll("ۡ", "");
        v = v.replaceAll("ٓ", "");
        v = v.replaceAll("ٰ", "");
        v = v.replaceAll("ؕ", "");
        v = v.replaceAll("ٍ", "");
        v = v.replaceAll("ً", "");
        v = v.replaceAll("ۘ", "");
        v = v.replaceAll("ۙ", "");
        v = v.replaceAll("ۢ", "");
        v = v.replaceAll("ۚ", "");
        v = v.replaceAll("ۤ", "");
        v = v.replaceAll("۪", "");
        v = v.replaceAll("ٌ", "");
        v = v.replaceAll("ٖ", "");
        return v;
    }
    public static void ui_searchFor_advance (String words, EditText tv)
    {

        String parts[] = words.split ( "," );
        Spannable raw = new SpannableString( tv.getText () );
        BackgroundColorSpan[] spans = raw.getSpans ( 0,
                raw.length (),
                BackgroundColorSpan.class );

        for (BackgroundColorSpan span : spans)
        {
            raw.removeSpan ( span );
        }

        for (String item :
                parts)
        {
            int index = TextUtils.indexOf ( raw, item );

            while (index >= 0)
            {
                raw.setSpan ( new BackgroundColorSpan( Color.YELLOW ), index, index
                        + item.length (), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
                index = TextUtils.indexOf ( raw, item, index + item.length () );
            }
        }

        tv.setText ( raw );
    }

    public static void hideKeyboard (Context context, EditText editText)
    {
        // hide the soft keyboard
        ((InputMethodManager) context.getSystemService(
                Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                editText.getWindowToken(), 0);
    }

    public static String separateLanguages (String text)
    {
        boolean isArabic = false;
        boolean isEng = false;
        String[] text_words = text.split ( " " );

        String output = "";

        for (int i = 0; i < text_words.length; i++)
        {
            output += " ";


            String word = text_words[ i ];
            String prev_word = word;
            String next_word = word;
            if (i > 0)
            {
                prev_word = text_words[ i - 1 ];
            }
            if (i < text_words.length - 1)
            {
                next_word = text_words[ i + 1 ];
            }
            if (Utils.isProbablyArabic ( word ) && isArabic == false)
            {
                if (!Utils.isProbablyArabic ( prev_word ))
                {
                    output += "\n";
                    output += word;
                } else
                {
                    output += word;
                }

                isEng = false;
                //isArabic = true;
                Log.i ( "_word", "arabic = " + word );
            } else if (!Utils.isProbablyArabic ( word ) && isEng == false)
            {
                if (Utils.isProbablyArabic ( prev_word ))
                {
                    output += "\n";
                    output += word;
                } else
                {
                    output += word;
                }
                isArabic = false;
                Log.i ( "_word", "eng = " + word );
            } else
            {
                output += word;
                Log.i ( "_word", "simple = " + word );
            }
        }
        return output;
    }

    public static boolean isProbablyArabic (String s)
    {
        for (int i = 0; i < s.length (); )
        {
            int c = s.codePointAt ( i );
            if (c >= 0x0600 && c <= 0x06E0)
            {
                return true;
            }
            i += Character.charCount ( c );
        }
        return false;
    }

    public static String removeHtmlTags(String ans)
    {
        ans = ans.replace ( "<font color=#000000>", "" );
        ans = ans.replace ( "</font></p>", "" );
        ans = ans.replace ( "<font color=#0033cc>", "" );
        ans = ans.replace ( "<font color=#cc3300>", "" );
        ans = ans.replace ( "<font color=#33cc33>", "" );
        ans = ans.replace ( "</font></h3>", "" );
        ans = ans.replace ( "<font color=#e60099>", "" );
        ans = ans.replace ( "<font>", "" );
        ans = ans.replace ( "</font>", "" );
        ans = ans.replace ( "<p>", "" );
        ans = ans.replace ( "</p>", "" );
        ans = ans.replace ( "<h3>", "" );
        ans = ans.replace ( "</h3>", "" );
        ans = ans.replace ( "font", "" );
        ans = ans.replace ( "<font", "" );
        return ans;
    }

    public void alert()
    {
//        dialogBuilder
//                .withTitle("Modal Dialog")                                  //.withTitle(null)  no title
//                .withTitleColor("#FFFFFF")                                  //def
//                .withDividerColor("#11000000")                              //def
//                .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
//                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
//                .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)
//                .withIcon(getResources().getDrawable(R.drawable.icon))
//                .withDuration(700)                                          //def
//                .withEffect(effect)                                         //def Effectstype.Slidetop
//                .withButton1Text("OK")                                      //def gone
//                .withButton2Text("Cancel")                                  //def gone
//                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
//                .setCustomView(R.layout.custom_view,v.getContext())         //.setCustomView(View or ResId,context)
//                .setButton1Click(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setButton2Click(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(v.getContext(),"i'm btn2",Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .show();
    }
}



//        SpannableStringBuilder ss = new SpannableStringBuilder(text);
//        ss.setSpan(new CustomTypefaceSpan("", font), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        ss.setSpan(new CustomTypefaceSpan("", font), 8, 16, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);