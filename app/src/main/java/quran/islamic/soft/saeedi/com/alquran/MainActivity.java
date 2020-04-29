package quran.islamic.soft.saeedi.com.alquran;

import android.content.*;
import android.graphics.*;
import android.os.*;

import android.support.v7.app.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import com.github.clans.fab.*;

import java.util.*;

import quran.islamic.soft.saeedi.com.alquran.DataSource.*;

public class MainActivity extends AppCompatActivity
{

    Context mContext;
    SharedPreferences preferences;
    int page = 0;

    Typeface ar_typeface;
    Typeface ur_typeface;

    TextView tv_page;
    Button btn_next;
    Button btn_prev;
    ScrollView scv;
    FloatingActionButton fbtn_font_size_change;
    FloatingActionMenu fab;

    int limit = 0;

    List<View> et_list;
    List<String> tafseer_data_list;
    List<String> quran_data_list;
    int font_size = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        preferences = this.getSharedPreferences("settings",
                this.MODE_PRIVATE);

        font_size = Integer.parseInt(preferences.getString("font-size", "15"));

        // -----------------------------------------------------------------------------
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_prev = (Button) findViewById(R.id.btn_prev);
        scv = (ScrollView) findViewById(R.id.scv);
        fbtn_font_size_change = (FloatingActionButton) findViewById(R.id.fbtn_font_size);
        fab = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ar_typeface = SettingsHelper.setFont(mContext, "Al_Mushaf");
        ur_typeface = SettingsHelper.setFont(mContext, "nastaleeq");

        quran_data_list = new ArrayList<>();
        tafseer_data_list = new ArrayList<>();

        tafseer_data_list = new Tafseer_tafseer_ul_hasnat().getList();
        quran_data_list = new Arabic_Urdu().getList();

        limit = tafseer_data_list.size();

        Log.i("_limit", limit + "");

        et_list = new ArrayList<>();

