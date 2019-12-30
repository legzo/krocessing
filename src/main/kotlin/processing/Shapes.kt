package processing

import processing.core.PApplet
import kotlin.random.Random

/**
 * TO TEST :
 *  - brightness decreases for further squares
 *  - jitter increases for further squares
 */
val drawSquares: PApplet.(List<Rectangle>) -> Unit = { square ->
    clear()
    square.forEach { drawWithJitter(it, 1) }
}

val randomSquares: PApplet.() -> List<Rectangle> = {
    val margin = Random.nextInt(100, 200)
    val maxSquareSize = 200
    val nbOfSteps = 30
    val baseHue = Random.nextInt(0, 360)
    val thickness = Random.nextInt(4, 6).f
    val offsetJitter = 30

    strokeWeight(thickness)

    ((0 + margin)..(width - margin - maxSquareSize) step nbOfSteps)
        .flatMap { x ->
            ((0 + margin)..(height - margin - maxSquareSize) step nbOfSteps)
                .map { y ->

                    val size = Random.nextInt(20, maxSquareSize)
                    val localOffsetX = Random.nextInt(-offsetJitter, offsetJitter)
                    val localOffsetY = Random.nextInt(-offsetJitter, offsetJitter)

                    Rectangle(
                        x = x + localOffsetX,
                        y = y + localOffsetY,
                        width = size,
                        height = size,
                        color = HSBColor.random(baseHue, 50)
                    )
                }
        }.shuffled()

}


