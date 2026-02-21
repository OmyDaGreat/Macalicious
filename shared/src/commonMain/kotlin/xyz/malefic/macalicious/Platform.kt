package xyz.malefic.macalicious

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
