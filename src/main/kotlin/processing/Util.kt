package processing

import processing.core.PApplet
import kotlin.random.Random

data class HSBColor(
    val hue: Int,
    val saturation: Int,
    val brightness: Int
) {
    companion object {
        fun random() = HSBColor(
            hue = Random.nextInt(0, 360),
            saturation = Random.nextInt(0, 100),
            brightness = Random.nextInt(0, 100)
        )

        fun random(baseHue: Int, jitter: Int = 100): HSBColor {

            val randomishHue = baseHue + Random.nextInt(-jitter / 2, jitter / 2)

            return HSBColor(
                hue = randomishHue,
                saturation = Random.nextInt(10, 90),
                brightness = Random.nextInt(10, 90)
            )
        }
    }
}

data class Rectangle(
    val x: Int,
    val y: Int,
    val width: Int,
    val height: Int,
    val color: HSBColor
)

fun PApplet.bg(color: HSBColor) {
    with(color) {
        background(hue.f, saturation.f, brightness.f)
    }
}

fun PApplet.draw(rectangle: Rectangle) {
    with(rectangle) {
        fillWith(color)
        rect(x.f, y.f, width.f, height.f)
    }
}

fun PApplet.drawWithJitter(rectangle: Rectangle, jitter: Int) {
    with(rectangle) {
        fillWith(color)
        rect(
            (x + Random.nextInt(-jitter, jitter)).f,
            (y + Random.nextInt(-jitter, jitter)).f,
            width.f,
            height.f
        )
    }
}

fun PApplet.fillWith(color: HSBColor) {
    with(color) {
        fill(hue.f, saturation.f, brightness.f)
    }
}
val Int.f: Float
    get() = this.toFloat()

val <T> List<T>.pairwise: List<Pair<T, T>>
    get() = zipWithNext()
