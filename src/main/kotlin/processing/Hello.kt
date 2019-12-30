package processing

import processing.core.PApplet

typealias Drawing = PApplet.() -> Unit

const val WIDTH = 800
const val HEIGHT = 800

class Hello {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PApplet.main("processing.HelloProcessing")
        }
    }
}

class HelloProcessing() : PApplet() {

    override fun settings() {
        size(WIDTH, HEIGHT)
    }

    override fun setup() {
        background(255)
        colorMode(HSB, 360f, 100f, 100f, 1f)
        //frameRate(24f)

        bg(HSBColor(100, 20, 20))

        //noLoop()
    }

    override fun draw() {
        drawSquares(squares())
    }

    // Nullable var... there must be a way to do better
    private var squares: List<Rectangle>? = null

    private fun squares(): List<Rectangle> {
        val sq = squares ?: randomSquares()

        if (squares == null) {
            squares = sq
        }

        return sq
    }

    override fun keyPressed() {
        super.keyPressed()
        if (key == 's') {
            println("Saved screenshot")
            saveFrame("screenshots/line-######.png")
        } else if (key == 'r') {
            squares = randomSquares()
            redraw()
        }
    }
}

fun main() {
    PApplet.main("processing.HelloProcessing")
}
