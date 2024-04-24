package com.main.appmycityrmv.data.local

import com.main.appmycityrmv.R
import com.main.appmycityrmv.data.model.Category
import com.main.appmycityrmv.data.model.Recommendation

object Datasource {
    val recommendations = listOf(
        Recommendation(
            "Church of the Gesu",
            "The Church of the Gesu is a Jesuit church in Miami, Florida. It is located at 118 Northeast 2nd Street. On July 22, 1974, it was added to the U.S. National Register of Historic Places.",
            R.drawable.church_catedral,
            Category.CHURCH
        ),
        Recommendation(
            "Church of the Little Flower",
            "The Church of the Little Flower is a Roman Catholic church in Coral Gables, Florida. It is located at 2711 Indian Mound Trail. On July 22, 1974, it was added to the U.S. National Register of Historic Places.",
            R.drawable.wedding_cam1,
            Category.WEDDING
        ),
        Recommendation(
            "Church of the Little Flower",
            "The Church of the Little Flower is a Roman Catholic church in Coral Gables, Florida. It is located at 2711 Indian Mound Trail. On July 22, 1974, it was added to the U.S. National Register of Historic Places.",
            R.drawable.hotel_holiday,
            Category.HOTEL
        ),
    )
}