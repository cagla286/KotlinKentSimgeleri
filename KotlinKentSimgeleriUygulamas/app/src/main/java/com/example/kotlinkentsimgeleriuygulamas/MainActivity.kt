package com.example.kotlinkentsimgeleriuygulamas

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Data
        var landMarkNames = ArrayList<String>()
        landMarkNames.add("Pisa")
        landMarkNames.add("Colosseum")
        landMarkNames.add("Eiffel")
        landMarkNames.add("London Bridge")

        //Image

        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colosseum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val londonBridge = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)

        var landMarkImages = ArrayList<Bitmap>()
        landMarkImages.add(pisa)
        landMarkImages.add(colosseum)
        landMarkImages.add(eiffel)
        landMarkImages.add(londonBridge)


        //val adapter = ArrayAdapter(this,R.layout.list_row,R.id.textView2,landmarks)
         var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landMarkNames)
        
         listView.adapter = adapter
        
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val intent = Intent(this,DetailsActivity::class.java)

            intent.putExtra("name",landMarkNames[position])

            val singleton = Singleton.Selected
            singleton.selectedImage = landMarkImages[position]



            startActivity(intent)
        }
    }
}