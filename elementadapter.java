public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ViewHolder> {

    private List<Element> elements;
    private Context context;

    public ElementAdapter(Context context, List<Element> elements) {
        this.context = context;
        this.elements = elements;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSymbol, tvAtomicNumber;

        public ViewHolder(View view) {
            super(view);
            tvSymbol = view.findViewById(R.id.tvSymbol);
            tvAtomicNumber = view.findViewById(R.id.tvAtomicNumber);
        }
    }

    @Override
    public ElementAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ElementAdapter.ViewHolder holder, int position) {
        Element element = elements.get(position);
        holder.tvSymbol.setText(element.symbol);
        holder.tvAtomicNumber.setText(String.valueOf(element.atomicNumber));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("element", new Gson().toJson(element));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
