package b.m.i;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcBmi(View view){
        //部品自体を取得
        EditText etHeight = findViewById(R.id.height);
        //取得した部品情報を取得
        String strHeight = etHeight.getText().toString();
        //体重取得
        EditText etWeight = findViewById(R.id.weight);
        //数字数値変換
        double weight = Double.parseDouble(etWeight.getText().toString());
        double height = Double.parseDouble(strHeight);

        //BMI計算
        BigDecimal Bbmi;
        height /= 100.0;
        double bmi = weight / (height * height);
        Bbmi = new BigDecimal(bmi);
        Bbmi = Bbmi.setScale(1, RoundingMode.HALF_UP);

        //標準体型計算
        BigDecimal Bappweight;
        double appweight = (height * height) * 22;
        Bappweight = new BigDecimal(appweight);
        Bappweight = Bappweight.setScale(1, RoundingMode.HALF_UP);


        Bitmap img_pass ;
        String result_ans = "";
        if(40 < bmi){
            result_ans = "肥満(3度)";
            ImageView myImage= findViewById(R.id.imgcode);
            img_pass = BitmapFactory.decodeResource(getResources(), R.drawable.fat);
            myImage.setImageBitmap(img_pass);
        }else if(bmi < 16){
            result_ans = "痩せすぎ";
            ImageView myImage= findViewById(R.id.imgcode);
            img_pass = BitmapFactory.decodeResource(getResources(), R.drawable.thin);
            myImage.setImageBitmap(img_pass);
        }else if(35 < bmi){
            result_ans = "肥満(2度)";
            ImageView myImage= findViewById(R.id.imgcode);
            img_pass = BitmapFactory.decodeResource(getResources(), R.drawable.fat);
            myImage.setImageBitmap(img_pass);
        }else if(30 < bmi){
            result_ans = "肥満(1度)";
            ImageView myImage= findViewById(R.id.imgcode);
            img_pass = BitmapFactory.decodeResource(getResources(), R.drawable.fat);
            myImage.setImageBitmap(img_pass);
        }else if(25 < bmi){
            result_ans = "前肥満";
            ImageView myImage= findViewById(R.id.imgcode);
            img_pass = BitmapFactory.decodeResource(getResources(), R.drawable.normal);
            myImage.setImageBitmap(img_pass);
        }else if(18.50 < bmi){
            result_ans = "普通体重";
            ImageView myImage= findViewById(R.id.imgcode);
            img_pass = BitmapFactory.decodeResource(getResources(), R.drawable.normal);
            myImage.setImageBitmap(img_pass);
        }else if(17 < bmi) {
            result_ans = "痩せ気味";
            ImageView myImage= findViewById(R.id.imgcode);
            img_pass = BitmapFactory.decodeResource(getResources(), R.drawable.normal);
            myImage.setImageBitmap(img_pass);
        }else if(16 < bmi) {
            result_ans = "痩せ";
            ImageView myImage= findViewById(R.id.imgcode);
            img_pass = BitmapFactory.decodeResource(getResources(), R.drawable.thin);
            myImage.setImageBitmap(img_pass);
        }

        //BMI
        //TextViewをインスタンス化
        TextView tvBmi = findViewById(R.id.bmi);
        //結果を表示する
        tvBmi.setText(String.valueOf(Bbmi));

        //標準体重
        //TextViewをインスタンス化
        TextView stdweight = findViewById(R.id.std_weight);
        //結果を表示する
        stdweight.setText(String.valueOf(Bappweight));

        //肥満度
        //TextViewをインスタンス化
        TextView tvResult = findViewById(R.id.result);
        //結果を表示する
        tvResult.setText(result_ans);

    }

}