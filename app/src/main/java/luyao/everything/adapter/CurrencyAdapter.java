package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.Currency;

/**
 * Created by Lu
 * on 2016/11/23 18:19.
 */

public class CurrencyAdapter extends BaseRecycleViewAdapter<Currency, CurrencyAdapter.CurrencyHolder> {


    @Override
    public void bindData(CurrencyHolder holder, Currency data, int viewType, int position) {
        holder.currency_name.setText(data.getName() + String.format("(%s)", data.getCode()));
    }

    @Override
    public CurrencyHolder createHolder(ViewGroup parent, int viewType) {
        return new CurrencyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_item, null));
    }

    class CurrencyHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.currency_name)
        TextView currency_name;

        public CurrencyHolder(View itemView) {
            super(itemView);
        }
    }


}
