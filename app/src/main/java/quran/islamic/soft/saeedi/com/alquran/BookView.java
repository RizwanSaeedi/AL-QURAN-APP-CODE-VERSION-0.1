package quran.islamic.soft.saeedi.com.alquran;

import android.content.*;
import android.graphics.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.support.v7.app.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import com.github.clans.fab.*;
import com.gitonway.lee.niftymodaldialogeffects.lib.*;

import java.util.*;

import quran.islamic.soft.saeedi.com.alquran.DataSource.*;


public class BookView extends AppCompatActivity
{
    int total_pages;
    ViewGroup mContentView;
    ScrollView scv;
    Context mContext;
    Intent incoming_intent;
    FloatingActionMenu fab;
    ViewGroup spin_layout;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    private FloatingActionButton fbtn_bookmark;
    private FloatingActionButton fbtn_font_change;
    private FloatingActionButton fbtn_last_page;
    private FloatingActionButton fbtn_goto_page;
    private FloatingActionButton fbtn_search;
    private Spinner goto_page_spinner;
    private int last_page = 0;
    private int book_number;
    private int selected_page;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_pager);

        mContext = this;
        incoming_intent = getIntent();
        // -------------
        mContentView = (ViewGroup) findViewById(R.id.main_content);
        scv = (ScrollView) findViewById(R.id.scv);
        fab = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        fbtn_font_change = (FloatingActionButton) findViewById(R.id.fbtn_font_change);

        fbtn_last_page = (FloatingActionButton) findViewById(R.id.fbtn_last_page);
        fbtn_goto_page = (FloatingActionButton) findViewById(R.id.fbtn_goto_page);
        fbtn_search = (FloatingActionButton) findViewById(R.id.fbtn_search);
        goto_page_spinner = (Spinner) findViewById(R.id.goto_page_spinner);

        spin_layout = (ViewGroup) findViewById(R.id.spin_layout);
        // -------------

        // -------------
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // -------------

        // ----------------


        // ----------------
        final SharedPreferences preferences;

        preferences = this.getSharedPreferences("book_info",
                this.MODE_PRIVATE);

        book_number = preferences.getInt("selection", 0);
        selected_page = preferences.getInt("page", 0);

        Log.i("__intent", book_number + "");

        total_pages = 5;

        List<String> pages = getRangeList(1, last_page);

        ArrayAdapter<String> page_number_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pages);
        goto_page_spinner.setAdapter(page_number_adapter);
        spin_layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                Toast.makeText(mContext, "set", Toast.LENGTH_SHORT).show();
                goto_page_spinner.performClick();

            }
        });
        fbtn_goto_page.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goto_page_spinner.performClick();
                fab.close(true);
            }
        });
        fbtn_search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Log.i("__intent", "sending " + book_number);
            }
        });
        goto_page_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                try
                {
                    if (i > 0)
                    {
                        mViewPager.setCurrentItem(i - 1);
                        goto_page_spinner.setSelection(0);
//                        mViewPager.setOffscreenPageLimit(10);

                    }
                } catch (Exception e)
                {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
        // ----------------

        fbtn_font_change.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                fab.close(true);

                AlertDialog.Builder font_dialogue = new AlertDialog.Builder(mContext);
                font_dialogue.setMessage("Choose Font");
                font_dialogue.setPositiveButton("Nastaleeq", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("text-font", "Nastaleeq");
                        editor.commit();
                        recreate();
                    }
                });
                font_dialogue.setNegativeButton("Al-Mushaaf", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("text-font", "Al-Mushaaf");
                        editor.commit();
                        recreate();
                    }
                });
