package com.example.swe401swe2009867

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.imageview.ShapeableImageView

class CarOverview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_overview)

        // Retrieve data from the intent
        val carName = intent.getStringExtra("carName") ?: "N/A"
        val carPrice = intent.getDoubleExtra("carPrice", 0.0)
        val carImageResId = intent.getIntExtra("carImageResId", 0) //
        val mileageLimit = intent.getIntExtra("mileageLimit", 0)
        val fuelType = intent.getStringExtra("fuelType") ?: "N/A"
        val transmissionType = intent.getStringExtra("transmissionType") ?: "N/A"
        val numberOfSeats = intent.getIntExtra("numberOfSeats", 0)
        val isAvailable = intent.getBooleanExtra("isAvailable", false)

        // Initialize the views
        val carImageView = findViewById<ShapeableImageView>(R.id.carImageView)
        val carNameTextView = findViewById<TextView>(R.id.carNameTextView)
        val carPriceChip = findViewById<Chip>(R.id.carPriceTextView)
        val mileageLimitTextView = findViewById<TextView>(R.id.mileageLimitTextView)
        val fuelTypeTextView = findViewById<TextView>(R.id.fuelTypeTextView)
        val transmissionTypeTextView = findViewById<TextView>(R.id.transmissionTypeTextView)
        val numberOfSeatsTextView = findViewById<TextView>(R.id.numberOfSeatsTextView)
        val availabilityStatusTextView = findViewById<TextView>(R.id.availabilityStatusTextView)

        // Set data to views
        carImageView.setImageResource(carImageResId)
        carNameTextView.text = carName
        carPriceChip.text = getString(R.string.price_per_day, carPrice)
        mileageLimitTextView.text = getString(R.string.mileage_limit, mileageLimit)
        fuelTypeTextView.text = getString(R.string.fuel_type, fuelType)
        transmissionTypeTextView.text = getString(R.string.transmission_type, transmissionType)
        numberOfSeatsTextView.text = getString(R.string.number_of_seats, numberOfSeats)
        availabilityStatusTextView.text = getString(R.string.availability_status, if (isAvailable) "Available" else "Not Available")
    }
}
