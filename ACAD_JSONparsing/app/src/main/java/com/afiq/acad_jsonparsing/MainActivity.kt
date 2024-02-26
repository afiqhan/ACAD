package com.afiq.acad_jsonparsing
import android.os.Bundle
import android.util.Log
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // private string declare in the latter section of the program
        val jsonStr = listData
        try {

            // Create a userList string hashmap arraylist
            val userList = ArrayList<HashMap<String, String?>>()

            // Declaring the listView from the layout file
            val lv = findViewById<ListView>(R.id.user_list)

            // Initializing the JSON object and extracting the data
            val jObj = JSONObject(jsonStr)
            val jsonArry = jObj.getJSONArray("users")
            for (i in 0 until jsonArry.length()) {
                val user = HashMap<String, String?>()
                val obj = jsonArry.getJSONObject(i)
                user["name"] = obj.getString("name")
                user["designation"] = obj.getString("designation")
                user["location"] = obj.getString("location")
                userList.add(user)
            }
            // ListAdapter to broadcast the information to the list elements
            val adapter: ListAdapter = SimpleAdapter(
                this, userList, R.layout.list_row,
                arrayOf("name", "designation", "location"), intArrayOf(
                    R.id.name,
                    R.id.designation, R.id.location
                )
            )
            lv.adapter = adapter
        } catch (ex: JSONException) {
            Log.e("JsonParser Example", "unexpected JSON exception", ex)
        }
    }

    private val listData: String
        get() = ("{ \"users\" :[" +
                "{\"name\":\"Azim\",\"designation\":\"Engineer\",\"location\":\"Malaysia\"}" +
                ",{\"name\":\"Harun Majid\",\"designation\":\"Accountant\",\"location\":\"Singapore\"}" +
                ",{\"name\":\"Omar\",\"designation\":\"Developer\",\"location\":\"Yemen\"}] }")
}
