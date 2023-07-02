package com.example.myhomework

object CapitalRepository {
    val list: List<Capital> = listOf(
        Capital(id = 1, name = "Moscow", url = "https://en.wikipedia.org/wiki/Moscow#/media/File:Saint_Basil's_Cathedral_and_the_Red_Square.jpg", description = "The capital of Russia"),
        Capital(id = 2, name = "Saint-Petersburg", url = "https://en.wikipedia.org/wiki/Saint_Petersburg#/media/File:Winter_Palace_Panorama_3.jpg", description = "Cultural Capital of Russia"),
        Capital(id = 3, name = "Yekaterinburg", url = "https://en.wikipedia.org/wiki/Yekaterinburg#/media/File:E-burg_asv2019-05_img46_view_from_VysotSky.jpg", description = "Capital of the Urals"),
    )

    fun getAllCapital() : List<Capital> {
        return list
    }

    fun getCapitalFromId(id: Int) : Capital{
        var capital = list.firstOrNull{capital ->
            capital.id == id
        }
        return capital!!
    }

}