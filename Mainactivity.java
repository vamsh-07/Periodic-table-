public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Element> elementList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        elementList = loadElementsFromAssets();
        recyclerView.setAdapter(new ElementAdapter(this, elementList));
    }

    private List<Element> loadElementsFromAssets() {
        try {
            InputStream is = getAssets().open("elements.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            Type listType = new TypeToken<List<Element>>() {}.getType();
            return new Gson().fromJson(json, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
