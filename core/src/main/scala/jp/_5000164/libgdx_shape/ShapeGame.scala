package jp._5000164.libgdx_shape

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.{Game, Gdx, Screen}
import scala.math.sin

class ShapeGame extends Game {
  override def create() {
    setScreen(new TitleScreen(this))
  }
}

class TitleScreen(game: ShapeGame) extends Screen {
  lazy val camera = new OrthographicCamera()
  camera.setToOrtho(false, 800, 480)
  lazy val shapeRenderer = new ShapeRenderer()
  var colorSeedC = 0.0
  var colorSeedR = 0.0
  var colorSeedT = 0.0

  override def render(delta: Float) {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    camera.update()

    val colorCR = (sin(colorSeedC * 1) + 1) / 2
    val colorCG = (sin(colorSeedC * 2) + 1) / 2
    val colorCB = (sin(colorSeedC * 4) + 1) / 2

    val colorRR = (sin(colorSeedR * 1) + 1) / 2
    val colorRG = (sin(colorSeedR * 2) + 1) / 2
    val colorRB = (sin(colorSeedR * 4) + 1) / 2

    val colorTR = (sin(colorSeedT * 1) + 1) / 2
    val colorTG = (sin(colorSeedT * 2) + 1) / 2
    val colorTB = (sin(colorSeedT * 4) + 1) / 2

    shapeRenderer.setProjectionMatrix(camera.combined)
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
    shapeRenderer.setColor(colorCR.toFloat, colorCG.toFloat, colorCB.toFloat, 1)
    shapeRenderer.circle(340, 240, 20)
    shapeRenderer.setColor(colorRR.toFloat, colorRG.toFloat, colorRB.toFloat, 1)
    shapeRenderer.rect(380, 220, 40, 40)
    shapeRenderer.setColor(colorTR.toFloat, colorTG.toFloat, colorTB.toFloat, 1)
    shapeRenderer.triangle(440, 220, 480, 220, 460, 260)
    shapeRenderer.end()

    colorSeedC += 0.01
    colorSeedR += 0.02
    colorSeedT += 0.04
  }


  override def resize(width: Int, height: Int) {}

  override def show() {}

  override def hide() {}

  override def pause() {}

  override def resume() {}

  override def dispose() {}
}