        et_list.add((EditText) findViewById(R.id.et_1));
        et_list.add((EditText) findViewById(R.id.et_2));
        et_list.add((EditText) findViewById(R.id.et_3));
        et_list.add((EditText) findViewById(R.id.et_4));
        et_list.add((EditText) findViewById(R.id.et_5));
        et_list.add((EditText) findViewById(R.id.et_6));
        et_list.add((EditText) findViewById(R.id.et_7));
        et_list.add((EditText) findViewById(R.id.et_8));
        et_list.add((EditText) findViewById(R.id.et_9));
        et_list.add((EditText) findViewById(R.id.et_10));
        et_list.add((EditText) findViewById(R.id.et_11));
        et_list.add((EditText) findViewById(R.id.et_12));
        et_list.add((EditText) findViewById(R.id.et_13));
        et_list.add((EditText) findViewById(R.id.et_14));
        et_list.add((EditText) findViewById(R.id.et_15));
        et_list.add((EditText) findViewById(R.id.et_16));
        et_list.add((EditText) findViewById(R.id.et_17));
        et_list.add((EditText) findViewById(R.id.et_18));
        et_list.add((EditText) findViewById(R.id.et_19));
        et_list.add((EditText) findViewById(R.id.et_20));
        et_list.add((EditText) findViewById(R.id.et_21));
        et_list.add((EditText) findViewById(R.id.et_22));
        et_list.add((EditText) findViewById(R.id.et_23));
        et_list.add((EditText) findViewById(R.id.et_24));
        et_list.add((EditText) findViewById(R.id.et_25));
        et_list.add((EditText) findViewById(R.id.et_26));
        et_list.add((EditText) findViewById(R.id.et_27));
        et_list.add((EditText) findViewById(R.id.et_28));
        et_list.add((EditText) findViewById(R.id.et_29));
        et_list.add((EditText) findViewById(R.id.et_30));
        et_list.add((EditText) findViewById(R.id.et_31));
        et_list.add((EditText) findViewById(R.id.et_32));
        et_list.add((EditText) findViewById(R.id.et_33));
        et_list.add((EditText) findViewById(R.id.et_34));
        et_list.add((EditText) findViewById(R.id.et_35));
        et_list.add((EditText) findViewById(R.id.et_36));
        et_list.add((EditText) findViewById(R.id.et_37));
        et_list.add((EditText) findViewById(R.id.et_38));
        et_list.add((EditText) findViewById(R.id.et_39));
        et_list.add((EditText) findViewById(R.id.et_40));
        et_list.add((EditText) findViewById(R.id.et_41));
        et_list.add((EditText) findViewById(R.id.et_42));
        et_list.add((EditText) findViewById(R.id.et_43));
        et_list.add((EditText) findViewById(R.id.et_44));
        et_list.add((EditText) findViewById(R.id.et_45));
        et_list.add((EditText) findViewById(R.id.et_46));
        et_list.add((EditText) findViewById(R.id.et_47));
        et_list.add((EditText) findViewById(R.id.et_48));
        et_list.add((EditText) findViewById(R.id.et_49));
        et_list.add((EditText) findViewById(R.id.et_50));
        et_list.add((EditText) findViewById(R.id.et_51));
        et_list.add((EditText) findViewById(R.id.et_52));
        et_list.add((EditText) findViewById(R.id.et_53));
        et_list.add((EditText) findViewById(R.id.et_54));
        et_list.add((EditText) findViewById(R.id.et_55));
        et_list.add((EditText) findViewById(R.id.et_56));
        et_list.add((EditText) findViewById(R.id.et_57));
        et_list.add((EditText) findViewById(R.id.et_58));
        et_list.add((EditText) findViewById(R.id.et_59));
        et_list.add((EditText) findViewById(R.id.et_60));
        et_list.add((EditText) findViewById(R.id.et_61));
        et_list.add((EditText) findViewById(R.id.et_62));
        et_list.add((EditText) findViewById(R.id.et_63));
        et_list.add((EditText) findViewById(R.id.et_64));
        et_list.add((EditText) findViewById(R.id.et_65));
        et_list.add((EditText) findViewById(R.id.et_66));
        et_list.add((EditText) findViewById(R.id.et_67));
        et_list.add((EditText) findViewById(R.id.et_68));
        et_list.add((EditText) findViewById(R.id.et_69));
        et_list.add((EditText) findViewById(R.id.et_70));
        et_list.add((EditText) findViewById(R.id.et_71));
        et_list.add((EditText) findViewById(R.id.et_72));
        et_list.add((EditText) findViewById(R.id.et_73));
        et_list.add((EditText) findViewById(R.id.et_74));
        et_list.add((EditText) findViewById(R.id.et_75));
        et_list.add((EditText) findViewById(R.id.et_76));
        et_list.add((EditText) findViewById(R.id.et_77));
        et_list.add((EditText) findViewById(R.id.et_78));
        et_list.add((EditText) findViewById(R.id.et_79));
        et_list.add((EditText) findViewById(R.id.et_80));
        et_list.add((EditText) findViewById(R.id.et_81));
        et_list.add((EditText) findViewById(R.id.et_82));
        et_list.add((EditText) findViewById(R.id.et_83));
        et_list.add((EditText) findViewById(R.id.et_84));
        et_list.add((EditText) findViewById(R.id.et_85));
        et_list.add((EditText) findViewById(R.id.et_86));


        tv_page = (TextView) findViewById(R.id.tv_page_num);

        fbtn_font_size_change.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                fab.close(true);

