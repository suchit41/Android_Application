package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    EditText Name,Email,Contact,Password;
    Button Sign_in,Update,Delete,View;
    DBhelper db ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Name = findViewById(R.id.Name );
        Email = findViewById(R.id.Email);
        Contact = findViewById(R.id.Contact);
        Password = findViewById(R.id.Password);
        Sign_in = findViewById(R.id.Sign_in);
        Update = findViewById(R.id.Update);
        Delete = findViewById(R.id.Delete);
        View = findViewById(R.id.View);
        db = new DBhelper(this);
                Sign_in.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
String Nametxt= Name.getText().toString();
String Emailtxt = Email.getText().toString();
String Contacttxt = Contact.getText().toString();
String Passwordtxt = Password.getText().toString();
Boolean checkinsertdata =   db.insertuserdata(Nametxt,Emailtxt,Contacttxt,Passwordtxt);
if(checkinsertdata==true){
    Toast.makeText(MainActivity.this,"new is enter",Toast.LENGTH_SHORT).show();
}else {
    Toast.makeText(MainActivity.this,"not enter",Toast.LENGTH_SHORT).show();
}
                    }
                });
       Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nametxt = Name.getText().toString();
                String Emailtxt = Email.getText().toString();
                String Contacttxt = Contact.getText().toString();
                String Passwordtxt = Password.getText().toString();
                Boolean checkupdatedata =   db.updateuserdata(Nametxt,Emailtxt,Contacttxt,Passwordtxt);
                if(checkupdatedata==true){
                    Toast.makeText(MainActivity.this," update",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"not update",Toast.LENGTH_SHORT).show();
                }
    } });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nametxt= Name.getText().toString();
                String Emailtxt = Email.getText().toString();
                String Contacttxt = Contact.getText().toString();
                String Passwordtxt = Password.getText().toString();
                Boolean checkdeletedata =   db.deleteuserdata(Nametxt,Emailtxt,Contacttxt,Passwordtxt);
                if(checkdeletedata==true){
                    Toast.makeText(MainActivity.this," delete",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"not delete",Toast.LENGTH_SHORT).show();
                }
            } });
      View.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(android.view.View view) {
              Cursor res = db.getdata();
              if(res.getCount()==0){
                  Toast.makeText(MainActivity.this,"no entry ",Toast.LENGTH_SHORT).show();
                  return;
              }
              StringBuilder buffer = new StringBuilder();
              while (res.moveToNext()){
                  buffer.append("Name").append(res.getString(0)).append("\n");
                  buffer.append("Email").append(res.getString(1)).append("\n");
                  buffer.append("Contact").append(res.getString(2)).append("\n");
                  buffer.append("Password").append(res.getString(3)).append("\n");

              }
              AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
              builder.setCancelable(true);
              builder.setTitle("user Enteries");
              builder.setMessage(buffer.toString());
              builder.show();
          }
      });

       }}