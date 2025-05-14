public class DetailActivity extends AppCompatActivity {

    TextView tvName, tvSymbol, tvAtomicNumber, tvAtomicMass, tvGroup, tvPeriod, tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tvName);
        tvSymbol = findViewById(R.id.tvSymbol);
        tvAtomicNumber = findViewById(R.id.tvAtomicNumber);
        tvAtomicMass = findViewById(R.id.tvAtomicMass);
        tvGroup = findViewById(R.id.tvGroup);
        tvPeriod = findViewById(R.id.tvPeriod);
        tvCategory = findViewById(R.id.tvCategory);

        String elementJson = getIntent().getStringExtra("element");
        Element element = new Gson().fromJson(elementJson, Element.class);

        tvName.setText("Name: " + element.name);
        tvSymbol.setText("Symbol: " + element.symbol);
        tvAtomicNumber.setText("Atomic Number: " + element.atomicNumber);
        tvAtomicMass.setText("Atomic Mass: " + element.atomicMass);
        tvGroup.setText("Group: " + element.group);
        tvPeriod.setText("Period: " + element.period);
        tvCategory.setText("Category: " + element.category);
    }
}
