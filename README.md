# CountDown-Control-with-Arc-Shape-Example
This example shows a demo , how to create a countdown timer with ArcShape on android platform in which the arc decreases with the countdown reducing,

We have used two main parts in this code

1)android.os.CountDownTimer instance

 new CountDownTimer(totalTime, one_tick_duration_mills) {//also parse it to long

            public void onTick(long millisUntilFinished) {
              //perform something on tick
            }

            public void onFinish() {
             //perform something after countdown finish


            }
        }
                .start();
and 
2) The second part comprises of 

  i)Creation of bitmap and creating a Canvas from the bitmap.
  
  ii)An ArcShape that we draw on canvas after every second.
  
  iii)Attach bitmap to ImageView using setImageBitmap method.



PS:This sample was created using Android Studio
