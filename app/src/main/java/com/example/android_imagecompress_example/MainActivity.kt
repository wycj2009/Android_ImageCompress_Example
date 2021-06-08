package com.example.android_imagecompress_example

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainButtonCompress: Button
    private lateinit var activityMainImageviewCompressed: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainButtonCompress = findViewById(R.id.activity_main_button_compress)
        activityMainImageviewCompressed = findViewById(R.id.activity_main_imageview_compressed)

        val drawable = ContextCompat.getDrawable(applicationContext, R.drawable.beach)
        val bitmap = (drawable as BitmapDrawable).bitmap
        val compressedBitmap = compressBitmap(bitmap, 30)

        activityMainButtonCompress.setOnClickListener {
            activityMainImageviewCompressed.setImageBitmap(compressedBitmap)
        }
    }

    private fun compressBitmap(bitmap: Bitmap, quality: Int): Bitmap {
        val stream = ByteArrayOutputStream() // Initialize a new ByteArrayStream

        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, stream) // Compress the bitmap with JPEG format and quality 50%

        val byteArray = stream.toByteArray()

        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size) // Finally, return the compressed bitmap
    }

}