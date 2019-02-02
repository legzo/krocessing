package processing

import processing.core.PVector
import processing.core.PApplet
import processing.core.PConstants
import processing.core.PGraphics

val WIDTH = 800
val HEIGHT = 800

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
        colorMode(PConstants.HSB, 360f, 100f,100f, 1f)
        // remove if you want animations etc.
        noLoop()
    }

    override fun draw() {
        background(0f,0f,100f)
    }

    override fun keyPressed() {
        super.keyPressed()
        if(key == 's') {
            // e.g. maybe save something
        } else if(key == 'r') {
            // e.g. maybe regenerate something and call redraw()
        }
    }
}

fun main(args: Array<String>) {
    PApplet.main("processing.HelloProcessing")
}