//                font_dialogue.show();
                //mViewPager.setCurrentItem(0);

                try
                {
                    final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(mContext);

                    dialogBuilder
                            .withTitle("Font Selection")
                            .withTitleColor(Color.YELLOW)
                            .withDividerColor(Color.WHITE)

                            .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                            .withDialogColor(Color.BLUE)                               //def  | withDialogColor(int resid)
                            .withIcon(getResources().getDrawable(android.R.drawable.ic_dialog_info))
//                        .isCancelableOnTouchOutside(false)                           //def    | isCancelable(true)
//                        .setCustomView(R.layout.custom_view,v.getContext())         //.setCustomView(View or ResId,conte
                            .withEffect(Effectstype.RotateLeft)
                            .withButton1Text("Nastaleeq")                                      //def gone
                            .withButton2Text("Al-Mushaaf")

                            .setButton1Click(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString("text-font", "Nastaleeq");
                                    editor.commit();
                                    recreate();
                                    dialogBuilder.hide();
                                }
                            })
                            .setButton2Click(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString("text-font", "Al-Mushaaf");
                                    editor.commit();
                                    recreate();
                                    dialogBuilder.hide();
                                }
                            })
                            .show();
                } catch (Exception e)
                {
                    Log.i("nifty", e.toString());
                }
            }
        });

        fbtn_last_page.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                fab.close(true);
                mViewPager.setCurrentItem(last_page - 2);
            }
        });

        // -----------------------------------------


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setRotationY(180);
//        mViewPager.setPageTransformer(true, new ZoomPageTransformer());


        mViewPager.setCurrentItem(selected_page);

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

    private List<String> getRangeList(int i, int last_page)
    {

        List<String> list = new ArrayList<>();
        list.add("");
        for (int j = i; j <= last_page; j++)
        {
            list.add(j + "");
        }
        return list;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment
    {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */


        public PlaceholderFragment()
        {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber)
        {

            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);

            fragment.setArguments(args);

            Log.i("_args", "setting page = " + args);

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {

            List<EditText> et_list = new ArrayList<>();


            View rootView = inflater.inflate(R.layout.book_fragment, container, false);

//
            et_list.add((EditText) rootView.findViewById(R.id.et_1));
            et_list.add((EditText) rootView.findViewById(R.id.et_2));
            et_list.add((EditText) rootView.findViewById(R.id.et_3));
            et_list.add((EditText) rootView.findViewById(R.id.et_4));
            et_list.add((EditText) rootView.findViewById(R.id.et_5));
            et_list.add((EditText) rootView.findViewById(R.id.et_6));
            et_list.add((EditText) rootView.findViewById(R.id.et_7));
            et_list.add((EditText) rootView.findViewById(R.id.et_8));
            et_list.add((EditText) rootView.findViewById(R.id.et_9));
            et_list.add((EditText) rootView.findViewById(R.id.et_10));
            et_list.add((EditText) rootView.findViewById(R.id.et_11));
            et_list.add((EditText) rootView.findViewById(R.id.et_12));
            et_list.add((EditText) rootView.findViewById(R.id.et_13));
            et_list.add((EditText) rootView.findViewById(R.id.et_14));
            et_list.add((EditText) rootView.findViewById(R.id.et_15));
            et_list.add((EditText) rootView.findViewById(R.id.et_16));
            et_list.add((EditText) rootView.findViewById(R.id.et_17));
            et_list.add((EditText) rootView.findViewById(R.id.et_18));
            et_list.add((EditText) rootView.findViewById(R.id.et_19));
            et_list.add((EditText) rootView.findViewById(R.id.et_20));
            et_list.add((EditText) rootView.findViewById(R.id.et_21));
            et_list.add((EditText) rootView.findViewById(R.id.et_22));
            et_list.add((EditText) rootView.findViewById(R.id.et_23));
            et_list.add((EditText) rootView.findViewById(R.id.et_24));
            et_list.add((EditText) rootView.findViewById(R.id.et_25));
            et_list.add((EditText) rootView.findViewById(R.id.et_26));
            et_list.add((EditText) rootView.findViewById(R.id.et_27));
            et_list.add((EditText) rootView.findViewById(R.id.et_28));
            et_list.add((EditText) rootView.findViewById(R.id.et_29));
            et_list.add((EditText) rootView.findViewById(R.id.et_30));
            et_list.add((EditText) rootView.findViewById(R.id.et_31));
            et_list.add((EditText) rootView.findViewById(R.id.et_32));
            et_list.add((EditText) rootView.findViewById(R.id.et_33));
            et_list.add((EditText) rootView.findViewById(R.id.et_34));
            et_list.add((EditText) rootView.findViewById(R.id.et_35));
            et_list.add((EditText) rootView.findViewById(R.id.et_36));
            et_list.add((EditText) rootView.findViewById(R.id.et_37));
            et_list.add((EditText) rootView.findViewById(R.id.et_38));
            et_list.add((EditText) rootView.findViewById(R.id.et_39));
            et_list.add((EditText) rootView.findViewById(R.id.et_40));
            et_list.add((EditText) rootView.findViewById(R.id.et_41));
            et_list.add((EditText) rootView.findViewById(R.id.et_42));
            et_list.add((EditText) rootView.findViewById(R.id.et_43));
            et_list.add((EditText) rootView.findViewById(R.id.et_44));
            et_list.add((EditText) rootView.findViewById(R.id.et_45));
            et_list.add((EditText) rootView.findViewById(R.id.et_46));
            et_list.add((EditText) rootView.findViewById(R.id.et_47));
            et_list.add((EditText) rootView.findViewById(R.id.et_48));
            et_list.add((EditText) rootView.findViewById(R.id.et_49));
            et_list.add((EditText) rootView.findViewById(R.id.et_50));
            et_list.add((EditText) rootView.findViewById(R.id.et_51));
            et_list.add((EditText) rootView.findViewById(R.id.et_52));
            et_list.add((EditText) rootView.findViewById(R.id.et_53));
            et_list.add((EditText) rootView.findViewById(R.id.et_54));
            et_list.add((EditText) rootView.findViewById(R.id.et_55));
            et_list.add((EditText) rootView.findViewById(R.id.et_56));
            et_list.add((EditText) rootView.findViewById(R.id.et_57));
            et_list.add((EditText) rootView.findViewById(R.id.et_58));
            et_list.add((EditText) rootView.findViewById(R.id.et_59));
            et_list.add((EditText) rootView.findViewById(R.id.et_60));
            et_list.add((EditText) rootView.findViewById(R.id.et_61));
            et_list.add((EditText) rootView.findViewById(R.id.et_62));
            et_list.add((EditText) rootView.findViewById(R.id.et_63));
            et_list.add((EditText) rootView.findViewById(R.id.et_64));
            et_list.add((EditText) rootView.findViewById(R.id.et_65));
            et_list.add((EditText) rootView.findViewById(R.id.et_66));
            et_list.add((EditText) rootView.findViewById(R.id.et_67));
            et_list.add((EditText) rootView.findViewById(R.id.et_68));
            et_list.add((EditText) rootView.findViewById(R.id.et_69));
            et_list.add((EditText) rootView.findViewById(R.id.et_70));
            et_list.add((EditText) rootView.findViewById(R.id.et_71));
            et_list.add((EditText) rootView.findViewById(R.id.et_72));
            et_list.add((EditText) rootView.findViewById(R.id.et_73));
            et_list.add((EditText) rootView.findViewById(R.id.et_74));
            et_list.add((EditText) rootView.findViewById(R.id.et_75));
            et_list.add((EditText) rootView.findViewById(R.id.et_76));
            et_list.add((EditText) rootView.findViewById(R.id.et_77));
            et_list.add((EditText) rootView.findViewById(R.id.et_78));
            et_list.add((EditText) rootView.findViewById(R.id.et_79));
            et_list.add((EditText) rootView.findViewById(R.id.et_80));
            et_list.add((EditText) rootView.findViewById(R.id.et_81));
            et_list.add((EditText) rootView.findViewById(R.id.et_82));
            et_list.add((EditText) rootView.findViewById(R.id.et_83));
            et_list.add((EditText) rootView.findViewById(R.id.et_84));
            et_list.add((EditText) rootView.findViewById(R.id.et_85));
            et_list.add((EditText) rootView.findViewById(R.id.et_86));


            TextView tv_page = (TextView) rootView.findViewById(R.id.tv_page_num);


            List<String> ar_list;
            List<String> ur_list;
            List<String> tfs_list;
            List<String> ar_ur_list;

            List<String> ar_list_parts;
            List<String> ur_list_parts;
            List<String> tfs_list_parts;
            List<String> ar_ur_list_parts;

            Log.i("_view", "page " + ARG_SECTION_NUMBER);
            int arg = getArguments().getInt(ARG_SECTION_NUMBER);
            Log.i("_args", "getting page = " + arg);

            tv_page.setText(arg+"");
            tv_page.setRotationY(180);

            //----------------------------------------------------------------------------------
            String tafseer_text = new Tafseer_tafseer_ul_hasnat().getList().get(arg);
            String ar_ur_text = new Arabic_Urdu().getList().get(arg);
            //----------------------------------------------------------------------------------

            ar_list_parts = getArabic(ar_ur_text);
            ur_list_parts = getUrdu(ar_ur_text);
            tfs_list_parts = getTafseerPage(tafseer_text);


            int et_counter = 0;
            for (int i = 0; i < ar_list_parts.size(); i++)
            {
                try
                {
                    EditText et_ar = (EditText) et_list.get(et_counter);
                    EditText et_ur = (EditText) et_list.get(et_counter + 1);
                    EditText et_tfs = (EditText) et_list.get(et_counter + 2);

                    et_ar.setVisibility(View.VISIBLE);
                    et_ur.setVisibility(View.VISIBLE);
                    et_tfs.setVisibility(View.VISIBLE);

                    et_ar.setRotationY(180);
                    et_ur.setRotationY(180);
                    et_tfs.setRotationY(180);

                    et_ar.setTextColor(Color.BLUE);
                    et_ur.setTextColor(Color.MAGENTA);

                    SettingsHelper.setFont(getContext(), "Al_Mushaf", et_ar);
                    SettingsHelper.setFont(getContext(), "Al_Mushaf", et_ur);
                    SettingsHelper.setFont(getContext(), "Al_Mushaf", et_tfs);
//                    SettingsHelper.setFont(getContext(), "nastaleeq", et_ur);
//                    SettingsHelper.setFont(getContext(), "nastaleeq", et_tfs);


                    et_ar.setText(ar_list_parts.get(i));
                    et_ur.setText(ur_list_parts.get(i));
                    et_tfs.setText(tfs_list_parts.get(i));

                    et_ar.setGravity(View.TEXT_ALIGNMENT_CENTER);
                    et_ur.setGravity(View.TEXT_ALIGNMENT_CENTER);
                    et_tfs.setGravity(View.TEXT_ALIGNMENT_CENTER);

                } catch (Exception ex)
                {
                    Log.i("_settext", ex.toString());
                }

                et_counter += 3;
            }

//            try
//            {
//
//                for (EditText et:
//                     et_list)
//                {
//                    et.setVisibility(View.VISIBLE);
//                    et.setText("ssssssss");
//
////                tv_page.setText(arg + "");
//                    et_list.get(0).setRotationY(180);
//                }
//            } catch (Exception e)
//            {
//                et_list.get(0).setText("END");
//                tv_page.setText("");
//                Log.i("_view", e.toString());
//            }
           /* Arabic_Urdu QuranData = new Arabic_Urdu();
            Tafseer_tafseer_ul_hasnat TafseerData = new Tafseer_tafseer_ul_hasnat();

            List<String> ar_list;
            List<String> ur_list;
            List<String> tfs_list;
            List<String> ar_ur_list;

            List<String> ar_list_parts;
            List<String> ur_list_parts;
            List<String> tfs_list_parts;
            List<String> ar_ur_list_parts;

            List<View> et_list;
            LinearLayout text_container;
            View rootView = inflater.inflate(R.layout.book_fragment, container, false);
            text_container = (LinearLayout) rootView.findViewById(R.id.text_container_fragment);
            TextView tv_page = (TextView) rootView.findViewById(R.id.tv_page_num);


            Log.i("_view", "page " + ARG_SECTION_NUMBER);
            int arg = getArguments().getInt(ARG_SECTION_NUMBER);

            Log.i("_args", "page = " + arg);


            //----------------------------------------------------------------------------------
            et_list = new ArrayList<>();
            String tafseer_text = TafseerData.getList().get(arg);
            String ar_ur_text = QuranData.getList().get(arg);
            //----------------------------------------------------------------------------------

            ar_list_parts = getArabic(ar_ur_text);
            ur_list_parts = getUrdu(ar_ur_text);
            tfs_list_parts = getTafseerPage(tafseer_text);

            logList("_text", ar_list_parts);
            logList("_text", ur_list_parts);
            logList("_text", tfs_list_parts);

            // get a reference to the LayoutInflater service
            for (int i = 0; i < ar_list_parts.size() * 3; i++)
            {
                // inflate new_tag_view.xml to create new tag and edit Buttons
                View new_textview = inflater.inflate(R.layout.edittext_item, null);

                new_textview.setRotationY(180);

                text_container.addView(new_textview);

                et_list.add(new_textview);
            }

            int et_counter = 0;
            for (int i = 0; i < ar_list_parts.size(); i++)
            {
                EditText et_ar = (EditText) et_list.get(et_counter);
                EditText et_ur = (EditText) et_list.get(et_counter + 1);
                EditText et_tfs = (EditText) et_list.get(et_counter + 2);

                et_ar.setTextColor(Color.BLUE);
                et_ur.setTextColor(Color.MAGENTA);

                SettingsHelper.setFont(getContext(), "Al_Mushaf", et_ar);
                SettingsHelper.setFont(getContext(), "nastaleeq", et_ur);
                SettingsHelper.setFont(getContext(), "nastaleeq", et_tfs);

                try
                {
                    et_ar.setText(ar_list_parts.get(i));
                    et_ur.setText(ur_list_parts.get(i));
                    et_tfs.setText(tfs_list_parts.get(i));
                } catch (Exception e)
                {
                    Log.i("_settext", e.toString());
                }

                et_counter += 3;*/


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {

        public SectionsPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount()
        {
            // Show 3 total pages.
//            int total = new Ahya_ul_uloom().getList().size();

            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {

            return null;
        }
    }

    public static List<String> getDataList(int book_number)
    {
        List<String> list = new ArrayList<>();
        return list;
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
