package vamsee.application.digitalregisterassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vamsee.application.digitalregisterassignment.Model.Transaction;

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.ViewHolder> {

    private ArrayList<Transaction> data = new ArrayList<>();

    public TransactionListAdapter(ArrayList<Transaction> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transaction txn = data.get(position);
        holder.date.setText(txn.getDate());
        holder.time.setText(txn.getTime());
        holder.name.setText(txn.getName());
        holder.unit.setText(txn.getUnit());
        if (txn.getTypeOfTransaction() == "sell"){
            holder.sell.setText(txn.getTotalPrice());
        }
        else {
            holder.purchase.setText(txn.getTotalPrice());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

    public TextView date, time, name, unit, purchase, sell;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        this.date = itemView.findViewById(R.id.SellingDate);
        this.time = itemView.findViewById(R.id.SellingTime);
        this.name = itemView.findViewById(R.id.name);
        this.unit = itemView.findViewById(R.id.unit);
        this.purchase = itemView.findViewById(R.id.purchase);
        this.sell = itemView.findViewById(R.id.sell);

    }
}
}



