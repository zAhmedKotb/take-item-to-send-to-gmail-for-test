package com.abokotb.ordertake

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.reflect.typeOf


class MainActivity : AppCompatActivity() {

    private val mango = "Mango"
    private val orange = "Orange"
    private val apple = "Apple"
    private val pineapple = "Pineapple"

    private val subject = "orders Drink"
    private val message = "your order is : "

    val valuo = mapOf(
        mango to 17,
        orange to 32,
        apple to 22,
        pineapple to 12
    )



    lateinit var btn:Button
    lateinit var drop1:AutoCompleteTextView
    lateinit var resalt: TextInputEditText
    lateinit var fieldDrop: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inshlizetion()
        adopter()

        drop1.setOnItemClickListener { adapterView, view, i, l ->
            var someValuo = valuo [drop1.text.toString()]
            resalt.setText(someValuo.toString())

        }

        btn.setOnClickListener(){
             intent =  Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","email@email.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);

            typeOf<String>();
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));

            //If you don't have a specific recipient - go like this:

            /*Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "", null));
            */
           /* val email = Intent(Intent.ACTION_SENDTO)
            email.type = "message/rfc822"
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(to))
            email.putExtra(Intent.EXTRA_SUBJECT, subject)
            email.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(Intent.createChooser(email, "Choose an Email client :"))*/
        }


    }
    private fun adopter() {
        val listItem = listOf(mango,orange,apple,pineapple)
        var adapter =ArrayAdapter (this,R.layout.drop_down,listItem)
        drop1.setAdapter(adapter)
    }
    private fun inshlizetion(){

        btn= findViewById(R.id.btn)
        drop1 = findViewById(R.id.itemsIs)
        resalt= findViewById(R.id.resalt)
        fieldDrop  = findViewById(R.id.SelectItemDrink)

    }

}