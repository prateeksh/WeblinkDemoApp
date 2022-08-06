package com.example.weblinkdemoapp.model

import com.google.gson.annotations.SerializedName

data class InfoResult(

    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("days"       ) var days       : String? = null,
    @SerializedName("open_on"    ) var openOn     : String? = null,
    @SerializedName("close_on"   ) var closeOn    : String? = null,
    @SerializedName("background" ) var background : String? = null,
    @SerializedName("slug"       ) var slug       : String? = null,
    @SerializedName("open"       ) var open       : String? = null,
    @SerializedName("jodi"       ) var jodi       : String? = null,
    @SerializedName("close"      ) var close      : String? = null,
    @SerializedName("open_date"  ) var openDate   : String? = null

)
