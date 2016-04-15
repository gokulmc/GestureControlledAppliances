package gesture.on.send.sendongesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetector mGestureDetector;

    private EditText etContent;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mGestureDetector = new GestureDetector(this, new GestureListener());

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        etContent = (EditText) findViewById(R.id.etContent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //method onTouchEvent of GestureDetector class Analyzes the given motion event
        //and if applicable triggers the appropriate callbacks on the GestureDetector.OnGestureListener supplied.
        //Returns true if the GestureDetector.OnGestureListener consumed the event, else false.

        boolean eventConsumed=mGestureDetector.onTouchEvent(event);
        if (eventConsumed)
        {
            Toast.makeText(this,GestureListener.currentGestureDetected, Toast.LENGTH_LONG).show();
            etContent.setText("hello");
            return true;
        }
        else
            return false;
    }
}
