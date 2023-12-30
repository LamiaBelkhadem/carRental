package com.example.swe401swe2009867

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Car(
    val imageResId: Int,
    val name: String,
    val pricePerDay: Double,
    val mileageLimit: Int,
    val fuelType: String,
    val transmissionType: String,
    val numberOfSeats: Int,
    val isAvailable: Boolean
)


class MainActivity : AppCompatActivity() {

    private lateinit var carRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carRecyclerView = findViewById(R.id.carRecyclerView)
        carRecyclerView.layoutManager = LinearLayoutManager(this)

        val carList = listOf(
            Car(R.drawable.car1, "Toyota Corolla", 55.0, 250, "Petrol", "Automatic", 5, true),
            Car(R.drawable.car1, "Honda Civic", 60.0, 300, "Petrol", "Automatic", 5, false),
            Car(R.drawable.car1, "Ford Mustang", 120.0, 200, "Petrol", "Manual", 4, true),
            Car(R.drawable.car1, "Chevrolet Camaro", 130.0, 200, "Petrol", "Manual", 4, true),
            Car(R.drawable.car1, "BMW 3 Series", 110.0, 300, "Diesel", "Automatic", 5, false),
            Car(R.drawable.car1, "Mercedes-Benz C-Class", 115.0, 300, "Diesel", "Automatic", 5, true),
            Car(R.drawable.car1, "Audi A4", 100.0, 300, "Diesel", "Automatic", 5, true),
            Car(R.drawable.car1, "Nissan Altima", 58.0, 300, "Petrol", "Automatic", 5, true),
            Car(R.drawable.car1, "Volkswagen Jetta", 55.0, 300, "Diesel", "Automatic", 5, false),
            Car(R.drawable.car1, "Hyundai Sonata", 53.0, 300, "Hybrid", "Automatic", 5, true),
            Car(R.drawable.car1, "Kia Optima", 50.0, 300, "Petrol", "Automatic", 5, true),
            Car(R.drawable.car1, "Mazda 6", 59.0, 300, "Petrol", "Automatic", 5, false)
        )



        val adapter = CarAdapter(carList)
        carRecyclerView.adapter = adapter
    }

    class CarAdapter(private val carList: List<Car>) :
        RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.car_card_item, parent, false)
            return CarViewHolder(view)
        }

        override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
            val car = carList[position]
            holder.carImage.setImageResource(car.imageResId)
            holder.carName.text = car.name
            holder.carPrice.text = "$${car.pricePerDay} per day"

            holder.viewCarButton.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, CarOverview::class.java)
                intent.putExtra("carName", car.name)
                intent.putExtra("carPrice", car.pricePerDay)
                intent.putExtra("carImageResId", car.imageResId)
                intent.putExtra("mileageLimit", car.mileageLimit)
                intent.putExtra("fuelType", car.fuelType)
                intent.putExtra("transmissionType", car.transmissionType)
                intent.putExtra("numberOfSeats", car.numberOfSeats)
                intent.putExtra("isAvailable", car.isAvailable)
                context.startActivity(intent)
            }

        }

        override fun getItemCount(): Int {
            return carList.size
        }

        class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val carImage: ImageView = itemView.findViewById(R.id.carImage)
            val carName: TextView = itemView.findViewById(R.id.carName)
            val carPrice: TextView = itemView.findViewById(R.id.carPrice)
            val viewCarButton: Button = itemView.findViewById(R.id.viewCarButton)
        }
    }
}
