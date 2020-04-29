//package quran.islamic.soft.saeedi.com.alquran;
//
//import android.content.*;
//import android.graphics.*;
//import android.os.*;
//import android.support.design.widget.*;
//import android.support.v7.app.*;
//import android.util.*;
//import android.view.*;
//import android.widget.*;
//
//import java.util.*;
//
//import quran.islamic.soft.saeedi.com.alquran.DataSource.*;
//
//public class MainActivity extends AppCompatActivity
//{
//    Arabic_Urdu QuranData;
//    Tafseer_tafseer_ul_hasnat TafseerData;
//    LinearLayout text_container;
//    List<View> et_list;
//    TextView tv_page;
//    public Context mContext;
//    int page = 0;
//    Typeface ar_typeface;
//    Typeface ur_typeface;
//
//    Button btn_next;
//    Button btn_prev;
//
//    List<String> ar_list;
//    List<String> ur_list;
//    List<String> tfs_list;
//    List<String> ar_ur_list;
//
//    List<String> ar_list_parts;
//    List<String> ur_list_parts;
//    List<String> tfs_list_parts;
//    List<String> ar_ur_list_parts;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main);
//
//        mContext = this;
//
//        // ------------------------------------------------------------------------------
//
//        btn_next = (Button) findViewById(R.id.btn_next);
//        btn_prev = (Button) findViewById(R.id.btn_prev);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        List<EditText> et_list = new ArrayList<>();
//
//        et_list.add((EditText) findViewById(R.id.et_1));
//        et_list.add((EditText) findViewById(R.id.et_2));
//        et_list.add((EditText) findViewById(R.id.et_3));
//        et_list.add((EditText) findViewById(R.id.et_4));
//        et_list.add((EditText) findViewById(R.id.et_5));
//        et_list.add((EditText) findViewById(R.id.et_6));
//        et_list.add((EditText) findViewById(R.id.et_7));
//        et_list.add((EditText) findViewById(R.id.et_8));
//        et_list.add((EditText) findViewById(R.id.et_9));
//        et_list.add((EditText) findViewById(R.id.et_10));
//        et_list.add((EditText) findViewById(R.id.et_11));
//        et_list.add((EditText) findViewById(R.id.et_12));
//        et_list.add((EditText) findViewById(R.id.et_13));
//        et_list.add((EditText) findViewById(R.id.et_14));
//        et_list.add((EditText) findViewById(R.id.et_15));
//        et_list.add((EditText) findViewById(R.id.et_16));
//        et_list.add((EditText) findViewById(R.id.et_17));
//        et_list.add((EditText) findViewById(R.id.et_18));
//        et_list.add((EditText) findViewById(R.id.et_19));
//        et_list.add((EditText) findViewById(R.id.et_20));
//        et_list.add((EditText) findViewById(R.id.et_21));
//        et_list.add((EditText) findViewById(R.id.et_22));
//        et_list.add((EditText) findViewById(R.id.et_23));
//        et_list.add((EditText) findViewById(R.id.et_24));
//        et_list.add((EditText) findViewById(R.id.et_25));
//        et_list.add((EditText) findViewById(R.id.et_26));
//        et_list.add((EditText) findViewById(R.id.et_27));
//        et_list.add((EditText) findViewById(R.id.et_28));
//        et_list.add((EditText) findViewById(R.id.et_29));
//        et_list.add((EditText) findViewById(R.id.et_30));
//        et_list.add((EditText) findViewById(R.id.et_31));
//        et_list.add((EditText) findViewById(R.id.et_32));
//        et_list.add((EditText) findViewById(R.id.et_33));
//        et_list.add((EditText) findViewById(R.id.et_34));
//        et_list.add((EditText) findViewById(R.id.et_35));
//        et_list.add((EditText) findViewById(R.id.et_36));
//        et_list.add((EditText) findViewById(R.id.et_37));
//        et_list.add((EditText) findViewById(R.id.et_38));
//        et_list.add((EditText) findViewById(R.id.et_39));
//        et_list.add((EditText) findViewById(R.id.et_40));
//        et_list.add((EditText) findViewById(R.id.et_41));
//        et_list.add((EditText) findViewById(R.id.et_42));
//        et_list.add((EditText) findViewById(R.id.et_43));
//        et_list.add((EditText) findViewById(R.id.et_44));
//        et_list.add((EditText) findViewById(R.id.et_45));
//        et_list.add((EditText) findViewById(R.id.et_46));
//        et_list.add((EditText) findViewById(R.id.et_47));
//        et_list.add((EditText) findViewById(R.id.et_48));
//        et_list.add((EditText) findViewById(R.id.et_49));
//        et_list.add((EditText) findViewById(R.id.et_50));
//        et_list.add((EditText) findViewById(R.id.et_51));
//        et_list.add((EditText) findViewById(R.id.et_52));
//        et_list.add((EditText) findViewById(R.id.et_53));
//        et_list.add((EditText) findViewById(R.id.et_54));
//        et_list.add((EditText) findViewById(R.id.et_55));
//        et_list.add((EditText) findViewById(R.id.et_56));
//        et_list.add((EditText) findViewById(R.id.et_57));
//        et_list.add((EditText) findViewById(R.id.et_58));
//        et_list.add((EditText) findViewById(R.id.et_59));
//        et_list.add((EditText) findViewById(R.id.et_60));
//        et_list.add((EditText) findViewById(R.id.et_61));
//        et_list.add((EditText) findViewById(R.id.et_62));
//        et_list.add((EditText) findViewById(R.id.et_63));
//        et_list.add((EditText) findViewById(R.id.et_64));
//        et_list.add((EditText) findViewById(R.id.et_65));
//        et_list.add((EditText) findViewById(R.id.et_66));
//        et_list.add((EditText) findViewById(R.id.et_67));
//        et_list.add((EditText) findViewById(R.id.et_68));
//        et_list.add((EditText) findViewById(R.id.et_69));
//        et_list.add((EditText) findViewById(R.id.et_70));
//        et_list.add((EditText) findViewById(R.id.et_71));
//        et_list.add((EditText) findViewById(R.id.et_72));
//        et_list.add((EditText) findViewById(R.id.et_73));
//        et_list.add((EditText) findViewById(R.id.et_74));
//        et_list.add((EditText) findViewById(R.id.et_75));
//        et_list.add((EditText) findViewById(R.id.et_76));
//        et_list.add((EditText) findViewById(R.id.et_77));
//        et_list.add((EditText) findViewById(R.id.et_78));
//        et_list.add((EditText) findViewById(R.id.et_79));
//        et_list.add((EditText) findViewById(R.id.et_80));
//        et_list.add((EditText) findViewById(R.id.et_81));
//        et_list.add((EditText) findViewById(R.id.et_82));
//        et_list.add((EditText) findViewById(R.id.et_83));
//        et_list.add((EditText) findViewById(R.id.et_84));
//        et_list.add((EditText) findViewById(R.id.et_85));
//        et_list.add((EditText) findViewById(R.id.et_86));
//
//
//        tv_page = (TextView) findViewById(R.id.tv_page_num);
//
//        loadPage();
//
//
//        btn_next.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                page++;
//                loadPage();
//            }
//        });
//
//        btn_prev.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                page--;
//                loadPage();
//            }
//        });
//
//
//
//
//    }
//
//    private void loadPage()
//    {
//        //----------------------------------------------------------------------------------
//        String tafseer_text = new Tafseer_tafseer_ul_hasnat().getList().get(page);
//        String ar_ur_text = new Arabic_Urdu().getList().get(page);
//        //----------------------------------------------------------------------------------
//
//        tv_page.setText(page+"");
//
//        ar_list_parts = getArabic(ar_ur_text);
//        ur_list_parts = getUrdu(ar_ur_text);
//        tfs_list_parts = getTafseerPage(tafseer_text);
//
//
//        logList("__data", ar_list_parts);
//        logList("__data", ur_list_parts);
//        logList("__data", tfs_list_parts);
//
//
//
//
//        int et_counter = 0;
//        for (int i = 0; i < ar_list_parts.size(); i++)
//        {
//
//            EditText et_ar = (EditText) et_list.get(et_counter);
//            EditText et_ur = (EditText) et_list.get(et_counter + 1);
//            EditText et_tfs = (EditText) et_list.get(et_counter + 2);
//
//            et_ar.setVisibility(View.VISIBLE);
//            et_ur.setVisibility(View.VISIBLE);
//            et_tfs.setVisibility(View.VISIBLE);
//
//            et_ar.setTextColor(Color.BLUE);
//            et_ur.setTextColor(Color.MAGENTA);
//
//            SettingsHelper.setFont(mContext, "Al_Mushaf", et_ar);
//            SettingsHelper.setFont(mContext, "Al_Mushaf", et_ur);
//            SettingsHelper.setFont(mContext, "Al_Mushaf", et_tfs);
////                    SettingsHelper.setFont(getContext(), "nastaleeq", et_ur);
////                    SettingsHelper.setFont(getContext(), "nastaleeq", et_tfs);
//
////
//            et_ar.setText(ar_list_parts.get(i));
//            et_ur.setText(ur_list_parts.get(i));
//            et_tfs.setText(tfs_list_parts.get(i));
//
//
//            et_counter += 3;
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings)
//        {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    private static List<String> getArabic(String text)
//    {
//        List<String> list = new ArrayList<>();
//
//
//        String[] parts = text.split("\n");
//
//
//        logList("_getarabic", parts);
//        for (int i = 0; i < parts.length; i++)
//        {
//            if ((i % 2) == 0)
//            {
//                list.add(parts[i]);
//            }
//        }
//
//        return list;
//    }
//
//    private static List<String> getUrdu(String text)
//    {
//        List<String> list = new ArrayList<>();
//
//        String[] parts = text.split("\n");
//
//        for (int i = 0; i < parts.length; i++)
//        {
//            if ((i % 2) != 0)
//            {
//                list.add(parts[i]);
//            }
//        }
//
//        return list;
//    }
//
//    public static void logList(String tag, List<String> ar_list_parts)
//    {
//        for (String item :
//                ar_list_parts)
//        {
//            Log.i(tag, item);
//        }
//    }
//
//    public static void logList(String tag, String[] ar_list_parts)
//    {
//        for (String item :
//                ar_list_parts)
//        {
//            Log.i(tag, item);
//        }
//    }
//
//    public static List<String> getTafseerPage(String text)
//    {
//        List<String> list = new ArrayList<>();
//
//        String[] parts = text.split("\n");
//
//        for (int i = 0; i < parts.length; i++)
//        {
//            list.add(parts[i]);
//        }
//
//        return list;
//    }
//}
