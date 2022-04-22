package com.adl.ujianandoridretrofit

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.github.drjacky.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_checkin.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class CheckinActivity : AppCompatActivity() {

    lateinit var photoURI: Uri

    private val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val uri = it.data?.data!!

                photo.setImageURI(uri)
                photoURI = uri
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkin)

        btnCamera.setOnClickListener({
            cameraLauncher.launch(
                ImagePicker.with(this)
                    .crop()
                    .cameraOnly()
                    .maxResultSize(480, 800, true)
                    .createIntent()
            )

        })

        fun createRB(data: String): RequestBody {
            return RequestBody.create(MultipartBody.FORM, data)
        }

        fun uploadImage(uri: Uri, param: String): MultipartBody.Part {
            val file: File = File(uri.path)
            val rb: RequestBody = file.asRequestBody("image/jpeg".toMediaTypeOrNull())

            return MultipartBody.Part.createFormData(param, file.name, rb)


        }
    }
}