                LayoutInflater inflater = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);

                // inflate slideshow_name_edittext.xml to create an EditText
                View view = inflater.inflate(R.layout.font_size_slider, null);
                final SeekBar seekBar =
                        (SeekBar) view.findViewById(R.id.seekBar2);
                final TextView textView =
                        (TextView) view.findViewById(R.id.font_textview);

                int font_size = Integer.parseInt(preferences.getString("font-size", "15"));

                seekBar.setProgress(font_size);
                textView.setTextSize(font_size);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
                    {
                        Log.i("_seekbar", progress + "");
                        if (progress > 10)
                        {
                            textView.setTextSize(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar)
                    {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar)
                    {

                    }
                });


                AlertDialog.Builder font_dialogue = new AlertDialog.Builder(mContext);
                font_dialogue.setMessage("Choose Font Size");
                font_dialogue.setView(view);
                font_dialogue.setPositiveButton("Set", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        seekBar.getProgress();

                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("font-size", seekBar.getProgress() + "");
                        editor.commit();
                        recreate();
                    }
                });
                font_dialogue.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
                font_dialogue.create();
                font_dialogue.show();

            }
        });
        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                scv.scrollTo(0,0);
                page++;
                if (page < limit)
                {
                    hideAllEditText();
                    loadPage();
                }
                else
                {
                    page--;
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                scv.scrollTo(0,0);
                page--;
                if (page >= 0)
                {
                    hideAllEditText();
                    loadPage();
                }
                else
                {
                    page++;
                }
            }
        });

        hideAllEditText();
        loadPage();


    }

    private void hideAllEditText()
    {
        for (View view :
                et_list)
        {
            EditText et = (EditText) view;
            et.setVisibility(View.GONE);
        }
    }

    private void loadPage()
    {

        tv_page.setText((page + 1) + "");
        List<String> ar_list_parts;
        List<String> ur_list_parts;
        List<String> tfs_list_parts;
        List<String> ar_ur_list_parts;


        //----------------------------------------------------------------------------------
        String tafseer_text = tafseer_data_list.get(page);
        String ar_ur_text = quran_data_list.get(page);
        //----------------------------------------------------------------------------------

        ar_list_parts = getArabic(ar_ur_text);
        ur_list_parts = getUrdu(ar_ur_text);
        tfs_list_parts = getTafseerPage(tafseer_text);


        logList("__data", ar_list_parts);
        logList("__data", ur_list_parts);
        logList("__data", tfs_list_parts);

        int et_counter = 0;
        for (int i = 0; i < ur_list_parts.size(); i++)
        {

            EditText et_ar = (EditText) et_list.get(et_counter);
            EditText et_ur = (EditText) et_list.get(et_counter + 1);
            EditText et_tfs = (EditText) et_list.get(et_counter + 2);

            et_ar.setVisibility(View.VISIBLE);
            et_ur.setVisibility(View.VISIBLE);
            et_tfs.setVisibility(View.VISIBLE);
            et_ar.setTextSize(font_size);
            et_ur.setTextSize(font_size);
            et_tfs.setTextSize(font_size);

            et_ar.setTextColor(Color.BLUE);
            et_ur.setTextColor(Color.MAGENTA);

            et_ar.setTypeface(ar_typeface);
            et_ur.setTypeface(ur_typeface);
            et_tfs.setTypeface(ur_typeface);


            et_ar.setText(ar_list_parts.get(i));
            et_ur.setText(ur_list_parts.get(i));
            et_tfs.setText(tfs_list_parts.get(i));


            et_counter += 3;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static List<String> getArabic(String text)
    {
        List<String> list = new ArrayList<>();


        String[] parts = text.split("\n");


        logList("_getarabic", parts);
        for (int i = 0; i < parts.length; i++)
        {
            if ((i % 2) == 0)
            {
                list.add(parts[i]);
            }
        }

        return list;
    }

    private static List<String> getUrdu(String text)
    {
        List<String> list = new ArrayList<>();

        String[] parts = text.split("\n");

        for (int i = 0; i < parts.length; i++)
        {
            if ((i % 2) != 0)
            {
                list.add(parts[i]);
            }
        }

        return list;
    }

    public static void logList(String tag, List<String> ar_list_parts)
    {
        for (String item :
                ar_list_parts)
        {
            Log.i(tag, item);
        }
    }

    public static void logList(String tag, String[] ar_list_parts)
    {
        for (String item :
                ar_list_parts)
        {
            Log.i(tag, item);
        }
    }

    public static List<String> getTafseerPage(String text)
    {
        List<String> list = new ArrayList<>();

        String[] parts = text.split("\n");

        for (int i = 0; i < parts.length; i++)
        {
            list.add(parts[i]);
        }

        return list;
    }
}
