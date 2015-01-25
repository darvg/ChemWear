package siddharth.com.chemforwear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class InfoActivity extends Activity {

    private TextView mTextView;
    Element ele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent i = getIntent();

        ele = (Element) i.getParcelableExtra("EXTRA_ELEMENT");

        TextView atomicNo = (TextView)findViewById(R.id.numberView);
        TextView nameSymbView = (TextView)findViewById(R.id.nameSyblView);
        TextView info = (TextView)findViewById(R.id.infoView);

        atomicNo.setText(Integer.toString(ele.getAtomicNumber()));
        nameSymbView.setText(ele.getSymbol() + ":" + ele.getName());
        info.setText(ele.getInfo());
        info.setMovementMethod(new ScrollingMovementMethod());


    }
}
