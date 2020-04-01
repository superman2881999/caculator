package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private float numberOne;
    private float numberTwo;
    private String phepTinh;
    private String xuatRaManHinh="";
    //Khai báo các View
    private TextView tvResult;
    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnCham;
    private Button btnAmHoacDuong;
    private Button btnCE;
    private Button btnC;
    private Button btnBS;
    private Button btnEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
        tvResult.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/DS-DIGI.TTF"));
    }

    // Khởi tạo gán gtri các id cho button tương ứng
    public void initWidget() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnNumber0 = (Button) findViewById(R.id.So0);
        btnNumber1 = (Button) findViewById(R.id.So1);
        btnNumber2 = (Button) findViewById(R.id.So2);
        btnNumber3 = (Button) findViewById(R.id.So3);
        btnNumber4 = (Button) findViewById(R.id.So4);
        btnNumber5 = (Button) findViewById(R.id.So5);
        btnNumber6 = (Button) findViewById(R.id.So6);
        btnNumber7 = (Button) findViewById(R.id.So7);
        btnNumber8 = (Button) findViewById(R.id.So8);
        btnNumber9 = (Button) findViewById(R.id.So9);
        btnCong = (Button) findViewById(R.id.phepCong);
        btnTru = (Button) findViewById(R.id.phepTru);
        btnNhan = (Button) findViewById(R.id.phepNhan);
        btnChia = (Button) findViewById(R.id.phepChia);
        btnCham = (Button) findViewById(R.id.dauCham);
        btnAmHoacDuong = (Button) findViewById(R.id.AmHoacDuong);
        btnBS = (Button) findViewById(R.id.nutBS);
        btnC = (Button) findViewById(R.id.nutC);
        btnCE = (Button) findViewById(R.id.nutCE);
        btnEqual = (Button) findViewById(R.id.dauBang);
    }

    // Lắng nghe sự kiện
    public void setEventClickViews() {
        btnEqual.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnCham.setOnClickListener(this);
        btnAmHoacDuong.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnCE.setOnClickListener(this);
    }

    //chạy vào hàm onClick khi có sự kiện click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phepCong:
                phepTinh = "+";
                numberOne = Float.parseFloat(tvResult.getText().toString());
                xuatRaManHinh="0";
                tvResult.setText(String.valueOf(numberOne));
                break;

            case R.id.phepTru:
                phepTinh = "-";
                numberOne = Float.parseFloat(tvResult.getText().toString());
                xuatRaManHinh="0";
                tvResult.setText(String.valueOf(numberOne));
                break;

            case R.id.phepNhan:
                phepTinh = "*";
                numberOne = Float.parseFloat(tvResult.getText().toString());
                xuatRaManHinh="0";
                tvResult.setText(String.valueOf(numberOne));
                break;

            case R.id.phepChia:
                phepTinh = "/";
                numberOne = Float.parseFloat(tvResult.getText().toString());
                xuatRaManHinh="0";
                tvResult.setText(String.valueOf(numberOne));
                break;

            case R.id.AmHoacDuong:
                String newNumber2 = AmHoacDuong(tvResult.getText().toString());
                tvResult.setText(newNumber2);
                break;
            // Xoá 1 ký tự vừa nhập
            case R.id.nutBS:
                String newNumber = deleteAString(tvResult.getText().toString());
                xuatRaManHinh=newNumber;
                tvResult.setText(newNumber);
                break;
            //
            case R.id.nutC:
                tvResult.setText("0");
                numberOne = 0.0f;
                numberTwo = 0.0f;
                xuatRaManHinh ="0";
                break;

            case R.id.nutCE:
                if(isCheck(phepTinh)){
                    numberTwo = 0.0f;
                    xuatRaManHinh="0";
                    tvResult.setText("0");
                }
                else numberOne = 0.0f;
                xuatRaManHinh="0";
                tvResult.setText("0");
                break;

            case R.id.dauBang:
               String newNumber3 = result(tvResult.getText().toString());
                tvResult.setText(newNumber3);
                numberOne=0.0f;
                xuatRaManHinh="0";
                break;
            // Nối chuỗi các toán hạng và loại bỏ số 0 ở đầu toán hạng
            default:
                if(xuatRaManHinh.equals("0")){
                    xuatRaManHinh="";
                }
                xuatRaManHinh+=((Button)v).getText().toString();
                tvResult.setText(xuatRaManHinh);
                break;
        }
    }
    // Xoá ký tự vừa nhập vào
    public String deleteAString(String number) {
        if(number.length()>1) {
            String temp = number.substring(0, number.length() - 1);
            return temp;
        }
        return xuatRaManHinh ;
    }
    // đổi number thành âm hoặc dương
    int count=0;
    public String AmHoacDuong(String number) {

        if(count==0){
            number ="-"+number;
            count=1;
        }
        else if(count==1){
            number = (String) number.subSequence(1,number.length());
            count=0;
        }
        return number;
    }
    // Lưu số thứ 2,3,4,... nhập vào và trả về kết quả phép tính
    public String result(String number) {
        float ketqua = 0;
        numberTwo = Float.parseFloat(number);
        if (phepTinh.equals("+")) {
            ketqua = numberOne + numberTwo;
        }
        else if(phepTinh.equals("-")){
            ketqua = numberOne - numberTwo;
        }
        else if(phepTinh.equals("*")){
            ketqua = numberOne * numberTwo;
        }
        else if(phepTinh.equals("/")){
            ketqua = numberOne / numberTwo;
        }
        numberTwo=ketqua;
        return String.valueOf(ketqua);
    }
    // Check xem một nút phép tính vừa được bấm hay không
    public boolean isCheck(String number){
        if(phepTinh.equals("+")||phepTinh.equals("-")||phepTinh.equals("*")||phepTinh.equals("/")){
            return true;
        }
        else return false;
    }

}
