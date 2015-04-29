package mg.ma.com.arcshapeexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {


    private TextView textView;
    private ImageView imageView;
    private int totalTime = 30000;
    private Paint paint;
    private Bitmap bg;
    private Canvas canvas;
    private RectF rectF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        imageView = (ImageView) findViewById(R.id.image_view);
        paint = new Paint();

        new CountDownTimer(totalTime, 1000) {//also parse it to long

            public void onTick(long millisUntilFinished) {
                textView.setText("" + millisUntilFinished / 1000);
                paint.setColor(Color.parseColor("#000000"));

                if (bg != null)
                    bg.recycle();

                bg = Bitmap.createBitmap(320, 320, Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bg);
                rectF = new RectF(0, 0, 320, 320);
                canvas.drawArc(rectF, 0, 12 * (millisUntilFinished) / 1000, true, paint);
                imageView.setImageBitmap(bg);
            }

            public void onFinish() {
                textView.setText("0");
                if (bg != null)
                    bg.recycle();

                bg = Bitmap.createBitmap(320, 320, Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bg);
                canvas.drawArc(rectF, 0, 12 * (0) / 1000, true, paint);
                imageView.setImageBitmap(bg);


            }
        }
                .start();


    }

    @Override
    public void finish() {
        super.finish();
        if (bg != null)
            bg.recycle();


    }
}
