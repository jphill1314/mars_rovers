package com.jphill.retrofit.rovers

sealed class Rover (
    val name: String,
    val cameras: List<Pair<String, String>>
)

class CuriosityRover: Rover(
    "curiosity",
    listOf(
        Pair("fhaz", "Front Hazard Avoidance Camera"),
        Pair("rhaz", "Rear Hazard Avoidance Camera"),
        Pair("mast", "Mast Camera"),
        Pair("chemcam", "Chemistry and Camera Complex"),
        Pair("mahli", "Mars Hand Lens Imager"),
        Pair("mardi", "Mars Descent Imager"),
        Pair("navcam", "Navigation Camera")
    )
)

class Opportunity: Rover(
    "opportunity",
    listOf(
        Pair("fhaz", "Front Hazard Avoidance Camera"),
        Pair("rhaz", "Rear Hazard Avoidance Camera"),
        Pair("navcam", "Navigation Camera"),
        Pair("pancam", "Panoramic Camera"),
        Pair("minites", "Miniature Thermal Emission Spectrometer (Mini-TES)")
    )
)

class Spirit: Rover(
    "spirit",
    listOf(
        Pair("fhaz", "Front Hazard Avoidance Camera"),
        Pair("rhaz", "Rear Hazard Avoidance Camera"),
        Pair("navcam", "Navigation Camera"),
        Pair("pancam", "Panoramic Camera"),
        Pair("minites", "Miniature Thermal Emission Spectrometer (Mini-TES)")
    )
)

fun Rover.asInt() = when(this) {
    is CuriosityRover -> 0
    is Opportunity -> 1
    is Spirit -> 2
}

fun Int.toRover() = when(this) {
    0 -> CuriosityRover()
    1 -> Opportunity()
    2 -> Spirit()
    else -> null
}