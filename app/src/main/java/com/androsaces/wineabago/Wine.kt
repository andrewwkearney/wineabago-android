package com.androsaces.wineabago

class Wine(val name: String, val vintage: String, val region: String) {
    override fun toString(): String {
        return "$name $vintage"
    }
}
